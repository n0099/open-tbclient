package d.a.e0.n;

import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class d {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: a  reason: collision with root package name */
    public static String f42678a = null;

    /* renamed from: b  reason: collision with root package name */
    public static String f42679b = null;

    /* renamed from: c  reason: collision with root package name */
    public static int f42680c = 0;

    /* renamed from: d  reason: collision with root package name */
    public static boolean f42681d = true;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(String str, Throwable th) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65536, null, str, th) == null) && f42681d) {
            c(new Throwable().getStackTrace());
            Log.e("CashierSdk", d(str), th);
        }
    }

    public static void b(Object... objArr) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65537, null, objArr) == null) && f42681d) {
            c(new Throwable().getStackTrace());
            Log.e("CashierSdk", d(objArr));
        }
    }

    public static void c(StackTraceElement[] stackTraceElementArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, stackTraceElementArr) == null) {
            f42678a = stackTraceElementArr[1].getFileName();
            f42679b = stackTraceElementArr[1].getMethodName();
            f42680c = stackTraceElementArr[1].getLineNumber();
        }
    }

    public static String d(Object... objArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, objArr)) == null) {
            if (objArr == null) {
                return "";
            }
            StringBuilder sb = new StringBuilder();
            for (Object obj : objArr) {
                if (obj != null) {
                    sb.append(obj.toString());
                }
            }
            return f(sb.toString());
        }
        return (String) invokeL.objValue;
    }

    public static void e(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str) == null) && f42681d) {
            Log.i("CashierSdk", str);
        }
    }

    public static String f(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, str)) == null) {
            return Thread.currentThread().getName() + PreferencesUtil.LEFT_MOUNT + f42678a + ":" + f42679b + ":" + f42680c + PreferencesUtil.RIGHT_MOUNT + str;
        }
        return (String) invokeL.objValue;
    }
}
