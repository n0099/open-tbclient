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
    private boolean bHG;
    private List<T> mDatas;
    private int[] mGl;
    private ArrayList<ImageView> mGm;
    private CBLoopViewPager mGn;
    private ViewGroup mGo;
    private long mGp;
    private boolean mGq;
    private boolean mGr;
    private boolean mGs;
    private com.kascend.chushou.widget.convenientbanner.b.a mGt;
    private com.kascend.chushou.widget.convenientbanner.d.a mGu;
    private c mGv;
    private a mGw;
    private b mGx;
    private boolean visible;

    public ConvenientBanner(Context context) {
        super(context);
        this.mGm = new ArrayList<>();
        this.mGp = -1L;
        this.mGr = false;
        this.mGs = true;
        this.visible = false;
        this.bHG = true;
        init(context);
    }

    public ConvenientBanner(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mGm = new ArrayList<>();
        this.mGp = -1L;
        this.mGr = false;
        this.mGs = true;
        this.visible = false;
        this.bHG = true;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.c.ConvenientBanner);
        this.mGs = obtainStyledAttributes.getBoolean(a.c.ConvenientBanner_banner_canLoop, true);
        this.mGp = obtainStyledAttributes.getInteger(a.c.ConvenientBanner_banner_autoTurningTime, -1);
        obtainStyledAttributes.recycle();
        init(context);
    }

    private void init(Context context) {
        View inflate = LayoutInflater.from(context).inflate(a.b.banner_layout, (ViewGroup) this, true);
        this.mGn = (CBLoopViewPager) inflate.findViewById(a.C0746a.banner_loop_viewpager);
        this.mGo = (ViewGroup) inflate.findViewById(a.C0746a.banner_indicator);
        this.mGx = new b(context, 0, false);
        this.mGx.setItemPrefetchEnabled(true);
        this.mGx.setInitialPrefetchItemCount(1);
        this.mGn.setLayoutManager(this.mGx);
        this.mGn.setFocusableInTouchMode(false);
        this.mGn.requestFocus();
        this.mGt = new com.kascend.chushou.widget.convenientbanner.b.a();
        this.mGw = new a(this);
    }

    public ConvenientBanner a(com.kascend.chushou.widget.convenientbanner.c.a<T> aVar, List<T> list) {
        this.mDatas = list;
        this.mGn.setAdapter(new com.kascend.chushou.widget.convenientbanner.a.a(aVar, this.mDatas, this.mGs, this));
        if (this.mGl != null) {
            r(this.mGl);
        }
        this.mGt.IC(this.mGs ? this.mDatas.size() : 0);
        this.mGt.a(this.mGn);
        return this;
    }

    public void notifyDataSetChanged() {
        this.mGn.getAdapter().notifyDataSetChanged();
        if (this.mDatas != null && this.mDatas.size() > 0) {
            this.mGt.setCurrentItem(0);
        }
        if (this.mGl != null) {
            r(this.mGl);
        }
    }

    public ConvenientBanner r(int[] iArr) {
        this.mGo.removeAllViews();
        this.mGm.clear();
        this.mGl = iArr;
        if (this.mDatas != null) {
            for (int i = 0; i < this.mDatas.size(); i++) {
                ImageView imageView = new ImageView(getContext());
                imageView.setPadding(5, 0, 5, 0);
                if (this.mGt.dyZ() % this.mDatas.size() == i) {
                    imageView.setImageResource(iArr[1]);
                } else {
                    imageView.setImageResource(iArr[0]);
                }
                this.mGm.add(imageView);
                this.mGo.addView(imageView);
            }
            if (this.mDatas.size() > 1) {
                this.mGo.setVisibility(0);
                this.mGx.wi(true);
            } else {
                this.mGo.setVisibility(8);
                this.mGx.wi(false);
            }
            this.mGu = new com.kascend.chushou.widget.convenientbanner.d.a(this.mGm, iArr);
            this.mGt.a(this.mGu);
            if (this.mGv != null) {
                this.mGu.a(this.mGv);
            }
        }
        return this;
    }

    public c getOnPageChangeListener() {
        return this.mGv;
    }

    public int getCurrentItem() {
        return this.mGt.dyY();
    }

    public int getFaceCurrentItem() {
        return this.mGt.getCurrentItem();
    }

    public ConvenientBanner h(int i, int i2, int i3, int i4, int i5) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.mGo.getLayoutParams();
        layoutParams.gravity = i;
        layoutParams.topMargin = i3;
        layoutParams.leftMargin = i2;
        layoutParams.rightMargin = i4;
        layoutParams.bottomMargin = i5;
        this.mGo.setLayoutParams(layoutParams);
        return this;
    }

    public ConvenientBanner fY(long j) {
        if (j >= 0) {
            if (this.mGq) {
                dyW();
            }
            this.mGr = true;
            this.mGp = j;
            this.mGq = true;
            postDelayed(this.mGw, j);
        }
        return this;
    }

    public ConvenientBanner dyV() {
        fY(this.mGp);
        return this;
    }

    public void dyW() {
        this.mGq = false;
        removeCallbacks(this.mGw);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 1 || action == 3 || action == 4) {
            if (this.mGr) {
                fY(this.mGp);
            }
        } else if (action == 0 && this.mGr) {
            dyW();
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        this.visible = i == 0;
        if (this.bHG && this.visible && this.mGr) {
            dyV();
        } else {
            dyW();
        }
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        this.bHG = z;
        if (this.bHG && this.visible && this.mGr) {
            dyV();
        } else {
            dyW();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static class a implements Runnable {
        private final WeakReference<ConvenientBanner> hjy;

        a(ConvenientBanner convenientBanner) {
            this.hjy = new WeakReference<>(convenientBanner);
        }

        @Override // java.lang.Runnable
        public void run() {
            ConvenientBanner convenientBanner = this.hjy.get();
            if (convenientBanner != null && convenientBanner.mGn != null && convenientBanner.mGq) {
                convenientBanner.mGt.setCurrentItem(convenientBanner.mGt.getCurrentItem() + 1, true);
                convenientBanner.postDelayed(convenientBanner.mGw, convenientBanner.mGp);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static class b extends LinearLayoutManager {
        private boolean mGy;

        b(Context context, int i, boolean z) {
            super(context, i, z);
            this.mGy = true;
        }

        @Override // android.support.v7.widget.LinearLayoutManager, android.support.v7.widget.RecyclerView.LayoutManager
        public boolean canScrollHorizontally() {
            return this.mGy && super.canScrollHorizontally();
        }

        void wi(boolean z) {
            this.mGy = z;
        }
    }
}
