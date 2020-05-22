package tv.chushou.zues.widget.psts;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.ColorInt;
import android.support.annotation.DrawableRes;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import java.util.List;
import java.util.Locale;
import tv.chushou.zues.b;
import tv.chushou.zues.widget.fresco.FrescoThumbnailView;
import tv.chushou.zues.widget.fresco.b;
/* loaded from: classes5.dex */
public class PagerSlidingTabStrip extends HorizontalScrollView {
    private static final int[] ATTRS = {16842901, 16842904};
    private int Yf;
    private ViewPager dSA;
    private int dSB;
    private float dSC;
    private Paint dSD;
    private boolean dSE;
    private int dSG;
    private int dSL;
    private Typeface dSM;
    private int dSN;
    private int dSO;
    private int dSP;
    private LinearLayout.LayoutParams dSw;
    public ViewPager.OnPageChangeListener dSy;
    private LinearLayout dSz;
    private int dUD;
    private int dUE;
    private int dividerColor;
    private int dividerPadding;
    private DisplayMetrics dm;
    private int indicatorHeight;
    private Locale locale;
    private int mInterval;
    private final RectF mRectF;
    private LinearLayout.LayoutParams nQG;
    private d nQH;
    private int nQI;
    private Paint nQJ;
    private boolean nQK;
    private int nQL;
    private boolean nQM;
    private boolean nQN;
    private int nQO;
    private int nQP;
    private int nQQ;
    private int nQR;
    private int nQS;
    private int nQT;
    private int nQU;
    private int nQV;
    private int nQW;
    private int nQX;
    private int nQY;
    private int nQZ;
    private boolean nRa;
    private boolean nRb;
    private int nRc;
    private int nRd;
    private int nRe;
    private int nRf;
    private int nRg;
    private boolean nRh;
    private boolean nRi;
    private boolean nRj;
    private tv.chushou.zues.widget.psts.a nRk;
    private int nwe;
    private int tabPadding;
    private int tabTextColor;
    private int tabTextSize;

    /* loaded from: classes5.dex */
    public interface a {
        void dZ(int i, int i2);
    }

    /* loaded from: classes5.dex */
    public interface b {
        int IW(int i);

        String IX(int i);

        int IY(int i);

        tv.chushou.zues.widget.psts.b IZ(int i);

        int lI(int i);
    }

    /* loaded from: classes5.dex */
    public interface c {
        float KR(int i);

        int[] KS(int i);

        tv.chushou.zues.widget.psts.b KT(int i);
    }

    /* loaded from: classes5.dex */
    public interface e {
        tv.chushou.zues.widget.psts.b IZ(int i);

        int[] KU(int i);
    }

    /* loaded from: classes5.dex */
    public interface f {
        int KV(int i);
    }

    /* loaded from: classes5.dex */
    public interface g {
        void zq(int i);
    }

    /* loaded from: classes5.dex */
    public interface h {
        void Ch(int i);
    }

    public PagerSlidingTabStrip(Context context) {
        this(context, null);
    }

    public PagerSlidingTabStrip(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PagerSlidingTabStrip(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.nQH = new d();
        this.Yf = 0;
        this.nQI = 0;
        this.dSC = 0.0f;
        this.nQK = false;
        this.nQL = -10066330;
        this.nwe = 436207616;
        this.dividerColor = 436207616;
        this.dSE = true;
        this.nQM = false;
        this.dSG = 52;
        this.indicatorHeight = 3;
        this.dSL = 0;
        this.nQN = true;
        this.dUD = 1;
        this.dividerPadding = 12;
        this.nQO = 0;
        this.tabPadding = 24;
        this.nQP = 0;
        this.nQQ = 0;
        this.nQR = 0;
        this.dUE = 1;
        this.nQS = 0;
        this.tabTextSize = 15;
        this.nQT = this.tabTextSize;
        this.tabTextColor = -10066330;
        this.nQU = -10066330;
        this.nQV = 13;
        this.dSM = null;
        this.dSN = 0;
        this.nQW = 1;
        this.dSO = 0;
        this.nQX = 1;
        this.nQY = 0;
        this.dSP = b.d.zues_psts_tab_background;
        this.nQZ = -1;
        this.nRa = true;
        this.nRb = false;
        this.nRc = 3;
        this.nRf = 16;
        this.nRg = 0;
        this.mInterval = 0;
        this.nRh = false;
        this.nRi = false;
        this.nRj = true;
        this.mRectF = new RectF();
        setFillViewport(true);
        setWillNotDraw(false);
        this.dSz = new LinearLayout(context);
        this.dSz.setOrientation(0);
        this.dSz.setGravity(16);
        this.dm = getResources().getDisplayMetrics();
        this.nRf = (int) TypedValue.applyDimension(1, this.nRf, this.dm);
        this.dSG = (int) TypedValue.applyDimension(1, this.dSG, this.dm);
        this.indicatorHeight = (int) TypedValue.applyDimension(1, this.indicatorHeight, this.dm);
        this.dSL = (int) TypedValue.applyDimension(1, this.dSL, this.dm);
        this.dUD = (int) TypedValue.applyDimension(1, this.dUD, this.dm);
        this.dividerPadding = (int) TypedValue.applyDimension(1, this.dividerPadding, this.dm);
        this.tabPadding = (int) TypedValue.applyDimension(1, this.tabPadding, this.dm);
        this.dUE = (int) TypedValue.applyDimension(1, this.dUE, this.dm);
        this.tabTextSize = (int) TypedValue.applyDimension(2, this.tabTextSize, this.dm);
        this.nRc = (int) TypedValue.applyDimension(1, this.nRc, this.dm);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, ATTRS);
        this.tabTextSize = obtainStyledAttributes.getDimensionPixelSize(0, this.tabTextSize);
        this.nQT = this.tabTextSize;
        this.tabTextColor = obtainStyledAttributes.getColor(1, this.tabTextColor);
        obtainStyledAttributes.recycle();
        TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, b.i.PagerSlidingTabStrip);
        this.nQL = obtainStyledAttributes2.getColor(b.i.PagerSlidingTabStrip_indicatorColor, this.nQL);
        this.nQN = obtainStyledAttributes2.getBoolean(b.i.PagerSlidingTabStrip_indicatorRoundCap, false);
        this.nwe = obtainStyledAttributes2.getColor(b.i.PagerSlidingTabStrip_underlineColor, this.nwe);
        this.dividerColor = obtainStyledAttributes2.getColor(b.i.PagerSlidingTabStrip_dividerColor, this.dividerColor);
        this.nQU = obtainStyledAttributes2.getColor(b.i.PagerSlidingTabStrip_tabTextSelectColor, this.dividerColor);
        this.indicatorHeight = obtainStyledAttributes2.getDimensionPixelSize(b.i.PagerSlidingTabStrip_indicatorHeight, this.indicatorHeight);
        this.dSL = obtainStyledAttributes2.getDimensionPixelSize(b.i.PagerSlidingTabStrip_indicatorWidth, this.dSL);
        this.dUD = obtainStyledAttributes2.getDimensionPixelSize(b.i.PagerSlidingTabStrip_underlineHeight, this.dUD);
        this.dividerPadding = obtainStyledAttributes2.getDimensionPixelSize(b.i.PagerSlidingTabStrip_psts_dividerPadding, this.dividerPadding);
        this.nRf = obtainStyledAttributes2.getDimensionPixelSize(b.i.PagerSlidingTabStrip_psts_minInterval, this.nRf);
        this.nRg = obtainStyledAttributes2.getDimensionPixelSize(b.i.PagerSlidingTabStrip_center_paddingRight, 0);
        this.nQO = obtainStyledAttributes2.getDimensionPixelSize(b.i.PagerSlidingTabStrip_parentPaddingLeft, this.nQO);
        this.tabPadding = obtainStyledAttributes2.getDimensionPixelSize(b.i.PagerSlidingTabStrip_tabPaddingLeftRight, this.tabPadding);
        this.nQP = obtainStyledAttributes2.getDimensionPixelSize(b.i.PagerSlidingTabStrip_tabPaddingTopBottom, this.nQP);
        this.nQQ = obtainStyledAttributes2.getDimensionPixelSize(b.i.PagerSlidingTabStrip_textPaddingLeftRight, this.nQQ);
        this.nQR = obtainStyledAttributes2.getDimensionPixelSize(b.i.PagerSlidingTabStrip_textPaddingTopBottom, this.nQR);
        this.dSP = obtainStyledAttributes2.getResourceId(b.i.PagerSlidingTabStrip_ptabBackground, this.dSP);
        this.nQZ = obtainStyledAttributes2.getResourceId(b.i.PagerSlidingTabStrip_textBackground, this.nQZ);
        this.dSE = obtainStyledAttributes2.getBoolean(b.i.PagerSlidingTabStrip_shouldExpand, this.dSE);
        this.dSG = obtainStyledAttributes2.getDimensionPixelSize(b.i.PagerSlidingTabStrip_scrollOffset, this.dSG);
        this.nQM = obtainStyledAttributes2.getBoolean(b.i.PagerSlidingTabStrip_psts_textAllCaps, this.nQM);
        this.nRa = obtainStyledAttributes2.getBoolean(b.i.PagerSlidingTabStrip_psts_tabIsWeight, this.nRa);
        this.nQX = obtainStyledAttributes2.getInteger(b.i.PagerSlidingTabStrip_apsts_draw_mode, 0);
        this.nQY = obtainStyledAttributes2.getInteger(b.i.PagerSlidingTabStrip_apsts_layout_mode, 0);
        this.nQT = obtainStyledAttributes2.getDimensionPixelSize(b.i.PagerSlidingTabStrip_tabTextSelectSize, this.tabTextSize);
        obtainStyledAttributes2.recycle();
        this.dSD = new Paint();
        this.dSD.setAntiAlias(true);
        this.dSD.setStyle(Paint.Style.FILL);
        this.nQJ = new Paint();
        this.nQJ.setAntiAlias(true);
        this.nQJ.setStrokeWidth(this.dUE);
        if (this.nQY == 0) {
            this.dSw = new LinearLayout.LayoutParams(0, -1, 1.0f);
            this.nQG = new LinearLayout.LayoutParams(0, -1, 1.0f);
            this.nQG.setMargins(0, 0, 0, 0);
        } else {
            this.dSw = new LinearLayout.LayoutParams(-2, -1);
            this.nQG = new LinearLayout.LayoutParams(-2, -1);
            this.nQG.setMargins(0, 0, 0, 0);
        }
        if (this.locale == null) {
            this.locale = getResources().getConfiguration().locale;
        }
        this.dSz.setPadding(this.nQO, this.dSz.getPaddingTop(), this.dSz.getPaddingRight(), this.dSz.getPaddingBottom());
        this.dSz.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        addView(this.dSz);
    }

    public void setControlWidth(int i) {
        this.nRd = i;
    }

    /* loaded from: classes5.dex */
    public class NewAdapter extends FragmentStatePagerAdapter implements h {
        private List<String> mDatas;
        private g nRm;

        @Override // android.support.v4.app.FragmentStatePagerAdapter
        public Fragment getItem(int i) {
            return null;
        }

        @Override // android.support.v4.view.PagerAdapter
        public int getCount() {
            if (this.mDatas == null) {
                return 0;
            }
            return this.mDatas.size();
        }

        @Override // android.support.v4.view.PagerAdapter
        public CharSequence getPageTitle(int i) {
            return this.mDatas == null ? "" : this.mDatas.get(i);
        }

        @Override // tv.chushou.zues.widget.psts.PagerSlidingTabStrip.h
        public void Ch(int i) {
            if (this.nRm != null) {
                this.nRm.zq(i);
            }
        }
    }

    public boolean c(ViewPager viewPager) {
        return a(viewPager, false);
    }

    public boolean a(ViewPager viewPager, boolean z) {
        this.dSA = viewPager;
        if (viewPager.getAdapter() == null) {
            throw new IllegalStateException("ViewPager does not have adapter instance.");
        }
        if (!z) {
            viewPager.addOnPageChangeListener(this.nQH);
        }
        notifyDataSetChanged();
        return this.nRb;
    }

    public void setViewpageSmoothScroll(boolean z) {
        this.nRj = z;
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.dSy = onPageChangeListener;
    }

    public void notifyDataSetChanged() {
        tv.chushou.zues.widget.psts.b bVar;
        int[] iArr;
        this.nRe = 0;
        this.nRb = false;
        this.mInterval = this.nRf;
        this.dSz.removeAllViews();
        this.dSB = this.dSA.getAdapter().getCount();
        for (int i = 0; i < this.dSB; i++) {
            if (this.dSA.getAdapter() instanceof b) {
                a(i, ((b) this.dSA.getAdapter()).lI(i), ((b) this.dSA.getAdapter()).IX(i), ((b) this.dSA.getAdapter()).IZ(i), ((b) this.dSA.getAdapter()).IY(i));
            } else {
                if (this.dSA.getAdapter() instanceof e) {
                    e eVar = (e) this.dSA.getAdapter();
                    iArr = eVar.KU(i);
                    bVar = eVar.IZ(i);
                } else {
                    bVar = null;
                    iArr = null;
                }
                a(i, this.dSA.getAdapter().getPageTitle(i).toString(), iArr, bVar, this.dSA.getAdapter() instanceof f ? ((f) this.dSA.getAdapter()).KV(i) : 0);
            }
        }
        if (this.nQY != 0) {
            if (this.nRd == 0) {
                this.nRd = tv.chushou.zues.utils.a.gw(getContext()).x;
            }
            this.nRd -= this.dSz.getPaddingLeft();
            int i2 = (this.nRd - this.nRe) / (this.dSB + 1);
            if (this.nQY == 1) {
                if (this.mInterval < i2) {
                    this.mInterval = i2;
                } else {
                    this.nRb = true;
                }
                this.dSw.setMargins(this.mInterval, 0, 0, 0);
            } else if (this.nQY == 2) {
                if (this.mInterval < (this.nRd - this.nRe) / (this.dSB + 1)) {
                    this.dSz.setGravity(17);
                    this.dSz.setPadding(0, this.dSz.getPaddingTop(), this.nRg, this.dSz.getPaddingBottom());
                } else {
                    this.nRb = true;
                }
                this.dSw.setMargins(this.mInterval, 0, 0, 0);
            } else if (this.nQY == 3) {
                if (this.mInterval >= i2) {
                    this.nRb = true;
                }
                this.dSw.setMargins(this.mInterval, 0, 0, 0);
            }
        }
        updateTabStyles();
        this.nQK = false;
        getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: tv.chushou.zues.widget.psts.PagerSlidingTabStrip.1
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            @SuppressLint({"NewApi"})
            public void onGlobalLayout() {
                if (Build.VERSION.SDK_INT < 16) {
                    PagerSlidingTabStrip.this.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                } else {
                    PagerSlidingTabStrip.this.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                }
                if (PagerSlidingTabStrip.this.dSA != null) {
                    PagerSlidingTabStrip.this.Yf = PagerSlidingTabStrip.this.dSA.getCurrentItem();
                    PagerSlidingTabStrip.this.dY(PagerSlidingTabStrip.this.nQI, 0);
                }
            }
        });
    }

    private void a(final int i, String str, int[] iArr, tv.chushou.zues.widget.psts.b bVar, int i2) {
        RelativeLayout relativeLayout = new RelativeLayout(getContext());
        TextView textView = new TextView(getContext());
        textView.setText(str);
        textView.setFocusable(true);
        textView.setGravity(17);
        textView.setSingleLine();
        textView.setId(b.e.zues_psts_tab_tag);
        textView.setIncludeFontPadding(false);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(this.nQV);
        textView.setLayoutParams(layoutParams);
        textView.setPadding(this.nQQ, this.nQR, this.nQQ, this.nQR);
        textView.setCompoundDrawablePadding(getContext().getResources().getDimensionPixelSize(b.c.zues_psts_text_draw_padding));
        textView.setCompoundDrawablesWithIntrinsicBounds(0, 0, i2, 0);
        relativeLayout.setOnClickListener(new View.OnClickListener() { // from class: tv.chushou.zues.widget.psts.PagerSlidingTabStrip.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int i3 = PagerSlidingTabStrip.this.Yf;
                boolean dY = PagerSlidingTabStrip.this.dY(i, 0);
                PagerSlidingTabStrip.this.dSA.setCurrentItem(i, PagerSlidingTabStrip.this.nRj);
                if (PagerSlidingTabStrip.this.nRi) {
                    if (!dY && (PagerSlidingTabStrip.this.dSA.getAdapter() instanceof h)) {
                        ((h) PagerSlidingTabStrip.this.dSA.getAdapter()).Ch(i);
                    }
                } else if (dY && (PagerSlidingTabStrip.this.dSA.getAdapter() instanceof h)) {
                    ((h) PagerSlidingTabStrip.this.dSA.getAdapter()).Ch(i);
                }
                if (PagerSlidingTabStrip.this.dSA.getAdapter() instanceof a) {
                    ((a) PagerSlidingTabStrip.this.dSA.getAdapter()).dZ(i, i3);
                }
                PagerSlidingTabStrip.this.Yf = i;
                if (PagerSlidingTabStrip.this.nRi) {
                    PagerSlidingTabStrip.this.dSC = 0.0f;
                    PagerSlidingTabStrip.this.nQI = i;
                    PagerSlidingTabStrip.this.setSelectItem(i);
                    PagerSlidingTabStrip.this.dY(i, PagerSlidingTabStrip.this.dSz.getChildAt(i).getWidth() * 0);
                }
            }
        });
        Resources resources = getContext().getResources();
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, resources.getDimensionPixelSize(b.c.zues_psts_red_text_dot_size));
        if (iArr != null) {
            for (int i3 : iArr) {
                if (i3 == 1 || i3 == 0 || i3 == 6 || i3 == 8) {
                    layoutParams2.addRule(i3, b.e.zues_psts_tab_tag);
                }
            }
        } else {
            layoutParams2.addRule(11);
        }
        if (bVar != null) {
            layoutParams2.setMargins(bVar.mLeft, bVar.mTop, bVar.mRight, bVar.mBottom);
        }
        layoutParams2.topMargin = (int) tv.chushou.zues.utils.a.a(1, 2.0f, getContext());
        TextView textView2 = new TextView(getContext());
        textView2.setBackgroundResource(b.d.zues_psts_text_red_dot);
        textView2.setTextColor(resources.getColor(b.C0914b.zues_white));
        textView2.setTextSize(13.0f);
        textView2.setGravity(17);
        textView2.setLayoutParams(layoutParams2);
        textView2.setVisibility(8);
        textView2.setIncludeFontPadding(false);
        textView2.setMinWidth(resources.getDimensionPixelSize(b.c.zues_psts_red_text_dot_size));
        textView2.setVisibility(8);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(getResources().getDimensionPixelSize(b.c.zues_psts_red_image_dot_size), getResources().getDimensionPixelSize(b.c.zues_psts_red_image_dot_size));
        ImageView imageView = new ImageView(getContext());
        imageView.setImageResource(b.d.zues_psts_dot_bg);
        if (iArr != null) {
            for (int i4 : iArr) {
                if (i4 == 1 || i4 == 0 || i4 == 6 || i4 == 8) {
                    layoutParams3.addRule(i4, b.e.zues_psts_tab_tag);
                }
            }
        } else {
            layoutParams3.addRule(11);
        }
        if (bVar != null) {
            layoutParams3.setMargins(bVar.mLeft, bVar.mTop, bVar.mRight, bVar.mBottom);
        }
        imageView.setLayoutParams(layoutParams3);
        imageView.setVisibility(8);
        relativeLayout.addView(textView);
        relativeLayout.addView(textView2);
        relativeLayout.addView(imageView);
        this.dSz.addView(relativeLayout);
        if (this.nQY != 0) {
            Rect rect = new Rect();
            textView.getPaint().getTextBounds(str, 0, str.length(), rect);
            this.nRe = rect.width() + this.nRc + (this.nQQ * 2) + this.nRe;
        }
    }

    public void setTagRightImg(int i, @DrawableRes int i2) {
        TextView textView = (TextView) ((RelativeLayout) this.dSz.getChildAt(i)).findViewById(b.e.zues_psts_tab_tag);
        if (textView != null) {
            textView.setCompoundDrawablesWithIntrinsicBounds(0, 0, i2, 0);
        }
    }

    public void setTagText(int i, String str) {
        TextView textView = (TextView) ((RelativeLayout) this.dSz.getChildAt(i)).findViewById(b.e.zues_psts_tab_tag);
        if (textView != null) {
            textView.setText(str);
        }
    }

    public void bF(int i, String str) {
        RelativeLayout relativeLayout = (RelativeLayout) this.dSz.getChildAt(i);
        View childAt = relativeLayout.getChildAt(relativeLayout.getChildCount() - 3);
        if (childAt != null && (childAt instanceof FrescoThumbnailView)) {
            FrescoThumbnailView frescoThumbnailView = (FrescoThumbnailView) childAt;
            if (tv.chushou.zues.utils.h.isEmpty(str)) {
                frescoThumbnailView.setVisibility(8);
                return;
            }
            frescoThumbnailView.a(str, 0, b.a.small, b.a.small, 1);
            frescoThumbnailView.setVisibility(0);
        }
    }

    public void KO(int i) {
        RelativeLayout relativeLayout = (RelativeLayout) this.dSz.getChildAt(i);
        View childAt = relativeLayout.getChildAt(relativeLayout.getChildCount() - 3);
        if (childAt != null) {
            childAt.setVisibility(8);
        }
    }

    public void KP(int i) {
        RelativeLayout relativeLayout;
        View childAt;
        if (this.dSz != null && (relativeLayout = (RelativeLayout) this.dSz.getChildAt(i)) != null && (childAt = relativeLayout.getChildAt(relativeLayout.getChildCount() - 1)) != null) {
            ((ImageView) childAt).setVisibility(0);
        }
    }

    public void KQ(int i) {
        RelativeLayout relativeLayout;
        View childAt;
        if (this.dSz != null && (relativeLayout = (RelativeLayout) this.dSz.getChildAt(i)) != null && (childAt = relativeLayout.getChildAt(relativeLayout.getChildCount() - 1)) != null) {
            ((ImageView) childAt).setVisibility(8);
        }
    }

    private void a(final int i, int i2, String str, tv.chushou.zues.widget.psts.b bVar, int i3) {
        RelativeLayout relativeLayout = new RelativeLayout(getContext());
        relativeLayout.setOnClickListener(new View.OnClickListener() { // from class: tv.chushou.zues.widget.psts.PagerSlidingTabStrip.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int i4 = PagerSlidingTabStrip.this.Yf;
                boolean dY = PagerSlidingTabStrip.this.dY(i, 0);
                PagerSlidingTabStrip.this.dSA.setCurrentItem(i, PagerSlidingTabStrip.this.nRj);
                if (dY && (PagerSlidingTabStrip.this.dSA.getAdapter() instanceof h)) {
                    ((h) PagerSlidingTabStrip.this.dSA.getAdapter()).Ch(i);
                }
                if (PagerSlidingTabStrip.this.dSA.getAdapter() instanceof a) {
                    ((a) PagerSlidingTabStrip.this.dSA.getAdapter()).dZ(i, i4);
                }
            }
        });
        TextView textView = new TextView(getContext());
        textView.setText(str);
        textView.setFocusable(true);
        textView.setGravity(17);
        textView.setSingleLine();
        textView.setId(b.e.zues_psts_tab_tag);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13);
        if (this.dSA.getAdapter() instanceof c) {
            c cVar = (c) this.dSA.getAdapter();
            for (int i4 : cVar.KS(i)) {
                layoutParams.addRule(Integer.valueOf(i4).intValue());
            }
            tv.chushou.zues.widget.psts.b KT = cVar.KT(i);
            if (KT != null) {
                layoutParams.setMargins(KT.mLeft, KT.mTop, KT.mRight, KT.mBottom);
            }
        }
        textView.setLayoutParams(layoutParams);
        if (i2 != 0) {
            textView.setCompoundDrawablesWithIntrinsicBounds(0, i2, 0, 0);
            textView.setCompoundDrawablePadding(this.nQS);
        }
        Resources resources = getContext().getResources();
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, resources.getDimensionPixelSize(b.c.zues_psts_red_text_dot_size));
        layoutParams2.addRule(11);
        layoutParams2.topMargin = (int) tv.chushou.zues.utils.a.a(1, 2.0f, getContext());
        TextView textView2 = new TextView(getContext());
        textView2.setBackgroundResource(b.d.zues_psts_text_red_dot);
        textView2.setTextColor(resources.getColor(b.C0914b.zues_white));
        textView2.setTextSize(13.0f);
        textView2.setGravity(17);
        textView2.setLayoutParams(layoutParams2);
        textView2.setVisibility(8);
        textView2.setIncludeFontPadding(false);
        textView2.setMinWidth(resources.getDimensionPixelSize(b.c.zues_psts_red_text_dot_size));
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(getResources().getDimensionPixelSize(b.c.zues_psts_red_image_dot_size), getResources().getDimensionPixelSize(b.c.zues_psts_red_image_dot_size));
        ImageView imageView = new ImageView(getContext());
        imageView.setImageResource(b.d.zues_psts_dot_bg);
        if (i3 == 1 || i3 == 0) {
            layoutParams3.addRule(i3, b.e.zues_psts_tab_tag);
        } else {
            layoutParams3.addRule(i3);
        }
        if (bVar != null) {
            layoutParams3.setMargins(bVar.mLeft, bVar.mTop, bVar.mRight, bVar.mBottom);
        }
        imageView.setLayoutParams(layoutParams3);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(getResources().getDimensionPixelSize(b.c.zues_psts_image_width), getResources().getDimensionPixelSize(b.c.zues_psts_image_height));
        layoutParams4.addRule(11);
        layoutParams4.topMargin = (int) tv.chushou.zues.utils.a.a(1, 3.0f, getContext());
        FrescoThumbnailView frescoThumbnailView = new FrescoThumbnailView(getContext());
        frescoThumbnailView.setLayoutParams(layoutParams4);
        frescoThumbnailView.setVisibility(8);
        relativeLayout.addView(textView);
        relativeLayout.addView(frescoThumbnailView);
        relativeLayout.addView(textView2);
        relativeLayout.addView(imageView);
        imageView.setVisibility(8);
        this.dSz.addView(relativeLayout);
    }

    private void updateTabStyles() {
        for (int i = 0; i < this.dSB; i++) {
            View childAt = this.dSz.getChildAt(i);
            if (i != 0) {
                childAt.setLayoutParams(this.dSw);
            } else {
                childAt.setLayoutParams(this.nQG);
            }
            setMyTabLayoutParams(childAt);
            childAt.setBackgroundResource(this.dSP);
            if (this.dSE) {
                childAt.setPadding(0, 0, 0, 0);
            } else {
                childAt.setPadding(this.tabPadding, this.nQP, this.tabPadding, this.nQP);
            }
            if (childAt instanceof RelativeLayout) {
                TextView textView = (TextView) ((RelativeLayout) childAt).getChildAt(0);
                textView.setTextSize(0, this.tabTextSize);
                textView.setTypeface(this.dSM, this.dSN);
                textView.setTextColor(this.tabTextColor);
                if (this.nQM) {
                    if (Build.VERSION.SDK_INT >= 14) {
                        textView.setAllCaps(true);
                    } else {
                        textView.setText(textView.getText().toString().toUpperCase(this.locale));
                    }
                }
            }
        }
    }

    private void setMyTabLayoutParams(View view) {
    }

    public boolean dSl() {
        c cVar;
        if (this.dSA != null && this.dSA.getAdapter() != null && (this.dSA.getAdapter() instanceof c) && (cVar = (c) this.dSA.getAdapter()) != null) {
            for (int i = 0; i < this.dSB; i++) {
                float KR = cVar.KR(i);
                if (KR != 0.0f) {
                    if (KR == 0.0f) {
                        KR = 1.0f;
                    }
                    this.dSz.getChildAt(i).setLayoutParams(new LinearLayout.LayoutParams(0, -1, KR));
                } else {
                    if (i != 0) {
                        this.dSz.getChildAt(i).setLayoutParams(this.dSw);
                    } else {
                        this.dSz.getChildAt(i).setLayoutParams(this.nQG);
                    }
                    setMyTabLayoutParams(this.dSz.getChildAt(i));
                }
            }
        }
        return false;
    }

    @Override // android.widget.HorizontalScrollView, android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (!this.dSE || View.MeasureSpec.getMode(i) == 0) {
            dSl();
            return;
        }
        int measuredWidth = getMeasuredWidth();
        int i3 = 0;
        for (int i4 = 0; i4 < this.dSB; i4++) {
            i3 += this.dSz.getChildAt(i4).getMeasuredWidth();
        }
        if (!this.nQK && i3 > 0 && measuredWidth > 0) {
            if (i3 <= measuredWidth) {
                for (int i5 = 0; i5 < this.dSB; i5++) {
                    if (i5 != 0) {
                        this.dSz.getChildAt(i5).setLayoutParams(this.dSw);
                    } else {
                        this.dSz.getChildAt(i5).setLayoutParams(this.nQG);
                    }
                    setMyTabLayoutParams(this.dSz.getChildAt(i5));
                }
            }
            this.nQK = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean dY(int i, int i2) {
        if (this.dSB == 0) {
            return false;
        }
        int left = this.dSz.getChildAt(i).getLeft() + i2;
        if (i > 0 || i2 > 0) {
            left -= this.dSG;
        }
        int i3 = left - this.mInterval;
        if (i3 != this.dSO) {
            this.dSO = i3;
            scrollTo(i3, 0);
            return false;
        }
        return true;
    }

    public void setTabDrawMode(int i) {
        this.nQX = i;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (!isInEditMode() && this.dSB != 0) {
            if (this.nQX == 0) {
                am(canvas);
            } else {
                an(canvas);
            }
        }
    }

    private void am(Canvas canvas) {
        int height = getHeight();
        this.dSD.setColor(this.nQL);
        View childAt = this.dSz.getChildAt(this.Yf);
        float left = childAt.getLeft();
        float right = childAt.getRight();
        if (this.dSC > 0.0f && this.Yf < this.dSB - 1) {
            View childAt2 = this.dSz.getChildAt(this.Yf + 1);
            left = (left * (1.0f - this.dSC)) + (childAt2.getLeft() * this.dSC);
            right = (childAt2.getRight() * this.dSC) + ((1.0f - this.dSC) * right);
        }
        if (this.dSL > 0) {
            float f2 = ((right - left) - this.dSL) / 2.0f;
            this.mRectF.set(left + f2, height - this.indicatorHeight, f2 + left + this.dSL, height);
            if (this.nQN) {
                canvas.drawRoundRect(this.mRectF, this.indicatorHeight / 2, this.indicatorHeight / 2, this.dSD);
            } else {
                canvas.drawRect(this.mRectF, this.dSD);
            }
        } else {
            canvas.drawRect(left, height - this.indicatorHeight, right, height, this.dSD);
        }
        this.dSD.setColor(this.nwe);
        canvas.drawRect(0.0f, height - this.dUD, this.dSz.getWidth(), height, this.dSD);
        this.nQJ.setColor(this.dividerColor);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.dSB - 1) {
                View childAt3 = this.dSz.getChildAt(i2);
                canvas.drawLine(childAt3.getRight(), this.dividerPadding, childAt3.getRight(), height - this.dividerPadding, this.nQJ);
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    private void an(Canvas canvas) {
        float f2;
        float f3;
        float f4;
        int height = getHeight();
        this.dSD.setColor(this.nwe);
        canvas.drawRect(0.0f, height - this.dUD, this.dSz.getWidth(), height, this.dSD);
        this.dSD.setColor(this.nQL);
        View childAt = this.dSz.getChildAt(this.Yf);
        float left = childAt.getLeft();
        View childAt2 = ((RelativeLayout) childAt).getChildAt(0);
        float left2 = childAt2.getLeft();
        float right = childAt2.getRight();
        if (this.dSC <= 0.0f || this.Yf >= this.dSB - 1) {
            f2 = right;
            f3 = left2;
            f4 = left;
        } else {
            View childAt3 = this.dSz.getChildAt(this.Yf + 1);
            float left3 = (left * (1.0f - this.dSC)) + (childAt3.getLeft() * this.dSC);
            View childAt4 = ((RelativeLayout) childAt3).getChildAt(0);
            f3 = (childAt4.getLeft() * this.dSC) + (left2 * (1.0f - this.dSC));
            f2 = (childAt4.getRight() * this.dSC) + (right * (1.0f - this.dSC));
            f4 = left3;
        }
        if (this.dSL > 0) {
            float f5 = ((f2 - f3) - this.dSL) / 2.0f;
            this.mRectF.set(f4 + f3 + f5, height - this.indicatorHeight, f5 + f3 + f4 + this.dSL, height);
            if (this.nQN) {
                canvas.drawRoundRect(this.mRectF, this.indicatorHeight / 2, this.indicatorHeight / 2, this.dSD);
            } else {
                canvas.drawRect(this.mRectF, this.dSD);
            }
        } else {
            canvas.drawRect(f3 + f4, height - this.indicatorHeight, f4 + f2, height, this.dSD);
        }
        this.nQJ.setColor(this.dividerColor);
        this.dSD.setColor(this.nwe);
        for (int i = 0; i < this.dSB; i++) {
            View childAt5 = this.dSz.getChildAt(i);
            if (i < this.dSB - 1) {
                canvas.drawLine(childAt5.getRight(), this.dividerPadding, childAt5.getRight(), height - this.dividerPadding, this.nQJ);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public class d implements ViewPager.OnPageChangeListener {
        private d() {
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
            PagerSlidingTabStrip.this.Yf = i;
            PagerSlidingTabStrip.this.dSC = f;
            if (PagerSlidingTabStrip.this.dSz != null) {
                PagerSlidingTabStrip.this.dY(i, (int) (PagerSlidingTabStrip.this.dSz.getChildAt(i).getWidth() * f));
            }
            PagerSlidingTabStrip.this.invalidate();
            if (PagerSlidingTabStrip.this.dSy != null) {
                PagerSlidingTabStrip.this.dSy.onPageScrolled(i, f, i2);
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            if (i == 0) {
                PagerSlidingTabStrip.this.dY(PagerSlidingTabStrip.this.dSA.getCurrentItem(), 0);
            }
            if (PagerSlidingTabStrip.this.dSy != null) {
                PagerSlidingTabStrip.this.dSy.onPageScrollStateChanged(i);
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            PagerSlidingTabStrip.this.setSelectItem(i);
            if (PagerSlidingTabStrip.this.dSy != null) {
                PagerSlidingTabStrip.this.dSy.onPageSelected(i);
            }
        }
    }

    public void setSelectItem(int i) {
        if (this.dSz != null) {
            this.nQI = i;
            for (int i2 = 0; i2 < this.dSz.getChildCount(); i2++) {
                if (i2 == i) {
                    RelativeLayout relativeLayout = (RelativeLayout) this.dSz.getChildAt(i);
                    relativeLayout.setSelected(true);
                    TextView textView = (TextView) relativeLayout.getChildAt(0);
                    textView.setTypeface(this.dSM, this.nQW);
                    textView.setTextColor(this.nQU);
                    textView.setTextSize(0, this.nQT);
                    if (this.nQZ != -1) {
                        textView.setBackgroundResource(this.nQZ);
                    }
                    if (this.dSA.getAdapter() instanceof b) {
                        textView.setCompoundDrawablesWithIntrinsicBounds(0, ((b) this.dSA.getAdapter()).IW(i), 0, 0);
                    }
                } else {
                    RelativeLayout relativeLayout2 = (RelativeLayout) this.dSz.getChildAt(i2);
                    relativeLayout2.setSelected(false);
                    TextView textView2 = (TextView) relativeLayout2.getChildAt(0);
                    textView2.setTextColor(this.tabTextColor);
                    textView2.setBackgroundResource(0);
                    textView2.setTextSize(0, this.tabTextSize);
                    textView2.setTypeface(this.dSM, this.dSN);
                    if (this.dSA.getAdapter() instanceof b) {
                        textView2.setCompoundDrawablesWithIntrinsicBounds(0, ((b) this.dSA.getAdapter()).lI(i2), 0, 0);
                    }
                }
            }
        }
    }

    public void setTabTextSelectColor(@ColorInt int i) {
        this.nQU = i;
        invalidate();
    }

    public void setIndicatorColor(int i) {
        this.nQL = i;
        invalidate();
    }

    public void setIndicatorColorResource(int i) {
        this.nQL = getResources().getColor(i);
        invalidate();
    }

    public int getIndicatorColor() {
        return this.nQL;
    }

    public void setIndicatorHeight(int i) {
        this.indicatorHeight = i;
        invalidate();
    }

    public void setIndicatorWidth(int i) {
        this.dSL = i;
        invalidate();
    }

    public int getIndicatorHeight() {
        return this.indicatorHeight;
    }

    public int getIndicatorWidth() {
        return this.dSL;
    }

    public void setUnderlineColor(int i) {
        this.nwe = i;
        invalidate();
    }

    public void setUnderlineColorResource(int i) {
        this.nwe = getResources().getColor(i);
        invalidate();
    }

    public int getUnderlineColor() {
        return this.nwe;
    }

    public void setDividerColor(int i) {
        this.dividerColor = i;
        invalidate();
    }

    public void setDividerColorResource(int i) {
        this.dividerColor = getResources().getColor(i);
        invalidate();
    }

    public int getDividerColor() {
        return this.dividerColor;
    }

    public void setUnderlineHeight(int i) {
        this.dUD = i;
        invalidate();
    }

    public int getUnderlineHeight() {
        return this.dUD;
    }

    public void setDividerPadding(int i) {
        this.dividerPadding = i;
        invalidate();
    }

    public int getDividerPadding() {
        return this.dividerPadding;
    }

    public void setScrollOffset(int i) {
        this.dSG = i;
        invalidate();
    }

    public int getScrollOffset() {
        return this.dSG;
    }

    public void setShouldExpand(boolean z) {
        this.dSE = z;
        requestLayout();
    }

    public boolean getShouldExpand() {
        return this.dSE;
    }

    public void setAllCaps(boolean z) {
        this.nQM = z;
    }

    public void setTextSize(int i) {
        this.tabTextSize = i;
        updateTabStyles();
    }

    public int getTextSize() {
        return this.tabTextSize;
    }

    public void setTextColor(int i) {
        this.tabTextColor = i;
        updateTabStyles();
    }

    public void setTextColorResource(int i) {
        this.tabTextColor = getResources().getColor(i);
        updateTabStyles();
    }

    public int getTextColor() {
        return this.tabTextColor;
    }

    public void setTypeface(Typeface typeface, int i) {
        this.dSM = typeface;
        this.dSN = i;
        updateTabStyles();
    }

    public void setSelectedTypeface(Typeface typeface, int i) {
        this.dSM = typeface;
        this.nQW = i;
        updateTabStyles();
    }

    public void setTabBackground(int i) {
        this.dSP = i;
    }

    public int getTabBackground() {
        return this.dSP;
    }

    public void setTabPaddingLeftRight(int i) {
        this.tabPadding = i;
        updateTabStyles();
    }

    public int getTabPaddingLeftRight() {
        return this.tabPadding;
    }

    public void setIconPadding(int i) {
        this.nQS = i;
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.Yf = savedState.Yf;
        requestLayout();
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.Yf = this.Yf;
        return savedState;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() { // from class: tv.chushou.zues.widget.psts.PagerSlidingTabStrip.SavedState.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            /* renamed from: an */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            /* renamed from: KW */
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };
        int Yf;

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.Yf = parcel.readInt();
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.Yf);
        }
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.nRk != null) {
            this.nRk.xs(true);
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    public void setDisallowIntercept(tv.chushou.zues.widget.psts.a aVar) {
        this.nRk = aVar;
    }
}
