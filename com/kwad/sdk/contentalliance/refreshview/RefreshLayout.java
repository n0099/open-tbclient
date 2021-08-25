package com.kwad.sdk.contentalliance.refreshview;

import android.os.Build;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Interpolator;
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
/* loaded from: classes10.dex */
public abstract class RefreshLayout extends ViewGroup implements NestedScrollingChild, NestedScrollingParent {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public float A;
    public float B;
    public View C;
    public boolean D;
    public boolean E;
    public boolean F;
    public RefreshStyle G;
    public View H;
    public com.kwad.sdk.contentalliance.refreshview.a I;
    public a J;
    public final Animation.AnimationListener K;
    public c L;
    public b M;
    public List<b> N;
    public Interpolator O;
    public Interpolator P;
    public boolean Q;
    public boolean R;
    public final Animation S;
    public final Animation T;
    public boolean U;

    /* renamed from: a  reason: collision with root package name */
    public float f71254a;

    /* renamed from: b  reason: collision with root package name */
    public float f71255b;

    /* renamed from: c  reason: collision with root package name */
    public View f71256c;

    /* renamed from: d  reason: collision with root package name */
    public com.kwad.sdk.contentalliance.refreshview.b f71257d;

    /* renamed from: e  reason: collision with root package name */
    public final Animation.AnimationListener f71258e;

    /* renamed from: f  reason: collision with root package name */
    public final NestedScrollingChildHelper f71259f;

    /* renamed from: g  reason: collision with root package name */
    public final NestedScrollingParentHelper f71260g;

    /* renamed from: h  reason: collision with root package name */
    public float f71261h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f71262i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f71263j;
    public boolean k;
    public boolean l;
    public boolean m;
    public boolean n;
    public boolean o;
    public int p;
    public int q;
    public int r;
    public int s;
    public int t;
    public int u;
    public float v;
    public float w;
    public float x;
    public float y;
    public float z;

    /* renamed from: com.kwad.sdk.contentalliance.refreshview.RefreshLayout$2  reason: invalid class name */
    /* loaded from: classes10.dex */
    public static /* synthetic */ class AnonymousClass2 {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f71265a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(487301137, "Lcom/kwad/sdk/contentalliance/refreshview/RefreshLayout$2;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(487301137, "Lcom/kwad/sdk/contentalliance/refreshview/RefreshLayout$2;");
                    return;
                }
            }
            int[] iArr = new int[RefreshStyle.values().length];
            f71265a = iArr;
            try {
                iArr[RefreshStyle.FLOAT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f71265a[RefreshStyle.PINNED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes10.dex */
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

    /* loaded from: classes10.dex */
    public interface a {
    }

    /* loaded from: classes10.dex */
    public interface b {
        void a();

        void a(float f2, float f3, boolean z);

        void b();
    }

    /* loaded from: classes10.dex */
    public interface c {
        boolean a(float f2, boolean z);
    }

    private float a(MotionEvent motionEvent, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65536, this, motionEvent, i2)) == null) {
            int findPointerIndex = MotionEventCompat.findPointerIndex(motionEvent, i2);
            if (findPointerIndex < 0) {
                return -1.0f;
            }
            return MotionEventCompat.getY(motionEvent, findPointerIndex);
        }
        return invokeLI.floatValue;
    }

    private void a(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(65537, this, f2) == null) {
            float f3 = f2 - this.v;
            if (this.k && (f3 > this.u || this.f71254a > 0.0f)) {
                this.m = true;
                this.x = this.v + this.u;
            } else if (this.m) {
            } else {
                int i2 = this.u;
                if (f3 > i2) {
                    this.x = this.v + i2;
                    this.m = true;
                }
            }
        }
    }

    private void a(float f2, boolean z) {
        float f3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65538, this, new Object[]{Float.valueOf(f2), Boolean.valueOf(z)}) == null) {
            this.y = f2;
            c cVar = this.L;
            int i2 = 0;
            if (cVar == null || !cVar.a(f2, false)) {
                if (this.k) {
                    f3 = this.f71255b;
                    if (f2 <= f3) {
                        f3 = f2;
                    }
                    if (f3 < 0.0f) {
                        f3 = 0.0f;
                    }
                } else {
                    f3 = AnonymousClass2.f71265a[this.G.ordinal()] != 1 ? this.I.a(f2, this.f71255b) : this.z + this.I.a(f2, this.f71255b);
                }
                float f4 = this.f71255b;
                if (!this.k) {
                    if (f3 > f4 && !this.l) {
                        this.l = true;
                        this.f71257d.c();
                        b bVar = this.M;
                        if (bVar != null) {
                            bVar.a();
                        }
                        if (this.N != null) {
                            while (i2 < this.N.size()) {
                                this.N.get(i2).a();
                                i2++;
                            }
                        }
                    } else if (f3 <= f4 && this.l) {
                        this.l = false;
                        this.f71257d.d();
                        b bVar2 = this.M;
                        if (bVar2 != null) {
                            bVar2.b();
                        }
                        if (this.N != null) {
                            while (i2 < this.N.size()) {
                                this.N.get(i2).b();
                                i2++;
                            }
                        }
                    }
                }
                com.kwad.sdk.core.d.a.c("RefreshLayout", f2 + " -- " + f4 + " -- " + f3 + " -- " + this.f71254a + " -- " + this.f71255b);
                a((int) (f3 - this.f71254a), z);
            }
        }
    }

    private void a(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(65539, this, i2, i3) == null) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f71256c.getLayoutParams();
            this.f71256c.measure(marginLayoutParams.width == -1 ? View.MeasureSpec.makeMeasureSpec(Math.max(0, (((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight()) - marginLayoutParams.leftMargin) - marginLayoutParams.rightMargin), 1073741824) : ViewGroup.getChildMeasureSpec(i2, getPaddingLeft() + getPaddingRight() + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin, marginLayoutParams.width), marginLayoutParams.height == -1 ? View.MeasureSpec.makeMeasureSpec(Math.max(0, (((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom()) - marginLayoutParams.topMargin) - marginLayoutParams.bottomMargin), 1073741824) : ViewGroup.getChildMeasureSpec(i3, getPaddingTop() + getPaddingBottom() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin, marginLayoutParams.height));
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
        if (!(interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)}) == null) || this.H == null) {
            return;
        }
        int i3 = AnonymousClass2.f71265a[this.G.ordinal()];
        if (i3 == 1) {
            this.f71256c.offsetTopAndBottom(i2);
            view = this.f71256c;
        } else if (i3 != 2) {
            this.H.offsetTopAndBottom(i2);
            View view2 = this.C;
            if (view2 != null) {
                view2.offsetTopAndBottom(i2);
            } else {
                float f2 = (i2 / this.A) + this.B;
                int i4 = (int) f2;
                this.B = f2 - i4;
                this.f71256c.offsetTopAndBottom(i4);
            }
            this.f71254a = this.H.getTop();
            com.kwad.sdk.core.d.a.c("RefreshLayout", "refresh style" + this.f71254a);
            com.kwad.sdk.core.d.a.c("RefreshLayout", "current offset" + this.f71254a);
            if (AnonymousClass2.f71265a[this.G.ordinal()] == 1) {
                com.kwad.sdk.contentalliance.refreshview.b bVar = this.f71257d;
                float f3 = this.f71254a;
                bVar.a(f3, f3 / this.f71255b);
                b bVar2 = this.M;
                if (bVar2 != null) {
                    float f4 = this.f71254a;
                    bVar2.a(f4, f4 / this.f71255b, z);
                }
                if (this.N != null) {
                    for (int i5 = 0; i5 < this.N.size(); i5++) {
                        float f5 = this.f71254a;
                        this.N.get(i5).a(f5, f5 / this.f71255b, z);
                    }
                }
            } else {
                com.kwad.sdk.contentalliance.refreshview.b bVar3 = this.f71257d;
                float f6 = this.f71254a;
                bVar3.a(f6, (f6 - this.z) / this.f71255b);
                b bVar4 = this.M;
                if (bVar4 != null) {
                    float f7 = this.f71254a;
                    bVar4.a(f7, (f7 - this.z) / this.f71255b, z);
                }
                if (this.N != null) {
                    for (int i6 = 0; i6 < this.N.size(); i6++) {
                        float f8 = this.f71254a;
                        this.N.get(i6).a(f8, (f8 - this.z) / this.f71255b, z);
                    }
                }
            }
            if (this.R && this.f71256c.getVisibility() != 0) {
                this.f71256c.setVisibility(0);
            }
            invalidate();
        } else {
            this.H.offsetTopAndBottom(i2);
            View view3 = this.C;
            if (view3 != null) {
                view3.offsetTopAndBottom(i2);
            }
            view = this.H;
        }
        this.f71254a = view.getTop();
        com.kwad.sdk.core.d.a.c("RefreshLayout", "current offset" + this.f71254a);
        if (AnonymousClass2.f71265a[this.G.ordinal()] == 1) {
        }
        if (this.R) {
            this.f71256c.setVisibility(0);
        }
        invalidate();
    }

    private void a(MotionEvent motionEvent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(AdIconUtil.AD_TEXT_ID, this, motionEvent) == null) {
            int pointerId = MotionEventCompat.getPointerId(motionEvent, MotionEventCompat.getActionIndex(motionEvent));
            this.q = pointerId;
            this.x = a(motionEvent, pointerId) - this.y;
            com.kwad.sdk.core.d.a.c("RefreshLayout", " onDown " + this.x);
        }
    }

    private void a(boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(AdIconUtil.BAIDU_LOGO_ID, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) || this.k == z) {
            return;
        }
        this.n = z2;
        this.k = z;
        if (z) {
            b((int) this.f71254a, this.K);
            return;
        }
        this.f71257d.b();
        postDelayed(new Runnable(this) { // from class: com.kwad.sdk.contentalliance.refreshview.RefreshLayout.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ RefreshLayout f71264a;

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
                this.f71264a = this;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    RefreshLayout refreshLayout = this.f71264a;
                    refreshLayout.a((int) refreshLayout.f71254a, refreshLayout.f71258e);
                }
            }
        }, this.f71257d.e());
    }

    private boolean a(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, this, view)) == null) {
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
        if (interceptable == null || (invokeF = interceptable.invokeF(65544, this, f2)) == null) {
            com.kwad.sdk.core.d.a.c("RefreshLayout", "from -- refreshing " + f2);
            if (AnonymousClass2.f71265a[this.G.ordinal()] == 1) {
                f2 -= this.z;
            }
            return (int) (Math.max(0.0f, Math.min(1.0f, Math.abs(f2 - this.f71255b) / this.f71255b)) * this.s);
        }
        return invokeF.intValue;
    }

    private int b(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65545, this, i2)) == null) ? AnonymousClass2.f71265a[this.G.ordinal()] != 1 ? i2 + ((int) this.f71254a) : i2 : invokeI.intValue;
    }

    private void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65546, this) == null) {
            c();
            this.y = 0.0f;
            this.B = 0.0f;
            this.f71257d.a();
            this.f71256c.setVisibility(8);
            this.k = false;
            this.f71263j = false;
            com.kwad.sdk.core.d.a.c("RefreshLayout", "reset");
        }
    }

    private void b(int i2, Animation.AnimationListener animationListener) {
        float f2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(65547, this, i2, animationListener) == null) {
            clearAnimation();
            if (b(i2) <= 0) {
                animationListener.onAnimationStart(null);
                animationListener.onAnimationEnd(null);
                return;
            }
            this.t = i2;
            this.S.reset();
            this.S.setDuration(b(f2));
            this.S.setInterpolator(this.P);
            if (animationListener != null) {
                this.S.setAnimationListener(animationListener);
            }
            startAnimation(this.S);
        }
    }

    private void b(MotionEvent motionEvent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65548, this, motionEvent) == null) {
            int actionIndex = MotionEventCompat.getActionIndex(motionEvent);
            if (MotionEventCompat.getPointerId(motionEvent, actionIndex) == this.q) {
                this.q = MotionEventCompat.getPointerId(motionEvent, actionIndex == 0 ? 1 : 0);
            }
            this.x = a(motionEvent, this.q) - this.y;
            com.kwad.sdk.core.d.a.c("RefreshLayout", " onUp " + this.x);
        }
    }

    private int c(float f2) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(65549, this, f2)) == null) {
            com.kwad.sdk.core.d.a.c("RefreshLayout", "from -- start " + f2);
            if (f2 < this.z) {
                return 0;
            }
            if (AnonymousClass2.f71265a[this.G.ordinal()] == 1) {
                f2 -= this.z;
            }
            return (int) (Math.max(0.0f, Math.min(1.0f, Math.abs(f2) / this.f71255b)) * this.r);
        }
        return invokeF.intValue;
    }

    private void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65550, this) == null) {
            setTargetOrRefreshViewOffsetY((int) ((AnonymousClass2.f71265a[this.G.ordinal()] != 1 ? 0.0f : this.z) - this.f71254a));
        }
    }

    private void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65551, this) == null) {
            this.H.measure(View.MeasureSpec.makeMeasureSpec((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), 1073741824), View.MeasureSpec.makeMeasureSpec((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), 1073741824));
        }
    }

    private void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65552, this) == null) {
            this.w = 0.0f;
            this.m = false;
            this.o = false;
            this.q = -1;
        }
    }

    private void f() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65553, this) == null) || this.k || this.f71263j) {
            return;
        }
        c cVar = this.L;
        if (cVar == null || !cVar.a(this.y, true)) {
            if (a()) {
                a(true, true);
                return;
            }
            this.k = false;
            a((int) this.f71254a, this.f71258e);
        }
    }

    private void g() {
        View view;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65554, this) == null) || (view = this.C) == null) {
            return;
        }
        view.measure(View.MeasureSpec.makeMeasureSpec((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), 1073741824), View.MeasureSpec.makeMeasureSpec((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), 1073741824));
    }

    private int getTargetOrRefreshViewTop() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65555, this)) == null) {
            return (AnonymousClass2.f71265a[this.G.ordinal()] != 1 ? this.H : this.f71256c).getTop();
        }
        return invokeV.intValue;
    }

    private void h() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65556, this) == null) || i()) {
            return;
        }
        for (int i2 = 0; i2 < getChildCount(); i2++) {
            View childAt = getChildAt(i2);
            if (!childAt.equals(this.f71256c) && !childAt.equals(this.C)) {
                this.H = childAt;
                return;
            }
        }
    }

    private boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65557, this)) == null) {
            for (int i2 = 0; i2 < getChildCount(); i2++) {
                if (this.H == getChildAt(i2)) {
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
            int i3 = AnonymousClass2.f71265a[this.G.ordinal()];
            return (i3 == 1 || i3 != 2) ? i2 + ((int) this.f71254a) : i2;
        }
        return invokeI.intValue;
    }

    public void a(int i2, Animation.AnimationListener animationListener) {
        float f2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, animationListener) == null) {
            clearAnimation();
            if (c(i2) <= 0) {
                animationListener.onAnimationStart(null);
                animationListener.onAnimationEnd(null);
                return;
            }
            this.t = i2;
            this.T.reset();
            this.T.setDuration(c(f2));
            this.T.setInterpolator(this.O);
            if (animationListener != null) {
                this.T.setAnimationListener(animationListener);
            }
            startAnimation(this.T);
        }
    }

    public boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? !this.Q && ((float) getTargetOrRefreshViewOffset()) > this.f71255b : invokeV.booleanValue;
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedFling(float f2, float f3, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3), Boolean.valueOf(z)})) == null) ? this.f71259f.dispatchNestedFling(f2, f3, z) : invokeCommon.booleanValue;
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedPreFling(float f2, float f3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3)})) == null) ? this.f71259f.dispatchNestedPreFling(f2, f3) : invokeCommon.booleanValue;
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedPreScroll(int i2, int i3, int[] iArr, int[] iArr2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048581, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), iArr, iArr2})) == null) ? this.f71259f.dispatchNestedPreScroll(i2, i3, iArr, iArr2) : invokeCommon.booleanValue;
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedScroll(int i2, int i3, int i4, int i5, int[] iArr) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048582, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), iArr})) == null) ? this.f71259f.dispatchNestedScroll(i2, i3, i4, i5, iArr) : invokeCommon.booleanValue;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        int actionMasked;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, motionEvent)) == null) {
            if (this.U && ((actionMasked = MotionEventCompat.getActionMasked(motionEvent)) == 1 || actionMasked == 3)) {
                onStopNestedScroll(this);
            }
            com.kwad.sdk.core.d.a.c("RefreshLayout", "dispatch " + this.o + " isRefreshing" + this.k);
            return super.dispatchTouchEvent(motionEvent);
        }
        return invokeL.booleanValue;
    }

    @Override // android.view.ViewGroup, androidx.core.view.NestedScrollingParent
    public int getNestedScrollAxes() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f71260g.getNestedScrollAxes() : invokeV.intValue;
    }

    public float getRefreshTargetOffset() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f71255b : invokeV.floatValue;
    }

    @Nullable
    public View getStateView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.C : (View) invokeV.objValue;
    }

    public int getTargetOrRefreshViewOffset() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            if (AnonymousClass2.f71265a[this.G.ordinal()] != 1) {
                View view = this.H;
                if (view == null) {
                    return 0;
                }
                return view.getTop();
            }
            return (int) (this.f71256c.getTop() - this.z);
        }
        return invokeV.intValue;
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean hasNestedScrollingParent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.f71259f.hasNestedScrollingParent() : invokeV.booleanValue;
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean isNestedScrollingEnabled() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.f71259f.isNestedScrollingEnabled() : invokeV.booleanValue;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            b();
            this.J = null;
            clearAnimation();
            super.onDetachedFromWindow();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        View view;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048591, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)}) == null) || getChildCount() == 0) {
            return;
        }
        h();
        if (this.H == null) {
            return;
        }
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        if (this.H.getVisibility() != 8 || ((view = this.C) != null && view.getVisibility() != 8)) {
            int b2 = b(getPaddingTop());
            int paddingLeft = getPaddingLeft();
            int paddingLeft2 = ((paddingLeft + measuredWidth) - getPaddingLeft()) - getPaddingRight();
            int paddingTop = ((measuredHeight + b2) - getPaddingTop()) - getPaddingBottom();
            if (this.H.getVisibility() != 8) {
                this.H.layout(paddingLeft, b2, paddingLeft2, paddingTop);
            }
            View view2 = this.C;
            if (view2 != null && view2.getVisibility() != 8) {
                this.C.layout(paddingLeft, b2, paddingLeft2, paddingTop);
            }
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f71256c.getLayoutParams();
        int a2 = (a((int) this.z) + marginLayoutParams.topMargin) - marginLayoutParams.bottomMargin;
        this.f71256c.layout((measuredWidth - this.f71256c.getMeasuredWidth()) / 2, a2, (measuredWidth + this.f71256c.getMeasuredWidth()) / 2, this.f71256c.getMeasuredHeight() + a2);
    }

    @Override // android.view.View
    public void onMeasure(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048592, this, i2, i3) == null) {
            super.onMeasure(i2, i3);
            h();
            if (this.H == null) {
                return;
            }
            d();
            g();
            a(i2, i3);
            if (!this.F && !this.E) {
                int i4 = AnonymousClass2.f71265a[this.G.ordinal()];
                if (i4 == 1) {
                    float f2 = -this.f71256c.getMeasuredHeight();
                    this.z = f2;
                    this.f71254a = f2;
                } else if (i4 != 2) {
                    this.f71254a = 0.0f;
                    this.z = -this.f71256c.getMeasuredHeight();
                } else {
                    this.z = 0.0f;
                    this.f71254a = 0.0f;
                }
            }
            if (!this.F && !this.D && this.f71255b < this.f71256c.getMeasuredHeight()) {
                this.f71255b = this.f71256c.getMeasuredHeight();
            }
            this.F = true;
            this.p = -1;
            for (int i5 = 0; i5 < getChildCount(); i5++) {
                if (getChildAt(i5) == this.f71256c) {
                    this.p = i5;
                    return;
                }
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onStopNestedScroll(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, view) == null) {
            this.f71260g.onStopNestedScroll(view);
            this.f71262i = false;
            if (this.f71261h > 0.0f) {
                f();
                this.f71261h = 0.0f;
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
        if (interceptable == null || (invokeL = interceptable.invokeL(1048594, this, motionEvent)) == null) {
            h();
            if (this.H == null) {
                return false;
            }
            if (AnonymousClass2.f71265a[this.G.ordinal()] != 1) {
                if (!isEnabled() || (a(this.H) && !this.o)) {
                    return false;
                }
            } else if (!isEnabled() || a(this.H) || this.f71262i) {
                return false;
            }
            if (this.G == RefreshStyle.FLOAT && (a(this.H) || this.f71262i)) {
                return false;
            }
            int action = motionEvent.getAction();
            if (action != 0) {
                if (action != 1) {
                    if (action == 2) {
                        int i2 = this.q;
                        if (i2 == -1) {
                            return false;
                        }
                        float a2 = a(motionEvent, i2);
                        if (a2 == -1.0f) {
                            return false;
                        }
                        if (this.f71263j) {
                            f2 = getTargetOrRefreshViewTop();
                            this.x = a2;
                            this.w = f2;
                            sb = new StringBuilder();
                            sb.append("animatetostart overscrolly ");
                            sb.append(f2);
                            sb.append(" -- ");
                            f3 = this.x;
                        } else {
                            f2 = (a2 - this.x) + this.w;
                            sb = new StringBuilder();
                            sb.append("overscrolly ");
                            sb.append(f2);
                            sb.append(" --");
                            sb.append(this.x);
                            sb.append(" -- ");
                            f3 = this.w;
                        }
                        sb.append(f3);
                        com.kwad.sdk.core.d.a.c("RefreshLayout", sb.toString());
                        if (this.k) {
                            if (f2 > 0.0f) {
                                if (f2 > 0.0f && f2 < this.f71255b && this.o) {
                                    motionEvent = MotionEvent.obtain(motionEvent);
                                    motionEvent.setAction(3);
                                    this.o = false;
                                }
                                com.kwad.sdk.core.d.a.c("RefreshLayout", "moveSpinner refreshing -- " + this.w + " -- " + (a2 - this.x));
                                a(f2, true);
                            } else if (!this.o) {
                                motionEvent = MotionEvent.obtain(motionEvent);
                                motionEvent.setAction(0);
                                this.o = true;
                            }
                            this.H.dispatchTouchEvent(motionEvent);
                            com.kwad.sdk.core.d.a.c("RefreshLayout", "moveSpinner refreshing -- " + this.w + " -- " + (a2 - this.x));
                            a(f2, true);
                        } else if (!this.m) {
                            com.kwad.sdk.core.d.a.c("RefreshLayout", "is not Being Dragged, init drag status");
                            a(a2);
                        } else if (f2 <= 0.0f) {
                            com.kwad.sdk.core.d.a.c("RefreshLayout", "is Being Dragged, but over scroll Y < 0");
                            return false;
                        } else {
                            a(f2, true);
                            com.kwad.sdk.core.d.a.c("RefreshLayout", "moveSpinner not refreshing -- " + this.w + " -- " + (a2 - this.x));
                        }
                    } else if (action != 3) {
                        if (action == 5) {
                            a(motionEvent);
                        } else if (action == 6) {
                            b(motionEvent);
                        }
                    }
                }
                int i3 = this.q;
                if (i3 == -1 || a(motionEvent, i3) == -1.0f) {
                    e();
                    return false;
                } else if (!this.k && !this.f71263j) {
                    e();
                    f();
                    return false;
                } else {
                    if (this.o) {
                        this.H.dispatchTouchEvent(motionEvent);
                    }
                    e();
                    return false;
                }
            }
            this.q = MotionEventCompat.getPointerId(motionEvent, 0);
            this.m = false;
            return true;
        }
        return invokeL.booleanValue;
    }

    public void setAnimateToRefreshDuration(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048595, this, i2) == null) {
            this.s = i2;
        }
    }

    public void setAnimateToRefreshInterpolator(Interpolator interpolator) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, interpolator) == null) {
            this.P = interpolator;
        }
    }

    public void setAnimateToStartDuration(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048597, this, i2) == null) {
            this.r = i2;
        }
    }

    public void setAnimateToStartInterpolator(Interpolator interpolator) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, interpolator) == null) {
            this.O = interpolator;
        }
    }

    public void setDragDistanceConverter(@NonNull com.kwad.sdk.contentalliance.refreshview.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, aVar) == null) {
            if (aVar == null) {
                throw new NullPointerException("the dragDistanceConverter can't be null");
            }
            this.I = aVar;
        }
    }

    public void setIsStopNestScrollWhenUpOrCancel(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048600, this, z) == null) {
            this.U = z;
        }
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public void setNestedScrollingEnabled(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048601, this, z) == null) {
            this.f71259f.setNestedScrollingEnabled(z);
        }
    }

    public void setOnRefreshListener(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, aVar) == null) {
            this.J = aVar;
        }
    }

    public void setOnRefreshStatusListener(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, bVar) == null) {
            this.M = bVar;
        }
    }

    public void setOnScrollInterceptor(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048604, this, cVar) == null) {
            this.L = cVar;
        }
    }

    public void setOnlySupportPull(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048605, this, z) == null) {
            this.Q = z;
        }
    }

    public void setRefreshInitialOffset(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048606, this, f2) == null) {
            this.z = f2;
            this.E = true;
            requestLayout();
        }
    }

    public void setRefreshStyle(@NonNull RefreshStyle refreshStyle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048607, this, refreshStyle) == null) {
            this.G = refreshStyle;
        }
    }

    public void setRefreshTargetOffset(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048608, this, f2) == null) {
            this.f71255b = f2;
            this.D = true;
            requestLayout();
        }
    }

    public void setRefreshing(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048609, this, z) == null) || this.k == z) {
            return;
        }
        if (!z) {
            a(z, false);
            return;
        }
        if (getAnimation() != null && !getAnimation().hasEnded()) {
            getAnimation().setAnimationListener(null);
            clearAnimation();
            b();
        }
        this.k = z;
        this.n = false;
        b((int) this.f71254a, this.K);
    }

    public void setShowRefreshView(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048610, this, z) == null) {
            setOnlySupportPull(!z);
            this.R = z;
        }
    }

    public void setTargetOrRefreshViewOffsetY(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048611, this, i2) == null) {
            a(i2, false);
        }
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean startNestedScroll(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048612, this, i2)) == null) ? this.f71259f.startNestedScroll(i2) : invokeI.booleanValue;
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public void stopNestedScroll() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048613, this) == null) {
            this.f71259f.stopNestedScroll();
        }
    }
}
