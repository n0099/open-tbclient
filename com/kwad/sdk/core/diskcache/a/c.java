package com.kwad.sdk.core.diskcache.a;

import androidx.annotation.NonNull;
import com.baidu.searchbox.aperf.bosuploader.BOSTokenRequest;
import com.kwad.sdk.core.diskcache.kwai.a;
import com.kwad.sdk.core.network.o;
import com.kwad.sdk.core.network.q;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.ExecutorService;
import okhttp3.internal.http2.Http2Codec;
import org.apache.http.protocol.HTTP;
/* loaded from: classes10.dex */
public final class c {
    public static ExecutorService WG = com.kwad.sdk.core.threads.b.vq();

    /* loaded from: classes10.dex */
    public static class a {
        public String Qd;
    }

    public static File a(@NonNull com.kwad.sdk.core.diskcache.kwai.a aVar, @NonNull String str) {
        try {
            a.c bx = aVar.bx(str);
            if (bx != null) {
                return bx.ax(0);
            }
            return null;
        } catch (IOException unused) {
            return null;
        }
    }

    public static void a(@NonNull final com.kwad.sdk.core.diskcache.kwai.a aVar, @NonNull final String str, @NonNull final String str2) {
        WG.execute(new Runnable() { // from class: com.kwad.sdk.core.diskcache.a.c.1
            @Override // java.lang.Runnable
            public final void run() {
                OutputStream outputStream = null;
                try {
                    a.C0668a by = com.kwad.sdk.core.diskcache.kwai.a.this.by(str2);
                    if (by != null) {
                        outputStream = by.au(0);
                        if (c.a(str, outputStream, new a())) {
                            by.commit();
                        } else {
                            by.abort();
                        }
                        com.kwad.sdk.core.diskcache.kwai.a.this.flush();
                    }
                } catch (IOException unused) {
                } finally {
                    com.kwad.sdk.crash.utils.b.closeQuietly(outputStream);
                }
            }
        });
    }

    public static boolean a(@NonNull com.kwad.sdk.core.diskcache.kwai.a aVar, @NonNull String str, @NonNull String str2, a aVar2) {
        boolean z = false;
        OutputStream outputStream = null;
        try {
            try {
                a.C0668a by = aVar.by(str2);
                if (by != null) {
                    outputStream = by.au(0);
                    if (a(str, outputStream, aVar2)) {
                        by.commit();
                        z = true;
                    } else {
                        by.abort();
                    }
                    aVar.flush();
                }
            } catch (IOException e) {
                aVar2.Qd = e.getMessage();
            }
            return z;
        } finally {
            com.kwad.sdk.crash.utils.b.closeQuietly(outputStream);
        }
    }

    public static boolean a(String str, OutputStream outputStream, a aVar) {
        HttpURLConnection httpURLConnection;
        BufferedOutputStream bufferedOutputStream;
        BufferedInputStream bufferedInputStream;
        BufferedInputStream bufferedInputStream2 = null;
        try {
            httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            try {
                q.wrapHttpURLConnection(httpURLConnection);
                httpURLConnection.setRequestProperty("Accept-Language", "zh-CN");
                httpURLConnection.setConnectTimeout(10000);
                httpURLConnection.setReadTimeout(120000);
                httpURLConnection.setUseCaches(false);
                httpURLConnection.setDoInput(true);
                httpURLConnection.setRequestProperty(HTTP.CONN_DIRECTIVE, Http2Codec.KEEP_ALIVE);
                httpURLConnection.setRequestProperty(BOSTokenRequest.CHARSET, "UTF-8");
                httpURLConnection.setRequestProperty("User-Agent", o.getUserAgent());
                httpURLConnection.setRequestProperty("BrowserUa", o.tD());
                httpURLConnection.setRequestProperty("SystemUa", o.tC());
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
            com.kwad.sdk.crash.utils.b.closeQuietly(bufferedOutputStream);
            com.kwad.sdk.crash.utils.b.closeQuietly(bufferedInputStream);
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
            return true;
        } catch (Throwable th4) {
            th = th4;
            bufferedInputStream2 = bufferedInputStream;
            try {
                aVar.Qd = th.getMessage();
                return false;
            } finally {
                com.kwad.sdk.crash.utils.b.closeQuietly(bufferedOutputStream);
                com.kwad.sdk.crash.utils.b.closeQuietly(bufferedInputStream2);
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
            }
        }
    }
}
