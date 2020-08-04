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
    private int Yz;
    private int dividerColor;
    private int dividerPadding;
    private int dividerWidth;
    private DisplayMetrics dm;
    private LinearLayout.LayoutParams efB;
    public ViewPager.OnPageChangeListener efD;
    private LinearLayout efE;
    private ViewPager efF;
    private int efG;
    private float efH;
    private Paint efI;
    private boolean efJ;
    private Typeface efP;
    private int efQ;
    private int efR;
    private int efS;
    private int indicatorColor;
    private int indicatorHeight;
    private int indicatorWidth;
    private Locale locale;
    private int mInterval;
    private final RectF mRectF;
    private int owA;
    private int owB;
    private int owC;
    private boolean owD;
    private boolean owE;
    private int owF;
    private int owG;
    private int owH;
    private int owI;
    private int owJ;
    private boolean owK;
    private boolean owL;
    private boolean owM;
    private tv.chushou.zues.widget.psts.a owN;
    private LinearLayout.LayoutParams owp;
    private d owq;
    private int owr;
    private Paint ows;
    private boolean owt;
    private boolean owu;
    private boolean owv;
    private int oww;
    private int owx;
    private int owy;
    private int owz;
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
        void ek(int i, int i2);
    }

    /* loaded from: classes6.dex */
    public interface b {
        int KA(int i);

        String KB(int i);

        int KC(int i);

        tv.chushou.zues.widget.psts.b KD(int i);

        int mu(int i);
    }

    /* loaded from: classes6.dex */
    public interface c {
        float Mt(int i);

        int[] Mu(int i);

        tv.chushou.zues.widget.psts.b Mv(int i);
    }

    /* loaded from: classes6.dex */
    public interface e {
        tv.chushou.zues.widget.psts.b KD(int i);

        int[] Mw(int i);
    }

    /* loaded from: classes6.dex */
    public interface f {
        int Mx(int i);
    }

    /* loaded from: classes6.dex */
    public interface g {
        void AD(int i);
    }

    /* loaded from: classes6.dex */
    public interface h {
        void DH(int i);
    }

    public PagerSlidingTabStrip(Context context) {
        this(context, null);
    }

    public PagerSlidingTabStrip(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PagerSlidingTabStrip(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.owq = new d();
        this.Yz = 0;
        this.owr = 0;
        this.efH = 0.0f;
        this.owt = false;
        this.indicatorColor = -10066330;
        this.underlineColor = 436207616;
        this.dividerColor = 436207616;
        this.efJ = true;
        this.owu = false;
        this.scrollOffset = 52;
        this.indicatorHeight = 3;
        this.indicatorWidth = 0;
        this.owv = true;
        this.underlineHeight = 1;
        this.dividerPadding = 12;
        this.parentPaddingLeft = 0;
        this.tabPadding = 24;
        this.tabPaddingTopBottom = 0;
        this.textPaddingLeftRight = 0;
        this.textPaddingTopBottom = 0;
        this.dividerWidth = 1;
        this.oww = 0;
        this.tabTextSize = 15;
        this.owx = this.tabTextSize;
        this.tabTextColor = -10066330;
        this.tabTextSelectColor = -10066330;
        this.owy = 13;
        this.efP = null;
        this.efQ = 0;
        this.owz = 1;
        this.efR = 0;
        this.owA = 1;
        this.owB = 0;
        this.efS = b.d.zues_psts_tab_background;
        this.owC = -1;
        this.owD = true;
        this.owE = false;
        this.owF = 3;
        this.owI = 16;
        this.owJ = 0;
        this.mInterval = 0;
        this.owK = false;
        this.owL = false;
        this.owM = true;
        this.mRectF = new RectF();
        setFillViewport(true);
        setWillNotDraw(false);
        this.efE = new LinearLayout(context);
        this.efE.setOrientation(0);
        this.efE.setGravity(16);
        this.dm = getResources().getDisplayMetrics();
        this.owI = (int) TypedValue.applyDimension(1, this.owI, this.dm);
        this.scrollOffset = (int) TypedValue.applyDimension(1, this.scrollOffset, this.dm);
        this.indicatorHeight = (int) TypedValue.applyDimension(1, this.indicatorHeight, this.dm);
        this.indicatorWidth = (int) TypedValue.applyDimension(1, this.indicatorWidth, this.dm);
        this.underlineHeight = (int) TypedValue.applyDimension(1, this.underlineHeight, this.dm);
        this.dividerPadding = (int) TypedValue.applyDimension(1, this.dividerPadding, this.dm);
        this.tabPadding = (int) TypedValue.applyDimension(1, this.tabPadding, this.dm);
        this.dividerWidth = (int) TypedValue.applyDimension(1, this.dividerWidth, this.dm);
        this.tabTextSize = (int) TypedValue.applyDimension(2, this.tabTextSize, this.dm);
        this.owF = (int) TypedValue.applyDimension(1, this.owF, this.dm);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, ATTRS);
        this.tabTextSize = obtainStyledAttributes.getDimensionPixelSize(0, this.tabTextSize);
        this.owx = this.tabTextSize;
        this.tabTextColor = obtainStyledAttributes.getColor(1, this.tabTextColor);
        obtainStyledAttributes.recycle();
        TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, b.i.PagerSlidingTabStrip);
        this.indicatorColor = obtainStyledAttributes2.getColor(b.i.PagerSlidingTabStrip_indicatorColor, this.indicatorColor);
        this.owv = obtainStyledAttributes2.getBoolean(b.i.PagerSlidingTabStrip_indicatorRoundCap, false);
        this.underlineColor = obtainStyledAttributes2.getColor(b.i.PagerSlidingTabStrip_underlineColor, this.underlineColor);
        this.dividerColor = obtainStyledAttributes2.getColor(b.i.PagerSlidingTabStrip_dividerColor, this.dividerColor);
        this.tabTextSelectColor = obtainStyledAttributes2.getColor(b.i.PagerSlidingTabStrip_tabTextSelectColor, this.dividerColor);
        this.indicatorHeight = obtainStyledAttributes2.getDimensionPixelSize(b.i.PagerSlidingTabStrip_indicatorHeight, this.indicatorHeight);
        this.indicatorWidth = obtainStyledAttributes2.getDimensionPixelSize(b.i.PagerSlidingTabStrip_indicatorWidth, this.indicatorWidth);
        this.underlineHeight = obtainStyledAttributes2.getDimensionPixelSize(b.i.PagerSlidingTabStrip_underlineHeight, this.underlineHeight);
        this.dividerPadding = obtainStyledAttributes2.getDimensionPixelSize(b.i.PagerSlidingTabStrip_psts_dividerPadding, this.dividerPadding);
        this.owI = obtainStyledAttributes2.getDimensionPixelSize(b.i.PagerSlidingTabStrip_psts_minInterval, this.owI);
        this.owJ = obtainStyledAttributes2.getDimensionPixelSize(b.i.PagerSlidingTabStrip_center_paddingRight, 0);
        this.parentPaddingLeft = obtainStyledAttributes2.getDimensionPixelSize(b.i.PagerSlidingTabStrip_parentPaddingLeft, this.parentPaddingLeft);
        this.tabPadding = obtainStyledAttributes2.getDimensionPixelSize(b.i.PagerSlidingTabStrip_tabPaddingLeftRight, this.tabPadding);
        this.tabPaddingTopBottom = obtainStyledAttributes2.getDimensionPixelSize(b.i.PagerSlidingTabStrip_tabPaddingTopBottom, this.tabPaddingTopBottom);
        this.textPaddingLeftRight = obtainStyledAttributes2.getDimensionPixelSize(b.i.PagerSlidingTabStrip_textPaddingLeftRight, this.textPaddingLeftRight);
        this.textPaddingTopBottom = obtainStyledAttributes2.getDimensionPixelSize(b.i.PagerSlidingTabStrip_textPaddingTopBottom, this.textPaddingTopBottom);
        this.efS = obtainStyledAttributes2.getResourceId(b.i.PagerSlidingTabStrip_ptabBackground, this.efS);
        this.owC = obtainStyledAttributes2.getResourceId(b.i.PagerSlidingTabStrip_textBackground, this.owC);
        this.efJ = obtainStyledAttributes2.getBoolean(b.i.PagerSlidingTabStrip_shouldExpand, this.efJ);
        this.scrollOffset = obtainStyledAttributes2.getDimensionPixelSize(b.i.PagerSlidingTabStrip_scrollOffset, this.scrollOffset);
        this.owu = obtainStyledAttributes2.getBoolean(b.i.PagerSlidingTabStrip_psts_textAllCaps, this.owu);
        this.owD = obtainStyledAttributes2.getBoolean(b.i.PagerSlidingTabStrip_psts_tabIsWeight, this.owD);
        this.owA = obtainStyledAttributes2.getInteger(b.i.PagerSlidingTabStrip_apsts_draw_mode, 0);
        this.owB = obtainStyledAttributes2.getInteger(b.i.PagerSlidingTabStrip_apsts_layout_mode, 0);
        this.owx = obtainStyledAttributes2.getDimensionPixelSize(b.i.PagerSlidingTabStrip_tabTextSelectSize, this.tabTextSize);
        obtainStyledAttributes2.recycle();
        this.efI = new Paint();
        this.efI.setAntiAlias(true);
        this.efI.setStyle(Paint.Style.FILL);
        this.ows = new Paint();
        this.ows.setAntiAlias(true);
        this.ows.setStrokeWidth(this.dividerWidth);
        if (this.owB == 0) {
            this.efB = new LinearLayout.LayoutParams(0, -1, 1.0f);
            this.owp = new LinearLayout.LayoutParams(0, -1, 1.0f);
            this.owp.setMargins(0, 0, 0, 0);
        } else {
            this.efB = new LinearLayout.LayoutParams(-2, -1);
            this.owp = new LinearLayout.LayoutParams(-2, -1);
            this.owp.setMargins(0, 0, 0, 0);
        }
        if (this.locale == null) {
            this.locale = getResources().getConfiguration().locale;
        }
        this.efE.setPadding(this.parentPaddingLeft, this.efE.getPaddingTop(), this.efE.getPaddingRight(), this.efE.getPaddingBottom());
        this.efE.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        addView(this.efE);
    }

    public void setControlWidth(int i) {
        this.owG = i;
    }

    /* loaded from: classes6.dex */
    public class NewAdapter extends FragmentStatePagerAdapter implements h {
        private List<String> mDatas;
        private g owP;

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
        public void DH(int i) {
            if (this.owP != null) {
                this.owP.AD(i);
            }
        }
    }

    public boolean c(ViewPager viewPager) {
        return a(viewPager, false);
    }

    public boolean a(ViewPager viewPager, boolean z) {
        this.efF = viewPager;
        if (viewPager.getAdapter() == null) {
            throw new IllegalStateException("ViewPager does not have adapter instance.");
        }
        if (!z) {
            viewPager.addOnPageChangeListener(this.owq);
        }
        notifyDataSetChanged();
        return this.owE;
    }

    public void setViewpageSmoothScroll(boolean z) {
        this.owM = z;
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.efD = onPageChangeListener;
    }

    public void notifyDataSetChanged() {
        tv.chushou.zues.widget.psts.b bVar;
        int[] iArr;
        this.owH = 0;
        this.owE = false;
        this.mInterval = this.owI;
        this.efE.removeAllViews();
        this.efG = this.efF.getAdapter().getCount();
        for (int i = 0; i < this.efG; i++) {
            if (this.efF.getAdapter() instanceof b) {
                a(i, ((b) this.efF.getAdapter()).mu(i), ((b) this.efF.getAdapter()).KB(i), ((b) this.efF.getAdapter()).KD(i), ((b) this.efF.getAdapter()).KC(i));
            } else {
                if (this.efF.getAdapter() instanceof e) {
                    e eVar = (e) this.efF.getAdapter();
                    iArr = eVar.Mw(i);
                    bVar = eVar.KD(i);
                } else {
                    bVar = null;
                    iArr = null;
                }
                a(i, this.efF.getAdapter().getPageTitle(i).toString(), iArr, bVar, this.efF.getAdapter() instanceof f ? ((f) this.efF.getAdapter()).Mx(i) : 0);
            }
        }
        if (this.owB != 0) {
            if (this.owG == 0) {
                this.owG = tv.chushou.zues.utils.a.gF(getContext()).x;
            }
            this.owG -= this.efE.getPaddingLeft();
            int i2 = (this.owG - this.owH) / (this.efG + 1);
            if (this.owB == 1) {
                if (this.mInterval < i2) {
                    this.mInterval = i2;
                } else {
                    this.owE = true;
                }
                this.efB.setMargins(this.mInterval, 0, 0, 0);
            } else if (this.owB == 2) {
                if (this.mInterval < (this.owG - this.owH) / (this.efG + 1)) {
                    this.efE.setGravity(17);
                    this.efE.setPadding(0, this.efE.getPaddingTop(), this.owJ, this.efE.getPaddingBottom());
                } else {
                    this.owE = true;
                }
                this.efB.setMargins(this.mInterval, 0, 0, 0);
            } else if (this.owB == 3) {
                if (this.mInterval >= i2) {
                    this.owE = true;
                }
                this.efB.setMargins(this.mInterval, 0, 0, 0);
            }
        }
        updateTabStyles();
        this.owt = false;
        getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: tv.chushou.zues.widget.psts.PagerSlidingTabStrip.1
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            @SuppressLint({"NewApi"})
            public void onGlobalLayout() {
                if (Build.VERSION.SDK_INT < 16) {
                    PagerSlidingTabStrip.this.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                } else {
                    PagerSlidingTabStrip.this.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                }
                if (PagerSlidingTabStrip.this.efF != null) {
                    PagerSlidingTabStrip.this.Yz = PagerSlidingTabStrip.this.efF.getCurrentItem();
                    PagerSlidingTabStrip.this.ej(PagerSlidingTabStrip.this.owr, 0);
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
        layoutParams.addRule(this.owy);
        textView.setLayoutParams(layoutParams);
        textView.setPadding(this.textPaddingLeftRight, this.textPaddingTopBottom, this.textPaddingLeftRight, this.textPaddingTopBottom);
        textView.setCompoundDrawablePadding(getContext().getResources().getDimensionPixelSize(b.c.zues_psts_text_draw_padding));
        textView.setCompoundDrawablesWithIntrinsicBounds(0, 0, i2, 0);
        relativeLayout.setOnClickListener(new View.OnClickListener() { // from class: tv.chushou.zues.widget.psts.PagerSlidingTabStrip.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int i3 = PagerSlidingTabStrip.this.Yz;
                boolean ej = PagerSlidingTabStrip.this.ej(i, 0);
                PagerSlidingTabStrip.this.efF.setCurrentItem(i, PagerSlidingTabStrip.this.owM);
                if (PagerSlidingTabStrip.this.owL) {
                    if (!ej && (PagerSlidingTabStrip.this.efF.getAdapter() instanceof h)) {
                        ((h) PagerSlidingTabStrip.this.efF.getAdapter()).DH(i);
                    }
                } else if (ej && (PagerSlidingTabStrip.this.efF.getAdapter() instanceof h)) {
                    ((h) PagerSlidingTabStrip.this.efF.getAdapter()).DH(i);
                }
                if (PagerSlidingTabStrip.this.efF.getAdapter() instanceof a) {
                    ((a) PagerSlidingTabStrip.this.efF.getAdapter()).ek(i, i3);
                }
                PagerSlidingTabStrip.this.Yz = i;
                if (PagerSlidingTabStrip.this.owL) {
                    PagerSlidingTabStrip.this.efH = 0.0f;
                    PagerSlidingTabStrip.this.owr = i;
                    PagerSlidingTabStrip.this.setSelectItem(i);
                    PagerSlidingTabStrip.this.ej(i, PagerSlidingTabStrip.this.efE.getChildAt(i).getWidth() * 0);
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
        textView2.setTextColor(resources.getColor(b.C0950b.zues_white));
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
        this.efE.addView(relativeLayout);
        if (this.owB != 0) {
            Rect rect = new Rect();
            textView.getPaint().getTextBounds(str, 0, str.length(), rect);
            this.owH = rect.width() + this.owF + (this.textPaddingLeftRight * 2) + this.owH;
        }
    }

    public void setTagRightImg(int i, @DrawableRes int i2) {
        TextView textView = (TextView) ((RelativeLayout) this.efE.getChildAt(i)).findViewById(b.e.zues_psts_tab_tag);
        if (textView != null) {
            textView.setCompoundDrawablesWithIntrinsicBounds(0, 0, i2, 0);
        }
    }

    public void setTagText(int i, String str) {
        TextView textView = (TextView) ((RelativeLayout) this.efE.getChildAt(i)).findViewById(b.e.zues_psts_tab_tag);
        if (textView != null) {
            textView.setText(str);
        }
    }

    public void bN(int i, String str) {
        RelativeLayout relativeLayout = (RelativeLayout) this.efE.getChildAt(i);
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

    public void Mq(int i) {
        RelativeLayout relativeLayout = (RelativeLayout) this.efE.getChildAt(i);
        View childAt = relativeLayout.getChildAt(relativeLayout.getChildCount() - 3);
        if (childAt != null) {
            childAt.setVisibility(8);
        }
    }

    public void Mr(int i) {
        RelativeLayout relativeLayout;
        View childAt;
        if (this.efE != null && (relativeLayout = (RelativeLayout) this.efE.getChildAt(i)) != null && (childAt = relativeLayout.getChildAt(relativeLayout.getChildCount() - 1)) != null) {
            ((ImageView) childAt).setVisibility(0);
        }
    }

    public void Ms(int i) {
        RelativeLayout relativeLayout;
        View childAt;
        if (this.efE != null && (relativeLayout = (RelativeLayout) this.efE.getChildAt(i)) != null && (childAt = relativeLayout.getChildAt(relativeLayout.getChildCount() - 1)) != null) {
            ((ImageView) childAt).setVisibility(8);
        }
    }

    private void a(final int i, int i2, String str, tv.chushou.zues.widget.psts.b bVar, int i3) {
        RelativeLayout relativeLayout = new RelativeLayout(getContext());
        relativeLayout.setOnClickListener(new View.OnClickListener() { // from class: tv.chushou.zues.widget.psts.PagerSlidingTabStrip.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int i4 = PagerSlidingTabStrip.this.Yz;
                boolean ej = PagerSlidingTabStrip.this.ej(i, 0);
                PagerSlidingTabStrip.this.efF.setCurrentItem(i, PagerSlidingTabStrip.this.owM);
                if (ej && (PagerSlidingTabStrip.this.efF.getAdapter() instanceof h)) {
                    ((h) PagerSlidingTabStrip.this.efF.getAdapter()).DH(i);
                }
                if (PagerSlidingTabStrip.this.efF.getAdapter() instanceof a) {
                    ((a) PagerSlidingTabStrip.this.efF.getAdapter()).ek(i, i4);
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
        if (this.efF.getAdapter() instanceof c) {
            c cVar = (c) this.efF.getAdapter();
            for (int i4 : cVar.Mu(i)) {
                layoutParams.addRule(Integer.valueOf(i4).intValue());
            }
            tv.chushou.zues.widget.psts.b Mv = cVar.Mv(i);
            if (Mv != null) {
                layoutParams.setMargins(Mv.mLeft, Mv.mTop, Mv.mRight, Mv.mBottom);
            }
        }
        textView.setLayoutParams(layoutParams);
        if (i2 != 0) {
            textView.setCompoundDrawablesWithIntrinsicBounds(0, i2, 0, 0);
            textView.setCompoundDrawablePadding(this.oww);
        }
        Resources resources = getContext().getResources();
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, resources.getDimensionPixelSize(b.c.zues_psts_red_text_dot_size));
        layoutParams2.addRule(11);
        layoutParams2.topMargin = (int) tv.chushou.zues.utils.a.a(1, 2.0f, getContext());
        TextView textView2 = new TextView(getContext());
        textView2.setBackgroundResource(b.d.zues_psts_text_red_dot);
        textView2.setTextColor(resources.getColor(b.C0950b.zues_white));
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
        this.efE.addView(relativeLayout);
    }

    private void updateTabStyles() {
        for (int i = 0; i < this.efG; i++) {
            View childAt = this.efE.getChildAt(i);
            if (i != 0) {
                childAt.setLayoutParams(this.efB);
            } else {
                childAt.setLayoutParams(this.owp);
            }
            setMyTabLayoutParams(childAt);
            childAt.setBackgroundResource(this.efS);
            if (this.efJ) {
                childAt.setPadding(0, 0, 0, 0);
            } else {
                childAt.setPadding(this.tabPadding, this.tabPaddingTopBottom, this.tabPadding, this.tabPaddingTopBottom);
            }
            if (childAt instanceof RelativeLayout) {
                TextView textView = (TextView) ((RelativeLayout) childAt).getChildAt(0);
                textView.setTextSize(0, this.tabTextSize);
                textView.setTypeface(this.efP, this.efQ);
                textView.setTextColor(this.tabTextColor);
                if (this.owu) {
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

    public boolean eaG() {
        c cVar;
        if (this.efF != null && this.efF.getAdapter() != null && (this.efF.getAdapter() instanceof c) && (cVar = (c) this.efF.getAdapter()) != null) {
            for (int i = 0; i < this.efG; i++) {
                float Mt = cVar.Mt(i);
                if (Mt != 0.0f) {
                    if (Mt == 0.0f) {
                        Mt = 1.0f;
                    }
                    this.efE.getChildAt(i).setLayoutParams(new LinearLayout.LayoutParams(0, -1, Mt));
                } else {
                    if (i != 0) {
                        this.efE.getChildAt(i).setLayoutParams(this.efB);
                    } else {
                        this.efE.getChildAt(i).setLayoutParams(this.owp);
                    }
                    setMyTabLayoutParams(this.efE.getChildAt(i));
                }
            }
        }
        return false;
    }

    @Override // android.widget.HorizontalScrollView, android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (!this.efJ || View.MeasureSpec.getMode(i) == 0) {
            eaG();
            return;
        }
        int measuredWidth = getMeasuredWidth();
        int i3 = 0;
        for (int i4 = 0; i4 < this.efG; i4++) {
            i3 += this.efE.getChildAt(i4).getMeasuredWidth();
        }
        if (!this.owt && i3 > 0 && measuredWidth > 0) {
            if (i3 <= measuredWidth) {
                for (int i5 = 0; i5 < this.efG; i5++) {
                    if (i5 != 0) {
                        this.efE.getChildAt(i5).setLayoutParams(this.efB);
                    } else {
                        this.efE.getChildAt(i5).setLayoutParams(this.owp);
                    }
                    setMyTabLayoutParams(this.efE.getChildAt(i5));
                }
            }
            this.owt = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean ej(int i, int i2) {
        if (this.efG == 0) {
            return false;
        }
        int left = this.efE.getChildAt(i).getLeft() + i2;
        if (i > 0 || i2 > 0) {
            left -= this.scrollOffset;
        }
        int i3 = left - this.mInterval;
        if (i3 != this.efR) {
            this.efR = i3;
            scrollTo(i3, 0);
            return false;
        }
        return true;
    }

    public void setTabDrawMode(int i) {
        this.owA = i;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (!isInEditMode() && this.efG != 0) {
            if (this.owA == 0) {
                ar(canvas);
            } else {
                as(canvas);
            }
        }
    }

    private void ar(Canvas canvas) {
        int height = getHeight();
        this.efI.setColor(this.indicatorColor);
        View childAt = this.efE.getChildAt(this.Yz);
        float left = childAt.getLeft();
        float right = childAt.getRight();
        if (this.efH > 0.0f && this.Yz < this.efG - 1) {
            View childAt2 = this.efE.getChildAt(this.Yz + 1);
            left = (left * (1.0f - this.efH)) + (childAt2.getLeft() * this.efH);
            right = (childAt2.getRight() * this.efH) + ((1.0f - this.efH) * right);
        }
        if (this.indicatorWidth > 0) {
            float f2 = ((right - left) - this.indicatorWidth) / 2.0f;
            this.mRectF.set(left + f2, height - this.indicatorHeight, f2 + left + this.indicatorWidth, height);
            if (this.owv) {
                canvas.drawRoundRect(this.mRectF, this.indicatorHeight / 2, this.indicatorHeight / 2, this.efI);
            } else {
                canvas.drawRect(this.mRectF, this.efI);
            }
        } else {
            canvas.drawRect(left, height - this.indicatorHeight, right, height, this.efI);
        }
        this.efI.setColor(this.underlineColor);
        canvas.drawRect(0.0f, height - this.underlineHeight, this.efE.getWidth(), height, this.efI);
        this.ows.setColor(this.dividerColor);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.efG - 1) {
                View childAt3 = this.efE.getChildAt(i2);
                canvas.drawLine(childAt3.getRight(), this.dividerPadding, childAt3.getRight(), height - this.dividerPadding, this.ows);
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
        this.efI.setColor(this.underlineColor);
        canvas.drawRect(0.0f, height - this.underlineHeight, this.efE.getWidth(), height, this.efI);
        this.efI.setColor(this.indicatorColor);
        View childAt = this.efE.getChildAt(this.Yz);
        float left = childAt.getLeft();
        View childAt2 = ((RelativeLayout) childAt).getChildAt(0);
        float left2 = childAt2.getLeft();
        float right = childAt2.getRight();
        if (this.efH <= 0.0f || this.Yz >= this.efG - 1) {
            f2 = right;
            f3 = left2;
            f4 = left;
        } else {
            View childAt3 = this.efE.getChildAt(this.Yz + 1);
            float left3 = (left * (1.0f - this.efH)) + (childAt3.getLeft() * this.efH);
            View childAt4 = ((RelativeLayout) childAt3).getChildAt(0);
            f3 = (childAt4.getLeft() * this.efH) + (left2 * (1.0f - this.efH));
            f2 = (childAt4.getRight() * this.efH) + (right * (1.0f - this.efH));
            f4 = left3;
        }
        if (this.indicatorWidth > 0) {
            float f5 = ((f2 - f3) - this.indicatorWidth) / 2.0f;
            this.mRectF.set(f4 + f3 + f5, height - this.indicatorHeight, f5 + f3 + f4 + this.indicatorWidth, height);
            if (this.owv) {
                canvas.drawRoundRect(this.mRectF, this.indicatorHeight / 2, this.indicatorHeight / 2, this.efI);
            } else {
                canvas.drawRect(this.mRectF, this.efI);
            }
        } else {
            canvas.drawRect(f3 + f4, height - this.indicatorHeight, f4 + f2, height, this.efI);
        }
        this.ows.setColor(this.dividerColor);
        this.efI.setColor(this.underlineColor);
        for (int i = 0; i < this.efG; i++) {
            View childAt5 = this.efE.getChildAt(i);
            if (i < this.efG - 1) {
                canvas.drawLine(childAt5.getRight(), this.dividerPadding, childAt5.getRight(), height - this.dividerPadding, this.ows);
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
            PagerSlidingTabStrip.this.Yz = i;
            PagerSlidingTabStrip.this.efH = f;
            if (PagerSlidingTabStrip.this.efE != null) {
                PagerSlidingTabStrip.this.ej(i, (int) (PagerSlidingTabStrip.this.efE.getChildAt(i).getWidth() * f));
            }
            PagerSlidingTabStrip.this.invalidate();
            if (PagerSlidingTabStrip.this.efD != null) {
                PagerSlidingTabStrip.this.efD.onPageScrolled(i, f, i2);
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            if (i == 0) {
                PagerSlidingTabStrip.this.ej(PagerSlidingTabStrip.this.efF.getCurrentItem(), 0);
            }
            if (PagerSlidingTabStrip.this.efD != null) {
                PagerSlidingTabStrip.this.efD.onPageScrollStateChanged(i);
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            PagerSlidingTabStrip.this.setSelectItem(i);
            if (PagerSlidingTabStrip.this.efD != null) {
                PagerSlidingTabStrip.this.efD.onPageSelected(i);
            }
        }
    }

    public void setSelectItem(int i) {
        if (this.efE != null) {
            this.owr = i;
            for (int i2 = 0; i2 < this.efE.getChildCount(); i2++) {
                if (i2 == i) {
                    RelativeLayout relativeLayout = (RelativeLayout) this.efE.getChildAt(i);
                    relativeLayout.setSelected(true);
                    TextView textView = (TextView) relativeLayout.getChildAt(0);
                    textView.setTypeface(this.efP, this.owz);
                    textView.setTextColor(this.tabTextSelectColor);
                    textView.setTextSize(0, this.owx);
                    if (this.owC != -1) {
                        textView.setBackgroundResource(this.owC);
                    }
                    if (this.efF.getAdapter() instanceof b) {
                        textView.setCompoundDrawablesWithIntrinsicBounds(0, ((b) this.efF.getAdapter()).KA(i), 0, 0);
                    }
                } else {
                    RelativeLayout relativeLayout2 = (RelativeLayout) this.efE.getChildAt(i2);
                    relativeLayout2.setSelected(false);
                    TextView textView2 = (TextView) relativeLayout2.getChildAt(0);
                    textView2.setTextColor(this.tabTextColor);
                    textView2.setBackgroundResource(0);
                    textView2.setTextSize(0, this.tabTextSize);
                    textView2.setTypeface(this.efP, this.efQ);
                    if (this.efF.getAdapter() instanceof b) {
                        textView2.setCompoundDrawablesWithIntrinsicBounds(0, ((b) this.efF.getAdapter()).mu(i2), 0, 0);
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
        this.efJ = z;
        requestLayout();
    }

    public boolean getShouldExpand() {
        return this.efJ;
    }

    public void setAllCaps(boolean z) {
        this.owu = z;
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
        this.efP = typeface;
        this.efQ = i;
        updateTabStyles();
    }

    public void setSelectedTypeface(Typeface typeface, int i) {
        this.efP = typeface;
        this.owz = i;
        updateTabStyles();
    }

    public void setTabBackground(int i) {
        this.efS = i;
    }

    public int getTabBackground() {
        return this.efS;
    }

    public void setTabPaddingLeftRight(int i) {
        this.tabPadding = i;
        updateTabStyles();
    }

    public int getTabPaddingLeftRight() {
        return this.tabPadding;
    }

    public void setIconPadding(int i) {
        this.oww = i;
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.Yz = savedState.Yz;
        requestLayout();
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.Yz = this.Yz;
        return savedState;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() { // from class: tv.chushou.zues.widget.psts.PagerSlidingTabStrip.SavedState.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            /* renamed from: as */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            /* renamed from: My */
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };
        int Yz;

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.Yz = parcel.readInt();
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.Yz);
        }
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.owN != null) {
            this.owN.yu(true);
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    public void setDisallowIntercept(tv.chushou.zues.widget.psts.a aVar) {
        this.owN = aVar;
    }
}
