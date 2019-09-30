package com.example.mymvpdemo.presenter;

import com.example.mymvpdemo.base.BaseMvpPresenter;
import com.example.mymvpdemo.contract.WeatherActivityContract;
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
public class WeatherActivityPresenter extends BaseMvpPresenter<WeatherActivityContract.IView> implements WeatherActivityContract.Presenter {

    @Inject
    WeatherActivityPresenter() {
    }

    @Override
    public void loadData(String city) {
        /*addSubscribe(dataHelper.weather(city)
                    .compose(MyRxUtils.ToMainWithHandResultOfObservableTransformer(Schedulers.io()))
                    .doOnSubscribe(disposable -> baseView.showLoading())
                    .subscribeWith(new BaseDisposableObserver<WeatherBean>(baseView) {
                        @Override
                        public void onNext(WeatherBean weatherBean) {
                            baseView.showSuccessful(weatherBean.toString());
                        }
                    })
        );*/
    }
}
