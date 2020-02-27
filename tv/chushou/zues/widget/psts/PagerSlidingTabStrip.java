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
    private int Ev;
    private int deA;
    private int deB;
    private LinearLayout.LayoutParams deg;
    public ViewPager.OnPageChangeListener dei;
    private LinearLayout dej;
    private ViewPager dek;
    private int del;
    private float dem;
    private Paint den;
    private boolean deo;
    private int der;
    private int dex;
    private Typeface dey;
    private int dez;
    private int dgp;
    private int dgq;
    private int dividerColor;
    private int dividerPadding;
    private DisplayMetrics dm;
    private int indicatorHeight;
    private Locale locale;
    private int mInterval;
    private final RectF mRectF;
    private int nFy;
    private LinearLayout.LayoutParams nZI;
    private d nZJ;
    private int nZK;
    private Paint nZL;
    private boolean nZM;
    private int nZN;
    private boolean nZO;
    private boolean nZP;
    private int nZQ;
    private int nZR;
    private int nZS;
    private int nZT;
    private int nZU;
    private int nZV;
    private int nZW;
    private int nZX;
    private int nZY;
    private int nZZ;
    private int oaa;
    private int oab;
    private boolean oac;
    private boolean oad;
    private int oae;
    private int oaf;
    private int oag;
    private int oah;
    private int oai;
    private boolean oaj;
    private boolean oak;
    private boolean oal;
    private tv.chushou.zues.widget.psts.a oam;
    private int tabPadding;
    private int tabTextColor;
    private int tabTextSize;

    /* loaded from: classes5.dex */
    public interface a {
        void eI(int i, int i2);
    }

    /* loaded from: classes5.dex */
    public interface b {
        int ML(int i);

        String MM(int i);

        int MN(int i);

        tv.chushou.zues.widget.psts.b MO(int i);

        int kW(int i);
    }

    /* loaded from: classes5.dex */
    public interface c {
        float OD(int i);

        int[] OE(int i);

        tv.chushou.zues.widget.psts.b OF(int i);
    }

    /* loaded from: classes5.dex */
    public interface e {
        tv.chushou.zues.widget.psts.b MO(int i);

        int[] OG(int i);
    }

    /* loaded from: classes5.dex */
    public interface f {
        int OH(int i);
    }

    /* loaded from: classes5.dex */
    public interface g {
        void bA(int i);
    }

    /* loaded from: classes5.dex */
    public interface h {
        void AP(int i);
    }

    public PagerSlidingTabStrip(Context context) {
        this(context, null);
    }

    public PagerSlidingTabStrip(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PagerSlidingTabStrip(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.nZJ = new d();
        this.Ev = 0;
        this.nZK = 0;
        this.dem = 0.0f;
        this.nZM = false;
        this.nZN = -10066330;
        this.nFy = 436207616;
        this.dividerColor = 436207616;
        this.deo = true;
        this.nZO = false;
        this.der = 52;
        this.indicatorHeight = 3;
        this.dex = 0;
        this.nZP = true;
        this.dgp = 1;
        this.dividerPadding = 12;
        this.nZQ = 0;
        this.tabPadding = 24;
        this.nZR = 0;
        this.nZS = 0;
        this.nZT = 0;
        this.dgq = 1;
        this.nZU = 0;
        this.tabTextSize = 15;
        this.nZV = this.tabTextSize;
        this.tabTextColor = -10066330;
        this.nZW = -10066330;
        this.nZX = 13;
        this.dey = null;
        this.dez = 0;
        this.nZY = 1;
        this.deA = 0;
        this.nZZ = 1;
        this.oaa = 0;
        this.deB = b.d.zues_psts_tab_background;
        this.oab = -1;
        this.oac = true;
        this.oad = false;
        this.oae = 3;
        this.oah = 16;
        this.oai = 0;
        this.mInterval = 0;
        this.oaj = false;
        this.oak = false;
        this.oal = true;
        this.mRectF = new RectF();
        setFillViewport(true);
        setWillNotDraw(false);
        this.dej = new LinearLayout(context);
        this.dej.setOrientation(0);
        this.dej.setGravity(16);
        this.dm = getResources().getDisplayMetrics();
        this.oah = (int) TypedValue.applyDimension(1, this.oah, this.dm);
        this.der = (int) TypedValue.applyDimension(1, this.der, this.dm);
        this.indicatorHeight = (int) TypedValue.applyDimension(1, this.indicatorHeight, this.dm);
        this.dex = (int) TypedValue.applyDimension(1, this.dex, this.dm);
        this.dgp = (int) TypedValue.applyDimension(1, this.dgp, this.dm);
        this.dividerPadding = (int) TypedValue.applyDimension(1, this.dividerPadding, this.dm);
        this.tabPadding = (int) TypedValue.applyDimension(1, this.tabPadding, this.dm);
        this.dgq = (int) TypedValue.applyDimension(1, this.dgq, this.dm);
        this.tabTextSize = (int) TypedValue.applyDimension(2, this.tabTextSize, this.dm);
        this.oae = (int) TypedValue.applyDimension(1, this.oae, this.dm);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, ATTRS);
        this.tabTextSize = obtainStyledAttributes.getDimensionPixelSize(0, this.tabTextSize);
        this.nZV = this.tabTextSize;
        this.tabTextColor = obtainStyledAttributes.getColor(1, this.tabTextColor);
        obtainStyledAttributes.recycle();
        TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, b.i.PagerSlidingTabStrip);
        this.nZN = obtainStyledAttributes2.getColor(b.i.PagerSlidingTabStrip_indicatorColor, this.nZN);
        this.nZP = obtainStyledAttributes2.getBoolean(b.i.PagerSlidingTabStrip_indicatorRoundCap, false);
        this.nFy = obtainStyledAttributes2.getColor(b.i.PagerSlidingTabStrip_underlineColor, this.nFy);
        this.dividerColor = obtainStyledAttributes2.getColor(b.i.PagerSlidingTabStrip_dividerColor, this.dividerColor);
        this.nZW = obtainStyledAttributes2.getColor(b.i.PagerSlidingTabStrip_tabTextSelectColor, this.dividerColor);
        this.indicatorHeight = obtainStyledAttributes2.getDimensionPixelSize(b.i.PagerSlidingTabStrip_indicatorHeight, this.indicatorHeight);
        this.dex = obtainStyledAttributes2.getDimensionPixelSize(b.i.PagerSlidingTabStrip_indicatorWidth, this.dex);
        this.dgp = obtainStyledAttributes2.getDimensionPixelSize(b.i.PagerSlidingTabStrip_underlineHeight, this.dgp);
        this.dividerPadding = obtainStyledAttributes2.getDimensionPixelSize(b.i.PagerSlidingTabStrip_psts_dividerPadding, this.dividerPadding);
        this.oah = obtainStyledAttributes2.getDimensionPixelSize(b.i.PagerSlidingTabStrip_psts_minInterval, this.oah);
        this.oai = obtainStyledAttributes2.getDimensionPixelSize(b.i.PagerSlidingTabStrip_center_paddingRight, 0);
        this.nZQ = obtainStyledAttributes2.getDimensionPixelSize(b.i.PagerSlidingTabStrip_parentPaddingLeft, this.nZQ);
        this.tabPadding = obtainStyledAttributes2.getDimensionPixelSize(b.i.PagerSlidingTabStrip_tabPaddingLeftRight, this.tabPadding);
        this.nZR = obtainStyledAttributes2.getDimensionPixelSize(b.i.PagerSlidingTabStrip_tabPaddingTopBottom, this.nZR);
        this.nZS = obtainStyledAttributes2.getDimensionPixelSize(b.i.PagerSlidingTabStrip_textPaddingLeftRight, this.nZS);
        this.nZT = obtainStyledAttributes2.getDimensionPixelSize(b.i.PagerSlidingTabStrip_textPaddingTopBottom, this.nZT);
        this.deB = obtainStyledAttributes2.getResourceId(b.i.PagerSlidingTabStrip_ptabBackground, this.deB);
        this.oab = obtainStyledAttributes2.getResourceId(b.i.PagerSlidingTabStrip_textBackground, this.oab);
        this.deo = obtainStyledAttributes2.getBoolean(b.i.PagerSlidingTabStrip_shouldExpand, this.deo);
        this.der = obtainStyledAttributes2.getDimensionPixelSize(b.i.PagerSlidingTabStrip_scrollOffset, this.der);
        this.nZO = obtainStyledAttributes2.getBoolean(b.i.PagerSlidingTabStrip_psts_textAllCaps, this.nZO);
        this.oac = obtainStyledAttributes2.getBoolean(b.i.PagerSlidingTabStrip_psts_tabIsWeight, this.oac);
        this.nZZ = obtainStyledAttributes2.getInteger(b.i.PagerSlidingTabStrip_apsts_draw_mode, 0);
        this.oaa = obtainStyledAttributes2.getInteger(b.i.PagerSlidingTabStrip_apsts_layout_mode, 0);
        this.nZV = obtainStyledAttributes2.getDimensionPixelSize(b.i.PagerSlidingTabStrip_tabTextSelectSize, this.tabTextSize);
        obtainStyledAttributes2.recycle();
        this.den = new Paint();
        this.den.setAntiAlias(true);
        this.den.setStyle(Paint.Style.FILL);
        this.nZL = new Paint();
        this.nZL.setAntiAlias(true);
        this.nZL.setStrokeWidth(this.dgq);
        if (this.oaa == 0) {
            this.deg = new LinearLayout.LayoutParams(0, -1, 1.0f);
            this.nZI = new LinearLayout.LayoutParams(0, -1, 1.0f);
            this.nZI.setMargins(0, 0, 0, 0);
        } else {
            this.deg = new LinearLayout.LayoutParams(-2, -1);
            this.nZI = new LinearLayout.LayoutParams(-2, -1);
            this.nZI.setMargins(0, 0, 0, 0);
        }
        if (this.locale == null) {
            this.locale = getResources().getConfiguration().locale;
        }
        this.dej.setPadding(this.nZQ, this.dej.getPaddingTop(), this.dej.getPaddingRight(), this.dej.getPaddingBottom());
        this.dej.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        addView(this.dej);
    }

    public void setControlWidth(int i) {
        this.oaf = i;
    }

    /* loaded from: classes5.dex */
    public class NewAdapter extends FragmentStatePagerAdapter implements h {
        private List<String> mDatas;
        private g oao;

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
        public void AP(int i) {
            if (this.oao != null) {
                this.oao.bA(i);
            }
        }
    }

    public boolean c(ViewPager viewPager) {
        return a(viewPager, false);
    }

    public boolean a(ViewPager viewPager, boolean z) {
        this.dek = viewPager;
        if (viewPager.getAdapter() == null) {
            throw new IllegalStateException("ViewPager does not have adapter instance.");
        }
        if (!z) {
            viewPager.addOnPageChangeListener(this.nZJ);
        }
        notifyDataSetChanged();
        return this.oad;
    }

    public void setViewpageSmoothScroll(boolean z) {
        this.oal = z;
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.dei = onPageChangeListener;
    }

    public void notifyDataSetChanged() {
        tv.chushou.zues.widget.psts.b bVar;
        int[] iArr;
        this.oag = 0;
        this.oad = false;
        this.mInterval = this.oah;
        this.dej.removeAllViews();
        this.del = this.dek.getAdapter().getCount();
        for (int i = 0; i < this.del; i++) {
            if (this.dek.getAdapter() instanceof b) {
                a(i, ((b) this.dek.getAdapter()).kW(i), ((b) this.dek.getAdapter()).MM(i), ((b) this.dek.getAdapter()).MO(i), ((b) this.dek.getAdapter()).MN(i));
            } else {
                if (this.dek.getAdapter() instanceof e) {
                    e eVar = (e) this.dek.getAdapter();
                    iArr = eVar.OG(i);
                    bVar = eVar.MO(i);
                } else {
                    bVar = null;
                    iArr = null;
                }
                a(i, this.dek.getAdapter().getPageTitle(i).toString(), iArr, bVar, this.dek.getAdapter() instanceof f ? ((f) this.dek.getAdapter()).OH(i) : 0);
            }
        }
        if (this.oaa != 0) {
            if (this.oaf == 0) {
                this.oaf = tv.chushou.zues.utils.a.he(getContext()).x;
            }
            this.oaf -= this.dej.getPaddingLeft();
            int i2 = (this.oaf - this.oag) / (this.del + 1);
            if (this.oaa == 1) {
                if (this.mInterval < i2) {
                    this.mInterval = i2;
                } else {
                    this.oad = true;
                }
                this.deg.setMargins(this.mInterval, 0, 0, 0);
            } else if (this.oaa == 2) {
                if (this.mInterval < (this.oaf - this.oag) / (this.del + 1)) {
                    this.dej.setGravity(17);
                    this.dej.setPadding(0, this.dej.getPaddingTop(), this.oai, this.dej.getPaddingBottom());
                } else {
                    this.oad = true;
                }
                this.deg.setMargins(this.mInterval, 0, 0, 0);
            } else if (this.oaa == 3) {
                if (this.mInterval >= i2) {
                    this.oad = true;
                }
                this.deg.setMargins(this.mInterval, 0, 0, 0);
            }
        }
        updateTabStyles();
        this.nZM = false;
        getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: tv.chushou.zues.widget.psts.PagerSlidingTabStrip.1
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            @SuppressLint({"NewApi"})
            public void onGlobalLayout() {
                if (Build.VERSION.SDK_INT < 16) {
                    PagerSlidingTabStrip.this.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                } else {
                    PagerSlidingTabStrip.this.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                }
                if (PagerSlidingTabStrip.this.dek != null) {
                    PagerSlidingTabStrip.this.Ev = PagerSlidingTabStrip.this.dek.getCurrentItem();
                    PagerSlidingTabStrip.this.eH(PagerSlidingTabStrip.this.nZK, 0);
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
        layoutParams.addRule(this.nZX);
        textView.setLayoutParams(layoutParams);
        textView.setPadding(this.nZS, this.nZT, this.nZS, this.nZT);
        textView.setCompoundDrawablePadding(getContext().getResources().getDimensionPixelSize(b.c.zues_psts_text_draw_padding));
        textView.setCompoundDrawablesWithIntrinsicBounds(0, 0, i2, 0);
        relativeLayout.setOnClickListener(new View.OnClickListener() { // from class: tv.chushou.zues.widget.psts.PagerSlidingTabStrip.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int i3 = PagerSlidingTabStrip.this.Ev;
                boolean eH = PagerSlidingTabStrip.this.eH(i, 0);
                PagerSlidingTabStrip.this.dek.setCurrentItem(i, PagerSlidingTabStrip.this.oal);
                if (PagerSlidingTabStrip.this.oak) {
                    if (!eH && (PagerSlidingTabStrip.this.dek.getAdapter() instanceof h)) {
                        ((h) PagerSlidingTabStrip.this.dek.getAdapter()).AP(i);
                    }
                } else if (eH && (PagerSlidingTabStrip.this.dek.getAdapter() instanceof h)) {
                    ((h) PagerSlidingTabStrip.this.dek.getAdapter()).AP(i);
                }
                if (PagerSlidingTabStrip.this.dek.getAdapter() instanceof a) {
                    ((a) PagerSlidingTabStrip.this.dek.getAdapter()).eI(i, i3);
                }
                PagerSlidingTabStrip.this.Ev = i;
                if (PagerSlidingTabStrip.this.oak) {
                    PagerSlidingTabStrip.this.dem = 0.0f;
                    PagerSlidingTabStrip.this.nZK = i;
                    PagerSlidingTabStrip.this.setSelectItem(i);
                    PagerSlidingTabStrip.this.eH(i, PagerSlidingTabStrip.this.dej.getChildAt(i).getWidth() * 0);
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
        textView2.setTextColor(resources.getColor(b.C0807b.zues_white));
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
        this.dej.addView(relativeLayout);
        if (this.oaa != 0) {
            Rect rect = new Rect();
            textView.getPaint().getTextBounds(str, 0, str.length(), rect);
            this.oag = rect.width() + this.oae + (this.nZS * 2) + this.oag;
        }
    }

    public void setTagRightImg(int i, @DrawableRes int i2) {
        TextView textView = (TextView) ((RelativeLayout) this.dej.getChildAt(i)).findViewById(b.e.zues_psts_tab_tag);
        if (textView != null) {
            textView.setCompoundDrawablesWithIntrinsicBounds(0, 0, i2, 0);
        }
    }

    public void setTagText(int i, String str) {
        TextView textView = (TextView) ((RelativeLayout) this.dej.getChildAt(i)).findViewById(b.e.zues_psts_tab_tag);
        if (textView != null) {
            textView.setText(str);
        }
    }

    public void bl(int i, String str) {
        RelativeLayout relativeLayout = (RelativeLayout) this.dej.getChildAt(i);
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

    public void OA(int i) {
        RelativeLayout relativeLayout = (RelativeLayout) this.dej.getChildAt(i);
        View childAt = relativeLayout.getChildAt(relativeLayout.getChildCount() - 3);
        if (childAt != null) {
            childAt.setVisibility(8);
        }
    }

    public void OB(int i) {
        RelativeLayout relativeLayout;
        View childAt;
        if (this.dej != null && (relativeLayout = (RelativeLayout) this.dej.getChildAt(i)) != null && (childAt = relativeLayout.getChildAt(relativeLayout.getChildCount() - 1)) != null) {
            ((ImageView) childAt).setVisibility(0);
        }
    }

    public void OC(int i) {
        RelativeLayout relativeLayout;
        View childAt;
        if (this.dej != null && (relativeLayout = (RelativeLayout) this.dej.getChildAt(i)) != null && (childAt = relativeLayout.getChildAt(relativeLayout.getChildCount() - 1)) != null) {
            ((ImageView) childAt).setVisibility(8);
        }
    }

    private void a(final int i, int i2, String str, tv.chushou.zues.widget.psts.b bVar, int i3) {
        RelativeLayout relativeLayout = new RelativeLayout(getContext());
        relativeLayout.setOnClickListener(new View.OnClickListener() { // from class: tv.chushou.zues.widget.psts.PagerSlidingTabStrip.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int i4 = PagerSlidingTabStrip.this.Ev;
                boolean eH = PagerSlidingTabStrip.this.eH(i, 0);
                PagerSlidingTabStrip.this.dek.setCurrentItem(i, PagerSlidingTabStrip.this.oal);
                if (eH && (PagerSlidingTabStrip.this.dek.getAdapter() instanceof h)) {
                    ((h) PagerSlidingTabStrip.this.dek.getAdapter()).AP(i);
                }
                if (PagerSlidingTabStrip.this.dek.getAdapter() instanceof a) {
                    ((a) PagerSlidingTabStrip.this.dek.getAdapter()).eI(i, i4);
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
        if (this.dek.getAdapter() instanceof c) {
            c cVar = (c) this.dek.getAdapter();
            for (int i4 : cVar.OE(i)) {
                layoutParams.addRule(Integer.valueOf(i4).intValue());
            }
            tv.chushou.zues.widget.psts.b OF = cVar.OF(i);
            if (OF != null) {
                layoutParams.setMargins(OF.mLeft, OF.mTop, OF.mRight, OF.mBottom);
            }
        }
        textView.setLayoutParams(layoutParams);
        if (i2 != 0) {
            textView.setCompoundDrawablesWithIntrinsicBounds(0, i2, 0, 0);
            textView.setCompoundDrawablePadding(this.nZU);
        }
        Resources resources = getContext().getResources();
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, resources.getDimensionPixelSize(b.c.zues_psts_red_text_dot_size));
        layoutParams2.addRule(11);
        layoutParams2.topMargin = (int) tv.chushou.zues.utils.a.a(1, 2.0f, getContext());
        TextView textView2 = new TextView(getContext());
        textView2.setBackgroundResource(b.d.zues_psts_text_red_dot);
        textView2.setTextColor(resources.getColor(b.C0807b.zues_white));
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
        this.dej.addView(relativeLayout);
    }

    private void updateTabStyles() {
        for (int i = 0; i < this.del; i++) {
            View childAt = this.dej.getChildAt(i);
            if (i != 0) {
                childAt.setLayoutParams(this.deg);
            } else {
                childAt.setLayoutParams(this.nZI);
            }
            setMyTabLayoutParams(childAt);
            childAt.setBackgroundResource(this.deB);
            if (this.deo) {
                childAt.setPadding(0, 0, 0, 0);
            } else {
                childAt.setPadding(this.tabPadding, this.nZR, this.tabPadding, this.nZR);
            }
            if (childAt instanceof RelativeLayout) {
                TextView textView = (TextView) ((RelativeLayout) childAt).getChildAt(0);
                textView.setTextSize(0, this.tabTextSize);
                textView.setTypeface(this.dey, this.dez);
                textView.setTextColor(this.tabTextColor);
                if (this.nZO) {
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

    public boolean dQP() {
        c cVar;
        if (this.dek != null && this.dek.getAdapter() != null && (this.dek.getAdapter() instanceof c) && (cVar = (c) this.dek.getAdapter()) != null) {
            for (int i = 0; i < this.del; i++) {
                float OD = cVar.OD(i);
                if (OD != 0.0f) {
                    if (OD == 0.0f) {
                        OD = 1.0f;
                    }
                    this.dej.getChildAt(i).setLayoutParams(new LinearLayout.LayoutParams(0, -1, OD));
                } else {
                    if (i != 0) {
                        this.dej.getChildAt(i).setLayoutParams(this.deg);
                    } else {
                        this.dej.getChildAt(i).setLayoutParams(this.nZI);
                    }
                    setMyTabLayoutParams(this.dej.getChildAt(i));
                }
            }
        }
        return false;
    }

    @Override // android.widget.HorizontalScrollView, android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (!this.deo || View.MeasureSpec.getMode(i) == 0) {
            dQP();
            return;
        }
        int measuredWidth = getMeasuredWidth();
        int i3 = 0;
        for (int i4 = 0; i4 < this.del; i4++) {
            i3 += this.dej.getChildAt(i4).getMeasuredWidth();
        }
        if (!this.nZM && i3 > 0 && measuredWidth > 0) {
            if (i3 <= measuredWidth) {
                for (int i5 = 0; i5 < this.del; i5++) {
                    if (i5 != 0) {
                        this.dej.getChildAt(i5).setLayoutParams(this.deg);
                    } else {
                        this.dej.getChildAt(i5).setLayoutParams(this.nZI);
                    }
                    setMyTabLayoutParams(this.dej.getChildAt(i5));
                }
            }
            this.nZM = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean eH(int i, int i2) {
        if (this.del == 0) {
            return false;
        }
        int left = this.dej.getChildAt(i).getLeft() + i2;
        if (i > 0 || i2 > 0) {
            left -= this.der;
        }
        int i3 = left - this.mInterval;
        if (i3 != this.deA) {
            this.deA = i3;
            scrollTo(i3, 0);
            return false;
        }
        return true;
    }

    public void setTabDrawMode(int i) {
        this.nZZ = i;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (!isInEditMode() && this.del != 0) {
            if (this.nZZ == 0) {
                aq(canvas);
            } else {
                ar(canvas);
            }
        }
    }

    private void aq(Canvas canvas) {
        int height = getHeight();
        this.den.setColor(this.nZN);
        View childAt = this.dej.getChildAt(this.Ev);
        float left = childAt.getLeft();
        float right = childAt.getRight();
        if (this.dem > 0.0f && this.Ev < this.del - 1) {
            View childAt2 = this.dej.getChildAt(this.Ev + 1);
            left = (left * (1.0f - this.dem)) + (childAt2.getLeft() * this.dem);
            right = (childAt2.getRight() * this.dem) + ((1.0f - this.dem) * right);
        }
        if (this.dex > 0) {
            float f2 = ((right - left) - this.dex) / 2.0f;
            this.mRectF.set(left + f2, height - this.indicatorHeight, f2 + left + this.dex, height);
            if (this.nZP) {
                canvas.drawRoundRect(this.mRectF, this.indicatorHeight / 2, this.indicatorHeight / 2, this.den);
            } else {
                canvas.drawRect(this.mRectF, this.den);
            }
        } else {
            canvas.drawRect(left, height - this.indicatorHeight, right, height, this.den);
        }
        this.den.setColor(this.nFy);
        canvas.drawRect(0.0f, height - this.dgp, this.dej.getWidth(), height, this.den);
        this.nZL.setColor(this.dividerColor);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.del - 1) {
                View childAt3 = this.dej.getChildAt(i2);
                canvas.drawLine(childAt3.getRight(), this.dividerPadding, childAt3.getRight(), height - this.dividerPadding, this.nZL);
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
        this.den.setColor(this.nFy);
        canvas.drawRect(0.0f, height - this.dgp, this.dej.getWidth(), height, this.den);
        this.den.setColor(this.nZN);
        View childAt = this.dej.getChildAt(this.Ev);
        float left = childAt.getLeft();
        View childAt2 = ((RelativeLayout) childAt).getChildAt(0);
        float left2 = childAt2.getLeft();
        float right = childAt2.getRight();
        if (this.dem <= 0.0f || this.Ev >= this.del - 1) {
            f2 = right;
            f3 = left2;
            f4 = left;
        } else {
            View childAt3 = this.dej.getChildAt(this.Ev + 1);
            float left3 = (left * (1.0f - this.dem)) + (childAt3.getLeft() * this.dem);
            View childAt4 = ((RelativeLayout) childAt3).getChildAt(0);
            f3 = (childAt4.getLeft() * this.dem) + (left2 * (1.0f - this.dem));
            f2 = (childAt4.getRight() * this.dem) + (right * (1.0f - this.dem));
            f4 = left3;
        }
        if (this.dex > 0) {
            float f5 = ((f2 - f3) - this.dex) / 2.0f;
            this.mRectF.set(f4 + f3 + f5, height - this.indicatorHeight, f5 + f3 + f4 + this.dex, height);
            if (this.nZP) {
                canvas.drawRoundRect(this.mRectF, this.indicatorHeight / 2, this.indicatorHeight / 2, this.den);
            } else {
                canvas.drawRect(this.mRectF, this.den);
            }
        } else {
            canvas.drawRect(f3 + f4, height - this.indicatorHeight, f4 + f2, height, this.den);
        }
        this.nZL.setColor(this.dividerColor);
        this.den.setColor(this.nFy);
        for (int i = 0; i < this.del; i++) {
            View childAt5 = this.dej.getChildAt(i);
            if (i < this.del - 1) {
                canvas.drawLine(childAt5.getRight(), this.dividerPadding, childAt5.getRight(), height - this.dividerPadding, this.nZL);
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
            PagerSlidingTabStrip.this.Ev = i;
            PagerSlidingTabStrip.this.dem = f;
            if (PagerSlidingTabStrip.this.dej != null) {
                PagerSlidingTabStrip.this.eH(i, (int) (PagerSlidingTabStrip.this.dej.getChildAt(i).getWidth() * f));
            }
            PagerSlidingTabStrip.this.invalidate();
            if (PagerSlidingTabStrip.this.dei != null) {
                PagerSlidingTabStrip.this.dei.onPageScrolled(i, f, i2);
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            if (i == 0) {
                PagerSlidingTabStrip.this.eH(PagerSlidingTabStrip.this.dek.getCurrentItem(), 0);
            }
            if (PagerSlidingTabStrip.this.dei != null) {
                PagerSlidingTabStrip.this.dei.onPageScrollStateChanged(i);
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            PagerSlidingTabStrip.this.setSelectItem(i);
            if (PagerSlidingTabStrip.this.dei != null) {
                PagerSlidingTabStrip.this.dei.onPageSelected(i);
            }
        }
    }

    public void setSelectItem(int i) {
        if (this.dej != null) {
            this.nZK = i;
            for (int i2 = 0; i2 < this.dej.getChildCount(); i2++) {
                if (i2 == i) {
                    RelativeLayout relativeLayout = (RelativeLayout) this.dej.getChildAt(i);
                    relativeLayout.setSelected(true);
                    TextView textView = (TextView) relativeLayout.getChildAt(0);
                    textView.setTypeface(this.dey, this.nZY);
                    textView.setTextColor(this.nZW);
                    textView.setTextSize(0, this.nZV);
                    if (this.oab != -1) {
                        textView.setBackgroundResource(this.oab);
                    }
                    if (this.dek.getAdapter() instanceof b) {
                        textView.setCompoundDrawablesWithIntrinsicBounds(0, ((b) this.dek.getAdapter()).ML(i), 0, 0);
                    }
                } else {
                    RelativeLayout relativeLayout2 = (RelativeLayout) this.dej.getChildAt(i2);
                    relativeLayout2.setSelected(false);
                    TextView textView2 = (TextView) relativeLayout2.getChildAt(0);
                    textView2.setTextColor(this.tabTextColor);
                    textView2.setBackgroundResource(0);
                    textView2.setTextSize(0, this.tabTextSize);
                    textView2.setTypeface(this.dey, this.dez);
                    if (this.dek.getAdapter() instanceof b) {
                        textView2.setCompoundDrawablesWithIntrinsicBounds(0, ((b) this.dek.getAdapter()).kW(i2), 0, 0);
                    }
                }
            }
        }
    }

    public void setTabTextSelectColor(@ColorInt int i) {
        this.nZW = i;
        invalidate();
    }

    public void setIndicatorColor(int i) {
        this.nZN = i;
        invalidate();
    }

    public void setIndicatorColorResource(int i) {
        this.nZN = getResources().getColor(i);
        invalidate();
    }

    public int getIndicatorColor() {
        return this.nZN;
    }

    public void setIndicatorHeight(int i) {
        this.indicatorHeight = i;
        invalidate();
    }

    public void setIndicatorWidth(int i) {
        this.dex = i;
        invalidate();
    }

    public int getIndicatorHeight() {
        return this.indicatorHeight;
    }

    public int getIndicatorWidth() {
        return this.dex;
    }

    public void setUnderlineColor(int i) {
        this.nFy = i;
        invalidate();
    }

    public void setUnderlineColorResource(int i) {
        this.nFy = getResources().getColor(i);
        invalidate();
    }

    public int getUnderlineColor() {
        return this.nFy;
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
        this.dgp = i;
        invalidate();
    }

    public int getUnderlineHeight() {
        return this.dgp;
    }

    public void setDividerPadding(int i) {
        this.dividerPadding = i;
        invalidate();
    }

    public int getDividerPadding() {
        return this.dividerPadding;
    }

    public void setScrollOffset(int i) {
        this.der = i;
        invalidate();
    }

    public int getScrollOffset() {
        return this.der;
    }

    public void setShouldExpand(boolean z) {
        this.deo = z;
        requestLayout();
    }

    public boolean getShouldExpand() {
        return this.deo;
    }

    public void setAllCaps(boolean z) {
        this.nZO = z;
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
        this.dey = typeface;
        this.dez = i;
        updateTabStyles();
    }

    public void setSelectedTypeface(Typeface typeface, int i) {
        this.dey = typeface;
        this.nZY = i;
        updateTabStyles();
    }

    public void setTabBackground(int i) {
        this.deB = i;
    }

    public int getTabBackground() {
        return this.deB;
    }

    public void setTabPaddingLeftRight(int i) {
        this.tabPadding = i;
        updateTabStyles();
    }

    public int getTabPaddingLeftRight() {
        return this.tabPadding;
    }

    public void setIconPadding(int i) {
        this.nZU = i;
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.Ev = savedState.Ev;
        requestLayout();
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.Ev = this.Ev;
        return savedState;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
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
            /* renamed from: OI */
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };
        int Ev;

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.Ev = parcel.readInt();
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.Ev);
        }
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.oam != null) {
            this.oam.xi(true);
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    public void setDisallowIntercept(tv.chushou.zues.widget.psts.a aVar) {
        this.oam = aVar;
    }
}
