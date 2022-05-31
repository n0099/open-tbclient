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
/* loaded from: classes7.dex */
public class xj0 implements Runnable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;
    public int b;
    public boolean c;
    public int d;
    public ADConfigError e;
    public ek0 f;

    /* loaded from: classes7.dex */
    public class a extends wn0<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xj0 a;

        public a(xj0 xj0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xj0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = xj0Var;
        }

        @Override // com.repackage.un0
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
                        wj0.c().b();
                        wj0.c().d(str);
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
        @Override // com.repackage.vn0
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
        @Override // com.repackage.vn0
        /* renamed from: h */
        public String d(Headers headers, String str, int i) {
            InterceptResult invokeLLI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048582, this, headers, str, i)) == null) {
                if (i != 200) {
                    String str2 = i + "";
                    if (str != null) {
                        str2 = hx0.c(str).optString("error_message");
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

    public xj0(int i, boolean z, int i2) {
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
            eh0 a2 = xg0.a();
            hx0.f(jSONObject, "cuid", a2.b());
            hx0.f(jSONObject, "baiduid", a2.g());
            hx0.f(jSONObject, "product", a2.u());
            hx0.f(jSONObject, "bundle_id", a2.packageName());
            hx0.f(jSONObject, AdExtParam.KEY_NAD_CORE_VERSION, "5.2.0.21");
            hx0.f(jSONObject, "ot", "2");
            hx0.f(jSONObject, SearchJsBridge.COOKIE_OV, a2.c());
            hx0.f(jSONObject, "ua", xg0.e());
            hx0.f(jSONObject, "ver", a2.q());
            hx0.f(jSONObject, "sid", a2.d());
            hx0.f(jSONObject, HttpRetryStrategyDataParse.DOWNFLOW_TETRY_REQUEST_ID, String.valueOf(System.currentTimeMillis()));
            hx0.f(jSONObject, "ext", "");
            return jSONObject;
        }
        return (JSONObject) invokeV.objValue;
    }

    @Nullable
    public final do0 h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            co0 f = co0.f(p01.a(g().toString().getBytes()));
            do0 do0Var = new do0();
            do0Var.a("Content-Encoding", "gzip");
            do0Var.a("Content-Type", "application/json");
            do0Var.k("https://afdconf.baidu.com/afd/platform?" + xg0.a().e());
            do0Var.g(this.b * 1000);
            do0Var.i(this.b * 1000);
            do0Var.j(this.b * 1000);
            do0Var.f(f);
            return do0Var;
        }
        return (do0) invokeV.objValue;
    }

    public boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.a : invokeV.booleanValue;
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            zj0.c().d();
        }
    }

    public final void k() {
        ADConfigError aDConfigError;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (aDConfigError = this.e) == null || TextUtils.equals(aDConfigError.reason, ADConfigError.REASON_REQUEST_SUCCESS)) {
            return;
        }
        yj0.c(this.e, this.d, this.c);
    }

    public void l(ek0 ek0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, ek0Var) == null) {
            this.f = ek0Var;
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            do0 h = h();
            if (h == null) {
                this.e = ADConfigError.error("10", ADConfigError.REASON_BUILD_REQUEST_FAILED);
                k();
                j();
                return;
            }
            ln0.b().a().a(h, new a(this));
        }
    }
}
