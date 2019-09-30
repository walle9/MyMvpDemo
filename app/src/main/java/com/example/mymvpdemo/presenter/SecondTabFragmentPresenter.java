package com.example.mymvpdemo.presenter;

import com.example.mymvpdemo.base.BaseMvpPresenter;
import com.example.mymvpdemo.contract.SecondTabFragmentContract;
import com.example.mymvpdemo.model.bean.WeatherBean;
import com.example.mymvpdemo.model.http.BaseDisposableObserver;
import com.example.mymvpdemo.model.http.MyRxUtils;

import javax.inject.Inject;

import io.reactivex.schedulers.Schedulers;

/**
 * @ProjectName: MyMvpDemo
 * @Package: com.example.mymvpdemo.presenter
 * @ClassName: WeatherActivityPresenter
 * @Description: java类作用描述
 * @Author: walle
 * @CreateDate: 2019/9/2 20:52
 * @UpdateUser: 更新者：
 * @UpdateDate: 2019/9/2 20:52
 * @UpdateRemark: 更新说明：
 * @Version: 1.0
 */
public class SecondTabFragmentPresenter extends BaseMvpPresenter<SecondTabFragmentContract.IView> implements SecondTabFragmentContract.Presenter {

    @Inject
    SecondTabFragmentPresenter() {
    }


    @Override
    public void getGirlList(String count, String page) {

    }
}
