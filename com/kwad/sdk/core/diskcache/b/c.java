package com.kwad.sdk.core.diskcache.b;

import androidx.annotation.NonNull;
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
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static ExecutorService f35999a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public String f36003a;

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
        f35999a = Executors.newFixedThreadPool(5);
    }

    public static void a(@NonNull com.kwad.sdk.core.diskcache.a.a aVar, @NonNull String str, @NonNull String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65537, null, aVar, str, str2) == null) {
            f35999a.execute(new Runnable(aVar, str2, str) { // from class: com.kwad.sdk.core.diskcache.b.c.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ com.kwad.sdk.core.diskcache.a.a f36000a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ String f36001b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ String f36002c;

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
                    this.f36000a = aVar;
                    this.f36001b = str2;
                    this.f36002c = str;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        OutputStream outputStream = null;
                        try {
                            try {
                                a.C0424a a2 = this.f36000a.a(this.f36001b);
                                if (a2 != null) {
                                    outputStream = a2.a(0);
                                    if (c.b(this.f36002c, outputStream, new a())) {
                                        a2.a();
                                    } else {
                                        a2.b();
                                    }
                                    this.f36000a.b();
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
                    a.C0424a a2 = aVar.a(str2);
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
                    aVar2.f36003a = e2.getMessage();
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
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65540, null, file, str)) == null) {
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

    public static boolean b(String str, OutputStream outputStream, a aVar) {
        InterceptResult invokeLLL;
        HttpURLConnection httpURLConnection;
        BufferedInputStream bufferedInputStream;
        BufferedOutputStream bufferedOutputStream;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeLLL = interceptable.invokeLLL(AdIconUtil.BAIDU_LOGO_ID, null, str, outputStream, aVar)) != null) {
            return invokeLLL.booleanValue;
        }
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
                } catch (Exception e3) {
                    e = e3;
                    bufferedOutputStream2 = bufferedOutputStream;
                    com.kwad.sdk.core.d.a.a(e);
                    com.kwad.sdk.core.d.a.a("FileHelper", "downloadUrlToStream file crash", e);
                    aVar.f36003a = e.getMessage();
                    d.a(bufferedOutputStream2);
                    d.a(bufferedInputStream);
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                    return false;
                } catch (Throwable th2) {
                    th = th2;
                    bufferedOutputStream2 = bufferedOutputStream;
                    d.a(bufferedOutputStream2);
                    d.a(bufferedInputStream);
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                    throw th;
                }
            } catch (Exception e4) {
                e = e4;
                bufferedInputStream = null;
            } catch (Throwable th3) {
                th = th3;
                bufferedInputStream = null;
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
