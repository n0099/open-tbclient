package com.kuaishou.weapon.un;

import android.os.Build;
import android.text.TextUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
/* loaded from: classes2.dex */
public class c0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public c0() {
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

    private String a(String str) {
        InterceptResult invokeL;
        int read;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, this, str)) == null) {
            try {
                File file = new File(str);
                if (file.exists() && file.canRead()) {
                    byte[] bArr = new byte[1024];
                    FileInputStream fileInputStream = new FileInputStream(file);
                    String str2 = null;
                    do {
                        read = fileInputStream.read(bArr);
                        if (read == -1) {
                            break;
                        }
                        str2 = new String(bArr, 0, read);
                    } while (read <= 0);
                    fileInputStream.close();
                    return str2;
                }
                return null;
            } catch (Exception unused) {
                return null;
            }
        }
        return (String) invokeL.objValue;
    }

    public static boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if ("nokia".equalsIgnoreCase(Build.MANUFACTURER) && ("Nokia_N1".equalsIgnoreCase(Build.DEVICE) || "N1".equalsIgnoreCase(Build.MODEL))) {
                return false;
            }
            try {
                Process start = new ProcessBuilder("/system/bin/cat", "/proc/cpuinfo").start();
                StringBuffer stringBuffer = new StringBuffer();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(start.getInputStream(), "utf-8"));
                while (true) {
                    String readLine = bufferedReader.readLine();
                    if (TextUtils.isEmpty(readLine)) {
                        break;
                    }
                    stringBuffer.append(readLine);
                }
                bufferedReader.close();
                String lowerCase = stringBuffer.toString().toLowerCase();
                if (lowerCase.contains("intel") || lowerCase.contains("x86")) {
                    return true;
                }
                return lowerCase.contains("amd");
            } catch (IOException unused) {
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    public boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            String a = u1.a("jNPRzMCM19fajMfRytXG0dA=");
            String a2 = u1.a("jNPRzMCMwNPWys3FzA==");
            String a3 = u1.a("xMzPx8XK0Ms=");
            try {
                String a4 = a(a);
                boolean z = !TextUtils.isEmpty(a4) && a4.contains(a3);
                if (!z) {
                    String a5 = a(a2);
                    if (!TextUtils.isEmpty(a5)) {
                        if (a5.contains(a3)) {
                            return true;
                        }
                    }
                }
                return z;
            } catch (Exception unused) {
                return false;
            }
        }
        return invokeV.booleanValue;
    }
}
