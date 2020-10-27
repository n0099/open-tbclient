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
    private int ZQ;
    private int dividerColor;
    private int dividerPadding;
    private int dividerWidth;
    private DisplayMetrics dm;
    private LinearLayout.LayoutParams eLR;
    public ViewPager.OnPageChangeListener eLT;
    private LinearLayout eLU;
    private ViewPager eLV;
    private int eLW;
    private float eLX;
    private Paint eLY;
    private boolean eLZ;
    private Typeface eMg;
    private int eMh;
    private int eMi;
    private int eMj;
    private int indicatorColor;
    private int indicatorHeight;
    private int indicatorWidth;
    private Locale locale;
    private int mInterval;
    private final RectF mRectF;
    private int parentPaddingLeft;
    private boolean qgA;
    private boolean qgB;
    private int qgC;
    private int qgD;
    private int qgE;
    private int qgF;
    private int qgG;
    private int qgH;
    private int qgI;
    private boolean qgJ;
    private boolean qgK;
    private int qgL;
    private int qgM;
    private int qgN;
    private int qgO;
    private int qgP;
    private boolean qgQ;
    private boolean qgR;
    private boolean qgS;
    private tv.chushou.zues.widget.psts.a qgT;
    private LinearLayout.LayoutParams qgv;
    private d qgw;
    private int qgx;
    private Paint qgy;
    private boolean qgz;
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
        void eE(int i, int i2);
    }

    /* loaded from: classes6.dex */
    public interface b {
        int Qg(int i);

        String Qh(int i);

        int Qi(int i);

        tv.chushou.zues.widget.psts.b Qj(int i);

        int pv(int i);
    }

    /* loaded from: classes6.dex */
    public interface c {
        float RU(int i);

        int[] RV(int i);

        tv.chushou.zues.widget.psts.b RW(int i);
    }

    /* loaded from: classes6.dex */
    public interface e {
        tv.chushou.zues.widget.psts.b Qj(int i);

        int[] RX(int i);
    }

    /* loaded from: classes6.dex */
    public interface f {
        int RY(int i);
    }

    /* loaded from: classes6.dex */
    public interface g {
        void Ew(int i);
    }

    /* loaded from: classes6.dex */
    public interface h {
        void HC(int i);
    }

    public PagerSlidingTabStrip(Context context) {
        this(context, null);
    }

    public PagerSlidingTabStrip(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PagerSlidingTabStrip(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.qgw = new d();
        this.ZQ = 0;
        this.qgx = 0;
        this.eLX = 0.0f;
        this.qgz = false;
        this.indicatorColor = -10066330;
        this.underlineColor = 436207616;
        this.dividerColor = 436207616;
        this.eLZ = true;
        this.qgA = false;
        this.scrollOffset = 52;
        this.indicatorHeight = 3;
        this.indicatorWidth = 0;
        this.qgB = true;
        this.underlineHeight = 1;
        this.dividerPadding = 12;
        this.parentPaddingLeft = 0;
        this.tabPadding = 24;
        this.tabPaddingTopBottom = 0;
        this.textPaddingLeftRight = 0;
        this.textPaddingTopBottom = 0;
        this.dividerWidth = 1;
        this.qgC = 0;
        this.tabTextSize = 15;
        this.qgD = this.tabTextSize;
        this.tabTextColor = -10066330;
        this.tabTextSelectColor = -10066330;
        this.qgE = 13;
        this.eMg = null;
        this.eMh = 0;
        this.qgF = 1;
        this.eMi = 0;
        this.qgG = 1;
        this.qgH = 0;
        this.eMj = b.d.zues_psts_tab_background;
        this.qgI = -1;
        this.qgJ = true;
        this.qgK = false;
        this.qgL = 3;
        this.qgO = 16;
        this.qgP = 0;
        this.mInterval = 0;
        this.qgQ = false;
        this.qgR = false;
        this.qgS = true;
        this.mRectF = new RectF();
        setFillViewport(true);
        setWillNotDraw(false);
        this.eLU = new LinearLayout(context);
        this.eLU.setOrientation(0);
        this.eLU.setGravity(16);
        this.dm = getResources().getDisplayMetrics();
        this.qgO = (int) TypedValue.applyDimension(1, this.qgO, this.dm);
        this.scrollOffset = (int) TypedValue.applyDimension(1, this.scrollOffset, this.dm);
        this.indicatorHeight = (int) TypedValue.applyDimension(1, this.indicatorHeight, this.dm);
        this.indicatorWidth = (int) TypedValue.applyDimension(1, this.indicatorWidth, this.dm);
        this.underlineHeight = (int) TypedValue.applyDimension(1, this.underlineHeight, this.dm);
        this.dividerPadding = (int) TypedValue.applyDimension(1, this.dividerPadding, this.dm);
        this.tabPadding = (int) TypedValue.applyDimension(1, this.tabPadding, this.dm);
        this.dividerWidth = (int) TypedValue.applyDimension(1, this.dividerWidth, this.dm);
        this.tabTextSize = (int) TypedValue.applyDimension(2, this.tabTextSize, this.dm);
        this.qgL = (int) TypedValue.applyDimension(1, this.qgL, this.dm);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, ATTRS);
        this.tabTextSize = obtainStyledAttributes.getDimensionPixelSize(0, this.tabTextSize);
        this.qgD = this.tabTextSize;
        this.tabTextColor = obtainStyledAttributes.getColor(1, this.tabTextColor);
        obtainStyledAttributes.recycle();
        TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, b.i.PagerSlidingTabStrip);
        this.indicatorColor = obtainStyledAttributes2.getColor(b.i.PagerSlidingTabStrip_indicatorColor, this.indicatorColor);
        this.qgB = obtainStyledAttributes2.getBoolean(b.i.PagerSlidingTabStrip_indicatorRoundCap, false);
        this.underlineColor = obtainStyledAttributes2.getColor(b.i.PagerSlidingTabStrip_underlineColor, this.underlineColor);
        this.dividerColor = obtainStyledAttributes2.getColor(b.i.PagerSlidingTabStrip_dividerColor, this.dividerColor);
        this.tabTextSelectColor = obtainStyledAttributes2.getColor(b.i.PagerSlidingTabStrip_tabTextSelectColor, this.dividerColor);
        this.indicatorHeight = obtainStyledAttributes2.getDimensionPixelSize(b.i.PagerSlidingTabStrip_indicatorHeight, this.indicatorHeight);
        this.indicatorWidth = obtainStyledAttributes2.getDimensionPixelSize(b.i.PagerSlidingTabStrip_indicatorWidth, this.indicatorWidth);
        this.underlineHeight = obtainStyledAttributes2.getDimensionPixelSize(b.i.PagerSlidingTabStrip_underlineHeight, this.underlineHeight);
        this.dividerPadding = obtainStyledAttributes2.getDimensionPixelSize(b.i.PagerSlidingTabStrip_psts_dividerPadding, this.dividerPadding);
        this.qgO = obtainStyledAttributes2.getDimensionPixelSize(b.i.PagerSlidingTabStrip_psts_minInterval, this.qgO);
        this.qgP = obtainStyledAttributes2.getDimensionPixelSize(b.i.PagerSlidingTabStrip_center_paddingRight, 0);
        this.parentPaddingLeft = obtainStyledAttributes2.getDimensionPixelSize(b.i.PagerSlidingTabStrip_parentPaddingLeft, this.parentPaddingLeft);
        this.tabPadding = obtainStyledAttributes2.getDimensionPixelSize(b.i.PagerSlidingTabStrip_tabPaddingLeftRight, this.tabPadding);
        this.tabPaddingTopBottom = obtainStyledAttributes2.getDimensionPixelSize(b.i.PagerSlidingTabStrip_tabPaddingTopBottom, this.tabPaddingTopBottom);
        this.textPaddingLeftRight = obtainStyledAttributes2.getDimensionPixelSize(b.i.PagerSlidingTabStrip_textPaddingLeftRight, this.textPaddingLeftRight);
        this.textPaddingTopBottom = obtainStyledAttributes2.getDimensionPixelSize(b.i.PagerSlidingTabStrip_textPaddingTopBottom, this.textPaddingTopBottom);
        this.eMj = obtainStyledAttributes2.getResourceId(b.i.PagerSlidingTabStrip_ptabBackground, this.eMj);
        this.qgI = obtainStyledAttributes2.getResourceId(b.i.PagerSlidingTabStrip_textBackground, this.qgI);
        this.eLZ = obtainStyledAttributes2.getBoolean(b.i.PagerSlidingTabStrip_shouldExpand, this.eLZ);
        this.scrollOffset = obtainStyledAttributes2.getDimensionPixelSize(b.i.PagerSlidingTabStrip_scrollOffset, this.scrollOffset);
        this.qgA = obtainStyledAttributes2.getBoolean(b.i.PagerSlidingTabStrip_psts_textAllCaps, this.qgA);
        this.qgJ = obtainStyledAttributes2.getBoolean(b.i.PagerSlidingTabStrip_psts_tabIsWeight, this.qgJ);
        this.qgG = obtainStyledAttributes2.getInteger(b.i.PagerSlidingTabStrip_apsts_draw_mode, 0);
        this.qgH = obtainStyledAttributes2.getInteger(b.i.PagerSlidingTabStrip_apsts_layout_mode, 0);
        this.qgD = obtainStyledAttributes2.getDimensionPixelSize(b.i.PagerSlidingTabStrip_tabTextSelectSize, this.tabTextSize);
        obtainStyledAttributes2.recycle();
        this.eLY = new Paint();
        this.eLY.setAntiAlias(true);
        this.eLY.setStyle(Paint.Style.FILL);
        this.qgy = new Paint();
        this.qgy.setAntiAlias(true);
        this.qgy.setStrokeWidth(this.dividerWidth);
        if (this.qgH == 0) {
            this.eLR = new LinearLayout.LayoutParams(0, -1, 1.0f);
            this.qgv = new LinearLayout.LayoutParams(0, -1, 1.0f);
            this.qgv.setMargins(0, 0, 0, 0);
        } else {
            this.eLR = new LinearLayout.LayoutParams(-2, -1);
            this.qgv = new LinearLayout.LayoutParams(-2, -1);
            this.qgv.setMargins(0, 0, 0, 0);
        }
        if (this.locale == null) {
            this.locale = getResources().getConfiguration().locale;
        }
        this.eLU.setPadding(this.parentPaddingLeft, this.eLU.getPaddingTop(), this.eLU.getPaddingRight(), this.eLU.getPaddingBottom());
        this.eLU.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        addView(this.eLU);
    }

    public void setControlWidth(int i) {
        this.qgM = i;
    }

    /* loaded from: classes6.dex */
    public class NewAdapter extends FragmentStatePagerAdapter implements h {
        private List<String> mDatas;
        private g qgV;

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
        public void HC(int i) {
            if (this.qgV != null) {
                this.qgV.Ew(i);
            }
        }
    }

    public boolean c(ViewPager viewPager) {
        return a(viewPager, false);
    }

    public boolean a(ViewPager viewPager, boolean z) {
        this.eLV = viewPager;
        if (viewPager.getAdapter() == null) {
            throw new IllegalStateException("ViewPager does not have adapter instance.");
        }
        if (!z) {
            viewPager.addOnPageChangeListener(this.qgw);
        }
        notifyDataSetChanged();
        return this.qgK;
    }

    public void setViewpageSmoothScroll(boolean z) {
        this.qgS = z;
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.eLT = onPageChangeListener;
    }

    public void notifyDataSetChanged() {
        tv.chushou.zues.widget.psts.b bVar;
        int[] iArr;
        this.qgN = 0;
        this.qgK = false;
        this.mInterval = this.qgO;
        this.eLU.removeAllViews();
        this.eLW = this.eLV.getAdapter().getCount();
        for (int i = 0; i < this.eLW; i++) {
            if (this.eLV.getAdapter() instanceof b) {
                a(i, ((b) this.eLV.getAdapter()).pv(i), ((b) this.eLV.getAdapter()).Qh(i), ((b) this.eLV.getAdapter()).Qj(i), ((b) this.eLV.getAdapter()).Qi(i));
            } else {
                if (this.eLV.getAdapter() instanceof e) {
                    e eVar = (e) this.eLV.getAdapter();
                    iArr = eVar.RX(i);
                    bVar = eVar.Qj(i);
                } else {
                    bVar = null;
                    iArr = null;
                }
                a(i, this.eLV.getAdapter().getPageTitle(i).toString(), iArr, bVar, this.eLV.getAdapter() instanceof f ? ((f) this.eLV.getAdapter()).RY(i) : 0);
            }
        }
        if (this.qgH != 0) {
            if (this.qgM == 0) {
                this.qgM = tv.chushou.zues.utils.a.hE(getContext()).x;
            }
            this.qgM -= this.eLU.getPaddingLeft();
            int i2 = (this.qgM - this.qgN) / (this.eLW + 1);
            if (this.qgH == 1) {
                if (this.mInterval < i2) {
                    this.mInterval = i2;
                } else {
                    this.qgK = true;
                }
                this.eLR.setMargins(this.mInterval, 0, 0, 0);
            } else if (this.qgH == 2) {
                if (this.mInterval < (this.qgM - this.qgN) / (this.eLW + 1)) {
                    this.eLU.setGravity(17);
                    this.eLU.setPadding(0, this.eLU.getPaddingTop(), this.qgP, this.eLU.getPaddingBottom());
                } else {
                    this.qgK = true;
                }
                this.eLR.setMargins(this.mInterval, 0, 0, 0);
            } else if (this.qgH == 3) {
                if (this.mInterval >= i2) {
                    this.qgK = true;
                }
                this.eLR.setMargins(this.mInterval, 0, 0, 0);
            }
        }
        updateTabStyles();
        this.qgz = false;
        getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: tv.chushou.zues.widget.psts.PagerSlidingTabStrip.1
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            @SuppressLint({"NewApi"})
            public void onGlobalLayout() {
                if (Build.VERSION.SDK_INT < 16) {
                    PagerSlidingTabStrip.this.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                } else {
                    PagerSlidingTabStrip.this.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                }
                if (PagerSlidingTabStrip.this.eLV != null) {
                    PagerSlidingTabStrip.this.ZQ = PagerSlidingTabStrip.this.eLV.getCurrentItem();
                    PagerSlidingTabStrip.this.eD(PagerSlidingTabStrip.this.qgx, 0);
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
        layoutParams.addRule(this.qgE);
        textView.setLayoutParams(layoutParams);
        textView.setPadding(this.textPaddingLeftRight, this.textPaddingTopBottom, this.textPaddingLeftRight, this.textPaddingTopBottom);
        textView.setCompoundDrawablePadding(getContext().getResources().getDimensionPixelSize(b.c.zues_psts_text_draw_padding));
        textView.setCompoundDrawablesWithIntrinsicBounds(0, 0, i2, 0);
        relativeLayout.setOnClickListener(new View.OnClickListener() { // from class: tv.chushou.zues.widget.psts.PagerSlidingTabStrip.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int i3 = PagerSlidingTabStrip.this.ZQ;
                boolean eD = PagerSlidingTabStrip.this.eD(i, 0);
                PagerSlidingTabStrip.this.eLV.setCurrentItem(i, PagerSlidingTabStrip.this.qgS);
                if (PagerSlidingTabStrip.this.qgR) {
                    if (!eD && (PagerSlidingTabStrip.this.eLV.getAdapter() instanceof h)) {
                        ((h) PagerSlidingTabStrip.this.eLV.getAdapter()).HC(i);
                    }
                } else if (eD && (PagerSlidingTabStrip.this.eLV.getAdapter() instanceof h)) {
                    ((h) PagerSlidingTabStrip.this.eLV.getAdapter()).HC(i);
                }
                if (PagerSlidingTabStrip.this.eLV.getAdapter() instanceof a) {
                    ((a) PagerSlidingTabStrip.this.eLV.getAdapter()).eE(i, i3);
                }
                PagerSlidingTabStrip.this.ZQ = i;
                if (PagerSlidingTabStrip.this.qgR) {
                    PagerSlidingTabStrip.this.eLX = 0.0f;
                    PagerSlidingTabStrip.this.qgx = i;
                    PagerSlidingTabStrip.this.setSelectItem(i);
                    PagerSlidingTabStrip.this.eD(i, PagerSlidingTabStrip.this.eLU.getChildAt(i).getWidth() * 0);
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
        textView2.setTextColor(resources.getColor(b.C1095b.zues_white));
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
        this.eLU.addView(relativeLayout);
        if (this.qgH != 0) {
            Rect rect = new Rect();
            textView.getPaint().getTextBounds(str, 0, str.length(), rect);
            this.qgN = rect.width() + this.qgL + (this.textPaddingLeftRight * 2) + this.qgN;
        }
    }

    public void setTagRightImg(int i, @DrawableRes int i2) {
        TextView textView = (TextView) ((RelativeLayout) this.eLU.getChildAt(i)).findViewById(b.e.zues_psts_tab_tag);
        if (textView != null) {
            textView.setCompoundDrawablesWithIntrinsicBounds(0, 0, i2, 0);
        }
    }

    public void setTagText(int i, String str) {
        TextView textView = (TextView) ((RelativeLayout) this.eLU.getChildAt(i)).findViewById(b.e.zues_psts_tab_tag);
        if (textView != null) {
            textView.setText(str);
        }
    }

    public void bZ(int i, String str) {
        RelativeLayout relativeLayout = (RelativeLayout) this.eLU.getChildAt(i);
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

    public void RR(int i) {
        RelativeLayout relativeLayout = (RelativeLayout) this.eLU.getChildAt(i);
        View childAt = relativeLayout.getChildAt(relativeLayout.getChildCount() - 3);
        if (childAt != null) {
            childAt.setVisibility(8);
        }
    }

    public void RS(int i) {
        RelativeLayout relativeLayout;
        View childAt;
        if (this.eLU != null && (relativeLayout = (RelativeLayout) this.eLU.getChildAt(i)) != null && (childAt = relativeLayout.getChildAt(relativeLayout.getChildCount() - 1)) != null) {
            ((ImageView) childAt).setVisibility(0);
        }
    }

    public void RT(int i) {
        RelativeLayout relativeLayout;
        View childAt;
        if (this.eLU != null && (relativeLayout = (RelativeLayout) this.eLU.getChildAt(i)) != null && (childAt = relativeLayout.getChildAt(relativeLayout.getChildCount() - 1)) != null) {
            ((ImageView) childAt).setVisibility(8);
        }
    }

    private void a(final int i, int i2, String str, tv.chushou.zues.widget.psts.b bVar, int i3) {
        RelativeLayout relativeLayout = new RelativeLayout(getContext());
        relativeLayout.setOnClickListener(new View.OnClickListener() { // from class: tv.chushou.zues.widget.psts.PagerSlidingTabStrip.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int i4 = PagerSlidingTabStrip.this.ZQ;
                boolean eD = PagerSlidingTabStrip.this.eD(i, 0);
                PagerSlidingTabStrip.this.eLV.setCurrentItem(i, PagerSlidingTabStrip.this.qgS);
                if (eD && (PagerSlidingTabStrip.this.eLV.getAdapter() instanceof h)) {
                    ((h) PagerSlidingTabStrip.this.eLV.getAdapter()).HC(i);
                }
                if (PagerSlidingTabStrip.this.eLV.getAdapter() instanceof a) {
                    ((a) PagerSlidingTabStrip.this.eLV.getAdapter()).eE(i, i4);
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
        if (this.eLV.getAdapter() instanceof c) {
            c cVar = (c) this.eLV.getAdapter();
            for (int i4 : cVar.RV(i)) {
                layoutParams.addRule(Integer.valueOf(i4).intValue());
            }
            tv.chushou.zues.widget.psts.b RW = cVar.RW(i);
            if (RW != null) {
                layoutParams.setMargins(RW.mLeft, RW.mTop, RW.mRight, RW.mBottom);
            }
        }
        textView.setLayoutParams(layoutParams);
        if (i2 != 0) {
            textView.setCompoundDrawablesWithIntrinsicBounds(0, i2, 0, 0);
            textView.setCompoundDrawablePadding(this.qgC);
        }
        Resources resources = getContext().getResources();
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, resources.getDimensionPixelSize(b.c.zues_psts_red_text_dot_size));
        layoutParams2.addRule(11);
        layoutParams2.topMargin = (int) tv.chushou.zues.utils.a.a(1, 2.0f, getContext());
        TextView textView2 = new TextView(getContext());
        textView2.setBackgroundResource(b.d.zues_psts_text_red_dot);
        textView2.setTextColor(resources.getColor(b.C1095b.zues_white));
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
        this.eLU.addView(relativeLayout);
    }

    private void updateTabStyles() {
        for (int i = 0; i < this.eLW; i++) {
            View childAt = this.eLU.getChildAt(i);
            if (i != 0) {
                childAt.setLayoutParams(this.eLR);
            } else {
                childAt.setLayoutParams(this.qgv);
            }
            setMyTabLayoutParams(childAt);
            childAt.setBackgroundResource(this.eMj);
            if (this.eLZ) {
                childAt.setPadding(0, 0, 0, 0);
            } else {
                childAt.setPadding(this.tabPadding, this.tabPaddingTopBottom, this.tabPadding, this.tabPaddingTopBottom);
            }
            if (childAt instanceof RelativeLayout) {
                TextView textView = (TextView) ((RelativeLayout) childAt).getChildAt(0);
                textView.setTextSize(0, this.tabTextSize);
                textView.setTypeface(this.eMg, this.eMh);
                textView.setTextColor(this.tabTextColor);
                if (this.qgA) {
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

    public boolean eEx() {
        c cVar;
        if (this.eLV != null && this.eLV.getAdapter() != null && (this.eLV.getAdapter() instanceof c) && (cVar = (c) this.eLV.getAdapter()) != null) {
            for (int i = 0; i < this.eLW; i++) {
                float RU = cVar.RU(i);
                if (RU != 0.0f) {
                    if (RU == 0.0f) {
                        RU = 1.0f;
                    }
                    this.eLU.getChildAt(i).setLayoutParams(new LinearLayout.LayoutParams(0, -1, RU));
                } else {
                    if (i != 0) {
                        this.eLU.getChildAt(i).setLayoutParams(this.eLR);
                    } else {
                        this.eLU.getChildAt(i).setLayoutParams(this.qgv);
                    }
                    setMyTabLayoutParams(this.eLU.getChildAt(i));
                }
            }
        }
        return false;
    }

    @Override // android.widget.HorizontalScrollView, android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (!this.eLZ || View.MeasureSpec.getMode(i) == 0) {
            eEx();
            return;
        }
        int measuredWidth = getMeasuredWidth();
        int i3 = 0;
        for (int i4 = 0; i4 < this.eLW; i4++) {
            i3 += this.eLU.getChildAt(i4).getMeasuredWidth();
        }
        if (!this.qgz && i3 > 0 && measuredWidth > 0) {
            if (i3 <= measuredWidth) {
                for (int i5 = 0; i5 < this.eLW; i5++) {
                    if (i5 != 0) {
                        this.eLU.getChildAt(i5).setLayoutParams(this.eLR);
                    } else {
                        this.eLU.getChildAt(i5).setLayoutParams(this.qgv);
                    }
                    setMyTabLayoutParams(this.eLU.getChildAt(i5));
                }
            }
            this.qgz = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean eD(int i, int i2) {
        if (this.eLW == 0) {
            return false;
        }
        int left = this.eLU.getChildAt(i).getLeft() + i2;
        if (i > 0 || i2 > 0) {
            left -= this.scrollOffset;
        }
        int i3 = left - this.mInterval;
        if (i3 != this.eMi) {
            this.eMi = i3;
            scrollTo(i3, 0);
            return false;
        }
        return true;
    }

    public void setTabDrawMode(int i) {
        this.qgG = i;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (!isInEditMode() && this.eLW != 0) {
            if (this.qgG == 0) {
                aA(canvas);
            } else {
                aB(canvas);
            }
        }
    }

    private void aA(Canvas canvas) {
        int height = getHeight();
        this.eLY.setColor(this.indicatorColor);
        View childAt = this.eLU.getChildAt(this.ZQ);
        float left = childAt.getLeft();
        float right = childAt.getRight();
        if (this.eLX > 0.0f && this.ZQ < this.eLW - 1) {
            View childAt2 = this.eLU.getChildAt(this.ZQ + 1);
            left = (left * (1.0f - this.eLX)) + (childAt2.getLeft() * this.eLX);
            right = (childAt2.getRight() * this.eLX) + ((1.0f - this.eLX) * right);
        }
        if (this.indicatorWidth > 0) {
            float f2 = ((right - left) - this.indicatorWidth) / 2.0f;
            this.mRectF.set(left + f2, height - this.indicatorHeight, f2 + left + this.indicatorWidth, height);
            if (this.qgB) {
                canvas.drawRoundRect(this.mRectF, this.indicatorHeight / 2, this.indicatorHeight / 2, this.eLY);
            } else {
                canvas.drawRect(this.mRectF, this.eLY);
            }
        } else {
            canvas.drawRect(left, height - this.indicatorHeight, right, height, this.eLY);
        }
        this.eLY.setColor(this.underlineColor);
        canvas.drawRect(0.0f, height - this.underlineHeight, this.eLU.getWidth(), height, this.eLY);
        this.qgy.setColor(this.dividerColor);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.eLW - 1) {
                View childAt3 = this.eLU.getChildAt(i2);
                canvas.drawLine(childAt3.getRight(), this.dividerPadding, childAt3.getRight(), height - this.dividerPadding, this.qgy);
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    private void aB(Canvas canvas) {
        float f2;
        float f3;
        float f4;
        int height = getHeight();
        this.eLY.setColor(this.underlineColor);
        canvas.drawRect(0.0f, height - this.underlineHeight, this.eLU.getWidth(), height, this.eLY);
        this.eLY.setColor(this.indicatorColor);
        View childAt = this.eLU.getChildAt(this.ZQ);
        float left = childAt.getLeft();
        View childAt2 = ((RelativeLayout) childAt).getChildAt(0);
        float left2 = childAt2.getLeft();
        float right = childAt2.getRight();
        if (this.eLX <= 0.0f || this.ZQ >= this.eLW - 1) {
            f2 = right;
            f3 = left2;
            f4 = left;
        } else {
            View childAt3 = this.eLU.getChildAt(this.ZQ + 1);
            float left3 = (left * (1.0f - this.eLX)) + (childAt3.getLeft() * this.eLX);
            View childAt4 = ((RelativeLayout) childAt3).getChildAt(0);
            f3 = (childAt4.getLeft() * this.eLX) + (left2 * (1.0f - this.eLX));
            f2 = (childAt4.getRight() * this.eLX) + (right * (1.0f - this.eLX));
            f4 = left3;
        }
        if (this.indicatorWidth > 0) {
            float f5 = ((f2 - f3) - this.indicatorWidth) / 2.0f;
            this.mRectF.set(f4 + f3 + f5, height - this.indicatorHeight, f5 + f3 + f4 + this.indicatorWidth, height);
            if (this.qgB) {
                canvas.drawRoundRect(this.mRectF, this.indicatorHeight / 2, this.indicatorHeight / 2, this.eLY);
            } else {
                canvas.drawRect(this.mRectF, this.eLY);
            }
        } else {
            canvas.drawRect(f3 + f4, height - this.indicatorHeight, f4 + f2, height, this.eLY);
        }
        this.qgy.setColor(this.dividerColor);
        this.eLY.setColor(this.underlineColor);
        for (int i = 0; i < this.eLW; i++) {
            View childAt5 = this.eLU.getChildAt(i);
            if (i < this.eLW - 1) {
                canvas.drawLine(childAt5.getRight(), this.dividerPadding, childAt5.getRight(), height - this.dividerPadding, this.qgy);
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
            PagerSlidingTabStrip.this.ZQ = i;
            PagerSlidingTabStrip.this.eLX = f;
            if (PagerSlidingTabStrip.this.eLU != null) {
                PagerSlidingTabStrip.this.eD(i, (int) (PagerSlidingTabStrip.this.eLU.getChildAt(i).getWidth() * f));
            }
            PagerSlidingTabStrip.this.invalidate();
            if (PagerSlidingTabStrip.this.eLT != null) {
                PagerSlidingTabStrip.this.eLT.onPageScrolled(i, f, i2);
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            if (i == 0) {
                PagerSlidingTabStrip.this.eD(PagerSlidingTabStrip.this.eLV.getCurrentItem(), 0);
            }
            if (PagerSlidingTabStrip.this.eLT != null) {
                PagerSlidingTabStrip.this.eLT.onPageScrollStateChanged(i);
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            PagerSlidingTabStrip.this.setSelectItem(i);
            if (PagerSlidingTabStrip.this.eLT != null) {
                PagerSlidingTabStrip.this.eLT.onPageSelected(i);
            }
        }
    }

    public void setSelectItem(int i) {
        if (this.eLU != null) {
            this.qgx = i;
            for (int i2 = 0; i2 < this.eLU.getChildCount(); i2++) {
                if (i2 == i) {
                    RelativeLayout relativeLayout = (RelativeLayout) this.eLU.getChildAt(i);
                    relativeLayout.setSelected(true);
                    TextView textView = (TextView) relativeLayout.getChildAt(0);
                    textView.setTypeface(this.eMg, this.qgF);
                    textView.setTextColor(this.tabTextSelectColor);
                    textView.setTextSize(0, this.qgD);
                    if (this.qgI != -1) {
                        textView.setBackgroundResource(this.qgI);
                    }
                    if (this.eLV.getAdapter() instanceof b) {
                        textView.setCompoundDrawablesWithIntrinsicBounds(0, ((b) this.eLV.getAdapter()).Qg(i), 0, 0);
                    }
                } else {
                    RelativeLayout relativeLayout2 = (RelativeLayout) this.eLU.getChildAt(i2);
                    relativeLayout2.setSelected(false);
                    TextView textView2 = (TextView) relativeLayout2.getChildAt(0);
                    textView2.setTextColor(this.tabTextColor);
                    textView2.setBackgroundResource(0);
                    textView2.setTextSize(0, this.tabTextSize);
                    textView2.setTypeface(this.eMg, this.eMh);
                    if (this.eLV.getAdapter() instanceof b) {
                        textView2.setCompoundDrawablesWithIntrinsicBounds(0, ((b) this.eLV.getAdapter()).pv(i2), 0, 0);
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
        this.eLZ = z;
        requestLayout();
    }

    public boolean getShouldExpand() {
        return this.eLZ;
    }

    public void setAllCaps(boolean z) {
        this.qgA = z;
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
        this.eMg = typeface;
        this.eMh = i;
        updateTabStyles();
    }

    public void setSelectedTypeface(Typeface typeface, int i) {
        this.eMg = typeface;
        this.qgF = i;
        updateTabStyles();
    }

    public void setTabBackground(int i) {
        this.eMj = i;
    }

    public int getTabBackground() {
        return this.eMj;
    }

    public void setTabPaddingLeftRight(int i) {
        this.tabPadding = i;
        updateTabStyles();
    }

    public int getTabPaddingLeftRight() {
        return this.tabPadding;
    }

    public void setIconPadding(int i) {
        this.qgC = i;
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.ZQ = savedState.ZQ;
        requestLayout();
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.ZQ = this.ZQ;
        return savedState;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() { // from class: tv.chushou.zues.widget.psts.PagerSlidingTabStrip.SavedState.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            /* renamed from: av */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            /* renamed from: RZ */
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };
        int ZQ;

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.ZQ = parcel.readInt();
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.ZQ);
        }
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.qgT != null) {
            this.qgT.Bj(true);
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    public void setDisallowIntercept(tv.chushou.zues.widget.psts.a aVar) {
        this.qgT = aVar;
    }
}
