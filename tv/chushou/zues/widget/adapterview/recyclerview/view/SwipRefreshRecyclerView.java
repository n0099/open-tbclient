package tv.chushou.zues.widget.adapterview.recyclerview.view;

import android.content.Context;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SimpleItemAnimator;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import tv.chushou.zues.b;
import tv.chushou.zues.widget.adapterview.CustomSwipeRefreshLayout;
import tv.chushou.zues.widget.adapterview.b;
import tv.chushou.zues.widget.adapterview.c;
import tv.chushou.zues.widget.adapterview.f;
import tv.chushou.zues.widget.adapterview.loadmore.DefaultLoadMoreView;
import tv.chushou.zues.widget.adapterview.recyclerview.c.a;
/* loaded from: classes5.dex */
public class SwipRefreshRecyclerView extends CustomSwipeRefreshLayout implements c {
    private boolean emX;
    private RecyclerView.OnScrollListener mOnScrollListener;
    private float mTouchSlop;
    private RecyclerView.OnScrollListener nZA;
    private boolean nZB;
    private ExtendedRecyclerView nZs;
    private View nZt;
    private b nZu;
    private boolean nZv;
    private boolean nZw;
    private int nZx;
    private int nZy;
    private f nZz;
    private float startX;
    private float startY;

    public SwipRefreshRecyclerView(Context context) {
        this(context, null);
    }

    public SwipRefreshRecyclerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.emX = false;
        this.nZv = true;
        this.nZw = true;
        this.nZx = 9;
        this.nZy = 20;
        this.mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: tv.chushou.zues.widget.adapterview.recyclerview.view.SwipRefreshRecyclerView.3
            private int nZD = -1;

            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i, int i2) {
                boolean z = false;
                super.onScrolled(recyclerView, i, i2);
                if (SwipRefreshRecyclerView.this.nZA != null) {
                    SwipRefreshRecyclerView.this.nZA.onScrolled(recyclerView, i, i2);
                }
                if (SwipRefreshRecyclerView.this.nZs.getLayoutManager() != null) {
                    this.nZD = a.e(SwipRefreshRecyclerView.this.nZs.getLayoutManager());
                    if (Build.VERSION.SDK_INT < 21) {
                        int top2 = (recyclerView == null || recyclerView.getChildCount() == 0) ? 0 : recyclerView.getChildAt(0).getTop();
                        SwipRefreshRecyclerView swipRefreshRecyclerView = SwipRefreshRecyclerView.this;
                        if (top2 >= recyclerView.getPaddingTop() && SwipRefreshRecyclerView.this.nZw) {
                            z = true;
                        }
                        swipRefreshRecyclerView.setEnabled(z);
                    }
                }
            }

            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                RecyclerView.Adapter adapter;
                super.onScrollStateChanged(recyclerView, i);
                if (i == 0 || i == 1) {
                    tv.chushou.zues.widget.fresco.a.resume();
                } else if (i == 2) {
                    tv.chushou.zues.widget.fresco.a.pause();
                }
                if (SwipRefreshRecyclerView.this.nZA != null) {
                    SwipRefreshRecyclerView.this.nZA.onScrollStateChanged(recyclerView, i);
                }
                RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
                if (layoutManager != null && (adapter = recyclerView.getAdapter()) != null) {
                    int childCount = layoutManager.getChildCount();
                    int itemCount = layoutManager.getItemCount();
                    if (childCount > 0 && i == 0 && this.nZD >= itemCount - 1 && SwipRefreshRecyclerView.this.nZB && !SwipRefreshRecyclerView.this.emX && SwipRefreshRecyclerView.this.nZv && SwipRefreshRecyclerView.this.nZu != null && adapter.getItemCount() > SwipRefreshRecyclerView.this.nZx) {
                        SwipRefreshRecyclerView.this.nZu.bck();
                        SwipRefreshRecyclerView.this.emX = true;
                    }
                }
            }
        };
        this.nZs = new ExtendedRecyclerView(getContext(), attributeSet);
        this.nZs.setId(b.e.zues_swiperefresh_recyclerview);
        RecyclerView.ItemAnimator itemAnimator = this.nZs.getItemAnimator();
        if (itemAnimator instanceof SimpleItemAnimator) {
            ((SimpleItemAnimator) itemAnimator).setSupportsChangeAnimations(false);
        }
        this.nZs.setHasFixedSize(true);
        addView(this.nZs, new ViewGroup.LayoutParams(-1, -1));
        setColorSchemeResources(17170452, 17170459, 17170452, 17170459);
        this.nZs.addOnScrollListener(this.mOnScrollListener);
        super.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() { // from class: tv.chushou.zues.widget.adapterview.recyclerview.view.SwipRefreshRecyclerView.1
            @Override // android.support.v4.widget.SwipeRefreshLayout.OnRefreshListener
            public void onRefresh() {
                if (SwipRefreshRecyclerView.this.nZz != null) {
                    SwipRefreshRecyclerView.this.nZv = true;
                    tv.chushou.zues.widget.adapterview.recyclerview.a.b adapter = SwipRefreshRecyclerView.this.getAdapter();
                    if (adapter != null) {
                        adapter.dRa();
                    }
                    SwipRefreshRecyclerView.this.nZz.onRefresh();
                }
            }
        });
        setEnabled(this.nZw);
        if (Build.VERSION.SDK_INT < 21) {
            setCanChildScrollUpCallback(new CustomSwipeRefreshLayout.a() { // from class: tv.chushou.zues.widget.adapterview.recyclerview.view.SwipRefreshRecyclerView.2
                @Override // tv.chushou.zues.widget.adapterview.CustomSwipeRefreshLayout.a
                public boolean dQY() {
                    return SwipRefreshRecyclerView.this.nZs != null && SwipRefreshRecyclerView.this.nZs.getScrollY() > 0;
                }
            });
        }
        this.mTouchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
    }

    public void setOnePageSize(int i) {
        this.nZy = i;
    }

    public ExtendedRecyclerView getInnerRecyclerView() {
        return this.nZs;
    }

    public void setHasFixedSize(boolean z) {
        this.nZs.setHasFixedSize(z);
    }

    public void setUpDefault() {
        this.nZs.setLayoutManager(new LinearLayoutManager(getContext()));
        this.nZt = new DefaultLoadMoreView(getContext());
    }

    public void setAdapter(RecyclerView.Adapter adapter) {
        this.nZs.setAdapter(adapter);
        if (this.nZu != null) {
            this.nZs.setLoadMoreProvider(this);
        }
    }

    public tv.chushou.zues.widget.adapterview.recyclerview.a.b getAdapter() {
        return this.nZs.getAdapter();
    }

    public boolean Oy(int i) {
        return this.nZs.Oy(i);
    }

    public int getHeaderViewCount() {
        return this.nZs.getHeaderViewCount();
    }

    public boolean Oz(int i) {
        return this.nZs.Oz(i);
    }

    public int getFooterViewCount() {
        return this.nZs.getFooterViewCount();
    }

    public void setEmptyView(@NonNull View view) {
        this.nZs.setEmptyView(view);
    }

    @Nullable
    public View getEmptyView() {
        return this.nZs.getEmptyView();
    }

    public void setLoadMoreListener(tv.chushou.zues.widget.adapterview.b bVar) {
        this.nZu = bVar;
        if (getAdapter() != null) {
            this.nZs.setLoadMoreProvider(this);
        }
    }

    public void setLoadMoreFooter(@NonNull View view) {
        this.nZt = view;
    }

    public void dRd() {
        this.emX = false;
    }

    @Override // tv.chushou.zues.widget.adapterview.c
    public void Ot(int i) {
        if (this.nZv && this.nZs.getAdapter() != null) {
            if (this.nZt == null) {
                this.nZt = new DefaultLoadMoreView(getContext());
            }
            if (i >= this.nZy) {
                if (!this.nZs.dG(this.nZt)) {
                    this.nZs.addFooterView(this.nZt, 0);
                }
            } else if (this.nZs.dG(this.nZt)) {
                this.nZs.dE(this.nZt);
            }
            this.emX = false;
        }
    }

    @Override // tv.chushou.zues.widget.adapterview.c
    public boolean dQZ() {
        if (this.nZt == null) {
            this.nZt = new DefaultLoadMoreView(getContext());
        }
        return this.nZs.dG(this.nZt);
    }

    public void setHasMoreItems(boolean z) {
        this.nZv = z;
        if (!z && this.nZs.dG(this.nZt)) {
            this.nZs.dE(this.nZt);
        }
    }

    public void setPullToRefreshEnabled(boolean z) {
        this.nZw = z;
        setEnabled(this.nZw);
    }

    public void completeRefresh() {
        setRefreshing(false);
    }

    public void setPullToRefreshListener(f fVar) {
        this.nZz = fVar;
    }

    @Override // android.support.v4.widget.SwipeRefreshLayout
    @Deprecated
    public void setOnRefreshListener(@Nullable SwipeRefreshLayout.OnRefreshListener onRefreshListener) {
        super.setOnRefreshListener(onRefreshListener);
    }

    public void setLayoutManager(RecyclerView.LayoutManager layoutManager) {
        this.nZs.setLayoutManager(layoutManager);
    }

    public RecyclerView.LayoutManager getLayoutManager() {
        return this.nZs.getLayoutManager();
    }

    public void addItemDecoration(RecyclerView.ItemDecoration itemDecoration) {
        this.nZs.addItemDecoration(itemDecoration);
    }

    public void scrollToPosition(int i) {
        this.nZs.scrollToPosition(i);
    }

    public void setItemDecration(RecyclerView.ItemDecoration itemDecoration) {
        this.nZs.addItemDecoration(itemDecoration);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                this.nZB = false;
                this.startY = motionEvent.getY();
                this.startX = motionEvent.getX();
                break;
            case 2:
                float y = motionEvent.getY();
                float abs = Math.abs(y - this.startY);
                float f = y - this.startY;
                if (abs > this.mTouchSlop && f < 0.0f) {
                    this.nZB = true;
                    break;
                } else {
                    this.nZB = false;
                    break;
                }
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public void setSmallPageSize(int i) {
        this.nZx = i;
    }
}
