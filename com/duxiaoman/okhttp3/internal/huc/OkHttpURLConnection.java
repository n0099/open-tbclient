package com.duxiaoman.okhttp3.internal.huc;

import androidx.core.view.InputDeviceCompat;
import c.d.b.b0;
import c.d.b.e;
import c.d.b.e0.b;
import c.d.b.e0.d;
import c.d.b.e0.i.k;
import c.d.b.e0.n.g;
import c.d.b.f;
import c.d.b.n;
import c.d.b.q;
import c.d.b.r;
import c.d.b.s;
import c.d.b.t;
import c.d.b.w;
import c.d.b.z;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.Proxy;
import java.net.SocketPermission;
import java.net.URL;
import java.net.UnknownHostException;
import java.security.Permission;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import okio.Buffer;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpOptions;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.methods.HttpTrace;
/* loaded from: classes7.dex */
public final class OkHttpURLConnection extends HttpURLConnection implements f {
    public static /* synthetic */ Interceptable $ic;
    public static final String p;
    public static final String q;
    public static final Set<String> r;
    public transient /* synthetic */ FieldHolder $fh;
    public w a;

    /* renamed from: b  reason: collision with root package name */
    public final a f52113b;

    /* renamed from: c  reason: collision with root package name */
    public r.a f52114c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f52115d;

    /* renamed from: e  reason: collision with root package name */
    public e f52116e;

    /* renamed from: f  reason: collision with root package name */
    public d f52117f;

    /* renamed from: g  reason: collision with root package name */
    public r f52118g;

    /* renamed from: h  reason: collision with root package name */
    public long f52119h;

    /* renamed from: i  reason: collision with root package name */
    public final Object f52120i;

    /* renamed from: j  reason: collision with root package name */
    public b0 f52121j;
    public Throwable k;
    public b0 l;
    public boolean m;
    public Proxy n;
    public q o;

    /* loaded from: classes7.dex */
    public static final class UnexpectedException extends IOException {
        public static /* synthetic */ Interceptable $ic;
        public static final t INTERCEPTOR;
        public transient /* synthetic */ FieldHolder $fh;

        /* loaded from: classes7.dex */
        public class a implements t {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

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

            @Override // c.d.b.t
            public b0 a(t.a aVar) throws IOException {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, aVar)) == null) {
                    try {
                        return aVar.a(aVar.request());
                    } catch (Error | RuntimeException e2) {
                        throw new UnexpectedException(e2);
                    }
                }
                return (b0) invokeL.objValue;
            }
        }

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1156754308, "Lcom/duxiaoman/okhttp3/internal/huc/OkHttpURLConnection$UnexpectedException;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1156754308, "Lcom/duxiaoman/okhttp3/internal/huc/OkHttpURLConnection$UnexpectedException;");
                    return;
                }
            }
            INTERCEPTOR = new a();
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public UnexpectedException(Throwable th) {
            super(th);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {th};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((Throwable) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public final class a implements t {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ OkHttpURLConnection f52122b;

        public a(OkHttpURLConnection okHttpURLConnection) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {okHttpURLConnection};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f52122b = okHttpURLConnection;
        }

        @Override // c.d.b.t
        public b0 a(t.a aVar) throws IOException {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, aVar)) == null) {
                z request = aVar.request();
                this.f52122b.f52114c = request.d().f();
                d dVar = this.f52122b.f52117f;
                if (dVar != null) {
                    dVar.a(request.h().C());
                }
                synchronized (this.f52122b.f52120i) {
                    this.f52122b.m = false;
                    this.f52122b.n = aVar.connection().route().b();
                    this.f52122b.o = aVar.connection().handshake();
                    this.f52122b.f52120i.notifyAll();
                    while (!this.a) {
                        try {
                            this.f52122b.f52120i.wait();
                        } catch (InterruptedException unused) {
                            Thread.currentThread().interrupt();
                            throw new InterruptedIOException();
                        }
                    }
                }
                if (request.a() instanceof c.d.b.e0.l.d) {
                    request = ((c.d.b.e0.l.d) request.a()).i(request);
                }
                b0 a = aVar.a(request);
                synchronized (this.f52122b.f52120i) {
                    this.f52122b.l = a;
                    ((HttpURLConnection) this.f52122b).url = a.r().h().C();
                }
                return a;
            }
            return (b0) invokeL.objValue;
        }

        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                synchronized (this.f52122b.f52120i) {
                    this.a = true;
                    this.f52122b.f52120i.notifyAll();
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(195305470, "Lcom/duxiaoman/okhttp3/internal/huc/OkHttpURLConnection;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(195305470, "Lcom/duxiaoman/okhttp3/internal/huc/OkHttpURLConnection;");
                return;
            }
        }
        p = g.m().n() + "-Selected-Protocol";
        q = g.m().n() + "-Response-Source";
        r = new LinkedHashSet(Arrays.asList(HttpOptions.METHOD_NAME, "GET", "HEAD", "POST", HttpPut.METHOD_NAME, HttpDelete.METHOD_NAME, HttpTrace.METHOD_NAME, "PATCH"));
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OkHttpURLConnection(URL url, w wVar) {
        super(url);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {url, wVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((URL) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f52113b = new a(this);
        this.f52114c = new r.a();
        this.f52119h = -1L;
        this.f52120i = new Object();
        this.m = true;
        this.a = wVar;
    }

    public static IOException j(Throwable th) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, th)) == null) {
            if (!(th instanceof IOException)) {
                if (!(th instanceof Error)) {
                    if (th instanceof RuntimeException) {
                        throw ((RuntimeException) th);
                    }
                    throw new AssertionError();
                }
                throw ((Error) th);
            }
            throw ((IOException) th);
        }
        return (IOException) invokeL.objValue;
    }

    public static String k(b0 b0Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, b0Var)) == null) {
            if (b0Var.m() == null) {
                if (b0Var.e() == null) {
                    return "NONE";
                }
                return "CACHE " + b0Var.code();
            } else if (b0Var.e() == null) {
                return "NETWORK " + b0Var.code();
            } else {
                return "CONDITIONAL_CACHE " + b0Var.m().code();
            }
        }
        return (String) invokeL.objValue;
    }

    public static String l(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, str)) == null) {
            int length = str.length();
            int i2 = 0;
            while (i2 < length) {
                int codePointAt = str.codePointAt(i2);
                if (codePointAt > 31 && codePointAt < 127) {
                    i2 += Character.charCount(codePointAt);
                } else {
                    Buffer buffer = new Buffer();
                    buffer.writeUtf8(str, 0, i2);
                    buffer.writeUtf8CodePoint(63);
                    while (true) {
                        i2 += Character.charCount(codePointAt);
                        if (i2 < length) {
                            codePointAt = str.codePointAt(i2);
                            buffer.writeUtf8CodePoint((codePointAt <= 31 || codePointAt >= 127) ? 63 : codePointAt);
                        } else {
                            return buffer.readUtf8();
                        }
                    }
                }
            }
            return str;
        }
        return (String) invokeL.objValue;
    }

    @Override // c.d.b.f
    public void a(e eVar, IOException iOException) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, eVar, iOException) == null) {
            synchronized (this.f52120i) {
                boolean z = iOException instanceof UnexpectedException;
                Throwable th = iOException;
                if (z) {
                    th = iOException.getCause();
                }
                this.k = th;
                this.f52120i.notifyAll();
            }
        }
    }

    @Override // java.net.URLConnection
    public void addRequestProperty(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2) == null) {
            if (((HttpURLConnection) this).connected) {
                throw new IllegalStateException("Cannot add request property after connection is made");
            }
            if (str == null) {
                throw new NullPointerException("field == null");
            }
            if (str2 == null) {
                g m = g.m();
                m.u(5, "Ignoring header " + str + " because its value was null.", null);
                return;
            }
            this.f52114c.a(str, str2);
        }
    }

    @Override // c.d.b.f
    public void b(e eVar, b0 b0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, eVar, b0Var) == null) {
            synchronized (this.f52120i) {
                this.f52121j = b0Var;
                this.o = b0Var.f();
                ((HttpURLConnection) this).url = b0Var.r().h().C();
                this.f52120i.notifyAll();
            }
        }
    }

    @Override // java.net.URLConnection
    public void connect() throws IOException {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || this.f52115d) {
            return;
        }
        e f2 = f();
        this.f52115d = true;
        f2.d(this);
        synchronized (this.f52120i) {
            while (this.m && this.f52121j == null && this.k == null) {
                try {
                    this.f52120i.wait();
                } catch (InterruptedException unused) {
                    Thread.currentThread().interrupt();
                    throw new InterruptedIOException();
                }
            }
            if (this.k != null) {
                j(this.k);
                throw null;
            }
        }
    }

    @Override // java.net.HttpURLConnection
    public void disconnect() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || this.f52116e == null) {
            return;
        }
        this.f52113b.b();
        this.f52116e.cancel();
    }

    public final e f() throws IOException {
        InterceptResult invokeV;
        c.d.b.e0.l.d dVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            e eVar = this.f52116e;
            if (eVar != null) {
                return eVar;
            }
            boolean z = true;
            ((HttpURLConnection) this).connected = true;
            if (((HttpURLConnection) this).doOutput) {
                if (((HttpURLConnection) this).method.equals("GET")) {
                    ((HttpURLConnection) this).method = "POST";
                } else if (!c.d.b.e0.i.f.b(((HttpURLConnection) this).method)) {
                    throw new ProtocolException(((HttpURLConnection) this).method + " does not support writing");
                }
            }
            if (this.f52114c.e("User-Agent") == null) {
                this.f52114c.a("User-Agent", g());
            }
            if (c.d.b.e0.i.f.b(((HttpURLConnection) this).method)) {
                if (this.f52114c.e("Content-Type") == null) {
                    this.f52114c.a("Content-Type", "application/x-www-form-urlencoded");
                }
                long j2 = -1;
                if (this.f52119h == -1 && ((HttpURLConnection) this).chunkLength <= 0) {
                    z = false;
                }
                String e2 = this.f52114c.e("Content-Length");
                long j3 = this.f52119h;
                if (j3 != -1) {
                    j2 = j3;
                } else if (e2 != null) {
                    j2 = Long.parseLong(e2);
                }
                if (z) {
                    dVar = new c.d.b.e0.l.e(j2);
                } else {
                    dVar = new c.d.b.e0.l.a(j2);
                }
                dVar.j().timeout(this.a.F(), TimeUnit.MILLISECONDS);
            } else {
                dVar = null;
            }
            try {
                s k = s.k(getURL().toString());
                z.a aVar = new z.a();
                aVar.g(k);
                aVar.d(this.f52114c.d());
                aVar.e(((HttpURLConnection) this).method, dVar);
                z b2 = aVar.b();
                d dVar2 = this.f52117f;
                if (dVar2 != null) {
                    dVar2.a(b2.h().C());
                }
                w.b t = this.a.t();
                t.k().clear();
                t.k().add(UnexpectedException.INTERCEPTOR);
                t.l().clear();
                t.l().add(this.f52113b);
                t.f(new n(this.a.i().c()));
                if (!getUseCaches()) {
                    t.b(null);
                }
                e u = t.a().u(b2);
                this.f52116e = u;
                return u;
            } catch (IllegalArgumentException e3) {
                if (c.d.b.e0.a.a.i(e3)) {
                    UnknownHostException unknownHostException = new UnknownHostException();
                    unknownHostException.initCause(e3);
                    throw unknownHostException;
                }
                MalformedURLException malformedURLException = new MalformedURLException();
                malformedURLException.initCause(e3);
                throw malformedURLException;
            }
        }
        return (e) invokeV.objValue;
    }

    public final String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            String property = System.getProperty("http.agent");
            return property != null ? l(property) : c.d.b.e0.f.a();
        }
        return (String) invokeV.objValue;
    }

    @Override // java.net.URLConnection
    public int getConnectTimeout() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.a.e() : invokeV.intValue;
    }

    @Override // java.net.HttpURLConnection
    public InputStream getErrorStream() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            try {
                b0 i2 = i(true);
                if (c.d.b.e0.i.e.c(i2) && i2.code() >= 400) {
                    return i2.a().a();
                }
            } catch (IOException unused) {
            }
            return null;
        }
        return (InputStream) invokeV.objValue;
    }

    @Override // java.net.HttpURLConnection, java.net.URLConnection
    public String getHeaderField(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048585, this, i2)) == null) {
            try {
                r h2 = h();
                if (i2 >= 0 && i2 < h2.g()) {
                    return h2.h(i2);
                }
            } catch (IOException unused) {
            }
            return null;
        }
        return (String) invokeI.objValue;
    }

    @Override // java.net.HttpURLConnection, java.net.URLConnection
    public String getHeaderFieldKey(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048587, this, i2)) == null) {
            try {
                r h2 = h();
                if (i2 >= 0 && i2 < h2.g()) {
                    return h2.e(i2);
                }
            } catch (IOException unused) {
            }
            return null;
        }
        return (String) invokeI.objValue;
    }

    @Override // java.net.URLConnection
    public Map<String, List<String>> getHeaderFields() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            try {
                return b.a(h(), k.a(i(true)).toString());
            } catch (IOException unused) {
                return Collections.emptyMap();
            }
        }
        return (Map) invokeV.objValue;
    }

    @Override // java.net.URLConnection
    public InputStream getInputStream() throws IOException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            if (((HttpURLConnection) this).doInput) {
                b0 i2 = i(false);
                if (i2.code() < 400) {
                    return i2.a().a();
                }
                throw new FileNotFoundException(((HttpURLConnection) this).url.toString());
            }
            throw new ProtocolException("This protocol does not support input");
        }
        return (InputStream) invokeV.objValue;
    }

    @Override // java.net.HttpURLConnection
    public boolean getInstanceFollowRedirects() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.a.l() : invokeV.booleanValue;
    }

    @Override // java.net.URLConnection
    public OutputStream getOutputStream() throws IOException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            c.d.b.e0.l.d dVar = (c.d.b.e0.l.d) f().request().a();
            if (dVar != null) {
                if (dVar instanceof c.d.b.e0.l.e) {
                    connect();
                    this.f52113b.b();
                }
                if (!dVar.g()) {
                    return dVar.h();
                }
                throw new ProtocolException("cannot write request body after response has been read");
            }
            throw new ProtocolException("method does not support a request body: " + ((HttpURLConnection) this).method);
        }
        return (OutputStream) invokeV.objValue;
    }

    @Override // java.net.HttpURLConnection, java.net.URLConnection
    public Permission getPermission() throws IOException {
        InterceptResult invokeV;
        int d2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            URL url = getURL();
            String host = url.getHost();
            if (url.getPort() != -1) {
                d2 = url.getPort();
            } else {
                d2 = s.d(url.getProtocol());
            }
            if (usingProxy()) {
                InetSocketAddress inetSocketAddress = (InetSocketAddress) this.a.y().address();
                host = inetSocketAddress.getHostName();
                d2 = inetSocketAddress.getPort();
            }
            return new SocketPermission(host + ":" + d2, "connect, resolve");
        }
        return (Permission) invokeV.objValue;
    }

    @Override // java.net.URLConnection
    public int getReadTimeout() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.a.B() : invokeV.intValue;
    }

    @Override // java.net.URLConnection
    public Map<String, List<String>> getRequestProperties() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            if (!((HttpURLConnection) this).connected) {
                return b.a(this.f52114c.d(), null);
            }
            throw new IllegalStateException("Cannot access request header fields after connection is set");
        }
        return (Map) invokeV.objValue;
    }

    @Override // java.net.URLConnection
    public String getRequestProperty(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048595, this, str)) == null) {
            if (str == null) {
                return null;
            }
            return this.f52114c.e(str);
        }
        return (String) invokeL.objValue;
    }

    @Override // java.net.HttpURLConnection
    public int getResponseCode() throws IOException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? i(true).code() : invokeV.intValue;
    }

    @Override // java.net.HttpURLConnection
    public String getResponseMessage() throws IOException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? i(true).l() : (String) invokeV.objValue;
    }

    public final r h() throws IOException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            if (this.f52118g == null) {
                b0 i2 = i(true);
                r.a f2 = i2.j().f();
                f2.a(p, i2.p().toString());
                f2.a(q, k(i2));
                this.f52118g = f2.d();
            }
            return this.f52118g;
        }
        return (r) invokeV.objValue;
    }

    public final b0 i(boolean z) throws IOException {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048599, this, z)) == null) {
            synchronized (this.f52120i) {
                if (this.f52121j != null) {
                    return this.f52121j;
                }
                if (this.k != null) {
                    if (!z || this.l == null) {
                        j(this.k);
                        throw null;
                    }
                    return this.l;
                }
                e f2 = f();
                this.f52113b.b();
                c.d.b.e0.l.d dVar = (c.d.b.e0.l.d) f2.request().a();
                if (dVar != null) {
                    dVar.h().close();
                }
                if (this.f52115d) {
                    synchronized (this.f52120i) {
                        while (this.f52121j == null && this.k == null) {
                            try {
                                try {
                                    this.f52120i.wait();
                                } catch (InterruptedException unused) {
                                    Thread.currentThread().interrupt();
                                    throw new InterruptedIOException();
                                }
                            } finally {
                            }
                        }
                    }
                } else {
                    this.f52115d = true;
                    try {
                        b(f2, f2.execute());
                    } catch (IOException e2) {
                        a(f2, e2);
                    }
                }
                synchronized (this.f52120i) {
                    if (this.k == null) {
                        if (this.f52121j != null) {
                            return this.f52121j;
                        }
                        throw new AssertionError();
                    }
                    j(this.k);
                    throw null;
                }
            }
        }
        return (b0) invokeZ.objValue;
    }

    @Override // java.net.URLConnection
    public void setConnectTimeout(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048600, this, i2) == null) {
            w.b t = this.a.t();
            t.c(i2, TimeUnit.MILLISECONDS);
            this.a = t.a();
        }
    }

    @Override // java.net.HttpURLConnection
    public void setFixedLengthStreamingMode(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048601, this, i2) == null) {
            setFixedLengthStreamingMode(i2);
        }
    }

    @Override // java.net.URLConnection
    public void setIfModifiedSince(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048603, this, j2) == null) {
            super.setIfModifiedSince(j2);
            if (((HttpURLConnection) this).ifModifiedSince != 0) {
                this.f52114c.g("If-Modified-Since", c.d.b.e0.i.d.a(new Date(((HttpURLConnection) this).ifModifiedSince)));
            } else {
                this.f52114c.f("If-Modified-Since");
            }
        }
    }

    @Override // java.net.HttpURLConnection
    public void setInstanceFollowRedirects(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048604, this, z) == null) {
            w.b t = this.a.t();
            t.i(z);
            this.a = t.a();
        }
    }

    @Override // java.net.URLConnection
    public void setReadTimeout(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048605, this, i2) == null) {
            w.b t = this.a.t();
            t.n(i2, TimeUnit.MILLISECONDS);
            this.a = t.a();
        }
    }

    @Override // java.net.HttpURLConnection
    public void setRequestMethod(String str) throws ProtocolException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048606, this, str) == null) {
            if (r.contains(str)) {
                ((HttpURLConnection) this).method = str;
                return;
            }
            throw new ProtocolException("Expected one of " + r + " but was " + str);
        }
    }

    @Override // java.net.URLConnection
    public void setRequestProperty(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048607, this, str, str2) == null) {
            if (((HttpURLConnection) this).connected) {
                throw new IllegalStateException("Cannot set request property after connection is made");
            }
            if (str == null) {
                throw new NullPointerException("field == null");
            }
            if (str2 == null) {
                g m = g.m();
                m.u(5, "Ignoring header " + str + " because its value was null.", null);
                return;
            }
            this.f52114c.g(str, str2);
        }
    }

    @Override // java.net.HttpURLConnection
    public boolean usingProxy() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) {
            if (this.n != null) {
                return true;
            }
            Proxy y = this.a.y();
            return (y == null || y.type() == Proxy.Type.DIRECT) ? false : true;
        }
        return invokeV.booleanValue;
    }

    @Override // java.net.HttpURLConnection
    public void setFixedLengthStreamingMode(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048602, this, j2) == null) {
            if (!((HttpURLConnection) this).connected) {
                if (((HttpURLConnection) this).chunkLength > 0) {
                    throw new IllegalStateException("Already in chunked mode");
                }
                if (j2 >= 0) {
                    this.f52119h = j2;
                    ((HttpURLConnection) this).fixedContentLength = (int) Math.min(j2, 2147483647L);
                    return;
                }
                throw new IllegalArgumentException("contentLength < 0");
            }
            throw new IllegalStateException("Already connected");
        }
    }

    @Override // java.net.URLConnection
    public String getHeaderField(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, str)) == null) {
            try {
                if (str == null) {
                    return k.a(i(true)).toString();
                }
                return h().c(str);
            } catch (IOException unused) {
                return null;
            }
        }
        return (String) invokeL.objValue;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public OkHttpURLConnection(URL url, w wVar, d dVar) {
        this(url, wVar);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {url, wVar, dVar};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((URL) objArr2[0], (w) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.f52117f = dVar;
    }
}
