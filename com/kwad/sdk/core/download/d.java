package com.kwad.sdk.core.download;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.searchbox.aperf.bosuploader.BOSTokenRequest;
import com.kwad.sdk.KsAdSDKImpl;
import com.kwad.sdk.core.network.k;
import com.kwad.sdk.core.network.m;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.export.proxy.AdDownloadProxy;
import com.kwad.sdk.utils.aq;
import java.io.BufferedInputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import org.apache.http.protocol.HTTP;
/* loaded from: classes3.dex */
public class d {
    public static final String a = aq.a(KsAdSDKImpl.get().getContext()) + "/downloadFileSync/.temp";

    /* renamed from: b  reason: collision with root package name */
    public static ExecutorService f55778b = com.kwad.sdk.core.i.b.i();

    /* loaded from: classes3.dex */
    public static class a implements c {
        public final OutputStream a;

        public a(File file, boolean z) {
            this.a = new FileOutputStream(file, z);
        }

        @Override // com.kwad.sdk.core.download.d.c
        public void a(int i2, Map<String, List<String>> map) {
        }

        @Override // com.kwad.sdk.core.download.d.c
        public void a(long j2) {
        }

        @Override // com.kwad.sdk.core.download.d.c
        public void a(byte[] bArr, int i2, int i3) {
            this.a.write(bArr, i2, i3);
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            this.a.close();
        }
    }

    /* loaded from: classes3.dex */
    public interface b {
        boolean a(int i2, int i3, Object obj);
    }

    /* loaded from: classes3.dex */
    public interface c extends Closeable {
        void a(int i2, Map<String, List<String>> map);

        void a(long j2);

        void a(byte[] bArr, int i2, int i3);
    }

    public static URLConnection a(String str, int i2, int i3, boolean z, boolean z2) {
        try {
            URLConnection openConnection = new URL(str).openConnection();
            m.a(openConnection);
            openConnection.setRequestProperty("Accept-Language", "zh-CN");
            if (i2 > 0) {
                openConnection.setConnectTimeout(i2);
            }
            if (i3 > 0) {
                openConnection.setReadTimeout(i3);
            }
            openConnection.setUseCaches(z);
            openConnection.setDoInput(true);
            openConnection.setRequestProperty(HTTP.CONN_DIRECTIVE, "keep-alive");
            openConnection.setRequestProperty(BOSTokenRequest.CHARSET, "UTF-8");
            return openConnection;
        } catch (MalformedURLException e2) {
            com.kwad.sdk.core.d.a.a(e2);
            return null;
        }
    }

    public static void a(Context context, AdInfo adInfo) {
        a(context, adInfo, false);
    }

    public static void a(Context context, AdInfo adInfo, boolean z) {
        AdDownloadProxy proxyForDownload = KsAdSDKImpl.get().getProxyForDownload();
        if (proxyForDownload != null) {
            DownloadParams transform = DownloadParams.transform(adInfo);
            transform.requestInstallPermission = z;
            proxyForDownload.startDownload(context, transform.mDownloadid, transform);
        }
    }

    public static void a(Context context, String str) {
        AdDownloadProxy proxyForDownload = KsAdSDKImpl.get().getProxyForDownload();
        if (proxyForDownload != null) {
            proxyForDownload.pauseDownload(context, str, null);
        }
    }

    public static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
            }
        }
    }

    public static boolean a(String str, File file, b bVar, int i2) {
        a aVar;
        a aVar2 = null;
        try {
            aVar = new a(file, false);
        } catch (Throwable th) {
            th = th;
        }
        try {
            boolean a2 = a(str, (String) null, aVar, bVar, i2);
            a(aVar);
            return a2;
        } catch (Throwable th2) {
            th = th2;
            aVar2 = aVar;
            a(aVar2);
            throw th;
        }
    }

    public static boolean a(String str, String str2, c cVar, b bVar, int i2) {
        return a(str, str2, cVar, bVar, i2, -1L, -1L, false);
    }

    public static boolean a(String str, String str2, c cVar, b bVar, int i2, long j2, long j3, boolean z) {
        HttpURLConnection httpURLConnection = null;
        try {
            HttpURLConnection httpURLConnection2 = (HttpURLConnection) a(str, 10000, i2 > 0 ? i2 : 120000, false, true);
            try {
                if (httpURLConnection2 != null) {
                    boolean a2 = a(httpURLConnection2, str2, cVar, bVar, i2, j2, j3, z);
                    a(cVar);
                    if (httpURLConnection2 != null) {
                        httpURLConnection2.disconnect();
                    }
                    return a2;
                }
                throw new IOException("Fail to createUrlConnection");
            } catch (Throwable th) {
                th = th;
                httpURLConnection = httpURLConnection2;
                a(cVar);
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:84:0x017c A[Catch: all -> 0x01a6, TryCatch #3 {all -> 0x01a6, blocks: (B:82:0x0178, B:84:0x017c, B:86:0x01a5, B:85:0x017f), top: B:101:0x0178 }] */
    /* JADX WARN: Removed duplicated region for block: B:85:0x017f A[Catch: all -> 0x01a6, TryCatch #3 {all -> 0x01a6, blocks: (B:82:0x0178, B:84:0x017c, B:86:0x01a5, B:85:0x017f), top: B:101:0x0178 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean a(HttpURLConnection httpURLConnection, String str, c cVar, b bVar, int i2, long j2, long j3, boolean z) {
        Object valueOf;
        File file;
        FileOutputStream fileOutputStream;
        File file2;
        BufferedInputStream bufferedInputStream = null;
        int i3 = (j2 > 0L ? 1 : (j2 == 0L ? 0 : -1));
        if (i3 > 0 || j3 > 0) {
            try {
                Object[] objArr = new Object[2];
                objArr[0] = Long.valueOf(j2);
                if (j3 > 0) {
                    try {
                        valueOf = Long.valueOf(j3);
                    } catch (Throwable th) {
                        th = th;
                        file = null;
                        fileOutputStream = null;
                        try {
                            if (th instanceof IOException) {
                            }
                        } catch (Throwable th2) {
                            a(cVar);
                            a(bufferedInputStream);
                            if (httpURLConnection != null) {
                                httpURLConnection.disconnect();
                            }
                            a(fileOutputStream);
                            if (file != null) {
                                file.delete();
                            }
                            throw th2;
                        }
                    }
                } else {
                    valueOf = "";
                }
                objArr[1] = valueOf;
                httpURLConnection.setRequestProperty("Range", String.format("bytes=%s-%s", objArr));
            } catch (Throwable th3) {
                th = th3;
                file = null;
                fileOutputStream = null;
                bufferedInputStream = null;
                if (th instanceof IOException) {
                }
            }
        }
        if (!TextUtils.isEmpty(str)) {
            httpURLConnection.setRequestProperty("Host", str);
            httpURLConnection.setInstanceFollowRedirects(false);
            if (httpURLConnection.getResponseCode() == 302) {
                boolean a2 = a(httpURLConnection.getHeaderField("Location"), (String) null, cVar, bVar, i2);
                a(cVar);
                a(null);
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
                a(null);
                return a2;
            }
        }
        httpURLConnection.setRequestProperty("User-Agent", k.c());
        httpURLConnection.setRequestProperty("BrowserUa", k.d());
        httpURLConnection.setRequestProperty("SystemUa", k.a());
        BufferedInputStream bufferedInputStream2 = new BufferedInputStream(httpURLConnection.getInputStream());
        try {
            int contentLength = httpURLConnection.getContentLength();
            HashMap hashMap = httpURLConnection.getHeaderFields() == null ? new HashMap() : new HashMap(httpURLConnection.getHeaderFields());
            BufferedInputStream bufferedInputStream3 = new BufferedInputStream(httpURLConnection.getInputStream());
            if (contentLength <= 0) {
                try {
                    Random random = new Random(System.currentTimeMillis());
                    file2 = new File(a, random.nextInt() + ".tmp");
                    try {
                        fileOutputStream = new FileOutputStream(file2);
                    } catch (Throwable th4) {
                        th = th4;
                        fileOutputStream = null;
                        bufferedInputStream = bufferedInputStream3;
                        file = file2;
                        if (th instanceof IOException) {
                        }
                    }
                } catch (Throwable th5) {
                    th = th5;
                    file = null;
                    fileOutputStream = null;
                    bufferedInputStream = bufferedInputStream3;
                    if (th instanceof IOException) {
                    }
                }
                try {
                    byte[] bArr = new byte[10240];
                    int i4 = 0;
                    while (true) {
                        int read = bufferedInputStream3.read(bArr);
                        if (read == -1) {
                            break;
                        }
                        i4 += read;
                        fileOutputStream.write(bArr, 0, read);
                    }
                    a(bufferedInputStream3);
                    a(fileOutputStream);
                    BufferedInputStream bufferedInputStream4 = new BufferedInputStream(new FileInputStream(file2));
                    try {
                        hashMap.put("Content-Length", Collections.singletonList(String.valueOf(i4)));
                        bufferedInputStream3 = bufferedInputStream4;
                        contentLength = i4;
                    } catch (Throwable th6) {
                        th = th6;
                        bufferedInputStream = bufferedInputStream4;
                        file = file2;
                        if (th instanceof IOException) {
                            throw new IOException(th.getClass().getName() + ":" + th.getMessage(), th);
                        }
                        throw th;
                    }
                } catch (Throwable th7) {
                    th = th7;
                    bufferedInputStream = bufferedInputStream3;
                    file = file2;
                    if (th instanceof IOException) {
                    }
                }
            } else {
                fileOutputStream = null;
                file2 = null;
            }
            int i5 = (i3 <= 0 || !z) ? 0 : (int) j2;
            int i6 = contentLength + i5;
            cVar.a(i6);
            cVar.a(httpURLConnection.getResponseCode(), hashMap);
            if (bVar != null) {
                bVar.a(i5, i6, null);
            }
            byte[] bArr2 = new byte[10240];
            while (true) {
                int read2 = bufferedInputStream3.read(bArr2);
                if (read2 == -1) {
                    break;
                }
                i5 += read2;
                cVar.a(bArr2, 0, read2);
                if (bVar != null) {
                    bVar.a(i5, i6, null);
                }
            }
            if (bVar != null) {
                bVar.a(i6, i6, null);
            }
            a(cVar);
            a(bufferedInputStream3);
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
            a(fileOutputStream);
            if (file2 != null) {
                file2.delete();
                return true;
            }
            return true;
        } catch (Throwable th8) {
            th = th8;
            file = null;
            fileOutputStream = null;
            bufferedInputStream = bufferedInputStream2;
        }
    }
}
