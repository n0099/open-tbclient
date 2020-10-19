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
    private c ozF;
    private CBLoopViewPager ozM;
    private int ozO;
    private int idW = 0;
    private int ozN = 0;
    private PagerSnapHelper ozP = new PagerSnapHelper();

    public void a(final CBLoopViewPager cBLoopViewPager) {
        if (cBLoopViewPager != null) {
            this.ozM = cBLoopViewPager;
            cBLoopViewPager.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: com.kascend.chushou.widget.convenientbanner.b.a.1
                @Override // android.support.v7.widget.RecyclerView.OnScrollListener
                public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                    super.onScrollStateChanged(recyclerView, i);
                    int currentItem = a.this.getCurrentItem();
                    int bLd = ((com.kascend.chushou.widget.convenientbanner.a.a) cBLoopViewPager.getAdapter()).bLd();
                    if (i == 0 && a.this.ozF != null) {
                        a.this.ozF.onScrollStateChanged(recyclerView, i);
                        a.this.ozF.onPageSelected(currentItem % bLd);
                    }
                }

                @Override // android.support.v7.widget.RecyclerView.OnScrollListener
                public void onScrolled(RecyclerView recyclerView, int i, int i2) {
                    super.onScrolled(recyclerView, i, i2);
                    if (a.this.ozF != null) {
                        a.this.ozF.onScrolled(recyclerView, i, i2);
                    }
                    a.this.eiA();
                }
            });
            zB();
            this.ozP.attachToRecyclerView(cBLoopViewPager);
        }
    }

    private void zB() {
        this.ozM.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.kascend.chushou.widget.convenientbanner.b.a.2
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                a.this.ozM.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                a.this.scrollToPosition(a.this.ozO);
            }
        });
    }

    public void setCurrentItem(int i) {
        setCurrentItem(i, false);
    }

    public void setCurrentItem(int i, boolean z) {
        if (this.ozM != null) {
            if (z) {
                this.ozM.smoothScrollToPosition(i);
            } else {
                scrollToPosition(i);
            }
        }
    }

    public void scrollToPosition(int i) {
        if (this.ozM != null) {
            ((LinearLayoutManager) this.ozM.getLayoutManager()).scrollToPositionWithOffset(i, this.idW + this.ozN);
            this.ozM.post(new Runnable() { // from class: com.kascend.chushou.widget.convenientbanner.b.a.3
                @Override // java.lang.Runnable
                public void run() {
                    a.this.eiA();
                }
            });
        }
    }

    public void OF(int i) {
        this.ozO = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eiA() {
    }

    public int getCurrentItem() {
        View findSnapView = this.ozP.findSnapView(this.ozM.getLayoutManager());
        if (findSnapView != null) {
            return this.ozM.getLayoutManager().getPosition(findSnapView);
        }
        return 0;
    }

    public int eiB() {
        return getCurrentItem() % ((com.kascend.chushou.widget.convenientbanner.a.a) this.ozM.getAdapter()).bLd();
    }

    public int eiC() {
        return this.ozO;
    }

    public void a(c cVar) {
        this.ozF = cVar;
    }
}
