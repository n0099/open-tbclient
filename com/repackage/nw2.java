package com.repackage;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.o42;
import com.tencent.open.miniapp.MiniApp;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public abstract class nw2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public class a implements o42.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ jw2 a;
        public final /* synthetic */ l22 b;
        public final /* synthetic */ nw2 c;

        public a(nw2 nw2Var, jw2 jw2Var, l22 l22Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nw2Var, jw2Var, l22Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = nw2Var;
            this.a = jw2Var;
            this.b = l22Var;
        }

        @Override // com.repackage.o42.b
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                rw2.b("payment fun page, your pkg is latest");
            }
        }

        @Override // com.repackage.o42.b
        public void b(sc3 sc3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, sc3Var) == null) {
                this.c.d(this.a, false, this.b);
            }
        }

        @Override // com.repackage.o42.b
        public void onSuccess() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                this.c.d(this.a, true, this.b);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements u32 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ jw2 a;
        public final /* synthetic */ l22 b;
        public final /* synthetic */ nw2 c;

        public b(nw2 nw2Var, jw2 jw2Var, l22 l22Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nw2Var, jw2Var, l22Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = nw2Var;
            this.a = jw2Var;
            this.b = l22Var;
        }

        @Override // com.repackage.u32
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.c.d(this.a, true, this.b);
            }
        }

        @Override // com.repackage.u32
        public void b(int i, sc3 sc3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, sc3Var) == null) {
                this.c.d(this.a, false, this.b);
            }
        }
    }

    public nw2() {
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

    public abstract zs1 b(JSONObject jSONObject);

    public final void c(jw2 jw2Var, String str, l22<kw2> l22Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jw2Var, str, l22Var) == null) {
            rw2.b("local has not main pkg, download fun page main pkg");
            zb4 zb4Var = new zb4(str, y03.K().k());
            zb4Var.q(0L);
            zb4Var.t(jw2Var.c);
            zb4Var.d("3");
            h84.c(zb4Var, new o42(str, new a(this, jw2Var, l22Var)));
        }
    }

    public final void d(jw2 jw2Var, boolean z, l22<kw2> l22Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{jw2Var, Boolean.valueOf(z), l22Var}) == null) {
            if (z) {
                iw2 f = f(jw2Var);
                if (f != null && f.f) {
                    rw2.b("payment fun page, download success, ready to jump");
                    j(f.c, jw2Var);
                    return;
                }
                rw2.b("payment fun page, download success, but not exist");
                kw2 kw2Var = new kw2(jw2Var.f);
                kw2Var.a = jw2Var.e;
                l22Var.a(kw2Var);
                return;
            }
            rw2.b("payment fun page, download failed");
            kw2 kw2Var2 = new kw2(jw2Var.f);
            kw2Var2.a = jw2Var.e;
            l22Var.a(kw2Var2);
        }
    }

    public final void e(jw2 jw2Var, iw2 iw2Var, l22<kw2> l22Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048579, this, jw2Var, iw2Var, l22Var) == null) {
            rw2.b("main pkg is exist, download fun page sub pkg");
            String str = iw2Var.a;
            int i = iw2Var.d;
            h84.h(new cc4(str, i, xw2.e(iw2Var.c, iw2Var.b), 0), new q42(str, String.valueOf(i), new b(this, jw2Var, l22Var)));
        }
    }

    public abstract iw2 f(jw2 jw2Var);

    public abstract String g();

    public abstract String h();

    public final boolean i(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) ? TextUtils.equals(str, MiniApp.MINIAPP_VERSION_DEVELOP) : invokeL.booleanValue;
    }

    public abstract zs1 j(String str, jw2 jw2Var);

    public abstract boolean k();

    public final zs1 l(jw2 jw2Var, l22<kw2> l22Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048586, this, jw2Var, l22Var)) == null) {
            rw2.b("open fun page start");
            if (jw2Var != null && jw2Var.a()) {
                zs1 b2 = b(jw2Var.g);
                if (b2 != null) {
                    rw2.b("fun page args params invalid");
                    return b2;
                } else if (k()) {
                    rw2.b("open payment fun page");
                    iw2 f = f(jw2Var);
                    if (f == null) {
                        return new zs1(1001, "fun page not exists");
                    }
                    if (!f.f) {
                        rw2.b("payment fun page, " + jw2Var.d + " mode");
                        if (i(jw2Var.d)) {
                            if (f.e) {
                                e(jw2Var, f, l22Var);
                            } else {
                                return new zs1(1001, "fun page not exists");
                            }
                        } else if (f.e) {
                            e(jw2Var, f, l22Var);
                        } else {
                            c(jw2Var, f.a, l22Var);
                        }
                        rw2.b("open fun page end");
                        return new zs1(0);
                    }
                    return j(f.c, jw2Var);
                } else {
                    rw2.b("open user info or choose address fun page");
                    return m(jw2Var, l22Var);
                }
            }
            rw2.b("params parse fail");
            return new zs1(202, "params parse fail");
        }
        return (zs1) invokeLL.objValue;
    }

    public abstract zs1 m(jw2 jw2Var, l22<kw2> l22Var);
}
