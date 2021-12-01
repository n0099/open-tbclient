package com.kwad.sdk.core.videocache;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;
/* loaded from: classes2.dex */
public class h implements m {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final com.kwad.sdk.core.videocache.c.b a;

    /* renamed from: b  reason: collision with root package name */
    public final com.kwad.sdk.core.videocache.a.b f57917b;

    /* renamed from: c  reason: collision with root package name */
    public n f57918c;

    /* renamed from: d  reason: collision with root package name */
    public HttpURLConnection f57919d;

    /* renamed from: e  reason: collision with root package name */
    public InputStream f57920e;

    public h(h hVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {hVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f57918c = hVar.f57918c;
        this.a = hVar.a;
        this.f57917b = hVar.f57917b;
    }

    public h(String str, com.kwad.sdk.core.videocache.c.b bVar, com.kwad.sdk.core.videocache.a.b bVar2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, bVar, bVar2};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = (com.kwad.sdk.core.videocache.c.b) j.a(bVar);
        this.f57917b = (com.kwad.sdk.core.videocache.a.b) j.a(bVar2);
        n a = bVar.a(str);
        this.f57918c = a == null ? new n(str, -2147483648L, l.a(str)) : a;
    }

    private long a(HttpURLConnection httpURLConnection) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, this, httpURLConnection)) == null) {
            String headerField = httpURLConnection.getHeaderField("Content-Length");
            if (headerField == null) {
                return -1L;
            }
            return Long.parseLong(headerField);
        }
        return invokeL.longValue;
    }

    private long a(HttpURLConnection httpURLConnection, long j2, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65539, this, new Object[]{httpURLConnection, Long.valueOf(j2), Integer.valueOf(i2)})) == null) {
            long a = a(httpURLConnection);
            return i2 == 200 ? a : i2 == 206 ? a + j2 : this.f57918c.f57934b;
        }
        return invokeCommon.longValue;
    }

    private HttpURLConnection a(long j2, int i2) {
        InterceptResult invokeCommon;
        String str;
        HttpURLConnection httpURLConnection;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, this, new Object[]{Long.valueOf(j2), Integer.valueOf(i2)})) == null) {
            String str2 = this.f57918c.a;
            int i3 = 0;
            do {
                StringBuilder sb = new StringBuilder();
                sb.append("Open connection ");
                int i4 = (j2 > 0L ? 1 : (j2 == 0L ? 0 : -1));
                if (i4 > 0) {
                    str = " with offset " + j2;
                } else {
                    str = "";
                }
                sb.append(str);
                sb.append(" to ");
                sb.append(str2);
                com.kwad.sdk.core.d.a.a("HttpUrlSource", sb.toString());
                httpURLConnection = (HttpURLConnection) new URL(str2).openConnection();
                com.kwad.sdk.core.network.m.a(httpURLConnection);
                a(httpURLConnection, str2);
                if (i4 > 0) {
                    httpURLConnection.setRequestProperty("Range", "bytes=" + j2 + "-");
                }
                if (i2 > 0) {
                    httpURLConnection.setConnectTimeout(i2);
                    httpURLConnection.setReadTimeout(i2);
                }
                httpURLConnection.setRequestProperty("User-Agent", com.kwad.sdk.core.network.k.c());
                httpURLConnection.setRequestProperty("BrowserUa", com.kwad.sdk.core.network.k.d());
                httpURLConnection.setRequestProperty("SystemUa", com.kwad.sdk.core.network.k.a());
                int responseCode = httpURLConnection.getResponseCode();
                z = responseCode == 301 || responseCode == 302 || responseCode == 303;
                if (z) {
                    str2 = httpURLConnection.getHeaderField("Location");
                    i3++;
                    httpURLConnection.disconnect();
                }
                if (i3 > 5) {
                    throw new ProxyCacheException("Too many redirects: " + i3);
                }
            } while (z);
            return httpURLConnection;
        }
        return (HttpURLConnection) invokeCommon.objValue;
    }

    private void a(HttpURLConnection httpURLConnection, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65541, this, httpURLConnection, str) == null) {
            for (Map.Entry<String, String> entry : this.f57917b.a(str).entrySet()) {
                httpURLConnection.setRequestProperty(entry.getKey(), entry.getValue());
            }
        }
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:10:0x0061 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:27:0x0067 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:28:0x0023 */
    /* JADX DEBUG: Null dom frontier in handler: IOException -> 0x0067 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:22:0x008d  */
    /* JADX WARN: Type inference failed for: r0v10, types: [java.net.HttpURLConnection] */
    /* JADX WARN: Type inference failed for: r0v12 */
    /* JADX WARN: Type inference failed for: r0v13 */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5 */
    /* JADX WARN: Type inference failed for: r0v7, types: [java.net.HttpURLConnection] */
    /* JADX WARN: Type inference failed for: r0v8 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void e() {
        HttpURLConnection httpURLConnection;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65542, this) == null) {
            com.kwad.sdk.core.d.a.a("HttpUrlSource", "Read content info from " + this.f57918c.a);
            ?? r0 = 10000;
            InputStream inputStream = null;
            try {
                try {
                    httpURLConnection = a(0L, 10000);
                    try {
                        long a = a(httpURLConnection);
                        String contentType = httpURLConnection.getContentType();
                        inputStream = httpURLConnection.getInputStream();
                        n nVar = new n(this.f57918c.a, a, contentType);
                        this.f57918c = nVar;
                        this.a.a(nVar.a, nVar);
                        com.kwad.sdk.core.d.a.a("HttpUrlSource", "Source info fetched: " + this.f57918c);
                        l.a(inputStream);
                        r0 = httpURLConnection;
                        if (httpURLConnection == null) {
                            return;
                        }
                    } catch (IOException unused) {
                        com.kwad.sdk.core.d.a.e("HttpUrlSource", "Error fetching info from " + this.f57918c.a);
                        l.a(inputStream);
                        r0 = httpURLConnection;
                        if (httpURLConnection == null) {
                            return;
                        }
                        r0.disconnect();
                    }
                } catch (Throwable th) {
                    th = th;
                    l.a(inputStream);
                    if (r0 != 0) {
                        r0.disconnect();
                    }
                    throw th;
                }
            } catch (IOException unused2) {
                httpURLConnection = null;
            } catch (Throwable th2) {
                th = th2;
                r0 = 0;
                l.a(inputStream);
                if (r0 != 0) {
                }
                throw th;
            }
            r0.disconnect();
        }
    }

    @Override // com.kwad.sdk.core.videocache.m
    public int a(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, bArr)) == null) {
            InputStream inputStream = this.f57920e;
            if (inputStream == null) {
                throw new ProxyCacheException("Error reading data from " + this.f57918c.a + ": connection is absent!");
            }
            try {
                return inputStream.read(bArr, 0, bArr.length);
            } catch (InterruptedIOException e2) {
                throw new InterruptedProxyCacheException("Reading source " + this.f57918c.a + " is interrupted", e2);
            } catch (IOException e3) {
                throw new ProxyCacheException("Error reading data from " + this.f57918c.a, e3);
            }
        }
        return invokeL.intValue;
    }

    @Override // com.kwad.sdk.core.videocache.m
    public synchronized long a() {
        InterceptResult invokeV;
        long j2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            synchronized (this) {
                if (this.f57918c.f57934b == -2147483648L) {
                    e();
                }
                j2 = this.f57918c.f57934b;
            }
            return j2;
        }
        return invokeV.longValue;
    }

    @Override // com.kwad.sdk.core.videocache.m
    public void a(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(Constants.METHOD_SEND_USER_MSG, this, j2) == null) {
            try {
                HttpURLConnection a = a(j2, -1);
                this.f57919d = a;
                String contentType = a.getContentType();
                this.f57920e = new BufferedInputStream(this.f57919d.getInputStream(), 8192);
                n nVar = new n(this.f57918c.a, a(this.f57919d, j2, this.f57919d.getResponseCode()), contentType);
                this.f57918c = nVar;
                this.a.a(nVar.a, nVar);
            } catch (IOException e2) {
                throw new ProxyCacheException("Error opening connection for " + this.f57918c.a + " with offset " + j2, e2);
            }
        }
    }

    @Override // com.kwad.sdk.core.videocache.m
    public void b() {
        HttpURLConnection httpURLConnection;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (httpURLConnection = this.f57919d) == null) {
            return;
        }
        try {
            httpURLConnection.disconnect();
        } catch (ArrayIndexOutOfBoundsException unused) {
            com.kwad.sdk.core.d.a.e("HttpUrlSource", "Error closing connection correctly. Should happen only on Android L. If anybody know how to fix it, please visit https://github.com/danikula/AndroidVideoCache/issues/88. Until good solution is not know, just ignore this issue.");
        } catch (IllegalArgumentException e2) {
            e = e2;
            throw new RuntimeException("Wait... but why? WTF!? Really shouldn't happen any more after fixing https://github.com/danikula/AndroidVideoCache/issues/43. If you read it on your device log, please, notify me danikula@gmail.com or create issue here https://github.com/danikula/AndroidVideoCache/issues.", e);
        } catch (NullPointerException e3) {
            e = e3;
            throw new RuntimeException("Wait... but why? WTF!? Really shouldn't happen any more after fixing https://github.com/danikula/AndroidVideoCache/issues/43. If you read it on your device log, please, notify me danikula@gmail.com or create issue here https://github.com/danikula/AndroidVideoCache/issues.", e);
        }
    }

    public synchronized String c() {
        InterceptResult invokeV;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            synchronized (this) {
                if (TextUtils.isEmpty(this.f57918c.f57935c)) {
                    e();
                }
                str = this.f57918c.f57935c;
            }
            return str;
        }
        return (String) invokeV.objValue;
    }

    public String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f57918c.a : (String) invokeV.objValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return "HttpUrlSource{sourceInfo='" + this.f57918c + "}";
        }
        return (String) invokeV.objValue;
    }
}
