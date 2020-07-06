package com.facebook.imagepipeline.producers;

import android.net.Uri;
import com.baidu.ar.arplay.core.message.ARPMessageType;
import com.baidubce.http.Headers;
import com.facebook.imagepipeline.producers.af;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.util.Locale;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
/* loaded from: classes12.dex */
public class u extends c<t> {
    private final ExecutorService mExecutorService;
    private int mTr;

    public u() {
        this(Executors.newFixedThreadPool(3));
    }

    public u(int i) {
        this(Executors.newFixedThreadPool(3));
        this.mTr = i;
    }

    u(ExecutorService executorService) {
        this.mExecutorService = executorService;
    }

    @Override // com.facebook.imagepipeline.producers.af
    public t b(k<com.facebook.imagepipeline.g.e> kVar, ak akVar) {
        return new t(kVar, akVar);
    }

    @Override // com.facebook.imagepipeline.producers.af
    public void a(final t tVar, final af.a aVar) {
        final Future<?> submit = this.mExecutorService.submit(new Runnable() { // from class: com.facebook.imagepipeline.producers.u.1
            @Override // java.lang.Runnable
            public void run() {
                u.this.b(tVar, aVar);
            }
        });
        tVar.dGp().a(new e() { // from class: com.facebook.imagepipeline.producers.u.2
            @Override // com.facebook.imagepipeline.producers.e, com.facebook.imagepipeline.producers.al
            public void dCu() {
                if (submit.cancel(false)) {
                    aVar.dzh();
                }
            }
        });
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [96=4] */
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
    void b(t tVar, af.a aVar) {
        HttpURLConnection httpURLConnection;
        ?? r1 = 0;
        r1 = 0;
        InputStream inputStream = null;
        try {
            try {
                httpURLConnection = c(tVar.getUri(), 5);
                if (httpURLConnection != null) {
                    try {
                        r1 = httpURLConnection.getInputStream();
                        aVar.g(r1, -1);
                        inputStream = r1;
                    } catch (IOException e) {
                        e = e;
                        aVar.G(e);
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

    private HttpURLConnection c(Uri uri, int i) throws IOException {
        HttpURLConnection X = X(uri);
        X.setConnectTimeout(this.mTr);
        int responseCode = X.getResponseCode();
        if (!Jp(responseCode)) {
            if (Jq(responseCode)) {
                String headerField = X.getHeaderField(Headers.LOCATION);
                X.disconnect();
                Uri parse = headerField == null ? null : Uri.parse(headerField);
                String scheme = uri.getScheme();
                if (i > 0 && parse != null && !parse.getScheme().equals(scheme)) {
                    return c(parse, i - 1);
                }
                throw new IOException(i == 0 ? m("URL %s follows too many redirects", uri.toString()) : m("URL %s returned %d without a valid redirect", uri.toString(), Integer.valueOf(responseCode)));
            }
            X.disconnect();
            throw new IOException(String.format("Image URL %s returned HTTP code %d", uri.toString(), Integer.valueOf(responseCode)));
        }
        return X;
    }

    static HttpURLConnection X(Uri uri) throws IOException {
        return (HttpURLConnection) com.facebook.common.util.d.I(uri).openConnection();
    }

    private static boolean Jp(int i) {
        return i >= 200 && i < 300;
    }

    private static boolean Jq(int i) {
        switch (i) {
            case 300:
            case 301:
            case 302:
            case 303:
            case 307:
            case 308:
                return true;
            case 304:
            case 305:
            case ARPMessageType.MSG_TYPE_IMU_MIRROR_DATA /* 306 */:
            default:
                return false;
        }
    }

    private static String m(String str, Object... objArr) {
        return String.format(Locale.getDefault(), str, objArr);
    }
}
