package com.repackage;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.x32;
import com.tencent.open.miniapp.MiniApp;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public abstract class wv2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public class a implements x32.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ sv2 a;
        public final /* synthetic */ u12 b;
        public final /* synthetic */ wv2 c;

        public a(wv2 wv2Var, sv2 sv2Var, u12 u12Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wv2Var, sv2Var, u12Var};
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
            this.a = sv2Var;
            this.b = u12Var;
        }

        @Override // com.repackage.x32.b
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                aw2.b("payment fun page, your pkg is latest");
            }
        }

        @Override // com.repackage.x32.b
        public void b(bc3 bc3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bc3Var) == null) {
                this.c.d(this.a, false, this.b);
            }
        }

        @Override // com.repackage.x32.b
        public void onSuccess() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                this.c.d(this.a, true, this.b);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements d32 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ sv2 a;
        public final /* synthetic */ u12 b;
        public final /* synthetic */ wv2 c;

        public b(wv2 wv2Var, sv2 sv2Var, u12 u12Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wv2Var, sv2Var, u12Var};
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
            this.a = sv2Var;
            this.b = u12Var;
        }

        @Override // com.repackage.d32
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.c.d(this.a, true, this.b);
            }
        }

        @Override // com.repackage.d32
        public void b(int i, bc3 bc3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, bc3Var) == null) {
                this.c.d(this.a, false, this.b);
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

    public abstract is1 b(JSONObject jSONObject);

    public final void c(sv2 sv2Var, String str, u12<tv2> u12Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, sv2Var, str, u12Var) == null) {
            aw2.b("local has not main pkg, download fun page main pkg");
            ib4 ib4Var = new ib4(str, h03.K().k());
            ib4Var.q(0L);
            ib4Var.t(sv2Var.c);
            ib4Var.d("3");
            q74.c(ib4Var, new x32(str, new a(this, sv2Var, u12Var)));
        }
    }

    public final void d(sv2 sv2Var, boolean z, u12<tv2> u12Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{sv2Var, Boolean.valueOf(z), u12Var}) == null) {
            if (z) {
                rv2 f = f(sv2Var);
                if (f != null && f.f) {
                    aw2.b("payment fun page, download success, ready to jump");
                    j(f.c, sv2Var);
                    return;
                }
                aw2.b("payment fun page, download success, but not exist");
                tv2 tv2Var = new tv2(sv2Var.f);
                tv2Var.a = sv2Var.e;
                u12Var.a(tv2Var);
                return;
            }
            aw2.b("payment fun page, download failed");
            tv2 tv2Var2 = new tv2(sv2Var.f);
            tv2Var2.a = sv2Var.e;
            u12Var.a(tv2Var2);
        }
    }

    public final void e(sv2 sv2Var, rv2 rv2Var, u12<tv2> u12Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048579, this, sv2Var, rv2Var, u12Var) == null) {
            aw2.b("main pkg is exist, download fun page sub pkg");
            String str = rv2Var.a;
            int i = rv2Var.d;
            q74.h(new lb4(str, i, gw2.e(rv2Var.c, rv2Var.b), 0), new z32(str, String.valueOf(i), new b(this, sv2Var, u12Var)));
        }
    }

    public abstract rv2 f(sv2 sv2Var);

    public abstract String g();

    public abstract String h();

    public final boolean i(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) ? TextUtils.equals(str, MiniApp.MINIAPP_VERSION_DEVELOP) : invokeL.booleanValue;
    }

    public abstract is1 j(String str, sv2 sv2Var);

    public abstract boolean k();

    public final is1 l(sv2 sv2Var, u12<tv2> u12Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048586, this, sv2Var, u12Var)) == null) {
            aw2.b("open fun page start");
            if (sv2Var != null && sv2Var.a()) {
                is1 b2 = b(sv2Var.g);
                if (b2 != null) {
                    aw2.b("fun page args params invalid");
                    return b2;
                } else if (k()) {
                    aw2.b("open payment fun page");
                    rv2 f = f(sv2Var);
                    if (f == null) {
                        return new is1(1001, "fun page not exists");
                    }
                    if (!f.f) {
                        aw2.b("payment fun page, " + sv2Var.d + " mode");
                        if (i(sv2Var.d)) {
                            if (f.e) {
                                e(sv2Var, f, u12Var);
                            } else {
                                return new is1(1001, "fun page not exists");
                            }
                        } else if (f.e) {
                            e(sv2Var, f, u12Var);
                        } else {
                            c(sv2Var, f.a, u12Var);
                        }
                        aw2.b("open fun page end");
                        return new is1(0);
                    }
                    return j(f.c, sv2Var);
                } else {
                    aw2.b("open user info or choose address fun page");
                    return m(sv2Var, u12Var);
                }
            }
            aw2.b("params parse fail");
            return new is1(202, "params parse fail");
        }
        return (is1) invokeLL.objValue;
    }

    public abstract is1 m(sv2 sv2Var, u12<tv2> u12Var);
}
