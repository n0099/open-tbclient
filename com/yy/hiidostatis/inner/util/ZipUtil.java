package com.yy.hiidostatis.inner.util;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.hiidostatis.inner.util.log.L;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
/* loaded from: classes8.dex */
public class ZipUtil {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public ZipUtil() {
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

    public static void zipFiles(String[] strArr, String str) throws Exception {
        ZipOutputStream zipOutputStream;
        File file;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, strArr, str) == null) {
            ZipOutputStream zipOutputStream2 = null;
            try {
                zipOutputStream = new ZipOutputStream(new FileOutputStream(str));
            } catch (Throwable th) {
                th = th;
            }
            try {
                for (String str2 : strArr) {
                    zipFiles(file.getParent() + File.separator, new File(str2).getName(), zipOutputStream);
                }
                zipOutputStream.finish();
                zipOutputStream.close();
            } catch (Throwable th2) {
                th = th2;
                zipOutputStream2 = zipOutputStream;
                if (zipOutputStream2 != null) {
                    zipOutputStream2.close();
                }
                throw th;
            }
        }
    }

    public static void zipFolder(String str, String str2) throws Exception {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeLL(65539, null, str, str2) != null) {
            return;
        }
        ZipOutputStream zipOutputStream = null;
        try {
            ZipOutputStream zipOutputStream2 = new ZipOutputStream(new FileOutputStream(str2));
            try {
                File file = new File(str);
                zipFiles(file.getParent() + File.separator, file.getName(), zipOutputStream2);
                zipOutputStream2.finish();
                zipOutputStream2.close();
            } catch (Throwable th) {
                th = th;
                zipOutputStream = zipOutputStream2;
                if (zipOutputStream != null) {
                    zipOutputStream.close();
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static void zipFiles(String str, String str2, ZipOutputStream zipOutputStream) throws Exception {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65537, null, str, str2, zipOutputStream) == null) || zipOutputStream == null) {
            return;
        }
        File file = new File(str + str2);
        FileInputStream fileInputStream = null;
        try {
            if (file.isFile()) {
                ZipEntry zipEntry = new ZipEntry(str2);
                FileInputStream fileInputStream2 = new FileInputStream(file);
                try {
                    zipOutputStream.putNextEntry(zipEntry);
                    byte[] bArr = new byte[100000];
                    while (true) {
                        int read = fileInputStream2.read(bArr);
                        if (read == -1) {
                            break;
                        }
                        zipOutputStream.write(bArr, 0, read);
                    }
                    zipOutputStream.closeEntry();
                    fileInputStream = fileInputStream2;
                } catch (Throwable th) {
                    th = th;
                    fileInputStream = fileInputStream2;
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (Throwable th2) {
                            L.debug("ZipUtil", th2.getMessage(), new Object[0]);
                        }
                    }
                    throw th;
                }
            } else {
                String[] list = file.list();
                if (list.length <= 0) {
                    zipOutputStream.putNextEntry(new ZipEntry(str2 + File.separator));
                    zipOutputStream.closeEntry();
                }
                for (int i = 0; i < list.length; i++) {
                    zipFiles(str, str2 + File.separator + list[i], zipOutputStream);
                }
            }
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (Throwable th3) {
                    L.debug("ZipUtil", th3.getMessage(), new Object[0]);
                }
            }
        } catch (Throwable th4) {
            th = th4;
        }
    }
}
