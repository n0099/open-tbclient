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
/* loaded from: classes6.dex */
public class PagerSlidingTabStrip extends HorizontalScrollView {

    /* renamed from: h  reason: collision with root package name */
    public static final int[] f36417h = {16842901, 16842904, 16842927};
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
    public ViewPager.OnPageChangeListener f36418a;

    /* renamed from: b  reason: collision with root package name */
    public LinearLayout f36419b;

    /* renamed from: c  reason: collision with root package name */
    public ViewPager f36420c;

    /* renamed from: d  reason: collision with root package name */
    public int f36421d;

    /* renamed from: e  reason: collision with root package name */
    public float f36422e;

    /* renamed from: f  reason: collision with root package name */
    public int f36423f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f36424g;
    public LinearLayout.LayoutParams i;
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

    /* loaded from: classes6.dex */
    public class a implements ViewPager.OnPageChangeListener {
        public a() {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            if (i == 0) {
                PagerSlidingTabStrip pagerSlidingTabStrip = PagerSlidingTabStrip.this;
                pagerSlidingTabStrip.a(pagerSlidingTabStrip.f36420c.getCurrentItem(), 0);
            }
            ViewPager.OnPageChangeListener onPageChangeListener = PagerSlidingTabStrip.this.f36418a;
            if (onPageChangeListener != null) {
                onPageChangeListener.onPageScrollStateChanged(i);
            }
            if (i == 1) {
                PagerSlidingTabStrip pagerSlidingTabStrip2 = PagerSlidingTabStrip.this;
                pagerSlidingTabStrip2.Q = pagerSlidingTabStrip2.f36420c.getCurrentItem();
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f2, int i2) {
            PagerSlidingTabStrip pagerSlidingTabStrip;
            if (i >= PagerSlidingTabStrip.this.f36419b.getChildCount() - (PagerSlidingTabStrip.this.M != null ? 1 : 0)) {
                return;
            }
            PagerSlidingTabStrip pagerSlidingTabStrip2 = PagerSlidingTabStrip.this;
            pagerSlidingTabStrip2.f36421d = i;
            pagerSlidingTabStrip2.f36422e = f2;
            if (pagerSlidingTabStrip2.V) {
                float width = PagerSlidingTabStrip.this.f36419b.getChildAt(i).getWidth();
                if (i < PagerSlidingTabStrip.this.f36419b.getChildCount() - 1) {
                    int i3 = i + 1;
                    width = (PagerSlidingTabStrip.this.f36419b.getChildAt(i3).getLeft() + (PagerSlidingTabStrip.this.f36419b.getChildAt(i3).getWidth() / 2)) - (PagerSlidingTabStrip.this.f36419b.getChildAt(i).getLeft() + (PagerSlidingTabStrip.this.f36419b.getChildAt(i).getWidth() / 2));
                }
                PagerSlidingTabStrip.this.a(i, (int) (width * f2));
            } else {
                PagerSlidingTabStrip.this.a(i, (int) (pagerSlidingTabStrip.f36419b.getChildAt(i).getWidth() * f2));
            }
            PagerSlidingTabStrip.this.invalidate();
            ViewPager.OnPageChangeListener onPageChangeListener = PagerSlidingTabStrip.this.f36418a;
            if (onPageChangeListener != null) {
                onPageChangeListener.onPageScrolled(i, f2, i2);
            }
            if (PagerSlidingTabStrip.this.Q == i) {
                PagerSlidingTabStrip.this.f36424g = true;
            } else {
                PagerSlidingTabStrip.this.f36424g = false;
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            PagerSlidingTabStrip.this.a(i);
            ViewPager.OnPageChangeListener onPageChangeListener = PagerSlidingTabStrip.this.f36418a;
            if (onPageChangeListener != null) {
                onPageChangeListener.onPageSelected(i);
            }
        }
    }

    /* loaded from: classes6.dex */
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
            public b[] newArray(int i) {
                return new b[i];
            }
        };

        /* renamed from: a  reason: collision with root package name */
        public int f36427a;

        public b(Parcel parcel) {
            super(parcel);
            this.f36427a = parcel.readInt();
        }

        public b(Parcelable parcelable) {
            super(parcelable);
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.f36427a);
        }
    }

    /* loaded from: classes6.dex */
    public static class c {

        /* renamed from: a  reason: collision with root package name */
        public View.OnClickListener f36428a;

        /* renamed from: b  reason: collision with root package name */
        public CharSequence f36429b;

        /* renamed from: c  reason: collision with root package name */
        public View f36430c;

        /* renamed from: d  reason: collision with root package name */
        public View f36431d;

        /* renamed from: e  reason: collision with root package name */
        public int f36432e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f36433f;

        /* renamed from: g  reason: collision with root package name */
        public boolean f36434g;

        /* renamed from: h  reason: collision with root package name */
        public String f36435h;

        /* loaded from: classes6.dex */
        public interface a {
            c b(int i);
        }

        public c(String str) {
            this.f36435h = str;
        }

        public c(String str, CharSequence charSequence) {
            this(str);
            this.f36429b = charSequence;
        }

        public View a(Context context, final int i, final ViewPager viewPager) {
            this.f36432e = i;
            View view = this.f36430c;
            if (view != null) {
                this.f36431d = view;
            } else {
                TextView textView = new TextView(context);
                this.f36431d = textView;
                TextView textView2 = textView;
                textView2.setText(this.f36429b);
                textView2.setFocusable(true);
                textView2.setGravity(17);
                textView2.setSingleLine();
            }
            this.f36431d.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.sdk.lib.widget.viewpager.tabstrip.PagerSlidingTabStrip.c.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    View.OnClickListener onClickListener = c.this.f36428a;
                    if (onClickListener != null) {
                        onClickListener.onClick(view2);
                        if (c.this.f36434g) {
                            return;
                        }
                    }
                    if (c.this.f36433f) {
                        return;
                    }
                    viewPager.setCurrentItem(i);
                }
            });
            return this.f36431d;
        }

        public String a() {
            return this.f36435h;
        }
    }

    /* loaded from: classes6.dex */
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
    public PagerSlidingTabStrip(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.j = new a();
        this.f36421d = 0;
        this.f36422e = 0.0f;
        this.f36423f = -1;
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
        this.f36419b = linearLayout;
        linearLayout.setOrientation(0);
        this.f36419b.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.f36419b.setGravity(this.L);
        this.f36419b.setClipChildren(false);
        this.f36419b.setClipToPadding(false);
        addView(this.f36419b);
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        this.u = (int) TypedValue.applyDimension(1, this.u, displayMetrics);
        this.v = (int) TypedValue.applyDimension(1, this.v, displayMetrics);
        this.x = (int) TypedValue.applyDimension(1, this.x, displayMetrics);
        this.y = (int) TypedValue.applyDimension(1, this.y, displayMetrics);
        this.z = (int) TypedValue.applyDimension(1, this.z, displayMetrics);
        this.A = (int) TypedValue.applyDimension(1, this.A, displayMetrics);
        this.B = (int) TypedValue.applyDimension(2, this.B, displayMetrics);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f36417h);
        this.B = obtainStyledAttributes.getDimensionPixelSize(0, this.B);
        this.C = obtainStyledAttributes.getColorStateList(1);
        this.L = obtainStyledAttributes.getInt(2, this.L);
        obtainStyledAttributes.recycle();
        int i2 = R.attr.ksad_pstsIndicatorColor;
        int i3 = R.attr.ksad_pstsUnderlineColor;
        int i4 = R.attr.ksad_pstsDividerColor;
        int i5 = R.attr.ksad_pstsIndicatorHeight;
        int i6 = R.attr.ksad_pstsUnderlineHeight;
        int i7 = R.attr.ksad_pstsDividerPadding;
        int i8 = R.attr.ksad_pstsTabPaddingLeftRight;
        int i9 = R.attr.ksad_pstsTabBackground;
        int i10 = R.attr.ksad_pstsShouldExpand;
        int i11 = R.attr.ksad_pstsScrollOffset;
        int i12 = R.attr.ksad_pstsTextAllCaps;
        int i13 = R.attr.ksad_pstsIndicatorPadding;
        int i14 = R.attr.ksad_pstsShouldOverScroll;
        int i15 = R.attr.ksad_pstsIndicatorWidth;
        int i16 = R.attr.ksad_pstsIndicatorWidthFitText;
        int i17 = R.attr.ksad_pstsIndicatorMarginBottom;
        int i18 = R.attr.ksad_pstsAverageWidth;
        int i19 = R.attr.ksad_pstsScrollSelectedTabToCenter;
        int i20 = R.attr.ksad_pstsIndicatorCorner;
        int[] iArr = {i2, i3, i4, i5, i6, i7, i8, i9, i10, i11, i12, i13, i14, i15, i16, i17, i18, i19, i20};
        Arrays.sort(iArr);
        TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, iArr);
        this.o = obtainStyledAttributes.getColor(Arrays.binarySearch(iArr, i2), this.o);
        this.p = obtainStyledAttributes.getColor(Arrays.binarySearch(iArr, i3), this.p);
        this.q = obtainStyledAttributes.getColor(Arrays.binarySearch(iArr, i4), this.q);
        this.v = obtainStyledAttributes.getDimensionPixelSize(Arrays.binarySearch(iArr, i5), this.v);
        this.x = obtainStyledAttributes.getDimensionPixelSize(Arrays.binarySearch(iArr, i6), this.x);
        this.y = obtainStyledAttributes.getDimensionPixelSize(Arrays.binarySearch(iArr, i7), this.y);
        this.z = obtainStyledAttributes.getDimensionPixelSize(Arrays.binarySearch(iArr, i8), this.z);
        this.I = obtainStyledAttributes.getResourceId(Arrays.binarySearch(iArr, i9), this.I);
        this.r = obtainStyledAttributes.getBoolean(Arrays.binarySearch(iArr, i10), this.r);
        this.u = obtainStyledAttributes.getDimensionPixelSize(Arrays.binarySearch(iArr, i11), this.u);
        this.s = obtainStyledAttributes.getBoolean(Arrays.binarySearch(iArr, i12), this.s);
        this.w = obtainStyledAttributes.getDimensionPixelSize(Arrays.binarySearch(iArr, i13), 0);
        this.t = obtainStyledAttributes.getBoolean(Arrays.binarySearch(iArr, i14), this.t);
        this.O = obtainStyledAttributes.getDimensionPixelSize(Arrays.binarySearch(iArr, i15), 0);
        this.P = obtainStyledAttributes.getBoolean(Arrays.binarySearch(iArr, i16), false);
        this.U = obtainStyledAttributes.getDimensionPixelSize(Arrays.binarySearch(iArr, i17), 0);
        this.T = obtainStyledAttributes.getBoolean(Arrays.binarySearch(iArr, i18), true);
        this.V = obtainStyledAttributes.getBoolean(Arrays.binarySearch(iArr, i19), false);
        this.N = obtainStyledAttributes.getDimensionPixelSize(Arrays.binarySearch(iArr, i20), ao.a(getContext(), 15.0f));
        obtainStyledAttributes2.recycle();
        Paint paint = new Paint();
        this.m = paint;
        paint.setAntiAlias(true);
        this.m.setStyle(Paint.Style.FILL);
        Paint paint2 = new Paint();
        this.n = paint2;
        paint2.setAntiAlias(true);
        this.n.setStrokeWidth(this.A);
        this.i = this.T ? new LinearLayout.LayoutParams(0, -1, 1.0f) : new LinearLayout.LayoutParams(-2, -1);
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

    private void a(int i, c cVar) {
        this.f36419b.addView(cVar.a(getContext(), i, this.f36420c), i);
    }

    private void a(View view) {
        float f2;
        int i = this.f36421d;
        View childAt = i < this.l ? this.f36419b.getChildAt(i + 1) : null;
        if (childAt == null) {
            childAt = view;
        }
        float f3 = 0.0f;
        if (view instanceof TextView) {
            TextView textView = (TextView) view;
            TextView textView2 = (TextView) childAt;
            f3 = a(textView, textView.getText(), textView.getPaint());
            f2 = a(textView2, textView2.getText(), textView2.getPaint());
        } else if (view instanceof a.InterfaceC0442a) {
            a.InterfaceC0442a interfaceC0442a = (a.InterfaceC0442a) view;
            a.InterfaceC0442a interfaceC0442a2 = (a.InterfaceC0442a) childAt;
            f3 = a((View) interfaceC0442a, interfaceC0442a.a(), interfaceC0442a.b());
            f2 = a((View) interfaceC0442a2, interfaceC0442a2.a(), interfaceC0442a2.b());
        } else {
            f2 = 0.0f;
        }
        this.w = (int) (this.f36424g ? f3 + ((f2 - f3) * this.f36422e) : f3 - ((f3 - f2) * this.f36422e));
    }

    private void d() {
        TextView textView;
        int i;
        this.f36420c.getCurrentItem();
        for (int i2 = 0; i2 < this.f36419b.getChildCount(); i2++) {
            View childAt = this.f36419b.getChildAt(i2);
            if (childAt.getLayoutParams() == null || childAt.getLayoutParams().width < 0) {
                childAt.setLayoutParams(a());
            }
            childAt.setBackgroundResource(this.I);
            int i3 = this.z;
            childAt.setPadding(i3, 0, i3, 0);
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
                    i = this.F;
                    if (i == 1) {
                        textView.setTypeface(null);
                        textView.getPaint().setFakeBoldText(true);
                    }
                    textView.setTypeface(typeface, i);
                } else {
                    i = this.E;
                    if (i == 1) {
                        textView.setTypeface(this.D);
                        textView.getPaint().setFakeBoldText(true);
                    } else {
                        typeface = this.D;
                        textView.setTypeface(typeface, i);
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

    public void a(int i) {
        int i2 = this.f36423f;
        if (i2 != i && i < this.l && i >= 0) {
            View childAt = this.f36419b.getChildAt(i2);
            if (childAt != null) {
                childAt.setSelected(false);
            }
            this.f36423f = i;
            View childAt2 = this.f36419b.getChildAt(i);
            if (childAt2 != null) {
                childAt2.setSelected(true);
            }
            d();
        }
    }

    public void a(int i, int i2) {
        if (this.l == 0) {
            return;
        }
        int left = this.f36419b.getChildAt(i).getLeft() + i2;
        if (i > 0 || i2 > 0) {
            left = this.V ? (left - (getWidth() / 2)) + (this.f36419b.getChildAt(i).getWidth() / 2) : left - this.u;
        }
        int i3 = this.G;
        if (left != i3) {
            if (this.t) {
                if (left < i3) {
                    this.G = left;
                    this.H = getWidth() + left;
                    scrollTo(left, 0);
                }
                left = (this.f36419b.getChildAt(i).getRight() - getWidth()) + i2;
                if (i > 0 || i2 > 0) {
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
        int i;
        c cVar;
        this.f36419b.removeAllViews();
        this.l = this.f36420c.getAdapter().getCount();
        int i2 = 0;
        while (true) {
            i = this.l;
            if (i2 >= i) {
                break;
            }
            a(i2, this.f36420c.getAdapter() instanceof c.a ? ((c.a) this.f36420c.getAdapter()).b(i2) : new c(Integer.toString(i2), this.f36420c.getAdapter().getPageTitle(i2)));
            i2++;
        }
        if (i > 0 && (cVar = this.M) != null) {
            a(i, cVar);
        }
        d();
        this.K = false;
        a(this.f36420c.getCurrentItem());
    }

    public int getTabPadding() {
        return this.z;
    }

    public LinearLayout getTabsContainer() {
        return this.f36419b;
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        d();
        this.K = false;
        post(new Runnable() { // from class: com.kwad.sdk.lib.widget.viewpager.tabstrip.PagerSlidingTabStrip.1
            @Override // java.lang.Runnable
            public void run() {
                PagerSlidingTabStrip pagerSlidingTabStrip = PagerSlidingTabStrip.this;
                pagerSlidingTabStrip.a(pagerSlidingTabStrip.f36423f, 0);
            }
        });
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        RectF rectF;
        int i;
        super.onDraw(canvas);
        if (isInEditMode() || this.l == 0) {
            return;
        }
        View childAt = this.f36419b.getChildAt(this.f36421d);
        float left = childAt.getLeft();
        float right = childAt.getRight();
        if (this.f36422e > 0.0f && (i = this.f36421d) < this.l - 1) {
            View childAt2 = this.f36419b.getChildAt(i + 1);
            float f2 = this.f36422e;
            left = (childAt2.getLeft() * f2) + ((1.0f - f2) * left);
            right = (childAt2.getRight() * f2) + ((1.0f - f2) * right);
        }
        int height = getHeight();
        this.m.setColor(this.o);
        int i2 = this.O;
        if (i2 != 0) {
            int i3 = (int) (((right - left) - i2) / 2.0f);
            this.w = i3;
            float f3 = this.f36422e;
            float f4 = i3;
            float f5 = (((double) f3) < 0.5d ? f4 * f3 : f4 * (1.0f - f3)) / 3.0f;
            int i4 = this.w;
            int i5 = this.U;
            rectF = new RectF((left + i4) - f5, ((height - this.v) - 1) - i5, (right - i4) + f5, (height - 1) - i5);
        } else {
            if (this.P) {
                a(childAt);
            }
            int i6 = this.w;
            int i7 = this.U;
            rectF = new RectF(left + i6, (height - this.v) - i7, right - i6, height - i7);
        }
        if (b()) {
            if (Build.VERSION.SDK_INT > 19) {
                int i8 = this.N;
                canvas.drawRoundRect(rectF, i8, i8, this.m);
            } else {
                canvas.drawRect(rectF, this.m);
            }
        }
        this.m.setColor(this.p);
        canvas.drawRect(0.0f, height - this.x, this.f36419b.getWidth(), height, this.m);
        this.n.setColor(this.q);
        for (int i9 = 0; i9 < this.l - 1; i9++) {
            View childAt3 = this.f36419b.getChildAt(i9);
            canvas.drawLine(childAt3.getRight(), this.y, childAt3.getRight(), height - this.y, this.n);
        }
    }

    @Override // android.widget.HorizontalScrollView, android.widget.FrameLayout, android.view.View
    public void onMeasure(int i, int i2) {
        LinearLayout.LayoutParams layoutParams;
        if (!this.r || this.K || View.MeasureSpec.getMode(i) == 0) {
            super.onMeasure(i, i2);
            return;
        }
        if (!this.K) {
            super.onMeasure(i, i2);
        }
        int measuredWidth = getMeasuredWidth();
        int i3 = 0;
        for (int i4 = 0; i4 < this.l; i4++) {
            i3 += this.f36419b.getChildAt(i4).getMeasuredWidth();
        }
        if (i3 > 0 && measuredWidth > 0) {
            this.u = this.f36419b.getChildAt(0).getMeasuredWidth();
            if (i3 <= measuredWidth) {
                for (int i5 = 0; i5 < this.l; i5++) {
                    View childAt = this.f36419b.getChildAt(i5);
                    if (i5 == 0) {
                        LinearLayout.LayoutParams layoutParams2 = this.i;
                        layoutParams = new LinearLayout.LayoutParams(layoutParams2.width, layoutParams2.height);
                        LinearLayout.LayoutParams layoutParams3 = this.i;
                        layoutParams.gravity = layoutParams3.gravity;
                        layoutParams.weight = layoutParams3.weight;
                        layoutParams.rightMargin = layoutParams3.rightMargin;
                        layoutParams.bottomMargin = layoutParams3.bottomMargin;
                        layoutParams.topMargin = layoutParams3.topMargin;
                        layoutParams.leftMargin = 0;
                    } else {
                        layoutParams = this.i;
                    }
                    childAt.setLayoutParams(layoutParams);
                    int i6 = this.z;
                    childAt.setPadding(i6, 0, i6, 0);
                }
            }
            this.K = true;
        }
        super.onMeasure(i, i2);
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        b bVar = (b) parcelable;
        super.onRestoreInstanceState(bVar.getSuperState());
        this.f36421d = bVar.f36427a;
        requestLayout();
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public Parcelable onSaveInstanceState() {
        b bVar = new b(super.onSaveInstanceState());
        bVar.f36427a = this.f36421d;
        return bVar;
    }

    @Override // android.view.View
    public void onScrollChanged(int i, int i2, int i3, int i4) {
        super.onScrollChanged(i, i2, i3, i4);
        d dVar = this.k;
        if (dVar != null) {
            dVar.a();
        }
    }

    public void setClickOnlyTabStrip(c cVar) {
        this.M = cVar;
    }

    public void setIndicatorColor(@ColorRes int i) {
        this.o = ResourcesCompat.getColor(getResources(), i, null);
    }

    public void setIndicatorColorInt(@ColorInt int i) {
        this.o = i;
    }

    public void setIndicatorPadding(int i) {
        this.w = i;
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.f36418a = onPageChangeListener;
    }

    public void setScrollListener(d dVar) {
        this.k = dVar;
    }

    public void setScrollSelectedTabToCenter(boolean z) {
        this.V = z;
    }

    public void setTabGravity(int i) {
        this.L = i;
        this.f36419b.setGravity(i);
    }

    public void setTabLayoutParams(LinearLayout.LayoutParams layoutParams) {
        this.i = layoutParams;
    }

    public void setTabPadding(int i) {
        if (this.z != i) {
            this.z = i;
            requestLayout();
        }
    }

    public void setTabTypefaceStyle(int i) {
        this.E = i;
        this.F = i;
        d();
    }

    public void setTextColor(@ColorRes int i) {
        this.C = ResourcesCompat.getColorStateList(getResources(), i, null);
        d();
    }

    public void setViewPager(ViewPager viewPager) {
        this.f36420c = viewPager;
        if (viewPager.getAdapter() == null) {
            throw new IllegalStateException("ViewPager does not have adapter instance.");
        }
        viewPager.setOnPageChangeListener(this.j);
        c();
    }
}
