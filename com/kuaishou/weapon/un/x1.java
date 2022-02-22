package com.kuaishou.weapon.un;

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
/* loaded from: classes4.dex */
public class x1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public x1() {
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

    public static String a(int i2) {
        InterceptResult invokeI;
        BufferedReader bufferedReader;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65537, null, i2)) == null) {
            BufferedReader bufferedReader2 = null;
            try {
                bufferedReader = new BufferedReader(new FileReader(String.format("/proc/%1$s/cmdline", Integer.valueOf(i2))));
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
                return a(String.format("cat /proc/%1$s/cmdline", Integer.valueOf(i2))).trim();
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

    public static String a(String str) {
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
