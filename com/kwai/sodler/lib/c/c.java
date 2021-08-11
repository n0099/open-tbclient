package com.kwai.sodler.lib.c;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.imsdk.retrieve.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.kwad.sdk.utils.AbiUtil;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
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
/* loaded from: classes10.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static File a(Context context, File file, String str, File file2) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65536, null, context, file, str, file2)) == null) {
            com.kwai.sodler.lib.a.a("plugin.so", "--");
            String a2 = AbiUtil.a();
            File file3 = null;
            if (TextUtils.isEmpty(a2)) {
                com.kwai.sodler.lib.a.e("plugin.so", "Cpu abis is null.");
            } else {
                com.kwai.sodler.lib.a.a("plugin.so", "Try install soLib, supported abi = " + a2);
                File file4 = new File(file, "lib" + File.separator + a2 + File.separator + str);
                if (file4.exists()) {
                    File file5 = new File(file2, str);
                    if (!file4.renameTo(file5)) {
                        throw new IOException("Rename soLib fail.");
                    }
                    com.kwai.sodler.lib.a.a("plugin.so", "Rename soLib, from = " + file4.getAbsolutePath() + ", to = " + file5.getAbsolutePath());
                    file3 = file5;
                }
            }
            if (file3 == null) {
                com.kwai.sodler.lib.a.b("plugin.so", "Can not install " + str + ", NO_MATCHING_ABIS");
            }
            com.kwai.sodler.lib.a.a("plugin.so", "--");
            return file3;
        }
        return (File) invokeLLLL.objValue;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:34:0x0111 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0155 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r8v11 */
    /* JADX WARN: Type inference failed for: r8v12 */
    /* JADX WARN: Type inference failed for: r8v13, types: [java.io.BufferedInputStream, java.io.InputStream] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Set<String> a(File file, File file2) {
        InterceptResult invokeLL;
        ZipFile zipFile;
        OutputStream outputStream;
        ZipFile zipFile2;
        ZipFile zipFile3;
        ?? r8;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeLL = interceptable.invokeLL(65537, null, file, file2)) != null) {
            return (Set) invokeLL.objValue;
        }
        if (file == null || !file.exists()) {
            throw new IOException("Apk file not found.");
        }
        HashSet hashSet = new HashSet(4);
        a.e(file2);
        com.kwai.sodler.lib.a.a("plugin.so", "copy so file to " + file2.getAbsolutePath() + ", apk = " + file.getName());
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
                        if (name != null && !name.contains(Constants.PATH_PARENT)) {
                            if (!name.startsWith("lib" + File.separator)) {
                                com.kwai.sodler.lib.a.a("plugin.so", "not lib dir entry, skip " + name);
                            } else if (nextElement.isDirectory()) {
                                File file3 = new File(file2, name);
                                com.kwai.sodler.lib.a.a("plugin.so", "create dir " + file3.getAbsolutePath());
                                a.e(file3);
                            } else {
                                File file4 = new File(file2, name);
                                com.kwai.sodler.lib.a.a("plugin.so", "unzip soLib file " + file4.getAbsolutePath());
                                a.d(file4);
                                byte[] bArr = new byte[4096];
                                FileOutputStream fileOutputStream = new FileOutputStream(file4);
                                try {
                                    FileDescriptor fd = fileOutputStream.getFD();
                                    OutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
                                    try {
                                        r8 = new BufferedInputStream(zipFile.getInputStream(nextElement));
                                        while (true) {
                                            try {
                                                int read = r8.read(bArr);
                                                if (read == -1) {
                                                    break;
                                                }
                                                bufferedOutputStream.write(bArr, 0, read);
                                            } catch (IOException e2) {
                                                e = e2;
                                                zipFile4 = zipFile;
                                                outputStream = bufferedOutputStream;
                                                zipFile2 = r8;
                                                try {
                                                    com.kwai.sodler.lib.a.a("plugin.so", e);
                                                    throw new IOException("Unzip soLibs fail.", e);
                                                } catch (Throwable th) {
                                                    th = th;
                                                    zipFile = zipFile4;
                                                    zipFile4 = zipFile2;
                                                    a.a(zipFile4);
                                                    a.a(outputStream);
                                                    if (zipFile != null) {
                                                        try {
                                                            zipFile.close();
                                                        } catch (IOException unused) {
                                                        }
                                                    }
                                                    throw th;
                                                }
                                            } catch (Throwable th2) {
                                                th = th2;
                                                zipFile4 = r8;
                                                outputStream = bufferedOutputStream;
                                                a.a(zipFile4);
                                                a.a(outputStream);
                                                if (zipFile != null) {
                                                }
                                                throw th;
                                            }
                                        }
                                        bufferedOutputStream.flush();
                                        fd.sync();
                                        hashSet.add(file4.getName());
                                        zipFile4 = r8;
                                        outputStream = bufferedOutputStream;
                                    } catch (IOException e3) {
                                        e = e3;
                                        r8 = zipFile4;
                                    } catch (Throwable th3) {
                                        th = th3;
                                    }
                                } catch (IOException e4) {
                                    e = e4;
                                    outputStream = fileOutputStream;
                                    zipFile3 = zipFile4;
                                    zipFile4 = zipFile;
                                    zipFile2 = zipFile3;
                                    com.kwai.sodler.lib.a.a("plugin.so", e);
                                    throw new IOException("Unzip soLibs fail.", e);
                                } catch (Throwable th4) {
                                    th = th4;
                                    outputStream = fileOutputStream;
                                }
                            }
                        }
                    } catch (IOException e5) {
                        e = e5;
                    } catch (Throwable th5) {
                        th = th5;
                    }
                }
                a.a(zipFile4);
                a.a(outputStream);
                try {
                    zipFile.close();
                } catch (IOException unused2) {
                }
                return hashSet;
            } catch (IOException e6) {
                e = e6;
                outputStream = null;
                zipFile3 = null;
            } catch (Throwable th6) {
                th = th6;
                outputStream = null;
            }
        } catch (IOException e7) {
            e = e7;
            outputStream = null;
            zipFile2 = null;
        } catch (Throwable th7) {
            th = th7;
            zipFile = null;
            outputStream = null;
        }
    }
}
