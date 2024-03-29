package com.example.mymvpdemo.presenter;

import com.example.mymvpdemo.base.BaseMvpFragment;
import com.example.mymvpdemo.base.BaseMvpPresenter;
import com.example.mymvpdemo.contract.LookerFragmentContract;
import com.example.mymvpdemo.model.bean.LookerBean;
import com.example.mymvpdemo.model.http.BaseDisposableObserver;
import com.example.mymvpdemo.model.http.HttpNoResult;
import com.example.mymvpdemo.model.http.MyRxUtils;
import com.example.mymvpdemo.model.http.MySubscriber;
import com.example.mymvpdemo.utils.ToastUtils;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.schedulers.Schedulers;

/**
 * @ProjectName: MyMvpDemo
 * @Package: com.example.mymvpdemo.presenter
 * @ClassName: LookerFragmentPresenter
 * @Description: 获取美女图片,P层
 * @Author: walle
 * @CreateDate: 2019/9/4 17:40
 * @UpdateUser: 更新者：
 * @UpdateDate: 2019/9/4 17:40
 * @UpdateRemark: 更新说明：
 * @Version: 1.0
 */
public class LookerFragmentPresenter extends BaseMvpPresenter<LookerFragmentContract.IView> implements LookerFragmentContract.Presenter {

    private int currentPage = 1;

    @Inject
    public LookerFragmentPresenter() {
    }

    @Override
    public void loadData(boolean isRefresh, String count) {
        if (isRefresh) {
            currentPage= 1;
        }

        /*addSubscribe(dataHelper.LookerImgs()
                    .compose(MyRxUtils.ToMainWithHandResultOfObservableTransformer(Schedulers.io()))
                    .subscribeWith(new BaseDisposableObserver<List<LookerBean>>(baseView) {
                        @Override
                        public void onNext(List<LookerBean> lookerBeans) {
                            baseView.showSuccessful(lookerBeans);
                        }
                    })
        );*/
    }
}
