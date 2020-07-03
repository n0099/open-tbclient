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
    private int YJ;
    private int dZD;
    private Typeface dZE;
    private int dZF;
    private int dZG;
    private int dZH;
    private LinearLayout.LayoutParams dZo;
    public ViewPager.OnPageChangeListener dZq;
    private LinearLayout dZr;
    private ViewPager dZs;
    private int dZt;
    private float dZu;
    private Paint dZv;
    private boolean dZw;
    private int dZy;
    private int dividerColor;
    private int dividerPadding;
    private DisplayMetrics dm;
    private int ebS;
    private int ebT;
    private int indicatorHeight;
    private Locale locale;
    private int mInterval;
    private final RectF mRectF;
    private int nTa;
    private LinearLayout.LayoutParams onF;
    private d onG;
    private int onH;
    private Paint onI;
    private boolean onJ;
    private int onK;
    private boolean onL;
    private boolean onM;
    private int onN;
    private int onO;
    private int onP;
    private int onQ;
    private int onR;
    private int onS;
    private int onT;
    private int onU;
    private int onV;
    private int onW;
    private int onX;
    private int onY;
    private boolean onZ;
    private boolean ooa;
    private int oob;
    private int ooc;
    private int ood;
    private int ooe;
    private int oof;
    private boolean oog;
    private boolean ooh;
    private boolean ooi;
    private tv.chushou.zues.widget.psts.a ooj;
    private int tabPadding;
    private int tabTextColor;
    private int tabTextSize;

    /* loaded from: classes5.dex */
    public interface a {
        void ei(int i, int i2);
    }

    /* loaded from: classes5.dex */
    public interface b {
        int Kf(int i);

        String Kg(int i);

        int Kh(int i);

        tv.chushou.zues.widget.psts.b Ki(int i);

        int mb(int i);
    }

    /* loaded from: classes5.dex */
    public interface c {
        float LZ(int i);

        int[] Ma(int i);

        tv.chushou.zues.widget.psts.b Mb(int i);
    }

    /* loaded from: classes5.dex */
    public interface e {
        tv.chushou.zues.widget.psts.b Ki(int i);

        int[] Mc(int i);
    }

    /* loaded from: classes5.dex */
    public interface f {
        int Md(int i);
    }

    /* loaded from: classes5.dex */
    public interface g {
        void Ae(int i);
    }

    /* loaded from: classes5.dex */
    public interface h {
        void Dl(int i);
    }

    public PagerSlidingTabStrip(Context context) {
        this(context, null);
    }

    public PagerSlidingTabStrip(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PagerSlidingTabStrip(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.onG = new d();
        this.YJ = 0;
        this.onH = 0;
        this.dZu = 0.0f;
        this.onJ = false;
        this.onK = -10066330;
        this.nTa = 436207616;
        this.dividerColor = 436207616;
        this.dZw = true;
        this.onL = false;
        this.dZy = 52;
        this.indicatorHeight = 3;
        this.dZD = 0;
        this.onM = true;
        this.ebS = 1;
        this.dividerPadding = 12;
        this.onN = 0;
        this.tabPadding = 24;
        this.onO = 0;
        this.onP = 0;
        this.onQ = 0;
        this.ebT = 1;
        this.onR = 0;
        this.tabTextSize = 15;
        this.onS = this.tabTextSize;
        this.tabTextColor = -10066330;
        this.onT = -10066330;
        this.onU = 13;
        this.dZE = null;
        this.dZF = 0;
        this.onV = 1;
        this.dZG = 0;
        this.onW = 1;
        this.onX = 0;
        this.dZH = b.d.zues_psts_tab_background;
        this.onY = -1;
        this.onZ = true;
        this.ooa = false;
        this.oob = 3;
        this.ooe = 16;
        this.oof = 0;
        this.mInterval = 0;
        this.oog = false;
        this.ooh = false;
        this.ooi = true;
        this.mRectF = new RectF();
        setFillViewport(true);
        setWillNotDraw(false);
        this.dZr = new LinearLayout(context);
        this.dZr.setOrientation(0);
        this.dZr.setGravity(16);
        this.dm = getResources().getDisplayMetrics();
        this.ooe = (int) TypedValue.applyDimension(1, this.ooe, this.dm);
        this.dZy = (int) TypedValue.applyDimension(1, this.dZy, this.dm);
        this.indicatorHeight = (int) TypedValue.applyDimension(1, this.indicatorHeight, this.dm);
        this.dZD = (int) TypedValue.applyDimension(1, this.dZD, this.dm);
        this.ebS = (int) TypedValue.applyDimension(1, this.ebS, this.dm);
        this.dividerPadding = (int) TypedValue.applyDimension(1, this.dividerPadding, this.dm);
        this.tabPadding = (int) TypedValue.applyDimension(1, this.tabPadding, this.dm);
        this.ebT = (int) TypedValue.applyDimension(1, this.ebT, this.dm);
        this.tabTextSize = (int) TypedValue.applyDimension(2, this.tabTextSize, this.dm);
        this.oob = (int) TypedValue.applyDimension(1, this.oob, this.dm);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, ATTRS);
        this.tabTextSize = obtainStyledAttributes.getDimensionPixelSize(0, this.tabTextSize);
        this.onS = this.tabTextSize;
        this.tabTextColor = obtainStyledAttributes.getColor(1, this.tabTextColor);
        obtainStyledAttributes.recycle();
        TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, b.i.PagerSlidingTabStrip);
        this.onK = obtainStyledAttributes2.getColor(b.i.PagerSlidingTabStrip_indicatorColor, this.onK);
        this.onM = obtainStyledAttributes2.getBoolean(b.i.PagerSlidingTabStrip_indicatorRoundCap, false);
        this.nTa = obtainStyledAttributes2.getColor(b.i.PagerSlidingTabStrip_underlineColor, this.nTa);
        this.dividerColor = obtainStyledAttributes2.getColor(b.i.PagerSlidingTabStrip_dividerColor, this.dividerColor);
        this.onT = obtainStyledAttributes2.getColor(b.i.PagerSlidingTabStrip_tabTextSelectColor, this.dividerColor);
        this.indicatorHeight = obtainStyledAttributes2.getDimensionPixelSize(b.i.PagerSlidingTabStrip_indicatorHeight, this.indicatorHeight);
        this.dZD = obtainStyledAttributes2.getDimensionPixelSize(b.i.PagerSlidingTabStrip_indicatorWidth, this.dZD);
        this.ebS = obtainStyledAttributes2.getDimensionPixelSize(b.i.PagerSlidingTabStrip_underlineHeight, this.ebS);
        this.dividerPadding = obtainStyledAttributes2.getDimensionPixelSize(b.i.PagerSlidingTabStrip_psts_dividerPadding, this.dividerPadding);
        this.ooe = obtainStyledAttributes2.getDimensionPixelSize(b.i.PagerSlidingTabStrip_psts_minInterval, this.ooe);
        this.oof = obtainStyledAttributes2.getDimensionPixelSize(b.i.PagerSlidingTabStrip_center_paddingRight, 0);
        this.onN = obtainStyledAttributes2.getDimensionPixelSize(b.i.PagerSlidingTabStrip_parentPaddingLeft, this.onN);
        this.tabPadding = obtainStyledAttributes2.getDimensionPixelSize(b.i.PagerSlidingTabStrip_tabPaddingLeftRight, this.tabPadding);
        this.onO = obtainStyledAttributes2.getDimensionPixelSize(b.i.PagerSlidingTabStrip_tabPaddingTopBottom, this.onO);
        this.onP = obtainStyledAttributes2.getDimensionPixelSize(b.i.PagerSlidingTabStrip_textPaddingLeftRight, this.onP);
        this.onQ = obtainStyledAttributes2.getDimensionPixelSize(b.i.PagerSlidingTabStrip_textPaddingTopBottom, this.onQ);
        this.dZH = obtainStyledAttributes2.getResourceId(b.i.PagerSlidingTabStrip_ptabBackground, this.dZH);
        this.onY = obtainStyledAttributes2.getResourceId(b.i.PagerSlidingTabStrip_textBackground, this.onY);
        this.dZw = obtainStyledAttributes2.getBoolean(b.i.PagerSlidingTabStrip_shouldExpand, this.dZw);
        this.dZy = obtainStyledAttributes2.getDimensionPixelSize(b.i.PagerSlidingTabStrip_scrollOffset, this.dZy);
        this.onL = obtainStyledAttributes2.getBoolean(b.i.PagerSlidingTabStrip_psts_textAllCaps, this.onL);
        this.onZ = obtainStyledAttributes2.getBoolean(b.i.PagerSlidingTabStrip_psts_tabIsWeight, this.onZ);
        this.onW = obtainStyledAttributes2.getInteger(b.i.PagerSlidingTabStrip_apsts_draw_mode, 0);
        this.onX = obtainStyledAttributes2.getInteger(b.i.PagerSlidingTabStrip_apsts_layout_mode, 0);
        this.onS = obtainStyledAttributes2.getDimensionPixelSize(b.i.PagerSlidingTabStrip_tabTextSelectSize, this.tabTextSize);
        obtainStyledAttributes2.recycle();
        this.dZv = new Paint();
        this.dZv.setAntiAlias(true);
        this.dZv.setStyle(Paint.Style.FILL);
        this.onI = new Paint();
        this.onI.setAntiAlias(true);
        this.onI.setStrokeWidth(this.ebT);
        if (this.onX == 0) {
            this.dZo = new LinearLayout.LayoutParams(0, -1, 1.0f);
            this.onF = new LinearLayout.LayoutParams(0, -1, 1.0f);
            this.onF.setMargins(0, 0, 0, 0);
        } else {
            this.dZo = new LinearLayout.LayoutParams(-2, -1);
            this.onF = new LinearLayout.LayoutParams(-2, -1);
            this.onF.setMargins(0, 0, 0, 0);
        }
        if (this.locale == null) {
            this.locale = getResources().getConfiguration().locale;
        }
        this.dZr.setPadding(this.onN, this.dZr.getPaddingTop(), this.dZr.getPaddingRight(), this.dZr.getPaddingBottom());
        this.dZr.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        addView(this.dZr);
    }

    public void setControlWidth(int i) {
        this.ooc = i;
    }

    /* loaded from: classes5.dex */
    public class NewAdapter extends FragmentStatePagerAdapter implements h {
        private List<String> mDatas;
        private g ool;

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
        public void Dl(int i) {
            if (this.ool != null) {
                this.ool.Ae(i);
            }
        }
    }

    public boolean c(ViewPager viewPager) {
        return a(viewPager, false);
    }

    public boolean a(ViewPager viewPager, boolean z) {
        this.dZs = viewPager;
        if (viewPager.getAdapter() == null) {
            throw new IllegalStateException("ViewPager does not have adapter instance.");
        }
        if (!z) {
            viewPager.addOnPageChangeListener(this.onG);
        }
        notifyDataSetChanged();
        return this.ooa;
    }

    public void setViewpageSmoothScroll(boolean z) {
        this.ooi = z;
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.dZq = onPageChangeListener;
    }

    public void notifyDataSetChanged() {
        tv.chushou.zues.widget.psts.b bVar;
        int[] iArr;
        this.ood = 0;
        this.ooa = false;
        this.mInterval = this.ooe;
        this.dZr.removeAllViews();
        this.dZt = this.dZs.getAdapter().getCount();
        for (int i = 0; i < this.dZt; i++) {
            if (this.dZs.getAdapter() instanceof b) {
                a(i, ((b) this.dZs.getAdapter()).mb(i), ((b) this.dZs.getAdapter()).Kg(i), ((b) this.dZs.getAdapter()).Ki(i), ((b) this.dZs.getAdapter()).Kh(i));
            } else {
                if (this.dZs.getAdapter() instanceof e) {
                    e eVar = (e) this.dZs.getAdapter();
                    iArr = eVar.Mc(i);
                    bVar = eVar.Ki(i);
                } else {
                    bVar = null;
                    iArr = null;
                }
                a(i, this.dZs.getAdapter().getPageTitle(i).toString(), iArr, bVar, this.dZs.getAdapter() instanceof f ? ((f) this.dZs.getAdapter()).Md(i) : 0);
            }
        }
        if (this.onX != 0) {
            if (this.ooc == 0) {
                this.ooc = tv.chushou.zues.utils.a.gx(getContext()).x;
            }
            this.ooc -= this.dZr.getPaddingLeft();
            int i2 = (this.ooc - this.ood) / (this.dZt + 1);
            if (this.onX == 1) {
                if (this.mInterval < i2) {
                    this.mInterval = i2;
                } else {
                    this.ooa = true;
                }
                this.dZo.setMargins(this.mInterval, 0, 0, 0);
            } else if (this.onX == 2) {
                if (this.mInterval < (this.ooc - this.ood) / (this.dZt + 1)) {
                    this.dZr.setGravity(17);
                    this.dZr.setPadding(0, this.dZr.getPaddingTop(), this.oof, this.dZr.getPaddingBottom());
                } else {
                    this.ooa = true;
                }
                this.dZo.setMargins(this.mInterval, 0, 0, 0);
            } else if (this.onX == 3) {
                if (this.mInterval >= i2) {
                    this.ooa = true;
                }
                this.dZo.setMargins(this.mInterval, 0, 0, 0);
            }
        }
        updateTabStyles();
        this.onJ = false;
        getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: tv.chushou.zues.widget.psts.PagerSlidingTabStrip.1
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            @SuppressLint({"NewApi"})
            public void onGlobalLayout() {
                if (Build.VERSION.SDK_INT < 16) {
                    PagerSlidingTabStrip.this.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                } else {
                    PagerSlidingTabStrip.this.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                }
                if (PagerSlidingTabStrip.this.dZs != null) {
                    PagerSlidingTabStrip.this.YJ = PagerSlidingTabStrip.this.dZs.getCurrentItem();
                    PagerSlidingTabStrip.this.eh(PagerSlidingTabStrip.this.onH, 0);
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
        layoutParams.addRule(this.onU);
        textView.setLayoutParams(layoutParams);
        textView.setPadding(this.onP, this.onQ, this.onP, this.onQ);
        textView.setCompoundDrawablePadding(getContext().getResources().getDimensionPixelSize(b.c.zues_psts_text_draw_padding));
        textView.setCompoundDrawablesWithIntrinsicBounds(0, 0, i2, 0);
        relativeLayout.setOnClickListener(new View.OnClickListener() { // from class: tv.chushou.zues.widget.psts.PagerSlidingTabStrip.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int i3 = PagerSlidingTabStrip.this.YJ;
                boolean eh = PagerSlidingTabStrip.this.eh(i, 0);
                PagerSlidingTabStrip.this.dZs.setCurrentItem(i, PagerSlidingTabStrip.this.ooi);
                if (PagerSlidingTabStrip.this.ooh) {
                    if (!eh && (PagerSlidingTabStrip.this.dZs.getAdapter() instanceof h)) {
                        ((h) PagerSlidingTabStrip.this.dZs.getAdapter()).Dl(i);
                    }
                } else if (eh && (PagerSlidingTabStrip.this.dZs.getAdapter() instanceof h)) {
                    ((h) PagerSlidingTabStrip.this.dZs.getAdapter()).Dl(i);
                }
                if (PagerSlidingTabStrip.this.dZs.getAdapter() instanceof a) {
                    ((a) PagerSlidingTabStrip.this.dZs.getAdapter()).ei(i, i3);
                }
                PagerSlidingTabStrip.this.YJ = i;
                if (PagerSlidingTabStrip.this.ooh) {
                    PagerSlidingTabStrip.this.dZu = 0.0f;
                    PagerSlidingTabStrip.this.onH = i;
                    PagerSlidingTabStrip.this.setSelectItem(i);
                    PagerSlidingTabStrip.this.eh(i, PagerSlidingTabStrip.this.dZr.getChildAt(i).getWidth() * 0);
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
        textView2.setTextColor(resources.getColor(b.C0934b.zues_white));
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
        this.dZr.addView(relativeLayout);
        if (this.onX != 0) {
            Rect rect = new Rect();
            textView.getPaint().getTextBounds(str, 0, str.length(), rect);
            this.ood = rect.width() + this.oob + (this.onP * 2) + this.ood;
        }
    }

    public void setTagRightImg(int i, @DrawableRes int i2) {
        TextView textView = (TextView) ((RelativeLayout) this.dZr.getChildAt(i)).findViewById(b.e.zues_psts_tab_tag);
        if (textView != null) {
            textView.setCompoundDrawablesWithIntrinsicBounds(0, 0, i2, 0);
        }
    }

    public void setTagText(int i, String str) {
        TextView textView = (TextView) ((RelativeLayout) this.dZr.getChildAt(i)).findViewById(b.e.zues_psts_tab_tag);
        if (textView != null) {
            textView.setText(str);
        }
    }

    public void bM(int i, String str) {
        RelativeLayout relativeLayout = (RelativeLayout) this.dZr.getChildAt(i);
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

    public void LW(int i) {
        RelativeLayout relativeLayout = (RelativeLayout) this.dZr.getChildAt(i);
        View childAt = relativeLayout.getChildAt(relativeLayout.getChildCount() - 3);
        if (childAt != null) {
            childAt.setVisibility(8);
        }
    }

    public void LX(int i) {
        RelativeLayout relativeLayout;
        View childAt;
        if (this.dZr != null && (relativeLayout = (RelativeLayout) this.dZr.getChildAt(i)) != null && (childAt = relativeLayout.getChildAt(relativeLayout.getChildCount() - 1)) != null) {
            ((ImageView) childAt).setVisibility(0);
        }
    }

    public void LY(int i) {
        RelativeLayout relativeLayout;
        View childAt;
        if (this.dZr != null && (relativeLayout = (RelativeLayout) this.dZr.getChildAt(i)) != null && (childAt = relativeLayout.getChildAt(relativeLayout.getChildCount() - 1)) != null) {
            ((ImageView) childAt).setVisibility(8);
        }
    }

    private void a(final int i, int i2, String str, tv.chushou.zues.widget.psts.b bVar, int i3) {
        RelativeLayout relativeLayout = new RelativeLayout(getContext());
        relativeLayout.setOnClickListener(new View.OnClickListener() { // from class: tv.chushou.zues.widget.psts.PagerSlidingTabStrip.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int i4 = PagerSlidingTabStrip.this.YJ;
                boolean eh = PagerSlidingTabStrip.this.eh(i, 0);
                PagerSlidingTabStrip.this.dZs.setCurrentItem(i, PagerSlidingTabStrip.this.ooi);
                if (eh && (PagerSlidingTabStrip.this.dZs.getAdapter() instanceof h)) {
                    ((h) PagerSlidingTabStrip.this.dZs.getAdapter()).Dl(i);
                }
                if (PagerSlidingTabStrip.this.dZs.getAdapter() instanceof a) {
                    ((a) PagerSlidingTabStrip.this.dZs.getAdapter()).ei(i, i4);
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
        if (this.dZs.getAdapter() instanceof c) {
            c cVar = (c) this.dZs.getAdapter();
            for (int i4 : cVar.Ma(i)) {
                layoutParams.addRule(Integer.valueOf(i4).intValue());
            }
            tv.chushou.zues.widget.psts.b Mb = cVar.Mb(i);
            if (Mb != null) {
                layoutParams.setMargins(Mb.mLeft, Mb.mTop, Mb.mRight, Mb.mBottom);
            }
        }
        textView.setLayoutParams(layoutParams);
        if (i2 != 0) {
            textView.setCompoundDrawablesWithIntrinsicBounds(0, i2, 0, 0);
            textView.setCompoundDrawablePadding(this.onR);
        }
        Resources resources = getContext().getResources();
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, resources.getDimensionPixelSize(b.c.zues_psts_red_text_dot_size));
        layoutParams2.addRule(11);
        layoutParams2.topMargin = (int) tv.chushou.zues.utils.a.a(1, 2.0f, getContext());
        TextView textView2 = new TextView(getContext());
        textView2.setBackgroundResource(b.d.zues_psts_text_red_dot);
        textView2.setTextColor(resources.getColor(b.C0934b.zues_white));
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
        this.dZr.addView(relativeLayout);
    }

    private void updateTabStyles() {
        for (int i = 0; i < this.dZt; i++) {
            View childAt = this.dZr.getChildAt(i);
            if (i != 0) {
                childAt.setLayoutParams(this.dZo);
            } else {
                childAt.setLayoutParams(this.onF);
            }
            setMyTabLayoutParams(childAt);
            childAt.setBackgroundResource(this.dZH);
            if (this.dZw) {
                childAt.setPadding(0, 0, 0, 0);
            } else {
                childAt.setPadding(this.tabPadding, this.onO, this.tabPadding, this.onO);
            }
            if (childAt instanceof RelativeLayout) {
                TextView textView = (TextView) ((RelativeLayout) childAt).getChildAt(0);
                textView.setTextSize(0, this.tabTextSize);
                textView.setTypeface(this.dZE, this.dZF);
                textView.setTextColor(this.tabTextColor);
                if (this.onL) {
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

    public boolean dXf() {
        c cVar;
        if (this.dZs != null && this.dZs.getAdapter() != null && (this.dZs.getAdapter() instanceof c) && (cVar = (c) this.dZs.getAdapter()) != null) {
            for (int i = 0; i < this.dZt; i++) {
                float LZ = cVar.LZ(i);
                if (LZ != 0.0f) {
                    if (LZ == 0.0f) {
                        LZ = 1.0f;
                    }
                    this.dZr.getChildAt(i).setLayoutParams(new LinearLayout.LayoutParams(0, -1, LZ));
                } else {
                    if (i != 0) {
                        this.dZr.getChildAt(i).setLayoutParams(this.dZo);
                    } else {
                        this.dZr.getChildAt(i).setLayoutParams(this.onF);
                    }
                    setMyTabLayoutParams(this.dZr.getChildAt(i));
                }
            }
        }
        return false;
    }

    @Override // android.widget.HorizontalScrollView, android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (!this.dZw || View.MeasureSpec.getMode(i) == 0) {
            dXf();
            return;
        }
        int measuredWidth = getMeasuredWidth();
        int i3 = 0;
        for (int i4 = 0; i4 < this.dZt; i4++) {
            i3 += this.dZr.getChildAt(i4).getMeasuredWidth();
        }
        if (!this.onJ && i3 > 0 && measuredWidth > 0) {
            if (i3 <= measuredWidth) {
                for (int i5 = 0; i5 < this.dZt; i5++) {
                    if (i5 != 0) {
                        this.dZr.getChildAt(i5).setLayoutParams(this.dZo);
                    } else {
                        this.dZr.getChildAt(i5).setLayoutParams(this.onF);
                    }
                    setMyTabLayoutParams(this.dZr.getChildAt(i5));
                }
            }
            this.onJ = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean eh(int i, int i2) {
        if (this.dZt == 0) {
            return false;
        }
        int left = this.dZr.getChildAt(i).getLeft() + i2;
        if (i > 0 || i2 > 0) {
            left -= this.dZy;
        }
        int i3 = left - this.mInterval;
        if (i3 != this.dZG) {
            this.dZG = i3;
            scrollTo(i3, 0);
            return false;
        }
        return true;
    }

    public void setTabDrawMode(int i) {
        this.onW = i;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (!isInEditMode() && this.dZt != 0) {
            if (this.onW == 0) {
                ar(canvas);
            } else {
                as(canvas);
            }
        }
    }

    private void ar(Canvas canvas) {
        int height = getHeight();
        this.dZv.setColor(this.onK);
        View childAt = this.dZr.getChildAt(this.YJ);
        float left = childAt.getLeft();
        float right = childAt.getRight();
        if (this.dZu > 0.0f && this.YJ < this.dZt - 1) {
            View childAt2 = this.dZr.getChildAt(this.YJ + 1);
            left = (left * (1.0f - this.dZu)) + (childAt2.getLeft() * this.dZu);
            right = (childAt2.getRight() * this.dZu) + ((1.0f - this.dZu) * right);
        }
        if (this.dZD > 0) {
            float f2 = ((right - left) - this.dZD) / 2.0f;
            this.mRectF.set(left + f2, height - this.indicatorHeight, f2 + left + this.dZD, height);
            if (this.onM) {
                canvas.drawRoundRect(this.mRectF, this.indicatorHeight / 2, this.indicatorHeight / 2, this.dZv);
            } else {
                canvas.drawRect(this.mRectF, this.dZv);
            }
        } else {
            canvas.drawRect(left, height - this.indicatorHeight, right, height, this.dZv);
        }
        this.dZv.setColor(this.nTa);
        canvas.drawRect(0.0f, height - this.ebS, this.dZr.getWidth(), height, this.dZv);
        this.onI.setColor(this.dividerColor);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.dZt - 1) {
                View childAt3 = this.dZr.getChildAt(i2);
                canvas.drawLine(childAt3.getRight(), this.dividerPadding, childAt3.getRight(), height - this.dividerPadding, this.onI);
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    private void as(Canvas canvas) {
        float f2;
        float f3;
        float f4;
        int height = getHeight();
        this.dZv.setColor(this.nTa);
        canvas.drawRect(0.0f, height - this.ebS, this.dZr.getWidth(), height, this.dZv);
        this.dZv.setColor(this.onK);
        View childAt = this.dZr.getChildAt(this.YJ);
        float left = childAt.getLeft();
        View childAt2 = ((RelativeLayout) childAt).getChildAt(0);
        float left2 = childAt2.getLeft();
        float right = childAt2.getRight();
        if (this.dZu <= 0.0f || this.YJ >= this.dZt - 1) {
            f2 = right;
            f3 = left2;
            f4 = left;
        } else {
            View childAt3 = this.dZr.getChildAt(this.YJ + 1);
            float left3 = (left * (1.0f - this.dZu)) + (childAt3.getLeft() * this.dZu);
            View childAt4 = ((RelativeLayout) childAt3).getChildAt(0);
            f3 = (childAt4.getLeft() * this.dZu) + (left2 * (1.0f - this.dZu));
            f2 = (childAt4.getRight() * this.dZu) + (right * (1.0f - this.dZu));
            f4 = left3;
        }
        if (this.dZD > 0) {
            float f5 = ((f2 - f3) - this.dZD) / 2.0f;
            this.mRectF.set(f4 + f3 + f5, height - this.indicatorHeight, f5 + f3 + f4 + this.dZD, height);
            if (this.onM) {
                canvas.drawRoundRect(this.mRectF, this.indicatorHeight / 2, this.indicatorHeight / 2, this.dZv);
            } else {
                canvas.drawRect(this.mRectF, this.dZv);
            }
        } else {
            canvas.drawRect(f3 + f4, height - this.indicatorHeight, f4 + f2, height, this.dZv);
        }
        this.onI.setColor(this.dividerColor);
        this.dZv.setColor(this.nTa);
        for (int i = 0; i < this.dZt; i++) {
            View childAt5 = this.dZr.getChildAt(i);
            if (i < this.dZt - 1) {
                canvas.drawLine(childAt5.getRight(), this.dividerPadding, childAt5.getRight(), height - this.dividerPadding, this.onI);
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
            PagerSlidingTabStrip.this.YJ = i;
            PagerSlidingTabStrip.this.dZu = f;
            if (PagerSlidingTabStrip.this.dZr != null) {
                PagerSlidingTabStrip.this.eh(i, (int) (PagerSlidingTabStrip.this.dZr.getChildAt(i).getWidth() * f));
            }
            PagerSlidingTabStrip.this.invalidate();
            if (PagerSlidingTabStrip.this.dZq != null) {
                PagerSlidingTabStrip.this.dZq.onPageScrolled(i, f, i2);
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            if (i == 0) {
                PagerSlidingTabStrip.this.eh(PagerSlidingTabStrip.this.dZs.getCurrentItem(), 0);
            }
            if (PagerSlidingTabStrip.this.dZq != null) {
                PagerSlidingTabStrip.this.dZq.onPageScrollStateChanged(i);
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            PagerSlidingTabStrip.this.setSelectItem(i);
            if (PagerSlidingTabStrip.this.dZq != null) {
                PagerSlidingTabStrip.this.dZq.onPageSelected(i);
            }
        }
    }

    public void setSelectItem(int i) {
        if (this.dZr != null) {
            this.onH = i;
            for (int i2 = 0; i2 < this.dZr.getChildCount(); i2++) {
                if (i2 == i) {
                    RelativeLayout relativeLayout = (RelativeLayout) this.dZr.getChildAt(i);
                    relativeLayout.setSelected(true);
                    TextView textView = (TextView) relativeLayout.getChildAt(0);
                    textView.setTypeface(this.dZE, this.onV);
                    textView.setTextColor(this.onT);
                    textView.setTextSize(0, this.onS);
                    if (this.onY != -1) {
                        textView.setBackgroundResource(this.onY);
                    }
                    if (this.dZs.getAdapter() instanceof b) {
                        textView.setCompoundDrawablesWithIntrinsicBounds(0, ((b) this.dZs.getAdapter()).Kf(i), 0, 0);
                    }
                } else {
                    RelativeLayout relativeLayout2 = (RelativeLayout) this.dZr.getChildAt(i2);
                    relativeLayout2.setSelected(false);
                    TextView textView2 = (TextView) relativeLayout2.getChildAt(0);
                    textView2.setTextColor(this.tabTextColor);
                    textView2.setBackgroundResource(0);
                    textView2.setTextSize(0, this.tabTextSize);
                    textView2.setTypeface(this.dZE, this.dZF);
                    if (this.dZs.getAdapter() instanceof b) {
                        textView2.setCompoundDrawablesWithIntrinsicBounds(0, ((b) this.dZs.getAdapter()).mb(i2), 0, 0);
                    }
                }
            }
        }
    }

    public void setTabTextSelectColor(@ColorInt int i) {
        this.onT = i;
        invalidate();
    }

    public void setIndicatorColor(int i) {
        this.onK = i;
        invalidate();
    }

    public void setIndicatorColorResource(int i) {
        this.onK = getResources().getColor(i);
        invalidate();
    }

    public int getIndicatorColor() {
        return this.onK;
    }

    public void setIndicatorHeight(int i) {
        this.indicatorHeight = i;
        invalidate();
    }

    public void setIndicatorWidth(int i) {
        this.dZD = i;
        invalidate();
    }

    public int getIndicatorHeight() {
        return this.indicatorHeight;
    }

    public int getIndicatorWidth() {
        return this.dZD;
    }

    public void setUnderlineColor(int i) {
        this.nTa = i;
        invalidate();
    }

    public void setUnderlineColorResource(int i) {
        this.nTa = getResources().getColor(i);
        invalidate();
    }

    public int getUnderlineColor() {
        return this.nTa;
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
        this.ebS = i;
        invalidate();
    }

    public int getUnderlineHeight() {
        return this.ebS;
    }

    public void setDividerPadding(int i) {
        this.dividerPadding = i;
        invalidate();
    }

    public int getDividerPadding() {
        return this.dividerPadding;
    }

    public void setScrollOffset(int i) {
        this.dZy = i;
        invalidate();
    }

    public int getScrollOffset() {
        return this.dZy;
    }

    public void setShouldExpand(boolean z) {
        this.dZw = z;
        requestLayout();
    }

    public boolean getShouldExpand() {
        return this.dZw;
    }

    public void setAllCaps(boolean z) {
        this.onL = z;
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
        this.dZE = typeface;
        this.dZF = i;
        updateTabStyles();
    }

    public void setSelectedTypeface(Typeface typeface, int i) {
        this.dZE = typeface;
        this.onV = i;
        updateTabStyles();
    }

    public void setTabBackground(int i) {
        this.dZH = i;
    }

    public int getTabBackground() {
        return this.dZH;
    }

    public void setTabPaddingLeftRight(int i) {
        this.tabPadding = i;
        updateTabStyles();
    }

    public int getTabPaddingLeftRight() {
        return this.tabPadding;
    }

    public void setIconPadding(int i) {
        this.onR = i;
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.YJ = savedState.YJ;
        requestLayout();
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.YJ = this.YJ;
        return savedState;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() { // from class: tv.chushou.zues.widget.psts.PagerSlidingTabStrip.SavedState.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            /* renamed from: aq */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            /* renamed from: Me */
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };
        int YJ;

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.YJ = parcel.readInt();
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.YJ);
        }
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.ooj != null) {
            this.ooj.xP(true);
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    public void setDisallowIntercept(tv.chushou.zues.widget.psts.a aVar) {
        this.ooj = aVar;
    }
}
