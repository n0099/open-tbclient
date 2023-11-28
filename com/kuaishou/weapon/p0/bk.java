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
/* loaded from: classes10.dex */
public class bk {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String a = "/proc/cpuinfo";
    public transient /* synthetic */ FieldHolder $fh;

    public bk() {
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
                    sb.append(ParamableElem.DIVIDE_PARAM + str2);
                }
                String a2 = bh.a("ro.product.cpu.abilist");
                if (!TextUtils.isEmpty(a2)) {
                    sb.append(ParamableElem.DIVIDE_PARAM + a2);
                }
                return sb.toString();
            } catch (Throwable unused) {
                return "";
            }
        }
        return (String) invokeV.objValue;
    }

    public static bj b() {
        InterceptResult invokeV;
        InputStreamReader inputStreamReader;
        FileInputStream fileInputStream;
        BufferedReader bufferedReader;
        String[] split;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            try {
                fileInputStream = new FileInputStream(new File(a));
                try {
                    inputStreamReader = new InputStreamReader(fileInputStream);
                    try {
                        bufferedReader = new BufferedReader(inputStreamReader);
                        try {
                            bj bjVar = new bj();
                            int i = 0;
                            while (true) {
                                String readLine = bufferedReader.readLine();
                                if (readLine != null) {
                                    if (!TextUtils.isEmpty(readLine)) {
                                        if (readLine.contains("Processor")) {
                                            String[] split2 = readLine.split(":");
                                            if (split2 != null) {
                                                String trim = split2[1].trim();
                                                if (!TextUtils.isEmpty(trim)) {
                                                    bjVar.b(trim);
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
                                                bjVar.a(str);
                                            }
                                        }
                                    }
                                } else {
                                    bjVar.a(i);
                                    bufferedReader.close();
                                    inputStreamReader.close();
                                    fileInputStream.close();
                                    return bjVar;
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
        } else {
            return (bj) invokeV.objValue;
        }
    }
}
