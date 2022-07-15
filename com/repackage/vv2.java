package com.repackage;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.w32;
import com.tencent.open.miniapp.MiniApp;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public abstract class vv2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public class a implements w32.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ rv2 a;
        public final /* synthetic */ t12 b;
        public final /* synthetic */ vv2 c;

        public a(vv2 vv2Var, rv2 rv2Var, t12 t12Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vv2Var, rv2Var, t12Var};
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
            this.a = rv2Var;
            this.b = t12Var;
        }

        @Override // com.repackage.w32.b
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                zv2.b("payment fun page, your pkg is latest");
            }
        }

        @Override // com.repackage.w32.b
        public void b(ac3 ac3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, ac3Var) == null) {
                this.c.d(this.a, false, this.b);
            }
        }

        @Override // com.repackage.w32.b
        public void onSuccess() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                this.c.d(this.a, true, this.b);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements c32 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ rv2 a;
        public final /* synthetic */ t12 b;
        public final /* synthetic */ vv2 c;

        public b(vv2 vv2Var, rv2 rv2Var, t12 t12Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vv2Var, rv2Var, t12Var};
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
            this.a = rv2Var;
            this.b = t12Var;
        }

        @Override // com.repackage.c32
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.c.d(this.a, true, this.b);
            }
        }

        @Override // com.repackage.c32
        public void b(int i, ac3 ac3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, ac3Var) == null) {
                this.c.d(this.a, false, this.b);
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

    public abstract hs1 b(JSONObject jSONObject);

    public final void c(rv2 rv2Var, String str, t12<sv2> t12Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, rv2Var, str, t12Var) == null) {
            zv2.b("local has not main pkg, download fun page main pkg");
            hb4 hb4Var = new hb4(str, g03.K().k());
            hb4Var.q(0L);
            hb4Var.t(rv2Var.c);
            hb4Var.d("3");
            p74.c(hb4Var, new w32(str, new a(this, rv2Var, t12Var)));
        }
    }

    public final void d(rv2 rv2Var, boolean z, t12<sv2> t12Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{rv2Var, Boolean.valueOf(z), t12Var}) == null) {
            if (z) {
                qv2 f = f(rv2Var);
                if (f != null && f.f) {
                    zv2.b("payment fun page, download success, ready to jump");
                    j(f.c, rv2Var);
                    return;
                }
                zv2.b("payment fun page, download success, but not exist");
                sv2 sv2Var = new sv2(rv2Var.f);
                sv2Var.a = rv2Var.e;
                t12Var.a(sv2Var);
                return;
            }
            zv2.b("payment fun page, download failed");
            sv2 sv2Var2 = new sv2(rv2Var.f);
            sv2Var2.a = rv2Var.e;
            t12Var.a(sv2Var2);
        }
    }

    public final void e(rv2 rv2Var, qv2 qv2Var, t12<sv2> t12Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048579, this, rv2Var, qv2Var, t12Var) == null) {
            zv2.b("main pkg is exist, download fun page sub pkg");
            String str = qv2Var.a;
            int i = qv2Var.d;
            p74.h(new kb4(str, i, fw2.e(qv2Var.c, qv2Var.b), 0), new y32(str, String.valueOf(i), new b(this, rv2Var, t12Var)));
        }
    }

    public abstract qv2 f(rv2 rv2Var);

    public abstract String g();

    public abstract String h();

    public final boolean i(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) ? TextUtils.equals(str, MiniApp.MINIAPP_VERSION_DEVELOP) : invokeL.booleanValue;
    }

    public abstract hs1 j(String str, rv2 rv2Var);

    public abstract boolean k();

    public final hs1 l(rv2 rv2Var, t12<sv2> t12Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048586, this, rv2Var, t12Var)) == null) {
            zv2.b("open fun page start");
            if (rv2Var != null && rv2Var.a()) {
                hs1 b2 = b(rv2Var.g);
                if (b2 != null) {
                    zv2.b("fun page args params invalid");
                    return b2;
                } else if (k()) {
                    zv2.b("open payment fun page");
                    qv2 f = f(rv2Var);
                    if (f == null) {
                        return new hs1(1001, "fun page not exists");
                    }
                    if (!f.f) {
                        zv2.b("payment fun page, " + rv2Var.d + " mode");
                        if (i(rv2Var.d)) {
                            if (f.e) {
                                e(rv2Var, f, t12Var);
                            } else {
                                return new hs1(1001, "fun page not exists");
                            }
                        } else if (f.e) {
                            e(rv2Var, f, t12Var);
                        } else {
                            c(rv2Var, f.a, t12Var);
                        }
                        zv2.b("open fun page end");
                        return new hs1(0);
                    }
                    return j(f.c, rv2Var);
                } else {
                    zv2.b("open user info or choose address fun page");
                    return m(rv2Var, t12Var);
                }
            }
            zv2.b("params parse fail");
            return new hs1(202, "params parse fail");
        }
        return (hs1) invokeLL.objValue;
    }

    public abstract hs1 m(rv2 rv2Var, t12<sv2> t12Var);
}
