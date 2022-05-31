package com.repackage;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.w22;
import com.tencent.open.miniapp.MiniApp;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public abstract class vu2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public class a implements w22.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ru2 a;
        public final /* synthetic */ t02 b;
        public final /* synthetic */ vu2 c;

        public a(vu2 vu2Var, ru2 ru2Var, t02 t02Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vu2Var, ru2Var, t02Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = vu2Var;
            this.a = ru2Var;
            this.b = t02Var;
        }

        @Override // com.repackage.w22.b
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                zu2.b("payment fun page, your pkg is latest");
            }
        }

        @Override // com.repackage.w22.b
        public void b(ab3 ab3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, ab3Var) == null) {
                this.c.d(this.a, false, this.b);
            }
        }

        @Override // com.repackage.w22.b
        public void onSuccess() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                this.c.d(this.a, true, this.b);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements c22 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ru2 a;
        public final /* synthetic */ t02 b;
        public final /* synthetic */ vu2 c;

        public b(vu2 vu2Var, ru2 ru2Var, t02 t02Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vu2Var, ru2Var, t02Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = vu2Var;
            this.a = ru2Var;
            this.b = t02Var;
        }

        @Override // com.repackage.c22
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.c.d(this.a, true, this.b);
            }
        }

        @Override // com.repackage.c22
        public void b(int i, ab3 ab3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, ab3Var) == null) {
                this.c.d(this.a, false, this.b);
            }
        }
    }

    public vu2() {
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

    public abstract hr1 b(JSONObject jSONObject);

    public final void c(ru2 ru2Var, String str, t02<su2> t02Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, ru2Var, str, t02Var) == null) {
            zu2.b("local has not main pkg, download fun page main pkg");
            ha4 ha4Var = new ha4(str, gz2.J().l());
            ha4Var.q(0L);
            ha4Var.t(ru2Var.c);
            ha4Var.d("3");
            p64.c(ha4Var, new w22(str, new a(this, ru2Var, t02Var)));
        }
    }

    public final void d(ru2 ru2Var, boolean z, t02<su2> t02Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{ru2Var, Boolean.valueOf(z), t02Var}) == null) {
            if (z) {
                qu2 f = f(ru2Var);
                if (f != null && f.f) {
                    zu2.b("payment fun page, download success, ready to jump");
                    j(f.c, ru2Var);
                    return;
                }
                zu2.b("payment fun page, download success, but not exist");
                su2 su2Var = new su2(ru2Var.f);
                su2Var.a = ru2Var.e;
                t02Var.a(su2Var);
                return;
            }
            zu2.b("payment fun page, download failed");
            su2 su2Var2 = new su2(ru2Var.f);
            su2Var2.a = ru2Var.e;
            t02Var.a(su2Var2);
        }
    }

    public final void e(ru2 ru2Var, qu2 qu2Var, t02<su2> t02Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048579, this, ru2Var, qu2Var, t02Var) == null) {
            zu2.b("main pkg is exist, download fun page sub pkg");
            String str = qu2Var.a;
            int i = qu2Var.d;
            p64.h(new ka4(str, i, fv2.e(qu2Var.c, qu2Var.b), 0), new y22(str, String.valueOf(i), new b(this, ru2Var, t02Var)));
        }
    }

    public abstract qu2 f(ru2 ru2Var);

    public abstract String g();

    public abstract String h();

    public final boolean i(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) ? TextUtils.equals(str, MiniApp.MINIAPP_VERSION_DEVELOP) : invokeL.booleanValue;
    }

    public abstract hr1 j(String str, ru2 ru2Var);

    public abstract boolean k();

    public final hr1 l(ru2 ru2Var, t02<su2> t02Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048586, this, ru2Var, t02Var)) == null) {
            zu2.b("open fun page start");
            if (ru2Var != null && ru2Var.a()) {
                hr1 b2 = b(ru2Var.g);
                if (b2 != null) {
                    zu2.b("fun page args params invalid");
                    return b2;
                } else if (k()) {
                    zu2.b("open payment fun page");
                    qu2 f = f(ru2Var);
                    if (f == null) {
                        return new hr1(1001, "fun page not exists");
                    }
                    if (!f.f) {
                        zu2.b("payment fun page, " + ru2Var.d + " mode");
                        if (i(ru2Var.d)) {
                            if (f.e) {
                                e(ru2Var, f, t02Var);
                            } else {
                                return new hr1(1001, "fun page not exists");
                            }
                        } else if (f.e) {
                            e(ru2Var, f, t02Var);
                        } else {
                            c(ru2Var, f.a, t02Var);
                        }
                        zu2.b("open fun page end");
                        return new hr1(0);
                    }
                    return j(f.c, ru2Var);
                } else {
                    zu2.b("open user info or choose address fun page");
                    return m(ru2Var, t02Var);
                }
            }
            zu2.b("params parse fail");
            return new hr1(202, "params parse fail");
        }
        return (hr1) invokeLL.objValue;
    }

    public abstract hr1 m(ru2 ru2Var, t02<su2> t02Var);
}
