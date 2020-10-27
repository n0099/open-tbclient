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
    private boolean geR;
    private float inQ;
    private RecyclerView.OnScrollListener mOnScrollListener;
    private ExtendedRecyclerView qeo;
    private View qep;
    private b qeq;
    private boolean qer;
    private boolean qes;
    private int qet;
    private int qeu;
    private f qev;
    private RecyclerView.OnScrollListener qew;
    private boolean qex;
    private float startX;
    private float startY;

    public SwipRefreshRecyclerView(Context context) {
        this(context, null);
    }

    public SwipRefreshRecyclerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.geR = false;
        this.qer = true;
        this.qes = true;
        this.qet = 9;
        this.qeu = 20;
        this.mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: tv.chushou.zues.widget.adapterview.recyclerview.view.SwipRefreshRecyclerView.3
            private int qez = -1;

            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i, int i2) {
                boolean z = false;
                super.onScrolled(recyclerView, i, i2);
                if (SwipRefreshRecyclerView.this.qew != null) {
                    SwipRefreshRecyclerView.this.qew.onScrolled(recyclerView, i, i2);
                }
                if (SwipRefreshRecyclerView.this.qeo.getLayoutManager() != null) {
                    this.qez = a.e(SwipRefreshRecyclerView.this.qeo.getLayoutManager());
                    if (Build.VERSION.SDK_INT < 21) {
                        int top = (recyclerView == null || recyclerView.getChildCount() == 0) ? 0 : recyclerView.getChildAt(0).getTop();
                        SwipRefreshRecyclerView swipRefreshRecyclerView = SwipRefreshRecyclerView.this;
                        if (top >= recyclerView.getPaddingTop() && SwipRefreshRecyclerView.this.qes) {
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
                if (SwipRefreshRecyclerView.this.qew != null) {
                    SwipRefreshRecyclerView.this.qew.onScrollStateChanged(recyclerView, i);
                }
                RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
                if (layoutManager != null && (adapter = recyclerView.getAdapter()) != null) {
                    int childCount = layoutManager.getChildCount();
                    int itemCount = layoutManager.getItemCount();
                    if (childCount > 0 && i == 0 && this.qez >= itemCount - 1 && SwipRefreshRecyclerView.this.qex && !SwipRefreshRecyclerView.this.geR && SwipRefreshRecyclerView.this.qer && SwipRefreshRecyclerView.this.qeq != null && adapter.getItemCount() > SwipRefreshRecyclerView.this.qet) {
                        SwipRefreshRecyclerView.this.qeq.bMi();
                        SwipRefreshRecyclerView.this.geR = true;
                    }
                }
            }
        };
        this.qeo = new ExtendedRecyclerView(getContext(), attributeSet);
        this.qeo.setId(b.e.zues_swiperefresh_recyclerview);
        RecyclerView.ItemAnimator itemAnimator = this.qeo.getItemAnimator();
        if (itemAnimator instanceof SimpleItemAnimator) {
            ((SimpleItemAnimator) itemAnimator).setSupportsChangeAnimations(false);
        }
        this.qeo.setHasFixedSize(true);
        addView(this.qeo, new ViewGroup.LayoutParams(-1, -1));
        setColorSchemeResources(17170452, 17170459, 17170452, 17170459);
        this.qeo.addOnScrollListener(this.mOnScrollListener);
        super.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() { // from class: tv.chushou.zues.widget.adapterview.recyclerview.view.SwipRefreshRecyclerView.1
            @Override // android.support.v4.widget.SwipeRefreshLayout.OnRefreshListener
            public void onRefresh() {
                if (SwipRefreshRecyclerView.this.qev != null) {
                    SwipRefreshRecyclerView.this.qer = true;
                    tv.chushou.zues.widget.adapterview.recyclerview.a.b adapter = SwipRefreshRecyclerView.this.getAdapter();
                    if (adapter != null) {
                        adapter.eEh();
                    }
                    SwipRefreshRecyclerView.this.qev.onRefresh();
                }
            }
        });
        setEnabled(this.qes);
        if (Build.VERSION.SDK_INT < 21) {
            setCanChildScrollUpCallback(new CustomSwipeRefreshLayout.a() { // from class: tv.chushou.zues.widget.adapterview.recyclerview.view.SwipRefreshRecyclerView.2
                @Override // tv.chushou.zues.widget.adapterview.CustomSwipeRefreshLayout.a
                public boolean eEf() {
                    return SwipRefreshRecyclerView.this.qeo != null && SwipRefreshRecyclerView.this.qeo.getScrollY() > 0;
                }
            });
        }
        this.inQ = ViewConfiguration.get(context).getScaledTouchSlop();
    }

    public void setOnePageSize(int i) {
        this.qeu = i;
    }

    public ExtendedRecyclerView getInnerRecyclerView() {
        return this.qeo;
    }

    public void setHasFixedSize(boolean z) {
        this.qeo.setHasFixedSize(z);
    }

    public void setUpDefault() {
        this.qeo.setLayoutManager(new LinearLayoutManager(getContext()));
        this.qep = new DefaultLoadMoreView(getContext());
    }

    public void setAdapter(RecyclerView.Adapter adapter) {
        this.qeo.setAdapter(adapter);
        if (this.qeq != null) {
            this.qeo.setLoadMoreProvider(this);
        }
    }

    public tv.chushou.zues.widget.adapterview.recyclerview.a.b getAdapter() {
        return this.qeo.getAdapter();
    }

    public boolean RM(int i) {
        return this.qeo.RM(i);
    }

    public int getHeaderViewCount() {
        return this.qeo.getHeaderViewCount();
    }

    public boolean RN(int i) {
        return this.qeo.RN(i);
    }

    public int getFooterViewCount() {
        return this.qeo.getFooterViewCount();
    }

    public void setEmptyView(@NonNull View view) {
        this.qeo.setEmptyView(view);
    }

    @Nullable
    public View getEmptyView() {
        return this.qeo.getEmptyView();
    }

    public void setLoadMoreListener(tv.chushou.zues.widget.adapterview.b bVar) {
        this.qeq = bVar;
        if (getAdapter() != null) {
            this.qeo.setLoadMoreProvider(this);
        }
    }

    public void setLoadMoreFooter(@NonNull View view) {
        this.qep = view;
    }

    public void eEk() {
        this.geR = false;
    }

    @Override // tv.chushou.zues.widget.adapterview.c
    public void RI(int i) {
        if (this.qer && this.qeo.getAdapter() != null) {
            if (this.qep == null) {
                this.qep = new DefaultLoadMoreView(getContext());
            }
            if (i >= this.qeu) {
                if (!this.qeo.ec(this.qep)) {
                    this.qeo.addFooterView(this.qep, 0);
                }
            } else if (this.qeo.ec(this.qep)) {
                this.qeo.ea(this.qep);
            }
            this.geR = false;
        }
    }

    @Override // tv.chushou.zues.widget.adapterview.c
    public boolean eEg() {
        if (this.qep == null) {
            this.qep = new DefaultLoadMoreView(getContext());
        }
        return this.qeo.ec(this.qep);
    }

    public void setHasMoreItems(boolean z) {
        this.qer = z;
        if (!z && this.qeo.ec(this.qep)) {
            this.qeo.ea(this.qep);
        }
    }

    public void setPullToRefreshEnabled(boolean z) {
        this.qes = z;
        setEnabled(this.qes);
    }

    public void completeRefresh() {
        setRefreshing(false);
    }

    public void setPullToRefreshListener(f fVar) {
        this.qev = fVar;
    }

    @Override // android.support.v4.widget.SwipeRefreshLayout
    @Deprecated
    public void setOnRefreshListener(@Nullable SwipeRefreshLayout.OnRefreshListener onRefreshListener) {
        super.setOnRefreshListener(onRefreshListener);
    }

    public void setLayoutManager(RecyclerView.LayoutManager layoutManager) {
        this.qeo.setLayoutManager(layoutManager);
    }

    public RecyclerView.LayoutManager getLayoutManager() {
        return this.qeo.getLayoutManager();
    }

    public void addItemDecoration(RecyclerView.ItemDecoration itemDecoration) {
        this.qeo.addItemDecoration(itemDecoration);
    }

    public void scrollToPosition(int i) {
        this.qeo.scrollToPosition(i);
    }

    public void setItemDecration(RecyclerView.ItemDecoration itemDecoration) {
        this.qeo.addItemDecoration(itemDecoration);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                this.qex = false;
                this.startY = motionEvent.getY();
                this.startX = motionEvent.getX();
                break;
            case 2:
                float y = motionEvent.getY();
                float abs = Math.abs(y - this.startY);
                float f = y - this.startY;
                if (abs > this.inQ && f < 0.0f) {
                    this.qex = true;
                    break;
                } else {
                    this.qex = false;
                    break;
                }
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public void setSmallPageSize(int i) {
        this.qet = i;
    }
}
