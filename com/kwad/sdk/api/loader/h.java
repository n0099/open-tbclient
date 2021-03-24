package com.kwad.sdk.api.loader;

import android.content.Context;
import android.os.Environment;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.searchbox.aperf.bosuploader.BOSTokenRequest;
import com.kwad.sdk.api.core.RequestParamsUtils;
import com.kwad.sdk.api.core.SpeedLimitApiHolder;
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
import java.util.List;
import java.util.Map;
import java.util.Random;
import org.apache.http.protocol.HTTP;
/* loaded from: classes6.dex */
public class h {

    /* renamed from: a  reason: collision with root package name */
    public static final String f31795a = a(Loader.get().getContext()) + "/apkfileD/dynamic";

    /* loaded from: classes6.dex */
    public interface a {
        void a();

        void a(File file);
    }

    /* loaded from: classes6.dex */
    public static class b implements d {

        /* renamed from: a  reason: collision with root package name */
        public final OutputStream f31799a;

        public b(File file, boolean z) {
            this.f31799a = new FileOutputStream(file, z);
        }

        @Override // com.kwad.sdk.api.loader.h.d
        public void a(int i, Map<String, List<String>> map) {
        }

        @Override // com.kwad.sdk.api.loader.h.d
        public void a(long j) {
        }

        @Override // com.kwad.sdk.api.loader.h.d
        public void a(byte[] bArr, int i, int i2) {
            this.f31799a.write(bArr, i, i2);
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            this.f31799a.close();
        }
    }

    /* loaded from: classes6.dex */
    public interface c {
        boolean a(int i, int i2, Object obj);
    }

    /* loaded from: classes6.dex */
    public interface d extends Closeable {
        void a(int i, Map<String, List<String>> map);

        void a(long j);

        void a(byte[] bArr, int i, int i2);
    }

    @NonNull
    public static String a(Context context) {
        File file;
        String str = "";
        try {
            str = Environment.getExternalStorageState();
        } catch (IncompatibleClassChangeError | NullPointerException unused) {
        }
        String str2 = null;
        if ("mounted".equals(str) || !Environment.isExternalStorageRemovable()) {
            try {
                file = context.getExternalFilesDir(null);
            } catch (Exception unused2) {
                file = null;
            }
            if (file != null) {
                str2 = file.getPath();
            }
        }
        if (TextUtils.isEmpty(str2)) {
            str2 = context.getFilesDir().getPath();
        }
        return str2 + File.separator + "ksadsdk";
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
        } catch (MalformedURLException unused) {
            return null;
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

    public static void a(final String str, String str2, final a aVar) {
        final File file = new File(str2);
        if (file.exists()) {
            file.delete();
        }
        i.a(new Runnable() { // from class: com.kwad.sdk.api.loader.h.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    boolean a2 = h.a(str, file, null, 0);
                    if (aVar != null) {
                        if (a2) {
                            aVar.a(file);
                        } else {
                            aVar.a();
                        }
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                    a aVar2 = aVar;
                    if (aVar2 != null) {
                        aVar2.a();
                    }
                }
            }
        });
    }

    public static boolean a(String str, File file, c cVar, int i) {
        b bVar;
        b bVar2 = null;
        try {
            bVar = new b(file, false);
        } catch (Throwable th) {
            th = th;
        }
        try {
            boolean a2 = a(str, (String) null, bVar, cVar, i);
            a(bVar);
            return a2;
        } catch (Throwable th2) {
            th = th2;
            bVar2 = bVar;
            a(bVar2);
            throw th;
        }
    }

    public static boolean a(String str, String str2, d dVar, c cVar, int i) {
        return a(str, str2, dVar, cVar, i, -1L, -1L, false);
    }

    public static boolean a(String str, String str2, d dVar, c cVar, int i, long j, long j2, boolean z) {
        HttpURLConnection httpURLConnection = null;
        try {
            HttpURLConnection httpURLConnection2 = (HttpURLConnection) a(str, 10000, i > 0 ? i : 120000, false, true);
            try {
                if (httpURLConnection2 != null) {
                    boolean a2 = a(httpURLConnection2, str2, dVar, cVar, i, j, j2, z);
                    a(dVar);
                    if (httpURLConnection2 != null) {
                        httpURLConnection2.disconnect();
                    }
                    return a2;
                }
                throw new IOException("Fail to createUrlConnection");
            } catch (Throwable th) {
                th = th;
                httpURLConnection = httpURLConnection2;
                a(dVar);
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:81:0x016f A[Catch: all -> 0x0199, TryCatch #4 {all -> 0x0199, blocks: (B:79:0x016b, B:81:0x016f, B:83:0x0198, B:82:0x0172), top: B:101:0x016b }] */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0172 A[Catch: all -> 0x0199, TryCatch #4 {all -> 0x0199, blocks: (B:79:0x016b, B:81:0x016f, B:83:0x0198, B:82:0x0172), top: B:101:0x016b }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean a(HttpURLConnection httpURLConnection, String str, d dVar, c cVar, int i, long j, long j2, boolean z) {
        File file;
        FileOutputStream fileOutputStream;
        InputStream bufferedInputStream;
        long j3;
        InputStream inputStream = null;
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
                    a(dVar);
                    a(inputStream);
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
                boolean a2 = a(httpURLConnection.getHeaderField("Location"), (String) null, dVar, cVar, i);
                a(dVar);
                a((Closeable) null);
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
                a((Closeable) null);
                return a2;
            }
        }
        httpURLConnection.setRequestProperty("User-Agent", RequestParamsUtils.getUserAgent());
        InputStream bufferedInputStream2 = new BufferedInputStream(httpURLConnection.getInputStream());
        try {
            int contentLength = httpURLConnection.getContentLength();
            HashMap hashMap = httpURLConnection.getHeaderFields() == null ? new HashMap() : new HashMap(httpURLConnection.getHeaderFields());
            InputStream bufferedInputStream3 = new BufferedInputStream(httpURLConnection.getInputStream());
            if (contentLength <= 0) {
                try {
                    Random random = new Random(System.currentTimeMillis());
                    file = new File(f31795a, random.nextInt() + ".tmp");
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
                            int read = bufferedInputStream3.read(bArr);
                            if (read == -1) {
                                break;
                            }
                            contentLength += read;
                            fileOutputStream.write(bArr, 0, read);
                        }
                        a(bufferedInputStream3);
                        a(fileOutputStream);
                        bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
                    } catch (Throwable th4) {
                        th = th4;
                        inputStream = bufferedInputStream3;
                        if (th instanceof IOException) {
                            throw new IOException(th.getClass().getName() + ":" + th.getMessage(), th);
                        }
                        throw th;
                    }
                    try {
                        hashMap.put("Content-Length", Collections.singletonList(String.valueOf(contentLength)));
                        bufferedInputStream3 = bufferedInputStream;
                        j3 = 0;
                    } catch (Throwable th5) {
                        th = th5;
                        inputStream = bufferedInputStream;
                        if (th instanceof IOException) {
                        }
                    }
                } catch (Throwable th6) {
                    th = th6;
                    fileOutputStream = null;
                    inputStream = bufferedInputStream3;
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
            dVar.a(i3);
            dVar.a(httpURLConnection.getResponseCode(), hashMap);
            if (cVar != null) {
                cVar.a(i2, i3, null);
            }
            byte[] bArr2 = new byte[10240];
            if (SpeedLimitApiHolder.getInstance() != null) {
                bufferedInputStream3 = SpeedLimitApiHolder.getInstance().wrapInputStream(bufferedInputStream3);
            }
            while (true) {
                int read2 = bufferedInputStream3.read(bArr2);
                if (read2 == -1) {
                    break;
                }
                i2 += read2;
                dVar.a(bArr2, 0, read2);
                if (cVar != null) {
                    cVar.a(i2, i3, null);
                }
            }
            if (cVar != null) {
                cVar.a(i3, i3, null);
            }
            a(dVar);
            a(bufferedInputStream3);
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
            inputStream = bufferedInputStream2;
        }
    }
}
