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
public class l24 {
    public static /* synthetic */ Interceptable $ic;
    public static final int g;
    public static volatile l24 h;
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
        public final /* synthetic */ k24 b;
        public final /* synthetic */ l24 c;

        public a(l24 l24Var, View view2, k24 k24Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {l24Var, view2, k24Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = l24Var;
            this.a = view2;
            this.b = k24Var;
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
                int n = yc3.n(AppRuntime.getAppContext());
                int t = yc3.t();
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
                    this.c.b = i - l24.g;
                    l24 l24Var = this.c;
                    l24Var.a = ((n - i) - t) - l24Var.c;
                    if (this.c.a > 0) {
                        l24 l24Var2 = this.c;
                        if (l24Var2.t(this.b, l24Var2.a, this.c.b)) {
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755580989, "Lcom/repackage/l24;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755580989, "Lcom/repackage/l24;");
                return;
            }
        }
        g = w14.a(42.0f);
        h = null;
    }

    public l24() {
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

    public static l24 p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65550, null)) == null) {
            if (h == null) {
                synchronized (l24.class) {
                    if (h == null) {
                        h = new l24();
                    }
                }
            }
            return h;
        }
        return (l24) invokeV.objValue;
    }

    public final void m(View view2, k24 k24Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, view2, k24Var) == null) || view2 == null || k24Var == null) {
            return;
        }
        this.e = view2.getHeight();
        this.f = new a(this, view2, k24Var);
        view2.getViewTreeObserver().addOnGlobalLayoutListener(this.f);
    }

    public boolean n(k24 k24Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, k24Var)) == null) {
            yg1 X = uk2.U().X();
            boolean z = (X == null || r(k24Var.f()) || !X.c(k24Var.f(), o())) ? false : true;
            if (z) {
                if (!k24Var.l() || X == null) {
                    return false;
                }
                m(X.getRootView(), k24Var);
            }
            return z;
        }
        return invokeL.booleanValue;
    }

    public final np2 o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            np2 np2Var = new np2();
            np2Var.k(true);
            np2Var.n(-1);
            np2Var.j(-2);
            return np2Var;
        }
        return (np2) invokeV.objValue;
    }

    public final np2 q(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i)) == null) {
            np2 np2Var = new np2();
            np2Var.k(true);
            np2Var.m(i);
            np2Var.n(-1);
            np2Var.j(-2);
            return np2Var;
        }
        return (np2) invokeI.objValue;
    }

    public final boolean r(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, view2)) == null) {
            yg1 X = uk2.U().X();
            return X != null && X.d(view2);
        }
        return invokeL.booleanValue;
    }

    public boolean s(k24 k24Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, k24Var)) == null) {
            yg1 X = uk2.U().X();
            if (X == null) {
                return false;
            }
            FrameLayout rootView = X.getRootView();
            if (rootView != null && this.f != null) {
                rootView.getViewTreeObserver().removeOnGlobalLayoutListener(this.f);
            }
            k24Var.h();
            this.f = null;
            this.a = -1;
            this.b = -1;
            this.c = -1;
            this.d = false;
            this.e = -1;
            return X.removeView(k24Var.f());
        }
        return invokeL.booleanValue;
    }

    public final boolean t(k24 k24Var, int i, int i2) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(1048582, this, k24Var, i, i2)) == null) {
            yg1 X = uk2.U().X();
            boolean z = X != null && X.a(k24Var.f(), q(i2));
            if (z) {
                k24Var.k(i);
            }
            return z;
        }
        return invokeLII.booleanValue;
    }
}
