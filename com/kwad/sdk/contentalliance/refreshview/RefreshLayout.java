package com.kwad.sdk.contentalliance.refreshview;

import android.animation.ValueAnimator;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.Transformation;
import android.widget.AbsListView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import androidx.core.view.MotionEventCompat;
import androidx.core.view.NestedScrollingChild;
import androidx.core.view.NestedScrollingChildHelper;
import androidx.core.view.NestedScrollingParent;
import androidx.core.view.NestedScrollingParentHelper;
import androidx.core.view.ViewCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes7.dex */
public abstract class RefreshLayout extends ViewGroup implements NestedScrollingChild, NestedScrollingParent {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public float A;
    public float B;
    public float C;
    public float D;
    public float E;
    public float F;
    public View G;
    public boolean H;
    public boolean I;
    public boolean J;
    public RefreshStyle K;
    public View L;
    public ValueAnimator M;
    public com.kwad.sdk.contentalliance.refreshview.b N;
    public b O;
    public final Animation.AnimationListener P;
    public d Q;
    public c R;
    public List<c> S;
    public Interpolator T;
    public Interpolator U;
    public boolean V;
    public boolean W;

    /* renamed from: a  reason: collision with root package name */
    public int f35416a;
    public final Animation aa;
    public final Animation ab;
    public boolean ac;

    /* renamed from: b  reason: collision with root package name */
    public float f35417b;

    /* renamed from: c  reason: collision with root package name */
    public float f35418c;

    /* renamed from: d  reason: collision with root package name */
    public View f35419d;

    /* renamed from: e  reason: collision with root package name */
    public com.kwad.sdk.contentalliance.refreshview.d f35420e;

    /* renamed from: f  reason: collision with root package name */
    public final Animation.AnimationListener f35421f;

    /* renamed from: g  reason: collision with root package name */
    public final String f35422g;

    /* renamed from: h  reason: collision with root package name */
    public final int[] f35423h;

    /* renamed from: i  reason: collision with root package name */
    public final int[] f35424i;
    public final NestedScrollingChildHelper j;
    public final NestedScrollingParentHelper k;
    public float l;
    public boolean m;
    public boolean n;
    public boolean o;
    public boolean p;
    public boolean q;
    public boolean r;
    public boolean s;
    public int t;
    public int u;
    public int v;
    public int w;
    public int x;
    public int y;
    public float z;

    /* renamed from: com.kwad.sdk.contentalliance.refreshview.RefreshLayout$6  reason: invalid class name */
    /* loaded from: classes7.dex */
    public static /* synthetic */ class AnonymousClass6 {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f35430a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(487301261, "Lcom/kwad/sdk/contentalliance/refreshview/RefreshLayout$6;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(487301261, "Lcom/kwad/sdk/contentalliance/refreshview/RefreshLayout$6;");
                    return;
                }
            }
            int[] iArr = new int[RefreshStyle.values().length];
            f35430a = iArr;
            try {
                iArr[RefreshStyle.FLOAT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f35430a[RefreshStyle.PINNED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes7.dex */
    public static final class RefreshStyle {
        public static final /* synthetic */ RefreshStyle[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final RefreshStyle FLOAT;
        public static final RefreshStyle NORMAL;
        public static final RefreshStyle PINNED;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-763203459, "Lcom/kwad/sdk/contentalliance/refreshview/RefreshLayout$RefreshStyle;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-763203459, "Lcom/kwad/sdk/contentalliance/refreshview/RefreshLayout$RefreshStyle;");
                    return;
                }
            }
            NORMAL = new RefreshStyle("NORMAL", 0);
            PINNED = new RefreshStyle("PINNED", 1);
            RefreshStyle refreshStyle = new RefreshStyle("FLOAT", 2);
            FLOAT = refreshStyle;
            $VALUES = new RefreshStyle[]{NORMAL, PINNED, refreshStyle};
        }

        public RefreshStyle(String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public static RefreshStyle valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (RefreshStyle) Enum.valueOf(RefreshStyle.class, str) : (RefreshStyle) invokeL.objValue;
        }

        public static RefreshStyle[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (RefreshStyle[]) $VALUES.clone() : (RefreshStyle[]) invokeV.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public static class a extends ViewGroup.MarginLayoutParams {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(int i2, int i3) {
            super(i2, i3);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i2), Integer.valueOf(i3)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Integer) objArr2[0]).intValue(), ((Integer) objArr2[1]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context, attributeSet};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {layoutParams};
                interceptable.invokeUnInit(65538, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((ViewGroup.LayoutParams) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65538, newInitContext);
                    return;
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public interface b {
        void a();
    }

    /* loaded from: classes7.dex */
    public interface c {
        void a();

        void a(float f2, float f3, boolean z);

        void b();

        void c();
    }

    /* loaded from: classes7.dex */
    public interface d {
        boolean a(float f2, boolean z);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public RefreshLayout(Context context) {
        this(context, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RefreshLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f35422g = "RefreshLayout";
        this.f35423h = new int[2];
        this.f35424i = new int[2];
        this.t = -1;
        this.u = -1;
        this.v = 300;
        this.w = 500;
        this.H = false;
        this.I = false;
        this.J = false;
        this.K = RefreshStyle.NORMAL;
        this.M = null;
        this.P = new Animation.AnimationListener(this) { // from class: com.kwad.sdk.contentalliance.refreshview.RefreshLayout.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ RefreshLayout f35425a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr3 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.f35425a = this;
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, animation) == null) {
                    if (this.f35425a.r && this.f35425a.O != null) {
                        this.f35425a.O.a();
                    }
                    this.f35425a.n = false;
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animation) == null) {
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, animation) == null) {
                    this.f35425a.n = true;
                    this.f35425a.f35420e.b();
                }
            }
        };
        this.f35421f = new Animation.AnimationListener(this) { // from class: com.kwad.sdk.contentalliance.refreshview.RefreshLayout.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ RefreshLayout f35426a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr3 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.f35426a = this;
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, animation) == null) {
                    this.f35426a.a();
                    if (this.f35426a.R != null) {
                        this.f35426a.R.c();
                    }
                    if (this.f35426a.S != null) {
                        for (int i4 = 0; i4 < this.f35426a.S.size(); i4++) {
                            ((c) this.f35426a.S.get(i4)).c();
                        }
                    }
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animation) == null) {
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, animation) == null) {
                    this.f35426a.n = true;
                }
            }
        };
        this.T = new DecelerateInterpolator(2.0f);
        this.U = new DecelerateInterpolator(2.0f);
        this.W = true;
        this.aa = new Animation(this) { // from class: com.kwad.sdk.contentalliance.refreshview.RefreshLayout.3
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ RefreshLayout f35427a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr3 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.f35427a = this;
            }

            @Override // android.view.animation.Animation
            public void applyTransformation(float f2, Transformation transformation) {
                float f3;
                RefreshLayout refreshLayout;
                View view;
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeCommon(1048576, this, new Object[]{Float.valueOf(f2), transformation}) == null) || this.f35427a.L == null) {
                    return;
                }
                if (AnonymousClass6.f35430a[this.f35427a.K.ordinal()] != 1) {
                    refreshLayout = this.f35427a;
                    f3 = refreshLayout.f35418c;
                    view = refreshLayout.L;
                } else {
                    RefreshLayout refreshLayout2 = this.f35427a;
                    f3 = refreshLayout2.f35418c + refreshLayout2.D;
                    refreshLayout = this.f35427a;
                    view = refreshLayout.f35419d;
                }
                refreshLayout.a(f3, view.getTop(), f2);
            }
        };
        this.ab = new Animation(this) { // from class: com.kwad.sdk.contentalliance.refreshview.RefreshLayout.4
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ RefreshLayout f35428a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr3 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.f35428a = this;
            }

            @Override // android.view.animation.Animation
            public void applyTransformation(float f2, Transformation transformation) {
                RefreshLayout refreshLayout;
                float f3;
                View view;
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeCommon(1048576, this, new Object[]{Float.valueOf(f2), transformation}) == null) || this.f35428a.L == null) {
                    return;
                }
                if (AnonymousClass6.f35430a[this.f35428a.K.ordinal()] != 1) {
                    refreshLayout = this.f35428a;
                    f3 = 0.0f;
                    view = refreshLayout.L;
                } else {
                    refreshLayout = this.f35428a;
                    f3 = refreshLayout.D;
                    view = this.f35428a.f35419d;
                }
                refreshLayout.a(f3, view.getTop(), f2);
            }
        };
        this.ac = true;
        this.y = ViewConfiguration.get(context).getScaledTouchSlop();
        float f2 = getResources().getDisplayMetrics().density;
        this.f35416a = (int) (f2 * 70.0f);
        this.f35418c = f2 * 70.0f;
        this.f35417b = 0.0f;
        com.kwad.sdk.core.d.a.b("RefreshLayout", "constructor: " + this.f35417b);
        this.D = 0.0f;
        this.E = 1.0f;
        this.k = new NestedScrollingParentHelper(this);
        this.j = new NestedScrollingChildHelper(this);
        a(attributeSet);
        g();
        setNestedScrollingEnabled(true);
        ViewCompat.setChildrenDrawingOrderEnabled(this, true);
    }

    private float a(MotionEvent motionEvent, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65538, this, motionEvent, i2)) == null) {
            int findPointerIndex = MotionEventCompat.findPointerIndex(motionEvent, i2);
            if (findPointerIndex < 0) {
                return -1.0f;
            }
            return MotionEventCompat.getY(motionEvent, findPointerIndex);
        }
        return invokeLI.floatValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, this) == null) {
            c();
            this.C = 0.0f;
            this.F = 0.0f;
            this.f35420e.a();
            this.f35419d.setVisibility(8);
            this.o = false;
            this.n = false;
            com.kwad.sdk.core.d.a.b("RefreshLayout", "reset");
        }
    }

    private void a(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(65540, this, f2) == null) {
            float f3 = f2 - this.z;
            if (this.o && (f3 > this.y || this.f35417b > 0.0f)) {
                this.q = true;
                this.B = this.z + this.y;
            } else if (this.q) {
            } else {
                int i2 = this.y;
                if (f3 > i2) {
                    this.B = this.z + i2;
                    this.q = true;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(float f2, float f3, float f4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(AdIconUtil.AD_TEXT_ID, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4)}) == null) {
            int i2 = this.x;
            setTargetOrRefreshViewOffsetY((int) (((int) (i2 + ((f2 - i2) * f4))) - f3));
        }
    }

    private void a(float f2, boolean z) {
        float f3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(AdIconUtil.BAIDU_LOGO_ID, this, new Object[]{Float.valueOf(f2), Boolean.valueOf(z)}) == null) {
            this.C = f2;
            d dVar = this.Q;
            int i2 = 0;
            if (dVar == null || !dVar.a(f2, false)) {
                if (this.o) {
                    f3 = this.f35418c;
                    if (f2 <= f3) {
                        f3 = f2;
                    }
                    if (f3 < 0.0f) {
                        f3 = 0.0f;
                    }
                } else {
                    f3 = AnonymousClass6.f35430a[this.K.ordinal()] != 1 ? this.N.a(f2, this.f35418c) : this.D + this.N.a(f2, this.f35418c);
                }
                float f4 = this.f35418c;
                if (!this.o) {
                    if (f3 > f4 && !this.p) {
                        this.p = true;
                        this.f35420e.d();
                        c cVar = this.R;
                        if (cVar != null) {
                            cVar.a();
                        }
                        if (this.S != null) {
                            while (i2 < this.S.size()) {
                                this.S.get(i2).a();
                                i2++;
                            }
                        }
                    } else if (f3 <= f4 && this.p) {
                        this.p = false;
                        this.f35420e.e();
                        c cVar2 = this.R;
                        if (cVar2 != null) {
                            cVar2.b();
                        }
                        if (this.S != null) {
                            while (i2 < this.S.size()) {
                                this.S.get(i2).b();
                                i2++;
                            }
                        }
                    }
                }
                com.kwad.sdk.core.d.a.b("RefreshLayout", f2 + " -- " + f4 + " -- " + f3 + " -- " + this.f35417b + " -- " + this.f35418c);
                a((int) (f3 - this.f35417b), z);
            }
        }
    }

    private void a(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(65543, this, i2, i3) == null) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f35419d.getLayoutParams();
            this.f35419d.measure(marginLayoutParams.width == -1 ? View.MeasureSpec.makeMeasureSpec(Math.max(0, (((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight()) - marginLayoutParams.leftMargin) - marginLayoutParams.rightMargin), 1073741824) : ViewGroup.getChildMeasureSpec(i2, getPaddingLeft() + getPaddingRight() + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin, marginLayoutParams.width), marginLayoutParams.height == -1 ? View.MeasureSpec.makeMeasureSpec(Math.max(0, (((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom()) - marginLayoutParams.topMargin) - marginLayoutParams.bottomMargin), 1073741824) : ViewGroup.getChildMeasureSpec(i3, getPaddingTop() + getPaddingBottom() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin, marginLayoutParams.height));
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0099  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00d2  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void a(int i2, boolean z) {
        View view;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65544, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)}) == null) || this.L == null) {
            return;
        }
        int i3 = AnonymousClass6.f35430a[this.K.ordinal()];
        if (i3 == 1) {
            this.f35419d.offsetTopAndBottom(i2);
            view = this.f35419d;
        } else if (i3 != 2) {
            this.L.offsetTopAndBottom(i2);
            View view2 = this.G;
            if (view2 != null) {
                view2.offsetTopAndBottom(i2);
            } else {
                float f2 = (i2 / this.E) + this.F;
                int i4 = (int) f2;
                this.F = f2 - i4;
                this.f35419d.offsetTopAndBottom(i4);
            }
            this.f35417b = this.L.getTop();
            com.kwad.sdk.core.d.a.b("RefreshLayout", "refresh style" + this.f35417b);
            com.kwad.sdk.core.d.a.b("RefreshLayout", "current offset" + this.f35417b);
            if (AnonymousClass6.f35430a[this.K.ordinal()] == 1) {
                com.kwad.sdk.contentalliance.refreshview.d dVar = this.f35420e;
                float f3 = this.f35417b;
                dVar.a(f3, f3 / this.f35418c);
                c cVar = this.R;
                if (cVar != null) {
                    float f4 = this.f35417b;
                    cVar.a(f4, f4 / this.f35418c, z);
                }
                if (this.S != null) {
                    for (int i5 = 0; i5 < this.S.size(); i5++) {
                        float f5 = this.f35417b;
                        this.S.get(i5).a(f5, f5 / this.f35418c, z);
                    }
                }
            } else {
                com.kwad.sdk.contentalliance.refreshview.d dVar2 = this.f35420e;
                float f6 = this.f35417b;
                dVar2.a(f6, (f6 - this.D) / this.f35418c);
                c cVar2 = this.R;
                if (cVar2 != null) {
                    float f7 = this.f35417b;
                    cVar2.a(f7, (f7 - this.D) / this.f35418c, z);
                }
                if (this.S != null) {
                    for (int i6 = 0; i6 < this.S.size(); i6++) {
                        float f8 = this.f35417b;
                        this.S.get(i6).a(f8, (f8 - this.D) / this.f35418c, z);
                    }
                }
            }
            if (this.W && this.f35419d.getVisibility() != 0) {
                this.f35419d.setVisibility(0);
            }
            invalidate();
        } else {
            this.L.offsetTopAndBottom(i2);
            View view3 = this.G;
            if (view3 != null) {
                view3.offsetTopAndBottom(i2);
            }
            view = this.L;
        }
        this.f35417b = view.getTop();
        com.kwad.sdk.core.d.a.b("RefreshLayout", "current offset" + this.f35417b);
        if (AnonymousClass6.f35430a[this.K.ordinal()] == 1) {
        }
        if (this.W) {
            this.f35419d.setVisibility(0);
        }
        invalidate();
    }

    private void a(MotionEvent motionEvent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65545, this, motionEvent) == null) {
            int pointerId = MotionEventCompat.getPointerId(motionEvent, MotionEventCompat.getActionIndex(motionEvent));
            this.u = pointerId;
            this.B = a(motionEvent, pointerId) - this.C;
            com.kwad.sdk.core.d.a.b("RefreshLayout", " onDown " + this.B);
        }
    }

    private void a(boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65547, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) || this.o == z) {
            return;
        }
        this.r = z2;
        this.o = z;
        if (z) {
            b((int) this.f35417b, this.P);
            return;
        }
        this.f35420e.c();
        postDelayed(new Runnable(this) { // from class: com.kwad.sdk.contentalliance.refreshview.RefreshLayout.5
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ RefreshLayout f35429a;

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
                this.f35429a = this;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    RefreshLayout refreshLayout = this.f35429a;
                    refreshLayout.a((int) refreshLayout.f35417b, refreshLayout.f35421f);
                }
            }
        }, this.f35420e.f());
    }

    private boolean a(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65548, this, view)) == null) {
            if (view == null) {
                return false;
            }
            if (Build.VERSION.SDK_INT < 14 && (view instanceof AbsListView)) {
                AbsListView absListView = (AbsListView) view;
                if (absListView.getChildCount() > 0) {
                    return absListView.getFirstVisiblePosition() > 0 || absListView.getChildAt(0).getTop() < absListView.getPaddingTop();
                }
                return false;
            }
            if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                int childCount = viewGroup.getChildCount();
                for (int i2 = 0; i2 < childCount; i2++) {
                    if (a(viewGroup.getChildAt(i2))) {
                        return true;
                    }
                }
            }
            return ViewCompat.canScrollVertically(view, -1);
        }
        return invokeL.booleanValue;
    }

    private int b(float f2) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(65551, this, f2)) == null) {
            com.kwad.sdk.core.d.a.b("RefreshLayout", "from -- refreshing " + f2);
            if (AnonymousClass6.f35430a[this.K.ordinal()] == 1) {
                f2 -= this.D;
            }
            return (int) (Math.max(0.0f, Math.min(1.0f, Math.abs(f2 - this.f35418c) / this.f35418c)) * this.w);
        }
        return invokeF.intValue;
    }

    private int b(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65552, this, i2)) == null) ? AnonymousClass6.f35430a[this.K.ordinal()] != 1 ? i2 + ((int) this.f35417b) : i2 : invokeI.intValue;
    }

    private void b(int i2, Animation.AnimationListener animationListener) {
        float f2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(65554, this, i2, animationListener) == null) {
            clearAnimation();
            if (b(i2) <= 0) {
                animationListener.onAnimationStart(null);
                animationListener.onAnimationEnd(null);
                return;
            }
            this.x = i2;
            this.aa.reset();
            this.aa.setDuration(b(f2));
            this.aa.setInterpolator(this.U);
            if (animationListener != null) {
                this.aa.setAnimationListener(animationListener);
            }
            startAnimation(this.aa);
        }
    }

    private void b(MotionEvent motionEvent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65555, this, motionEvent) == null) {
            int actionIndex = MotionEventCompat.getActionIndex(motionEvent);
            if (MotionEventCompat.getPointerId(motionEvent, actionIndex) == this.u) {
                this.u = MotionEventCompat.getPointerId(motionEvent, actionIndex == 0 ? 1 : 0);
            }
            this.B = a(motionEvent, this.u) - this.C;
            com.kwad.sdk.core.d.a.b("RefreshLayout", " onUp " + this.B);
        }
    }

    private int c(float f2) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(65556, this, f2)) == null) {
            com.kwad.sdk.core.d.a.b("RefreshLayout", "from -- start " + f2);
            if (f2 < this.D) {
                return 0;
            }
            if (AnonymousClass6.f35430a[this.K.ordinal()] == 1) {
                f2 -= this.D;
            }
            return (int) (Math.max(0.0f, Math.min(1.0f, Math.abs(f2) / this.f35418c)) * this.v);
        }
        return invokeF.intValue;
    }

    private void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65557, this) == null) {
            setTargetOrRefreshViewOffsetY((int) ((AnonymousClass6.f35430a[this.K.ordinal()] != 1 ? 0.0f : this.D) - this.f35417b));
        }
    }

    private void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65563, this) == null) {
            this.N = b();
        }
    }

    private int getTargetOrRefreshViewTop() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65564, this)) == null) {
            return (AnonymousClass6.f35430a[this.K.ordinal()] != 1 ? this.L : this.f35419d).getTop();
        }
        return invokeV.intValue;
    }

    private void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65566, this) == null) {
            this.L.measure(View.MeasureSpec.makeMeasureSpec((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), 1073741824), View.MeasureSpec.makeMeasureSpec((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), 1073741824));
        }
    }

    private void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65567, this) == null) {
            this.A = 0.0f;
            this.q = false;
            this.s = false;
            this.u = -1;
        }
    }

    private void j() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65568, this) == null) || this.o || this.n) {
            return;
        }
        d dVar = this.Q;
        if (dVar == null || !dVar.a(this.C, true)) {
            if (d()) {
                a(true, true);
                return;
            }
            this.o = false;
            a((int) this.f35417b, this.f35421f);
        }
    }

    private void k() {
        View view;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65569, this) == null) || (view = this.G) == null) {
            return;
        }
        view.measure(View.MeasureSpec.makeMeasureSpec((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), 1073741824), View.MeasureSpec.makeMeasureSpec((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), 1073741824));
    }

    private void l() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65570, this) == null) || m()) {
            return;
        }
        for (int i2 = 0; i2 < getChildCount(); i2++) {
            View childAt = getChildAt(i2);
            if (!childAt.equals(this.f35419d) && !childAt.equals(this.G)) {
                this.L = childAt;
                return;
            }
        }
    }

    private boolean m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65571, this)) == null) {
            for (int i2 = 0; i2 < getChildCount(); i2++) {
                if (this.L == getChildAt(i2)) {
                    return true;
                }
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public int a(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
            int i3 = AnonymousClass6.f35430a[this.K.ordinal()];
            return (i3 == 1 || i3 != 2) ? i2 + ((int) this.f35417b) : i2;
        }
        return invokeI.intValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.view.ViewGroup
    /* renamed from: a */
    public a generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, layoutParams)) == null) ? new a(layoutParams) : (a) invokeL.objValue;
    }

    public void a(int i2, Animation.AnimationListener animationListener) {
        float f2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(Constants.METHOD_SEND_USER_MSG, this, i2, animationListener) == null) {
            clearAnimation();
            if (c(i2) <= 0) {
                animationListener.onAnimationStart(null);
                animationListener.onAnimationEnd(null);
                return;
            }
            this.x = i2;
            this.ab.reset();
            this.ab.setDuration(c(f2));
            this.ab.setInterpolator(this.T);
            if (animationListener != null) {
                this.ab.setAnimationListener(animationListener);
            }
            startAnimation(this.ab);
        }
    }

    public void a(AttributeSet attributeSet) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, attributeSet) == null) {
            View b2 = b(attributeSet);
            this.f35419d = b2;
            b2.setVisibility(8);
            View view = this.f35419d;
            if (!(view instanceof com.kwad.sdk.contentalliance.refreshview.d)) {
                throw new ClassCastException("the refreshView must implement the interface IRefreshStatus");
            }
            this.f35420e = (com.kwad.sdk.contentalliance.refreshview.d) view;
            a c2 = c(attributeSet);
            if (c2 == null) {
                int i2 = this.f35416a;
                c2 = new a(i2, i2);
            }
            addView(this.f35419d, c2);
        }
    }

    public abstract View b(AttributeSet attributeSet);

    public abstract com.kwad.sdk.contentalliance.refreshview.b b();

    public a c(AttributeSet attributeSet) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, attributeSet)) == null) {
            return null;
        }
        return (a) invokeL.objValue;
    }

    @Override // android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, layoutParams)) == null) ? layoutParams instanceof a : invokeL.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.view.ViewGroup
    /* renamed from: d */
    public a generateLayoutParams(AttributeSet attributeSet) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, attributeSet)) == null) ? new a(getContext(), attributeSet) : (a) invokeL.objValue;
    }

    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? !this.V && ((float) getTargetOrRefreshViewOffset()) > this.f35418c : invokeV.booleanValue;
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedFling(float f2, float f3, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048586, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3), Boolean.valueOf(z)})) == null) ? this.j.dispatchNestedFling(f2, f3, z) : invokeCommon.booleanValue;
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedPreFling(float f2, float f3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048587, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3)})) == null) ? this.j.dispatchNestedPreFling(f2, f3) : invokeCommon.booleanValue;
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedPreScroll(int i2, int i3, int[] iArr, int[] iArr2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048588, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), iArr, iArr2})) == null) ? this.j.dispatchNestedPreScroll(i2, i3, iArr, iArr2) : invokeCommon.booleanValue;
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedScroll(int i2, int i3, int i4, int i5, int[] iArr) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048589, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), iArr})) == null) ? this.j.dispatchNestedScroll(i2, i3, i4, i5, iArr) : invokeCommon.booleanValue;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        int actionMasked;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, motionEvent)) == null) {
            if (this.ac && ((actionMasked = MotionEventCompat.getActionMasked(motionEvent)) == 1 || actionMasked == 3)) {
                onStopNestedScroll(this);
            }
            com.kwad.sdk.core.d.a.b("RefreshLayout", "dispatch " + this.s + " isRefreshing" + this.o);
            return super.dispatchTouchEvent(motionEvent);
        }
        return invokeL.booleanValue;
    }

    public boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.o : invokeV.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.view.ViewGroup
    /* renamed from: f */
    public a generateDefaultLayoutParams() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? new a(-2, -2) : (a) invokeV.objValue;
    }

    @Override // android.view.ViewGroup
    public int getChildDrawingOrder(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048596, this, i2, i3)) == null) {
            if (AnonymousClass6.f35430a[this.K.ordinal()] != 1) {
                int i4 = this.t;
                return i4 < 0 ? i3 : i3 == 0 ? i4 : i3 <= i4 ? i3 - 1 : i3;
            }
            int i5 = this.t;
            return i5 < 0 ? i3 : i3 == i2 - 1 ? i5 : i3 >= i5 ? i3 + 1 : i3;
        }
        return invokeII.intValue;
    }

    @Override // android.view.ViewGroup, androidx.core.view.NestedScrollingParent
    public int getNestedScrollAxes() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? this.k.getNestedScrollAxes() : invokeV.intValue;
    }

    public float getRefreshTargetOffset() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? this.f35418c : invokeV.floatValue;
    }

    @Nullable
    public View getStateView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? this.G : (View) invokeV.objValue;
    }

    public int getTargetOrRefreshViewOffset() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            if (AnonymousClass6.f35430a[this.K.ordinal()] != 1) {
                View view = this.L;
                if (view == null) {
                    return 0;
                }
                return view.getTop();
            }
            return (int) (this.f35419d.getTop() - this.D);
        }
        return invokeV.intValue;
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean hasNestedScrollingParent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? this.j.hasNestedScrollingParent() : invokeV.booleanValue;
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean isNestedScrollingEnabled() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) ? this.j.isNestedScrollingEnabled() : invokeV.booleanValue;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048603, this) == null) {
            a();
            this.O = null;
            clearAnimation();
            super.onDetachedFromWindow();
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048604, this, motionEvent)) == null) {
            l();
            View view = this.L;
            if (view == null) {
                return false;
            }
            if (!(view instanceof com.kwad.sdk.contentalliance.refreshview.c) || ((com.kwad.sdk.contentalliance.refreshview.c) view).a()) {
                if (AnonymousClass6.f35430a[this.K.ordinal()] != 1) {
                    if (!isEnabled() || (a(this.L) && !this.s)) {
                        return false;
                    }
                } else if (!isEnabled() || a(this.L) || this.o || this.m) {
                    return false;
                }
                int actionMasked = MotionEventCompat.getActionMasked(motionEvent);
                if (actionMasked != 0) {
                    if (actionMasked != 1) {
                        if (actionMasked == 2) {
                            int i2 = this.u;
                            if (i2 == -1) {
                                return false;
                            }
                            float a2 = a(motionEvent, i2);
                            if (a2 == -1.0f) {
                                return false;
                            }
                            a(a2);
                            ValueAnimator valueAnimator = this.M;
                            if (valueAnimator != null && valueAnimator.isRunning()) {
                                this.M.cancel();
                                this.f35420e.c();
                                a((int) this.f35417b, this.f35421f);
                            }
                        } else if (actionMasked != 3) {
                            if (actionMasked == 6) {
                                b(motionEvent);
                            }
                        }
                    }
                    this.q = false;
                    this.u = -1;
                } else {
                    int pointerId = motionEvent.getPointerId(0);
                    this.u = pointerId;
                    this.q = false;
                    float a3 = a(motionEvent, pointerId);
                    if (a3 == -1.0f) {
                        return false;
                    }
                    if (this.aa.hasEnded() && this.ab.hasEnded()) {
                        this.n = false;
                    }
                    this.z = a3;
                    this.A = this.f35417b;
                    this.s = false;
                }
                return this.q;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        View view;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048605, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)}) == null) || getChildCount() == 0) {
            return;
        }
        l();
        if (this.L == null) {
            return;
        }
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        if (this.L.getVisibility() != 8 || ((view = this.G) != null && view.getVisibility() != 8)) {
            int b2 = b(getPaddingTop());
            int paddingLeft = getPaddingLeft();
            int paddingLeft2 = ((paddingLeft + measuredWidth) - getPaddingLeft()) - getPaddingRight();
            int paddingTop = ((measuredHeight + b2) - getPaddingTop()) - getPaddingBottom();
            if (this.L.getVisibility() != 8) {
                this.L.layout(paddingLeft, b2, paddingLeft2, paddingTop);
            }
            View view2 = this.G;
            if (view2 != null && view2.getVisibility() != 8) {
                this.G.layout(paddingLeft, b2, paddingLeft2, paddingTop);
            }
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f35419d.getLayoutParams();
        int a2 = (a((int) this.D) + marginLayoutParams.topMargin) - marginLayoutParams.bottomMargin;
        this.f35419d.layout((measuredWidth - this.f35419d.getMeasuredWidth()) / 2, a2, (measuredWidth + this.f35419d.getMeasuredWidth()) / 2, this.f35419d.getMeasuredHeight() + a2);
    }

    @Override // android.view.View
    public void onMeasure(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048606, this, i2, i3) == null) {
            super.onMeasure(i2, i3);
            l();
            if (this.L == null) {
                return;
            }
            h();
            k();
            a(i2, i3);
            if (!this.J && !this.I) {
                int i4 = AnonymousClass6.f35430a[this.K.ordinal()];
                if (i4 == 1) {
                    float f2 = -this.f35419d.getMeasuredHeight();
                    this.D = f2;
                    this.f35417b = f2;
                } else if (i4 != 2) {
                    this.f35417b = 0.0f;
                    this.D = -this.f35419d.getMeasuredHeight();
                } else {
                    this.D = 0.0f;
                    this.f35417b = 0.0f;
                }
            }
            if (!this.J && !this.H && this.f35418c < this.f35419d.getMeasuredHeight()) {
                this.f35418c = this.f35419d.getMeasuredHeight();
            }
            this.J = true;
            this.t = -1;
            for (int i5 = 0; i5 < getChildCount(); i5++) {
                if (getChildAt(i5) == this.f35419d) {
                    this.t = i5;
                    return;
                }
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public boolean onNestedFling(View view, float f2, float f3, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048607, this, new Object[]{view, Float.valueOf(f2), Float.valueOf(f3), Boolean.valueOf(z)})) == null) ? dispatchNestedFling(f2, f3, z) : invokeCommon.booleanValue;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public boolean onNestedPreFling(View view, float f2, float f3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048608, this, new Object[]{view, Float.valueOf(f2), Float.valueOf(f3)})) == null) ? dispatchNestedPreFling(f2, f3) : invokeCommon.booleanValue;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onNestedPreScroll(View view, int i2, int i3, int[] iArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048609, this, new Object[]{view, Integer.valueOf(i2), Integer.valueOf(i3), iArr}) == null) {
            if (i3 > 0) {
                float f2 = this.l;
                if (f2 > 0.0f) {
                    float f3 = i3;
                    if (f3 > f2) {
                        iArr[1] = i3 - ((int) f2);
                        this.l = 0.0f;
                    } else {
                        this.l = f2 - f3;
                        iArr[1] = i3;
                    }
                    com.kwad.sdk.core.d.a.b("RefreshLayout", "pre scroll");
                    a(this.l, false);
                }
            }
            int[] iArr2 = this.f35423h;
            if (dispatchNestedPreScroll(i2 - iArr[0], i3 - iArr[1], iArr2, null)) {
                iArr[0] = iArr[0] + iArr2[0];
                iArr[1] = iArr[1] + iArr2[1];
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onNestedScroll(View view, int i2, int i3, int i4, int i5) {
        int i6;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048610, this, new Object[]{view, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)}) == null) {
            dispatchNestedScroll(i2, i3, i4, i5, this.f35424i);
            if (i5 + this.f35424i[1] < 0) {
                this.l += Math.abs(i6);
                com.kwad.sdk.core.d.a.b("RefreshLayout", "nested scroll");
                a(this.l, true);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onNestedScrollAccepted(View view, View view2, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048611, this, view, view2, i2) == null) {
            this.k.onNestedScrollAccepted(view, view2, i2);
            startNestedScroll(i2 & 2);
            this.l = 0.0f;
            this.m = true;
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public boolean onStartNestedScroll(View view, View view2, int i2) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048612, this, view, view2, i2)) == null) ? AnonymousClass6.f35430a[this.K.ordinal()] != 1 ? isEnabled() && a(this.L) && (i2 & 2) != 0 : isEnabled() && a(this.L) && !this.o && (i2 & 2) != 0 : invokeLLI.booleanValue;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onStopNestedScroll(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048613, this, view) == null) {
            this.k.onStopNestedScroll(view);
            this.m = false;
            if (this.l > 0.0f) {
                j();
                this.l = 0.0f;
            }
            stopNestedScroll();
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        float f2;
        StringBuilder sb;
        float f3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048614, this, motionEvent)) == null) {
            l();
            if (this.L == null) {
                return false;
            }
            if (AnonymousClass6.f35430a[this.K.ordinal()] != 1) {
                if (!isEnabled() || (a(this.L) && !this.s)) {
                    return false;
                }
            } else if (!isEnabled() || a(this.L) || this.m) {
                return false;
            }
            if (this.K == RefreshStyle.FLOAT && (a(this.L) || this.m)) {
                return false;
            }
            int action = motionEvent.getAction();
            if (action != 0) {
                if (action != 1) {
                    if (action == 2) {
                        int i2 = this.u;
                        if (i2 == -1) {
                            return false;
                        }
                        float a2 = a(motionEvent, i2);
                        if (a2 == -1.0f) {
                            return false;
                        }
                        if (this.n) {
                            f2 = getTargetOrRefreshViewTop();
                            this.B = a2;
                            this.A = f2;
                            sb = new StringBuilder();
                            sb.append("animatetostart overscrolly ");
                            sb.append(f2);
                            sb.append(" -- ");
                            f3 = this.B;
                        } else {
                            f2 = (a2 - this.B) + this.A;
                            sb = new StringBuilder();
                            sb.append("overscrolly ");
                            sb.append(f2);
                            sb.append(" --");
                            sb.append(this.B);
                            sb.append(" -- ");
                            f3 = this.A;
                        }
                        sb.append(f3);
                        com.kwad.sdk.core.d.a.b("RefreshLayout", sb.toString());
                        if (this.o) {
                            if (f2 > 0.0f) {
                                if (f2 > 0.0f && f2 < this.f35418c && this.s) {
                                    motionEvent = MotionEvent.obtain(motionEvent);
                                    motionEvent.setAction(3);
                                    this.s = false;
                                }
                                com.kwad.sdk.core.d.a.b("RefreshLayout", "moveSpinner refreshing -- " + this.A + " -- " + (a2 - this.B));
                                a(f2, true);
                            } else if (!this.s) {
                                motionEvent = MotionEvent.obtain(motionEvent);
                                motionEvent.setAction(0);
                                this.s = true;
                            }
                            this.L.dispatchTouchEvent(motionEvent);
                            com.kwad.sdk.core.d.a.b("RefreshLayout", "moveSpinner refreshing -- " + this.A + " -- " + (a2 - this.B));
                            a(f2, true);
                        } else if (!this.q) {
                            com.kwad.sdk.core.d.a.b("RefreshLayout", "is not Being Dragged, init drag status");
                            a(a2);
                        } else if (f2 <= 0.0f) {
                            com.kwad.sdk.core.d.a.b("RefreshLayout", "is Being Dragged, but over scroll Y < 0");
                            return false;
                        } else {
                            a(f2, true);
                            com.kwad.sdk.core.d.a.b("RefreshLayout", "moveSpinner not refreshing -- " + this.A + " -- " + (a2 - this.B));
                        }
                    } else if (action != 3) {
                        if (action == 5) {
                            a(motionEvent);
                        } else if (action == 6) {
                            b(motionEvent);
                        }
                    }
                }
                int i3 = this.u;
                if (i3 == -1 || a(motionEvent, i3) == -1.0f) {
                    i();
                    return false;
                } else if (!this.o && !this.n) {
                    i();
                    j();
                    return false;
                } else {
                    if (this.s) {
                        this.L.dispatchTouchEvent(motionEvent);
                    }
                    i();
                    return false;
                }
            }
            this.u = MotionEventCompat.getPointerId(motionEvent, 0);
            this.q = false;
            return true;
        }
        return invokeL.booleanValue;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048615, this, z) == null) {
            if (Build.VERSION.SDK_INT >= 21 || !(this.L instanceof AbsListView)) {
                View view = this.L;
                if (view == null || ViewCompat.isNestedScrollingEnabled(view)) {
                    super.requestDisallowInterceptTouchEvent(z);
                }
            }
        }
    }

    public void setAnimateToRefreshDuration(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048616, this, i2) == null) {
            this.w = i2;
        }
    }

    public void setAnimateToRefreshInterpolator(Interpolator interpolator) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048617, this, interpolator) == null) {
            this.U = interpolator;
        }
    }

    public void setAnimateToStartDuration(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048618, this, i2) == null) {
            this.v = i2;
        }
    }

    public void setAnimateToStartInterpolator(Interpolator interpolator) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048619, this, interpolator) == null) {
            this.T = interpolator;
        }
    }

    public void setDragDistanceConverter(@NonNull com.kwad.sdk.contentalliance.refreshview.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048620, this, bVar) == null) {
            if (bVar == null) {
                throw new NullPointerException("the dragDistanceConverter can't be null");
            }
            this.N = bVar;
        }
    }

    public void setIsStopNestScrollWhenUpOrCancel(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048621, this, z) == null) {
            this.ac = z;
        }
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public void setNestedScrollingEnabled(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048622, this, z) == null) {
            this.j.setNestedScrollingEnabled(z);
        }
    }

    public void setOnRefreshListener(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048623, this, bVar) == null) {
            this.O = bVar;
        }
    }

    public void setOnRefreshStatusListener(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048624, this, cVar) == null) {
            this.R = cVar;
        }
    }

    public void setOnScrollInterceptor(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048625, this, dVar) == null) {
            this.Q = dVar;
        }
    }

    public void setOnlySupportPull(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048626, this, z) == null) {
            this.V = z;
        }
    }

    public void setRefreshInitialOffset(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048627, this, f2) == null) {
            this.D = f2;
            this.I = true;
            requestLayout();
        }
    }

    public void setRefreshStyle(@NonNull RefreshStyle refreshStyle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048628, this, refreshStyle) == null) {
            this.K = refreshStyle;
        }
    }

    public void setRefreshTargetOffset(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048629, this, f2) == null) {
            this.f35418c = f2;
            this.H = true;
            requestLayout();
        }
    }

    public void setRefreshing(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048630, this, z) == null) || this.o == z) {
            return;
        }
        if (!z) {
            a(z, false);
            return;
        }
        if (getAnimation() != null && !getAnimation().hasEnded()) {
            getAnimation().setAnimationListener(null);
            clearAnimation();
            a();
        }
        this.o = z;
        this.r = false;
        b((int) this.f35417b, this.P);
    }

    public void setShowRefreshView(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048631, this, z) == null) {
            setOnlySupportPull(!z);
            this.W = z;
        }
    }

    public void setTargetOrRefreshViewOffsetY(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048632, this, i2) == null) {
            a(i2, false);
        }
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean startNestedScroll(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048633, this, i2)) == null) ? this.j.startNestedScroll(i2) : invokeI.booleanValue;
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public void stopNestedScroll() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048634, this) == null) {
            this.j.stopNestedScroll();
        }
    }
}
