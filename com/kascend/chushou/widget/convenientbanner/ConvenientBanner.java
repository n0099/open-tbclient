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
    private int[] nbA;
    private ArrayList<ImageView> nbB;
    private CBLoopViewPager nbC;
    private ViewGroup nbD;
    private long nbE;
    private boolean nbF;
    private boolean nbG;
    private boolean nbH;
    private com.kascend.chushou.widget.convenientbanner.b.a nbI;
    private com.kascend.chushou.widget.convenientbanner.d.a nbJ;
    private c nbK;
    private a nbL;
    private b nbM;
    private boolean visible;

    public ConvenientBanner(Context context) {
        super(context);
        this.nbB = new ArrayList<>();
        this.nbE = -1L;
        this.nbG = false;
        this.nbH = true;
        this.visible = false;
        this.bQD = true;
        init(context);
    }

    public ConvenientBanner(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.nbB = new ArrayList<>();
        this.nbE = -1L;
        this.nbG = false;
        this.nbH = true;
        this.visible = false;
        this.bQD = true;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.c.ConvenientBanner);
        this.nbH = obtainStyledAttributes.getBoolean(a.c.ConvenientBanner_banner_canLoop, true);
        this.nbE = obtainStyledAttributes.getInteger(a.c.ConvenientBanner_banner_autoTurningTime, -1);
        obtainStyledAttributes.recycle();
        init(context);
    }

    private void init(Context context) {
        View inflate = LayoutInflater.from(context).inflate(a.b.banner_layout, (ViewGroup) this, true);
        this.nbC = (CBLoopViewPager) inflate.findViewById(a.C0826a.banner_loop_viewpager);
        this.nbD = (ViewGroup) inflate.findViewById(a.C0826a.banner_indicator);
        this.nbM = new b(context, 0, false);
        this.nbM.setItemPrefetchEnabled(true);
        this.nbM.setInitialPrefetchItemCount(1);
        this.nbC.setLayoutManager(this.nbM);
        this.nbC.setFocusableInTouchMode(false);
        this.nbC.requestFocus();
        this.nbI = new com.kascend.chushou.widget.convenientbanner.b.a();
        this.nbL = new a(this);
    }

    public ConvenientBanner a(com.kascend.chushou.widget.convenientbanner.c.a<T> aVar, List<T> list) {
        this.mDatas = list;
        this.nbC.setAdapter(new com.kascend.chushou.widget.convenientbanner.a.a(aVar, this.mDatas, this.nbH, this));
        if (this.nbA != null) {
            r(this.nbA);
        }
        this.nbI.Jp(this.nbH ? this.mDatas.size() : 0);
        this.nbI.a(this.nbC);
        return this;
    }

    public void notifyDataSetChanged() {
        this.nbC.getAdapter().notifyDataSetChanged();
        if (this.mDatas != null && this.mDatas.size() > 0) {
            this.nbI.setCurrentItem(0);
        }
        if (this.nbA != null) {
            r(this.nbA);
        }
    }

    public ConvenientBanner r(int[] iArr) {
        this.nbD.removeAllViews();
        this.nbB.clear();
        this.nbA = iArr;
        if (this.mDatas != null) {
            for (int i = 0; i < this.mDatas.size(); i++) {
                ImageView imageView = new ImageView(getContext());
                imageView.setPadding(5, 0, 5, 0);
                if (this.nbI.dGC() % this.mDatas.size() == i) {
                    imageView.setImageResource(iArr[1]);
                } else {
                    imageView.setImageResource(iArr[0]);
                }
                this.nbB.add(imageView);
                this.nbD.addView(imageView);
            }
            if (this.mDatas.size() > 1) {
                this.nbD.setVisibility(0);
                this.nbM.wI(true);
            } else {
                this.nbD.setVisibility(8);
                this.nbM.wI(false);
            }
            this.nbJ = new com.kascend.chushou.widget.convenientbanner.d.a(this.nbB, iArr);
            this.nbI.a(this.nbJ);
            if (this.nbK != null) {
                this.nbJ.a(this.nbK);
            }
        }
        return this;
    }

    public c getOnPageChangeListener() {
        return this.nbK;
    }

    public int getCurrentItem() {
        return this.nbI.dGB();
    }

    public int getFaceCurrentItem() {
        return this.nbI.getCurrentItem();
    }

    public ConvenientBanner h(int i, int i2, int i3, int i4, int i5) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.nbD.getLayoutParams();
        layoutParams.gravity = i;
        layoutParams.topMargin = i3;
        layoutParams.leftMargin = i2;
        layoutParams.rightMargin = i4;
        layoutParams.bottomMargin = i5;
        this.nbD.setLayoutParams(layoutParams);
        return this;
    }

    public ConvenientBanner fY(long j) {
        if (j >= 0) {
            if (this.nbF) {
                dGz();
            }
            this.nbG = true;
            this.nbE = j;
            this.nbF = true;
            postDelayed(this.nbL, j);
        }
        return this;
    }

    public ConvenientBanner dGy() {
        fY(this.nbE);
        return this;
    }

    public void dGz() {
        this.nbF = false;
        removeCallbacks(this.nbL);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 1 || action == 3 || action == 4) {
            if (this.nbG) {
                fY(this.nbE);
            }
        } else if (action == 0 && this.nbG) {
            dGz();
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        this.visible = i == 0;
        if (this.bQD && this.visible && this.nbG) {
            dGy();
        } else {
            dGz();
        }
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        this.bQD = z;
        if (this.bQD && this.visible && this.nbG) {
            dGy();
        } else {
            dGz();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static class a implements Runnable {
        private final WeakReference<ConvenientBanner> hyD;

        a(ConvenientBanner convenientBanner) {
            this.hyD = new WeakReference<>(convenientBanner);
        }

        @Override // java.lang.Runnable
        public void run() {
            ConvenientBanner convenientBanner = this.hyD.get();
            if (convenientBanner != null && convenientBanner.nbC != null && convenientBanner.nbF) {
                convenientBanner.nbI.setCurrentItem(convenientBanner.nbI.getCurrentItem() + 1, true);
                convenientBanner.postDelayed(convenientBanner.nbL, convenientBanner.nbE);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static class b extends LinearLayoutManager {
        private boolean nbN;

        b(Context context, int i, boolean z) {
            super(context, i, z);
            this.nbN = true;
        }

        @Override // android.support.v7.widget.LinearLayoutManager, android.support.v7.widget.RecyclerView.LayoutManager
        public boolean canScrollHorizontally() {
            return this.nbN && super.canScrollHorizontally();
        }

        void wI(boolean z) {
            this.nbN = z;
        }
    }
}
