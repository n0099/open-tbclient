package d.a.o0.a.u.i;

import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import androidx.annotation.NonNull;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import d.a.o0.a.k;
import d.a.o0.a.p.e.d;
/* loaded from: classes7.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f48372a;

    /* renamed from: b  reason: collision with root package name */
    public static final String[] f48373b;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-998114831, "Ld/a/o0/a/u/i/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-998114831, "Ld/a/o0/a/u/i/a;");
                return;
            }
        }
        f48372a = k.f46335a;
        f48373b = new String[]{"swan", "swanAPI", "utils"};
    }

    @NonNull
    public static Pair<Boolean, d.a.o0.a.u.h.a> a(d.a.o0.a.u.c.a aVar, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, aVar, str)) == null) {
            d.a.o0.a.u.h.b bVar = new d.a.o0.a.u.h.b();
            boolean b2 = b(str, aVar.a().h());
            if (b2) {
                bVar.f48368b = 402;
            }
            return new Pair<>(Boolean.valueOf(b2), bVar);
        }
        return (Pair) invokeLL.objValue;
    }

    public static boolean b(String str, CallbackHandler callbackHandler) {
        InterceptResult invokeLL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, str, callbackHandler)) == null) {
            if (!(callbackHandler instanceof d)) {
                if (f48372a) {
                    Log.d("SwanApiSafe", "intercept: false, handler is null or not WebSafeHolder");
                }
                return false;
            } else if (TextUtils.isEmpty(str)) {
                if (f48372a) {
                    throw new RuntimeException("whitelistName is empty");
                }
                return false;
            } else {
                String c0 = ((d) callbackHandler).c0();
                if ("ai_apps_widget".equals(c0)) {
                    z = c(str);
                } else if ("ai_apps_ad_landing".equals(c0)) {
                    z = !d.a.o0.a.b2.a.b.a(str);
                } else {
                    if (!"swan_app_alliance_login_widget".equals(c0) && !"swan_app_alliance_choose_address_widget".equals(c0) && f48372a) {
                        Log.d("SwanApiSafe", "intercept: false, source frame is not aiapps widget frame");
                    }
                    return false;
                }
                if (f48372a) {
                    Log.d("SwanApiSafe", "intercept: result=" + z + ", path=" + str);
                }
                return z;
            }
        }
        return invokeLL.booleanValue;
    }

    public static boolean c(@NonNull String str) {
        InterceptResult invokeL;
        String[] strArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) {
            int indexOf = str.indexOf("/");
            if (indexOf < 0) {
                return true;
            }
            if (str.startsWith("swan")) {
                String substring = str.substring(indexOf + 1);
                for (String str2 : f48373b) {
                    if (d.a.o0.a.b2.a.b.g(str2 + "/" + substring)) {
                        return false;
                    }
                }
                return true;
            }
            return !d.a.o0.a.b2.a.b.g(str);
        }
        return invokeL.booleanValue;
    }
}
