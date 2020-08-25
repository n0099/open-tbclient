package com.heytap.mcssdk.utils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
/* loaded from: classes9.dex */
public class GzipUtil {
    private static final int IO_BUF_SIZE = 1024;

    /* JADX WARN: Removed duplicated region for block: B:32:0x0065 A[Catch: IOException -> 0x006c, TryCatch #6 {IOException -> 0x006c, blocks: (B:30:0x0060, B:32:0x0065, B:33:0x0068), top: B:48:0x0060 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static byte[] compress(String str) {
        GZIPOutputStream gZIPOutputStream;
        if (str == null || str.length() == 0) {
            return "".getBytes();
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(str.getBytes());
        GZIPOutputStream gZIPOutputStream2 = null;
        try {
            try {
                gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
                try {
                    byte[] bArr = new byte[1024];
                    while (true) {
                        int read = byteArrayInputStream.read(bArr);
                        if (read > 0) {
                            gZIPOutputStream.write(bArr, 0, read);
                            gZIPOutputStream.flush();
                        } else {
                            try {
                                break;
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                    byteArrayInputStream.close();
                    gZIPOutputStream.close();
                    byteArrayOutputStream.close();
                } catch (IOException e2) {
                    e = e2;
                    LogUtil.e(e);
                    try {
                        byteArrayInputStream.close();
                        if (gZIPOutputStream != null) {
                            gZIPOutputStream.close();
                        }
                        byteArrayOutputStream.close();
                    } catch (IOException e3) {
                        e3.printStackTrace();
                    }
                    return byteArrayOutputStream.toByteArray();
                }
            } catch (Throwable th) {
                th = th;
                try {
                    byteArrayInputStream.close();
                    if (0 != 0) {
                        gZIPOutputStream2.close();
                    }
                    byteArrayOutputStream.close();
                } catch (IOException e4) {
                    e4.printStackTrace();
                }
                throw th;
            }
        } catch (IOException e5) {
            e = e5;
            gZIPOutputStream = null;
        } catch (Throwable th2) {
            th = th2;
            byteArrayInputStream.close();
            if (0 != 0) {
            }
            byteArrayOutputStream.close();
            throw th;
        }
        return byteArrayOutputStream.toByteArray();
    }

    /* JADX WARN: Removed duplicated region for block: B:42:0x0057 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String uncompress(byte[] bArr) {
        GZIPInputStream gZIPInputStream;
        if (bArr == null || bArr.length == 0) {
            return "";
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        GZIPInputStream gZIPInputStream2 = null;
        try {
            try {
                gZIPInputStream = new GZIPInputStream(byteArrayInputStream);
                try {
                    byte[] bArr2 = new byte[1024];
                    while (true) {
                        int read = gZIPInputStream.read(bArr2);
                        if (read > 0) {
                            byteArrayOutputStream.write(bArr2, 0, read);
                            byteArrayOutputStream.flush();
                        } else {
                            try {
                                break;
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                    gZIPInputStream.close();
                    byteArrayInputStream.close();
                    byteArrayOutputStream.close();
                } catch (IOException e2) {
                    e = e2;
                    LogUtil.e(e);
                    if (gZIPInputStream != null) {
                        try {
                            gZIPInputStream.close();
                        } catch (IOException e3) {
                            e3.printStackTrace();
                        }
                    }
                    byteArrayInputStream.close();
                    byteArrayOutputStream.close();
                    return byteArrayOutputStream.toString();
                }
            } catch (Throwable th) {
                th = th;
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
            e = e5;
            gZIPInputStream = null;
        } catch (Throwable th2) {
            th = th2;
            if (0 != 0) {
            }
            byteArrayInputStream.close();
            byteArrayOutputStream.close();
            throw th;
        }
        return byteArrayOutputStream.toString();
    }
}
