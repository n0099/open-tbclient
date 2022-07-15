package com.kwai.sodler.lib.d;

import android.text.TextUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.kwad.sdk.utils.o;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Set;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
/* loaded from: classes5.dex */
public final class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static File a(File file, String str, File file2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65536, null, file, str, file2)) == null) {
            String a = a.a();
            File file3 = null;
            if (TextUtils.isEmpty(a)) {
                com.kwai.sodler.lib.a.b("plugin.so", "Cpu abis is null.");
            } else {
                new StringBuilder("Try install soLib, supported abi = ").append(a);
                File file4 = new File(file, "lib" + File.separator + a + File.separator + str);
                if (file4.exists()) {
                    File file5 = new File(file2, str);
                    if (!file4.renameTo(file5)) {
                        throw new IOException("Rename soLib fail.");
                    }
                    StringBuilder sb = new StringBuilder("Rename soLib, from = ");
                    sb.append(file4.getAbsolutePath());
                    sb.append(", to = ");
                    sb.append(file5.getAbsolutePath());
                    file3 = file5;
                }
            }
            if (file3 == null) {
                StringBuilder sb2 = new StringBuilder("Can not install ");
                sb2.append(str);
                sb2.append(", NO_MATCHING_ABIS");
            }
            return file3;
        }
        return (File) invokeLLL.objValue;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:33:0x00e3 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v11 */
    /* JADX WARN: Type inference failed for: r7v12 */
    /* JADX WARN: Type inference failed for: r7v13, types: [java.io.BufferedInputStream, java.io.InputStream] */
    public static Set<String> a(File file, File file2) {
        InterceptResult invokeLL;
        ZipFile zipFile;
        OutputStream outputStream;
        ZipFile zipFile2;
        ZipFile zipFile3;
        ?? r7;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeLL = interceptable.invokeLL(65537, null, file, file2)) != null) {
            return (Set) invokeLL.objValue;
        }
        if (file == null || !file.exists()) {
            throw new IOException("Apk file not found.");
        }
        HashSet hashSet = new HashSet(4);
        o.i(file2);
        StringBuilder sb = new StringBuilder("copy so file to ");
        sb.append(file2.getAbsolutePath());
        sb.append(", apk = ");
        sb.append(file.getName());
        ZipFile zipFile4 = null;
        try {
            zipFile = new ZipFile(file);
            try {
                Enumeration<? extends ZipEntry> entries = zipFile.entries();
                outputStream = null;
                while (entries.hasMoreElements()) {
                    try {
                        ZipEntry nextElement = entries.nextElement();
                        String name = nextElement.getName();
                        if (name != null && !name.contains("../")) {
                            if (!name.startsWith("lib" + File.separator)) {
                                new StringBuilder("not lib dir entry, skip ").append(name);
                            } else if (nextElement.isDirectory()) {
                                File file3 = new File(file2, name);
                                new StringBuilder("create dir ").append(file3.getAbsolutePath());
                                o.i(file3);
                            } else {
                                File file4 = new File(file2, name);
                                new StringBuilder("unzip soLib file ").append(file4.getAbsolutePath());
                                o.j(file4);
                                byte[] bArr = new byte[4096];
                                FileOutputStream fileOutputStream = new FileOutputStream(file4);
                                try {
                                    FileDescriptor fd = fileOutputStream.getFD();
                                    OutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
                                    try {
                                        r7 = new BufferedInputStream(zipFile.getInputStream(nextElement));
                                        while (true) {
                                            try {
                                                int read = r7.read(bArr);
                                                if (read == -1) {
                                                    break;
                                                }
                                                bufferedOutputStream.write(bArr, 0, read);
                                            } catch (IOException e) {
                                                e = e;
                                                zipFile4 = zipFile;
                                                outputStream = bufferedOutputStream;
                                                zipFile2 = r7;
                                                try {
                                                    com.kwai.sodler.lib.a.a("plugin.so", e);
                                                    throw new IOException("Unzip soLibs fail:" + e.getMessage(), e);
                                                } catch (Throwable th) {
                                                    th = th;
                                                    zipFile = zipFile4;
                                                    zipFile4 = zipFile2;
                                                    com.kwad.sdk.crash.utils.b.a((Closeable) zipFile4);
                                                    com.kwad.sdk.crash.utils.b.a(outputStream);
                                                    com.kwad.sdk.crash.utils.b.a(zipFile);
                                                    throw th;
                                                }
                                            } catch (Throwable th2) {
                                                th = th2;
                                                zipFile4 = r7;
                                                outputStream = bufferedOutputStream;
                                                com.kwad.sdk.crash.utils.b.a((Closeable) zipFile4);
                                                com.kwad.sdk.crash.utils.b.a(outputStream);
                                                com.kwad.sdk.crash.utils.b.a(zipFile);
                                                throw th;
                                            }
                                        }
                                        bufferedOutputStream.flush();
                                        fd.sync();
                                        hashSet.add(file4.getName());
                                        zipFile4 = r7;
                                        outputStream = bufferedOutputStream;
                                    } catch (IOException e2) {
                                        e = e2;
                                        r7 = zipFile4;
                                    } catch (Throwable th3) {
                                        th = th3;
                                    }
                                } catch (IOException e3) {
                                    e = e3;
                                    outputStream = fileOutputStream;
                                    zipFile3 = zipFile4;
                                    zipFile4 = zipFile;
                                    zipFile2 = zipFile3;
                                    com.kwai.sodler.lib.a.a("plugin.so", e);
                                    throw new IOException("Unzip soLibs fail:" + e.getMessage(), e);
                                } catch (Throwable th4) {
                                    th = th4;
                                    outputStream = fileOutputStream;
                                }
                            }
                        }
                    } catch (IOException e4) {
                        e = e4;
                    } catch (Throwable th5) {
                        th = th5;
                    }
                }
                com.kwad.sdk.crash.utils.b.a((Closeable) zipFile4);
                com.kwad.sdk.crash.utils.b.a(outputStream);
                com.kwad.sdk.crash.utils.b.a(zipFile);
                return hashSet;
            } catch (IOException e5) {
                e = e5;
                outputStream = null;
                zipFile3 = null;
            } catch (Throwable th6) {
                th = th6;
                outputStream = null;
            }
        } catch (IOException e6) {
            e = e6;
            outputStream = null;
            zipFile2 = null;
        } catch (Throwable th7) {
            th = th7;
            zipFile = null;
            outputStream = null;
        }
    }
}
