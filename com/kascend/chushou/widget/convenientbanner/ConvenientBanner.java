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
    private boolean cyP;
    private List<T> mDatas;
    private int[] pqQ;
    private ArrayList<ImageView> pqR;
    private CBLoopViewPager pqS;
    private ViewGroup pqT;
    private long pqU;
    private boolean pqV;
    private boolean pqW;
    private boolean pqX;
    private com.kascend.chushou.widget.convenientbanner.b.a pqY;
    private com.kascend.chushou.widget.convenientbanner.d.a pqZ;
    private c pra;
    private a prb;
    private b prc;
    private boolean visible;

    public ConvenientBanner(Context context) {
        super(context);
        this.pqR = new ArrayList<>();
        this.pqU = -1L;
        this.pqW = false;
        this.pqX = true;
        this.visible = false;
        this.cyP = true;
        init(context);
    }

    public ConvenientBanner(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.pqR = new ArrayList<>();
        this.pqU = -1L;
        this.pqW = false;
        this.pqX = true;
        this.visible = false;
        this.cyP = true;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.c.ConvenientBanner);
        this.pqX = obtainStyledAttributes.getBoolean(a.c.ConvenientBanner_banner_canLoop, true);
        this.pqU = obtainStyledAttributes.getInteger(a.c.ConvenientBanner_banner_autoTurningTime, -1);
        obtainStyledAttributes.recycle();
        init(context);
    }

    private void init(Context context) {
        View inflate = LayoutInflater.from(context).inflate(a.b.banner_layout, (ViewGroup) this, true);
        this.pqS = (CBLoopViewPager) inflate.findViewById(a.C1000a.banner_loop_viewpager);
        this.pqT = (ViewGroup) inflate.findViewById(a.C1000a.banner_indicator);
        this.prc = new b(context, 0, false);
        this.prc.setItemPrefetchEnabled(true);
        this.prc.setInitialPrefetchItemCount(1);
        this.pqS.setLayoutManager(this.prc);
        this.pqS.setFocusableInTouchMode(false);
        this.pqS.requestFocus();
        this.pqY = new com.kascend.chushou.widget.convenientbanner.b.a();
        this.prb = new a(this);
    }

    public ConvenientBanner a(com.kascend.chushou.widget.convenientbanner.c.a<T> aVar, List<T> list) {
        this.mDatas = list;
        this.pqS.setAdapter(new com.kascend.chushou.widget.convenientbanner.a.a(aVar, this.mDatas, this.pqX, this));
        if (this.pqQ != null) {
            r(this.pqQ);
        }
        this.pqY.Qw(this.pqX ? this.mDatas.size() : 0);
        this.pqY.a(this.pqS);
        return this;
    }

    public void notifyDataSetChanged() {
        this.pqS.getAdapter().notifyDataSetChanged();
        if (this.mDatas != null && this.mDatas.size() > 0) {
            this.pqY.setCurrentItem(0);
        }
        if (this.pqQ != null) {
            r(this.pqQ);
        }
    }

    public ConvenientBanner r(int[] iArr) {
        this.pqT.removeAllViews();
        this.pqR.clear();
        this.pqQ = iArr;
        if (this.mDatas != null) {
            for (int i = 0; i < this.mDatas.size(); i++) {
                ImageView imageView = new ImageView(getContext());
                imageView.setPadding(5, 0, 5, 0);
                if (this.pqY.esC() % this.mDatas.size() == i) {
                    imageView.setImageResource(iArr[1]);
                } else {
                    imageView.setImageResource(iArr[0]);
                }
                this.pqR.add(imageView);
                this.pqT.addView(imageView);
            }
            if (this.mDatas.size() > 1) {
                this.pqT.setVisibility(0);
                this.prc.Az(true);
            } else {
                this.pqT.setVisibility(8);
                this.prc.Az(false);
            }
            this.pqZ = new com.kascend.chushou.widget.convenientbanner.d.a(this.pqR, iArr);
            this.pqY.a(this.pqZ);
            if (this.pra != null) {
                this.pqZ.a(this.pra);
            }
        }
        return this;
    }

    public c getOnPageChangeListener() {
        return this.pra;
    }

    public int getCurrentItem() {
        return this.pqY.esB();
    }

    public int getFaceCurrentItem() {
        return this.pqY.getCurrentItem();
    }

    public ConvenientBanner h(int i, int i2, int i3, int i4, int i5) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.pqT.getLayoutParams();
        layoutParams.gravity = i;
        layoutParams.topMargin = i3;
        layoutParams.leftMargin = i2;
        layoutParams.rightMargin = i4;
        layoutParams.bottomMargin = i5;
        this.pqT.setLayoutParams(layoutParams);
        return this;
    }

    public ConvenientBanner hB(long j) {
        if (j >= 0) {
            if (this.pqV) {
                esz();
            }
            this.pqW = true;
            this.pqU = j;
            this.pqV = true;
            postDelayed(this.prb, j);
        }
        return this;
    }

    public ConvenientBanner esy() {
        hB(this.pqU);
        return this;
    }

    public void esz() {
        this.pqV = false;
        removeCallbacks(this.prb);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 1 || action == 3 || action == 4) {
            if (this.pqW) {
                hB(this.pqU);
            }
        } else if (action == 0 && this.pqW) {
            esz();
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        this.visible = i == 0;
        if (this.cyP && this.visible && this.pqW) {
            esy();
        } else {
            esz();
        }
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        this.cyP = z;
        if (this.cyP && this.visible && this.pqW) {
            esy();
        } else {
            esz();
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
            if (convenientBanner != null && convenientBanner.pqS != null && convenientBanner.pqV) {
                convenientBanner.pqY.setCurrentItem(convenientBanner.pqY.getCurrentItem() + 1, true);
                convenientBanner.postDelayed(convenientBanner.prb, convenientBanner.pqU);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public static class b extends LinearLayoutManager {
        private boolean prd;

        b(Context context, int i, boolean z) {
            super(context, i, z);
            this.prd = true;
        }

        @Override // android.support.v7.widget.LinearLayoutManager, android.support.v7.widget.RecyclerView.LayoutManager
        public boolean canScrollHorizontally() {
            return this.prd && super.canScrollHorizontally();
        }

        void Az(boolean z) {
            this.prd = z;
        }
    }
}
