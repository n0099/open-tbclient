package d.h.b.a;

import android.content.Context;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.lang.reflect.Method;
/* loaded from: classes8.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static String a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, context)) == null) {
            d b2 = d.b();
            return b2.c(context.getApplicationContext(), b2.f70974a);
        }
        return (String) invokeL.objValue;
    }

    public static final boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            Context context = null;
            try {
                Method method = Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]);
                method.setAccessible(true);
                context = (Context) method.invoke(null, new Object[0]);
            } catch (Exception e2) {
                Log.e("OpenIdHelper", "ActivityThread:currentApplication --> " + e2.toString());
            }
            if (context == null) {
                return false;
            }
            return d.b().f(context, false);
        }
        return invokeV.booleanValue;
    }

    public static String c(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            d b2 = d.b();
            return b2.c(context.getApplicationContext(), b2.f70975b);
        }
        return (String) invokeL.objValue;
    }

    public static String d(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, context)) == null) {
            d b2 = d.b();
            return b2.c(context.getApplicationContext(), b2.f70977d);
        }
        return (String) invokeL.objValue;
    }

    public static String e(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, context)) == null) {
            d b2 = d.b();
            return b2.c(context.getApplicationContext(), b2.f70976c);
        }
        return (String) invokeL.objValue;
    }
}
