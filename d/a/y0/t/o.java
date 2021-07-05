package d.a.y0.t;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.lang.reflect.Method;
/* loaded from: classes9.dex */
public class o {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static float a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            long[] b2 = b();
            if (b2[0] <= 0) {
                return 0.0f;
            }
            return 1.0f - (((float) ((b2[1] + b2[2]) + b2[3])) / ((float) b2[0]));
        }
        return invokeV.floatValue;
    }

    public static long[] b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            long[] jArr = new long[4];
            try {
                Method method = Class.forName("android.os.Process").getMethod("readProcLines", String.class, String[].class, long[].class);
                long[] jArr2 = {30, -30};
                Object[] objArr = {new String("/proc/meminfo"), new String[]{"MemTotal:", "MemFree:", "Buffers:", "Cached:"}, jArr2};
                if (method != null) {
                    method.invoke(null, objArr);
                    for (int i2 = 0; i2 < 4; i2++) {
                        jArr[i2] = jArr2[i2] / 1024;
                    }
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            return jArr;
        }
        return (long[]) invokeV.objValue;
    }
}
