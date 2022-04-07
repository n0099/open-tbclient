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
public abstract class wv2 extends xv2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public class a implements vg1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ tv2 a;
        public final /* synthetic */ v12 b;
        public final /* synthetic */ wv2 c;

        public a(wv2 wv2Var, tv2 tv2Var, v12 v12Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wv2Var, tv2Var, v12Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = wv2Var;
            this.a = tv2Var;
            this.b = v12Var;
        }

        @Override // com.repackage.vg1
        public void onResult(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
                if (i != 0) {
                    uv2 uv2Var = new uv2(this.a.f);
                    uv2Var.a = this.a.e;
                    this.b.a(uv2Var);
                    return;
                }
                this.c.o(this.a, this.b);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements cf3<v53> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ j03 a;
        public final /* synthetic */ SwanAppActivity b;
        public final /* synthetic */ tv2 c;
        public final /* synthetic */ v12 d;
        public final /* synthetic */ wv2 e;

        public b(wv2 wv2Var, j03 j03Var, SwanAppActivity swanAppActivity, tv2 tv2Var, v12 v12Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wv2Var, j03Var, swanAppActivity, tv2Var, v12Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = wv2Var;
            this.a = j03Var;
            this.b = swanAppActivity;
            this.c = tv2Var;
            this.d = v12Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.cf3
        /* renamed from: a */
        public void onCallback(v53 v53Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, v53Var) == null) {
                this.e.p(this.b, this.a.N(), this.c, v53Var, this.d);
            }
        }
    }

    public wv2() {
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

    @Override // com.repackage.xv2
    public sv2 f(tv2 tv2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, tv2Var)) == null) {
            return null;
        }
        return (sv2) invokeL.objValue;
    }

    @Override // com.repackage.xv2
    public js1 j(String str, tv2 tv2Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, tv2Var)) == null) ? new js1(0) : (js1) invokeLL.objValue;
    }

    @Override // com.repackage.xv2
    public boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.repackage.xv2
    public js1 m(tv2 tv2Var, v12<uv2> v12Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, tv2Var, v12Var)) == null) {
            if (tv2Var == null || TextUtils.isEmpty(tv2Var.a)) {
                return new js1(1001, "get fun page info, provider appKey is empty");
            }
            if (v12Var == null) {
                return new js1(1001, "get fun page info, cb is null");
            }
            j03 r = i03.J().r();
            SwanAppActivity x = r.x();
            if (x != null && !x.isFinishing()) {
                if (!r.M().e(r)) {
                    r.M().f(x, null, new a(this, tv2Var, v12Var));
                    return new js1(1001, "not login");
                }
                o(tv2Var, v12Var);
                return new js1(0);
            }
            return new js1(1001, "get fun page info, master has dead");
        }
        return (js1) invokeLL.objValue;
    }

    public final void o(tv2 tv2Var, v12<uv2> v12Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, tv2Var, v12Var) == null) {
            bw2.b("start get open data");
            j03 r = i03.J().r();
            SwanAppActivity x = r.x();
            v53.B(x, g(), tv2Var.a, true, h(), new b(this, r, x, tv2Var, v12Var));
        }
    }

    public abstract void p(SwanAppActivity swanAppActivity, String str, tv2 tv2Var, v53 v53Var, v12<uv2> v12Var);
}
