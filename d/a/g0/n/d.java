package d.a.g0.n;

import android.util.Log;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes8.dex */
public class d {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: a  reason: collision with root package name */
    public static String f45493a = null;

    /* renamed from: b  reason: collision with root package name */
    public static String f45494b = null;

    /* renamed from: c  reason: collision with root package name */
    public static int f45495c = 0;

    /* renamed from: d  reason: collision with root package name */
    public static boolean f45496d = true;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(String str, Throwable th) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65536, null, str, th) == null) && f45496d) {
            c(new Throwable().getStackTrace());
            Log.e("CashierSdk", d(str), th);
        }
    }

    public static void b(Object... objArr) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65537, null, objArr) == null) && f45496d) {
            c(new Throwable().getStackTrace());
            Log.e("CashierSdk", d(objArr));
        }
    }

    public static void c(StackTraceElement[] stackTraceElementArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, stackTraceElementArr) == null) {
            f45493a = stackTraceElementArr[1].getFileName();
            f45494b = stackTraceElementArr[1].getMethodName();
            f45495c = stackTraceElementArr[1].getLineNumber();
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
        if ((interceptable == null || interceptable.invokeL(65540, null, str) == null) && f45496d) {
            Log.i("CashierSdk", str);
        }
    }

    public static String f(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, str)) == null) {
            return Thread.currentThread().getName() + PreferencesUtil.LEFT_MOUNT + f45493a + ":" + f45494b + ":" + f45495c + PreferencesUtil.RIGHT_MOUNT + str;
        }
        return (String) invokeL.objValue;
    }
}
