package com.kwad.sdk.lib.widget.viewpager.tabstrip;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.core.content.res.ResourcesCompat;
import androidx.viewpager.widget.ViewPager;
import com.kwad.sdk.R;
import com.kwad.sdk.lib.widget.a;
import com.kwad.sdk.utils.ao;
import java.util.Arrays;
import java.util.Locale;
/* loaded from: classes7.dex */
public class PagerSlidingTabStrip extends HorizontalScrollView {

    /* renamed from: h  reason: collision with root package name */
    public static final int[] f36838h = {16842901, 16842904, 16842927};
    public int A;
    public int B;
    public ColorStateList C;
    public Typeface D;
    public int E;
    public int F;
    public int G;
    public int H;
    public int I;
    public Locale J;
    public boolean K;
    public int L;
    public c M;
    public int N;
    public int O;
    public boolean P;
    public int Q;
    public com.kwad.sdk.lib.widget.a R;
    public boolean S;
    public boolean T;
    public int U;
    public boolean V;

    /* renamed from: a  reason: collision with root package name */
    public ViewPager.OnPageChangeListener f36839a;

    /* renamed from: b  reason: collision with root package name */
    public LinearLayout f36840b;

    /* renamed from: c  reason: collision with root package name */
    public ViewPager f36841c;

    /* renamed from: d  reason: collision with root package name */
    public int f36842d;

    /* renamed from: e  reason: collision with root package name */
    public float f36843e;

    /* renamed from: f  reason: collision with root package name */
    public int f36844f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f36845g;

    /* renamed from: i  reason: collision with root package name */
    public LinearLayout.LayoutParams f36846i;
    public final a j;
    public d k;
    public int l;
    public Paint m;
    public Paint n;
    public int o;
    public int p;
    public int q;
    public boolean r;
    public boolean s;
    public boolean t;
    public int u;
    public int v;
    public int w;
    public int x;
    public int y;
    public int z;

    /* loaded from: classes7.dex */
    public class a implements ViewPager.OnPageChangeListener {
        public a() {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i2) {
            if (i2 == 0) {
                PagerSlidingTabStrip pagerSlidingTabStrip = PagerSlidingTabStrip.this;
                pagerSlidingTabStrip.a(pagerSlidingTabStrip.f36841c.getCurrentItem(), 0);
            }
            ViewPager.OnPageChangeListener onPageChangeListener = PagerSlidingTabStrip.this.f36839a;
            if (onPageChangeListener != null) {
                onPageChangeListener.onPageScrollStateChanged(i2);
            }
            if (i2 == 1) {
                PagerSlidingTabStrip pagerSlidingTabStrip2 = PagerSlidingTabStrip.this;
                pagerSlidingTabStrip2.Q = pagerSlidingTabStrip2.f36841c.getCurrentItem();
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i2, float f2, int i3) {
            PagerSlidingTabStrip pagerSlidingTabStrip;
            if (i2 >= PagerSlidingTabStrip.this.f36840b.getChildCount() - (PagerSlidingTabStrip.this.M != null ? 1 : 0)) {
                return;
            }
            PagerSlidingTabStrip pagerSlidingTabStrip2 = PagerSlidingTabStrip.this;
            pagerSlidingTabStrip2.f36842d = i2;
            pagerSlidingTabStrip2.f36843e = f2;
            if (pagerSlidingTabStrip2.V) {
                float width = PagerSlidingTabStrip.this.f36840b.getChildAt(i2).getWidth();
                if (i2 < PagerSlidingTabStrip.this.f36840b.getChildCount() - 1) {
                    int i4 = i2 + 1;
                    width = (PagerSlidingTabStrip.this.f36840b.getChildAt(i4).getLeft() + (PagerSlidingTabStrip.this.f36840b.getChildAt(i4).getWidth() / 2)) - (PagerSlidingTabStrip.this.f36840b.getChildAt(i2).getLeft() + (PagerSlidingTabStrip.this.f36840b.getChildAt(i2).getWidth() / 2));
                }
                PagerSlidingTabStrip.this.a(i2, (int) (width * f2));
            } else {
                PagerSlidingTabStrip.this.a(i2, (int) (pagerSlidingTabStrip.f36840b.getChildAt(i2).getWidth() * f2));
            }
            PagerSlidingTabStrip.this.invalidate();
            ViewPager.OnPageChangeListener onPageChangeListener = PagerSlidingTabStrip.this.f36839a;
            if (onPageChangeListener != null) {
                onPageChangeListener.onPageScrolled(i2, f2, i3);
            }
            if (PagerSlidingTabStrip.this.Q == i2) {
                PagerSlidingTabStrip.this.f36845g = true;
            } else {
                PagerSlidingTabStrip.this.f36845g = false;
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i2) {
            PagerSlidingTabStrip.this.a(i2);
            ViewPager.OnPageChangeListener onPageChangeListener = PagerSlidingTabStrip.this.f36839a;
            if (onPageChangeListener != null) {
                onPageChangeListener.onPageSelected(i2);
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class b extends View.BaseSavedState {
        public static final Parcelable.Creator<b> CREATOR = new Parcelable.Creator<b>() { // from class: com.kwad.sdk.lib.widget.viewpager.tabstrip.PagerSlidingTabStrip.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            /* renamed from: a */
            public b createFromParcel(Parcel parcel) {
                return new b(parcel);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            /* renamed from: a */
            public b[] newArray(int i2) {
                return new b[i2];
            }
        };

        /* renamed from: a  reason: collision with root package name */
        public int f36849a;

        public b(Parcel parcel) {
            super(parcel);
            this.f36849a = parcel.readInt();
        }

        public b(Parcelable parcelable) {
            super(parcelable);
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeInt(this.f36849a);
        }
    }

    /* loaded from: classes7.dex */
    public static class c {

        /* renamed from: a  reason: collision with root package name */
        public View.OnClickListener f36850a;

        /* renamed from: b  reason: collision with root package name */
        public CharSequence f36851b;

        /* renamed from: c  reason: collision with root package name */
        public View f36852c;

        /* renamed from: d  reason: collision with root package name */
        public View f36853d;

        /* renamed from: e  reason: collision with root package name */
        public int f36854e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f36855f;

        /* renamed from: g  reason: collision with root package name */
        public boolean f36856g;

        /* renamed from: h  reason: collision with root package name */
        public String f36857h;

        /* loaded from: classes7.dex */
        public interface a {
            c b(int i2);
        }

        public c(String str) {
            this.f36857h = str;
        }

        public c(String str, CharSequence charSequence) {
            this(str);
            this.f36851b = charSequence;
        }

        public View a(Context context, final int i2, final ViewPager viewPager) {
            this.f36854e = i2;
            View view = this.f36852c;
            if (view != null) {
                this.f36853d = view;
            } else {
                TextView textView = new TextView(context);
                this.f36853d = textView;
                TextView textView2 = textView;
                textView2.setText(this.f36851b);
                textView2.setFocusable(true);
                textView2.setGravity(17);
                textView2.setSingleLine();
            }
            this.f36853d.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.sdk.lib.widget.viewpager.tabstrip.PagerSlidingTabStrip.c.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    View.OnClickListener onClickListener = c.this.f36850a;
                    if (onClickListener != null) {
                        onClickListener.onClick(view2);
                        if (c.this.f36856g) {
                            return;
                        }
                    }
                    if (c.this.f36855f) {
                        return;
                    }
                    viewPager.setCurrentItem(i2);
                }
            });
            return this.f36853d;
        }

        public String a() {
            return this.f36857h;
        }
    }

    /* loaded from: classes7.dex */
    public interface d {
        void a();
    }

    public PagerSlidingTabStrip(Context context) {
        this(context, null);
    }

    public PagerSlidingTabStrip(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    @SuppressLint({"ResourceType"})
    public PagerSlidingTabStrip(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.j = new a();
        this.f36842d = 0;
        this.f36843e = 0.0f;
        this.f36844f = -1;
        this.o = -10066330;
        this.p = 436207616;
        this.q = 436207616;
        this.r = false;
        this.s = false;
        this.t = false;
        this.u = 52;
        this.v = 8;
        this.w = 0;
        this.x = 2;
        this.y = 12;
        this.z = 24;
        this.A = 1;
        this.B = 12;
        this.D = null;
        this.E = 1;
        this.F = 1;
        this.G = 0;
        this.H = 0;
        this.L = 0;
        this.R = null;
        this.S = true;
        this.T = true;
        setFillViewport(true);
        setWillNotDraw(false);
        LinearLayout linearLayout = new LinearLayout(context);
        this.f36840b = linearLayout;
        linearLayout.setOrientation(0);
        this.f36840b.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.f36840b.setGravity(this.L);
        this.f36840b.setClipChildren(false);
        this.f36840b.setClipToPadding(false);
        addView(this.f36840b);
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        this.u = (int) TypedValue.applyDimension(1, this.u, displayMetrics);
        this.v = (int) TypedValue.applyDimension(1, this.v, displayMetrics);
        this.x = (int) TypedValue.applyDimension(1, this.x, displayMetrics);
        this.y = (int) TypedValue.applyDimension(1, this.y, displayMetrics);
        this.z = (int) TypedValue.applyDimension(1, this.z, displayMetrics);
        this.A = (int) TypedValue.applyDimension(1, this.A, displayMetrics);
        this.B = (int) TypedValue.applyDimension(2, this.B, displayMetrics);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f36838h);
        this.B = obtainStyledAttributes.getDimensionPixelSize(0, this.B);
        this.C = obtainStyledAttributes.getColorStateList(1);
        this.L = obtainStyledAttributes.getInt(2, this.L);
        obtainStyledAttributes.recycle();
        int i3 = R.attr.ksad_pstsIndicatorColor;
        int i4 = R.attr.ksad_pstsUnderlineColor;
        int i5 = R.attr.ksad_pstsDividerColor;
        int i6 = R.attr.ksad_pstsIndicatorHeight;
        int i7 = R.attr.ksad_pstsUnderlineHeight;
        int i8 = R.attr.ksad_pstsDividerPadding;
        int i9 = R.attr.ksad_pstsTabPaddingLeftRight;
        int i10 = R.attr.ksad_pstsTabBackground;
        int i11 = R.attr.ksad_pstsShouldExpand;
        int i12 = R.attr.ksad_pstsScrollOffset;
        int i13 = R.attr.ksad_pstsTextAllCaps;
        int i14 = R.attr.ksad_pstsIndicatorPadding;
        int i15 = R.attr.ksad_pstsShouldOverScroll;
        int i16 = R.attr.ksad_pstsIndicatorWidth;
        int i17 = R.attr.ksad_pstsIndicatorWidthFitText;
        int i18 = R.attr.ksad_pstsIndicatorMarginBottom;
        int i19 = R.attr.ksad_pstsAverageWidth;
        int i20 = R.attr.ksad_pstsScrollSelectedTabToCenter;
        int i21 = R.attr.ksad_pstsIndicatorCorner;
        int[] iArr = {i3, i4, i5, i6, i7, i8, i9, i10, i11, i12, i13, i14, i15, i16, i17, i18, i19, i20, i21};
        Arrays.sort(iArr);
        TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, iArr);
        this.o = obtainStyledAttributes.getColor(Arrays.binarySearch(iArr, i3), this.o);
        this.p = obtainStyledAttributes.getColor(Arrays.binarySearch(iArr, i4), this.p);
        this.q = obtainStyledAttributes.getColor(Arrays.binarySearch(iArr, i5), this.q);
        this.v = obtainStyledAttributes.getDimensionPixelSize(Arrays.binarySearch(iArr, i6), this.v);
        this.x = obtainStyledAttributes.getDimensionPixelSize(Arrays.binarySearch(iArr, i7), this.x);
        this.y = obtainStyledAttributes.getDimensionPixelSize(Arrays.binarySearch(iArr, i8), this.y);
        this.z = obtainStyledAttributes.getDimensionPixelSize(Arrays.binarySearch(iArr, i9), this.z);
        this.I = obtainStyledAttributes.getResourceId(Arrays.binarySearch(iArr, i10), this.I);
        this.r = obtainStyledAttributes.getBoolean(Arrays.binarySearch(iArr, i11), this.r);
        this.u = obtainStyledAttributes.getDimensionPixelSize(Arrays.binarySearch(iArr, i12), this.u);
        this.s = obtainStyledAttributes.getBoolean(Arrays.binarySearch(iArr, i13), this.s);
        this.w = obtainStyledAttributes.getDimensionPixelSize(Arrays.binarySearch(iArr, i14), 0);
        this.t = obtainStyledAttributes.getBoolean(Arrays.binarySearch(iArr, i15), this.t);
        this.O = obtainStyledAttributes.getDimensionPixelSize(Arrays.binarySearch(iArr, i16), 0);
        this.P = obtainStyledAttributes.getBoolean(Arrays.binarySearch(iArr, i17), false);
        this.U = obtainStyledAttributes.getDimensionPixelSize(Arrays.binarySearch(iArr, i18), 0);
        this.T = obtainStyledAttributes.getBoolean(Arrays.binarySearch(iArr, i19), true);
        this.V = obtainStyledAttributes.getBoolean(Arrays.binarySearch(iArr, i20), false);
        this.N = obtainStyledAttributes.getDimensionPixelSize(Arrays.binarySearch(iArr, i21), ao.a(getContext(), 15.0f));
        obtainStyledAttributes2.recycle();
        Paint paint = new Paint();
        this.m = paint;
        paint.setAntiAlias(true);
        this.m.setStyle(Paint.Style.FILL);
        Paint paint2 = new Paint();
        this.n = paint2;
        paint2.setAntiAlias(true);
        this.n.setStrokeWidth(this.A);
        this.f36846i = this.T ? new LinearLayout.LayoutParams(0, -1, 1.0f) : new LinearLayout.LayoutParams(-2, -1);
        if (this.J == null) {
            this.J = getResources().getConfiguration().locale;
        }
    }

    private float a(View view, CharSequence charSequence, TextPaint textPaint) {
        if (this.R == null) {
            this.R = new com.kwad.sdk.lib.widget.a();
        }
        return (view.getWidth() - this.R.a(charSequence, textPaint, this.B)) / 2.0f;
    }

    private void a(int i2, c cVar) {
        this.f36840b.addView(cVar.a(getContext(), i2, this.f36841c), i2);
    }

    private void a(View view) {
        float f2;
        int i2 = this.f36842d;
        View childAt = i2 < this.l ? this.f36840b.getChildAt(i2 + 1) : null;
        if (childAt == null) {
            childAt = view;
        }
        float f3 = 0.0f;
        if (view instanceof TextView) {
            TextView textView = (TextView) view;
            TextView textView2 = (TextView) childAt;
            f3 = a(textView, textView.getText(), textView.getPaint());
            f2 = a(textView2, textView2.getText(), textView2.getPaint());
        } else if (view instanceof a.InterfaceC0428a) {
            a.InterfaceC0428a interfaceC0428a = (a.InterfaceC0428a) view;
            a.InterfaceC0428a interfaceC0428a2 = (a.InterfaceC0428a) childAt;
            f3 = a((View) interfaceC0428a, interfaceC0428a.a(), interfaceC0428a.b());
            f2 = a((View) interfaceC0428a2, interfaceC0428a2.a(), interfaceC0428a2.b());
        } else {
            f2 = 0.0f;
        }
        this.w = (int) (this.f36845g ? f3 + ((f2 - f3) * this.f36843e) : f3 - ((f3 - f2) * this.f36843e));
    }

    private void d() {
        TextView textView;
        int i2;
        this.f36841c.getCurrentItem();
        for (int i3 = 0; i3 < this.f36840b.getChildCount(); i3++) {
            View childAt = this.f36840b.getChildAt(i3);
            if (childAt.getLayoutParams() == null || childAt.getLayoutParams().width < 0) {
                childAt.setLayoutParams(a());
            }
            childAt.setBackgroundResource(this.I);
            int i4 = this.z;
            childAt.setPadding(i4, 0, i4, 0);
            Typeface typeface = null;
            if (childAt instanceof TextView) {
                textView = (TextView) childAt;
            } else {
                try {
                    textView = (TextView) childAt.findViewById(R.id.ksad_tab_text);
                } catch (Exception unused) {
                    textView = null;
                }
            }
            if (textView != null) {
                textView.setTextSize(0, this.B);
                if (childAt.isSelected()) {
                    i2 = this.F;
                    if (i2 == 1) {
                        textView.setTypeface(null);
                        textView.getPaint().setFakeBoldText(true);
                    }
                    textView.setTypeface(typeface, i2);
                } else {
                    i2 = this.E;
                    if (i2 == 1) {
                        textView.setTypeface(this.D);
                        textView.getPaint().setFakeBoldText(true);
                    } else {
                        typeface = this.D;
                        textView.setTypeface(typeface, i2);
                    }
                }
                ColorStateList colorStateList = this.C;
                if (colorStateList != null) {
                    textView.setTextColor(colorStateList);
                }
                if (this.s) {
                    if (Build.VERSION.SDK_INT >= 14) {
                        textView.setAllCaps(true);
                    } else {
                        textView.setText(textView.getText().toString().toUpperCase(this.J));
                    }
                }
            }
        }
    }

    public ViewGroup.LayoutParams a() {
        return new LinearLayout.LayoutParams(-2, -1);
    }

    public void a(int i2) {
        int i3 = this.f36844f;
        if (i3 != i2 && i2 < this.l && i2 >= 0) {
            View childAt = this.f36840b.getChildAt(i3);
            if (childAt != null) {
                childAt.setSelected(false);
            }
            this.f36844f = i2;
            View childAt2 = this.f36840b.getChildAt(i2);
            if (childAt2 != null) {
                childAt2.setSelected(true);
            }
            d();
        }
    }

    public void a(int i2, int i3) {
        if (this.l == 0) {
            return;
        }
        int left = this.f36840b.getChildAt(i2).getLeft() + i3;
        if (i2 > 0 || i3 > 0) {
            left = this.V ? (left - (getWidth() / 2)) + (this.f36840b.getChildAt(i2).getWidth() / 2) : left - this.u;
        }
        int i4 = this.G;
        if (left != i4) {
            if (this.t) {
                if (left < i4) {
                    this.G = left;
                    this.H = getWidth() + left;
                    scrollTo(left, 0);
                }
                left = (this.f36840b.getChildAt(i2).getRight() - getWidth()) + i3;
                if (i2 > 0 || i3 > 0) {
                    left += this.u;
                }
                if (getWidth() + left <= this.H) {
                    return;
                }
                this.H = getWidth() + left;
            }
            this.G = left;
            scrollTo(left, 0);
        }
    }

    public boolean b() {
        return this.S;
    }

    public void c() {
        int i2;
        c cVar;
        this.f36840b.removeAllViews();
        this.l = this.f36841c.getAdapter().getCount();
        int i3 = 0;
        while (true) {
            i2 = this.l;
            if (i3 >= i2) {
                break;
            }
            a(i3, this.f36841c.getAdapter() instanceof c.a ? ((c.a) this.f36841c.getAdapter()).b(i3) : new c(Integer.toString(i3), this.f36841c.getAdapter().getPageTitle(i3)));
            i3++;
        }
        if (i2 > 0 && (cVar = this.M) != null) {
            a(i2, cVar);
        }
        d();
        this.K = false;
        a(this.f36841c.getCurrentItem());
    }

    public int getTabPadding() {
        return this.z;
    }

    public LinearLayout getTabsContainer() {
        return this.f36840b;
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        d();
        this.K = false;
        post(new Runnable() { // from class: com.kwad.sdk.lib.widget.viewpager.tabstrip.PagerSlidingTabStrip.1
            @Override // java.lang.Runnable
            public void run() {
                PagerSlidingTabStrip pagerSlidingTabStrip = PagerSlidingTabStrip.this;
                pagerSlidingTabStrip.a(pagerSlidingTabStrip.f36844f, 0);
            }
        });
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        RectF rectF;
        int i2;
        super.onDraw(canvas);
        if (isInEditMode() || this.l == 0) {
            return;
        }
        View childAt = this.f36840b.getChildAt(this.f36842d);
        float left = childAt.getLeft();
        float right = childAt.getRight();
        if (this.f36843e > 0.0f && (i2 = this.f36842d) < this.l - 1) {
            View childAt2 = this.f36840b.getChildAt(i2 + 1);
            float f2 = this.f36843e;
            left = (childAt2.getLeft() * f2) + ((1.0f - f2) * left);
            right = (childAt2.getRight() * f2) + ((1.0f - f2) * right);
        }
        int height = getHeight();
        this.m.setColor(this.o);
        int i3 = this.O;
        if (i3 != 0) {
            int i4 = (int) (((right - left) - i3) / 2.0f);
            this.w = i4;
            float f3 = this.f36843e;
            float f4 = i4;
            float f5 = (((double) f3) < 0.5d ? f4 * f3 : f4 * (1.0f - f3)) / 3.0f;
            int i5 = this.w;
            int i6 = this.U;
            rectF = new RectF((left + i5) - f5, ((height - this.v) - 1) - i6, (right - i5) + f5, (height - 1) - i6);
        } else {
            if (this.P) {
                a(childAt);
            }
            int i7 = this.w;
            int i8 = this.U;
            rectF = new RectF(left + i7, (height - this.v) - i8, right - i7, height - i8);
        }
        if (b()) {
            if (Build.VERSION.SDK_INT > 19) {
                int i9 = this.N;
                canvas.drawRoundRect(rectF, i9, i9, this.m);
            } else {
                canvas.drawRect(rectF, this.m);
            }
        }
        this.m.setColor(this.p);
        canvas.drawRect(0.0f, height - this.x, this.f36840b.getWidth(), height, this.m);
        this.n.setColor(this.q);
        for (int i10 = 0; i10 < this.l - 1; i10++) {
            View childAt3 = this.f36840b.getChildAt(i10);
            canvas.drawLine(childAt3.getRight(), this.y, childAt3.getRight(), height - this.y, this.n);
        }
    }

    @Override // android.widget.HorizontalScrollView, android.widget.FrameLayout, android.view.View
    public void onMeasure(int i2, int i3) {
        LinearLayout.LayoutParams layoutParams;
        if (!this.r || this.K || View.MeasureSpec.getMode(i2) == 0) {
            super.onMeasure(i2, i3);
            return;
        }
        if (!this.K) {
            super.onMeasure(i2, i3);
        }
        int measuredWidth = getMeasuredWidth();
        int i4 = 0;
        for (int i5 = 0; i5 < this.l; i5++) {
            i4 += this.f36840b.getChildAt(i5).getMeasuredWidth();
        }
        if (i4 > 0 && measuredWidth > 0) {
            this.u = this.f36840b.getChildAt(0).getMeasuredWidth();
            if (i4 <= measuredWidth) {
                for (int i6 = 0; i6 < this.l; i6++) {
                    View childAt = this.f36840b.getChildAt(i6);
                    if (i6 == 0) {
                        LinearLayout.LayoutParams layoutParams2 = this.f36846i;
                        layoutParams = new LinearLayout.LayoutParams(layoutParams2.width, layoutParams2.height);
                        LinearLayout.LayoutParams layoutParams3 = this.f36846i;
                        layoutParams.gravity = layoutParams3.gravity;
                        layoutParams.weight = layoutParams3.weight;
                        layoutParams.rightMargin = layoutParams3.rightMargin;
                        layoutParams.bottomMargin = layoutParams3.bottomMargin;
                        layoutParams.topMargin = layoutParams3.topMargin;
                        layoutParams.leftMargin = 0;
                    } else {
                        layoutParams = this.f36846i;
                    }
                    childAt.setLayoutParams(layoutParams);
                    int i7 = this.z;
                    childAt.setPadding(i7, 0, i7, 0);
                }
            }
            this.K = true;
        }
        super.onMeasure(i2, i3);
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        b bVar = (b) parcelable;
        super.onRestoreInstanceState(bVar.getSuperState());
        this.f36842d = bVar.f36849a;
        requestLayout();
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public Parcelable onSaveInstanceState() {
        b bVar = new b(super.onSaveInstanceState());
        bVar.f36849a = this.f36842d;
        return bVar;
    }

    @Override // android.view.View
    public void onScrollChanged(int i2, int i3, int i4, int i5) {
        super.onScrollChanged(i2, i3, i4, i5);
        d dVar = this.k;
        if (dVar != null) {
            dVar.a();
        }
    }

    public void setClickOnlyTabStrip(c cVar) {
        this.M = cVar;
    }

    public void setIndicatorColor(@ColorRes int i2) {
        this.o = ResourcesCompat.getColor(getResources(), i2, null);
    }

    public void setIndicatorColorInt(@ColorInt int i2) {
        this.o = i2;
    }

    public void setIndicatorPadding(int i2) {
        this.w = i2;
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.f36839a = onPageChangeListener;
    }

    public void setScrollListener(d dVar) {
        this.k = dVar;
    }

    public void setScrollSelectedTabToCenter(boolean z) {
        this.V = z;
    }

    public void setTabGravity(int i2) {
        this.L = i2;
        this.f36840b.setGravity(i2);
    }

    public void setTabLayoutParams(LinearLayout.LayoutParams layoutParams) {
        this.f36846i = layoutParams;
    }

    public void setTabPadding(int i2) {
        if (this.z != i2) {
            this.z = i2;
            requestLayout();
        }
    }

    public void setTabTypefaceStyle(int i2) {
        this.E = i2;
        this.F = i2;
        d();
    }

    public void setTextColor(@ColorRes int i2) {
        this.C = ResourcesCompat.getColorStateList(getResources(), i2, null);
        d();
    }

    public void setViewPager(ViewPager viewPager) {
        this.f36841c = viewPager;
        if (viewPager.getAdapter() == null) {
            throw new IllegalStateException("ViewPager does not have adapter instance.");
        }
        viewPager.setOnPageChangeListener(this.j);
        c();
    }
}
