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
    private int[] nGf;
    private ArrayList<ImageView> nGg;
    private CBLoopViewPager nGh;
    private ViewGroup nGi;
    private long nGj;
    private boolean nGk;
    private boolean nGl;
    private boolean nGm;
    private com.kascend.chushou.widget.convenientbanner.b.a nGn;
    private com.kascend.chushou.widget.convenientbanner.d.a nGo;
    private c nGp;
    private a nGq;
    private b nGr;
    private boolean visible;

    public ConvenientBanner(Context context) {
        super(context);
        this.nGg = new ArrayList<>();
        this.nGj = -1L;
        this.nGl = false;
        this.nGm = true;
        this.visible = false;
        this.bWj = true;
        init(context);
    }

    public ConvenientBanner(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.nGg = new ArrayList<>();
        this.nGj = -1L;
        this.nGl = false;
        this.nGm = true;
        this.visible = false;
        this.bWj = true;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.c.ConvenientBanner);
        this.nGm = obtainStyledAttributes.getBoolean(a.c.ConvenientBanner_banner_canLoop, true);
        this.nGj = obtainStyledAttributes.getInteger(a.c.ConvenientBanner_banner_autoTurningTime, -1);
        obtainStyledAttributes.recycle();
        init(context);
    }

    private void init(Context context) {
        View inflate = LayoutInflater.from(context).inflate(a.b.banner_layout, (ViewGroup) this, true);
        this.nGh = (CBLoopViewPager) inflate.findViewById(a.C0855a.banner_loop_viewpager);
        this.nGi = (ViewGroup) inflate.findViewById(a.C0855a.banner_indicator);
        this.nGr = new b(context, 0, false);
        this.nGr.setItemPrefetchEnabled(true);
        this.nGr.setInitialPrefetchItemCount(1);
        this.nGh.setLayoutManager(this.nGr);
        this.nGh.setFocusableInTouchMode(false);
        this.nGh.requestFocus();
        this.nGn = new com.kascend.chushou.widget.convenientbanner.b.a();
        this.nGq = new a(this);
    }

    public ConvenientBanner a(com.kascend.chushou.widget.convenientbanner.c.a<T> aVar, List<T> list) {
        this.mDatas = list;
        this.nGh.setAdapter(new com.kascend.chushou.widget.convenientbanner.a.a(aVar, this.mDatas, this.nGm, this));
        if (this.nGf != null) {
            r(this.nGf);
        }
        this.nGn.KQ(this.nGm ? this.mDatas.size() : 0);
        this.nGn.a(this.nGh);
        return this;
    }

    public void notifyDataSetChanged() {
        this.nGh.getAdapter().notifyDataSetChanged();
        if (this.mDatas != null && this.mDatas.size() > 0) {
            this.nGn.setCurrentItem(0);
        }
        if (this.nGf != null) {
            r(this.nGf);
        }
    }

    public ConvenientBanner r(int[] iArr) {
        this.nGi.removeAllViews();
        this.nGg.clear();
        this.nGf = iArr;
        if (this.mDatas != null) {
            for (int i = 0; i < this.mDatas.size(); i++) {
                ImageView imageView = new ImageView(getContext());
                imageView.setPadding(5, 0, 5, 0);
                if (this.nGn.dOI() % this.mDatas.size() == i) {
                    imageView.setImageResource(iArr[1]);
                } else {
                    imageView.setImageResource(iArr[0]);
                }
                this.nGg.add(imageView);
                this.nGi.addView(imageView);
            }
            if (this.mDatas.size() > 1) {
                this.nGi.setVisibility(0);
                this.nGr.xI(true);
            } else {
                this.nGi.setVisibility(8);
                this.nGr.xI(false);
            }
            this.nGo = new com.kascend.chushou.widget.convenientbanner.d.a(this.nGg, iArr);
            this.nGn.a(this.nGo);
            if (this.nGp != null) {
                this.nGo.a(this.nGp);
            }
        }
        return this;
    }

    public c getOnPageChangeListener() {
        return this.nGp;
    }

    public int getCurrentItem() {
        return this.nGn.dOH();
    }

    public int getFaceCurrentItem() {
        return this.nGn.getCurrentItem();
    }

    public ConvenientBanner h(int i, int i2, int i3, int i4, int i5) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.nGi.getLayoutParams();
        layoutParams.gravity = i;
        layoutParams.topMargin = i3;
        layoutParams.leftMargin = i2;
        layoutParams.rightMargin = i4;
        layoutParams.bottomMargin = i5;
        this.nGi.setLayoutParams(layoutParams);
        return this;
    }

    public ConvenientBanner gq(long j) {
        if (j >= 0) {
            if (this.nGk) {
                dOF();
            }
            this.nGl = true;
            this.nGj = j;
            this.nGk = true;
            postDelayed(this.nGq, j);
        }
        return this;
    }

    public ConvenientBanner dOE() {
        gq(this.nGj);
        return this;
    }

    public void dOF() {
        this.nGk = false;
        removeCallbacks(this.nGq);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 1 || action == 3 || action == 4) {
            if (this.nGl) {
                gq(this.nGj);
            }
        } else if (action == 0 && this.nGl) {
            dOF();
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        this.visible = i == 0;
        if (this.bWj && this.visible && this.nGl) {
            dOE();
        } else {
            dOF();
        }
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        this.bWj = z;
        if (this.bWj && this.visible && this.nGl) {
            dOE();
        } else {
            dOF();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public static class a implements Runnable {
        private final WeakReference<ConvenientBanner> hRB;

        a(ConvenientBanner convenientBanner) {
            this.hRB = new WeakReference<>(convenientBanner);
        }

        @Override // java.lang.Runnable
        public void run() {
            ConvenientBanner convenientBanner = this.hRB.get();
            if (convenientBanner != null && convenientBanner.nGh != null && convenientBanner.nGk) {
                convenientBanner.nGn.setCurrentItem(convenientBanner.nGn.getCurrentItem() + 1, true);
                convenientBanner.postDelayed(convenientBanner.nGq, convenientBanner.nGj);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public static class b extends LinearLayoutManager {
        private boolean nGs;

        b(Context context, int i, boolean z) {
            super(context, i, z);
            this.nGs = true;
        }

        @Override // android.support.v7.widget.LinearLayoutManager, android.support.v7.widget.RecyclerView.LayoutManager
        public boolean canScrollHorizontally() {
            return this.nGs && super.canScrollHorizontally();
        }

        void xI(boolean z) {
            this.nGs = z;
        }
    }
}
