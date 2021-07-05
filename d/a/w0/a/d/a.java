package d.a.w0.a.d;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import d.a.w0.a.e.f;
import d.a.w0.a.e.i;
/* loaded from: classes9.dex */
public final class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static boolean a(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, context, str)) == null) {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo != null && activeNetworkInfo.isConnected()) {
                if (!f.i() || i.f(context) == 1) {
                    return b.c(b.b(str, "http://absample.baidu.com/appabapp/appapi/applog"), null);
                }
                return false;
            }
            return false;
        }
        return invokeLL.booleanValue;
    }
}
