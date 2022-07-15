package com.repackage;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.net.request.Headers;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class sf0 implements kl0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public class a extends no0<JSONObject> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ sf0 a;

        public a(sf0 sf0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sf0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = sf0Var;
        }

        @Override // com.repackage.lo0
        public void a(Exception exc, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, exc, i) == null) {
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.mo0
        /* renamed from: e */
        public void b(Headers headers, JSONObject jSONObject, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLI(1048579, this, headers, jSONObject, i) == null) {
                this.a.i(jSONObject);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.mo0
        /* renamed from: f */
        public JSONObject d(Headers headers, String str, int i) throws Exception {
            InterceptResult invokeLLI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048580, this, headers, str, i)) == null) {
                if (i == 200 && !TextUtils.isEmpty(str)) {
                    return new JSONObject(str);
                }
                return null;
            }
            return (JSONObject) invokeLLI.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public static final sf0 a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-15568426, "Lcom/repackage/sf0$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-15568426, "Lcom/repackage/sf0$b;");
                    return;
                }
            }
            a = new sf0(null);
        }
    }

    public /* synthetic */ sf0(a aVar) {
        this();
    }

    public static sf0 c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? b.a : (sf0) invokeV.objValue;
    }

    @Override // com.repackage.kl0
    @NonNull
    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? f() : (String) invokeV.objValue;
    }

    public final long d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? fy0.a().b("nad_app_quick_config").getLong("ip_dx_expire_time", 0L) : invokeV.longValue;
    }

    public final long e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? fy0.a().b("nad_app_quick_config").getLong("request_ip_dx_time", 0L) : invokeV.longValue;
    }

    public String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? fy0.a().b("nad_app_quick_config").getString("ip_dx_data", "") : (String) invokeV.objValue;
    }

    public final boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? System.currentTimeMillis() / 1000 <= d() : invokeV.booleanValue;
    }

    public final boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? System.currentTimeMillis() - e() > 21600000 : invokeV.booleanValue;
    }

    public final void i(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, jSONObject) == null) || jSONObject == null) {
            return;
        }
        k(jSONObject);
        j(jSONObject.optLong("exptime"));
    }

    public final void j(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048583, this, j) == null) {
            fy0.a().b("nad_app_quick_config").h("ip_dx_expire_time", j);
        }
    }

    public final void k(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, jSONObject) == null) {
            fy0.a().b("nad_app_quick_config").i("ip_dx_data", jSONObject.toString());
        }
    }

    public final void l(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048585, this, j) == null) {
            fy0.a().b("nad_app_quick_config").h("request_ip_dx_time", j);
        }
    }

    public void m() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048586, this) == null) && h() && !g()) {
            l(System.currentTimeMillis());
            oh0 a2 = hh0.c().a();
            String b2 = a2.b();
            String packageName = a2.packageName();
            String str = "https://bz-ipdx.baidu.com/miaozhen?" + String.format("uid=%s&appname=%s", b2, packageName);
            go0 a3 = co0.b().a();
            uo0 uo0Var = new uo0();
            uo0Var.k(str);
            uo0Var.c();
            a3.a(uo0Var, new a(this));
        }
    }

    @Override // com.repackage.kl0
    public void request() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            m();
        }
    }

    public sf0() {
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
}
