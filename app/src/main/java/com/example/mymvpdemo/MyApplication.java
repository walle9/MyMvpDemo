package com.example.mymvpdemo;

import android.app.Application;

/**
 * @ProjectName: MyMvpDemo
 * @Package: com.example.mymvpdemo
 * @ClassName: MyApplication
 * @Description: java类作用描述
 * @Author: walle
 * @CreateDate: 2019/8/15 22:36
 * @UpdateUser: 更新者：
 * @UpdateDate: 2019/8/15 22:36
 * @UpdateRemark: 更新说明：
 * @Version: 1.0
 */
public class MyApplication extends Application {
    private static MyApplication instance;


    public MyApplication getInstance() {
        return instance;
    }

    private void setInstance(MyApplication instance) {
        MyApplication.instance = instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        setInstance(this);
    }
}
