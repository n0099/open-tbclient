package com.kascend.chushou.widget.convenientbanner.b;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.PagerSnapHelper;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewTreeObserver;
import com.kascend.chushou.widget.convenientbanner.d.c;
import com.kascend.chushou.widget.convenientbanner.view.CBLoopViewPager;
/* loaded from: classes6.dex */
public class a {
    private c pBY;
    private CBLoopViewPager pCf;
    private int pCh;
    private int ixg = 0;
    private int pCg = 0;
    private PagerSnapHelper pCi = new PagerSnapHelper();

    public void a(final CBLoopViewPager cBLoopViewPager) {
        if (cBLoopViewPager != null) {
            this.pCf = cBLoopViewPager;
            cBLoopViewPager.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: com.kascend.chushou.widget.convenientbanner.b.a.1
                @Override // android.support.v7.widget.RecyclerView.OnScrollListener
                public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                    super.onScrollStateChanged(recyclerView, i);
                    int currentItem = a.this.getCurrentItem();
                    int bPy = ((com.kascend.chushou.widget.convenientbanner.a.a) cBLoopViewPager.getAdapter()).bPy();
                    if (i == 0 && a.this.pBY != null) {
                        a.this.pBY.onScrollStateChanged(recyclerView, i);
                        a.this.pBY.onPageSelected(currentItem % bPy);
                    }
                }

                @Override // android.support.v7.widget.RecyclerView.OnScrollListener
                public void onScrolled(RecyclerView recyclerView, int i, int i2) {
                    super.onScrolled(recyclerView, i, i2);
                    if (a.this.pBY != null) {
                        a.this.pBY.onScrolled(recyclerView, i, i2);
                    }
                    a.this.ewq();
                }
            });
            ewp();
            this.pCi.attachToRecyclerView(cBLoopViewPager);
        }
    }

    private void ewp() {
        this.pCf.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.kascend.chushou.widget.convenientbanner.b.a.2
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                a.this.pCf.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                a.this.scrollToPosition(a.this.pCh);
            }
        });
    }

    public void setCurrentItem(int i) {
        setCurrentItem(i, false);
    }

    public void setCurrentItem(int i, boolean z) {
        if (this.pCf != null) {
            if (z) {
                this.pCf.smoothScrollToPosition(i);
            } else {
                scrollToPosition(i);
            }
        }
    }

    public void scrollToPosition(int i) {
        if (this.pCf != null) {
            ((LinearLayoutManager) this.pCf.getLayoutManager()).scrollToPositionWithOffset(i, this.ixg + this.pCg);
            this.pCf.post(new Runnable() { // from class: com.kascend.chushou.widget.convenientbanner.b.a.3
                @Override // java.lang.Runnable
                public void run() {
                    a.this.ewq();
                }
            });
        }
    }

    public void Ru(int i) {
        this.pCh = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ewq() {
    }

    public int getCurrentItem() {
        View findSnapView = this.pCi.findSnapView(this.pCf.getLayoutManager());
        if (findSnapView != null) {
            return this.pCf.getLayoutManager().getPosition(findSnapView);
        }
        return 0;
    }

    public int ewr() {
        return getCurrentItem() % ((com.kascend.chushou.widget.convenientbanner.a.a) this.pCf.getAdapter()).bPy();
    }

    public int ews() {
        return this.pCh;
    }

    public void a(c cVar) {
        this.pBY = cVar;
    }
}
