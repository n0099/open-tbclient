package d.a.o0.a.v2;

import android.content.Context;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public final class b0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-968395503, "Ld/a/o0/a/v2/b0;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-968395503, "Ld/a/o0/a/v2/b0;");
                return;
            }
        }
        boolean z = d.a.o0.a.k.f46335a;
    }

    public static void a(Context context, Drawable drawable, PorterDuff.Mode mode, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLI(65537, null, context, drawable, mode, i2) == null) || context == null || drawable == null) {
            return;
        }
        int d2 = d(context);
        if (i2 >= 0 && i2 < 255) {
            d2 = Color.argb((Color.alpha(d2) * i2) / 255, Color.red(d2), Color.green(d2), Color.blue(d2));
        }
        drawable.setColorFilter(d2, mode);
    }

    public static void b(Context context, Drawable drawable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, context, drawable) == null) {
            c(context, drawable, 255);
        }
    }

    public static void c(Context context, Drawable drawable, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(65539, null, context, drawable, i2) == null) {
            a(context, drawable, PorterDuff.Mode.SRC_ATOP, i2);
        }
    }

    public static int d(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, context)) == null) ? context.getResources().getColor(d.a.o0.a.c.aiapps_ui_cover_layer_color) : invokeL.intValue;
    }
}
