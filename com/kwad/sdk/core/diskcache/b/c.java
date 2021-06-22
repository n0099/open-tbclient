package com.kwad.sdk.core.diskcache.b;

import androidx.annotation.NonNull;
import com.baidu.searchbox.aperf.bosuploader.BOSTokenRequest;
import com.kwad.sdk.core.diskcache.a.a;
import com.kwad.sdk.core.imageloader.utils.IoUtils;
import com.kwad.sdk.core.network.k;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
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
/* loaded from: classes7.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public static ExecutorService f34236a = Executors.newFixedThreadPool(5);

    /* loaded from: classes7.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public String f34240a;
    }

    public static void a(@NonNull final com.kwad.sdk.core.diskcache.a.a aVar, @NonNull final String str, @NonNull final String str2) {
        f34236a.execute(new Runnable() { // from class: com.kwad.sdk.core.diskcache.b.c.1
            @Override // java.lang.Runnable
            public void run() {
                OutputStream outputStream = null;
                try {
                    try {
                        a.C0380a a2 = com.kwad.sdk.core.diskcache.a.a.this.a(str2);
                        if (a2 != null) {
                            outputStream = a2.a(0);
                            if (c.b(str, outputStream, new a())) {
                                a2.a();
                            } else {
                                a2.b();
                            }
                            com.kwad.sdk.core.diskcache.a.a.this.b();
                        }
                    } catch (IOException e2) {
                        com.kwad.sdk.core.d.a.a(e2);
                        com.kwad.sdk.core.d.a.a("FileHelper", "downLoadFileAsync file crash", e2);
                    }
                } finally {
                    d.a(outputStream);
                }
            }
        });
    }

    public static void a(File file, File file2) {
        BufferedOutputStream bufferedOutputStream;
        BufferedInputStream bufferedInputStream = null;
        try {
            BufferedInputStream bufferedInputStream2 = new BufferedInputStream(new FileInputStream(file));
            try {
                bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file2));
                try {
                    byte[] bArr = new byte[1024];
                    while (true) {
                        int read = bufferedInputStream2.read(bArr);
                        if (read == -1) {
                            break;
                        }
                        bufferedOutputStream.write(bArr, 0, read);
                    }
                    IoUtils.closeSilently(bufferedInputStream2);
                } catch (Exception e2) {
                    e = e2;
                    bufferedInputStream = bufferedInputStream2;
                    try {
                        com.kwad.sdk.core.d.a.a(e);
                        IoUtils.closeSilently(bufferedInputStream);
                        IoUtils.closeSilently(bufferedOutputStream);
                    } catch (Throwable th) {
                        th = th;
                        IoUtils.closeSilently(bufferedInputStream);
                        IoUtils.closeSilently(bufferedOutputStream);
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    bufferedInputStream = bufferedInputStream2;
                    IoUtils.closeSilently(bufferedInputStream);
                    IoUtils.closeSilently(bufferedOutputStream);
                    throw th;
                }
            } catch (Exception e3) {
                e = e3;
                bufferedOutputStream = null;
            } catch (Throwable th3) {
                th = th3;
                bufferedOutputStream = null;
            }
        } catch (Exception e4) {
            e = e4;
            bufferedOutputStream = null;
        } catch (Throwable th4) {
            th = th4;
            bufferedOutputStream = null;
        }
        IoUtils.closeSilently(bufferedOutputStream);
    }

    public static boolean a(@NonNull com.kwad.sdk.core.diskcache.a.a aVar, @NonNull String str, @NonNull String str2, a aVar2) {
        boolean z = false;
        OutputStream outputStream = null;
        try {
            try {
                a.C0380a a2 = aVar.a(str2);
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
            } catch (IOException e2) {
                com.kwad.sdk.core.d.a.a(e2);
                com.kwad.sdk.core.d.a.a("FileHelper", "downLoadFileSync file crash", e2);
                aVar2.f34240a = e2.getMessage();
            }
            return z;
        } finally {
            d.a(outputStream);
        }
    }

    public static boolean a(@NonNull File file, @NonNull String str) {
        FileOutputStream fileOutputStream;
        FileOutputStream fileOutputStream2 = null;
        try {
            try {
                fileOutputStream = new FileOutputStream(file);
            } catch (Throwable th) {
                th = th;
            }
        } catch (IOException e2) {
            e = e2;
        }
        try {
            boolean b2 = b(str, fileOutputStream, new a());
            d.a(fileOutputStream);
            return b2;
        } catch (IOException e3) {
            e = e3;
            fileOutputStream2 = fileOutputStream;
            com.kwad.sdk.core.d.a.a(e);
            com.kwad.sdk.core.d.a.a("FileHelper", "downLoadFileSync file crash", e);
            d.a(fileOutputStream2);
            return false;
        } catch (Throwable th2) {
            th = th2;
            fileOutputStream2 = fileOutputStream;
            d.a(fileOutputStream2);
            throw th;
        }
    }

    public static boolean b(String str, OutputStream outputStream, a aVar) {
        HttpURLConnection httpURLConnection;
        BufferedInputStream bufferedInputStream;
        BufferedOutputStream bufferedOutputStream;
        BufferedOutputStream bufferedOutputStream2 = null;
        try {
            httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            try {
                httpURLConnection.setRequestProperty("Accept-Language", "zh-CN");
                httpURLConnection.setConnectTimeout(10000);
                httpURLConnection.setReadTimeout(120000);
                httpURLConnection.setUseCaches(false);
                httpURLConnection.setDoInput(true);
                httpURLConnection.setRequestProperty(HTTP.CONN_DIRECTIVE, "keep-alive");
                httpURLConnection.setRequestProperty(BOSTokenRequest.CHARSET, "UTF-8");
                httpURLConnection.setRequestProperty("User-Agent", k.a());
                bufferedInputStream = new BufferedInputStream(httpURLConnection.getInputStream());
                try {
                    try {
                        bufferedOutputStream = new BufferedOutputStream(outputStream);
                    } catch (Exception e2) {
                        e = e2;
                    }
                } catch (Throwable th) {
                    th = th;
                }
            } catch (Exception e3) {
                e = e3;
                bufferedInputStream = null;
            } catch (Throwable th2) {
                th = th2;
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
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
                return true;
            } catch (Exception e4) {
                e = e4;
                bufferedOutputStream2 = bufferedOutputStream;
                com.kwad.sdk.core.d.a.a(e);
                com.kwad.sdk.core.d.a.a("FileHelper", "downloadUrlToStream file crash", e);
                aVar.f34240a = e.getMessage();
                d.a(bufferedOutputStream2);
                d.a(bufferedInputStream);
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
                return false;
            } catch (Throwable th3) {
                th = th3;
                bufferedOutputStream2 = bufferedOutputStream;
                d.a(bufferedOutputStream2);
                d.a(bufferedInputStream);
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
                throw th;
            }
        } catch (Exception e5) {
            e = e5;
            httpURLConnection = null;
            bufferedInputStream = null;
        } catch (Throwable th4) {
            th = th4;
            httpURLConnection = null;
            bufferedInputStream = null;
        }
    }
}
