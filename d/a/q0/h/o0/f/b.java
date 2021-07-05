package d.a.q0.h.o0.f;

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
import d.a.q0.a.g1.f;
import d.a.q0.a.p.b.a.n;
import d.a.q0.a.v2.n0;
import d.a.q0.h.m0.g;
/* loaded from: classes8.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: g  reason: collision with root package name */
    public static final int f53505g;

    /* renamed from: h  reason: collision with root package name */
    public static volatile b f53506h;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f53507a;

    /* renamed from: b  reason: collision with root package name */
    public int f53508b;

    /* renamed from: c  reason: collision with root package name */
    public int f53509c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f53510d;

    /* renamed from: e  reason: collision with root package name */
    public int f53511e;

    /* renamed from: f  reason: collision with root package name */
    public ViewTreeObserver.OnGlobalLayoutListener f53512f;

    /* loaded from: classes8.dex */
    public class a implements ViewTreeObserver.OnGlobalLayoutListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ View f53513e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d.a.q0.h.o0.f.a f53514f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ b f53515g;

        public a(b bVar, View view, d.a.q0.h.o0.f.a aVar) {
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
            this.f53515g = bVar;
            this.f53513e = view;
            this.f53514f = aVar;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                Rect rect = new Rect();
                View view = this.f53513e;
                if (view == null) {
                    return;
                }
                view.getWindowVisibleDisplayFrame(rect);
                int i2 = rect.bottom - rect.top;
                int n = n0.n(AppRuntime.getAppContext());
                int u = n0.u();
                if (!this.f53515g.f53510d) {
                    this.f53515g.f53510d = true;
                    this.f53515g.f53509c = (n - i2) - u;
                    if (this.f53515g.f53509c < 0) {
                        this.f53515g.f53509c = 0;
                    }
                }
                if (i2 > 0) {
                    if (i2 >= this.f53515g.f53511e || this.f53513e.getHeight() - i2 <= 200) {
                        if (i2 <= this.f53515g.f53511e || this.f53513e.getHeight() - i2 >= 200) {
                            return;
                        }
                        this.f53515g.f53511e = i2;
                        this.f53515g.s(this.f53514f);
                        return;
                    }
                    this.f53515g.f53511e = i2;
                    this.f53515g.f53508b = i2 - b.f53505g;
                    b bVar = this.f53515g;
                    bVar.f53507a = ((n - i2) - u) - bVar.f53509c;
                    if (this.f53515g.f53507a > 0) {
                        b bVar2 = this.f53515g;
                        if (bVar2.t(this.f53514f, bVar2.f53507a, this.f53515g.f53508b)) {
                            return;
                        }
                        this.f53515g.s(this.f53514f);
                    }
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1439300738, "Ld/a/q0/h/o0/f/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1439300738, "Ld/a/q0/h/o0/f/b;");
                return;
            }
        }
        f53505g = g.a(42.0f);
        f53506h = null;
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
        this.f53512f = null;
    }

    public static b p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65550, null)) == null) {
            if (f53506h == null) {
                synchronized (b.class) {
                    if (f53506h == null) {
                        f53506h = new b();
                    }
                }
            }
            return f53506h;
        }
        return (b) invokeV.objValue;
    }

    public final void m(View view, d.a.q0.h.o0.f.a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, view, aVar) == null) || view == null || aVar == null) {
            return;
        }
        this.f53511e = view.getHeight();
        this.f53512f = new a(this, view, aVar);
        view.getViewTreeObserver().addOnGlobalLayoutListener(this.f53512f);
    }

    public boolean n(d.a.q0.h.o0.f.a aVar) {
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

    public final d.a.q0.a.l1.e.a.a o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            d.a.q0.a.l1.e.a.a aVar = new d.a.q0.a.l1.e.a.a();
            aVar.n(true);
            aVar.q(-1);
            aVar.m(-2);
            return aVar;
        }
        return (d.a.q0.a.l1.e.a.a) invokeV.objValue;
    }

    public final d.a.q0.a.l1.e.a.a q(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i2)) == null) {
            d.a.q0.a.l1.e.a.a aVar = new d.a.q0.a.l1.e.a.a();
            aVar.n(true);
            aVar.p(i2);
            aVar.q(-1);
            aVar.m(-2);
            return aVar;
        }
        return (d.a.q0.a.l1.e.a.a) invokeI.objValue;
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

    public boolean s(d.a.q0.h.o0.f.a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, aVar)) == null) {
            n Y = f.V().Y();
            if (Y == null) {
                return false;
            }
            FrameLayout rootView = Y.getRootView();
            if (rootView != null && this.f53512f != null) {
                rootView.getViewTreeObserver().removeOnGlobalLayoutListener(this.f53512f);
            }
            aVar.h();
            this.f53512f = null;
            this.f53507a = -1;
            this.f53508b = -1;
            this.f53509c = -1;
            this.f53510d = false;
            this.f53511e = -1;
            return Y.removeView(aVar.f());
        }
        return invokeL.booleanValue;
    }

    public final boolean t(d.a.q0.h.o0.f.a aVar, int i2, int i3) {
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
