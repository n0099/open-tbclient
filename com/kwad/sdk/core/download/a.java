package com.kwad.sdk.core.download;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
import android.webkit.URLUtil;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;
import com.baidu.nps.utils.Constant;
import com.baidu.searchbox.aperf.bosuploader.BOSTokenRequest;
import com.kwad.sdk.DownloadTask;
import com.kwad.sdk.core.network.p;
import com.kwad.sdk.core.network.r;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.ad;
import com.kwad.sdk.utils.ag;
import com.kwad.sdk.utils.aw;
import com.kwad.sdk.utils.v;
import com.kwad.sdk.utils.w;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.zip.GZIPInputStream;
import okhttp3.internal.http2.Http2Codec;
import org.apache.http.protocol.HTTP;
/* loaded from: classes10.dex */
public final class a {
    @SuppressLint({"StaticFieldLeak"})
    public static Context mContext;
    public static volatile boolean mHasInit;

    /* renamed from: com.kwad.sdk.core.download.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public interface InterfaceC0704a {
    }

    @Nullable
    public static String G(AdInfo adInfo) {
        return cW(DownloadParams.transform(adInfo).mFileUrl);
    }

    public static void H(@NonNull AdInfo adInfo) {
        a(adInfo, false);
    }

    public static synchronized void aU(Context context) {
        synchronized (a.class) {
            if (context != null) {
                if (!mHasInit) {
                    mContext = context;
                    com.kwad.sdk.c.xA().init(context);
                    b.BU().init(context);
                    mHasInit = true;
                }
            }
        }
    }

    public static boolean aV(Context context) {
        try {
            new NotificationCompat.Builder(context, "");
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static String cW(String str) {
        if (mContext == null) {
            return "";
        }
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return aw.cL(mContext) + File.separator + cX(str);
    }

    public static String cX(String str) {
        return ad.bn(str) + Constant.FILE.SUFFIX.BUNDLE_SUFFIX;
    }

    public static void cY(String str) {
        if (mContext != null && !TextUtils.isEmpty(str)) {
            com.kwad.sdk.e.a.C(mContext, str);
        }
    }

    public static void cZ(String str) {
        if (mContext == null) {
            return;
        }
        String cW = cW(str);
        com.kwad.sdk.e.a.e(mContext, ad.bn(str), cW);
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

    public static void a(@NonNull AdInfo adInfo, boolean z) {
        Context context = mContext;
        if (context == null) {
            return;
        }
        if (!ag.isNetworkConnected(context)) {
            Context context2 = mContext;
            v.O(context2, w.bX(context2));
            return;
        }
        DownloadParams transform = DownloadParams.transform(adInfo);
        transform.requestInstallPermission = false;
        String str = transform.mFileUrl;
        if (!TextUtils.isEmpty(str) && URLUtil.isNetworkUrl(str)) {
            DownloadTask.DownloadRequest downloadRequest = new DownloadTask.DownloadRequest(transform.mFileUrl);
            downloadRequest.setDestinationFileName(cX(str));
            downloadRequest.setTag(transform);
            downloadRequest.setDownloadEnablePause(transform.downloadEnablePause);
            if (ServiceProvider.Jo().showNotification && aV(mContext)) {
                downloadRequest.setNotificationVisibility(3);
            } else {
                downloadRequest.setNotificationVisibility(0);
            }
            com.kwad.sdk.e.a.a(mContext, transform.mDownloadid, downloadRequest);
        }
    }

    public static void a(String str, File file, boolean z) {
        a(str, file, null, true);
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:46:0x00fb */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:85:? */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0117 A[Catch: all -> 0x0141, TryCatch #1 {all -> 0x0141, blocks: (B:61:0x0113, B:63:0x0117, B:65:0x0140, B:64:0x011a), top: B:76:0x0113 }] */
    /* JADX WARN: Removed duplicated region for block: B:64:0x011a A[Catch: all -> 0x0141, TryCatch #1 {all -> 0x0141, blocks: (B:61:0x0113, B:63:0x0117, B:65:0x0140, B:64:0x011a), top: B:76:0x0113 }] */
    /* JADX WARN: Type inference failed for: r6v0 */
    /* JADX WARN: Type inference failed for: r6v1, types: [java.io.File] */
    /* JADX WARN: Type inference failed for: r6v10 */
    /* JADX WARN: Type inference failed for: r6v11 */
    /* JADX WARN: Type inference failed for: r6v2 */
    /* JADX WARN: Type inference failed for: r6v3 */
    /* JADX WARN: Type inference failed for: r6v4 */
    /* JADX WARN: Type inference failed for: r6v5 */
    /* JADX WARN: Type inference failed for: r6v6 */
    /* JADX WARN: Type inference failed for: r6v7, types: [java.io.File] */
    /* JADX WARN: Type inference failed for: r6v9, types: [java.io.File] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean a(String str, File file, InterfaceC0704a interfaceC0704a, boolean z) {
        HttpURLConnection httpURLConnection;
        FileOutputStream fileOutputStream;
        FileOutputStream fileOutputStream2;
        ?? r6;
        HashMap hashMap;
        int i;
        InputStream inputStream = null;
        try {
            httpURLConnection = (HttpURLConnection) da(str);
            try {
                if (z) {
                    long length = file.length();
                    fileOutputStream = new FileOutputStream(file, true);
                    if (length > 0) {
                        try {
                            httpURLConnection.setRequestProperty("Range", String.format("bytes=%s-%s", Long.valueOf(length), ""));
                        } catch (Throwable th) {
                            th = th;
                            fileOutputStream2 = null;
                            r6 = fileOutputStream2;
                            try {
                                if (!(th instanceof IOException)) {
                                }
                            } finally {
                                com.kwad.sdk.crash.utils.b.closeQuietly(fileOutputStream);
                                com.kwad.sdk.crash.utils.b.closeQuietly(inputStream);
                                if (httpURLConnection != null) {
                                    httpURLConnection.disconnect();
                                }
                                com.kwad.sdk.crash.utils.b.closeQuietly(fileOutputStream2);
                                if (r6 != 0) {
                                    r6.delete();
                                }
                            }
                        }
                    }
                } else {
                    fileOutputStream = new FileOutputStream(file, false);
                }
                p.b(httpURLConnection);
                httpURLConnection.setRequestProperty("Accept-Encoding", "gzip");
                InputStream bufferedInputStream = new BufferedInputStream(httpURLConnection.getInputStream());
                try {
                    int contentLength = httpURLConnection.getContentLength();
                    if (httpURLConnection.getHeaderFields() == null) {
                        hashMap = new HashMap();
                    } else {
                        hashMap = new HashMap(httpURLConnection.getHeaderFields());
                    }
                    BufferedInputStream bufferedInputStream2 = new BufferedInputStream(httpURLConnection.getInputStream());
                    try {
                        bufferedInputStream = a(hashMap, bufferedInputStream2);
                        if (contentLength <= 0) {
                            Random random = new Random(System.currentTimeMillis());
                            r6 = new File(aw.cM(mContext), random.nextInt() + ".tmp");
                            try {
                                fileOutputStream2 = new FileOutputStream((File) r6);
                                try {
                                    byte[] bArr = new byte[8192];
                                    i = 0;
                                    while (true) {
                                        int read = bufferedInputStream.read(bArr);
                                        if (read == -1) {
                                            break;
                                        }
                                        i += read;
                                        fileOutputStream2.write(bArr, 0, read);
                                    }
                                    com.kwad.sdk.crash.utils.b.closeQuietly(bufferedInputStream);
                                    com.kwad.sdk.crash.utils.b.closeQuietly(fileOutputStream2);
                                    inputStream = new BufferedInputStream(new FileInputStream((File) r6));
                                } catch (Throwable th2) {
                                    inputStream = bufferedInputStream;
                                    th = th2;
                                    if (!(th instanceof IOException)) {
                                        throw new IOException(th.getClass().getName() + ":" + th.getMessage(), th);
                                    }
                                    throw th;
                                }
                            } catch (Throwable th3) {
                                th = th3;
                                fileOutputStream2 = null;
                                r6 = r6;
                                inputStream = bufferedInputStream;
                                th = th;
                                if (!(th instanceof IOException)) {
                                }
                            }
                            try {
                                hashMap.put("Content-Length", Collections.singletonList(String.valueOf(i)));
                                r6 = r6;
                            } catch (Throwable th4) {
                                th = th4;
                                if (!(th instanceof IOException)) {
                                }
                            }
                        } else {
                            fileOutputStream2 = null;
                            r6 = 0;
                            inputStream = bufferedInputStream;
                        }
                        byte[] bArr2 = new byte[8192];
                        while (true) {
                            int read2 = inputStream.read(bArr2);
                            if (read2 == -1) {
                                break;
                            }
                            fileOutputStream.write(bArr2, 0, read2);
                        }
                        return true;
                    } catch (Throwable th5) {
                        th = th5;
                        fileOutputStream2 = null;
                        r6 = 0;
                        inputStream = bufferedInputStream2;
                    }
                } catch (Throwable th6) {
                    th = th6;
                    fileOutputStream2 = null;
                    r6 = 0;
                }
            } catch (Throwable th7) {
                th = th7;
                fileOutputStream = null;
                fileOutputStream2 = fileOutputStream;
                r6 = fileOutputStream2;
                if (!(th instanceof IOException)) {
                }
            }
        } catch (Throwable th8) {
            th = th8;
            httpURLConnection = null;
            fileOutputStream = null;
        }
    }

    public static boolean d(String str, File file) {
        try {
            return a(str, file, null, false);
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static URLConnection da(String str) {
        URLConnection openConnection = new URL(str).openConnection();
        r.wrapHttpURLConnection(openConnection);
        openConnection.setRequestProperty("Accept-Language", "zh-CN");
        openConnection.setConnectTimeout(10000);
        openConnection.setReadTimeout(120000);
        openConnection.setUseCaches(false);
        openConnection.setDoInput(true);
        openConnection.setRequestProperty(HTTP.CONN_DIRECTIVE, Http2Codec.KEEP_ALIVE);
        openConnection.setRequestProperty(BOSTokenRequest.CHARSET, "UTF-8");
        return openConnection;
    }
}
