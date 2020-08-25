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
    private int Zf;
    private int dividerColor;
    private int dividerPadding;
    private int dividerWidth;
    private DisplayMetrics dm;
    private LinearLayout.LayoutParams epb;
    public ViewPager.OnPageChangeListener epd;
    private LinearLayout epe;
    private ViewPager epf;
    private int epg;
    private float eph;
    private Paint epi;
    private boolean epj;
    private Typeface epq;
    private int epr;
    private int eps;
    private int ept;
    private int indicatorColor;
    private int indicatorHeight;
    private int indicatorWidth;
    private Locale locale;
    private int mInterval;
    private final RectF mRectF;
    private int oQA;
    private boolean oQB;
    private boolean oQC;
    private boolean oQD;
    private tv.chushou.zues.widget.psts.a oQE;
    private LinearLayout.LayoutParams oQg;
    private d oQh;
    private int oQi;
    private Paint oQj;
    private boolean oQk;
    private boolean oQl;
    private boolean oQm;
    private int oQn;
    private int oQo;
    private int oQp;
    private int oQq;
    private int oQr;
    private int oQs;
    private int oQt;
    private boolean oQu;
    private boolean oQv;
    private int oQw;
    private int oQx;
    private int oQy;
    private int oQz;
    private int parentPaddingLeft;
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
        void es(int i, int i2);
    }

    /* loaded from: classes6.dex */
    public interface b {
        int Ne(int i);

        String Nf(int i);

        int Ng(int i);

        tv.chushou.zues.widget.psts.b Nh(int i);

        int oz(int i);
    }

    /* loaded from: classes6.dex */
    public interface c {
        float OW(int i);

        int[] OX(int i);

        tv.chushou.zues.widget.psts.b OY(int i);
    }

    /* loaded from: classes6.dex */
    public interface e {
        tv.chushou.zues.widget.psts.b Nh(int i);

        int[] OZ(int i);
    }

    /* loaded from: classes6.dex */
    public interface f {
        int Pa(int i);
    }

    /* loaded from: classes6.dex */
    public interface g {
        void CW(int i);
    }

    /* loaded from: classes6.dex */
    public interface h {
        void Gc(int i);
    }

    public PagerSlidingTabStrip(Context context) {
        this(context, null);
    }

    public PagerSlidingTabStrip(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PagerSlidingTabStrip(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.oQh = new d();
        this.Zf = 0;
        this.oQi = 0;
        this.eph = 0.0f;
        this.oQk = false;
        this.indicatorColor = -10066330;
        this.underlineColor = 436207616;
        this.dividerColor = 436207616;
        this.epj = true;
        this.oQl = false;
        this.scrollOffset = 52;
        this.indicatorHeight = 3;
        this.indicatorWidth = 0;
        this.oQm = true;
        this.underlineHeight = 1;
        this.dividerPadding = 12;
        this.parentPaddingLeft = 0;
        this.tabPadding = 24;
        this.tabPaddingTopBottom = 0;
        this.textPaddingLeftRight = 0;
        this.textPaddingTopBottom = 0;
        this.dividerWidth = 1;
        this.oQn = 0;
        this.tabTextSize = 15;
        this.oQo = this.tabTextSize;
        this.tabTextColor = -10066330;
        this.tabTextSelectColor = -10066330;
        this.oQp = 13;
        this.epq = null;
        this.epr = 0;
        this.oQq = 1;
        this.eps = 0;
        this.oQr = 1;
        this.oQs = 0;
        this.ept = b.d.zues_psts_tab_background;
        this.oQt = -1;
        this.oQu = true;
        this.oQv = false;
        this.oQw = 3;
        this.oQz = 16;
        this.oQA = 0;
        this.mInterval = 0;
        this.oQB = false;
        this.oQC = false;
        this.oQD = true;
        this.mRectF = new RectF();
        setFillViewport(true);
        setWillNotDraw(false);
        this.epe = new LinearLayout(context);
        this.epe.setOrientation(0);
        this.epe.setGravity(16);
        this.dm = getResources().getDisplayMetrics();
        this.oQz = (int) TypedValue.applyDimension(1, this.oQz, this.dm);
        this.scrollOffset = (int) TypedValue.applyDimension(1, this.scrollOffset, this.dm);
        this.indicatorHeight = (int) TypedValue.applyDimension(1, this.indicatorHeight, this.dm);
        this.indicatorWidth = (int) TypedValue.applyDimension(1, this.indicatorWidth, this.dm);
        this.underlineHeight = (int) TypedValue.applyDimension(1, this.underlineHeight, this.dm);
        this.dividerPadding = (int) TypedValue.applyDimension(1, this.dividerPadding, this.dm);
        this.tabPadding = (int) TypedValue.applyDimension(1, this.tabPadding, this.dm);
        this.dividerWidth = (int) TypedValue.applyDimension(1, this.dividerWidth, this.dm);
        this.tabTextSize = (int) TypedValue.applyDimension(2, this.tabTextSize, this.dm);
        this.oQw = (int) TypedValue.applyDimension(1, this.oQw, this.dm);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, ATTRS);
        this.tabTextSize = obtainStyledAttributes.getDimensionPixelSize(0, this.tabTextSize);
        this.oQo = this.tabTextSize;
        this.tabTextColor = obtainStyledAttributes.getColor(1, this.tabTextColor);
        obtainStyledAttributes.recycle();
        TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, b.i.PagerSlidingTabStrip);
        this.indicatorColor = obtainStyledAttributes2.getColor(b.i.PagerSlidingTabStrip_indicatorColor, this.indicatorColor);
        this.oQm = obtainStyledAttributes2.getBoolean(b.i.PagerSlidingTabStrip_indicatorRoundCap, false);
        this.underlineColor = obtainStyledAttributes2.getColor(b.i.PagerSlidingTabStrip_underlineColor, this.underlineColor);
        this.dividerColor = obtainStyledAttributes2.getColor(b.i.PagerSlidingTabStrip_dividerColor, this.dividerColor);
        this.tabTextSelectColor = obtainStyledAttributes2.getColor(b.i.PagerSlidingTabStrip_tabTextSelectColor, this.dividerColor);
        this.indicatorHeight = obtainStyledAttributes2.getDimensionPixelSize(b.i.PagerSlidingTabStrip_indicatorHeight, this.indicatorHeight);
        this.indicatorWidth = obtainStyledAttributes2.getDimensionPixelSize(b.i.PagerSlidingTabStrip_indicatorWidth, this.indicatorWidth);
        this.underlineHeight = obtainStyledAttributes2.getDimensionPixelSize(b.i.PagerSlidingTabStrip_underlineHeight, this.underlineHeight);
        this.dividerPadding = obtainStyledAttributes2.getDimensionPixelSize(b.i.PagerSlidingTabStrip_psts_dividerPadding, this.dividerPadding);
        this.oQz = obtainStyledAttributes2.getDimensionPixelSize(b.i.PagerSlidingTabStrip_psts_minInterval, this.oQz);
        this.oQA = obtainStyledAttributes2.getDimensionPixelSize(b.i.PagerSlidingTabStrip_center_paddingRight, 0);
        this.parentPaddingLeft = obtainStyledAttributes2.getDimensionPixelSize(b.i.PagerSlidingTabStrip_parentPaddingLeft, this.parentPaddingLeft);
        this.tabPadding = obtainStyledAttributes2.getDimensionPixelSize(b.i.PagerSlidingTabStrip_tabPaddingLeftRight, this.tabPadding);
        this.tabPaddingTopBottom = obtainStyledAttributes2.getDimensionPixelSize(b.i.PagerSlidingTabStrip_tabPaddingTopBottom, this.tabPaddingTopBottom);
        this.textPaddingLeftRight = obtainStyledAttributes2.getDimensionPixelSize(b.i.PagerSlidingTabStrip_textPaddingLeftRight, this.textPaddingLeftRight);
        this.textPaddingTopBottom = obtainStyledAttributes2.getDimensionPixelSize(b.i.PagerSlidingTabStrip_textPaddingTopBottom, this.textPaddingTopBottom);
        this.ept = obtainStyledAttributes2.getResourceId(b.i.PagerSlidingTabStrip_ptabBackground, this.ept);
        this.oQt = obtainStyledAttributes2.getResourceId(b.i.PagerSlidingTabStrip_textBackground, this.oQt);
        this.epj = obtainStyledAttributes2.getBoolean(b.i.PagerSlidingTabStrip_shouldExpand, this.epj);
        this.scrollOffset = obtainStyledAttributes2.getDimensionPixelSize(b.i.PagerSlidingTabStrip_scrollOffset, this.scrollOffset);
        this.oQl = obtainStyledAttributes2.getBoolean(b.i.PagerSlidingTabStrip_psts_textAllCaps, this.oQl);
        this.oQu = obtainStyledAttributes2.getBoolean(b.i.PagerSlidingTabStrip_psts_tabIsWeight, this.oQu);
        this.oQr = obtainStyledAttributes2.getInteger(b.i.PagerSlidingTabStrip_apsts_draw_mode, 0);
        this.oQs = obtainStyledAttributes2.getInteger(b.i.PagerSlidingTabStrip_apsts_layout_mode, 0);
        this.oQo = obtainStyledAttributes2.getDimensionPixelSize(b.i.PagerSlidingTabStrip_tabTextSelectSize, this.tabTextSize);
        obtainStyledAttributes2.recycle();
        this.epi = new Paint();
        this.epi.setAntiAlias(true);
        this.epi.setStyle(Paint.Style.FILL);
        this.oQj = new Paint();
        this.oQj.setAntiAlias(true);
        this.oQj.setStrokeWidth(this.dividerWidth);
        if (this.oQs == 0) {
            this.epb = new LinearLayout.LayoutParams(0, -1, 1.0f);
            this.oQg = new LinearLayout.LayoutParams(0, -1, 1.0f);
            this.oQg.setMargins(0, 0, 0, 0);
        } else {
            this.epb = new LinearLayout.LayoutParams(-2, -1);
            this.oQg = new LinearLayout.LayoutParams(-2, -1);
            this.oQg.setMargins(0, 0, 0, 0);
        }
        if (this.locale == null) {
            this.locale = getResources().getConfiguration().locale;
        }
        this.epe.setPadding(this.parentPaddingLeft, this.epe.getPaddingTop(), this.epe.getPaddingRight(), this.epe.getPaddingBottom());
        this.epe.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        addView(this.epe);
    }

    public void setControlWidth(int i) {
        this.oQx = i;
    }

    /* loaded from: classes6.dex */
    public class NewAdapter extends FragmentStatePagerAdapter implements h {
        private List<String> mDatas;
        private g oQG;

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
        public void Gc(int i) {
            if (this.oQG != null) {
                this.oQG.CW(i);
            }
        }
    }

    public boolean c(ViewPager viewPager) {
        return a(viewPager, false);
    }

    public boolean a(ViewPager viewPager, boolean z) {
        this.epf = viewPager;
        if (viewPager.getAdapter() == null) {
            throw new IllegalStateException("ViewPager does not have adapter instance.");
        }
        if (!z) {
            viewPager.addOnPageChangeListener(this.oQh);
        }
        notifyDataSetChanged();
        return this.oQv;
    }

    public void setViewpageSmoothScroll(boolean z) {
        this.oQD = z;
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.epd = onPageChangeListener;
    }

    public void notifyDataSetChanged() {
        tv.chushou.zues.widget.psts.b bVar;
        int[] iArr;
        this.oQy = 0;
        this.oQv = false;
        this.mInterval = this.oQz;
        this.epe.removeAllViews();
        this.epg = this.epf.getAdapter().getCount();
        for (int i = 0; i < this.epg; i++) {
            if (this.epf.getAdapter() instanceof b) {
                a(i, ((b) this.epf.getAdapter()).oz(i), ((b) this.epf.getAdapter()).Nf(i), ((b) this.epf.getAdapter()).Nh(i), ((b) this.epf.getAdapter()).Ng(i));
            } else {
                if (this.epf.getAdapter() instanceof e) {
                    e eVar = (e) this.epf.getAdapter();
                    iArr = eVar.OZ(i);
                    bVar = eVar.Nh(i);
                } else {
                    bVar = null;
                    iArr = null;
                }
                a(i, this.epf.getAdapter().getPageTitle(i).toString(), iArr, bVar, this.epf.getAdapter() instanceof f ? ((f) this.epf.getAdapter()).Pa(i) : 0);
            }
        }
        if (this.oQs != 0) {
            if (this.oQx == 0) {
                this.oQx = tv.chushou.zues.utils.a.gX(getContext()).x;
            }
            this.oQx -= this.epe.getPaddingLeft();
            int i2 = (this.oQx - this.oQy) / (this.epg + 1);
            if (this.oQs == 1) {
                if (this.mInterval < i2) {
                    this.mInterval = i2;
                } else {
                    this.oQv = true;
                }
                this.epb.setMargins(this.mInterval, 0, 0, 0);
            } else if (this.oQs == 2) {
                if (this.mInterval < (this.oQx - this.oQy) / (this.epg + 1)) {
                    this.epe.setGravity(17);
                    this.epe.setPadding(0, this.epe.getPaddingTop(), this.oQA, this.epe.getPaddingBottom());
                } else {
                    this.oQv = true;
                }
                this.epb.setMargins(this.mInterval, 0, 0, 0);
            } else if (this.oQs == 3) {
                if (this.mInterval >= i2) {
                    this.oQv = true;
                }
                this.epb.setMargins(this.mInterval, 0, 0, 0);
            }
        }
        updateTabStyles();
        this.oQk = false;
        getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: tv.chushou.zues.widget.psts.PagerSlidingTabStrip.1
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            @SuppressLint({"NewApi"})
            public void onGlobalLayout() {
                if (Build.VERSION.SDK_INT < 16) {
                    PagerSlidingTabStrip.this.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                } else {
                    PagerSlidingTabStrip.this.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                }
                if (PagerSlidingTabStrip.this.epf != null) {
                    PagerSlidingTabStrip.this.Zf = PagerSlidingTabStrip.this.epf.getCurrentItem();
                    PagerSlidingTabStrip.this.er(PagerSlidingTabStrip.this.oQi, 0);
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
        layoutParams.addRule(this.oQp);
        textView.setLayoutParams(layoutParams);
        textView.setPadding(this.textPaddingLeftRight, this.textPaddingTopBottom, this.textPaddingLeftRight, this.textPaddingTopBottom);
        textView.setCompoundDrawablePadding(getContext().getResources().getDimensionPixelSize(b.c.zues_psts_text_draw_padding));
        textView.setCompoundDrawablesWithIntrinsicBounds(0, 0, i2, 0);
        relativeLayout.setOnClickListener(new View.OnClickListener() { // from class: tv.chushou.zues.widget.psts.PagerSlidingTabStrip.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int i3 = PagerSlidingTabStrip.this.Zf;
                boolean er = PagerSlidingTabStrip.this.er(i, 0);
                PagerSlidingTabStrip.this.epf.setCurrentItem(i, PagerSlidingTabStrip.this.oQD);
                if (PagerSlidingTabStrip.this.oQC) {
                    if (!er && (PagerSlidingTabStrip.this.epf.getAdapter() instanceof h)) {
                        ((h) PagerSlidingTabStrip.this.epf.getAdapter()).Gc(i);
                    }
                } else if (er && (PagerSlidingTabStrip.this.epf.getAdapter() instanceof h)) {
                    ((h) PagerSlidingTabStrip.this.epf.getAdapter()).Gc(i);
                }
                if (PagerSlidingTabStrip.this.epf.getAdapter() instanceof a) {
                    ((a) PagerSlidingTabStrip.this.epf.getAdapter()).es(i, i3);
                }
                PagerSlidingTabStrip.this.Zf = i;
                if (PagerSlidingTabStrip.this.oQC) {
                    PagerSlidingTabStrip.this.eph = 0.0f;
                    PagerSlidingTabStrip.this.oQi = i;
                    PagerSlidingTabStrip.this.setSelectItem(i);
                    PagerSlidingTabStrip.this.er(i, PagerSlidingTabStrip.this.epe.getChildAt(i).getWidth() * 0);
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
        textView2.setTextColor(resources.getColor(b.C1008b.zues_white));
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
        this.epe.addView(relativeLayout);
        if (this.oQs != 0) {
            Rect rect = new Rect();
            textView.getPaint().getTextBounds(str, 0, str.length(), rect);
            this.oQy = rect.width() + this.oQw + (this.textPaddingLeftRight * 2) + this.oQy;
        }
    }

    public void setTagRightImg(int i, @DrawableRes int i2) {
        TextView textView = (TextView) ((RelativeLayout) this.epe.getChildAt(i)).findViewById(b.e.zues_psts_tab_tag);
        if (textView != null) {
            textView.setCompoundDrawablesWithIntrinsicBounds(0, 0, i2, 0);
        }
    }

    public void setTagText(int i, String str) {
        TextView textView = (TextView) ((RelativeLayout) this.epe.getChildAt(i)).findViewById(b.e.zues_psts_tab_tag);
        if (textView != null) {
            textView.setText(str);
        }
    }

    public void bL(int i, String str) {
        RelativeLayout relativeLayout = (RelativeLayout) this.epe.getChildAt(i);
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

    public void OT(int i) {
        RelativeLayout relativeLayout = (RelativeLayout) this.epe.getChildAt(i);
        View childAt = relativeLayout.getChildAt(relativeLayout.getChildCount() - 3);
        if (childAt != null) {
            childAt.setVisibility(8);
        }
    }

    public void OU(int i) {
        RelativeLayout relativeLayout;
        View childAt;
        if (this.epe != null && (relativeLayout = (RelativeLayout) this.epe.getChildAt(i)) != null && (childAt = relativeLayout.getChildAt(relativeLayout.getChildCount() - 1)) != null) {
            ((ImageView) childAt).setVisibility(0);
        }
    }

    public void OV(int i) {
        RelativeLayout relativeLayout;
        View childAt;
        if (this.epe != null && (relativeLayout = (RelativeLayout) this.epe.getChildAt(i)) != null && (childAt = relativeLayout.getChildAt(relativeLayout.getChildCount() - 1)) != null) {
            ((ImageView) childAt).setVisibility(8);
        }
    }

    private void a(final int i, int i2, String str, tv.chushou.zues.widget.psts.b bVar, int i3) {
        RelativeLayout relativeLayout = new RelativeLayout(getContext());
        relativeLayout.setOnClickListener(new View.OnClickListener() { // from class: tv.chushou.zues.widget.psts.PagerSlidingTabStrip.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int i4 = PagerSlidingTabStrip.this.Zf;
                boolean er = PagerSlidingTabStrip.this.er(i, 0);
                PagerSlidingTabStrip.this.epf.setCurrentItem(i, PagerSlidingTabStrip.this.oQD);
                if (er && (PagerSlidingTabStrip.this.epf.getAdapter() instanceof h)) {
                    ((h) PagerSlidingTabStrip.this.epf.getAdapter()).Gc(i);
                }
                if (PagerSlidingTabStrip.this.epf.getAdapter() instanceof a) {
                    ((a) PagerSlidingTabStrip.this.epf.getAdapter()).es(i, i4);
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
        if (this.epf.getAdapter() instanceof c) {
            c cVar = (c) this.epf.getAdapter();
            for (int i4 : cVar.OX(i)) {
                layoutParams.addRule(Integer.valueOf(i4).intValue());
            }
            tv.chushou.zues.widget.psts.b OY = cVar.OY(i);
            if (OY != null) {
                layoutParams.setMargins(OY.mLeft, OY.mTop, OY.mRight, OY.mBottom);
            }
        }
        textView.setLayoutParams(layoutParams);
        if (i2 != 0) {
            textView.setCompoundDrawablesWithIntrinsicBounds(0, i2, 0, 0);
            textView.setCompoundDrawablePadding(this.oQn);
        }
        Resources resources = getContext().getResources();
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, resources.getDimensionPixelSize(b.c.zues_psts_red_text_dot_size));
        layoutParams2.addRule(11);
        layoutParams2.topMargin = (int) tv.chushou.zues.utils.a.a(1, 2.0f, getContext());
        TextView textView2 = new TextView(getContext());
        textView2.setBackgroundResource(b.d.zues_psts_text_red_dot);
        textView2.setTextColor(resources.getColor(b.C1008b.zues_white));
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
        this.epe.addView(relativeLayout);
    }

    private void updateTabStyles() {
        for (int i = 0; i < this.epg; i++) {
            View childAt = this.epe.getChildAt(i);
            if (i != 0) {
                childAt.setLayoutParams(this.epb);
            } else {
                childAt.setLayoutParams(this.oQg);
            }
            setMyTabLayoutParams(childAt);
            childAt.setBackgroundResource(this.ept);
            if (this.epj) {
                childAt.setPadding(0, 0, 0, 0);
            } else {
                childAt.setPadding(this.tabPadding, this.tabPaddingTopBottom, this.tabPadding, this.tabPaddingTopBottom);
            }
            if (childAt instanceof RelativeLayout) {
                TextView textView = (TextView) ((RelativeLayout) childAt).getChildAt(0);
                textView.setTextSize(0, this.tabTextSize);
                textView.setTypeface(this.epq, this.epr);
                textView.setTextColor(this.tabTextColor);
                if (this.oQl) {
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

    public boolean emJ() {
        c cVar;
        if (this.epf != null && this.epf.getAdapter() != null && (this.epf.getAdapter() instanceof c) && (cVar = (c) this.epf.getAdapter()) != null) {
            for (int i = 0; i < this.epg; i++) {
                float OW = cVar.OW(i);
                if (OW != 0.0f) {
                    if (OW == 0.0f) {
                        OW = 1.0f;
                    }
                    this.epe.getChildAt(i).setLayoutParams(new LinearLayout.LayoutParams(0, -1, OW));
                } else {
                    if (i != 0) {
                        this.epe.getChildAt(i).setLayoutParams(this.epb);
                    } else {
                        this.epe.getChildAt(i).setLayoutParams(this.oQg);
                    }
                    setMyTabLayoutParams(this.epe.getChildAt(i));
                }
            }
        }
        return false;
    }

    @Override // android.widget.HorizontalScrollView, android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (!this.epj || View.MeasureSpec.getMode(i) == 0) {
            emJ();
            return;
        }
        int measuredWidth = getMeasuredWidth();
        int i3 = 0;
        for (int i4 = 0; i4 < this.epg; i4++) {
            i3 += this.epe.getChildAt(i4).getMeasuredWidth();
        }
        if (!this.oQk && i3 > 0 && measuredWidth > 0) {
            if (i3 <= measuredWidth) {
                for (int i5 = 0; i5 < this.epg; i5++) {
                    if (i5 != 0) {
                        this.epe.getChildAt(i5).setLayoutParams(this.epb);
                    } else {
                        this.epe.getChildAt(i5).setLayoutParams(this.oQg);
                    }
                    setMyTabLayoutParams(this.epe.getChildAt(i5));
                }
            }
            this.oQk = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean er(int i, int i2) {
        if (this.epg == 0) {
            return false;
        }
        int left = this.epe.getChildAt(i).getLeft() + i2;
        if (i > 0 || i2 > 0) {
            left -= this.scrollOffset;
        }
        int i3 = left - this.mInterval;
        if (i3 != this.eps) {
            this.eps = i3;
            scrollTo(i3, 0);
            return false;
        }
        return true;
    }

    public void setTabDrawMode(int i) {
        this.oQr = i;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (!isInEditMode() && this.epg != 0) {
            if (this.oQr == 0) {
                ax(canvas);
            } else {
                ay(canvas);
            }
        }
    }

    private void ax(Canvas canvas) {
        int height = getHeight();
        this.epi.setColor(this.indicatorColor);
        View childAt = this.epe.getChildAt(this.Zf);
        float left = childAt.getLeft();
        float right = childAt.getRight();
        if (this.eph > 0.0f && this.Zf < this.epg - 1) {
            View childAt2 = this.epe.getChildAt(this.Zf + 1);
            left = (left * (1.0f - this.eph)) + (childAt2.getLeft() * this.eph);
            right = (childAt2.getRight() * this.eph) + ((1.0f - this.eph) * right);
        }
        if (this.indicatorWidth > 0) {
            float f2 = ((right - left) - this.indicatorWidth) / 2.0f;
            this.mRectF.set(left + f2, height - this.indicatorHeight, f2 + left + this.indicatorWidth, height);
            if (this.oQm) {
                canvas.drawRoundRect(this.mRectF, this.indicatorHeight / 2, this.indicatorHeight / 2, this.epi);
            } else {
                canvas.drawRect(this.mRectF, this.epi);
            }
        } else {
            canvas.drawRect(left, height - this.indicatorHeight, right, height, this.epi);
        }
        this.epi.setColor(this.underlineColor);
        canvas.drawRect(0.0f, height - this.underlineHeight, this.epe.getWidth(), height, this.epi);
        this.oQj.setColor(this.dividerColor);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.epg - 1) {
                View childAt3 = this.epe.getChildAt(i2);
                canvas.drawLine(childAt3.getRight(), this.dividerPadding, childAt3.getRight(), height - this.dividerPadding, this.oQj);
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    private void ay(Canvas canvas) {
        float f2;
        float f3;
        float f4;
        int height = getHeight();
        this.epi.setColor(this.underlineColor);
        canvas.drawRect(0.0f, height - this.underlineHeight, this.epe.getWidth(), height, this.epi);
        this.epi.setColor(this.indicatorColor);
        View childAt = this.epe.getChildAt(this.Zf);
        float left = childAt.getLeft();
        View childAt2 = ((RelativeLayout) childAt).getChildAt(0);
        float left2 = childAt2.getLeft();
        float right = childAt2.getRight();
        if (this.eph <= 0.0f || this.Zf >= this.epg - 1) {
            f2 = right;
            f3 = left2;
            f4 = left;
        } else {
            View childAt3 = this.epe.getChildAt(this.Zf + 1);
            float left3 = (left * (1.0f - this.eph)) + (childAt3.getLeft() * this.eph);
            View childAt4 = ((RelativeLayout) childAt3).getChildAt(0);
            f3 = (childAt4.getLeft() * this.eph) + (left2 * (1.0f - this.eph));
            f2 = (childAt4.getRight() * this.eph) + (right * (1.0f - this.eph));
            f4 = left3;
        }
        if (this.indicatorWidth > 0) {
            float f5 = ((f2 - f3) - this.indicatorWidth) / 2.0f;
            this.mRectF.set(f4 + f3 + f5, height - this.indicatorHeight, f5 + f3 + f4 + this.indicatorWidth, height);
            if (this.oQm) {
                canvas.drawRoundRect(this.mRectF, this.indicatorHeight / 2, this.indicatorHeight / 2, this.epi);
            } else {
                canvas.drawRect(this.mRectF, this.epi);
            }
        } else {
            canvas.drawRect(f3 + f4, height - this.indicatorHeight, f4 + f2, height, this.epi);
        }
        this.oQj.setColor(this.dividerColor);
        this.epi.setColor(this.underlineColor);
        for (int i = 0; i < this.epg; i++) {
            View childAt5 = this.epe.getChildAt(i);
            if (i < this.epg - 1) {
                canvas.drawLine(childAt5.getRight(), this.dividerPadding, childAt5.getRight(), height - this.dividerPadding, this.oQj);
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
            PagerSlidingTabStrip.this.Zf = i;
            PagerSlidingTabStrip.this.eph = f;
            if (PagerSlidingTabStrip.this.epe != null) {
                PagerSlidingTabStrip.this.er(i, (int) (PagerSlidingTabStrip.this.epe.getChildAt(i).getWidth() * f));
            }
            PagerSlidingTabStrip.this.invalidate();
            if (PagerSlidingTabStrip.this.epd != null) {
                PagerSlidingTabStrip.this.epd.onPageScrolled(i, f, i2);
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            if (i == 0) {
                PagerSlidingTabStrip.this.er(PagerSlidingTabStrip.this.epf.getCurrentItem(), 0);
            }
            if (PagerSlidingTabStrip.this.epd != null) {
                PagerSlidingTabStrip.this.epd.onPageScrollStateChanged(i);
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            PagerSlidingTabStrip.this.setSelectItem(i);
            if (PagerSlidingTabStrip.this.epd != null) {
                PagerSlidingTabStrip.this.epd.onPageSelected(i);
            }
        }
    }

    public void setSelectItem(int i) {
        if (this.epe != null) {
            this.oQi = i;
            for (int i2 = 0; i2 < this.epe.getChildCount(); i2++) {
                if (i2 == i) {
                    RelativeLayout relativeLayout = (RelativeLayout) this.epe.getChildAt(i);
                    relativeLayout.setSelected(true);
                    TextView textView = (TextView) relativeLayout.getChildAt(0);
                    textView.setTypeface(this.epq, this.oQq);
                    textView.setTextColor(this.tabTextSelectColor);
                    textView.setTextSize(0, this.oQo);
                    if (this.oQt != -1) {
                        textView.setBackgroundResource(this.oQt);
                    }
                    if (this.epf.getAdapter() instanceof b) {
                        textView.setCompoundDrawablesWithIntrinsicBounds(0, ((b) this.epf.getAdapter()).Ne(i), 0, 0);
                    }
                } else {
                    RelativeLayout relativeLayout2 = (RelativeLayout) this.epe.getChildAt(i2);
                    relativeLayout2.setSelected(false);
                    TextView textView2 = (TextView) relativeLayout2.getChildAt(0);
                    textView2.setTextColor(this.tabTextColor);
                    textView2.setBackgroundResource(0);
                    textView2.setTextSize(0, this.tabTextSize);
                    textView2.setTypeface(this.epq, this.epr);
                    if (this.epf.getAdapter() instanceof b) {
                        textView2.setCompoundDrawablesWithIntrinsicBounds(0, ((b) this.epf.getAdapter()).oz(i2), 0, 0);
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
        this.epj = z;
        requestLayout();
    }

    public boolean getShouldExpand() {
        return this.epj;
    }

    public void setAllCaps(boolean z) {
        this.oQl = z;
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
        this.epq = typeface;
        this.epr = i;
        updateTabStyles();
    }

    public void setSelectedTypeface(Typeface typeface, int i) {
        this.epq = typeface;
        this.oQq = i;
        updateTabStyles();
    }

    public void setTabBackground(int i) {
        this.ept = i;
    }

    public int getTabBackground() {
        return this.ept;
    }

    public void setTabPaddingLeftRight(int i) {
        this.tabPadding = i;
        updateTabStyles();
    }

    public int getTabPaddingLeftRight() {
        return this.tabPadding;
    }

    public void setIconPadding(int i) {
        this.oQn = i;
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.Zf = savedState.Zf;
        requestLayout();
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.Zf = this.Zf;
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
            /* renamed from: Pb */
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };
        int Zf;

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.Zf = parcel.readInt();
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.Zf);
        }
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.oQE != null) {
            this.oQE.zm(true);
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    public void setDisallowIntercept(tv.chushou.zues.widget.psts.a aVar) {
        this.oQE = aVar;
    }
}
