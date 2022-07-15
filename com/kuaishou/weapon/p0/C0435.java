package com.kuaishou.weapon.p0;

import android.os.Build;
import android.text.TextUtils;
import com.baidu.android.imsdk.chatmessage.request.IMAudioTransRequest;
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
/* renamed from: com.kuaishou.weapon.p0.ᐧ  reason: contains not printable characters */
/* loaded from: classes5.dex */
public class C0435 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public C0435() {
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

    /* renamed from: ʻ  reason: contains not printable characters */
    private String m906(String str) {
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

    /* renamed from: ʼ  reason: contains not printable characters */
    public static boolean m907() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if ("nokia".equalsIgnoreCase(Build.MANUFACTURER) && ("Nokia_N1".equalsIgnoreCase(Build.DEVICE) || "N1".equalsIgnoreCase(Build.MODEL))) {
                return false;
            }
            try {
                Process start = new ProcessBuilder("/system/bin/cat", C0294.f19).start();
                StringBuffer stringBuffer = new StringBuffer();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(start.getInputStream(), IMAudioTransRequest.CHARSET));
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

    /* renamed from: ʻ  reason: contains not printable characters */
    public boolean m908() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            try {
                String m906 = m906("/proc/tty/drivers");
                boolean z = !TextUtils.isEmpty(m906) && m906.contains("goldfish");
                if (!z) {
                    String m9062 = m906(C0294.f19);
                    if (!TextUtils.isEmpty(m9062)) {
                        if (m9062.contains("goldfish")) {
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
