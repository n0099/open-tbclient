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
    private boolean cdY;
    private List<T> mDatas;
    private int[] okc;
    private ArrayList<ImageView> okd;
    private CBLoopViewPager oke;
    private ViewGroup okf;
    private long okg;
    private boolean okh;
    private boolean oki;
    private boolean okj;
    private com.kascend.chushou.widget.convenientbanner.b.a okk;
    private com.kascend.chushou.widget.convenientbanner.d.a okl;
    private c okm;
    private a okn;
    private b oko;
    private boolean visible;

    public ConvenientBanner(Context context) {
        super(context);
        this.okd = new ArrayList<>();
        this.okg = -1L;
        this.oki = false;
        this.okj = true;
        this.visible = false;
        this.cdY = true;
        init(context);
    }

    public ConvenientBanner(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.okd = new ArrayList<>();
        this.okg = -1L;
        this.oki = false;
        this.okj = true;
        this.visible = false;
        this.cdY = true;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.c.ConvenientBanner);
        this.okj = obtainStyledAttributes.getBoolean(a.c.ConvenientBanner_banner_canLoop, true);
        this.okg = obtainStyledAttributes.getInteger(a.c.ConvenientBanner_banner_autoTurningTime, -1);
        obtainStyledAttributes.recycle();
        init(context);
    }

    private void init(Context context) {
        View inflate = LayoutInflater.from(context).inflate(a.b.banner_layout, (ViewGroup) this, true);
        this.oke = (CBLoopViewPager) inflate.findViewById(a.C0910a.banner_loop_viewpager);
        this.okf = (ViewGroup) inflate.findViewById(a.C0910a.banner_indicator);
        this.oko = new b(context, 0, false);
        this.oko.setItemPrefetchEnabled(true);
        this.oko.setInitialPrefetchItemCount(1);
        this.oke.setLayoutManager(this.oko);
        this.oke.setFocusableInTouchMode(false);
        this.oke.requestFocus();
        this.okk = new com.kascend.chushou.widget.convenientbanner.b.a();
        this.okn = new a(this);
    }

    public ConvenientBanner a(com.kascend.chushou.widget.convenientbanner.c.a<T> aVar, List<T> list) {
        this.mDatas = list;
        this.oke.setAdapter(new com.kascend.chushou.widget.convenientbanner.a.a(aVar, this.mDatas, this.okj, this));
        if (this.okc != null) {
            s(this.okc);
        }
        this.okk.NZ(this.okj ? this.mDatas.size() : 0);
        this.okk.a(this.oke);
        return this;
    }

    public void notifyDataSetChanged() {
        this.oke.getAdapter().notifyDataSetChanged();
        if (this.mDatas != null && this.mDatas.size() > 0) {
            this.okk.setCurrentItem(0);
        }
        if (this.okc != null) {
            s(this.okc);
        }
    }

    public ConvenientBanner s(int[] iArr) {
        this.okf.removeAllViews();
        this.okd.clear();
        this.okc = iArr;
        if (this.mDatas != null) {
            for (int i = 0; i < this.mDatas.size(); i++) {
                ImageView imageView = new ImageView(getContext());
                imageView.setPadding(5, 0, 5, 0);
                if (this.okk.eeR() % this.mDatas.size() == i) {
                    imageView.setImageResource(iArr[1]);
                } else {
                    imageView.setImageResource(iArr[0]);
                }
                this.okd.add(imageView);
                this.okf.addView(imageView);
            }
            if (this.mDatas.size() > 1) {
                this.okf.setVisibility(0);
                this.oko.yK(true);
            } else {
                this.okf.setVisibility(8);
                this.oko.yK(false);
            }
            this.okl = new com.kascend.chushou.widget.convenientbanner.d.a(this.okd, iArr);
            this.okk.a(this.okl);
            if (this.okm != null) {
                this.okl.a(this.okm);
            }
        }
        return this;
    }

    public c getOnPageChangeListener() {
        return this.okm;
    }

    public int getCurrentItem() {
        return this.okk.eeQ();
    }

    public int getFaceCurrentItem() {
        return this.okk.getCurrentItem();
    }

    public ConvenientBanner h(int i, int i2, int i3, int i4, int i5) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.okf.getLayoutParams();
        layoutParams.gravity = i;
        layoutParams.topMargin = i3;
        layoutParams.leftMargin = i2;
        layoutParams.rightMargin = i4;
        layoutParams.bottomMargin = i5;
        this.okf.setLayoutParams(layoutParams);
        return this;
    }

    public ConvenientBanner gT(long j) {
        if (j >= 0) {
            if (this.okh) {
                eeO();
            }
            this.oki = true;
            this.okg = j;
            this.okh = true;
            postDelayed(this.okn, j);
        }
        return this;
    }

    public ConvenientBanner eeN() {
        gT(this.okg);
        return this;
    }

    public void eeO() {
        this.okh = false;
        removeCallbacks(this.okn);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 1 || action == 3 || action == 4) {
            if (this.oki) {
                gT(this.okg);
            }
        } else if (action == 0 && this.oki) {
            eeO();
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        this.visible = i == 0;
        if (this.cdY && this.visible && this.oki) {
            eeN();
        } else {
            eeO();
        }
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        this.cdY = z;
        if (this.cdY && this.visible && this.oki) {
            eeN();
        } else {
            eeO();
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
            if (convenientBanner != null && convenientBanner.oke != null && convenientBanner.okh) {
                convenientBanner.okk.setCurrentItem(convenientBanner.okk.getCurrentItem() + 1, true);
                convenientBanner.postDelayed(convenientBanner.okn, convenientBanner.okg);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public static class b extends LinearLayoutManager {
        private boolean okp;

        b(Context context, int i, boolean z) {
            super(context, i, z);
            this.okp = true;
        }

        @Override // android.support.v7.widget.LinearLayoutManager, android.support.v7.widget.RecyclerView.LayoutManager
        public boolean canScrollHorizontally() {
            return this.okp && super.canScrollHorizontally();
        }

        void yK(boolean z) {
            this.okp = z;
        }
    }
}
