package com.qq.e.comm.plugin.util;

import android.util.Base64;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
/* loaded from: classes4.dex */
public class bj {
    public static String a(String str) {
        if (str == null) {
            return null;
        }
        return Base64.encodeToString(a(str.getBytes(com.qq.e.comm.plugin.f.a.f12290a)), 2);
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x004b A[Catch: Exception -> 0x004f, TRY_LEAVE, TryCatch #0 {Exception -> 0x004f, blocks: (B:30:0x0046, B:32:0x004b), top: B:41:0x0046 }] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0046 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static byte[] a(byte[] bArr) {
        GZIPOutputStream gZIPOutputStream;
        if (bArr != null && bArr.length != 0) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                try {
                    gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
                    try {
                        gZIPOutputStream.write(bArr);
                        gZIPOutputStream.finish();
                        bArr = byteArrayOutputStream.toByteArray();
                        if (gZIPOutputStream != null) {
                            try {
                                gZIPOutputStream.close();
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                        if (byteArrayOutputStream != null) {
                            byteArrayOutputStream.close();
                        }
                    } catch (Exception e2) {
                        e = e2;
                        e.printStackTrace();
                        if (gZIPOutputStream != null) {
                            try {
                                gZIPOutputStream.close();
                            } catch (Exception e3) {
                                e3.printStackTrace();
                                bArr = null;
                            }
                        }
                        if (byteArrayOutputStream != null) {
                            byteArrayOutputStream.close();
                            bArr = null;
                        } else {
                            bArr = null;
                        }
                        return bArr;
                    }
                } catch (Throwable th) {
                    th = th;
                    if (gZIPOutputStream != null) {
                        try {
                            gZIPOutputStream.close();
                        } catch (Exception e4) {
                            e4.printStackTrace();
                            throw th;
                        }
                    }
                    if (byteArrayOutputStream != null) {
                        byteArrayOutputStream.close();
                    }
                    throw th;
                }
            } catch (Exception e5) {
                e = e5;
                gZIPOutputStream = null;
            } catch (Throwable th2) {
                th = th2;
                gZIPOutputStream = null;
                if (gZIPOutputStream != null) {
                }
                if (byteArrayOutputStream != null) {
                }
                throw th;
            }
        }
        return bArr;
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x0067 A[Catch: Exception -> 0x0070, TryCatch #0 {Exception -> 0x0070, blocks: (B:37:0x0062, B:39:0x0067, B:41:0x006c), top: B:50:0x0062 }] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x006c A[Catch: Exception -> 0x0070, TRY_LEAVE, TryCatch #0 {Exception -> 0x0070, blocks: (B:37:0x0062, B:39:0x0067, B:41:0x006c), top: B:50:0x0062 }] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0062 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static byte[] b(byte[] bArr) {
        Throwable th;
        GZIPInputStream gZIPInputStream;
        GZIPInputStream gZIPInputStream2;
        if (bArr == null || bArr.length == 0) {
            return bArr;
        }
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr2 = new byte[1024];
        try {
            try {
                gZIPInputStream2 = new GZIPInputStream(byteArrayInputStream);
                while (true) {
                    try {
                        int read = gZIPInputStream2.read(bArr2);
                        if (read == -1) {
                            break;
                        }
                        byteArrayOutputStream.write(bArr2, 0, read);
                    } catch (Exception e) {
                        e = e;
                        e.printStackTrace();
                        if (gZIPInputStream2 != null) {
                            try {
                                gZIPInputStream2.close();
                            } catch (Exception e2) {
                                e2.printStackTrace();
                                return null;
                            }
                        }
                        if (byteArrayInputStream != null) {
                            byteArrayInputStream.close();
                        }
                        if (byteArrayOutputStream != null) {
                            byteArrayOutputStream.close();
                            return null;
                        }
                        return null;
                    }
                }
                byteArrayOutputStream.flush();
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                if (gZIPInputStream2 != null) {
                    try {
                        gZIPInputStream2.close();
                    } catch (Exception e3) {
                        e3.printStackTrace();
                        return byteArray;
                    }
                }
                if (byteArrayInputStream != null) {
                    byteArrayInputStream.close();
                }
                if (byteArrayOutputStream != null) {
                    byteArrayOutputStream.close();
                    return byteArray;
                }
                return byteArray;
            } catch (Throwable th2) {
                th = th2;
                gZIPInputStream = 1024;
                if (gZIPInputStream != null) {
                    try {
                        gZIPInputStream.close();
                    } catch (Exception e4) {
                        e4.printStackTrace();
                        throw th;
                    }
                }
                if (byteArrayInputStream != null) {
                    byteArrayInputStream.close();
                }
                if (byteArrayOutputStream != null) {
                    byteArrayOutputStream.close();
                }
                throw th;
            }
        } catch (Exception e5) {
            e = e5;
            gZIPInputStream2 = null;
        } catch (Throwable th3) {
            th = th3;
            gZIPInputStream = null;
            if (gZIPInputStream != null) {
            }
            if (byteArrayInputStream != null) {
            }
            if (byteArrayOutputStream != null) {
            }
            throw th;
        }
    }
}
