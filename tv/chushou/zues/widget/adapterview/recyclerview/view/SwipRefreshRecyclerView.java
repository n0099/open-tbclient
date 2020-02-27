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
    private boolean ems;
    private RecyclerView.OnScrollListener mOnScrollListener;
    private float mTouchSlop;
    private RecyclerView.OnScrollListener nXA;
    private boolean nXB;
    private ExtendedRecyclerView nXs;
    private View nXt;
    private b nXu;
    private boolean nXv;
    private boolean nXw;
    private int nXx;
    private int nXy;
    private f nXz;
    private float startX;
    private float startY;

    public SwipRefreshRecyclerView(Context context) {
        this(context, null);
    }

    public SwipRefreshRecyclerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ems = false;
        this.nXv = true;
        this.nXw = true;
        this.nXx = 9;
        this.nXy = 20;
        this.mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: tv.chushou.zues.widget.adapterview.recyclerview.view.SwipRefreshRecyclerView.3
            private int nXD = -1;

            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i, int i2) {
                boolean z = false;
                super.onScrolled(recyclerView, i, i2);
                if (SwipRefreshRecyclerView.this.nXA != null) {
                    SwipRefreshRecyclerView.this.nXA.onScrolled(recyclerView, i, i2);
                }
                if (SwipRefreshRecyclerView.this.nXs.getLayoutManager() != null) {
                    this.nXD = a.e(SwipRefreshRecyclerView.this.nXs.getLayoutManager());
                    if (Build.VERSION.SDK_INT < 21) {
                        int top2 = (recyclerView == null || recyclerView.getChildCount() == 0) ? 0 : recyclerView.getChildAt(0).getTop();
                        SwipRefreshRecyclerView swipRefreshRecyclerView = SwipRefreshRecyclerView.this;
                        if (top2 >= recyclerView.getPaddingTop() && SwipRefreshRecyclerView.this.nXw) {
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
                if (SwipRefreshRecyclerView.this.nXA != null) {
                    SwipRefreshRecyclerView.this.nXA.onScrollStateChanged(recyclerView, i);
                }
                RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
                if (layoutManager != null && (adapter = recyclerView.getAdapter()) != null) {
                    int childCount = layoutManager.getChildCount();
                    int itemCount = layoutManager.getItemCount();
                    if (childCount > 0 && i == 0 && this.nXD >= itemCount - 1 && SwipRefreshRecyclerView.this.nXB && !SwipRefreshRecyclerView.this.ems && SwipRefreshRecyclerView.this.nXv && SwipRefreshRecyclerView.this.nXu != null && adapter.getItemCount() > SwipRefreshRecyclerView.this.nXx) {
                        SwipRefreshRecyclerView.this.nXu.bcd();
                        SwipRefreshRecyclerView.this.ems = true;
                    }
                }
            }
        };
        this.nXs = new ExtendedRecyclerView(getContext(), attributeSet);
        this.nXs.setId(b.e.zues_swiperefresh_recyclerview);
        RecyclerView.ItemAnimator itemAnimator = this.nXs.getItemAnimator();
        if (itemAnimator instanceof SimpleItemAnimator) {
            ((SimpleItemAnimator) itemAnimator).setSupportsChangeAnimations(false);
        }
        this.nXs.setHasFixedSize(true);
        addView(this.nXs, new ViewGroup.LayoutParams(-1, -1));
        setColorSchemeResources(17170452, 17170459, 17170452, 17170459);
        this.nXs.addOnScrollListener(this.mOnScrollListener);
        super.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() { // from class: tv.chushou.zues.widget.adapterview.recyclerview.view.SwipRefreshRecyclerView.1
            @Override // android.support.v4.widget.SwipeRefreshLayout.OnRefreshListener
            public void onRefresh() {
                if (SwipRefreshRecyclerView.this.nXz != null) {
                    SwipRefreshRecyclerView.this.nXv = true;
                    tv.chushou.zues.widget.adapterview.recyclerview.a.b adapter = SwipRefreshRecyclerView.this.getAdapter();
                    if (adapter != null) {
                        adapter.dQx();
                    }
                    SwipRefreshRecyclerView.this.nXz.onRefresh();
                }
            }
        });
        setEnabled(this.nXw);
        if (Build.VERSION.SDK_INT < 21) {
            setCanChildScrollUpCallback(new CustomSwipeRefreshLayout.a() { // from class: tv.chushou.zues.widget.adapterview.recyclerview.view.SwipRefreshRecyclerView.2
                @Override // tv.chushou.zues.widget.adapterview.CustomSwipeRefreshLayout.a
                public boolean dQv() {
                    return SwipRefreshRecyclerView.this.nXs != null && SwipRefreshRecyclerView.this.nXs.getScrollY() > 0;
                }
            });
        }
        this.mTouchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
    }

    public void setOnePageSize(int i) {
        this.nXy = i;
    }

    public ExtendedRecyclerView getInnerRecyclerView() {
        return this.nXs;
    }

    public void setHasFixedSize(boolean z) {
        this.nXs.setHasFixedSize(z);
    }

    public void setUpDefault() {
        this.nXs.setLayoutManager(new LinearLayoutManager(getContext()));
        this.nXt = new DefaultLoadMoreView(getContext());
    }

    public void setAdapter(RecyclerView.Adapter adapter) {
        this.nXs.setAdapter(adapter);
        if (this.nXu != null) {
            this.nXs.setLoadMoreProvider(this);
        }
    }

    public tv.chushou.zues.widget.adapterview.recyclerview.a.b getAdapter() {
        return this.nXs.getAdapter();
    }

    public boolean Os(int i) {
        return this.nXs.Os(i);
    }

    public int getHeaderViewCount() {
        return this.nXs.getHeaderViewCount();
    }

    public boolean Ot(int i) {
        return this.nXs.Ot(i);
    }

    public int getFooterViewCount() {
        return this.nXs.getFooterViewCount();
    }

    public void setEmptyView(@NonNull View view) {
        this.nXs.setEmptyView(view);
    }

    @Nullable
    public View getEmptyView() {
        return this.nXs.getEmptyView();
    }

    public void setLoadMoreListener(tv.chushou.zues.widget.adapterview.b bVar) {
        this.nXu = bVar;
        if (getAdapter() != null) {
            this.nXs.setLoadMoreProvider(this);
        }
    }

    public void setLoadMoreFooter(@NonNull View view) {
        this.nXt = view;
    }

    public void dQA() {
        this.ems = false;
    }

    @Override // tv.chushou.zues.widget.adapterview.c
    public void On(int i) {
        if (this.nXv && this.nXs.getAdapter() != null) {
            if (this.nXt == null) {
                this.nXt = new DefaultLoadMoreView(getContext());
            }
            if (i >= this.nXy) {
                if (!this.nXs.dG(this.nXt)) {
                    this.nXs.addFooterView(this.nXt, 0);
                }
            } else if (this.nXs.dG(this.nXt)) {
                this.nXs.dE(this.nXt);
            }
            this.ems = false;
        }
    }

    @Override // tv.chushou.zues.widget.adapterview.c
    public boolean dQw() {
        if (this.nXt == null) {
            this.nXt = new DefaultLoadMoreView(getContext());
        }
        return this.nXs.dG(this.nXt);
    }

    public void setHasMoreItems(boolean z) {
        this.nXv = z;
        if (!z && this.nXs.dG(this.nXt)) {
            this.nXs.dE(this.nXt);
        }
    }

    public void setPullToRefreshEnabled(boolean z) {
        this.nXw = z;
        setEnabled(this.nXw);
    }

    public void completeRefresh() {
        setRefreshing(false);
    }

    public void setPullToRefreshListener(f fVar) {
        this.nXz = fVar;
    }

    @Override // android.support.v4.widget.SwipeRefreshLayout
    @Deprecated
    public void setOnRefreshListener(@Nullable SwipeRefreshLayout.OnRefreshListener onRefreshListener) {
        super.setOnRefreshListener(onRefreshListener);
    }

    public void setLayoutManager(RecyclerView.LayoutManager layoutManager) {
        this.nXs.setLayoutManager(layoutManager);
    }

    public RecyclerView.LayoutManager getLayoutManager() {
        return this.nXs.getLayoutManager();
    }

    public void addItemDecoration(RecyclerView.ItemDecoration itemDecoration) {
        this.nXs.addItemDecoration(itemDecoration);
    }

    public void scrollToPosition(int i) {
        this.nXs.scrollToPosition(i);
    }

    public void setItemDecration(RecyclerView.ItemDecoration itemDecoration) {
        this.nXs.addItemDecoration(itemDecoration);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                this.nXB = false;
                this.startY = motionEvent.getY();
                this.startX = motionEvent.getX();
                break;
            case 2:
                float y = motionEvent.getY();
                float abs = Math.abs(y - this.startY);
                float f = y - this.startY;
                if (abs > this.mTouchSlop && f < 0.0f) {
                    this.nXB = true;
                    break;
                } else {
                    this.nXB = false;
                    break;
                }
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public void setSmallPageSize(int i) {
        this.nXx = i;
    }
}
