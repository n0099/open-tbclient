package com.repackage;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.y32;
import com.tencent.open.miniapp.MiniApp;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public abstract class xv2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public class a implements y32.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ tv2 a;
        public final /* synthetic */ v12 b;
        public final /* synthetic */ xv2 c;

        public a(xv2 xv2Var, tv2 tv2Var, v12 v12Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xv2Var, tv2Var, v12Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = xv2Var;
            this.a = tv2Var;
            this.b = v12Var;
        }

        @Override // com.repackage.y32.b
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                bw2.b("payment fun page, your pkg is latest");
            }
        }

        @Override // com.repackage.y32.b
        public void b(cc3 cc3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cc3Var) == null) {
                this.c.d(this.a, false, this.b);
            }
        }

        @Override // com.repackage.y32.b
        public void onSuccess() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                this.c.d(this.a, true, this.b);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements e32 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ tv2 a;
        public final /* synthetic */ v12 b;
        public final /* synthetic */ xv2 c;

        public b(xv2 xv2Var, tv2 tv2Var, v12 v12Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xv2Var, tv2Var, v12Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = xv2Var;
            this.a = tv2Var;
            this.b = v12Var;
        }

        @Override // com.repackage.e32
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.c.d(this.a, true, this.b);
            }
        }

        @Override // com.repackage.e32
        public void b(int i, cc3 cc3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, cc3Var) == null) {
                this.c.d(this.a, false, this.b);
            }
        }
    }

    public xv2() {
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

    public abstract js1 b(JSONObject jSONObject);

    public final void c(tv2 tv2Var, String str, v12<uv2> v12Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, tv2Var, str, v12Var) == null) {
            bw2.b("local has not main pkg, download fun page main pkg");
            jb4 jb4Var = new jb4(str, i03.J().l());
            jb4Var.q(0L);
            jb4Var.t(tv2Var.c);
            jb4Var.d("3");
            r74.c(jb4Var, new y32(str, new a(this, tv2Var, v12Var)));
        }
    }

    public final void d(tv2 tv2Var, boolean z, v12<uv2> v12Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{tv2Var, Boolean.valueOf(z), v12Var}) == null) {
            if (z) {
                sv2 f = f(tv2Var);
                if (f != null && f.f) {
                    bw2.b("payment fun page, download success, ready to jump");
                    j(f.c, tv2Var);
                    return;
                }
                bw2.b("payment fun page, download success, but not exist");
                uv2 uv2Var = new uv2(tv2Var.f);
                uv2Var.a = tv2Var.e;
                v12Var.a(uv2Var);
                return;
            }
            bw2.b("payment fun page, download failed");
            uv2 uv2Var2 = new uv2(tv2Var.f);
            uv2Var2.a = tv2Var.e;
            v12Var.a(uv2Var2);
        }
    }

    public final void e(tv2 tv2Var, sv2 sv2Var, v12<uv2> v12Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048579, this, tv2Var, sv2Var, v12Var) == null) {
            bw2.b("main pkg is exist, download fun page sub pkg");
            String str = sv2Var.a;
            int i = sv2Var.d;
            r74.h(new mb4(str, i, hw2.e(sv2Var.c, sv2Var.b), 0), new a42(str, String.valueOf(i), new b(this, tv2Var, v12Var)));
        }
    }

    public abstract sv2 f(tv2 tv2Var);

    public abstract String g();

    public abstract String h();

    public final boolean i(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) ? TextUtils.equals(str, MiniApp.MINIAPP_VERSION_DEVELOP) : invokeL.booleanValue;
    }

    public abstract js1 j(String str, tv2 tv2Var);

    public abstract boolean k();

    public final js1 l(tv2 tv2Var, v12<uv2> v12Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048586, this, tv2Var, v12Var)) == null) {
            bw2.b("open fun page start");
            if (tv2Var != null && tv2Var.a()) {
                js1 b2 = b(tv2Var.g);
                if (b2 != null) {
                    bw2.b("fun page args params invalid");
                    return b2;
                } else if (k()) {
                    bw2.b("open payment fun page");
                    sv2 f = f(tv2Var);
                    if (f == null) {
                        return new js1(1001, "fun page not exists");
                    }
                    if (!f.f) {
                        bw2.b("payment fun page, " + tv2Var.d + " mode");
                        if (i(tv2Var.d)) {
                            if (f.e) {
                                e(tv2Var, f, v12Var);
                            } else {
                                return new js1(1001, "fun page not exists");
                            }
                        } else if (f.e) {
                            e(tv2Var, f, v12Var);
                        } else {
                            c(tv2Var, f.a, v12Var);
                        }
                        bw2.b("open fun page end");
                        return new js1(0);
                    }
                    return j(f.c, tv2Var);
                } else {
                    bw2.b("open user info or choose address fun page");
                    return m(tv2Var, v12Var);
                }
            }
            bw2.b("params parse fail");
            return new js1(202, "params parse fail");
        }
        return (js1) invokeLL.objValue;
    }

    public abstract js1 m(tv2 tv2Var, v12<uv2> v12Var);
}
