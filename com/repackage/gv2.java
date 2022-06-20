package com.repackage;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.h32;
import com.tencent.open.miniapp.MiniApp;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public abstract class gv2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public class a implements h32.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ cv2 a;
        public final /* synthetic */ e12 b;
        public final /* synthetic */ gv2 c;

        public a(gv2 gv2Var, cv2 cv2Var, e12 e12Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gv2Var, cv2Var, e12Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = gv2Var;
            this.a = cv2Var;
            this.b = e12Var;
        }

        @Override // com.repackage.h32.b
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                kv2.b("payment fun page, your pkg is latest");
            }
        }

        @Override // com.repackage.h32.b
        public void b(lb3 lb3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, lb3Var) == null) {
                this.c.d(this.a, false, this.b);
            }
        }

        @Override // com.repackage.h32.b
        public void onSuccess() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                this.c.d(this.a, true, this.b);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements n22 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ cv2 a;
        public final /* synthetic */ e12 b;
        public final /* synthetic */ gv2 c;

        public b(gv2 gv2Var, cv2 cv2Var, e12 e12Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gv2Var, cv2Var, e12Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = gv2Var;
            this.a = cv2Var;
            this.b = e12Var;
        }

        @Override // com.repackage.n22
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.c.d(this.a, true, this.b);
            }
        }

        @Override // com.repackage.n22
        public void b(int i, lb3 lb3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, lb3Var) == null) {
                this.c.d(this.a, false, this.b);
            }
        }
    }

    public gv2() {
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

    public abstract sr1 b(JSONObject jSONObject);

    public final void c(cv2 cv2Var, String str, e12<dv2> e12Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cv2Var, str, e12Var) == null) {
            kv2.b("local has not main pkg, download fun page main pkg");
            sa4 sa4Var = new sa4(str, rz2.K().l());
            sa4Var.q(0L);
            sa4Var.t(cv2Var.c);
            sa4Var.d("3");
            a74.c(sa4Var, new h32(str, new a(this, cv2Var, e12Var)));
        }
    }

    public final void d(cv2 cv2Var, boolean z, e12<dv2> e12Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{cv2Var, Boolean.valueOf(z), e12Var}) == null) {
            if (z) {
                bv2 f = f(cv2Var);
                if (f != null && f.f) {
                    kv2.b("payment fun page, download success, ready to jump");
                    j(f.c, cv2Var);
                    return;
                }
                kv2.b("payment fun page, download success, but not exist");
                dv2 dv2Var = new dv2(cv2Var.f);
                dv2Var.a = cv2Var.e;
                e12Var.a(dv2Var);
                return;
            }
            kv2.b("payment fun page, download failed");
            dv2 dv2Var2 = new dv2(cv2Var.f);
            dv2Var2.a = cv2Var.e;
            e12Var.a(dv2Var2);
        }
    }

    public final void e(cv2 cv2Var, bv2 bv2Var, e12<dv2> e12Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048579, this, cv2Var, bv2Var, e12Var) == null) {
            kv2.b("main pkg is exist, download fun page sub pkg");
            String str = bv2Var.a;
            int i = bv2Var.d;
            a74.h(new va4(str, i, qv2.e(bv2Var.c, bv2Var.b), 0), new j32(str, String.valueOf(i), new b(this, cv2Var, e12Var)));
        }
    }

    public abstract bv2 f(cv2 cv2Var);

    public abstract String g();

    public abstract String h();

    public final boolean i(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) ? TextUtils.equals(str, MiniApp.MINIAPP_VERSION_DEVELOP) : invokeL.booleanValue;
    }

    public abstract sr1 j(String str, cv2 cv2Var);

    public abstract boolean k();

    public final sr1 l(cv2 cv2Var, e12<dv2> e12Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048586, this, cv2Var, e12Var)) == null) {
            kv2.b("open fun page start");
            if (cv2Var != null && cv2Var.a()) {
                sr1 b2 = b(cv2Var.g);
                if (b2 != null) {
                    kv2.b("fun page args params invalid");
                    return b2;
                } else if (k()) {
                    kv2.b("open payment fun page");
                    bv2 f = f(cv2Var);
                    if (f == null) {
                        return new sr1(1001, "fun page not exists");
                    }
                    if (!f.f) {
                        kv2.b("payment fun page, " + cv2Var.d + " mode");
                        if (i(cv2Var.d)) {
                            if (f.e) {
                                e(cv2Var, f, e12Var);
                            } else {
                                return new sr1(1001, "fun page not exists");
                            }
                        } else if (f.e) {
                            e(cv2Var, f, e12Var);
                        } else {
                            c(cv2Var, f.a, e12Var);
                        }
                        kv2.b("open fun page end");
                        return new sr1(0);
                    }
                    return j(f.c, cv2Var);
                } else {
                    kv2.b("open user info or choose address fun page");
                    return m(cv2Var, e12Var);
                }
            }
            kv2.b("params parse fail");
            return new sr1(202, "params parse fail");
        }
        return (sr1) invokeLL.objValue;
    }

    public abstract sr1 m(cv2 cv2Var, e12<dv2> e12Var);
}
