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
import androidx.core.view.InputDeviceCompat;
import androidx.viewpager.widget.ViewPager;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.R;
import com.kwad.sdk.lib.widget.a;
import com.kwad.sdk.utils.ao;
import java.util.Arrays;
import java.util.Locale;
/* loaded from: classes7.dex */
public class PagerSlidingTabStrip extends HorizontalScrollView {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: h  reason: collision with root package name */
    public static final int[] f38601h;
    public transient /* synthetic */ FieldHolder $fh;
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
    public ViewPager.OnPageChangeListener f38602a;

    /* renamed from: b  reason: collision with root package name */
    public LinearLayout f38603b;

    /* renamed from: c  reason: collision with root package name */
    public ViewPager f38604c;

    /* renamed from: d  reason: collision with root package name */
    public int f38605d;

    /* renamed from: e  reason: collision with root package name */
    public float f38606e;

    /* renamed from: f  reason: collision with root package name */
    public int f38607f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f38608g;

    /* renamed from: i  reason: collision with root package name */
    public LinearLayout.LayoutParams f38609i;
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
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PagerSlidingTabStrip f38611a;

        public a(PagerSlidingTabStrip pagerSlidingTabStrip) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pagerSlidingTabStrip};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f38611a = pagerSlidingTabStrip;
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
                if (i2 == 0) {
                    PagerSlidingTabStrip pagerSlidingTabStrip = this.f38611a;
                    pagerSlidingTabStrip.a(pagerSlidingTabStrip.f38604c.getCurrentItem(), 0);
                }
                ViewPager.OnPageChangeListener onPageChangeListener = this.f38611a.f38602a;
                if (onPageChangeListener != null) {
                    onPageChangeListener.onPageScrollStateChanged(i2);
                }
                if (i2 == 1) {
                    PagerSlidingTabStrip pagerSlidingTabStrip2 = this.f38611a;
                    pagerSlidingTabStrip2.Q = pagerSlidingTabStrip2.f38604c.getCurrentItem();
                }
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i2, float f2, int i3) {
            PagerSlidingTabStrip pagerSlidingTabStrip;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i2), Float.valueOf(f2), Integer.valueOf(i3)}) == null) {
                if (i2 >= this.f38611a.f38603b.getChildCount() - (this.f38611a.M != null ? 1 : 0)) {
                    return;
                }
                PagerSlidingTabStrip pagerSlidingTabStrip2 = this.f38611a;
                pagerSlidingTabStrip2.f38605d = i2;
                pagerSlidingTabStrip2.f38606e = f2;
                if (pagerSlidingTabStrip2.V) {
                    float width = this.f38611a.f38603b.getChildAt(i2).getWidth();
                    if (i2 < this.f38611a.f38603b.getChildCount() - 1) {
                        int i4 = i2 + 1;
                        width = (this.f38611a.f38603b.getChildAt(i4).getLeft() + (this.f38611a.f38603b.getChildAt(i4).getWidth() / 2)) - (this.f38611a.f38603b.getChildAt(i2).getLeft() + (this.f38611a.f38603b.getChildAt(i2).getWidth() / 2));
                    }
                    this.f38611a.a(i2, (int) (width * f2));
                } else {
                    this.f38611a.a(i2, (int) (pagerSlidingTabStrip.f38603b.getChildAt(i2).getWidth() * f2));
                }
                this.f38611a.invalidate();
                ViewPager.OnPageChangeListener onPageChangeListener = this.f38611a.f38602a;
                if (onPageChangeListener != null) {
                    onPageChangeListener.onPageScrolled(i2, f2, i3);
                }
                if (this.f38611a.Q == i2) {
                    this.f38611a.f38608g = true;
                } else {
                    this.f38611a.f38608g = false;
                }
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
                this.f38611a.a(i2);
                ViewPager.OnPageChangeListener onPageChangeListener = this.f38611a.f38602a;
                if (onPageChangeListener != null) {
                    onPageChangeListener.onPageSelected(i2);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class b extends View.BaseSavedState {
        public static /* synthetic */ Interceptable $ic;
        public static final Parcelable.Creator<b> CREATOR;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public int f38612a;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1103620026, "Lcom/kwad/sdk/lib/widget/viewpager/tabstrip/PagerSlidingTabStrip$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1103620026, "Lcom/kwad/sdk/lib/widget/viewpager/tabstrip/PagerSlidingTabStrip$b;");
                    return;
                }
            }
            CREATOR = new Parcelable.Creator<b>() { // from class: com.kwad.sdk.lib.widget.viewpager.tabstrip.PagerSlidingTabStrip.b.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                        }
                    }
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // android.os.Parcelable.Creator
                /* renamed from: a */
                public b createFromParcel(Parcel parcel) {
                    InterceptResult invokeL;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, parcel)) == null) ? new b(parcel) : (b) invokeL.objValue;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // android.os.Parcelable.Creator
                /* renamed from: a */
                public b[] newArray(int i2) {
                    InterceptResult invokeI;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeI = interceptable2.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) ? new b[i2] : (b[]) invokeI.objValue;
                }
            };
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(Parcel parcel) {
            super(parcel);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {parcel};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((Parcel) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.f38612a = parcel.readInt();
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(Parcelable parcelable) {
            super(parcelable);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {parcelable};
                interceptable.invokeUnInit(65538, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((Parcelable) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65538, newInitContext);
                    return;
                }
            }
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, parcel, i2) == null) {
                super.writeToParcel(parcel, i2);
                parcel.writeInt(this.f38612a);
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public View.OnClickListener f38613a;

        /* renamed from: b  reason: collision with root package name */
        public CharSequence f38614b;

        /* renamed from: c  reason: collision with root package name */
        public View f38615c;

        /* renamed from: d  reason: collision with root package name */
        public View f38616d;

        /* renamed from: e  reason: collision with root package name */
        public int f38617e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f38618f;

        /* renamed from: g  reason: collision with root package name */
        public boolean f38619g;

        /* renamed from: h  reason: collision with root package name */
        public String f38620h;

        /* loaded from: classes7.dex */
        public interface a {
            c b(int i2);
        }

        public c(String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f38620h = str;
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public c(String str, CharSequence charSequence) {
            this(str);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, charSequence};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    this((String) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.f38614b = charSequence;
        }

        public View a(Context context, int i2, ViewPager viewPager) {
            InterceptResult invokeLIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048576, this, context, i2, viewPager)) == null) {
                this.f38617e = i2;
                View view = this.f38615c;
                if (view != null) {
                    this.f38616d = view;
                } else {
                    TextView textView = new TextView(context);
                    this.f38616d = textView;
                    TextView textView2 = textView;
                    textView2.setText(this.f38614b);
                    textView2.setFocusable(true);
                    textView2.setGravity(17);
                    textView2.setSingleLine();
                }
                this.f38616d.setOnClickListener(new View.OnClickListener(this, viewPager, i2) { // from class: com.kwad.sdk.lib.widget.viewpager.tabstrip.PagerSlidingTabStrip.c.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ ViewPager f38621a;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ int f38622b;

                    /* renamed from: c  reason: collision with root package name */
                    public final /* synthetic */ c f38623c;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, viewPager, Integer.valueOf(i2)};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i3 = newInitContext.flag;
                            if ((i3 & 1) != 0) {
                                int i4 = i3 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f38623c = this;
                        this.f38621a = viewPager;
                        this.f38622b = i2;
                    }

                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                            View.OnClickListener onClickListener = this.f38623c.f38613a;
                            if (onClickListener != null) {
                                onClickListener.onClick(view2);
                                if (this.f38623c.f38619g) {
                                    return;
                                }
                            }
                            if (this.f38623c.f38618f) {
                                return;
                            }
                            this.f38621a.setCurrentItem(this.f38622b);
                        }
                    }
                });
                return this.f38616d;
            }
            return (View) invokeLIL.objValue;
        }

        public String a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f38620h : (String) invokeV.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public interface d {
        void a();
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1214492680, "Lcom/kwad/sdk/lib/widget/viewpager/tabstrip/PagerSlidingTabStrip;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1214492680, "Lcom/kwad/sdk/lib/widget/viewpager/tabstrip/PagerSlidingTabStrip;");
                return;
            }
        }
        f38601h = new int[]{16842901, 16842904, 16842927};
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public PagerSlidingTabStrip(Context context) {
        this(context, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public PagerSlidingTabStrip(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @SuppressLint({"ResourceType"})
    public PagerSlidingTabStrip(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r3;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65539, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        this.j = new a(this);
        this.f38605d = 0;
        this.f38606e = 0.0f;
        this.f38607f = -1;
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
        this.f38603b = linearLayout;
        linearLayout.setOrientation(0);
        this.f38603b.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.f38603b.setGravity(this.L);
        this.f38603b.setClipChildren(false);
        this.f38603b.setClipToPadding(false);
        addView(this.f38603b);
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        this.u = (int) TypedValue.applyDimension(1, this.u, displayMetrics);
        this.v = (int) TypedValue.applyDimension(1, this.v, displayMetrics);
        this.x = (int) TypedValue.applyDimension(1, this.x, displayMetrics);
        this.y = (int) TypedValue.applyDimension(1, this.y, displayMetrics);
        this.z = (int) TypedValue.applyDimension(1, this.z, displayMetrics);
        this.A = (int) TypedValue.applyDimension(1, this.A, displayMetrics);
        this.B = (int) TypedValue.applyDimension(2, this.B, displayMetrics);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f38601h);
        this.B = obtainStyledAttributes.getDimensionPixelSize(0, this.B);
        this.C = obtainStyledAttributes.getColorStateList(1);
        this.L = obtainStyledAttributes.getInt(2, this.L);
        obtainStyledAttributes.recycle();
        int i5 = R.attr.ksad_pstsIndicatorColor;
        int i6 = R.attr.ksad_pstsUnderlineColor;
        int i7 = R.attr.ksad_pstsDividerColor;
        int i8 = R.attr.ksad_pstsIndicatorHeight;
        int i9 = R.attr.ksad_pstsUnderlineHeight;
        int i10 = R.attr.ksad_pstsDividerPadding;
        int i11 = R.attr.ksad_pstsTabPaddingLeftRight;
        int i12 = R.attr.ksad_pstsTabBackground;
        int i13 = R.attr.ksad_pstsShouldExpand;
        int i14 = R.attr.ksad_pstsScrollOffset;
        int i15 = R.attr.ksad_pstsTextAllCaps;
        int i16 = R.attr.ksad_pstsIndicatorPadding;
        int i17 = R.attr.ksad_pstsShouldOverScroll;
        int i18 = R.attr.ksad_pstsIndicatorWidth;
        int i19 = R.attr.ksad_pstsIndicatorWidthFitText;
        int i20 = R.attr.ksad_pstsIndicatorMarginBottom;
        int i21 = R.attr.ksad_pstsAverageWidth;
        int i22 = R.attr.ksad_pstsScrollSelectedTabToCenter;
        int i23 = R.attr.ksad_pstsIndicatorCorner;
        int[] iArr = {i5, i6, i7, i8, i9, i10, i11, i12, i13, i14, i15, i16, i17, i18, i19, i20, i21, i22, i23};
        Arrays.sort(iArr);
        TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, iArr);
        this.o = obtainStyledAttributes.getColor(Arrays.binarySearch(iArr, i5), this.o);
        this.p = obtainStyledAttributes.getColor(Arrays.binarySearch(iArr, i6), this.p);
        this.q = obtainStyledAttributes.getColor(Arrays.binarySearch(iArr, i7), this.q);
        this.v = obtainStyledAttributes.getDimensionPixelSize(Arrays.binarySearch(iArr, i8), this.v);
        this.x = obtainStyledAttributes.getDimensionPixelSize(Arrays.binarySearch(iArr, i9), this.x);
        this.y = obtainStyledAttributes.getDimensionPixelSize(Arrays.binarySearch(iArr, i10), this.y);
        this.z = obtainStyledAttributes.getDimensionPixelSize(Arrays.binarySearch(iArr, i11), this.z);
        this.I = obtainStyledAttributes.getResourceId(Arrays.binarySearch(iArr, i12), this.I);
        this.r = obtainStyledAttributes.getBoolean(Arrays.binarySearch(iArr, i13), this.r);
        this.u = obtainStyledAttributes.getDimensionPixelSize(Arrays.binarySearch(iArr, i14), this.u);
        this.s = obtainStyledAttributes.getBoolean(Arrays.binarySearch(iArr, i15), this.s);
        this.w = obtainStyledAttributes.getDimensionPixelSize(Arrays.binarySearch(iArr, i16), 0);
        this.t = obtainStyledAttributes.getBoolean(Arrays.binarySearch(iArr, i17), this.t);
        this.O = obtainStyledAttributes.getDimensionPixelSize(Arrays.binarySearch(iArr, i18), 0);
        this.P = obtainStyledAttributes.getBoolean(Arrays.binarySearch(iArr, i19), false);
        this.U = obtainStyledAttributes.getDimensionPixelSize(Arrays.binarySearch(iArr, i20), 0);
        this.T = obtainStyledAttributes.getBoolean(Arrays.binarySearch(iArr, i21), true);
        this.V = obtainStyledAttributes.getBoolean(Arrays.binarySearch(iArr, i22), false);
        this.N = obtainStyledAttributes.getDimensionPixelSize(Arrays.binarySearch(iArr, i23), ao.a(getContext(), 15.0f));
        obtainStyledAttributes2.recycle();
        Paint paint = new Paint();
        this.m = paint;
        paint.setAntiAlias(true);
        this.m.setStyle(Paint.Style.FILL);
        Paint paint2 = new Paint();
        this.n = paint2;
        paint2.setAntiAlias(true);
        this.n.setStrokeWidth(this.A);
        this.f38609i = this.T ? new LinearLayout.LayoutParams(0, -1, 1.0f) : new LinearLayout.LayoutParams(-2, -1);
        if (this.J == null) {
            this.J = getResources().getConfiguration().locale;
        }
    }

    private float a(View view, CharSequence charSequence, TextPaint textPaint) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65540, this, view, charSequence, textPaint)) == null) {
            if (this.R == null) {
                this.R = new com.kwad.sdk.lib.widget.a();
            }
            return (view.getWidth() - this.R.a(charSequence, textPaint, this.B)) / 2.0f;
        }
        return invokeLLL.floatValue;
    }

    private void a(int i2, c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(65543, this, i2, cVar) == null) {
            this.f38603b.addView(cVar.a(getContext(), i2, this.f38604c), i2);
        }
    }

    private void a(View view) {
        float f2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65544, this, view) == null) {
            int i2 = this.f38605d;
            View childAt = i2 < this.l ? this.f38603b.getChildAt(i2 + 1) : null;
            if (childAt == null) {
                childAt = view;
            }
            float f3 = 0.0f;
            if (view instanceof TextView) {
                TextView textView = (TextView) view;
                TextView textView2 = (TextView) childAt;
                f3 = a(textView, textView.getText(), textView.getPaint());
                f2 = a(textView2, textView2.getText(), textView2.getPaint());
            } else if (view instanceof a.InterfaceC0472a) {
                a.InterfaceC0472a interfaceC0472a = (a.InterfaceC0472a) view;
                a.InterfaceC0472a interfaceC0472a2 = (a.InterfaceC0472a) childAt;
                f3 = a((View) interfaceC0472a, interfaceC0472a.a(), interfaceC0472a.b());
                f2 = a((View) interfaceC0472a2, interfaceC0472a2.a(), interfaceC0472a2.b());
            } else {
                f2 = 0.0f;
            }
            this.w = (int) (this.f38608g ? f3 + ((f2 - f3) * this.f38606e) : f3 - ((f3 - f2) * this.f38606e));
        }
    }

    private void d() {
        TextView textView;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65547, this) == null) {
            this.f38604c.getCurrentItem();
            for (int i3 = 0; i3 < this.f38603b.getChildCount(); i3++) {
                View childAt = this.f38603b.getChildAt(i3);
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
    }

    public ViewGroup.LayoutParams a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? new LinearLayout.LayoutParams(-2, -1) : (ViewGroup.LayoutParams) invokeV.objValue;
    }

    public void a(int i2) {
        int i3;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) || (i3 = this.f38607f) == i2 || i2 >= this.l || i2 < 0) {
            return;
        }
        View childAt = this.f38603b.getChildAt(i3);
        if (childAt != null) {
            childAt.setSelected(false);
        }
        this.f38607f = i2;
        View childAt2 = this.f38603b.getChildAt(i2);
        if (childAt2 != null) {
            childAt2.setSelected(true);
        }
        d();
    }

    public void a(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeII(Constants.METHOD_SEND_USER_MSG, this, i2, i3) == null) || this.l == 0) {
            return;
        }
        int left = this.f38603b.getChildAt(i2).getLeft() + i3;
        if (i2 > 0 || i3 > 0) {
            left = this.V ? (left - (getWidth() / 2)) + (this.f38603b.getChildAt(i2).getWidth() / 2) : left - this.u;
        }
        int i4 = this.G;
        if (left != i4) {
            if (this.t) {
                if (left < i4) {
                    this.G = left;
                    this.H = getWidth() + left;
                    scrollTo(left, 0);
                }
                left = (this.f38603b.getChildAt(i2).getRight() - getWidth()) + i3;
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
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.S : invokeV.booleanValue;
    }

    public void c() {
        int i2;
        c cVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.f38603b.removeAllViews();
            this.l = this.f38604c.getAdapter().getCount();
            int i3 = 0;
            while (true) {
                i2 = this.l;
                if (i3 >= i2) {
                    break;
                }
                a(i3, this.f38604c.getAdapter() instanceof c.a ? ((c.a) this.f38604c.getAdapter()).b(i3) : new c(Integer.toString(i3), this.f38604c.getAdapter().getPageTitle(i3)));
                i3++;
            }
            if (i2 > 0 && (cVar = this.M) != null) {
                a(i2, cVar);
            }
            d();
            this.K = false;
            a(this.f38604c.getCurrentItem());
        }
    }

    public int getTabPadding() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.z : invokeV.intValue;
    }

    public LinearLayout getTabsContainer() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f38603b : (LinearLayout) invokeV.objValue;
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, configuration) == null) {
            d();
            this.K = false;
            post(new Runnable(this) { // from class: com.kwad.sdk.lib.widget.viewpager.tabstrip.PagerSlidingTabStrip.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ PagerSlidingTabStrip f38610a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f38610a = this;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        PagerSlidingTabStrip pagerSlidingTabStrip = this.f38610a;
                        pagerSlidingTabStrip.a(pagerSlidingTabStrip.f38607f, 0);
                    }
                }
            });
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        RectF rectF;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, canvas) == null) {
            super.onDraw(canvas);
            if (isInEditMode() || this.l == 0) {
                return;
            }
            View childAt = this.f38603b.getChildAt(this.f38605d);
            float left = childAt.getLeft();
            float right = childAt.getRight();
            if (this.f38606e > 0.0f && (i2 = this.f38605d) < this.l - 1) {
                View childAt2 = this.f38603b.getChildAt(i2 + 1);
                float f2 = this.f38606e;
                left = (childAt2.getLeft() * f2) + ((1.0f - f2) * left);
                right = (childAt2.getRight() * f2) + ((1.0f - f2) * right);
            }
            int height = getHeight();
            this.m.setColor(this.o);
            int i3 = this.O;
            if (i3 != 0) {
                int i4 = (int) (((right - left) - i3) / 2.0f);
                this.w = i4;
                float f3 = this.f38606e;
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
            canvas.drawRect(0.0f, height - this.x, this.f38603b.getWidth(), height, this.m);
            this.n.setColor(this.q);
            for (int i10 = 0; i10 < this.l - 1; i10++) {
                View childAt3 = this.f38603b.getChildAt(i10);
                canvas.drawLine(childAt3.getRight(), this.y, childAt3.getRight(), height - this.y, this.n);
            }
        }
    }

    @Override // android.widget.HorizontalScrollView, android.widget.FrameLayout, android.view.View
    public void onMeasure(int i2, int i3) {
        LinearLayout.LayoutParams layoutParams;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048585, this, i2, i3) == null) {
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
                i4 += this.f38603b.getChildAt(i5).getMeasuredWidth();
            }
            if (i4 > 0 && measuredWidth > 0) {
                this.u = this.f38603b.getChildAt(0).getMeasuredWidth();
                if (i4 <= measuredWidth) {
                    for (int i6 = 0; i6 < this.l; i6++) {
                        View childAt = this.f38603b.getChildAt(i6);
                        if (i6 == 0) {
                            LinearLayout.LayoutParams layoutParams2 = this.f38609i;
                            layoutParams = new LinearLayout.LayoutParams(layoutParams2.width, layoutParams2.height);
                            LinearLayout.LayoutParams layoutParams3 = this.f38609i;
                            layoutParams.gravity = layoutParams3.gravity;
                            layoutParams.weight = layoutParams3.weight;
                            layoutParams.rightMargin = layoutParams3.rightMargin;
                            layoutParams.bottomMargin = layoutParams3.bottomMargin;
                            layoutParams.topMargin = layoutParams3.topMargin;
                            layoutParams.leftMargin = 0;
                        } else {
                            layoutParams = this.f38609i;
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
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, parcelable) == null) {
            b bVar = (b) parcelable;
            super.onRestoreInstanceState(bVar.getSuperState());
            this.f38605d = bVar.f38612a;
            requestLayout();
        }
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public Parcelable onSaveInstanceState() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            b bVar = new b(super.onSaveInstanceState());
            bVar.f38612a = this.f38605d;
            return bVar;
        }
        return (Parcelable) invokeV.objValue;
    }

    @Override // android.view.View
    public void onScrollChanged(int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048588, this, i2, i3, i4, i5) == null) {
            super.onScrollChanged(i2, i3, i4, i5);
            d dVar = this.k;
            if (dVar != null) {
                dVar.a();
            }
        }
    }

    public void setClickOnlyTabStrip(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, cVar) == null) {
            this.M = cVar;
        }
    }

    public void setIndicatorColor(@ColorRes int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i2) == null) {
            this.o = ResourcesCompat.getColor(getResources(), i2, null);
        }
    }

    public void setIndicatorColorInt(@ColorInt int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048591, this, i2) == null) {
            this.o = i2;
        }
    }

    public void setIndicatorPadding(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048592, this, i2) == null) {
            this.w = i2;
        }
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, onPageChangeListener) == null) {
            this.f38602a = onPageChangeListener;
        }
    }

    public void setScrollListener(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, dVar) == null) {
            this.k = dVar;
        }
    }

    public void setScrollSelectedTabToCenter(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048595, this, z) == null) {
            this.V = z;
        }
    }

    public void setTabGravity(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048596, this, i2) == null) {
            this.L = i2;
            this.f38603b.setGravity(i2);
        }
    }

    public void setTabLayoutParams(LinearLayout.LayoutParams layoutParams) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, layoutParams) == null) {
            this.f38609i = layoutParams;
        }
    }

    public void setTabPadding(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048598, this, i2) == null) || this.z == i2) {
            return;
        }
        this.z = i2;
        requestLayout();
    }

    public void setTabTypefaceStyle(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048599, this, i2) == null) {
            this.E = i2;
            this.F = i2;
            d();
        }
    }

    public void setTextColor(@ColorRes int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048600, this, i2) == null) {
            this.C = ResourcesCompat.getColorStateList(getResources(), i2, null);
            d();
        }
    }

    public void setViewPager(ViewPager viewPager) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, viewPager) == null) {
            this.f38604c = viewPager;
            if (viewPager.getAdapter() == null) {
                throw new IllegalStateException("ViewPager does not have adapter instance.");
            }
            viewPager.setOnPageChangeListener(this.j);
            c();
        }
    }
}
