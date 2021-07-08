package d.a.n0.a.p1;

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
import d.a.n0.a.a2.e;
import d.a.n0.a.k;
import d.a.n0.a.v1.c.c;
import d.a.n0.a.v2.e1.b;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: b  reason: collision with root package name */
    public static final boolean f46735b;

    /* renamed from: c  reason: collision with root package name */
    public static volatile a f46736c;

    /* renamed from: d  reason: collision with root package name */
    public static final String f46737d;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public b<SwanAppPageInfo> f46738a;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(713893330, "Ld/a/n0/a/p1/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(713893330, "Ld/a/n0/a/p1/a;");
                return;
            }
        }
        f46735b = k.f45831a;
        f46737d = d.a.n0.a.c1.a.m().a() + "_";
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
            if (f46736c == null) {
                synchronized (a.class) {
                    if (f46736c == null) {
                        f46736c = new a();
                    }
                }
            }
            return f46736c;
        }
        return (a) invokeV.objValue;
    }

    public final d.a.n0.a.f1.e.b b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            e Q = e.Q();
            if (Q == null || Q.L() == null) {
                return null;
            }
            return Q.L();
        }
        return (d.a.n0.a.f1.e.b) invokeV.objValue;
    }

    public void c(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONObject) == null) {
            String optString = jSONObject.optString("type");
            if (TextUtils.isEmpty(optString) || !optString.startsWith(f46737d)) {
                return;
            }
            d.a.n0.a.f1.e.b b2 = b();
            if (b2 != null) {
                try {
                    jSONObject.put("appName", b2.K());
                    jSONObject.put("iconUrl", b2.Q());
                    jSONObject.put("appDesc", b2.c1());
                } catch (JSONException e2) {
                    if (f46735b) {
                        e2.printStackTrace();
                    }
                }
            }
            jSONObject.put("type", optString.substring(f46737d.length()));
            b<SwanAppPageInfo> bVar = this.f46738a;
            if (bVar != null) {
                bVar.onCallback(new SwanAppPageInfo(jSONObject));
            }
            if (SwanAppProcessInfo.isSwanAppProcess(ProcessUtils.getCurProcessName())) {
                d();
                Bundle bundle = new Bundle();
                bundle.putString("page_info", jSONObject.toString());
                d.a.n0.a.v1.c.a.e().h(new c(24, bundle));
                if (f46735b) {
                    Log.d("SwanAppPageInfoHelper", "postPageInfo: post to main process");
                }
            }
        }
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || this.f46738a == null) {
            return;
        }
        this.f46738a = null;
    }
}
