package com.sdk.c;

import android.text.TextUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.sdk.a.e;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.net.HttpURLConnection;
/* loaded from: classes8.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:135:?, code lost:
        return r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:136:?, code lost:
        return r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x009f, code lost:
        r6 = r13;
        r7 = r14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x00a1, code lost:
        r6.flush();
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x00a4, code lost:
        if (r19 == null) goto L114;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x00ad, code lost:
        ((com.sdk.a.e) r19).a(r15, r4, true);
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x00b0, code lost:
        r7.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x00cb, code lost:
        if (r6 == null) goto L48;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x00ce, code lost:
        r6.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x00d7, code lost:
        if (r3.exists() == false) goto L63;
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x00df, code lost:
        r0 = new java.io.File(r3.getParent(), r22);
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x00ec, code lost:
        if (r0.exists() != false) goto L55;
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x00ee, code lost:
        r0 = new java.io.File(r3.getParent(), java.lang.System.currentTimeMillis() + r22);
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x010f, code lost:
        if (r3.renameTo(r0) != false) goto L59;
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x0112, code lost:
        return r0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public File a(HttpURLConnection httpURLConnection, b bVar, String str, boolean z, String str2) {
        InterceptResult invokeCommon;
        BufferedOutputStream bufferedOutputStream;
        FileOutputStream fileOutputStream;
        long contentLength;
        BufferedInputStream bufferedInputStream;
        BufferedInputStream bufferedInputStream2;
        BufferedOutputStream bufferedOutputStream2;
        byte[] bArr;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{httpURLConnection, bVar, str, Boolean.valueOf(z), str2})) != null) {
            return (File) invokeCommon.objValue;
        }
        BufferedInputStream bufferedInputStream3 = null;
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
            contentLength = httpURLConnection.getContentLength() + j;
            bufferedInputStream = new BufferedInputStream(httpURLConnection.getInputStream());
            try {
                bufferedOutputStream2 = new BufferedOutputStream(fileOutputStream);
                if (bVar != null) {
                    try {
                        if (!((e) bVar).a(contentLength, j, true)) {
                            try {
                                bufferedInputStream.close();
                            } catch (Throwable unused) {
                            }
                            try {
                                bufferedOutputStream2.close();
                            } catch (Throwable unused2) {
                            }
                            return file;
                        }
                    } catch (Throwable th) {
                        th = th;
                        bufferedOutputStream = bufferedOutputStream2;
                        bufferedInputStream2 = bufferedInputStream;
                    }
                }
                bArr = new byte[4096];
            } catch (Throwable th2) {
                th = th2;
                bufferedInputStream2 = bufferedInputStream;
                bufferedOutputStream = null;
            }
        } catch (Throwable th3) {
            th = th3;
            bufferedOutputStream = null;
        }
        while (true) {
            int read = bufferedInputStream.read(bArr);
            if (read == -1) {
                break;
            }
            bufferedOutputStream2.write(bArr, 0, read);
            j += read;
            if (bVar != null) {
                bufferedOutputStream = bufferedOutputStream2;
                bufferedInputStream2 = bufferedInputStream;
                try {
                    if (!((e) bVar).a(contentLength, j, false)) {
                        try {
                            bufferedInputStream2.close();
                        } catch (Throwable unused3) {
                        }
                        try {
                            bufferedOutputStream.close();
                        } catch (Throwable unused4) {
                        }
                        return file;
                    }
                } catch (Throwable th4) {
                    th = th4;
                }
            } else {
                bufferedOutputStream = bufferedOutputStream2;
                bufferedInputStream2 = bufferedInputStream;
            }
            bufferedOutputStream2 = bufferedOutputStream;
            bufferedInputStream = bufferedInputStream2;
            th = th4;
            bufferedInputStream3 = bufferedInputStream2;
            try {
                th.printStackTrace();
                if (bufferedInputStream3 != null) {
                    try {
                        bufferedInputStream3.close();
                    } catch (Throwable unused5) {
                    }
                }
            } catch (Throwable th5) {
                if (bufferedInputStream3 != null) {
                    try {
                        bufferedInputStream3.close();
                    } catch (Throwable unused6) {
                    }
                }
                if (bufferedOutputStream != null) {
                    try {
                        bufferedOutputStream.close();
                    } catch (Throwable unused7) {
                    }
                }
                throw th5;
            }
        }
    }
}
