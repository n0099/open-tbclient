package e.a;

import android.util.Log;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import dxm.sasdk.DxmSdkSensorsDataAPI;
/* loaded from: classes10.dex */
public class k {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static DxmSdkSensorsDataAPI f75237a;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65536, null, str, str2) == null) {
            try {
                if (f75237a.y()) {
                    Log.i(str, str2);
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public static void b(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, str, str2) == null) {
            try {
                if (DxmSdkSensorsDataAPI.r.booleanValue()) {
                    Log.i(str, str2);
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public static void c(String str, String str2, Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65538, null, str, str2, th) == null) {
            try {
                if (DxmSdkSensorsDataAPI.r.booleanValue()) {
                    Log.i(str, str2, th);
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public static void d(DxmSdkSensorsDataAPI dxmSdkSensorsDataAPI) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, dxmSdkSensorsDataAPI) == null) {
            f75237a = dxmSdkSensorsDataAPI;
        }
    }
}
