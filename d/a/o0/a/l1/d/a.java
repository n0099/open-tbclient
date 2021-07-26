package d.a.o0.a.l1.d;

import android.text.TextUtils;
import android.util.Log;
import android.util.LruCache;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.pms.model.PMSAppInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.o0.a.k;
import d.a.o0.n.o.e;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public abstract class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: c  reason: collision with root package name */
    public static final boolean f46504c;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final LruCache<String, JSONObject> f46505a;

    /* renamed from: b  reason: collision with root package name */
    public final LruCache<String, JSONObject> f46506b;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-269161032, "Ld/a/o0/a/l1/d/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-269161032, "Ld/a/o0/a/l1/d/a;");
                return;
            }
        }
        f46504c = k.f46335a;
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
                return;
            }
        }
        this.f46505a = new LruCache<>(5);
        this.f46506b = new LruCache<>(5);
    }

    public final JSONObject a(PMSAppInfo pMSAppInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, pMSAppInfo)) == null) {
            if (pMSAppInfo == null) {
                if (f46504c) {
                    Log.e("SwanAppExtInfo", "appInfo is null");
                }
                return null;
            }
            String str = pMSAppInfo.appId;
            String valueOf = String.valueOf(pMSAppInfo.appSign);
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(valueOf)) {
                String d2 = d(str, valueOf);
                JSONObject jSONObject = this.f46505a.get(d2);
                if (jSONObject == null) {
                    jSONObject = e.m(b.a(pMSAppInfo));
                    this.f46505a.put(d2, jSONObject);
                }
                if (f46504c) {
                    Log.d("SwanAppExtInfo", "appId - " + str + " app info' ext - " + jSONObject.toString());
                }
                return jSONObject;
            }
            if (f46504c) {
                Log.e("SwanAppExtInfo", "appId or app sign is empty");
            }
            return null;
        }
        return (JSONObject) invokeL.objValue;
    }

    public final JSONObject b(PMSAppInfo pMSAppInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pMSAppInfo)) == null) {
            JSONObject a2 = a(pMSAppInfo);
            if (a2 == null) {
                if (f46504c) {
                    Log.e("SwanAppExtInfo", "appInfoExt is null");
                }
                return null;
            }
            JSONObject optJSONObject = a2.optJSONObject("client");
            if (optJSONObject == null) {
                if (f46504c) {
                    Log.e("SwanAppExtInfo", "clientInfo is null");
                }
                return null;
            }
            if (f46504c) {
                Log.d("SwanAppExtInfo", "clientInfo - " + optJSONObject);
            }
            return optJSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }

    public final JSONObject c(PMSAppInfo pMSAppInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, pMSAppInfo)) == null) {
            if (pMSAppInfo == null) {
                if (f46504c) {
                    Log.e("SwanAppExtInfo", "appInfo is null");
                }
                return null;
            }
            String str = pMSAppInfo.appId;
            String valueOf = String.valueOf(pMSAppInfo.versionCode);
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(valueOf)) {
                String d2 = d(str, valueOf);
                JSONObject jSONObject = this.f46506b.get(d2);
                if (jSONObject == null) {
                    jSONObject = e.m(c.f(pMSAppInfo));
                    this.f46505a.put(d2, jSONObject);
                }
                if (f46504c) {
                    Log.d("SwanAppExtInfo", "appId - " + str + " pkg info' ext - " + jSONObject.toString());
                }
                return jSONObject;
            }
            if (f46504c) {
                Log.e("SwanAppExtInfo", "appId or version code is empty");
            }
            return null;
        }
        return (JSONObject) invokeL.objValue;
    }

    public final String d(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, str, str2)) == null) {
            return str + "_" + str2;
        }
        return (String) invokeLL.objValue;
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            if (f46504c) {
                Log.d("SwanAppExtInfo", "release cache");
            }
            this.f46505a.evictAll();
            this.f46506b.evictAll();
        }
    }
}
