package com.facebook.imagepipeline.producers;

import android.net.Uri;
import com.facebook.imagepipeline.producers.af;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Locale;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import okhttp3.internal.http.StatusLine;
/* loaded from: classes2.dex */
public class t extends c<s> {
    private final ExecutorService bav;

    public t() {
        this(Executors.newFixedThreadPool(3));
    }

    t(ExecutorService executorService) {
        this.bav = executorService;
    }

    @Override // com.facebook.imagepipeline.producers.af
    public s d(j<com.facebook.imagepipeline.f.d> jVar, aj ajVar) {
        return new s(jVar, ajVar);
    }

    @Override // com.facebook.imagepipeline.producers.af
    public void a(final s sVar, final af.a aVar) {
        final Future<?> submit = this.bav.submit(new Runnable() { // from class: com.facebook.imagepipeline.producers.t.1
            @Override // java.lang.Runnable
            public void run() {
                t.this.b(sVar, aVar);
            }
        });
        sVar.cKP().a(new e() { // from class: com.facebook.imagepipeline.producers.t.2
            @Override // com.facebook.imagepipeline.producers.e, com.facebook.imagepipeline.producers.ak
            public void cKI() {
                if (submit.cancel(false)) {
                    aVar.cEA();
                }
            }
        });
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [90=4] */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:33:0x0044 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:36:0x000c */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0038  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0033 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r1v0, types: [java.net.HttpURLConnection, java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r1v2, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v4, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r1v7 */
    /* JADX WARN: Type inference failed for: r5v0, types: [com.facebook.imagepipeline.producers.af$a] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    void b(s sVar, af.a aVar) {
        HttpURLConnection httpURLConnection;
        ?? r1 = 0;
        r1 = 0;
        InputStream inputStream = null;
        try {
            try {
                httpURLConnection = b(sVar.getUri(), 5);
                if (httpURLConnection != null) {
                    try {
                        r1 = httpURLConnection.getInputStream();
                        aVar.f(r1, -1);
                        inputStream = r1;
                    } catch (IOException e) {
                        e = e;
                        aVar.B(e);
                        if (r1 != 0) {
                            try {
                                r1.close();
                            } catch (IOException e2) {
                            }
                        }
                        if (httpURLConnection != null) {
                            httpURLConnection.disconnect();
                            return;
                        }
                        return;
                    }
                }
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException e3) {
                    }
                }
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
            } catch (Throwable th) {
                th = th;
                if (0 != 0) {
                    try {
                        r1.close();
                    } catch (IOException e4) {
                    }
                }
                if (0 != 0) {
                    r1.disconnect();
                }
                throw th;
            }
        } catch (IOException e5) {
            e = e5;
            httpURLConnection = null;
        } catch (Throwable th2) {
            th = th2;
            if (0 != 0) {
            }
            if (0 != 0) {
            }
            throw th;
        }
    }

    private HttpURLConnection b(Uri uri, int i) throws IOException {
        HttpURLConnection P = P(uri);
        int responseCode = P.getResponseCode();
        if (!En(responseCode)) {
            if (Eo(responseCode)) {
                String headerField = P.getHeaderField("Location");
                P.disconnect();
                Uri parse = headerField == null ? null : Uri.parse(headerField);
                String scheme = uri.getScheme();
                if (i > 0 && parse != null && !parse.getScheme().equals(scheme)) {
                    return b(parse, i - 1);
                }
                throw new IOException(i == 0 ? m("URL %s follows too many redirects", uri.toString()) : m("URL %s returned %d without a valid redirect", uri.toString(), Integer.valueOf(responseCode)));
            }
            P.disconnect();
            throw new IOException(String.format("Image URL %s returned HTTP code %d", uri.toString(), Integer.valueOf(responseCode)));
        }
        return P;
    }

    static HttpURLConnection P(Uri uri) throws IOException {
        return (HttpURLConnection) new URL(uri.toString()).openConnection();
    }

    private static boolean En(int i) {
        return i >= 200 && i < 300;
    }

    private static boolean Eo(int i) {
        switch (i) {
            case 300:
            case 301:
            case 302:
            case 303:
            case 307:
            case StatusLine.HTTP_PERM_REDIRECT /* 308 */:
                return true;
            case 304:
            case 305:
            case 306:
            default:
                return false;
        }
    }

    private static String m(String str, Object... objArr) {
        return String.format(Locale.getDefault(), str, objArr);
    }
}
