package d.b.a;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes10.dex */
public class e0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static boolean a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, context)) == null) {
            try {
                NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
                if (activeNetworkInfo != null) {
                    return activeNetworkInfo.isAvailable();
                }
                return false;
            } catch (Throwable unused) {
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0019  */
    /* JADX WARN: Removed duplicated region for block: B:31:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String b(Context context) {
        InterceptResult invokeL;
        NetworkInfo networkInfo;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(65537, null, context)) != null) {
            return (String) invokeL.objValue;
        }
        try {
            networkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        } catch (SecurityException e2) {
            h0.b(e2);
            networkInfo = null;
            return networkInfo != null ? null : null;
        } catch (Throwable unused) {
            networkInfo = null;
            if (networkInfo != null) {
            }
        }
        if (networkInfo != null && networkInfo.isAvailable()) {
            int type = networkInfo.getType();
            if (1 == type) {
                return "wifi";
            }
            if (type == 0) {
                switch (((TelephonyManager) context.getSystemService("phone")).getNetworkType()) {
                    case 1:
                    case 2:
                    case 4:
                    case 7:
                    case 11:
                    case 16:
                        return "2g";
                    case 3:
                    case 5:
                    case 6:
                    case 8:
                    case 9:
                    case 10:
                    case 12:
                    case 14:
                    case 15:
                    case 17:
                        return "3g";
                    case 13:
                    case 18:
                    case 19:
                        return "4g";
                    default:
                        return "mobile";
                }
            }
            return null;
        }
    }
}
