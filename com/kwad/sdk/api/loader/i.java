package com.kwad.sdk.api.loader;

import android.content.Context;
import android.os.Environment;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.searchbox.aperf.bosuploader.BOSTokenRequest;
import com.baidubce.http.Headers;
import com.kwad.sdk.api.core.RequestParamsUtils;
import com.kwad.sdk.api.core.SpeedLimitApiHolder;
import com.kwad.sdk.api.core.TLSConnectionUtils;
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
import java.util.Random;
import org.apache.http.protocol.HTTP;
/* loaded from: classes5.dex */
public final class i {
    public static final String a = a(Loader.get().getContext()) + "/apkfileD/dynamic";

    /* loaded from: classes5.dex */
    public interface a {
        void a();

        void a(File file);
    }

    /* loaded from: classes5.dex */
    public static class b implements d {
        public final OutputStream a;

        public b(File file) {
            this.a = new FileOutputStream(file, false);
        }

        @Override // com.kwad.sdk.api.loader.i.d
        public final void a(byte[] bArr, int i) {
            this.a.write(bArr, 0, i);
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public final void close() {
            this.a.close();
        }
    }

    /* loaded from: classes5.dex */
    public interface c {
    }

    /* loaded from: classes5.dex */
    public interface d extends Closeable {
        void a(byte[] bArr, int i);
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

    public static URLConnection a(String str, int i) {
        try {
            URLConnection openConnection = new URL(str).openConnection();
            TLSConnectionUtils.wrapHttpURLConnection(openConnection);
            openConnection.setRequestProperty("Accept-Language", "zh-CN");
            openConnection.setConnectTimeout(10000);
            if (i > 0) {
                openConnection.setReadTimeout(i);
            }
            openConnection.setUseCaches(false);
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
        j.a(new Runnable() { // from class: com.kwad.sdk.api.loader.i.1
            @Override // java.lang.Runnable
            public final void run() {
                try {
                    boolean a2 = i.a(str, file);
                    if (aVar != null) {
                        if (a2) {
                            aVar.a(file);
                        } else {
                            aVar.a();
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    a aVar2 = aVar;
                    if (aVar2 != null) {
                        aVar2.a();
                    }
                }
            }
        });
    }

    public static boolean a(String str, d dVar, c cVar, int i) {
        HttpURLConnection httpURLConnection;
        HttpURLConnection httpURLConnection2 = null;
        try {
            httpURLConnection = (HttpURLConnection) a(str, i > 0 ? i : 120000);
        } catch (Throwable th) {
            th = th;
        }
        try {
            if (httpURLConnection != null) {
                boolean a2 = a(httpURLConnection, dVar, cVar, i);
                a(dVar);
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
                return a2;
            }
            throw new IOException("Fail to createUrlConnection");
        } catch (Throwable th2) {
            th = th2;
            httpURLConnection2 = httpURLConnection;
            a(dVar);
            if (httpURLConnection2 != null) {
                httpURLConnection2.disconnect();
            }
            throw th;
        }
    }

    public static boolean a(String str, File file) {
        b bVar;
        b bVar2 = null;
        try {
            bVar = new b(file);
        } catch (Throwable th) {
            th = th;
        }
        try {
            boolean a2 = a(str, bVar, (c) null, 0);
            a(bVar);
            return a2;
        } catch (Throwable th2) {
            th = th2;
            bVar2 = bVar;
            a(bVar2);
            throw th;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:60:0x010d A[Catch: all -> 0x0137, TryCatch #5 {all -> 0x0137, blocks: (B:58:0x0109, B:60:0x010d, B:62:0x0136, B:61:0x0110), top: B:80:0x0109 }] */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0110 A[Catch: all -> 0x0137, TryCatch #5 {all -> 0x0137, blocks: (B:58:0x0109, B:60:0x010d, B:62:0x0136, B:61:0x0110), top: B:80:0x0109 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean a(HttpURLConnection httpURLConnection, d dVar, c cVar, int i) {
        FileOutputStream fileOutputStream;
        File file;
        int i2;
        InputStream inputStream = null;
        try {
            if (!TextUtils.isEmpty(null)) {
                httpURLConnection.setRequestProperty("Host", null);
                httpURLConnection.setInstanceFollowRedirects(false);
                if (httpURLConnection.getResponseCode() == 302) {
                    boolean a2 = a(httpURLConnection.getHeaderField(Headers.LOCATION), dVar, cVar, i);
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
            InputStream bufferedInputStream = new BufferedInputStream(httpURLConnection.getInputStream());
            try {
                int contentLength = httpURLConnection.getContentLength();
                HashMap hashMap = httpURLConnection.getHeaderFields() == null ? new HashMap() : new HashMap(httpURLConnection.getHeaderFields());
                InputStream bufferedInputStream2 = new BufferedInputStream(httpURLConnection.getInputStream());
                if (contentLength <= 0) {
                    try {
                        Random random = new Random(System.currentTimeMillis());
                        file = new File(a, random.nextInt() + ".tmp");
                        try {
                            fileOutputStream = new FileOutputStream(file);
                            try {
                                byte[] bArr = new byte[10240];
                                i2 = 0;
                                while (true) {
                                    int read = bufferedInputStream2.read(bArr);
                                    if (read == -1) {
                                        break;
                                    }
                                    i2 += read;
                                    fileOutputStream.write(bArr, 0, read);
                                }
                                a(bufferedInputStream2);
                                a(fileOutputStream);
                                inputStream = new BufferedInputStream(new FileInputStream(file));
                            } catch (Throwable th) {
                                th = th;
                                inputStream = bufferedInputStream2;
                                try {
                                    if (th instanceof IOException) {
                                        throw new IOException(th.getClass().getName() + ":" + th.getMessage(), th);
                                    }
                                    throw th;
                                } finally {
                                    a(dVar);
                                    a(inputStream);
                                    if (httpURLConnection != null) {
                                        httpURLConnection.disconnect();
                                    }
                                    a(fileOutputStream);
                                    if (file != null) {
                                        file.delete();
                                    }
                                }
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            fileOutputStream = null;
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        fileOutputStream = null;
                        file = null;
                    }
                    try {
                        hashMap.put("Content-Length", Collections.singletonList(String.valueOf(i2)));
                    } catch (Throwable th4) {
                        th = th4;
                        if (th instanceof IOException) {
                        }
                    }
                } else {
                    fileOutputStream = null;
                    file = null;
                    inputStream = bufferedInputStream2;
                }
                httpURLConnection.getResponseCode();
                byte[] bArr2 = new byte[10240];
                if (SpeedLimitApiHolder.getInstance() != null) {
                    inputStream = SpeedLimitApiHolder.getInstance().wrapInputStream(inputStream);
                }
                while (true) {
                    int read2 = inputStream.read(bArr2);
                    if (read2 == -1) {
                        break;
                    }
                    dVar.a(bArr2, read2);
                }
            } catch (Throwable th5) {
                th = th5;
                fileOutputStream = null;
                file = null;
                inputStream = bufferedInputStream;
            }
        } catch (Throwable th6) {
            th = th6;
            fileOutputStream = null;
            file = null;
        }
    }
}
