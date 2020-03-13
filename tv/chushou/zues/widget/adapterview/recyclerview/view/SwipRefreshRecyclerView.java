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
    private boolean emG;
    private RecyclerView.OnScrollListener mOnScrollListener;
    private float mTouchSlop;
    private ExtendedRecyclerView nXF;
    private View nXG;
    private b nXH;
    private boolean nXI;
    private boolean nXJ;
    private int nXK;
    private int nXL;
    private f nXM;
    private RecyclerView.OnScrollListener nXN;
    private boolean nXO;
    private float startX;
    private float startY;

    public SwipRefreshRecyclerView(Context context) {
        this(context, null);
    }

    public SwipRefreshRecyclerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.emG = false;
        this.nXI = true;
        this.nXJ = true;
        this.nXK = 9;
        this.nXL = 20;
        this.mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: tv.chushou.zues.widget.adapterview.recyclerview.view.SwipRefreshRecyclerView.3
            private int nXQ = -1;

            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i, int i2) {
                boolean z = false;
                super.onScrolled(recyclerView, i, i2);
                if (SwipRefreshRecyclerView.this.nXN != null) {
                    SwipRefreshRecyclerView.this.nXN.onScrolled(recyclerView, i, i2);
                }
                if (SwipRefreshRecyclerView.this.nXF.getLayoutManager() != null) {
                    this.nXQ = a.e(SwipRefreshRecyclerView.this.nXF.getLayoutManager());
                    if (Build.VERSION.SDK_INT < 21) {
                        int top2 = (recyclerView == null || recyclerView.getChildCount() == 0) ? 0 : recyclerView.getChildAt(0).getTop();
                        SwipRefreshRecyclerView swipRefreshRecyclerView = SwipRefreshRecyclerView.this;
                        if (top2 >= recyclerView.getPaddingTop() && SwipRefreshRecyclerView.this.nXJ) {
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
                if (SwipRefreshRecyclerView.this.nXN != null) {
                    SwipRefreshRecyclerView.this.nXN.onScrollStateChanged(recyclerView, i);
                }
                RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
                if (layoutManager != null && (adapter = recyclerView.getAdapter()) != null) {
                    int childCount = layoutManager.getChildCount();
                    int itemCount = layoutManager.getItemCount();
                    if (childCount > 0 && i == 0 && this.nXQ >= itemCount - 1 && SwipRefreshRecyclerView.this.nXO && !SwipRefreshRecyclerView.this.emG && SwipRefreshRecyclerView.this.nXI && SwipRefreshRecyclerView.this.nXH != null && adapter.getItemCount() > SwipRefreshRecyclerView.this.nXK) {
                        SwipRefreshRecyclerView.this.nXH.bcg();
                        SwipRefreshRecyclerView.this.emG = true;
                    }
                }
            }
        };
        this.nXF = new ExtendedRecyclerView(getContext(), attributeSet);
        this.nXF.setId(b.e.zues_swiperefresh_recyclerview);
        RecyclerView.ItemAnimator itemAnimator = this.nXF.getItemAnimator();
        if (itemAnimator instanceof SimpleItemAnimator) {
            ((SimpleItemAnimator) itemAnimator).setSupportsChangeAnimations(false);
        }
        this.nXF.setHasFixedSize(true);
        addView(this.nXF, new ViewGroup.LayoutParams(-1, -1));
        setColorSchemeResources(17170452, 17170459, 17170452, 17170459);
        this.nXF.addOnScrollListener(this.mOnScrollListener);
        super.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() { // from class: tv.chushou.zues.widget.adapterview.recyclerview.view.SwipRefreshRecyclerView.1
            @Override // android.support.v4.widget.SwipeRefreshLayout.OnRefreshListener
            public void onRefresh() {
                if (SwipRefreshRecyclerView.this.nXM != null) {
                    SwipRefreshRecyclerView.this.nXI = true;
                    tv.chushou.zues.widget.adapterview.recyclerview.a.b adapter = SwipRefreshRecyclerView.this.getAdapter();
                    if (adapter != null) {
                        adapter.dQA();
                    }
                    SwipRefreshRecyclerView.this.nXM.onRefresh();
                }
            }
        });
        setEnabled(this.nXJ);
        if (Build.VERSION.SDK_INT < 21) {
            setCanChildScrollUpCallback(new CustomSwipeRefreshLayout.a() { // from class: tv.chushou.zues.widget.adapterview.recyclerview.view.SwipRefreshRecyclerView.2
                @Override // tv.chushou.zues.widget.adapterview.CustomSwipeRefreshLayout.a
                public boolean dQy() {
                    return SwipRefreshRecyclerView.this.nXF != null && SwipRefreshRecyclerView.this.nXF.getScrollY() > 0;
                }
            });
        }
        this.mTouchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
    }

    public void setOnePageSize(int i) {
        this.nXL = i;
    }

    public ExtendedRecyclerView getInnerRecyclerView() {
        return this.nXF;
    }

    public void setHasFixedSize(boolean z) {
        this.nXF.setHasFixedSize(z);
    }

    public void setUpDefault() {
        this.nXF.setLayoutManager(new LinearLayoutManager(getContext()));
        this.nXG = new DefaultLoadMoreView(getContext());
    }

    public void setAdapter(RecyclerView.Adapter adapter) {
        this.nXF.setAdapter(adapter);
        if (this.nXH != null) {
            this.nXF.setLoadMoreProvider(this);
        }
    }

    public tv.chushou.zues.widget.adapterview.recyclerview.a.b getAdapter() {
        return this.nXF.getAdapter();
    }

    public boolean Os(int i) {
        return this.nXF.Os(i);
    }

    public int getHeaderViewCount() {
        return this.nXF.getHeaderViewCount();
    }

    public boolean Ot(int i) {
        return this.nXF.Ot(i);
    }

    public int getFooterViewCount() {
        return this.nXF.getFooterViewCount();
    }

    public void setEmptyView(@NonNull View view) {
        this.nXF.setEmptyView(view);
    }

    @Nullable
    public View getEmptyView() {
        return this.nXF.getEmptyView();
    }

    public void setLoadMoreListener(tv.chushou.zues.widget.adapterview.b bVar) {
        this.nXH = bVar;
        if (getAdapter() != null) {
            this.nXF.setLoadMoreProvider(this);
        }
    }

    public void setLoadMoreFooter(@NonNull View view) {
        this.nXG = view;
    }

    public void dQD() {
        this.emG = false;
    }

    @Override // tv.chushou.zues.widget.adapterview.c
    public void On(int i) {
        if (this.nXI && this.nXF.getAdapter() != null) {
            if (this.nXG == null) {
                this.nXG = new DefaultLoadMoreView(getContext());
            }
            if (i >= this.nXL) {
                if (!this.nXF.dG(this.nXG)) {
                    this.nXF.addFooterView(this.nXG, 0);
                }
            } else if (this.nXF.dG(this.nXG)) {
                this.nXF.dE(this.nXG);
            }
            this.emG = false;
        }
    }

    @Override // tv.chushou.zues.widget.adapterview.c
    public boolean dQz() {
        if (this.nXG == null) {
            this.nXG = new DefaultLoadMoreView(getContext());
        }
        return this.nXF.dG(this.nXG);
    }

    public void setHasMoreItems(boolean z) {
        this.nXI = z;
        if (!z && this.nXF.dG(this.nXG)) {
            this.nXF.dE(this.nXG);
        }
    }

    public void setPullToRefreshEnabled(boolean z) {
        this.nXJ = z;
        setEnabled(this.nXJ);
    }

    public void completeRefresh() {
        setRefreshing(false);
    }

    public void setPullToRefreshListener(f fVar) {
        this.nXM = fVar;
    }

    @Override // android.support.v4.widget.SwipeRefreshLayout
    @Deprecated
    public void setOnRefreshListener(@Nullable SwipeRefreshLayout.OnRefreshListener onRefreshListener) {
        super.setOnRefreshListener(onRefreshListener);
    }

    public void setLayoutManager(RecyclerView.LayoutManager layoutManager) {
        this.nXF.setLayoutManager(layoutManager);
    }

    public RecyclerView.LayoutManager getLayoutManager() {
        return this.nXF.getLayoutManager();
    }

    public void addItemDecoration(RecyclerView.ItemDecoration itemDecoration) {
        this.nXF.addItemDecoration(itemDecoration);
    }

    public void scrollToPosition(int i) {
        this.nXF.scrollToPosition(i);
    }

    public void setItemDecration(RecyclerView.ItemDecoration itemDecoration) {
        this.nXF.addItemDecoration(itemDecoration);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                this.nXO = false;
                this.startY = motionEvent.getY();
                this.startX = motionEvent.getX();
                break;
            case 2:
                float y = motionEvent.getY();
                float abs = Math.abs(y - this.startY);
                float f = y - this.startY;
                if (abs > this.mTouchSlop && f < 0.0f) {
                    this.nXO = true;
                    break;
                } else {
                    this.nXO = false;
                    break;
                }
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public void setSmallPageSize(int i) {
        this.nXK = i;
    }
}
