package e.a;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import dxm.sasdk.DxmSdkSensorsDataAPI;
/* loaded from: classes2.dex */
public class k {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static DxmSdkSensorsDataAPI f71667a;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65536, null, str, str2) == null) {
            try {
                f71667a.y();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public static void b(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, str, str2) == null) {
            try {
                DxmSdkSensorsDataAPI.r.booleanValue();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public static void c(String str, String str2, Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65538, null, str, str2, th) == null) {
            try {
                DxmSdkSensorsDataAPI.r.booleanValue();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public static void d(DxmSdkSensorsDataAPI dxmSdkSensorsDataAPI) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, dxmSdkSensorsDataAPI) == null) {
            f71667a = dxmSdkSensorsDataAPI;
        }
    }
}
