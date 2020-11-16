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
/* loaded from: classes6.dex */
public class SwipRefreshRecyclerView extends CustomSwipeRefreshLayout implements c {
    private boolean gkn;
    private float iuB;
    private RecyclerView.OnScrollListener mOnScrollListener;
    private ExtendedRecyclerView qpm;
    private View qpn;
    private b qpo;
    private boolean qpp;
    private boolean qpq;
    private int qpr;
    private int qps;
    private f qpt;
    private RecyclerView.OnScrollListener qpu;
    private boolean qpv;
    private float startX;
    private float startY;

    public SwipRefreshRecyclerView(Context context) {
        this(context, null);
    }

    public SwipRefreshRecyclerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.gkn = false;
        this.qpp = true;
        this.qpq = true;
        this.qpr = 9;
        this.qps = 20;
        this.mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: tv.chushou.zues.widget.adapterview.recyclerview.view.SwipRefreshRecyclerView.3
            private int qpx = -1;

            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i, int i2) {
                boolean z = false;
                super.onScrolled(recyclerView, i, i2);
                if (SwipRefreshRecyclerView.this.qpu != null) {
                    SwipRefreshRecyclerView.this.qpu.onScrolled(recyclerView, i, i2);
                }
                if (SwipRefreshRecyclerView.this.qpm.getLayoutManager() != null) {
                    this.qpx = a.e(SwipRefreshRecyclerView.this.qpm.getLayoutManager());
                    if (Build.VERSION.SDK_INT < 21) {
                        int top = (recyclerView == null || recyclerView.getChildCount() == 0) ? 0 : recyclerView.getChildAt(0).getTop();
                        SwipRefreshRecyclerView swipRefreshRecyclerView = SwipRefreshRecyclerView.this;
                        if (top >= recyclerView.getPaddingTop() && SwipRefreshRecyclerView.this.qpq) {
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
                if (SwipRefreshRecyclerView.this.qpu != null) {
                    SwipRefreshRecyclerView.this.qpu.onScrollStateChanged(recyclerView, i);
                }
                RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
                if (layoutManager != null && (adapter = recyclerView.getAdapter()) != null) {
                    int childCount = layoutManager.getChildCount();
                    int itemCount = layoutManager.getItemCount();
                    if (childCount > 0 && i == 0 && this.qpx >= itemCount - 1 && SwipRefreshRecyclerView.this.qpv && !SwipRefreshRecyclerView.this.gkn && SwipRefreshRecyclerView.this.qpp && SwipRefreshRecyclerView.this.qpo != null && adapter.getItemCount() > SwipRefreshRecyclerView.this.qpr) {
                        SwipRefreshRecyclerView.this.qpo.bOb();
                        SwipRefreshRecyclerView.this.gkn = true;
                    }
                }
            }
        };
        this.qpm = new ExtendedRecyclerView(getContext(), attributeSet);
        this.qpm.setId(b.e.zues_swiperefresh_recyclerview);
        RecyclerView.ItemAnimator itemAnimator = this.qpm.getItemAnimator();
        if (itemAnimator instanceof SimpleItemAnimator) {
            ((SimpleItemAnimator) itemAnimator).setSupportsChangeAnimations(false);
        }
        this.qpm.setHasFixedSize(true);
        addView(this.qpm, new ViewGroup.LayoutParams(-1, -1));
        setColorSchemeResources(17170452, 17170459, 17170452, 17170459);
        this.qpm.addOnScrollListener(this.mOnScrollListener);
        super.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() { // from class: tv.chushou.zues.widget.adapterview.recyclerview.view.SwipRefreshRecyclerView.1
            @Override // android.support.v4.widget.SwipeRefreshLayout.OnRefreshListener
            public void onRefresh() {
                if (SwipRefreshRecyclerView.this.qpt != null) {
                    SwipRefreshRecyclerView.this.qpp = true;
                    tv.chushou.zues.widget.adapterview.recyclerview.a.b adapter = SwipRefreshRecyclerView.this.getAdapter();
                    if (adapter != null) {
                        adapter.eHX();
                    }
                    SwipRefreshRecyclerView.this.qpt.onRefresh();
                }
            }
        });
        setEnabled(this.qpq);
        if (Build.VERSION.SDK_INT < 21) {
            setCanChildScrollUpCallback(new CustomSwipeRefreshLayout.a() { // from class: tv.chushou.zues.widget.adapterview.recyclerview.view.SwipRefreshRecyclerView.2
                @Override // tv.chushou.zues.widget.adapterview.CustomSwipeRefreshLayout.a
                public boolean eHV() {
                    return SwipRefreshRecyclerView.this.qpm != null && SwipRefreshRecyclerView.this.qpm.getScrollY() > 0;
                }
            });
        }
        this.iuB = ViewConfiguration.get(context).getScaledTouchSlop();
    }

    public void setOnePageSize(int i) {
        this.qps = i;
    }

    public ExtendedRecyclerView getInnerRecyclerView() {
        return this.qpm;
    }

    public void setHasFixedSize(boolean z) {
        this.qpm.setHasFixedSize(z);
    }

    public void setUpDefault() {
        this.qpm.setLayoutManager(new LinearLayoutManager(getContext()));
        this.qpn = new DefaultLoadMoreView(getContext());
    }

    public void setAdapter(RecyclerView.Adapter adapter) {
        this.qpm.setAdapter(adapter);
        if (this.qpo != null) {
            this.qpm.setLoadMoreProvider(this);
        }
    }

    public tv.chushou.zues.widget.adapterview.recyclerview.a.b getAdapter() {
        return this.qpm.getAdapter();
    }

    public boolean SJ(int i) {
        return this.qpm.SJ(i);
    }

    public int getHeaderViewCount() {
        return this.qpm.getHeaderViewCount();
    }

    public boolean vA(int i) {
        return this.qpm.vA(i);
    }

    public int getFooterViewCount() {
        return this.qpm.getFooterViewCount();
    }

    public void setEmptyView(@NonNull View view) {
        this.qpm.setEmptyView(view);
    }

    @Nullable
    public View getEmptyView() {
        return this.qpm.getEmptyView();
    }

    public void setLoadMoreListener(tv.chushou.zues.widget.adapterview.b bVar) {
        this.qpo = bVar;
        if (getAdapter() != null) {
            this.qpm.setLoadMoreProvider(this);
        }
    }

    public void setLoadMoreFooter(@NonNull View view) {
        this.qpn = view;
    }

    public void eIa() {
        this.gkn = false;
    }

    @Override // tv.chushou.zues.widget.adapterview.c
    public void SF(int i) {
        if (this.qpp && this.qpm.getAdapter() != null) {
            if (this.qpn == null) {
                this.qpn = new DefaultLoadMoreView(getContext());
            }
            if (i >= this.qps) {
                if (!this.qpm.er(this.qpn)) {
                    this.qpm.addFooterView(this.qpn, 0);
                }
            } else if (this.qpm.er(this.qpn)) {
                this.qpm.ep(this.qpn);
            }
            this.gkn = false;
        }
    }

    @Override // tv.chushou.zues.widget.adapterview.c
    public boolean eHW() {
        if (this.qpn == null) {
            this.qpn = new DefaultLoadMoreView(getContext());
        }
        return this.qpm.er(this.qpn);
    }

    public void setHasMoreItems(boolean z) {
        this.qpp = z;
        if (!z && this.qpm.er(this.qpn)) {
            this.qpm.ep(this.qpn);
        }
    }

    public void setPullToRefreshEnabled(boolean z) {
        this.qpq = z;
        setEnabled(this.qpq);
    }

    public void completeRefresh() {
        setRefreshing(false);
    }

    public void setPullToRefreshListener(f fVar) {
        this.qpt = fVar;
    }

    @Override // android.support.v4.widget.SwipeRefreshLayout
    @Deprecated
    public void setOnRefreshListener(@Nullable SwipeRefreshLayout.OnRefreshListener onRefreshListener) {
        super.setOnRefreshListener(onRefreshListener);
    }

    public void setLayoutManager(RecyclerView.LayoutManager layoutManager) {
        this.qpm.setLayoutManager(layoutManager);
    }

    public RecyclerView.LayoutManager getLayoutManager() {
        return this.qpm.getLayoutManager();
    }

    public void addItemDecoration(RecyclerView.ItemDecoration itemDecoration) {
        this.qpm.addItemDecoration(itemDecoration);
    }

    public void scrollToPosition(int i) {
        this.qpm.scrollToPosition(i);
    }

    public void setItemDecration(RecyclerView.ItemDecoration itemDecoration) {
        this.qpm.addItemDecoration(itemDecoration);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                this.qpv = false;
                this.startY = motionEvent.getY();
                this.startX = motionEvent.getX();
                break;
            case 2:
                float y = motionEvent.getY();
                float abs = Math.abs(y - this.startY);
                float f = y - this.startY;
                if (abs > this.iuB && f < 0.0f) {
                    this.qpv = true;
                    break;
                } else {
                    this.qpv = false;
                    break;
                }
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public void setSmallPageSize(int i) {
        this.qpr = i;
    }
}
