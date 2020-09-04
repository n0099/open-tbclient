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
    private boolean cbV;
    private List<T> mDatas;
    private b oaA;
    private int[] oao;
    private ArrayList<ImageView> oap;
    private CBLoopViewPager oaq;
    private ViewGroup oar;
    private long oas;
    private boolean oat;
    private boolean oau;
    private boolean oav;
    private com.kascend.chushou.widget.convenientbanner.b.a oaw;
    private com.kascend.chushou.widget.convenientbanner.d.a oax;
    private c oay;
    private a oaz;
    private boolean visible;

    public ConvenientBanner(Context context) {
        super(context);
        this.oap = new ArrayList<>();
        this.oas = -1L;
        this.oau = false;
        this.oav = true;
        this.visible = false;
        this.cbV = true;
        init(context);
    }

    public ConvenientBanner(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.oap = new ArrayList<>();
        this.oas = -1L;
        this.oau = false;
        this.oav = true;
        this.visible = false;
        this.cbV = true;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.c.ConvenientBanner);
        this.oav = obtainStyledAttributes.getBoolean(a.c.ConvenientBanner_banner_canLoop, true);
        this.oas = obtainStyledAttributes.getInteger(a.c.ConvenientBanner_banner_autoTurningTime, -1);
        obtainStyledAttributes.recycle();
        init(context);
    }

    private void init(Context context) {
        View inflate = LayoutInflater.from(context).inflate(a.b.banner_layout, (ViewGroup) this, true);
        this.oaq = (CBLoopViewPager) inflate.findViewById(a.C0913a.banner_loop_viewpager);
        this.oar = (ViewGroup) inflate.findViewById(a.C0913a.banner_indicator);
        this.oaA = new b(context, 0, false);
        this.oaA.setItemPrefetchEnabled(true);
        this.oaA.setInitialPrefetchItemCount(1);
        this.oaq.setLayoutManager(this.oaA);
        this.oaq.setFocusableInTouchMode(false);
        this.oaq.requestFocus();
        this.oaw = new com.kascend.chushou.widget.convenientbanner.b.a();
        this.oaz = new a(this);
    }

    public ConvenientBanner a(com.kascend.chushou.widget.convenientbanner.c.a<T> aVar, List<T> list) {
        this.mDatas = list;
        this.oaq.setAdapter(new com.kascend.chushou.widget.convenientbanner.a.a(aVar, this.mDatas, this.oav, this));
        if (this.oao != null) {
            s(this.oao);
        }
        this.oaw.Nu(this.oav ? this.mDatas.size() : 0);
        this.oaw.a(this.oaq);
        return this;
    }

    public void notifyDataSetChanged() {
        this.oaq.getAdapter().notifyDataSetChanged();
        if (this.mDatas != null && this.mDatas.size() > 0) {
            this.oaw.setCurrentItem(0);
        }
        if (this.oao != null) {
            s(this.oao);
        }
    }

    public ConvenientBanner s(int[] iArr) {
        this.oar.removeAllViews();
        this.oap.clear();
        this.oao = iArr;
        if (this.mDatas != null) {
            for (int i = 0; i < this.mDatas.size(); i++) {
                ImageView imageView = new ImageView(getContext());
                imageView.setPadding(5, 0, 5, 0);
                if (this.oaw.eaT() % this.mDatas.size() == i) {
                    imageView.setImageResource(iArr[1]);
                } else {
                    imageView.setImageResource(iArr[0]);
                }
                this.oap.add(imageView);
                this.oar.addView(imageView);
            }
            if (this.mDatas.size() > 1) {
                this.oar.setVisibility(0);
                this.oaA.yC(true);
            } else {
                this.oar.setVisibility(8);
                this.oaA.yC(false);
            }
            this.oax = new com.kascend.chushou.widget.convenientbanner.d.a(this.oap, iArr);
            this.oaw.a(this.oax);
            if (this.oay != null) {
                this.oax.a(this.oay);
            }
        }
        return this;
    }

    public c getOnPageChangeListener() {
        return this.oay;
    }

    public int getCurrentItem() {
        return this.oaw.eaS();
    }

    public int getFaceCurrentItem() {
        return this.oaw.getCurrentItem();
    }

    public ConvenientBanner h(int i, int i2, int i3, int i4, int i5) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.oar.getLayoutParams();
        layoutParams.gravity = i;
        layoutParams.topMargin = i3;
        layoutParams.leftMargin = i2;
        layoutParams.rightMargin = i4;
        layoutParams.bottomMargin = i5;
        this.oar.setLayoutParams(layoutParams);
        return this;
    }

    public ConvenientBanner gF(long j) {
        if (j >= 0) {
            if (this.oat) {
                eaQ();
            }
            this.oau = true;
            this.oas = j;
            this.oat = true;
            postDelayed(this.oaz, j);
        }
        return this;
    }

    public ConvenientBanner eaP() {
        gF(this.oas);
        return this;
    }

    public void eaQ() {
        this.oat = false;
        removeCallbacks(this.oaz);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 1 || action == 3 || action == 4) {
            if (this.oau) {
                gF(this.oas);
            }
        } else if (action == 0 && this.oau) {
            eaQ();
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        this.visible = i == 0;
        if (this.cbV && this.visible && this.oau) {
            eaP();
        } else {
            eaQ();
        }
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        this.cbV = z;
        if (this.cbV && this.visible && this.oau) {
            eaP();
        } else {
            eaQ();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public static class a implements Runnable {
        private final WeakReference<ConvenientBanner> reference;

        a(ConvenientBanner convenientBanner) {
            this.reference = new WeakReference<>(convenientBanner);
        }

        @Override // java.lang.Runnable
        public void run() {
            ConvenientBanner convenientBanner = this.reference.get();
            if (convenientBanner != null && convenientBanner.oaq != null && convenientBanner.oat) {
                convenientBanner.oaw.setCurrentItem(convenientBanner.oaw.getCurrentItem() + 1, true);
                convenientBanner.postDelayed(convenientBanner.oaz, convenientBanner.oas);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public static class b extends LinearLayoutManager {
        private boolean oaB;

        b(Context context, int i, boolean z) {
            super(context, i, z);
            this.oaB = true;
        }

        @Override // android.support.v7.widget.LinearLayoutManager, android.support.v7.widget.RecyclerView.LayoutManager
        public boolean canScrollHorizontally() {
            return this.oaB && super.canScrollHorizontally();
        }

        void yC(boolean z) {
            this.oaB = z;
        }
    }
}
