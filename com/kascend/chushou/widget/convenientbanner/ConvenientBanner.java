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
    private com.kascend.chushou.widget.convenientbanner.d.a nxA;
    private c nxB;
    private a nxC;
    private b nxD;
    private int[] nxr;
    private ArrayList<ImageView> nxs;
    private CBLoopViewPager nxt;
    private ViewGroup nxu;
    private long nxv;
    private boolean nxw;
    private boolean nxx;
    private boolean nxy;
    private com.kascend.chushou.widget.convenientbanner.b.a nxz;
    private boolean visible;

    public ConvenientBanner(Context context) {
        super(context);
        this.nxs = new ArrayList<>();
        this.nxv = -1L;
        this.nxx = false;
        this.nxy = true;
        this.visible = false;
        this.bVr = true;
        init(context);
    }

    public ConvenientBanner(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.nxs = new ArrayList<>();
        this.nxv = -1L;
        this.nxx = false;
        this.nxy = true;
        this.visible = false;
        this.bVr = true;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.c.ConvenientBanner);
        this.nxy = obtainStyledAttributes.getBoolean(a.c.ConvenientBanner_banner_canLoop, true);
        this.nxv = obtainStyledAttributes.getInteger(a.c.ConvenientBanner_banner_autoTurningTime, -1);
        obtainStyledAttributes.recycle();
        init(context);
    }

    private void init(Context context) {
        View inflate = LayoutInflater.from(context).inflate(a.b.banner_layout, (ViewGroup) this, true);
        this.nxt = (CBLoopViewPager) inflate.findViewById(a.C0845a.banner_loop_viewpager);
        this.nxu = (ViewGroup) inflate.findViewById(a.C0845a.banner_indicator);
        this.nxD = new b(context, 0, false);
        this.nxD.setItemPrefetchEnabled(true);
        this.nxD.setInitialPrefetchItemCount(1);
        this.nxt.setLayoutManager(this.nxD);
        this.nxt.setFocusableInTouchMode(false);
        this.nxt.requestFocus();
        this.nxz = new com.kascend.chushou.widget.convenientbanner.b.a();
        this.nxC = new a(this);
    }

    public ConvenientBanner a(com.kascend.chushou.widget.convenientbanner.c.a<T> aVar, List<T> list) {
        this.mDatas = list;
        this.nxt.setAdapter(new com.kascend.chushou.widget.convenientbanner.a.a(aVar, this.mDatas, this.nxy, this));
        if (this.nxr != null) {
            r(this.nxr);
        }
        this.nxz.Kw(this.nxy ? this.mDatas.size() : 0);
        this.nxz.a(this.nxt);
        return this;
    }

    public void notifyDataSetChanged() {
        this.nxt.getAdapter().notifyDataSetChanged();
        if (this.mDatas != null && this.mDatas.size() > 0) {
            this.nxz.setCurrentItem(0);
        }
        if (this.nxr != null) {
            r(this.nxr);
        }
    }

    public ConvenientBanner r(int[] iArr) {
        this.nxu.removeAllViews();
        this.nxs.clear();
        this.nxr = iArr;
        if (this.mDatas != null) {
            for (int i = 0; i < this.mDatas.size(); i++) {
                ImageView imageView = new ImageView(getContext());
                imageView.setPadding(5, 0, 5, 0);
                if (this.nxz.dLi() % this.mDatas.size() == i) {
                    imageView.setImageResource(iArr[1]);
                } else {
                    imageView.setImageResource(iArr[0]);
                }
                this.nxs.add(imageView);
                this.nxu.addView(imageView);
            }
            if (this.mDatas.size() > 1) {
                this.nxu.setVisibility(0);
                this.nxD.xd(true);
            } else {
                this.nxu.setVisibility(8);
                this.nxD.xd(false);
            }
            this.nxA = new com.kascend.chushou.widget.convenientbanner.d.a(this.nxs, iArr);
            this.nxz.a(this.nxA);
            if (this.nxB != null) {
                this.nxA.a(this.nxB);
            }
        }
        return this;
    }

    public c getOnPageChangeListener() {
        return this.nxB;
    }

    public int getCurrentItem() {
        return this.nxz.dLh();
    }

    public int getFaceCurrentItem() {
        return this.nxz.getCurrentItem();
    }

    public ConvenientBanner h(int i, int i2, int i3, int i4, int i5) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.nxu.getLayoutParams();
        layoutParams.gravity = i;
        layoutParams.topMargin = i3;
        layoutParams.leftMargin = i2;
        layoutParams.rightMargin = i4;
        layoutParams.bottomMargin = i5;
        this.nxu.setLayoutParams(layoutParams);
        return this;
    }

    public ConvenientBanner gd(long j) {
        if (j >= 0) {
            if (this.nxw) {
                dLf();
            }
            this.nxx = true;
            this.nxv = j;
            this.nxw = true;
            postDelayed(this.nxC, j);
        }
        return this;
    }

    public ConvenientBanner dLe() {
        gd(this.nxv);
        return this;
    }

    public void dLf() {
        this.nxw = false;
        removeCallbacks(this.nxC);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 1 || action == 3 || action == 4) {
            if (this.nxx) {
                gd(this.nxv);
            }
        } else if (action == 0 && this.nxx) {
            dLf();
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        this.visible = i == 0;
        if (this.bVr && this.visible && this.nxx) {
            dLe();
        } else {
            dLf();
        }
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        this.bVr = z;
        if (this.bVr && this.visible && this.nxx) {
            dLe();
        } else {
            dLf();
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
            if (convenientBanner != null && convenientBanner.nxt != null && convenientBanner.nxw) {
                convenientBanner.nxz.setCurrentItem(convenientBanner.nxz.getCurrentItem() + 1, true);
                convenientBanner.postDelayed(convenientBanner.nxC, convenientBanner.nxv);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static class b extends LinearLayoutManager {
        private boolean nxE;

        b(Context context, int i, boolean z) {
            super(context, i, z);
            this.nxE = true;
        }

        @Override // android.support.v7.widget.LinearLayoutManager, android.support.v7.widget.RecyclerView.LayoutManager
        public boolean canScrollHorizontally() {
            return this.nxE && super.canScrollHorizontally();
        }

        void xd(boolean z) {
            this.nxE = z;
        }
    }
}
