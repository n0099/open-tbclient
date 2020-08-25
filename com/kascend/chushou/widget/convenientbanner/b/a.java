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
    private c oag;
    private CBLoopViewPager oan;
    private int oap;
    private int hHQ = 0;
    private int oao = 0;
    private PagerSnapHelper oaq = new PagerSnapHelper();

    public void a(final CBLoopViewPager cBLoopViewPager) {
        if (cBLoopViewPager != null) {
            this.oan = cBLoopViewPager;
            cBLoopViewPager.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: com.kascend.chushou.widget.convenientbanner.b.a.1
                @Override // android.support.v7.widget.RecyclerView.OnScrollListener
                public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                    super.onScrollStateChanged(recyclerView, i);
                    int currentItem = a.this.getCurrentItem();
                    int bHc = ((com.kascend.chushou.widget.convenientbanner.a.a) cBLoopViewPager.getAdapter()).bHc();
                    if (i == 0 && a.this.oag != null) {
                        a.this.oag.onScrollStateChanged(recyclerView, i);
                        a.this.oag.onPageSelected(currentItem % bHc);
                    }
                }

                @Override // android.support.v7.widget.RecyclerView.OnScrollListener
                public void onScrolled(RecyclerView recyclerView, int i, int i2) {
                    super.onScrolled(recyclerView, i, i2);
                    if (a.this.oag != null) {
                        a.this.oag.onScrolled(recyclerView, i, i2);
                    }
                    a.this.eaI();
                }
            });
            zf();
            this.oaq.attachToRecyclerView(cBLoopViewPager);
        }
    }

    private void zf() {
        this.oan.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.kascend.chushou.widget.convenientbanner.b.a.2
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                a.this.oan.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                a.this.scrollToPosition(a.this.oap);
            }
        });
    }

    public void setCurrentItem(int i) {
        setCurrentItem(i, false);
    }

    public void setCurrentItem(int i, boolean z) {
        if (this.oan != null) {
            if (z) {
                this.oan.smoothScrollToPosition(i);
            } else {
                scrollToPosition(i);
            }
        }
    }

    public void scrollToPosition(int i) {
        if (this.oan != null) {
            ((LinearLayoutManager) this.oan.getLayoutManager()).scrollToPositionWithOffset(i, this.hHQ + this.oao);
            this.oan.post(new Runnable() { // from class: com.kascend.chushou.widget.convenientbanner.b.a.3
                @Override // java.lang.Runnable
                public void run() {
                    a.this.eaI();
                }
            });
        }
    }

    public void Nu(int i) {
        this.oap = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eaI() {
    }

    public int getCurrentItem() {
        View findSnapView = this.oaq.findSnapView(this.oan.getLayoutManager());
        if (findSnapView != null) {
            return this.oan.getLayoutManager().getPosition(findSnapView);
        }
        return 0;
    }

    public int eaJ() {
        return getCurrentItem() % ((com.kascend.chushou.widget.convenientbanner.a.a) this.oan.getAdapter()).bHc();
    }

    public int eaK() {
        return this.oap;
    }

    public void a(c cVar) {
        this.oag = cVar;
    }
}
