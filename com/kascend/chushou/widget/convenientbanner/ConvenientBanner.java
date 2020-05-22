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
    private boolean bQD;
    private List<T> mDatas;
    private c naA;
    private a naB;
    private b naC;
    private int[] naq;
    private ArrayList<ImageView> nar;
    private CBLoopViewPager nas;
    private ViewGroup nat;
    private long nau;
    private boolean nav;
    private boolean naw;
    private boolean nax;
    private com.kascend.chushou.widget.convenientbanner.b.a nay;
    private com.kascend.chushou.widget.convenientbanner.d.a naz;
    private boolean visible;

    public ConvenientBanner(Context context) {
        super(context);
        this.nar = new ArrayList<>();
        this.nau = -1L;
        this.naw = false;
        this.nax = true;
        this.visible = false;
        this.bQD = true;
        init(context);
    }

    public ConvenientBanner(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.nar = new ArrayList<>();
        this.nau = -1L;
        this.naw = false;
        this.nax = true;
        this.visible = false;
        this.bQD = true;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.c.ConvenientBanner);
        this.nax = obtainStyledAttributes.getBoolean(a.c.ConvenientBanner_banner_canLoop, true);
        this.nau = obtainStyledAttributes.getInteger(a.c.ConvenientBanner_banner_autoTurningTime, -1);
        obtainStyledAttributes.recycle();
        init(context);
    }

    private void init(Context context) {
        View inflate = LayoutInflater.from(context).inflate(a.b.banner_layout, (ViewGroup) this, true);
        this.nas = (CBLoopViewPager) inflate.findViewById(a.C0825a.banner_loop_viewpager);
        this.nat = (ViewGroup) inflate.findViewById(a.C0825a.banner_indicator);
        this.naC = new b(context, 0, false);
        this.naC.setItemPrefetchEnabled(true);
        this.naC.setInitialPrefetchItemCount(1);
        this.nas.setLayoutManager(this.naC);
        this.nas.setFocusableInTouchMode(false);
        this.nas.requestFocus();
        this.nay = new com.kascend.chushou.widget.convenientbanner.b.a();
        this.naB = new a(this);
    }

    public ConvenientBanner a(com.kascend.chushou.widget.convenientbanner.c.a<T> aVar, List<T> list) {
        this.mDatas = list;
        this.nas.setAdapter(new com.kascend.chushou.widget.convenientbanner.a.a(aVar, this.mDatas, this.nax, this));
        if (this.naq != null) {
            r(this.naq);
        }
        this.nay.Jn(this.nax ? this.mDatas.size() : 0);
        this.nay.a(this.nas);
        return this;
    }

    public void notifyDataSetChanged() {
        this.nas.getAdapter().notifyDataSetChanged();
        if (this.mDatas != null && this.mDatas.size() > 0) {
            this.nay.setCurrentItem(0);
        }
        if (this.naq != null) {
            r(this.naq);
        }
    }

    public ConvenientBanner r(int[] iArr) {
        this.nat.removeAllViews();
        this.nar.clear();
        this.naq = iArr;
        if (this.mDatas != null) {
            for (int i = 0; i < this.mDatas.size(); i++) {
                ImageView imageView = new ImageView(getContext());
                imageView.setPadding(5, 0, 5, 0);
                if (this.nay.dGo() % this.mDatas.size() == i) {
                    imageView.setImageResource(iArr[1]);
                } else {
                    imageView.setImageResource(iArr[0]);
                }
                this.nar.add(imageView);
                this.nat.addView(imageView);
            }
            if (this.mDatas.size() > 1) {
                this.nat.setVisibility(0);
                this.naC.wG(true);
            } else {
                this.nat.setVisibility(8);
                this.naC.wG(false);
            }
            this.naz = new com.kascend.chushou.widget.convenientbanner.d.a(this.nar, iArr);
            this.nay.a(this.naz);
            if (this.naA != null) {
                this.naz.a(this.naA);
            }
        }
        return this;
    }

    public c getOnPageChangeListener() {
        return this.naA;
    }

    public int getCurrentItem() {
        return this.nay.dGn();
    }

    public int getFaceCurrentItem() {
        return this.nay.getCurrentItem();
    }

    public ConvenientBanner h(int i, int i2, int i3, int i4, int i5) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.nat.getLayoutParams();
        layoutParams.gravity = i;
        layoutParams.topMargin = i3;
        layoutParams.leftMargin = i2;
        layoutParams.rightMargin = i4;
        layoutParams.bottomMargin = i5;
        this.nat.setLayoutParams(layoutParams);
        return this;
    }

    public ConvenientBanner fY(long j) {
        if (j >= 0) {
            if (this.nav) {
                dGl();
            }
            this.naw = true;
            this.nau = j;
            this.nav = true;
            postDelayed(this.naB, j);
        }
        return this;
    }

    public ConvenientBanner dGk() {
        fY(this.nau);
        return this;
    }

    public void dGl() {
        this.nav = false;
        removeCallbacks(this.naB);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 1 || action == 3 || action == 4) {
            if (this.naw) {
                fY(this.nau);
            }
        } else if (action == 0 && this.naw) {
            dGl();
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        this.visible = i == 0;
        if (this.bQD && this.visible && this.naw) {
            dGk();
        } else {
            dGl();
        }
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        this.bQD = z;
        if (this.bQD && this.visible && this.naw) {
            dGk();
        } else {
            dGl();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static class a implements Runnable {
        private final WeakReference<ConvenientBanner> hys;

        a(ConvenientBanner convenientBanner) {
            this.hys = new WeakReference<>(convenientBanner);
        }

        @Override // java.lang.Runnable
        public void run() {
            ConvenientBanner convenientBanner = this.hys.get();
            if (convenientBanner != null && convenientBanner.nas != null && convenientBanner.nav) {
                convenientBanner.nay.setCurrentItem(convenientBanner.nay.getCurrentItem() + 1, true);
                convenientBanner.postDelayed(convenientBanner.naB, convenientBanner.nau);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static class b extends LinearLayoutManager {
        private boolean naD;

        b(Context context, int i, boolean z) {
            super(context, i, z);
            this.naD = true;
        }

        @Override // android.support.v7.widget.LinearLayoutManager, android.support.v7.widget.RecyclerView.LayoutManager
        public boolean canScrollHorizontally() {
            return this.naD && super.canScrollHorizontally();
        }

        void wG(boolean z) {
            this.naD = z;
        }
    }
}
