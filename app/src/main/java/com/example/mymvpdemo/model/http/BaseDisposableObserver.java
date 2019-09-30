package com.example.mymvpdemo.model.http;

import com.example.mymvpdemo.R;
import com.example.mymvpdemo.base.BaseView;
import com.example.mymvpdemo.base.MyApplication;

import io.reactivex.observers.DisposableObserver;

/**
 * @ProjectName: MyMvpDemo
 * @Package: com.example.mymvpdemo.model.http
 * @ClassName: BaseDisposableObserver
 * @Description: 自定义DisposableObserver
 * @Author: walle
 * @CreateDate: 2019/8/19 20:52
 * @UpdateUser: 更新者：
 * @UpdateDate: 2019/8/19 20:52
 * @UpdateRemark: 更新说明：
 * @Version: 1.0
 */
public abstract class BaseDisposableObserver<T> extends DisposableObserver<T> {

    private BaseView baseView;

    public BaseDisposableObserver(BaseView baseView) {
        this.baseView = baseView;
    }

    @Override
    public void onError(Throwable e) {
        if (null == baseView) {
            return;
        }
        baseView.hideLoading();

        ApiException apiException = FactoryException.analysisExcetpion(e);
        baseView.showTipMsg(MyApplication.getInstance().getResources().getString(R.string.code_tip,apiException.getCode(),apiException.getMessage()));
        baseView.ShowError();
    }

    @Override
    public void onComplete() {
        if (null != baseView) {
            baseView.hideLoading();
        }
    }

}
