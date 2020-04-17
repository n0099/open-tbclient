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
    private int XM;
    private LinearLayout.LayoutParams dEg;
    public ViewPager.OnPageChangeListener dEi;
    private LinearLayout dEj;
    private ViewPager dEk;
    private int dEl;
    private float dEm;
    private Paint dEn;
    private boolean dEo;
    private int dEq;
    private int dEv;
    private Typeface dEw;
    private int dEx;
    private int dEy;
    private int dEz;
    private int dGn;
    private int dGo;
    private int dividerColor;
    private int dividerPadding;
    private DisplayMetrics dm;
    private int indicatorHeight;
    private Locale locale;
    private int mInterval;
    private final RectF mRectF;
    private int naY;
    private LinearLayout.LayoutParams nvH;
    private d nvI;
    private int nvJ;
    private Paint nvK;
    private boolean nvL;
    private int nvM;
    private boolean nvN;
    private boolean nvO;
    private int nvP;
    private int nvQ;
    private int nvR;
    private int nvS;
    private int nvT;
    private int nvU;
    private int nvV;
    private int nvW;
    private int nvX;
    private int nvY;
    private int nvZ;
    private int nwa;
    private boolean nwb;
    private boolean nwc;
    private int nwd;
    private int nwe;
    private int nwf;
    private int nwg;
    private int nwh;
    private boolean nwi;
    private boolean nwj;
    private boolean nwk;
    private tv.chushou.zues.widget.psts.a nwl;
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
        this.nvI = new d();
        this.XM = 0;
        this.nvJ = 0;
        this.dEm = 0.0f;
        this.nvL = false;
        this.nvM = -10066330;
        this.naY = 436207616;
        this.dividerColor = 436207616;
        this.dEo = true;
        this.nvN = false;
        this.dEq = 52;
        this.indicatorHeight = 3;
        this.dEv = 0;
        this.nvO = true;
        this.dGn = 1;
        this.dividerPadding = 12;
        this.nvP = 0;
        this.tabPadding = 24;
        this.nvQ = 0;
        this.nvR = 0;
        this.nvS = 0;
        this.dGo = 1;
        this.nvT = 0;
        this.tabTextSize = 15;
        this.nvU = this.tabTextSize;
        this.tabTextColor = -10066330;
        this.nvV = -10066330;
        this.nvW = 13;
        this.dEw = null;
        this.dEx = 0;
        this.nvX = 1;
        this.dEy = 0;
        this.nvY = 1;
        this.nvZ = 0;
        this.dEz = b.d.zues_psts_tab_background;
        this.nwa = -1;
        this.nwb = true;
        this.nwc = false;
        this.nwd = 3;
        this.nwg = 16;
        this.nwh = 0;
        this.mInterval = 0;
        this.nwi = false;
        this.nwj = false;
        this.nwk = true;
        this.mRectF = new RectF();
        setFillViewport(true);
        setWillNotDraw(false);
        this.dEj = new LinearLayout(context);
        this.dEj.setOrientation(0);
        this.dEj.setGravity(16);
        this.dm = getResources().getDisplayMetrics();
        this.nwg = (int) TypedValue.applyDimension(1, this.nwg, this.dm);
        this.dEq = (int) TypedValue.applyDimension(1, this.dEq, this.dm);
        this.indicatorHeight = (int) TypedValue.applyDimension(1, this.indicatorHeight, this.dm);
        this.dEv = (int) TypedValue.applyDimension(1, this.dEv, this.dm);
        this.dGn = (int) TypedValue.applyDimension(1, this.dGn, this.dm);
        this.dividerPadding = (int) TypedValue.applyDimension(1, this.dividerPadding, this.dm);
        this.tabPadding = (int) TypedValue.applyDimension(1, this.tabPadding, this.dm);
        this.dGo = (int) TypedValue.applyDimension(1, this.dGo, this.dm);
        this.tabTextSize = (int) TypedValue.applyDimension(2, this.tabTextSize, this.dm);
        this.nwd = (int) TypedValue.applyDimension(1, this.nwd, this.dm);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, ATTRS);
        this.tabTextSize = obtainStyledAttributes.getDimensionPixelSize(0, this.tabTextSize);
        this.nvU = this.tabTextSize;
        this.tabTextColor = obtainStyledAttributes.getColor(1, this.tabTextColor);
        obtainStyledAttributes.recycle();
        TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, b.i.PagerSlidingTabStrip);
        this.nvM = obtainStyledAttributes2.getColor(b.i.PagerSlidingTabStrip_indicatorColor, this.nvM);
        this.nvO = obtainStyledAttributes2.getBoolean(b.i.PagerSlidingTabStrip_indicatorRoundCap, false);
        this.naY = obtainStyledAttributes2.getColor(b.i.PagerSlidingTabStrip_underlineColor, this.naY);
        this.dividerColor = obtainStyledAttributes2.getColor(b.i.PagerSlidingTabStrip_dividerColor, this.dividerColor);
        this.nvV = obtainStyledAttributes2.getColor(b.i.PagerSlidingTabStrip_tabTextSelectColor, this.dividerColor);
        this.indicatorHeight = obtainStyledAttributes2.getDimensionPixelSize(b.i.PagerSlidingTabStrip_indicatorHeight, this.indicatorHeight);
        this.dEv = obtainStyledAttributes2.getDimensionPixelSize(b.i.PagerSlidingTabStrip_indicatorWidth, this.dEv);
        this.dGn = obtainStyledAttributes2.getDimensionPixelSize(b.i.PagerSlidingTabStrip_underlineHeight, this.dGn);
        this.dividerPadding = obtainStyledAttributes2.getDimensionPixelSize(b.i.PagerSlidingTabStrip_psts_dividerPadding, this.dividerPadding);
        this.nwg = obtainStyledAttributes2.getDimensionPixelSize(b.i.PagerSlidingTabStrip_psts_minInterval, this.nwg);
        this.nwh = obtainStyledAttributes2.getDimensionPixelSize(b.i.PagerSlidingTabStrip_center_paddingRight, 0);
        this.nvP = obtainStyledAttributes2.getDimensionPixelSize(b.i.PagerSlidingTabStrip_parentPaddingLeft, this.nvP);
        this.tabPadding = obtainStyledAttributes2.getDimensionPixelSize(b.i.PagerSlidingTabStrip_tabPaddingLeftRight, this.tabPadding);
        this.nvQ = obtainStyledAttributes2.getDimensionPixelSize(b.i.PagerSlidingTabStrip_tabPaddingTopBottom, this.nvQ);
        this.nvR = obtainStyledAttributes2.getDimensionPixelSize(b.i.PagerSlidingTabStrip_textPaddingLeftRight, this.nvR);
        this.nvS = obtainStyledAttributes2.getDimensionPixelSize(b.i.PagerSlidingTabStrip_textPaddingTopBottom, this.nvS);
        this.dEz = obtainStyledAttributes2.getResourceId(b.i.PagerSlidingTabStrip_ptabBackground, this.dEz);
        this.nwa = obtainStyledAttributes2.getResourceId(b.i.PagerSlidingTabStrip_textBackground, this.nwa);
        this.dEo = obtainStyledAttributes2.getBoolean(b.i.PagerSlidingTabStrip_shouldExpand, this.dEo);
        this.dEq = obtainStyledAttributes2.getDimensionPixelSize(b.i.PagerSlidingTabStrip_scrollOffset, this.dEq);
        this.nvN = obtainStyledAttributes2.getBoolean(b.i.PagerSlidingTabStrip_psts_textAllCaps, this.nvN);
        this.nwb = obtainStyledAttributes2.getBoolean(b.i.PagerSlidingTabStrip_psts_tabIsWeight, this.nwb);
        this.nvY = obtainStyledAttributes2.getInteger(b.i.PagerSlidingTabStrip_apsts_draw_mode, 0);
        this.nvZ = obtainStyledAttributes2.getInteger(b.i.PagerSlidingTabStrip_apsts_layout_mode, 0);
        this.nvU = obtainStyledAttributes2.getDimensionPixelSize(b.i.PagerSlidingTabStrip_tabTextSelectSize, this.tabTextSize);
        obtainStyledAttributes2.recycle();
        this.dEn = new Paint();
        this.dEn.setAntiAlias(true);
        this.dEn.setStyle(Paint.Style.FILL);
        this.nvK = new Paint();
        this.nvK.setAntiAlias(true);
        this.nvK.setStrokeWidth(this.dGo);
        if (this.nvZ == 0) {
            this.dEg = new LinearLayout.LayoutParams(0, -1, 1.0f);
            this.nvH = new LinearLayout.LayoutParams(0, -1, 1.0f);
            this.nvH.setMargins(0, 0, 0, 0);
        } else {
            this.dEg = new LinearLayout.LayoutParams(-2, -1);
            this.nvH = new LinearLayout.LayoutParams(-2, -1);
            this.nvH.setMargins(0, 0, 0, 0);
        }
        if (this.locale == null) {
            this.locale = getResources().getConfiguration().locale;
        }
        this.dEj.setPadding(this.nvP, this.dEj.getPaddingTop(), this.dEj.getPaddingRight(), this.dEj.getPaddingBottom());
        this.dEj.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        addView(this.dEj);
    }

    public void setControlWidth(int i) {
        this.nwe = i;
    }

    /* loaded from: classes5.dex */
    public class NewAdapter extends FragmentStatePagerAdapter implements h {
        private List<String> mDatas;
        private g nwn;

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
            if (this.nwn != null) {
                this.nwn.yI(i);
            }
        }
    }

    public boolean c(ViewPager viewPager) {
        return a(viewPager, false);
    }

    public boolean a(ViewPager viewPager, boolean z) {
        this.dEk = viewPager;
        if (viewPager.getAdapter() == null) {
            throw new IllegalStateException("ViewPager does not have adapter instance.");
        }
        if (!z) {
            viewPager.addOnPageChangeListener(this.nvI);
        }
        notifyDataSetChanged();
        return this.nwc;
    }

    public void setViewpageSmoothScroll(boolean z) {
        this.nwk = z;
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.dEi = onPageChangeListener;
    }

    public void notifyDataSetChanged() {
        tv.chushou.zues.widget.psts.b bVar;
        int[] iArr;
        this.nwf = 0;
        this.nwc = false;
        this.mInterval = this.nwg;
        this.dEj.removeAllViews();
        this.dEl = this.dEk.getAdapter().getCount();
        for (int i = 0; i < this.dEl; i++) {
            if (this.dEk.getAdapter() instanceof b) {
                a(i, ((b) this.dEk.getAdapter()).lg(i), ((b) this.dEk.getAdapter()).Im(i), ((b) this.dEk.getAdapter()).Io(i), ((b) this.dEk.getAdapter()).In(i));
            } else {
                if (this.dEk.getAdapter() instanceof e) {
                    e eVar = (e) this.dEk.getAdapter();
                    iArr = eVar.Kj(i);
                    bVar = eVar.Io(i);
                } else {
                    bVar = null;
                    iArr = null;
                }
                a(i, this.dEk.getAdapter().getPageTitle(i).toString(), iArr, bVar, this.dEk.getAdapter() instanceof f ? ((f) this.dEk.getAdapter()).Kk(i) : 0);
            }
        }
        if (this.nvZ != 0) {
            if (this.nwe == 0) {
                this.nwe = tv.chushou.zues.utils.a.gi(getContext()).x;
            }
            this.nwe -= this.dEj.getPaddingLeft();
            int i2 = (this.nwe - this.nwf) / (this.dEl + 1);
            if (this.nvZ == 1) {
                if (this.mInterval < i2) {
                    this.mInterval = i2;
                } else {
                    this.nwc = true;
                }
                this.dEg.setMargins(this.mInterval, 0, 0, 0);
            } else if (this.nvZ == 2) {
                if (this.mInterval < (this.nwe - this.nwf) / (this.dEl + 1)) {
                    this.dEj.setGravity(17);
                    this.dEj.setPadding(0, this.dEj.getPaddingTop(), this.nwh, this.dEj.getPaddingBottom());
                } else {
                    this.nwc = true;
                }
                this.dEg.setMargins(this.mInterval, 0, 0, 0);
            } else if (this.nvZ == 3) {
                if (this.mInterval >= i2) {
                    this.nwc = true;
                }
                this.dEg.setMargins(this.mInterval, 0, 0, 0);
            }
        }
        updateTabStyles();
        this.nvL = false;
        getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: tv.chushou.zues.widget.psts.PagerSlidingTabStrip.1
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            @SuppressLint({"NewApi"})
            public void onGlobalLayout() {
                if (Build.VERSION.SDK_INT < 16) {
                    PagerSlidingTabStrip.this.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                } else {
                    PagerSlidingTabStrip.this.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                }
                if (PagerSlidingTabStrip.this.dEk != null) {
                    PagerSlidingTabStrip.this.XM = PagerSlidingTabStrip.this.dEk.getCurrentItem();
                    PagerSlidingTabStrip.this.dT(PagerSlidingTabStrip.this.nvJ, 0);
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
        layoutParams.addRule(this.nvW);
        textView.setLayoutParams(layoutParams);
        textView.setPadding(this.nvR, this.nvS, this.nvR, this.nvS);
        textView.setCompoundDrawablePadding(getContext().getResources().getDimensionPixelSize(b.c.zues_psts_text_draw_padding));
        textView.setCompoundDrawablesWithIntrinsicBounds(0, 0, i2, 0);
        relativeLayout.setOnClickListener(new View.OnClickListener() { // from class: tv.chushou.zues.widget.psts.PagerSlidingTabStrip.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int i3 = PagerSlidingTabStrip.this.XM;
                boolean dT = PagerSlidingTabStrip.this.dT(i, 0);
                PagerSlidingTabStrip.this.dEk.setCurrentItem(i, PagerSlidingTabStrip.this.nwk);
                if (PagerSlidingTabStrip.this.nwj) {
                    if (!dT && (PagerSlidingTabStrip.this.dEk.getAdapter() instanceof h)) {
                        ((h) PagerSlidingTabStrip.this.dEk.getAdapter()).Bx(i);
                    }
                } else if (dT && (PagerSlidingTabStrip.this.dEk.getAdapter() instanceof h)) {
                    ((h) PagerSlidingTabStrip.this.dEk.getAdapter()).Bx(i);
                }
                if (PagerSlidingTabStrip.this.dEk.getAdapter() instanceof a) {
                    ((a) PagerSlidingTabStrip.this.dEk.getAdapter()).dU(i, i3);
                }
                PagerSlidingTabStrip.this.XM = i;
                if (PagerSlidingTabStrip.this.nwj) {
                    PagerSlidingTabStrip.this.dEm = 0.0f;
                    PagerSlidingTabStrip.this.nvJ = i;
                    PagerSlidingTabStrip.this.setSelectItem(i);
                    PagerSlidingTabStrip.this.dT(i, PagerSlidingTabStrip.this.dEj.getChildAt(i).getWidth() * 0);
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
        textView2.setTextColor(resources.getColor(b.C0831b.zues_white));
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
        this.dEj.addView(relativeLayout);
        if (this.nvZ != 0) {
            Rect rect = new Rect();
            textView.getPaint().getTextBounds(str, 0, str.length(), rect);
            this.nwf = rect.width() + this.nwd + (this.nvR * 2) + this.nwf;
        }
    }

    public void setTagRightImg(int i, @DrawableRes int i2) {
        TextView textView = (TextView) ((RelativeLayout) this.dEj.getChildAt(i)).findViewById(b.e.zues_psts_tab_tag);
        if (textView != null) {
            textView.setCompoundDrawablesWithIntrinsicBounds(0, 0, i2, 0);
        }
    }

    public void setTagText(int i, String str) {
        TextView textView = (TextView) ((RelativeLayout) this.dEj.getChildAt(i)).findViewById(b.e.zues_psts_tab_tag);
        if (textView != null) {
            textView.setText(str);
        }
    }

    public void bA(int i, String str) {
        RelativeLayout relativeLayout = (RelativeLayout) this.dEj.getChildAt(i);
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
        RelativeLayout relativeLayout = (RelativeLayout) this.dEj.getChildAt(i);
        View childAt = relativeLayout.getChildAt(relativeLayout.getChildCount() - 3);
        if (childAt != null) {
            childAt.setVisibility(8);
        }
    }

    public void Ke(int i) {
        RelativeLayout relativeLayout;
        View childAt;
        if (this.dEj != null && (relativeLayout = (RelativeLayout) this.dEj.getChildAt(i)) != null && (childAt = relativeLayout.getChildAt(relativeLayout.getChildCount() - 1)) != null) {
            ((ImageView) childAt).setVisibility(0);
        }
    }

    public void Kf(int i) {
        RelativeLayout relativeLayout;
        View childAt;
        if (this.dEj != null && (relativeLayout = (RelativeLayout) this.dEj.getChildAt(i)) != null && (childAt = relativeLayout.getChildAt(relativeLayout.getChildCount() - 1)) != null) {
            ((ImageView) childAt).setVisibility(8);
        }
    }

    private void a(final int i, int i2, String str, tv.chushou.zues.widget.psts.b bVar, int i3) {
        RelativeLayout relativeLayout = new RelativeLayout(getContext());
        relativeLayout.setOnClickListener(new View.OnClickListener() { // from class: tv.chushou.zues.widget.psts.PagerSlidingTabStrip.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int i4 = PagerSlidingTabStrip.this.XM;
                boolean dT = PagerSlidingTabStrip.this.dT(i, 0);
                PagerSlidingTabStrip.this.dEk.setCurrentItem(i, PagerSlidingTabStrip.this.nwk);
                if (dT && (PagerSlidingTabStrip.this.dEk.getAdapter() instanceof h)) {
                    ((h) PagerSlidingTabStrip.this.dEk.getAdapter()).Bx(i);
                }
                if (PagerSlidingTabStrip.this.dEk.getAdapter() instanceof a) {
                    ((a) PagerSlidingTabStrip.this.dEk.getAdapter()).dU(i, i4);
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
        if (this.dEk.getAdapter() instanceof c) {
            c cVar = (c) this.dEk.getAdapter();
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
            textView.setCompoundDrawablePadding(this.nvT);
        }
        Resources resources = getContext().getResources();
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, resources.getDimensionPixelSize(b.c.zues_psts_red_text_dot_size));
        layoutParams2.addRule(11);
        layoutParams2.topMargin = (int) tv.chushou.zues.utils.a.a(1, 2.0f, getContext());
        TextView textView2 = new TextView(getContext());
        textView2.setBackgroundResource(b.d.zues_psts_text_red_dot);
        textView2.setTextColor(resources.getColor(b.C0831b.zues_white));
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
        this.dEj.addView(relativeLayout);
    }

    private void updateTabStyles() {
        for (int i = 0; i < this.dEl; i++) {
            View childAt = this.dEj.getChildAt(i);
            if (i != 0) {
                childAt.setLayoutParams(this.dEg);
            } else {
                childAt.setLayoutParams(this.nvH);
            }
            setMyTabLayoutParams(childAt);
            childAt.setBackgroundResource(this.dEz);
            if (this.dEo) {
                childAt.setPadding(0, 0, 0, 0);
            } else {
                childAt.setPadding(this.tabPadding, this.nvQ, this.tabPadding, this.nvQ);
            }
            if (childAt instanceof RelativeLayout) {
                TextView textView = (TextView) ((RelativeLayout) childAt).getChildAt(0);
                textView.setTextSize(0, this.tabTextSize);
                textView.setTypeface(this.dEw, this.dEx);
                textView.setTextColor(this.tabTextColor);
                if (this.nvN) {
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

    public boolean dKu() {
        c cVar;
        if (this.dEk != null && this.dEk.getAdapter() != null && (this.dEk.getAdapter() instanceof c) && (cVar = (c) this.dEk.getAdapter()) != null) {
            for (int i = 0; i < this.dEl; i++) {
                float Kg = cVar.Kg(i);
                if (Kg != 0.0f) {
                    if (Kg == 0.0f) {
                        Kg = 1.0f;
                    }
                    this.dEj.getChildAt(i).setLayoutParams(new LinearLayout.LayoutParams(0, -1, Kg));
                } else {
                    if (i != 0) {
                        this.dEj.getChildAt(i).setLayoutParams(this.dEg);
                    } else {
                        this.dEj.getChildAt(i).setLayoutParams(this.nvH);
                    }
                    setMyTabLayoutParams(this.dEj.getChildAt(i));
                }
            }
        }
        return false;
    }

    @Override // android.widget.HorizontalScrollView, android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (!this.dEo || View.MeasureSpec.getMode(i) == 0) {
            dKu();
            return;
        }
        int measuredWidth = getMeasuredWidth();
        int i3 = 0;
        for (int i4 = 0; i4 < this.dEl; i4++) {
            i3 += this.dEj.getChildAt(i4).getMeasuredWidth();
        }
        if (!this.nvL && i3 > 0 && measuredWidth > 0) {
            if (i3 <= measuredWidth) {
                for (int i5 = 0; i5 < this.dEl; i5++) {
                    if (i5 != 0) {
                        this.dEj.getChildAt(i5).setLayoutParams(this.dEg);
                    } else {
                        this.dEj.getChildAt(i5).setLayoutParams(this.nvH);
                    }
                    setMyTabLayoutParams(this.dEj.getChildAt(i5));
                }
            }
            this.nvL = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean dT(int i, int i2) {
        if (this.dEl == 0) {
            return false;
        }
        int left = this.dEj.getChildAt(i).getLeft() + i2;
        if (i > 0 || i2 > 0) {
            left -= this.dEq;
        }
        int i3 = left - this.mInterval;
        if (i3 != this.dEy) {
            this.dEy = i3;
            scrollTo(i3, 0);
            return false;
        }
        return true;
    }

    public void setTabDrawMode(int i) {
        this.nvY = i;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (!isInEditMode() && this.dEl != 0) {
            if (this.nvY == 0) {
                ak(canvas);
            } else {
                al(canvas);
            }
        }
    }

    private void ak(Canvas canvas) {
        int height = getHeight();
        this.dEn.setColor(this.nvM);
        View childAt = this.dEj.getChildAt(this.XM);
        float left = childAt.getLeft();
        float right = childAt.getRight();
        if (this.dEm > 0.0f && this.XM < this.dEl - 1) {
            View childAt2 = this.dEj.getChildAt(this.XM + 1);
            left = (left * (1.0f - this.dEm)) + (childAt2.getLeft() * this.dEm);
            right = (childAt2.getRight() * this.dEm) + ((1.0f - this.dEm) * right);
        }
        if (this.dEv > 0) {
            float f2 = ((right - left) - this.dEv) / 2.0f;
            this.mRectF.set(left + f2, height - this.indicatorHeight, f2 + left + this.dEv, height);
            if (this.nvO) {
                canvas.drawRoundRect(this.mRectF, this.indicatorHeight / 2, this.indicatorHeight / 2, this.dEn);
            } else {
                canvas.drawRect(this.mRectF, this.dEn);
            }
        } else {
            canvas.drawRect(left, height - this.indicatorHeight, right, height, this.dEn);
        }
        this.dEn.setColor(this.naY);
        canvas.drawRect(0.0f, height - this.dGn, this.dEj.getWidth(), height, this.dEn);
        this.nvK.setColor(this.dividerColor);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.dEl - 1) {
                View childAt3 = this.dEj.getChildAt(i2);
                canvas.drawLine(childAt3.getRight(), this.dividerPadding, childAt3.getRight(), height - this.dividerPadding, this.nvK);
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
        this.dEn.setColor(this.naY);
        canvas.drawRect(0.0f, height - this.dGn, this.dEj.getWidth(), height, this.dEn);
        this.dEn.setColor(this.nvM);
        View childAt = this.dEj.getChildAt(this.XM);
        float left = childAt.getLeft();
        View childAt2 = ((RelativeLayout) childAt).getChildAt(0);
        float left2 = childAt2.getLeft();
        float right = childAt2.getRight();
        if (this.dEm <= 0.0f || this.XM >= this.dEl - 1) {
            f2 = right;
            f3 = left2;
            f4 = left;
        } else {
            View childAt3 = this.dEj.getChildAt(this.XM + 1);
            float left3 = (left * (1.0f - this.dEm)) + (childAt3.getLeft() * this.dEm);
            View childAt4 = ((RelativeLayout) childAt3).getChildAt(0);
            f3 = (childAt4.getLeft() * this.dEm) + (left2 * (1.0f - this.dEm));
            f2 = (childAt4.getRight() * this.dEm) + (right * (1.0f - this.dEm));
            f4 = left3;
        }
        if (this.dEv > 0) {
            float f5 = ((f2 - f3) - this.dEv) / 2.0f;
            this.mRectF.set(f4 + f3 + f5, height - this.indicatorHeight, f5 + f3 + f4 + this.dEv, height);
            if (this.nvO) {
                canvas.drawRoundRect(this.mRectF, this.indicatorHeight / 2, this.indicatorHeight / 2, this.dEn);
            } else {
                canvas.drawRect(this.mRectF, this.dEn);
            }
        } else {
            canvas.drawRect(f3 + f4, height - this.indicatorHeight, f4 + f2, height, this.dEn);
        }
        this.nvK.setColor(this.dividerColor);
        this.dEn.setColor(this.naY);
        for (int i = 0; i < this.dEl; i++) {
            View childAt5 = this.dEj.getChildAt(i);
            if (i < this.dEl - 1) {
                canvas.drawLine(childAt5.getRight(), this.dividerPadding, childAt5.getRight(), height - this.dividerPadding, this.nvK);
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
            PagerSlidingTabStrip.this.XM = i;
            PagerSlidingTabStrip.this.dEm = f;
            if (PagerSlidingTabStrip.this.dEj != null) {
                PagerSlidingTabStrip.this.dT(i, (int) (PagerSlidingTabStrip.this.dEj.getChildAt(i).getWidth() * f));
            }
            PagerSlidingTabStrip.this.invalidate();
            if (PagerSlidingTabStrip.this.dEi != null) {
                PagerSlidingTabStrip.this.dEi.onPageScrolled(i, f, i2);
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            if (i == 0) {
                PagerSlidingTabStrip.this.dT(PagerSlidingTabStrip.this.dEk.getCurrentItem(), 0);
            }
            if (PagerSlidingTabStrip.this.dEi != null) {
                PagerSlidingTabStrip.this.dEi.onPageScrollStateChanged(i);
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            PagerSlidingTabStrip.this.setSelectItem(i);
            if (PagerSlidingTabStrip.this.dEi != null) {
                PagerSlidingTabStrip.this.dEi.onPageSelected(i);
            }
        }
    }

    public void setSelectItem(int i) {
        if (this.dEj != null) {
            this.nvJ = i;
            for (int i2 = 0; i2 < this.dEj.getChildCount(); i2++) {
                if (i2 == i) {
                    RelativeLayout relativeLayout = (RelativeLayout) this.dEj.getChildAt(i);
                    relativeLayout.setSelected(true);
                    TextView textView = (TextView) relativeLayout.getChildAt(0);
                    textView.setTypeface(this.dEw, this.nvX);
                    textView.setTextColor(this.nvV);
                    textView.setTextSize(0, this.nvU);
                    if (this.nwa != -1) {
                        textView.setBackgroundResource(this.nwa);
                    }
                    if (this.dEk.getAdapter() instanceof b) {
                        textView.setCompoundDrawablesWithIntrinsicBounds(0, ((b) this.dEk.getAdapter()).Il(i), 0, 0);
                    }
                } else {
                    RelativeLayout relativeLayout2 = (RelativeLayout) this.dEj.getChildAt(i2);
                    relativeLayout2.setSelected(false);
                    TextView textView2 = (TextView) relativeLayout2.getChildAt(0);
                    textView2.setTextColor(this.tabTextColor);
                    textView2.setBackgroundResource(0);
                    textView2.setTextSize(0, this.tabTextSize);
                    textView2.setTypeface(this.dEw, this.dEx);
                    if (this.dEk.getAdapter() instanceof b) {
                        textView2.setCompoundDrawablesWithIntrinsicBounds(0, ((b) this.dEk.getAdapter()).lg(i2), 0, 0);
                    }
                }
            }
        }
    }

    public void setTabTextSelectColor(@ColorInt int i) {
        this.nvV = i;
        invalidate();
    }

    public void setIndicatorColor(int i) {
        this.nvM = i;
        invalidate();
    }

    public void setIndicatorColorResource(int i) {
        this.nvM = getResources().getColor(i);
        invalidate();
    }

    public int getIndicatorColor() {
        return this.nvM;
    }

    public void setIndicatorHeight(int i) {
        this.indicatorHeight = i;
        invalidate();
    }

    public void setIndicatorWidth(int i) {
        this.dEv = i;
        invalidate();
    }

    public int getIndicatorHeight() {
        return this.indicatorHeight;
    }

    public int getIndicatorWidth() {
        return this.dEv;
    }

    public void setUnderlineColor(int i) {
        this.naY = i;
        invalidate();
    }

    public void setUnderlineColorResource(int i) {
        this.naY = getResources().getColor(i);
        invalidate();
    }

    public int getUnderlineColor() {
        return this.naY;
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
        this.dGn = i;
        invalidate();
    }

    public int getUnderlineHeight() {
        return this.dGn;
    }

    public void setDividerPadding(int i) {
        this.dividerPadding = i;
        invalidate();
    }

    public int getDividerPadding() {
        return this.dividerPadding;
    }

    public void setScrollOffset(int i) {
        this.dEq = i;
        invalidate();
    }

    public int getScrollOffset() {
        return this.dEq;
    }

    public void setShouldExpand(boolean z) {
        this.dEo = z;
        requestLayout();
    }

    public boolean getShouldExpand() {
        return this.dEo;
    }

    public void setAllCaps(boolean z) {
        this.nvN = z;
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
        this.dEw = typeface;
        this.dEx = i;
        updateTabStyles();
    }

    public void setSelectedTypeface(Typeface typeface, int i) {
        this.dEw = typeface;
        this.nvX = i;
        updateTabStyles();
    }

    public void setTabBackground(int i) {
        this.dEz = i;
    }

    public int getTabBackground() {
        return this.dEz;
    }

    public void setTabPaddingLeftRight(int i) {
        this.tabPadding = i;
        updateTabStyles();
    }

    public int getTabPaddingLeftRight() {
        return this.tabPadding;
    }

    public void setIconPadding(int i) {
        this.nvT = i;
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.XM = savedState.XM;
        requestLayout();
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.XM = this.XM;
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
        int XM;

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.XM = parcel.readInt();
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.XM);
        }
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.nwl != null) {
            this.nwl.wV(true);
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    public void setDisallowIntercept(tv.chushou.zues.widget.psts.a aVar) {
        this.nwl = aVar;
    }
}
