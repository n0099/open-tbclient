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
    private boolean bHL;
    private List<T> mDatas;
    private c mGA;
    private a mGB;
    private b mGC;
    private int[] mGq;
    private ArrayList<ImageView> mGr;
    private CBLoopViewPager mGs;
    private ViewGroup mGt;
    private long mGu;
    private boolean mGv;
    private boolean mGw;
    private boolean mGx;
    private com.kascend.chushou.widget.convenientbanner.b.a mGy;
    private com.kascend.chushou.widget.convenientbanner.d.a mGz;
    private boolean visible;

    public ConvenientBanner(Context context) {
        super(context);
        this.mGr = new ArrayList<>();
        this.mGu = -1L;
        this.mGw = false;
        this.mGx = true;
        this.visible = false;
        this.bHL = true;
        init(context);
    }

    public ConvenientBanner(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mGr = new ArrayList<>();
        this.mGu = -1L;
        this.mGw = false;
        this.mGx = true;
        this.visible = false;
        this.bHL = true;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.c.ConvenientBanner);
        this.mGx = obtainStyledAttributes.getBoolean(a.c.ConvenientBanner_banner_canLoop, true);
        this.mGu = obtainStyledAttributes.getInteger(a.c.ConvenientBanner_banner_autoTurningTime, -1);
        obtainStyledAttributes.recycle();
        init(context);
    }

    private void init(Context context) {
        View inflate = LayoutInflater.from(context).inflate(a.b.banner_layout, (ViewGroup) this, true);
        this.mGs = (CBLoopViewPager) inflate.findViewById(a.C0767a.banner_loop_viewpager);
        this.mGt = (ViewGroup) inflate.findViewById(a.C0767a.banner_indicator);
        this.mGC = new b(context, 0, false);
        this.mGC.setItemPrefetchEnabled(true);
        this.mGC.setInitialPrefetchItemCount(1);
        this.mGs.setLayoutManager(this.mGC);
        this.mGs.setFocusableInTouchMode(false);
        this.mGs.requestFocus();
        this.mGy = new com.kascend.chushou.widget.convenientbanner.b.a();
        this.mGB = new a(this);
    }

    public ConvenientBanner a(com.kascend.chushou.widget.convenientbanner.c.a<T> aVar, List<T> list) {
        this.mDatas = list;
        this.mGs.setAdapter(new com.kascend.chushou.widget.convenientbanner.a.a(aVar, this.mDatas, this.mGx, this));
        if (this.mGq != null) {
            r(this.mGq);
        }
        this.mGy.IC(this.mGx ? this.mDatas.size() : 0);
        this.mGy.a(this.mGs);
        return this;
    }

    public void notifyDataSetChanged() {
        this.mGs.getAdapter().notifyDataSetChanged();
        if (this.mDatas != null && this.mDatas.size() > 0) {
            this.mGy.setCurrentItem(0);
        }
        if (this.mGq != null) {
            r(this.mGq);
        }
    }

    public ConvenientBanner r(int[] iArr) {
        this.mGt.removeAllViews();
        this.mGr.clear();
        this.mGq = iArr;
        if (this.mDatas != null) {
            for (int i = 0; i < this.mDatas.size(); i++) {
                ImageView imageView = new ImageView(getContext());
                imageView.setPadding(5, 0, 5, 0);
                if (this.mGy.dyV() % this.mDatas.size() == i) {
                    imageView.setImageResource(iArr[1]);
                } else {
                    imageView.setImageResource(iArr[0]);
                }
                this.mGr.add(imageView);
                this.mGt.addView(imageView);
            }
            if (this.mDatas.size() > 1) {
                this.mGt.setVisibility(0);
                this.mGC.wi(true);
            } else {
                this.mGt.setVisibility(8);
                this.mGC.wi(false);
            }
            this.mGz = new com.kascend.chushou.widget.convenientbanner.d.a(this.mGr, iArr);
            this.mGy.a(this.mGz);
            if (this.mGA != null) {
                this.mGz.a(this.mGA);
            }
        }
        return this;
    }

    public c getOnPageChangeListener() {
        return this.mGA;
    }

    public int getCurrentItem() {
        return this.mGy.dyU();
    }

    public int getFaceCurrentItem() {
        return this.mGy.getCurrentItem();
    }

    public ConvenientBanner h(int i, int i2, int i3, int i4, int i5) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.mGt.getLayoutParams();
        layoutParams.gravity = i;
        layoutParams.topMargin = i3;
        layoutParams.leftMargin = i2;
        layoutParams.rightMargin = i4;
        layoutParams.bottomMargin = i5;
        this.mGt.setLayoutParams(layoutParams);
        return this;
    }

    public ConvenientBanner fY(long j) {
        if (j >= 0) {
            if (this.mGv) {
                dyS();
            }
            this.mGw = true;
            this.mGu = j;
            this.mGv = true;
            postDelayed(this.mGB, j);
        }
        return this;
    }

    public ConvenientBanner dyR() {
        fY(this.mGu);
        return this;
    }

    public void dyS() {
        this.mGv = false;
        removeCallbacks(this.mGB);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 1 || action == 3 || action == 4) {
            if (this.mGw) {
                fY(this.mGu);
            }
        } else if (action == 0 && this.mGw) {
            dyS();
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        this.visible = i == 0;
        if (this.bHL && this.visible && this.mGw) {
            dyR();
        } else {
            dyS();
        }
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        this.bHL = z;
        if (this.bHL && this.visible && this.mGw) {
            dyR();
        } else {
            dyS();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static class a implements Runnable {
        private final WeakReference<ConvenientBanner> hjE;

        a(ConvenientBanner convenientBanner) {
            this.hjE = new WeakReference<>(convenientBanner);
        }

        @Override // java.lang.Runnable
        public void run() {
            ConvenientBanner convenientBanner = this.hjE.get();
            if (convenientBanner != null && convenientBanner.mGs != null && convenientBanner.mGv) {
                convenientBanner.mGy.setCurrentItem(convenientBanner.mGy.getCurrentItem() + 1, true);
                convenientBanner.postDelayed(convenientBanner.mGB, convenientBanner.mGu);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static class b extends LinearLayoutManager {
        private boolean mGD;

        b(Context context, int i, boolean z) {
            super(context, i, z);
            this.mGD = true;
        }

        @Override // android.support.v7.widget.LinearLayoutManager, android.support.v7.widget.RecyclerView.LayoutManager
        public boolean canScrollHorizontally() {
            return this.mGD && super.canScrollHorizontally();
        }

        void wi(boolean z) {
            this.mGD = z;
        }
    }
}
