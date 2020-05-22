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
    private boolean fdk;
    private float gZN;
    private RecyclerView.OnScrollListener mOnScrollListener;
    private ExtendedRecyclerView nOm;
    private View nOn;
    private b nOo;
    private boolean nOp;
    private boolean nOq;
    private int nOr;
    private int nOs;
    private f nOt;
    private RecyclerView.OnScrollListener nOu;
    private boolean nOv;
    private float startX;
    private float startY;

    public SwipRefreshRecyclerView(Context context) {
        this(context, null);
    }

    public SwipRefreshRecyclerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fdk = false;
        this.nOp = true;
        this.nOq = true;
        this.nOr = 9;
        this.nOs = 20;
        this.mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: tv.chushou.zues.widget.adapterview.recyclerview.view.SwipRefreshRecyclerView.3
            private int nOx = -1;

            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i, int i2) {
                boolean z = false;
                super.onScrolled(recyclerView, i, i2);
                if (SwipRefreshRecyclerView.this.nOu != null) {
                    SwipRefreshRecyclerView.this.nOu.onScrolled(recyclerView, i, i2);
                }
                if (SwipRefreshRecyclerView.this.nOm.getLayoutManager() != null) {
                    this.nOx = a.e(SwipRefreshRecyclerView.this.nOm.getLayoutManager());
                    if (Build.VERSION.SDK_INT < 21) {
                        int top2 = (recyclerView == null || recyclerView.getChildCount() == 0) ? 0 : recyclerView.getChildAt(0).getTop();
                        SwipRefreshRecyclerView swipRefreshRecyclerView = SwipRefreshRecyclerView.this;
                        if (top2 >= recyclerView.getPaddingTop() && SwipRefreshRecyclerView.this.nOq) {
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
                if (SwipRefreshRecyclerView.this.nOu != null) {
                    SwipRefreshRecyclerView.this.nOu.onScrollStateChanged(recyclerView, i);
                }
                RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
                if (layoutManager != null && (adapter = recyclerView.getAdapter()) != null) {
                    int childCount = layoutManager.getChildCount();
                    int itemCount = layoutManager.getItemCount();
                    if (childCount > 0 && i == 0 && this.nOx >= itemCount - 1 && SwipRefreshRecyclerView.this.nOv && !SwipRefreshRecyclerView.this.fdk && SwipRefreshRecyclerView.this.nOp && SwipRefreshRecyclerView.this.nOo != null && adapter.getItemCount() > SwipRefreshRecyclerView.this.nOr) {
                        SwipRefreshRecyclerView.this.nOo.bqv();
                        SwipRefreshRecyclerView.this.fdk = true;
                    }
                }
            }
        };
        this.nOm = new ExtendedRecyclerView(getContext(), attributeSet);
        this.nOm.setId(b.e.zues_swiperefresh_recyclerview);
        RecyclerView.ItemAnimator itemAnimator = this.nOm.getItemAnimator();
        if (itemAnimator instanceof SimpleItemAnimator) {
            ((SimpleItemAnimator) itemAnimator).setSupportsChangeAnimations(false);
        }
        this.nOm.setHasFixedSize(true);
        addView(this.nOm, new ViewGroup.LayoutParams(-1, -1));
        setColorSchemeResources(17170452, 17170459, 17170452, 17170459);
        this.nOm.addOnScrollListener(this.mOnScrollListener);
        super.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() { // from class: tv.chushou.zues.widget.adapterview.recyclerview.view.SwipRefreshRecyclerView.1
            @Override // android.support.v4.widget.SwipeRefreshLayout.OnRefreshListener
            public void onRefresh() {
                if (SwipRefreshRecyclerView.this.nOt != null) {
                    SwipRefreshRecyclerView.this.nOp = true;
                    tv.chushou.zues.widget.adapterview.recyclerview.a.b adapter = SwipRefreshRecyclerView.this.getAdapter();
                    if (adapter != null) {
                        adapter.dRT();
                    }
                    SwipRefreshRecyclerView.this.nOt.onRefresh();
                }
            }
        });
        setEnabled(this.nOq);
        if (Build.VERSION.SDK_INT < 21) {
            setCanChildScrollUpCallback(new CustomSwipeRefreshLayout.a() { // from class: tv.chushou.zues.widget.adapterview.recyclerview.view.SwipRefreshRecyclerView.2
                @Override // tv.chushou.zues.widget.adapterview.CustomSwipeRefreshLayout.a
                public boolean dRR() {
                    return SwipRefreshRecyclerView.this.nOm != null && SwipRefreshRecyclerView.this.nOm.getScrollY() > 0;
                }
            });
        }
        this.gZN = ViewConfiguration.get(context).getScaledTouchSlop();
    }

    public void setOnePageSize(int i) {
        this.nOs = i;
    }

    public ExtendedRecyclerView getInnerRecyclerView() {
        return this.nOm;
    }

    public void setHasFixedSize(boolean z) {
        this.nOm.setHasFixedSize(z);
    }

    public void setUpDefault() {
        this.nOm.setLayoutManager(new LinearLayoutManager(getContext()));
        this.nOn = new DefaultLoadMoreView(getContext());
    }

    public void setAdapter(RecyclerView.Adapter adapter) {
        this.nOm.setAdapter(adapter);
        if (this.nOo != null) {
            this.nOm.setLoadMoreProvider(this);
        }
    }

    public tv.chushou.zues.widget.adapterview.recyclerview.a.b getAdapter() {
        return this.nOm.getAdapter();
    }

    public boolean KF(int i) {
        return this.nOm.KF(i);
    }

    public int getHeaderViewCount() {
        return this.nOm.getHeaderViewCount();
    }

    public boolean KG(int i) {
        return this.nOm.KG(i);
    }

    public int getFooterViewCount() {
        return this.nOm.getFooterViewCount();
    }

    public void setEmptyView(@NonNull View view) {
        this.nOm.setEmptyView(view);
    }

    @Nullable
    public View getEmptyView() {
        return this.nOm.getEmptyView();
    }

    public void setLoadMoreListener(tv.chushou.zues.widget.adapterview.b bVar) {
        this.nOo = bVar;
        if (getAdapter() != null) {
            this.nOm.setLoadMoreProvider(this);
        }
    }

    public void setLoadMoreFooter(@NonNull View view) {
        this.nOn = view;
    }

    public void dRW() {
        this.fdk = false;
    }

    @Override // tv.chushou.zues.widget.adapterview.c
    public void KA(int i) {
        if (this.nOp && this.nOm.getAdapter() != null) {
            if (this.nOn == null) {
                this.nOn = new DefaultLoadMoreView(getContext());
            }
            if (i >= this.nOs) {
                if (!this.nOm.dy(this.nOn)) {
                    this.nOm.addFooterView(this.nOn, 0);
                }
            } else if (this.nOm.dy(this.nOn)) {
                this.nOm.dw(this.nOn);
            }
            this.fdk = false;
        }
    }

    @Override // tv.chushou.zues.widget.adapterview.c
    public boolean dRS() {
        if (this.nOn == null) {
            this.nOn = new DefaultLoadMoreView(getContext());
        }
        return this.nOm.dy(this.nOn);
    }

    public void setHasMoreItems(boolean z) {
        this.nOp = z;
        if (!z && this.nOm.dy(this.nOn)) {
            this.nOm.dw(this.nOn);
        }
    }

    public void setPullToRefreshEnabled(boolean z) {
        this.nOq = z;
        setEnabled(this.nOq);
    }

    public void completeRefresh() {
        setRefreshing(false);
    }

    public void setPullToRefreshListener(f fVar) {
        this.nOt = fVar;
    }

    @Override // android.support.v4.widget.SwipeRefreshLayout
    @Deprecated
    public void setOnRefreshListener(@Nullable SwipeRefreshLayout.OnRefreshListener onRefreshListener) {
        super.setOnRefreshListener(onRefreshListener);
    }

    public void setLayoutManager(RecyclerView.LayoutManager layoutManager) {
        this.nOm.setLayoutManager(layoutManager);
    }

    public RecyclerView.LayoutManager getLayoutManager() {
        return this.nOm.getLayoutManager();
    }

    public void addItemDecoration(RecyclerView.ItemDecoration itemDecoration) {
        this.nOm.addItemDecoration(itemDecoration);
    }

    public void scrollToPosition(int i) {
        this.nOm.scrollToPosition(i);
    }

    public void setItemDecration(RecyclerView.ItemDecoration itemDecoration) {
        this.nOm.addItemDecoration(itemDecoration);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                this.nOv = false;
                this.startY = motionEvent.getY();
                this.startX = motionEvent.getX();
                break;
            case 2:
                float y = motionEvent.getY();
                float abs = Math.abs(y - this.startY);
                float f = y - this.startY;
                if (abs > this.gZN && f < 0.0f) {
                    this.nOv = true;
                    break;
                } else {
                    this.nOv = false;
                    break;
                }
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public void setSmallPageSize(int i) {
        this.nOr = i;
    }
}
