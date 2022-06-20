package com.kwad.sdk.core.diskcache.a;

import androidx.annotation.NonNull;
import com.baidu.searchbox.aperf.bosuploader.BOSTokenRequest;
import com.kwad.sdk.core.diskcache.kwai.a;
import com.kwad.sdk.core.network.k;
import com.kwad.sdk.core.network.m;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.ExecutorService;
import org.apache.http.protocol.HTTP;
/* loaded from: classes5.dex */
public class c {
    public static ExecutorService a = com.kwad.sdk.core.i.b.i();

    /* loaded from: classes5.dex */
    public static class a {
        public String a;
    }

    public static void a(@NonNull final com.kwad.sdk.core.diskcache.kwai.a aVar, @NonNull final String str, @NonNull final String str2) {
        a.execute(new Runnable() { // from class: com.kwad.sdk.core.diskcache.a.c.1
            @Override // java.lang.Runnable
            public void run() {
                OutputStream outputStream = null;
                try {
                    try {
                        a.C0302a b = com.kwad.sdk.core.diskcache.kwai.a.this.b(str2);
                        if (b != null) {
                            outputStream = b.a(0);
                            if (c.b(str, outputStream, new a())) {
                                b.a();
                            } else {
                                b.b();
                            }
                            com.kwad.sdk.core.diskcache.kwai.a.this.b();
                        }
                    } catch (IOException e) {
                        com.kwad.sdk.core.d.a.a(e);
                        com.kwad.sdk.core.d.a.a("FileHelper", "downLoadFileAsync file crash", e);
                    }
                } finally {
                    d.a(outputStream);
                }
            }
        });
    }

    public static boolean a(@NonNull com.kwad.sdk.core.diskcache.kwai.a aVar, @NonNull String str, @NonNull String str2, a aVar2) {
        boolean z = false;
        OutputStream outputStream = null;
        try {
            try {
                a.C0302a b = aVar.b(str2);
                if (b != null) {
                    outputStream = b.a(0);
                    if (b(str, outputStream, aVar2)) {
                        b.a();
                        z = true;
                    } else {
                        b.b();
                    }
                    aVar.b();
                }
            } catch (IOException e) {
                com.kwad.sdk.core.d.a.a(e);
                com.kwad.sdk.core.d.a.a("FileHelper", "downLoadFileSync file crash", e);
                aVar2.a = e.getMessage();
            }
            return z;
        } finally {
            d.a(outputStream);
        }
    }

    public static boolean a(@NonNull File file, @NonNull String str) {
        FileOutputStream fileOutputStream;
        FileOutputStream fileOutputStream2 = null;
        try {
            try {
                fileOutputStream = new FileOutputStream(file);
            } catch (Throwable th) {
                th = th;
            }
        } catch (IOException e) {
            e = e;
        }
        try {
            boolean b = b(str, fileOutputStream, new a());
            d.a(fileOutputStream);
            return b;
        } catch (IOException e2) {
            e = e2;
            fileOutputStream2 = fileOutputStream;
            com.kwad.sdk.core.d.a.b(e);
            com.kwad.sdk.core.d.a.a("FileHelper", "downLoadFileSync file crash", e);
            d.a(fileOutputStream2);
            return false;
        } catch (Throwable th2) {
            th = th2;
            fileOutputStream2 = fileOutputStream;
            d.a(fileOutputStream2);
            throw th;
        }
    }

    public static boolean b(String str, OutputStream outputStream, a aVar) {
        HttpURLConnection httpURLConnection;
        BufferedOutputStream bufferedOutputStream;
        BufferedInputStream bufferedInputStream;
        BufferedInputStream bufferedInputStream2 = null;
        try {
            httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            try {
                m.a(httpURLConnection);
                httpURLConnection.setRequestProperty("Accept-Language", "zh-CN");
                httpURLConnection.setConnectTimeout(10000);
                httpURLConnection.setReadTimeout(120000);
                httpURLConnection.setUseCaches(false);
                httpURLConnection.setDoInput(true);
                httpURLConnection.setRequestProperty(HTTP.CONN_DIRECTIVE, "keep-alive");
                httpURLConnection.setRequestProperty(BOSTokenRequest.CHARSET, "UTF-8");
                httpURLConnection.setRequestProperty("User-Agent", k.c());
                httpURLConnection.setRequestProperty("BrowserUa", k.d());
                httpURLConnection.setRequestProperty("SystemUa", k.a());
                bufferedInputStream = new BufferedInputStream(httpURLConnection.getInputStream());
                try {
                    bufferedOutputStream = new BufferedOutputStream(outputStream);
                } catch (Throwable th) {
                    th = th;
                    bufferedOutputStream = null;
                }
            } catch (Throwable th2) {
                th = th2;
                bufferedOutputStream = null;
            }
        } catch (Throwable th3) {
            th = th3;
            httpURLConnection = null;
            bufferedOutputStream = null;
        }
        try {
            byte[] bArr = new byte[1024];
            while (true) {
                int read = bufferedInputStream.read(bArr);
                if (read == -1) {
                    break;
                }
                bufferedOutputStream.write(bArr, 0, read);
            }
            bufferedOutputStream.flush();
            d.a(bufferedOutputStream);
            d.a((Closeable) bufferedInputStream);
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
            return true;
        } catch (Throwable th4) {
            th = th4;
            bufferedInputStream2 = bufferedInputStream;
            try {
                com.kwad.sdk.core.d.a.b(th);
                com.kwad.sdk.core.d.a.a("FileHelper", "downloadUrlToStream file crash", th);
                aVar.a = th.getMessage();
                return false;
            } finally {
                d.a(bufferedOutputStream);
                d.a((Closeable) bufferedInputStream2);
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
            }
        }
    }
}
