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
/* loaded from: classes4.dex */
public class SwipRefreshRecyclerView extends CustomSwipeRefreshLayout implements c {
    private boolean eil;
    private RecyclerView.OnScrollListener mOnScrollListener;
    private float mTouchSlop;
    private b nWA;
    private boolean nWB;
    private boolean nWC;
    private int nWD;
    private int nWE;
    private f nWF;
    private RecyclerView.OnScrollListener nWG;
    private boolean nWH;
    private ExtendedRecyclerView nWy;
    private View nWz;
    private float startX;
    private float startY;

    public SwipRefreshRecyclerView(Context context) {
        this(context, null);
    }

    public SwipRefreshRecyclerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.eil = false;
        this.nWB = true;
        this.nWC = true;
        this.nWD = 9;
        this.nWE = 20;
        this.mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: tv.chushou.zues.widget.adapterview.recyclerview.view.SwipRefreshRecyclerView.3
            private int nWJ = -1;

            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i, int i2) {
                boolean z = false;
                super.onScrolled(recyclerView, i, i2);
                if (SwipRefreshRecyclerView.this.nWG != null) {
                    SwipRefreshRecyclerView.this.nWG.onScrolled(recyclerView, i, i2);
                }
                if (SwipRefreshRecyclerView.this.nWy.getLayoutManager() != null) {
                    this.nWJ = a.e(SwipRefreshRecyclerView.this.nWy.getLayoutManager());
                    if (Build.VERSION.SDK_INT < 21) {
                        int top = (recyclerView == null || recyclerView.getChildCount() == 0) ? 0 : recyclerView.getChildAt(0).getTop();
                        SwipRefreshRecyclerView swipRefreshRecyclerView = SwipRefreshRecyclerView.this;
                        if (top >= recyclerView.getPaddingTop() && SwipRefreshRecyclerView.this.nWC) {
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
                if (SwipRefreshRecyclerView.this.nWG != null) {
                    SwipRefreshRecyclerView.this.nWG.onScrollStateChanged(recyclerView, i);
                }
                RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
                if (layoutManager != null && (adapter = recyclerView.getAdapter()) != null) {
                    int childCount = layoutManager.getChildCount();
                    int itemCount = layoutManager.getItemCount();
                    if (childCount > 0 && i == 0 && this.nWJ >= itemCount - 1 && SwipRefreshRecyclerView.this.nWH && !SwipRefreshRecyclerView.this.eil && SwipRefreshRecyclerView.this.nWB && SwipRefreshRecyclerView.this.nWA != null && adapter.getItemCount() > SwipRefreshRecyclerView.this.nWD) {
                        SwipRefreshRecyclerView.this.nWA.aZN();
                        SwipRefreshRecyclerView.this.eil = true;
                    }
                }
            }
        };
        this.nWy = new ExtendedRecyclerView(getContext(), attributeSet);
        this.nWy.setId(b.e.zues_swiperefresh_recyclerview);
        RecyclerView.ItemAnimator itemAnimator = this.nWy.getItemAnimator();
        if (itemAnimator instanceof SimpleItemAnimator) {
            ((SimpleItemAnimator) itemAnimator).setSupportsChangeAnimations(false);
        }
        this.nWy.setHasFixedSize(true);
        addView(this.nWy, new ViewGroup.LayoutParams(-1, -1));
        setColorSchemeResources(17170452, 17170459, 17170452, 17170459);
        this.nWy.addOnScrollListener(this.mOnScrollListener);
        super.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() { // from class: tv.chushou.zues.widget.adapterview.recyclerview.view.SwipRefreshRecyclerView.1
            @Override // android.support.v4.widget.SwipeRefreshLayout.OnRefreshListener
            public void onRefresh() {
                if (SwipRefreshRecyclerView.this.nWF != null) {
                    SwipRefreshRecyclerView.this.nWB = true;
                    tv.chushou.zues.widget.adapterview.recyclerview.a.b adapter = SwipRefreshRecyclerView.this.getAdapter();
                    if (adapter != null) {
                        adapter.dPi();
                    }
                    SwipRefreshRecyclerView.this.nWF.onRefresh();
                }
            }
        });
        setEnabled(this.nWC);
        if (Build.VERSION.SDK_INT < 21) {
            setCanChildScrollUpCallback(new CustomSwipeRefreshLayout.a() { // from class: tv.chushou.zues.widget.adapterview.recyclerview.view.SwipRefreshRecyclerView.2
                @Override // tv.chushou.zues.widget.adapterview.CustomSwipeRefreshLayout.a
                public boolean dPg() {
                    return SwipRefreshRecyclerView.this.nWy != null && SwipRefreshRecyclerView.this.nWy.getScrollY() > 0;
                }
            });
        }
        this.mTouchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
    }

    public void setOnePageSize(int i) {
        this.nWE = i;
    }

    public ExtendedRecyclerView getInnerRecyclerView() {
        return this.nWy;
    }

    public void setHasFixedSize(boolean z) {
        this.nWy.setHasFixedSize(z);
    }

    public void setUpDefault() {
        this.nWy.setLayoutManager(new LinearLayoutManager(getContext()));
        this.nWz = new DefaultLoadMoreView(getContext());
    }

    public void setAdapter(RecyclerView.Adapter adapter) {
        this.nWy.setAdapter(adapter);
        if (this.nWA != null) {
            this.nWy.setLoadMoreProvider(this);
        }
    }

    public tv.chushou.zues.widget.adapterview.recyclerview.a.b getAdapter() {
        return this.nWy.getAdapter();
    }

    public boolean Op(int i) {
        return this.nWy.Op(i);
    }

    public int getHeaderViewCount() {
        return this.nWy.getHeaderViewCount();
    }

    public boolean Oq(int i) {
        return this.nWy.Oq(i);
    }

    public int getFooterViewCount() {
        return this.nWy.getFooterViewCount();
    }

    public void setEmptyView(@NonNull View view) {
        this.nWy.setEmptyView(view);
    }

    @Nullable
    public View getEmptyView() {
        return this.nWy.getEmptyView();
    }

    public void setLoadMoreListener(tv.chushou.zues.widget.adapterview.b bVar) {
        this.nWA = bVar;
        if (getAdapter() != null) {
            this.nWy.setLoadMoreProvider(this);
        }
    }

    public void setLoadMoreFooter(@NonNull View view) {
        this.nWz = view;
    }

    public void dPl() {
        this.eil = false;
    }

    @Override // tv.chushou.zues.widget.adapterview.c
    public void Ok(int i) {
        if (this.nWB && this.nWy.getAdapter() != null) {
            if (this.nWz == null) {
                this.nWz = new DefaultLoadMoreView(getContext());
            }
            if (i >= this.nWE) {
                if (!this.nWy.dE(this.nWz)) {
                    this.nWy.addFooterView(this.nWz, 0);
                }
            } else if (this.nWy.dE(this.nWz)) {
                this.nWy.dC(this.nWz);
            }
            this.eil = false;
        }
    }

    @Override // tv.chushou.zues.widget.adapterview.c
    public boolean dPh() {
        if (this.nWz == null) {
            this.nWz = new DefaultLoadMoreView(getContext());
        }
        return this.nWy.dE(this.nWz);
    }

    public void setHasMoreItems(boolean z) {
        this.nWB = z;
        if (!z && this.nWy.dE(this.nWz)) {
            this.nWy.dC(this.nWz);
        }
    }

    public void setPullToRefreshEnabled(boolean z) {
        this.nWC = z;
        setEnabled(this.nWC);
    }

    public void completeRefresh() {
        setRefreshing(false);
    }

    public void setPullToRefreshListener(f fVar) {
        this.nWF = fVar;
    }

    @Override // android.support.v4.widget.SwipeRefreshLayout
    @Deprecated
    public void setOnRefreshListener(@Nullable SwipeRefreshLayout.OnRefreshListener onRefreshListener) {
        super.setOnRefreshListener(onRefreshListener);
    }

    public void setLayoutManager(RecyclerView.LayoutManager layoutManager) {
        this.nWy.setLayoutManager(layoutManager);
    }

    public RecyclerView.LayoutManager getLayoutManager() {
        return this.nWy.getLayoutManager();
    }

    public void addItemDecoration(RecyclerView.ItemDecoration itemDecoration) {
        this.nWy.addItemDecoration(itemDecoration);
    }

    public void scrollToPosition(int i) {
        this.nWy.scrollToPosition(i);
    }

    public void setItemDecration(RecyclerView.ItemDecoration itemDecoration) {
        this.nWy.addItemDecoration(itemDecoration);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                this.nWH = false;
                this.startY = motionEvent.getY();
                this.startX = motionEvent.getX();
                break;
            case 2:
                float y = motionEvent.getY();
                float abs = Math.abs(y - this.startY);
                float f = y - this.startY;
                if (abs > this.mTouchSlop && f < 0.0f) {
                    this.nWH = true;
                    break;
                } else {
                    this.nWH = false;
                    break;
                }
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public void setSmallPageSize(int i) {
        this.nWD = i;
    }
}
