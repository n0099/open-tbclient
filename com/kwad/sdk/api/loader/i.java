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
/* loaded from: classes10.dex */
public final class i {
    public static HttpURLConnection bT(String str) {
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
        TLSConnectionUtils.wrapHttpURLConnection(httpURLConnection);
        httpURLConnection.setRequestProperty("Accept-Language", "zh-CN");
        httpURLConnection.setConnectTimeout(10000);
        httpURLConnection.setReadTimeout(120000);
        httpURLConnection.setUseCaches(false);
        httpURLConnection.setDoInput(true);
        httpURLConnection.setRequestProperty(HTTP.CONN_DIRECTIVE, Http2Codec.KEEP_ALIVE);
        httpURLConnection.setRequestProperty(BOSTokenRequest.CHARSET, "UTF-8");
        return httpURLConnection;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0056  */
    /* JADX WARN: Type inference failed for: r7v10 */
    /* JADX WARN: Type inference failed for: r7v3, types: [java.io.Closeable] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void c(String str, File file) {
        HttpURLConnection httpURLConnection;
        HttpURLConnection httpURLConnection2;
        BufferedInputStream bufferedInputStream;
        HttpURLConnection bT;
        FileOutputStream fileOutputStream;
        BufferedInputStream bufferedInputStream2;
        BufferedInputStream bufferedInputStream3;
        FileOutputStream fileOutputStream2 = null;
        try {
            if (file.exists()) {
                h.j(file);
            }
            FileOutputStream fileOutputStream3 = new FileOutputStream(file, false);
            try {
                file.setReadOnly();
                bT = bT(str);
                try {
                    bufferedInputStream3 = new BufferedInputStream(bT.getInputStream());
                } catch (Throwable th) {
                    fileOutputStream = fileOutputStream3;
                    httpURLConnection2 = bT;
                    th = th;
                    bufferedInputStream2 = null;
                }
            } catch (Throwable th2) {
                th = th2;
                httpURLConnection = null;
                fileOutputStream2 = fileOutputStream3;
                httpURLConnection2 = httpURLConnection;
                bufferedInputStream = httpURLConnection;
                closeQuietly(fileOutputStream2);
                closeQuietly(bufferedInputStream);
                if (httpURLConnection2 != null) {
                    httpURLConnection2.disconnect();
                }
                throw th;
            }
            try {
                byte[] bArr = new byte[10240];
                while (true) {
                    int read = bufferedInputStream3.read(bArr);
                    if (read == -1) {
                        break;
                    }
                    fileOutputStream3.write(bArr, 0, read);
                }
                closeQuietly(fileOutputStream3);
                closeQuietly(bufferedInputStream3);
                if (bT != null) {
                    bT.disconnect();
                }
            } catch (Throwable th3) {
                fileOutputStream = fileOutputStream3;
                httpURLConnection2 = bT;
                th = th3;
                bufferedInputStream2 = bufferedInputStream3;
                fileOutputStream2 = fileOutputStream;
                bufferedInputStream = bufferedInputStream2;
                closeQuietly(fileOutputStream2);
                closeQuietly(bufferedInputStream);
                if (httpURLConnection2 != null) {
                }
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
            httpURLConnection = null;
        }
    }

    public static void closeQuietly(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
            }
        }
    }
}
