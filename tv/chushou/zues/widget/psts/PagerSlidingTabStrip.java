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
    private LinearLayout.LayoutParams deI;
    public ViewPager.OnPageChangeListener deK;
    private LinearLayout deL;
    private ViewPager deM;
    private int deN;
    private float deO;
    private Paint deP;
    private boolean deQ;
    private int deT;
    private int deY;
    private Typeface deZ;
    private int dfa;
    private int dfb;
    private int dfc;
    private int dgQ;
    private int dgR;
    private int dividerColor;
    private int dividerPadding;
    private DisplayMetrics dm;
    private int indicatorHeight;
    private Locale locale;
    private int mInterval;
    private final RectF mRectF;
    private int nHy;
    private LinearLayout.LayoutParams obJ;
    private d obK;
    private int obL;
    private Paint obM;
    private boolean obN;
    private int obO;
    private boolean obP;
    private boolean obQ;
    private int obR;
    private int obS;
    private int obT;
    private int obU;
    private int obV;
    private int obW;
    private int obX;
    private int obY;
    private int obZ;
    private int oca;
    private int ocb;
    private int occ;
    private boolean ocd;
    private boolean oce;
    private int ocf;
    private int ocg;
    private int och;
    private int oci;
    private int ocj;
    private boolean ock;
    private boolean ocl;
    private boolean ocm;
    private tv.chushou.zues.widget.psts.a ocn;
    private int tabPadding;
    private int tabTextColor;
    private int tabTextSize;

    /* loaded from: classes5.dex */
    public interface a {
        void eJ(int i, int i2);
    }

    /* loaded from: classes5.dex */
    public interface b {
        int MR(int i);

        String MS(int i);

        int MT(int i);

        tv.chushou.zues.widget.psts.b MU(int i);

        int kW(int i);
    }

    /* loaded from: classes5.dex */
    public interface c {
        float OJ(int i);

        int[] OK(int i);

        tv.chushou.zues.widget.psts.b OL(int i);
    }

    /* loaded from: classes5.dex */
    public interface e {
        tv.chushou.zues.widget.psts.b MU(int i);

        int[] OM(int i);
    }

    /* loaded from: classes5.dex */
    public interface f {
        int ON(int i);
    }

    /* loaded from: classes5.dex */
    public interface g {
        void bA(int i);
    }

    /* loaded from: classes5.dex */
    public interface h {
        void AX(int i);
    }

    public PagerSlidingTabStrip(Context context) {
        this(context, null);
    }

    public PagerSlidingTabStrip(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PagerSlidingTabStrip(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.obK = new d();
        this.Ev = 0;
        this.obL = 0;
        this.deO = 0.0f;
        this.obN = false;
        this.obO = -10066330;
        this.nHy = 436207616;
        this.dividerColor = 436207616;
        this.deQ = true;
        this.obP = false;
        this.deT = 52;
        this.indicatorHeight = 3;
        this.deY = 0;
        this.obQ = true;
        this.dgQ = 1;
        this.dividerPadding = 12;
        this.obR = 0;
        this.tabPadding = 24;
        this.obS = 0;
        this.obT = 0;
        this.obU = 0;
        this.dgR = 1;
        this.obV = 0;
        this.tabTextSize = 15;
        this.obW = this.tabTextSize;
        this.tabTextColor = -10066330;
        this.obX = -10066330;
        this.obY = 13;
        this.deZ = null;
        this.dfa = 0;
        this.obZ = 1;
        this.dfb = 0;
        this.oca = 1;
        this.ocb = 0;
        this.dfc = b.d.zues_psts_tab_background;
        this.occ = -1;
        this.ocd = true;
        this.oce = false;
        this.ocf = 3;
        this.oci = 16;
        this.ocj = 0;
        this.mInterval = 0;
        this.ock = false;
        this.ocl = false;
        this.ocm = true;
        this.mRectF = new RectF();
        setFillViewport(true);
        setWillNotDraw(false);
        this.deL = new LinearLayout(context);
        this.deL.setOrientation(0);
        this.deL.setGravity(16);
        this.dm = getResources().getDisplayMetrics();
        this.oci = (int) TypedValue.applyDimension(1, this.oci, this.dm);
        this.deT = (int) TypedValue.applyDimension(1, this.deT, this.dm);
        this.indicatorHeight = (int) TypedValue.applyDimension(1, this.indicatorHeight, this.dm);
        this.deY = (int) TypedValue.applyDimension(1, this.deY, this.dm);
        this.dgQ = (int) TypedValue.applyDimension(1, this.dgQ, this.dm);
        this.dividerPadding = (int) TypedValue.applyDimension(1, this.dividerPadding, this.dm);
        this.tabPadding = (int) TypedValue.applyDimension(1, this.tabPadding, this.dm);
        this.dgR = (int) TypedValue.applyDimension(1, this.dgR, this.dm);
        this.tabTextSize = (int) TypedValue.applyDimension(2, this.tabTextSize, this.dm);
        this.ocf = (int) TypedValue.applyDimension(1, this.ocf, this.dm);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, ATTRS);
        this.tabTextSize = obtainStyledAttributes.getDimensionPixelSize(0, this.tabTextSize);
        this.obW = this.tabTextSize;
        this.tabTextColor = obtainStyledAttributes.getColor(1, this.tabTextColor);
        obtainStyledAttributes.recycle();
        TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, b.i.PagerSlidingTabStrip);
        this.obO = obtainStyledAttributes2.getColor(b.i.PagerSlidingTabStrip_indicatorColor, this.obO);
        this.obQ = obtainStyledAttributes2.getBoolean(b.i.PagerSlidingTabStrip_indicatorRoundCap, false);
        this.nHy = obtainStyledAttributes2.getColor(b.i.PagerSlidingTabStrip_underlineColor, this.nHy);
        this.dividerColor = obtainStyledAttributes2.getColor(b.i.PagerSlidingTabStrip_dividerColor, this.dividerColor);
        this.obX = obtainStyledAttributes2.getColor(b.i.PagerSlidingTabStrip_tabTextSelectColor, this.dividerColor);
        this.indicatorHeight = obtainStyledAttributes2.getDimensionPixelSize(b.i.PagerSlidingTabStrip_indicatorHeight, this.indicatorHeight);
        this.deY = obtainStyledAttributes2.getDimensionPixelSize(b.i.PagerSlidingTabStrip_indicatorWidth, this.deY);
        this.dgQ = obtainStyledAttributes2.getDimensionPixelSize(b.i.PagerSlidingTabStrip_underlineHeight, this.dgQ);
        this.dividerPadding = obtainStyledAttributes2.getDimensionPixelSize(b.i.PagerSlidingTabStrip_psts_dividerPadding, this.dividerPadding);
        this.oci = obtainStyledAttributes2.getDimensionPixelSize(b.i.PagerSlidingTabStrip_psts_minInterval, this.oci);
        this.ocj = obtainStyledAttributes2.getDimensionPixelSize(b.i.PagerSlidingTabStrip_center_paddingRight, 0);
        this.obR = obtainStyledAttributes2.getDimensionPixelSize(b.i.PagerSlidingTabStrip_parentPaddingLeft, this.obR);
        this.tabPadding = obtainStyledAttributes2.getDimensionPixelSize(b.i.PagerSlidingTabStrip_tabPaddingLeftRight, this.tabPadding);
        this.obS = obtainStyledAttributes2.getDimensionPixelSize(b.i.PagerSlidingTabStrip_tabPaddingTopBottom, this.obS);
        this.obT = obtainStyledAttributes2.getDimensionPixelSize(b.i.PagerSlidingTabStrip_textPaddingLeftRight, this.obT);
        this.obU = obtainStyledAttributes2.getDimensionPixelSize(b.i.PagerSlidingTabStrip_textPaddingTopBottom, this.obU);
        this.dfc = obtainStyledAttributes2.getResourceId(b.i.PagerSlidingTabStrip_ptabBackground, this.dfc);
        this.occ = obtainStyledAttributes2.getResourceId(b.i.PagerSlidingTabStrip_textBackground, this.occ);
        this.deQ = obtainStyledAttributes2.getBoolean(b.i.PagerSlidingTabStrip_shouldExpand, this.deQ);
        this.deT = obtainStyledAttributes2.getDimensionPixelSize(b.i.PagerSlidingTabStrip_scrollOffset, this.deT);
        this.obP = obtainStyledAttributes2.getBoolean(b.i.PagerSlidingTabStrip_psts_textAllCaps, this.obP);
        this.ocd = obtainStyledAttributes2.getBoolean(b.i.PagerSlidingTabStrip_psts_tabIsWeight, this.ocd);
        this.oca = obtainStyledAttributes2.getInteger(b.i.PagerSlidingTabStrip_apsts_draw_mode, 0);
        this.ocb = obtainStyledAttributes2.getInteger(b.i.PagerSlidingTabStrip_apsts_layout_mode, 0);
        this.obW = obtainStyledAttributes2.getDimensionPixelSize(b.i.PagerSlidingTabStrip_tabTextSelectSize, this.tabTextSize);
        obtainStyledAttributes2.recycle();
        this.deP = new Paint();
        this.deP.setAntiAlias(true);
        this.deP.setStyle(Paint.Style.FILL);
        this.obM = new Paint();
        this.obM.setAntiAlias(true);
        this.obM.setStrokeWidth(this.dgR);
        if (this.ocb == 0) {
            this.deI = new LinearLayout.LayoutParams(0, -1, 1.0f);
            this.obJ = new LinearLayout.LayoutParams(0, -1, 1.0f);
            this.obJ.setMargins(0, 0, 0, 0);
        } else {
            this.deI = new LinearLayout.LayoutParams(-2, -1);
            this.obJ = new LinearLayout.LayoutParams(-2, -1);
            this.obJ.setMargins(0, 0, 0, 0);
        }
        if (this.locale == null) {
            this.locale = getResources().getConfiguration().locale;
        }
        this.deL.setPadding(this.obR, this.deL.getPaddingTop(), this.deL.getPaddingRight(), this.deL.getPaddingBottom());
        this.deL.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        addView(this.deL);
    }

    public void setControlWidth(int i) {
        this.ocg = i;
    }

    /* loaded from: classes5.dex */
    public class NewAdapter extends FragmentStatePagerAdapter implements h {
        private List<String> mDatas;
        private g ocp;

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
        public void AX(int i) {
            if (this.ocp != null) {
                this.ocp.bA(i);
            }
        }
    }

    public boolean c(ViewPager viewPager) {
        return a(viewPager, false);
    }

    public boolean a(ViewPager viewPager, boolean z) {
        this.deM = viewPager;
        if (viewPager.getAdapter() == null) {
            throw new IllegalStateException("ViewPager does not have adapter instance.");
        }
        if (!z) {
            viewPager.addOnPageChangeListener(this.obK);
        }
        notifyDataSetChanged();
        return this.oce;
    }

    public void setViewpageSmoothScroll(boolean z) {
        this.ocm = z;
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.deK = onPageChangeListener;
    }

    public void notifyDataSetChanged() {
        tv.chushou.zues.widget.psts.b bVar;
        int[] iArr;
        this.och = 0;
        this.oce = false;
        this.mInterval = this.oci;
        this.deL.removeAllViews();
        this.deN = this.deM.getAdapter().getCount();
        for (int i = 0; i < this.deN; i++) {
            if (this.deM.getAdapter() instanceof b) {
                a(i, ((b) this.deM.getAdapter()).kW(i), ((b) this.deM.getAdapter()).MS(i), ((b) this.deM.getAdapter()).MU(i), ((b) this.deM.getAdapter()).MT(i));
            } else {
                if (this.deM.getAdapter() instanceof e) {
                    e eVar = (e) this.deM.getAdapter();
                    iArr = eVar.OM(i);
                    bVar = eVar.MU(i);
                } else {
                    bVar = null;
                    iArr = null;
                }
                a(i, this.deM.getAdapter().getPageTitle(i).toString(), iArr, bVar, this.deM.getAdapter() instanceof f ? ((f) this.deM.getAdapter()).ON(i) : 0);
            }
        }
        if (this.ocb != 0) {
            if (this.ocg == 0) {
                this.ocg = tv.chushou.zues.utils.a.hd(getContext()).x;
            }
            this.ocg -= this.deL.getPaddingLeft();
            int i2 = (this.ocg - this.och) / (this.deN + 1);
            if (this.ocb == 1) {
                if (this.mInterval < i2) {
                    this.mInterval = i2;
                } else {
                    this.oce = true;
                }
                this.deI.setMargins(this.mInterval, 0, 0, 0);
            } else if (this.ocb == 2) {
                if (this.mInterval < (this.ocg - this.och) / (this.deN + 1)) {
                    this.deL.setGravity(17);
                    this.deL.setPadding(0, this.deL.getPaddingTop(), this.ocj, this.deL.getPaddingBottom());
                } else {
                    this.oce = true;
                }
                this.deI.setMargins(this.mInterval, 0, 0, 0);
            } else if (this.ocb == 3) {
                if (this.mInterval >= i2) {
                    this.oce = true;
                }
                this.deI.setMargins(this.mInterval, 0, 0, 0);
            }
        }
        updateTabStyles();
        this.obN = false;
        getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: tv.chushou.zues.widget.psts.PagerSlidingTabStrip.1
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            @SuppressLint({"NewApi"})
            public void onGlobalLayout() {
                if (Build.VERSION.SDK_INT < 16) {
                    PagerSlidingTabStrip.this.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                } else {
                    PagerSlidingTabStrip.this.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                }
                if (PagerSlidingTabStrip.this.deM != null) {
                    PagerSlidingTabStrip.this.Ev = PagerSlidingTabStrip.this.deM.getCurrentItem();
                    PagerSlidingTabStrip.this.eI(PagerSlidingTabStrip.this.obL, 0);
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
        layoutParams.addRule(this.obY);
        textView.setLayoutParams(layoutParams);
        textView.setPadding(this.obT, this.obU, this.obT, this.obU);
        textView.setCompoundDrawablePadding(getContext().getResources().getDimensionPixelSize(b.c.zues_psts_text_draw_padding));
        textView.setCompoundDrawablesWithIntrinsicBounds(0, 0, i2, 0);
        relativeLayout.setOnClickListener(new View.OnClickListener() { // from class: tv.chushou.zues.widget.psts.PagerSlidingTabStrip.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int i3 = PagerSlidingTabStrip.this.Ev;
                boolean eI = PagerSlidingTabStrip.this.eI(i, 0);
                PagerSlidingTabStrip.this.deM.setCurrentItem(i, PagerSlidingTabStrip.this.ocm);
                if (PagerSlidingTabStrip.this.ocl) {
                    if (!eI && (PagerSlidingTabStrip.this.deM.getAdapter() instanceof h)) {
                        ((h) PagerSlidingTabStrip.this.deM.getAdapter()).AX(i);
                    }
                } else if (eI && (PagerSlidingTabStrip.this.deM.getAdapter() instanceof h)) {
                    ((h) PagerSlidingTabStrip.this.deM.getAdapter()).AX(i);
                }
                if (PagerSlidingTabStrip.this.deM.getAdapter() instanceof a) {
                    ((a) PagerSlidingTabStrip.this.deM.getAdapter()).eJ(i, i3);
                }
                PagerSlidingTabStrip.this.Ev = i;
                if (PagerSlidingTabStrip.this.ocl) {
                    PagerSlidingTabStrip.this.deO = 0.0f;
                    PagerSlidingTabStrip.this.obL = i;
                    PagerSlidingTabStrip.this.setSelectItem(i);
                    PagerSlidingTabStrip.this.eI(i, PagerSlidingTabStrip.this.deL.getChildAt(i).getWidth() * 0);
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
        textView2.setTextColor(resources.getColor(b.C0808b.zues_white));
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
        this.deL.addView(relativeLayout);
        if (this.ocb != 0) {
            Rect rect = new Rect();
            textView.getPaint().getTextBounds(str, 0, str.length(), rect);
            this.och = rect.width() + this.ocf + (this.obT * 2) + this.och;
        }
    }

    public void setTagRightImg(int i, @DrawableRes int i2) {
        TextView textView = (TextView) ((RelativeLayout) this.deL.getChildAt(i)).findViewById(b.e.zues_psts_tab_tag);
        if (textView != null) {
            textView.setCompoundDrawablesWithIntrinsicBounds(0, 0, i2, 0);
        }
    }

    public void setTagText(int i, String str) {
        TextView textView = (TextView) ((RelativeLayout) this.deL.getChildAt(i)).findViewById(b.e.zues_psts_tab_tag);
        if (textView != null) {
            textView.setText(str);
        }
    }

    public void bl(int i, String str) {
        RelativeLayout relativeLayout = (RelativeLayout) this.deL.getChildAt(i);
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

    public void OG(int i) {
        RelativeLayout relativeLayout = (RelativeLayout) this.deL.getChildAt(i);
        View childAt = relativeLayout.getChildAt(relativeLayout.getChildCount() - 3);
        if (childAt != null) {
            childAt.setVisibility(8);
        }
    }

    public void OH(int i) {
        RelativeLayout relativeLayout;
        View childAt;
        if (this.deL != null && (relativeLayout = (RelativeLayout) this.deL.getChildAt(i)) != null && (childAt = relativeLayout.getChildAt(relativeLayout.getChildCount() - 1)) != null) {
            ((ImageView) childAt).setVisibility(0);
        }
    }

    public void OI(int i) {
        RelativeLayout relativeLayout;
        View childAt;
        if (this.deL != null && (relativeLayout = (RelativeLayout) this.deL.getChildAt(i)) != null && (childAt = relativeLayout.getChildAt(relativeLayout.getChildCount() - 1)) != null) {
            ((ImageView) childAt).setVisibility(8);
        }
    }

    private void a(final int i, int i2, String str, tv.chushou.zues.widget.psts.b bVar, int i3) {
        RelativeLayout relativeLayout = new RelativeLayout(getContext());
        relativeLayout.setOnClickListener(new View.OnClickListener() { // from class: tv.chushou.zues.widget.psts.PagerSlidingTabStrip.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int i4 = PagerSlidingTabStrip.this.Ev;
                boolean eI = PagerSlidingTabStrip.this.eI(i, 0);
                PagerSlidingTabStrip.this.deM.setCurrentItem(i, PagerSlidingTabStrip.this.ocm);
                if (eI && (PagerSlidingTabStrip.this.deM.getAdapter() instanceof h)) {
                    ((h) PagerSlidingTabStrip.this.deM.getAdapter()).AX(i);
                }
                if (PagerSlidingTabStrip.this.deM.getAdapter() instanceof a) {
                    ((a) PagerSlidingTabStrip.this.deM.getAdapter()).eJ(i, i4);
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
        if (this.deM.getAdapter() instanceof c) {
            c cVar = (c) this.deM.getAdapter();
            for (int i4 : cVar.OK(i)) {
                layoutParams.addRule(Integer.valueOf(i4).intValue());
            }
            tv.chushou.zues.widget.psts.b OL = cVar.OL(i);
            if (OL != null) {
                layoutParams.setMargins(OL.mLeft, OL.mTop, OL.mRight, OL.mBottom);
            }
        }
        textView.setLayoutParams(layoutParams);
        if (i2 != 0) {
            textView.setCompoundDrawablesWithIntrinsicBounds(0, i2, 0, 0);
            textView.setCompoundDrawablePadding(this.obV);
        }
        Resources resources = getContext().getResources();
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, resources.getDimensionPixelSize(b.c.zues_psts_red_text_dot_size));
        layoutParams2.addRule(11);
        layoutParams2.topMargin = (int) tv.chushou.zues.utils.a.a(1, 2.0f, getContext());
        TextView textView2 = new TextView(getContext());
        textView2.setBackgroundResource(b.d.zues_psts_text_red_dot);
        textView2.setTextColor(resources.getColor(b.C0808b.zues_white));
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
        this.deL.addView(relativeLayout);
    }

    private void updateTabStyles() {
        for (int i = 0; i < this.deN; i++) {
            View childAt = this.deL.getChildAt(i);
            if (i != 0) {
                childAt.setLayoutParams(this.deI);
            } else {
                childAt.setLayoutParams(this.obJ);
            }
            setMyTabLayoutParams(childAt);
            childAt.setBackgroundResource(this.dfc);
            if (this.deQ) {
                childAt.setPadding(0, 0, 0, 0);
            } else {
                childAt.setPadding(this.tabPadding, this.obS, this.tabPadding, this.obS);
            }
            if (childAt instanceof RelativeLayout) {
                TextView textView = (TextView) ((RelativeLayout) childAt).getChildAt(0);
                textView.setTextSize(0, this.tabTextSize);
                textView.setTypeface(this.deZ, this.dfa);
                textView.setTextColor(this.tabTextColor);
                if (this.obP) {
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

    public boolean dRs() {
        c cVar;
        if (this.deM != null && this.deM.getAdapter() != null && (this.deM.getAdapter() instanceof c) && (cVar = (c) this.deM.getAdapter()) != null) {
            for (int i = 0; i < this.deN; i++) {
                float OJ = cVar.OJ(i);
                if (OJ != 0.0f) {
                    if (OJ == 0.0f) {
                        OJ = 1.0f;
                    }
                    this.deL.getChildAt(i).setLayoutParams(new LinearLayout.LayoutParams(0, -1, OJ));
                } else {
                    if (i != 0) {
                        this.deL.getChildAt(i).setLayoutParams(this.deI);
                    } else {
                        this.deL.getChildAt(i).setLayoutParams(this.obJ);
                    }
                    setMyTabLayoutParams(this.deL.getChildAt(i));
                }
            }
        }
        return false;
    }

    @Override // android.widget.HorizontalScrollView, android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (!this.deQ || View.MeasureSpec.getMode(i) == 0) {
            dRs();
            return;
        }
        int measuredWidth = getMeasuredWidth();
        int i3 = 0;
        for (int i4 = 0; i4 < this.deN; i4++) {
            i3 += this.deL.getChildAt(i4).getMeasuredWidth();
        }
        if (!this.obN && i3 > 0 && measuredWidth > 0) {
            if (i3 <= measuredWidth) {
                for (int i5 = 0; i5 < this.deN; i5++) {
                    if (i5 != 0) {
                        this.deL.getChildAt(i5).setLayoutParams(this.deI);
                    } else {
                        this.deL.getChildAt(i5).setLayoutParams(this.obJ);
                    }
                    setMyTabLayoutParams(this.deL.getChildAt(i5));
                }
            }
            this.obN = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean eI(int i, int i2) {
        if (this.deN == 0) {
            return false;
        }
        int left = this.deL.getChildAt(i).getLeft() + i2;
        if (i > 0 || i2 > 0) {
            left -= this.deT;
        }
        int i3 = left - this.mInterval;
        if (i3 != this.dfb) {
            this.dfb = i3;
            scrollTo(i3, 0);
            return false;
        }
        return true;
    }

    public void setTabDrawMode(int i) {
        this.oca = i;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (!isInEditMode() && this.deN != 0) {
            if (this.oca == 0) {
                ar(canvas);
            } else {
                as(canvas);
            }
        }
    }

    private void ar(Canvas canvas) {
        int height = getHeight();
        this.deP.setColor(this.obO);
        View childAt = this.deL.getChildAt(this.Ev);
        float left = childAt.getLeft();
        float right = childAt.getRight();
        if (this.deO > 0.0f && this.Ev < this.deN - 1) {
            View childAt2 = this.deL.getChildAt(this.Ev + 1);
            left = (left * (1.0f - this.deO)) + (childAt2.getLeft() * this.deO);
            right = (childAt2.getRight() * this.deO) + ((1.0f - this.deO) * right);
        }
        if (this.deY > 0) {
            float f2 = ((right - left) - this.deY) / 2.0f;
            this.mRectF.set(left + f2, height - this.indicatorHeight, f2 + left + this.deY, height);
            if (this.obQ) {
                canvas.drawRoundRect(this.mRectF, this.indicatorHeight / 2, this.indicatorHeight / 2, this.deP);
            } else {
                canvas.drawRect(this.mRectF, this.deP);
            }
        } else {
            canvas.drawRect(left, height - this.indicatorHeight, right, height, this.deP);
        }
        this.deP.setColor(this.nHy);
        canvas.drawRect(0.0f, height - this.dgQ, this.deL.getWidth(), height, this.deP);
        this.obM.setColor(this.dividerColor);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.deN - 1) {
                View childAt3 = this.deL.getChildAt(i2);
                canvas.drawLine(childAt3.getRight(), this.dividerPadding, childAt3.getRight(), height - this.dividerPadding, this.obM);
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
        this.deP.setColor(this.nHy);
        canvas.drawRect(0.0f, height - this.dgQ, this.deL.getWidth(), height, this.deP);
        this.deP.setColor(this.obO);
        View childAt = this.deL.getChildAt(this.Ev);
        float left = childAt.getLeft();
        View childAt2 = ((RelativeLayout) childAt).getChildAt(0);
        float left2 = childAt2.getLeft();
        float right = childAt2.getRight();
        if (this.deO <= 0.0f || this.Ev >= this.deN - 1) {
            f2 = right;
            f3 = left2;
            f4 = left;
        } else {
            View childAt3 = this.deL.getChildAt(this.Ev + 1);
            float left3 = (left * (1.0f - this.deO)) + (childAt3.getLeft() * this.deO);
            View childAt4 = ((RelativeLayout) childAt3).getChildAt(0);
            f3 = (childAt4.getLeft() * this.deO) + (left2 * (1.0f - this.deO));
            f2 = (childAt4.getRight() * this.deO) + (right * (1.0f - this.deO));
            f4 = left3;
        }
        if (this.deY > 0) {
            float f5 = ((f2 - f3) - this.deY) / 2.0f;
            this.mRectF.set(f4 + f3 + f5, height - this.indicatorHeight, f5 + f3 + f4 + this.deY, height);
            if (this.obQ) {
                canvas.drawRoundRect(this.mRectF, this.indicatorHeight / 2, this.indicatorHeight / 2, this.deP);
            } else {
                canvas.drawRect(this.mRectF, this.deP);
            }
        } else {
            canvas.drawRect(f3 + f4, height - this.indicatorHeight, f4 + f2, height, this.deP);
        }
        this.obM.setColor(this.dividerColor);
        this.deP.setColor(this.nHy);
        for (int i = 0; i < this.deN; i++) {
            View childAt5 = this.deL.getChildAt(i);
            if (i < this.deN - 1) {
                canvas.drawLine(childAt5.getRight(), this.dividerPadding, childAt5.getRight(), height - this.dividerPadding, this.obM);
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
            PagerSlidingTabStrip.this.deO = f;
            if (PagerSlidingTabStrip.this.deL != null) {
                PagerSlidingTabStrip.this.eI(i, (int) (PagerSlidingTabStrip.this.deL.getChildAt(i).getWidth() * f));
            }
            PagerSlidingTabStrip.this.invalidate();
            if (PagerSlidingTabStrip.this.deK != null) {
                PagerSlidingTabStrip.this.deK.onPageScrolled(i, f, i2);
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            if (i == 0) {
                PagerSlidingTabStrip.this.eI(PagerSlidingTabStrip.this.deM.getCurrentItem(), 0);
            }
            if (PagerSlidingTabStrip.this.deK != null) {
                PagerSlidingTabStrip.this.deK.onPageScrollStateChanged(i);
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            PagerSlidingTabStrip.this.setSelectItem(i);
            if (PagerSlidingTabStrip.this.deK != null) {
                PagerSlidingTabStrip.this.deK.onPageSelected(i);
            }
        }
    }

    public void setSelectItem(int i) {
        if (this.deL != null) {
            this.obL = i;
            for (int i2 = 0; i2 < this.deL.getChildCount(); i2++) {
                if (i2 == i) {
                    RelativeLayout relativeLayout = (RelativeLayout) this.deL.getChildAt(i);
                    relativeLayout.setSelected(true);
                    TextView textView = (TextView) relativeLayout.getChildAt(0);
                    textView.setTypeface(this.deZ, this.obZ);
                    textView.setTextColor(this.obX);
                    textView.setTextSize(0, this.obW);
                    if (this.occ != -1) {
                        textView.setBackgroundResource(this.occ);
                    }
                    if (this.deM.getAdapter() instanceof b) {
                        textView.setCompoundDrawablesWithIntrinsicBounds(0, ((b) this.deM.getAdapter()).MR(i), 0, 0);
                    }
                } else {
                    RelativeLayout relativeLayout2 = (RelativeLayout) this.deL.getChildAt(i2);
                    relativeLayout2.setSelected(false);
                    TextView textView2 = (TextView) relativeLayout2.getChildAt(0);
                    textView2.setTextColor(this.tabTextColor);
                    textView2.setBackgroundResource(0);
                    textView2.setTextSize(0, this.tabTextSize);
                    textView2.setTypeface(this.deZ, this.dfa);
                    if (this.deM.getAdapter() instanceof b) {
                        textView2.setCompoundDrawablesWithIntrinsicBounds(0, ((b) this.deM.getAdapter()).kW(i2), 0, 0);
                    }
                }
            }
        }
    }

    public void setTabTextSelectColor(@ColorInt int i) {
        this.obX = i;
        invalidate();
    }

    public void setIndicatorColor(int i) {
        this.obO = i;
        invalidate();
    }

    public void setIndicatorColorResource(int i) {
        this.obO = getResources().getColor(i);
        invalidate();
    }

    public int getIndicatorColor() {
        return this.obO;
    }

    public void setIndicatorHeight(int i) {
        this.indicatorHeight = i;
        invalidate();
    }

    public void setIndicatorWidth(int i) {
        this.deY = i;
        invalidate();
    }

    public int getIndicatorHeight() {
        return this.indicatorHeight;
    }

    public int getIndicatorWidth() {
        return this.deY;
    }

    public void setUnderlineColor(int i) {
        this.nHy = i;
        invalidate();
    }

    public void setUnderlineColorResource(int i) {
        this.nHy = getResources().getColor(i);
        invalidate();
    }

    public int getUnderlineColor() {
        return this.nHy;
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
        this.dgQ = i;
        invalidate();
    }

    public int getUnderlineHeight() {
        return this.dgQ;
    }

    public void setDividerPadding(int i) {
        this.dividerPadding = i;
        invalidate();
    }

    public int getDividerPadding() {
        return this.dividerPadding;
    }

    public void setScrollOffset(int i) {
        this.deT = i;
        invalidate();
    }

    public int getScrollOffset() {
        return this.deT;
    }

    public void setShouldExpand(boolean z) {
        this.deQ = z;
        requestLayout();
    }

    public boolean getShouldExpand() {
        return this.deQ;
    }

    public void setAllCaps(boolean z) {
        this.obP = z;
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
        this.deZ = typeface;
        this.dfa = i;
        updateTabStyles();
    }

    public void setSelectedTypeface(Typeface typeface, int i) {
        this.deZ = typeface;
        this.obZ = i;
        updateTabStyles();
    }

    public void setTabBackground(int i) {
        this.dfc = i;
    }

    public int getTabBackground() {
        return this.dfc;
    }

    public void setTabPaddingLeftRight(int i) {
        this.tabPadding = i;
        updateTabStyles();
    }

    public int getTabPaddingLeftRight() {
        return this.tabPadding;
    }

    public void setIconPadding(int i) {
        this.obV = i;
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
            /* renamed from: OO */
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
        if (this.ocn != null) {
            this.ocn.xq(true);
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    public void setDisallowIntercept(tv.chushou.zues.widget.psts.a aVar) {
        this.ocn = aVar;
    }
}
