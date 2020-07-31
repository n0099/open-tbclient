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
    private c nGn;
    private CBLoopViewPager nGu;
    private int nGw;
    private int huB = 0;
    private int nGv = 0;
    private PagerSnapHelper nGx = new PagerSnapHelper();

    public void a(final CBLoopViewPager cBLoopViewPager) {
        if (cBLoopViewPager != null) {
            this.nGu = cBLoopViewPager;
            cBLoopViewPager.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: com.kascend.chushou.widget.convenientbanner.b.a.1
                @Override // android.support.v7.widget.RecyclerView.OnScrollListener
                public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                    super.onScrollStateChanged(recyclerView, i);
                    int currentItem = a.this.getCurrentItem();
                    int byd = ((com.kascend.chushou.widget.convenientbanner.a.a) cBLoopViewPager.getAdapter()).byd();
                    if (i == 0 && a.this.nGn != null) {
                        a.this.nGn.onScrollStateChanged(recyclerView, i);
                        a.this.nGn.onPageSelected(currentItem % byd);
                    }
                }

                @Override // android.support.v7.widget.RecyclerView.OnScrollListener
                public void onScrolled(RecyclerView recyclerView, int i, int i2) {
                    super.onScrolled(recyclerView, i, i2);
                    if (a.this.nGn != null) {
                        a.this.nGn.onScrolled(recyclerView, i, i2);
                    }
                    a.this.dOF();
                }
            });
            tJ();
            this.nGx.attachToRecyclerView(cBLoopViewPager);
        }
    }

    private void tJ() {
        this.nGu.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.kascend.chushou.widget.convenientbanner.b.a.2
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                a.this.nGu.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                a.this.scrollToPosition(a.this.nGw);
            }
        });
    }

    public void setCurrentItem(int i) {
        setCurrentItem(i, false);
    }

    public void setCurrentItem(int i, boolean z) {
        if (this.nGu != null) {
            if (z) {
                this.nGu.smoothScrollToPosition(i);
            } else {
                scrollToPosition(i);
            }
        }
    }

    public void scrollToPosition(int i) {
        if (this.nGu != null) {
            ((LinearLayoutManager) this.nGu.getLayoutManager()).scrollToPositionWithOffset(i, this.huB + this.nGv);
            this.nGu.post(new Runnable() { // from class: com.kascend.chushou.widget.convenientbanner.b.a.3
                @Override // java.lang.Runnable
                public void run() {
                    a.this.dOF();
                }
            });
        }
    }

    public void KQ(int i) {
        this.nGw = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dOF() {
    }

    public int getCurrentItem() {
        View findSnapView = this.nGx.findSnapView(this.nGu.getLayoutManager());
        if (findSnapView != null) {
            return this.nGu.getLayoutManager().getPosition(findSnapView);
        }
        return 0;
    }

    public int dOG() {
        return getCurrentItem() % ((com.kascend.chushou.widget.convenientbanner.a.a) this.nGu.getAdapter()).byd();
    }

    public int dOH() {
        return this.nGw;
    }

    public void a(c cVar) {
        this.nGn = cVar;
    }
}
