package com.dxmpay.apollon.utils;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.idl.license.License;
import com.baidu.pass.main.facesdk.FaceAuth;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.reflect.Method;
/* loaded from: classes2.dex */
public class CheckDefaultSoExist {
    public static /* synthetic */ Interceptable $ic;
    public static final String[] FACE_SO_NAME_ARRAY;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-2119478099, "Lcom/dxmpay/apollon/utils/CheckDefaultSoExist;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-2119478099, "Lcom/dxmpay/apollon/utils/CheckDefaultSoExist;");
                return;
            }
        }
        FACE_SO_NAME_ARRAY = new String[]{License.LICENSE_ASSETS_FILE, FaceAuth.TAG};
    }

    public CheckDefaultSoExist() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static String a(Context context, String str) {
        InterceptResult invokeLL;
        Object invoke;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, context, str)) == null) {
            ClassLoader classLoader = context.getClassLoader();
            if (classLoader == null) {
                return null;
            }
            try {
                Method method = classLoader.getClass().getMethod("findLibrary", String.class);
                if (method != null && (invoke = method.invoke(classLoader, str)) != null && (invoke instanceof String)) {
                    return (String) invoke;
                }
                return null;
            } catch (Exception e2) {
                LogUtil.errord("findLibrary1", e2.toString());
                return "catch Exception";
            }
        }
        return (String) invokeLL.objValue;
    }

    public static String b(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, context, str)) == null) {
            ClassLoader classLoader = context.getClassLoader();
            if (classLoader == null) {
                return null;
            }
            try {
                Method declaredMethod = classLoader.getClass().getDeclaredMethod("findLibrary", String.class);
                if (declaredMethod == null) {
                    return null;
                }
                if (!declaredMethod.isAccessible()) {
                    declaredMethod.setAccessible(true);
                }
                Object invoke = declaredMethod.invoke(classLoader, str);
                if (invoke != null && (invoke instanceof String)) {
                    return (String) invoke;
                }
                return null;
            } catch (Exception e2) {
                LogUtil.errord("findLibrary2", e2.toString());
                return "catch Exception";
            }
        }
        return (String) invokeLL.objValue;
    }

    public static boolean isExist(Context context, String[] strArr) {
        InterceptResult invokeLL;
        String b2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, context, strArr)) == null) {
            if (strArr != null && strArr.length > 0) {
                for (String str : strArr) {
                    if (Build.VERSION.SDK_INT > 8) {
                        b2 = a(context, str);
                    } else {
                        b2 = b(context, str);
                    }
                    if (!TextUtils.isEmpty(b2)) {
                        LogUtil.i("CheckDefaultSoExist", "so is all exist");
                        return true;
                    }
                    LogUtil.errord("CheckDefaultSoExist", str + " so is not exist ,please put the " + str + " so file in the right folder");
                }
            }
            return false;
        }
        return invokeLL.booleanValue;
    }
}
