package com.sdk.base.framework.a.b;

import android.text.TextUtils;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.net.HttpURLConnection;
/* loaded from: classes6.dex */
public final class b {
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0092, code lost:
        r14.flush();
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x0095, code lost:
        if (r16 == null) goto L101;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x0097, code lost:
        r16.a(r11, r4, true);
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x009e, code lost:
        r13.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x00b4, code lost:
        if (r14 == null) goto L40;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x00b6, code lost:
        r14.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x00bf, code lost:
        if (r8.exists() != false) goto L42;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x00c7, code lost:
        r0 = new java.io.File(r8.getParent(), r19);
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x00d4, code lost:
        if (r0.exists() != false) goto L47;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x00d6, code lost:
        r0 = new java.io.File(r8.getParent(), java.lang.System.currentTimeMillis() + r19);
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x00f7, code lost:
        if (r8.renameTo(r0) != false) goto L51;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x00f9, code lost:
        return r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x00fa, code lost:
        return r8;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static File a(HttpURLConnection httpURLConnection, c cVar, String str, boolean z, String str2) {
        BufferedOutputStream bufferedOutputStream;
        FileOutputStream fileOutputStream;
        BufferedInputStream bufferedInputStream = null;
        if (httpURLConnection == null || TextUtils.isEmpty(str)) {
            return null;
        }
        File file = new File(str);
        if (!file.exists()) {
            File parentFile = file.getParentFile();
            if (parentFile.exists() || parentFile.mkdirs()) {
                file.createNewFile();
            }
        }
        long j = 0;
        try {
            if (z) {
                j = file.length();
                fileOutputStream = new FileOutputStream(str, true);
            } else {
                fileOutputStream = new FileOutputStream(str);
            }
            long j2 = j;
            long contentLength = httpURLConnection.getContentLength() + j2;
            BufferedInputStream bufferedInputStream2 = new BufferedInputStream(httpURLConnection.getInputStream());
            try {
                bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
                if (cVar != null) {
                    try {
                        if (!cVar.a(contentLength, j2, true)) {
                            try {
                                bufferedInputStream2.close();
                            } catch (Throwable unused) {
                            }
                            try {
                                bufferedOutputStream.close();
                            } catch (Throwable unused2) {
                            }
                            return file;
                        }
                    } catch (Throwable th) {
                        th = th;
                        bufferedInputStream = bufferedInputStream2;
                        try {
                            th.printStackTrace();
                            if (bufferedInputStream != null) {
                                try {
                                    bufferedInputStream.close();
                                } catch (Throwable unused3) {
                                }
                            }
                        } catch (Throwable th2) {
                            if (bufferedInputStream != null) {
                                try {
                                    bufferedInputStream.close();
                                } catch (Throwable unused4) {
                                }
                            }
                            if (bufferedOutputStream != null) {
                                try {
                                    bufferedOutputStream.close();
                                } catch (Throwable unused5) {
                                }
                            }
                            throw th2;
                        }
                    }
                }
                byte[] bArr = new byte[4096];
                while (true) {
                    long j3 = j2;
                    int read = bufferedInputStream2.read(bArr);
                    if (read == -1) {
                        break;
                    }
                    bufferedOutputStream.write(bArr, 0, read);
                    j2 = j3 + read;
                    if (cVar != null && !cVar.a(contentLength, j2, false)) {
                        try {
                            bufferedInputStream2.close();
                        } catch (Throwable unused6) {
                        }
                        try {
                            bufferedOutputStream.close();
                        } catch (Throwable unused7) {
                        }
                        return file;
                    }
                }
            } catch (Throwable th3) {
                th = th3;
                bufferedOutputStream = null;
            }
        } catch (Throwable th4) {
            th = th4;
            bufferedOutputStream = null;
        }
    }
}
