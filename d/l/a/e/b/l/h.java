package d.l.a.e.b.l;

import android.content.Context;
import android.content.pm.ServiceInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes10.dex */
public class h {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static boolean a(Context context, String str, String str2) {
        InterceptResult invokeLLL;
        ServiceInfo[] serviceInfoArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65536, null, context, str, str2)) == null) {
            try {
                for (ServiceInfo serviceInfo : context.getPackageManager().getPackageInfo(str, 4).services) {
                    if (serviceInfo.exported && serviceInfo.enabled && serviceInfo.permission == null && serviceInfo.name.equals(str2)) {
                        return true;
                    }
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
            return false;
        }
        return invokeLLL.booleanValue;
    }
}
