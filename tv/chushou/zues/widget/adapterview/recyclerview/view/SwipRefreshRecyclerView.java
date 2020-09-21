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
    private boolean fIz;
    private float hMt;
    private RecyclerView.OnScrollListener mOnScrollListener;
    private ExtendedRecyclerView oXG;
    private View oXH;
    private b oXI;
    private boolean oXJ;
    private boolean oXK;
    private int oXL;
    private int oXM;
    private f oXN;
    private RecyclerView.OnScrollListener oXO;
    private boolean oXP;
    private float startX;
    private float startY;

    public SwipRefreshRecyclerView(Context context) {
        this(context, null);
    }

    public SwipRefreshRecyclerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fIz = false;
        this.oXJ = true;
        this.oXK = true;
        this.oXL = 9;
        this.oXM = 20;
        this.mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: tv.chushou.zues.widget.adapterview.recyclerview.view.SwipRefreshRecyclerView.3
            private int oXR = -1;

            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i, int i2) {
                boolean z = false;
                super.onScrolled(recyclerView, i, i2);
                if (SwipRefreshRecyclerView.this.oXO != null) {
                    SwipRefreshRecyclerView.this.oXO.onScrolled(recyclerView, i, i2);
                }
                if (SwipRefreshRecyclerView.this.oXG.getLayoutManager() != null) {
                    this.oXR = a.e(SwipRefreshRecyclerView.this.oXG.getLayoutManager());
                    if (Build.VERSION.SDK_INT < 21) {
                        int top = (recyclerView == null || recyclerView.getChildCount() == 0) ? 0 : recyclerView.getChildAt(0).getTop();
                        SwipRefreshRecyclerView swipRefreshRecyclerView = SwipRefreshRecyclerView.this;
                        if (top >= recyclerView.getPaddingTop() && SwipRefreshRecyclerView.this.oXK) {
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
                if (SwipRefreshRecyclerView.this.oXO != null) {
                    SwipRefreshRecyclerView.this.oXO.onScrollStateChanged(recyclerView, i);
                }
                RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
                if (layoutManager != null && (adapter = recyclerView.getAdapter()) != null) {
                    int childCount = layoutManager.getChildCount();
                    int itemCount = layoutManager.getItemCount();
                    if (childCount > 0 && i == 0 && this.oXR >= itemCount - 1 && SwipRefreshRecyclerView.this.oXP && !SwipRefreshRecyclerView.this.fIz && SwipRefreshRecyclerView.this.oXJ && SwipRefreshRecyclerView.this.oXI != null && adapter.getItemCount() > SwipRefreshRecyclerView.this.oXL) {
                        SwipRefreshRecyclerView.this.oXI.bGU();
                        SwipRefreshRecyclerView.this.fIz = true;
                    }
                }
            }
        };
        this.oXG = new ExtendedRecyclerView(getContext(), attributeSet);
        this.oXG.setId(b.e.zues_swiperefresh_recyclerview);
        RecyclerView.ItemAnimator itemAnimator = this.oXG.getItemAnimator();
        if (itemAnimator instanceof SimpleItemAnimator) {
            ((SimpleItemAnimator) itemAnimator).setSupportsChangeAnimations(false);
        }
        this.oXG.setHasFixedSize(true);
        addView(this.oXG, new ViewGroup.LayoutParams(-1, -1));
        setColorSchemeResources(17170452, 17170459, 17170452, 17170459);
        this.oXG.addOnScrollListener(this.mOnScrollListener);
        super.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() { // from class: tv.chushou.zues.widget.adapterview.recyclerview.view.SwipRefreshRecyclerView.1
            @Override // android.support.v4.widget.SwipeRefreshLayout.OnRefreshListener
            public void onRefresh() {
                if (SwipRefreshRecyclerView.this.oXN != null) {
                    SwipRefreshRecyclerView.this.oXJ = true;
                    tv.chushou.zues.widget.adapterview.recyclerview.a.b adapter = SwipRefreshRecyclerView.this.getAdapter();
                    if (adapter != null) {
                        adapter.eqy();
                    }
                    SwipRefreshRecyclerView.this.oXN.onRefresh();
                }
            }
        });
        setEnabled(this.oXK);
        if (Build.VERSION.SDK_INT < 21) {
            setCanChildScrollUpCallback(new CustomSwipeRefreshLayout.a() { // from class: tv.chushou.zues.widget.adapterview.recyclerview.view.SwipRefreshRecyclerView.2
                @Override // tv.chushou.zues.widget.adapterview.CustomSwipeRefreshLayout.a
                public boolean eqw() {
                    return SwipRefreshRecyclerView.this.oXG != null && SwipRefreshRecyclerView.this.oXG.getScrollY() > 0;
                }
            });
        }
        this.hMt = ViewConfiguration.get(context).getScaledTouchSlop();
    }

    public void setOnePageSize(int i) {
        this.oXM = i;
    }

    public ExtendedRecyclerView getInnerRecyclerView() {
        return this.oXG;
    }

    public void setHasFixedSize(boolean z) {
        this.oXG.setHasFixedSize(z);
    }

    public void setUpDefault() {
        this.oXG.setLayoutManager(new LinearLayoutManager(getContext()));
        this.oXH = new DefaultLoadMoreView(getContext());
    }

    public void setAdapter(RecyclerView.Adapter adapter) {
        this.oXG.setAdapter(adapter);
        if (this.oXI != null) {
            this.oXG.setLoadMoreProvider(this);
        }
    }

    public tv.chushou.zues.widget.adapterview.recyclerview.a.b getAdapter() {
        return this.oXG.getAdapter();
    }

    public boolean Pp(int i) {
        return this.oXG.Pp(i);
    }

    public int getHeaderViewCount() {
        return this.oXG.getHeaderViewCount();
    }

    public boolean Pq(int i) {
        return this.oXG.Pq(i);
    }

    public int getFooterViewCount() {
        return this.oXG.getFooterViewCount();
    }

    public void setEmptyView(@NonNull View view) {
        this.oXG.setEmptyView(view);
    }

    @Nullable
    public View getEmptyView() {
        return this.oXG.getEmptyView();
    }

    public void setLoadMoreListener(tv.chushou.zues.widget.adapterview.b bVar) {
        this.oXI = bVar;
        if (getAdapter() != null) {
            this.oXG.setLoadMoreProvider(this);
        }
    }

    public void setLoadMoreFooter(@NonNull View view) {
        this.oXH = view;
    }

    public void eqB() {
        this.fIz = false;
    }

    @Override // tv.chushou.zues.widget.adapterview.c
    public void Pl(int i) {
        if (this.oXJ && this.oXG.getAdapter() != null) {
            if (this.oXH == null) {
                this.oXH = new DefaultLoadMoreView(getContext());
            }
            if (i >= this.oXM) {
                if (!this.oXG.dQ(this.oXH)) {
                    this.oXG.addFooterView(this.oXH, 0);
                }
            } else if (this.oXG.dQ(this.oXH)) {
                this.oXG.dO(this.oXH);
            }
            this.fIz = false;
        }
    }

    @Override // tv.chushou.zues.widget.adapterview.c
    public boolean eqx() {
        if (this.oXH == null) {
            this.oXH = new DefaultLoadMoreView(getContext());
        }
        return this.oXG.dQ(this.oXH);
    }

    public void setHasMoreItems(boolean z) {
        this.oXJ = z;
        if (!z && this.oXG.dQ(this.oXH)) {
            this.oXG.dO(this.oXH);
        }
    }

    public void setPullToRefreshEnabled(boolean z) {
        this.oXK = z;
        setEnabled(this.oXK);
    }

    public void completeRefresh() {
        setRefreshing(false);
    }

    public void setPullToRefreshListener(f fVar) {
        this.oXN = fVar;
    }

    @Override // android.support.v4.widget.SwipeRefreshLayout
    @Deprecated
    public void setOnRefreshListener(@Nullable SwipeRefreshLayout.OnRefreshListener onRefreshListener) {
        super.setOnRefreshListener(onRefreshListener);
    }

    public void setLayoutManager(RecyclerView.LayoutManager layoutManager) {
        this.oXG.setLayoutManager(layoutManager);
    }

    public RecyclerView.LayoutManager getLayoutManager() {
        return this.oXG.getLayoutManager();
    }

    public void addItemDecoration(RecyclerView.ItemDecoration itemDecoration) {
        this.oXG.addItemDecoration(itemDecoration);
    }

    public void scrollToPosition(int i) {
        this.oXG.scrollToPosition(i);
    }

    public void setItemDecration(RecyclerView.ItemDecoration itemDecoration) {
        this.oXG.addItemDecoration(itemDecoration);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                this.oXP = false;
                this.startY = motionEvent.getY();
                this.startX = motionEvent.getX();
                break;
            case 2:
                float y = motionEvent.getY();
                float abs = Math.abs(y - this.startY);
                float f = y - this.startY;
                if (abs > this.hMt && f < 0.0f) {
                    this.oXP = true;
                    break;
                } else {
                    this.oXP = false;
                    break;
                }
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public void setSmallPageSize(int i) {
        this.oXL = i;
    }
}
