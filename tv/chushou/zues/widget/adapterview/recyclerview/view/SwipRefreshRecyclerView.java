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
    private boolean emt;
    private RecyclerView.OnScrollListener mOnScrollListener;
    private float mTouchSlop;
    private int nXA;
    private f nXB;
    private RecyclerView.OnScrollListener nXC;
    private boolean nXD;
    private ExtendedRecyclerView nXu;
    private View nXv;
    private b nXw;
    private boolean nXx;
    private boolean nXy;
    private int nXz;
    private float startX;
    private float startY;

    public SwipRefreshRecyclerView(Context context) {
        this(context, null);
    }

    public SwipRefreshRecyclerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.emt = false;
        this.nXx = true;
        this.nXy = true;
        this.nXz = 9;
        this.nXA = 20;
        this.mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: tv.chushou.zues.widget.adapterview.recyclerview.view.SwipRefreshRecyclerView.3
            private int nXF = -1;

            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i, int i2) {
                boolean z = false;
                super.onScrolled(recyclerView, i, i2);
                if (SwipRefreshRecyclerView.this.nXC != null) {
                    SwipRefreshRecyclerView.this.nXC.onScrolled(recyclerView, i, i2);
                }
                if (SwipRefreshRecyclerView.this.nXu.getLayoutManager() != null) {
                    this.nXF = a.e(SwipRefreshRecyclerView.this.nXu.getLayoutManager());
                    if (Build.VERSION.SDK_INT < 21) {
                        int top2 = (recyclerView == null || recyclerView.getChildCount() == 0) ? 0 : recyclerView.getChildAt(0).getTop();
                        SwipRefreshRecyclerView swipRefreshRecyclerView = SwipRefreshRecyclerView.this;
                        if (top2 >= recyclerView.getPaddingTop() && SwipRefreshRecyclerView.this.nXy) {
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
                if (SwipRefreshRecyclerView.this.nXC != null) {
                    SwipRefreshRecyclerView.this.nXC.onScrollStateChanged(recyclerView, i);
                }
                RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
                if (layoutManager != null && (adapter = recyclerView.getAdapter()) != null) {
                    int childCount = layoutManager.getChildCount();
                    int itemCount = layoutManager.getItemCount();
                    if (childCount > 0 && i == 0 && this.nXF >= itemCount - 1 && SwipRefreshRecyclerView.this.nXD && !SwipRefreshRecyclerView.this.emt && SwipRefreshRecyclerView.this.nXx && SwipRefreshRecyclerView.this.nXw != null && adapter.getItemCount() > SwipRefreshRecyclerView.this.nXz) {
                        SwipRefreshRecyclerView.this.nXw.bcf();
                        SwipRefreshRecyclerView.this.emt = true;
                    }
                }
            }
        };
        this.nXu = new ExtendedRecyclerView(getContext(), attributeSet);
        this.nXu.setId(b.e.zues_swiperefresh_recyclerview);
        RecyclerView.ItemAnimator itemAnimator = this.nXu.getItemAnimator();
        if (itemAnimator instanceof SimpleItemAnimator) {
            ((SimpleItemAnimator) itemAnimator).setSupportsChangeAnimations(false);
        }
        this.nXu.setHasFixedSize(true);
        addView(this.nXu, new ViewGroup.LayoutParams(-1, -1));
        setColorSchemeResources(17170452, 17170459, 17170452, 17170459);
        this.nXu.addOnScrollListener(this.mOnScrollListener);
        super.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() { // from class: tv.chushou.zues.widget.adapterview.recyclerview.view.SwipRefreshRecyclerView.1
            @Override // android.support.v4.widget.SwipeRefreshLayout.OnRefreshListener
            public void onRefresh() {
                if (SwipRefreshRecyclerView.this.nXB != null) {
                    SwipRefreshRecyclerView.this.nXx = true;
                    tv.chushou.zues.widget.adapterview.recyclerview.a.b adapter = SwipRefreshRecyclerView.this.getAdapter();
                    if (adapter != null) {
                        adapter.dQz();
                    }
                    SwipRefreshRecyclerView.this.nXB.onRefresh();
                }
            }
        });
        setEnabled(this.nXy);
        if (Build.VERSION.SDK_INT < 21) {
            setCanChildScrollUpCallback(new CustomSwipeRefreshLayout.a() { // from class: tv.chushou.zues.widget.adapterview.recyclerview.view.SwipRefreshRecyclerView.2
                @Override // tv.chushou.zues.widget.adapterview.CustomSwipeRefreshLayout.a
                public boolean dQx() {
                    return SwipRefreshRecyclerView.this.nXu != null && SwipRefreshRecyclerView.this.nXu.getScrollY() > 0;
                }
            });
        }
        this.mTouchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
    }

    public void setOnePageSize(int i) {
        this.nXA = i;
    }

    public ExtendedRecyclerView getInnerRecyclerView() {
        return this.nXu;
    }

    public void setHasFixedSize(boolean z) {
        this.nXu.setHasFixedSize(z);
    }

    public void setUpDefault() {
        this.nXu.setLayoutManager(new LinearLayoutManager(getContext()));
        this.nXv = new DefaultLoadMoreView(getContext());
    }

    public void setAdapter(RecyclerView.Adapter adapter) {
        this.nXu.setAdapter(adapter);
        if (this.nXw != null) {
            this.nXu.setLoadMoreProvider(this);
        }
    }

    public tv.chushou.zues.widget.adapterview.recyclerview.a.b getAdapter() {
        return this.nXu.getAdapter();
    }

    public boolean Os(int i) {
        return this.nXu.Os(i);
    }

    public int getHeaderViewCount() {
        return this.nXu.getHeaderViewCount();
    }

    public boolean Ot(int i) {
        return this.nXu.Ot(i);
    }

    public int getFooterViewCount() {
        return this.nXu.getFooterViewCount();
    }

    public void setEmptyView(@NonNull View view) {
        this.nXu.setEmptyView(view);
    }

    @Nullable
    public View getEmptyView() {
        return this.nXu.getEmptyView();
    }

    public void setLoadMoreListener(tv.chushou.zues.widget.adapterview.b bVar) {
        this.nXw = bVar;
        if (getAdapter() != null) {
            this.nXu.setLoadMoreProvider(this);
        }
    }

    public void setLoadMoreFooter(@NonNull View view) {
        this.nXv = view;
    }

    public void dQC() {
        this.emt = false;
    }

    @Override // tv.chushou.zues.widget.adapterview.c
    public void On(int i) {
        if (this.nXx && this.nXu.getAdapter() != null) {
            if (this.nXv == null) {
                this.nXv = new DefaultLoadMoreView(getContext());
            }
            if (i >= this.nXA) {
                if (!this.nXu.dG(this.nXv)) {
                    this.nXu.addFooterView(this.nXv, 0);
                }
            } else if (this.nXu.dG(this.nXv)) {
                this.nXu.dE(this.nXv);
            }
            this.emt = false;
        }
    }

    @Override // tv.chushou.zues.widget.adapterview.c
    public boolean dQy() {
        if (this.nXv == null) {
            this.nXv = new DefaultLoadMoreView(getContext());
        }
        return this.nXu.dG(this.nXv);
    }

    public void setHasMoreItems(boolean z) {
        this.nXx = z;
        if (!z && this.nXu.dG(this.nXv)) {
            this.nXu.dE(this.nXv);
        }
    }

    public void setPullToRefreshEnabled(boolean z) {
        this.nXy = z;
        setEnabled(this.nXy);
    }

    public void completeRefresh() {
        setRefreshing(false);
    }

    public void setPullToRefreshListener(f fVar) {
        this.nXB = fVar;
    }

    @Override // android.support.v4.widget.SwipeRefreshLayout
    @Deprecated
    public void setOnRefreshListener(@Nullable SwipeRefreshLayout.OnRefreshListener onRefreshListener) {
        super.setOnRefreshListener(onRefreshListener);
    }

    public void setLayoutManager(RecyclerView.LayoutManager layoutManager) {
        this.nXu.setLayoutManager(layoutManager);
    }

    public RecyclerView.LayoutManager getLayoutManager() {
        return this.nXu.getLayoutManager();
    }

    public void addItemDecoration(RecyclerView.ItemDecoration itemDecoration) {
        this.nXu.addItemDecoration(itemDecoration);
    }

    public void scrollToPosition(int i) {
        this.nXu.scrollToPosition(i);
    }

    public void setItemDecration(RecyclerView.ItemDecoration itemDecoration) {
        this.nXu.addItemDecoration(itemDecoration);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                this.nXD = false;
                this.startY = motionEvent.getY();
                this.startX = motionEvent.getX();
                break;
            case 2:
                float y = motionEvent.getY();
                float abs = Math.abs(y - this.startY);
                float f = y - this.startY;
                if (abs > this.mTouchSlop && f < 0.0f) {
                    this.nXD = true;
                    break;
                } else {
                    this.nXD = false;
                    break;
                }
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public void setSmallPageSize(int i) {
        this.nXz = i;
    }
}
