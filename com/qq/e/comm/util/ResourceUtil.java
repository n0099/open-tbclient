package com.qq.e.comm.util;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.reflect.Field;
/* loaded from: classes8.dex */
public class ResourceUtil {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public ResourceUtil() {
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

    public static int getColorId(Context context, String str) {
        InterceptResult invokeLL;
        Resources resources;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, context, str)) == null) {
            if (context == null || TextUtils.isEmpty(str) || (resources = context.getResources()) == null) {
                return -1;
            }
            return resources.getIdentifier(str, "color", context.getPackageName());
        }
        return invokeLL.intValue;
    }

    public static int getDrawableId(Context context, String str) {
        InterceptResult invokeLL;
        Resources resources;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, context, str)) == null) {
            if (context == null || TextUtils.isEmpty(str) || (resources = context.getResources()) == null) {
                return -1;
            }
            return resources.getIdentifier(str, "drawable", context.getPackageName());
        }
        return invokeLL.intValue;
    }

    public static int getId(Context context, String str) {
        InterceptResult invokeLL;
        Resources resources;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, context, str)) == null) {
            if (context == null || TextUtils.isEmpty(str) || (resources = context.getResources()) == null) {
                return -1;
            }
            return resources.getIdentifier(str, "id", context.getPackageName());
        }
        return invokeLL.intValue;
    }

    public static int getLayoutId(Context context, String str) {
        InterceptResult invokeLL;
        Resources resources;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, context, str)) == null) {
            if (context == null || TextUtils.isEmpty(str) || (resources = context.getResources()) == null) {
                return -1;
            }
            return resources.getIdentifier(str, "layout", context.getPackageName());
        }
        return invokeLL.intValue;
    }

    public static int getStringId(Context context, String str) {
        InterceptResult invokeLL;
        Resources resources;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65541, null, context, str)) == null) {
            if (context == null || TextUtils.isEmpty(str) || (resources = context.getResources()) == null) {
                return -1;
            }
            return resources.getIdentifier(str, "string", context.getPackageName());
        }
        return invokeLL.intValue;
    }

    public static int getStyleId(Context context, String str) {
        InterceptResult invokeLL;
        Resources resources;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65542, null, context, str)) == null) {
            if (context == null || TextUtils.isEmpty(str) || (resources = context.getResources()) == null) {
                return -1;
            }
            return resources.getIdentifier(str, "style", context.getPackageName());
        }
        return invokeLL.intValue;
    }

    public static int getStyleableFieldId(Context context, String str, String str2) {
        InterceptResult invokeLLL;
        Class<?>[] classes;
        Field[] fields;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65543, null, context, str, str2)) == null) {
            String str3 = str + "_" + str2;
            try {
                for (Class<?> cls : Class.forName(context.getPackageName() + ".R").getClasses()) {
                    if (cls.getSimpleName().equals("styleable")) {
                        for (Field field : cls.getFields()) {
                            if (field.getName().equals(str3)) {
                                return ((Integer) field.get(null)).intValue();
                            }
                        }
                        continue;
                    }
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
            return 0;
        }
        return invokeLLL.intValue;
    }

    public static int[] getStyleableIntArray(Context context, String str) {
        InterceptResult invokeLL;
        Field[] fields;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65544, null, context, str)) == null) {
            try {
                for (Field field : Class.forName(context.getPackageName() + ".R$styleable").getFields()) {
                    if (field.getName().equals(str)) {
                        return (int[]) field.get(null);
                    }
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
            return null;
        }
        return (int[]) invokeLL.objValue;
    }
}
