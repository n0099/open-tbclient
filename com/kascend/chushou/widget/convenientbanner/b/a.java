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
    private CBLoopViewPager pAC;
    private int pAE;
    private c pAv;
    private int iwr = 0;
    private int pAD = 0;
    private PagerSnapHelper pAF = new PagerSnapHelper();

    public void a(final CBLoopViewPager cBLoopViewPager) {
        if (cBLoopViewPager != null) {
            this.pAC = cBLoopViewPager;
            cBLoopViewPager.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: com.kascend.chushou.widget.convenientbanner.b.a.1
                @Override // android.support.v7.widget.RecyclerView.OnScrollListener
                public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                    super.onScrollStateChanged(recyclerView, i);
                    int currentItem = a.this.getCurrentItem();
                    int bQf = ((com.kascend.chushou.widget.convenientbanner.a.a) cBLoopViewPager.getAdapter()).bQf();
                    if (i == 0 && a.this.pAv != null) {
                        a.this.pAv.onScrollStateChanged(recyclerView, i);
                        a.this.pAv.onPageSelected(currentItem % bQf);
                    }
                }

                @Override // android.support.v7.widget.RecyclerView.OnScrollListener
                public void onScrolled(RecyclerView recyclerView, int i, int i2) {
                    super.onScrolled(recyclerView, i, i2);
                    if (a.this.pAv != null) {
                        a.this.pAv.onScrolled(recyclerView, i, i2);
                    }
                    a.this.ewp();
                }
            });
            zB();
            this.pAF.attachToRecyclerView(cBLoopViewPager);
        }
    }

    private void zB() {
        this.pAC.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.kascend.chushou.widget.convenientbanner.b.a.2
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                a.this.pAC.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                a.this.scrollToPosition(a.this.pAE);
            }
        });
    }

    public void setCurrentItem(int i) {
        setCurrentItem(i, false);
    }

    public void setCurrentItem(int i, boolean z) {
        if (this.pAC != null) {
            if (z) {
                this.pAC.smoothScrollToPosition(i);
            } else {
                scrollToPosition(i);
            }
        }
    }

    public void scrollToPosition(int i) {
        if (this.pAC != null) {
            ((LinearLayoutManager) this.pAC.getLayoutManager()).scrollToPositionWithOffset(i, this.iwr + this.pAD);
            this.pAC.post(new Runnable() { // from class: com.kascend.chushou.widget.convenientbanner.b.a.3
                @Override // java.lang.Runnable
                public void run() {
                    a.this.ewp();
                }
            });
        }
    }

    public void QR(int i) {
        this.pAE = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ewp() {
    }

    public int getCurrentItem() {
        View findSnapView = this.pAF.findSnapView(this.pAC.getLayoutManager());
        if (findSnapView != null) {
            return this.pAC.getLayoutManager().getPosition(findSnapView);
        }
        return 0;
    }

    public int ewq() {
        return getCurrentItem() % ((com.kascend.chushou.widget.convenientbanner.a.a) this.pAC.getAdapter()).bQf();
    }

    public int ewr() {
        return this.pAE;
    }

    public void a(c cVar) {
        this.pAv = cVar;
    }
}
