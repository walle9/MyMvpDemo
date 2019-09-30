package com.example.mymvpdemo.model.http;

import com.example.mymvpdemo.R;
import com.example.mymvpdemo.base.BaseView;
import com.example.mymvpdemo.base.MyApplication;

import io.reactivex.subscribers.ResourceSubscriber;

/**
 * @ProjectName: MyMvpDemo
 * @Package: com.example.mymvpdemo.model.http
 * @ClassName: MySubscriber
 * @Description: 自定义Subscriber
 * @Author: walle
 * @CreateDate: 2019/8/19 20:49
 * @UpdateUser: 更新者：
 * @UpdateDate: 2019/8/19 20:49
 * @UpdateRemark: 更新说明：
 * @Version: 1.0
 */
public abstract class MySubscriber<T> extends ResourceSubscriber<T> {
    private BaseView baseView;
    private boolean showLoading;

    public MySubscriber(BaseView baseView) {
        this.baseView = baseView;
    }

    public MySubscriber(BaseView baseView, boolean showLoading) {
        this.baseView = baseView;
        this.showLoading = showLoading;
    }

    @Override
    protected void onStart() {
        super.onStart();
        if (null != baseView && showLoading) {
            baseView.showLoading();
        }
    }

    @Override
    public void onError(Throwable t) {
        if (null == baseView) {
            return;
        }
        baseView.hideLoading();
        ApiException apiException = FactoryException.analysisExcetpion(t);
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
