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
    private ExtendedRecyclerView olk;
    private View oll;
    private b olm;
    private boolean oln;
    private boolean olo;
    private int olp;
    private int olq;
    private f olr;
    private RecyclerView.OnScrollListener ols;
    private boolean olt;
    private float startX;
    private float startY;

    public SwipRefreshRecyclerView(Context context) {
        this(context, null);
    }

    public SwipRefreshRecyclerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.foF = false;
        this.oln = true;
        this.olo = true;
        this.olp = 9;
        this.olq = 20;
        this.mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: tv.chushou.zues.widget.adapterview.recyclerview.view.SwipRefreshRecyclerView.3
            private int olv = -1;

            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i, int i2) {
                boolean z = false;
                super.onScrolled(recyclerView, i, i2);
                if (SwipRefreshRecyclerView.this.ols != null) {
                    SwipRefreshRecyclerView.this.ols.onScrolled(recyclerView, i, i2);
                }
                if (SwipRefreshRecyclerView.this.olk.getLayoutManager() != null) {
                    this.olv = a.e(SwipRefreshRecyclerView.this.olk.getLayoutManager());
                    if (Build.VERSION.SDK_INT < 21) {
                        int top2 = (recyclerView == null || recyclerView.getChildCount() == 0) ? 0 : recyclerView.getChildAt(0).getTop();
                        SwipRefreshRecyclerView swipRefreshRecyclerView = SwipRefreshRecyclerView.this;
                        if (top2 >= recyclerView.getPaddingTop() && SwipRefreshRecyclerView.this.olo) {
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
                if (SwipRefreshRecyclerView.this.ols != null) {
                    SwipRefreshRecyclerView.this.ols.onScrollStateChanged(recyclerView, i);
                }
                RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
                if (layoutManager != null && (adapter = recyclerView.getAdapter()) != null) {
                    int childCount = layoutManager.getChildCount();
                    int itemCount = layoutManager.getItemCount();
                    if (childCount > 0 && i == 0 && this.olv >= itemCount - 1 && SwipRefreshRecyclerView.this.olt && !SwipRefreshRecyclerView.this.foF && SwipRefreshRecyclerView.this.oln && SwipRefreshRecyclerView.this.olm != null && adapter.getItemCount() > SwipRefreshRecyclerView.this.olp) {
                        SwipRefreshRecyclerView.this.olm.btu();
                        SwipRefreshRecyclerView.this.foF = true;
                    }
                }
            }
        };
        this.olk = new ExtendedRecyclerView(getContext(), attributeSet);
        this.olk.setId(b.e.zues_swiperefresh_recyclerview);
        RecyclerView.ItemAnimator itemAnimator = this.olk.getItemAnimator();
        if (itemAnimator instanceof SimpleItemAnimator) {
            ((SimpleItemAnimator) itemAnimator).setSupportsChangeAnimations(false);
        }
        this.olk.setHasFixedSize(true);
        addView(this.olk, new ViewGroup.LayoutParams(-1, -1));
        setColorSchemeResources(17170452, 17170459, 17170452, 17170459);
        this.olk.addOnScrollListener(this.mOnScrollListener);
        super.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() { // from class: tv.chushou.zues.widget.adapterview.recyclerview.view.SwipRefreshRecyclerView.1
            @Override // android.support.v4.widget.SwipeRefreshLayout.OnRefreshListener
            public void onRefresh() {
                if (SwipRefreshRecyclerView.this.olr != null) {
                    SwipRefreshRecyclerView.this.oln = true;
                    tv.chushou.zues.widget.adapterview.recyclerview.a.b adapter = SwipRefreshRecyclerView.this.getAdapter();
                    if (adapter != null) {
                        adapter.dWN();
                    }
                    SwipRefreshRecyclerView.this.olr.onRefresh();
                }
            }
        });
        setEnabled(this.olo);
        if (Build.VERSION.SDK_INT < 21) {
            setCanChildScrollUpCallback(new CustomSwipeRefreshLayout.a() { // from class: tv.chushou.zues.widget.adapterview.recyclerview.view.SwipRefreshRecyclerView.2
                @Override // tv.chushou.zues.widget.adapterview.CustomSwipeRefreshLayout.a
                public boolean dWL() {
                    return SwipRefreshRecyclerView.this.olk != null && SwipRefreshRecyclerView.this.olk.getScrollY() > 0;
                }
            });
        }
        this.hmk = ViewConfiguration.get(context).getScaledTouchSlop();
    }

    public void setOnePageSize(int i) {
        this.olq = i;
    }

    public ExtendedRecyclerView getInnerRecyclerView() {
        return this.olk;
    }

    public void setHasFixedSize(boolean z) {
        this.olk.setHasFixedSize(z);
    }

    public void setUpDefault() {
        this.olk.setLayoutManager(new LinearLayoutManager(getContext()));
        this.oll = new DefaultLoadMoreView(getContext());
    }

    public void setAdapter(RecyclerView.Adapter adapter) {
        this.olk.setAdapter(adapter);
        if (this.olm != null) {
            this.olk.setLoadMoreProvider(this);
        }
    }

    public tv.chushou.zues.widget.adapterview.recyclerview.a.b getAdapter() {
        return this.olk.getAdapter();
    }

    public boolean LN(int i) {
        return this.olk.LN(i);
    }

    public int getHeaderViewCount() {
        return this.olk.getHeaderViewCount();
    }

    public boolean LO(int i) {
        return this.olk.LO(i);
    }

    public int getFooterViewCount() {
        return this.olk.getFooterViewCount();
    }

    public void setEmptyView(@NonNull View view) {
        this.olk.setEmptyView(view);
    }

    @Nullable
    public View getEmptyView() {
        return this.olk.getEmptyView();
    }

    public void setLoadMoreListener(tv.chushou.zues.widget.adapterview.b bVar) {
        this.olm = bVar;
        if (getAdapter() != null) {
            this.olk.setLoadMoreProvider(this);
        }
    }

    public void setLoadMoreFooter(@NonNull View view) {
        this.oll = view;
    }

    public void dWQ() {
        this.foF = false;
    }

    @Override // tv.chushou.zues.widget.adapterview.c
    public void LJ(int i) {
        if (this.oln && this.olk.getAdapter() != null) {
            if (this.oll == null) {
                this.oll = new DefaultLoadMoreView(getContext());
            }
            if (i >= this.olq) {
                if (!this.olk.dz(this.oll)) {
                    this.olk.addFooterView(this.oll, 0);
                }
            } else if (this.olk.dz(this.oll)) {
                this.olk.dx(this.oll);
            }
            this.foF = false;
        }
    }

    @Override // tv.chushou.zues.widget.adapterview.c
    public boolean dWM() {
        if (this.oll == null) {
            this.oll = new DefaultLoadMoreView(getContext());
        }
        return this.olk.dz(this.oll);
    }

    public void setHasMoreItems(boolean z) {
        this.oln = z;
        if (!z && this.olk.dz(this.oll)) {
            this.olk.dx(this.oll);
        }
    }

    public void setPullToRefreshEnabled(boolean z) {
        this.olo = z;
        setEnabled(this.olo);
    }

    public void completeRefresh() {
        setRefreshing(false);
    }

    public void setPullToRefreshListener(f fVar) {
        this.olr = fVar;
    }

    @Override // android.support.v4.widget.SwipeRefreshLayout
    @Deprecated
    public void setOnRefreshListener(@Nullable SwipeRefreshLayout.OnRefreshListener onRefreshListener) {
        super.setOnRefreshListener(onRefreshListener);
    }

    public void setLayoutManager(RecyclerView.LayoutManager layoutManager) {
        this.olk.setLayoutManager(layoutManager);
    }

    public RecyclerView.LayoutManager getLayoutManager() {
        return this.olk.getLayoutManager();
    }

    public void addItemDecoration(RecyclerView.ItemDecoration itemDecoration) {
        this.olk.addItemDecoration(itemDecoration);
    }

    public void scrollToPosition(int i) {
        this.olk.scrollToPosition(i);
    }

    public void setItemDecration(RecyclerView.ItemDecoration itemDecoration) {
        this.olk.addItemDecoration(itemDecoration);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                this.olt = false;
                this.startY = motionEvent.getY();
                this.startX = motionEvent.getX();
                break;
            case 2:
                float y = motionEvent.getY();
                float abs = Math.abs(y - this.startY);
                float f = y - this.startY;
                if (abs > this.hmk && f < 0.0f) {
                    this.olt = true;
                    break;
                } else {
                    this.olt = false;
                    break;
                }
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public void setSmallPageSize(int i) {
        this.olp = i;
    }
}
