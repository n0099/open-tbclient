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
    private int XP;
    private Typeface dEA;
    private int dEB;
    private int dEC;
    private int dED;
    private LinearLayout.LayoutParams dEk;
    public ViewPager.OnPageChangeListener dEm;
    private LinearLayout dEn;
    private ViewPager dEo;
    private int dEp;
    private float dEq;
    private Paint dEr;
    private boolean dEs;
    private int dEu;
    private int dEz;
    private int dGr;
    private int dGs;
    private int dividerColor;
    private int dividerPadding;
    private DisplayMetrics dm;
    private int indicatorHeight;
    private Locale locale;
    private int mInterval;
    private final RectF mRectF;
    private int nbb;
    private LinearLayout.LayoutParams nvK;
    private d nvL;
    private int nvM;
    private Paint nvN;
    private boolean nvO;
    private int nvP;
    private boolean nvQ;
    private boolean nvR;
    private int nvS;
    private int nvT;
    private int nvU;
    private int nvV;
    private int nvW;
    private int nvX;
    private int nvY;
    private int nvZ;
    private int nwa;
    private int nwb;
    private int nwc;
    private int nwd;
    private boolean nwe;
    private boolean nwf;
    private int nwg;
    private int nwh;
    private int nwi;
    private int nwj;
    private int nwk;
    private boolean nwl;
    private boolean nwm;
    private boolean nwn;
    private tv.chushou.zues.widget.psts.a nwo;
    private int tabPadding;
    private int tabTextColor;
    private int tabTextSize;

    /* loaded from: classes5.dex */
    public interface a {
        void dU(int i, int i2);
    }

    /* loaded from: classes5.dex */
    public interface b {
        int Il(int i);

        String Im(int i);

        int In(int i);

        tv.chushou.zues.widget.psts.b Io(int i);

        int lg(int i);
    }

    /* loaded from: classes5.dex */
    public interface c {
        float Kg(int i);

        int[] Kh(int i);

        tv.chushou.zues.widget.psts.b Ki(int i);
    }

    /* loaded from: classes5.dex */
    public interface e {
        tv.chushou.zues.widget.psts.b Io(int i);

        int[] Kj(int i);
    }

    /* loaded from: classes5.dex */
    public interface f {
        int Kk(int i);
    }

    /* loaded from: classes5.dex */
    public interface g {
        void yI(int i);
    }

    /* loaded from: classes5.dex */
    public interface h {
        void Bx(int i);
    }

    public PagerSlidingTabStrip(Context context) {
        this(context, null);
    }

    public PagerSlidingTabStrip(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PagerSlidingTabStrip(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.nvL = new d();
        this.XP = 0;
        this.nvM = 0;
        this.dEq = 0.0f;
        this.nvO = false;
        this.nvP = -10066330;
        this.nbb = 436207616;
        this.dividerColor = 436207616;
        this.dEs = true;
        this.nvQ = false;
        this.dEu = 52;
        this.indicatorHeight = 3;
        this.dEz = 0;
        this.nvR = true;
        this.dGr = 1;
        this.dividerPadding = 12;
        this.nvS = 0;
        this.tabPadding = 24;
        this.nvT = 0;
        this.nvU = 0;
        this.nvV = 0;
        this.dGs = 1;
        this.nvW = 0;
        this.tabTextSize = 15;
        this.nvX = this.tabTextSize;
        this.tabTextColor = -10066330;
        this.nvY = -10066330;
        this.nvZ = 13;
        this.dEA = null;
        this.dEB = 0;
        this.nwa = 1;
        this.dEC = 0;
        this.nwb = 1;
        this.nwc = 0;
        this.dED = b.d.zues_psts_tab_background;
        this.nwd = -1;
        this.nwe = true;
        this.nwf = false;
        this.nwg = 3;
        this.nwj = 16;
        this.nwk = 0;
        this.mInterval = 0;
        this.nwl = false;
        this.nwm = false;
        this.nwn = true;
        this.mRectF = new RectF();
        setFillViewport(true);
        setWillNotDraw(false);
        this.dEn = new LinearLayout(context);
        this.dEn.setOrientation(0);
        this.dEn.setGravity(16);
        this.dm = getResources().getDisplayMetrics();
        this.nwj = (int) TypedValue.applyDimension(1, this.nwj, this.dm);
        this.dEu = (int) TypedValue.applyDimension(1, this.dEu, this.dm);
        this.indicatorHeight = (int) TypedValue.applyDimension(1, this.indicatorHeight, this.dm);
        this.dEz = (int) TypedValue.applyDimension(1, this.dEz, this.dm);
        this.dGr = (int) TypedValue.applyDimension(1, this.dGr, this.dm);
        this.dividerPadding = (int) TypedValue.applyDimension(1, this.dividerPadding, this.dm);
        this.tabPadding = (int) TypedValue.applyDimension(1, this.tabPadding, this.dm);
        this.dGs = (int) TypedValue.applyDimension(1, this.dGs, this.dm);
        this.tabTextSize = (int) TypedValue.applyDimension(2, this.tabTextSize, this.dm);
        this.nwg = (int) TypedValue.applyDimension(1, this.nwg, this.dm);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, ATTRS);
        this.tabTextSize = obtainStyledAttributes.getDimensionPixelSize(0, this.tabTextSize);
        this.nvX = this.tabTextSize;
        this.tabTextColor = obtainStyledAttributes.getColor(1, this.tabTextColor);
        obtainStyledAttributes.recycle();
        TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, b.i.PagerSlidingTabStrip);
        this.nvP = obtainStyledAttributes2.getColor(b.i.PagerSlidingTabStrip_indicatorColor, this.nvP);
        this.nvR = obtainStyledAttributes2.getBoolean(b.i.PagerSlidingTabStrip_indicatorRoundCap, false);
        this.nbb = obtainStyledAttributes2.getColor(b.i.PagerSlidingTabStrip_underlineColor, this.nbb);
        this.dividerColor = obtainStyledAttributes2.getColor(b.i.PagerSlidingTabStrip_dividerColor, this.dividerColor);
        this.nvY = obtainStyledAttributes2.getColor(b.i.PagerSlidingTabStrip_tabTextSelectColor, this.dividerColor);
        this.indicatorHeight = obtainStyledAttributes2.getDimensionPixelSize(b.i.PagerSlidingTabStrip_indicatorHeight, this.indicatorHeight);
        this.dEz = obtainStyledAttributes2.getDimensionPixelSize(b.i.PagerSlidingTabStrip_indicatorWidth, this.dEz);
        this.dGr = obtainStyledAttributes2.getDimensionPixelSize(b.i.PagerSlidingTabStrip_underlineHeight, this.dGr);
        this.dividerPadding = obtainStyledAttributes2.getDimensionPixelSize(b.i.PagerSlidingTabStrip_psts_dividerPadding, this.dividerPadding);
        this.nwj = obtainStyledAttributes2.getDimensionPixelSize(b.i.PagerSlidingTabStrip_psts_minInterval, this.nwj);
        this.nwk = obtainStyledAttributes2.getDimensionPixelSize(b.i.PagerSlidingTabStrip_center_paddingRight, 0);
        this.nvS = obtainStyledAttributes2.getDimensionPixelSize(b.i.PagerSlidingTabStrip_parentPaddingLeft, this.nvS);
        this.tabPadding = obtainStyledAttributes2.getDimensionPixelSize(b.i.PagerSlidingTabStrip_tabPaddingLeftRight, this.tabPadding);
        this.nvT = obtainStyledAttributes2.getDimensionPixelSize(b.i.PagerSlidingTabStrip_tabPaddingTopBottom, this.nvT);
        this.nvU = obtainStyledAttributes2.getDimensionPixelSize(b.i.PagerSlidingTabStrip_textPaddingLeftRight, this.nvU);
        this.nvV = obtainStyledAttributes2.getDimensionPixelSize(b.i.PagerSlidingTabStrip_textPaddingTopBottom, this.nvV);
        this.dED = obtainStyledAttributes2.getResourceId(b.i.PagerSlidingTabStrip_ptabBackground, this.dED);
        this.nwd = obtainStyledAttributes2.getResourceId(b.i.PagerSlidingTabStrip_textBackground, this.nwd);
        this.dEs = obtainStyledAttributes2.getBoolean(b.i.PagerSlidingTabStrip_shouldExpand, this.dEs);
        this.dEu = obtainStyledAttributes2.getDimensionPixelSize(b.i.PagerSlidingTabStrip_scrollOffset, this.dEu);
        this.nvQ = obtainStyledAttributes2.getBoolean(b.i.PagerSlidingTabStrip_psts_textAllCaps, this.nvQ);
        this.nwe = obtainStyledAttributes2.getBoolean(b.i.PagerSlidingTabStrip_psts_tabIsWeight, this.nwe);
        this.nwb = obtainStyledAttributes2.getInteger(b.i.PagerSlidingTabStrip_apsts_draw_mode, 0);
        this.nwc = obtainStyledAttributes2.getInteger(b.i.PagerSlidingTabStrip_apsts_layout_mode, 0);
        this.nvX = obtainStyledAttributes2.getDimensionPixelSize(b.i.PagerSlidingTabStrip_tabTextSelectSize, this.tabTextSize);
        obtainStyledAttributes2.recycle();
        this.dEr = new Paint();
        this.dEr.setAntiAlias(true);
        this.dEr.setStyle(Paint.Style.FILL);
        this.nvN = new Paint();
        this.nvN.setAntiAlias(true);
        this.nvN.setStrokeWidth(this.dGs);
        if (this.nwc == 0) {
            this.dEk = new LinearLayout.LayoutParams(0, -1, 1.0f);
            this.nvK = new LinearLayout.LayoutParams(0, -1, 1.0f);
            this.nvK.setMargins(0, 0, 0, 0);
        } else {
            this.dEk = new LinearLayout.LayoutParams(-2, -1);
            this.nvK = new LinearLayout.LayoutParams(-2, -1);
            this.nvK.setMargins(0, 0, 0, 0);
        }
        if (this.locale == null) {
            this.locale = getResources().getConfiguration().locale;
        }
        this.dEn.setPadding(this.nvS, this.dEn.getPaddingTop(), this.dEn.getPaddingRight(), this.dEn.getPaddingBottom());
        this.dEn.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        addView(this.dEn);
    }

    public void setControlWidth(int i) {
        this.nwh = i;
    }

    /* loaded from: classes5.dex */
    public class NewAdapter extends FragmentStatePagerAdapter implements h {
        private List<String> mDatas;
        private g nwq;

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
        public void Bx(int i) {
            if (this.nwq != null) {
                this.nwq.yI(i);
            }
        }
    }

    public boolean c(ViewPager viewPager) {
        return a(viewPager, false);
    }

    public boolean a(ViewPager viewPager, boolean z) {
        this.dEo = viewPager;
        if (viewPager.getAdapter() == null) {
            throw new IllegalStateException("ViewPager does not have adapter instance.");
        }
        if (!z) {
            viewPager.addOnPageChangeListener(this.nvL);
        }
        notifyDataSetChanged();
        return this.nwf;
    }

    public void setViewpageSmoothScroll(boolean z) {
        this.nwn = z;
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.dEm = onPageChangeListener;
    }

    public void notifyDataSetChanged() {
        tv.chushou.zues.widget.psts.b bVar;
        int[] iArr;
        this.nwi = 0;
        this.nwf = false;
        this.mInterval = this.nwj;
        this.dEn.removeAllViews();
        this.dEp = this.dEo.getAdapter().getCount();
        for (int i = 0; i < this.dEp; i++) {
            if (this.dEo.getAdapter() instanceof b) {
                a(i, ((b) this.dEo.getAdapter()).lg(i), ((b) this.dEo.getAdapter()).Im(i), ((b) this.dEo.getAdapter()).Io(i), ((b) this.dEo.getAdapter()).In(i));
            } else {
                if (this.dEo.getAdapter() instanceof e) {
                    e eVar = (e) this.dEo.getAdapter();
                    iArr = eVar.Kj(i);
                    bVar = eVar.Io(i);
                } else {
                    bVar = null;
                    iArr = null;
                }
                a(i, this.dEo.getAdapter().getPageTitle(i).toString(), iArr, bVar, this.dEo.getAdapter() instanceof f ? ((f) this.dEo.getAdapter()).Kk(i) : 0);
            }
        }
        if (this.nwc != 0) {
            if (this.nwh == 0) {
                this.nwh = tv.chushou.zues.utils.a.fV(getContext()).x;
            }
            this.nwh -= this.dEn.getPaddingLeft();
            int i2 = (this.nwh - this.nwi) / (this.dEp + 1);
            if (this.nwc == 1) {
                if (this.mInterval < i2) {
                    this.mInterval = i2;
                } else {
                    this.nwf = true;
                }
                this.dEk.setMargins(this.mInterval, 0, 0, 0);
            } else if (this.nwc == 2) {
                if (this.mInterval < (this.nwh - this.nwi) / (this.dEp + 1)) {
                    this.dEn.setGravity(17);
                    this.dEn.setPadding(0, this.dEn.getPaddingTop(), this.nwk, this.dEn.getPaddingBottom());
                } else {
                    this.nwf = true;
                }
                this.dEk.setMargins(this.mInterval, 0, 0, 0);
            } else if (this.nwc == 3) {
                if (this.mInterval >= i2) {
                    this.nwf = true;
                }
                this.dEk.setMargins(this.mInterval, 0, 0, 0);
            }
        }
        updateTabStyles();
        this.nvO = false;
        getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: tv.chushou.zues.widget.psts.PagerSlidingTabStrip.1
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            @SuppressLint({"NewApi"})
            public void onGlobalLayout() {
                if (Build.VERSION.SDK_INT < 16) {
                    PagerSlidingTabStrip.this.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                } else {
                    PagerSlidingTabStrip.this.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                }
                if (PagerSlidingTabStrip.this.dEo != null) {
                    PagerSlidingTabStrip.this.XP = PagerSlidingTabStrip.this.dEo.getCurrentItem();
                    PagerSlidingTabStrip.this.dT(PagerSlidingTabStrip.this.nvM, 0);
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
        layoutParams.addRule(this.nvZ);
        textView.setLayoutParams(layoutParams);
        textView.setPadding(this.nvU, this.nvV, this.nvU, this.nvV);
        textView.setCompoundDrawablePadding(getContext().getResources().getDimensionPixelSize(b.c.zues_psts_text_draw_padding));
        textView.setCompoundDrawablesWithIntrinsicBounds(0, 0, i2, 0);
        relativeLayout.setOnClickListener(new View.OnClickListener() { // from class: tv.chushou.zues.widget.psts.PagerSlidingTabStrip.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int i3 = PagerSlidingTabStrip.this.XP;
                boolean dT = PagerSlidingTabStrip.this.dT(i, 0);
                PagerSlidingTabStrip.this.dEo.setCurrentItem(i, PagerSlidingTabStrip.this.nwn);
                if (PagerSlidingTabStrip.this.nwm) {
                    if (!dT && (PagerSlidingTabStrip.this.dEo.getAdapter() instanceof h)) {
                        ((h) PagerSlidingTabStrip.this.dEo.getAdapter()).Bx(i);
                    }
                } else if (dT && (PagerSlidingTabStrip.this.dEo.getAdapter() instanceof h)) {
                    ((h) PagerSlidingTabStrip.this.dEo.getAdapter()).Bx(i);
                }
                if (PagerSlidingTabStrip.this.dEo.getAdapter() instanceof a) {
                    ((a) PagerSlidingTabStrip.this.dEo.getAdapter()).dU(i, i3);
                }
                PagerSlidingTabStrip.this.XP = i;
                if (PagerSlidingTabStrip.this.nwm) {
                    PagerSlidingTabStrip.this.dEq = 0.0f;
                    PagerSlidingTabStrip.this.nvM = i;
                    PagerSlidingTabStrip.this.setSelectItem(i);
                    PagerSlidingTabStrip.this.dT(i, PagerSlidingTabStrip.this.dEn.getChildAt(i).getWidth() * 0);
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
        textView2.setTextColor(resources.getColor(b.C0852b.zues_white));
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
        this.dEn.addView(relativeLayout);
        if (this.nwc != 0) {
            Rect rect = new Rect();
            textView.getPaint().getTextBounds(str, 0, str.length(), rect);
            this.nwi = rect.width() + this.nwg + (this.nvU * 2) + this.nwi;
        }
    }

    public void setTagRightImg(int i, @DrawableRes int i2) {
        TextView textView = (TextView) ((RelativeLayout) this.dEn.getChildAt(i)).findViewById(b.e.zues_psts_tab_tag);
        if (textView != null) {
            textView.setCompoundDrawablesWithIntrinsicBounds(0, 0, i2, 0);
        }
    }

    public void setTagText(int i, String str) {
        TextView textView = (TextView) ((RelativeLayout) this.dEn.getChildAt(i)).findViewById(b.e.zues_psts_tab_tag);
        if (textView != null) {
            textView.setText(str);
        }
    }

    public void bA(int i, String str) {
        RelativeLayout relativeLayout = (RelativeLayout) this.dEn.getChildAt(i);
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

    public void Kd(int i) {
        RelativeLayout relativeLayout = (RelativeLayout) this.dEn.getChildAt(i);
        View childAt = relativeLayout.getChildAt(relativeLayout.getChildCount() - 3);
        if (childAt != null) {
            childAt.setVisibility(8);
        }
    }

    public void Ke(int i) {
        RelativeLayout relativeLayout;
        View childAt;
        if (this.dEn != null && (relativeLayout = (RelativeLayout) this.dEn.getChildAt(i)) != null && (childAt = relativeLayout.getChildAt(relativeLayout.getChildCount() - 1)) != null) {
            ((ImageView) childAt).setVisibility(0);
        }
    }

    public void Kf(int i) {
        RelativeLayout relativeLayout;
        View childAt;
        if (this.dEn != null && (relativeLayout = (RelativeLayout) this.dEn.getChildAt(i)) != null && (childAt = relativeLayout.getChildAt(relativeLayout.getChildCount() - 1)) != null) {
            ((ImageView) childAt).setVisibility(8);
        }
    }

    private void a(final int i, int i2, String str, tv.chushou.zues.widget.psts.b bVar, int i3) {
        RelativeLayout relativeLayout = new RelativeLayout(getContext());
        relativeLayout.setOnClickListener(new View.OnClickListener() { // from class: tv.chushou.zues.widget.psts.PagerSlidingTabStrip.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int i4 = PagerSlidingTabStrip.this.XP;
                boolean dT = PagerSlidingTabStrip.this.dT(i, 0);
                PagerSlidingTabStrip.this.dEo.setCurrentItem(i, PagerSlidingTabStrip.this.nwn);
                if (dT && (PagerSlidingTabStrip.this.dEo.getAdapter() instanceof h)) {
                    ((h) PagerSlidingTabStrip.this.dEo.getAdapter()).Bx(i);
                }
                if (PagerSlidingTabStrip.this.dEo.getAdapter() instanceof a) {
                    ((a) PagerSlidingTabStrip.this.dEo.getAdapter()).dU(i, i4);
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
        if (this.dEo.getAdapter() instanceof c) {
            c cVar = (c) this.dEo.getAdapter();
            for (int i4 : cVar.Kh(i)) {
                layoutParams.addRule(Integer.valueOf(i4).intValue());
            }
            tv.chushou.zues.widget.psts.b Ki = cVar.Ki(i);
            if (Ki != null) {
                layoutParams.setMargins(Ki.mLeft, Ki.mTop, Ki.mRight, Ki.mBottom);
            }
        }
        textView.setLayoutParams(layoutParams);
        if (i2 != 0) {
            textView.setCompoundDrawablesWithIntrinsicBounds(0, i2, 0, 0);
            textView.setCompoundDrawablePadding(this.nvW);
        }
        Resources resources = getContext().getResources();
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, resources.getDimensionPixelSize(b.c.zues_psts_red_text_dot_size));
        layoutParams2.addRule(11);
        layoutParams2.topMargin = (int) tv.chushou.zues.utils.a.a(1, 2.0f, getContext());
        TextView textView2 = new TextView(getContext());
        textView2.setBackgroundResource(b.d.zues_psts_text_red_dot);
        textView2.setTextColor(resources.getColor(b.C0852b.zues_white));
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
        this.dEn.addView(relativeLayout);
    }

    private void updateTabStyles() {
        for (int i = 0; i < this.dEp; i++) {
            View childAt = this.dEn.getChildAt(i);
            if (i != 0) {
                childAt.setLayoutParams(this.dEk);
            } else {
                childAt.setLayoutParams(this.nvK);
            }
            setMyTabLayoutParams(childAt);
            childAt.setBackgroundResource(this.dED);
            if (this.dEs) {
                childAt.setPadding(0, 0, 0, 0);
            } else {
                childAt.setPadding(this.tabPadding, this.nvT, this.tabPadding, this.nvT);
            }
            if (childAt instanceof RelativeLayout) {
                TextView textView = (TextView) ((RelativeLayout) childAt).getChildAt(0);
                textView.setTextSize(0, this.tabTextSize);
                textView.setTypeface(this.dEA, this.dEB);
                textView.setTextColor(this.tabTextColor);
                if (this.nvQ) {
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

    public boolean dKq() {
        c cVar;
        if (this.dEo != null && this.dEo.getAdapter() != null && (this.dEo.getAdapter() instanceof c) && (cVar = (c) this.dEo.getAdapter()) != null) {
            for (int i = 0; i < this.dEp; i++) {
                float Kg = cVar.Kg(i);
                if (Kg != 0.0f) {
                    if (Kg == 0.0f) {
                        Kg = 1.0f;
                    }
                    this.dEn.getChildAt(i).setLayoutParams(new LinearLayout.LayoutParams(0, -1, Kg));
                } else {
                    if (i != 0) {
                        this.dEn.getChildAt(i).setLayoutParams(this.dEk);
                    } else {
                        this.dEn.getChildAt(i).setLayoutParams(this.nvK);
                    }
                    setMyTabLayoutParams(this.dEn.getChildAt(i));
                }
            }
        }
        return false;
    }

    @Override // android.widget.HorizontalScrollView, android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (!this.dEs || View.MeasureSpec.getMode(i) == 0) {
            dKq();
            return;
        }
        int measuredWidth = getMeasuredWidth();
        int i3 = 0;
        for (int i4 = 0; i4 < this.dEp; i4++) {
            i3 += this.dEn.getChildAt(i4).getMeasuredWidth();
        }
        if (!this.nvO && i3 > 0 && measuredWidth > 0) {
            if (i3 <= measuredWidth) {
                for (int i5 = 0; i5 < this.dEp; i5++) {
                    if (i5 != 0) {
                        this.dEn.getChildAt(i5).setLayoutParams(this.dEk);
                    } else {
                        this.dEn.getChildAt(i5).setLayoutParams(this.nvK);
                    }
                    setMyTabLayoutParams(this.dEn.getChildAt(i5));
                }
            }
            this.nvO = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean dT(int i, int i2) {
        if (this.dEp == 0) {
            return false;
        }
        int left = this.dEn.getChildAt(i).getLeft() + i2;
        if (i > 0 || i2 > 0) {
            left -= this.dEu;
        }
        int i3 = left - this.mInterval;
        if (i3 != this.dEC) {
            this.dEC = i3;
            scrollTo(i3, 0);
            return false;
        }
        return true;
    }

    public void setTabDrawMode(int i) {
        this.nwb = i;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (!isInEditMode() && this.dEp != 0) {
            if (this.nwb == 0) {
                ak(canvas);
            } else {
                al(canvas);
            }
        }
    }

    private void ak(Canvas canvas) {
        int height = getHeight();
        this.dEr.setColor(this.nvP);
        View childAt = this.dEn.getChildAt(this.XP);
        float left = childAt.getLeft();
        float right = childAt.getRight();
        if (this.dEq > 0.0f && this.XP < this.dEp - 1) {
            View childAt2 = this.dEn.getChildAt(this.XP + 1);
            left = (left * (1.0f - this.dEq)) + (childAt2.getLeft() * this.dEq);
            right = (childAt2.getRight() * this.dEq) + ((1.0f - this.dEq) * right);
        }
        if (this.dEz > 0) {
            float f2 = ((right - left) - this.dEz) / 2.0f;
            this.mRectF.set(left + f2, height - this.indicatorHeight, f2 + left + this.dEz, height);
            if (this.nvR) {
                canvas.drawRoundRect(this.mRectF, this.indicatorHeight / 2, this.indicatorHeight / 2, this.dEr);
            } else {
                canvas.drawRect(this.mRectF, this.dEr);
            }
        } else {
            canvas.drawRect(left, height - this.indicatorHeight, right, height, this.dEr);
        }
        this.dEr.setColor(this.nbb);
        canvas.drawRect(0.0f, height - this.dGr, this.dEn.getWidth(), height, this.dEr);
        this.nvN.setColor(this.dividerColor);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.dEp - 1) {
                View childAt3 = this.dEn.getChildAt(i2);
                canvas.drawLine(childAt3.getRight(), this.dividerPadding, childAt3.getRight(), height - this.dividerPadding, this.nvN);
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    private void al(Canvas canvas) {
        float f2;
        float f3;
        float f4;
        int height = getHeight();
        this.dEr.setColor(this.nbb);
        canvas.drawRect(0.0f, height - this.dGr, this.dEn.getWidth(), height, this.dEr);
        this.dEr.setColor(this.nvP);
        View childAt = this.dEn.getChildAt(this.XP);
        float left = childAt.getLeft();
        View childAt2 = ((RelativeLayout) childAt).getChildAt(0);
        float left2 = childAt2.getLeft();
        float right = childAt2.getRight();
        if (this.dEq <= 0.0f || this.XP >= this.dEp - 1) {
            f2 = right;
            f3 = left2;
            f4 = left;
        } else {
            View childAt3 = this.dEn.getChildAt(this.XP + 1);
            float left3 = (left * (1.0f - this.dEq)) + (childAt3.getLeft() * this.dEq);
            View childAt4 = ((RelativeLayout) childAt3).getChildAt(0);
            f3 = (childAt4.getLeft() * this.dEq) + (left2 * (1.0f - this.dEq));
            f2 = (childAt4.getRight() * this.dEq) + (right * (1.0f - this.dEq));
            f4 = left3;
        }
        if (this.dEz > 0) {
            float f5 = ((f2 - f3) - this.dEz) / 2.0f;
            this.mRectF.set(f4 + f3 + f5, height - this.indicatorHeight, f5 + f3 + f4 + this.dEz, height);
            if (this.nvR) {
                canvas.drawRoundRect(this.mRectF, this.indicatorHeight / 2, this.indicatorHeight / 2, this.dEr);
            } else {
                canvas.drawRect(this.mRectF, this.dEr);
            }
        } else {
            canvas.drawRect(f3 + f4, height - this.indicatorHeight, f4 + f2, height, this.dEr);
        }
        this.nvN.setColor(this.dividerColor);
        this.dEr.setColor(this.nbb);
        for (int i = 0; i < this.dEp; i++) {
            View childAt5 = this.dEn.getChildAt(i);
            if (i < this.dEp - 1) {
                canvas.drawLine(childAt5.getRight(), this.dividerPadding, childAt5.getRight(), height - this.dividerPadding, this.nvN);
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
            PagerSlidingTabStrip.this.XP = i;
            PagerSlidingTabStrip.this.dEq = f;
            if (PagerSlidingTabStrip.this.dEn != null) {
                PagerSlidingTabStrip.this.dT(i, (int) (PagerSlidingTabStrip.this.dEn.getChildAt(i).getWidth() * f));
            }
            PagerSlidingTabStrip.this.invalidate();
            if (PagerSlidingTabStrip.this.dEm != null) {
                PagerSlidingTabStrip.this.dEm.onPageScrolled(i, f, i2);
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            if (i == 0) {
                PagerSlidingTabStrip.this.dT(PagerSlidingTabStrip.this.dEo.getCurrentItem(), 0);
            }
            if (PagerSlidingTabStrip.this.dEm != null) {
                PagerSlidingTabStrip.this.dEm.onPageScrollStateChanged(i);
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            PagerSlidingTabStrip.this.setSelectItem(i);
            if (PagerSlidingTabStrip.this.dEm != null) {
                PagerSlidingTabStrip.this.dEm.onPageSelected(i);
            }
        }
    }

    public void setSelectItem(int i) {
        if (this.dEn != null) {
            this.nvM = i;
            for (int i2 = 0; i2 < this.dEn.getChildCount(); i2++) {
                if (i2 == i) {
                    RelativeLayout relativeLayout = (RelativeLayout) this.dEn.getChildAt(i);
                    relativeLayout.setSelected(true);
                    TextView textView = (TextView) relativeLayout.getChildAt(0);
                    textView.setTypeface(this.dEA, this.nwa);
                    textView.setTextColor(this.nvY);
                    textView.setTextSize(0, this.nvX);
                    if (this.nwd != -1) {
                        textView.setBackgroundResource(this.nwd);
                    }
                    if (this.dEo.getAdapter() instanceof b) {
                        textView.setCompoundDrawablesWithIntrinsicBounds(0, ((b) this.dEo.getAdapter()).Il(i), 0, 0);
                    }
                } else {
                    RelativeLayout relativeLayout2 = (RelativeLayout) this.dEn.getChildAt(i2);
                    relativeLayout2.setSelected(false);
                    TextView textView2 = (TextView) relativeLayout2.getChildAt(0);
                    textView2.setTextColor(this.tabTextColor);
                    textView2.setBackgroundResource(0);
                    textView2.setTextSize(0, this.tabTextSize);
                    textView2.setTypeface(this.dEA, this.dEB);
                    if (this.dEo.getAdapter() instanceof b) {
                        textView2.setCompoundDrawablesWithIntrinsicBounds(0, ((b) this.dEo.getAdapter()).lg(i2), 0, 0);
                    }
                }
            }
        }
    }

    public void setTabTextSelectColor(@ColorInt int i) {
        this.nvY = i;
        invalidate();
    }

    public void setIndicatorColor(int i) {
        this.nvP = i;
        invalidate();
    }

    public void setIndicatorColorResource(int i) {
        this.nvP = getResources().getColor(i);
        invalidate();
    }

    public int getIndicatorColor() {
        return this.nvP;
    }

    public void setIndicatorHeight(int i) {
        this.indicatorHeight = i;
        invalidate();
    }

    public void setIndicatorWidth(int i) {
        this.dEz = i;
        invalidate();
    }

    public int getIndicatorHeight() {
        return this.indicatorHeight;
    }

    public int getIndicatorWidth() {
        return this.dEz;
    }

    public void setUnderlineColor(int i) {
        this.nbb = i;
        invalidate();
    }

    public void setUnderlineColorResource(int i) {
        this.nbb = getResources().getColor(i);
        invalidate();
    }

    public int getUnderlineColor() {
        return this.nbb;
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
        this.dGr = i;
        invalidate();
    }

    public int getUnderlineHeight() {
        return this.dGr;
    }

    public void setDividerPadding(int i) {
        this.dividerPadding = i;
        invalidate();
    }

    public int getDividerPadding() {
        return this.dividerPadding;
    }

    public void setScrollOffset(int i) {
        this.dEu = i;
        invalidate();
    }

    public int getScrollOffset() {
        return this.dEu;
    }

    public void setShouldExpand(boolean z) {
        this.dEs = z;
        requestLayout();
    }

    public boolean getShouldExpand() {
        return this.dEs;
    }

    public void setAllCaps(boolean z) {
        this.nvQ = z;
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
        this.dEA = typeface;
        this.dEB = i;
        updateTabStyles();
    }

    public void setSelectedTypeface(Typeface typeface, int i) {
        this.dEA = typeface;
        this.nwa = i;
        updateTabStyles();
    }

    public void setTabBackground(int i) {
        this.dED = i;
    }

    public int getTabBackground() {
        return this.dED;
    }

    public void setTabPaddingLeftRight(int i) {
        this.tabPadding = i;
        updateTabStyles();
    }

    public int getTabPaddingLeftRight() {
        return this.tabPadding;
    }

    public void setIconPadding(int i) {
        this.nvW = i;
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.XP = savedState.XP;
        requestLayout();
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.XP = this.XP;
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
            /* renamed from: Kl */
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };
        int XP;

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.XP = parcel.readInt();
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.XP);
        }
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.nwo != null) {
            this.nwo.wV(true);
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    public void setDisallowIntercept(tv.chushou.zues.widget.psts.a aVar) {
        this.nwo = aVar;
    }
}
