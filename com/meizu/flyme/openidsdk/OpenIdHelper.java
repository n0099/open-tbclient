package com.meizu.flyme.openidsdk;

import android.content.Context;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.reflect.Method;
/* loaded from: classes4.dex */
public class OpenIdHelper {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "OpenIdHelper";
    public transient /* synthetic */ FieldHolder $fh;

    public OpenIdHelper() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static String getAAID(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
            b a = b.a();
            return a.a(context.getApplicationContext(), a.f59064c);
        }
        return (String) invokeL.objValue;
    }

    public static String getOAID(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            b a = b.a();
            return a.a(context.getApplicationContext(), a.f59063b);
        }
        return (String) invokeL.objValue;
    }

    public static String getUDID(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, context)) == null) {
            b a = b.a();
            return a.a(context.getApplicationContext(), a.a);
        }
        return (String) invokeL.objValue;
    }

    public static String getVAID(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, context)) == null) {
            b a = b.a();
            return a.a(context.getApplicationContext(), a.f59065d);
        }
        return (String) invokeL.objValue;
    }

    public static final boolean isSupported() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
            Context context = null;
            try {
                Method method = Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]);
                method.setAccessible(true);
                context = (Context) method.invoke(null, new Object[0]);
            } catch (Exception e2) {
                String str = "ActivityThread:currentApplication --> " + e2.toString();
            }
            if (context == null) {
                return false;
            }
            return b.a().a(context, false);
        }
        return invokeV.booleanValue;
    }

    public static void setLogEnable(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65542, null, z) == null) {
            b.a().a(z);
        }
    }
}
