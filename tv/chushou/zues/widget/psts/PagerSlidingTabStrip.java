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
    private float deB;
    private Paint deC;
    private boolean deD;
    private int deG;
    private int deL;
    private Typeface deM;
    private int deN;
    private int deO;
    private int deP;
    private LinearLayout.LayoutParams dev;
    public ViewPager.OnPageChangeListener dex;
    private LinearLayout dey;
    private ViewPager dez;
    private int dgD;
    private int dgE;
    private int dividerColor;
    private int dividerPadding;
    private DisplayMetrics dm;
    private int indicatorHeight;
    private Locale locale;
    private int mInterval;
    private final RectF mRectF;
    private int nFL;
    private LinearLayout.LayoutParams nZV;
    private d nZW;
    private int nZX;
    private Paint nZY;
    private boolean nZZ;
    private int oaa;
    private boolean oab;
    private boolean oac;
    private int oad;
    private int oae;
    private int oaf;
    private int oag;
    private int oah;
    private int oai;
    private int oaj;
    private int oak;
    private int oal;
    private int oam;
    private int oan;
    private int oao;
    private boolean oap;
    private boolean oaq;
    private int oar;
    private int oas;
    private int oat;
    private int oau;
    private int oav;
    private boolean oaw;
    private boolean oax;
    private boolean oay;
    private tv.chushou.zues.widget.psts.a oaz;
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
        this.nZW = new d();
        this.Ev = 0;
        this.nZX = 0;
        this.deB = 0.0f;
        this.nZZ = false;
        this.oaa = -10066330;
        this.nFL = 436207616;
        this.dividerColor = 436207616;
        this.deD = true;
        this.oab = false;
        this.deG = 52;
        this.indicatorHeight = 3;
        this.deL = 0;
        this.oac = true;
        this.dgD = 1;
        this.dividerPadding = 12;
        this.oad = 0;
        this.tabPadding = 24;
        this.oae = 0;
        this.oaf = 0;
        this.oag = 0;
        this.dgE = 1;
        this.oah = 0;
        this.tabTextSize = 15;
        this.oai = this.tabTextSize;
        this.tabTextColor = -10066330;
        this.oaj = -10066330;
        this.oak = 13;
        this.deM = null;
        this.deN = 0;
        this.oal = 1;
        this.deO = 0;
        this.oam = 1;
        this.oan = 0;
        this.deP = b.d.zues_psts_tab_background;
        this.oao = -1;
        this.oap = true;
        this.oaq = false;
        this.oar = 3;
        this.oau = 16;
        this.oav = 0;
        this.mInterval = 0;
        this.oaw = false;
        this.oax = false;
        this.oay = true;
        this.mRectF = new RectF();
        setFillViewport(true);
        setWillNotDraw(false);
        this.dey = new LinearLayout(context);
        this.dey.setOrientation(0);
        this.dey.setGravity(16);
        this.dm = getResources().getDisplayMetrics();
        this.oau = (int) TypedValue.applyDimension(1, this.oau, this.dm);
        this.deG = (int) TypedValue.applyDimension(1, this.deG, this.dm);
        this.indicatorHeight = (int) TypedValue.applyDimension(1, this.indicatorHeight, this.dm);
        this.deL = (int) TypedValue.applyDimension(1, this.deL, this.dm);
        this.dgD = (int) TypedValue.applyDimension(1, this.dgD, this.dm);
        this.dividerPadding = (int) TypedValue.applyDimension(1, this.dividerPadding, this.dm);
        this.tabPadding = (int) TypedValue.applyDimension(1, this.tabPadding, this.dm);
        this.dgE = (int) TypedValue.applyDimension(1, this.dgE, this.dm);
        this.tabTextSize = (int) TypedValue.applyDimension(2, this.tabTextSize, this.dm);
        this.oar = (int) TypedValue.applyDimension(1, this.oar, this.dm);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, ATTRS);
        this.tabTextSize = obtainStyledAttributes.getDimensionPixelSize(0, this.tabTextSize);
        this.oai = this.tabTextSize;
        this.tabTextColor = obtainStyledAttributes.getColor(1, this.tabTextColor);
        obtainStyledAttributes.recycle();
        TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, b.i.PagerSlidingTabStrip);
        this.oaa = obtainStyledAttributes2.getColor(b.i.PagerSlidingTabStrip_indicatorColor, this.oaa);
        this.oac = obtainStyledAttributes2.getBoolean(b.i.PagerSlidingTabStrip_indicatorRoundCap, false);
        this.nFL = obtainStyledAttributes2.getColor(b.i.PagerSlidingTabStrip_underlineColor, this.nFL);
        this.dividerColor = obtainStyledAttributes2.getColor(b.i.PagerSlidingTabStrip_dividerColor, this.dividerColor);
        this.oaj = obtainStyledAttributes2.getColor(b.i.PagerSlidingTabStrip_tabTextSelectColor, this.dividerColor);
        this.indicatorHeight = obtainStyledAttributes2.getDimensionPixelSize(b.i.PagerSlidingTabStrip_indicatorHeight, this.indicatorHeight);
        this.deL = obtainStyledAttributes2.getDimensionPixelSize(b.i.PagerSlidingTabStrip_indicatorWidth, this.deL);
        this.dgD = obtainStyledAttributes2.getDimensionPixelSize(b.i.PagerSlidingTabStrip_underlineHeight, this.dgD);
        this.dividerPadding = obtainStyledAttributes2.getDimensionPixelSize(b.i.PagerSlidingTabStrip_psts_dividerPadding, this.dividerPadding);
        this.oau = obtainStyledAttributes2.getDimensionPixelSize(b.i.PagerSlidingTabStrip_psts_minInterval, this.oau);
        this.oav = obtainStyledAttributes2.getDimensionPixelSize(b.i.PagerSlidingTabStrip_center_paddingRight, 0);
        this.oad = obtainStyledAttributes2.getDimensionPixelSize(b.i.PagerSlidingTabStrip_parentPaddingLeft, this.oad);
        this.tabPadding = obtainStyledAttributes2.getDimensionPixelSize(b.i.PagerSlidingTabStrip_tabPaddingLeftRight, this.tabPadding);
        this.oae = obtainStyledAttributes2.getDimensionPixelSize(b.i.PagerSlidingTabStrip_tabPaddingTopBottom, this.oae);
        this.oaf = obtainStyledAttributes2.getDimensionPixelSize(b.i.PagerSlidingTabStrip_textPaddingLeftRight, this.oaf);
        this.oag = obtainStyledAttributes2.getDimensionPixelSize(b.i.PagerSlidingTabStrip_textPaddingTopBottom, this.oag);
        this.deP = obtainStyledAttributes2.getResourceId(b.i.PagerSlidingTabStrip_ptabBackground, this.deP);
        this.oao = obtainStyledAttributes2.getResourceId(b.i.PagerSlidingTabStrip_textBackground, this.oao);
        this.deD = obtainStyledAttributes2.getBoolean(b.i.PagerSlidingTabStrip_shouldExpand, this.deD);
        this.deG = obtainStyledAttributes2.getDimensionPixelSize(b.i.PagerSlidingTabStrip_scrollOffset, this.deG);
        this.oab = obtainStyledAttributes2.getBoolean(b.i.PagerSlidingTabStrip_psts_textAllCaps, this.oab);
        this.oap = obtainStyledAttributes2.getBoolean(b.i.PagerSlidingTabStrip_psts_tabIsWeight, this.oap);
        this.oam = obtainStyledAttributes2.getInteger(b.i.PagerSlidingTabStrip_apsts_draw_mode, 0);
        this.oan = obtainStyledAttributes2.getInteger(b.i.PagerSlidingTabStrip_apsts_layout_mode, 0);
        this.oai = obtainStyledAttributes2.getDimensionPixelSize(b.i.PagerSlidingTabStrip_tabTextSelectSize, this.tabTextSize);
        obtainStyledAttributes2.recycle();
        this.deC = new Paint();
        this.deC.setAntiAlias(true);
        this.deC.setStyle(Paint.Style.FILL);
        this.nZY = new Paint();
        this.nZY.setAntiAlias(true);
        this.nZY.setStrokeWidth(this.dgE);
        if (this.oan == 0) {
            this.dev = new LinearLayout.LayoutParams(0, -1, 1.0f);
            this.nZV = new LinearLayout.LayoutParams(0, -1, 1.0f);
            this.nZV.setMargins(0, 0, 0, 0);
        } else {
            this.dev = new LinearLayout.LayoutParams(-2, -1);
            this.nZV = new LinearLayout.LayoutParams(-2, -1);
            this.nZV.setMargins(0, 0, 0, 0);
        }
        if (this.locale == null) {
            this.locale = getResources().getConfiguration().locale;
        }
        this.dey.setPadding(this.oad, this.dey.getPaddingTop(), this.dey.getPaddingRight(), this.dey.getPaddingBottom());
        this.dey.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        addView(this.dey);
    }

    public void setControlWidth(int i) {
        this.oas = i;
    }

    /* loaded from: classes5.dex */
    public class NewAdapter extends FragmentStatePagerAdapter implements h {
        private List<String> mDatas;
        private g oaB;

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
            if (this.oaB != null) {
                this.oaB.bA(i);
            }
        }
    }

    public boolean c(ViewPager viewPager) {
        return a(viewPager, false);
    }

    public boolean a(ViewPager viewPager, boolean z) {
        this.dez = viewPager;
        if (viewPager.getAdapter() == null) {
            throw new IllegalStateException("ViewPager does not have adapter instance.");
        }
        if (!z) {
            viewPager.addOnPageChangeListener(this.nZW);
        }
        notifyDataSetChanged();
        return this.oaq;
    }

    public void setViewpageSmoothScroll(boolean z) {
        this.oay = z;
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.dex = onPageChangeListener;
    }

    public void notifyDataSetChanged() {
        tv.chushou.zues.widget.psts.b bVar;
        int[] iArr;
        this.oat = 0;
        this.oaq = false;
        this.mInterval = this.oau;
        this.dey.removeAllViews();
        this.deA = this.dez.getAdapter().getCount();
        for (int i = 0; i < this.deA; i++) {
            if (this.dez.getAdapter() instanceof b) {
                a(i, ((b) this.dez.getAdapter()).kW(i), ((b) this.dez.getAdapter()).MM(i), ((b) this.dez.getAdapter()).MO(i), ((b) this.dez.getAdapter()).MN(i));
            } else {
                if (this.dez.getAdapter() instanceof e) {
                    e eVar = (e) this.dez.getAdapter();
                    iArr = eVar.OG(i);
                    bVar = eVar.MO(i);
                } else {
                    bVar = null;
                    iArr = null;
                }
                a(i, this.dez.getAdapter().getPageTitle(i).toString(), iArr, bVar, this.dez.getAdapter() instanceof f ? ((f) this.dez.getAdapter()).OH(i) : 0);
            }
        }
        if (this.oan != 0) {
            if (this.oas == 0) {
                this.oas = tv.chushou.zues.utils.a.he(getContext()).x;
            }
            this.oas -= this.dey.getPaddingLeft();
            int i2 = (this.oas - this.oat) / (this.deA + 1);
            if (this.oan == 1) {
                if (this.mInterval < i2) {
                    this.mInterval = i2;
                } else {
                    this.oaq = true;
                }
                this.dev.setMargins(this.mInterval, 0, 0, 0);
            } else if (this.oan == 2) {
                if (this.mInterval < (this.oas - this.oat) / (this.deA + 1)) {
                    this.dey.setGravity(17);
                    this.dey.setPadding(0, this.dey.getPaddingTop(), this.oav, this.dey.getPaddingBottom());
                } else {
                    this.oaq = true;
                }
                this.dev.setMargins(this.mInterval, 0, 0, 0);
            } else if (this.oan == 3) {
                if (this.mInterval >= i2) {
                    this.oaq = true;
                }
                this.dev.setMargins(this.mInterval, 0, 0, 0);
            }
        }
        updateTabStyles();
        this.nZZ = false;
        getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: tv.chushou.zues.widget.psts.PagerSlidingTabStrip.1
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            @SuppressLint({"NewApi"})
            public void onGlobalLayout() {
                if (Build.VERSION.SDK_INT < 16) {
                    PagerSlidingTabStrip.this.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                } else {
                    PagerSlidingTabStrip.this.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                }
                if (PagerSlidingTabStrip.this.dez != null) {
                    PagerSlidingTabStrip.this.Ev = PagerSlidingTabStrip.this.dez.getCurrentItem();
                    PagerSlidingTabStrip.this.eH(PagerSlidingTabStrip.this.nZX, 0);
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
        layoutParams.addRule(this.oak);
        textView.setLayoutParams(layoutParams);
        textView.setPadding(this.oaf, this.oag, this.oaf, this.oag);
        textView.setCompoundDrawablePadding(getContext().getResources().getDimensionPixelSize(b.c.zues_psts_text_draw_padding));
        textView.setCompoundDrawablesWithIntrinsicBounds(0, 0, i2, 0);
        relativeLayout.setOnClickListener(new View.OnClickListener() { // from class: tv.chushou.zues.widget.psts.PagerSlidingTabStrip.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int i3 = PagerSlidingTabStrip.this.Ev;
                boolean eH = PagerSlidingTabStrip.this.eH(i, 0);
                PagerSlidingTabStrip.this.dez.setCurrentItem(i, PagerSlidingTabStrip.this.oay);
                if (PagerSlidingTabStrip.this.oax) {
                    if (!eH && (PagerSlidingTabStrip.this.dez.getAdapter() instanceof h)) {
                        ((h) PagerSlidingTabStrip.this.dez.getAdapter()).AP(i);
                    }
                } else if (eH && (PagerSlidingTabStrip.this.dez.getAdapter() instanceof h)) {
                    ((h) PagerSlidingTabStrip.this.dez.getAdapter()).AP(i);
                }
                if (PagerSlidingTabStrip.this.dez.getAdapter() instanceof a) {
                    ((a) PagerSlidingTabStrip.this.dez.getAdapter()).eI(i, i3);
                }
                PagerSlidingTabStrip.this.Ev = i;
                if (PagerSlidingTabStrip.this.oax) {
                    PagerSlidingTabStrip.this.deB = 0.0f;
                    PagerSlidingTabStrip.this.nZX = i;
                    PagerSlidingTabStrip.this.setSelectItem(i);
                    PagerSlidingTabStrip.this.eH(i, PagerSlidingTabStrip.this.dey.getChildAt(i).getWidth() * 0);
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
        this.dey.addView(relativeLayout);
        if (this.oan != 0) {
            Rect rect = new Rect();
            textView.getPaint().getTextBounds(str, 0, str.length(), rect);
            this.oat = rect.width() + this.oar + (this.oaf * 2) + this.oat;
        }
    }

    public void setTagRightImg(int i, @DrawableRes int i2) {
        TextView textView = (TextView) ((RelativeLayout) this.dey.getChildAt(i)).findViewById(b.e.zues_psts_tab_tag);
        if (textView != null) {
            textView.setCompoundDrawablesWithIntrinsicBounds(0, 0, i2, 0);
        }
    }

    public void setTagText(int i, String str) {
        TextView textView = (TextView) ((RelativeLayout) this.dey.getChildAt(i)).findViewById(b.e.zues_psts_tab_tag);
        if (textView != null) {
            textView.setText(str);
        }
    }

    public void bl(int i, String str) {
        RelativeLayout relativeLayout = (RelativeLayout) this.dey.getChildAt(i);
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
        RelativeLayout relativeLayout = (RelativeLayout) this.dey.getChildAt(i);
        View childAt = relativeLayout.getChildAt(relativeLayout.getChildCount() - 3);
        if (childAt != null) {
            childAt.setVisibility(8);
        }
    }

    public void OB(int i) {
        RelativeLayout relativeLayout;
        View childAt;
        if (this.dey != null && (relativeLayout = (RelativeLayout) this.dey.getChildAt(i)) != null && (childAt = relativeLayout.getChildAt(relativeLayout.getChildCount() - 1)) != null) {
            ((ImageView) childAt).setVisibility(0);
        }
    }

    public void OC(int i) {
        RelativeLayout relativeLayout;
        View childAt;
        if (this.dey != null && (relativeLayout = (RelativeLayout) this.dey.getChildAt(i)) != null && (childAt = relativeLayout.getChildAt(relativeLayout.getChildCount() - 1)) != null) {
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
                PagerSlidingTabStrip.this.dez.setCurrentItem(i, PagerSlidingTabStrip.this.oay);
                if (eH && (PagerSlidingTabStrip.this.dez.getAdapter() instanceof h)) {
                    ((h) PagerSlidingTabStrip.this.dez.getAdapter()).AP(i);
                }
                if (PagerSlidingTabStrip.this.dez.getAdapter() instanceof a) {
                    ((a) PagerSlidingTabStrip.this.dez.getAdapter()).eI(i, i4);
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
        if (this.dez.getAdapter() instanceof c) {
            c cVar = (c) this.dez.getAdapter();
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
            textView.setCompoundDrawablePadding(this.oah);
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
        this.dey.addView(relativeLayout);
    }

    private void updateTabStyles() {
        for (int i = 0; i < this.deA; i++) {
            View childAt = this.dey.getChildAt(i);
            if (i != 0) {
                childAt.setLayoutParams(this.dev);
            } else {
                childAt.setLayoutParams(this.nZV);
            }
            setMyTabLayoutParams(childAt);
            childAt.setBackgroundResource(this.deP);
            if (this.deD) {
                childAt.setPadding(0, 0, 0, 0);
            } else {
                childAt.setPadding(this.tabPadding, this.oae, this.tabPadding, this.oae);
            }
            if (childAt instanceof RelativeLayout) {
                TextView textView = (TextView) ((RelativeLayout) childAt).getChildAt(0);
                textView.setTextSize(0, this.tabTextSize);
                textView.setTypeface(this.deM, this.deN);
                textView.setTextColor(this.tabTextColor);
                if (this.oab) {
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

    public boolean dQS() {
        c cVar;
        if (this.dez != null && this.dez.getAdapter() != null && (this.dez.getAdapter() instanceof c) && (cVar = (c) this.dez.getAdapter()) != null) {
            for (int i = 0; i < this.deA; i++) {
                float OD = cVar.OD(i);
                if (OD != 0.0f) {
                    if (OD == 0.0f) {
                        OD = 1.0f;
                    }
                    this.dey.getChildAt(i).setLayoutParams(new LinearLayout.LayoutParams(0, -1, OD));
                } else {
                    if (i != 0) {
                        this.dey.getChildAt(i).setLayoutParams(this.dev);
                    } else {
                        this.dey.getChildAt(i).setLayoutParams(this.nZV);
                    }
                    setMyTabLayoutParams(this.dey.getChildAt(i));
                }
            }
        }
        return false;
    }

    @Override // android.widget.HorizontalScrollView, android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (!this.deD || View.MeasureSpec.getMode(i) == 0) {
            dQS();
            return;
        }
        int measuredWidth = getMeasuredWidth();
        int i3 = 0;
        for (int i4 = 0; i4 < this.deA; i4++) {
            i3 += this.dey.getChildAt(i4).getMeasuredWidth();
        }
        if (!this.nZZ && i3 > 0 && measuredWidth > 0) {
            if (i3 <= measuredWidth) {
                for (int i5 = 0; i5 < this.deA; i5++) {
                    if (i5 != 0) {
                        this.dey.getChildAt(i5).setLayoutParams(this.dev);
                    } else {
                        this.dey.getChildAt(i5).setLayoutParams(this.nZV);
                    }
                    setMyTabLayoutParams(this.dey.getChildAt(i5));
                }
            }
            this.nZZ = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean eH(int i, int i2) {
        if (this.deA == 0) {
            return false;
        }
        int left = this.dey.getChildAt(i).getLeft() + i2;
        if (i > 0 || i2 > 0) {
            left -= this.deG;
        }
        int i3 = left - this.mInterval;
        if (i3 != this.deO) {
            this.deO = i3;
            scrollTo(i3, 0);
            return false;
        }
        return true;
    }

    public void setTabDrawMode(int i) {
        this.oam = i;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (!isInEditMode() && this.deA != 0) {
            if (this.oam == 0) {
                aq(canvas);
            } else {
                ar(canvas);
            }
        }
    }

    private void aq(Canvas canvas) {
        int height = getHeight();
        this.deC.setColor(this.oaa);
        View childAt = this.dey.getChildAt(this.Ev);
        float left = childAt.getLeft();
        float right = childAt.getRight();
        if (this.deB > 0.0f && this.Ev < this.deA - 1) {
            View childAt2 = this.dey.getChildAt(this.Ev + 1);
            left = (left * (1.0f - this.deB)) + (childAt2.getLeft() * this.deB);
            right = (childAt2.getRight() * this.deB) + ((1.0f - this.deB) * right);
        }
        if (this.deL > 0) {
            float f2 = ((right - left) - this.deL) / 2.0f;
            this.mRectF.set(left + f2, height - this.indicatorHeight, f2 + left + this.deL, height);
            if (this.oac) {
                canvas.drawRoundRect(this.mRectF, this.indicatorHeight / 2, this.indicatorHeight / 2, this.deC);
            } else {
                canvas.drawRect(this.mRectF, this.deC);
            }
        } else {
            canvas.drawRect(left, height - this.indicatorHeight, right, height, this.deC);
        }
        this.deC.setColor(this.nFL);
        canvas.drawRect(0.0f, height - this.dgD, this.dey.getWidth(), height, this.deC);
        this.nZY.setColor(this.dividerColor);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.deA - 1) {
                View childAt3 = this.dey.getChildAt(i2);
                canvas.drawLine(childAt3.getRight(), this.dividerPadding, childAt3.getRight(), height - this.dividerPadding, this.nZY);
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
        this.deC.setColor(this.nFL);
        canvas.drawRect(0.0f, height - this.dgD, this.dey.getWidth(), height, this.deC);
        this.deC.setColor(this.oaa);
        View childAt = this.dey.getChildAt(this.Ev);
        float left = childAt.getLeft();
        View childAt2 = ((RelativeLayout) childAt).getChildAt(0);
        float left2 = childAt2.getLeft();
        float right = childAt2.getRight();
        if (this.deB <= 0.0f || this.Ev >= this.deA - 1) {
            f2 = right;
            f3 = left2;
            f4 = left;
        } else {
            View childAt3 = this.dey.getChildAt(this.Ev + 1);
            float left3 = (left * (1.0f - this.deB)) + (childAt3.getLeft() * this.deB);
            View childAt4 = ((RelativeLayout) childAt3).getChildAt(0);
            f3 = (childAt4.getLeft() * this.deB) + (left2 * (1.0f - this.deB));
            f2 = (childAt4.getRight() * this.deB) + (right * (1.0f - this.deB));
            f4 = left3;
        }
        if (this.deL > 0) {
            float f5 = ((f2 - f3) - this.deL) / 2.0f;
            this.mRectF.set(f4 + f3 + f5, height - this.indicatorHeight, f5 + f3 + f4 + this.deL, height);
            if (this.oac) {
                canvas.drawRoundRect(this.mRectF, this.indicatorHeight / 2, this.indicatorHeight / 2, this.deC);
            } else {
                canvas.drawRect(this.mRectF, this.deC);
            }
        } else {
            canvas.drawRect(f3 + f4, height - this.indicatorHeight, f4 + f2, height, this.deC);
        }
        this.nZY.setColor(this.dividerColor);
        this.deC.setColor(this.nFL);
        for (int i = 0; i < this.deA; i++) {
            View childAt5 = this.dey.getChildAt(i);
            if (i < this.deA - 1) {
                canvas.drawLine(childAt5.getRight(), this.dividerPadding, childAt5.getRight(), height - this.dividerPadding, this.nZY);
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
            PagerSlidingTabStrip.this.deB = f;
            if (PagerSlidingTabStrip.this.dey != null) {
                PagerSlidingTabStrip.this.eH(i, (int) (PagerSlidingTabStrip.this.dey.getChildAt(i).getWidth() * f));
            }
            PagerSlidingTabStrip.this.invalidate();
            if (PagerSlidingTabStrip.this.dex != null) {
                PagerSlidingTabStrip.this.dex.onPageScrolled(i, f, i2);
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            if (i == 0) {
                PagerSlidingTabStrip.this.eH(PagerSlidingTabStrip.this.dez.getCurrentItem(), 0);
            }
            if (PagerSlidingTabStrip.this.dex != null) {
                PagerSlidingTabStrip.this.dex.onPageScrollStateChanged(i);
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            PagerSlidingTabStrip.this.setSelectItem(i);
            if (PagerSlidingTabStrip.this.dex != null) {
                PagerSlidingTabStrip.this.dex.onPageSelected(i);
            }
        }
    }

    public void setSelectItem(int i) {
        if (this.dey != null) {
            this.nZX = i;
            for (int i2 = 0; i2 < this.dey.getChildCount(); i2++) {
                if (i2 == i) {
                    RelativeLayout relativeLayout = (RelativeLayout) this.dey.getChildAt(i);
                    relativeLayout.setSelected(true);
                    TextView textView = (TextView) relativeLayout.getChildAt(0);
                    textView.setTypeface(this.deM, this.oal);
                    textView.setTextColor(this.oaj);
                    textView.setTextSize(0, this.oai);
                    if (this.oao != -1) {
                        textView.setBackgroundResource(this.oao);
                    }
                    if (this.dez.getAdapter() instanceof b) {
                        textView.setCompoundDrawablesWithIntrinsicBounds(0, ((b) this.dez.getAdapter()).ML(i), 0, 0);
                    }
                } else {
                    RelativeLayout relativeLayout2 = (RelativeLayout) this.dey.getChildAt(i2);
                    relativeLayout2.setSelected(false);
                    TextView textView2 = (TextView) relativeLayout2.getChildAt(0);
                    textView2.setTextColor(this.tabTextColor);
                    textView2.setBackgroundResource(0);
                    textView2.setTextSize(0, this.tabTextSize);
                    textView2.setTypeface(this.deM, this.deN);
                    if (this.dez.getAdapter() instanceof b) {
                        textView2.setCompoundDrawablesWithIntrinsicBounds(0, ((b) this.dez.getAdapter()).kW(i2), 0, 0);
                    }
                }
            }
        }
    }

    public void setTabTextSelectColor(@ColorInt int i) {
        this.oaj = i;
        invalidate();
    }

    public void setIndicatorColor(int i) {
        this.oaa = i;
        invalidate();
    }

    public void setIndicatorColorResource(int i) {
        this.oaa = getResources().getColor(i);
        invalidate();
    }

    public int getIndicatorColor() {
        return this.oaa;
    }

    public void setIndicatorHeight(int i) {
        this.indicatorHeight = i;
        invalidate();
    }

    public void setIndicatorWidth(int i) {
        this.deL = i;
        invalidate();
    }

    public int getIndicatorHeight() {
        return this.indicatorHeight;
    }

    public int getIndicatorWidth() {
        return this.deL;
    }

    public void setUnderlineColor(int i) {
        this.nFL = i;
        invalidate();
    }

    public void setUnderlineColorResource(int i) {
        this.nFL = getResources().getColor(i);
        invalidate();
    }

    public int getUnderlineColor() {
        return this.nFL;
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
        this.dgD = i;
        invalidate();
    }

    public int getUnderlineHeight() {
        return this.dgD;
    }

    public void setDividerPadding(int i) {
        this.dividerPadding = i;
        invalidate();
    }

    public int getDividerPadding() {
        return this.dividerPadding;
    }

    public void setScrollOffset(int i) {
        this.deG = i;
        invalidate();
    }

    public int getScrollOffset() {
        return this.deG;
    }

    public void setShouldExpand(boolean z) {
        this.deD = z;
        requestLayout();
    }

    public boolean getShouldExpand() {
        return this.deD;
    }

    public void setAllCaps(boolean z) {
        this.oab = z;
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
        this.deM = typeface;
        this.deN = i;
        updateTabStyles();
    }

    public void setSelectedTypeface(Typeface typeface, int i) {
        this.deM = typeface;
        this.oal = i;
        updateTabStyles();
    }

    public void setTabBackground(int i) {
        this.deP = i;
    }

    public int getTabBackground() {
        return this.deP;
    }

    public void setTabPaddingLeftRight(int i) {
        this.tabPadding = i;
        updateTabStyles();
    }

    public int getTabPaddingLeftRight() {
        return this.tabPadding;
    }

    public void setIconPadding(int i) {
        this.oah = i;
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
        if (this.oaz != null) {
            this.oaz.xi(true);
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    public void setDisallowIntercept(tv.chushou.zues.widget.psts.a aVar) {
        this.oaz = aVar;
    }
}
