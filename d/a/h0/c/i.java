package d.a.h0.c;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.bridge.BaiduAppJsBridgeHandler;
import com.baidu.prologue.service.network.Als;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.vivo.push.PushClientConstants;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;
@SuppressLint({"LongLogTag"})
/* loaded from: classes8.dex */
public class i extends e {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f45652a;

    /* renamed from: b  reason: collision with root package name */
    public static final String[] f45653b;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes8.dex */
    public class a implements b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a(i iVar, d.a.h0.c.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iVar, aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1577630624, "Ld/a/h0/c/i;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1577630624, "Ld/a/h0/c/i;");
                return;
            }
        }
        f45652a = d.a.h0.a.b.a.f45561a.get().s();
        f45653b = new String[]{"deeplink", "open"};
    }

    public i() {
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

    @Override // d.a.h0.c.e
    public void a(HashMap<String, String> hashMap) {
        String[] strArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, hashMap) == null) {
            for (String str : f45653b) {
                hashMap.put("splash/ad/" + str, "splash_ad/" + str);
            }
        }
    }

    @Override // d.a.h0.c.e
    @SuppressLint({"LongLogTag"})
    public boolean c(Context context, g gVar, d.a.h0.c.a aVar) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, gVar, aVar)) == null) {
            String g2 = gVar.g(true);
            if (!TextUtils.isEmpty(g2) && context != null) {
                if (gVar.i()) {
                    return true;
                }
                if (f45652a) {
                    Log.e("UnitedSchemeSplashDispatcher", "invoke: " + gVar.h().toString());
                }
                char c2 = 65535;
                int hashCode = g2.hashCode();
                if (hashCode != 3417674) {
                    if (hashCode == 629233382 && g2.equals("deeplink")) {
                        c2 = 0;
                    }
                } else if (g2.equals("open")) {
                    c2 = 1;
                }
                if (c2 != 0) {
                    if (c2 != 1) {
                        if (f45652a) {
                            throw new IllegalStateException("scheme action 不支持错误");
                        }
                        return false;
                    }
                    return f(gVar, aVar);
                }
                return e(context, gVar, aVar);
            }
            gVar.m = j.h(201);
            return false;
        }
        return invokeLLL.booleanValue;
    }

    public final boolean e(@NonNull Context context, @NonNull g gVar, d.a.h0.c.a aVar) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, context, gVar, aVar)) == null) {
            String str = gVar.f().get("params");
            if (TextUtils.isEmpty(str)) {
                if (f45652a) {
                    throw new IllegalStateException("action deeplink 没有params参数");
                }
                return false;
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                String optString = jSONObject.optString("appUrl");
                String optString2 = jSONObject.optString(BaiduAppJsBridgeHandler.INPUT_PARAM_WEB_URL);
                String optString3 = jSONObject.optString(PushClientConstants.TAG_PKG_NAME);
                if (!TextUtils.isEmpty(optString) && d.a.h0.a.c.i.b(context, optString)) {
                    h(Als.Area.DEEPLINK_RESULT_APP);
                    return true;
                } else if (!TextUtils.isEmpty(optString3) && d.a.h0.a.c.i.a(context, optString3)) {
                    h(Als.Area.DEEPLINK_RESULT_APP);
                    return true;
                } else if (TextUtils.isEmpty(optString2)) {
                    return false;
                } else {
                    h(Als.Area.DEEPLINK_RESULT_H5);
                    return g(optString2, aVar);
                }
            } catch (JSONException e2) {
                e2.printStackTrace();
                return false;
            }
        }
        return invokeLLL.booleanValue;
    }

    public final boolean f(g gVar, d.a.h0.c.a aVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, gVar, aVar)) == null) {
            String str = gVar.f().get("params");
            if (TextUtils.isEmpty(str)) {
                if (f45652a) {
                    throw new IllegalStateException("action deeplink 没有params参数");
                }
                return false;
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                String optString = jSONObject.optString(BaiduAppJsBridgeHandler.INPUT_PARAM_WEB_URL);
                if (TextUtils.isEmpty(optString)) {
                    optString = jSONObject.optString("innerUrl");
                }
                if (f45652a) {
                    Log.d("UnitedSchemeSplashDispatcher", "openUrl: " + optString);
                }
                return g(optString, aVar);
            } catch (JSONException e2) {
                e2.printStackTrace();
                return false;
            }
        }
        return invokeLL.booleanValue;
    }

    public final boolean g(@NonNull String str, d.a.h0.c.a aVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, str, aVar)) == null) ? d.a.h0.a.b.a.f45561a.get().v(str, new a(this, aVar)) : invokeLL.booleanValue;
    }

    public final void h(Als.Area area) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, area) == null) {
            if (!TextUtils.isEmpty(d.a.h0.b.g.c.f45612a)) {
                Als.c cVar = new Als.c(Als.Type.DEEP_LINK);
                cVar.l(Als.Page.NA_DEEPLINK);
                cVar.e(area);
                cVar.m(d.a.h0.b.g.c.f45612a);
                Als.e(cVar);
            } else if (f45652a) {
                throw new IllegalStateException("全局数据仓库获取数据失败，打点失败...");
            }
        }
    }
}
