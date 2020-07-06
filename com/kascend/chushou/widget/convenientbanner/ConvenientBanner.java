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
    private boolean bVr;
    private List<T> mDatas;
    private boolean nxA;
    private boolean nxB;
    private com.kascend.chushou.widget.convenientbanner.b.a nxC;
    private com.kascend.chushou.widget.convenientbanner.d.a nxD;
    private c nxE;
    private a nxF;
    private b nxG;
    private int[] nxu;
    private ArrayList<ImageView> nxv;
    private CBLoopViewPager nxw;
    private ViewGroup nxx;
    private long nxy;
    private boolean nxz;
    private boolean visible;

    public ConvenientBanner(Context context) {
        super(context);
        this.nxv = new ArrayList<>();
        this.nxy = -1L;
        this.nxA = false;
        this.nxB = true;
        this.visible = false;
        this.bVr = true;
        init(context);
    }

    public ConvenientBanner(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.nxv = new ArrayList<>();
        this.nxy = -1L;
        this.nxA = false;
        this.nxB = true;
        this.visible = false;
        this.bVr = true;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.c.ConvenientBanner);
        this.nxB = obtainStyledAttributes.getBoolean(a.c.ConvenientBanner_banner_canLoop, true);
        this.nxy = obtainStyledAttributes.getInteger(a.c.ConvenientBanner_banner_autoTurningTime, -1);
        obtainStyledAttributes.recycle();
        init(context);
    }

    private void init(Context context) {
        View inflate = LayoutInflater.from(context).inflate(a.b.banner_layout, (ViewGroup) this, true);
        this.nxw = (CBLoopViewPager) inflate.findViewById(a.C0846a.banner_loop_viewpager);
        this.nxx = (ViewGroup) inflate.findViewById(a.C0846a.banner_indicator);
        this.nxG = new b(context, 0, false);
        this.nxG.setItemPrefetchEnabled(true);
        this.nxG.setInitialPrefetchItemCount(1);
        this.nxw.setLayoutManager(this.nxG);
        this.nxw.setFocusableInTouchMode(false);
        this.nxw.requestFocus();
        this.nxC = new com.kascend.chushou.widget.convenientbanner.b.a();
        this.nxF = new a(this);
    }

    public ConvenientBanner a(com.kascend.chushou.widget.convenientbanner.c.a<T> aVar, List<T> list) {
        this.mDatas = list;
        this.nxw.setAdapter(new com.kascend.chushou.widget.convenientbanner.a.a(aVar, this.mDatas, this.nxB, this));
        if (this.nxu != null) {
            r(this.nxu);
        }
        this.nxC.Kw(this.nxB ? this.mDatas.size() : 0);
        this.nxC.a(this.nxw);
        return this;
    }

    public void notifyDataSetChanged() {
        this.nxw.getAdapter().notifyDataSetChanged();
        if (this.mDatas != null && this.mDatas.size() > 0) {
            this.nxC.setCurrentItem(0);
        }
        if (this.nxu != null) {
            r(this.nxu);
        }
    }

    public ConvenientBanner r(int[] iArr) {
        this.nxx.removeAllViews();
        this.nxv.clear();
        this.nxu = iArr;
        if (this.mDatas != null) {
            for (int i = 0; i < this.mDatas.size(); i++) {
                ImageView imageView = new ImageView(getContext());
                imageView.setPadding(5, 0, 5, 0);
                if (this.nxC.dLm() % this.mDatas.size() == i) {
                    imageView.setImageResource(iArr[1]);
                } else {
                    imageView.setImageResource(iArr[0]);
                }
                this.nxv.add(imageView);
                this.nxx.addView(imageView);
            }
            if (this.mDatas.size() > 1) {
                this.nxx.setVisibility(0);
                this.nxG.xd(true);
            } else {
                this.nxx.setVisibility(8);
                this.nxG.xd(false);
            }
            this.nxD = new com.kascend.chushou.widget.convenientbanner.d.a(this.nxv, iArr);
            this.nxC.a(this.nxD);
            if (this.nxE != null) {
                this.nxD.a(this.nxE);
            }
        }
        return this;
    }

    public c getOnPageChangeListener() {
        return this.nxE;
    }

    public int getCurrentItem() {
        return this.nxC.dLl();
    }

    public int getFaceCurrentItem() {
        return this.nxC.getCurrentItem();
    }

    public ConvenientBanner h(int i, int i2, int i3, int i4, int i5) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.nxx.getLayoutParams();
        layoutParams.gravity = i;
        layoutParams.topMargin = i3;
        layoutParams.leftMargin = i2;
        layoutParams.rightMargin = i4;
        layoutParams.bottomMargin = i5;
        this.nxx.setLayoutParams(layoutParams);
        return this;
    }

    public ConvenientBanner gd(long j) {
        if (j >= 0) {
            if (this.nxz) {
                dLj();
            }
            this.nxA = true;
            this.nxy = j;
            this.nxz = true;
            postDelayed(this.nxF, j);
        }
        return this;
    }

    public ConvenientBanner dLi() {
        gd(this.nxy);
        return this;
    }

    public void dLj() {
        this.nxz = false;
        removeCallbacks(this.nxF);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 1 || action == 3 || action == 4) {
            if (this.nxA) {
                gd(this.nxy);
            }
        } else if (action == 0 && this.nxA) {
            dLj();
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        this.visible = i == 0;
        if (this.bVr && this.visible && this.nxA) {
            dLi();
        } else {
            dLj();
        }
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        this.bVr = z;
        if (this.bVr && this.visible && this.nxA) {
            dLi();
        } else {
            dLj();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static class a implements Runnable {
        private final WeakReference<ConvenientBanner> hLA;

        a(ConvenientBanner convenientBanner) {
            this.hLA = new WeakReference<>(convenientBanner);
        }

        @Override // java.lang.Runnable
        public void run() {
            ConvenientBanner convenientBanner = this.hLA.get();
            if (convenientBanner != null && convenientBanner.nxw != null && convenientBanner.nxz) {
                convenientBanner.nxC.setCurrentItem(convenientBanner.nxC.getCurrentItem() + 1, true);
                convenientBanner.postDelayed(convenientBanner.nxF, convenientBanner.nxy);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static class b extends LinearLayoutManager {
        private boolean nxH;

        b(Context context, int i, boolean z) {
            super(context, i, z);
            this.nxH = true;
        }

        @Override // android.support.v7.widget.LinearLayoutManager, android.support.v7.widget.RecyclerView.LayoutManager
        public boolean canScrollHorizontally() {
            return this.nxH && super.canScrollHorizontally();
        }

        void xd(boolean z) {
            this.nxH = z;
        }
    }
}
