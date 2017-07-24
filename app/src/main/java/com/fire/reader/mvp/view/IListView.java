package com.fire.reader.mvp.view;

import java.util.List;

/**
 * Created by Administrator on 2017/7/17.
 */

public interface IListView extends BaseView {


    void setListItem(List<String> data);

    void showMessage(String message);
}
