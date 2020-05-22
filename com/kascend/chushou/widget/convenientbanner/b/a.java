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
    private c naA;
    private CBLoopViewPager naH;
    private int naJ;
    private int hct = 0;
    private int naI = 0;
    private PagerSnapHelper naK = new PagerSnapHelper();

    public void a(final CBLoopViewPager cBLoopViewPager) {
        if (cBLoopViewPager != null) {
            this.naH = cBLoopViewPager;
            cBLoopViewPager.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: com.kascend.chushou.widget.convenientbanner.b.a.1
                @Override // android.support.v7.widget.RecyclerView.OnScrollListener
                public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                    super.onScrollStateChanged(recyclerView, i);
                    int currentItem = a.this.getCurrentItem();
                    int brV = ((com.kascend.chushou.widget.convenientbanner.a.a) cBLoopViewPager.getAdapter()).brV();
                    if (i == 0 && a.this.naA != null) {
                        a.this.naA.onScrollStateChanged(recyclerView, i);
                        a.this.naA.onPageSelected(currentItem % brV);
                    }
                }

                @Override // android.support.v7.widget.RecyclerView.OnScrollListener
                public void onScrolled(RecyclerView recyclerView, int i, int i2) {
                    super.onScrolled(recyclerView, i, i2);
                    if (a.this.naA != null) {
                        a.this.naA.onScrolled(recyclerView, i, i2);
                    }
                    a.this.dGm();
                }
            });
            tr();
            this.naK.attachToRecyclerView(cBLoopViewPager);
        }
    }

    private void tr() {
        this.naH.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.kascend.chushou.widget.convenientbanner.b.a.2
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                a.this.naH.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                a.this.scrollToPosition(a.this.naJ);
            }
        });
    }

    public void setCurrentItem(int i) {
        setCurrentItem(i, false);
    }

    public void setCurrentItem(int i, boolean z) {
        if (this.naH != null) {
            if (z) {
                this.naH.smoothScrollToPosition(i);
            } else {
                scrollToPosition(i);
            }
        }
    }

    public void scrollToPosition(int i) {
        if (this.naH != null) {
            ((LinearLayoutManager) this.naH.getLayoutManager()).scrollToPositionWithOffset(i, this.hct + this.naI);
            this.naH.post(new Runnable() { // from class: com.kascend.chushou.widget.convenientbanner.b.a.3
                @Override // java.lang.Runnable
                public void run() {
                    a.this.dGm();
                }
            });
        }
    }

    public void Jn(int i) {
        this.naJ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dGm() {
    }

    public int getCurrentItem() {
        View findSnapView = this.naK.findSnapView(this.naH.getLayoutManager());
        if (findSnapView != null) {
            return this.naH.getLayoutManager().getPosition(findSnapView);
        }
        return 0;
    }

    public int dGn() {
        return getCurrentItem() % ((com.kascend.chushou.widget.convenientbanner.a.a) this.naH.getAdapter()).brV();
    }

    public int dGo() {
        return this.naJ;
    }

    public void a(c cVar) {
        this.naA = cVar;
    }
}
