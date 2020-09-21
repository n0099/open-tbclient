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
    private c okm;
    private CBLoopViewPager okt;
    private int okv;
    private int hOX = 0;
    private int oku = 0;
    private PagerSnapHelper okw = new PagerSnapHelper();

    public void a(final CBLoopViewPager cBLoopViewPager) {
        if (cBLoopViewPager != null) {
            this.okt = cBLoopViewPager;
            cBLoopViewPager.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: com.kascend.chushou.widget.convenientbanner.b.a.1
                @Override // android.support.v7.widget.RecyclerView.OnScrollListener
                public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                    super.onScrollStateChanged(recyclerView, i);
                    int currentItem = a.this.getCurrentItem();
                    int bIt = ((com.kascend.chushou.widget.convenientbanner.a.a) cBLoopViewPager.getAdapter()).bIt();
                    if (i == 0 && a.this.okm != null) {
                        a.this.okm.onScrollStateChanged(recyclerView, i);
                        a.this.okm.onPageSelected(currentItem % bIt);
                    }
                }

                @Override // android.support.v7.widget.RecyclerView.OnScrollListener
                public void onScrolled(RecyclerView recyclerView, int i, int i2) {
                    super.onScrolled(recyclerView, i, i2);
                    if (a.this.okm != null) {
                        a.this.okm.onScrolled(recyclerView, i, i2);
                    }
                    a.this.eeP();
                }
            });
            zt();
            this.okw.attachToRecyclerView(cBLoopViewPager);
        }
    }

    private void zt() {
        this.okt.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.kascend.chushou.widget.convenientbanner.b.a.2
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                a.this.okt.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                a.this.scrollToPosition(a.this.okv);
            }
        });
    }

    public void setCurrentItem(int i) {
        setCurrentItem(i, false);
    }

    public void setCurrentItem(int i, boolean z) {
        if (this.okt != null) {
            if (z) {
                this.okt.smoothScrollToPosition(i);
            } else {
                scrollToPosition(i);
            }
        }
    }

    public void scrollToPosition(int i) {
        if (this.okt != null) {
            ((LinearLayoutManager) this.okt.getLayoutManager()).scrollToPositionWithOffset(i, this.hOX + this.oku);
            this.okt.post(new Runnable() { // from class: com.kascend.chushou.widget.convenientbanner.b.a.3
                @Override // java.lang.Runnable
                public void run() {
                    a.this.eeP();
                }
            });
        }
    }

    public void NZ(int i) {
        this.okv = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eeP() {
    }

    public int getCurrentItem() {
        View findSnapView = this.okw.findSnapView(this.okt.getLayoutManager());
        if (findSnapView != null) {
            return this.okt.getLayoutManager().getPosition(findSnapView);
        }
        return 0;
    }

    public int eeQ() {
        return getCurrentItem() % ((com.kascend.chushou.widget.convenientbanner.a.a) this.okt.getAdapter()).bIt();
    }

    public int eeR() {
        return this.okv;
    }

    public void a(c cVar) {
        this.okm = cVar;
    }
}
