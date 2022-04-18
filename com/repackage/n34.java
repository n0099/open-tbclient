package com.repackage;

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
/* loaded from: classes6.dex */
public class n34 {
    public static /* synthetic */ Interceptable $ic;
    public static final int g;
    public static volatile n34 h;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public int b;
    public int c;
    public boolean d;
    public int e;
    public ViewTreeObserver.OnGlobalLayoutListener f;

    /* loaded from: classes6.dex */
    public class a implements ViewTreeObserver.OnGlobalLayoutListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ View a;
        public final /* synthetic */ m34 b;
        public final /* synthetic */ n34 c;

        public a(n34 n34Var, View view2, m34 m34Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {n34Var, view2, m34Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = n34Var;
            this.a = view2;
            this.b = m34Var;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                Rect rect = new Rect();
                View view2 = this.a;
                if (view2 == null) {
                    return;
                }
                view2.getWindowVisibleDisplayFrame(rect);
                int i = rect.bottom - rect.top;
                int n = ae3.n(AppRuntime.getAppContext());
                int t = ae3.t();
                if (!this.c.d) {
                    this.c.d = true;
                    this.c.c = (n - i) - t;
                    if (this.c.c < 0) {
                        this.c.c = 0;
                    }
                }
                if (i > 0) {
                    if (i >= this.c.e || this.a.getHeight() - i <= 200) {
                        if (i <= this.c.e || this.a.getHeight() - i >= 200) {
                            return;
                        }
                        this.c.e = i;
                        this.c.s(this.b);
                        return;
                    }
                    this.c.e = i;
                    this.c.b = i - n34.g;
                    n34 n34Var = this.c;
                    n34Var.a = ((n - i) - t) - n34Var.c;
                    if (this.c.a > 0) {
                        n34 n34Var2 = this.c;
                        if (n34Var2.t(this.b, n34Var2.a, this.c.b)) {
                            return;
                        }
                        this.c.s(this.b);
                    }
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755520446, "Lcom/repackage/n34;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755520446, "Lcom/repackage/n34;");
                return;
            }
        }
        g = y24.a(42.0f);
        h = null;
    }

    public n34() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f = null;
    }

    public static n34 p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65550, null)) == null) {
            if (h == null) {
                synchronized (n34.class) {
                    if (h == null) {
                        h = new n34();
                    }
                }
            }
            return h;
        }
        return (n34) invokeV.objValue;
    }

    public final void m(View view2, m34 m34Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, view2, m34Var) == null) || view2 == null || m34Var == null) {
            return;
        }
        this.e = view2.getHeight();
        this.f = new a(this, view2, m34Var);
        view2.getViewTreeObserver().addOnGlobalLayoutListener(this.f);
    }

    public boolean n(m34 m34Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, m34Var)) == null) {
            ai1 X = wl2.U().X();
            boolean z = (X == null || r(m34Var.f()) || !X.c(m34Var.f(), o())) ? false : true;
            if (z) {
                if (!m34Var.l() || X == null) {
                    return false;
                }
                m(X.getRootView(), m34Var);
            }
            return z;
        }
        return invokeL.booleanValue;
    }

    public final pq2 o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            pq2 pq2Var = new pq2();
            pq2Var.k(true);
            pq2Var.n(-1);
            pq2Var.j(-2);
            return pq2Var;
        }
        return (pq2) invokeV.objValue;
    }

    public final pq2 q(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i)) == null) {
            pq2 pq2Var = new pq2();
            pq2Var.k(true);
            pq2Var.m(i);
            pq2Var.n(-1);
            pq2Var.j(-2);
            return pq2Var;
        }
        return (pq2) invokeI.objValue;
    }

    public final boolean r(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, view2)) == null) {
            ai1 X = wl2.U().X();
            return X != null && X.d(view2);
        }
        return invokeL.booleanValue;
    }

    public boolean s(m34 m34Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, m34Var)) == null) {
            ai1 X = wl2.U().X();
            if (X == null) {
                return false;
            }
            FrameLayout rootView = X.getRootView();
            if (rootView != null && this.f != null) {
                rootView.getViewTreeObserver().removeOnGlobalLayoutListener(this.f);
            }
            m34Var.h();
            this.f = null;
            this.a = -1;
            this.b = -1;
            this.c = -1;
            this.d = false;
            this.e = -1;
            return X.removeView(m34Var.f());
        }
        return invokeL.booleanValue;
    }

    public final boolean t(m34 m34Var, int i, int i2) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(1048582, this, m34Var, i, i2)) == null) {
            ai1 X = wl2.U().X();
            boolean z = X != null && X.a(m34Var.f(), q(i2));
            if (z) {
                m34Var.k(i);
            }
            return z;
        }
        return invokeLII.booleanValue;
    }
}
