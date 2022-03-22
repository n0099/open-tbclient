package com.tachikoma.core.debug;

import android.content.Context;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.v8.V8;
import java.lang.reflect.Method;
/* loaded from: classes7.dex */
public class TKDebuggerUtils {
    public static /* synthetic */ Interceptable $ic;
    public static Class<?> sDebuggerHelper;
    public static Method sDisableAll;
    public static Method sDisableDebug;
    public static Method sEnableDebug;
    public static Method sGenContextName;
    public static Method sGenScriptName;
    public static Method sInitializeTKDebugger;
    public static Method sOnExecuteScript;
    public transient /* synthetic */ FieldHolder $fh;

    public TKDebuggerUtils() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static void disableDebug(@NonNull String str) {
        Class<?> cls;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65537, null, str) == null) || (cls = sDebuggerHelper) == null) {
            return;
        }
        try {
            if (sDisableDebug == null) {
                sDisableDebug = cls.getDeclaredMethod("disableDebug", String.class);
            }
            sDisableDebug.invoke(null, str);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static void disableDebugAll() {
        Class<?> cls;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65538, null) == null) || (cls = sDebuggerHelper) == null) {
            return;
        }
        try {
            if (sDisableAll == null) {
                sDisableAll = cls.getDeclaredMethod("disableDebug", new Class[0]);
            }
            sDisableAll.invoke(null, new Object[0]);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static void enableDebug(@NonNull V8 v8, @NonNull String str, @Nullable View view) {
        Class<?> cls;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65539, null, v8, str, view) == null) || (cls = sDebuggerHelper) == null) {
            return;
        }
        try {
            if (sEnableDebug == null) {
                sEnableDebug = cls.getDeclaredMethod("enableDebug", V8.class, String.class, View.class);
            }
            sEnableDebug.invoke(null, v8, str, view);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static String genContextName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            Class<?> cls = sDebuggerHelper;
            if (cls != null) {
                try {
                    if (sGenContextName == null) {
                        sGenContextName = cls.getDeclaredMethod("genContextName", new Class[0]);
                    }
                    return sGenContextName.invoke(null, new Object[0]).toString();
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
            return "";
        }
        return (String) invokeV.objValue;
    }

    public static String genScriptName(@Nullable String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, str)) == null) {
            Class<?> cls = sDebuggerHelper;
            if (cls != null) {
                try {
                    if (sGenScriptName == null) {
                        sGenScriptName = cls.getDeclaredMethod("genScriptName", new Class[0]);
                    }
                    return sGenScriptName.invoke(null, new Object[0]).toString();
                } catch (Exception e2) {
                    e2.printStackTrace();
                    return str;
                }
            }
            return str;
        }
        return (String) invokeL.objValue;
    }

    public static boolean hasDebugger(@NonNull ClassLoader classLoader) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, classLoader)) == null) {
            try {
                Class<?> loadClass = classLoader.loadClass("com.tachikoma.debugger.TKDebuggerHelper");
                sDebuggerHelper = loadClass;
                return loadClass != null;
            } catch (Exception unused) {
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public static void initializeTKDebugger(@NonNull Context context) {
        Class<?> cls;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65543, null, context) == null) || (cls = sDebuggerHelper) == null) {
            return;
        }
        try {
            if (sInitializeTKDebugger == null) {
                sInitializeTKDebugger = cls.getDeclaredMethod("initializeTKDebugger", Context.class);
            }
            sInitializeTKDebugger.invoke(null, context);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static void onExecuteScript(@NonNull String str, @NonNull String str2, @NonNull String str3, @Nullable String str4, int i) {
        Class<?> cls;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65544, null, new Object[]{str, str2, str3, str4, Integer.valueOf(i)}) == null) || (cls = sDebuggerHelper) == null) {
            return;
        }
        try {
            if (sOnExecuteScript == null) {
                sOnExecuteScript = cls.getDeclaredMethod("onExecuteScript", String.class, String.class, String.class, String.class, Integer.TYPE);
            }
            sOnExecuteScript.invoke(null, str, str2, str3, str4, Integer.valueOf(i));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
