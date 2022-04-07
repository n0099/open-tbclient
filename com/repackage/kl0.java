package com.repackage;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.down.retry.HttpRetryStrategyDataParse;
import com.baidu.nadcore.exp.ADConfigError;
import com.baidu.nadcore.net.request.Headers;
import com.baidu.tbadk.browser.SearchJsBridge;
import com.baidu.tbadk.util.AdExtParam;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class kl0 implements Runnable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;
    public int b;
    public boolean c;
    public int d;
    public ADConfigError e;
    public rl0 f;

    /* loaded from: classes6.dex */
    public class a extends jp0<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ kl0 a;

        public a(kl0 kl0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kl0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = kl0Var;
        }

        @Override // com.repackage.hp0
        public void a(Exception exc, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, exc, i) == null) {
                try {
                    e(exc);
                } finally {
                    this.a.j();
                }
            }
        }

        public final void e(Exception exc) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, exc) == null) {
                this.a.e = ADConfigError.error("1", exc.toString());
                if (this.a.f != null) {
                    this.a.f.a(this.a.e);
                }
            }
        }

        public final void f(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
                if (!TextUtils.isEmpty(str)) {
                    try {
                        this.a.a = true;
                        jl0.d().c();
                        jl0.d().e(str);
                        return;
                    } catch (ADConfigError e) {
                        this.a.e = e;
                        this.a.k();
                        return;
                    }
                }
                this.a.e = ADConfigError.error("1", ADConfigError.REASON_NULL_RESPONSE);
                this.a.k();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.ip0
        /* renamed from: g */
        public void b(Headers headers, String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLI(1048581, this, headers, str, i) == null) {
                try {
                    f(str);
                } finally {
                    this.a.j();
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.ip0
        /* renamed from: h */
        public String d(Headers headers, String str, int i) {
            InterceptResult invokeLLI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048582, this, headers, str, i)) == null) {
                if (i != 200) {
                    String str2 = i + "";
                    if (str != null) {
                        str2 = uy0.c(str).optString("error_message");
                    }
                    this.a.e = ADConfigError.error("8", str2);
                    this.a.k();
                    this.a.j();
                    return null;
                }
                return str;
            }
            return (String) invokeLLI.objValue;
        }
    }

    public kl0(int i, boolean z, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i), Boolean.valueOf(z), Integer.valueOf(i2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = i;
        this.c = z;
        this.d = i2;
    }

    @NonNull
    public final JSONObject g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            oi0 a2 = hi0.a();
            uy0.f(jSONObject, "cuid", a2.b());
            uy0.f(jSONObject, "baiduid", a2.g());
            uy0.f(jSONObject, "product", a2.u());
            uy0.f(jSONObject, "bundle_id", a2.packageName());
            uy0.f(jSONObject, AdExtParam.KEY_NAD_CORE_VERSION, "5.2.0.3");
            uy0.f(jSONObject, "ot", "2");
            uy0.f(jSONObject, SearchJsBridge.COOKIE_OV, a2.c());
            uy0.f(jSONObject, "ua", hi0.e());
            uy0.f(jSONObject, "ver", a2.q());
            uy0.f(jSONObject, "sid", a2.d());
            uy0.f(jSONObject, HttpRetryStrategyDataParse.DOWNFLOW_TETRY_REQUEST_ID, String.valueOf(System.currentTimeMillis()));
            uy0.f(jSONObject, "ext", "");
            return jSONObject;
        }
        return (JSONObject) invokeV.objValue;
    }

    @Nullable
    public final qp0 h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            pp0 f = pp0.f(s11.a(g().toString().getBytes()));
            qp0 qp0Var = new qp0();
            qp0Var.a("Content-Encoding", "gzip");
            qp0Var.a("Content-Type", "application/json");
            qp0Var.k("https://afdconf.baidu.com/afd/platform?" + hi0.a().e());
            qp0Var.g(this.b * 1000);
            qp0Var.i(this.b * 1000);
            qp0Var.j(this.b * 1000);
            qp0Var.f(f);
            return qp0Var;
        }
        return (qp0) invokeV.objValue;
    }

    public boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.a : invokeV.booleanValue;
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            ml0.c().d();
        }
    }

    public final void k() {
        ADConfigError aDConfigError;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (aDConfigError = this.e) == null || TextUtils.equals(aDConfigError.reason, ADConfigError.REASON_REQUEST_SUCCESS)) {
            return;
        }
        ll0.c(this.e, this.d, this.c);
    }

    public void l(rl0 rl0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, rl0Var) == null) {
            this.f = rl0Var;
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            qp0 h = h();
            if (h == null) {
                this.e = ADConfigError.error("10", ADConfigError.REASON_BUILD_REQUEST_FAILED);
                k();
                j();
                return;
            }
            yo0.b().a().a(h, new a(this));
        }
    }
}
