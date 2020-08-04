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
    private c nGp;
    private CBLoopViewPager nGw;
    private int nGy;
    private int huB = 0;
    private int nGx = 0;
    private PagerSnapHelper nGz = new PagerSnapHelper();

    public void a(final CBLoopViewPager cBLoopViewPager) {
        if (cBLoopViewPager != null) {
            this.nGw = cBLoopViewPager;
            cBLoopViewPager.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: com.kascend.chushou.widget.convenientbanner.b.a.1
                @Override // android.support.v7.widget.RecyclerView.OnScrollListener
                public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                    super.onScrollStateChanged(recyclerView, i);
                    int currentItem = a.this.getCurrentItem();
                    int byd = ((com.kascend.chushou.widget.convenientbanner.a.a) cBLoopViewPager.getAdapter()).byd();
                    if (i == 0 && a.this.nGp != null) {
                        a.this.nGp.onScrollStateChanged(recyclerView, i);
                        a.this.nGp.onPageSelected(currentItem % byd);
                    }
                }

                @Override // android.support.v7.widget.RecyclerView.OnScrollListener
                public void onScrolled(RecyclerView recyclerView, int i, int i2) {
                    super.onScrolled(recyclerView, i, i2);
                    if (a.this.nGp != null) {
                        a.this.nGp.onScrolled(recyclerView, i, i2);
                    }
                    a.this.dOG();
                }
            });
            tJ();
            this.nGz.attachToRecyclerView(cBLoopViewPager);
        }
    }

    private void tJ() {
        this.nGw.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.kascend.chushou.widget.convenientbanner.b.a.2
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                a.this.nGw.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                a.this.scrollToPosition(a.this.nGy);
            }
        });
    }

    public void setCurrentItem(int i) {
        setCurrentItem(i, false);
    }

    public void setCurrentItem(int i, boolean z) {
        if (this.nGw != null) {
            if (z) {
                this.nGw.smoothScrollToPosition(i);
            } else {
                scrollToPosition(i);
            }
        }
    }

    public void scrollToPosition(int i) {
        if (this.nGw != null) {
            ((LinearLayoutManager) this.nGw.getLayoutManager()).scrollToPositionWithOffset(i, this.huB + this.nGx);
            this.nGw.post(new Runnable() { // from class: com.kascend.chushou.widget.convenientbanner.b.a.3
                @Override // java.lang.Runnable
                public void run() {
                    a.this.dOG();
                }
            });
        }
    }

    public void KQ(int i) {
        this.nGy = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dOG() {
    }

    public int getCurrentItem() {
        View findSnapView = this.nGz.findSnapView(this.nGw.getLayoutManager());
        if (findSnapView != null) {
            return this.nGw.getLayoutManager().getPosition(findSnapView);
        }
        return 0;
    }

    public int dOH() {
        return getCurrentItem() % ((com.kascend.chushou.widget.convenientbanner.a.a) this.nGw.getAdapter()).byd();
    }

    public int dOI() {
        return this.nGy;
    }

    public void a(c cVar) {
        this.nGp = cVar;
    }
}
