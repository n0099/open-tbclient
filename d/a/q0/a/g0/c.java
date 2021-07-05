package d.a.q0.a.g0;

import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.CookieManager;
import com.baidu.webkit.sdk.CookieSyncManager;
import d.a.q0.a.e2.c.h;
import d.a.q0.a.k;
import d.a.q0.a.v2.d;
import java.util.List;
/* loaded from: classes8.dex */
public class c extends h {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f47822a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(116011397, "Ld/a/q0/a/g0/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(116011397, "Ld/a/q0/a/g0/c;");
                return;
            }
        }
        f47822a = k.f49133a;
        try {
            CookieSyncManager.createInstance(AppRuntime.getAppContext());
        } catch (Exception e2) {
            if (f47822a) {
                Log.w("RealCookieManager", "static createInstance err=" + e2 + " trace=" + Log.getStackTraceString(e2));
            }
        }
    }

    public c() {
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

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            if (d.f()) {
                if (f47822a) {
                    Log.i("RealCookieManager", "syncCookie: hasLollipop flush");
                }
                CookieManager.getInstance().flush();
                android.webkit.CookieManager.getInstance().flush();
                return;
            }
            if (f47822a) {
                Log.i("RealCookieManager", "syncCookie: noLollipop sync");
            }
            CookieSyncManager.getInstance().sync();
        }
    }

    @Override // d.a.q0.a.e2.c.h, com.baidu.searchbox.http.cookie.CookieManager
    public String getCookie(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            if (f47822a) {
                Log.i("RealCookieManager", "getCookie: httpUrl=" + str);
            }
            String str2 = "";
            try {
                str2 = CookieManager.getInstance().getCookie(str);
                if (f47822a) {
                    Log.d("RealCookieManager", "RealCookieManager:" + str2);
                }
            } catch (Exception e2) {
                if (f47822a) {
                    Log.e("RealCookieManager", "getCookie: err=" + e2 + " trace=" + Log.getStackTraceString(e2));
                }
            }
            if (f47822a) {
                Log.i("RealCookieManager", "getCookie: ret cookie=" + str2 + " for httpUrl=" + str);
            }
            return str2;
        }
        return (String) invokeL.objValue;
    }

    @Override // com.baidu.searchbox.http.cookie.CookieManager
    public boolean shouldAcceptCookie(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, str2)) == null) {
            return true;
        }
        return invokeLL.booleanValue;
    }

    @Override // com.baidu.searchbox.http.cookie.CookieManager
    public boolean shouldSendCookie(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, str, str2)) == null) {
            return true;
        }
        return invokeLL.booleanValue;
    }

    @Override // com.baidu.searchbox.http.cookie.CookieManager
    public void storeCookie(String str, List<String> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, str, list) == null) {
            if (f47822a) {
                Log.d("RealCookieManager", "storeCookie: httpUrl= " + str);
                StringBuilder sb = new StringBuilder();
                sb.append("storeCookie: cookies=");
                sb.append(list == null ? -1 : list.size());
                Log.i("RealCookieManager", sb.toString());
            }
            if (list == null || list.size() <= 0) {
                return;
            }
            try {
                for (String str2 : list) {
                    if (f47822a) {
                        Log.i("RealCookieManager", "storeCookie: cookies item=" + str2);
                    }
                    CookieManager.getInstance().setCookie(str, str2);
                    android.webkit.CookieManager.getInstance().setCookie(str, str2);
                }
                a();
            } catch (Exception e2) {
                if (f47822a) {
                    Log.e("RealCookieManager", "storeCookie: err=" + e2 + " trace=" + Log.getStackTraceString(e2));
                }
            }
        }
    }
}
