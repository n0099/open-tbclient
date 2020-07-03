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
    private c nxB;
    private CBLoopViewPager nxI;
    private int nxK;
    private int hoP = 0;
    private int nxJ = 0;
    private PagerSnapHelper nxL = new PagerSnapHelper();

    public void a(final CBLoopViewPager cBLoopViewPager) {
        if (cBLoopViewPager != null) {
            this.nxI = cBLoopViewPager;
            cBLoopViewPager.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: com.kascend.chushou.widget.convenientbanner.b.a.1
                @Override // android.support.v7.widget.RecyclerView.OnScrollListener
                public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                    super.onScrollStateChanged(recyclerView, i);
                    int currentItem = a.this.getCurrentItem();
                    int buT = ((com.kascend.chushou.widget.convenientbanner.a.a) cBLoopViewPager.getAdapter()).buT();
                    if (i == 0 && a.this.nxB != null) {
                        a.this.nxB.onScrollStateChanged(recyclerView, i);
                        a.this.nxB.onPageSelected(currentItem % buT);
                    }
                }

                @Override // android.support.v7.widget.RecyclerView.OnScrollListener
                public void onScrolled(RecyclerView recyclerView, int i, int i2) {
                    super.onScrolled(recyclerView, i, i2);
                    if (a.this.nxB != null) {
                        a.this.nxB.onScrolled(recyclerView, i, i2);
                    }
                    a.this.dLg();
                }
            });
            tJ();
            this.nxL.attachToRecyclerView(cBLoopViewPager);
        }
    }

    private void tJ() {
        this.nxI.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.kascend.chushou.widget.convenientbanner.b.a.2
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                a.this.nxI.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                a.this.scrollToPosition(a.this.nxK);
            }
        });
    }

    public void setCurrentItem(int i) {
        setCurrentItem(i, false);
    }

    public void setCurrentItem(int i, boolean z) {
        if (this.nxI != null) {
            if (z) {
                this.nxI.smoothScrollToPosition(i);
            } else {
                scrollToPosition(i);
            }
        }
    }

    public void scrollToPosition(int i) {
        if (this.nxI != null) {
            ((LinearLayoutManager) this.nxI.getLayoutManager()).scrollToPositionWithOffset(i, this.hoP + this.nxJ);
            this.nxI.post(new Runnable() { // from class: com.kascend.chushou.widget.convenientbanner.b.a.3
                @Override // java.lang.Runnable
                public void run() {
                    a.this.dLg();
                }
            });
        }
    }

    public void Kw(int i) {
        this.nxK = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dLg() {
    }

    public int getCurrentItem() {
        View findSnapView = this.nxL.findSnapView(this.nxI.getLayoutManager());
        if (findSnapView != null) {
            return this.nxI.getLayoutManager().getPosition(findSnapView);
        }
        return 0;
    }

    public int dLh() {
        return getCurrentItem() % ((com.kascend.chushou.widget.convenientbanner.a.a) this.nxI.getAdapter()).buT();
    }

    public int dLi() {
        return this.nxK;
    }

    public void a(c cVar) {
        this.nxB = cVar;
    }
}
