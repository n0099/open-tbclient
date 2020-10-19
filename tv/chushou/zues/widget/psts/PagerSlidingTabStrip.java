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
/* loaded from: classes6.dex */
public class PagerSlidingTabStrip extends HorizontalScrollView {
    private static final int[] ATTRS = {16842901, 16842904};
    private int ZP;
    private int dividerColor;
    private int dividerPadding;
    private int dividerWidth;
    private DisplayMetrics dm;
    private int eDA;
    private float eDB;
    private Paint eDC;
    private boolean eDD;
    private Typeface eDK;
    private int eDL;
    private int eDM;
    private int eDN;
    private LinearLayout.LayoutParams eDv;
    public ViewPager.OnPageChangeListener eDx;
    private LinearLayout eDy;
    private ViewPager eDz;
    private int indicatorColor;
    private int indicatorHeight;
    private int indicatorWidth;
    private Locale locale;
    private int mInterval;
    private final RectF mRectF;
    private int parentPaddingLeft;
    private int ppA;
    private int ppB;
    private int ppC;
    private int ppD;
    private int ppE;
    private boolean ppF;
    private boolean ppG;
    private boolean ppH;
    private tv.chushou.zues.widget.psts.a ppI;
    private LinearLayout.LayoutParams ppk;
    private d ppl;
    private int ppm;
    private Paint ppn;
    private boolean ppo;
    private boolean ppp;
    private boolean ppq;
    private int ppr;
    private int pps;
    private int ppt;
    private int ppu;
    private int ppv;
    private int ppw;
    private int ppx;
    private boolean ppy;
    private boolean ppz;
    private int scrollOffset;
    private int tabPadding;
    private int tabPaddingTopBottom;
    private int tabTextColor;
    private int tabTextSelectColor;
    private int tabTextSize;
    private int textPaddingLeftRight;
    private int textPaddingTopBottom;
    private int underlineColor;
    private int underlineHeight;

    /* loaded from: classes6.dex */
    public interface a {
        void ew(int i, int i2);
    }

    /* loaded from: classes6.dex */
    public interface b {
        int Op(int i);

        String Oq(int i);

        int Or(int i);

        tv.chushou.zues.widget.psts.b Os(int i);

        int pj(int i);
    }

    /* loaded from: classes6.dex */
    public interface c {
        float Qd(int i);

        int[] Qe(int i);

        tv.chushou.zues.widget.psts.b Qf(int i);
    }

    /* loaded from: classes6.dex */
    public interface e {
        tv.chushou.zues.widget.psts.b Os(int i);

        int[] Qg(int i);
    }

    /* loaded from: classes6.dex */
    public interface f {
        int Qh(int i);
    }

    /* loaded from: classes6.dex */
    public interface g {
        void Ed(int i);
    }

    /* loaded from: classes6.dex */
    public interface h {
        void Hj(int i);
    }

    public PagerSlidingTabStrip(Context context) {
        this(context, null);
    }

    public PagerSlidingTabStrip(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PagerSlidingTabStrip(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.ppl = new d();
        this.ZP = 0;
        this.ppm = 0;
        this.eDB = 0.0f;
        this.ppo = false;
        this.indicatorColor = -10066330;
        this.underlineColor = 436207616;
        this.dividerColor = 436207616;
        this.eDD = true;
        this.ppp = false;
        this.scrollOffset = 52;
        this.indicatorHeight = 3;
        this.indicatorWidth = 0;
        this.ppq = true;
        this.underlineHeight = 1;
        this.dividerPadding = 12;
        this.parentPaddingLeft = 0;
        this.tabPadding = 24;
        this.tabPaddingTopBottom = 0;
        this.textPaddingLeftRight = 0;
        this.textPaddingTopBottom = 0;
        this.dividerWidth = 1;
        this.ppr = 0;
        this.tabTextSize = 15;
        this.pps = this.tabTextSize;
        this.tabTextColor = -10066330;
        this.tabTextSelectColor = -10066330;
        this.ppt = 13;
        this.eDK = null;
        this.eDL = 0;
        this.ppu = 1;
        this.eDM = 0;
        this.ppv = 1;
        this.ppw = 0;
        this.eDN = b.d.zues_psts_tab_background;
        this.ppx = -1;
        this.ppy = true;
        this.ppz = false;
        this.ppA = 3;
        this.ppD = 16;
        this.ppE = 0;
        this.mInterval = 0;
        this.ppF = false;
        this.ppG = false;
        this.ppH = true;
        this.mRectF = new RectF();
        setFillViewport(true);
        setWillNotDraw(false);
        this.eDy = new LinearLayout(context);
        this.eDy.setOrientation(0);
        this.eDy.setGravity(16);
        this.dm = getResources().getDisplayMetrics();
        this.ppD = (int) TypedValue.applyDimension(1, this.ppD, this.dm);
        this.scrollOffset = (int) TypedValue.applyDimension(1, this.scrollOffset, this.dm);
        this.indicatorHeight = (int) TypedValue.applyDimension(1, this.indicatorHeight, this.dm);
        this.indicatorWidth = (int) TypedValue.applyDimension(1, this.indicatorWidth, this.dm);
        this.underlineHeight = (int) TypedValue.applyDimension(1, this.underlineHeight, this.dm);
        this.dividerPadding = (int) TypedValue.applyDimension(1, this.dividerPadding, this.dm);
        this.tabPadding = (int) TypedValue.applyDimension(1, this.tabPadding, this.dm);
        this.dividerWidth = (int) TypedValue.applyDimension(1, this.dividerWidth, this.dm);
        this.tabTextSize = (int) TypedValue.applyDimension(2, this.tabTextSize, this.dm);
        this.ppA = (int) TypedValue.applyDimension(1, this.ppA, this.dm);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, ATTRS);
        this.tabTextSize = obtainStyledAttributes.getDimensionPixelSize(0, this.tabTextSize);
        this.pps = this.tabTextSize;
        this.tabTextColor = obtainStyledAttributes.getColor(1, this.tabTextColor);
        obtainStyledAttributes.recycle();
        TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, b.i.PagerSlidingTabStrip);
        this.indicatorColor = obtainStyledAttributes2.getColor(b.i.PagerSlidingTabStrip_indicatorColor, this.indicatorColor);
        this.ppq = obtainStyledAttributes2.getBoolean(b.i.PagerSlidingTabStrip_indicatorRoundCap, false);
        this.underlineColor = obtainStyledAttributes2.getColor(b.i.PagerSlidingTabStrip_underlineColor, this.underlineColor);
        this.dividerColor = obtainStyledAttributes2.getColor(b.i.PagerSlidingTabStrip_dividerColor, this.dividerColor);
        this.tabTextSelectColor = obtainStyledAttributes2.getColor(b.i.PagerSlidingTabStrip_tabTextSelectColor, this.dividerColor);
        this.indicatorHeight = obtainStyledAttributes2.getDimensionPixelSize(b.i.PagerSlidingTabStrip_indicatorHeight, this.indicatorHeight);
        this.indicatorWidth = obtainStyledAttributes2.getDimensionPixelSize(b.i.PagerSlidingTabStrip_indicatorWidth, this.indicatorWidth);
        this.underlineHeight = obtainStyledAttributes2.getDimensionPixelSize(b.i.PagerSlidingTabStrip_underlineHeight, this.underlineHeight);
        this.dividerPadding = obtainStyledAttributes2.getDimensionPixelSize(b.i.PagerSlidingTabStrip_psts_dividerPadding, this.dividerPadding);
        this.ppD = obtainStyledAttributes2.getDimensionPixelSize(b.i.PagerSlidingTabStrip_psts_minInterval, this.ppD);
        this.ppE = obtainStyledAttributes2.getDimensionPixelSize(b.i.PagerSlidingTabStrip_center_paddingRight, 0);
        this.parentPaddingLeft = obtainStyledAttributes2.getDimensionPixelSize(b.i.PagerSlidingTabStrip_parentPaddingLeft, this.parentPaddingLeft);
        this.tabPadding = obtainStyledAttributes2.getDimensionPixelSize(b.i.PagerSlidingTabStrip_tabPaddingLeftRight, this.tabPadding);
        this.tabPaddingTopBottom = obtainStyledAttributes2.getDimensionPixelSize(b.i.PagerSlidingTabStrip_tabPaddingTopBottom, this.tabPaddingTopBottom);
        this.textPaddingLeftRight = obtainStyledAttributes2.getDimensionPixelSize(b.i.PagerSlidingTabStrip_textPaddingLeftRight, this.textPaddingLeftRight);
        this.textPaddingTopBottom = obtainStyledAttributes2.getDimensionPixelSize(b.i.PagerSlidingTabStrip_textPaddingTopBottom, this.textPaddingTopBottom);
        this.eDN = obtainStyledAttributes2.getResourceId(b.i.PagerSlidingTabStrip_ptabBackground, this.eDN);
        this.ppx = obtainStyledAttributes2.getResourceId(b.i.PagerSlidingTabStrip_textBackground, this.ppx);
        this.eDD = obtainStyledAttributes2.getBoolean(b.i.PagerSlidingTabStrip_shouldExpand, this.eDD);
        this.scrollOffset = obtainStyledAttributes2.getDimensionPixelSize(b.i.PagerSlidingTabStrip_scrollOffset, this.scrollOffset);
        this.ppp = obtainStyledAttributes2.getBoolean(b.i.PagerSlidingTabStrip_psts_textAllCaps, this.ppp);
        this.ppy = obtainStyledAttributes2.getBoolean(b.i.PagerSlidingTabStrip_psts_tabIsWeight, this.ppy);
        this.ppv = obtainStyledAttributes2.getInteger(b.i.PagerSlidingTabStrip_apsts_draw_mode, 0);
        this.ppw = obtainStyledAttributes2.getInteger(b.i.PagerSlidingTabStrip_apsts_layout_mode, 0);
        this.pps = obtainStyledAttributes2.getDimensionPixelSize(b.i.PagerSlidingTabStrip_tabTextSelectSize, this.tabTextSize);
        obtainStyledAttributes2.recycle();
        this.eDC = new Paint();
        this.eDC.setAntiAlias(true);
        this.eDC.setStyle(Paint.Style.FILL);
        this.ppn = new Paint();
        this.ppn.setAntiAlias(true);
        this.ppn.setStrokeWidth(this.dividerWidth);
        if (this.ppw == 0) {
            this.eDv = new LinearLayout.LayoutParams(0, -1, 1.0f);
            this.ppk = new LinearLayout.LayoutParams(0, -1, 1.0f);
            this.ppk.setMargins(0, 0, 0, 0);
        } else {
            this.eDv = new LinearLayout.LayoutParams(-2, -1);
            this.ppk = new LinearLayout.LayoutParams(-2, -1);
            this.ppk.setMargins(0, 0, 0, 0);
        }
        if (this.locale == null) {
            this.locale = getResources().getConfiguration().locale;
        }
        this.eDy.setPadding(this.parentPaddingLeft, this.eDy.getPaddingTop(), this.eDy.getPaddingRight(), this.eDy.getPaddingBottom());
        this.eDy.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        addView(this.eDy);
    }

    public void setControlWidth(int i) {
        this.ppB = i;
    }

    /* loaded from: classes6.dex */
    public class NewAdapter extends FragmentStatePagerAdapter implements h {
        private List<String> mDatas;
        private g ppK;

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
        public void Hj(int i) {
            if (this.ppK != null) {
                this.ppK.Ed(i);
            }
        }
    }

    public boolean c(ViewPager viewPager) {
        return a(viewPager, false);
    }

    public boolean a(ViewPager viewPager, boolean z) {
        this.eDz = viewPager;
        if (viewPager.getAdapter() == null) {
            throw new IllegalStateException("ViewPager does not have adapter instance.");
        }
        if (!z) {
            viewPager.addOnPageChangeListener(this.ppl);
        }
        notifyDataSetChanged();
        return this.ppz;
    }

    public void setViewpageSmoothScroll(boolean z) {
        this.ppH = z;
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.eDx = onPageChangeListener;
    }

    public void notifyDataSetChanged() {
        tv.chushou.zues.widget.psts.b bVar;
        int[] iArr;
        this.ppC = 0;
        this.ppz = false;
        this.mInterval = this.ppD;
        this.eDy.removeAllViews();
        this.eDA = this.eDz.getAdapter().getCount();
        for (int i = 0; i < this.eDA; i++) {
            if (this.eDz.getAdapter() instanceof b) {
                a(i, ((b) this.eDz.getAdapter()).pj(i), ((b) this.eDz.getAdapter()).Oq(i), ((b) this.eDz.getAdapter()).Os(i), ((b) this.eDz.getAdapter()).Or(i));
            } else {
                if (this.eDz.getAdapter() instanceof e) {
                    e eVar = (e) this.eDz.getAdapter();
                    iArr = eVar.Qg(i);
                    bVar = eVar.Os(i);
                } else {
                    bVar = null;
                    iArr = null;
                }
                a(i, this.eDz.getAdapter().getPageTitle(i).toString(), iArr, bVar, this.eDz.getAdapter() instanceof f ? ((f) this.eDz.getAdapter()).Qh(i) : 0);
            }
        }
        if (this.ppw != 0) {
            if (this.ppB == 0) {
                this.ppB = tv.chushou.zues.utils.a.hk(getContext()).x;
            }
            this.ppB -= this.eDy.getPaddingLeft();
            int i2 = (this.ppB - this.ppC) / (this.eDA + 1);
            if (this.ppw == 1) {
                if (this.mInterval < i2) {
                    this.mInterval = i2;
                } else {
                    this.ppz = true;
                }
                this.eDv.setMargins(this.mInterval, 0, 0, 0);
            } else if (this.ppw == 2) {
                if (this.mInterval < (this.ppB - this.ppC) / (this.eDA + 1)) {
                    this.eDy.setGravity(17);
                    this.eDy.setPadding(0, this.eDy.getPaddingTop(), this.ppE, this.eDy.getPaddingBottom());
                } else {
                    this.ppz = true;
                }
                this.eDv.setMargins(this.mInterval, 0, 0, 0);
            } else if (this.ppw == 3) {
                if (this.mInterval >= i2) {
                    this.ppz = true;
                }
                this.eDv.setMargins(this.mInterval, 0, 0, 0);
            }
        }
        updateTabStyles();
        this.ppo = false;
        getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: tv.chushou.zues.widget.psts.PagerSlidingTabStrip.1
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            @SuppressLint({"NewApi"})
            public void onGlobalLayout() {
                if (Build.VERSION.SDK_INT < 16) {
                    PagerSlidingTabStrip.this.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                } else {
                    PagerSlidingTabStrip.this.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                }
                if (PagerSlidingTabStrip.this.eDz != null) {
                    PagerSlidingTabStrip.this.ZP = PagerSlidingTabStrip.this.eDz.getCurrentItem();
                    PagerSlidingTabStrip.this.ev(PagerSlidingTabStrip.this.ppm, 0);
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
        layoutParams.addRule(this.ppt);
        textView.setLayoutParams(layoutParams);
        textView.setPadding(this.textPaddingLeftRight, this.textPaddingTopBottom, this.textPaddingLeftRight, this.textPaddingTopBottom);
        textView.setCompoundDrawablePadding(getContext().getResources().getDimensionPixelSize(b.c.zues_psts_text_draw_padding));
        textView.setCompoundDrawablesWithIntrinsicBounds(0, 0, i2, 0);
        relativeLayout.setOnClickListener(new View.OnClickListener() { // from class: tv.chushou.zues.widget.psts.PagerSlidingTabStrip.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int i3 = PagerSlidingTabStrip.this.ZP;
                boolean ev = PagerSlidingTabStrip.this.ev(i, 0);
                PagerSlidingTabStrip.this.eDz.setCurrentItem(i, PagerSlidingTabStrip.this.ppH);
                if (PagerSlidingTabStrip.this.ppG) {
                    if (!ev && (PagerSlidingTabStrip.this.eDz.getAdapter() instanceof h)) {
                        ((h) PagerSlidingTabStrip.this.eDz.getAdapter()).Hj(i);
                    }
                } else if (ev && (PagerSlidingTabStrip.this.eDz.getAdapter() instanceof h)) {
                    ((h) PagerSlidingTabStrip.this.eDz.getAdapter()).Hj(i);
                }
                if (PagerSlidingTabStrip.this.eDz.getAdapter() instanceof a) {
                    ((a) PagerSlidingTabStrip.this.eDz.getAdapter()).ew(i, i3);
                }
                PagerSlidingTabStrip.this.ZP = i;
                if (PagerSlidingTabStrip.this.ppG) {
                    PagerSlidingTabStrip.this.eDB = 0.0f;
                    PagerSlidingTabStrip.this.ppm = i;
                    PagerSlidingTabStrip.this.setSelectItem(i);
                    PagerSlidingTabStrip.this.ev(i, PagerSlidingTabStrip.this.eDy.getChildAt(i).getWidth() * 0);
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
        textView2.setTextColor(resources.getColor(b.C1023b.zues_white));
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
        this.eDy.addView(relativeLayout);
        if (this.ppw != 0) {
            Rect rect = new Rect();
            textView.getPaint().getTextBounds(str, 0, str.length(), rect);
            this.ppC = rect.width() + this.ppA + (this.textPaddingLeftRight * 2) + this.ppC;
        }
    }

    public void setTagRightImg(int i, @DrawableRes int i2) {
        TextView textView = (TextView) ((RelativeLayout) this.eDy.getChildAt(i)).findViewById(b.e.zues_psts_tab_tag);
        if (textView != null) {
            textView.setCompoundDrawablesWithIntrinsicBounds(0, 0, i2, 0);
        }
    }

    public void setTagText(int i, String str) {
        TextView textView = (TextView) ((RelativeLayout) this.eDy.getChildAt(i)).findViewById(b.e.zues_psts_tab_tag);
        if (textView != null) {
            textView.setText(str);
        }
    }

    public void bY(int i, String str) {
        RelativeLayout relativeLayout = (RelativeLayout) this.eDy.getChildAt(i);
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

    public void Qa(int i) {
        RelativeLayout relativeLayout = (RelativeLayout) this.eDy.getChildAt(i);
        View childAt = relativeLayout.getChildAt(relativeLayout.getChildCount() - 3);
        if (childAt != null) {
            childAt.setVisibility(8);
        }
    }

    public void Qb(int i) {
        RelativeLayout relativeLayout;
        View childAt;
        if (this.eDy != null && (relativeLayout = (RelativeLayout) this.eDy.getChildAt(i)) != null && (childAt = relativeLayout.getChildAt(relativeLayout.getChildCount() - 1)) != null) {
            ((ImageView) childAt).setVisibility(0);
        }
    }

    public void Qc(int i) {
        RelativeLayout relativeLayout;
        View childAt;
        if (this.eDy != null && (relativeLayout = (RelativeLayout) this.eDy.getChildAt(i)) != null && (childAt = relativeLayout.getChildAt(relativeLayout.getChildCount() - 1)) != null) {
            ((ImageView) childAt).setVisibility(8);
        }
    }

    private void a(final int i, int i2, String str, tv.chushou.zues.widget.psts.b bVar, int i3) {
        RelativeLayout relativeLayout = new RelativeLayout(getContext());
        relativeLayout.setOnClickListener(new View.OnClickListener() { // from class: tv.chushou.zues.widget.psts.PagerSlidingTabStrip.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int i4 = PagerSlidingTabStrip.this.ZP;
                boolean ev = PagerSlidingTabStrip.this.ev(i, 0);
                PagerSlidingTabStrip.this.eDz.setCurrentItem(i, PagerSlidingTabStrip.this.ppH);
                if (ev && (PagerSlidingTabStrip.this.eDz.getAdapter() instanceof h)) {
                    ((h) PagerSlidingTabStrip.this.eDz.getAdapter()).Hj(i);
                }
                if (PagerSlidingTabStrip.this.eDz.getAdapter() instanceof a) {
                    ((a) PagerSlidingTabStrip.this.eDz.getAdapter()).ew(i, i4);
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
        if (this.eDz.getAdapter() instanceof c) {
            c cVar = (c) this.eDz.getAdapter();
            for (int i4 : cVar.Qe(i)) {
                layoutParams.addRule(Integer.valueOf(i4).intValue());
            }
            tv.chushou.zues.widget.psts.b Qf = cVar.Qf(i);
            if (Qf != null) {
                layoutParams.setMargins(Qf.mLeft, Qf.mTop, Qf.mRight, Qf.mBottom);
            }
        }
        textView.setLayoutParams(layoutParams);
        if (i2 != 0) {
            textView.setCompoundDrawablesWithIntrinsicBounds(0, i2, 0, 0);
            textView.setCompoundDrawablePadding(this.ppr);
        }
        Resources resources = getContext().getResources();
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, resources.getDimensionPixelSize(b.c.zues_psts_red_text_dot_size));
        layoutParams2.addRule(11);
        layoutParams2.topMargin = (int) tv.chushou.zues.utils.a.a(1, 2.0f, getContext());
        TextView textView2 = new TextView(getContext());
        textView2.setBackgroundResource(b.d.zues_psts_text_red_dot);
        textView2.setTextColor(resources.getColor(b.C1023b.zues_white));
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
        this.eDy.addView(relativeLayout);
    }

    private void updateTabStyles() {
        for (int i = 0; i < this.eDA; i++) {
            View childAt = this.eDy.getChildAt(i);
            if (i != 0) {
                childAt.setLayoutParams(this.eDv);
            } else {
                childAt.setLayoutParams(this.ppk);
            }
            setMyTabLayoutParams(childAt);
            childAt.setBackgroundResource(this.eDN);
            if (this.eDD) {
                childAt.setPadding(0, 0, 0, 0);
            } else {
                childAt.setPadding(this.tabPadding, this.tabPaddingTopBottom, this.tabPadding, this.tabPaddingTopBottom);
            }
            if (childAt instanceof RelativeLayout) {
                TextView textView = (TextView) ((RelativeLayout) childAt).getChildAt(0);
                textView.setTextSize(0, this.tabTextSize);
                textView.setTypeface(this.eDK, this.eDL);
                textView.setTextColor(this.tabTextColor);
                if (this.ppp) {
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

    public boolean euz() {
        c cVar;
        if (this.eDz != null && this.eDz.getAdapter() != null && (this.eDz.getAdapter() instanceof c) && (cVar = (c) this.eDz.getAdapter()) != null) {
            for (int i = 0; i < this.eDA; i++) {
                float Qd = cVar.Qd(i);
                if (Qd != 0.0f) {
                    if (Qd == 0.0f) {
                        Qd = 1.0f;
                    }
                    this.eDy.getChildAt(i).setLayoutParams(new LinearLayout.LayoutParams(0, -1, Qd));
                } else {
                    if (i != 0) {
                        this.eDy.getChildAt(i).setLayoutParams(this.eDv);
                    } else {
                        this.eDy.getChildAt(i).setLayoutParams(this.ppk);
                    }
                    setMyTabLayoutParams(this.eDy.getChildAt(i));
                }
            }
        }
        return false;
    }

    @Override // android.widget.HorizontalScrollView, android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (!this.eDD || View.MeasureSpec.getMode(i) == 0) {
            euz();
            return;
        }
        int measuredWidth = getMeasuredWidth();
        int i3 = 0;
        for (int i4 = 0; i4 < this.eDA; i4++) {
            i3 += this.eDy.getChildAt(i4).getMeasuredWidth();
        }
        if (!this.ppo && i3 > 0 && measuredWidth > 0) {
            if (i3 <= measuredWidth) {
                for (int i5 = 0; i5 < this.eDA; i5++) {
                    if (i5 != 0) {
                        this.eDy.getChildAt(i5).setLayoutParams(this.eDv);
                    } else {
                        this.eDy.getChildAt(i5).setLayoutParams(this.ppk);
                    }
                    setMyTabLayoutParams(this.eDy.getChildAt(i5));
                }
            }
            this.ppo = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean ev(int i, int i2) {
        if (this.eDA == 0) {
            return false;
        }
        int left = this.eDy.getChildAt(i).getLeft() + i2;
        if (i > 0 || i2 > 0) {
            left -= this.scrollOffset;
        }
        int i3 = left - this.mInterval;
        if (i3 != this.eDM) {
            this.eDM = i3;
            scrollTo(i3, 0);
            return false;
        }
        return true;
    }

    public void setTabDrawMode(int i) {
        this.ppv = i;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (!isInEditMode() && this.eDA != 0) {
            if (this.ppv == 0) {
                ay(canvas);
            } else {
                az(canvas);
            }
        }
    }

    private void ay(Canvas canvas) {
        int height = getHeight();
        this.eDC.setColor(this.indicatorColor);
        View childAt = this.eDy.getChildAt(this.ZP);
        float left = childAt.getLeft();
        float right = childAt.getRight();
        if (this.eDB > 0.0f && this.ZP < this.eDA - 1) {
            View childAt2 = this.eDy.getChildAt(this.ZP + 1);
            left = (left * (1.0f - this.eDB)) + (childAt2.getLeft() * this.eDB);
            right = (childAt2.getRight() * this.eDB) + ((1.0f - this.eDB) * right);
        }
        if (this.indicatorWidth > 0) {
            float f2 = ((right - left) - this.indicatorWidth) / 2.0f;
            this.mRectF.set(left + f2, height - this.indicatorHeight, f2 + left + this.indicatorWidth, height);
            if (this.ppq) {
                canvas.drawRoundRect(this.mRectF, this.indicatorHeight / 2, this.indicatorHeight / 2, this.eDC);
            } else {
                canvas.drawRect(this.mRectF, this.eDC);
            }
        } else {
            canvas.drawRect(left, height - this.indicatorHeight, right, height, this.eDC);
        }
        this.eDC.setColor(this.underlineColor);
        canvas.drawRect(0.0f, height - this.underlineHeight, this.eDy.getWidth(), height, this.eDC);
        this.ppn.setColor(this.dividerColor);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.eDA - 1) {
                View childAt3 = this.eDy.getChildAt(i2);
                canvas.drawLine(childAt3.getRight(), this.dividerPadding, childAt3.getRight(), height - this.dividerPadding, this.ppn);
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    private void az(Canvas canvas) {
        float f2;
        float f3;
        float f4;
        int height = getHeight();
        this.eDC.setColor(this.underlineColor);
        canvas.drawRect(0.0f, height - this.underlineHeight, this.eDy.getWidth(), height, this.eDC);
        this.eDC.setColor(this.indicatorColor);
        View childAt = this.eDy.getChildAt(this.ZP);
        float left = childAt.getLeft();
        View childAt2 = ((RelativeLayout) childAt).getChildAt(0);
        float left2 = childAt2.getLeft();
        float right = childAt2.getRight();
        if (this.eDB <= 0.0f || this.ZP >= this.eDA - 1) {
            f2 = right;
            f3 = left2;
            f4 = left;
        } else {
            View childAt3 = this.eDy.getChildAt(this.ZP + 1);
            float left3 = (left * (1.0f - this.eDB)) + (childAt3.getLeft() * this.eDB);
            View childAt4 = ((RelativeLayout) childAt3).getChildAt(0);
            f3 = (childAt4.getLeft() * this.eDB) + (left2 * (1.0f - this.eDB));
            f2 = (childAt4.getRight() * this.eDB) + (right * (1.0f - this.eDB));
            f4 = left3;
        }
        if (this.indicatorWidth > 0) {
            float f5 = ((f2 - f3) - this.indicatorWidth) / 2.0f;
            this.mRectF.set(f4 + f3 + f5, height - this.indicatorHeight, f5 + f3 + f4 + this.indicatorWidth, height);
            if (this.ppq) {
                canvas.drawRoundRect(this.mRectF, this.indicatorHeight / 2, this.indicatorHeight / 2, this.eDC);
            } else {
                canvas.drawRect(this.mRectF, this.eDC);
            }
        } else {
            canvas.drawRect(f3 + f4, height - this.indicatorHeight, f4 + f2, height, this.eDC);
        }
        this.ppn.setColor(this.dividerColor);
        this.eDC.setColor(this.underlineColor);
        for (int i = 0; i < this.eDA; i++) {
            View childAt5 = this.eDy.getChildAt(i);
            if (i < this.eDA - 1) {
                canvas.drawLine(childAt5.getRight(), this.dividerPadding, childAt5.getRight(), height - this.dividerPadding, this.ppn);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public class d implements ViewPager.OnPageChangeListener {
        private d() {
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
            PagerSlidingTabStrip.this.ZP = i;
            PagerSlidingTabStrip.this.eDB = f;
            if (PagerSlidingTabStrip.this.eDy != null) {
                PagerSlidingTabStrip.this.ev(i, (int) (PagerSlidingTabStrip.this.eDy.getChildAt(i).getWidth() * f));
            }
            PagerSlidingTabStrip.this.invalidate();
            if (PagerSlidingTabStrip.this.eDx != null) {
                PagerSlidingTabStrip.this.eDx.onPageScrolled(i, f, i2);
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            if (i == 0) {
                PagerSlidingTabStrip.this.ev(PagerSlidingTabStrip.this.eDz.getCurrentItem(), 0);
            }
            if (PagerSlidingTabStrip.this.eDx != null) {
                PagerSlidingTabStrip.this.eDx.onPageScrollStateChanged(i);
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            PagerSlidingTabStrip.this.setSelectItem(i);
            if (PagerSlidingTabStrip.this.eDx != null) {
                PagerSlidingTabStrip.this.eDx.onPageSelected(i);
            }
        }
    }

    public void setSelectItem(int i) {
        if (this.eDy != null) {
            this.ppm = i;
            for (int i2 = 0; i2 < this.eDy.getChildCount(); i2++) {
                if (i2 == i) {
                    RelativeLayout relativeLayout = (RelativeLayout) this.eDy.getChildAt(i);
                    relativeLayout.setSelected(true);
                    TextView textView = (TextView) relativeLayout.getChildAt(0);
                    textView.setTypeface(this.eDK, this.ppu);
                    textView.setTextColor(this.tabTextSelectColor);
                    textView.setTextSize(0, this.pps);
                    if (this.ppx != -1) {
                        textView.setBackgroundResource(this.ppx);
                    }
                    if (this.eDz.getAdapter() instanceof b) {
                        textView.setCompoundDrawablesWithIntrinsicBounds(0, ((b) this.eDz.getAdapter()).Op(i), 0, 0);
                    }
                } else {
                    RelativeLayout relativeLayout2 = (RelativeLayout) this.eDy.getChildAt(i2);
                    relativeLayout2.setSelected(false);
                    TextView textView2 = (TextView) relativeLayout2.getChildAt(0);
                    textView2.setTextColor(this.tabTextColor);
                    textView2.setBackgroundResource(0);
                    textView2.setTextSize(0, this.tabTextSize);
                    textView2.setTypeface(this.eDK, this.eDL);
                    if (this.eDz.getAdapter() instanceof b) {
                        textView2.setCompoundDrawablesWithIntrinsicBounds(0, ((b) this.eDz.getAdapter()).pj(i2), 0, 0);
                    }
                }
            }
        }
    }

    public void setTabTextSelectColor(@ColorInt int i) {
        this.tabTextSelectColor = i;
        invalidate();
    }

    public void setIndicatorColor(int i) {
        this.indicatorColor = i;
        invalidate();
    }

    public void setIndicatorColorResource(int i) {
        this.indicatorColor = getResources().getColor(i);
        invalidate();
    }

    public int getIndicatorColor() {
        return this.indicatorColor;
    }

    public void setIndicatorHeight(int i) {
        this.indicatorHeight = i;
        invalidate();
    }

    public void setIndicatorWidth(int i) {
        this.indicatorWidth = i;
        invalidate();
    }

    public int getIndicatorHeight() {
        return this.indicatorHeight;
    }

    public int getIndicatorWidth() {
        return this.indicatorWidth;
    }

    public void setUnderlineColor(int i) {
        this.underlineColor = i;
        invalidate();
    }

    public void setUnderlineColorResource(int i) {
        this.underlineColor = getResources().getColor(i);
        invalidate();
    }

    public int getUnderlineColor() {
        return this.underlineColor;
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
        this.underlineHeight = i;
        invalidate();
    }

    public int getUnderlineHeight() {
        return this.underlineHeight;
    }

    public void setDividerPadding(int i) {
        this.dividerPadding = i;
        invalidate();
    }

    public int getDividerPadding() {
        return this.dividerPadding;
    }

    public void setScrollOffset(int i) {
        this.scrollOffset = i;
        invalidate();
    }

    public int getScrollOffset() {
        return this.scrollOffset;
    }

    public void setShouldExpand(boolean z) {
        this.eDD = z;
        requestLayout();
    }

    public boolean getShouldExpand() {
        return this.eDD;
    }

    public void setAllCaps(boolean z) {
        this.ppp = z;
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
        this.eDK = typeface;
        this.eDL = i;
        updateTabStyles();
    }

    public void setSelectedTypeface(Typeface typeface, int i) {
        this.eDK = typeface;
        this.ppu = i;
        updateTabStyles();
    }

    public void setTabBackground(int i) {
        this.eDN = i;
    }

    public int getTabBackground() {
        return this.eDN;
    }

    public void setTabPaddingLeftRight(int i) {
        this.tabPadding = i;
        updateTabStyles();
    }

    public int getTabPaddingLeftRight() {
        return this.tabPadding;
    }

    public void setIconPadding(int i) {
        this.ppr = i;
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.ZP = savedState.ZP;
        requestLayout();
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.ZP = this.ZP;
        return savedState;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() { // from class: tv.chushou.zues.widget.psts.PagerSlidingTabStrip.SavedState.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            /* renamed from: at */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            /* renamed from: Qi */
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };
        int ZP;

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.ZP = parcel.readInt();
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.ZP);
        }
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.ppI != null) {
            this.ppI.Ac(true);
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    public void setDisallowIntercept(tv.chushou.zues.widget.psts.a aVar) {
        this.ppI = aVar;
    }
}
