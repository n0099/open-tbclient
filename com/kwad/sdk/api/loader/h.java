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
    public static final String f32180a = a(Loader.get().getContext()) + "/apkfileD/dynamic";

    /* loaded from: classes6.dex */
    public interface a {
        void a();

        void a(File file);
    }

    /* loaded from: classes6.dex */
    public static class b implements d {

        /* renamed from: a  reason: collision with root package name */
        public final OutputStream f32184a;

        public b(File file, boolean z) {
            this.f32184a = new FileOutputStream(file, z);
        }

        @Override // com.kwad.sdk.api.loader.h.d
        public void a(int i, Map<String, List<String>> map) {
        }

        @Override // com.kwad.sdk.api.loader.h.d
        public void a(long j) {
        }

        @Override // com.kwad.sdk.api.loader.h.d
        public void a(byte[] bArr, int i, int i2) {
            this.f32184a.write(bArr, i, i2);
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            this.f32184a.close();
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

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:115:0x00d5 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:81:0x016c */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:90:0x017d A[Catch: all -> 0x01a7, TryCatch #3 {all -> 0x01a7, blocks: (B:88:0x0179, B:90:0x017d, B:92:0x01a6, B:91:0x0180), top: B:107:0x0179 }] */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0180 A[Catch: all -> 0x01a7, TryCatch #3 {all -> 0x01a7, blocks: (B:88:0x0179, B:90:0x017d, B:92:0x01a6, B:91:0x0180), top: B:107:0x0179 }] */
    /* JADX WARN: Type inference failed for: r14v5 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean a(HttpURLConnection httpURLConnection, String str, d dVar, c cVar, int i, long j, long j2, boolean z) {
        Object valueOf;
        FileOutputStream fileOutputStream;
        File file;
        HashMap hashMap;
        File file2;
        InputStream inputStream = null;
        int i2 = (j > 0L ? 1 : (j == 0L ? 0 : -1));
        if (i2 > 0 || j2 > 0) {
            try {
                Object[] objArr = new Object[2];
                objArr[0] = Long.valueOf(j);
                if (j2 > 0) {
                    try {
                        valueOf = Long.valueOf(j2);
                    } catch (Throwable th) {
                        th = th;
                        fileOutputStream = null;
                        file = null;
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
                } else {
                    valueOf = "";
                }
                objArr[1] = valueOf;
                httpURLConnection.setRequestProperty("Range", String.format("bytes=%s-%s", objArr));
            } catch (Throwable th3) {
                th = th3;
                fileOutputStream = null;
                inputStream = null;
                file = null;
                if (th instanceof IOException) {
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
        BufferedInputStream bufferedInputStream = new BufferedInputStream(httpURLConnection.getInputStream());
        try {
            int contentLength = httpURLConnection.getContentLength();
            if (httpURLConnection.getHeaderFields() == null) {
                try {
                    hashMap = new HashMap();
                } catch (Throwable th4) {
                    th = th4;
                    fileOutputStream = null;
                    file = fileOutputStream;
                    inputStream = bufferedInputStream;
                    if (th instanceof IOException) {
                        throw new IOException(th.getClass().getName() + ":" + th.getMessage(), th);
                    }
                    throw th;
                }
            } else {
                hashMap = new HashMap(httpURLConnection.getHeaderFields());
            }
            BufferedInputStream bufferedInputStream2 = new BufferedInputStream(httpURLConnection.getInputStream());
            if (contentLength <= 0) {
                try {
                    Random random = new Random(System.currentTimeMillis());
                    file2 = new File(f32180a, random.nextInt() + ".tmp");
                    try {
                        fileOutputStream = new FileOutputStream(file2);
                    } catch (Throwable th5) {
                        th = th5;
                        fileOutputStream = null;
                        inputStream = bufferedInputStream2;
                        file = file2;
                        if (th instanceof IOException) {
                        }
                    }
                } catch (Throwable th6) {
                    th = th6;
                    fileOutputStream = null;
                    file2 = null;
                }
                try {
                    byte[] bArr = new byte[10240];
                    int i3 = 0;
                    while (true) {
                        int read = bufferedInputStream2.read(bArr);
                        if (read == -1) {
                            break;
                        }
                        i3 += read;
                        fileOutputStream.write(bArr, 0, read);
                    }
                    a(bufferedInputStream2);
                    a(fileOutputStream);
                    BufferedInputStream bufferedInputStream3 = new BufferedInputStream(new FileInputStream(file2));
                    try {
                        hashMap.put("Content-Length", Collections.singletonList(String.valueOf(i3)));
                        bufferedInputStream2 = bufferedInputStream3;
                        contentLength = i3;
                        file2 = file2;
                    } catch (Throwable th7) {
                        th = th7;
                        inputStream = bufferedInputStream3;
                        file = file2;
                        if (th instanceof IOException) {
                        }
                    }
                } catch (Throwable th8) {
                    th = th8;
                    inputStream = bufferedInputStream2;
                    file = file2;
                    if (th instanceof IOException) {
                    }
                }
            } else {
                fileOutputStream = null;
                file2 = null;
            }
            int i4 = (i2 <= 0 || !z) ? 0 : (int) j;
            int i5 = contentLength + i4;
            dVar.a(i5);
            dVar.a(httpURLConnection.getResponseCode(), hashMap);
            if (cVar != null) {
                cVar.a(i4, i5, null);
            }
            byte[] bArr2 = new byte[10240];
            if (SpeedLimitApiHolder.getInstance() != null) {
                bufferedInputStream2 = SpeedLimitApiHolder.getInstance().wrapInputStream(bufferedInputStream2);
            }
            while (true) {
                int read2 = bufferedInputStream2.read(bArr2);
                if (read2 == -1) {
                    break;
                }
                i4 += read2;
                dVar.a(bArr2, 0, read2);
                if (cVar != null) {
                    cVar.a(i4, i5, null);
                }
            }
            if (cVar != null) {
                cVar.a(i5, i5, null);
            }
            a(dVar);
            a(bufferedInputStream2);
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
            a(fileOutputStream);
            if (file2 != null) {
                file2.delete();
                return true;
            }
            return true;
        } catch (Throwable th9) {
            th = th9;
            fileOutputStream = null;
        }
    }
}
