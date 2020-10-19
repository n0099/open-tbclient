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
    private boolean cqo;
    private List<T> mDatas;
    private boolean ozA;
    private boolean ozB;
    private boolean ozC;
    private com.kascend.chushou.widget.convenientbanner.b.a ozD;
    private com.kascend.chushou.widget.convenientbanner.d.a ozE;
    private c ozF;
    private a ozG;
    private b ozH;
    private int[] ozv;
    private ArrayList<ImageView> ozw;
    private CBLoopViewPager ozx;
    private ViewGroup ozy;
    private long ozz;
    private boolean visible;

    public ConvenientBanner(Context context) {
        super(context);
        this.ozw = new ArrayList<>();
        this.ozz = -1L;
        this.ozB = false;
        this.ozC = true;
        this.visible = false;
        this.cqo = true;
        init(context);
    }

    public ConvenientBanner(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ozw = new ArrayList<>();
        this.ozz = -1L;
        this.ozB = false;
        this.ozC = true;
        this.visible = false;
        this.cqo = true;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.c.ConvenientBanner);
        this.ozC = obtainStyledAttributes.getBoolean(a.c.ConvenientBanner_banner_canLoop, true);
        this.ozz = obtainStyledAttributes.getInteger(a.c.ConvenientBanner_banner_autoTurningTime, -1);
        obtainStyledAttributes.recycle();
        init(context);
    }

    private void init(Context context) {
        View inflate = LayoutInflater.from(context).inflate(a.b.banner_layout, (ViewGroup) this, true);
        this.ozx = (CBLoopViewPager) inflate.findViewById(a.C0928a.banner_loop_viewpager);
        this.ozy = (ViewGroup) inflate.findViewById(a.C0928a.banner_indicator);
        this.ozH = new b(context, 0, false);
        this.ozH.setItemPrefetchEnabled(true);
        this.ozH.setInitialPrefetchItemCount(1);
        this.ozx.setLayoutManager(this.ozH);
        this.ozx.setFocusableInTouchMode(false);
        this.ozx.requestFocus();
        this.ozD = new com.kascend.chushou.widget.convenientbanner.b.a();
        this.ozG = new a(this);
    }

    public ConvenientBanner a(com.kascend.chushou.widget.convenientbanner.c.a<T> aVar, List<T> list) {
        this.mDatas = list;
        this.ozx.setAdapter(new com.kascend.chushou.widget.convenientbanner.a.a(aVar, this.mDatas, this.ozC, this));
        if (this.ozv != null) {
            r(this.ozv);
        }
        this.ozD.OF(this.ozC ? this.mDatas.size() : 0);
        this.ozD.a(this.ozx);
        return this;
    }

    public void notifyDataSetChanged() {
        this.ozx.getAdapter().notifyDataSetChanged();
        if (this.mDatas != null && this.mDatas.size() > 0) {
            this.ozD.setCurrentItem(0);
        }
        if (this.ozv != null) {
            r(this.ozv);
        }
    }

    public ConvenientBanner r(int[] iArr) {
        this.ozy.removeAllViews();
        this.ozw.clear();
        this.ozv = iArr;
        if (this.mDatas != null) {
            for (int i = 0; i < this.mDatas.size(); i++) {
                ImageView imageView = new ImageView(getContext());
                imageView.setPadding(5, 0, 5, 0);
                if (this.ozD.eiC() % this.mDatas.size() == i) {
                    imageView.setImageResource(iArr[1]);
                } else {
                    imageView.setImageResource(iArr[0]);
                }
                this.ozw.add(imageView);
                this.ozy.addView(imageView);
            }
            if (this.mDatas.size() > 1) {
                this.ozy.setVisibility(0);
                this.ozH.zr(true);
            } else {
                this.ozy.setVisibility(8);
                this.ozH.zr(false);
            }
            this.ozE = new com.kascend.chushou.widget.convenientbanner.d.a(this.ozw, iArr);
            this.ozD.a(this.ozE);
            if (this.ozF != null) {
                this.ozE.a(this.ozF);
            }
        }
        return this;
    }

    public c getOnPageChangeListener() {
        return this.ozF;
    }

    public int getCurrentItem() {
        return this.ozD.eiB();
    }

    public int getFaceCurrentItem() {
        return this.ozD.getCurrentItem();
    }

    public ConvenientBanner h(int i, int i2, int i3, int i4, int i5) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.ozy.getLayoutParams();
        layoutParams.gravity = i;
        layoutParams.topMargin = i3;
        layoutParams.leftMargin = i2;
        layoutParams.rightMargin = i4;
        layoutParams.bottomMargin = i5;
        this.ozy.setLayoutParams(layoutParams);
        return this;
    }

    public ConvenientBanner hl(long j) {
        if (j >= 0) {
            if (this.ozA) {
                eiz();
            }
            this.ozB = true;
            this.ozz = j;
            this.ozA = true;
            postDelayed(this.ozG, j);
        }
        return this;
    }

    public ConvenientBanner eiy() {
        hl(this.ozz);
        return this;
    }

    public void eiz() {
        this.ozA = false;
        removeCallbacks(this.ozG);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 1 || action == 3 || action == 4) {
            if (this.ozB) {
                hl(this.ozz);
            }
        } else if (action == 0 && this.ozB) {
            eiz();
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        this.visible = i == 0;
        if (this.cqo && this.visible && this.ozB) {
            eiy();
        } else {
            eiz();
        }
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        this.cqo = z;
        if (this.cqo && this.visible && this.ozB) {
            eiy();
        } else {
            eiz();
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
            if (convenientBanner != null && convenientBanner.ozx != null && convenientBanner.ozA) {
                convenientBanner.ozD.setCurrentItem(convenientBanner.ozD.getCurrentItem() + 1, true);
                convenientBanner.postDelayed(convenientBanner.ozG, convenientBanner.ozz);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public static class b extends LinearLayoutManager {
        private boolean ozI;

        b(Context context, int i, boolean z) {
            super(context, i, z);
            this.ozI = true;
        }

        @Override // android.support.v7.widget.LinearLayoutManager, android.support.v7.widget.RecyclerView.LayoutManager
        public boolean canScrollHorizontally() {
            return this.ozI && super.canScrollHorizontally();
        }

        void zr(boolean z) {
            this.ozI = z;
        }
    }
}
