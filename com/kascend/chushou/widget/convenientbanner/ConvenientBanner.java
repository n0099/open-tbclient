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
    private int[] nha;
    private ArrayList<ImageView> nhb;
    private CBLoopViewPager nhc;
    private ViewGroup nhd;
    private long nhe;
    private boolean nhf;
    private boolean nhg;
    private boolean nhh;
    private com.kascend.chushou.widget.convenientbanner.b.a nhi;
    private com.kascend.chushou.widget.convenientbanner.d.a nhj;
    private c nhk;
    private a nhl;
    private b nhm;
    private boolean visible;

    public ConvenientBanner(Context context) {
        super(context);
        this.nhb = new ArrayList<>();
        this.nhe = -1L;
        this.nhg = false;
        this.nhh = true;
        this.visible = false;
        this.beV = true;
        init(context);
    }

    public ConvenientBanner(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.nhb = new ArrayList<>();
        this.nhe = -1L;
        this.nhg = false;
        this.nhh = true;
        this.visible = false;
        this.beV = true;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.c.ConvenientBanner);
        this.nhh = obtainStyledAttributes.getBoolean(a.c.ConvenientBanner_banner_canLoop, true);
        this.nhe = obtainStyledAttributes.getInteger(a.c.ConvenientBanner_banner_autoTurningTime, -1);
        obtainStyledAttributes.recycle();
        init(context);
    }

    private void init(Context context) {
        View inflate = LayoutInflater.from(context).inflate(a.b.banner_layout, (ViewGroup) this, true);
        this.nhc = (CBLoopViewPager) inflate.findViewById(a.C0713a.banner_loop_viewpager);
        this.nhd = (ViewGroup) inflate.findViewById(a.C0713a.banner_indicator);
        this.nhm = new b(context, 0, false);
        this.nhm.setItemPrefetchEnabled(true);
        this.nhm.setInitialPrefetchItemCount(1);
        this.nhc.setLayoutManager(this.nhm);
        this.nhc.setFocusableInTouchMode(false);
        this.nhc.requestFocus();
        this.nhi = new com.kascend.chushou.widget.convenientbanner.b.a();
        this.nhl = new a(this);
    }

    public ConvenientBanner a(com.kascend.chushou.widget.convenientbanner.c.a<T> aVar, List<T> list) {
        this.mDatas = list;
        this.nhc.setAdapter(new com.kascend.chushou.widget.convenientbanner.a.a(aVar, this.mDatas, this.nhh, this));
        if (this.nha != null) {
            q(this.nha);
        }
        this.nhi.MZ(this.nhh ? this.mDatas.size() : 0);
        this.nhi.a(this.nhc);
        return this;
    }

    public void notifyDataSetChanged() {
        this.nhc.getAdapter().notifyDataSetChanged();
        if (this.mDatas != null && this.mDatas.size() > 0) {
            this.nhi.setCurrentItem(0);
        }
        if (this.nha != null) {
            q(this.nha);
        }
    }

    public ConvenientBanner q(int[] iArr) {
        this.nhd.removeAllViews();
        this.nhb.clear();
        this.nha = iArr;
        if (this.mDatas != null) {
            for (int i = 0; i < this.mDatas.size(); i++) {
                ImageView imageView = new ImageView(getContext());
                imageView.setPadding(5, 0, 5, 0);
                if (this.nhi.dDn() % this.mDatas.size() == i) {
                    imageView.setImageResource(iArr[1]);
                } else {
                    imageView.setImageResource(iArr[0]);
                }
                this.nhb.add(imageView);
                this.nhd.addView(imageView);
            }
            if (this.mDatas.size() > 1) {
                this.nhd.setVisibility(0);
                this.nhm.wo(true);
            } else {
                this.nhd.setVisibility(8);
                this.nhm.wo(false);
            }
            this.nhj = new com.kascend.chushou.widget.convenientbanner.d.a(this.nhb, iArr);
            this.nhi.a(this.nhj);
            if (this.nhk != null) {
                this.nhj.a(this.nhk);
            }
        }
        return this;
    }

    public c getOnPageChangeListener() {
        return this.nhk;
    }

    public int getCurrentItem() {
        return this.nhi.dDm();
    }

    public int getFaceCurrentItem() {
        return this.nhi.getCurrentItem();
    }

    public ConvenientBanner j(int i, int i2, int i3, int i4, int i5) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.nhd.getLayoutParams();
        layoutParams.gravity = i;
        layoutParams.topMargin = i3;
        layoutParams.leftMargin = i2;
        layoutParams.rightMargin = i4;
        layoutParams.bottomMargin = i5;
        this.nhd.setLayoutParams(layoutParams);
        return this;
    }

    public ConvenientBanner gX(long j) {
        if (j >= 0) {
            if (this.nhf) {
                dDk();
            }
            this.nhg = true;
            this.nhe = j;
            this.nhf = true;
            postDelayed(this.nhl, j);
        }
        return this;
    }

    public ConvenientBanner dDj() {
        gX(this.nhe);
        return this;
    }

    public void dDk() {
        this.nhf = false;
        removeCallbacks(this.nhl);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 1 || action == 3 || action == 4) {
            if (this.nhg) {
                gX(this.nhe);
            }
        } else if (action == 0 && this.nhg) {
            dDk();
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        this.visible = i == 0;
        if (this.beV && this.visible && this.nhg) {
            dDj();
        } else {
            dDk();
        }
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        this.beV = z;
        if (this.beV && this.visible && this.nhg) {
            dDj();
        } else {
            dDk();
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
            if (convenientBanner != null && convenientBanner.nhc != null && convenientBanner.nhf) {
                convenientBanner.nhi.setCurrentItem(convenientBanner.nhi.getCurrentItem() + 1, true);
                convenientBanner.postDelayed(convenientBanner.nhl, convenientBanner.nhe);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static class b extends LinearLayoutManager {
        private boolean nhn;

        b(Context context, int i, boolean z) {
            super(context, i, z);
            this.nhn = true;
        }

        @Override // android.support.v7.widget.LinearLayoutManager, android.support.v7.widget.RecyclerView.LayoutManager
        public boolean canScrollHorizontally() {
            return this.nhn && super.canScrollHorizontally();
        }

        void wo(boolean z) {
            this.nhn = z;
        }
    }
}
