package com.bytedance.sdk.openadsdk.preload.geckox.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.Arrays;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
/* loaded from: classes6.dex */
public class l {

    /* renamed from: a  reason: collision with root package name */
    private static byte[] f5109a = {80, 75, 3, 4};
    private static byte[] b = {80, 75, 5, 6};

    public static void a(InputStream inputStream, String str, String str2) throws Exception {
        FileOutputStream fileOutputStream;
        ZipInputStream zipInputStream = null;
        try {
            String canonicalPath = new File(str).getCanonicalPath();
            ZipInputStream zipInputStream2 = new ZipInputStream(inputStream);
            boolean z = false;
            while (true) {
                try {
                    ZipEntry nextEntry = zipInputStream2.getNextEntry();
                    if (nextEntry != null) {
                        z = true;
                        String name = nextEntry.getName();
                        if (!a(name)) {
                            if (!name.startsWith(str2 + File.separator)) {
                                throw new RuntimeException("the zip package outermost folder is not named by channel channel:" + str2);
                            }
                            if (nextEntry.isDirectory()) {
                                File file = new File(canonicalPath, name);
                                if (!file.getCanonicalPath().startsWith(canonicalPath)) {
                                    throw new RuntimeException("directory traversal, dir:" + name + ", channel:" + str2);
                                }
                                file.mkdirs();
                            } else {
                                String canonicalPath2 = new File(canonicalPath, name).getCanonicalPath();
                                if (!canonicalPath2.startsWith(canonicalPath)) {
                                    throw new RuntimeException("directory traversal, file name:" + name);
                                }
                                File file2 = new File(canonicalPath2);
                                file2.getParentFile().mkdirs();
                                try {
                                    fileOutputStream = new FileOutputStream(file2);
                                    try {
                                        d.a(zipInputStream2, fileOutputStream);
                                        b.a(fileOutputStream);
                                    } catch (Throwable th) {
                                        th = th;
                                        b.a(fileOutputStream);
                                        throw th;
                                    }
                                } catch (Throwable th2) {
                                    th = th2;
                                    fileOutputStream = null;
                                }
                            }
                        }
                    } else if (!z) {
                        inputStream.reset();
                        if (!a(inputStream)) {
                            throw new RuntimeException("not zip file  channel:" + str2);
                        }
                        throw new RuntimeException("unzip file: channel:" + str2);
                    } else {
                        b.a(zipInputStream2);
                        return;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    zipInputStream = zipInputStream2;
                    b.a(zipInputStream);
                    throw th;
                }
            }
        } catch (Throwable th4) {
            th = th4;
        }
    }

    private static boolean a(String str) {
        return str.startsWith("__MACOSX/") || str.equals(".DS_Store");
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x001b, code lost:
        if (java.util.Arrays.equals(com.bytedance.sdk.openadsdk.preload.geckox.utils.l.b, r1) != false) goto L13;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static boolean a(InputStream inputStream) throws Exception {
        boolean z = false;
        try {
            byte[] bArr = new byte[4];
            if (inputStream.read(bArr, 0, bArr.length) == bArr.length) {
                if (!Arrays.equals(f5109a, bArr)) {
                }
                z = true;
            }
            return z;
        } finally {
            b.a(inputStream);
        }
    }
}
