package com.kwad.sdk.core.diskcache.b;

import androidx.annotation.NonNull;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.kwad.sdk.core.diskcache.a.a;
import com.kwad.sdk.core.imageloader.utils.IoUtils;
import com.kwad.sdk.core.network.k;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.apache.http.protocol.HTTP;
/* loaded from: classes3.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    private static ExecutorService f9085a = Executors.newFixedThreadPool(5);

    /* loaded from: classes3.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public String f9088a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(@NonNull final com.kwad.sdk.core.diskcache.a.a aVar, @NonNull final String str, @NonNull final String str2) {
        f9085a.execute(new Runnable() { // from class: com.kwad.sdk.core.diskcache.b.c.1
            @Override // java.lang.Runnable
            public void run() {
                OutputStream outputStream = null;
                try {
                    a.C1092a a2 = com.kwad.sdk.core.diskcache.a.a.this.a(str2);
                    if (a2 != null) {
                        outputStream = a2.a(0);
                        if (c.b(str, outputStream, new a())) {
                            a2.a();
                        } else {
                            a2.b();
                        }
                        com.kwad.sdk.core.diskcache.a.a.this.b();
                    }
                } catch (IOException e) {
                    com.kwad.sdk.core.d.a.a(e);
                    com.kwad.sdk.core.d.a.a("FileHelper", "downLoadFileAsync file crash", e);
                } finally {
                    d.a(outputStream);
                }
            }
        });
    }

    public static void a(File file, File file2) {
        Closeable closeable;
        BufferedInputStream bufferedInputStream;
        BufferedOutputStream bufferedOutputStream;
        try {
            try {
                bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
            } catch (Throwable th) {
                th = th;
            }
            try {
                bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file2));
                try {
                    byte[] bArr = new byte[1024];
                    while (true) {
                        int read = bufferedInputStream.read(bArr);
                        if (read == -1) {
                            IoUtils.closeSilently(bufferedInputStream);
                            IoUtils.closeSilently(bufferedOutputStream);
                            return;
                        }
                        bufferedOutputStream.write(bArr, 0, read);
                    }
                } catch (Exception e) {
                    e = e;
                    com.kwad.sdk.core.d.a.a(e);
                    IoUtils.closeSilently(bufferedInputStream);
                    IoUtils.closeSilently(bufferedOutputStream);
                }
            } catch (Exception e2) {
                e = e2;
                bufferedOutputStream = null;
            } catch (Throwable th2) {
                th = th2;
                closeable = null;
                IoUtils.closeSilently(bufferedInputStream);
                IoUtils.closeSilently(closeable);
                throw th;
            }
        } catch (Exception e3) {
            e = e3;
            bufferedOutputStream = null;
            bufferedInputStream = null;
        } catch (Throwable th3) {
            th = th3;
            closeable = null;
            bufferedInputStream = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean a(@NonNull com.kwad.sdk.core.diskcache.a.a aVar, @NonNull String str, @NonNull String str2, a aVar2) {
        boolean z = false;
        OutputStream outputStream = null;
        try {
            a.C1092a a2 = aVar.a(str2);
            if (a2 != null) {
                outputStream = a2.a(0);
                if (b(str, outputStream, aVar2)) {
                    a2.a();
                    z = true;
                } else {
                    a2.b();
                }
                aVar.b();
            }
        } catch (IOException e) {
            com.kwad.sdk.core.d.a.a(e);
            com.kwad.sdk.core.d.a.a("FileHelper", "downLoadFileSync file crash", e);
            aVar2.f9088a = e.getMessage();
        } finally {
            d.a(outputStream);
        }
        return z;
    }

    public static boolean a(@NonNull File file, @NonNull String str) {
        FileOutputStream fileOutputStream;
        try {
            fileOutputStream = new FileOutputStream(file);
            try {
                try {
                    r0 = b(str, fileOutputStream, new a());
                    d.a(fileOutputStream);
                } catch (IOException e) {
                    e = e;
                    com.kwad.sdk.core.d.a.a(e);
                    com.kwad.sdk.core.d.a.a("FileHelper", "downLoadFileSync file crash", e);
                    d.a(fileOutputStream);
                    return r0;
                }
            } catch (Throwable th) {
                th = th;
                d.a(fileOutputStream);
                throw th;
            }
        } catch (IOException e2) {
            e = e2;
            fileOutputStream = null;
        } catch (Throwable th2) {
            th = th2;
            fileOutputStream = null;
            d.a(fileOutputStream);
            throw th;
        }
        return r0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00a2  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean b(String str, OutputStream outputStream, a aVar) {
        Throwable th;
        HttpURLConnection httpURLConnection;
        BufferedOutputStream bufferedOutputStream;
        BufferedInputStream bufferedInputStream;
        Exception e;
        HttpURLConnection httpURLConnection2;
        try {
            httpURLConnection2 = (HttpURLConnection) new URL(str).openConnection();
            try {
                httpURLConnection2.setRequestProperty("Accept-Language", "zh-CN");
                httpURLConnection2.setConnectTimeout(10000);
                httpURLConnection2.setReadTimeout(BdStatisticsManager.UPLOAD_TIMER_INTERVAL);
                httpURLConnection2.setUseCaches(false);
                httpURLConnection2.setDoInput(true);
                httpURLConnection2.setRequestProperty(HTTP.CONN_DIRECTIVE, "keep-alive");
                httpURLConnection2.setRequestProperty("Charset", "UTF-8");
                httpURLConnection2.setRequestProperty("User-Agent", k.a());
                bufferedInputStream = new BufferedInputStream(httpURLConnection2.getInputStream());
                try {
                    bufferedOutputStream = new BufferedOutputStream(outputStream);
                } catch (Exception e2) {
                    e = e2;
                    httpURLConnection = httpURLConnection2;
                    bufferedOutputStream = null;
                } catch (Throwable th2) {
                    th = th2;
                    httpURLConnection = httpURLConnection2;
                    bufferedOutputStream = null;
                }
            } catch (Exception e3) {
                e = e3;
                httpURLConnection = httpURLConnection2;
                bufferedOutputStream = null;
                bufferedInputStream = null;
            } catch (Throwable th3) {
                th = th3;
                httpURLConnection = httpURLConnection2;
                bufferedOutputStream = null;
                bufferedInputStream = null;
            }
        } catch (Exception e4) {
            e = e4;
            httpURLConnection = null;
            bufferedOutputStream = null;
            bufferedInputStream = null;
        } catch (Throwable th4) {
            th = th4;
            httpURLConnection = null;
            bufferedOutputStream = null;
            bufferedInputStream = null;
        }
        try {
            byte[] bArr = new byte[1024];
            while (true) {
                int read = bufferedInputStream.read(bArr);
                if (read == -1) {
                    break;
                }
                bufferedOutputStream.write(bArr, 0, read);
            }
            bufferedOutputStream.flush();
            d.a(bufferedOutputStream);
            d.a(bufferedInputStream);
            if (httpURLConnection2 != null) {
                httpURLConnection2.disconnect();
            }
            return true;
        } catch (Exception e5) {
            e = e5;
            httpURLConnection = httpURLConnection2;
            try {
                com.kwad.sdk.core.d.a.a(e);
                com.kwad.sdk.core.d.a.a("FileHelper", "downloadUrlToStream file crash", e);
                aVar.f9088a = e.getMessage();
                d.a(bufferedOutputStream);
                d.a(bufferedInputStream);
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
                return false;
            } catch (Throwable th5) {
                th = th5;
                d.a(bufferedOutputStream);
                d.a(bufferedInputStream);
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
                throw th;
            }
        } catch (Throwable th6) {
            th = th6;
            httpURLConnection = httpURLConnection2;
            d.a(bufferedOutputStream);
            d.a(bufferedInputStream);
            if (httpURLConnection != null) {
            }
            throw th;
        }
    }
}
