package com.repackage;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public abstract class uv2 extends vv2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public class a implements tg1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ rv2 a;
        public final /* synthetic */ t12 b;
        public final /* synthetic */ uv2 c;

        public a(uv2 uv2Var, rv2 rv2Var, t12 t12Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {uv2Var, rv2Var, t12Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = uv2Var;
            this.a = rv2Var;
            this.b = t12Var;
        }

        @Override // com.repackage.tg1
        public void onResult(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
                if (i != 0) {
                    sv2 sv2Var = new sv2(this.a.f);
                    sv2Var.a = this.a.e;
                    this.b.a(sv2Var);
                    return;
                }
                this.c.o(this.a, this.b);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements af3<t53> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ h03 a;
        public final /* synthetic */ SwanAppActivity b;
        public final /* synthetic */ rv2 c;
        public final /* synthetic */ t12 d;
        public final /* synthetic */ uv2 e;

        public b(uv2 uv2Var, h03 h03Var, SwanAppActivity swanAppActivity, rv2 rv2Var, t12 t12Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {uv2Var, h03Var, swanAppActivity, rv2Var, t12Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = uv2Var;
            this.a = h03Var;
            this.b = swanAppActivity;
            this.c = rv2Var;
            this.d = t12Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.af3
        /* renamed from: b */
        public void a(t53 t53Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, t53Var) == null) {
                this.e.p(this.b, this.a.O(), this.c, t53Var, this.d);
            }
        }
    }

    public uv2() {
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

    @Override // com.repackage.vv2
    public qv2 f(rv2 rv2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, rv2Var)) == null) {
            return null;
        }
        return (qv2) invokeL.objValue;
    }

    @Override // com.repackage.vv2
    public hs1 j(String str, rv2 rv2Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, rv2Var)) == null) ? new hs1(0) : (hs1) invokeLL.objValue;
    }

    @Override // com.repackage.vv2
    public boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.repackage.vv2
    public hs1 m(rv2 rv2Var, t12<sv2> t12Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, rv2Var, t12Var)) == null) {
            if (rv2Var == null || TextUtils.isEmpty(rv2Var.a)) {
                return new hs1(1001, "get fun page info, provider appKey is empty");
            }
            if (t12Var == null) {
                return new hs1(1001, "get fun page info, cb is null");
            }
            h03 q = g03.K().q();
            SwanAppActivity w = q.w();
            if (w != null && !w.isFinishing()) {
                if (!q.N().e(q)) {
                    q.N().f(w, null, new a(this, rv2Var, t12Var));
                    return new hs1(1001, "not login");
                }
                o(rv2Var, t12Var);
                return new hs1(0);
            }
            return new hs1(1001, "get fun page info, master has dead");
        }
        return (hs1) invokeLL.objValue;
    }

    public final void o(rv2 rv2Var, t12<sv2> t12Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, rv2Var, t12Var) == null) {
            zv2.b("start get open data");
            h03 q = g03.K().q();
            SwanAppActivity w = q.w();
            t53.B(w, g(), rv2Var.a, true, h(), new b(this, q, w, rv2Var, t12Var));
        }
    }

    public abstract void p(SwanAppActivity swanAppActivity, String str, rv2 rv2Var, t53 t53Var, t12<sv2> t12Var);
}
