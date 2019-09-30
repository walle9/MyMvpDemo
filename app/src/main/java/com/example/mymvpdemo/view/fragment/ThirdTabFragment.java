package com.example.mymvpdemo.view.fragment;

import android.lib.widget.snackbar.Snackbar;
import android.os.Bundle;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.example.mymvpdemo.R;
import com.example.mymvpdemo.base.BaseMvpFragment;
import com.example.mymvpdemo.base.MyApplication;
import com.example.mymvpdemo.contract.ThirdTabFragmentContract;
import com.example.mymvpdemo.model.bean.LookerBean;
import com.example.mymvpdemo.presenter.ThirdTabFragmentPresenter;
import com.example.mymvpdemo.utils.ToastUtils;
import com.example.mymvpdemo.view.adapter.LookerAdapter;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadMoreListener;

import java.util.List;

import me.yokeyword.fragmentation.SupportFragment;

/**
 * @ProjectName: MyMvpDemo
 * @Package: com.example.mymvpdemo.view.fragment
 * @ClassName: FirstTabFragment
 * @Description: java类作用描述
 * @Author: walle
 * @CreateDate: 2019/9/3 10:15
 * @UpdateUser: 更新者：
 * @UpdateDate: 2019/9/3 10:15
 * @UpdateRemark: 更新说明：
 * @Version: 1.0
 */
public class ThirdTabFragment extends BaseMvpFragment<ThirdTabFragmentPresenter> implements ThirdTabFragmentContract.IView {

    private SmartRefreshLayout mRefreshLayout;
    private RecyclerView mRvImageList;
    private LookerAdapter mAdapter;

    public static SupportFragment newInstance() {
        Bundle args = new Bundle();
        ThirdTabFragment fragment = new ThirdTabFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void initInject() {
        getActivityComponent().inject(this);
    }

    @Override
    protected int layoutRes() {
        return R.layout.third_fragment;
    }



    @Override
    protected void initData() {
        mRefreshLayout.autoRefresh();
    }

    @Override
    protected void initView() {
        super.initView();
        mRefreshLayout = findViewById(R.id.refreshLayout);
        mRvImageList = findViewById(R.id.rv_image_list);

        mRvImageList.setLayoutManager(new LinearLayoutManager(_mActivity));
        mAdapter = new LookerAdapter(_mActivity);
        mRvImageList.setAdapter(mAdapter);

        mRefreshLayout.setOnRefreshListener(refreshLayout -> basePresenter.getGirlList(10,true));
        mRefreshLayout.setOnLoadMoreListener(refreshLayout -> basePresenter.getGirlList(10,false));

    }

    @Override
    public void showSuccessful(List<LookerBean> lookerBeans,boolean isRefresh) {
        mAdapter.addDate(lookerBeans,isRefresh);
        if (isRefresh) {
            mRefreshLayout.finishRefresh();
        } else {
            mRefreshLayout.finishLoadMore();
        }
    }

    @Override
    public void showHasNoData(boolean isRefresh) {
        if (isRefresh) {
            // TODO: 2019/9/7 显示什么数据都没有
        } else {
            mRefreshLayout.finishLoadMoreWithNoMoreData();
            Snackbar.with(_mActivity).setText("没有更多数据了").show();
        }
    }

    @Override
    public void ShowError() {
        mRefreshLayout.finishRefresh();
        mRefreshLayout.finishLoadMore();
    }
}
