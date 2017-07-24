package com.fire.reader.ui.activity;

import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.fire.reader.R;
import com.fire.reader.mvp.presenter.ListViewPresenter;
import com.fire.reader.mvp.view.IListView;

import java.util.List;

import butterknife.BindView;

public class MainActivity extends BaseActivity<IListView, ListViewPresenter>
        implements IListView, AdapterView.OnItemClickListener {


    @BindView(R.id.list_view)
    ListView mListView;
    @BindView(R.id.progress_bar)
    ProgressBar mProgressBar;
    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @Override
    public ListViewPresenter initPresenter() {
        return new ListViewPresenter(this);
    }

    @Override
    public int getLayout() {
        return R.layout.activity_main;
    }

    @Override
    public void initView() {
        mListView.setOnItemClickListener(this);
        setToolBar(toolbar,false);
    }

    @Override
    protected void onResume() {
        super.onResume();
        presenter.updateList();
    }

    @Override
    public void setListItem(List<String> data) {
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, data);
        mListView.setAdapter(adapter);
    }

    @Override
    public void showMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showLoading() {
        if (mProgressBar.getVisibility() == View.GONE) {
            mProgressBar.setVisibility(View.VISIBLE);
        }

    }

    @Override
    public void hideLoading() {
        if (mProgressBar.getVisibility() != View.GONE) {
            mProgressBar.setVisibility(View.GONE);
        }
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        presenter.onItemClick(position);
    }

}
