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
    private c pra;
    private CBLoopViewPager prh;
    private int prj;
    private int iqu = 0;
    private int pri = 0;
    private PagerSnapHelper prk = new PagerSnapHelper();

    public void a(final CBLoopViewPager cBLoopViewPager) {
        if (cBLoopViewPager != null) {
            this.prh = cBLoopViewPager;
            cBLoopViewPager.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: com.kascend.chushou.widget.convenientbanner.b.a.1
                @Override // android.support.v7.widget.RecyclerView.OnScrollListener
                public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                    super.onScrollStateChanged(recyclerView, i);
                    int currentItem = a.this.getCurrentItem();
                    int bNF = ((com.kascend.chushou.widget.convenientbanner.a.a) cBLoopViewPager.getAdapter()).bNF();
                    if (i == 0 && a.this.pra != null) {
                        a.this.pra.onScrollStateChanged(recyclerView, i);
                        a.this.pra.onPageSelected(currentItem % bNF);
                    }
                }

                @Override // android.support.v7.widget.RecyclerView.OnScrollListener
                public void onScrolled(RecyclerView recyclerView, int i, int i2) {
                    super.onScrolled(recyclerView, i, i2);
                    if (a.this.pra != null) {
                        a.this.pra.onScrolled(recyclerView, i, i2);
                    }
                    a.this.esA();
                }
            });
            zB();
            this.prk.attachToRecyclerView(cBLoopViewPager);
        }
    }

    private void zB() {
        this.prh.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.kascend.chushou.widget.convenientbanner.b.a.2
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                a.this.prh.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                a.this.scrollToPosition(a.this.prj);
            }
        });
    }

    public void setCurrentItem(int i) {
        setCurrentItem(i, false);
    }

    public void setCurrentItem(int i, boolean z) {
        if (this.prh != null) {
            if (z) {
                this.prh.smoothScrollToPosition(i);
            } else {
                scrollToPosition(i);
            }
        }
    }

    public void scrollToPosition(int i) {
        if (this.prh != null) {
            ((LinearLayoutManager) this.prh.getLayoutManager()).scrollToPositionWithOffset(i, this.iqu + this.pri);
            this.prh.post(new Runnable() { // from class: com.kascend.chushou.widget.convenientbanner.b.a.3
                @Override // java.lang.Runnable
                public void run() {
                    a.this.esA();
                }
            });
        }
    }

    public void Qw(int i) {
        this.prj = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void esA() {
    }

    public int getCurrentItem() {
        View findSnapView = this.prk.findSnapView(this.prh.getLayoutManager());
        if (findSnapView != null) {
            return this.prh.getLayoutManager().getPosition(findSnapView);
        }
        return 0;
    }

    public int esB() {
        return getCurrentItem() % ((com.kascend.chushou.widget.convenientbanner.a.a) this.prh.getAdapter()).bNF();
    }

    public int esC() {
        return this.prj;
    }

    public void a(c cVar) {
        this.pra = cVar;
    }
}
