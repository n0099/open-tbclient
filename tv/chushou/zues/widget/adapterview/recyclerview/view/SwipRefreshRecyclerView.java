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
    private ExtendedRecyclerView otU;
    private View otV;
    private b otW;
    private boolean otX;
    private boolean otY;
    private int otZ;
    private int oua;
    private f oub;
    private RecyclerView.OnScrollListener ouc;
    private boolean oud;
    private float startX;
    private float startY;

    public SwipRefreshRecyclerView(Context context) {
        this(context, null);
    }

    public SwipRefreshRecyclerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ftQ = false;
        this.otX = true;
        this.otY = true;
        this.otZ = 9;
        this.oua = 20;
        this.mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: tv.chushou.zues.widget.adapterview.recyclerview.view.SwipRefreshRecyclerView.3
            private int ouf = -1;

            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i, int i2) {
                boolean z = false;
                super.onScrolled(recyclerView, i, i2);
                if (SwipRefreshRecyclerView.this.ouc != null) {
                    SwipRefreshRecyclerView.this.ouc.onScrolled(recyclerView, i, i2);
                }
                if (SwipRefreshRecyclerView.this.otU.getLayoutManager() != null) {
                    this.ouf = a.e(SwipRefreshRecyclerView.this.otU.getLayoutManager());
                    if (Build.VERSION.SDK_INT < 21) {
                        int top = (recyclerView == null || recyclerView.getChildCount() == 0) ? 0 : recyclerView.getChildAt(0).getTop();
                        SwipRefreshRecyclerView swipRefreshRecyclerView = SwipRefreshRecyclerView.this;
                        if (top >= recyclerView.getPaddingTop() && SwipRefreshRecyclerView.this.otY) {
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
                if (SwipRefreshRecyclerView.this.ouc != null) {
                    SwipRefreshRecyclerView.this.ouc.onScrollStateChanged(recyclerView, i);
                }
                RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
                if (layoutManager != null && (adapter = recyclerView.getAdapter()) != null) {
                    int childCount = layoutManager.getChildCount();
                    int itemCount = layoutManager.getItemCount();
                    if (childCount > 0 && i == 0 && this.ouf >= itemCount - 1 && SwipRefreshRecyclerView.this.oud && !SwipRefreshRecyclerView.this.ftQ && SwipRefreshRecyclerView.this.otX && SwipRefreshRecyclerView.this.otW != null && adapter.getItemCount() > SwipRefreshRecyclerView.this.otZ) {
                        SwipRefreshRecyclerView.this.otW.bwE();
                        SwipRefreshRecyclerView.this.ftQ = true;
                    }
                }
            }
        };
        this.otU = new ExtendedRecyclerView(getContext(), attributeSet);
        this.otU.setId(b.e.zues_swiperefresh_recyclerview);
        RecyclerView.ItemAnimator itemAnimator = this.otU.getItemAnimator();
        if (itemAnimator instanceof SimpleItemAnimator) {
            ((SimpleItemAnimator) itemAnimator).setSupportsChangeAnimations(false);
        }
        this.otU.setHasFixedSize(true);
        addView(this.otU, new ViewGroup.LayoutParams(-1, -1));
        setColorSchemeResources(17170452, 17170459, 17170452, 17170459);
        this.otU.addOnScrollListener(this.mOnScrollListener);
        super.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() { // from class: tv.chushou.zues.widget.adapterview.recyclerview.view.SwipRefreshRecyclerView.1
            @Override // android.support.v4.widget.SwipeRefreshLayout.OnRefreshListener
            public void onRefresh() {
                if (SwipRefreshRecyclerView.this.oub != null) {
                    SwipRefreshRecyclerView.this.otX = true;
                    tv.chushou.zues.widget.adapterview.recyclerview.a.b adapter = SwipRefreshRecyclerView.this.getAdapter();
                    if (adapter != null) {
                        adapter.eao();
                    }
                    SwipRefreshRecyclerView.this.oub.onRefresh();
                }
            }
        });
        setEnabled(this.otY);
        if (Build.VERSION.SDK_INT < 21) {
            setCanChildScrollUpCallback(new CustomSwipeRefreshLayout.a() { // from class: tv.chushou.zues.widget.adapterview.recyclerview.view.SwipRefreshRecyclerView.2
                @Override // tv.chushou.zues.widget.adapterview.CustomSwipeRefreshLayout.a
                public boolean eam() {
                    return SwipRefreshRecyclerView.this.otU != null && SwipRefreshRecyclerView.this.otU.getScrollY() > 0;
                }
            });
        }
        this.hrW = ViewConfiguration.get(context).getScaledTouchSlop();
    }

    public void setOnePageSize(int i) {
        this.oua = i;
    }

    public ExtendedRecyclerView getInnerRecyclerView() {
        return this.otU;
    }

    public void setHasFixedSize(boolean z) {
        this.otU.setHasFixedSize(z);
    }

    public void setUpDefault() {
        this.otU.setLayoutManager(new LinearLayoutManager(getContext()));
        this.otV = new DefaultLoadMoreView(getContext());
    }

    public void setAdapter(RecyclerView.Adapter adapter) {
        this.otU.setAdapter(adapter);
        if (this.otW != null) {
            this.otU.setLoadMoreProvider(this);
        }
    }

    public tv.chushou.zues.widget.adapterview.recyclerview.a.b getAdapter() {
        return this.otU.getAdapter();
    }

    public boolean Mh(int i) {
        return this.otU.Mh(i);
    }

    public int getHeaderViewCount() {
        return this.otU.getHeaderViewCount();
    }

    public boolean Mi(int i) {
        return this.otU.Mi(i);
    }

    public int getFooterViewCount() {
        return this.otU.getFooterViewCount();
    }

    public void setEmptyView(@NonNull View view) {
        this.otU.setEmptyView(view);
    }

    @Nullable
    public View getEmptyView() {
        return this.otU.getEmptyView();
    }

    public void setLoadMoreListener(tv.chushou.zues.widget.adapterview.b bVar) {
        this.otW = bVar;
        if (getAdapter() != null) {
            this.otU.setLoadMoreProvider(this);
        }
    }

    public void setLoadMoreFooter(@NonNull View view) {
        this.otV = view;
    }

    public void ear() {
        this.ftQ = false;
    }

    @Override // tv.chushou.zues.widget.adapterview.c
    public void Md(int i) {
        if (this.otX && this.otU.getAdapter() != null) {
            if (this.otV == null) {
                this.otV = new DefaultLoadMoreView(getContext());
            }
            if (i >= this.oua) {
                if (!this.otU.dF(this.otV)) {
                    this.otU.addFooterView(this.otV, 0);
                }
            } else if (this.otU.dF(this.otV)) {
                this.otU.dD(this.otV);
            }
            this.ftQ = false;
        }
    }

    @Override // tv.chushou.zues.widget.adapterview.c
    public boolean ean() {
        if (this.otV == null) {
            this.otV = new DefaultLoadMoreView(getContext());
        }
        return this.otU.dF(this.otV);
    }

    public void setHasMoreItems(boolean z) {
        this.otX = z;
        if (!z && this.otU.dF(this.otV)) {
            this.otU.dD(this.otV);
        }
    }

    public void setPullToRefreshEnabled(boolean z) {
        this.otY = z;
        setEnabled(this.otY);
    }

    public void completeRefresh() {
        setRefreshing(false);
    }

    public void setPullToRefreshListener(f fVar) {
        this.oub = fVar;
    }

    @Override // android.support.v4.widget.SwipeRefreshLayout
    @Deprecated
    public void setOnRefreshListener(@Nullable SwipeRefreshLayout.OnRefreshListener onRefreshListener) {
        super.setOnRefreshListener(onRefreshListener);
    }

    public void setLayoutManager(RecyclerView.LayoutManager layoutManager) {
        this.otU.setLayoutManager(layoutManager);
    }

    public RecyclerView.LayoutManager getLayoutManager() {
        return this.otU.getLayoutManager();
    }

    public void addItemDecoration(RecyclerView.ItemDecoration itemDecoration) {
        this.otU.addItemDecoration(itemDecoration);
    }

    public void scrollToPosition(int i) {
        this.otU.scrollToPosition(i);
    }

    public void setItemDecration(RecyclerView.ItemDecoration itemDecoration) {
        this.otU.addItemDecoration(itemDecoration);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                this.oud = false;
                this.startY = motionEvent.getY();
                this.startX = motionEvent.getX();
                break;
            case 2:
                float y = motionEvent.getY();
                float abs = Math.abs(y - this.startY);
                float f = y - this.startY;
                if (abs > this.hrW && f < 0.0f) {
                    this.oud = true;
                    break;
                } else {
                    this.oud = false;
                    break;
                }
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public void setSmallPageSize(int i) {
        this.otZ = i;
    }
}
