package com.yy.mobile.framework.revenuesdk.baseapi.utils;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
/* loaded from: classes4.dex */
public class SPUtils {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String FILE_NAME = "revenuesdk_share_data";
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes4.dex */
    public static class SharedPreferencesCompat {
        public static /* synthetic */ Interceptable $ic;
        public static final Method sApplyMethod;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(418193058, "Lcom/yy/mobile/framework/revenuesdk/baseapi/utils/SPUtils$SharedPreferencesCompat;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(418193058, "Lcom/yy/mobile/framework/revenuesdk/baseapi/utils/SPUtils$SharedPreferencesCompat;");
                    return;
                }
            }
            sApplyMethod = findApplyMethod();
        }

        public SharedPreferencesCompat() {
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

        public static void apply(SharedPreferences.Editor editor) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(65538, null, editor) == null) {
                try {
                    if (sApplyMethod != null) {
                        sApplyMethod.invoke(editor, new Object[0]);
                        return;
                    }
                } catch (IllegalAccessException e2) {
                    e2.printStackTrace();
                } catch (IllegalArgumentException e3) {
                    e3.printStackTrace();
                } catch (InvocationTargetException e4) {
                    e4.printStackTrace();
                }
                editor.commit();
            }
        }

        public static Method findApplyMethod() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
                try {
                    return SharedPreferences.Editor.class.getMethod("apply", new Class[0]);
                } catch (NoSuchMethodException e2) {
                    e2.printStackTrace();
                    return null;
                }
            }
            return (Method) invokeV.objValue;
        }
    }

    public SPUtils() {
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

    public static void clear(Context context) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65537, null, context) == null) || context == null) {
            return;
        }
        SharedPreferences.Editor edit = context.getSharedPreferences(FILE_NAME, 0).edit();
        edit.clear();
        SharedPreferencesCompat.apply(edit);
    }

    public static boolean contains(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, context, str)) == null) {
            if (context == null || str == null) {
                return false;
            }
            return context.getSharedPreferences(FILE_NAME, 0).contains(str);
        }
        return invokeLL.booleanValue;
    }

    public static Object get(Context context, String str, Object obj) {
        InterceptResult invokeLLL;
        SharedPreferences sharedPreferences;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65539, null, context, str, obj)) == null) {
            if (context == null || str == null || obj == null || (sharedPreferences = context.getSharedPreferences(FILE_NAME, 0)) == null) {
                return null;
            }
            if (obj instanceof String) {
                return sharedPreferences.getString(str, (String) obj);
            }
            if (obj instanceof Integer) {
                return Integer.valueOf(sharedPreferences.getInt(str, ((Integer) obj).intValue()));
            }
            if (obj instanceof Boolean) {
                return Boolean.valueOf(sharedPreferences.getBoolean(str, ((Boolean) obj).booleanValue()));
            }
            if (obj instanceof Float) {
                return Float.valueOf(sharedPreferences.getFloat(str, ((Float) obj).floatValue()));
            }
            if (obj instanceof Long) {
                return Long.valueOf(sharedPreferences.getLong(str, ((Long) obj).longValue()));
            }
            return null;
        }
        return invokeLLL.objValue;
    }

    public static Map<String, ?> getAll(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, context)) == null) {
            if (context == null) {
                return null;
            }
            return context.getSharedPreferences(FILE_NAME, 0).getAll();
        }
        return (Map) invokeL.objValue;
    }

    public static void put(Context context, String str, Object obj) {
        SharedPreferences sharedPreferences;
        SharedPreferences.Editor edit;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65541, null, context, str, obj) == null) || context == null || str == null || obj == null || (sharedPreferences = context.getSharedPreferences(FILE_NAME, 0)) == null || (edit = sharedPreferences.edit()) == null) {
            return;
        }
        if (obj instanceof String) {
            edit.putString(str, (String) obj);
        } else if (obj instanceof Integer) {
            edit.putInt(str, ((Integer) obj).intValue());
        } else if (obj instanceof Boolean) {
            edit.putBoolean(str, ((Boolean) obj).booleanValue());
        } else if (obj instanceof Float) {
            edit.putFloat(str, ((Float) obj).floatValue());
        } else if (obj instanceof Long) {
            edit.putLong(str, ((Long) obj).longValue());
        } else {
            edit.putString(str, obj.toString());
        }
        SharedPreferencesCompat.apply(edit);
    }

    public static void remove(Context context, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65542, null, context, str) == null) || context == null || str == null) {
            return;
        }
        SharedPreferences.Editor edit = context.getSharedPreferences(FILE_NAME, 0).edit();
        edit.remove(str);
        SharedPreferencesCompat.apply(edit);
    }
}
