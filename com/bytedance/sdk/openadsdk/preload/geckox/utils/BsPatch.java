package com.bytedance.sdk.openadsdk.preload.geckox.utils;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.File;
import java.io.FileNotFoundException;
/* loaded from: classes5.dex */
public class BsPatch {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(344724807, "Lcom/bytedance/sdk/openadsdk/preload/geckox/utils/BsPatch;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(344724807, "Lcom/bytedance/sdk/openadsdk/preload/geckox/utils/BsPatch;");
                return;
            }
        }
        g.a("geckox_bspatch");
    }

    public static void a(File file, File file2, File file3, String str) throws Exception {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65537, null, file, file2, file3, str) == null) {
            if (file.exists()) {
                if (file2.exists()) {
                    file3.mkdirs();
                    File file4 = new File(file3, str);
                    file4.delete();
                    int patch = patch(file.getAbsolutePath(), file4.getAbsolutePath(), file2.getAbsolutePath());
                    if (patch == 0) {
                        return;
                    }
                    throw new RuntimeException("patch merged failed, code：" + patch + " full:" + file.getAbsolutePath() + " patch:" + file2.getAbsolutePath() + " dest:" + file4.getAbsolutePath());
                }
                throw new FileNotFoundException("patch package not exist：" + file2.getAbsolutePath());
            }
            throw new FileNotFoundException("full package not exist：" + file.getAbsolutePath());
        }
    }

    public static native int patch(String str, String str2, String str3) throws Exception;
}
