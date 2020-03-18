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
    private c njO;
    private CBLoopViewPager njV;
    private int njX;
    private int ges = 0;
    private int njW = 0;
    private PagerSnapHelper njY = new PagerSnapHelper();

    public void a(final CBLoopViewPager cBLoopViewPager) {
        if (cBLoopViewPager != null) {
            this.njV = cBLoopViewPager;
            cBLoopViewPager.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: com.kascend.chushou.widget.convenientbanner.b.a.1
                @Override // android.support.v7.widget.RecyclerView.OnScrollListener
                public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                    super.onScrollStateChanged(recyclerView, i);
                    int currentItem = a.this.getCurrentItem();
                    int bdI = ((com.kascend.chushou.widget.convenientbanner.a.a) cBLoopViewPager.getAdapter()).bdI();
                    if (i == 0 && a.this.njO != null) {
                        a.this.njO.onScrollStateChanged(recyclerView, i);
                        a.this.njO.onPageSelected(currentItem % bdI);
                    }
                }

                @Override // android.support.v7.widget.RecyclerView.OnScrollListener
                public void onScrolled(RecyclerView recyclerView, int i, int i2) {
                    super.onScrolled(recyclerView, i, i2);
                    if (a.this.njO != null) {
                        a.this.njO.onScrolled(recyclerView, i, i2);
                    }
                    a.this.dEV();
                }
            });
            oO();
            this.njY.attachToRecyclerView(cBLoopViewPager);
        }
    }

    private void oO() {
        this.njV.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.kascend.chushou.widget.convenientbanner.b.a.2
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                a.this.njV.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                a.this.scrollToPosition(a.this.njX);
            }
        });
    }

    public void setCurrentItem(int i) {
        setCurrentItem(i, false);
    }

    public void setCurrentItem(int i, boolean z) {
        if (this.njV != null) {
            if (z) {
                this.njV.smoothScrollToPosition(i);
            } else {
                scrollToPosition(i);
            }
        }
    }

    public void scrollToPosition(int i) {
        if (this.njV != null) {
            ((LinearLayoutManager) this.njV.getLayoutManager()).scrollToPositionWithOffset(i, this.ges + this.njW);
            this.njV.post(new Runnable() { // from class: com.kascend.chushou.widget.convenientbanner.b.a.3
                @Override // java.lang.Runnable
                public void run() {
                    a.this.dEV();
                }
            });
        }
    }

    public void Ni(int i) {
        this.njX = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dEV() {
    }

    public int getCurrentItem() {
        View findSnapView = this.njY.findSnapView(this.njV.getLayoutManager());
        if (findSnapView != null) {
            return this.njV.getLayoutManager().getPosition(findSnapView);
        }
        return 0;
    }

    public int dEW() {
        return getCurrentItem() % ((com.kascend.chushou.widget.convenientbanner.a.a) this.njV.getAdapter()).bdI();
    }

    public int dEX() {
        return this.njX;
    }

    public void a(c cVar) {
        this.njO = cVar;
    }
}
