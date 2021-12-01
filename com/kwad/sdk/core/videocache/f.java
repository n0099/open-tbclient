package com.kwad.sdk.core.videocache;

import android.content.Context;
import android.net.Uri;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.aperf.bosuploader.BOSTokenRequest;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import org.apache.http.protocol.HTTP;
/* loaded from: classes2.dex */
public class f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Object a;

    /* renamed from: b  reason: collision with root package name */
    public final ExecutorService f57899b;

    /* renamed from: c  reason: collision with root package name */
    public final Map<String, g> f57900c;

    /* renamed from: d  reason: collision with root package name */
    public final ServerSocket f57901d;

    /* renamed from: e  reason: collision with root package name */
    public final int f57902e;

    /* renamed from: f  reason: collision with root package name */
    public final Thread f57903f;

    /* renamed from: g  reason: collision with root package name */
    public final com.kwad.sdk.core.videocache.c f57904g;

    /* renamed from: com.kwad.sdk.core.videocache.f$1  reason: invalid class name */
    /* loaded from: classes2.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes2.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public File a;

        /* renamed from: b  reason: collision with root package name */
        public com.kwad.sdk.core.videocache.kwai.c f57905b;

        /* renamed from: c  reason: collision with root package name */
        public com.kwad.sdk.core.videocache.kwai.a f57906c;

        /* renamed from: d  reason: collision with root package name */
        public com.kwad.sdk.core.videocache.c.b f57907d;

        /* renamed from: e  reason: collision with root package name */
        public com.kwad.sdk.core.videocache.a.b f57908e;

        public a(Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f57907d = com.kwad.sdk.core.videocache.c.c.a(context);
            this.a = o.a(context);
            this.f57906c = new com.kwad.sdk.core.videocache.kwai.g(536870912L);
            this.f57905b = new com.kwad.sdk.core.videocache.kwai.f();
            this.f57908e = new com.kwad.sdk.core.videocache.a.a();
        }

        private com.kwad.sdk.core.videocache.c b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65537, this)) == null) ? new com.kwad.sdk.core.videocache.c(this.a, this.f57905b, this.f57906c, this.f57907d, this.f57908e) : (com.kwad.sdk.core.videocache.c) invokeV.objValue;
        }

        public a a(long j2) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJ = interceptable.invokeJ(1048576, this, j2)) == null) {
                this.f57906c = new com.kwad.sdk.core.videocache.kwai.g(j2);
                return this;
            }
            return (a) invokeJ.objValue;
        }

        public f a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? new f(b(), null) : (f) invokeV.objValue;
        }
    }

    /* loaded from: classes2.dex */
    public final class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ f a;

        /* renamed from: b  reason: collision with root package name */
        public final Socket f57909b;

        public b(f fVar, Socket socket) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar, socket};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = fVar;
            this.f57909b = socket;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                com.kwad.sdk.core.d.a.a("HttpProxyCacheServer", "schedule SocketProcessorRunnable run");
                this.a.a(this.f57909b);
            }
        }
    }

    /* loaded from: classes2.dex */
    public final class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ f a;

        /* renamed from: b  reason: collision with root package name */
        public final CountDownLatch f57910b;

        public c(f fVar, CountDownLatch countDownLatch) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar, countDownLatch};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = fVar;
            this.f57910b = countDownLatch;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    this.f57910b.countDown();
                    this.a.a();
                } catch (Throwable th) {
                    com.kwad.sdk.core.d.a.a(th);
                }
            }
        }
    }

    public f(com.kwad.sdk.core.videocache.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {cVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = new Object();
        this.f57899b = com.kwad.sdk.core.i.b.l();
        this.f57900c = new ConcurrentHashMap();
        this.f57904g = (com.kwad.sdk.core.videocache.c) j.a(cVar);
        try {
            ServerSocket serverSocket = new ServerSocket(0, 8, InetAddress.getByName("127.0.0.1"));
            this.f57901d = serverSocket;
            int localPort = serverSocket.getLocalPort();
            this.f57902e = localPort;
            i.a("127.0.0.1", localPort);
            CountDownLatch countDownLatch = new CountDownLatch(1);
            Thread thread = new Thread(new c(this, countDownLatch));
            this.f57903f = thread;
            thread.start();
            countDownLatch.await();
        } catch (IOException | InterruptedException e2) {
            this.f57899b.shutdown();
            throw new IllegalStateException("Error starting local proxy server", e2);
        }
    }

    public /* synthetic */ f(com.kwad.sdk.core.videocache.c cVar, AnonymousClass1 anonymousClass1) {
        this(cVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, this) == null) {
            while (!Thread.currentThread().isInterrupted()) {
                try {
                    Socket accept = this.f57901d.accept();
                    com.kwad.sdk.core.d.a.a("HttpProxyCacheServer", "Accept new socket " + accept);
                    this.f57899b.submit(new b(this, accept));
                } catch (IOException e2) {
                    a(new ProxyCacheException("Error during waiting connection", e2));
                    return;
                }
            }
        }
    }

    private void a(File file) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65541, this, file) == null) {
            try {
                this.f57904g.f57890c.a(file);
            } catch (IOException unused) {
                com.kwad.sdk.core.d.a.e("HttpProxyCacheServer", "Error touching file " + file);
            }
        }
    }

    private void a(Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65542, this, th) == null) {
            com.kwad.sdk.core.d.a.e("HttpProxyCacheServer", "HttpProxyCacheServer error");
            com.kwad.sdk.core.d.a.b(th);
        }
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:24:0x0008 */
    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(r0v3 ?? I:java.lang.String), (wrap: int : 0x0080: INVOKE  (r0v4 int A[REMOVE]) = (r5v0 'this' ?? I:com.kwad.sdk.core.videocache.f A[IMMUTABLE_TYPE, THIS]) type: DIRECT call: com.kwad.sdk.core.videocache.f.b():int)] */
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v2, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r0v3, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r0v5, types: [int] */
    /* JADX WARN: Type inference failed for: r5v0, types: [java.lang.Object, com.kwad.sdk.core.videocache.f] */
    /* JADX WARN: Type inference failed for: r6v0, types: [java.net.Socket, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r6v3, types: [java.net.Socket] */
    /* JADX WARN: Type inference failed for: r6v4, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r6v7, types: [java.lang.String] */
    public void a(Socket socket) {
        StringBuilder sb;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65543, this, socket) == null) {
            ?? r0 = "Opened connections: ";
            try {
                try {
                    d a2 = d.a(socket.getInputStream());
                    com.kwad.sdk.core.d.a.a("HttpProxyCacheServer", "Request to cache proxy:" + a2);
                    f(l.c(a2.a)).a(a2, socket);
                    b(socket);
                    sb = new StringBuilder();
                } catch (ProxyCacheException e2) {
                    e = e2;
                    a(new ProxyCacheException("Error processing request", e));
                    b(socket);
                    sb = new StringBuilder();
                } catch (SocketException e3) {
                    com.kwad.sdk.core.d.a.a("HttpProxyCacheServer", "Closing socket… Socket is closed by client.");
                    e3.printStackTrace();
                    b(socket);
                    sb = new StringBuilder();
                } catch (IOException e4) {
                    e = e4;
                    a(new ProxyCacheException("Error processing request", e));
                    b(socket);
                    sb = new StringBuilder();
                }
                sb.append("Opened connections: ");
                r0 = b();
                sb.append((int) r0);
                socket = sb.toString();
                com.kwad.sdk.core.d.a.a("HttpProxyCacheServer", (String) socket);
            } catch (Throwable th) {
                b(socket);
                ?? sb2 = new StringBuilder();
                sb2.append(r0);
                sb2.append(b());
                com.kwad.sdk.core.d.a.a("HttpProxyCacheServer", sb2.toString());
                throw th;
            }
        }
    }

    private int b() {
        InterceptResult invokeV;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, this)) == null) {
            synchronized (this.a) {
                i2 = 0;
                for (g gVar : this.f57900c.values()) {
                    i2 += gVar.b();
                }
            }
            return i2;
        }
        return invokeV.intValue;
    }

    private void b(Socket socket) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65545, this, socket) == null) {
            c(socket);
            d(socket);
            e(socket);
        }
    }

    private void c(Socket socket) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65546, this, socket) == null) {
            try {
                if (socket.isInputShutdown()) {
                    return;
                }
                socket.shutdownInput();
            } catch (SocketException unused) {
                com.kwad.sdk.core.d.a.a("HttpProxyCacheServer", "Releasing input stream… Socket is closed by client.");
            } catch (IOException e2) {
                a(new ProxyCacheException("Error closing socket input stream", e2));
            }
        }
    }

    private void d(Socket socket) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65547, this, socket) == null) {
            try {
                if (socket.isOutputShutdown()) {
                    return;
                }
                socket.shutdownOutput();
            } catch (IOException unused) {
                com.kwad.sdk.core.d.a.d("HttpProxyCacheServer", "Failed to close socket on proxy side: {}. It seems client have already closed connection.");
            }
        }
    }

    private String e(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65548, this, str)) == null) ? String.format(Locale.US, "http://%s:%d/%s", "127.0.0.1", Integer.valueOf(this.f57902e), l.b(str)) : (String) invokeL.objValue;
    }

    private void e(Socket socket) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65549, this, socket) == null) {
            try {
                if (socket.isClosed()) {
                    return;
                }
                socket.close();
            } catch (IOException e2) {
                a(new ProxyCacheException("Error closing socket", e2));
            }
        }
    }

    private g f(String str) {
        InterceptResult invokeL;
        g gVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65550, this, str)) == null) {
            synchronized (this.a) {
                gVar = this.f57900c.get(str);
                if (gVar == null) {
                    gVar = new g(str, this.f57904g);
                    this.f57900c.put(str, gVar);
                }
            }
            return gVar;
        }
        return (g) invokeL.objValue;
    }

    public String a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) ? a(str, true) : (String) invokeL.objValue;
    }

    public String a(String str, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, z)) == null) {
            if (z && d(str).exists()) {
                File d2 = d(str);
                a(d2);
                return Uri.fromFile(d2).toString();
            }
            return e(str);
        }
        return (String) invokeLZ.objValue;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:26:0x00a5 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:41:0x00c2 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:57:0x002a */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v1, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r11v2 */
    /* JADX WARN: Type inference failed for: r11v3 */
    /* JADX WARN: Type inference failed for: r11v4 */
    /* JADX WARN: Type inference failed for: r11v5, types: [java.net.HttpURLConnection] */
    /* JADX WARN: Type inference failed for: r11v6, types: [java.net.HttpURLConnection] */
    /* JADX WARN: Type inference failed for: r11v8, types: [java.net.HttpURLConnection, java.net.URLConnection] */
    public boolean a(String str, int i2) {
        InterceptResult invokeLI;
        BufferedInputStream bufferedInputStream;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, str, i2)) == null) {
            com.kwad.sdk.core.d.a.a("HttpProxyCacheServer", "preloadSync preloadUrl " + str);
            if (b(str)) {
                return true;
            }
            ?? e2 = e(str);
            long j2 = 0;
            BufferedInputStream bufferedInputStream2 = null;
            try {
                try {
                    e2 = (HttpURLConnection) new URL(e2).openConnection();
                    try {
                        com.kwad.sdk.core.network.m.a((URLConnection) e2);
                        e2.setRequestProperty("Accept-Language", "zh-CN");
                        e2.setConnectTimeout(10000);
                        e2.setReadTimeout(120000);
                        e2.setUseCaches(false);
                        e2.setDoInput(true);
                        e2.setRequestProperty(HTTP.CONN_DIRECTIVE, "keep-alive");
                        e2.setRequestProperty(BOSTokenRequest.CHARSET, "UTF-8");
                        e2.setRequestProperty("User-Agent", com.kwad.sdk.core.network.k.c());
                        e2.setRequestProperty("BrowserUa", com.kwad.sdk.core.network.k.d());
                        e2.setRequestProperty("SystemUa", com.kwad.sdk.core.network.k.a());
                        bufferedInputStream = new BufferedInputStream(e2.getInputStream());
                    } catch (Exception e3) {
                        e = e3;
                    }
                } catch (Throwable th) {
                    th = th;
                }
            } catch (Exception e4) {
                e = e4;
                e2 = 0;
            } catch (Throwable th2) {
                th = th2;
                e2 = 0;
            }
            try {
                byte[] bArr = new byte[1024];
                try {
                    do {
                        int read = bufferedInputStream.read(bArr);
                        if (read == -1) {
                            break;
                        }
                        j2 += read;
                    } while (j2 <= i2);
                    break;
                    bufferedInputStream.close();
                } catch (IOException unused) {
                }
                if (e2 != 0) {
                    e2.disconnect();
                    return true;
                }
                return true;
            } catch (Exception e5) {
                e = e5;
                bufferedInputStream2 = bufferedInputStream;
                com.kwad.sdk.core.d.a.b(e);
                com.kwad.sdk.core.d.a.a("HttpProxyCacheServer", "downloadUrlToStream file crash", e);
                if (bufferedInputStream2 != null) {
                    try {
                        bufferedInputStream2.close();
                    } catch (IOException unused2) {
                    }
                }
                if (e2 != 0) {
                    e2.disconnect();
                }
                return false;
            } catch (Throwable th3) {
                th = th3;
                bufferedInputStream2 = bufferedInputStream;
                if (bufferedInputStream2 != null) {
                    try {
                        bufferedInputStream2.close();
                    } catch (IOException unused3) {
                    }
                }
                if (e2 != 0) {
                    e2.disconnect();
                }
                throw th;
            }
        }
        return invokeLI.booleanValue;
    }

    public boolean b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            j.a(str, "Url can't be null!");
            return d(str).exists();
        }
        return invokeL.booleanValue;
    }

    public boolean c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            g gVar = this.f57900c.get(str);
            if (gVar != null) {
                gVar.a();
                this.f57900c.remove(str);
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public File d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            com.kwad.sdk.core.videocache.c cVar = this.f57904g;
            return new File(cVar.a, cVar.f57889b.a(str));
        }
        return (File) invokeL.objValue;
    }
}
