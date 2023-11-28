package com.kwad.library.solder.lib.d;

import android.text.TextUtils;
import com.kwad.sdk.utils.q;
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
/* loaded from: classes10.dex */
public final class c {
    /* JADX WARN: Removed duplicated region for block: B:13:0x006b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static File a(File file, String str, File file2) {
        File file3;
        String xz = a.xz();
        if (!TextUtils.isEmpty(xz)) {
            new StringBuilder("Try install soLib, supported abi = ").append(xz);
            File file4 = new File(file, "lib" + File.separator + xz + File.separator + str);
            if (file4.exists()) {
                file3 = new File(file2, str);
                if (file4.renameTo(file3)) {
                    StringBuilder sb = new StringBuilder("Rename soLib, from = ");
                    sb.append(file4.getAbsolutePath());
                    sb.append(", to = ");
                    sb.append(file3.getAbsolutePath());
                    if (file3 == null) {
                        StringBuilder sb2 = new StringBuilder("Can not install ");
                        sb2.append(str);
                        sb2.append(", NO_MATCHING_ABIS");
                    }
                    return file3;
                }
                throw new IOException("Rename soLib fail.");
            }
        }
        file3 = null;
        if (file3 == null) {
        }
        return file3;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:30:0x00da */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v10 */
    /* JADX WARN: Type inference failed for: r7v11 */
    /* JADX WARN: Type inference failed for: r7v12, types: [java.io.BufferedInputStream, java.io.Closeable, java.io.InputStream] */
    public static Set<String> b(File file, File file2) {
        ZipFile zipFile;
        OutputStream outputStream;
        ZipFile zipFile2;
        ZipFile zipFile3;
        ?? r7;
        if (file != null && file.exists()) {
            HashSet hashSet = new HashSet(4);
            q.X(file2);
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
                                    continue;
                                } else if (nextElement.isDirectory()) {
                                    File file3 = new File(file2, name);
                                    new StringBuilder("create dir ").append(file3.getAbsolutePath());
                                    q.X(file3);
                                } else {
                                    File file4 = new File(file2, name);
                                    new StringBuilder("unzip soLib file ").append(file4.getAbsolutePath());
                                    q.Y(file4);
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
                                                        com.kwad.library.solder.lib.a.e("plugin.so", e);
                                                        throw new IOException("Unzip soLibs fail:" + e.getMessage(), e);
                                                    } catch (Throwable th) {
                                                        th = th;
                                                        zipFile = zipFile4;
                                                        zipFile4 = zipFile2;
                                                        com.kwad.sdk.crash.utils.b.closeQuietly((Closeable) zipFile4);
                                                        com.kwad.sdk.crash.utils.b.closeQuietly(outputStream);
                                                        com.kwad.sdk.crash.utils.b.closeQuietly(zipFile);
                                                        throw th;
                                                    }
                                                } catch (Throwable th2) {
                                                    th = th2;
                                                    zipFile4 = r7;
                                                    outputStream = bufferedOutputStream;
                                                    com.kwad.sdk.crash.utils.b.closeQuietly((Closeable) zipFile4);
                                                    com.kwad.sdk.crash.utils.b.closeQuietly(outputStream);
                                                    com.kwad.sdk.crash.utils.b.closeQuietly(zipFile);
                                                    throw th;
                                                }
                                            }
                                            bufferedOutputStream.flush();
                                            fd.sync();
                                            com.kwad.sdk.crash.utils.b.closeQuietly((Closeable) r7);
                                            com.kwad.sdk.crash.utils.b.closeQuietly(bufferedOutputStream);
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
                                        com.kwad.library.solder.lib.a.e("plugin.so", e);
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
                    com.kwad.sdk.crash.utils.b.closeQuietly((Closeable) zipFile4);
                    com.kwad.sdk.crash.utils.b.closeQuietly(outputStream);
                    com.kwad.sdk.crash.utils.b.closeQuietly(zipFile);
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
        } else {
            throw new IOException("Apk file not found.");
        }
    }
}
