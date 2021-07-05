package com.bytedance.sdk.openadsdk.preload.geckox.utils;

import android.os.Process;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
/* loaded from: classes6.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static boolean a(File file) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, file)) == null) {
            if (file == null || !file.exists()) {
                return true;
            }
            com.bytedance.sdk.openadsdk.preload.geckox.h.b.a("gecko-debug-tag", "delete file，pid:", Integer.valueOf(Process.myPid()), ", thread:", Thread.currentThread().toString(), ", file:" + file.getAbsolutePath());
            return d(file);
        }
        return invokeL.booleanValue;
    }

    public static List<File> b(File file) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, file)) == null) {
            if (file != null && file.exists() && file.isDirectory()) {
                List<File> asList = Arrays.asList(file.listFiles());
                Collections.sort(asList, new Comparator<File>() { // from class: com.bytedance.sdk.openadsdk.preload.geckox.utils.d.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                            }
                        }
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // java.util.Comparator
                    /* renamed from: a */
                    public int compare(File file2, File file3) {
                        InterceptResult invokeLL;
                        Interceptable interceptable2 = $ic;
                        return (interceptable2 == null || (invokeLL = interceptable2.invokeLL(1048576, this, file2, file3)) == null) ? Long.compare(file2.lastModified(), file3.lastModified()) : invokeLL.intValue;
                    }
                });
                return asList;
            }
            return null;
        }
        return (List) invokeL.objValue;
    }

    public static boolean c(File file) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, file)) == null) {
            if (file.isDirectory()) {
                for (String str : file.list()) {
                    if (!c(new File(file, str))) {
                        return false;
                    }
                }
            }
            return file.delete();
        }
        return invokeL.booleanValue;
    }

    public static boolean d(File file) {
        InterceptResult invokeL;
        boolean z;
        File[] listFiles;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65540, null, file)) == null) {
            if (file == null || !file.exists()) {
                return true;
            }
            if (!file.isDirectory() || (listFiles = file.listFiles()) == null) {
                z = true;
            } else {
                z = true;
                for (File file2 : listFiles) {
                    z = z && d(file2);
                }
            }
            return z && file.delete();
        }
        return invokeL.booleanValue;
    }

    public static void a(InputStream inputStream, OutputStream outputStream) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeLL(65536, null, inputStream, outputStream) != null) {
            return;
        }
        BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(outputStream);
        byte[] bArr = new byte[1024];
        while (true) {
            int read = bufferedInputStream.read(bArr);
            if (read != -1) {
                bufferedOutputStream.write(bArr, 0, read);
            } else {
                bufferedOutputStream.flush();
                return;
            }
        }
    }
}
