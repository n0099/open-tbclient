package com.sdk.i;

import android.content.Context;
import android.telephony.TelephonyManager;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.sdk.f.g;
import java.lang.reflect.Method;
/* loaded from: classes8.dex */
public class a {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "a";
    public static final boolean isDebug;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1593077969, "Lcom/sdk/i/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1593077969, "Lcom/sdk/i/a;");
                return;
            }
        }
        isDebug = g.b;
    }

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static Object invokeOnSubscriptionManager(Context context, String str, Boolean bool, Class<?>[] clsArr, Object[] objArr) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(65538, null, context, str, bool, clsArr, objArr)) == null) {
            Object obj = null;
            try {
                Class<?> cls = Class.forName("android.telephony.SubscriptionManager");
                Class<?>[] clsArr2 = new Class[1];
                clsArr2[0] = Class.forName("android.content.Context");
                Object newInstance = cls.getConstructor(clsArr2).newInstance(context);
                Method declaredMethod = cls.getDeclaredMethod(str, clsArr);
                declaredMethod.setAccessible(true);
                obj = bool.booleanValue() ? declaredMethod.invoke(null, objArr) : declaredMethod.invoke(newInstance, objArr);
            } catch (Exception unused) {
            }
            return obj;
        }
        return invokeLLLLL.objValue;
    }

    public static Object invokeOnTelephonyManager(Context context, String str, Boolean bool, Class<?>[] clsArr, Object[] objArr) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(65539, null, context, str, bool, clsArr, objArr)) == null) {
            Object obj = null;
            try {
                TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                Method declaredMethod = Class.forName(telephonyManager.getClass().getName()).getDeclaredMethod(str, clsArr);
                declaredMethod.setAccessible(true);
                obj = bool.booleanValue() ? declaredMethod.invoke(null, objArr) : declaredMethod.invoke(telephonyManager, objArr);
            } catch (Exception e) {
                com.sdk.n.a.a(TAG, e.getMessage(), Boolean.valueOf(isDebug));
            }
            return obj;
        }
        return invokeLLLLL.objValue;
    }

    public static void logError(String str, String str2, Object obj, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{str, str2, obj, Boolean.valueOf(z)}) == null) && z) {
            Log.e(str, "==>" + str2 + "\n==>" + obj);
        }
    }

    public static void logInfo(String str, String str2, Object obj, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65541, null, new Object[]{str, str2, obj, Boolean.valueOf(z)}) == null) && z) {
            Log.i(str, "==>" + str2 + "\n==>" + obj);
        }
    }
}
