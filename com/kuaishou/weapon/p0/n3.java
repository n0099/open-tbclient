package com.kuaishou.weapon.p0;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
/* loaded from: classes10.dex */
public class n3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public n3() {
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

    public static void a(String str, Boolean bool) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65537, null, str, bool) == null) && bool.booleanValue()) {
            a("771", new File(str).getParentFile().getAbsolutePath());
        }
    }

    public static boolean a(File file) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, file)) == null) ? file != null && file.exists() && file.isFile() && file.canRead() && file.length() > 0 : invokeL.booleanValue;
    }

    public static boolean a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            return a(new File(str));
        }
        return invokeL.booleanValue;
    }

    public static boolean a(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, str, str2)) == null) {
            if (str == null || TextUtils.isEmpty(str) || str2 == null || TextUtils.isEmpty(str2) || !a(str)) {
                return false;
            }
            try {
                Runtime runtime = Runtime.getRuntime();
                runtime.exec("chmod " + str2 + " " + str + "\n").waitFor();
                return true;
            } catch (Throwable unused) {
                return false;
            }
        }
        return invokeLL.booleanValue;
    }

    public static void b(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65541, null, str) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        File file = new File(str);
        if (file.exists()) {
            File[] listFiles = file.listFiles();
            if (listFiles != null && listFiles.length > 0) {
                for (File file2 : listFiles) {
                    if (file2.isDirectory()) {
                        b(file2.getAbsolutePath());
                    } else {
                        file2.delete();
                    }
                }
            }
            file.delete();
        }
    }

    public static boolean b(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65542, null, str, str2)) == null) {
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                try {
                    String[] split = str.split("\\.");
                    String[] split2 = str2.split("\\.");
                    for (int i = 0; i < split.length && i < split2.length; i++) {
                        int intValue = Integer.valueOf(split[i]).intValue() - Integer.valueOf(split2[i]).intValue();
                        if (intValue != 0) {
                            return intValue > 0;
                        }
                    }
                    if (split.length > split2.length) {
                        return true;
                    }
                } catch (Throwable unused) {
                }
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public static void c(String str) {
        File[] listFiles;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65543, null, str) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        File file = new File(str);
        if (file.exists() && (listFiles = file.listFiles()) != null && listFiles.length > 0) {
            for (File file2 : listFiles) {
                if (!file2.isDirectory()) {
                    file2.delete();
                }
            }
        }
    }
}
