package d.a.n0.h.o0.f;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.n0.a.g1.f;
import d.a.n0.a.p.b.a.n;
import d.a.n0.a.v2.n0;
import d.a.n0.h.m0.g;
/* loaded from: classes7.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: g  reason: collision with root package name */
    public static final int f50203g;

    /* renamed from: h  reason: collision with root package name */
    public static volatile b f50204h;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f50205a;

    /* renamed from: b  reason: collision with root package name */
    public int f50206b;

    /* renamed from: c  reason: collision with root package name */
    public int f50207c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f50208d;

    /* renamed from: e  reason: collision with root package name */
    public int f50209e;

    /* renamed from: f  reason: collision with root package name */
    public ViewTreeObserver.OnGlobalLayoutListener f50210f;

    /* loaded from: classes7.dex */
    public class a implements ViewTreeObserver.OnGlobalLayoutListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ View f50211e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d.a.n0.h.o0.f.a f50212f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ b f50213g;

        public a(b bVar, View view, d.a.n0.h.o0.f.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, view, aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f50213g = bVar;
            this.f50211e = view;
            this.f50212f = aVar;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                Rect rect = new Rect();
                View view = this.f50211e;
                if (view == null) {
                    return;
                }
                view.getWindowVisibleDisplayFrame(rect);
                int i2 = rect.bottom - rect.top;
                int n = n0.n(AppRuntime.getAppContext());
                int u = n0.u();
                if (!this.f50213g.f50208d) {
                    this.f50213g.f50208d = true;
                    this.f50213g.f50207c = (n - i2) - u;
                    if (this.f50213g.f50207c < 0) {
                        this.f50213g.f50207c = 0;
                    }
                }
                if (i2 > 0) {
                    if (i2 >= this.f50213g.f50209e || this.f50211e.getHeight() - i2 <= 200) {
                        if (i2 <= this.f50213g.f50209e || this.f50211e.getHeight() - i2 >= 200) {
                            return;
                        }
                        this.f50213g.f50209e = i2;
                        this.f50213g.s(this.f50212f);
                        return;
                    }
                    this.f50213g.f50209e = i2;
                    this.f50213g.f50206b = i2 - b.f50203g;
                    b bVar = this.f50213g;
                    bVar.f50205a = ((n - i2) - u) - bVar.f50207c;
                    if (this.f50213g.f50205a > 0) {
                        b bVar2 = this.f50213g;
                        if (bVar2.t(this.f50212f, bVar2.f50205a, this.f50213g.f50206b)) {
                            return;
                        }
                        this.f50213g.s(this.f50212f);
                    }
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1826548895, "Ld/a/n0/h/o0/f/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1826548895, "Ld/a/n0/h/o0/f/b;");
                return;
            }
        }
        f50203g = g.a(42.0f);
        f50204h = null;
    }

    public b() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f50210f = null;
    }

    public static b p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65550, null)) == null) {
            if (f50204h == null) {
                synchronized (b.class) {
                    if (f50204h == null) {
                        f50204h = new b();
                    }
                }
            }
            return f50204h;
        }
        return (b) invokeV.objValue;
    }

    public final void m(View view, d.a.n0.h.o0.f.a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, view, aVar) == null) || view == null || aVar == null) {
            return;
        }
        this.f50209e = view.getHeight();
        this.f50210f = new a(this, view, aVar);
        view.getViewTreeObserver().addOnGlobalLayoutListener(this.f50210f);
    }

    public boolean n(d.a.n0.h.o0.f.a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar)) == null) {
            n Y = f.V().Y();
            boolean z = (Y == null || r(aVar.f()) || !Y.c(aVar.f(), o())) ? false : true;
            if (z) {
                if (!aVar.l() || Y == null) {
                    return false;
                }
                m(Y.getRootView(), aVar);
            }
            return z;
        }
        return invokeL.booleanValue;
    }

    public final d.a.n0.a.l1.e.a.a o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            d.a.n0.a.l1.e.a.a aVar = new d.a.n0.a.l1.e.a.a();
            aVar.n(true);
            aVar.q(-1);
            aVar.m(-2);
            return aVar;
        }
        return (d.a.n0.a.l1.e.a.a) invokeV.objValue;
    }

    public final d.a.n0.a.l1.e.a.a q(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i2)) == null) {
            d.a.n0.a.l1.e.a.a aVar = new d.a.n0.a.l1.e.a.a();
            aVar.n(true);
            aVar.p(i2);
            aVar.q(-1);
            aVar.m(-2);
            return aVar;
        }
        return (d.a.n0.a.l1.e.a.a) invokeI.objValue;
    }

    public final boolean r(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, view)) == null) {
            n Y = f.V().Y();
            return Y != null && Y.d(view);
        }
        return invokeL.booleanValue;
    }

    public boolean s(d.a.n0.h.o0.f.a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, aVar)) == null) {
            n Y = f.V().Y();
            if (Y == null) {
                return false;
            }
            FrameLayout rootView = Y.getRootView();
            if (rootView != null && this.f50210f != null) {
                rootView.getViewTreeObserver().removeOnGlobalLayoutListener(this.f50210f);
            }
            aVar.h();
            this.f50210f = null;
            this.f50205a = -1;
            this.f50206b = -1;
            this.f50207c = -1;
            this.f50208d = false;
            this.f50209e = -1;
            return Y.removeView(aVar.f());
        }
        return invokeL.booleanValue;
    }

    public final boolean t(d.a.n0.h.o0.f.a aVar, int i2, int i3) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(1048582, this, aVar, i2, i3)) == null) {
            n Y = f.V().Y();
            boolean z = Y != null && Y.a(aVar.f(), q(i3));
            if (z) {
                aVar.k(i2);
            }
            return z;
        }
        return invokeLII.booleanValue;
    }
}
