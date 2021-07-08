package d.a.o0.r.y;

import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipException;
import java.util.zip.ZipFile;
import java.util.zip.ZipOutputStream;
/* loaded from: classes7.dex */
public class r {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static boolean a(File file, String str) {
        InterceptResult invokeLL;
        ZipFile zipFile;
        FileOutputStream fileOutputStream;
        InputStream inputStream;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, file, str)) == null) {
            File file2 = new File(str);
            if (file2.exists() || file2.mkdirs()) {
                boolean z = true;
                ZipFile zipFile2 = null;
                InputStream inputStream2 = null;
                zipFile2 = null;
                try {
                    try {
                        zipFile = new ZipFile(file);
                    } catch (Exception e2) {
                        e = e2;
                    }
                } catch (Throwable th) {
                    th = th;
                }
                try {
                    Enumeration<? extends ZipEntry> entries = zipFile.entries();
                    while (entries.hasMoreElements()) {
                        try {
                            ZipEntry nextElement = entries.nextElement();
                            String name = nextElement.getName();
                            if (name == null || !name.contains("__MACOSX/")) {
                                File file3 = new File(str, name);
                                if (nextElement.isDirectory()) {
                                    file3.mkdirs();
                                } else {
                                    inputStream = zipFile.getInputStream(nextElement);
                                    try {
                                        fileOutputStream = new FileOutputStream(file3);
                                        try {
                                            try {
                                                byte[] bArr = new byte[1024];
                                                while (true) {
                                                    int read = inputStream.read(bArr);
                                                    if (read <= 0) {
                                                        break;
                                                    }
                                                    fileOutputStream.write(bArr, 0, read);
                                                }
                                                fileOutputStream.flush();
                                                if (inputStream != null) {
                                                    try {
                                                        inputStream.close();
                                                    } catch (IOException e3) {
                                                        e3.printStackTrace();
                                                    }
                                                }
                                                try {
                                                    fileOutputStream.close();
                                                } catch (IOException e4) {
                                                    e4.printStackTrace();
                                                }
                                            } catch (Throwable th2) {
                                                th = th2;
                                                inputStream2 = inputStream;
                                                if (inputStream2 != null) {
                                                    try {
                                                        inputStream2.close();
                                                    } catch (IOException e5) {
                                                        e5.printStackTrace();
                                                    }
                                                }
                                                if (fileOutputStream != null) {
                                                    try {
                                                        fileOutputStream.close();
                                                    } catch (IOException e6) {
                                                        e6.printStackTrace();
                                                    }
                                                }
                                                throw th;
                                            }
                                        } catch (Exception e7) {
                                            e = e7;
                                            e.printStackTrace();
                                            if (inputStream != null) {
                                                try {
                                                    inputStream.close();
                                                } catch (IOException e8) {
                                                    e8.printStackTrace();
                                                }
                                            }
                                            if (fileOutputStream != null) {
                                                try {
                                                    fileOutputStream.close();
                                                } catch (IOException e9) {
                                                    e9.printStackTrace();
                                                }
                                            }
                                            z = false;
                                        }
                                    } catch (Exception e10) {
                                        e = e10;
                                        fileOutputStream = null;
                                    } catch (Throwable th3) {
                                        th = th3;
                                        fileOutputStream = null;
                                    }
                                }
                            }
                        } catch (Exception e11) {
                            e = e11;
                            inputStream = null;
                            fileOutputStream = null;
                        } catch (Throwable th4) {
                            th = th4;
                            fileOutputStream = null;
                        }
                    }
                    try {
                        zipFile.close();
                    } catch (IOException e12) {
                        e12.printStackTrace();
                    }
                    return z;
                } catch (Exception e13) {
                    e = e13;
                    zipFile2 = zipFile;
                    e.printStackTrace();
                    if (zipFile2 != null) {
                        try {
                            zipFile2.close();
                            return false;
                        } catch (IOException e14) {
                            e14.printStackTrace();
                            return false;
                        }
                    }
                    return false;
                } catch (Throwable th5) {
                    th = th5;
                    zipFile2 = zipFile;
                    if (zipFile2 != null) {
                        try {
                            zipFile2.close();
                        } catch (IOException e15) {
                            e15.printStackTrace();
                        }
                    }
                    throw th;
                }
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public static boolean b(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, str, str2)) == null) ? a(new File(str), str2) : invokeLL.booleanValue;
    }

    public static void c(File file, String str) throws ZipException, IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, file, str) == null) {
            File file2 = new File(str);
            if (!file2.exists()) {
                file2.mkdirs();
            }
            ZipFile zipFile = new ZipFile(file);
            Enumeration<? extends ZipEntry> entries = zipFile.entries();
            while (entries.hasMoreElements()) {
                ZipEntry nextElement = entries.nextElement();
                String name = nextElement.getName();
                if (!"./".equals(name) && !".".equals(name) && !name.endsWith("/")) {
                    InputStream inputStream = zipFile.getInputStream(nextElement);
                    File file3 = new File(str + File.separator + name);
                    if (!file3.exists()) {
                        File parentFile = file3.getParentFile();
                        if (!parentFile.exists()) {
                            parentFile.mkdirs();
                        }
                        file3.createNewFile();
                    }
                    FileOutputStream fileOutputStream = new FileOutputStream(file3);
                    byte[] bArr = new byte[10240];
                    while (true) {
                        int read = inputStream.read(bArr);
                        if (read <= 0) {
                            break;
                        }
                        fileOutputStream.write(bArr, 0, read);
                    }
                    inputStream.close();
                    fileOutputStream.close();
                }
            }
        }
    }

    public static void d(String str, String str2, ZipOutputStream zipOutputStream) throws Exception {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65539, null, str, str2, zipOutputStream) == null) || zipOutputStream == null) {
            return;
        }
        File file = new File(str, str2);
        if (!file.exists()) {
            return;
        }
        if (file.isFile()) {
            ZipEntry zipEntry = new ZipEntry(str2);
            FileInputStream fileInputStream = new FileInputStream(file);
            zipOutputStream.putNextEntry(zipEntry);
            byte[] bArr = new byte[4096];
            while (true) {
                int read = fileInputStream.read(bArr);
                if (read != -1) {
                    zipOutputStream.write(bArr, 0, read);
                } else {
                    zipOutputStream.closeEntry();
                    return;
                }
            }
        } else if (file.isDirectory()) {
            String[] list = file.list();
            if (list.length <= 0) {
                zipOutputStream.putNextEntry(new ZipEntry(str2 + File.separator));
                zipOutputStream.closeEntry();
            }
            for (int i2 = 0; i2 < list.length; i2++) {
                d(str, str2 + File.separator + list[i2], zipOutputStream);
            }
        }
    }

    public static boolean e(String str, String str2) {
        InterceptResult invokeLL;
        ZipOutputStream zipOutputStream;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, str, str2)) == null) {
            ZipOutputStream zipOutputStream2 = null;
            try {
                try {
                    zipOutputStream = new ZipOutputStream(new FileOutputStream(str2));
                } catch (Throwable th) {
                    th = th;
                }
            } catch (FileNotFoundException e2) {
                e = e2;
            } catch (IOException e3) {
                e = e3;
            } catch (Exception e4) {
                e = e4;
            }
            try {
                File file = new File(str);
                if (!file.exists()) {
                    d.a.c.e.p.m.f(zipOutputStream);
                    return false;
                }
                d(file.getParent(), file.getName(), zipOutputStream);
                zipOutputStream.finish();
                zipOutputStream.close();
                d.a.c.e.p.m.f(zipOutputStream);
                return true;
            } catch (FileNotFoundException e5) {
                e = e5;
                zipOutputStream2 = zipOutputStream;
                e.printStackTrace();
                d.a.c.e.p.m.f(zipOutputStream2);
                return false;
            } catch (IOException e6) {
                e = e6;
                zipOutputStream2 = zipOutputStream;
                e.printStackTrace();
                d.a.c.e.p.m.f(zipOutputStream2);
                return false;
            } catch (Exception e7) {
                e = e7;
                zipOutputStream2 = zipOutputStream;
                e.printStackTrace();
                d.a.c.e.p.m.f(zipOutputStream2);
                return false;
            } catch (Throwable th2) {
                th = th2;
                zipOutputStream2 = zipOutputStream;
                d.a.c.e.p.m.f(zipOutputStream2);
                throw th;
            }
        }
        return invokeLL.booleanValue;
    }
}
