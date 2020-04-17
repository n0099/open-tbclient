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
    private CBLoopViewPager mGC;
    private int mGE;
    private c mGv;
    private int gNB = 0;
    private int mGD = 0;
    private PagerSnapHelper mGF = new PagerSnapHelper();

    public void a(final CBLoopViewPager cBLoopViewPager) {
        if (cBLoopViewPager != null) {
            this.mGC = cBLoopViewPager;
            cBLoopViewPager.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: com.kascend.chushou.widget.convenientbanner.b.a.1
                @Override // android.support.v7.widget.RecyclerView.OnScrollListener
                public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                    super.onScrollStateChanged(recyclerView, i);
                    int currentItem = a.this.getCurrentItem();
                    int bmz = ((com.kascend.chushou.widget.convenientbanner.a.a) cBLoopViewPager.getAdapter()).bmz();
                    if (i == 0 && a.this.mGv != null) {
                        a.this.mGv.onScrollStateChanged(recyclerView, i);
                        a.this.mGv.onPageSelected(currentItem % bmz);
                    }
                }

                @Override // android.support.v7.widget.RecyclerView.OnScrollListener
                public void onScrolled(RecyclerView recyclerView, int i, int i2) {
                    super.onScrolled(recyclerView, i, i2);
                    if (a.this.mGv != null) {
                        a.this.mGv.onScrolled(recyclerView, i, i2);
                    }
                    a.this.dyX();
                }
            });
            ti();
            this.mGF.attachToRecyclerView(cBLoopViewPager);
        }
    }

    private void ti() {
        this.mGC.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.kascend.chushou.widget.convenientbanner.b.a.2
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                a.this.mGC.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                a.this.scrollToPosition(a.this.mGE);
            }
        });
    }

    public void setCurrentItem(int i) {
        setCurrentItem(i, false);
    }

    public void setCurrentItem(int i, boolean z) {
        if (this.mGC != null) {
            if (z) {
                this.mGC.smoothScrollToPosition(i);
            } else {
                scrollToPosition(i);
            }
        }
    }

    public void scrollToPosition(int i) {
        if (this.mGC != null) {
            ((LinearLayoutManager) this.mGC.getLayoutManager()).scrollToPositionWithOffset(i, this.gNB + this.mGD);
            this.mGC.post(new Runnable() { // from class: com.kascend.chushou.widget.convenientbanner.b.a.3
                @Override // java.lang.Runnable
                public void run() {
                    a.this.dyX();
                }
            });
        }
    }

    public void IC(int i) {
        this.mGE = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dyX() {
    }

    public int getCurrentItem() {
        View findSnapView = this.mGF.findSnapView(this.mGC.getLayoutManager());
        if (findSnapView != null) {
            return this.mGC.getLayoutManager().getPosition(findSnapView);
        }
        return 0;
    }

    public int dyY() {
        return getCurrentItem() % ((com.kascend.chushou.widget.convenientbanner.a.a) this.mGC.getAdapter()).bmz();
    }

    public int dyZ() {
        return this.mGE;
    }

    public void a(c cVar) {
        this.mGv = cVar;
    }
}
