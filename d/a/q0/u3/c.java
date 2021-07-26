package d.a.q0.u3;

import android.content.Context;
import android.hardware.SensorManager;
import android.os.Build;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes8.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static int a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            try {
                return Integer.valueOf(Build.VERSION.SDK).intValue();
            } catch (NumberFormatException e2) {
                e2.printStackTrace();
                return 0;
            }
        }
        return invokeV.intValue;
    }

    public static boolean b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) ? ((SensorManager) context.getSystemService("sensor")).getDefaultSensor(4) != null : invokeL.booleanValue;
    }
}
