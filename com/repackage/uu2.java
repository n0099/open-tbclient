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
public abstract class uu2 extends vu2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public class a implements tf1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ru2 a;
        public final /* synthetic */ t02 b;
        public final /* synthetic */ uu2 c;

        public a(uu2 uu2Var, ru2 ru2Var, t02 t02Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {uu2Var, ru2Var, t02Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = uu2Var;
            this.a = ru2Var;
            this.b = t02Var;
        }

        @Override // com.repackage.tf1
        public void onResult(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
                if (i != 0) {
                    su2 su2Var = new su2(this.a.f);
                    su2Var.a = this.a.e;
                    this.b.a(su2Var);
                    return;
                }
                this.c.o(this.a, this.b);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements ae3<t43> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ hz2 a;
        public final /* synthetic */ SwanAppActivity b;
        public final /* synthetic */ ru2 c;
        public final /* synthetic */ t02 d;
        public final /* synthetic */ uu2 e;

        public b(uu2 uu2Var, hz2 hz2Var, SwanAppActivity swanAppActivity, ru2 ru2Var, t02 t02Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {uu2Var, hz2Var, swanAppActivity, ru2Var, t02Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = uu2Var;
            this.a = hz2Var;
            this.b = swanAppActivity;
            this.c = ru2Var;
            this.d = t02Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.ae3
        /* renamed from: a */
        public void onCallback(t43 t43Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, t43Var) == null) {
                this.e.p(this.b, this.a.N(), this.c, t43Var, this.d);
            }
        }
    }

    public uu2() {
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

    @Override // com.repackage.vu2
    public qu2 f(ru2 ru2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, ru2Var)) == null) {
            return null;
        }
        return (qu2) invokeL.objValue;
    }

    @Override // com.repackage.vu2
    public hr1 j(String str, ru2 ru2Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, ru2Var)) == null) ? new hr1(0) : (hr1) invokeLL.objValue;
    }

    @Override // com.repackage.vu2
    public boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.repackage.vu2
    public hr1 m(ru2 ru2Var, t02<su2> t02Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, ru2Var, t02Var)) == null) {
            if (ru2Var == null || TextUtils.isEmpty(ru2Var.a)) {
                return new hr1(1001, "get fun page info, provider appKey is empty");
            }
            if (t02Var == null) {
                return new hr1(1001, "get fun page info, cb is null");
            }
            hz2 r = gz2.J().r();
            SwanAppActivity x = r.x();
            if (x != null && !x.isFinishing()) {
                if (!r.M().e(r)) {
                    r.M().f(x, null, new a(this, ru2Var, t02Var));
                    return new hr1(1001, "not login");
                }
                o(ru2Var, t02Var);
                return new hr1(0);
            }
            return new hr1(1001, "get fun page info, master has dead");
        }
        return (hr1) invokeLL.objValue;
    }

    public final void o(ru2 ru2Var, t02<su2> t02Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, ru2Var, t02Var) == null) {
            zu2.b("start get open data");
            hz2 r = gz2.J().r();
            SwanAppActivity x = r.x();
            t43.B(x, g(), ru2Var.a, true, h(), new b(this, r, x, ru2Var, t02Var));
        }
    }

    public abstract void p(SwanAppActivity swanAppActivity, String str, ru2 ru2Var, t43 t43Var, t02<su2> t02Var);
}
