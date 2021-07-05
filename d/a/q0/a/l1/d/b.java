package d.a.q0.a.l1.d;

import android.util.Log;
import com.baidu.swan.pms.model.PMSAppInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import d.a.q0.a.k;
/* loaded from: classes8.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f49305a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-10995563, "Ld/a/q0/a/l1/d/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-10995563, "Ld/a/q0/a/l1/d/b;");
                return;
            }
        }
        f49305a = k.f49133a;
    }

    public static String a(PMSAppInfo pMSAppInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, pMSAppInfo)) == null) {
            if (pMSAppInfo == null) {
                if (f49305a) {
                    Log.e("AppInfoExt", "appInfo can not be null, please check");
                    return "";
                }
                return "";
            }
            String str = pMSAppInfo.serverExt;
            if (f49305a) {
                Log.d("AppInfoExt", "appId - " + pMSAppInfo.appId + ",get app info' ext - " + str);
            }
            return str;
        }
        return (String) invokeL.objValue;
    }
}
