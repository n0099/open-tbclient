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
    private boolean ftQ;
    private float hrW;
    private RecyclerView.OnScrollListener mOnScrollListener;
    private ExtendedRecyclerView otS;
    private View otT;
    private b otU;
    private boolean otV;
    private boolean otW;
    private int otX;
    private int otY;
    private f otZ;
    private RecyclerView.OnScrollListener oua;
    private boolean oub;
    private float startX;
    private float startY;

    public SwipRefreshRecyclerView(Context context) {
        this(context, null);
    }

    public SwipRefreshRecyclerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ftQ = false;
        this.otV = true;
        this.otW = true;
        this.otX = 9;
        this.otY = 20;
        this.mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: tv.chushou.zues.widget.adapterview.recyclerview.view.SwipRefreshRecyclerView.3
            private int oud = -1;

            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i, int i2) {
                boolean z = false;
                super.onScrolled(recyclerView, i, i2);
                if (SwipRefreshRecyclerView.this.oua != null) {
                    SwipRefreshRecyclerView.this.oua.onScrolled(recyclerView, i, i2);
                }
                if (SwipRefreshRecyclerView.this.otS.getLayoutManager() != null) {
                    this.oud = a.e(SwipRefreshRecyclerView.this.otS.getLayoutManager());
                    if (Build.VERSION.SDK_INT < 21) {
                        int top = (recyclerView == null || recyclerView.getChildCount() == 0) ? 0 : recyclerView.getChildAt(0).getTop();
                        SwipRefreshRecyclerView swipRefreshRecyclerView = SwipRefreshRecyclerView.this;
                        if (top >= recyclerView.getPaddingTop() && SwipRefreshRecyclerView.this.otW) {
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
                if (SwipRefreshRecyclerView.this.oua != null) {
                    SwipRefreshRecyclerView.this.oua.onScrollStateChanged(recyclerView, i);
                }
                RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
                if (layoutManager != null && (adapter = recyclerView.getAdapter()) != null) {
                    int childCount = layoutManager.getChildCount();
                    int itemCount = layoutManager.getItemCount();
                    if (childCount > 0 && i == 0 && this.oud >= itemCount - 1 && SwipRefreshRecyclerView.this.oub && !SwipRefreshRecyclerView.this.ftQ && SwipRefreshRecyclerView.this.otV && SwipRefreshRecyclerView.this.otU != null && adapter.getItemCount() > SwipRefreshRecyclerView.this.otX) {
                        SwipRefreshRecyclerView.this.otU.bwE();
                        SwipRefreshRecyclerView.this.ftQ = true;
                    }
                }
            }
        };
        this.otS = new ExtendedRecyclerView(getContext(), attributeSet);
        this.otS.setId(b.e.zues_swiperefresh_recyclerview);
        RecyclerView.ItemAnimator itemAnimator = this.otS.getItemAnimator();
        if (itemAnimator instanceof SimpleItemAnimator) {
            ((SimpleItemAnimator) itemAnimator).setSupportsChangeAnimations(false);
        }
        this.otS.setHasFixedSize(true);
        addView(this.otS, new ViewGroup.LayoutParams(-1, -1));
        setColorSchemeResources(17170452, 17170459, 17170452, 17170459);
        this.otS.addOnScrollListener(this.mOnScrollListener);
        super.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() { // from class: tv.chushou.zues.widget.adapterview.recyclerview.view.SwipRefreshRecyclerView.1
            @Override // android.support.v4.widget.SwipeRefreshLayout.OnRefreshListener
            public void onRefresh() {
                if (SwipRefreshRecyclerView.this.otZ != null) {
                    SwipRefreshRecyclerView.this.otV = true;
                    tv.chushou.zues.widget.adapterview.recyclerview.a.b adapter = SwipRefreshRecyclerView.this.getAdapter();
                    if (adapter != null) {
                        adapter.ean();
                    }
                    SwipRefreshRecyclerView.this.otZ.onRefresh();
                }
            }
        });
        setEnabled(this.otW);
        if (Build.VERSION.SDK_INT < 21) {
            setCanChildScrollUpCallback(new CustomSwipeRefreshLayout.a() { // from class: tv.chushou.zues.widget.adapterview.recyclerview.view.SwipRefreshRecyclerView.2
                @Override // tv.chushou.zues.widget.adapterview.CustomSwipeRefreshLayout.a
                public boolean eal() {
                    return SwipRefreshRecyclerView.this.otS != null && SwipRefreshRecyclerView.this.otS.getScrollY() > 0;
                }
            });
        }
        this.hrW = ViewConfiguration.get(context).getScaledTouchSlop();
    }

    public void setOnePageSize(int i) {
        this.otY = i;
    }

    public ExtendedRecyclerView getInnerRecyclerView() {
        return this.otS;
    }

    public void setHasFixedSize(boolean z) {
        this.otS.setHasFixedSize(z);
    }

    public void setUpDefault() {
        this.otS.setLayoutManager(new LinearLayoutManager(getContext()));
        this.otT = new DefaultLoadMoreView(getContext());
    }

    public void setAdapter(RecyclerView.Adapter adapter) {
        this.otS.setAdapter(adapter);
        if (this.otU != null) {
            this.otS.setLoadMoreProvider(this);
        }
    }

    public tv.chushou.zues.widget.adapterview.recyclerview.a.b getAdapter() {
        return this.otS.getAdapter();
    }

    public boolean Mh(int i) {
        return this.otS.Mh(i);
    }

    public int getHeaderViewCount() {
        return this.otS.getHeaderViewCount();
    }

    public boolean Mi(int i) {
        return this.otS.Mi(i);
    }

    public int getFooterViewCount() {
        return this.otS.getFooterViewCount();
    }

    public void setEmptyView(@NonNull View view) {
        this.otS.setEmptyView(view);
    }

    @Nullable
    public View getEmptyView() {
        return this.otS.getEmptyView();
    }

    public void setLoadMoreListener(tv.chushou.zues.widget.adapterview.b bVar) {
        this.otU = bVar;
        if (getAdapter() != null) {
            this.otS.setLoadMoreProvider(this);
        }
    }

    public void setLoadMoreFooter(@NonNull View view) {
        this.otT = view;
    }

    public void eaq() {
        this.ftQ = false;
    }

    @Override // tv.chushou.zues.widget.adapterview.c
    public void Md(int i) {
        if (this.otV && this.otS.getAdapter() != null) {
            if (this.otT == null) {
                this.otT = new DefaultLoadMoreView(getContext());
            }
            if (i >= this.otY) {
                if (!this.otS.dF(this.otT)) {
                    this.otS.addFooterView(this.otT, 0);
                }
            } else if (this.otS.dF(this.otT)) {
                this.otS.dD(this.otT);
            }
            this.ftQ = false;
        }
    }

    @Override // tv.chushou.zues.widget.adapterview.c
    public boolean eam() {
        if (this.otT == null) {
            this.otT = new DefaultLoadMoreView(getContext());
        }
        return this.otS.dF(this.otT);
    }

    public void setHasMoreItems(boolean z) {
        this.otV = z;
        if (!z && this.otS.dF(this.otT)) {
            this.otS.dD(this.otT);
        }
    }

    public void setPullToRefreshEnabled(boolean z) {
        this.otW = z;
        setEnabled(this.otW);
    }

    public void completeRefresh() {
        setRefreshing(false);
    }

    public void setPullToRefreshListener(f fVar) {
        this.otZ = fVar;
    }

    @Override // android.support.v4.widget.SwipeRefreshLayout
    @Deprecated
    public void setOnRefreshListener(@Nullable SwipeRefreshLayout.OnRefreshListener onRefreshListener) {
        super.setOnRefreshListener(onRefreshListener);
    }

    public void setLayoutManager(RecyclerView.LayoutManager layoutManager) {
        this.otS.setLayoutManager(layoutManager);
    }

    public RecyclerView.LayoutManager getLayoutManager() {
        return this.otS.getLayoutManager();
    }

    public void addItemDecoration(RecyclerView.ItemDecoration itemDecoration) {
        this.otS.addItemDecoration(itemDecoration);
    }

    public void scrollToPosition(int i) {
        this.otS.scrollToPosition(i);
    }

    public void setItemDecration(RecyclerView.ItemDecoration itemDecoration) {
        this.otS.addItemDecoration(itemDecoration);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                this.oub = false;
                this.startY = motionEvent.getY();
                this.startX = motionEvent.getX();
                break;
            case 2:
                float y = motionEvent.getY();
                float abs = Math.abs(y - this.startY);
                float f = y - this.startY;
                if (abs > this.hrW && f < 0.0f) {
                    this.oub = true;
                    break;
                } else {
                    this.oub = false;
                    break;
                }
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public void setSmallPageSize(int i) {
        this.otX = i;
    }
}
