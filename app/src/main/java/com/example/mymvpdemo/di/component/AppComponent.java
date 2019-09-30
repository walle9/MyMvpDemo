package com.example.mymvpdemo.di.component;

import com.example.mymvpdemo.di.module.AppModule;
import com.example.mymvpdemo.di.module.HttpModule;
import com.example.mymvpdemo.manager.AppManager;
import com.example.mymvpdemo.model.DataHelper;

import javax.inject.Singleton;

import dagger.Component;

/**
 * @ProjectName: MyMvpDemo
 * @Package: com.example.mymvpdemo.di.component
 * @ClassName: AppComponent
 * @Description: App 注射器
 * @Author: walle
 * @CreateDate: 2019/8/19 15:24
 * @UpdateUser: 更新者：
 * @UpdateDate: 2019/8/19 15:24
 * @UpdateRemark: 更新说明：
 * @Version: 1.0
 */

@Singleton
@Component(modules = {AppModule.class, HttpModule.class})
public interface AppComponent {
    /**
     *获取DataHelper
     * @return  DataHelper  在AppModule中,由provideDataHelper
     */
    DataHelper getDataHelper();
    AppManager getAppManager();

}
