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
public class ok0 implements Runnable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;
    public int b;
    public boolean c;
    public int d;
    public ADConfigError e;
    public vk0 f;

    /* loaded from: classes6.dex */
    public class a extends no0<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ok0 a;

        public a(ok0 ok0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ok0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ok0Var;
        }

        @Override // com.repackage.lo0
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
                        nk0.d().c();
                        nk0.d().e(str);
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
        @Override // com.repackage.mo0
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
        @Override // com.repackage.mo0
        /* renamed from: h */
        public String d(Headers headers, String str, int i) {
            InterceptResult invokeLLI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048582, this, headers, str, i)) == null) {
                if (i != 200) {
                    String str2 = i + "";
                    if (str != null) {
                        str2 = yx0.c(str).optString("error_message");
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

    public ok0(int i, boolean z, int i2) {
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
            ph0 a2 = hh0.a();
            yx0.f(jSONObject, "cuid", a2.b());
            yx0.f(jSONObject, "baiduid", a2.g());
            yx0.f(jSONObject, "product", a2.u());
            yx0.f(jSONObject, "bundle_id", a2.packageName());
            yx0.f(jSONObject, AdExtParam.KEY_NAD_CORE_VERSION, "5.5.0.11");
            yx0.f(jSONObject, "ot", "2");
            yx0.f(jSONObject, SearchJsBridge.COOKIE_OV, a2.c());
            yx0.f(jSONObject, "ua", hh0.e());
            yx0.f(jSONObject, "ver", a2.q());
            yx0.f(jSONObject, "sid", a2.d());
            yx0.f(jSONObject, HttpRetryStrategyDataParse.DOWNFLOW_TETRY_REQUEST_ID, String.valueOf(System.currentTimeMillis()));
            yx0.f(jSONObject, "ext", "");
            return jSONObject;
        }
        return (JSONObject) invokeV.objValue;
    }

    @Nullable
    public final uo0 h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            to0 f = to0.f(h11.a(g().toString().getBytes()));
            uo0 uo0Var = new uo0();
            uo0Var.a("Content-Encoding", "gzip");
            uo0Var.a("Content-Type", "application/json");
            uo0Var.k("https://afdconf.baidu.com/afd/platform?" + hh0.a().e());
            uo0Var.g(this.b * 1000);
            uo0Var.i(this.b * 1000);
            uo0Var.j(this.b * 1000);
            uo0Var.f(f);
            return uo0Var;
        }
        return (uo0) invokeV.objValue;
    }

    public boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.a : invokeV.booleanValue;
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            qk0.c().d();
        }
    }

    public final void k() {
        ADConfigError aDConfigError;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (aDConfigError = this.e) == null || TextUtils.equals(aDConfigError.reason, ADConfigError.REASON_REQUEST_SUCCESS)) {
            return;
        }
        pk0.c(this.e, this.d, this.c);
    }

    public void l(vk0 vk0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, vk0Var) == null) {
            this.f = vk0Var;
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            uo0 h = h();
            if (h == null) {
                this.e = ADConfigError.error("10", ADConfigError.REASON_BUILD_REQUEST_FAILED);
                k();
                j();
                return;
            }
            co0.b().a().a(h, new a(this));
        }
    }
}
