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
    private c nhk;
    private CBLoopViewPager nhr;
    private int nht;
    private int gbt = 0;
    private int nhs = 0;
    private PagerSnapHelper nhu = new PagerSnapHelper();

    public void a(final CBLoopViewPager cBLoopViewPager) {
        if (cBLoopViewPager != null) {
            this.nhr = cBLoopViewPager;
            cBLoopViewPager.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: com.kascend.chushou.widget.convenientbanner.b.a.1
                @Override // android.support.v7.widget.RecyclerView.OnScrollListener
                public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                    super.onScrollStateChanged(recyclerView, i);
                    int currentItem = a.this.getCurrentItem();
                    int bbl = ((com.kascend.chushou.widget.convenientbanner.a.a) cBLoopViewPager.getAdapter()).bbl();
                    if (i == 0 && a.this.nhk != null) {
                        a.this.nhk.onScrollStateChanged(recyclerView, i);
                        a.this.nhk.onPageSelected(currentItem % bbl);
                    }
                }

                @Override // android.support.v7.widget.RecyclerView.OnScrollListener
                public void onScrolled(RecyclerView recyclerView, int i, int i2) {
                    super.onScrolled(recyclerView, i, i2);
                    if (a.this.nhk != null) {
                        a.this.nhk.onScrolled(recyclerView, i, i2);
                    }
                    a.this.dDl();
                }
            });
            oa();
            this.nhu.attachToRecyclerView(cBLoopViewPager);
        }
    }

    private void oa() {
        this.nhr.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.kascend.chushou.widget.convenientbanner.b.a.2
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                a.this.nhr.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                a.this.scrollToPosition(a.this.nht);
            }
        });
    }

    public void setCurrentItem(int i) {
        setCurrentItem(i, false);
    }

    public void setCurrentItem(int i, boolean z) {
        if (this.nhr != null) {
            if (z) {
                this.nhr.smoothScrollToPosition(i);
            } else {
                scrollToPosition(i);
            }
        }
    }

    public void scrollToPosition(int i) {
        if (this.nhr != null) {
            ((LinearLayoutManager) this.nhr.getLayoutManager()).scrollToPositionWithOffset(i, this.gbt + this.nhs);
            this.nhr.post(new Runnable() { // from class: com.kascend.chushou.widget.convenientbanner.b.a.3
                @Override // java.lang.Runnable
                public void run() {
                    a.this.dDl();
                }
            });
        }
    }

    public void MZ(int i) {
        this.nht = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dDl() {
    }

    public int getCurrentItem() {
        View findSnapView = this.nhu.findSnapView(this.nhr.getLayoutManager());
        if (findSnapView != null) {
            return this.nhr.getLayoutManager().getPosition(findSnapView);
        }
        return 0;
    }

    public int dDm() {
        return getCurrentItem() % ((com.kascend.chushou.widget.convenientbanner.a.a) this.nhr.getAdapter()).bbl();
    }

    public int dDn() {
        return this.nht;
    }

    public void a(c cVar) {
        this.nhk = cVar;
    }
}
