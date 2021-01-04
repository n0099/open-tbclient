package com.kwai.sodler.lib.c;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.imsdk.retrieve.Constants;
import com.kwad.sdk.crash.utils.AbiUtil;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Set;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
/* loaded from: classes5.dex */
public class c {
    public static File a(Context context, File file, String str, File file2) {
        com.kwai.sodler.lib.a.a("plugin.so", "--");
        File file3 = null;
        String a2 = AbiUtil.a();
        if (TextUtils.isEmpty(a2)) {
            com.kwai.sodler.lib.a.e("plugin.so", "Cpu abis is null.");
        } else {
            com.kwai.sodler.lib.a.a("plugin.so", "Try install soLib, supported abi = " + a2);
            File file4 = new File(file, "lib" + File.separator + a2 + File.separator + str);
            if (file4.exists()) {
                file3 = new File(file2, str);
                if (!file4.renameTo(file3)) {
                    throw new IOException("Rename soLib fail.");
                }
                com.kwai.sodler.lib.a.a("plugin.so", "Rename soLib, from = " + file4.getAbsolutePath() + ", to = " + file3.getAbsolutePath());
            }
        }
        if (file3 == null) {
            com.kwai.sodler.lib.a.b("plugin.so", "Can not install " + str + ", NO_MATCHING_ABIS");
        }
        com.kwai.sodler.lib.a.a("plugin.so", "--");
        return file3;
    }

    public static Set<String> a(File file, File file2) {
        BufferedOutputStream bufferedOutputStream;
        BufferedInputStream bufferedInputStream;
        ZipFile zipFile;
        BufferedInputStream bufferedInputStream2;
        BufferedOutputStream bufferedOutputStream2;
        if (file == null || !file.exists()) {
            throw new IOException("Apk file not found.");
        }
        HashSet hashSet = new HashSet(4);
        a.e(file2);
        com.kwai.sodler.lib.a.a("plugin.so", "copy so file to " + file2.getAbsolutePath() + ", apk = " + file.getName());
        try {
            zipFile = new ZipFile(file);
            try {
                Enumeration<? extends ZipEntry> entries = zipFile.entries();
                bufferedOutputStream = null;
                bufferedInputStream = null;
                while (entries.hasMoreElements()) {
                    try {
                        try {
                            ZipEntry nextElement = entries.nextElement();
                            String name = nextElement.getName();
                            if (name != null && !name.contains(Constants.PATH_PARENT)) {
                                if (name.startsWith("lib" + File.separator)) {
                                    if (nextElement.isDirectory()) {
                                        File file3 = new File(file2, name);
                                        com.kwai.sodler.lib.a.a("plugin.so", "create dir " + file3.getAbsolutePath());
                                        a.e(file3);
                                        bufferedOutputStream2 = bufferedOutputStream;
                                        bufferedInputStream2 = bufferedInputStream;
                                    } else {
                                        File file4 = new File(file2, name);
                                        com.kwai.sodler.lib.a.a("plugin.so", "unzip soLib file " + file4.getAbsolutePath());
                                        a.d(file4);
                                        byte[] bArr = new byte[4096];
                                        FileOutputStream fileOutputStream = new FileOutputStream(file4);
                                        try {
                                            FileDescriptor fd = fileOutputStream.getFD();
                                            bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
                                            bufferedInputStream2 = new BufferedInputStream(zipFile.getInputStream(nextElement));
                                            while (true) {
                                                try {
                                                    int read = bufferedInputStream2.read(bArr);
                                                    if (read == -1) {
                                                        break;
                                                    }
                                                    bufferedOutputStream.write(bArr, 0, read);
                                                } catch (IOException e) {
                                                    e = e;
                                                    bufferedInputStream = bufferedInputStream2;
                                                    com.kwai.sodler.lib.a.a("plugin.so", e);
                                                    throw new IOException("Unzip soLibs fail.", e);
                                                } catch (Throwable th) {
                                                    th = th;
                                                    bufferedInputStream = bufferedInputStream2;
                                                    a.a((Object) bufferedInputStream);
                                                    a.a(bufferedOutputStream);
                                                    if (zipFile != null) {
                                                        try {
                                                            zipFile.close();
                                                        } catch (IOException e2) {
                                                        }
                                                    }
                                                    throw th;
                                                }
                                            }
                                            bufferedOutputStream.flush();
                                            fd.sync();
                                            hashSet.add(file4.getName());
                                            bufferedOutputStream2 = bufferedOutputStream;
                                        } catch (IOException e3) {
                                            e = e3;
                                            bufferedOutputStream = fileOutputStream;
                                        } catch (Throwable th2) {
                                            th = th2;
                                            bufferedOutputStream = fileOutputStream;
                                        }
                                    }
                                    bufferedOutputStream = bufferedOutputStream2;
                                    bufferedInputStream = bufferedInputStream2;
                                } else {
                                    com.kwai.sodler.lib.a.a("plugin.so", "not lib dir entry, skip " + name);
                                }
                            }
                        } catch (IOException e4) {
                            e = e4;
                        }
                    } catch (Throwable th3) {
                        th = th3;
                    }
                }
                a.a((Object) bufferedInputStream);
                a.a(bufferedOutputStream);
                if (zipFile != null) {
                    try {
                        zipFile.close();
                    } catch (IOException e5) {
                    }
                }
                return hashSet;
            } catch (IOException e6) {
                e = e6;
                bufferedOutputStream = null;
                bufferedInputStream = null;
            } catch (Throwable th4) {
                th = th4;
                bufferedOutputStream = null;
                bufferedInputStream = null;
            }
        } catch (IOException e7) {
            e = e7;
            bufferedOutputStream = null;
            bufferedInputStream = null;
            zipFile = null;
        } catch (Throwable th5) {
            th = th5;
            bufferedOutputStream = null;
            bufferedInputStream = null;
            zipFile = null;
        }
    }
}
