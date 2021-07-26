package d.a.o0.a.p1;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.swan.apps.page.model.SwanAppPageInfo;
import com.baidu.swan.apps.process.SwanAppProcessInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.o0.a.a2.e;
import d.a.o0.a.k;
import d.a.o0.a.v1.c.c;
import d.a.o0.a.v2.e1.b;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: b  reason: collision with root package name */
    public static final boolean f47239b;

    /* renamed from: c  reason: collision with root package name */
    public static volatile a f47240c;

    /* renamed from: d  reason: collision with root package name */
    public static final String f47241d;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public b<SwanAppPageInfo> f47242a;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(517379825, "Ld/a/o0/a/p1/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(517379825, "Ld/a/o0/a/p1/a;");
                return;
            }
        }
        f47239b = k.f46335a;
        f47241d = d.a.o0.a.c1.a.m().a() + "_";
    }

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static a a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (f47240c == null) {
                synchronized (a.class) {
                    if (f47240c == null) {
                        f47240c = new a();
                    }
                }
            }
            return f47240c;
        }
        return (a) invokeV.objValue;
    }

    public final d.a.o0.a.f1.e.b b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            e Q = e.Q();
            if (Q == null || Q.L() == null) {
                return null;
            }
            return Q.L();
        }
        return (d.a.o0.a.f1.e.b) invokeV.objValue;
    }

    public void c(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONObject) == null) {
            String optString = jSONObject.optString("type");
            if (TextUtils.isEmpty(optString) || !optString.startsWith(f47241d)) {
                return;
            }
            d.a.o0.a.f1.e.b b2 = b();
            if (b2 != null) {
                try {
                    jSONObject.put("appName", b2.K());
                    jSONObject.put("iconUrl", b2.Q());
                    jSONObject.put("appDesc", b2.c1());
                } catch (JSONException e2) {
                    if (f47239b) {
                        e2.printStackTrace();
                    }
                }
            }
            jSONObject.put("type", optString.substring(f47241d.length()));
            b<SwanAppPageInfo> bVar = this.f47242a;
            if (bVar != null) {
                bVar.onCallback(new SwanAppPageInfo(jSONObject));
            }
            if (SwanAppProcessInfo.isSwanAppProcess(ProcessUtils.getCurProcessName())) {
                d();
                Bundle bundle = new Bundle();
                bundle.putString("page_info", jSONObject.toString());
                d.a.o0.a.v1.c.a.e().h(new c(24, bundle));
                if (f47239b) {
                    Log.d("SwanAppPageInfoHelper", "postPageInfo: post to main process");
                }
            }
        }
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || this.f47242a == null) {
            return;
        }
        this.f47242a = null;
    }
}
