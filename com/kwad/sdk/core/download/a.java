package com.kwad.sdk.core.download;

import android.content.Context;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.baidu.searchbox.aperf.bosuploader.BOSTokenRequest;
import com.ksad.download.DownloadTask;
import com.kwad.sdk.core.network.o;
import com.kwad.sdk.core.network.q;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.export.proxy.AdDownloadProxy;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.ab;
import com.kwad.sdk.utils.ae;
import com.kwad.sdk.utils.ai;
import com.kwad.sdk.utils.as;
import com.kwad.sdk.utils.t;
import com.kwad.sdk.utils.u;
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
/* loaded from: classes7.dex */
public final class a {
    public static AdDownloadProxy WK;
    public static Context mContext;
    public static volatile boolean mHasInit;
    public static final String WL = as.cX(((com.kwad.sdk.service.kwai.d) ServiceProvider.get(com.kwad.sdk.service.kwai.d.class)).getContext()) + "/downloadFileSync/.temp";
    public static final ExecutorService WG = com.kwad.sdk.core.threads.b.vq();

    /* renamed from: com.kwad.sdk.core.download.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public final class C0600a implements c {
        public final OutputStream WM;

        public C0600a(File file, boolean z) {
            this.WM = new FileOutputStream(file, z);
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public final void close() {
            this.WM.close();
        }

        @Override // com.kwad.sdk.core.download.a.c
        public final void write(byte[] bArr, int i, int i2) {
            this.WM.write(bArr, 0, i2);
        }
    }

    /* loaded from: classes7.dex */
    public interface b {
    }

    /* loaded from: classes7.dex */
    public interface c extends Closeable {
        void write(byte[] bArr, int i, int i2);
    }

    public static InputStream a(Map map, InputStream inputStream) {
        List list;
        for (Map.Entry entry : map.entrySet()) {
            if ("Content-Encoding".equalsIgnoreCase((String) entry.getKey()) && (list = (List) entry.getValue()) != null && !list.isEmpty()) {
                boolean z = false;
                Iterator it = list.iterator();
                while (true) {
                    if (it.hasNext()) {
                        if ("gzip".equalsIgnoreCase((String) it.next())) {
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

    public static URLConnection a(String str, int i, int i2, boolean z) {
        try {
            URLConnection openConnection = new URL(str).openConnection();
            q.wrapHttpURLConnection(openConnection);
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
        } catch (MalformedURLException e) {
            com.kwad.sdk.core.e.b.printStackTrace(e);
            return null;
        }
    }

    public static synchronized void a(Context context, File file, boolean z) {
        synchronized (a.class) {
            if (context != null) {
                if (!mHasInit) {
                    mContext = context;
                    com.ksad.download.d.a(context, file, new com.kwad.sdk.core.download.a.a(context));
                    e.sV().init(context);
                    com.ksad.download.d.N().a(new com.kwad.sdk.core.download.b());
                    com.ksad.download.b.a(new com.ksad.download.a() { // from class: com.kwad.sdk.core.download.a.1
                        @Override // com.ksad.download.a
                        public final void a(DownloadTask downloadTask, String str) {
                            if (ai.X(a.mContext, str)) {
                                com.kwad.sdk.core.download.c.bJ(ab.dI(downloadTask.getUrl()));
                            }
                        }
                    });
                    WK = new com.kwad.sdk.core.download.b.a(z && bo(context));
                    mHasInit = true;
                }
            }
        }
    }

    public static boolean a(String str, File file, b bVar, int i) {
        C0600a c0600a;
        C0600a c0600a2 = null;
        try {
            c0600a = new C0600a(file, false);
        } catch (Throwable th) {
            th = th;
        }
        try {
            boolean a = a(str, (String) null, c0600a, (b) null, 0);
            com.kwad.sdk.crash.utils.b.closeQuietly(c0600a);
            return a;
        } catch (Throwable th2) {
            th = th2;
            c0600a2 = c0600a;
            com.kwad.sdk.crash.utils.b.closeQuietly(c0600a2);
            throw th;
        }
    }

    public static boolean a(String str, File file, b bVar, int i, boolean z) {
        C0600a c0600a = null;
        try {
            C0600a c0600a2 = new C0600a(file, true);
            try {
                boolean a = a(str, (String) null, (c) c0600a2, (b) null, -1, file.length(), -1L, true);
                com.kwad.sdk.crash.utils.b.closeQuietly(c0600a2);
                return a;
            } catch (Throwable th) {
                th = th;
                c0600a = c0600a2;
                com.kwad.sdk.crash.utils.b.closeQuietly(c0600a);
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
                boolean a = a(httpURLConnection, str2, cVar, bVar, i, j, -1L, z);
                com.kwad.sdk.crash.utils.b.closeQuietly(cVar);
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
                return a;
            }
            throw new IOException("Fail to createUrlConnection");
        } catch (Throwable th2) {
            th = th2;
            httpURLConnection2 = httpURLConnection;
            com.kwad.sdk.crash.utils.b.closeQuietly(cVar);
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
                    com.kwad.sdk.crash.utils.b.closeQuietly(cVar);
                    com.kwad.sdk.crash.utils.b.closeQuietly(inputStream);
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                    com.kwad.sdk.crash.utils.b.closeQuietly(fileOutputStream);
                    if (file != null) {
                        file.delete();
                    }
                }
            }
        }
        httpURLConnection.setRequestProperty("User-Agent", o.getUserAgent());
        httpURLConnection.setRequestProperty("BrowserUa", o.tD());
        httpURLConnection.setRequestProperty("SystemUa", o.tC());
        httpURLConnection.setRequestProperty("Accept-Encoding", "gzip");
        if (!TextUtils.isEmpty(str)) {
            httpURLConnection.setRequestProperty("Host", str);
            httpURLConnection.setInstanceFollowRedirects(false);
            if (httpURLConnection.getResponseCode() == 302) {
                boolean a = a(httpURLConnection.getHeaderField("Location"), (String) null, cVar, bVar, i);
                com.kwad.sdk.crash.utils.b.closeQuietly(cVar);
                com.kwad.sdk.crash.utils.b.closeQuietly((Closeable) null);
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
                com.kwad.sdk.crash.utils.b.closeQuietly((Closeable) null);
                return a;
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
                    new File(WL).mkdirs();
                    file = new File(WL, random.nextInt() + ".tmp");
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
                            com.kwad.sdk.crash.utils.b.closeQuietly(bufferedInputStream);
                            com.kwad.sdk.crash.utils.b.closeQuietly(fileOutputStream);
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
                    cVar.write(bArr2, 0, read2);
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

    public static void b(int i, AdTemplate adTemplate) {
        d dVar = (d) ServiceProvider.get(d.class);
        if (dVar != null) {
            dVar.a(1, adTemplate);
        }
    }

    public static void b(AdInfo adInfo, boolean z) {
        Context context = mContext;
        if (context == null) {
            return;
        }
        if (!ae.isNetworkConnected(context)) {
            Context context2 = mContext;
            t.z(context2, u.cj(context2));
            return;
        }
        DownloadParams transform = DownloadParams.transform(adInfo);
        transform.requestInstallPermission = false;
        WK.startDownload(mContext, transform.mDownloadid, transform);
    }

    public static void bD(String str) {
        if (mContext == null || WK == null || TextUtils.isEmpty(str)) {
            return;
        }
        WK.pauseDownload(mContext, str, null);
    }

    public static boolean bo(Context context) {
        try {
            new NotificationCompat.Builder(context, "");
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static boolean c(String str, File file) {
        try {
            return a(str, file, (b) null, 0);
        } catch (Throwable th) {
            com.kwad.sdk.core.e.b.printStackTraceOnly(th);
            return false;
        }
    }

    public static String w(AdInfo adInfo) {
        AdDownloadProxy adDownloadProxy;
        return (mContext == null || (adDownloadProxy = WK) == null) ? "" : adDownloadProxy.getDownloadFilePath(DownloadParams.transform(adInfo));
    }

    public static void x(AdInfo adInfo) {
        b(adInfo, false);
    }
}
