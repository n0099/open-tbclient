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
    private c nhN;
    private CBLoopViewPager nhU;
    private int nhW;
    private int gdu = 0;
    private int nhV = 0;
    private PagerSnapHelper nhX = new PagerSnapHelper();

    public void a(final CBLoopViewPager cBLoopViewPager) {
        if (cBLoopViewPager != null) {
            this.nhU = cBLoopViewPager;
            cBLoopViewPager.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: com.kascend.chushou.widget.convenientbanner.b.a.1
                @Override // android.support.v7.widget.RecyclerView.OnScrollListener
                public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                    super.onScrollStateChanged(recyclerView, i);
                    int currentItem = a.this.getCurrentItem();
                    int bdA = ((com.kascend.chushou.widget.convenientbanner.a.a) cBLoopViewPager.getAdapter()).bdA();
                    if (i == 0 && a.this.nhN != null) {
                        a.this.nhN.onScrollStateChanged(recyclerView, i);
                        a.this.nhN.onPageSelected(currentItem % bdA);
                    }
                }

                @Override // android.support.v7.widget.RecyclerView.OnScrollListener
                public void onScrolled(RecyclerView recyclerView, int i, int i2) {
                    super.onScrolled(recyclerView, i, i2);
                    if (a.this.nhN != null) {
                        a.this.nhN.onScrolled(recyclerView, i, i2);
                    }
                    a.this.dEs();
                }
            });
            oJ();
            this.nhX.attachToRecyclerView(cBLoopViewPager);
        }
    }

    private void oJ() {
        this.nhU.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.kascend.chushou.widget.convenientbanner.b.a.2
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                a.this.nhU.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                a.this.scrollToPosition(a.this.nhW);
            }
        });
    }

    public void setCurrentItem(int i) {
        setCurrentItem(i, false);
    }

    public void setCurrentItem(int i, boolean z) {
        if (this.nhU != null) {
            if (z) {
                this.nhU.smoothScrollToPosition(i);
            } else {
                scrollToPosition(i);
            }
        }
    }

    public void scrollToPosition(int i) {
        if (this.nhU != null) {
            ((LinearLayoutManager) this.nhU.getLayoutManager()).scrollToPositionWithOffset(i, this.gdu + this.nhV);
            this.nhU.post(new Runnable() { // from class: com.kascend.chushou.widget.convenientbanner.b.a.3
                @Override // java.lang.Runnable
                public void run() {
                    a.this.dEs();
                }
            });
        }
    }

    public void Nc(int i) {
        this.nhW = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dEs() {
    }

    public int getCurrentItem() {
        View findSnapView = this.nhX.findSnapView(this.nhU.getLayoutManager());
        if (findSnapView != null) {
            return this.nhU.getLayoutManager().getPosition(findSnapView);
        }
        return 0;
    }

    public int dEt() {
        return getCurrentItem() % ((com.kascend.chushou.widget.convenientbanner.a.a) this.nhU.getAdapter()).bdA();
    }

    public int dEu() {
        return this.nhW;
    }

    public void a(c cVar) {
        this.nhN = cVar;
    }
}
