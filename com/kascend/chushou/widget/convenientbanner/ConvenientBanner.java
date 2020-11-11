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
    private boolean cEI;
    private List<T> mDatas;
    private int[] pAl;
    private ArrayList<ImageView> pAm;
    private CBLoopViewPager pAn;
    private ViewGroup pAo;
    private long pAp;
    private boolean pAq;
    private boolean pAr;
    private boolean pAs;
    private com.kascend.chushou.widget.convenientbanner.b.a pAt;
    private com.kascend.chushou.widget.convenientbanner.d.a pAu;
    private c pAv;
    private a pAw;
    private b pAx;
    private boolean visible;

    public ConvenientBanner(Context context) {
        super(context);
        this.pAm = new ArrayList<>();
        this.pAp = -1L;
        this.pAr = false;
        this.pAs = true;
        this.visible = false;
        this.cEI = true;
        init(context);
    }

    public ConvenientBanner(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.pAm = new ArrayList<>();
        this.pAp = -1L;
        this.pAr = false;
        this.pAs = true;
        this.visible = false;
        this.cEI = true;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.c.ConvenientBanner);
        this.pAs = obtainStyledAttributes.getBoolean(a.c.ConvenientBanner_banner_canLoop, true);
        this.pAp = obtainStyledAttributes.getInteger(a.c.ConvenientBanner_banner_autoTurningTime, -1);
        obtainStyledAttributes.recycle();
        init(context);
    }

    private void init(Context context) {
        View inflate = LayoutInflater.from(context).inflate(a.b.banner_layout, (ViewGroup) this, true);
        this.pAn = (CBLoopViewPager) inflate.findViewById(a.C1019a.banner_loop_viewpager);
        this.pAo = (ViewGroup) inflate.findViewById(a.C1019a.banner_indicator);
        this.pAx = new b(context, 0, false);
        this.pAx.setItemPrefetchEnabled(true);
        this.pAx.setInitialPrefetchItemCount(1);
        this.pAn.setLayoutManager(this.pAx);
        this.pAn.setFocusableInTouchMode(false);
        this.pAn.requestFocus();
        this.pAt = new com.kascend.chushou.widget.convenientbanner.b.a();
        this.pAw = new a(this);
    }

    public ConvenientBanner a(com.kascend.chushou.widget.convenientbanner.c.a<T> aVar, List<T> list) {
        this.mDatas = list;
        this.pAn.setAdapter(new com.kascend.chushou.widget.convenientbanner.a.a(aVar, this.mDatas, this.pAs, this));
        if (this.pAl != null) {
            t(this.pAl);
        }
        this.pAt.QR(this.pAs ? this.mDatas.size() : 0);
        this.pAt.a(this.pAn);
        return this;
    }

    public void notifyDataSetChanged() {
        this.pAn.getAdapter().notifyDataSetChanged();
        if (this.mDatas != null && this.mDatas.size() > 0) {
            this.pAt.setCurrentItem(0);
        }
        if (this.pAl != null) {
            t(this.pAl);
        }
    }

    public ConvenientBanner t(int[] iArr) {
        this.pAo.removeAllViews();
        this.pAm.clear();
        this.pAl = iArr;
        if (this.mDatas != null) {
            for (int i = 0; i < this.mDatas.size(); i++) {
                ImageView imageView = new ImageView(getContext());
                imageView.setPadding(5, 0, 5, 0);
                if (this.pAt.ewr() % this.mDatas.size() == i) {
                    imageView.setImageResource(iArr[1]);
                } else {
                    imageView.setImageResource(iArr[0]);
                }
                this.pAm.add(imageView);
                this.pAo.addView(imageView);
            }
            if (this.mDatas.size() > 1) {
                this.pAo.setVisibility(0);
                this.pAx.AK(true);
            } else {
                this.pAo.setVisibility(8);
                this.pAx.AK(false);
            }
            this.pAu = new com.kascend.chushou.widget.convenientbanner.d.a(this.pAm, iArr);
            this.pAt.a(this.pAu);
            if (this.pAv != null) {
                this.pAu.a(this.pAv);
            }
        }
        return this;
    }

    public c getOnPageChangeListener() {
        return this.pAv;
    }

    public int getCurrentItem() {
        return this.pAt.ewq();
    }

    public int getFaceCurrentItem() {
        return this.pAt.getCurrentItem();
    }

    public ConvenientBanner h(int i, int i2, int i3, int i4, int i5) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.pAo.getLayoutParams();
        layoutParams.gravity = i;
        layoutParams.topMargin = i3;
        layoutParams.leftMargin = i2;
        layoutParams.rightMargin = i4;
        layoutParams.bottomMargin = i5;
        this.pAo.setLayoutParams(layoutParams);
        return this;
    }

    public ConvenientBanner hX(long j) {
        if (j >= 0) {
            if (this.pAq) {
                ewo();
            }
            this.pAr = true;
            this.pAp = j;
            this.pAq = true;
            postDelayed(this.pAw, j);
        }
        return this;
    }

    public ConvenientBanner ewn() {
        hX(this.pAp);
        return this;
    }

    public void ewo() {
        this.pAq = false;
        removeCallbacks(this.pAw);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 1 || action == 3 || action == 4) {
            if (this.pAr) {
                hX(this.pAp);
            }
        } else if (action == 0 && this.pAr) {
            ewo();
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        this.visible = i == 0;
        if (this.cEI && this.visible && this.pAr) {
            ewn();
        } else {
            ewo();
        }
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        this.cEI = z;
        if (this.cEI && this.visible && this.pAr) {
            ewn();
        } else {
            ewo();
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
            if (convenientBanner != null && convenientBanner.pAn != null && convenientBanner.pAq) {
                convenientBanner.pAt.setCurrentItem(convenientBanner.pAt.getCurrentItem() + 1, true);
                convenientBanner.postDelayed(convenientBanner.pAw, convenientBanner.pAp);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public static class b extends LinearLayoutManager {
        private boolean pAy;

        b(Context context, int i, boolean z) {
            super(context, i, z);
            this.pAy = true;
        }

        @Override // android.support.v7.widget.LinearLayoutManager, android.support.v7.widget.RecyclerView.LayoutManager
        public boolean canScrollHorizontally() {
            return this.pAy && super.canScrollHorizontally();
        }

        void AK(boolean z) {
            this.pAy = z;
        }
    }
}
