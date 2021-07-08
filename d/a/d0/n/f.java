package d.a.d0.n;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.text.TextUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            NetworkInfo c2 = c();
            return c2 != null && c2.isConnected();
        }
        return invokeV.booleanValue;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static String b(int i2, String str) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(65537, null, i2, str)) == null) {
            switch (i2) {
                case 1:
                case 2:
                case 4:
                case 7:
                case 11:
                case 16:
                    return "1";
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
                    return "2";
                case 13:
                case 18:
                case 19:
                    break;
                default:
                    if (TextUtils.isEmpty(str) || !str.equalsIgnoreCase("LTE_CA")) {
                        return "unknown";
                    }
                    break;
            }
            return "3";
        }
        return (String) invokeIL.objValue;
    }

    public static NetworkInfo c() {
        InterceptResult invokeV;
        ConnectivityManager connectivityManager;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            Context a2 = g.a();
            if (a2 == null || (connectivityManager = (ConnectivityManager) a2.getSystemService("connectivity")) == null) {
                return null;
            }
            return connectivityManager.getActiveNetworkInfo();
        }
        return (NetworkInfo) invokeV.objValue;
    }

    public static String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            NetworkInfo c2 = c();
            return (c2 == null || !c2.isConnected()) ? "0" : c2.getType() == 1 ? "4" : c2.getType() == 0 ? b(c2.getSubtype(), c2.getSubtypeName()) : "unknown";
        }
        return (String) invokeV.objValue;
    }
}
