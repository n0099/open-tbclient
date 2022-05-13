package com.repackage;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.j42;
import com.tencent.open.miniapp.MiniApp;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public abstract class iw2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public class a implements j42.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ew2 a;
        public final /* synthetic */ g22 b;
        public final /* synthetic */ iw2 c;

        public a(iw2 iw2Var, ew2 ew2Var, g22 g22Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iw2Var, ew2Var, g22Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = iw2Var;
            this.a = ew2Var;
            this.b = g22Var;
        }

        @Override // com.repackage.j42.b
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                mw2.b("payment fun page, your pkg is latest");
            }
        }

        @Override // com.repackage.j42.b
        public void b(nc3 nc3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, nc3Var) == null) {
                this.c.d(this.a, false, this.b);
            }
        }

        @Override // com.repackage.j42.b
        public void onSuccess() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                this.c.d(this.a, true, this.b);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements p32 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ew2 a;
        public final /* synthetic */ g22 b;
        public final /* synthetic */ iw2 c;

        public b(iw2 iw2Var, ew2 ew2Var, g22 g22Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iw2Var, ew2Var, g22Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = iw2Var;
            this.a = ew2Var;
            this.b = g22Var;
        }

        @Override // com.repackage.p32
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.c.d(this.a, true, this.b);
            }
        }

        @Override // com.repackage.p32
        public void b(int i, nc3 nc3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, nc3Var) == null) {
                this.c.d(this.a, false, this.b);
            }
        }
    }

    public iw2() {
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

    public abstract us1 b(JSONObject jSONObject);

    public final void c(ew2 ew2Var, String str, g22<fw2> g22Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, ew2Var, str, g22Var) == null) {
            mw2.b("local has not main pkg, download fun page main pkg");
            ub4 ub4Var = new ub4(str, t03.J().l());
            ub4Var.q(0L);
            ub4Var.t(ew2Var.c);
            ub4Var.d("3");
            c84.c(ub4Var, new j42(str, new a(this, ew2Var, g22Var)));
        }
    }

    public final void d(ew2 ew2Var, boolean z, g22<fw2> g22Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{ew2Var, Boolean.valueOf(z), g22Var}) == null) {
            if (z) {
                dw2 f = f(ew2Var);
                if (f != null && f.f) {
                    mw2.b("payment fun page, download success, ready to jump");
                    j(f.c, ew2Var);
                    return;
                }
                mw2.b("payment fun page, download success, but not exist");
                fw2 fw2Var = new fw2(ew2Var.f);
                fw2Var.a = ew2Var.e;
                g22Var.a(fw2Var);
                return;
            }
            mw2.b("payment fun page, download failed");
            fw2 fw2Var2 = new fw2(ew2Var.f);
            fw2Var2.a = ew2Var.e;
            g22Var.a(fw2Var2);
        }
    }

    public final void e(ew2 ew2Var, dw2 dw2Var, g22<fw2> g22Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048579, this, ew2Var, dw2Var, g22Var) == null) {
            mw2.b("main pkg is exist, download fun page sub pkg");
            String str = dw2Var.a;
            int i = dw2Var.d;
            c84.h(new xb4(str, i, sw2.e(dw2Var.c, dw2Var.b), 0), new l42(str, String.valueOf(i), new b(this, ew2Var, g22Var)));
        }
    }

    public abstract dw2 f(ew2 ew2Var);

    public abstract String g();

    public abstract String h();

    public final boolean i(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) ? TextUtils.equals(str, MiniApp.MINIAPP_VERSION_DEVELOP) : invokeL.booleanValue;
    }

    public abstract us1 j(String str, ew2 ew2Var);

    public abstract boolean k();

    public final us1 l(ew2 ew2Var, g22<fw2> g22Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048586, this, ew2Var, g22Var)) == null) {
            mw2.b("open fun page start");
            if (ew2Var != null && ew2Var.a()) {
                us1 b2 = b(ew2Var.g);
                if (b2 != null) {
                    mw2.b("fun page args params invalid");
                    return b2;
                } else if (k()) {
                    mw2.b("open payment fun page");
                    dw2 f = f(ew2Var);
                    if (f == null) {
                        return new us1(1001, "fun page not exists");
                    }
                    if (!f.f) {
                        mw2.b("payment fun page, " + ew2Var.d + " mode");
                        if (i(ew2Var.d)) {
                            if (f.e) {
                                e(ew2Var, f, g22Var);
                            } else {
                                return new us1(1001, "fun page not exists");
                            }
                        } else if (f.e) {
                            e(ew2Var, f, g22Var);
                        } else {
                            c(ew2Var, f.a, g22Var);
                        }
                        mw2.b("open fun page end");
                        return new us1(0);
                    }
                    return j(f.c, ew2Var);
                } else {
                    mw2.b("open user info or choose address fun page");
                    return m(ew2Var, g22Var);
                }
            }
            mw2.b("params parse fail");
            return new us1(202, "params parse fail");
        }
        return (us1) invokeLL.objValue;
    }

    public abstract us1 m(ew2 ew2Var, g22<fw2> g22Var);
}
