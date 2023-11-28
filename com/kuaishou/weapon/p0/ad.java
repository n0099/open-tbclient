package com.kuaishou.weapon.p0;

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
/* loaded from: classes10.dex */
public class ad {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public ad() {
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

    private String a(String str) {
        InterceptResult invokeL;
        int read;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, this, str)) == null) {
            try {
                File file = new File(str);
                if (!file.exists() || !file.canRead()) {
                    return null;
                }
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
                Process start = new ProcessBuilder("/system/bin/cat", bk.a).start();
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
                if (!lowerCase.contains("intel") && !lowerCase.contains("x86")) {
                    if (!lowerCase.contains("amd")) {
                        return false;
                    }
                    return true;
                }
                return true;
            } catch (IOException unused) {
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    public boolean a() {
        InterceptResult invokeV;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            try {
                String a = a("/proc/tty/drivers");
                if (!TextUtils.isEmpty(a) && a.contains("goldfish")) {
                    z = true;
                } else {
                    z = false;
                }
                if (!z) {
                    String a2 = a(bk.a);
                    if (!TextUtils.isEmpty(a2)) {
                        if (a2.contains("goldfish")) {
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
