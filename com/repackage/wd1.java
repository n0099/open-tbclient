package com.repackage;

import android.content.Context;
import cn.com.chinatelecom.gateway.lib.CtAuth;
import cn.com.chinatelecom.gateway.lib.PreCodeListener;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.sapi2.activity.social.YYInnerSSOLoginActivity;
import com.baidu.sapi2.result.OneKeyLoginOptResult;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class wd1 extends qd1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean s;

    /* loaded from: classes7.dex */
    public class a extends xd1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int b;
        public final /* synthetic */ int c;
        public final /* synthetic */ int d;
        public final /* synthetic */ wd1 e;

        public a(wd1 wd1Var, int i, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wd1Var, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = wd1Var;
            this.b = i;
            this.c = i2;
            this.d = i3;
        }

        @Override // cn.com.chinatelecom.gateway.lib.PreCodeListener
        public void onResult(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                long currentTimeMillis = System.currentTimeMillis() - a();
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    int optInt = jSONObject.optInt("result", -1);
                    String optString = jSONObject.optString("reqId", "");
                    if (!this.e.L(optInt, this.b) || this.c != 0) {
                        this.e.C(str, this.b, 1);
                    } else {
                        this.e.x(this.b, this.d, this.c + 1);
                    }
                    ie1.c(this.e.a, this.e.c, optInt, currentTimeMillis, this.d, optString);
                } catch (Throwable th) {
                    se1.d(th);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements PreCodeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;
        public final /* synthetic */ wd1 b;

        public b(wd1 wd1Var, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wd1Var, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = wd1Var;
            this.a = i;
        }

        @Override // cn.com.chinatelecom.gateway.lib.PreCodeListener
        public void onResult(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                this.b.C(str, this.a, 3);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c extends ne1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String b;
        public final /* synthetic */ int c;
        public final /* synthetic */ int d;
        public final /* synthetic */ wd1 e;

        public c(wd1 wd1Var, String str, int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wd1Var, str, Integer.valueOf(i), Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = wd1Var;
            this.b = str;
            this.c = i;
            this.d = i2;
        }

        @Override // com.repackage.ne1
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    JSONObject jSONObject = new JSONObject(this.b);
                    if (jSONObject.optInt("result", -1) == 0) {
                        this.e.K(jSONObject, this.c, this.d);
                    } else {
                        this.e.D(jSONObject, this.c, this.d);
                    }
                } catch (Throwable th) {
                    se1.d(th);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d extends ne1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ JSONObject b;
        public final /* synthetic */ int c;
        public final /* synthetic */ int d;
        public final /* synthetic */ wd1 e;

        public d(wd1 wd1Var, JSONObject jSONObject, int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wd1Var, jSONObject, Integer.valueOf(i), Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = wd1Var;
            this.b = jSONObject;
            this.c = i;
            this.d = i2;
        }

        @Override // com.repackage.ne1
        public void b() {
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    JSONObject optJSONObject = this.b.optJSONObject("data");
                    if (this.c == 1) {
                        this.e.e = optJSONObject.optString(YYInnerSSOLoginActivity.o, "");
                        this.e.g = optJSONObject.optString("number", "");
                        this.e.f = System.currentTimeMillis() + (optJSONObject.optInt("expiredTime", 0) * 1000);
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put(OneKeyLoginOptResult.OptResultFields.SECURITY_PHONE, this.e.a(this.e.g));
                        str = jSONObject.toString();
                    } else {
                        this.e.h = optJSONObject.optString(YYInnerSSOLoginActivity.o, "");
                        this.e.i = System.currentTimeMillis() + (optJSONObject.optInt("expiredTime", 0) * 1000);
                        str = "preVerify success";
                    }
                    this.e.e(this.d, 0, 0, this.e.c, str, this.c);
                } catch (Throwable unused) {
                    wd1 wd1Var = this.e;
                    wd1Var.e(this.d, 3, 2009, wd1Var.c, "ct on handle pre login or verify unknown error.", this.c);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e extends ne1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ JSONObject b;
        public final /* synthetic */ int c;
        public final /* synthetic */ int d;
        public final /* synthetic */ wd1 e;

        public e(wd1 wd1Var, JSONObject jSONObject, int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wd1Var, jSONObject, Integer.valueOf(i), Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = wd1Var;
            this.b = jSONObject;
            this.c = i;
            this.d = i2;
        }

        @Override // com.repackage.ne1
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    int optInt = this.b.optInt("result", -1);
                    String optString = this.b.optString("msg", "");
                    if (this.e.c != this.e.d && (optInt == -10009 || optInt == -10008)) {
                        this.e.e(this.c, 3, 2002, this.e.c, "pre login error, wrong sim operator", this.d);
                    } else {
                        wd1 wd1Var = this.e;
                        int i = this.c;
                        int i2 = this.e.c;
                        StringBuilder sb = new StringBuilder();
                        sb.append("ct pre login error.");
                        sb.append(optString);
                        sb.append(", status ");
                        sb.append(optInt);
                        wd1Var.e(i, 2, optInt, i2, sb.toString(), this.d);
                    }
                } catch (Throwable unused) {
                    wd1 wd1Var2 = this.e;
                    wd1Var2.e(this.c, 3, 2009, wd1Var2.c, "ct on handle pre login or verify unknown error.", this.d);
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public wd1(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.s = false;
        this.c = 3;
    }

    public final void C(String str, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(1048576, this, str, i, i2) == null) {
            pe1.c().b(new c(this, str, i, i2));
        }
    }

    public final void D(JSONObject jSONObject, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONObject, i, i2) == null) {
            pe1.c().b(new e(this, jSONObject, i, i2));
        }
    }

    public final void K(JSONObject jSONObject, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(Constants.METHOD_SEND_USER_MSG, this, jSONObject, i, i2) == null) {
            pe1.c().b(new d(this, jSONObject, i2, i));
        }
    }

    public final boolean L(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048579, this, i, i2)) == null) {
            return hd1.f(this.a).b() && hd1.f(this.a).m("k_retry_code_ct", i) && ld1.c().h(i2);
        }
        return invokeII.booleanValue;
    }

    @Override // com.repackage.pd1
    public void h(Context context, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048580, this, context, i) == null) {
            super.h(context, i);
            if (!hd1.f(this.a).c()) {
                e(i, 3, 997, this.c, "pre verify error. sdk stop run.", 3);
            } else if (!r()) {
                e(i, 3, 2006, this.c, "pre verify error. ct has not valid config.", 3);
            } else if (hd1.f(this.a).q0()) {
                if (!this.s) {
                    CtAuth.init(0, 0, 8000, null);
                    this.s = true;
                }
                CtAuth.requestPreAuthCode(context, pd1.m, pd1.n, new b(this, i));
            } else {
                e(i, 3, 996, this.c, "pre verify error. ct sdk stop run.", 3);
            }
        }
    }

    @Override // com.repackage.pd1
    public void i(Context context, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(1048581, this, context, i, i2) == null) {
            super.i(context, i, i2);
            if (!hd1.f(this.a).c()) {
                e(i2, 3, 997, this.c, "pre login error. sdk stop run.", 1);
            } else if (!r()) {
                e(i2, 3, 2006, this.c, "pre login error. ct has not valid config.", 1);
            } else if (hd1.f(this.a).q0()) {
                if (!this.s) {
                    System.currentTimeMillis();
                    CtAuth.init(0, 0, 8000, null);
                    this.s = true;
                }
                x(i2, i, 0);
            } else {
                e(i2, 3, 996, this.c, "pre login error. ct sdk stop run.", 1);
            }
        }
    }

    @Override // com.repackage.qd1, com.repackage.pd1
    public void p(Context context, int i, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{context, Integer.valueOf(i), Long.valueOf(j)}) == null) {
            super.p(context, i, j);
        }
    }

    public final void x(int i, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIII(1048583, this, i, i2, i3) == null) {
            CtAuth.requestPreAuthCode(this.a, pd1.m, pd1.n, new a(this, i, i3, i2));
        }
    }
}
