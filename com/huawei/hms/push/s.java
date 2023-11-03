package com.huawei.hms.push;

import android.content.Context;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.tieba.n6c;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.huawei.hms.android.HwBuildEx;
import com.huawei.hms.support.log.HMSLog;
import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public abstract class s {
    public static /* synthetic */ Interceptable $ic = null;
    public static final Object a;
    public static int b = -1;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1428231854, "Lcom/huawei/hms/push/s;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1428231854, "Lcom/huawei/hms/push/s;");
                return;
            }
        }
        a = new Object();
    }

    public static boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
            if (HwBuildEx.VERSION.EMUI_SDK_INT >= 21) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public static boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
            if (HwBuildEx.VERSION.EMUI_SDK_INT < 19) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public static boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            try {
                Class<?> cls = Class.forName("huawei.cust.HwCfgFilePolicy");
                int intValue = ((Integer) cls.getDeclaredField("CUST_TYPE_CONFIG").get(cls)).intValue();
                Method declaredMethod = cls.getDeclaredMethod("getCfgFile", String.class, Integer.TYPE);
                Object[] objArr = new Object[2];
                objArr[0] = "jars/hwpush.jar";
                objArr[1] = Integer.valueOf(intValue);
                File file = (File) declaredMethod.invoke(cls, objArr);
                if (file != null && file.exists()) {
                    HMSLog.d("CommFun", "get push cust File path success.");
                    return true;
                }
            } catch (ClassNotFoundException unused) {
                HMSLog.e("CommFun", "HwCfgFilePolicy ClassNotFoundException");
            } catch (IllegalAccessException unused2) {
                HMSLog.e("CommFun", "check cust exist push IllegalAccessException.");
            } catch (IllegalArgumentException unused3) {
                HMSLog.e("CommFun", "check cust exist push IllegalArgumentException.");
            } catch (NoSuchFieldException unused4) {
                HMSLog.e("CommFun", "check cust exist push NoSuchFieldException.");
            } catch (NoSuchMethodException unused5) {
                HMSLog.e("CommFun", "check cust exist push NoSuchMethodException.");
            } catch (SecurityException unused6) {
                HMSLog.e("CommFun", "check cust exist push SecurityException.");
            } catch (InvocationTargetException unused7) {
                HMSLog.e("CommFun", "check cust exist push InvocationTargetException.");
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public static boolean a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            HMSLog.d("CommFun", "existFrameworkPush:" + b);
            try {
                File file = new File("/system/framework/hwpush.jar");
                if (a()) {
                    HMSLog.d("CommFun", "push jarFile is exist");
                    return true;
                } else if (!file.isFile()) {
                    return false;
                } else {
                    HMSLog.d("CommFun", "push jarFile is exist");
                    return true;
                }
            } catch (Exception e) {
                HMSLog.e("CommFun", "get Apk version faild ,Exception e= " + e.toString());
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public static boolean a(JSONObject jSONObject, JSONObject jSONObject2, String str) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65539, null, jSONObject, jSONObject2, str)) == null) {
            if (jSONObject != null && (!TextUtils.isEmpty(str) || jSONObject2 != null)) {
                return false;
            }
            return true;
        }
        return invokeLLL.booleanValue;
    }

    public static long b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, context)) == null) {
            try {
                return context.getPackageManager().getPackageInfo("com.huawei.android.pushagent", 16384).versionCode;
            } catch (Exception unused) {
                HMSLog.e("CommFun", "get nc versionCode error");
                return -1L;
            }
        }
        return invokeL.longValue;
    }

    public static String c(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, context)) == null) {
            return n6c.c(context).a("client/project_id");
        }
        return (String) invokeL.objValue;
    }

    public static boolean d(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, context)) == null) {
            HMSLog.d("CommFun", "existFrameworkPush:" + b);
            synchronized (a) {
                boolean z = false;
                if (-1 != b) {
                    if (1 == b) {
                        z = true;
                    }
                    return z;
                }
                if (a(context)) {
                    b = 1;
                } else {
                    b = 0;
                }
                if (1 != b) {
                    return false;
                }
                return true;
            }
        }
        return invokeL.booleanValue;
    }
}
