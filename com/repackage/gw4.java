package com.repackage;

import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.File;
/* loaded from: classes6.dex */
public class gw4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65536, null) == null) {
            synchronized (gw4.class) {
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

    public static fw4 c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            fw4 fw4Var = new fw4();
            if (str == null) {
                fw4Var.c = 6;
                fw4Var.d = fw4.a(6);
                return fw4Var;
            }
            if (!FileHelper.CheckTempDir(FileHelper.getCacheDir() + "voice")) {
                fw4Var.c = 7;
                fw4Var.d = fw4.a(7);
                return fw4Var;
            }
            String b = vi.b(FileHelper.GetStreamFromTmpFile(str));
            if (b == null) {
                fw4Var.c = 5;
                fw4Var.d = fw4.a(5);
            } else {
                String filePath = FileHelper.getFilePath(b, 1, true);
                if (FileHelper.renameTo(str, filePath)) {
                    fw4Var.b = filePath;
                    fw4Var.a = b;
                } else {
                    fw4Var.c = 1;
                    fw4Var.d = fw4.a(1);
                }
            }
            return fw4Var;
        }
        return (fw4) invokeL.objValue;
    }
}
