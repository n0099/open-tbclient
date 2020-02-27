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
/* loaded from: classes5.dex */
public class ConvenientBanner<T> extends RelativeLayout {
    private boolean bjj;
    private List<T> mDatas;
    private int[] nhD;
    private ArrayList<ImageView> nhE;
    private CBLoopViewPager nhF;
    private ViewGroup nhG;
    private long nhH;
    private boolean nhI;
    private boolean nhJ;
    private boolean nhK;
    private com.kascend.chushou.widget.convenientbanner.b.a nhL;
    private com.kascend.chushou.widget.convenientbanner.d.a nhM;
    private c nhN;
    private a nhO;
    private b nhP;
    private boolean visible;

    public ConvenientBanner(Context context) {
        super(context);
        this.nhE = new ArrayList<>();
        this.nhH = -1L;
        this.nhJ = false;
        this.nhK = true;
        this.visible = false;
        this.bjj = true;
        init(context);
    }

    public ConvenientBanner(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.nhE = new ArrayList<>();
        this.nhH = -1L;
        this.nhJ = false;
        this.nhK = true;
        this.visible = false;
        this.bjj = true;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.c.ConvenientBanner);
        this.nhK = obtainStyledAttributes.getBoolean(a.c.ConvenientBanner_banner_canLoop, true);
        this.nhH = obtainStyledAttributes.getInteger(a.c.ConvenientBanner_banner_autoTurningTime, -1);
        obtainStyledAttributes.recycle();
        init(context);
    }

    private void init(Context context) {
        View inflate = LayoutInflater.from(context).inflate(a.b.banner_layout, (ViewGroup) this, true);
        this.nhF = (CBLoopViewPager) inflate.findViewById(a.C0721a.banner_loop_viewpager);
        this.nhG = (ViewGroup) inflate.findViewById(a.C0721a.banner_indicator);
        this.nhP = new b(context, 0, false);
        this.nhP.setItemPrefetchEnabled(true);
        this.nhP.setInitialPrefetchItemCount(1);
        this.nhF.setLayoutManager(this.nhP);
        this.nhF.setFocusableInTouchMode(false);
        this.nhF.requestFocus();
        this.nhL = new com.kascend.chushou.widget.convenientbanner.b.a();
        this.nhO = new a(this);
    }

    public ConvenientBanner a(com.kascend.chushou.widget.convenientbanner.c.a<T> aVar, List<T> list) {
        this.mDatas = list;
        this.nhF.setAdapter(new com.kascend.chushou.widget.convenientbanner.a.a(aVar, this.mDatas, this.nhK, this));
        if (this.nhD != null) {
            p(this.nhD);
        }
        this.nhL.Nc(this.nhK ? this.mDatas.size() : 0);
        this.nhL.a(this.nhF);
        return this;
    }

    public void notifyDataSetChanged() {
        this.nhF.getAdapter().notifyDataSetChanged();
        if (this.mDatas != null && this.mDatas.size() > 0) {
            this.nhL.setCurrentItem(0);
        }
        if (this.nhD != null) {
            p(this.nhD);
        }
    }

    public ConvenientBanner p(int[] iArr) {
        this.nhG.removeAllViews();
        this.nhE.clear();
        this.nhD = iArr;
        if (this.mDatas != null) {
            for (int i = 0; i < this.mDatas.size(); i++) {
                ImageView imageView = new ImageView(getContext());
                imageView.setPadding(5, 0, 5, 0);
                if (this.nhL.dEu() % this.mDatas.size() == i) {
                    imageView.setImageResource(iArr[1]);
                } else {
                    imageView.setImageResource(iArr[0]);
                }
                this.nhE.add(imageView);
                this.nhG.addView(imageView);
            }
            if (this.mDatas.size() > 1) {
                this.nhG.setVisibility(0);
                this.nhP.ws(true);
            } else {
                this.nhG.setVisibility(8);
                this.nhP.ws(false);
            }
            this.nhM = new com.kascend.chushou.widget.convenientbanner.d.a(this.nhE, iArr);
            this.nhL.a(this.nhM);
            if (this.nhN != null) {
                this.nhM.a(this.nhN);
            }
        }
        return this;
    }

    public c getOnPageChangeListener() {
        return this.nhN;
    }

    public int getCurrentItem() {
        return this.nhL.dEt();
    }

    public int getFaceCurrentItem() {
        return this.nhL.getCurrentItem();
    }

    public ConvenientBanner j(int i, int i2, int i3, int i4, int i5) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.nhG.getLayoutParams();
        layoutParams.gravity = i;
        layoutParams.topMargin = i3;
        layoutParams.leftMargin = i2;
        layoutParams.rightMargin = i4;
        layoutParams.bottomMargin = i5;
        this.nhG.setLayoutParams(layoutParams);
        return this;
    }

    public ConvenientBanner gV(long j) {
        if (j >= 0) {
            if (this.nhI) {
                dEr();
            }
            this.nhJ = true;
            this.nhH = j;
            this.nhI = true;
            postDelayed(this.nhO, j);
        }
        return this;
    }

    public ConvenientBanner dEq() {
        gV(this.nhH);
        return this;
    }

    public void dEr() {
        this.nhI = false;
        removeCallbacks(this.nhO);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 1 || action == 3 || action == 4) {
            if (this.nhJ) {
                gV(this.nhH);
            }
        } else if (action == 0 && this.nhJ) {
            dEr();
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        this.visible = i == 0;
        if (this.bjj && this.visible && this.nhJ) {
            dEq();
        } else {
            dEr();
        }
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        this.bjj = z;
        if (this.bjj && this.visible && this.nhJ) {
            dEq();
        } else {
            dEr();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static class a implements Runnable {
        private final WeakReference<ConvenientBanner> gyQ;

        a(ConvenientBanner convenientBanner) {
            this.gyQ = new WeakReference<>(convenientBanner);
        }

        @Override // java.lang.Runnable
        public void run() {
            ConvenientBanner convenientBanner = this.gyQ.get();
            if (convenientBanner != null && convenientBanner.nhF != null && convenientBanner.nhI) {
                convenientBanner.nhL.setCurrentItem(convenientBanner.nhL.getCurrentItem() + 1, true);
                convenientBanner.postDelayed(convenientBanner.nhO, convenientBanner.nhH);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static class b extends LinearLayoutManager {
        private boolean nhQ;

        b(Context context, int i, boolean z) {
            super(context, i, z);
            this.nhQ = true;
        }

        @Override // android.support.v7.widget.LinearLayoutManager, android.support.v7.widget.RecyclerView.LayoutManager
        public boolean canScrollHorizontally() {
            return this.nhQ && super.canScrollHorizontally();
        }

        void ws(boolean z) {
            this.nhQ = z;
        }
    }
}
