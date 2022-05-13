package com.repackage;

import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.File;
/* loaded from: classes6.dex */
public class iw4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65536, null) == null) {
            synchronized (iw4.class) {
                File file = new File(FileHelper.getCacheDir() + "voice");
                if (file.exists() && file.isDirectory()) {
                    File[] listFiles = file.listFiles();
                    if (listFiles == null) {
                        return;
                    }
                    for (File file2 : listFiles) {
                        file2.delete();
                    }
                }
            }
        }
    }

    public static boolean b(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, str, str2)) == null) ? FileHelper.renameTo(str, FileHelper.getFilePath(str2, 1, true)) : invokeLL.booleanValue;
    }

    public static hw4 c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            hw4 hw4Var = new hw4();
            if (str == null) {
                hw4Var.c = 6;
                hw4Var.d = hw4.a(6);
                return hw4Var;
            }
            if (!FileHelper.CheckTempDir(FileHelper.getCacheDir() + "voice")) {
                hw4Var.c = 7;
                hw4Var.d = hw4.a(7);
                return hw4Var;
            }
            String b = si.b(FileHelper.GetStreamFromTmpFile(str));
            if (b == null) {
                hw4Var.c = 5;
                hw4Var.d = hw4.a(5);
            } else {
                String filePath = FileHelper.getFilePath(b, 1, true);
                if (FileHelper.renameTo(str, filePath)) {
                    hw4Var.b = filePath;
                    hw4Var.a = b;
                } else {
                    hw4Var.c = 1;
                    hw4Var.d = hw4.a(1);
                }
            }
            return hw4Var;
        }
        return (hw4) invokeL.objValue;
    }
}
