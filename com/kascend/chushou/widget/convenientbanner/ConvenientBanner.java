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
    private boolean cbR;
    private List<T> mDatas;
    private int[] nZW;
    private ArrayList<ImageView> nZX;
    private CBLoopViewPager nZY;
    private ViewGroup nZZ;
    private long oaa;
    private boolean oab;
    private boolean oac;
    private boolean oad;
    private com.kascend.chushou.widget.convenientbanner.b.a oae;
    private com.kascend.chushou.widget.convenientbanner.d.a oaf;
    private c oag;
    private a oah;
    private b oai;
    private boolean visible;

    public ConvenientBanner(Context context) {
        super(context);
        this.nZX = new ArrayList<>();
        this.oaa = -1L;
        this.oac = false;
        this.oad = true;
        this.visible = false;
        this.cbR = true;
        init(context);
    }

    public ConvenientBanner(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.nZX = new ArrayList<>();
        this.oaa = -1L;
        this.oac = false;
        this.oad = true;
        this.visible = false;
        this.cbR = true;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.c.ConvenientBanner);
        this.oad = obtainStyledAttributes.getBoolean(a.c.ConvenientBanner_banner_canLoop, true);
        this.oaa = obtainStyledAttributes.getInteger(a.c.ConvenientBanner_banner_autoTurningTime, -1);
        obtainStyledAttributes.recycle();
        init(context);
    }

    private void init(Context context) {
        View inflate = LayoutInflater.from(context).inflate(a.b.banner_layout, (ViewGroup) this, true);
        this.nZY = (CBLoopViewPager) inflate.findViewById(a.C0913a.banner_loop_viewpager);
        this.nZZ = (ViewGroup) inflate.findViewById(a.C0913a.banner_indicator);
        this.oai = new b(context, 0, false);
        this.oai.setItemPrefetchEnabled(true);
        this.oai.setInitialPrefetchItemCount(1);
        this.nZY.setLayoutManager(this.oai);
        this.nZY.setFocusableInTouchMode(false);
        this.nZY.requestFocus();
        this.oae = new com.kascend.chushou.widget.convenientbanner.b.a();
        this.oah = new a(this);
    }

    public ConvenientBanner a(com.kascend.chushou.widget.convenientbanner.c.a<T> aVar, List<T> list) {
        this.mDatas = list;
        this.nZY.setAdapter(new com.kascend.chushou.widget.convenientbanner.a.a(aVar, this.mDatas, this.oad, this));
        if (this.nZW != null) {
            s(this.nZW);
        }
        this.oae.Nu(this.oad ? this.mDatas.size() : 0);
        this.oae.a(this.nZY);
        return this;
    }

    public void notifyDataSetChanged() {
        this.nZY.getAdapter().notifyDataSetChanged();
        if (this.mDatas != null && this.mDatas.size() > 0) {
            this.oae.setCurrentItem(0);
        }
        if (this.nZW != null) {
            s(this.nZW);
        }
    }

    public ConvenientBanner s(int[] iArr) {
        this.nZZ.removeAllViews();
        this.nZX.clear();
        this.nZW = iArr;
        if (this.mDatas != null) {
            for (int i = 0; i < this.mDatas.size(); i++) {
                ImageView imageView = new ImageView(getContext());
                imageView.setPadding(5, 0, 5, 0);
                if (this.oae.eaK() % this.mDatas.size() == i) {
                    imageView.setImageResource(iArr[1]);
                } else {
                    imageView.setImageResource(iArr[0]);
                }
                this.nZX.add(imageView);
                this.nZZ.addView(imageView);
            }
            if (this.mDatas.size() > 1) {
                this.nZZ.setVisibility(0);
                this.oai.yA(true);
            } else {
                this.nZZ.setVisibility(8);
                this.oai.yA(false);
            }
            this.oaf = new com.kascend.chushou.widget.convenientbanner.d.a(this.nZX, iArr);
            this.oae.a(this.oaf);
            if (this.oag != null) {
                this.oaf.a(this.oag);
            }
        }
        return this;
    }

    public c getOnPageChangeListener() {
        return this.oag;
    }

    public int getCurrentItem() {
        return this.oae.eaJ();
    }

    public int getFaceCurrentItem() {
        return this.oae.getCurrentItem();
    }

    public ConvenientBanner h(int i, int i2, int i3, int i4, int i5) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.nZZ.getLayoutParams();
        layoutParams.gravity = i;
        layoutParams.topMargin = i3;
        layoutParams.leftMargin = i2;
        layoutParams.rightMargin = i4;
        layoutParams.bottomMargin = i5;
        this.nZZ.setLayoutParams(layoutParams);
        return this;
    }

    public ConvenientBanner gD(long j) {
        if (j >= 0) {
            if (this.oab) {
                eaH();
            }
            this.oac = true;
            this.oaa = j;
            this.oab = true;
            postDelayed(this.oah, j);
        }
        return this;
    }

    public ConvenientBanner eaG() {
        gD(this.oaa);
        return this;
    }

    public void eaH() {
        this.oab = false;
        removeCallbacks(this.oah);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 1 || action == 3 || action == 4) {
            if (this.oac) {
                gD(this.oaa);
            }
        } else if (action == 0 && this.oac) {
            eaH();
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        this.visible = i == 0;
        if (this.cbR && this.visible && this.oac) {
            eaG();
        } else {
            eaH();
        }
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        this.cbR = z;
        if (this.cbR && this.visible && this.oac) {
            eaG();
        } else {
            eaH();
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
            if (convenientBanner != null && convenientBanner.nZY != null && convenientBanner.oab) {
                convenientBanner.oae.setCurrentItem(convenientBanner.oae.getCurrentItem() + 1, true);
                convenientBanner.postDelayed(convenientBanner.oah, convenientBanner.oaa);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public static class b extends LinearLayoutManager {
        private boolean oaj;

        b(Context context, int i, boolean z) {
            super(context, i, z);
            this.oaj = true;
        }

        @Override // android.support.v7.widget.LinearLayoutManager, android.support.v7.widget.RecyclerView.LayoutManager
        public boolean canScrollHorizontally() {
            return this.oaj && super.canScrollHorizontally();
        }

        void yA(boolean z) {
            this.oaj = z;
        }
    }
}
