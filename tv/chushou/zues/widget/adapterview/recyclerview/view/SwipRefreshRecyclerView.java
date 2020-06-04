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
    private boolean fdv;
    private float gZY;
    private RecyclerView.OnScrollListener mOnScrollListener;
    private boolean nPA;
    private int nPB;
    private int nPC;
    private f nPD;
    private RecyclerView.OnScrollListener nPE;
    private boolean nPF;
    private ExtendedRecyclerView nPw;
    private View nPx;
    private b nPy;
    private boolean nPz;
    private float startX;
    private float startY;

    public SwipRefreshRecyclerView(Context context) {
        this(context, null);
    }

    public SwipRefreshRecyclerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fdv = false;
        this.nPz = true;
        this.nPA = true;
        this.nPB = 9;
        this.nPC = 20;
        this.mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: tv.chushou.zues.widget.adapterview.recyclerview.view.SwipRefreshRecyclerView.3
            private int nPH = -1;

            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i, int i2) {
                boolean z = false;
                super.onScrolled(recyclerView, i, i2);
                if (SwipRefreshRecyclerView.this.nPE != null) {
                    SwipRefreshRecyclerView.this.nPE.onScrolled(recyclerView, i, i2);
                }
                if (SwipRefreshRecyclerView.this.nPw.getLayoutManager() != null) {
                    this.nPH = a.e(SwipRefreshRecyclerView.this.nPw.getLayoutManager());
                    if (Build.VERSION.SDK_INT < 21) {
                        int top2 = (recyclerView == null || recyclerView.getChildCount() == 0) ? 0 : recyclerView.getChildAt(0).getTop();
                        SwipRefreshRecyclerView swipRefreshRecyclerView = SwipRefreshRecyclerView.this;
                        if (top2 >= recyclerView.getPaddingTop() && SwipRefreshRecyclerView.this.nPA) {
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
                if (SwipRefreshRecyclerView.this.nPE != null) {
                    SwipRefreshRecyclerView.this.nPE.onScrollStateChanged(recyclerView, i);
                }
                RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
                if (layoutManager != null && (adapter = recyclerView.getAdapter()) != null) {
                    int childCount = layoutManager.getChildCount();
                    int itemCount = layoutManager.getItemCount();
                    if (childCount > 0 && i == 0 && this.nPH >= itemCount - 1 && SwipRefreshRecyclerView.this.nPF && !SwipRefreshRecyclerView.this.fdv && SwipRefreshRecyclerView.this.nPz && SwipRefreshRecyclerView.this.nPy != null && adapter.getItemCount() > SwipRefreshRecyclerView.this.nPB) {
                        SwipRefreshRecyclerView.this.nPy.bqx();
                        SwipRefreshRecyclerView.this.fdv = true;
                    }
                }
            }
        };
        this.nPw = new ExtendedRecyclerView(getContext(), attributeSet);
        this.nPw.setId(b.e.zues_swiperefresh_recyclerview);
        RecyclerView.ItemAnimator itemAnimator = this.nPw.getItemAnimator();
        if (itemAnimator instanceof SimpleItemAnimator) {
            ((SimpleItemAnimator) itemAnimator).setSupportsChangeAnimations(false);
        }
        this.nPw.setHasFixedSize(true);
        addView(this.nPw, new ViewGroup.LayoutParams(-1, -1));
        setColorSchemeResources(17170452, 17170459, 17170452, 17170459);
        this.nPw.addOnScrollListener(this.mOnScrollListener);
        super.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() { // from class: tv.chushou.zues.widget.adapterview.recyclerview.view.SwipRefreshRecyclerView.1
            @Override // android.support.v4.widget.SwipeRefreshLayout.OnRefreshListener
            public void onRefresh() {
                if (SwipRefreshRecyclerView.this.nPD != null) {
                    SwipRefreshRecyclerView.this.nPz = true;
                    tv.chushou.zues.widget.adapterview.recyclerview.a.b adapter = SwipRefreshRecyclerView.this.getAdapter();
                    if (adapter != null) {
                        adapter.dSh();
                    }
                    SwipRefreshRecyclerView.this.nPD.onRefresh();
                }
            }
        });
        setEnabled(this.nPA);
        if (Build.VERSION.SDK_INT < 21) {
            setCanChildScrollUpCallback(new CustomSwipeRefreshLayout.a() { // from class: tv.chushou.zues.widget.adapterview.recyclerview.view.SwipRefreshRecyclerView.2
                @Override // tv.chushou.zues.widget.adapterview.CustomSwipeRefreshLayout.a
                public boolean dSf() {
                    return SwipRefreshRecyclerView.this.nPw != null && SwipRefreshRecyclerView.this.nPw.getScrollY() > 0;
                }
            });
        }
        this.gZY = ViewConfiguration.get(context).getScaledTouchSlop();
    }

    public void setOnePageSize(int i) {
        this.nPC = i;
    }

    public ExtendedRecyclerView getInnerRecyclerView() {
        return this.nPw;
    }

    public void setHasFixedSize(boolean z) {
        this.nPw.setHasFixedSize(z);
    }

    public void setUpDefault() {
        this.nPw.setLayoutManager(new LinearLayoutManager(getContext()));
        this.nPx = new DefaultLoadMoreView(getContext());
    }

    public void setAdapter(RecyclerView.Adapter adapter) {
        this.nPw.setAdapter(adapter);
        if (this.nPy != null) {
            this.nPw.setLoadMoreProvider(this);
        }
    }

    public tv.chushou.zues.widget.adapterview.recyclerview.a.b getAdapter() {
        return this.nPw.getAdapter();
    }

    public boolean KH(int i) {
        return this.nPw.KH(i);
    }

    public int getHeaderViewCount() {
        return this.nPw.getHeaderViewCount();
    }

    public boolean KI(int i) {
        return this.nPw.KI(i);
    }

    public int getFooterViewCount() {
        return this.nPw.getFooterViewCount();
    }

    public void setEmptyView(@NonNull View view) {
        this.nPw.setEmptyView(view);
    }

    @Nullable
    public View getEmptyView() {
        return this.nPw.getEmptyView();
    }

    public void setLoadMoreListener(tv.chushou.zues.widget.adapterview.b bVar) {
        this.nPy = bVar;
        if (getAdapter() != null) {
            this.nPw.setLoadMoreProvider(this);
        }
    }

    public void setLoadMoreFooter(@NonNull View view) {
        this.nPx = view;
    }

    public void dSk() {
        this.fdv = false;
    }

    @Override // tv.chushou.zues.widget.adapterview.c
    public void KC(int i) {
        if (this.nPz && this.nPw.getAdapter() != null) {
            if (this.nPx == null) {
                this.nPx = new DefaultLoadMoreView(getContext());
            }
            if (i >= this.nPC) {
                if (!this.nPw.dy(this.nPx)) {
                    this.nPw.addFooterView(this.nPx, 0);
                }
            } else if (this.nPw.dy(this.nPx)) {
                this.nPw.dw(this.nPx);
            }
            this.fdv = false;
        }
    }

    @Override // tv.chushou.zues.widget.adapterview.c
    public boolean dSg() {
        if (this.nPx == null) {
            this.nPx = new DefaultLoadMoreView(getContext());
        }
        return this.nPw.dy(this.nPx);
    }

    public void setHasMoreItems(boolean z) {
        this.nPz = z;
        if (!z && this.nPw.dy(this.nPx)) {
            this.nPw.dw(this.nPx);
        }
    }

    public void setPullToRefreshEnabled(boolean z) {
        this.nPA = z;
        setEnabled(this.nPA);
    }

    public void completeRefresh() {
        setRefreshing(false);
    }

    public void setPullToRefreshListener(f fVar) {
        this.nPD = fVar;
    }

    @Override // android.support.v4.widget.SwipeRefreshLayout
    @Deprecated
    public void setOnRefreshListener(@Nullable SwipeRefreshLayout.OnRefreshListener onRefreshListener) {
        super.setOnRefreshListener(onRefreshListener);
    }

    public void setLayoutManager(RecyclerView.LayoutManager layoutManager) {
        this.nPw.setLayoutManager(layoutManager);
    }

    public RecyclerView.LayoutManager getLayoutManager() {
        return this.nPw.getLayoutManager();
    }

    public void addItemDecoration(RecyclerView.ItemDecoration itemDecoration) {
        this.nPw.addItemDecoration(itemDecoration);
    }

    public void scrollToPosition(int i) {
        this.nPw.scrollToPosition(i);
    }

    public void setItemDecration(RecyclerView.ItemDecoration itemDecoration) {
        this.nPw.addItemDecoration(itemDecoration);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                this.nPF = false;
                this.startY = motionEvent.getY();
                this.startX = motionEvent.getX();
                break;
            case 2:
                float y = motionEvent.getY();
                float abs = Math.abs(y - this.startY);
                float f = y - this.startY;
                if (abs > this.gZY && f < 0.0f) {
                    this.nPF = true;
                    break;
                } else {
                    this.nPF = false;
                    break;
                }
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public void setSmallPageSize(int i) {
        this.nPB = i;
    }
}
