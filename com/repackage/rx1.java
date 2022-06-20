package com.repackage;

import android.os.Build;
import android.os.Process;
import android.util.Log;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/* loaded from: classes7.dex */
public class rx1 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755335066, "Lcom/repackage/rx1;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755335066, "Lcom/repackage/rx1;");
                return;
            }
        }
        a = cg1.a;
    }

    public static synchronized String a() {
        InterceptResult invokeV;
        BufferedReader bufferedReader;
        Throwable th;
        IOException e;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeV = interceptable.invokeV(65537, null)) != null) {
            return (String) invokeV.objValue;
        }
        synchronized (rx1.class) {
            if (a) {
                Log.d("SwanCpuProperty", "start cpu monitor thread");
            }
            try {
                bufferedReader = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec(new String[]{"sh", "-c", "top -n 1 | grep " + Process.myPid()}).getInputStream()));
                try {
                    try {
                        String c = c(bufferedReader);
                        if (a) {
                            Log.d("SwanCpuProperty", "stop cpu monitor thread , cpu rate is : " + c);
                        }
                        uf4.d(bufferedReader);
                        return c;
                    } catch (IOException e2) {
                        e = e2;
                        if (a) {
                            Log.e("SwanCpuProperty", "error in cpu monitor", e);
                        }
                        uf4.d(bufferedReader);
                        return "";
                    }
                } catch (Throwable th2) {
                    th = th2;
                    uf4.d(bufferedReader);
                    throw th;
                }
            } catch (IOException e3) {
                bufferedReader = null;
                e = e3;
            } catch (Throwable th3) {
                bufferedReader = null;
                th = th3;
                uf4.d(bufferedReader);
                throw th;
            }
        }
    }

    public static float b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            String a2 = a();
            try {
                if (a2.contains("%")) {
                    return Float.parseFloat(a2.replace("%", "").trim());
                }
                return Float.parseFloat(a2);
            } catch (Exception e) {
                if (a) {
                    Log.d("SwanCpuProperty", "解析cpu使用率错误", e);
                    return 0.0f;
                }
                return 0.0f;
            }
        }
        return invokeV.floatValue;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(10:6|(1:9)|10|(6:12|(1:15)|16|17|18|19)|(1:27)(1:32)|(1:31)|16|17|18|19) */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0053, code lost:
        r11 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0056, code lost:
        if (com.repackage.rx1.a != false) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0058, code lost:
        android.util.Log.e("SwanCpuProperty", "get CPU Fail : " + r11.getMessage());
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String c(BufferedReader bufferedReader) throws IOException {
        InterceptResult invokeL;
        char read;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, bufferedReader)) == null) {
            char[] cArr = new char[4];
            int i = 0;
            if (Build.VERSION.SDK_INT < 26) {
                int i2 = 0;
                do {
                    read = (char) bufferedReader.read();
                    if (read == ' ' || i2 == 4) {
                        i2 = 0;
                    } else {
                        cArr[i2] = read;
                        i2++;
                    }
                    if (read == '%') {
                        break;
                    }
                } while (read != 65535);
                return String.valueOf(cArr, 0, i2);
            }
            int i3 = 0;
            int i4 = 0;
            while (true) {
                char read2 = (char) bufferedReader.read();
                if (z && read2 != ' ') {
                    i3++;
                }
                if (i3 == 9) {
                    if (read2 != '.' && read2 != ' ') {
                        cArr[i4] = read2;
                        i4++;
                    }
                    i = Integer.parseInt(String.valueOf(cArr, 0, i4)) / Runtime.getRuntime().availableProcessors();
                    return i + "%";
                }
                z = (i3 <= 9 && read2 != 65535 && i4 < 4) ? read2 == ' ' : true;
                i = Integer.parseInt(String.valueOf(cArr, 0, i4)) / Runtime.getRuntime().availableProcessors();
                return i + "%";
            }
        }
        return (String) invokeL.objValue;
    }
}
