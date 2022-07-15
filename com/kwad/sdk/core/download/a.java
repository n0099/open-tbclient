package com.kwad.sdk.core.download;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;
import com.baidu.searchbox.aperf.bosuploader.BOSTokenRequest;
import com.baidubce.http.Headers;
import com.ksad.download.DownloadTask;
import com.kwad.sdk.core.network.n;
import com.kwad.sdk.core.network.p;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.export.proxy.AdDownloadProxy;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.ac;
import com.kwad.sdk.utils.af;
import com.kwad.sdk.utils.ap;
import com.kwad.sdk.utils.t;
import com.kwad.sdk.utils.u;
import com.kwad.sdk.utils.z;
import java.io.BufferedInputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.zip.GZIPInputStream;
import org.apache.http.protocol.HTTP;
/* loaded from: classes5.dex */
public final class a {
    public static volatile boolean a;
    @SuppressLint({"StaticFieldLeak"})
    public static Context b;
    public static AdDownloadProxy c;
    public static final String d = ap.a(((com.kwad.sdk.service.kwai.d) ServiceProvider.a(com.kwad.sdk.service.kwai.d.class)).a()) + "/downloadFileSync/.temp";
    public static final ExecutorService e = com.kwad.sdk.core.threads.b.j();

    /* renamed from: com.kwad.sdk.core.download.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static class C0539a implements c {
        public final OutputStream a;

        public C0539a(File file, boolean z) {
            this.a = new FileOutputStream(file, z);
        }

        @Override // com.kwad.sdk.core.download.a.c
        public final void a(byte[] bArr, int i, int i2) {
            this.a.write(bArr, 0, i2);
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public final void close() {
            this.a.close();
        }
    }

    /* loaded from: classes5.dex */
    public interface b {
    }

    /* loaded from: classes5.dex */
    public interface c extends Closeable {
        void a(byte[] bArr, int i, int i2);
    }

    public static InputStream a(Map<String, List<String>> map, InputStream inputStream) {
        List<String> value;
        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            if ("Content-Encoding".equalsIgnoreCase(entry.getKey()) && (value = entry.getValue()) != null && !value.isEmpty()) {
                boolean z = false;
                Iterator<String> it = value.iterator();
                while (true) {
                    if (it.hasNext()) {
                        if ("gzip".equalsIgnoreCase(it.next())) {
                            z = true;
                            break;
                        }
                    } else {
                        break;
                    }
                }
                if (z) {
                    try {
                        return new GZIPInputStream(inputStream);
                    } catch (IOException unused) {
                    }
                } else {
                    continue;
                }
            }
        }
        return inputStream;
    }

    @Nullable
    public static String a(AdInfo adInfo) {
        AdDownloadProxy adDownloadProxy;
        return (b == null || (adDownloadProxy = c) == null) ? "" : adDownloadProxy.getDownloadFilePath(DownloadParams.transform(adInfo));
    }

    public static URLConnection a(String str, int i, int i2, boolean z) {
        try {
            URLConnection openConnection = new URL(str).openConnection();
            p.a(openConnection);
            openConnection.setRequestProperty("Accept-Language", "zh-CN");
            openConnection.setConnectTimeout(10000);
            if (i2 > 0) {
                openConnection.setReadTimeout(i2);
            }
            openConnection.setUseCaches(false);
            openConnection.setDoInput(true);
            openConnection.setRequestProperty(HTTP.CONN_DIRECTIVE, "keep-alive");
            openConnection.setRequestProperty(BOSTokenRequest.CHARSET, "UTF-8");
            return openConnection;
        } catch (MalformedURLException e2) {
            com.kwad.sdk.core.d.b.a(e2);
            return null;
        }
    }

    public static void a(int i, AdTemplate adTemplate) {
        d dVar = (d) ServiceProvider.a(d.class);
        if (dVar != null) {
            dVar.a(1, adTemplate);
        }
    }

    public static synchronized void a(Context context, @NonNull File file, boolean z) {
        synchronized (a.class) {
            if (context != null) {
                if (!a) {
                    b = context;
                    com.ksad.download.d.a(context, file, new com.kwad.sdk.core.download.a.a(context));
                    e.a().a(context);
                    com.ksad.download.d.a().a(new com.kwad.sdk.core.download.b());
                    com.ksad.download.b.a(new com.ksad.download.a() { // from class: com.kwad.sdk.core.download.a.1
                        @Override // com.ksad.download.a
                        public final void a(DownloadTask downloadTask, String str) {
                            if (af.d(a.b, str)) {
                                com.kwad.sdk.core.download.c.f(z.a(downloadTask.getUrl()));
                            }
                        }
                    });
                    c = new com.kwad.sdk.core.download.b.a(z && a(context));
                    a = true;
                }
            }
        }
    }

    public static void a(@NonNull AdInfo adInfo, boolean z) {
        Context context = b;
        if (context == null) {
            return;
        }
        if (!ac.b(context)) {
            Context context2 = b;
            t.a(context2, u.a(context2));
            return;
        }
        DownloadParams transform = DownloadParams.transform(adInfo);
        transform.requestInstallPermission = false;
        c.startDownload(b, transform.mDownloadid, transform);
    }

    public static void a(String str) {
        if (b == null || c == null || TextUtils.isEmpty(str)) {
            return;
        }
        c.pauseDownload(b, str, null);
    }

    public static boolean a(Context context) {
        try {
            new NotificationCompat.Builder(context, "");
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static boolean a(String str, File file) {
        try {
            return a(str, file, (b) null, 0);
        } catch (Throwable th) {
            com.kwad.sdk.core.d.b.b(th);
            return false;
        }
    }

    public static boolean a(String str, File file, b bVar, int i) {
        C0539a c0539a;
        C0539a c0539a2 = null;
        try {
            c0539a = new C0539a(file, false);
        } catch (Throwable th) {
            th = th;
        }
        try {
            boolean a2 = a(str, (String) null, c0539a, (b) null, 0);
            com.kwad.sdk.crash.utils.b.a(c0539a);
            return a2;
        } catch (Throwable th2) {
            th = th2;
            c0539a2 = c0539a;
            com.kwad.sdk.crash.utils.b.a(c0539a2);
            throw th;
        }
    }

    public static boolean a(String str, File file, b bVar, int i, boolean z) {
        C0539a c0539a = null;
        try {
            C0539a c0539a2 = new C0539a(file, true);
            try {
                boolean a2 = a(str, (String) null, (c) c0539a2, (b) null, -1, file.length(), -1L, true);
                com.kwad.sdk.crash.utils.b.a(c0539a2);
                return a2;
            } catch (Throwable th) {
                th = th;
                c0539a = c0539a2;
                com.kwad.sdk.crash.utils.b.a(c0539a);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static boolean a(String str, String str2, c cVar, b bVar, int i) {
        return a(str, (String) null, cVar, bVar, i, -1L, -1L, false);
    }

    public static boolean a(String str, String str2, c cVar, b bVar, int i, long j, long j2, boolean z) {
        HttpURLConnection httpURLConnection;
        HttpURLConnection httpURLConnection2 = null;
        try {
            httpURLConnection = (HttpURLConnection) a(str, 10000, i > 0 ? i : 120000, false);
        } catch (Throwable th) {
            th = th;
        }
        try {
            if (httpURLConnection != null) {
                boolean a2 = a(httpURLConnection, str2, cVar, bVar, i, j, -1L, z);
                com.kwad.sdk.crash.utils.b.a(cVar);
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
                return a2;
            }
            throw new IOException("Fail to createUrlConnection");
        } catch (Throwable th2) {
            th = th2;
            httpURLConnection2 = httpURLConnection;
            com.kwad.sdk.crash.utils.b.a(cVar);
            if (httpURLConnection2 != null) {
                httpURLConnection2.disconnect();
            }
            throw th;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:65:0x0157 A[Catch: all -> 0x0181, TryCatch #1 {all -> 0x0181, blocks: (B:63:0x0153, B:65:0x0157, B:67:0x0180, B:66:0x015a), top: B:77:0x0153 }] */
    /* JADX WARN: Removed duplicated region for block: B:66:0x015a A[Catch: all -> 0x0181, TryCatch #1 {all -> 0x0181, blocks: (B:63:0x0153, B:65:0x0157, B:67:0x0180, B:66:0x015a), top: B:77:0x0153 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean a(HttpURLConnection httpURLConnection, String str, c cVar, b bVar, int i, long j, long j2, boolean z) {
        FileOutputStream fileOutputStream;
        File file;
        InputStream inputStream = null;
        if (j > 0 && z) {
            try {
                Object[] objArr = new Object[2];
                objArr[0] = Long.valueOf(j);
                objArr[1] = j2 > 0 ? Long.valueOf(j2) : "";
                httpURLConnection.setRequestProperty("Range", String.format("bytes=%s-%s", objArr));
            } catch (Throwable th) {
                th = th;
                fileOutputStream = null;
                file = null;
                try {
                    if (th instanceof IOException) {
                        throw th;
                    }
                    throw new IOException(th.getClass().getName() + ":" + th.getMessage(), th);
                } finally {
                    com.kwad.sdk.crash.utils.b.a(cVar);
                    com.kwad.sdk.crash.utils.b.a(inputStream);
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                    com.kwad.sdk.crash.utils.b.a(fileOutputStream);
                    if (file != null) {
                        file.delete();
                    }
                }
            }
        }
        httpURLConnection.setRequestProperty("User-Agent", n.c());
        httpURLConnection.setRequestProperty("BrowserUa", n.d());
        httpURLConnection.setRequestProperty("SystemUa", n.a());
        httpURLConnection.setRequestProperty("Accept-Encoding", "gzip");
        if (!TextUtils.isEmpty(str)) {
            httpURLConnection.setRequestProperty("Host", str);
            httpURLConnection.setInstanceFollowRedirects(false);
            if (httpURLConnection.getResponseCode() == 302) {
                boolean a2 = a(httpURLConnection.getHeaderField(Headers.LOCATION), (String) null, cVar, bVar, i);
                com.kwad.sdk.crash.utils.b.a(cVar);
                com.kwad.sdk.crash.utils.b.a((Closeable) null);
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
                com.kwad.sdk.crash.utils.b.a((Closeable) null);
                return a2;
            }
        }
        InputStream bufferedInputStream = new BufferedInputStream(httpURLConnection.getInputStream());
        try {
            int contentLength = httpURLConnection.getContentLength();
            HashMap hashMap = httpURLConnection.getHeaderFields() == null ? new HashMap() : new HashMap(httpURLConnection.getHeaderFields());
            InputStream bufferedInputStream2 = new BufferedInputStream(httpURLConnection.getInputStream());
            try {
                bufferedInputStream = a(hashMap, bufferedInputStream2);
                if (contentLength <= 0) {
                    Random random = new Random(System.currentTimeMillis());
                    new File(d).mkdirs();
                    file = new File(d, random.nextInt() + ".tmp");
                    try {
                        fileOutputStream = new FileOutputStream(file);
                        try {
                            byte[] bArr = new byte[8192];
                            int i2 = 0;
                            while (true) {
                                int read = bufferedInputStream.read(bArr);
                                if (read == -1) {
                                    break;
                                }
                                i2 += read;
                                fileOutputStream.write(bArr, 0, read);
                            }
                            com.kwad.sdk.crash.utils.b.a(bufferedInputStream);
                            com.kwad.sdk.crash.utils.b.a(fileOutputStream);
                            inputStream = new BufferedInputStream(new FileInputStream(file));
                            try {
                                hashMap.put("Content-Length", Collections.singletonList(String.valueOf(i2)));
                            } catch (Throwable th2) {
                                th = th2;
                                if (th instanceof IOException) {
                                }
                            }
                        } catch (Throwable th3) {
                            th = th3;
                            inputStream = bufferedInputStream;
                            if (th instanceof IOException) {
                            }
                        }
                    } catch (Throwable th4) {
                        th = th4;
                        fileOutputStream = null;
                    }
                } else {
                    fileOutputStream = null;
                    file = null;
                    inputStream = bufferedInputStream;
                }
                httpURLConnection.getResponseCode();
                byte[] bArr2 = new byte[8192];
                while (true) {
                    int read2 = inputStream.read(bArr2);
                    if (read2 == -1) {
                        break;
                    }
                    cVar.a(bArr2, 0, read2);
                }
                return true;
            } catch (Throwable th5) {
                th = th5;
                fileOutputStream = null;
                file = null;
                inputStream = bufferedInputStream2;
            }
        } catch (Throwable th6) {
            th = th6;
            fileOutputStream = null;
            file = null;
        }
    }

    public static void b(@NonNull AdInfo adInfo) {
        a(adInfo, false);
    }
}
