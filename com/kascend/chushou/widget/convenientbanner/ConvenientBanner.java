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
    private boolean bjy;
    private List<T> mDatas;
    private int[] njE;
    private ArrayList<ImageView> njF;
    private CBLoopViewPager njG;
    private ViewGroup njH;
    private long njI;
    private boolean njJ;
    private boolean njK;
    private boolean njL;
    private com.kascend.chushou.widget.convenientbanner.b.a njM;
    private com.kascend.chushou.widget.convenientbanner.d.a njN;
    private c njO;
    private a njP;
    private b njQ;
    private boolean visible;

    public ConvenientBanner(Context context) {
        super(context);
        this.njF = new ArrayList<>();
        this.njI = -1L;
        this.njK = false;
        this.njL = true;
        this.visible = false;
        this.bjy = true;
        init(context);
    }

    public ConvenientBanner(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.njF = new ArrayList<>();
        this.njI = -1L;
        this.njK = false;
        this.njL = true;
        this.visible = false;
        this.bjy = true;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.c.ConvenientBanner);
        this.njL = obtainStyledAttributes.getBoolean(a.c.ConvenientBanner_banner_canLoop, true);
        this.njI = obtainStyledAttributes.getInteger(a.c.ConvenientBanner_banner_autoTurningTime, -1);
        obtainStyledAttributes.recycle();
        init(context);
    }

    private void init(Context context) {
        View inflate = LayoutInflater.from(context).inflate(a.b.banner_layout, (ViewGroup) this, true);
        this.njG = (CBLoopViewPager) inflate.findViewById(a.C0722a.banner_loop_viewpager);
        this.njH = (ViewGroup) inflate.findViewById(a.C0722a.banner_indicator);
        this.njQ = new b(context, 0, false);
        this.njQ.setItemPrefetchEnabled(true);
        this.njQ.setInitialPrefetchItemCount(1);
        this.njG.setLayoutManager(this.njQ);
        this.njG.setFocusableInTouchMode(false);
        this.njG.requestFocus();
        this.njM = new com.kascend.chushou.widget.convenientbanner.b.a();
        this.njP = new a(this);
    }

    public ConvenientBanner a(com.kascend.chushou.widget.convenientbanner.c.a<T> aVar, List<T> list) {
        this.mDatas = list;
        this.njG.setAdapter(new com.kascend.chushou.widget.convenientbanner.a.a(aVar, this.mDatas, this.njL, this));
        if (this.njE != null) {
            p(this.njE);
        }
        this.njM.Ni(this.njL ? this.mDatas.size() : 0);
        this.njM.a(this.njG);
        return this;
    }

    public void notifyDataSetChanged() {
        this.njG.getAdapter().notifyDataSetChanged();
        if (this.mDatas != null && this.mDatas.size() > 0) {
            this.njM.setCurrentItem(0);
        }
        if (this.njE != null) {
            p(this.njE);
        }
    }

    public ConvenientBanner p(int[] iArr) {
        this.njH.removeAllViews();
        this.njF.clear();
        this.njE = iArr;
        if (this.mDatas != null) {
            for (int i = 0; i < this.mDatas.size(); i++) {
                ImageView imageView = new ImageView(getContext());
                imageView.setPadding(5, 0, 5, 0);
                if (this.njM.dEX() % this.mDatas.size() == i) {
                    imageView.setImageResource(iArr[1]);
                } else {
                    imageView.setImageResource(iArr[0]);
                }
                this.njF.add(imageView);
                this.njH.addView(imageView);
            }
            if (this.mDatas.size() > 1) {
                this.njH.setVisibility(0);
                this.njQ.wA(true);
            } else {
                this.njH.setVisibility(8);
                this.njQ.wA(false);
            }
            this.njN = new com.kascend.chushou.widget.convenientbanner.d.a(this.njF, iArr);
            this.njM.a(this.njN);
            if (this.njO != null) {
                this.njN.a(this.njO);
            }
        }
        return this;
    }

    public c getOnPageChangeListener() {
        return this.njO;
    }

    public int getCurrentItem() {
        return this.njM.dEW();
    }

    public int getFaceCurrentItem() {
        return this.njM.getCurrentItem();
    }

    public ConvenientBanner j(int i, int i2, int i3, int i4, int i5) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.njH.getLayoutParams();
        layoutParams.gravity = i;
        layoutParams.topMargin = i3;
        layoutParams.leftMargin = i2;
        layoutParams.rightMargin = i4;
        layoutParams.bottomMargin = i5;
        this.njH.setLayoutParams(layoutParams);
        return this;
    }

    public ConvenientBanner gW(long j) {
        if (j >= 0) {
            if (this.njJ) {
                dEU();
            }
            this.njK = true;
            this.njI = j;
            this.njJ = true;
            postDelayed(this.njP, j);
        }
        return this;
    }

    public ConvenientBanner dET() {
        gW(this.njI);
        return this;
    }

    public void dEU() {
        this.njJ = false;
        removeCallbacks(this.njP);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 1 || action == 3 || action == 4) {
            if (this.njK) {
                gW(this.njI);
            }
        } else if (action == 0 && this.njK) {
            dEU();
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        this.visible = i == 0;
        if (this.bjy && this.visible && this.njK) {
            dET();
        } else {
            dEU();
        }
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        this.bjy = z;
        if (this.bjy && this.visible && this.njK) {
            dET();
        } else {
            dEU();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static class a implements Runnable {
        private final WeakReference<ConvenientBanner> gAc;

        a(ConvenientBanner convenientBanner) {
            this.gAc = new WeakReference<>(convenientBanner);
        }

        @Override // java.lang.Runnable
        public void run() {
            ConvenientBanner convenientBanner = this.gAc.get();
            if (convenientBanner != null && convenientBanner.njG != null && convenientBanner.njJ) {
                convenientBanner.njM.setCurrentItem(convenientBanner.njM.getCurrentItem() + 1, true);
                convenientBanner.postDelayed(convenientBanner.njP, convenientBanner.njI);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static class b extends LinearLayoutManager {
        private boolean njR;

        b(Context context, int i, boolean z) {
            super(context, i, z);
            this.njR = true;
        }

        @Override // android.support.v7.widget.LinearLayoutManager, android.support.v7.widget.RecyclerView.LayoutManager
        public boolean canScrollHorizontally() {
            return this.njR && super.canScrollHorizontally();
        }

        void wA(boolean z) {
            this.njR = z;
        }
    }
}
