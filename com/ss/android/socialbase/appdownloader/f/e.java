package com.ss.android.socialbase.appdownloader.f;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.os.Process;
import android.telephony.TelephonyManager;
import androidx.annotation.NonNull;
import androidx.annotation.WorkerThread;
import androidx.core.view.InputDeviceCompat;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.ss.android.socialbase.downloader.i.f;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
/* loaded from: classes2.dex */
public class e {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static Boolean f69026a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1108190700, "Lcom/ss/android/socialbase/appdownloader/f/e;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1108190700, "Lcom/ss/android/socialbase/appdownloader/f/e;");
        }
    }

    public static boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            Boolean bool = f69026a;
            if (bool == null) {
                return true;
            }
            return bool.booleanValue();
        }
        return invokeV.booleanValue;
    }

    public static boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            if (d() == 0) {
                return true;
            }
            return e();
        }
        return invokeV.booleanValue;
    }

    public static boolean c(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, context)) == null) {
            Intent registerReceiver = context.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
            return registerReceiver != null && registerReceiver.getIntExtra("plugged", -1) == 2;
        }
        return invokeL.booleanValue;
    }

    public static int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) {
            String str = null;
            try {
                Object invoke = Class.forName("android.os.SystemProperties").getMethod("get", String.class).invoke(null, a("726f2e736563757265"));
                if (invoke != null) {
                    str = (String) invoke;
                }
            } catch (Exception unused) {
            }
            return (str != null && "0".equals(str)) ? 0 : 1;
        }
        return invokeV.intValue;
    }

    public static boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65546, null)) == null) {
            String[] strArr = {a("2f7362696e2f7375"), a("2f73797374656d2f62696e2f7375"), a("2f73797374656d2f7862696e2f7375"), a("2f646174612f6c6f63616c2f7862696e2f7375"), a("2f646174612f6c6f63616c2f62696e2f7375"), a("2f73797374656d2f73642f7862696e2f7375"), a("2f73797374656d2f62696e2f6661696c736166652f7375"), a("2f646174612f6c6f63616c2f7375")};
            for (int i2 = 0; i2 < 8; i2++) {
                if (new File(strArr[i2]).exists()) {
                    return true;
                }
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0060 A[Catch: Exception -> 0x008d, TryCatch #0 {Exception -> 0x008d, blocks: (B:4:0x0004, B:5:0x002d, B:7:0x0034, B:9:0x003c, B:11:0x0044, B:12:0x0053, B:13:0x005a, B:15:0x0060, B:18:0x0073, B:21:0x0080), top: B:31:0x0004 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65548, null)) == null) {
            try {
                HashSet<String> hashSet = new HashSet();
                BufferedReader bufferedReader = new BufferedReader(new FileReader("/proc/" + Process.myPid() + "/maps"));
                while (true) {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        break;
                    } else if (readLine.endsWith(".so") || readLine.endsWith(".jar")) {
                        hashSet.add(readLine.substring(readLine.lastIndexOf(" ") + 1));
                    }
                }
                bufferedReader.close();
                for (String str : hashSet) {
                    if (str.contains(a("636f6d2e73617572696b2e737562737472617465")) || str.contains(a("58706f7365644272696467652e6a6172")) || str.contains(a("6c696273616e64686f6f6b2e656478702e736f"))) {
                        return true;
                    }
                    while (r0.hasNext()) {
                    }
                }
                return false;
            } catch (Exception unused) {
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    @WorkerThread
    public static synchronized void a(@NonNull Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, context) == null) {
            synchronized (e.class) {
                if (f69026a == null) {
                    f69026a = Boolean.valueOf((b() || b(context) || c(context) || !d(context) || c() || e(context)) ? false : true);
                }
            }
        }
    }

    public static boolean b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, context)) == null) {
            try {
                return (context.getApplicationInfo().flags & 2) != 0;
            } catch (Exception unused) {
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    @WorkerThread
    public static boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, null)) == null) {
            try {
                InetAddress.getByName("127.0.0.1");
                new Socket("127.0.0.1", Integer.parseInt(a("3237303432")));
                return true;
            } catch (IOException unused) {
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    public static boolean d(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, context)) == null) {
            try {
                int simState = ((TelephonyManager) context.getSystemService("phone")).getSimState();
                return (simState == 1 || simState == 0) ? false : true;
            } catch (Throwable unused) {
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public static String a(@NonNull String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) ? f.a(str) : (String) invokeL.objValue;
    }

    @WorkerThread
    public static boolean e(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65547, null, context)) == null) ? f() || f(context) : invokeL.booleanValue;
    }

    public static boolean f(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65549, null, context)) == null) {
            List<String> asList = Arrays.asList(a("64652e726f62762e616e64726f69642e78706f736564"), a("636f6d2e746f706a6f686e77752e6d616769736b"), a("696f2e76612e6578706f736564"), a("636f6d2e77696e642e636f74746572"), a("6f72672e6d656f776361742e656478706f7365642e6d616e61676572"), a("6d652e7765697368752e657870"), a("636f6d2e73617572696b2e737562737472617465"));
            PackageManager packageManager = context.getPackageManager();
            for (String str : asList) {
                try {
                } catch (PackageManager.NameNotFoundException e2) {
                    e2.printStackTrace();
                }
                if (packageManager.getPackageInfo(str, 0) != null) {
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }
}
