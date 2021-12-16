package com.kwad.sdk.core.diskcache.a;

import androidx.annotation.NonNull;
import com.baidu.searchbox.aperf.bosuploader.BOSTokenRequest;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.core.diskcache.kwai.a;
import com.kwad.sdk.core.network.k;
import com.kwad.sdk.core.network.m;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.ExecutorService;
import org.apache.http.protocol.HTTP;
/* loaded from: classes3.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public static ExecutorService a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes3.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;

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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1945814565, "Lcom/kwad/sdk/core/diskcache/a/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1945814565, "Lcom/kwad/sdk/core/diskcache/a/c;");
                return;
            }
        }
        a = com.kwad.sdk.core.i.b.i();
    }

    public static void a(@NonNull com.kwad.sdk.core.diskcache.kwai.a aVar, @NonNull String str, @NonNull String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65537, null, aVar, str, str2) == null) {
            a.execute(new Runnable(aVar, str2, str) { // from class: com.kwad.sdk.core.diskcache.a.c.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ com.kwad.sdk.core.diskcache.kwai.a a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ String f57862b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ String f57863c;

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
                    this.a = aVar;
                    this.f57862b = str2;
                    this.f57863c = str;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        OutputStream outputStream = null;
                        try {
                            try {
                                a.C2074a b2 = this.a.b(this.f57862b);
                                if (b2 != null) {
                                    outputStream = b2.a(0);
                                    if (c.b(this.f57863c, outputStream, new a())) {
                                        b2.a();
                                    } else {
                                        b2.b();
                                    }
                                    this.a.b();
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

    public static boolean a(@NonNull com.kwad.sdk.core.diskcache.kwai.a aVar, @NonNull String str, @NonNull String str2, a aVar2) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65538, null, aVar, str, str2, aVar2)) == null) {
            boolean z = false;
            OutputStream outputStream = null;
            try {
                try {
                    a.C2074a b2 = aVar.b(str2);
                    if (b2 != null) {
                        outputStream = b2.a(0);
                        if (b(str, outputStream, aVar2)) {
                            b2.a();
                            z = true;
                        } else {
                            b2.b();
                        }
                        aVar.b();
                    }
                } catch (IOException e2) {
                    com.kwad.sdk.core.d.a.a(e2);
                    com.kwad.sdk.core.d.a.a("FileHelper", "downLoadFileSync file crash", e2);
                    aVar2.a = e2.getMessage();
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
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, file, str)) == null) {
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
                com.kwad.sdk.core.d.a.b(e);
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
        BufferedOutputStream bufferedOutputStream;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeLLL = interceptable.invokeLLL(65541, null, str, outputStream, aVar)) != null) {
            return invokeLLL.booleanValue;
        }
        BufferedInputStream bufferedInputStream = null;
        try {
            httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            try {
                m.a(httpURLConnection);
                httpURLConnection.setRequestProperty("Accept-Language", "zh-CN");
                httpURLConnection.setConnectTimeout(10000);
                httpURLConnection.setReadTimeout(120000);
                httpURLConnection.setUseCaches(false);
                httpURLConnection.setDoInput(true);
                httpURLConnection.setRequestProperty(HTTP.CONN_DIRECTIVE, "keep-alive");
                httpURLConnection.setRequestProperty(BOSTokenRequest.CHARSET, "UTF-8");
                httpURLConnection.setRequestProperty("User-Agent", k.c());
                httpURLConnection.setRequestProperty("BrowserUa", k.d());
                httpURLConnection.setRequestProperty("SystemUa", k.a());
                BufferedInputStream bufferedInputStream2 = new BufferedInputStream(httpURLConnection.getInputStream());
                try {
                    bufferedOutputStream = new BufferedOutputStream(outputStream);
                    try {
                        byte[] bArr = new byte[1024];
                        while (true) {
                            int read = bufferedInputStream2.read(bArr);
                            if (read == -1) {
                                break;
                            }
                            bufferedOutputStream.write(bArr, 0, read);
                        }
                        bufferedOutputStream.flush();
                        d.a(bufferedOutputStream);
                        d.a((Closeable) bufferedInputStream2);
                        if (httpURLConnection != null) {
                            httpURLConnection.disconnect();
                        }
                        return true;
                    } catch (Throwable th) {
                        th = th;
                        bufferedInputStream = bufferedInputStream2;
                        try {
                            com.kwad.sdk.core.d.a.b(th);
                            com.kwad.sdk.core.d.a.a("FileHelper", "downloadUrlToStream file crash", th);
                            aVar.a = th.getMessage();
                            return false;
                        } finally {
                            d.a(bufferedOutputStream);
                            d.a((Closeable) bufferedInputStream);
                            if (httpURLConnection != null) {
                                httpURLConnection.disconnect();
                            }
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    bufferedOutputStream = null;
                }
            } catch (Throwable th3) {
                th = th3;
                bufferedOutputStream = null;
            }
        } catch (Throwable th4) {
            th = th4;
            httpURLConnection = null;
            bufferedOutputStream = null;
        }
    }
}
