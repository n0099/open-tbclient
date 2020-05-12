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
    private c mGA;
    private CBLoopViewPager mGH;
    private int mGJ;
    private int gNH = 0;
    private int mGI = 0;
    private PagerSnapHelper mGK = new PagerSnapHelper();

    public void a(final CBLoopViewPager cBLoopViewPager) {
        if (cBLoopViewPager != null) {
            this.mGH = cBLoopViewPager;
            cBLoopViewPager.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: com.kascend.chushou.widget.convenientbanner.b.a.1
                @Override // android.support.v7.widget.RecyclerView.OnScrollListener
                public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                    super.onScrollStateChanged(recyclerView, i);
                    int currentItem = a.this.getCurrentItem();
                    int bmx = ((com.kascend.chushou.widget.convenientbanner.a.a) cBLoopViewPager.getAdapter()).bmx();
                    if (i == 0 && a.this.mGA != null) {
                        a.this.mGA.onScrollStateChanged(recyclerView, i);
                        a.this.mGA.onPageSelected(currentItem % bmx);
                    }
                }

                @Override // android.support.v7.widget.RecyclerView.OnScrollListener
                public void onScrolled(RecyclerView recyclerView, int i, int i2) {
                    super.onScrolled(recyclerView, i, i2);
                    if (a.this.mGA != null) {
                        a.this.mGA.onScrolled(recyclerView, i, i2);
                    }
                    a.this.dyU();
                }
            });
            th();
            this.mGK.attachToRecyclerView(cBLoopViewPager);
        }
    }

    private void th() {
        this.mGH.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.kascend.chushou.widget.convenientbanner.b.a.2
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                a.this.mGH.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                a.this.scrollToPosition(a.this.mGJ);
            }
        });
    }

    public void setCurrentItem(int i) {
        setCurrentItem(i, false);
    }

    public void setCurrentItem(int i, boolean z) {
        if (this.mGH != null) {
            if (z) {
                this.mGH.smoothScrollToPosition(i);
            } else {
                scrollToPosition(i);
            }
        }
    }

    public void scrollToPosition(int i) {
        if (this.mGH != null) {
            ((LinearLayoutManager) this.mGH.getLayoutManager()).scrollToPositionWithOffset(i, this.gNH + this.mGI);
            this.mGH.post(new Runnable() { // from class: com.kascend.chushou.widget.convenientbanner.b.a.3
                @Override // java.lang.Runnable
                public void run() {
                    a.this.dyU();
                }
            });
        }
    }

    public void IC(int i) {
        this.mGJ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dyU() {
    }

    public int getCurrentItem() {
        View findSnapView = this.mGK.findSnapView(this.mGH.getLayoutManager());
        if (findSnapView != null) {
            return this.mGH.getLayoutManager().getPosition(findSnapView);
        }
        return 0;
    }

    public int dyV() {
        return getCurrentItem() % ((com.kascend.chushou.widget.convenientbanner.a.a) this.mGH.getAdapter()).bmx();
    }

    public int dyW() {
        return this.mGJ;
    }

    public void a(c cVar) {
        this.mGA = cVar;
    }
}
