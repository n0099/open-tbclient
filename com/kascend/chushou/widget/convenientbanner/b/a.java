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
    private c nia;
    private CBLoopViewPager nii;
    private int nik;
    private int gdJ = 0;
    private int nij = 0;
    private PagerSnapHelper nil = new PagerSnapHelper();

    public void a(final CBLoopViewPager cBLoopViewPager) {
        if (cBLoopViewPager != null) {
            this.nii = cBLoopViewPager;
            cBLoopViewPager.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: com.kascend.chushou.widget.convenientbanner.b.a.1
                @Override // android.support.v7.widget.RecyclerView.OnScrollListener
                public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                    super.onScrollStateChanged(recyclerView, i);
                    int currentItem = a.this.getCurrentItem();
                    int bdD = ((com.kascend.chushou.widget.convenientbanner.a.a) cBLoopViewPager.getAdapter()).bdD();
                    if (i == 0 && a.this.nia != null) {
                        a.this.nia.onScrollStateChanged(recyclerView, i);
                        a.this.nia.onPageSelected(currentItem % bdD);
                    }
                }

                @Override // android.support.v7.widget.RecyclerView.OnScrollListener
                public void onScrolled(RecyclerView recyclerView, int i, int i2) {
                    super.onScrolled(recyclerView, i, i2);
                    if (a.this.nia != null) {
                        a.this.nia.onScrolled(recyclerView, i, i2);
                    }
                    a.this.dEv();
                }
            });
            oJ();
            this.nil.attachToRecyclerView(cBLoopViewPager);
        }
    }

    private void oJ() {
        this.nii.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.kascend.chushou.widget.convenientbanner.b.a.2
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                a.this.nii.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                a.this.scrollToPosition(a.this.nik);
            }
        });
    }

    public void setCurrentItem(int i) {
        setCurrentItem(i, false);
    }

    public void setCurrentItem(int i, boolean z) {
        if (this.nii != null) {
            if (z) {
                this.nii.smoothScrollToPosition(i);
            } else {
                scrollToPosition(i);
            }
        }
    }

    public void scrollToPosition(int i) {
        if (this.nii != null) {
            ((LinearLayoutManager) this.nii.getLayoutManager()).scrollToPositionWithOffset(i, this.gdJ + this.nij);
            this.nii.post(new Runnable() { // from class: com.kascend.chushou.widget.convenientbanner.b.a.3
                @Override // java.lang.Runnable
                public void run() {
                    a.this.dEv();
                }
            });
        }
    }

    public void Nc(int i) {
        this.nik = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dEv() {
    }

    public int getCurrentItem() {
        View findSnapView = this.nil.findSnapView(this.nii.getLayoutManager());
        if (findSnapView != null) {
            return this.nii.getLayoutManager().getPosition(findSnapView);
        }
        return 0;
    }

    public int dEw() {
        return getCurrentItem() % ((com.kascend.chushou.widget.convenientbanner.a.a) this.nii.getAdapter()).bdD();
    }

    public int dEx() {
        return this.nik;
    }

    public void a(c cVar) {
        this.nia = cVar;
    }
}
