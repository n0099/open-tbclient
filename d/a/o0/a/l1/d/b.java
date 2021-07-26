package d.a.o0.a.l1.d;

import android.util.Log;
import com.baidu.swan.pms.model.PMSAppInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import d.a.o0.a.k;
/* loaded from: classes7.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f46507a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-269161001, "Ld/a/o0/a/l1/d/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-269161001, "Ld/a/o0/a/l1/d/b;");
                return;
            }
        }
        f46507a = k.f46335a;
    }

    public static String a(PMSAppInfo pMSAppInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, pMSAppInfo)) == null) {
            if (pMSAppInfo == null) {
                if (f46507a) {
                    Log.e("AppInfoExt", "appInfo can not be null, please check");
                    return "";
                }
                return "";
            }
            String str = pMSAppInfo.serverExt;
            if (f46507a) {
                Log.d("AppInfoExt", "appId - " + pMSAppInfo.appId + ",get app info' ext - " + str);
            }
            return str;
        }
        return (String) invokeL.objValue;
    }
}
