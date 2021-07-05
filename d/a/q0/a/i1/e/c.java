package d.a.q0.a.i1.e;

import android.content.Context;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes8.dex */
public final class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(Context context, Drawable drawable, PorterDuff.Mode mode, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLI(65536, null, context, drawable, mode, i2) == null) || context == null || drawable == null) {
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
        if (interceptable == null || interceptable.invokeLL(65537, null, context, drawable) == null) {
            c(context, drawable, 255);
        }
    }

    public static void c(Context context, Drawable drawable, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(65538, null, context, drawable, i2) == null) {
            a(context, drawable, PorterDuff.Mode.SRC_ATOP, i2);
        }
    }

    public static int d(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, context)) == null) {
            return 0;
        }
        return invokeL.intValue;
    }
}
