package com.kuaishou.weapon.p0;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
/* renamed from: com.kuaishou.weapon.p0.ʻٴ  reason: contains not printable characters */
/* loaded from: classes5.dex */
public class C0308 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public C0308() {
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
    public static String m192(int i) {
        InterceptResult invokeI;
        BufferedReader bufferedReader;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65537, null, i)) == null) {
            BufferedReader bufferedReader2 = null;
            try {
                bufferedReader = new BufferedReader(new FileReader(String.format("/proc/%1$s/cmdline", Integer.valueOf(i))));
            } catch (FileNotFoundException | IOException unused) {
            } catch (Throwable th) {
                th = th;
            }
            try {
                String trim = bufferedReader.readLine().trim();
                try {
                    bufferedReader.close();
                } catch (Exception unused2) {
                }
                return trim;
            } catch (FileNotFoundException | IOException unused3) {
                bufferedReader2 = bufferedReader;
                try {
                    bufferedReader2.close();
                } catch (Exception unused4) {
                }
                return m193(String.format("cat /proc/%1$s/cmdline", Integer.valueOf(i))).trim();
            } catch (Throwable th2) {
                th = th2;
                bufferedReader2 = bufferedReader;
                try {
                    bufferedReader2.close();
                } catch (Exception unused5) {
                }
                throw th;
            }
        }
        return (String) invokeI.objValue;
    }

    /* renamed from: ʻ  reason: contains not printable characters */
    public static String m193(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            String str2 = "";
            try {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec(str).getInputStream()));
                while (true) {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        break;
                    }
                    str2 = str2 + readLine + '\n';
                }
                bufferedReader.close();
            } catch (Exception unused) {
            }
            return str2;
        }
        return (String) invokeL.objValue;
    }
}
