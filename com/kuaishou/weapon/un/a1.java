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
import java.io.InputStreamReader;
/* loaded from: classes7.dex */
public class a1 {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String a = "/proc/cpuinfo";
    public transient /* synthetic */ FieldHolder $fh;

    public a1() {
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

    public static String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            try {
                String str = Build.CPU_ABI;
                String str2 = Build.CPU_ABI2;
                StringBuilder sb = new StringBuilder();
                sb.append(str);
                if (!TextUtils.isEmpty(str2)) {
                    sb.append(";" + str2);
                }
                String b2 = x0.b("ro.product.cpu.abilist");
                if (!TextUtils.isEmpty(b2)) {
                    sb.append(";" + b2);
                }
                return sb.toString();
            } catch (Throwable th) {
                x0.a(th);
                return "";
            }
        }
        return (String) invokeV.objValue;
    }

    public static z0 b() {
        InterceptResult invokeV;
        Throwable th;
        InputStreamReader inputStreamReader;
        FileInputStream fileInputStream;
        BufferedReader bufferedReader;
        String[] split;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeV = interceptable.invokeV(65538, null)) != null) {
            return (z0) invokeV.objValue;
        }
        try {
            fileInputStream = new FileInputStream(new File("/proc/cpuinfo"));
            try {
                inputStreamReader = new InputStreamReader(fileInputStream);
                try {
                    bufferedReader = new BufferedReader(inputStreamReader);
                    try {
                        z0 z0Var = new z0();
                        int i = 0;
                        while (true) {
                            String readLine = bufferedReader.readLine();
                            if (readLine == null) {
                                z0Var.a(i);
                                bufferedReader.close();
                                inputStreamReader.close();
                                fileInputStream.close();
                                return z0Var;
                            } else if (!TextUtils.isEmpty(readLine)) {
                                if (readLine.contains("Processor")) {
                                    String[] split2 = readLine.split(":");
                                    if (split2 != null) {
                                        String trim = split2[1].trim();
                                        if (!TextUtils.isEmpty(trim)) {
                                            z0Var.a(trim);
                                        }
                                    }
                                }
                                if (readLine.contains("processor")) {
                                    String[] split3 = readLine.split(":");
                                    if (split3 != null) {
                                        String trim2 = split3[1].trim();
                                        if (!TextUtils.isEmpty(trim2)) {
                                            i = Integer.parseInt(trim2) + 1;
                                        }
                                    }
                                }
                                if (readLine.contains("Hardware") && (split = readLine.split(":")) != null) {
                                    String str = split[1];
                                    if (!TextUtils.isEmpty(str)) {
                                        z0Var.b(str);
                                    }
                                }
                            }
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        try {
                            l1.a(th);
                            return null;
                        } finally {
                            if (bufferedReader != null) {
                                bufferedReader.close();
                            }
                            if (inputStreamReader != null) {
                                inputStreamReader.close();
                            }
                            if (fileInputStream != null) {
                                fileInputStream.close();
                            }
                        }
                    }
                } catch (Throwable th3) {
                    th = th3;
                    bufferedReader = null;
                }
            } catch (Throwable th4) {
                th = th4;
                inputStreamReader = null;
                bufferedReader = null;
            }
        } catch (Throwable th5) {
            th = th5;
            inputStreamReader = null;
            fileInputStream = null;
            bufferedReader = null;
        }
    }
}
