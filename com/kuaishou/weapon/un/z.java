package com.kuaishou.weapon.un;

import android.os.Build;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
/* loaded from: classes3.dex */
public class z {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String a = "/proc/cpuinfo";

    /* renamed from: b  reason: collision with root package name */
    public static final String f55318b = "/sys/devices/system/cpu/cpu0/cpufreq/cpuinfo_max_freq";

    /* renamed from: c  reason: collision with root package name */
    public static final String f55319c = "/sys/devices/system/cpu/cpu0/cpufreq/cpuinfo_min_freq";
    public transient /* synthetic */ FieldHolder $fh;

    public z() {
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
                        int i2 = 0;
                        while (true) {
                            String readLine = bufferedReader.readLine();
                            if (readLine == null) {
                                z0Var.a(i2);
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
                                            i2 = Integer.parseInt(trim2) + 1;
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
                            x0.a(th);
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

    public static int c() {
        InterceptResult invokeV;
        BufferedReader bufferedReader;
        Throwable th;
        FileReader fileReader;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeV = interceptable.invokeV(65539, null)) != null) {
            return invokeV.intValue;
        }
        try {
            fileReader = new FileReader(f55318b);
            try {
                bufferedReader = new BufferedReader(fileReader);
                try {
                    int parseInt = Integer.parseInt(bufferedReader.readLine().trim());
                    try {
                        fileReader.close();
                    } catch (IOException unused) {
                    }
                    try {
                        bufferedReader.close();
                    } catch (IOException unused2) {
                    }
                    return parseInt;
                } catch (Throwable th2) {
                    th = th2;
                    try {
                        x0.a(th);
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                                return -2;
                            } catch (IOException unused3) {
                                return -2;
                            }
                        }
                        return -2;
                    } finally {
                        if (fileReader != null) {
                            try {
                                fileReader.close();
                            } catch (IOException unused4) {
                            }
                        }
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (IOException unused5) {
                            }
                        }
                    }
                }
            } catch (Throwable th3) {
                bufferedReader = null;
                th = th3;
            }
        } catch (Throwable th4) {
            bufferedReader = null;
            th = th4;
            fileReader = null;
        }
    }

    public static int d() {
        InterceptResult invokeV;
        BufferedReader bufferedReader;
        Throwable th;
        FileReader fileReader;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) != null) {
            return invokeV.intValue;
        }
        try {
            fileReader = new FileReader(f55319c);
            try {
                bufferedReader = new BufferedReader(fileReader);
                try {
                    int parseInt = Integer.parseInt(bufferedReader.readLine().trim());
                    try {
                        fileReader.close();
                    } catch (IOException unused) {
                    }
                    try {
                        bufferedReader.close();
                    } catch (IOException unused2) {
                    }
                    return parseInt;
                } catch (Throwable th2) {
                    th = th2;
                    try {
                        x0.a(th);
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                                return -2;
                            } catch (IOException unused3) {
                                return -2;
                            }
                        }
                        return -2;
                    } finally {
                        if (fileReader != null) {
                            try {
                                fileReader.close();
                            } catch (IOException unused4) {
                            }
                        }
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (IOException unused5) {
                            }
                        }
                    }
                }
            } catch (Throwable th3) {
                bufferedReader = null;
                th = th3;
            }
        } catch (Throwable th4) {
            bufferedReader = null;
            th = th4;
            fileReader = null;
        }
    }
}
