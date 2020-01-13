package com.kascend.chushou.widget.convenientbanner.b;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.PagerSnapHelper;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewTreeObserver;
import com.kascend.chushou.widget.convenientbanner.d.c;
import com.kascend.chushou.widget.convenientbanner.view.CBLoopViewPager;
/* loaded from: classes4.dex */
public class a {
    private c nhf;
    private CBLoopViewPager nhm;
    private int nho;
    private int gbt = 0;
    private int nhn = 0;
    private PagerSnapHelper nhp = new PagerSnapHelper();

    public void a(final CBLoopViewPager cBLoopViewPager) {
        if (cBLoopViewPager != null) {
            this.nhm = cBLoopViewPager;
            cBLoopViewPager.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: com.kascend.chushou.widget.convenientbanner.b.a.1
                @Override // android.support.v7.widget.RecyclerView.OnScrollListener
                public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                    super.onScrollStateChanged(recyclerView, i);
                    int currentItem = a.this.getCurrentItem();
                    int bbl = ((com.kascend.chushou.widget.convenientbanner.a.a) cBLoopViewPager.getAdapter()).bbl();
                    if (i == 0 && a.this.nhf != null) {
                        a.this.nhf.onScrollStateChanged(recyclerView, i);
                        a.this.nhf.onPageSelected(currentItem % bbl);
                    }
                }

                @Override // android.support.v7.widget.RecyclerView.OnScrollListener
                public void onScrolled(RecyclerView recyclerView, int i, int i2) {
                    super.onScrolled(recyclerView, i, i2);
                    if (a.this.nhf != null) {
                        a.this.nhf.onScrolled(recyclerView, i, i2);
                    }
                    a.this.dDj();
                }
            });
            oa();
            this.nhp.attachToRecyclerView(cBLoopViewPager);
        }
    }

    private void oa() {
        this.nhm.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.kascend.chushou.widget.convenientbanner.b.a.2
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                a.this.nhm.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                a.this.scrollToPosition(a.this.nho);
            }
        });
    }

    public void setCurrentItem(int i) {
        setCurrentItem(i, false);
    }

    public void setCurrentItem(int i, boolean z) {
        if (this.nhm != null) {
            if (z) {
                this.nhm.smoothScrollToPosition(i);
            } else {
                scrollToPosition(i);
            }
        }
    }

    public void scrollToPosition(int i) {
        if (this.nhm != null) {
            ((LinearLayoutManager) this.nhm.getLayoutManager()).scrollToPositionWithOffset(i, this.gbt + this.nhn);
            this.nhm.post(new Runnable() { // from class: com.kascend.chushou.widget.convenientbanner.b.a.3
                @Override // java.lang.Runnable
                public void run() {
                    a.this.dDj();
                }
            });
        }
    }

    public void MZ(int i) {
        this.nho = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dDj() {
    }

    public int getCurrentItem() {
        View findSnapView = this.nhp.findSnapView(this.nhm.getLayoutManager());
        if (findSnapView != null) {
            return this.nhm.getLayoutManager().getPosition(findSnapView);
        }
        return 0;
    }

    public int dDk() {
        return getCurrentItem() % ((com.kascend.chushou.widget.convenientbanner.a.a) this.nhm.getAdapter()).bbl();
    }

    public int dDl() {
        return this.nho;
    }

    public void a(c cVar) {
        this.nhf = cVar;
    }
}
