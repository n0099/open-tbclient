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
public abstract class vv2 extends wv2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public class a implements ug1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ sv2 a;
        public final /* synthetic */ u12 b;
        public final /* synthetic */ vv2 c;

        public a(vv2 vv2Var, sv2 sv2Var, u12 u12Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vv2Var, sv2Var, u12Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = vv2Var;
            this.a = sv2Var;
            this.b = u12Var;
        }

        @Override // com.repackage.ug1
        public void onResult(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
                if (i != 0) {
                    tv2 tv2Var = new tv2(this.a.f);
                    tv2Var.a = this.a.e;
                    this.b.a(tv2Var);
                    return;
                }
                this.c.o(this.a, this.b);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements bf3<u53> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ i03 a;
        public final /* synthetic */ SwanAppActivity b;
        public final /* synthetic */ sv2 c;
        public final /* synthetic */ u12 d;
        public final /* synthetic */ vv2 e;

        public b(vv2 vv2Var, i03 i03Var, SwanAppActivity swanAppActivity, sv2 sv2Var, u12 u12Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vv2Var, i03Var, swanAppActivity, sv2Var, u12Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = vv2Var;
            this.a = i03Var;
            this.b = swanAppActivity;
            this.c = sv2Var;
            this.d = u12Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.bf3
        /* renamed from: b */
        public void a(u53 u53Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, u53Var) == null) {
                this.e.p(this.b, this.a.O(), this.c, u53Var, this.d);
            }
        }
    }

    public vv2() {
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

    @Override // com.repackage.wv2
    public rv2 f(sv2 sv2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, sv2Var)) == null) {
            return null;
        }
        return (rv2) invokeL.objValue;
    }

    @Override // com.repackage.wv2
    public is1 j(String str, sv2 sv2Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, sv2Var)) == null) ? new is1(0) : (is1) invokeLL.objValue;
    }

    @Override // com.repackage.wv2
    public boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.repackage.wv2
    public is1 m(sv2 sv2Var, u12<tv2> u12Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, sv2Var, u12Var)) == null) {
            if (sv2Var == null || TextUtils.isEmpty(sv2Var.a)) {
                return new is1(1001, "get fun page info, provider appKey is empty");
            }
            if (u12Var == null) {
                return new is1(1001, "get fun page info, cb is null");
            }
            i03 q = h03.K().q();
            SwanAppActivity w = q.w();
            if (w != null && !w.isFinishing()) {
                if (!q.N().e(q)) {
                    q.N().f(w, null, new a(this, sv2Var, u12Var));
                    return new is1(1001, "not login");
                }
                o(sv2Var, u12Var);
                return new is1(0);
            }
            return new is1(1001, "get fun page info, master has dead");
        }
        return (is1) invokeLL.objValue;
    }

    public final void o(sv2 sv2Var, u12<tv2> u12Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, sv2Var, u12Var) == null) {
            aw2.b("start get open data");
            i03 q = h03.K().q();
            SwanAppActivity w = q.w();
            u53.B(w, g(), sv2Var.a, true, h(), new b(this, q, w, sv2Var, u12Var));
        }
    }

    public abstract void p(SwanAppActivity swanAppActivity, String str, sv2 sv2Var, u53 u53Var, u12<tv2> u12Var);
}
