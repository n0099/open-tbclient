package com.kwad.sdk.api.loader;

import com.baidu.searchbox.aperf.bosuploader.BOSTokenRequest;
import com.kwad.sdk.api.core.TLSConnectionUtils;
import java.io.BufferedInputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import okhttp3.internal.http2.Http2Codec;
import org.apache.http.protocol.HTTP;
/* loaded from: classes8.dex */
public final class i {
    public static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0084  */
    /* JADX WARN: Type inference failed for: r7v17 */
    /* JADX WARN: Type inference failed for: r7v3, types: [java.io.Closeable] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void b(String str, File file) {
        HttpURLConnection httpURLConnection;
        HttpURLConnection httpURLConnection2;
        BufferedInputStream bufferedInputStream;
        FileOutputStream fileOutputStream;
        BufferedInputStream bufferedInputStream2;
        FileOutputStream fileOutputStream2 = null;
        try {
            if (file.exists()) {
                try {
                    h.d(file);
                } catch (Exception unused) {
                }
            }
            FileOutputStream fileOutputStream3 = new FileOutputStream(file, false);
            try {
                HttpURLConnection httpURLConnection3 = (HttpURLConnection) new URL(str).openConnection();
                TLSConnectionUtils.wrapHttpURLConnection(httpURLConnection3);
                httpURLConnection3.setRequestProperty("Accept-Language", "zh-CN");
                httpURLConnection3.setConnectTimeout(10000);
                httpURLConnection3.setReadTimeout(120000);
                httpURLConnection3.setUseCaches(false);
                httpURLConnection3.setDoInput(true);
                httpURLConnection3.setRequestProperty(HTTP.CONN_DIRECTIVE, Http2Codec.KEEP_ALIVE);
                httpURLConnection3.setRequestProperty(BOSTokenRequest.CHARSET, "UTF-8");
                try {
                    BufferedInputStream bufferedInputStream3 = new BufferedInputStream(httpURLConnection3.getInputStream());
                    try {
                        byte[] bArr = new byte[10240];
                        while (true) {
                            int read = bufferedInputStream3.read(bArr);
                            if (read == -1) {
                                break;
                            }
                            fileOutputStream3.write(bArr, 0, read);
                        }
                        a(fileOutputStream3);
                        a(bufferedInputStream3);
                        if (httpURLConnection3 != null) {
                            httpURLConnection3.disconnect();
                        }
                    } catch (Throwable th) {
                        fileOutputStream = fileOutputStream3;
                        httpURLConnection2 = httpURLConnection3;
                        th = th;
                        bufferedInputStream2 = bufferedInputStream3;
                        fileOutputStream2 = fileOutputStream;
                        bufferedInputStream = bufferedInputStream2;
                        a(fileOutputStream2);
                        a(bufferedInputStream);
                        if (httpURLConnection2 != null) {
                        }
                        throw th;
                    }
                } catch (Throwable th2) {
                    fileOutputStream = fileOutputStream3;
                    httpURLConnection2 = httpURLConnection3;
                    th = th2;
                    bufferedInputStream2 = null;
                }
            } catch (Throwable th3) {
                th = th3;
                httpURLConnection = null;
                fileOutputStream2 = fileOutputStream3;
                httpURLConnection2 = httpURLConnection;
                bufferedInputStream = httpURLConnection;
                a(fileOutputStream2);
                a(bufferedInputStream);
                if (httpURLConnection2 != null) {
                    httpURLConnection2.disconnect();
                }
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
            httpURLConnection = null;
        }
    }
}
