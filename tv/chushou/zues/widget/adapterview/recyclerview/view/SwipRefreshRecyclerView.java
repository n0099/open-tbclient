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
    private boolean fFn;
    private float hFs;
    private RecyclerView.OnScrollListener mOnScrollListener;
    private ExtendedRecyclerView oOe;
    private View oOf;
    private b oOg;
    private boolean oOh;
    private boolean oOi;
    private int oOj;
    private int oOk;
    private f oOl;
    private RecyclerView.OnScrollListener oOm;
    private boolean oOn;
    private float startX;
    private float startY;

    public SwipRefreshRecyclerView(Context context) {
        this(context, null);
    }

    public SwipRefreshRecyclerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fFn = false;
        this.oOh = true;
        this.oOi = true;
        this.oOj = 9;
        this.oOk = 20;
        this.mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: tv.chushou.zues.widget.adapterview.recyclerview.view.SwipRefreshRecyclerView.3
            private int oOp = -1;

            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i, int i2) {
                boolean z = false;
                super.onScrolled(recyclerView, i, i2);
                if (SwipRefreshRecyclerView.this.oOm != null) {
                    SwipRefreshRecyclerView.this.oOm.onScrolled(recyclerView, i, i2);
                }
                if (SwipRefreshRecyclerView.this.oOe.getLayoutManager() != null) {
                    this.oOp = a.e(SwipRefreshRecyclerView.this.oOe.getLayoutManager());
                    if (Build.VERSION.SDK_INT < 21) {
                        int top = (recyclerView == null || recyclerView.getChildCount() == 0) ? 0 : recyclerView.getChildAt(0).getTop();
                        SwipRefreshRecyclerView swipRefreshRecyclerView = SwipRefreshRecyclerView.this;
                        if (top >= recyclerView.getPaddingTop() && SwipRefreshRecyclerView.this.oOi) {
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
                if (SwipRefreshRecyclerView.this.oOm != null) {
                    SwipRefreshRecyclerView.this.oOm.onScrollStateChanged(recyclerView, i);
                }
                RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
                if (layoutManager != null && (adapter = recyclerView.getAdapter()) != null) {
                    int childCount = layoutManager.getChildCount();
                    int itemCount = layoutManager.getItemCount();
                    if (childCount > 0 && i == 0 && this.oOp >= itemCount - 1 && SwipRefreshRecyclerView.this.oOn && !SwipRefreshRecyclerView.this.fFn && SwipRefreshRecyclerView.this.oOh && SwipRefreshRecyclerView.this.oOg != null && adapter.getItemCount() > SwipRefreshRecyclerView.this.oOj) {
                        SwipRefreshRecyclerView.this.oOg.bFE();
                        SwipRefreshRecyclerView.this.fFn = true;
                    }
                }
            }
        };
        this.oOe = new ExtendedRecyclerView(getContext(), attributeSet);
        this.oOe.setId(b.e.zues_swiperefresh_recyclerview);
        RecyclerView.ItemAnimator itemAnimator = this.oOe.getItemAnimator();
        if (itemAnimator instanceof SimpleItemAnimator) {
            ((SimpleItemAnimator) itemAnimator).setSupportsChangeAnimations(false);
        }
        this.oOe.setHasFixedSize(true);
        addView(this.oOe, new ViewGroup.LayoutParams(-1, -1));
        setColorSchemeResources(17170452, 17170459, 17170452, 17170459);
        this.oOe.addOnScrollListener(this.mOnScrollListener);
        super.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() { // from class: tv.chushou.zues.widget.adapterview.recyclerview.view.SwipRefreshRecyclerView.1
            @Override // android.support.v4.widget.SwipeRefreshLayout.OnRefreshListener
            public void onRefresh() {
                if (SwipRefreshRecyclerView.this.oOl != null) {
                    SwipRefreshRecyclerView.this.oOh = true;
                    tv.chushou.zues.widget.adapterview.recyclerview.a.b adapter = SwipRefreshRecyclerView.this.getAdapter();
                    if (adapter != null) {
                        adapter.emA();
                    }
                    SwipRefreshRecyclerView.this.oOl.onRefresh();
                }
            }
        });
        setEnabled(this.oOi);
        if (Build.VERSION.SDK_INT < 21) {
            setCanChildScrollUpCallback(new CustomSwipeRefreshLayout.a() { // from class: tv.chushou.zues.widget.adapterview.recyclerview.view.SwipRefreshRecyclerView.2
                @Override // tv.chushou.zues.widget.adapterview.CustomSwipeRefreshLayout.a
                public boolean emy() {
                    return SwipRefreshRecyclerView.this.oOe != null && SwipRefreshRecyclerView.this.oOe.getScrollY() > 0;
                }
            });
        }
        this.hFs = ViewConfiguration.get(context).getScaledTouchSlop();
    }

    public void setOnePageSize(int i) {
        this.oOk = i;
    }

    public ExtendedRecyclerView getInnerRecyclerView() {
        return this.oOe;
    }

    public void setHasFixedSize(boolean z) {
        this.oOe.setHasFixedSize(z);
    }

    public void setUpDefault() {
        this.oOe.setLayoutManager(new LinearLayoutManager(getContext()));
        this.oOf = new DefaultLoadMoreView(getContext());
    }

    public void setAdapter(RecyclerView.Adapter adapter) {
        this.oOe.setAdapter(adapter);
        if (this.oOg != null) {
            this.oOe.setLoadMoreProvider(this);
        }
    }

    public tv.chushou.zues.widget.adapterview.recyclerview.a.b getAdapter() {
        return this.oOe.getAdapter();
    }

    public boolean OK(int i) {
        return this.oOe.OK(i);
    }

    public int getHeaderViewCount() {
        return this.oOe.getHeaderViewCount();
    }

    public boolean OL(int i) {
        return this.oOe.OL(i);
    }

    public int getFooterViewCount() {
        return this.oOe.getFooterViewCount();
    }

    public void setEmptyView(@NonNull View view) {
        this.oOe.setEmptyView(view);
    }

    @Nullable
    public View getEmptyView() {
        return this.oOe.getEmptyView();
    }

    public void setLoadMoreListener(tv.chushou.zues.widget.adapterview.b bVar) {
        this.oOg = bVar;
        if (getAdapter() != null) {
            this.oOe.setLoadMoreProvider(this);
        }
    }

    public void setLoadMoreFooter(@NonNull View view) {
        this.oOf = view;
    }

    public void emD() {
        this.fFn = false;
    }

    @Override // tv.chushou.zues.widget.adapterview.c
    public void OG(int i) {
        if (this.oOh && this.oOe.getAdapter() != null) {
            if (this.oOf == null) {
                this.oOf = new DefaultLoadMoreView(getContext());
            }
            if (i >= this.oOk) {
                if (!this.oOe.dH(this.oOf)) {
                    this.oOe.addFooterView(this.oOf, 0);
                }
            } else if (this.oOe.dH(this.oOf)) {
                this.oOe.dF(this.oOf);
            }
            this.fFn = false;
        }
    }

    @Override // tv.chushou.zues.widget.adapterview.c
    public boolean emz() {
        if (this.oOf == null) {
            this.oOf = new DefaultLoadMoreView(getContext());
        }
        return this.oOe.dH(this.oOf);
    }

    public void setHasMoreItems(boolean z) {
        this.oOh = z;
        if (!z && this.oOe.dH(this.oOf)) {
            this.oOe.dF(this.oOf);
        }
    }

    public void setPullToRefreshEnabled(boolean z) {
        this.oOi = z;
        setEnabled(this.oOi);
    }

    public void completeRefresh() {
        setRefreshing(false);
    }

    public void setPullToRefreshListener(f fVar) {
        this.oOl = fVar;
    }

    @Override // android.support.v4.widget.SwipeRefreshLayout
    @Deprecated
    public void setOnRefreshListener(@Nullable SwipeRefreshLayout.OnRefreshListener onRefreshListener) {
        super.setOnRefreshListener(onRefreshListener);
    }

    public void setLayoutManager(RecyclerView.LayoutManager layoutManager) {
        this.oOe.setLayoutManager(layoutManager);
    }

    public RecyclerView.LayoutManager getLayoutManager() {
        return this.oOe.getLayoutManager();
    }

    public void addItemDecoration(RecyclerView.ItemDecoration itemDecoration) {
        this.oOe.addItemDecoration(itemDecoration);
    }

    public void scrollToPosition(int i) {
        this.oOe.scrollToPosition(i);
    }

    public void setItemDecration(RecyclerView.ItemDecoration itemDecoration) {
        this.oOe.addItemDecoration(itemDecoration);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                this.oOn = false;
                this.startY = motionEvent.getY();
                this.startX = motionEvent.getX();
                break;
            case 2:
                float y = motionEvent.getY();
                float abs = Math.abs(y - this.startY);
                float f = y - this.startY;
                if (abs > this.hFs && f < 0.0f) {
                    this.oOn = true;
                    break;
                } else {
                    this.oOn = false;
                    break;
                }
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public void setSmallPageSize(int i) {
        this.oOj = i;
    }
}
