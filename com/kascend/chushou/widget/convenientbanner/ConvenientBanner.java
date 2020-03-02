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
    private boolean bjk;
    private List<T> mDatas;
    private int[] nhF;
    private ArrayList<ImageView> nhG;
    private CBLoopViewPager nhH;
    private ViewGroup nhI;
    private long nhJ;
    private boolean nhK;
    private boolean nhL;
    private boolean nhM;
    private com.kascend.chushou.widget.convenientbanner.b.a nhN;
    private com.kascend.chushou.widget.convenientbanner.d.a nhO;
    private c nhP;
    private a nhQ;
    private b nhR;
    private boolean visible;

    public ConvenientBanner(Context context) {
        super(context);
        this.nhG = new ArrayList<>();
        this.nhJ = -1L;
        this.nhL = false;
        this.nhM = true;
        this.visible = false;
        this.bjk = true;
        init(context);
    }

    public ConvenientBanner(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.nhG = new ArrayList<>();
        this.nhJ = -1L;
        this.nhL = false;
        this.nhM = true;
        this.visible = false;
        this.bjk = true;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.c.ConvenientBanner);
        this.nhM = obtainStyledAttributes.getBoolean(a.c.ConvenientBanner_banner_canLoop, true);
        this.nhJ = obtainStyledAttributes.getInteger(a.c.ConvenientBanner_banner_autoTurningTime, -1);
        obtainStyledAttributes.recycle();
        init(context);
    }

    private void init(Context context) {
        View inflate = LayoutInflater.from(context).inflate(a.b.banner_layout, (ViewGroup) this, true);
        this.nhH = (CBLoopViewPager) inflate.findViewById(a.C0721a.banner_loop_viewpager);
        this.nhI = (ViewGroup) inflate.findViewById(a.C0721a.banner_indicator);
        this.nhR = new b(context, 0, false);
        this.nhR.setItemPrefetchEnabled(true);
        this.nhR.setInitialPrefetchItemCount(1);
        this.nhH.setLayoutManager(this.nhR);
        this.nhH.setFocusableInTouchMode(false);
        this.nhH.requestFocus();
        this.nhN = new com.kascend.chushou.widget.convenientbanner.b.a();
        this.nhQ = new a(this);
    }

    public ConvenientBanner a(com.kascend.chushou.widget.convenientbanner.c.a<T> aVar, List<T> list) {
        this.mDatas = list;
        this.nhH.setAdapter(new com.kascend.chushou.widget.convenientbanner.a.a(aVar, this.mDatas, this.nhM, this));
        if (this.nhF != null) {
            p(this.nhF);
        }
        this.nhN.Nc(this.nhM ? this.mDatas.size() : 0);
        this.nhN.a(this.nhH);
        return this;
    }

    public void notifyDataSetChanged() {
        this.nhH.getAdapter().notifyDataSetChanged();
        if (this.mDatas != null && this.mDatas.size() > 0) {
            this.nhN.setCurrentItem(0);
        }
        if (this.nhF != null) {
            p(this.nhF);
        }
    }

    public ConvenientBanner p(int[] iArr) {
        this.nhI.removeAllViews();
        this.nhG.clear();
        this.nhF = iArr;
        if (this.mDatas != null) {
            for (int i = 0; i < this.mDatas.size(); i++) {
                ImageView imageView = new ImageView(getContext());
                imageView.setPadding(5, 0, 5, 0);
                if (this.nhN.dEw() % this.mDatas.size() == i) {
                    imageView.setImageResource(iArr[1]);
                } else {
                    imageView.setImageResource(iArr[0]);
                }
                this.nhG.add(imageView);
                this.nhI.addView(imageView);
            }
            if (this.mDatas.size() > 1) {
                this.nhI.setVisibility(0);
                this.nhR.ws(true);
            } else {
                this.nhI.setVisibility(8);
                this.nhR.ws(false);
            }
            this.nhO = new com.kascend.chushou.widget.convenientbanner.d.a(this.nhG, iArr);
            this.nhN.a(this.nhO);
            if (this.nhP != null) {
                this.nhO.a(this.nhP);
            }
        }
        return this;
    }

    public c getOnPageChangeListener() {
        return this.nhP;
    }

    public int getCurrentItem() {
        return this.nhN.dEv();
    }

    public int getFaceCurrentItem() {
        return this.nhN.getCurrentItem();
    }

    public ConvenientBanner j(int i, int i2, int i3, int i4, int i5) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.nhI.getLayoutParams();
        layoutParams.gravity = i;
        layoutParams.topMargin = i3;
        layoutParams.leftMargin = i2;
        layoutParams.rightMargin = i4;
        layoutParams.bottomMargin = i5;
        this.nhI.setLayoutParams(layoutParams);
        return this;
    }

    public ConvenientBanner gV(long j) {
        if (j >= 0) {
            if (this.nhK) {
                dEt();
            }
            this.nhL = true;
            this.nhJ = j;
            this.nhK = true;
            postDelayed(this.nhQ, j);
        }
        return this;
    }

    public ConvenientBanner dEs() {
        gV(this.nhJ);
        return this;
    }

    public void dEt() {
        this.nhK = false;
        removeCallbacks(this.nhQ);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 1 || action == 3 || action == 4) {
            if (this.nhL) {
                gV(this.nhJ);
            }
        } else if (action == 0 && this.nhL) {
            dEt();
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        this.visible = i == 0;
        if (this.bjk && this.visible && this.nhL) {
            dEs();
        } else {
            dEt();
        }
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        this.bjk = z;
        if (this.bjk && this.visible && this.nhL) {
            dEs();
        } else {
            dEt();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static class a implements Runnable {
        private final WeakReference<ConvenientBanner> gyS;

        a(ConvenientBanner convenientBanner) {
            this.gyS = new WeakReference<>(convenientBanner);
        }

        @Override // java.lang.Runnable
        public void run() {
            ConvenientBanner convenientBanner = this.gyS.get();
            if (convenientBanner != null && convenientBanner.nhH != null && convenientBanner.nhK) {
                convenientBanner.nhN.setCurrentItem(convenientBanner.nhN.getCurrentItem() + 1, true);
                convenientBanner.postDelayed(convenientBanner.nhQ, convenientBanner.nhJ);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static class b extends LinearLayoutManager {
        private boolean nhS;

        b(Context context, int i, boolean z) {
            super(context, i, z);
            this.nhS = true;
        }

        @Override // android.support.v7.widget.LinearLayoutManager, android.support.v7.widget.RecyclerView.LayoutManager
        public boolean canScrollHorizontally() {
            return this.nhS && super.canScrollHorizontally();
        }

        void ws(boolean z) {
            this.nhS = z;
        }
    }
}
