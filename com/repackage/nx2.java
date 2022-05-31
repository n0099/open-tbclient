package com.repackage;

import android.os.Bundle;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.sapi2.activity.BaseActivity;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public final class nx2 {
    public static /* synthetic */ Interceptable $ic;
    public static a a;
    public static boolean b;
    public static final nx2 c;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public interface a {
        void a(String str, String str2, String str3);

        void b(String str, String str2, String str3);
    }

    /* loaded from: classes6.dex */
    public static final class b<MsgType> implements ae3<k43<JSONObject>> {
        public static /* synthetic */ Interceptable $ic;
        public static final b a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-142031221, "Lcom/repackage/nx2$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-142031221, "Lcom/repackage/nx2$b;");
                    return;
                }
            }
            a = new b();
        }

        public b() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65537, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.ae3
        /* renamed from: a */
        public final void onCallback(k43<JSONObject> it) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, it) == null) {
                Intrinsics.checkNotNullExpressionValue(it, "it");
                if (it.c()) {
                    JSONObject jSONObject = it.a;
                    JSONObject optJSONObject = jSONObject != null ? jSONObject.optJSONObject("data") : null;
                    a b = nx2.c.b();
                    if (optJSONObject != null) {
                        String openId = optJSONObject.optString("openid");
                        if (b == null || !ProcessUtils.isMainProcess()) {
                            nx2.c.d(null, openId);
                            return;
                        }
                        Intrinsics.checkNotNullExpressionValue(openId, "openId");
                        gz2 J = gz2.J();
                        Intrinsics.checkNotNullExpressionValue(J, "Swan.get()");
                        String appId = J.getAppId();
                        tk1 n = oi2.n();
                        Intrinsics.checkNotNullExpressionValue(n, "SwanAppRuntime.getConfig()");
                        b.a(openId, appId, n.a());
                    }
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public static final class c<MsgType> implements ae3<k43<JSONObject>> {
        public static /* synthetic */ Interceptable $ic;
        public static final c a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-142031190, "Lcom/repackage/nx2$c;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-142031190, "Lcom/repackage/nx2$c;");
                    return;
                }
            }
            a = new c();
        }

        public c() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65537, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.ae3
        /* renamed from: a */
        public final void onCallback(k43<JSONObject> it) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, it) == null) {
                Intrinsics.checkNotNullExpressionValue(it, "it");
                if (it.c()) {
                    JSONObject jSONObject = it.a;
                    JSONObject optJSONObject = jSONObject != null ? jSONObject.optJSONObject("data") : null;
                    a b = nx2.c.b();
                    if (optJSONObject != null) {
                        String swanId = optJSONObject.optString("swanid");
                        if (b == null || !ProcessUtils.isMainProcess()) {
                            nx2.c.d(swanId, null);
                            return;
                        }
                        Intrinsics.checkNotNullExpressionValue(swanId, "swanId");
                        gz2 J = gz2.J();
                        Intrinsics.checkNotNullExpressionValue(J, "Swan.get()");
                        String appId = J.getAppId();
                        tk1 n = oi2.n();
                        Intrinsics.checkNotNullExpressionValue(n, "SwanAppRuntime.getConfig()");
                        b.b(swanId, appId, n.a());
                    }
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755454199, "Lcom/repackage/nx2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755454199, "Lcom/repackage/nx2;");
                return;
            }
        }
        c = new nx2();
    }

    public nx2() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public final a b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? a : (a) invokeV.objValue;
    }

    public final boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? b : invokeV.booleanValue;
    }

    public final void d(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, str2) == null) {
            gz2 J = gz2.J();
            Intrinsics.checkNotNullExpressionValue(J, "Swan.get()");
            cw2 z = J.z();
            if (z != null) {
                Bundle bundle = new Bundle();
                bundle.putString("swanId", str);
                bundle.putString(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_OPEN_ID, str2);
                gz2 J2 = gz2.J();
                Intrinsics.checkNotNullExpressionValue(J2, "Swan.get()");
                bundle.putString(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, J2.getAppId());
                tk1 n = oi2.n();
                Intrinsics.checkNotNullExpressionValue(n, "SwanAppRuntime.getConfig()");
                bundle.putString("hostName", n.a());
                z.V(bundle, mx2.class);
            }
        }
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            gz2 J = gz2.J();
            Intrinsics.checkNotNullExpressionValue(J, "Swan.get()");
            kg1 y = J.y();
            Intrinsics.checkNotNullExpressionValue(y, "Swan.get().adaptationProducer");
            o43 f = y.a().b().f(gz2.J());
            f.o(b.a);
            f.call();
        }
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            gz2 J = gz2.J();
            Intrinsics.checkNotNullExpressionValue(J, "Swan.get()");
            kg1 y = J.y();
            Intrinsics.checkNotNullExpressionValue(y, "Swan.get().adaptationProducer");
            p43 e = y.a().b().e(gz2.J());
            e.o(c.a);
            e.call();
        }
    }
}
