package com.repackage;

import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.File;
/* loaded from: classes7.dex */
public class yu4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65536, null) == null) {
            synchronized (yu4.class) {
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

    public static xu4 c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            xu4 xu4Var = new xu4();
            if (str == null) {
                xu4Var.c = 6;
                xu4Var.d = xu4.a(6);
                return xu4Var;
            }
            if (!FileHelper.CheckTempDir(FileHelper.getCacheDir() + "voice")) {
                xu4Var.c = 7;
                xu4Var.d = xu4.a(7);
                return xu4Var;
            }
            String b = ri.b(FileHelper.GetStreamFromTmpFile(str));
            if (b == null) {
                xu4Var.c = 5;
                xu4Var.d = xu4.a(5);
            } else {
                String filePath = FileHelper.getFilePath(b, 1, true);
                if (FileHelper.renameTo(str, filePath)) {
                    xu4Var.b = filePath;
                    xu4Var.a = b;
                } else {
                    xu4Var.c = 1;
                    xu4Var.d = xu4.a(1);
                }
            }
            return xu4Var;
        }
        return (xu4) invokeL.objValue;
    }
}
