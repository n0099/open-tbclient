package com.kuaishou.weapon.p0;

import android.os.Build;
import android.text.TextUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.hiidostatis.defs.obj.ParamableElem;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
/* renamed from: com.kuaishou.weapon.p0.ʻʽ  reason: contains not printable characters */
/* loaded from: classes5.dex */
public class C0294 {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: ʻ  reason: contains not printable characters */
    public static final String f19 = "/proc/cpuinfo";
    public transient /* synthetic */ FieldHolder $fh;

    public C0294() {
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
    public static String m89() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            try {
                String str = Build.CPU_ABI;
                String str2 = Build.CPU_ABI2;
                StringBuilder sb = new StringBuilder();
                sb.append(str);
                if (!TextUtils.isEmpty(str2)) {
                    sb.append(ParamableElem.DIVIDE_PARAM + str2);
                }
                String m854 = C0433.m854("ro.product.cpu.abilist");
                if (!TextUtils.isEmpty(m854)) {
                    sb.append(ParamableElem.DIVIDE_PARAM + m854);
                }
                return sb.toString();
            } catch (Throwable unused) {
                return "";
            }
        }
        return (String) invokeV.objValue;
    }

    /* renamed from: ʼ  reason: contains not printable characters */
    public static C0293 m90() {
        InterceptResult invokeV;
        InputStreamReader inputStreamReader;
        FileInputStream fileInputStream;
        BufferedReader bufferedReader;
        String[] split;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeV = interceptable.invokeV(65538, null)) != null) {
            return (C0293) invokeV.objValue;
        }
        try {
            fileInputStream = new FileInputStream(new File(f19));
            try {
                inputStreamReader = new InputStreamReader(fileInputStream);
                try {
                    bufferedReader = new BufferedReader(inputStreamReader);
                    try {
                        C0293 c0293 = new C0293();
                        int i = 0;
                        while (true) {
                            String readLine = bufferedReader.readLine();
                            if (readLine == null) {
                                c0293.m84(i);
                                bufferedReader.close();
                                inputStreamReader.close();
                                fileInputStream.close();
                                return c0293;
                            } else if (!TextUtils.isEmpty(readLine)) {
                                if (readLine.contains("Processor")) {
                                    String[] split2 = readLine.split(":");
                                    if (split2 != null) {
                                        String trim = split2[1].trim();
                                        if (!TextUtils.isEmpty(trim)) {
                                            c0293.m85(trim);
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
                                        c0293.m87(str);
                                    }
                                }
                            }
                        }
                    } catch (Throwable unused) {
                        if (bufferedReader != null) {
                            bufferedReader.close();
                        }
                        if (inputStreamReader != null) {
                            inputStreamReader.close();
                        }
                        if (fileInputStream != null) {
                            fileInputStream.close();
                        }
                        return null;
                    }
                } catch (Throwable unused2) {
                    bufferedReader = null;
                }
            } catch (Throwable unused3) {
                inputStreamReader = null;
                bufferedReader = null;
            }
        } catch (Throwable unused4) {
            inputStreamReader = null;
            fileInputStream = null;
            bufferedReader = null;
        }
    }
}
