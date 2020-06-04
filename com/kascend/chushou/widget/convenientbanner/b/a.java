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
    private c nbK;
    private CBLoopViewPager nbR;
    private int nbT;
    private int hcE = 0;
    private int nbS = 0;
    private PagerSnapHelper nbU = new PagerSnapHelper();

    public void a(final CBLoopViewPager cBLoopViewPager) {
        if (cBLoopViewPager != null) {
            this.nbR = cBLoopViewPager;
            cBLoopViewPager.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: com.kascend.chushou.widget.convenientbanner.b.a.1
                @Override // android.support.v7.widget.RecyclerView.OnScrollListener
                public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                    super.onScrollStateChanged(recyclerView, i);
                    int currentItem = a.this.getCurrentItem();
                    int brX = ((com.kascend.chushou.widget.convenientbanner.a.a) cBLoopViewPager.getAdapter()).brX();
                    if (i == 0 && a.this.nbK != null) {
                        a.this.nbK.onScrollStateChanged(recyclerView, i);
                        a.this.nbK.onPageSelected(currentItem % brX);
                    }
                }

                @Override // android.support.v7.widget.RecyclerView.OnScrollListener
                public void onScrolled(RecyclerView recyclerView, int i, int i2) {
                    super.onScrolled(recyclerView, i, i2);
                    if (a.this.nbK != null) {
                        a.this.nbK.onScrolled(recyclerView, i, i2);
                    }
                    a.this.dGA();
                }
            });
            tr();
            this.nbU.attachToRecyclerView(cBLoopViewPager);
        }
    }

    private void tr() {
        this.nbR.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.kascend.chushou.widget.convenientbanner.b.a.2
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                a.this.nbR.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                a.this.scrollToPosition(a.this.nbT);
            }
        });
    }

    public void setCurrentItem(int i) {
        setCurrentItem(i, false);
    }

    public void setCurrentItem(int i, boolean z) {
        if (this.nbR != null) {
            if (z) {
                this.nbR.smoothScrollToPosition(i);
            } else {
                scrollToPosition(i);
            }
        }
    }

    public void scrollToPosition(int i) {
        if (this.nbR != null) {
            ((LinearLayoutManager) this.nbR.getLayoutManager()).scrollToPositionWithOffset(i, this.hcE + this.nbS);
            this.nbR.post(new Runnable() { // from class: com.kascend.chushou.widget.convenientbanner.b.a.3
                @Override // java.lang.Runnable
                public void run() {
                    a.this.dGA();
                }
            });
        }
    }

    public void Jp(int i) {
        this.nbT = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dGA() {
    }

    public int getCurrentItem() {
        View findSnapView = this.nbU.findSnapView(this.nbR.getLayoutManager());
        if (findSnapView != null) {
            return this.nbR.getLayoutManager().getPosition(findSnapView);
        }
        return 0;
    }

    public int dGB() {
        return getCurrentItem() % ((com.kascend.chushou.widget.convenientbanner.a.a) this.nbR.getAdapter()).brX();
    }

    public int dGC() {
        return this.nbT;
    }

    public void a(c cVar) {
        this.nbK = cVar;
    }
}
