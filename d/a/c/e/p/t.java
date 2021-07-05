package d.a.c.e.p;

import android.graphics.Paint;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes8.dex */
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
        float measureText;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{Float.valueOf(f2), paint, str, Integer.valueOf(i2)})) == null) {
            float f3 = 0.0f;
            if (f2 != 0.0f && i2 != 0 && str != null && !str.isEmpty() && paint != null) {
                if (!str.contains("\n")) {
                    return paint.measureText(str) >= f2 * ((float) i2);
                }
                String[] split = str.split("\n");
                if (split.length > i2) {
                    return true;
                }
                int i3 = 0;
                for (int i4 = 0; i4 < i2 && split.length > i4; i4++) {
                    if (i4 < i2 - 1) {
                        measureText = paint.measureText(split[i4]);
                        int ceil = (int) Math.ceil(measureText / f2);
                        i3 += ceil;
                        if (i3 < 5) {
                            measureText = ceil * f2;
                        }
                    } else {
                        measureText = paint.measureText(split[i4]);
                        i3++;
                    }
                    f3 += measureText;
                    if (i3 >= 5) {
                        return f3 >= f2 * ((float) i2);
                    }
                }
            }
            return false;
        }
        return invokeCommon.booleanValue;
    }
}
