package com.bytedance.sdk.openadsdk.preload.geckox.utils;

import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.Arrays;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
/* loaded from: classes5.dex */
public class l {

    /* renamed from: a  reason: collision with root package name */
    public static byte[] f30044a = {80, 75, 3, 4};

    /* renamed from: b  reason: collision with root package name */
    public static byte[] f30045b = {80, 75, 5, 6};

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v6, types: [java.io.OutputStream, java.io.Closeable, java.io.FileOutputStream] */
    public static void a(InputStream inputStream, String str, String str2) throws Exception {
        ZipInputStream zipInputStream = null;
        try {
            String canonicalPath = new File(str).getCanonicalPath();
            ZipInputStream zipInputStream2 = new ZipInputStream(inputStream);
            boolean z = false;
            while (true) {
                try {
                    ZipEntry nextEntry = zipInputStream2.getNextEntry();
                    if (nextEntry == null) {
                        if (!z) {
                            inputStream.reset();
                            if (!a(inputStream)) {
                                throw new RuntimeException("not zip file  channel:" + str2);
                            }
                            throw new RuntimeException("unzip file: channel:" + str2);
                        }
                        b.a(zipInputStream2);
                        return;
                    }
                    z = true;
                    String name = nextEntry.getName();
                    if (!a(name)) {
                        if (name.startsWith(str2 + File.separator)) {
                            if (nextEntry.isDirectory()) {
                                File file = new File(canonicalPath, name);
                                if (file.getCanonicalPath().startsWith(canonicalPath)) {
                                    file.mkdirs();
                                } else {
                                    throw new RuntimeException("directory traversal, dir:" + name + ", channel:" + str2);
                                }
                            } else {
                                String canonicalPath2 = new File(canonicalPath, name).getCanonicalPath();
                                if (canonicalPath2.startsWith(canonicalPath)) {
                                    File file2 = new File(canonicalPath2);
                                    file2.getParentFile().mkdirs();
                                    try {
                                        ?? fileOutputStream = new FileOutputStream(file2);
                                        try {
                                            d.a(zipInputStream2, fileOutputStream);
                                            b.a((Closeable) fileOutputStream);
                                        } catch (Throwable th) {
                                            th = th;
                                            zipInputStream = fileOutputStream;
                                            b.a(zipInputStream);
                                            throw th;
                                        }
                                    } catch (Throwable th2) {
                                        th = th2;
                                    }
                                } else {
                                    throw new RuntimeException("directory traversal, file name:" + name);
                                }
                            }
                        } else {
                            throw new RuntimeException("the zip package outermost folder is not named by channel channel:" + str2);
                        }
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

    public static boolean a(String str) {
        return str.startsWith("__MACOSX/") || str.equals(".DS_Store");
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x0018, code lost:
        if (java.util.Arrays.equals(com.bytedance.sdk.openadsdk.preload.geckox.utils.l.f30045b, r1) != false) goto L13;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean a(InputStream inputStream) throws Exception {
        try {
            byte[] bArr = new byte[4];
            boolean z = false;
            if (inputStream.read(bArr, 0, 4) == 4) {
                if (!Arrays.equals(f30044a, bArr)) {
                }
                z = true;
                return z;
            }
            return false;
        } finally {
            b.a(inputStream);
        }
    }
}
