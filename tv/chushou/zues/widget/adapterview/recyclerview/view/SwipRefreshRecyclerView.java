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
    private boolean fFj;
    private float hFm;
    private RecyclerView.OnScrollListener mOnScrollListener;
    private ExtendedRecyclerView oNM;
    private View oNN;
    private b oNO;
    private boolean oNP;
    private boolean oNQ;
    private int oNR;
    private int oNS;
    private f oNT;
    private RecyclerView.OnScrollListener oNU;
    private boolean oNV;
    private float startX;
    private float startY;

    public SwipRefreshRecyclerView(Context context) {
        this(context, null);
    }

    public SwipRefreshRecyclerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fFj = false;
        this.oNP = true;
        this.oNQ = true;
        this.oNR = 9;
        this.oNS = 20;
        this.mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: tv.chushou.zues.widget.adapterview.recyclerview.view.SwipRefreshRecyclerView.3
            private int oNX = -1;

            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i, int i2) {
                boolean z = false;
                super.onScrolled(recyclerView, i, i2);
                if (SwipRefreshRecyclerView.this.oNU != null) {
                    SwipRefreshRecyclerView.this.oNU.onScrolled(recyclerView, i, i2);
                }
                if (SwipRefreshRecyclerView.this.oNM.getLayoutManager() != null) {
                    this.oNX = a.e(SwipRefreshRecyclerView.this.oNM.getLayoutManager());
                    if (Build.VERSION.SDK_INT < 21) {
                        int top = (recyclerView == null || recyclerView.getChildCount() == 0) ? 0 : recyclerView.getChildAt(0).getTop();
                        SwipRefreshRecyclerView swipRefreshRecyclerView = SwipRefreshRecyclerView.this;
                        if (top >= recyclerView.getPaddingTop() && SwipRefreshRecyclerView.this.oNQ) {
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
                if (SwipRefreshRecyclerView.this.oNU != null) {
                    SwipRefreshRecyclerView.this.oNU.onScrollStateChanged(recyclerView, i);
                }
                RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
                if (layoutManager != null && (adapter = recyclerView.getAdapter()) != null) {
                    int childCount = layoutManager.getChildCount();
                    int itemCount = layoutManager.getItemCount();
                    if (childCount > 0 && i == 0 && this.oNX >= itemCount - 1 && SwipRefreshRecyclerView.this.oNV && !SwipRefreshRecyclerView.this.fFj && SwipRefreshRecyclerView.this.oNP && SwipRefreshRecyclerView.this.oNO != null && adapter.getItemCount() > SwipRefreshRecyclerView.this.oNR) {
                        SwipRefreshRecyclerView.this.oNO.bFD();
                        SwipRefreshRecyclerView.this.fFj = true;
                    }
                }
            }
        };
        this.oNM = new ExtendedRecyclerView(getContext(), attributeSet);
        this.oNM.setId(b.e.zues_swiperefresh_recyclerview);
        RecyclerView.ItemAnimator itemAnimator = this.oNM.getItemAnimator();
        if (itemAnimator instanceof SimpleItemAnimator) {
            ((SimpleItemAnimator) itemAnimator).setSupportsChangeAnimations(false);
        }
        this.oNM.setHasFixedSize(true);
        addView(this.oNM, new ViewGroup.LayoutParams(-1, -1));
        setColorSchemeResources(17170452, 17170459, 17170452, 17170459);
        this.oNM.addOnScrollListener(this.mOnScrollListener);
        super.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() { // from class: tv.chushou.zues.widget.adapterview.recyclerview.view.SwipRefreshRecyclerView.1
            @Override // android.support.v4.widget.SwipeRefreshLayout.OnRefreshListener
            public void onRefresh() {
                if (SwipRefreshRecyclerView.this.oNT != null) {
                    SwipRefreshRecyclerView.this.oNP = true;
                    tv.chushou.zues.widget.adapterview.recyclerview.a.b adapter = SwipRefreshRecyclerView.this.getAdapter();
                    if (adapter != null) {
                        adapter.emr();
                    }
                    SwipRefreshRecyclerView.this.oNT.onRefresh();
                }
            }
        });
        setEnabled(this.oNQ);
        if (Build.VERSION.SDK_INT < 21) {
            setCanChildScrollUpCallback(new CustomSwipeRefreshLayout.a() { // from class: tv.chushou.zues.widget.adapterview.recyclerview.view.SwipRefreshRecyclerView.2
                @Override // tv.chushou.zues.widget.adapterview.CustomSwipeRefreshLayout.a
                public boolean emp() {
                    return SwipRefreshRecyclerView.this.oNM != null && SwipRefreshRecyclerView.this.oNM.getScrollY() > 0;
                }
            });
        }
        this.hFm = ViewConfiguration.get(context).getScaledTouchSlop();
    }

    public void setOnePageSize(int i) {
        this.oNS = i;
    }

    public ExtendedRecyclerView getInnerRecyclerView() {
        return this.oNM;
    }

    public void setHasFixedSize(boolean z) {
        this.oNM.setHasFixedSize(z);
    }

    public void setUpDefault() {
        this.oNM.setLayoutManager(new LinearLayoutManager(getContext()));
        this.oNN = new DefaultLoadMoreView(getContext());
    }

    public void setAdapter(RecyclerView.Adapter adapter) {
        this.oNM.setAdapter(adapter);
        if (this.oNO != null) {
            this.oNM.setLoadMoreProvider(this);
        }
    }

    public tv.chushou.zues.widget.adapterview.recyclerview.a.b getAdapter() {
        return this.oNM.getAdapter();
    }

    public boolean OK(int i) {
        return this.oNM.OK(i);
    }

    public int getHeaderViewCount() {
        return this.oNM.getHeaderViewCount();
    }

    public boolean OL(int i) {
        return this.oNM.OL(i);
    }

    public int getFooterViewCount() {
        return this.oNM.getFooterViewCount();
    }

    public void setEmptyView(@NonNull View view) {
        this.oNM.setEmptyView(view);
    }

    @Nullable
    public View getEmptyView() {
        return this.oNM.getEmptyView();
    }

    public void setLoadMoreListener(tv.chushou.zues.widget.adapterview.b bVar) {
        this.oNO = bVar;
        if (getAdapter() != null) {
            this.oNM.setLoadMoreProvider(this);
        }
    }

    public void setLoadMoreFooter(@NonNull View view) {
        this.oNN = view;
    }

    public void emu() {
        this.fFj = false;
    }

    @Override // tv.chushou.zues.widget.adapterview.c
    public void OG(int i) {
        if (this.oNP && this.oNM.getAdapter() != null) {
            if (this.oNN == null) {
                this.oNN = new DefaultLoadMoreView(getContext());
            }
            if (i >= this.oNS) {
                if (!this.oNM.dH(this.oNN)) {
                    this.oNM.addFooterView(this.oNN, 0);
                }
            } else if (this.oNM.dH(this.oNN)) {
                this.oNM.dF(this.oNN);
            }
            this.fFj = false;
        }
    }

    @Override // tv.chushou.zues.widget.adapterview.c
    public boolean emq() {
        if (this.oNN == null) {
            this.oNN = new DefaultLoadMoreView(getContext());
        }
        return this.oNM.dH(this.oNN);
    }

    public void setHasMoreItems(boolean z) {
        this.oNP = z;
        if (!z && this.oNM.dH(this.oNN)) {
            this.oNM.dF(this.oNN);
        }
    }

    public void setPullToRefreshEnabled(boolean z) {
        this.oNQ = z;
        setEnabled(this.oNQ);
    }

    public void completeRefresh() {
        setRefreshing(false);
    }

    public void setPullToRefreshListener(f fVar) {
        this.oNT = fVar;
    }

    @Override // android.support.v4.widget.SwipeRefreshLayout
    @Deprecated
    public void setOnRefreshListener(@Nullable SwipeRefreshLayout.OnRefreshListener onRefreshListener) {
        super.setOnRefreshListener(onRefreshListener);
    }

    public void setLayoutManager(RecyclerView.LayoutManager layoutManager) {
        this.oNM.setLayoutManager(layoutManager);
    }

    public RecyclerView.LayoutManager getLayoutManager() {
        return this.oNM.getLayoutManager();
    }

    public void addItemDecoration(RecyclerView.ItemDecoration itemDecoration) {
        this.oNM.addItemDecoration(itemDecoration);
    }

    public void scrollToPosition(int i) {
        this.oNM.scrollToPosition(i);
    }

    public void setItemDecration(RecyclerView.ItemDecoration itemDecoration) {
        this.oNM.addItemDecoration(itemDecoration);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                this.oNV = false;
                this.startY = motionEvent.getY();
                this.startX = motionEvent.getX();
                break;
            case 2:
                float y = motionEvent.getY();
                float abs = Math.abs(y - this.startY);
                float f = y - this.startY;
                if (abs > this.hFm && f < 0.0f) {
                    this.oNV = true;
                    break;
                } else {
                    this.oNV = false;
                    break;
                }
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public void setSmallPageSize(int i) {
        this.oNR = i;
    }
}
