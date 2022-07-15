package com.kwad.sdk.core.diskcache.a;

import androidx.annotation.NonNull;
import com.baidu.searchbox.aperf.bosuploader.BOSTokenRequest;
import com.kwad.sdk.core.diskcache.kwai.a;
import com.kwad.sdk.core.network.n;
import com.kwad.sdk.core.network.p;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.ExecutorService;
import org.apache.http.protocol.HTTP;
/* loaded from: classes5.dex */
public final class c {
    public static ExecutorService a = com.kwad.sdk.core.threads.b.j();

    /* loaded from: classes5.dex */
    public static class a {
        public String a;
    }

    public static File a(@NonNull com.kwad.sdk.core.diskcache.kwai.a aVar, @NonNull String str) {
        try {
            a.c a2 = aVar.a(str);
            if (a2 != null) {
                return a2.a(0);
            }
            return null;
        } catch (IOException unused) {
            return null;
        }
    }

    public static void a(@NonNull final com.kwad.sdk.core.diskcache.kwai.a aVar, @NonNull final String str, @NonNull final String str2) {
        a.execute(new Runnable() { // from class: com.kwad.sdk.core.diskcache.a.c.1
            @Override // java.lang.Runnable
            public final void run() {
                OutputStream outputStream = null;
                try {
                    a.C0537a b = com.kwad.sdk.core.diskcache.kwai.a.this.b(str2);
                    if (b != null) {
                        outputStream = b.a(0);
                        if (c.b(str, outputStream, new a())) {
                            b.a();
                        } else {
                            b.b();
                        }
                        com.kwad.sdk.core.diskcache.kwai.a.this.d();
                    }
                } catch (IOException unused) {
                } finally {
                    com.kwad.sdk.crash.utils.b.a(outputStream);
                }
            }
        });
    }

    public static boolean a(@NonNull com.kwad.sdk.core.diskcache.kwai.a aVar, @NonNull String str, @NonNull String str2, a aVar2) {
        boolean z = false;
        OutputStream outputStream = null;
        try {
            try {
                a.C0537a b = aVar.b(str2);
                if (b != null) {
                    outputStream = b.a(0);
                    if (b(str, outputStream, aVar2)) {
                        b.a();
                        z = true;
                    } else {
                        b.b();
                    }
                    aVar.d();
                }
            } catch (IOException e) {
                aVar2.a = e.getMessage();
            }
            return z;
        } finally {
            com.kwad.sdk.crash.utils.b.a(outputStream);
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
                p.a(httpURLConnection);
                httpURLConnection.setRequestProperty("Accept-Language", "zh-CN");
                httpURLConnection.setConnectTimeout(10000);
                httpURLConnection.setReadTimeout(120000);
                httpURLConnection.setUseCaches(false);
                httpURLConnection.setDoInput(true);
                httpURLConnection.setRequestProperty(HTTP.CONN_DIRECTIVE, "keep-alive");
                httpURLConnection.setRequestProperty(BOSTokenRequest.CHARSET, "UTF-8");
                httpURLConnection.setRequestProperty("User-Agent", n.c());
                httpURLConnection.setRequestProperty("BrowserUa", n.d());
                httpURLConnection.setRequestProperty("SystemUa", n.a());
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
            com.kwad.sdk.crash.utils.b.a(bufferedOutputStream);
            com.kwad.sdk.crash.utils.b.a(bufferedInputStream);
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
            return true;
        } catch (Throwable th4) {
            th = th4;
            bufferedInputStream2 = bufferedInputStream;
            try {
                aVar.a = th.getMessage();
                return false;
            } finally {
                com.kwad.sdk.crash.utils.b.a(bufferedOutputStream);
                com.kwad.sdk.crash.utils.b.a(bufferedInputStream2);
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
            }
        }
    }
}
