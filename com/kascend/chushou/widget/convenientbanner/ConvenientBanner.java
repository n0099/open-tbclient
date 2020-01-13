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
/* loaded from: classes4.dex */
public class ConvenientBanner<T> extends RelativeLayout {
    private boolean beV;
    private List<T> mDatas;
    private int[] ngV;
    private ArrayList<ImageView> ngW;
    private CBLoopViewPager ngX;
    private ViewGroup ngY;
    private long ngZ;
    private boolean nha;
    private boolean nhb;
    private boolean nhc;
    private com.kascend.chushou.widget.convenientbanner.b.a nhd;
    private com.kascend.chushou.widget.convenientbanner.d.a nhe;
    private c nhf;
    private a nhg;
    private b nhh;
    private boolean visible;

    public ConvenientBanner(Context context) {
        super(context);
        this.ngW = new ArrayList<>();
        this.ngZ = -1L;
        this.nhb = false;
        this.nhc = true;
        this.visible = false;
        this.beV = true;
        init(context);
    }

    public ConvenientBanner(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ngW = new ArrayList<>();
        this.ngZ = -1L;
        this.nhb = false;
        this.nhc = true;
        this.visible = false;
        this.beV = true;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.c.ConvenientBanner);
        this.nhc = obtainStyledAttributes.getBoolean(a.c.ConvenientBanner_banner_canLoop, true);
        this.ngZ = obtainStyledAttributes.getInteger(a.c.ConvenientBanner_banner_autoTurningTime, -1);
        obtainStyledAttributes.recycle();
        init(context);
    }

    private void init(Context context) {
        View inflate = LayoutInflater.from(context).inflate(a.b.banner_layout, (ViewGroup) this, true);
        this.ngX = (CBLoopViewPager) inflate.findViewById(a.C0713a.banner_loop_viewpager);
        this.ngY = (ViewGroup) inflate.findViewById(a.C0713a.banner_indicator);
        this.nhh = new b(context, 0, false);
        this.nhh.setItemPrefetchEnabled(true);
        this.nhh.setInitialPrefetchItemCount(1);
        this.ngX.setLayoutManager(this.nhh);
        this.ngX.setFocusableInTouchMode(false);
        this.ngX.requestFocus();
        this.nhd = new com.kascend.chushou.widget.convenientbanner.b.a();
        this.nhg = new a(this);
    }

    public ConvenientBanner a(com.kascend.chushou.widget.convenientbanner.c.a<T> aVar, List<T> list) {
        this.mDatas = list;
        this.ngX.setAdapter(new com.kascend.chushou.widget.convenientbanner.a.a(aVar, this.mDatas, this.nhc, this));
        if (this.ngV != null) {
            q(this.ngV);
        }
        this.nhd.MZ(this.nhc ? this.mDatas.size() : 0);
        this.nhd.a(this.ngX);
        return this;
    }

    public void notifyDataSetChanged() {
        this.ngX.getAdapter().notifyDataSetChanged();
        if (this.mDatas != null && this.mDatas.size() > 0) {
            this.nhd.setCurrentItem(0);
        }
        if (this.ngV != null) {
            q(this.ngV);
        }
    }

    public ConvenientBanner q(int[] iArr) {
        this.ngY.removeAllViews();
        this.ngW.clear();
        this.ngV = iArr;
        if (this.mDatas != null) {
            for (int i = 0; i < this.mDatas.size(); i++) {
                ImageView imageView = new ImageView(getContext());
                imageView.setPadding(5, 0, 5, 0);
                if (this.nhd.dDl() % this.mDatas.size() == i) {
                    imageView.setImageResource(iArr[1]);
                } else {
                    imageView.setImageResource(iArr[0]);
                }
                this.ngW.add(imageView);
                this.ngY.addView(imageView);
            }
            if (this.mDatas.size() > 1) {
                this.ngY.setVisibility(0);
                this.nhh.wo(true);
            } else {
                this.ngY.setVisibility(8);
                this.nhh.wo(false);
            }
            this.nhe = new com.kascend.chushou.widget.convenientbanner.d.a(this.ngW, iArr);
            this.nhd.a(this.nhe);
            if (this.nhf != null) {
                this.nhe.a(this.nhf);
            }
        }
        return this;
    }

    public c getOnPageChangeListener() {
        return this.nhf;
    }

    public int getCurrentItem() {
        return this.nhd.dDk();
    }

    public int getFaceCurrentItem() {
        return this.nhd.getCurrentItem();
    }

    public ConvenientBanner j(int i, int i2, int i3, int i4, int i5) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.ngY.getLayoutParams();
        layoutParams.gravity = i;
        layoutParams.topMargin = i3;
        layoutParams.leftMargin = i2;
        layoutParams.rightMargin = i4;
        layoutParams.bottomMargin = i5;
        this.ngY.setLayoutParams(layoutParams);
        return this;
    }

    public ConvenientBanner gX(long j) {
        if (j >= 0) {
            if (this.nha) {
                dDi();
            }
            this.nhb = true;
            this.ngZ = j;
            this.nha = true;
            postDelayed(this.nhg, j);
        }
        return this;
    }

    public ConvenientBanner dDh() {
        gX(this.ngZ);
        return this;
    }

    public void dDi() {
        this.nha = false;
        removeCallbacks(this.nhg);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 1 || action == 3 || action == 4) {
            if (this.nhb) {
                gX(this.ngZ);
            }
        } else if (action == 0 && this.nhb) {
            dDi();
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        this.visible = i == 0;
        if (this.beV && this.visible && this.nhb) {
            dDh();
        } else {
            dDi();
        }
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        this.beV = z;
        if (this.beV && this.visible && this.nhb) {
            dDh();
        } else {
            dDi();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public static class a implements Runnable {
        private final WeakReference<ConvenientBanner> gwP;

        a(ConvenientBanner convenientBanner) {
            this.gwP = new WeakReference<>(convenientBanner);
        }

        @Override // java.lang.Runnable
        public void run() {
            ConvenientBanner convenientBanner = this.gwP.get();
            if (convenientBanner != null && convenientBanner.ngX != null && convenientBanner.nha) {
                convenientBanner.nhd.setCurrentItem(convenientBanner.nhd.getCurrentItem() + 1, true);
                convenientBanner.postDelayed(convenientBanner.nhg, convenientBanner.ngZ);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static class b extends LinearLayoutManager {
        private boolean nhi;

        b(Context context, int i, boolean z) {
            super(context, i, z);
            this.nhi = true;
        }

        @Override // android.support.v7.widget.LinearLayoutManager, android.support.v7.widget.RecyclerView.LayoutManager
        public boolean canScrollHorizontally() {
            return this.nhi && super.canScrollHorizontally();
        }

        void wo(boolean z) {
            this.nhi = z;
        }
    }
}
