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
    private boolean foF;
    private float hmk;
    private RecyclerView.OnScrollListener mOnScrollListener;
    private ExtendedRecyclerView oln;
    private View olo;
    private b olp;
    private boolean olq;
    private boolean olr;
    private int ols;
    private int olt;
    private f olu;
    private RecyclerView.OnScrollListener olv;
    private boolean olw;
    private float startX;
    private float startY;

    public SwipRefreshRecyclerView(Context context) {
        this(context, null);
    }

    public SwipRefreshRecyclerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.foF = false;
        this.olq = true;
        this.olr = true;
        this.ols = 9;
        this.olt = 20;
        this.mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: tv.chushou.zues.widget.adapterview.recyclerview.view.SwipRefreshRecyclerView.3
            private int oly = -1;

            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i, int i2) {
                boolean z = false;
                super.onScrolled(recyclerView, i, i2);
                if (SwipRefreshRecyclerView.this.olv != null) {
                    SwipRefreshRecyclerView.this.olv.onScrolled(recyclerView, i, i2);
                }
                if (SwipRefreshRecyclerView.this.oln.getLayoutManager() != null) {
                    this.oly = a.e(SwipRefreshRecyclerView.this.oln.getLayoutManager());
                    if (Build.VERSION.SDK_INT < 21) {
                        int top2 = (recyclerView == null || recyclerView.getChildCount() == 0) ? 0 : recyclerView.getChildAt(0).getTop();
                        SwipRefreshRecyclerView swipRefreshRecyclerView = SwipRefreshRecyclerView.this;
                        if (top2 >= recyclerView.getPaddingTop() && SwipRefreshRecyclerView.this.olr) {
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
                if (SwipRefreshRecyclerView.this.olv != null) {
                    SwipRefreshRecyclerView.this.olv.onScrollStateChanged(recyclerView, i);
                }
                RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
                if (layoutManager != null && (adapter = recyclerView.getAdapter()) != null) {
                    int childCount = layoutManager.getChildCount();
                    int itemCount = layoutManager.getItemCount();
                    if (childCount > 0 && i == 0 && this.oly >= itemCount - 1 && SwipRefreshRecyclerView.this.olw && !SwipRefreshRecyclerView.this.foF && SwipRefreshRecyclerView.this.olq && SwipRefreshRecyclerView.this.olp != null && adapter.getItemCount() > SwipRefreshRecyclerView.this.ols) {
                        SwipRefreshRecyclerView.this.olp.btv();
                        SwipRefreshRecyclerView.this.foF = true;
                    }
                }
            }
        };
        this.oln = new ExtendedRecyclerView(getContext(), attributeSet);
        this.oln.setId(b.e.zues_swiperefresh_recyclerview);
        RecyclerView.ItemAnimator itemAnimator = this.oln.getItemAnimator();
        if (itemAnimator instanceof SimpleItemAnimator) {
            ((SimpleItemAnimator) itemAnimator).setSupportsChangeAnimations(false);
        }
        this.oln.setHasFixedSize(true);
        addView(this.oln, new ViewGroup.LayoutParams(-1, -1));
        setColorSchemeResources(17170452, 17170459, 17170452, 17170459);
        this.oln.addOnScrollListener(this.mOnScrollListener);
        super.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() { // from class: tv.chushou.zues.widget.adapterview.recyclerview.view.SwipRefreshRecyclerView.1
            @Override // android.support.v4.widget.SwipeRefreshLayout.OnRefreshListener
            public void onRefresh() {
                if (SwipRefreshRecyclerView.this.olu != null) {
                    SwipRefreshRecyclerView.this.olq = true;
                    tv.chushou.zues.widget.adapterview.recyclerview.a.b adapter = SwipRefreshRecyclerView.this.getAdapter();
                    if (adapter != null) {
                        adapter.dWR();
                    }
                    SwipRefreshRecyclerView.this.olu.onRefresh();
                }
            }
        });
        setEnabled(this.olr);
        if (Build.VERSION.SDK_INT < 21) {
            setCanChildScrollUpCallback(new CustomSwipeRefreshLayout.a() { // from class: tv.chushou.zues.widget.adapterview.recyclerview.view.SwipRefreshRecyclerView.2
                @Override // tv.chushou.zues.widget.adapterview.CustomSwipeRefreshLayout.a
                public boolean dWP() {
                    return SwipRefreshRecyclerView.this.oln != null && SwipRefreshRecyclerView.this.oln.getScrollY() > 0;
                }
            });
        }
        this.hmk = ViewConfiguration.get(context).getScaledTouchSlop();
    }

    public void setOnePageSize(int i) {
        this.olt = i;
    }

    public ExtendedRecyclerView getInnerRecyclerView() {
        return this.oln;
    }

    public void setHasFixedSize(boolean z) {
        this.oln.setHasFixedSize(z);
    }

    public void setUpDefault() {
        this.oln.setLayoutManager(new LinearLayoutManager(getContext()));
        this.olo = new DefaultLoadMoreView(getContext());
    }

    public void setAdapter(RecyclerView.Adapter adapter) {
        this.oln.setAdapter(adapter);
        if (this.olp != null) {
            this.oln.setLoadMoreProvider(this);
        }
    }

    public tv.chushou.zues.widget.adapterview.recyclerview.a.b getAdapter() {
        return this.oln.getAdapter();
    }

    public boolean LN(int i) {
        return this.oln.LN(i);
    }

    public int getHeaderViewCount() {
        return this.oln.getHeaderViewCount();
    }

    public boolean LO(int i) {
        return this.oln.LO(i);
    }

    public int getFooterViewCount() {
        return this.oln.getFooterViewCount();
    }

    public void setEmptyView(@NonNull View view) {
        this.oln.setEmptyView(view);
    }

    @Nullable
    public View getEmptyView() {
        return this.oln.getEmptyView();
    }

    public void setLoadMoreListener(tv.chushou.zues.widget.adapterview.b bVar) {
        this.olp = bVar;
        if (getAdapter() != null) {
            this.oln.setLoadMoreProvider(this);
        }
    }

    public void setLoadMoreFooter(@NonNull View view) {
        this.olo = view;
    }

    public void dWU() {
        this.foF = false;
    }

    @Override // tv.chushou.zues.widget.adapterview.c
    public void LJ(int i) {
        if (this.olq && this.oln.getAdapter() != null) {
            if (this.olo == null) {
                this.olo = new DefaultLoadMoreView(getContext());
            }
            if (i >= this.olt) {
                if (!this.oln.dz(this.olo)) {
                    this.oln.addFooterView(this.olo, 0);
                }
            } else if (this.oln.dz(this.olo)) {
                this.oln.dx(this.olo);
            }
            this.foF = false;
        }
    }

    @Override // tv.chushou.zues.widget.adapterview.c
    public boolean dWQ() {
        if (this.olo == null) {
            this.olo = new DefaultLoadMoreView(getContext());
        }
        return this.oln.dz(this.olo);
    }

    public void setHasMoreItems(boolean z) {
        this.olq = z;
        if (!z && this.oln.dz(this.olo)) {
            this.oln.dx(this.olo);
        }
    }

    public void setPullToRefreshEnabled(boolean z) {
        this.olr = z;
        setEnabled(this.olr);
    }

    public void completeRefresh() {
        setRefreshing(false);
    }

    public void setPullToRefreshListener(f fVar) {
        this.olu = fVar;
    }

    @Override // android.support.v4.widget.SwipeRefreshLayout
    @Deprecated
    public void setOnRefreshListener(@Nullable SwipeRefreshLayout.OnRefreshListener onRefreshListener) {
        super.setOnRefreshListener(onRefreshListener);
    }

    public void setLayoutManager(RecyclerView.LayoutManager layoutManager) {
        this.oln.setLayoutManager(layoutManager);
    }

    public RecyclerView.LayoutManager getLayoutManager() {
        return this.oln.getLayoutManager();
    }

    public void addItemDecoration(RecyclerView.ItemDecoration itemDecoration) {
        this.oln.addItemDecoration(itemDecoration);
    }

    public void scrollToPosition(int i) {
        this.oln.scrollToPosition(i);
    }

    public void setItemDecration(RecyclerView.ItemDecoration itemDecoration) {
        this.oln.addItemDecoration(itemDecoration);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                this.olw = false;
                this.startY = motionEvent.getY();
                this.startX = motionEvent.getX();
                break;
            case 2:
                float y = motionEvent.getY();
                float abs = Math.abs(y - this.startY);
                float f = y - this.startY;
                if (abs > this.hmk && f < 0.0f) {
                    this.olw = true;
                    break;
                } else {
                    this.olw = false;
                    break;
                }
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public void setSmallPageSize(int i) {
        this.ols = i;
    }
}
