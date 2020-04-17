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
    private boolean eQx;
    private float gKV;
    private RecyclerView.OnScrollListener mOnScrollListener;
    private ExtendedRecyclerView ntm;
    private View ntn;
    private b nto;
    private boolean ntp;
    private boolean ntq;
    private int ntr;
    private int nts;
    private f ntt;
    private RecyclerView.OnScrollListener ntu;
    private boolean ntv;
    private float startX;
    private float startY;

    public SwipRefreshRecyclerView(Context context) {
        this(context, null);
    }

    public SwipRefreshRecyclerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.eQx = false;
        this.ntp = true;
        this.ntq = true;
        this.ntr = 9;
        this.nts = 20;
        this.mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: tv.chushou.zues.widget.adapterview.recyclerview.view.SwipRefreshRecyclerView.3
            private int ntx = -1;

            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i, int i2) {
                boolean z = false;
                super.onScrolled(recyclerView, i, i2);
                if (SwipRefreshRecyclerView.this.ntu != null) {
                    SwipRefreshRecyclerView.this.ntu.onScrolled(recyclerView, i, i2);
                }
                if (SwipRefreshRecyclerView.this.ntm.getLayoutManager() != null) {
                    this.ntx = a.e(SwipRefreshRecyclerView.this.ntm.getLayoutManager());
                    if (Build.VERSION.SDK_INT < 21) {
                        int top2 = (recyclerView == null || recyclerView.getChildCount() == 0) ? 0 : recyclerView.getChildAt(0).getTop();
                        SwipRefreshRecyclerView swipRefreshRecyclerView = SwipRefreshRecyclerView.this;
                        if (top2 >= recyclerView.getPaddingTop() && SwipRefreshRecyclerView.this.ntq) {
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
                if (SwipRefreshRecyclerView.this.ntu != null) {
                    SwipRefreshRecyclerView.this.ntu.onScrollStateChanged(recyclerView, i);
                }
                RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
                if (layoutManager != null && (adapter = recyclerView.getAdapter()) != null) {
                    int childCount = layoutManager.getChildCount();
                    int itemCount = layoutManager.getItemCount();
                    if (childCount > 0 && i == 0 && this.ntx >= itemCount - 1 && SwipRefreshRecyclerView.this.ntv && !SwipRefreshRecyclerView.this.eQx && SwipRefreshRecyclerView.this.ntp && SwipRefreshRecyclerView.this.nto != null && adapter.getItemCount() > SwipRefreshRecyclerView.this.ntr) {
                        SwipRefreshRecyclerView.this.nto.blb();
                        SwipRefreshRecyclerView.this.eQx = true;
                    }
                }
            }
        };
        this.ntm = new ExtendedRecyclerView(getContext(), attributeSet);
        this.ntm.setId(b.e.zues_swiperefresh_recyclerview);
        RecyclerView.ItemAnimator itemAnimator = this.ntm.getItemAnimator();
        if (itemAnimator instanceof SimpleItemAnimator) {
            ((SimpleItemAnimator) itemAnimator).setSupportsChangeAnimations(false);
        }
        this.ntm.setHasFixedSize(true);
        addView(this.ntm, new ViewGroup.LayoutParams(-1, -1));
        setColorSchemeResources(17170452, 17170459, 17170452, 17170459);
        this.ntm.addOnScrollListener(this.mOnScrollListener);
        super.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() { // from class: tv.chushou.zues.widget.adapterview.recyclerview.view.SwipRefreshRecyclerView.1
            @Override // android.support.v4.widget.SwipeRefreshLayout.OnRefreshListener
            public void onRefresh() {
                if (SwipRefreshRecyclerView.this.ntt != null) {
                    SwipRefreshRecyclerView.this.ntp = true;
                    tv.chushou.zues.widget.adapterview.recyclerview.a.b adapter = SwipRefreshRecyclerView.this.getAdapter();
                    if (adapter != null) {
                        adapter.dKc();
                    }
                    SwipRefreshRecyclerView.this.ntt.onRefresh();
                }
            }
        });
        setEnabled(this.ntq);
        if (Build.VERSION.SDK_INT < 21) {
            setCanChildScrollUpCallback(new CustomSwipeRefreshLayout.a() { // from class: tv.chushou.zues.widget.adapterview.recyclerview.view.SwipRefreshRecyclerView.2
                @Override // tv.chushou.zues.widget.adapterview.CustomSwipeRefreshLayout.a
                public boolean dKa() {
                    return SwipRefreshRecyclerView.this.ntm != null && SwipRefreshRecyclerView.this.ntm.getScrollY() > 0;
                }
            });
        }
        this.gKV = ViewConfiguration.get(context).getScaledTouchSlop();
    }

    public void setOnePageSize(int i) {
        this.nts = i;
    }

    public ExtendedRecyclerView getInnerRecyclerView() {
        return this.ntm;
    }

    public void setHasFixedSize(boolean z) {
        this.ntm.setHasFixedSize(z);
    }

    public void setUpDefault() {
        this.ntm.setLayoutManager(new LinearLayoutManager(getContext()));
        this.ntn = new DefaultLoadMoreView(getContext());
    }

    public void setAdapter(RecyclerView.Adapter adapter) {
        this.ntm.setAdapter(adapter);
        if (this.nto != null) {
            this.ntm.setLoadMoreProvider(this);
        }
    }

    public tv.chushou.zues.widget.adapterview.recyclerview.a.b getAdapter() {
        return this.ntm.getAdapter();
    }

    public boolean JU(int i) {
        return this.ntm.JU(i);
    }

    public int getHeaderViewCount() {
        return this.ntm.getHeaderViewCount();
    }

    public boolean JV(int i) {
        return this.ntm.JV(i);
    }

    public int getFooterViewCount() {
        return this.ntm.getFooterViewCount();
    }

    public void setEmptyView(@NonNull View view) {
        this.ntm.setEmptyView(view);
    }

    @Nullable
    public View getEmptyView() {
        return this.ntm.getEmptyView();
    }

    public void setLoadMoreListener(tv.chushou.zues.widget.adapterview.b bVar) {
        this.nto = bVar;
        if (getAdapter() != null) {
            this.ntm.setLoadMoreProvider(this);
        }
    }

    public void setLoadMoreFooter(@NonNull View view) {
        this.ntn = view;
    }

    public void dKf() {
        this.eQx = false;
    }

    @Override // tv.chushou.zues.widget.adapterview.c
    public void JP(int i) {
        if (this.ntp && this.ntm.getAdapter() != null) {
            if (this.ntn == null) {
                this.ntn = new DefaultLoadMoreView(getContext());
            }
            if (i >= this.nts) {
                if (!this.ntm.dx(this.ntn)) {
                    this.ntm.addFooterView(this.ntn, 0);
                }
            } else if (this.ntm.dx(this.ntn)) {
                this.ntm.dv(this.ntn);
            }
            this.eQx = false;
        }
    }

    @Override // tv.chushou.zues.widget.adapterview.c
    public boolean dKb() {
        if (this.ntn == null) {
            this.ntn = new DefaultLoadMoreView(getContext());
        }
        return this.ntm.dx(this.ntn);
    }

    public void setHasMoreItems(boolean z) {
        this.ntp = z;
        if (!z && this.ntm.dx(this.ntn)) {
            this.ntm.dv(this.ntn);
        }
    }

    public void setPullToRefreshEnabled(boolean z) {
        this.ntq = z;
        setEnabled(this.ntq);
    }

    public void completeRefresh() {
        setRefreshing(false);
    }

    public void setPullToRefreshListener(f fVar) {
        this.ntt = fVar;
    }

    @Override // android.support.v4.widget.SwipeRefreshLayout
    @Deprecated
    public void setOnRefreshListener(@Nullable SwipeRefreshLayout.OnRefreshListener onRefreshListener) {
        super.setOnRefreshListener(onRefreshListener);
    }

    public void setLayoutManager(RecyclerView.LayoutManager layoutManager) {
        this.ntm.setLayoutManager(layoutManager);
    }

    public RecyclerView.LayoutManager getLayoutManager() {
        return this.ntm.getLayoutManager();
    }

    public void addItemDecoration(RecyclerView.ItemDecoration itemDecoration) {
        this.ntm.addItemDecoration(itemDecoration);
    }

    public void scrollToPosition(int i) {
        this.ntm.scrollToPosition(i);
    }

    public void setItemDecration(RecyclerView.ItemDecoration itemDecoration) {
        this.ntm.addItemDecoration(itemDecoration);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                this.ntv = false;
                this.startY = motionEvent.getY();
                this.startX = motionEvent.getX();
                break;
            case 2:
                float y = motionEvent.getY();
                float abs = Math.abs(y - this.startY);
                float f = y - this.startY;
                if (abs > this.gKV && f < 0.0f) {
                    this.ntv = true;
                    break;
                } else {
                    this.ntv = false;
                    break;
                }
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public void setSmallPageSize(int i) {
        this.ntr = i;
    }
}
