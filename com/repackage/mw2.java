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
public abstract class mw2 extends nw2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public class a implements lh1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ jw2 a;
        public final /* synthetic */ l22 b;
        public final /* synthetic */ mw2 c;

        public a(mw2 mw2Var, jw2 jw2Var, l22 l22Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mw2Var, jw2Var, l22Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = mw2Var;
            this.a = jw2Var;
            this.b = l22Var;
        }

        @Override // com.repackage.lh1
        public void onResult(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
                if (i != 0) {
                    kw2 kw2Var = new kw2(this.a.f);
                    kw2Var.a = this.a.e;
                    this.b.a(kw2Var);
                    return;
                }
                this.c.o(this.a, this.b);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements sf3<l63> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ z03 a;
        public final /* synthetic */ SwanAppActivity b;
        public final /* synthetic */ jw2 c;
        public final /* synthetic */ l22 d;
        public final /* synthetic */ mw2 e;

        public b(mw2 mw2Var, z03 z03Var, SwanAppActivity swanAppActivity, jw2 jw2Var, l22 l22Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mw2Var, z03Var, swanAppActivity, jw2Var, l22Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = mw2Var;
            this.a = z03Var;
            this.b = swanAppActivity;
            this.c = jw2Var;
            this.d = l22Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.sf3
        /* renamed from: b */
        public void a(l63 l63Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, l63Var) == null) {
                this.e.p(this.b, this.a.O(), this.c, l63Var, this.d);
            }
        }
    }

    public mw2() {
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

    @Override // com.repackage.nw2
    public iw2 f(jw2 jw2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, jw2Var)) == null) {
            return null;
        }
        return (iw2) invokeL.objValue;
    }

    @Override // com.repackage.nw2
    public zs1 j(String str, jw2 jw2Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, jw2Var)) == null) ? new zs1(0) : (zs1) invokeLL.objValue;
    }

    @Override // com.repackage.nw2
    public boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.repackage.nw2
    public zs1 m(jw2 jw2Var, l22<kw2> l22Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, jw2Var, l22Var)) == null) {
            if (jw2Var == null || TextUtils.isEmpty(jw2Var.a)) {
                return new zs1(1001, "get fun page info, provider appKey is empty");
            }
            if (l22Var == null) {
                return new zs1(1001, "get fun page info, cb is null");
            }
            z03 q = y03.K().q();
            SwanAppActivity w = q.w();
            if (w != null && !w.isFinishing()) {
                if (!q.N().e(q)) {
                    q.N().f(w, null, new a(this, jw2Var, l22Var));
                    return new zs1(1001, "not login");
                }
                o(jw2Var, l22Var);
                return new zs1(0);
            }
            return new zs1(1001, "get fun page info, master has dead");
        }
        return (zs1) invokeLL.objValue;
    }

    public final void o(jw2 jw2Var, l22<kw2> l22Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, jw2Var, l22Var) == null) {
            rw2.b("start get open data");
            z03 q = y03.K().q();
            SwanAppActivity w = q.w();
            l63.B(w, g(), jw2Var.a, true, h(), new b(this, q, w, jw2Var, l22Var));
        }
    }

    public abstract void p(SwanAppActivity swanAppActivity, String str, jw2 jw2Var, l63 l63Var, l22<kw2> l22Var);
}
