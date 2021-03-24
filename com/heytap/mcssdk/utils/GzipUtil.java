package com.heytap.mcssdk.utils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
/* loaded from: classes6.dex */
public class GzipUtil {
    public static final int IO_BUF_SIZE = 1024;

    /* JADX WARN: Removed duplicated region for block: B:35:0x0063 A[Catch: IOException -> 0x006a, TryCatch #0 {IOException -> 0x006a, blocks: (B:33:0x005e, B:35:0x0063, B:36:0x0066), top: B:43:0x005e }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static byte[] compress(String str) {
        GZIPOutputStream gZIPOutputStream;
        Throwable th;
        IOException e2;
        if (str == null || str.length() == 0) {
            return "".getBytes();
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(str.getBytes());
        try {
            try {
                gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
                try {
                    try {
                        byte[] bArr = new byte[1024];
                        while (true) {
                            int read = byteArrayInputStream.read(bArr);
                            if (read <= 0) {
                                break;
                            }
                            gZIPOutputStream.write(bArr, 0, read);
                            gZIPOutputStream.flush();
                        }
                        byteArrayInputStream.close();
                        gZIPOutputStream.close();
                        byteArrayOutputStream.close();
                    } catch (IOException e3) {
                        e2 = e3;
                        LogUtil.e(e2);
                        byteArrayInputStream.close();
                        if (gZIPOutputStream != null) {
                            gZIPOutputStream.close();
                        }
                        byteArrayOutputStream.close();
                        return byteArrayOutputStream.toByteArray();
                    }
                } catch (Throwable th2) {
                    th = th2;
                    try {
                        byteArrayInputStream.close();
                        if (gZIPOutputStream != null) {
                            gZIPOutputStream.close();
                        }
                        byteArrayOutputStream.close();
                    } catch (IOException e4) {
                        e4.printStackTrace();
                    }
                    throw th;
                }
            } catch (IOException e5) {
                e5.printStackTrace();
            }
        } catch (IOException e6) {
            gZIPOutputStream = null;
            e2 = e6;
        } catch (Throwable th3) {
            gZIPOutputStream = null;
            th = th3;
            byteArrayInputStream.close();
            if (gZIPOutputStream != null) {
            }
            byteArrayOutputStream.close();
            throw th;
        }
        return byteArrayOutputStream.toByteArray();
    }

    /* JADX WARN: Removed duplicated region for block: B:42:0x0058 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String uncompress(byte[] bArr) {
        Throwable th;
        GZIPInputStream gZIPInputStream;
        IOException e2;
        if (bArr == null || bArr.length == 0) {
            return "";
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        GZIPInputStream gZIPInputStream2 = null;
        try {
            try {
                try {
                    gZIPInputStream = new GZIPInputStream(byteArrayInputStream);
                    try {
                        byte[] bArr2 = new byte[1024];
                        while (true) {
                            int read = gZIPInputStream.read(bArr2);
                            if (read <= 0) {
                                break;
                            }
                            byteArrayOutputStream.write(bArr2, 0, read);
                            byteArrayOutputStream.flush();
                        }
                        gZIPInputStream.close();
                        byteArrayInputStream.close();
                        byteArrayOutputStream.close();
                    } catch (IOException e3) {
                        e2 = e3;
                        LogUtil.e(e2);
                        if (gZIPInputStream != null) {
                            gZIPInputStream.close();
                        }
                        byteArrayInputStream.close();
                        byteArrayOutputStream.close();
                        return byteArrayOutputStream.toString();
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (0 != 0) {
                        try {
                            gZIPInputStream2.close();
                        } catch (IOException e4) {
                            e4.printStackTrace();
                            throw th;
                        }
                    }
                    byteArrayInputStream.close();
                    byteArrayOutputStream.close();
                    throw th;
                }
            } catch (IOException e5) {
                gZIPInputStream = null;
                e2 = e5;
            } catch (Throwable th3) {
                th = th3;
                if (0 != 0) {
                }
                byteArrayInputStream.close();
                byteArrayOutputStream.close();
                throw th;
            }
        } catch (IOException e6) {
            e6.printStackTrace();
        }
        return byteArrayOutputStream.toString();
    }
}
