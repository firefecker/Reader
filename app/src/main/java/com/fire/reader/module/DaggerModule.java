package com.fire.reader.module;

import com.fire.reader.entity.Cloth;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Administrator on 2017/7/25.
 *
 * 注解是dagger2中的关键
 *
 * 现在的需求是DaggerActivity中需要使用到Cloth对象,
 * 所以我们要为DaggerActivity书写一个Module类用来提供Cloth对象,
 * 相当于创建了一个提供商
 *
 * 编写Module类时要在该类上声明@Module以表明该类是Module类,这样Dagger2才能识别
 *
 * @Provides 它的作用是声明Module类中哪些方法是用来提供依赖对象的,
 * 当Component类需要依赖对象时,他就会根据返回值的类型来在
 * 有@Provides注解的方法中选择调用哪个方法,在一个方法上声明@Provides注解,
 * 就相当于创建了一条生产线,这条生产线的产物就是方法的返回值类型,
 * 有了这条生产线,供应商就能提供这种类型的商品了,当商店老板发现有
 * 人需要这种类型的商品时,供应商就可以提供给他了
 */

@Module
public class DaggerModule {

    @Provides
    public Cloth getCloth() {
        Cloth cloth = new Cloth();
        cloth.setColor("红色");
        return cloth;
    }
}
