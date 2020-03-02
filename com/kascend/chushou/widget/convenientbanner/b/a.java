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
    private c nhP;
    private CBLoopViewPager nhW;
    private int nhY;
    private int gdw = 0;
    private int nhX = 0;
    private PagerSnapHelper nhZ = new PagerSnapHelper();

    public void a(final CBLoopViewPager cBLoopViewPager) {
        if (cBLoopViewPager != null) {
            this.nhW = cBLoopViewPager;
            cBLoopViewPager.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: com.kascend.chushou.widget.convenientbanner.b.a.1
                @Override // android.support.v7.widget.RecyclerView.OnScrollListener
                public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                    super.onScrollStateChanged(recyclerView, i);
                    int currentItem = a.this.getCurrentItem();
                    int bdC = ((com.kascend.chushou.widget.convenientbanner.a.a) cBLoopViewPager.getAdapter()).bdC();
                    if (i == 0 && a.this.nhP != null) {
                        a.this.nhP.onScrollStateChanged(recyclerView, i);
                        a.this.nhP.onPageSelected(currentItem % bdC);
                    }
                }

                @Override // android.support.v7.widget.RecyclerView.OnScrollListener
                public void onScrolled(RecyclerView recyclerView, int i, int i2) {
                    super.onScrolled(recyclerView, i, i2);
                    if (a.this.nhP != null) {
                        a.this.nhP.onScrolled(recyclerView, i, i2);
                    }
                    a.this.dEu();
                }
            });
            oJ();
            this.nhZ.attachToRecyclerView(cBLoopViewPager);
        }
    }

    private void oJ() {
        this.nhW.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.kascend.chushou.widget.convenientbanner.b.a.2
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                a.this.nhW.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                a.this.scrollToPosition(a.this.nhY);
            }
        });
    }

    public void setCurrentItem(int i) {
        setCurrentItem(i, false);
    }

    public void setCurrentItem(int i, boolean z) {
        if (this.nhW != null) {
            if (z) {
                this.nhW.smoothScrollToPosition(i);
            } else {
                scrollToPosition(i);
            }
        }
    }

    public void scrollToPosition(int i) {
        if (this.nhW != null) {
            ((LinearLayoutManager) this.nhW.getLayoutManager()).scrollToPositionWithOffset(i, this.gdw + this.nhX);
            this.nhW.post(new Runnable() { // from class: com.kascend.chushou.widget.convenientbanner.b.a.3
                @Override // java.lang.Runnable
                public void run() {
                    a.this.dEu();
                }
            });
        }
    }

    public void Nc(int i) {
        this.nhY = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dEu() {
    }

    public int getCurrentItem() {
        View findSnapView = this.nhZ.findSnapView(this.nhW.getLayoutManager());
        if (findSnapView != null) {
            return this.nhW.getLayoutManager().getPosition(findSnapView);
        }
        return 0;
    }

    public int dEv() {
        return getCurrentItem() % ((com.kascend.chushou.widget.convenientbanner.a.a) this.nhW.getAdapter()).bdC();
    }

    public int dEw() {
        return this.nhY;
    }

    public void a(c cVar) {
        this.nhP = cVar;
    }
}
