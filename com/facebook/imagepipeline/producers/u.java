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
import okhttp3.internal.http.StatusLine;
/* loaded from: classes5.dex */
public class u extends c<t> {
    private final ExecutorService mExecutorService;
    private int pLv;

    public u() {
        this(Executors.newFixedThreadPool(3));
    }

    public u(int i) {
        this(Executors.newFixedThreadPool(3));
        this.pLv = i;
    }

    u(ExecutorService executorService) {
        this.mExecutorService = executorService;
    }

    @Override // com.facebook.imagepipeline.producers.af
    public t d(k<com.facebook.imagepipeline.f.e> kVar, ak akVar) {
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
        tVar.ezM().a(new e() { // from class: com.facebook.imagepipeline.producers.u.2
            @Override // com.facebook.imagepipeline.producers.e, com.facebook.imagepipeline.producers.al
            public void ezF() {
                if (submit.cancel(false)) {
                    aVar.esM();
                }
            }
        });
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [96=4] */
    void b(t tVar, af.a aVar) {
        InputStream inputStream;
        HttpURLConnection httpURLConnection;
        InputStream inputStream2;
        try {
            try {
                httpURLConnection = c(tVar.getUri(), 5);
                if (httpURLConnection != null) {
                    try {
                        inputStream2 = httpURLConnection.getInputStream();
                        try {
                            aVar.f(inputStream2, -1);
                        } catch (IOException e) {
                            e = e;
                            aVar.C(e);
                            if (inputStream2 != null) {
                                try {
                                    inputStream2.close();
                                } catch (IOException e2) {
                                }
                            }
                            if (httpURLConnection != null) {
                                httpURLConnection.disconnect();
                                return;
                            }
                            return;
                        }
                    } catch (IOException e3) {
                        e = e3;
                        inputStream2 = null;
                    } catch (Throwable th) {
                        th = th;
                        inputStream = null;
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (IOException e4) {
                            }
                        }
                        if (httpURLConnection != null) {
                            httpURLConnection.disconnect();
                        }
                        throw th;
                    }
                } else {
                    inputStream2 = null;
                }
                if (inputStream2 != null) {
                    try {
                        inputStream2.close();
                    } catch (IOException e5) {
                    }
                }
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (IOException e6) {
            e = e6;
            inputStream2 = null;
            httpURLConnection = null;
        } catch (Throwable th3) {
            th = th3;
            inputStream = null;
            httpURLConnection = null;
        }
    }

    private HttpURLConnection c(Uri uri, int i) throws IOException {
        HttpURLConnection ab = ab(uri);
        ab.setConnectTimeout(this.pLv);
        int responseCode = ab.getResponseCode();
        if (!Qq(responseCode)) {
            if (isHttpRedirect(responseCode)) {
                String headerField = ab.getHeaderField(Headers.LOCATION);
                ab.disconnect();
                Uri parse = headerField == null ? null : Uri.parse(headerField);
                String scheme = uri.getScheme();
                if (i > 0 && parse != null && !parse.getScheme().equals(scheme)) {
                    return c(parse, i - 1);
                }
                throw new IOException(i == 0 ? m("URL %s follows too many redirects", uri.toString()) : m("URL %s returned %d without a valid redirect", uri.toString(), Integer.valueOf(responseCode)));
            }
            ab.disconnect();
            throw new IOException(String.format("Image URL %s returned HTTP code %d", uri.toString(), Integer.valueOf(responseCode)));
        }
        return ab;
    }

    static HttpURLConnection ab(Uri uri) throws IOException {
        return (HttpURLConnection) com.facebook.common.util.d.J(uri).openConnection();
    }

    private static boolean Qq(int i) {
        return i >= 200 && i < 300;
    }

    private static boolean isHttpRedirect(int i) {
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
            case ARPMessageType.MSG_TYPE_IMU_MIRROR_DATA /* 306 */:
            default:
                return false;
        }
    }

    private static String m(String str, Object... objArr) {
        return String.format(Locale.getDefault(), str, objArr);
    }
}
