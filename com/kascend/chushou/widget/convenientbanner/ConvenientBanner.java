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
    private boolean bjl;
    private List<T> mDatas;
    private int[] nhQ;
    private ArrayList<ImageView> nhR;
    private CBLoopViewPager nhS;
    private ViewGroup nhT;
    private long nhU;
    private boolean nhV;
    private boolean nhW;
    private boolean nhX;
    private com.kascend.chushou.widget.convenientbanner.b.a nhY;
    private com.kascend.chushou.widget.convenientbanner.d.a nhZ;
    private c nia;
    private a nib;
    private b nic;
    private boolean visible;

    public ConvenientBanner(Context context) {
        super(context);
        this.nhR = new ArrayList<>();
        this.nhU = -1L;
        this.nhW = false;
        this.nhX = true;
        this.visible = false;
        this.bjl = true;
        init(context);
    }

    public ConvenientBanner(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.nhR = new ArrayList<>();
        this.nhU = -1L;
        this.nhW = false;
        this.nhX = true;
        this.visible = false;
        this.bjl = true;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.c.ConvenientBanner);
        this.nhX = obtainStyledAttributes.getBoolean(a.c.ConvenientBanner_banner_canLoop, true);
        this.nhU = obtainStyledAttributes.getInteger(a.c.ConvenientBanner_banner_autoTurningTime, -1);
        obtainStyledAttributes.recycle();
        init(context);
    }

    private void init(Context context) {
        View inflate = LayoutInflater.from(context).inflate(a.b.banner_layout, (ViewGroup) this, true);
        this.nhS = (CBLoopViewPager) inflate.findViewById(a.C0721a.banner_loop_viewpager);
        this.nhT = (ViewGroup) inflate.findViewById(a.C0721a.banner_indicator);
        this.nic = new b(context, 0, false);
        this.nic.setItemPrefetchEnabled(true);
        this.nic.setInitialPrefetchItemCount(1);
        this.nhS.setLayoutManager(this.nic);
        this.nhS.setFocusableInTouchMode(false);
        this.nhS.requestFocus();
        this.nhY = new com.kascend.chushou.widget.convenientbanner.b.a();
        this.nib = new a(this);
    }

    public ConvenientBanner a(com.kascend.chushou.widget.convenientbanner.c.a<T> aVar, List<T> list) {
        this.mDatas = list;
        this.nhS.setAdapter(new com.kascend.chushou.widget.convenientbanner.a.a(aVar, this.mDatas, this.nhX, this));
        if (this.nhQ != null) {
            p(this.nhQ);
        }
        this.nhY.Nc(this.nhX ? this.mDatas.size() : 0);
        this.nhY.a(this.nhS);
        return this;
    }

    public void notifyDataSetChanged() {
        this.nhS.getAdapter().notifyDataSetChanged();
        if (this.mDatas != null && this.mDatas.size() > 0) {
            this.nhY.setCurrentItem(0);
        }
        if (this.nhQ != null) {
            p(this.nhQ);
        }
    }

    public ConvenientBanner p(int[] iArr) {
        this.nhT.removeAllViews();
        this.nhR.clear();
        this.nhQ = iArr;
        if (this.mDatas != null) {
            for (int i = 0; i < this.mDatas.size(); i++) {
                ImageView imageView = new ImageView(getContext());
                imageView.setPadding(5, 0, 5, 0);
                if (this.nhY.dEx() % this.mDatas.size() == i) {
                    imageView.setImageResource(iArr[1]);
                } else {
                    imageView.setImageResource(iArr[0]);
                }
                this.nhR.add(imageView);
                this.nhT.addView(imageView);
            }
            if (this.mDatas.size() > 1) {
                this.nhT.setVisibility(0);
                this.nic.ws(true);
            } else {
                this.nhT.setVisibility(8);
                this.nic.ws(false);
            }
            this.nhZ = new com.kascend.chushou.widget.convenientbanner.d.a(this.nhR, iArr);
            this.nhY.a(this.nhZ);
            if (this.nia != null) {
                this.nhZ.a(this.nia);
            }
        }
        return this;
    }

    public c getOnPageChangeListener() {
        return this.nia;
    }

    public int getCurrentItem() {
        return this.nhY.dEw();
    }

    public int getFaceCurrentItem() {
        return this.nhY.getCurrentItem();
    }

    public ConvenientBanner j(int i, int i2, int i3, int i4, int i5) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.nhT.getLayoutParams();
        layoutParams.gravity = i;
        layoutParams.topMargin = i3;
        layoutParams.leftMargin = i2;
        layoutParams.rightMargin = i4;
        layoutParams.bottomMargin = i5;
        this.nhT.setLayoutParams(layoutParams);
        return this;
    }

    public ConvenientBanner gV(long j) {
        if (j >= 0) {
            if (this.nhV) {
                dEu();
            }
            this.nhW = true;
            this.nhU = j;
            this.nhV = true;
            postDelayed(this.nib, j);
        }
        return this;
    }

    public ConvenientBanner dEt() {
        gV(this.nhU);
        return this;
    }

    public void dEu() {
        this.nhV = false;
        removeCallbacks(this.nib);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 1 || action == 3 || action == 4) {
            if (this.nhW) {
                gV(this.nhU);
            }
        } else if (action == 0 && this.nhW) {
            dEu();
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        this.visible = i == 0;
        if (this.bjl && this.visible && this.nhW) {
            dEt();
        } else {
            dEu();
        }
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        this.bjl = z;
        if (this.bjl && this.visible && this.nhW) {
            dEt();
        } else {
            dEu();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static class a implements Runnable {
        private final WeakReference<ConvenientBanner> gze;

        a(ConvenientBanner convenientBanner) {
            this.gze = new WeakReference<>(convenientBanner);
        }

        @Override // java.lang.Runnable
        public void run() {
            ConvenientBanner convenientBanner = this.gze.get();
            if (convenientBanner != null && convenientBanner.nhS != null && convenientBanner.nhV) {
                convenientBanner.nhY.setCurrentItem(convenientBanner.nhY.getCurrentItem() + 1, true);
                convenientBanner.postDelayed(convenientBanner.nib, convenientBanner.nhU);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static class b extends LinearLayoutManager {
        private boolean nie;

        b(Context context, int i, boolean z) {
            super(context, i, z);
            this.nie = true;
        }

        @Override // android.support.v7.widget.LinearLayoutManager, android.support.v7.widget.RecyclerView.LayoutManager
        public boolean canScrollHorizontally() {
            return this.nie && super.canScrollHorizontally();
        }

        void ws(boolean z) {
            this.nie = z;
        }
    }
}
