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
    private boolean cCY;
    private List<T> mDatas;
    private int[] pBO;
    private ArrayList<ImageView> pBP;
    private CBLoopViewPager pBQ;
    private ViewGroup pBR;
    private long pBS;
    private boolean pBT;
    private boolean pBU;
    private boolean pBV;
    private com.kascend.chushou.widget.convenientbanner.b.a pBW;
    private com.kascend.chushou.widget.convenientbanner.d.a pBX;
    private c pBY;
    private a pBZ;
    private b pCa;
    private boolean visible;

    public ConvenientBanner(Context context) {
        super(context);
        this.pBP = new ArrayList<>();
        this.pBS = -1L;
        this.pBU = false;
        this.pBV = true;
        this.visible = false;
        this.cCY = true;
        init(context);
    }

    public ConvenientBanner(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.pBP = new ArrayList<>();
        this.pBS = -1L;
        this.pBU = false;
        this.pBV = true;
        this.visible = false;
        this.cCY = true;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.c.ConvenientBanner);
        this.pBV = obtainStyledAttributes.getBoolean(a.c.ConvenientBanner_banner_canLoop, true);
        this.pBS = obtainStyledAttributes.getInteger(a.c.ConvenientBanner_banner_autoTurningTime, -1);
        obtainStyledAttributes.recycle();
        init(context);
    }

    private void init(Context context) {
        View inflate = LayoutInflater.from(context).inflate(a.b.banner_layout, (ViewGroup) this, true);
        this.pBQ = (CBLoopViewPager) inflate.findViewById(a.C1022a.banner_loop_viewpager);
        this.pBR = (ViewGroup) inflate.findViewById(a.C1022a.banner_indicator);
        this.pCa = new b(context, 0, false);
        this.pCa.setItemPrefetchEnabled(true);
        this.pCa.setInitialPrefetchItemCount(1);
        this.pBQ.setLayoutManager(this.pCa);
        this.pBQ.setFocusableInTouchMode(false);
        this.pBQ.requestFocus();
        this.pBW = new com.kascend.chushou.widget.convenientbanner.b.a();
        this.pBZ = new a(this);
    }

    public ConvenientBanner a(com.kascend.chushou.widget.convenientbanner.c.a<T> aVar, List<T> list) {
        this.mDatas = list;
        this.pBQ.setAdapter(new com.kascend.chushou.widget.convenientbanner.a.a(aVar, this.mDatas, this.pBV, this));
        if (this.pBO != null) {
            w(this.pBO);
        }
        this.pBW.Ru(this.pBV ? this.mDatas.size() : 0);
        this.pBW.a(this.pBQ);
        return this;
    }

    public void notifyDataSetChanged() {
        this.pBQ.getAdapter().notifyDataSetChanged();
        if (this.mDatas != null && this.mDatas.size() > 0) {
            this.pBW.setCurrentItem(0);
        }
        if (this.pBO != null) {
            w(this.pBO);
        }
    }

    public ConvenientBanner w(int[] iArr) {
        this.pBR.removeAllViews();
        this.pBP.clear();
        this.pBO = iArr;
        if (this.mDatas != null) {
            for (int i = 0; i < this.mDatas.size(); i++) {
                ImageView imageView = new ImageView(getContext());
                imageView.setPadding(5, 0, 5, 0);
                if (this.pBW.ews() % this.mDatas.size() == i) {
                    imageView.setImageResource(iArr[1]);
                } else {
                    imageView.setImageResource(iArr[0]);
                }
                this.pBP.add(imageView);
                this.pBR.addView(imageView);
            }
            if (this.mDatas.size() > 1) {
                this.pBR.setVisibility(0);
                this.pCa.AR(true);
            } else {
                this.pBR.setVisibility(8);
                this.pCa.AR(false);
            }
            this.pBX = new com.kascend.chushou.widget.convenientbanner.d.a(this.pBP, iArr);
            this.pBW.a(this.pBX);
            if (this.pBY != null) {
                this.pBX.a(this.pBY);
            }
        }
        return this;
    }

    public c getOnPageChangeListener() {
        return this.pBY;
    }

    public int getCurrentItem() {
        return this.pBW.ewr();
    }

    public int getFaceCurrentItem() {
        return this.pBW.getCurrentItem();
    }

    public ConvenientBanner h(int i, int i2, int i3, int i4, int i5) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.pBR.getLayoutParams();
        layoutParams.gravity = i;
        layoutParams.topMargin = i3;
        layoutParams.leftMargin = i2;
        layoutParams.rightMargin = i4;
        layoutParams.bottomMargin = i5;
        this.pBR.setLayoutParams(layoutParams);
        return this;
    }

    public ConvenientBanner ia(long j) {
        if (j >= 0) {
            if (this.pBT) {
                ewo();
            }
            this.pBU = true;
            this.pBS = j;
            this.pBT = true;
            postDelayed(this.pBZ, j);
        }
        return this;
    }

    public ConvenientBanner ewn() {
        ia(this.pBS);
        return this;
    }

    public void ewo() {
        this.pBT = false;
        removeCallbacks(this.pBZ);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 1 || action == 3 || action == 4) {
            if (this.pBU) {
                ia(this.pBS);
            }
        } else if (action == 0 && this.pBU) {
            ewo();
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        this.visible = i == 0;
        if (this.cCY && this.visible && this.pBU) {
            ewn();
        } else {
            ewo();
        }
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        this.cCY = z;
        if (this.cCY && this.visible && this.pBU) {
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
            if (convenientBanner != null && convenientBanner.pBQ != null && convenientBanner.pBT) {
                convenientBanner.pBW.setCurrentItem(convenientBanner.pBW.getCurrentItem() + 1, true);
                convenientBanner.postDelayed(convenientBanner.pBZ, convenientBanner.pBS);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public static class b extends LinearLayoutManager {
        private boolean pCb;

        b(Context context, int i, boolean z) {
            super(context, i, z);
            this.pCb = true;
        }

        @Override // android.support.v7.widget.LinearLayoutManager, android.support.v7.widget.RecyclerView.LayoutManager
        public boolean canScrollHorizontally() {
            return this.pCb && super.canScrollHorizontally();
        }

        void AR(boolean z) {
            this.pCb = z;
        }
    }
}
