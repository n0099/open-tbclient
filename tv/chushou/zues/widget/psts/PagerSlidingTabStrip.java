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
/* loaded from: classes4.dex */
public class PagerSlidingTabStrip extends HorizontalScrollView {
    private static final int[] ATTRS = {16842901, 16842904};
    private int Ec;
    private LinearLayout.LayoutParams dab;
    public ViewPager.OnPageChangeListener dad;
    private LinearLayout dae;
    private ViewPager daf;
    private int dag;
    private float dah;
    private Paint dai;
    private boolean daj;
    private int dam;
    private int dar;
    private Typeface das;
    private int dat;
    private int dau;
    private int dav;
    private int dck;
    private int dcl;
    private int dividerColor;
    private int dividerPadding;
    private DisplayMetrics dm;
    private int indicatorHeight;
    private Locale locale;
    private int mInterval;
    private final RectF mRectF;
    private int nEB;
    private LinearLayout.LayoutParams nYP;
    private d nYQ;
    private int nYR;
    private Paint nYS;
    private boolean nYT;
    private int nYU;
    private boolean nYV;
    private boolean nYW;
    private int nYX;
    private int nYY;
    private int nYZ;
    private int nZa;
    private int nZb;
    private int nZc;
    private int nZd;
    private int nZe;
    private int nZf;
    private int nZg;
    private int nZh;
    private int nZi;
    private boolean nZj;
    private boolean nZk;
    private int nZl;
    private int nZm;
    private int nZn;
    private int nZo;
    private int nZp;
    private boolean nZq;
    private boolean nZr;
    private boolean nZs;
    private tv.chushou.zues.widget.psts.a nZt;
    private int tabPadding;
    private int tabTextColor;
    private int tabTextSize;

    /* loaded from: classes4.dex */
    public interface a {
        void eF(int i, int i2);
    }

    /* loaded from: classes4.dex */
    public interface b {
        int MH(int i);

        String MI(int i);

        int MJ(int i);

        tv.chushou.zues.widget.psts.b MK(int i);

        int kF(int i);
    }

    /* loaded from: classes4.dex */
    public interface c {
        float OA(int i);

        int[] OB(int i);

        tv.chushou.zues.widget.psts.b OC(int i);
    }

    /* loaded from: classes4.dex */
    public interface e {
        tv.chushou.zues.widget.psts.b MK(int i);

        int[] OD(int i);
    }

    /* loaded from: classes4.dex */
    public interface f {
        int OE(int i);
    }

    /* loaded from: classes4.dex */
    public interface g {
        void bt(int i);
    }

    /* loaded from: classes4.dex */
    public interface h {
        void AG(int i);
    }

    public PagerSlidingTabStrip(Context context) {
        this(context, null);
    }

    public PagerSlidingTabStrip(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PagerSlidingTabStrip(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.nYQ = new d();
        this.Ec = 0;
        this.nYR = 0;
        this.dah = 0.0f;
        this.nYT = false;
        this.nYU = -10066330;
        this.nEB = 436207616;
        this.dividerColor = 436207616;
        this.daj = true;
        this.nYV = false;
        this.dam = 52;
        this.indicatorHeight = 3;
        this.dar = 0;
        this.nYW = true;
        this.dck = 1;
        this.dividerPadding = 12;
        this.nYX = 0;
        this.tabPadding = 24;
        this.nYY = 0;
        this.nYZ = 0;
        this.nZa = 0;
        this.dcl = 1;
        this.nZb = 0;
        this.tabTextSize = 15;
        this.nZc = this.tabTextSize;
        this.tabTextColor = -10066330;
        this.nZd = -10066330;
        this.nZe = 13;
        this.das = null;
        this.dat = 0;
        this.nZf = 1;
        this.dau = 0;
        this.nZg = 1;
        this.nZh = 0;
        this.dav = b.d.zues_psts_tab_background;
        this.nZi = -1;
        this.nZj = true;
        this.nZk = false;
        this.nZl = 3;
        this.nZo = 16;
        this.nZp = 0;
        this.mInterval = 0;
        this.nZq = false;
        this.nZr = false;
        this.nZs = true;
        this.mRectF = new RectF();
        setFillViewport(true);
        setWillNotDraw(false);
        this.dae = new LinearLayout(context);
        this.dae.setOrientation(0);
        this.dae.setGravity(16);
        this.dm = getResources().getDisplayMetrics();
        this.nZo = (int) TypedValue.applyDimension(1, this.nZo, this.dm);
        this.dam = (int) TypedValue.applyDimension(1, this.dam, this.dm);
        this.indicatorHeight = (int) TypedValue.applyDimension(1, this.indicatorHeight, this.dm);
        this.dar = (int) TypedValue.applyDimension(1, this.dar, this.dm);
        this.dck = (int) TypedValue.applyDimension(1, this.dck, this.dm);
        this.dividerPadding = (int) TypedValue.applyDimension(1, this.dividerPadding, this.dm);
        this.tabPadding = (int) TypedValue.applyDimension(1, this.tabPadding, this.dm);
        this.dcl = (int) TypedValue.applyDimension(1, this.dcl, this.dm);
        this.tabTextSize = (int) TypedValue.applyDimension(2, this.tabTextSize, this.dm);
        this.nZl = (int) TypedValue.applyDimension(1, this.nZl, this.dm);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, ATTRS);
        this.tabTextSize = obtainStyledAttributes.getDimensionPixelSize(0, this.tabTextSize);
        this.nZc = this.tabTextSize;
        this.tabTextColor = obtainStyledAttributes.getColor(1, this.tabTextColor);
        obtainStyledAttributes.recycle();
        TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, b.i.PagerSlidingTabStrip);
        this.nYU = obtainStyledAttributes2.getColor(b.i.PagerSlidingTabStrip_indicatorColor, this.nYU);
        this.nYW = obtainStyledAttributes2.getBoolean(b.i.PagerSlidingTabStrip_indicatorRoundCap, false);
        this.nEB = obtainStyledAttributes2.getColor(b.i.PagerSlidingTabStrip_underlineColor, this.nEB);
        this.dividerColor = obtainStyledAttributes2.getColor(b.i.PagerSlidingTabStrip_dividerColor, this.dividerColor);
        this.nZd = obtainStyledAttributes2.getColor(b.i.PagerSlidingTabStrip_tabTextSelectColor, this.dividerColor);
        this.indicatorHeight = obtainStyledAttributes2.getDimensionPixelSize(b.i.PagerSlidingTabStrip_indicatorHeight, this.indicatorHeight);
        this.dar = obtainStyledAttributes2.getDimensionPixelSize(b.i.PagerSlidingTabStrip_indicatorWidth, this.dar);
        this.dck = obtainStyledAttributes2.getDimensionPixelSize(b.i.PagerSlidingTabStrip_underlineHeight, this.dck);
        this.dividerPadding = obtainStyledAttributes2.getDimensionPixelSize(b.i.PagerSlidingTabStrip_psts_dividerPadding, this.dividerPadding);
        this.nZo = obtainStyledAttributes2.getDimensionPixelSize(b.i.PagerSlidingTabStrip_psts_minInterval, this.nZo);
        this.nZp = obtainStyledAttributes2.getDimensionPixelSize(b.i.PagerSlidingTabStrip_center_paddingRight, 0);
        this.nYX = obtainStyledAttributes2.getDimensionPixelSize(b.i.PagerSlidingTabStrip_parentPaddingLeft, this.nYX);
        this.tabPadding = obtainStyledAttributes2.getDimensionPixelSize(b.i.PagerSlidingTabStrip_tabPaddingLeftRight, this.tabPadding);
        this.nYY = obtainStyledAttributes2.getDimensionPixelSize(b.i.PagerSlidingTabStrip_tabPaddingTopBottom, this.nYY);
        this.nYZ = obtainStyledAttributes2.getDimensionPixelSize(b.i.PagerSlidingTabStrip_textPaddingLeftRight, this.nYZ);
        this.nZa = obtainStyledAttributes2.getDimensionPixelSize(b.i.PagerSlidingTabStrip_textPaddingTopBottom, this.nZa);
        this.dav = obtainStyledAttributes2.getResourceId(b.i.PagerSlidingTabStrip_ptabBackground, this.dav);
        this.nZi = obtainStyledAttributes2.getResourceId(b.i.PagerSlidingTabStrip_textBackground, this.nZi);
        this.daj = obtainStyledAttributes2.getBoolean(b.i.PagerSlidingTabStrip_shouldExpand, this.daj);
        this.dam = obtainStyledAttributes2.getDimensionPixelSize(b.i.PagerSlidingTabStrip_scrollOffset, this.dam);
        this.nYV = obtainStyledAttributes2.getBoolean(b.i.PagerSlidingTabStrip_psts_textAllCaps, this.nYV);
        this.nZj = obtainStyledAttributes2.getBoolean(b.i.PagerSlidingTabStrip_psts_tabIsWeight, this.nZj);
        this.nZg = obtainStyledAttributes2.getInteger(b.i.PagerSlidingTabStrip_apsts_draw_mode, 0);
        this.nZh = obtainStyledAttributes2.getInteger(b.i.PagerSlidingTabStrip_apsts_layout_mode, 0);
        this.nZc = obtainStyledAttributes2.getDimensionPixelSize(b.i.PagerSlidingTabStrip_tabTextSelectSize, this.tabTextSize);
        obtainStyledAttributes2.recycle();
        this.dai = new Paint();
        this.dai.setAntiAlias(true);
        this.dai.setStyle(Paint.Style.FILL);
        this.nYS = new Paint();
        this.nYS.setAntiAlias(true);
        this.nYS.setStrokeWidth(this.dcl);
        if (this.nZh == 0) {
            this.dab = new LinearLayout.LayoutParams(0, -1, 1.0f);
            this.nYP = new LinearLayout.LayoutParams(0, -1, 1.0f);
            this.nYP.setMargins(0, 0, 0, 0);
        } else {
            this.dab = new LinearLayout.LayoutParams(-2, -1);
            this.nYP = new LinearLayout.LayoutParams(-2, -1);
            this.nYP.setMargins(0, 0, 0, 0);
        }
        if (this.locale == null) {
            this.locale = getResources().getConfiguration().locale;
        }
        this.dae.setPadding(this.nYX, this.dae.getPaddingTop(), this.dae.getPaddingRight(), this.dae.getPaddingBottom());
        this.dae.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        addView(this.dae);
    }

    public void setControlWidth(int i) {
        this.nZm = i;
    }

    /* loaded from: classes4.dex */
    public class NewAdapter extends FragmentStatePagerAdapter implements h {
        private List<String> mDatas;
        private g nZv;

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
        public void AG(int i) {
            if (this.nZv != null) {
                this.nZv.bt(i);
            }
        }
    }

    public boolean c(ViewPager viewPager) {
        return a(viewPager, false);
    }

    public boolean a(ViewPager viewPager, boolean z) {
        this.daf = viewPager;
        if (viewPager.getAdapter() == null) {
            throw new IllegalStateException("ViewPager does not have adapter instance.");
        }
        if (!z) {
            viewPager.addOnPageChangeListener(this.nYQ);
        }
        notifyDataSetChanged();
        return this.nZk;
    }

    public void setViewpageSmoothScroll(boolean z) {
        this.nZs = z;
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.dad = onPageChangeListener;
    }

    public void notifyDataSetChanged() {
        tv.chushou.zues.widget.psts.b bVar;
        int[] iArr;
        this.nZn = 0;
        this.nZk = false;
        this.mInterval = this.nZo;
        this.dae.removeAllViews();
        this.dag = this.daf.getAdapter().getCount();
        for (int i = 0; i < this.dag; i++) {
            if (this.daf.getAdapter() instanceof b) {
                a(i, ((b) this.daf.getAdapter()).kF(i), ((b) this.daf.getAdapter()).MI(i), ((b) this.daf.getAdapter()).MK(i), ((b) this.daf.getAdapter()).MJ(i));
            } else {
                if (this.daf.getAdapter() instanceof e) {
                    e eVar = (e) this.daf.getAdapter();
                    iArr = eVar.OD(i);
                    bVar = eVar.MK(i);
                } else {
                    bVar = null;
                    iArr = null;
                }
                a(i, this.daf.getAdapter().getPageTitle(i).toString(), iArr, bVar, this.daf.getAdapter() instanceof f ? ((f) this.daf.getAdapter()).OE(i) : 0);
            }
        }
        if (this.nZh != 0) {
            if (this.nZm == 0) {
                this.nZm = tv.chushou.zues.utils.a.hf(getContext()).x;
            }
            this.nZm -= this.dae.getPaddingLeft();
            int i2 = (this.nZm - this.nZn) / (this.dag + 1);
            if (this.nZh == 1) {
                if (this.mInterval < i2) {
                    this.mInterval = i2;
                } else {
                    this.nZk = true;
                }
                this.dab.setMargins(this.mInterval, 0, 0, 0);
            } else if (this.nZh == 2) {
                if (this.mInterval < (this.nZm - this.nZn) / (this.dag + 1)) {
                    this.dae.setGravity(17);
                    this.dae.setPadding(0, this.dae.getPaddingTop(), this.nZp, this.dae.getPaddingBottom());
                } else {
                    this.nZk = true;
                }
                this.dab.setMargins(this.mInterval, 0, 0, 0);
            } else if (this.nZh == 3) {
                if (this.mInterval >= i2) {
                    this.nZk = true;
                }
                this.dab.setMargins(this.mInterval, 0, 0, 0);
            }
        }
        updateTabStyles();
        this.nYT = false;
        getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: tv.chushou.zues.widget.psts.PagerSlidingTabStrip.1
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            @SuppressLint({"NewApi"})
            public void onGlobalLayout() {
                if (Build.VERSION.SDK_INT < 16) {
                    PagerSlidingTabStrip.this.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                } else {
                    PagerSlidingTabStrip.this.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                }
                if (PagerSlidingTabStrip.this.daf != null) {
                    PagerSlidingTabStrip.this.Ec = PagerSlidingTabStrip.this.daf.getCurrentItem();
                    PagerSlidingTabStrip.this.eE(PagerSlidingTabStrip.this.nYR, 0);
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
        layoutParams.addRule(this.nZe);
        textView.setLayoutParams(layoutParams);
        textView.setPadding(this.nYZ, this.nZa, this.nYZ, this.nZa);
        textView.setCompoundDrawablePadding(getContext().getResources().getDimensionPixelSize(b.c.zues_psts_text_draw_padding));
        textView.setCompoundDrawablesWithIntrinsicBounds(0, 0, i2, 0);
        relativeLayout.setOnClickListener(new View.OnClickListener() { // from class: tv.chushou.zues.widget.psts.PagerSlidingTabStrip.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int i3 = PagerSlidingTabStrip.this.Ec;
                boolean eE = PagerSlidingTabStrip.this.eE(i, 0);
                PagerSlidingTabStrip.this.daf.setCurrentItem(i, PagerSlidingTabStrip.this.nZs);
                if (PagerSlidingTabStrip.this.nZr) {
                    if (!eE && (PagerSlidingTabStrip.this.daf.getAdapter() instanceof h)) {
                        ((h) PagerSlidingTabStrip.this.daf.getAdapter()).AG(i);
                    }
                } else if (eE && (PagerSlidingTabStrip.this.daf.getAdapter() instanceof h)) {
                    ((h) PagerSlidingTabStrip.this.daf.getAdapter()).AG(i);
                }
                if (PagerSlidingTabStrip.this.daf.getAdapter() instanceof a) {
                    ((a) PagerSlidingTabStrip.this.daf.getAdapter()).eF(i, i3);
                }
                PagerSlidingTabStrip.this.Ec = i;
                if (PagerSlidingTabStrip.this.nZr) {
                    PagerSlidingTabStrip.this.dah = 0.0f;
                    PagerSlidingTabStrip.this.nYR = i;
                    PagerSlidingTabStrip.this.setSelectItem(i);
                    PagerSlidingTabStrip.this.eE(i, PagerSlidingTabStrip.this.dae.getChildAt(i).getWidth() * 0);
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
        textView2.setTextColor(resources.getColor(b.C0799b.zues_white));
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
        this.dae.addView(relativeLayout);
        if (this.nZh != 0) {
            Rect rect = new Rect();
            textView.getPaint().getTextBounds(str, 0, str.length(), rect);
            this.nZn = rect.width() + this.nZl + (this.nYZ * 2) + this.nZn;
        }
    }

    public void setTagRightImg(int i, @DrawableRes int i2) {
        TextView textView = (TextView) ((RelativeLayout) this.dae.getChildAt(i)).findViewById(b.e.zues_psts_tab_tag);
        if (textView != null) {
            textView.setCompoundDrawablesWithIntrinsicBounds(0, 0, i2, 0);
        }
    }

    public void setTagText(int i, String str) {
        TextView textView = (TextView) ((RelativeLayout) this.dae.getChildAt(i)).findViewById(b.e.zues_psts_tab_tag);
        if (textView != null) {
            textView.setText(str);
        }
    }

    public void bm(int i, String str) {
        RelativeLayout relativeLayout = (RelativeLayout) this.dae.getChildAt(i);
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

    public void Ox(int i) {
        RelativeLayout relativeLayout = (RelativeLayout) this.dae.getChildAt(i);
        View childAt = relativeLayout.getChildAt(relativeLayout.getChildCount() - 3);
        if (childAt != null) {
            childAt.setVisibility(8);
        }
    }

    public void Oy(int i) {
        RelativeLayout relativeLayout;
        View childAt;
        if (this.dae != null && (relativeLayout = (RelativeLayout) this.dae.getChildAt(i)) != null && (childAt = relativeLayout.getChildAt(relativeLayout.getChildCount() - 1)) != null) {
            ((ImageView) childAt).setVisibility(0);
        }
    }

    public void Oz(int i) {
        RelativeLayout relativeLayout;
        View childAt;
        if (this.dae != null && (relativeLayout = (RelativeLayout) this.dae.getChildAt(i)) != null && (childAt = relativeLayout.getChildAt(relativeLayout.getChildCount() - 1)) != null) {
            ((ImageView) childAt).setVisibility(8);
        }
    }

    private void a(final int i, int i2, String str, tv.chushou.zues.widget.psts.b bVar, int i3) {
        RelativeLayout relativeLayout = new RelativeLayout(getContext());
        relativeLayout.setOnClickListener(new View.OnClickListener() { // from class: tv.chushou.zues.widget.psts.PagerSlidingTabStrip.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int i4 = PagerSlidingTabStrip.this.Ec;
                boolean eE = PagerSlidingTabStrip.this.eE(i, 0);
                PagerSlidingTabStrip.this.daf.setCurrentItem(i, PagerSlidingTabStrip.this.nZs);
                if (eE && (PagerSlidingTabStrip.this.daf.getAdapter() instanceof h)) {
                    ((h) PagerSlidingTabStrip.this.daf.getAdapter()).AG(i);
                }
                if (PagerSlidingTabStrip.this.daf.getAdapter() instanceof a) {
                    ((a) PagerSlidingTabStrip.this.daf.getAdapter()).eF(i, i4);
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
        if (this.daf.getAdapter() instanceof c) {
            c cVar = (c) this.daf.getAdapter();
            for (int i4 : cVar.OB(i)) {
                layoutParams.addRule(Integer.valueOf(i4).intValue());
            }
            tv.chushou.zues.widget.psts.b OC = cVar.OC(i);
            if (OC != null) {
                layoutParams.setMargins(OC.mLeft, OC.mTop, OC.mRight, OC.mBottom);
            }
        }
        textView.setLayoutParams(layoutParams);
        if (i2 != 0) {
            textView.setCompoundDrawablesWithIntrinsicBounds(0, i2, 0, 0);
            textView.setCompoundDrawablePadding(this.nZb);
        }
        Resources resources = getContext().getResources();
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, resources.getDimensionPixelSize(b.c.zues_psts_red_text_dot_size));
        layoutParams2.addRule(11);
        layoutParams2.topMargin = (int) tv.chushou.zues.utils.a.a(1, 2.0f, getContext());
        TextView textView2 = new TextView(getContext());
        textView2.setBackgroundResource(b.d.zues_psts_text_red_dot);
        textView2.setTextColor(resources.getColor(b.C0799b.zues_white));
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
        this.dae.addView(relativeLayout);
    }

    private void updateTabStyles() {
        for (int i = 0; i < this.dag; i++) {
            View childAt = this.dae.getChildAt(i);
            if (i != 0) {
                childAt.setLayoutParams(this.dab);
            } else {
                childAt.setLayoutParams(this.nYP);
            }
            setMyTabLayoutParams(childAt);
            childAt.setBackgroundResource(this.dav);
            if (this.daj) {
                childAt.setPadding(0, 0, 0, 0);
            } else {
                childAt.setPadding(this.tabPadding, this.nYY, this.tabPadding, this.nYY);
            }
            if (childAt instanceof RelativeLayout) {
                TextView textView = (TextView) ((RelativeLayout) childAt).getChildAt(0);
                textView.setTextSize(0, this.tabTextSize);
                textView.setTypeface(this.das, this.dat);
                textView.setTextColor(this.tabTextColor);
                if (this.nYV) {
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

    public boolean dPA() {
        c cVar;
        if (this.daf != null && this.daf.getAdapter() != null && (this.daf.getAdapter() instanceof c) && (cVar = (c) this.daf.getAdapter()) != null) {
            for (int i = 0; i < this.dag; i++) {
                float OA = cVar.OA(i);
                if (OA != 0.0f) {
                    if (OA == 0.0f) {
                        OA = 1.0f;
                    }
                    this.dae.getChildAt(i).setLayoutParams(new LinearLayout.LayoutParams(0, -1, OA));
                } else {
                    if (i != 0) {
                        this.dae.getChildAt(i).setLayoutParams(this.dab);
                    } else {
                        this.dae.getChildAt(i).setLayoutParams(this.nYP);
                    }
                    setMyTabLayoutParams(this.dae.getChildAt(i));
                }
            }
        }
        return false;
    }

    @Override // android.widget.HorizontalScrollView, android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (!this.daj || View.MeasureSpec.getMode(i) == 0) {
            dPA();
            return;
        }
        int measuredWidth = getMeasuredWidth();
        int i3 = 0;
        for (int i4 = 0; i4 < this.dag; i4++) {
            i3 += this.dae.getChildAt(i4).getMeasuredWidth();
        }
        if (!this.nYT && i3 > 0 && measuredWidth > 0) {
            if (i3 <= measuredWidth) {
                for (int i5 = 0; i5 < this.dag; i5++) {
                    if (i5 != 0) {
                        this.dae.getChildAt(i5).setLayoutParams(this.dab);
                    } else {
                        this.dae.getChildAt(i5).setLayoutParams(this.nYP);
                    }
                    setMyTabLayoutParams(this.dae.getChildAt(i5));
                }
            }
            this.nYT = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean eE(int i, int i2) {
        if (this.dag == 0) {
            return false;
        }
        int left = this.dae.getChildAt(i).getLeft() + i2;
        if (i > 0 || i2 > 0) {
            left -= this.dam;
        }
        int i3 = left - this.mInterval;
        if (i3 != this.dau) {
            this.dau = i3;
            scrollTo(i3, 0);
            return false;
        }
        return true;
    }

    public void setTabDrawMode(int i) {
        this.nZg = i;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (!isInEditMode() && this.dag != 0) {
            if (this.nZg == 0) {
                aq(canvas);
            } else {
                ar(canvas);
            }
        }
    }

    private void aq(Canvas canvas) {
        int height = getHeight();
        this.dai.setColor(this.nYU);
        View childAt = this.dae.getChildAt(this.Ec);
        float left = childAt.getLeft();
        float right = childAt.getRight();
        if (this.dah > 0.0f && this.Ec < this.dag - 1) {
            View childAt2 = this.dae.getChildAt(this.Ec + 1);
            left = (left * (1.0f - this.dah)) + (childAt2.getLeft() * this.dah);
            right = (childAt2.getRight() * this.dah) + ((1.0f - this.dah) * right);
        }
        if (this.dar > 0) {
            float f2 = ((right - left) - this.dar) / 2.0f;
            this.mRectF.set(left + f2, height - this.indicatorHeight, f2 + left + this.dar, height);
            if (this.nYW) {
                canvas.drawRoundRect(this.mRectF, this.indicatorHeight / 2, this.indicatorHeight / 2, this.dai);
            } else {
                canvas.drawRect(this.mRectF, this.dai);
            }
        } else {
            canvas.drawRect(left, height - this.indicatorHeight, right, height, this.dai);
        }
        this.dai.setColor(this.nEB);
        canvas.drawRect(0.0f, height - this.dck, this.dae.getWidth(), height, this.dai);
        this.nYS.setColor(this.dividerColor);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.dag - 1) {
                View childAt3 = this.dae.getChildAt(i2);
                canvas.drawLine(childAt3.getRight(), this.dividerPadding, childAt3.getRight(), height - this.dividerPadding, this.nYS);
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    private void ar(Canvas canvas) {
        float f2;
        float f3;
        float f4;
        int height = getHeight();
        this.dai.setColor(this.nEB);
        canvas.drawRect(0.0f, height - this.dck, this.dae.getWidth(), height, this.dai);
        this.dai.setColor(this.nYU);
        View childAt = this.dae.getChildAt(this.Ec);
        float left = childAt.getLeft();
        View childAt2 = ((RelativeLayout) childAt).getChildAt(0);
        float left2 = childAt2.getLeft();
        float right = childAt2.getRight();
        if (this.dah <= 0.0f || this.Ec >= this.dag - 1) {
            f2 = right;
            f3 = left2;
            f4 = left;
        } else {
            View childAt3 = this.dae.getChildAt(this.Ec + 1);
            float left3 = (left * (1.0f - this.dah)) + (childAt3.getLeft() * this.dah);
            View childAt4 = ((RelativeLayout) childAt3).getChildAt(0);
            f3 = (childAt4.getLeft() * this.dah) + (left2 * (1.0f - this.dah));
            f2 = (childAt4.getRight() * this.dah) + (right * (1.0f - this.dah));
            f4 = left3;
        }
        if (this.dar > 0) {
            float f5 = ((f2 - f3) - this.dar) / 2.0f;
            this.mRectF.set(f4 + f3 + f5, height - this.indicatorHeight, f5 + f3 + f4 + this.dar, height);
            if (this.nYW) {
                canvas.drawRoundRect(this.mRectF, this.indicatorHeight / 2, this.indicatorHeight / 2, this.dai);
            } else {
                canvas.drawRect(this.mRectF, this.dai);
            }
        } else {
            canvas.drawRect(f3 + f4, height - this.indicatorHeight, f4 + f2, height, this.dai);
        }
        this.nYS.setColor(this.dividerColor);
        this.dai.setColor(this.nEB);
        for (int i = 0; i < this.dag; i++) {
            View childAt5 = this.dae.getChildAt(i);
            if (i < this.dag - 1) {
                canvas.drawLine(childAt5.getRight(), this.dividerPadding, childAt5.getRight(), height - this.dividerPadding, this.nYS);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public class d implements ViewPager.OnPageChangeListener {
        private d() {
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
            PagerSlidingTabStrip.this.Ec = i;
            PagerSlidingTabStrip.this.dah = f;
            if (PagerSlidingTabStrip.this.dae != null) {
                PagerSlidingTabStrip.this.eE(i, (int) (PagerSlidingTabStrip.this.dae.getChildAt(i).getWidth() * f));
            }
            PagerSlidingTabStrip.this.invalidate();
            if (PagerSlidingTabStrip.this.dad != null) {
                PagerSlidingTabStrip.this.dad.onPageScrolled(i, f, i2);
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            if (i == 0) {
                PagerSlidingTabStrip.this.eE(PagerSlidingTabStrip.this.daf.getCurrentItem(), 0);
            }
            if (PagerSlidingTabStrip.this.dad != null) {
                PagerSlidingTabStrip.this.dad.onPageScrollStateChanged(i);
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            PagerSlidingTabStrip.this.setSelectItem(i);
            if (PagerSlidingTabStrip.this.dad != null) {
                PagerSlidingTabStrip.this.dad.onPageSelected(i);
            }
        }
    }

    public void setSelectItem(int i) {
        if (this.dae != null) {
            this.nYR = i;
            for (int i2 = 0; i2 < this.dae.getChildCount(); i2++) {
                if (i2 == i) {
                    RelativeLayout relativeLayout = (RelativeLayout) this.dae.getChildAt(i);
                    relativeLayout.setSelected(true);
                    TextView textView = (TextView) relativeLayout.getChildAt(0);
                    textView.setTypeface(this.das, this.nZf);
                    textView.setTextColor(this.nZd);
                    textView.setTextSize(0, this.nZc);
                    if (this.nZi != -1) {
                        textView.setBackgroundResource(this.nZi);
                    }
                    if (this.daf.getAdapter() instanceof b) {
                        textView.setCompoundDrawablesWithIntrinsicBounds(0, ((b) this.daf.getAdapter()).MH(i), 0, 0);
                    }
                } else {
                    RelativeLayout relativeLayout2 = (RelativeLayout) this.dae.getChildAt(i2);
                    relativeLayout2.setSelected(false);
                    TextView textView2 = (TextView) relativeLayout2.getChildAt(0);
                    textView2.setTextColor(this.tabTextColor);
                    textView2.setBackgroundResource(0);
                    textView2.setTextSize(0, this.tabTextSize);
                    textView2.setTypeface(this.das, this.dat);
                    if (this.daf.getAdapter() instanceof b) {
                        textView2.setCompoundDrawablesWithIntrinsicBounds(0, ((b) this.daf.getAdapter()).kF(i2), 0, 0);
                    }
                }
            }
        }
    }

    public void setTabTextSelectColor(@ColorInt int i) {
        this.nZd = i;
        invalidate();
    }

    public void setIndicatorColor(int i) {
        this.nYU = i;
        invalidate();
    }

    public void setIndicatorColorResource(int i) {
        this.nYU = getResources().getColor(i);
        invalidate();
    }

    public int getIndicatorColor() {
        return this.nYU;
    }

    public void setIndicatorHeight(int i) {
        this.indicatorHeight = i;
        invalidate();
    }

    public void setIndicatorWidth(int i) {
        this.dar = i;
        invalidate();
    }

    public int getIndicatorHeight() {
        return this.indicatorHeight;
    }

    public int getIndicatorWidth() {
        return this.dar;
    }

    public void setUnderlineColor(int i) {
        this.nEB = i;
        invalidate();
    }

    public void setUnderlineColorResource(int i) {
        this.nEB = getResources().getColor(i);
        invalidate();
    }

    public int getUnderlineColor() {
        return this.nEB;
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
        this.dck = i;
        invalidate();
    }

    public int getUnderlineHeight() {
        return this.dck;
    }

    public void setDividerPadding(int i) {
        this.dividerPadding = i;
        invalidate();
    }

    public int getDividerPadding() {
        return this.dividerPadding;
    }

    public void setScrollOffset(int i) {
        this.dam = i;
        invalidate();
    }

    public int getScrollOffset() {
        return this.dam;
    }

    public void setShouldExpand(boolean z) {
        this.daj = z;
        requestLayout();
    }

    public boolean getShouldExpand() {
        return this.daj;
    }

    public void setAllCaps(boolean z) {
        this.nYV = z;
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
        this.das = typeface;
        this.dat = i;
        updateTabStyles();
    }

    public void setSelectedTypeface(Typeface typeface, int i) {
        this.das = typeface;
        this.nZf = i;
        updateTabStyles();
    }

    public void setTabBackground(int i) {
        this.dav = i;
    }

    public int getTabBackground() {
        return this.dav;
    }

    public void setTabPaddingLeftRight(int i) {
        this.tabPadding = i;
        updateTabStyles();
    }

    public int getTabPaddingLeftRight() {
        return this.tabPadding;
    }

    public void setIconPadding(int i) {
        this.nZb = i;
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.Ec = savedState.Ec;
        requestLayout();
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.Ec = this.Ec;
        return savedState;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() { // from class: tv.chushou.zues.widget.psts.PagerSlidingTabStrip.SavedState.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            /* renamed from: aW */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            /* renamed from: OF */
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };
        int Ec;

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.Ec = parcel.readInt();
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.Ec);
        }
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.nZt != null) {
            this.nZt.xf(true);
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    public void setDisallowIntercept(tv.chushou.zues.widget.psts.a aVar) {
        this.nZt = aVar;
    }
}
