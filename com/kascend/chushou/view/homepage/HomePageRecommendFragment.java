package com.kascend.chushou.view.homepage;

import android.net.http.Headers;
import android.os.Bundle;
import android.support.annotation.Keep;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.android.imsdk.db.TableDefine;
import com.kascend.chushou.a;
import com.kascend.chushou.constants.ListItem;
import com.kascend.chushou.constants.PannelItem;
import com.kascend.chushou.view.a.a.c;
import com.kascend.chushou.view.base.b;
import com.kascend.chushou.widget.EmptyLoadingView;
import com.tencent.connect.common.Constants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import tv.chushou.zues.utils.e;
import tv.chushou.zues.utils.g;
import tv.chushou.zues.utils.h;
import tv.chushou.zues.widget.adapterview.recyclerview.view.SwipRefreshRecyclerView;
@Keep
/* loaded from: classes5.dex */
public class HomePageRecommendFragment extends b implements View.OnClickListener {
    public static final int ENTERTAINMENT_RECOMMEND = 1;
    public static final int RECOMMEND = 0;
    private com.kascend.chushou.view.a.a.b mAdapter;
    private EmptyLoadingView mEmptyView;
    private GridLayoutManager mLayoutManager;
    RecyclerView.OnScrollListener mOnScrollListener;
    private a mPresenter;
    private SwipRefreshRecyclerView mRecyclerView;
    private boolean mLoadedSuc = true;
    private long mStartTime = 0;

    public static HomePageRecommendFragment newInstance(String str, ArrayList<PannelItem> arrayList, int i, RecyclerView.OnScrollListener onScrollListener) {
        Bundle bundle = new Bundle();
        HomePageRecommendFragment homePageRecommendFragment = new HomePageRecommendFragment();
        if (!h.isEmpty(arrayList)) {
            bundle.putSerializable("pannellist", arrayList);
            bundle.putString("breakpoint", str);
        }
        bundle.putInt("recommendType", i);
        homePageRecommendFragment.setArguments(bundle);
        homePageRecommendFragment.mOnScrollListener = onScrollListener;
        return homePageRecommendFragment;
    }

    @Override // com.kascend.chushou.view.base.b, android.support.v4.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        String str;
        int i;
        e.d(this.TAG, "onCreate()<----");
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        ArrayList arrayList = null;
        if (arguments == null) {
            str = "";
            i = 0;
        } else {
            str = arguments.getString("breakpoint");
            arrayList = (ArrayList) arguments.getSerializable("pannellist");
            i = arguments.getInt("recommendType", 0);
        }
        if (this.mPresenter == null) {
            this.mPresenter = new a(str, arrayList, i);
        }
    }

    public void click(String str, String str2) {
    }

    @Override // com.kascend.chushou.view.base.b
    protected View initView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        View inflate = layoutInflater.inflate(a.h.fragment_home_live, viewGroup, false);
        this.mRecyclerView = (SwipRefreshRecyclerView) inflate.findViewById(a.f.home_live_recycler_view);
        this.mRecyclerView.getInnerRecyclerView().setClipToPadding(false);
        this.mRecyclerView.getInnerRecyclerView().setClipChildren(false);
        this.mRecyclerView.getInnerRecyclerView().setPadding(0, 0, 0, 0);
        this.mLayoutManager = new GridLayoutManager(this.mContext, 4);
        this.mLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() { // from class: com.kascend.chushou.view.homepage.HomePageRecommendFragment.1
            @Override // android.support.v7.widget.GridLayoutManager.SpanSizeLookup
            public int getSpanSize(int i) {
                if (HomePageRecommendFragment.this.mRecyclerView.Oy(i) || HomePageRecommendFragment.this.mRecyclerView.Oz(i)) {
                    return 4;
                }
                return com.kascend.chushou.view.a.a.b.a(HomePageRecommendFragment.this.mAdapter.getItemViewType(i - HomePageRecommendFragment.this.mRecyclerView.getHeaderViewCount()), 4);
            }
        });
        this.mRecyclerView.setLayoutManager(this.mLayoutManager);
        this.mRecyclerView.getInnerRecyclerView().addItemDecoration(new c(this.mLayoutManager, tv.chushou.zues.utils.a.dip2px(this.mContext, 4.0f)));
        String str = "68";
        if (this.mPresenter.e == 1) {
            str = "72";
        }
        this.mAdapter = new com.kascend.chushou.view.a.a.b(str, new com.kascend.chushou.view.a.a<PannelItem>() { // from class: com.kascend.chushou.view.homepage.HomePageRecommendFragment.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.kascend.chushou.view.a.a
            /* renamed from: a */
            public void b(View view, PannelItem pannelItem) {
                if (pannelItem.mMoreNav != null && !h.isEmpty(pannelItem.mMoreNav.mTargetKey)) {
                    String str2 = "";
                    if (HomePageRecommendFragment.this.mPresenter.e != 0) {
                        if (HomePageRecommendFragment.this.mPresenter.e == 1) {
                            str2 = "72";
                        }
                    } else {
                        str2 = "68";
                    }
                    com.kascend.chushou.d.e.a(HomePageRecommendFragment.this.mContext, pannelItem.mMoreNav, com.kascend.chushou.d.e.N("_fromView", str2, "_fromPos", "50", "_sc", pannelItem.mMoreNav.mSC));
                }
            }
        }, new com.kascend.chushou.view.a.a<ListItem>() { // from class: com.kascend.chushou.view.homepage.HomePageRecommendFragment.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.kascend.chushou.view.a.a
            /* renamed from: a */
            public void b(View view, ListItem listItem) {
                int parseInt;
                view.getId();
                if ("1".equals(listItem.mType)) {
                    HomePageRecommendFragment.this.click(listItem.mTargetKey, listItem.mLiveType);
                    return;
                }
                String str2 = "";
                if (HomePageRecommendFragment.this.mPresenter.e != 0) {
                    if (HomePageRecommendFragment.this.mPresenter.e == 1) {
                        str2 = "72";
                    }
                } else {
                    str2 = "68";
                }
                String a = com.kascend.chushou.toolkit.a.b.a(listItem.mDisplayStyle);
                Object[] objArr = new Object[6];
                objArr[0] = "_fromView";
                objArr[1] = str2;
                objArr[2] = "_fromPos";
                objArr[3] = a;
                objArr[4] = "_sc";
                objArr[5] = listItem != null ? listItem.mSC : "";
                com.kascend.chushou.d.e.a(HomePageRecommendFragment.this.mContext, listItem, com.kascend.chushou.d.e.N(objArr));
                if (listItem.mDisplayStyle.equals(Constants.VIA_REPORT_TYPE_START_WAP) && view != null && view.getTag() != null && (parseInt = h.parseInt(view.getTag().toString())) > 0) {
                    com.kascend.chushou.toolkit.a.c.a(HomePageRecommendFragment.this.mContext, "首页顶部图标_num", parseInt + "", new Object[0]);
                    HashMap hashMap = new HashMap(5);
                    hashMap.put("type", Constants.VIA_REPORT_TYPE_START_WAP);
                    hashMap.put("_targetKey", listItem.mTargetKey);
                    hashMap.put("name", listItem.mName);
                    hashMap.put("url", listItem.mUrl);
                    hashMap.put("_clickPos", Integer.valueOf(parseInt));
                    com.kascend.chushou.toolkit.a.a.b(hashMap);
                }
            }
        }, false);
        this.mRecyclerView.setAdapter(this.mAdapter);
        this.mRecyclerView.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() { // from class: com.kascend.chushou.view.homepage.HomePageRecommendFragment.4
            @Override // android.support.v4.widget.SwipeRefreshLayout.OnRefreshListener
            public void onRefresh() {
                HomePageRecommendFragment.this.refresh(false);
            }
        });
        this.mEmptyView = (EmptyLoadingView) inflate.findViewById(a.f.empty_view);
        this.mEmptyView.setReloadListener(new View.OnClickListener() { // from class: com.kascend.chushou.view.homepage.HomePageRecommendFragment.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                HomePageRecommendFragment.this.refresh(false);
            }
        });
        this.mPresenter.a((a) this);
        tv.chushou.zues.a.a.register(this);
        return inflate;
    }

    @Override // com.kascend.chushou.view.base.b
    protected void initData() {
        if (!h.isEmpty(this.mPresenter.d)) {
            updateUI(this.mPresenter.d);
        } else {
            this.mPresenter.c();
        }
    }

    @Override // com.kascend.chushou.view.base.b, android.support.v4.app.Fragment
    public void onDestroyView() {
        tv.chushou.zues.a.a.cr(this);
        this.mPresenter.a();
        super.onDestroyView();
    }

    @Override // android.support.v4.app.Fragment
    public void setUserVisibleHint(boolean z) {
        super.setUserVisibleHint(z);
        if (z && this.mPresenter != null && this.mPresenter.b()) {
            requestData(true);
        } else if (!z && this.mPresenter != null && this.mPresenter.b()) {
            this.mStartTime = System.currentTimeMillis();
        }
    }

    @Override // com.kascend.chushou.view.base.b
    public void showStatus(int i) {
        switch (i) {
            case 1:
                if (!this.mLoadedSuc) {
                    this.mEmptyView.Ng(1);
                    this.mRecyclerView.setVisibility(8);
                    return;
                }
                return;
            case 2:
                this.mLoadedSuc = true;
                this.mEmptyView.Ng(2);
                this.mRecyclerView.completeRefresh();
                this.mRecyclerView.setVisibility(0);
                return;
            case 3:
            case 4:
            case 6:
                this.mLoadedSuc = false;
                this.mRecyclerView.completeRefresh();
                this.mEmptyView.Ng(i);
                this.mRecyclerView.setVisibility(8);
                return;
            case 5:
            default:
                return;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    public void updateUI(List<PannelItem> list) {
        if (this.mAdapter != null) {
            this.mAdapter.a(list);
            this.mAdapter.notifyDataSetChanged();
        }
    }

    public void updateRangeUI(ArrayList<ListItem> arrayList, int i, int i2) {
        if (this.mAdapter != null) {
            this.mAdapter.a(i, i2, arrayList);
        }
    }

    public void requestData(boolean z) {
        if (this.mPresenter != null) {
            if (!z) {
                refresh(true);
                return;
            }
            long currentTimeMillis = System.currentTimeMillis();
            if (this.mStartTime != 0 && currentTimeMillis - this.mStartTime > 300000) {
                refresh(true);
            }
        }
    }

    public void refresh(boolean z) {
        e.i(this.TAG, Headers.REFRESH);
        if (z) {
            if (this.mRecyclerView != null && !this.mRecyclerView.isRefreshing()) {
                this.mRecyclerView.scrollToPosition(0);
                this.mRecyclerView.setRefreshing(true);
                this.mPresenter.c();
                return;
            }
            return;
        }
        this.mPresenter.c();
    }

    public void subscribeResult(boolean z, String str, ListItem listItem) {
        if (z) {
            int bG = this.mAdapter.bG(listItem);
            if (bG != -1) {
                this.mAdapter.notifyItemChanged(bG, TableDefine.PaSubscribeColumns.COLUMN_SUBSCRIBE);
                return;
            }
            return;
        }
        if (h.isEmpty(str)) {
            str = tv.chushou.widget.a.c.getString(a.i.subscribe_failed);
        }
        g.u(str);
    }

    public int getRecommend() {
        if (this.mPresenter != null) {
            return this.mPresenter.e;
        }
        return 0;
    }
}
