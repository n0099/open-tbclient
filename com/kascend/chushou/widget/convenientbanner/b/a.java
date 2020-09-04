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
    private CBLoopViewPager oaF;
    private int oaH;
    private c oay;
    private int hHW = 0;
    private int oaG = 0;
    private PagerSnapHelper oaI = new PagerSnapHelper();

    public void a(final CBLoopViewPager cBLoopViewPager) {
        if (cBLoopViewPager != null) {
            this.oaF = cBLoopViewPager;
            cBLoopViewPager.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: com.kascend.chushou.widget.convenientbanner.b.a.1
                @Override // android.support.v7.widget.RecyclerView.OnScrollListener
                public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                    super.onScrollStateChanged(recyclerView, i);
                    int currentItem = a.this.getCurrentItem();
                    int bHd = ((com.kascend.chushou.widget.convenientbanner.a.a) cBLoopViewPager.getAdapter()).bHd();
                    if (i == 0 && a.this.oay != null) {
                        a.this.oay.onScrollStateChanged(recyclerView, i);
                        a.this.oay.onPageSelected(currentItem % bHd);
                    }
                }

                @Override // android.support.v7.widget.RecyclerView.OnScrollListener
                public void onScrolled(RecyclerView recyclerView, int i, int i2) {
                    super.onScrolled(recyclerView, i, i2);
                    if (a.this.oay != null) {
                        a.this.oay.onScrolled(recyclerView, i, i2);
                    }
                    a.this.eaR();
                }
            });
            zf();
            this.oaI.attachToRecyclerView(cBLoopViewPager);
        }
    }

    private void zf() {
        this.oaF.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.kascend.chushou.widget.convenientbanner.b.a.2
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                a.this.oaF.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                a.this.scrollToPosition(a.this.oaH);
            }
        });
    }

    public void setCurrentItem(int i) {
        setCurrentItem(i, false);
    }

    public void setCurrentItem(int i, boolean z) {
        if (this.oaF != null) {
            if (z) {
                this.oaF.smoothScrollToPosition(i);
            } else {
                scrollToPosition(i);
            }
        }
    }

    public void scrollToPosition(int i) {
        if (this.oaF != null) {
            ((LinearLayoutManager) this.oaF.getLayoutManager()).scrollToPositionWithOffset(i, this.hHW + this.oaG);
            this.oaF.post(new Runnable() { // from class: com.kascend.chushou.widget.convenientbanner.b.a.3
                @Override // java.lang.Runnable
                public void run() {
                    a.this.eaR();
                }
            });
        }
    }

    public void Nu(int i) {
        this.oaH = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eaR() {
    }

    public int getCurrentItem() {
        View findSnapView = this.oaI.findSnapView(this.oaF.getLayoutManager());
        if (findSnapView != null) {
            return this.oaF.getLayoutManager().getPosition(findSnapView);
        }
        return 0;
    }

    public int eaS() {
        return getCurrentItem() % ((com.kascend.chushou.widget.convenientbanner.a.a) this.oaF.getAdapter()).bHd();
    }

    public int eaT() {
        return this.oaH;
    }

    public void a(c cVar) {
        this.oay = cVar;
    }
}
