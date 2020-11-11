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
    private boolean gkG;
    private float itN;
    private RecyclerView.OnScrollListener mOnScrollListener;
    private ExtendedRecyclerView qnJ;
    private View qnK;
    private b qnL;
    private boolean qnM;
    private boolean qnN;
    private int qnO;
    private int qnP;
    private f qnQ;
    private RecyclerView.OnScrollListener qnR;
    private boolean qnS;
    private float startX;
    private float startY;

    public SwipRefreshRecyclerView(Context context) {
        this(context, null);
    }

    public SwipRefreshRecyclerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.gkG = false;
        this.qnM = true;
        this.qnN = true;
        this.qnO = 9;
        this.qnP = 20;
        this.mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: tv.chushou.zues.widget.adapterview.recyclerview.view.SwipRefreshRecyclerView.3
            private int qnU = -1;

            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i, int i2) {
                boolean z = false;
                super.onScrolled(recyclerView, i, i2);
                if (SwipRefreshRecyclerView.this.qnR != null) {
                    SwipRefreshRecyclerView.this.qnR.onScrolled(recyclerView, i, i2);
                }
                if (SwipRefreshRecyclerView.this.qnJ.getLayoutManager() != null) {
                    this.qnU = a.e(SwipRefreshRecyclerView.this.qnJ.getLayoutManager());
                    if (Build.VERSION.SDK_INT < 21) {
                        int top = (recyclerView == null || recyclerView.getChildCount() == 0) ? 0 : recyclerView.getChildAt(0).getTop();
                        SwipRefreshRecyclerView swipRefreshRecyclerView = SwipRefreshRecyclerView.this;
                        if (top >= recyclerView.getPaddingTop() && SwipRefreshRecyclerView.this.qnN) {
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
                if (SwipRefreshRecyclerView.this.qnR != null) {
                    SwipRefreshRecyclerView.this.qnR.onScrollStateChanged(recyclerView, i);
                }
                RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
                if (layoutManager != null && (adapter = recyclerView.getAdapter()) != null) {
                    int childCount = layoutManager.getChildCount();
                    int itemCount = layoutManager.getItemCount();
                    if (childCount > 0 && i == 0 && this.qnU >= itemCount - 1 && SwipRefreshRecyclerView.this.qnS && !SwipRefreshRecyclerView.this.gkG && SwipRefreshRecyclerView.this.qnM && SwipRefreshRecyclerView.this.qnL != null && adapter.getItemCount() > SwipRefreshRecyclerView.this.qnO) {
                        SwipRefreshRecyclerView.this.qnL.bOI();
                        SwipRefreshRecyclerView.this.gkG = true;
                    }
                }
            }
        };
        this.qnJ = new ExtendedRecyclerView(getContext(), attributeSet);
        this.qnJ.setId(b.e.zues_swiperefresh_recyclerview);
        RecyclerView.ItemAnimator itemAnimator = this.qnJ.getItemAnimator();
        if (itemAnimator instanceof SimpleItemAnimator) {
            ((SimpleItemAnimator) itemAnimator).setSupportsChangeAnimations(false);
        }
        this.qnJ.setHasFixedSize(true);
        addView(this.qnJ, new ViewGroup.LayoutParams(-1, -1));
        setColorSchemeResources(17170452, 17170459, 17170452, 17170459);
        this.qnJ.addOnScrollListener(this.mOnScrollListener);
        super.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() { // from class: tv.chushou.zues.widget.adapterview.recyclerview.view.SwipRefreshRecyclerView.1
            @Override // android.support.v4.widget.SwipeRefreshLayout.OnRefreshListener
            public void onRefresh() {
                if (SwipRefreshRecyclerView.this.qnQ != null) {
                    SwipRefreshRecyclerView.this.qnM = true;
                    tv.chushou.zues.widget.adapterview.recyclerview.a.b adapter = SwipRefreshRecyclerView.this.getAdapter();
                    if (adapter != null) {
                        adapter.eHW();
                    }
                    SwipRefreshRecyclerView.this.qnQ.onRefresh();
                }
            }
        });
        setEnabled(this.qnN);
        if (Build.VERSION.SDK_INT < 21) {
            setCanChildScrollUpCallback(new CustomSwipeRefreshLayout.a() { // from class: tv.chushou.zues.widget.adapterview.recyclerview.view.SwipRefreshRecyclerView.2
                @Override // tv.chushou.zues.widget.adapterview.CustomSwipeRefreshLayout.a
                public boolean eHU() {
                    return SwipRefreshRecyclerView.this.qnJ != null && SwipRefreshRecyclerView.this.qnJ.getScrollY() > 0;
                }
            });
        }
        this.itN = ViewConfiguration.get(context).getScaledTouchSlop();
    }

    public void setOnePageSize(int i) {
        this.qnP = i;
    }

    public ExtendedRecyclerView getInnerRecyclerView() {
        return this.qnJ;
    }

    public void setHasFixedSize(boolean z) {
        this.qnJ.setHasFixedSize(z);
    }

    public void setUpDefault() {
        this.qnJ.setLayoutManager(new LinearLayoutManager(getContext()));
        this.qnK = new DefaultLoadMoreView(getContext());
    }

    public void setAdapter(RecyclerView.Adapter adapter) {
        this.qnJ.setAdapter(adapter);
        if (this.qnL != null) {
            this.qnJ.setLoadMoreProvider(this);
        }
    }

    public tv.chushou.zues.widget.adapterview.recyclerview.a.b getAdapter() {
        return this.qnJ.getAdapter();
    }

    public boolean Sh(int i) {
        return this.qnJ.Sh(i);
    }

    public int getHeaderViewCount() {
        return this.qnJ.getHeaderViewCount();
    }

    public boolean vc(int i) {
        return this.qnJ.vc(i);
    }

    public int getFooterViewCount() {
        return this.qnJ.getFooterViewCount();
    }

    public void setEmptyView(@NonNull View view) {
        this.qnJ.setEmptyView(view);
    }

    @Nullable
    public View getEmptyView() {
        return this.qnJ.getEmptyView();
    }

    public void setLoadMoreListener(tv.chushou.zues.widget.adapterview.b bVar) {
        this.qnL = bVar;
        if (getAdapter() != null) {
            this.qnJ.setLoadMoreProvider(this);
        }
    }

    public void setLoadMoreFooter(@NonNull View view) {
        this.qnK = view;
    }

    public void eHZ() {
        this.gkG = false;
    }

    @Override // tv.chushou.zues.widget.adapterview.c
    public void Sd(int i) {
        if (this.qnM && this.qnJ.getAdapter() != null) {
            if (this.qnK == null) {
                this.qnK = new DefaultLoadMoreView(getContext());
            }
            if (i >= this.qnP) {
                if (!this.qnJ.ek(this.qnK)) {
                    this.qnJ.addFooterView(this.qnK, 0);
                }
            } else if (this.qnJ.ek(this.qnK)) {
                this.qnJ.ei(this.qnK);
            }
            this.gkG = false;
        }
    }

    @Override // tv.chushou.zues.widget.adapterview.c
    public boolean eHV() {
        if (this.qnK == null) {
            this.qnK = new DefaultLoadMoreView(getContext());
        }
        return this.qnJ.ek(this.qnK);
    }

    public void setHasMoreItems(boolean z) {
        this.qnM = z;
        if (!z && this.qnJ.ek(this.qnK)) {
            this.qnJ.ei(this.qnK);
        }
    }

    public void setPullToRefreshEnabled(boolean z) {
        this.qnN = z;
        setEnabled(this.qnN);
    }

    public void completeRefresh() {
        setRefreshing(false);
    }

    public void setPullToRefreshListener(f fVar) {
        this.qnQ = fVar;
    }

    @Override // android.support.v4.widget.SwipeRefreshLayout
    @Deprecated
    public void setOnRefreshListener(@Nullable SwipeRefreshLayout.OnRefreshListener onRefreshListener) {
        super.setOnRefreshListener(onRefreshListener);
    }

    public void setLayoutManager(RecyclerView.LayoutManager layoutManager) {
        this.qnJ.setLayoutManager(layoutManager);
    }

    public RecyclerView.LayoutManager getLayoutManager() {
        return this.qnJ.getLayoutManager();
    }

    public void addItemDecoration(RecyclerView.ItemDecoration itemDecoration) {
        this.qnJ.addItemDecoration(itemDecoration);
    }

    public void scrollToPosition(int i) {
        this.qnJ.scrollToPosition(i);
    }

    public void setItemDecration(RecyclerView.ItemDecoration itemDecoration) {
        this.qnJ.addItemDecoration(itemDecoration);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                this.qnS = false;
                this.startY = motionEvent.getY();
                this.startX = motionEvent.getX();
                break;
            case 2:
                float y = motionEvent.getY();
                float abs = Math.abs(y - this.startY);
                float f = y - this.startY;
                if (abs > this.itN && f < 0.0f) {
                    this.qnS = true;
                    break;
                } else {
                    this.qnS = false;
                    break;
                }
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public void setSmallPageSize(int i) {
        this.qnO = i;
    }
}
