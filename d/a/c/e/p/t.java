package d.a.c.e.p;

import android.graphics.Paint;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class t {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static int a(float f2, Paint paint, String str, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65536, null, new Object[]{Float.valueOf(f2), paint, str, Integer.valueOf(i2)})) == null) {
            if (f2 == 0.0f || i2 == 0 || str == null || str.isEmpty()) {
                return 0;
            }
            return Math.min((int) Math.ceil(paint.measureText(str) / f2), i2);
        }
        return invokeCommon.intValue;
    }

    public static boolean b(float f2, Paint paint, String str, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{Float.valueOf(f2), paint, str, Integer.valueOf(i2)})) == null) ? c(f2, paint, str, i2, 5) : invokeCommon.booleanValue;
    }

    public static boolean c(float f2, Paint paint, String str, int i2, int i3) {
        InterceptResult invokeCommon;
        float measureText;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, null, new Object[]{Float.valueOf(f2), paint, str, Integer.valueOf(i2), Integer.valueOf(i3)})) == null) {
            float f3 = 0.0f;
            if (f2 != 0.0f && i2 != 0 && str != null && !str.isEmpty() && paint != null) {
                if (!str.contains("\n")) {
                    return paint.measureText(str) >= f2 * ((float) i2);
                }
                String[] split = str.split("\n");
                if (split.length > i2) {
                    return true;
                }
                int i4 = 0;
                for (int i5 = 0; i5 < i2 && split.length > i5; i5++) {
                    if (i5 < i2 - 1) {
                        measureText = paint.measureText(split[i5]);
                        int ceil = (int) Math.ceil(measureText / f2);
                        i4 += ceil;
                        if (i4 < i3) {
                            measureText = ceil * f2;
                        }
                    } else {
                        measureText = paint.measureText(split[i5]);
                        i4++;
                    }
                    f3 += measureText;
                    if (i4 >= 5) {
                        return f3 >= f2 * ((float) i2);
                    }
                }
            }
            return false;
        }
        return invokeCommon.booleanValue;
    }
}
