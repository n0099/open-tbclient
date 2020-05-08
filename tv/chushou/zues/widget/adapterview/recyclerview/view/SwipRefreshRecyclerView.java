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
    private boolean eQC;
    private float gLb;
    private RecyclerView.OnScrollListener mOnScrollListener;
    private ExtendedRecyclerView ntp;
    private View ntq;
    private b ntr;
    private boolean nts;
    private boolean ntt;
    private int ntu;
    private int ntv;
    private f ntw;
    private RecyclerView.OnScrollListener ntx;
    private boolean nty;
    private float startX;
    private float startY;

    public SwipRefreshRecyclerView(Context context) {
        this(context, null);
    }

    public SwipRefreshRecyclerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.eQC = false;
        this.nts = true;
        this.ntt = true;
        this.ntu = 9;
        this.ntv = 20;
        this.mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: tv.chushou.zues.widget.adapterview.recyclerview.view.SwipRefreshRecyclerView.3
            private int ntA = -1;

            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i, int i2) {
                boolean z = false;
                super.onScrolled(recyclerView, i, i2);
                if (SwipRefreshRecyclerView.this.ntx != null) {
                    SwipRefreshRecyclerView.this.ntx.onScrolled(recyclerView, i, i2);
                }
                if (SwipRefreshRecyclerView.this.ntp.getLayoutManager() != null) {
                    this.ntA = a.e(SwipRefreshRecyclerView.this.ntp.getLayoutManager());
                    if (Build.VERSION.SDK_INT < 21) {
                        int top2 = (recyclerView == null || recyclerView.getChildCount() == 0) ? 0 : recyclerView.getChildAt(0).getTop();
                        SwipRefreshRecyclerView swipRefreshRecyclerView = SwipRefreshRecyclerView.this;
                        if (top2 >= recyclerView.getPaddingTop() && SwipRefreshRecyclerView.this.ntt) {
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
                if (SwipRefreshRecyclerView.this.ntx != null) {
                    SwipRefreshRecyclerView.this.ntx.onScrollStateChanged(recyclerView, i);
                }
                RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
                if (layoutManager != null && (adapter = recyclerView.getAdapter()) != null) {
                    int childCount = layoutManager.getChildCount();
                    int itemCount = layoutManager.getItemCount();
                    if (childCount > 0 && i == 0 && this.ntA >= itemCount - 1 && SwipRefreshRecyclerView.this.nty && !SwipRefreshRecyclerView.this.eQC && SwipRefreshRecyclerView.this.nts && SwipRefreshRecyclerView.this.ntr != null && adapter.getItemCount() > SwipRefreshRecyclerView.this.ntu) {
                        SwipRefreshRecyclerView.this.ntr.bkZ();
                        SwipRefreshRecyclerView.this.eQC = true;
                    }
                }
            }
        };
        this.ntp = new ExtendedRecyclerView(getContext(), attributeSet);
        this.ntp.setId(b.e.zues_swiperefresh_recyclerview);
        RecyclerView.ItemAnimator itemAnimator = this.ntp.getItemAnimator();
        if (itemAnimator instanceof SimpleItemAnimator) {
            ((SimpleItemAnimator) itemAnimator).setSupportsChangeAnimations(false);
        }
        this.ntp.setHasFixedSize(true);
        addView(this.ntp, new ViewGroup.LayoutParams(-1, -1));
        setColorSchemeResources(17170452, 17170459, 17170452, 17170459);
        this.ntp.addOnScrollListener(this.mOnScrollListener);
        super.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() { // from class: tv.chushou.zues.widget.adapterview.recyclerview.view.SwipRefreshRecyclerView.1
            @Override // android.support.v4.widget.SwipeRefreshLayout.OnRefreshListener
            public void onRefresh() {
                if (SwipRefreshRecyclerView.this.ntw != null) {
                    SwipRefreshRecyclerView.this.nts = true;
                    tv.chushou.zues.widget.adapterview.recyclerview.a.b adapter = SwipRefreshRecyclerView.this.getAdapter();
                    if (adapter != null) {
                        adapter.dJY();
                    }
                    SwipRefreshRecyclerView.this.ntw.onRefresh();
                }
            }
        });
        setEnabled(this.ntt);
        if (Build.VERSION.SDK_INT < 21) {
            setCanChildScrollUpCallback(new CustomSwipeRefreshLayout.a() { // from class: tv.chushou.zues.widget.adapterview.recyclerview.view.SwipRefreshRecyclerView.2
                @Override // tv.chushou.zues.widget.adapterview.CustomSwipeRefreshLayout.a
                public boolean dJW() {
                    return SwipRefreshRecyclerView.this.ntp != null && SwipRefreshRecyclerView.this.ntp.getScrollY() > 0;
                }
            });
        }
        this.gLb = ViewConfiguration.get(context).getScaledTouchSlop();
    }

    public void setOnePageSize(int i) {
        this.ntv = i;
    }

    public ExtendedRecyclerView getInnerRecyclerView() {
        return this.ntp;
    }

    public void setHasFixedSize(boolean z) {
        this.ntp.setHasFixedSize(z);
    }

    public void setUpDefault() {
        this.ntp.setLayoutManager(new LinearLayoutManager(getContext()));
        this.ntq = new DefaultLoadMoreView(getContext());
    }

    public void setAdapter(RecyclerView.Adapter adapter) {
        this.ntp.setAdapter(adapter);
        if (this.ntr != null) {
            this.ntp.setLoadMoreProvider(this);
        }
    }

    public tv.chushou.zues.widget.adapterview.recyclerview.a.b getAdapter() {
        return this.ntp.getAdapter();
    }

    public boolean JU(int i) {
        return this.ntp.JU(i);
    }

    public int getHeaderViewCount() {
        return this.ntp.getHeaderViewCount();
    }

    public boolean JV(int i) {
        return this.ntp.JV(i);
    }

    public int getFooterViewCount() {
        return this.ntp.getFooterViewCount();
    }

    public void setEmptyView(@NonNull View view) {
        this.ntp.setEmptyView(view);
    }

    @Nullable
    public View getEmptyView() {
        return this.ntp.getEmptyView();
    }

    public void setLoadMoreListener(tv.chushou.zues.widget.adapterview.b bVar) {
        this.ntr = bVar;
        if (getAdapter() != null) {
            this.ntp.setLoadMoreProvider(this);
        }
    }

    public void setLoadMoreFooter(@NonNull View view) {
        this.ntq = view;
    }

    public void dKb() {
        this.eQC = false;
    }

    @Override // tv.chushou.zues.widget.adapterview.c
    public void JP(int i) {
        if (this.nts && this.ntp.getAdapter() != null) {
            if (this.ntq == null) {
                this.ntq = new DefaultLoadMoreView(getContext());
            }
            if (i >= this.ntv) {
                if (!this.ntp.dx(this.ntq)) {
                    this.ntp.addFooterView(this.ntq, 0);
                }
            } else if (this.ntp.dx(this.ntq)) {
                this.ntp.dv(this.ntq);
            }
            this.eQC = false;
        }
    }

    @Override // tv.chushou.zues.widget.adapterview.c
    public boolean dJX() {
        if (this.ntq == null) {
            this.ntq = new DefaultLoadMoreView(getContext());
        }
        return this.ntp.dx(this.ntq);
    }

    public void setHasMoreItems(boolean z) {
        this.nts = z;
        if (!z && this.ntp.dx(this.ntq)) {
            this.ntp.dv(this.ntq);
        }
    }

    public void setPullToRefreshEnabled(boolean z) {
        this.ntt = z;
        setEnabled(this.ntt);
    }

    public void completeRefresh() {
        setRefreshing(false);
    }

    public void setPullToRefreshListener(f fVar) {
        this.ntw = fVar;
    }

    @Override // android.support.v4.widget.SwipeRefreshLayout
    @Deprecated
    public void setOnRefreshListener(@Nullable SwipeRefreshLayout.OnRefreshListener onRefreshListener) {
        super.setOnRefreshListener(onRefreshListener);
    }

    public void setLayoutManager(RecyclerView.LayoutManager layoutManager) {
        this.ntp.setLayoutManager(layoutManager);
    }

    public RecyclerView.LayoutManager getLayoutManager() {
        return this.ntp.getLayoutManager();
    }

    public void addItemDecoration(RecyclerView.ItemDecoration itemDecoration) {
        this.ntp.addItemDecoration(itemDecoration);
    }

    public void scrollToPosition(int i) {
        this.ntp.scrollToPosition(i);
    }

    public void setItemDecration(RecyclerView.ItemDecoration itemDecoration) {
        this.ntp.addItemDecoration(itemDecoration);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                this.nty = false;
                this.startY = motionEvent.getY();
                this.startX = motionEvent.getX();
                break;
            case 2:
                float y = motionEvent.getY();
                float abs = Math.abs(y - this.startY);
                float f = y - this.startY;
                if (abs > this.gLb && f < 0.0f) {
                    this.nty = true;
                    break;
                } else {
                    this.nty = false;
                    break;
                }
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public void setSmallPageSize(int i) {
        this.ntu = i;
    }
}
