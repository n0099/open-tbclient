package com.kwad.sdk.core.diskcache.b;

import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.searchbox.aperf.bosuploader.BOSTokenRequest;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.core.diskcache.a.a;
import com.kwad.sdk.core.imageloader.utils.IoUtils;
import com.kwad.sdk.core.network.k;
import com.kwad.sdk.core.network.l;
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
import java.net.URLConnection;
import java.util.concurrent.ExecutorService;
import org.apache.http.protocol.HTTP;
/* loaded from: classes6.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static ExecutorService f34465a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public String f34469a;

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1945844356, "Lcom/kwad/sdk/core/diskcache/b/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1945844356, "Lcom/kwad/sdk/core/diskcache/b/c;");
                return;
            }
        }
        f34465a = com.kwad.sdk.core.i.b.i();
    }

    public static void a(@NonNull com.kwad.sdk.core.diskcache.a.a aVar, @NonNull String str, @NonNull String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65537, null, aVar, str, str2) == null) {
            f34465a.execute(new Runnable(aVar, str2, str) { // from class: com.kwad.sdk.core.diskcache.b.c.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ com.kwad.sdk.core.diskcache.a.a f34466a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ String f34467b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ String f34468c;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {aVar, str2, str};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f34466a = aVar;
                    this.f34467b = str2;
                    this.f34468c = str;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        OutputStream outputStream = null;
                        try {
                            try {
                                a.C0413a a2 = this.f34466a.a(this.f34467b);
                                if (a2 != null) {
                                    outputStream = a2.a(0);
                                    if (c.b(this.f34468c, outputStream, new a())) {
                                        a2.a();
                                    } else {
                                        a2.b();
                                    }
                                    this.f34466a.b();
                                }
                            } catch (IOException e2) {
                                com.kwad.sdk.core.d.a.a(e2);
                                com.kwad.sdk.core.d.a.a("FileHelper", "downLoadFileAsync file crash", e2);
                            }
                        } finally {
                            d.a(outputStream);
                        }
                    }
                }
            });
        }
    }

    public static void a(File file, File file2) {
        BufferedOutputStream bufferedOutputStream;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, file, file2) == null) {
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
    }

    public static boolean a(@NonNull com.kwad.sdk.core.diskcache.a.a aVar, @NonNull String str, @NonNull String str2, a aVar2) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65539, null, aVar, str, str2, aVar2)) == null) {
            boolean z = false;
            OutputStream outputStream = null;
            try {
                try {
                    a.C0413a a2 = aVar.a(str2);
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
                    aVar2.f34469a = e2.getMessage();
                }
                return z;
            } finally {
                d.a(outputStream);
            }
        }
        return invokeLLLL.booleanValue;
    }

    public static boolean a(@NonNull File file, @NonNull String str) {
        InterceptResult invokeLL;
        FileOutputStream fileOutputStream;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, file, str)) == null) {
            FileOutputStream fileOutputStream2 = null;
            try {
                try {
                    fileOutputStream = new FileOutputStream(file);
                } catch (IOException e2) {
                    e = e2;
                }
            } catch (Throwable th) {
                th = th;
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
        return invokeLL.booleanValue;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:22:0x0076 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:37:0x00a1 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v0, types: [com.baidu.titan.sdk.runtime.Interceptable] */
    /* JADX WARN: Type inference failed for: r3v12, types: [java.io.BufferedInputStream, java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r3v2 */
    /* JADX WARN: Type inference failed for: r3v3 */
    /* JADX WARN: Type inference failed for: r3v4, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r3v5, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r3v6 */
    /* JADX WARN: Type inference failed for: r3v7 */
    /* JADX WARN: Type inference failed for: r6v0, types: [java.lang.Object, java.lang.String] */
    /* JADX WARN: Type inference failed for: r6v1 */
    /* JADX WARN: Type inference failed for: r6v2 */
    /* JADX WARN: Type inference failed for: r6v3, types: [java.net.HttpURLConnection] */
    /* JADX WARN: Type inference failed for: r6v4, types: [java.net.HttpURLConnection] */
    /* JADX WARN: Type inference failed for: r6v6, types: [java.net.HttpURLConnection, java.net.URLConnection] */
    public static boolean b(String str, OutputStream outputStream, a aVar) {
        ?? r3;
        InterceptResult invokeLLL;
        BufferedOutputStream bufferedOutputStream;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeLLL = (r3 = interceptable).invokeLLL(AdIconUtil.BAIDU_LOGO_ID, null, str, outputStream, aVar)) != null) {
            return invokeLLL.booleanValue;
        }
        BufferedOutputStream bufferedOutputStream2 = null;
        try {
            try {
                str = (HttpURLConnection) new URL(str).openConnection();
                try {
                    l.a((URLConnection) str);
                    str.setRequestProperty("Accept-Language", "zh-CN");
                    str.setConnectTimeout(10000);
                    str.setReadTimeout(120000);
                    str.setUseCaches(false);
                    str.setDoInput(true);
                    str.setRequestProperty(HTTP.CONN_DIRECTIVE, "keep-alive");
                    str.setRequestProperty(BOSTokenRequest.CHARSET, "UTF-8");
                    str.setRequestProperty("User-Agent", k.a());
                    r3 = new BufferedInputStream(str.getInputStream());
                    try {
                        bufferedOutputStream = new BufferedOutputStream(outputStream);
                    } catch (Exception e2) {
                        e = e2;
                    }
                    try {
                        byte[] bArr = new byte[1024];
                        while (true) {
                            int read = r3.read(bArr);
                            if (read == -1) {
                                break;
                            }
                            bufferedOutputStream.write(bArr, 0, read);
                        }
                        bufferedOutputStream.flush();
                        d.a(bufferedOutputStream);
                        d.a((Closeable) r3);
                        if (str != 0) {
                            str.disconnect();
                        }
                        return true;
                    } catch (Exception e3) {
                        e = e3;
                        bufferedOutputStream2 = bufferedOutputStream;
                        com.kwad.sdk.core.d.a.a(e);
                        com.kwad.sdk.core.d.a.a("FileHelper", "downloadUrlToStream file crash", e);
                        aVar.f34469a = e.getMessage();
                        d.a(bufferedOutputStream2);
                        d.a((Closeable) r3);
                        if (str != 0) {
                            str.disconnect();
                        }
                        return false;
                    } catch (Throwable th) {
                        th = th;
                        bufferedOutputStream2 = bufferedOutputStream;
                        d.a(bufferedOutputStream2);
                        d.a((Closeable) r3);
                        if (str != 0) {
                            str.disconnect();
                        }
                        throw th;
                    }
                } catch (Exception e4) {
                    e = e4;
                    r3 = 0;
                } catch (Throwable th2) {
                    th = th2;
                    r3 = 0;
                }
            } catch (Throwable th3) {
                th = th3;
            }
        } catch (Exception e5) {
            e = e5;
            str = 0;
            r3 = 0;
        } catch (Throwable th4) {
            th = th4;
            str = 0;
            r3 = 0;
        }
    }
}
