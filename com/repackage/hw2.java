package com.repackage;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public abstract class hw2 extends iw2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public class a implements gh1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ew2 a;
        public final /* synthetic */ g22 b;
        public final /* synthetic */ hw2 c;

        public a(hw2 hw2Var, ew2 ew2Var, g22 g22Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hw2Var, ew2Var, g22Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = hw2Var;
            this.a = ew2Var;
            this.b = g22Var;
        }

        @Override // com.repackage.gh1
        public void onResult(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
                if (i != 0) {
                    fw2 fw2Var = new fw2(this.a.f);
                    fw2Var.a = this.a.e;
                    this.b.a(fw2Var);
                    return;
                }
                this.c.o(this.a, this.b);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements nf3<g63> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ u03 a;
        public final /* synthetic */ SwanAppActivity b;
        public final /* synthetic */ ew2 c;
        public final /* synthetic */ g22 d;
        public final /* synthetic */ hw2 e;

        public b(hw2 hw2Var, u03 u03Var, SwanAppActivity swanAppActivity, ew2 ew2Var, g22 g22Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hw2Var, u03Var, swanAppActivity, ew2Var, g22Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = hw2Var;
            this.a = u03Var;
            this.b = swanAppActivity;
            this.c = ew2Var;
            this.d = g22Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.nf3
        /* renamed from: a */
        public void onCallback(g63 g63Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, g63Var) == null) {
                this.e.p(this.b, this.a.N(), this.c, g63Var, this.d);
            }
        }
    }

    public hw2() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @Override // com.repackage.iw2
    public dw2 f(ew2 ew2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, ew2Var)) == null) {
            return null;
        }
        return (dw2) invokeL.objValue;
    }

    @Override // com.repackage.iw2
    public us1 j(String str, ew2 ew2Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, ew2Var)) == null) ? new us1(0) : (us1) invokeLL.objValue;
    }

    @Override // com.repackage.iw2
    public boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.repackage.iw2
    public us1 m(ew2 ew2Var, g22<fw2> g22Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, ew2Var, g22Var)) == null) {
            if (ew2Var == null || TextUtils.isEmpty(ew2Var.a)) {
                return new us1(1001, "get fun page info, provider appKey is empty");
            }
            if (g22Var == null) {
                return new us1(1001, "get fun page info, cb is null");
            }
            u03 r = t03.J().r();
            SwanAppActivity x = r.x();
            if (x != null && !x.isFinishing()) {
                if (!r.M().e(r)) {
                    r.M().f(x, null, new a(this, ew2Var, g22Var));
                    return new us1(1001, "not login");
                }
                o(ew2Var, g22Var);
                return new us1(0);
            }
            return new us1(1001, "get fun page info, master has dead");
        }
        return (us1) invokeLL.objValue;
    }

    public final void o(ew2 ew2Var, g22<fw2> g22Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, ew2Var, g22Var) == null) {
            mw2.b("start get open data");
            u03 r = t03.J().r();
            SwanAppActivity x = r.x();
            g63.B(x, g(), ew2Var.a, true, h(), new b(this, r, x, ew2Var, g22Var));
        }
    }

    public abstract void p(SwanAppActivity swanAppActivity, String str, ew2 ew2Var, g63 g63Var, g22<fw2> g22Var);
}
