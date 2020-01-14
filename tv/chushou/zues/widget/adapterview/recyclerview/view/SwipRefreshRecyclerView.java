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
    private ExtendedRecyclerView nWD;
    private View nWE;
    private b nWF;
    private boolean nWG;
    private boolean nWH;
    private int nWI;
    private int nWJ;
    private f nWK;
    private RecyclerView.OnScrollListener nWL;
    private boolean nWM;
    private float startX;
    private float startY;

    public SwipRefreshRecyclerView(Context context) {
        this(context, null);
    }

    public SwipRefreshRecyclerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.eil = false;
        this.nWG = true;
        this.nWH = true;
        this.nWI = 9;
        this.nWJ = 20;
        this.mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: tv.chushou.zues.widget.adapterview.recyclerview.view.SwipRefreshRecyclerView.3
            private int nWO = -1;

            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i, int i2) {
                boolean z = false;
                super.onScrolled(recyclerView, i, i2);
                if (SwipRefreshRecyclerView.this.nWL != null) {
                    SwipRefreshRecyclerView.this.nWL.onScrolled(recyclerView, i, i2);
                }
                if (SwipRefreshRecyclerView.this.nWD.getLayoutManager() != null) {
                    this.nWO = a.e(SwipRefreshRecyclerView.this.nWD.getLayoutManager());
                    if (Build.VERSION.SDK_INT < 21) {
                        int top = (recyclerView == null || recyclerView.getChildCount() == 0) ? 0 : recyclerView.getChildAt(0).getTop();
                        SwipRefreshRecyclerView swipRefreshRecyclerView = SwipRefreshRecyclerView.this;
                        if (top >= recyclerView.getPaddingTop() && SwipRefreshRecyclerView.this.nWH) {
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
                if (SwipRefreshRecyclerView.this.nWL != null) {
                    SwipRefreshRecyclerView.this.nWL.onScrollStateChanged(recyclerView, i);
                }
                RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
                if (layoutManager != null && (adapter = recyclerView.getAdapter()) != null) {
                    int childCount = layoutManager.getChildCount();
                    int itemCount = layoutManager.getItemCount();
                    if (childCount > 0 && i == 0 && this.nWO >= itemCount - 1 && SwipRefreshRecyclerView.this.nWM && !SwipRefreshRecyclerView.this.eil && SwipRefreshRecyclerView.this.nWG && SwipRefreshRecyclerView.this.nWF != null && adapter.getItemCount() > SwipRefreshRecyclerView.this.nWI) {
                        SwipRefreshRecyclerView.this.nWF.aZN();
                        SwipRefreshRecyclerView.this.eil = true;
                    }
                }
            }
        };
        this.nWD = new ExtendedRecyclerView(getContext(), attributeSet);
        this.nWD.setId(b.e.zues_swiperefresh_recyclerview);
        RecyclerView.ItemAnimator itemAnimator = this.nWD.getItemAnimator();
        if (itemAnimator instanceof SimpleItemAnimator) {
            ((SimpleItemAnimator) itemAnimator).setSupportsChangeAnimations(false);
        }
        this.nWD.setHasFixedSize(true);
        addView(this.nWD, new ViewGroup.LayoutParams(-1, -1));
        setColorSchemeResources(17170452, 17170459, 17170452, 17170459);
        this.nWD.addOnScrollListener(this.mOnScrollListener);
        super.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() { // from class: tv.chushou.zues.widget.adapterview.recyclerview.view.SwipRefreshRecyclerView.1
            @Override // android.support.v4.widget.SwipeRefreshLayout.OnRefreshListener
            public void onRefresh() {
                if (SwipRefreshRecyclerView.this.nWK != null) {
                    SwipRefreshRecyclerView.this.nWG = true;
                    tv.chushou.zues.widget.adapterview.recyclerview.a.b adapter = SwipRefreshRecyclerView.this.getAdapter();
                    if (adapter != null) {
                        adapter.dPk();
                    }
                    SwipRefreshRecyclerView.this.nWK.onRefresh();
                }
            }
        });
        setEnabled(this.nWH);
        if (Build.VERSION.SDK_INT < 21) {
            setCanChildScrollUpCallback(new CustomSwipeRefreshLayout.a() { // from class: tv.chushou.zues.widget.adapterview.recyclerview.view.SwipRefreshRecyclerView.2
                @Override // tv.chushou.zues.widget.adapterview.CustomSwipeRefreshLayout.a
                public boolean dPi() {
                    return SwipRefreshRecyclerView.this.nWD != null && SwipRefreshRecyclerView.this.nWD.getScrollY() > 0;
                }
            });
        }
        this.mTouchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
    }

    public void setOnePageSize(int i) {
        this.nWJ = i;
    }

    public ExtendedRecyclerView getInnerRecyclerView() {
        return this.nWD;
    }

    public void setHasFixedSize(boolean z) {
        this.nWD.setHasFixedSize(z);
    }

    public void setUpDefault() {
        this.nWD.setLayoutManager(new LinearLayoutManager(getContext()));
        this.nWE = new DefaultLoadMoreView(getContext());
    }

    public void setAdapter(RecyclerView.Adapter adapter) {
        this.nWD.setAdapter(adapter);
        if (this.nWF != null) {
            this.nWD.setLoadMoreProvider(this);
        }
    }

    public tv.chushou.zues.widget.adapterview.recyclerview.a.b getAdapter() {
        return this.nWD.getAdapter();
    }

    public boolean Op(int i) {
        return this.nWD.Op(i);
    }

    public int getHeaderViewCount() {
        return this.nWD.getHeaderViewCount();
    }

    public boolean Oq(int i) {
        return this.nWD.Oq(i);
    }

    public int getFooterViewCount() {
        return this.nWD.getFooterViewCount();
    }

    public void setEmptyView(@NonNull View view) {
        this.nWD.setEmptyView(view);
    }

    @Nullable
    public View getEmptyView() {
        return this.nWD.getEmptyView();
    }

    public void setLoadMoreListener(tv.chushou.zues.widget.adapterview.b bVar) {
        this.nWF = bVar;
        if (getAdapter() != null) {
            this.nWD.setLoadMoreProvider(this);
        }
    }

    public void setLoadMoreFooter(@NonNull View view) {
        this.nWE = view;
    }

    public void dPn() {
        this.eil = false;
    }

    @Override // tv.chushou.zues.widget.adapterview.c
    public void Ok(int i) {
        if (this.nWG && this.nWD.getAdapter() != null) {
            if (this.nWE == null) {
                this.nWE = new DefaultLoadMoreView(getContext());
            }
            if (i >= this.nWJ) {
                if (!this.nWD.dE(this.nWE)) {
                    this.nWD.addFooterView(this.nWE, 0);
                }
            } else if (this.nWD.dE(this.nWE)) {
                this.nWD.dC(this.nWE);
            }
            this.eil = false;
        }
    }

    @Override // tv.chushou.zues.widget.adapterview.c
    public boolean dPj() {
        if (this.nWE == null) {
            this.nWE = new DefaultLoadMoreView(getContext());
        }
        return this.nWD.dE(this.nWE);
    }

    public void setHasMoreItems(boolean z) {
        this.nWG = z;
        if (!z && this.nWD.dE(this.nWE)) {
            this.nWD.dC(this.nWE);
        }
    }

    public void setPullToRefreshEnabled(boolean z) {
        this.nWH = z;
        setEnabled(this.nWH);
    }

    public void completeRefresh() {
        setRefreshing(false);
    }

    public void setPullToRefreshListener(f fVar) {
        this.nWK = fVar;
    }

    @Override // android.support.v4.widget.SwipeRefreshLayout
    @Deprecated
    public void setOnRefreshListener(@Nullable SwipeRefreshLayout.OnRefreshListener onRefreshListener) {
        super.setOnRefreshListener(onRefreshListener);
    }

    public void setLayoutManager(RecyclerView.LayoutManager layoutManager) {
        this.nWD.setLayoutManager(layoutManager);
    }

    public RecyclerView.LayoutManager getLayoutManager() {
        return this.nWD.getLayoutManager();
    }

    public void addItemDecoration(RecyclerView.ItemDecoration itemDecoration) {
        this.nWD.addItemDecoration(itemDecoration);
    }

    public void scrollToPosition(int i) {
        this.nWD.scrollToPosition(i);
    }

    public void setItemDecration(RecyclerView.ItemDecoration itemDecoration) {
        this.nWD.addItemDecoration(itemDecoration);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                this.nWM = false;
                this.startY = motionEvent.getY();
                this.startX = motionEvent.getX();
                break;
            case 2:
                float y = motionEvent.getY();
                float abs = Math.abs(y - this.startY);
                float f = y - this.startY;
                if (abs > this.mTouchSlop && f < 0.0f) {
                    this.nWM = true;
                    break;
                } else {
                    this.nWM = false;
                    break;
                }
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public void setSmallPageSize(int i) {
        this.nWI = i;
    }
}
