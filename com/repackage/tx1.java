package com.repackage;

import android.text.TextUtils;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes7.dex */
public class tx1 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public static final Map<String, zm1> b;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755275484, "Lcom/repackage/tx1;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755275484, "Lcom/repackage/tx1;");
                return;
            }
        }
        a = eh1.a;
        b = new HashMap(2);
    }

    public static zm1 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (a) {
                Log.d("ConsoleCache", "create new sConsole");
            }
            ux1.n(true);
            return o72.U().f0().b(AppRuntime.getAppContext());
        }
        return (zm1) invokeV.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x002d A[Catch: all -> 0x006f, TryCatch #0 {, blocks: (B:6:0x0007, B:8:0x000d, B:11:0x0018, B:13:0x001f, B:15:0x002d, B:17:0x003d, B:18:0x0053, B:20:0x0057), top: B:30:0x0007 }] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0057 A[Catch: all -> 0x006f, TRY_LEAVE, TryCatch #0 {, blocks: (B:6:0x0007, B:8:0x000d, B:11:0x0018, B:13:0x001f, B:15:0x002d, B:17:0x003d, B:18:0x0053, B:20:0x0057), top: B:30:0x0007 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static synchronized zm1 b() {
        InterceptResult invokeV;
        String str;
        zm1 zm1Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            synchronized (tx1.class) {
                u03 a0 = u03.a0();
                if (a0 != null && !TextUtils.isEmpty(a0.getAppId())) {
                    str = a0.getAppId();
                    String a2 = ws1.a(str);
                    zm1Var = b.get(a2);
                    if (zm1Var == null) {
                        e();
                        zm1Var = a();
                        b.put(a2, zm1Var);
                        if (a) {
                            Log.d("ConsoleCache", "can not find sconsole for appId - " + str);
                        }
                    }
                    if (a) {
                        Log.d("ConsoleCache", "get sconsole for appId - " + str);
                    }
                }
                str = "_no_id_";
                String a22 = ws1.a(str);
                zm1Var = b.get(a22);
                if (zm1Var == null) {
                }
                if (a) {
                }
            }
            return zm1Var;
        }
        return (zm1) invokeV.objValue;
    }

    public static boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            u03 a0 = u03.a0();
            if (a0 != null && !TextUtils.isEmpty(a0.b)) {
                return sx1.b(ws1.a(a0.b));
            }
            if (a) {
                Log.w("ConsoleCache", "swanApp is null or appId is empty");
                return false;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public static void d() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null) == null) && c()) {
            b();
        }
    }

    public static synchronized void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65541, null) == null) {
            synchronized (tx1.class) {
                if (b.size() > 0) {
                    for (String str : b.keySet()) {
                        zm1 zm1Var = b.get(str);
                        if (zm1Var != null) {
                            zm1Var.G();
                        }
                    }
                    b.clear();
                }
            }
        }
    }
}
