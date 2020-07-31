package com.kascend.chushou.widget.convenientbanner;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.v7.widget.LinearLayoutManager;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.kascend.chushou.widget.convenientbanner.a;
import com.kascend.chushou.widget.convenientbanner.d.c;
import com.kascend.chushou.widget.convenientbanner.view.CBLoopViewPager;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class ConvenientBanner<T> extends RelativeLayout {
    private boolean bWj;
    private List<T> mDatas;
    private int[] nGd;
    private ArrayList<ImageView> nGe;
    private CBLoopViewPager nGf;
    private ViewGroup nGg;
    private long nGh;
    private boolean nGi;
    private boolean nGj;
    private boolean nGk;
    private com.kascend.chushou.widget.convenientbanner.b.a nGl;
    private com.kascend.chushou.widget.convenientbanner.d.a nGm;
    private c nGn;
    private a nGo;
    private b nGp;
    private boolean visible;

    public ConvenientBanner(Context context) {
        super(context);
        this.nGe = new ArrayList<>();
        this.nGh = -1L;
        this.nGj = false;
        this.nGk = true;
        this.visible = false;
        this.bWj = true;
        init(context);
    }

    public ConvenientBanner(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.nGe = new ArrayList<>();
        this.nGh = -1L;
        this.nGj = false;
        this.nGk = true;
        this.visible = false;
        this.bWj = true;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.c.ConvenientBanner);
        this.nGk = obtainStyledAttributes.getBoolean(a.c.ConvenientBanner_banner_canLoop, true);
        this.nGh = obtainStyledAttributes.getInteger(a.c.ConvenientBanner_banner_autoTurningTime, -1);
        obtainStyledAttributes.recycle();
        init(context);
    }

    private void init(Context context) {
        View inflate = LayoutInflater.from(context).inflate(a.b.banner_layout, (ViewGroup) this, true);
        this.nGf = (CBLoopViewPager) inflate.findViewById(a.C0855a.banner_loop_viewpager);
        this.nGg = (ViewGroup) inflate.findViewById(a.C0855a.banner_indicator);
        this.nGp = new b(context, 0, false);
        this.nGp.setItemPrefetchEnabled(true);
        this.nGp.setInitialPrefetchItemCount(1);
        this.nGf.setLayoutManager(this.nGp);
        this.nGf.setFocusableInTouchMode(false);
        this.nGf.requestFocus();
        this.nGl = new com.kascend.chushou.widget.convenientbanner.b.a();
        this.nGo = new a(this);
    }

    public ConvenientBanner a(com.kascend.chushou.widget.convenientbanner.c.a<T> aVar, List<T> list) {
        this.mDatas = list;
        this.nGf.setAdapter(new com.kascend.chushou.widget.convenientbanner.a.a(aVar, this.mDatas, this.nGk, this));
        if (this.nGd != null) {
            r(this.nGd);
        }
        this.nGl.KQ(this.nGk ? this.mDatas.size() : 0);
        this.nGl.a(this.nGf);
        return this;
    }

    public void notifyDataSetChanged() {
        this.nGf.getAdapter().notifyDataSetChanged();
        if (this.mDatas != null && this.mDatas.size() > 0) {
            this.nGl.setCurrentItem(0);
        }
        if (this.nGd != null) {
            r(this.nGd);
        }
    }

    public ConvenientBanner r(int[] iArr) {
        this.nGg.removeAllViews();
        this.nGe.clear();
        this.nGd = iArr;
        if (this.mDatas != null) {
            for (int i = 0; i < this.mDatas.size(); i++) {
                ImageView imageView = new ImageView(getContext());
                imageView.setPadding(5, 0, 5, 0);
                if (this.nGl.dOH() % this.mDatas.size() == i) {
                    imageView.setImageResource(iArr[1]);
                } else {
                    imageView.setImageResource(iArr[0]);
                }
                this.nGe.add(imageView);
                this.nGg.addView(imageView);
            }
            if (this.mDatas.size() > 1) {
                this.nGg.setVisibility(0);
                this.nGp.xI(true);
            } else {
                this.nGg.setVisibility(8);
                this.nGp.xI(false);
            }
            this.nGm = new com.kascend.chushou.widget.convenientbanner.d.a(this.nGe, iArr);
            this.nGl.a(this.nGm);
            if (this.nGn != null) {
                this.nGm.a(this.nGn);
            }
        }
        return this;
    }

    public c getOnPageChangeListener() {
        return this.nGn;
    }

    public int getCurrentItem() {
        return this.nGl.dOG();
    }

    public int getFaceCurrentItem() {
        return this.nGl.getCurrentItem();
    }

    public ConvenientBanner h(int i, int i2, int i3, int i4, int i5) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.nGg.getLayoutParams();
        layoutParams.gravity = i;
        layoutParams.topMargin = i3;
        layoutParams.leftMargin = i2;
        layoutParams.rightMargin = i4;
        layoutParams.bottomMargin = i5;
        this.nGg.setLayoutParams(layoutParams);
        return this;
    }

    public ConvenientBanner gq(long j) {
        if (j >= 0) {
            if (this.nGi) {
                dOE();
            }
            this.nGj = true;
            this.nGh = j;
            this.nGi = true;
            postDelayed(this.nGo, j);
        }
        return this;
    }

    public ConvenientBanner dOD() {
        gq(this.nGh);
        return this;
    }

    public void dOE() {
        this.nGi = false;
        removeCallbacks(this.nGo);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 1 || action == 3 || action == 4) {
            if (this.nGj) {
                gq(this.nGh);
            }
        } else if (action == 0 && this.nGj) {
            dOE();
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        this.visible = i == 0;
        if (this.bWj && this.visible && this.nGj) {
            dOD();
        } else {
            dOE();
        }
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        this.bWj = z;
        if (this.bWj && this.visible && this.nGj) {
            dOD();
        } else {
            dOE();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public static class a implements Runnable {
        private final WeakReference<ConvenientBanner> hRz;

        a(ConvenientBanner convenientBanner) {
            this.hRz = new WeakReference<>(convenientBanner);
        }

        @Override // java.lang.Runnable
        public void run() {
            ConvenientBanner convenientBanner = this.hRz.get();
            if (convenientBanner != null && convenientBanner.nGf != null && convenientBanner.nGi) {
                convenientBanner.nGl.setCurrentItem(convenientBanner.nGl.getCurrentItem() + 1, true);
                convenientBanner.postDelayed(convenientBanner.nGo, convenientBanner.nGh);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public static class b extends LinearLayoutManager {
        private boolean nGq;

        b(Context context, int i, boolean z) {
            super(context, i, z);
            this.nGq = true;
        }

        @Override // android.support.v7.widget.LinearLayoutManager, android.support.v7.widget.RecyclerView.LayoutManager
        public boolean canScrollHorizontally() {
            return this.nGq && super.canScrollHorizontally();
        }

        void xI(boolean z) {
            this.nGq = z;
        }
    }
}
