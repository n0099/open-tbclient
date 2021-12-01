package com.sdk.base.framework.a.b;

import android.text.TextUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.net.HttpURLConnection;
/* loaded from: classes2.dex */
public final class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public b() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:40:0x0096, code lost:
        r14.flush();
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x0099, code lost:
        if (r16 == null) goto L103;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x009b, code lost:
        r16.a(r11, r4, true);
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x00a2, code lost:
        r13.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x00b8, code lost:
        if (r14 == null) goto L42;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x00ba, code lost:
        r14.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x00c3, code lost:
        if (r8.exists() != false) goto L44;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x00cb, code lost:
        r0 = new java.io.File(r8.getParent(), r19);
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x00d8, code lost:
        if (r0.exists() != false) goto L49;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x00da, code lost:
        r0 = new java.io.File(r8.getParent(), java.lang.System.currentTimeMillis() + r19);
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x00fb, code lost:
        if (r8.renameTo(r0) != false) goto L53;
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x00fd, code lost:
        return r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x00fe, code lost:
        return r8;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static File a(HttpURLConnection httpURLConnection, c cVar, String str, boolean z, String str2) {
        InterceptResult invokeCommon;
        BufferedOutputStream bufferedOutputStream;
        FileOutputStream fileOutputStream;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{httpURLConnection, cVar, str, Boolean.valueOf(z), str2})) != null) {
            return (File) invokeCommon.objValue;
        }
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
        long j2 = 0;
        try {
            if (z) {
                j2 = file.length();
                fileOutputStream = new FileOutputStream(str, true);
            } else {
                fileOutputStream = new FileOutputStream(str);
            }
            long j3 = j2;
            long contentLength = httpURLConnection.getContentLength() + j3;
            BufferedInputStream bufferedInputStream2 = new BufferedInputStream(httpURLConnection.getInputStream());
            try {
                bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
                if (cVar != null) {
                    try {
                        if (!cVar.a(contentLength, j3, true)) {
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
                    long j4 = j3;
                    int read = bufferedInputStream2.read(bArr);
                    if (read == -1) {
                        break;
                    }
                    bufferedOutputStream.write(bArr, 0, read);
                    j3 = j4 + read;
                    if (cVar != null && !cVar.a(contentLength, j3, false)) {
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
