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
/* loaded from: classes3.dex */
public class PagerSlidingTabStrip extends HorizontalScrollView {
    private static final int[] h = {16842901, 16842904, 16842927};
    private int A;
    private int B;
    private ColorStateList C;
    private Typeface D;
    private int E;
    private int F;
    private int G;
    private int H;
    private int I;
    private Locale J;
    private boolean K;
    private int L;
    private c M;
    private int N;
    private int O;
    private boolean P;
    private int Q;
    private com.kwad.sdk.lib.widget.a R;
    private boolean S;
    private boolean T;
    private int U;
    private boolean V;

    /* renamed from: a  reason: collision with root package name */
    public ViewPager.OnPageChangeListener f10466a;

    /* renamed from: b  reason: collision with root package name */
    LinearLayout f10467b;
    ViewPager c;
    int d;
    float e;
    int f;
    public boolean g;
    private LinearLayout.LayoutParams i;
    private final a j;
    private d k;
    private int l;
    private Paint m;
    private Paint n;
    private int o;
    private int p;
    private int q;
    private boolean r;
    private boolean s;
    private boolean t;
    private int u;
    private int v;
    private int w;
    private int x;
    private int y;
    private int z;

    /* loaded from: classes3.dex */
    private class a implements ViewPager.OnPageChangeListener {
        a() {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            if (i == 0) {
                PagerSlidingTabStrip.this.a(PagerSlidingTabStrip.this.c.getCurrentItem(), 0);
            }
            if (PagerSlidingTabStrip.this.f10466a != null) {
                PagerSlidingTabStrip.this.f10466a.onPageScrollStateChanged(i);
            }
            if (i == 1) {
                PagerSlidingTabStrip.this.Q = PagerSlidingTabStrip.this.c.getCurrentItem();
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
            if (i >= PagerSlidingTabStrip.this.f10467b.getChildCount() - (PagerSlidingTabStrip.this.M != null ? 1 : 0)) {
                return;
            }
            PagerSlidingTabStrip.this.d = i;
            PagerSlidingTabStrip.this.e = f;
            if (PagerSlidingTabStrip.this.V) {
                float width = PagerSlidingTabStrip.this.f10467b.getChildAt(i).getWidth();
                if (i < PagerSlidingTabStrip.this.f10467b.getChildCount() - 1) {
                    width = (PagerSlidingTabStrip.this.f10467b.getChildAt(i + 1).getLeft() + (PagerSlidingTabStrip.this.f10467b.getChildAt(i + 1).getWidth() / 2)) - (PagerSlidingTabStrip.this.f10467b.getChildAt(i).getLeft() + (PagerSlidingTabStrip.this.f10467b.getChildAt(i).getWidth() / 2));
                }
                PagerSlidingTabStrip.this.a(i, (int) (width * f));
            } else {
                PagerSlidingTabStrip.this.a(i, (int) (PagerSlidingTabStrip.this.f10467b.getChildAt(i).getWidth() * f));
            }
            PagerSlidingTabStrip.this.invalidate();
            if (PagerSlidingTabStrip.this.f10466a != null) {
                PagerSlidingTabStrip.this.f10466a.onPageScrolled(i, f, i2);
            }
            if (PagerSlidingTabStrip.this.Q == i) {
                PagerSlidingTabStrip.this.g = true;
            } else {
                PagerSlidingTabStrip.this.g = false;
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            PagerSlidingTabStrip.this.a(i);
            if (PagerSlidingTabStrip.this.f10466a != null) {
                PagerSlidingTabStrip.this.f10466a.onPageSelected(i);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
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
        int f10470a;

        b(Parcel parcel) {
            super(parcel);
            this.f10470a = parcel.readInt();
        }

        public b(Parcelable parcelable) {
            super(parcelable);
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.f10470a);
        }
    }

    /* loaded from: classes3.dex */
    public static class c {

        /* renamed from: a  reason: collision with root package name */
        View.OnClickListener f10471a;

        /* renamed from: b  reason: collision with root package name */
        private CharSequence f10472b;
        private View c;
        private View d;
        private int e;
        private boolean f;
        private boolean g;
        private String h;

        /* loaded from: classes3.dex */
        public interface a {
            c b(int i);
        }

        public c(String str) {
            this.h = str;
        }

        public c(String str, CharSequence charSequence) {
            this(str);
            this.f10472b = charSequence;
        }

        public View a(Context context, final int i, final ViewPager viewPager) {
            this.e = i;
            if (this.c != null) {
                this.d = this.c;
            } else {
                this.d = new TextView(context);
                TextView textView = (TextView) this.d;
                textView.setText(this.f10472b);
                textView.setFocusable(true);
                textView.setGravity(17);
                textView.setSingleLine();
            }
            this.d.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.sdk.lib.widget.viewpager.tabstrip.PagerSlidingTabStrip.c.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (c.this.f10471a != null) {
                        c.this.f10471a.onClick(view);
                        if (c.this.g) {
                            return;
                        }
                    }
                    if (c.this.f) {
                        return;
                    }
                    viewPager.setCurrentItem(i);
                }
            });
            return this.d;
        }

        public String a() {
            return this.h;
        }
    }

    /* loaded from: classes3.dex */
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
        this.d = 0;
        this.e = 0.0f;
        this.f = -1;
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
        this.f10467b = new LinearLayout(context);
        this.f10467b.setOrientation(0);
        this.f10467b.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.f10467b.setGravity(this.L);
        this.f10467b.setClipChildren(false);
        this.f10467b.setClipToPadding(false);
        addView(this.f10467b);
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        this.u = (int) TypedValue.applyDimension(1, this.u, displayMetrics);
        this.v = (int) TypedValue.applyDimension(1, this.v, displayMetrics);
        this.x = (int) TypedValue.applyDimension(1, this.x, displayMetrics);
        this.y = (int) TypedValue.applyDimension(1, this.y, displayMetrics);
        this.z = (int) TypedValue.applyDimension(1, this.z, displayMetrics);
        this.A = (int) TypedValue.applyDimension(1, this.A, displayMetrics);
        this.B = (int) TypedValue.applyDimension(2, this.B, displayMetrics);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, h);
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
        this.m = new Paint();
        this.m.setAntiAlias(true);
        this.m.setStyle(Paint.Style.FILL);
        this.n = new Paint();
        this.n.setAntiAlias(true);
        this.n.setStrokeWidth(this.A);
        if (this.T) {
            this.i = new LinearLayout.LayoutParams(0, -1, 1.0f);
        } else {
            this.i = new LinearLayout.LayoutParams(-2, -1);
        }
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
        this.f10467b.addView(cVar.a(getContext(), i, this.c), i);
    }

    private void a(View view) {
        float f;
        float f2;
        View childAt = this.d < this.l ? this.f10467b.getChildAt(this.d + 1) : null;
        if (childAt == null) {
            childAt = view;
        }
        if (view instanceof TextView) {
            TextView textView = (TextView) view;
            TextView textView2 = (TextView) childAt;
            float a2 = a(textView, textView.getText(), textView.getPaint());
            f = a(textView2, textView2.getText(), textView2.getPaint());
            f2 = a2;
        } else if (view instanceof a.InterfaceC1138a) {
            a.InterfaceC1138a interfaceC1138a = (a.InterfaceC1138a) view;
            a.InterfaceC1138a interfaceC1138a2 = (a.InterfaceC1138a) childAt;
            f2 = a((View) interfaceC1138a, interfaceC1138a.a(), interfaceC1138a.b());
            f = a((View) interfaceC1138a2, interfaceC1138a2.a(), interfaceC1138a2.b());
        } else {
            f = 0.0f;
            f2 = 0.0f;
        }
        if (this.g) {
            this.w = (int) (((f - f2) * this.e) + f2);
        } else {
            this.w = (int) (f2 - ((f2 - f) * this.e));
        }
    }

    private void d() {
        TextView textView;
        this.c.getCurrentItem();
        for (int i = 0; i < this.f10467b.getChildCount(); i++) {
            View childAt = this.f10467b.getChildAt(i);
            if (childAt.getLayoutParams() == null || childAt.getLayoutParams().width < 0) {
                childAt.setLayoutParams(a());
            }
            childAt.setBackgroundResource(this.I);
            childAt.setPadding(this.z, 0, this.z, 0);
            if (childAt instanceof TextView) {
                textView = (TextView) childAt;
            } else {
                try {
                    textView = (TextView) childAt.findViewById(R.id.ksad_tab_text);
                } catch (Exception e) {
                    textView = null;
                }
            }
            if (textView != null) {
                textView.setTextSize(0, this.B);
                if (childAt.isSelected()) {
                    if (this.F == 1) {
                        textView.setTypeface(null);
                        textView.getPaint().setFakeBoldText(true);
                    } else {
                        textView.setTypeface(null, this.F);
                    }
                } else if (this.E == 1) {
                    textView.setTypeface(this.D);
                    textView.getPaint().setFakeBoldText(true);
                } else {
                    textView.setTypeface(this.D, this.E);
                }
                if (this.C != null) {
                    textView.setTextColor(this.C);
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

    void a(int i) {
        if (this.f != i && i < this.l && i >= 0) {
            View childAt = this.f10467b.getChildAt(this.f);
            if (childAt != null) {
                childAt.setSelected(false);
            }
            this.f = i;
            View childAt2 = this.f10467b.getChildAt(this.f);
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
        int left = this.f10467b.getChildAt(i).getLeft() + i2;
        if (i > 0 || i2 > 0) {
            left = this.V ? (left - (getWidth() / 2)) + (this.f10467b.getChildAt(i).getWidth() / 2) : left - this.u;
        }
        if (left != this.G) {
            if (!this.t) {
                this.G = left;
                scrollTo(left, 0);
            } else if (left < this.G) {
                this.G = left;
                this.H = this.G + getWidth();
                scrollTo(left, 0);
            } else {
                int right = (this.f10467b.getChildAt(i).getRight() - getWidth()) + i2;
                if (i > 0 || i2 > 0) {
                    right += this.u;
                }
                if (getWidth() + right > this.H) {
                    this.H = getWidth() + right;
                    this.G = right;
                    scrollTo(right, 0);
                }
            }
        }
    }

    public boolean b() {
        return this.S;
    }

    public void c() {
        this.f10467b.removeAllViews();
        this.l = this.c.getAdapter().getCount();
        for (int i = 0; i < this.l; i++) {
            if (this.c.getAdapter() instanceof c.a) {
                a(i, ((c.a) this.c.getAdapter()).b(i));
            } else {
                a(i, new c(Integer.toString(i), this.c.getAdapter().getPageTitle(i)));
            }
        }
        if (this.l > 0 && this.M != null) {
            a(this.l, this.M);
        }
        d();
        this.K = false;
        a(this.c.getCurrentItem());
    }

    public int getTabPadding() {
        return this.z;
    }

    public LinearLayout getTabsContainer() {
        return this.f10467b;
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        d();
        this.K = false;
        post(new Runnable() { // from class: com.kwad.sdk.lib.widget.viewpager.tabstrip.PagerSlidingTabStrip.1
            @Override // java.lang.Runnable
            public void run() {
                PagerSlidingTabStrip.this.a(PagerSlidingTabStrip.this.f, 0);
            }
        });
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        RectF rectF;
        super.onDraw(canvas);
        if (isInEditMode() || this.l == 0) {
            return;
        }
        View childAt = this.f10467b.getChildAt(this.d);
        float left = childAt.getLeft();
        float right = childAt.getRight();
        if (this.e > 0.0f && this.d < this.l - 1) {
            View childAt2 = this.f10467b.getChildAt(this.d + 1);
            left = (left * (1.0f - this.e)) + (childAt2.getLeft() * this.e);
            right = (right * (1.0f - this.e)) + (childAt2.getRight() * this.e);
        }
        int height = getHeight();
        this.m.setColor(this.o);
        if (this.O != 0) {
            this.w = (int) (((right - left) - this.O) / 2.0f);
            float f = ((double) this.e) < 0.5d ? (this.w * this.e) / 3.0f : (this.w * (1.0f - this.e)) / 3.0f;
            rectF = new RectF((left + this.w) - f, ((height - this.v) - 1) - this.U, (right - this.w) + f, (height - 1) - this.U);
        } else {
            if (this.P) {
                a(childAt);
            }
            rectF = new RectF(left + this.w, (height - this.v) - this.U, right - this.w, height - this.U);
        }
        if (b()) {
            if (Build.VERSION.SDK_INT > 19) {
                canvas.drawRoundRect(rectF, this.N, this.N, this.m);
            } else {
                canvas.drawRect(rectF, this.m);
            }
        }
        this.m.setColor(this.p);
        canvas.drawRect(0.0f, height - this.x, this.f10467b.getWidth(), height, this.m);
        this.n.setColor(this.q);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.l - 1) {
                return;
            }
            View childAt3 = this.f10467b.getChildAt(i2);
            canvas.drawLine(childAt3.getRight(), this.y, childAt3.getRight(), height - this.y, this.n);
            i = i2 + 1;
        }
    }

    @Override // android.widget.HorizontalScrollView, android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
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
            i3 += this.f10467b.getChildAt(i4).getMeasuredWidth();
        }
        if (i3 > 0 && measuredWidth > 0) {
            this.u = this.f10467b.getChildAt(0).getMeasuredWidth();
            if (i3 <= measuredWidth) {
                for (int i5 = 0; i5 < this.l; i5++) {
                    View childAt = this.f10467b.getChildAt(i5);
                    if (i5 == 0) {
                        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.i.width, this.i.height);
                        layoutParams.gravity = this.i.gravity;
                        layoutParams.weight = this.i.weight;
                        layoutParams.rightMargin = this.i.rightMargin;
                        layoutParams.bottomMargin = this.i.bottomMargin;
                        layoutParams.topMargin = this.i.topMargin;
                        layoutParams.leftMargin = 0;
                        childAt.setLayoutParams(layoutParams);
                    } else {
                        childAt.setLayoutParams(this.i);
                    }
                    childAt.setPadding(this.z, 0, this.z, 0);
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
        this.d = bVar.f10470a;
        requestLayout();
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public Parcelable onSaveInstanceState() {
        b bVar = new b(super.onSaveInstanceState());
        bVar.f10470a = this.d;
        return bVar;
    }

    @Override // android.view.View
    protected void onScrollChanged(int i, int i2, int i3, int i4) {
        super.onScrollChanged(i, i2, i3, i4);
        if (this.k != null) {
            this.k.a();
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
        this.f10466a = onPageChangeListener;
    }

    public void setScrollListener(d dVar) {
        this.k = dVar;
    }

    public void setScrollSelectedTabToCenter(boolean z) {
        this.V = z;
    }

    public void setTabGravity(int i) {
        this.L = i;
        this.f10467b.setGravity(i);
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
        this.c = viewPager;
        if (viewPager.getAdapter() == null) {
            throw new IllegalStateException("ViewPager does not have adapter instance.");
        }
        viewPager.setOnPageChangeListener(this.j);
        c();
    }
}
