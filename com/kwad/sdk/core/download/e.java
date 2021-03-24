package com.kwad.sdk.core.download;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.searchbox.aperf.bosuploader.BOSTokenRequest;
import com.kwad.sdk.KsAdSDKImpl;
import com.kwad.sdk.core.network.k;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.export.proxy.AdDownloadProxy;
import com.kwad.sdk.utils.ad;
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
import org.apache.http.protocol.HTTP;
/* loaded from: classes6.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public static final String f33587a = ad.a(KsAdSDKImpl.get().getContext()) + "/downloadFileSync/.temp";

    /* loaded from: classes6.dex */
    public static class a implements c {

        /* renamed from: a  reason: collision with root package name */
        public final OutputStream f33588a;

        public a(File file, boolean z) {
            this.f33588a = new FileOutputStream(file, z);
        }

        @Override // com.kwad.sdk.core.download.e.c
        public void a(int i, Map<String, List<String>> map) {
        }

        @Override // com.kwad.sdk.core.download.e.c
        public void a(long j) {
        }

        @Override // com.kwad.sdk.core.download.e.c
        public void a(byte[] bArr, int i, int i2) {
            this.f33588a.write(bArr, i, i2);
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            this.f33588a.close();
        }
    }

    /* loaded from: classes6.dex */
    public interface b {
        boolean a(int i, int i2, Object obj);
    }

    /* loaded from: classes6.dex */
    public interface c extends Closeable {
        void a(int i, Map<String, List<String>> map);

        void a(long j);

        void a(byte[] bArr, int i, int i2);
    }

    public static URLConnection a(String str, int i, int i2, boolean z, boolean z2) {
        try {
            URLConnection openConnection = new URL(str).openConnection();
            openConnection.setRequestProperty("Accept-Language", "zh-CN");
            if (i > 0) {
                openConnection.setConnectTimeout(i);
            }
            if (i2 > 0) {
                openConnection.setReadTimeout(i2);
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
        AdDownloadProxy proxyForDownload = KsAdSDKImpl.get().getProxyForDownload();
        if (proxyForDownload != null) {
            DownloadParams transfrom = DownloadParams.transfrom(adInfo);
            proxyForDownload.startDownload(context, transfrom.mDownloadid, transfrom);
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

    public static boolean a(String str, File file, b bVar, int i) {
        a aVar;
        a aVar2 = null;
        try {
            aVar = new a(file, false);
        } catch (Throwable th) {
            th = th;
        }
        try {
            boolean a2 = a(str, (String) null, aVar, bVar, i);
            a(aVar);
            return a2;
        } catch (Throwable th2) {
            th = th2;
            aVar2 = aVar;
            a(aVar2);
            throw th;
        }
    }

    public static boolean a(String str, String str2, c cVar, b bVar, int i) {
        return a(str, str2, cVar, bVar, i, -1L, -1L, false);
    }

    public static boolean a(String str, String str2, c cVar, b bVar, int i, long j, long j2, boolean z) {
        HttpURLConnection httpURLConnection = null;
        try {
            HttpURLConnection httpURLConnection2 = (HttpURLConnection) a(str, 10000, i > 0 ? i : 120000, false, true);
            try {
                if (httpURLConnection2 != null) {
                    boolean a2 = a(httpURLConnection2, str2, cVar, bVar, i, j, j2, z);
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

    /* JADX WARN: Removed duplicated region for block: B:79:0x0160 A[Catch: all -> 0x018a, TryCatch #4 {all -> 0x018a, blocks: (B:77:0x015c, B:79:0x0160, B:81:0x0189, B:80:0x0163), top: B:99:0x015c }] */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0163 A[Catch: all -> 0x018a, TryCatch #4 {all -> 0x018a, blocks: (B:77:0x015c, B:79:0x0160, B:81:0x0189, B:80:0x0163), top: B:99:0x015c }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean a(HttpURLConnection httpURLConnection, String str, c cVar, b bVar, int i, long j, long j2, boolean z) {
        File file;
        FileOutputStream fileOutputStream;
        BufferedInputStream bufferedInputStream;
        long j3;
        BufferedInputStream bufferedInputStream2 = null;
        if (j > 0 || j2 > 0) {
            try {
                Object[] objArr = new Object[2];
                objArr[0] = Long.valueOf(j);
                objArr[1] = j2 > 0 ? Long.valueOf(j2) : "";
                httpURLConnection.setRequestProperty("Range", String.format("bytes=%s-%s", objArr));
            } catch (Throwable th) {
                th = th;
                file = null;
                fileOutputStream = null;
                try {
                    if (th instanceof IOException) {
                    }
                } catch (Throwable th2) {
                    a(cVar);
                    a(bufferedInputStream2);
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
        }
        if (!TextUtils.isEmpty(str)) {
            httpURLConnection.setRequestProperty("Host", str);
            httpURLConnection.setInstanceFollowRedirects(false);
            if (httpURLConnection.getResponseCode() == 302) {
                boolean a2 = a(httpURLConnection.getHeaderField("Location"), (String) null, cVar, bVar, i);
                a(cVar);
                a(null);
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
                a(null);
                return a2;
            }
        }
        httpURLConnection.setRequestProperty("User-Agent", k.a());
        BufferedInputStream bufferedInputStream3 = new BufferedInputStream(httpURLConnection.getInputStream());
        try {
            int contentLength = httpURLConnection.getContentLength();
            HashMap hashMap = httpURLConnection.getHeaderFields() == null ? new HashMap() : new HashMap(httpURLConnection.getHeaderFields());
            BufferedInputStream bufferedInputStream4 = new BufferedInputStream(httpURLConnection.getInputStream());
            if (contentLength <= 0) {
                try {
                    Random random = new Random(System.currentTimeMillis());
                    file = new File(f33587a, random.nextInt() + ".tmp");
                } catch (Throwable th3) {
                    th = th3;
                    file = null;
                    fileOutputStream = null;
                }
                try {
                    fileOutputStream = new FileOutputStream(file);
                    try {
                        byte[] bArr = new byte[10240];
                        contentLength = 0;
                        while (true) {
                            int read = bufferedInputStream4.read(bArr);
                            if (read == -1) {
                                break;
                            }
                            contentLength += read;
                            fileOutputStream.write(bArr, 0, read);
                        }
                        a(bufferedInputStream4);
                        a(fileOutputStream);
                        bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
                    } catch (Throwable th4) {
                        th = th4;
                        bufferedInputStream2 = bufferedInputStream4;
                        if (th instanceof IOException) {
                            throw new IOException(th.getClass().getName() + ":" + th.getMessage(), th);
                        }
                        throw th;
                    }
                    try {
                        hashMap.put("Content-Length", Collections.singletonList(String.valueOf(contentLength)));
                        bufferedInputStream4 = bufferedInputStream;
                        j3 = 0;
                    } catch (Throwable th5) {
                        th = th5;
                        bufferedInputStream2 = bufferedInputStream;
                        if (th instanceof IOException) {
                        }
                    }
                } catch (Throwable th6) {
                    th = th6;
                    fileOutputStream = null;
                    bufferedInputStream2 = bufferedInputStream4;
                    if (th instanceof IOException) {
                    }
                }
            } else {
                j3 = 0;
                file = null;
                fileOutputStream = null;
            }
            int i2 = (j <= j3 || !z) ? 0 : (int) j;
            int i3 = contentLength + i2;
            cVar.a(i3);
            cVar.a(httpURLConnection.getResponseCode(), hashMap);
            if (bVar != null) {
                bVar.a(i2, i3, null);
            }
            byte[] bArr2 = new byte[10240];
            while (true) {
                int read2 = bufferedInputStream4.read(bArr2);
                if (read2 == -1) {
                    break;
                }
                i2 += read2;
                cVar.a(bArr2, 0, read2);
                if (bVar != null) {
                    bVar.a(i2, i3, null);
                }
            }
            if (bVar != null) {
                bVar.a(i3, i3, null);
            }
            a(cVar);
            a(bufferedInputStream4);
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
            a(fileOutputStream);
            if (file != null) {
                file.delete();
                return true;
            }
            return true;
        } catch (Throwable th7) {
            th = th7;
            file = null;
            fileOutputStream = null;
            bufferedInputStream2 = bufferedInputStream3;
        }
    }
}
