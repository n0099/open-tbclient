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
    private int deC;
    private LinearLayout.LayoutParams deh;
    public ViewPager.OnPageChangeListener dej;
    private LinearLayout dek;
    private ViewPager del;
    private int dem;
    private float den;
    private Paint deo;
    private boolean dep;
    private int det;
    private int dey;
    private Typeface dez;
    private int dgq;
    private int dgr;
    private int dividerColor;
    private int dividerPadding;
    private DisplayMetrics dm;
    private int indicatorHeight;
    private Locale locale;
    private int mInterval;
    private final RectF mRectF;
    private int nFA;
    private LinearLayout.LayoutParams nZK;
    private d nZL;
    private int nZM;
    private Paint nZN;
    private boolean nZO;
    private int nZP;
    private boolean nZQ;
    private boolean nZR;
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
    private int oac;
    private int oad;
    private boolean oae;
    private boolean oaf;
    private int oag;
    private int oah;
    private int oai;
    private int oaj;
    private int oak;
    private boolean oal;
    private boolean oam;
    private boolean oan;
    private tv.chushou.zues.widget.psts.a oao;
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
        this.nZL = new d();
        this.Ev = 0;
        this.nZM = 0;
        this.den = 0.0f;
        this.nZO = false;
        this.nZP = -10066330;
        this.nFA = 436207616;
        this.dividerColor = 436207616;
        this.dep = true;
        this.nZQ = false;
        this.det = 52;
        this.indicatorHeight = 3;
        this.dey = 0;
        this.nZR = true;
        this.dgq = 1;
        this.dividerPadding = 12;
        this.nZS = 0;
        this.tabPadding = 24;
        this.nZT = 0;
        this.nZU = 0;
        this.nZV = 0;
        this.dgr = 1;
        this.nZW = 0;
        this.tabTextSize = 15;
        this.nZX = this.tabTextSize;
        this.tabTextColor = -10066330;
        this.nZY = -10066330;
        this.nZZ = 13;
        this.dez = null;
        this.deA = 0;
        this.oaa = 1;
        this.deB = 0;
        this.oab = 1;
        this.oac = 0;
        this.deC = b.d.zues_psts_tab_background;
        this.oad = -1;
        this.oae = true;
        this.oaf = false;
        this.oag = 3;
        this.oaj = 16;
        this.oak = 0;
        this.mInterval = 0;
        this.oal = false;
        this.oam = false;
        this.oan = true;
        this.mRectF = new RectF();
        setFillViewport(true);
        setWillNotDraw(false);
        this.dek = new LinearLayout(context);
        this.dek.setOrientation(0);
        this.dek.setGravity(16);
        this.dm = getResources().getDisplayMetrics();
        this.oaj = (int) TypedValue.applyDimension(1, this.oaj, this.dm);
        this.det = (int) TypedValue.applyDimension(1, this.det, this.dm);
        this.indicatorHeight = (int) TypedValue.applyDimension(1, this.indicatorHeight, this.dm);
        this.dey = (int) TypedValue.applyDimension(1, this.dey, this.dm);
        this.dgq = (int) TypedValue.applyDimension(1, this.dgq, this.dm);
        this.dividerPadding = (int) TypedValue.applyDimension(1, this.dividerPadding, this.dm);
        this.tabPadding = (int) TypedValue.applyDimension(1, this.tabPadding, this.dm);
        this.dgr = (int) TypedValue.applyDimension(1, this.dgr, this.dm);
        this.tabTextSize = (int) TypedValue.applyDimension(2, this.tabTextSize, this.dm);
        this.oag = (int) TypedValue.applyDimension(1, this.oag, this.dm);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, ATTRS);
        this.tabTextSize = obtainStyledAttributes.getDimensionPixelSize(0, this.tabTextSize);
        this.nZX = this.tabTextSize;
        this.tabTextColor = obtainStyledAttributes.getColor(1, this.tabTextColor);
        obtainStyledAttributes.recycle();
        TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, b.i.PagerSlidingTabStrip);
        this.nZP = obtainStyledAttributes2.getColor(b.i.PagerSlidingTabStrip_indicatorColor, this.nZP);
        this.nZR = obtainStyledAttributes2.getBoolean(b.i.PagerSlidingTabStrip_indicatorRoundCap, false);
        this.nFA = obtainStyledAttributes2.getColor(b.i.PagerSlidingTabStrip_underlineColor, this.nFA);
        this.dividerColor = obtainStyledAttributes2.getColor(b.i.PagerSlidingTabStrip_dividerColor, this.dividerColor);
        this.nZY = obtainStyledAttributes2.getColor(b.i.PagerSlidingTabStrip_tabTextSelectColor, this.dividerColor);
        this.indicatorHeight = obtainStyledAttributes2.getDimensionPixelSize(b.i.PagerSlidingTabStrip_indicatorHeight, this.indicatorHeight);
        this.dey = obtainStyledAttributes2.getDimensionPixelSize(b.i.PagerSlidingTabStrip_indicatorWidth, this.dey);
        this.dgq = obtainStyledAttributes2.getDimensionPixelSize(b.i.PagerSlidingTabStrip_underlineHeight, this.dgq);
        this.dividerPadding = obtainStyledAttributes2.getDimensionPixelSize(b.i.PagerSlidingTabStrip_psts_dividerPadding, this.dividerPadding);
        this.oaj = obtainStyledAttributes2.getDimensionPixelSize(b.i.PagerSlidingTabStrip_psts_minInterval, this.oaj);
        this.oak = obtainStyledAttributes2.getDimensionPixelSize(b.i.PagerSlidingTabStrip_center_paddingRight, 0);
        this.nZS = obtainStyledAttributes2.getDimensionPixelSize(b.i.PagerSlidingTabStrip_parentPaddingLeft, this.nZS);
        this.tabPadding = obtainStyledAttributes2.getDimensionPixelSize(b.i.PagerSlidingTabStrip_tabPaddingLeftRight, this.tabPadding);
        this.nZT = obtainStyledAttributes2.getDimensionPixelSize(b.i.PagerSlidingTabStrip_tabPaddingTopBottom, this.nZT);
        this.nZU = obtainStyledAttributes2.getDimensionPixelSize(b.i.PagerSlidingTabStrip_textPaddingLeftRight, this.nZU);
        this.nZV = obtainStyledAttributes2.getDimensionPixelSize(b.i.PagerSlidingTabStrip_textPaddingTopBottom, this.nZV);
        this.deC = obtainStyledAttributes2.getResourceId(b.i.PagerSlidingTabStrip_ptabBackground, this.deC);
        this.oad = obtainStyledAttributes2.getResourceId(b.i.PagerSlidingTabStrip_textBackground, this.oad);
        this.dep = obtainStyledAttributes2.getBoolean(b.i.PagerSlidingTabStrip_shouldExpand, this.dep);
        this.det = obtainStyledAttributes2.getDimensionPixelSize(b.i.PagerSlidingTabStrip_scrollOffset, this.det);
        this.nZQ = obtainStyledAttributes2.getBoolean(b.i.PagerSlidingTabStrip_psts_textAllCaps, this.nZQ);
        this.oae = obtainStyledAttributes2.getBoolean(b.i.PagerSlidingTabStrip_psts_tabIsWeight, this.oae);
        this.oab = obtainStyledAttributes2.getInteger(b.i.PagerSlidingTabStrip_apsts_draw_mode, 0);
        this.oac = obtainStyledAttributes2.getInteger(b.i.PagerSlidingTabStrip_apsts_layout_mode, 0);
        this.nZX = obtainStyledAttributes2.getDimensionPixelSize(b.i.PagerSlidingTabStrip_tabTextSelectSize, this.tabTextSize);
        obtainStyledAttributes2.recycle();
        this.deo = new Paint();
        this.deo.setAntiAlias(true);
        this.deo.setStyle(Paint.Style.FILL);
        this.nZN = new Paint();
        this.nZN.setAntiAlias(true);
        this.nZN.setStrokeWidth(this.dgr);
        if (this.oac == 0) {
            this.deh = new LinearLayout.LayoutParams(0, -1, 1.0f);
            this.nZK = new LinearLayout.LayoutParams(0, -1, 1.0f);
            this.nZK.setMargins(0, 0, 0, 0);
        } else {
            this.deh = new LinearLayout.LayoutParams(-2, -1);
            this.nZK = new LinearLayout.LayoutParams(-2, -1);
            this.nZK.setMargins(0, 0, 0, 0);
        }
        if (this.locale == null) {
            this.locale = getResources().getConfiguration().locale;
        }
        this.dek.setPadding(this.nZS, this.dek.getPaddingTop(), this.dek.getPaddingRight(), this.dek.getPaddingBottom());
        this.dek.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        addView(this.dek);
    }

    public void setControlWidth(int i) {
        this.oah = i;
    }

    /* loaded from: classes5.dex */
    public class NewAdapter extends FragmentStatePagerAdapter implements h {
        private List<String> mDatas;
        private g oaq;

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
            if (this.oaq != null) {
                this.oaq.bA(i);
            }
        }
    }

    public boolean c(ViewPager viewPager) {
        return a(viewPager, false);
    }

    public boolean a(ViewPager viewPager, boolean z) {
        this.del = viewPager;
        if (viewPager.getAdapter() == null) {
            throw new IllegalStateException("ViewPager does not have adapter instance.");
        }
        if (!z) {
            viewPager.addOnPageChangeListener(this.nZL);
        }
        notifyDataSetChanged();
        return this.oaf;
    }

    public void setViewpageSmoothScroll(boolean z) {
        this.oan = z;
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.dej = onPageChangeListener;
    }

    public void notifyDataSetChanged() {
        tv.chushou.zues.widget.psts.b bVar;
        int[] iArr;
        this.oai = 0;
        this.oaf = false;
        this.mInterval = this.oaj;
        this.dek.removeAllViews();
        this.dem = this.del.getAdapter().getCount();
        for (int i = 0; i < this.dem; i++) {
            if (this.del.getAdapter() instanceof b) {
                a(i, ((b) this.del.getAdapter()).kW(i), ((b) this.del.getAdapter()).MM(i), ((b) this.del.getAdapter()).MO(i), ((b) this.del.getAdapter()).MN(i));
            } else {
                if (this.del.getAdapter() instanceof e) {
                    e eVar = (e) this.del.getAdapter();
                    iArr = eVar.OG(i);
                    bVar = eVar.MO(i);
                } else {
                    bVar = null;
                    iArr = null;
                }
                a(i, this.del.getAdapter().getPageTitle(i).toString(), iArr, bVar, this.del.getAdapter() instanceof f ? ((f) this.del.getAdapter()).OH(i) : 0);
            }
        }
        if (this.oac != 0) {
            if (this.oah == 0) {
                this.oah = tv.chushou.zues.utils.a.he(getContext()).x;
            }
            this.oah -= this.dek.getPaddingLeft();
            int i2 = (this.oah - this.oai) / (this.dem + 1);
            if (this.oac == 1) {
                if (this.mInterval < i2) {
                    this.mInterval = i2;
                } else {
                    this.oaf = true;
                }
                this.deh.setMargins(this.mInterval, 0, 0, 0);
            } else if (this.oac == 2) {
                if (this.mInterval < (this.oah - this.oai) / (this.dem + 1)) {
                    this.dek.setGravity(17);
                    this.dek.setPadding(0, this.dek.getPaddingTop(), this.oak, this.dek.getPaddingBottom());
                } else {
                    this.oaf = true;
                }
                this.deh.setMargins(this.mInterval, 0, 0, 0);
            } else if (this.oac == 3) {
                if (this.mInterval >= i2) {
                    this.oaf = true;
                }
                this.deh.setMargins(this.mInterval, 0, 0, 0);
            }
        }
        updateTabStyles();
        this.nZO = false;
        getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: tv.chushou.zues.widget.psts.PagerSlidingTabStrip.1
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            @SuppressLint({"NewApi"})
            public void onGlobalLayout() {
                if (Build.VERSION.SDK_INT < 16) {
                    PagerSlidingTabStrip.this.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                } else {
                    PagerSlidingTabStrip.this.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                }
                if (PagerSlidingTabStrip.this.del != null) {
                    PagerSlidingTabStrip.this.Ev = PagerSlidingTabStrip.this.del.getCurrentItem();
                    PagerSlidingTabStrip.this.eH(PagerSlidingTabStrip.this.nZM, 0);
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
        layoutParams.addRule(this.nZZ);
        textView.setLayoutParams(layoutParams);
        textView.setPadding(this.nZU, this.nZV, this.nZU, this.nZV);
        textView.setCompoundDrawablePadding(getContext().getResources().getDimensionPixelSize(b.c.zues_psts_text_draw_padding));
        textView.setCompoundDrawablesWithIntrinsicBounds(0, 0, i2, 0);
        relativeLayout.setOnClickListener(new View.OnClickListener() { // from class: tv.chushou.zues.widget.psts.PagerSlidingTabStrip.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int i3 = PagerSlidingTabStrip.this.Ev;
                boolean eH = PagerSlidingTabStrip.this.eH(i, 0);
                PagerSlidingTabStrip.this.del.setCurrentItem(i, PagerSlidingTabStrip.this.oan);
                if (PagerSlidingTabStrip.this.oam) {
                    if (!eH && (PagerSlidingTabStrip.this.del.getAdapter() instanceof h)) {
                        ((h) PagerSlidingTabStrip.this.del.getAdapter()).AP(i);
                    }
                } else if (eH && (PagerSlidingTabStrip.this.del.getAdapter() instanceof h)) {
                    ((h) PagerSlidingTabStrip.this.del.getAdapter()).AP(i);
                }
                if (PagerSlidingTabStrip.this.del.getAdapter() instanceof a) {
                    ((a) PagerSlidingTabStrip.this.del.getAdapter()).eI(i, i3);
                }
                PagerSlidingTabStrip.this.Ev = i;
                if (PagerSlidingTabStrip.this.oam) {
                    PagerSlidingTabStrip.this.den = 0.0f;
                    PagerSlidingTabStrip.this.nZM = i;
                    PagerSlidingTabStrip.this.setSelectItem(i);
                    PagerSlidingTabStrip.this.eH(i, PagerSlidingTabStrip.this.dek.getChildAt(i).getWidth() * 0);
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
        this.dek.addView(relativeLayout);
        if (this.oac != 0) {
            Rect rect = new Rect();
            textView.getPaint().getTextBounds(str, 0, str.length(), rect);
            this.oai = rect.width() + this.oag + (this.nZU * 2) + this.oai;
        }
    }

    public void setTagRightImg(int i, @DrawableRes int i2) {
        TextView textView = (TextView) ((RelativeLayout) this.dek.getChildAt(i)).findViewById(b.e.zues_psts_tab_tag);
        if (textView != null) {
            textView.setCompoundDrawablesWithIntrinsicBounds(0, 0, i2, 0);
        }
    }

    public void setTagText(int i, String str) {
        TextView textView = (TextView) ((RelativeLayout) this.dek.getChildAt(i)).findViewById(b.e.zues_psts_tab_tag);
        if (textView != null) {
            textView.setText(str);
        }
    }

    public void bl(int i, String str) {
        RelativeLayout relativeLayout = (RelativeLayout) this.dek.getChildAt(i);
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
        RelativeLayout relativeLayout = (RelativeLayout) this.dek.getChildAt(i);
        View childAt = relativeLayout.getChildAt(relativeLayout.getChildCount() - 3);
        if (childAt != null) {
            childAt.setVisibility(8);
        }
    }

    public void OB(int i) {
        RelativeLayout relativeLayout;
        View childAt;
        if (this.dek != null && (relativeLayout = (RelativeLayout) this.dek.getChildAt(i)) != null && (childAt = relativeLayout.getChildAt(relativeLayout.getChildCount() - 1)) != null) {
            ((ImageView) childAt).setVisibility(0);
        }
    }

    public void OC(int i) {
        RelativeLayout relativeLayout;
        View childAt;
        if (this.dek != null && (relativeLayout = (RelativeLayout) this.dek.getChildAt(i)) != null && (childAt = relativeLayout.getChildAt(relativeLayout.getChildCount() - 1)) != null) {
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
                PagerSlidingTabStrip.this.del.setCurrentItem(i, PagerSlidingTabStrip.this.oan);
                if (eH && (PagerSlidingTabStrip.this.del.getAdapter() instanceof h)) {
                    ((h) PagerSlidingTabStrip.this.del.getAdapter()).AP(i);
                }
                if (PagerSlidingTabStrip.this.del.getAdapter() instanceof a) {
                    ((a) PagerSlidingTabStrip.this.del.getAdapter()).eI(i, i4);
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
        if (this.del.getAdapter() instanceof c) {
            c cVar = (c) this.del.getAdapter();
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
            textView.setCompoundDrawablePadding(this.nZW);
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
        this.dek.addView(relativeLayout);
    }

    private void updateTabStyles() {
        for (int i = 0; i < this.dem; i++) {
            View childAt = this.dek.getChildAt(i);
            if (i != 0) {
                childAt.setLayoutParams(this.deh);
            } else {
                childAt.setLayoutParams(this.nZK);
            }
            setMyTabLayoutParams(childAt);
            childAt.setBackgroundResource(this.deC);
            if (this.dep) {
                childAt.setPadding(0, 0, 0, 0);
            } else {
                childAt.setPadding(this.tabPadding, this.nZT, this.tabPadding, this.nZT);
            }
            if (childAt instanceof RelativeLayout) {
                TextView textView = (TextView) ((RelativeLayout) childAt).getChildAt(0);
                textView.setTextSize(0, this.tabTextSize);
                textView.setTypeface(this.dez, this.deA);
                textView.setTextColor(this.tabTextColor);
                if (this.nZQ) {
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

    public boolean dQR() {
        c cVar;
        if (this.del != null && this.del.getAdapter() != null && (this.del.getAdapter() instanceof c) && (cVar = (c) this.del.getAdapter()) != null) {
            for (int i = 0; i < this.dem; i++) {
                float OD = cVar.OD(i);
                if (OD != 0.0f) {
                    if (OD == 0.0f) {
                        OD = 1.0f;
                    }
                    this.dek.getChildAt(i).setLayoutParams(new LinearLayout.LayoutParams(0, -1, OD));
                } else {
                    if (i != 0) {
                        this.dek.getChildAt(i).setLayoutParams(this.deh);
                    } else {
                        this.dek.getChildAt(i).setLayoutParams(this.nZK);
                    }
                    setMyTabLayoutParams(this.dek.getChildAt(i));
                }
            }
        }
        return false;
    }

    @Override // android.widget.HorizontalScrollView, android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (!this.dep || View.MeasureSpec.getMode(i) == 0) {
            dQR();
            return;
        }
        int measuredWidth = getMeasuredWidth();
        int i3 = 0;
        for (int i4 = 0; i4 < this.dem; i4++) {
            i3 += this.dek.getChildAt(i4).getMeasuredWidth();
        }
        if (!this.nZO && i3 > 0 && measuredWidth > 0) {
            if (i3 <= measuredWidth) {
                for (int i5 = 0; i5 < this.dem; i5++) {
                    if (i5 != 0) {
                        this.dek.getChildAt(i5).setLayoutParams(this.deh);
                    } else {
                        this.dek.getChildAt(i5).setLayoutParams(this.nZK);
                    }
                    setMyTabLayoutParams(this.dek.getChildAt(i5));
                }
            }
            this.nZO = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean eH(int i, int i2) {
        if (this.dem == 0) {
            return false;
        }
        int left = this.dek.getChildAt(i).getLeft() + i2;
        if (i > 0 || i2 > 0) {
            left -= this.det;
        }
        int i3 = left - this.mInterval;
        if (i3 != this.deB) {
            this.deB = i3;
            scrollTo(i3, 0);
            return false;
        }
        return true;
    }

    public void setTabDrawMode(int i) {
        this.oab = i;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (!isInEditMode() && this.dem != 0) {
            if (this.oab == 0) {
                aq(canvas);
            } else {
                ar(canvas);
            }
        }
    }

    private void aq(Canvas canvas) {
        int height = getHeight();
        this.deo.setColor(this.nZP);
        View childAt = this.dek.getChildAt(this.Ev);
        float left = childAt.getLeft();
        float right = childAt.getRight();
        if (this.den > 0.0f && this.Ev < this.dem - 1) {
            View childAt2 = this.dek.getChildAt(this.Ev + 1);
            left = (left * (1.0f - this.den)) + (childAt2.getLeft() * this.den);
            right = (childAt2.getRight() * this.den) + ((1.0f - this.den) * right);
        }
        if (this.dey > 0) {
            float f2 = ((right - left) - this.dey) / 2.0f;
            this.mRectF.set(left + f2, height - this.indicatorHeight, f2 + left + this.dey, height);
            if (this.nZR) {
                canvas.drawRoundRect(this.mRectF, this.indicatorHeight / 2, this.indicatorHeight / 2, this.deo);
            } else {
                canvas.drawRect(this.mRectF, this.deo);
            }
        } else {
            canvas.drawRect(left, height - this.indicatorHeight, right, height, this.deo);
        }
        this.deo.setColor(this.nFA);
        canvas.drawRect(0.0f, height - this.dgq, this.dek.getWidth(), height, this.deo);
        this.nZN.setColor(this.dividerColor);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.dem - 1) {
                View childAt3 = this.dek.getChildAt(i2);
                canvas.drawLine(childAt3.getRight(), this.dividerPadding, childAt3.getRight(), height - this.dividerPadding, this.nZN);
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
        this.deo.setColor(this.nFA);
        canvas.drawRect(0.0f, height - this.dgq, this.dek.getWidth(), height, this.deo);
        this.deo.setColor(this.nZP);
        View childAt = this.dek.getChildAt(this.Ev);
        float left = childAt.getLeft();
        View childAt2 = ((RelativeLayout) childAt).getChildAt(0);
        float left2 = childAt2.getLeft();
        float right = childAt2.getRight();
        if (this.den <= 0.0f || this.Ev >= this.dem - 1) {
            f2 = right;
            f3 = left2;
            f4 = left;
        } else {
            View childAt3 = this.dek.getChildAt(this.Ev + 1);
            float left3 = (left * (1.0f - this.den)) + (childAt3.getLeft() * this.den);
            View childAt4 = ((RelativeLayout) childAt3).getChildAt(0);
            f3 = (childAt4.getLeft() * this.den) + (left2 * (1.0f - this.den));
            f2 = (childAt4.getRight() * this.den) + (right * (1.0f - this.den));
            f4 = left3;
        }
        if (this.dey > 0) {
            float f5 = ((f2 - f3) - this.dey) / 2.0f;
            this.mRectF.set(f4 + f3 + f5, height - this.indicatorHeight, f5 + f3 + f4 + this.dey, height);
            if (this.nZR) {
                canvas.drawRoundRect(this.mRectF, this.indicatorHeight / 2, this.indicatorHeight / 2, this.deo);
            } else {
                canvas.drawRect(this.mRectF, this.deo);
            }
        } else {
            canvas.drawRect(f3 + f4, height - this.indicatorHeight, f4 + f2, height, this.deo);
        }
        this.nZN.setColor(this.dividerColor);
        this.deo.setColor(this.nFA);
        for (int i = 0; i < this.dem; i++) {
            View childAt5 = this.dek.getChildAt(i);
            if (i < this.dem - 1) {
                canvas.drawLine(childAt5.getRight(), this.dividerPadding, childAt5.getRight(), height - this.dividerPadding, this.nZN);
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
            PagerSlidingTabStrip.this.den = f;
            if (PagerSlidingTabStrip.this.dek != null) {
                PagerSlidingTabStrip.this.eH(i, (int) (PagerSlidingTabStrip.this.dek.getChildAt(i).getWidth() * f));
            }
            PagerSlidingTabStrip.this.invalidate();
            if (PagerSlidingTabStrip.this.dej != null) {
                PagerSlidingTabStrip.this.dej.onPageScrolled(i, f, i2);
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            if (i == 0) {
                PagerSlidingTabStrip.this.eH(PagerSlidingTabStrip.this.del.getCurrentItem(), 0);
            }
            if (PagerSlidingTabStrip.this.dej != null) {
                PagerSlidingTabStrip.this.dej.onPageScrollStateChanged(i);
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            PagerSlidingTabStrip.this.setSelectItem(i);
            if (PagerSlidingTabStrip.this.dej != null) {
                PagerSlidingTabStrip.this.dej.onPageSelected(i);
            }
        }
    }

    public void setSelectItem(int i) {
        if (this.dek != null) {
            this.nZM = i;
            for (int i2 = 0; i2 < this.dek.getChildCount(); i2++) {
                if (i2 == i) {
                    RelativeLayout relativeLayout = (RelativeLayout) this.dek.getChildAt(i);
                    relativeLayout.setSelected(true);
                    TextView textView = (TextView) relativeLayout.getChildAt(0);
                    textView.setTypeface(this.dez, this.oaa);
                    textView.setTextColor(this.nZY);
                    textView.setTextSize(0, this.nZX);
                    if (this.oad != -1) {
                        textView.setBackgroundResource(this.oad);
                    }
                    if (this.del.getAdapter() instanceof b) {
                        textView.setCompoundDrawablesWithIntrinsicBounds(0, ((b) this.del.getAdapter()).ML(i), 0, 0);
                    }
                } else {
                    RelativeLayout relativeLayout2 = (RelativeLayout) this.dek.getChildAt(i2);
                    relativeLayout2.setSelected(false);
                    TextView textView2 = (TextView) relativeLayout2.getChildAt(0);
                    textView2.setTextColor(this.tabTextColor);
                    textView2.setBackgroundResource(0);
                    textView2.setTextSize(0, this.tabTextSize);
                    textView2.setTypeface(this.dez, this.deA);
                    if (this.del.getAdapter() instanceof b) {
                        textView2.setCompoundDrawablesWithIntrinsicBounds(0, ((b) this.del.getAdapter()).kW(i2), 0, 0);
                    }
                }
            }
        }
    }

    public void setTabTextSelectColor(@ColorInt int i) {
        this.nZY = i;
        invalidate();
    }

    public void setIndicatorColor(int i) {
        this.nZP = i;
        invalidate();
    }

    public void setIndicatorColorResource(int i) {
        this.nZP = getResources().getColor(i);
        invalidate();
    }

    public int getIndicatorColor() {
        return this.nZP;
    }

    public void setIndicatorHeight(int i) {
        this.indicatorHeight = i;
        invalidate();
    }

    public void setIndicatorWidth(int i) {
        this.dey = i;
        invalidate();
    }

    public int getIndicatorHeight() {
        return this.indicatorHeight;
    }

    public int getIndicatorWidth() {
        return this.dey;
    }

    public void setUnderlineColor(int i) {
        this.nFA = i;
        invalidate();
    }

    public void setUnderlineColorResource(int i) {
        this.nFA = getResources().getColor(i);
        invalidate();
    }

    public int getUnderlineColor() {
        return this.nFA;
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
        this.dgq = i;
        invalidate();
    }

    public int getUnderlineHeight() {
        return this.dgq;
    }

    public void setDividerPadding(int i) {
        this.dividerPadding = i;
        invalidate();
    }

    public int getDividerPadding() {
        return this.dividerPadding;
    }

    public void setScrollOffset(int i) {
        this.det = i;
        invalidate();
    }

    public int getScrollOffset() {
        return this.det;
    }

    public void setShouldExpand(boolean z) {
        this.dep = z;
        requestLayout();
    }

    public boolean getShouldExpand() {
        return this.dep;
    }

    public void setAllCaps(boolean z) {
        this.nZQ = z;
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
        this.dez = typeface;
        this.deA = i;
        updateTabStyles();
    }

    public void setSelectedTypeface(Typeface typeface, int i) {
        this.dez = typeface;
        this.oaa = i;
        updateTabStyles();
    }

    public void setTabBackground(int i) {
        this.deC = i;
    }

    public int getTabBackground() {
        return this.deC;
    }

    public void setTabPaddingLeftRight(int i) {
        this.tabPadding = i;
        updateTabStyles();
    }

    public int getTabPaddingLeftRight() {
        return this.tabPadding;
    }

    public void setIconPadding(int i) {
        this.nZW = i;
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
        if (this.oao != null) {
            this.oao.xi(true);
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    public void setDisallowIntercept(tv.chushou.zues.widget.psts.a aVar) {
        this.oao = aVar;
    }
}
