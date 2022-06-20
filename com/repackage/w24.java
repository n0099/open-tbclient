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
/* loaded from: classes7.dex */
public class w24 {
    public static /* synthetic */ Interceptable $ic;
    public static final int g;
    public static volatile w24 h;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public int b;
    public int c;
    public boolean d;
    public int e;
    public ViewTreeObserver.OnGlobalLayoutListener f;

    /* loaded from: classes7.dex */
    public class a implements ViewTreeObserver.OnGlobalLayoutListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ View a;
        public final /* synthetic */ v24 b;
        public final /* synthetic */ w24 c;

        public a(w24 w24Var, View view2, v24 v24Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {w24Var, view2, v24Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = w24Var;
            this.a = view2;
            this.b = v24Var;
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
                int n = jd3.n(AppRuntime.getAppContext());
                int t = jd3.t();
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
                    this.c.b = i - w24.g;
                    w24 w24Var = this.c;
                    w24Var.a = ((n - i) - t) - w24Var.c;
                    if (this.c.a > 0) {
                        w24 w24Var2 = this.c;
                        if (w24Var2.t(this.b, w24Var2.a, this.c.b)) {
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755253288, "Lcom/repackage/w24;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755253288, "Lcom/repackage/w24;");
                return;
            }
        }
        g = h24.a(42.0f);
        h = null;
    }

    public w24() {
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

    public static w24 p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65550, null)) == null) {
            if (h == null) {
                synchronized (w24.class) {
                    if (h == null) {
                        h = new w24();
                    }
                }
            }
            return h;
        }
        return (w24) invokeV.objValue;
    }

    public final void m(View view2, v24 v24Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, view2, v24Var) == null) || view2 == null || v24Var == null) {
            return;
        }
        this.e = view2.getHeight();
        this.f = new a(this, view2, v24Var);
        view2.getViewTreeObserver().addOnGlobalLayoutListener(this.f);
    }

    public boolean n(v24 v24Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, v24Var)) == null) {
            jh1 X = fl2.U().X();
            boolean z = (X == null || r(v24Var.f()) || !X.c(v24Var.f(), o())) ? false : true;
            if (z) {
                if (!v24Var.l() || X == null) {
                    return false;
                }
                m(X.getRootView(), v24Var);
            }
            return z;
        }
        return invokeL.booleanValue;
    }

    public final yp2 o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            yp2 yp2Var = new yp2();
            yp2Var.k(true);
            yp2Var.n(-1);
            yp2Var.j(-2);
            return yp2Var;
        }
        return (yp2) invokeV.objValue;
    }

    public final yp2 q(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i)) == null) {
            yp2 yp2Var = new yp2();
            yp2Var.k(true);
            yp2Var.m(i);
            yp2Var.n(-1);
            yp2Var.j(-2);
            return yp2Var;
        }
        return (yp2) invokeI.objValue;
    }

    public final boolean r(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, view2)) == null) {
            jh1 X = fl2.U().X();
            return X != null && X.d(view2);
        }
        return invokeL.booleanValue;
    }

    public boolean s(v24 v24Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, v24Var)) == null) {
            jh1 X = fl2.U().X();
            if (X == null) {
                return false;
            }
            FrameLayout rootView = X.getRootView();
            if (rootView != null && this.f != null) {
                rootView.getViewTreeObserver().removeOnGlobalLayoutListener(this.f);
            }
            v24Var.h();
            this.f = null;
            this.a = -1;
            this.b = -1;
            this.c = -1;
            this.d = false;
            this.e = -1;
            return X.removeView(v24Var.f());
        }
        return invokeL.booleanValue;
    }

    public final boolean t(v24 v24Var, int i, int i2) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(1048582, this, v24Var, i, i2)) == null) {
            jh1 X = fl2.U().X();
            boolean z = X != null && X.a(v24Var.f(), q(i2));
            if (z) {
                v24Var.k(i);
            }
            return z;
        }
        return invokeLII.booleanValue;
    }
}
