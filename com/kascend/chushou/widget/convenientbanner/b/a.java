package com.kascend.chushou.widget.convenientbanner.b;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.PagerSnapHelper;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewTreeObserver;
import com.kascend.chushou.widget.convenientbanner.d.c;
import com.kascend.chushou.widget.convenientbanner.view.CBLoopViewPager;
/* loaded from: classes5.dex */
public class a {
    private c nxE;
    private CBLoopViewPager nxL;
    private int nxN;
    private int hoP = 0;
    private int nxM = 0;
    private PagerSnapHelper nxO = new PagerSnapHelper();

    public void a(final CBLoopViewPager cBLoopViewPager) {
        if (cBLoopViewPager != null) {
            this.nxL = cBLoopViewPager;
            cBLoopViewPager.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: com.kascend.chushou.widget.convenientbanner.b.a.1
                @Override // android.support.v7.widget.RecyclerView.OnScrollListener
                public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                    super.onScrollStateChanged(recyclerView, i);
                    int currentItem = a.this.getCurrentItem();
                    int buU = ((com.kascend.chushou.widget.convenientbanner.a.a) cBLoopViewPager.getAdapter()).buU();
                    if (i == 0 && a.this.nxE != null) {
                        a.this.nxE.onScrollStateChanged(recyclerView, i);
                        a.this.nxE.onPageSelected(currentItem % buU);
                    }
                }

                @Override // android.support.v7.widget.RecyclerView.OnScrollListener
                public void onScrolled(RecyclerView recyclerView, int i, int i2) {
                    super.onScrolled(recyclerView, i, i2);
                    if (a.this.nxE != null) {
                        a.this.nxE.onScrolled(recyclerView, i, i2);
                    }
                    a.this.dLk();
                }
            });
            tJ();
            this.nxO.attachToRecyclerView(cBLoopViewPager);
        }
    }

    private void tJ() {
        this.nxL.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.kascend.chushou.widget.convenientbanner.b.a.2
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                a.this.nxL.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                a.this.scrollToPosition(a.this.nxN);
            }
        });
    }

    public void setCurrentItem(int i) {
        setCurrentItem(i, false);
    }

    public void setCurrentItem(int i, boolean z) {
        if (this.nxL != null) {
            if (z) {
                this.nxL.smoothScrollToPosition(i);
            } else {
                scrollToPosition(i);
            }
        }
    }

    public void scrollToPosition(int i) {
        if (this.nxL != null) {
            ((LinearLayoutManager) this.nxL.getLayoutManager()).scrollToPositionWithOffset(i, this.hoP + this.nxM);
            this.nxL.post(new Runnable() { // from class: com.kascend.chushou.widget.convenientbanner.b.a.3
                @Override // java.lang.Runnable
                public void run() {
                    a.this.dLk();
                }
            });
        }
    }

    public void Kw(int i) {
        this.nxN = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dLk() {
    }

    public int getCurrentItem() {
        View findSnapView = this.nxO.findSnapView(this.nxL.getLayoutManager());
        if (findSnapView != null) {
            return this.nxL.getLayoutManager().getPosition(findSnapView);
        }
        return 0;
    }

    public int dLl() {
        return getCurrentItem() % ((com.kascend.chushou.widget.convenientbanner.a.a) this.nxL.getAdapter()).buU();
    }

    public int dLm() {
        return this.nxN;
    }

    public void a(c cVar) {
        this.nxE = cVar;
    }
}
