package com.bytedance.sdk.openadsdk.o;

import android.os.SystemClock;
import android.util.Log;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mapsdkplatform.comapi.map.r;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.searchbox.http.response.ResponseException;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.component.adnet.err.VAdError;
import com.bytedance.sdk.openadsdk.o.b;
import com.bytedance.sdk.openadsdk.o.h;
import com.bytedance.sdk.openadsdk.o.i;
import com.bytedance.sdk.openadsdk.o.l;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.SocketTimeoutException;
/* loaded from: classes6.dex */
public class g extends com.bytedance.sdk.openadsdk.o.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Socket m;
    public final c n;
    public final d o;
    public volatile com.bytedance.sdk.openadsdk.o.b p;
    public volatile boolean q;

    /* loaded from: classes6.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final OutputStream f31664a;

        /* renamed from: b  reason: collision with root package name */
        public int f31665b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f31666c;

        public b(OutputStream outputStream, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {outputStream, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f31664a = outputStream;
            this.f31665b = i2;
        }

        public boolean a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f31666c : invokeV.booleanValue;
        }

        public void b(byte[] bArr, int i2, int i3) throws com.bytedance.sdk.openadsdk.o.c.d {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(1048579, this, bArr, i2, i3) == null) {
                try {
                    this.f31664a.write(bArr, i2, i3);
                    this.f31665b += i3;
                } catch (IOException e2) {
                    throw new com.bytedance.sdk.openadsdk.o.c.d(e2);
                }
            }
        }

        public void a(byte[] bArr, int i2, int i3) throws com.bytedance.sdk.openadsdk.o.c.d {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLII(1048576, this, bArr, i2, i3) == null) || this.f31666c) {
                return;
            }
            try {
                this.f31664a.write(bArr, i2, i3);
                this.f31666c = true;
            } catch (IOException e2) {
                throw new com.bytedance.sdk.openadsdk.o.c.d(e2);
            }
        }

        public int b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f31665b : invokeV.intValue;
        }
    }

    /* loaded from: classes6.dex */
    public interface c {
        void a(g gVar);

        void b(g gVar);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(a aVar) {
        super(aVar.f31659a, aVar.f31660b);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {aVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((com.bytedance.sdk.openadsdk.o.a.a) objArr2[0], (com.bytedance.sdk.openadsdk.o.b.c) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.q = true;
        this.m = aVar.f31661c;
        this.n = aVar.f31662d;
        this.o = d.c();
    }

    private void a(boolean z, int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65540, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)}) == null) {
        }
    }

    private void b(b bVar, l.a aVar) throws IOException, com.bytedance.sdk.openadsdk.o.c.d, VAdError {
        byte[] a2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65543, this, bVar, aVar) == null) || (a2 = a(this.f31516b.a(this.f31522h, this.f31523i.f31680c.f31681a), bVar, aVar)) == null) {
            return;
        }
        bVar.a(a2, 0, a2.length);
    }

    private void c(b bVar, l.a aVar) throws h.a, com.bytedance.sdk.openadsdk.o.c.d, IOException, com.bytedance.sdk.openadsdk.o.c.a, com.bytedance.sdk.openadsdk.o.c.b, VAdError {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65544, this, bVar, aVar) == null) {
            if (this.q) {
                File c2 = this.f31515a.c(this.f31522h);
                long length = c2.length();
                com.bytedance.sdk.openadsdk.o.b.a a2 = this.f31516b.a(this.f31522h, this.f31523i.f31680c.f31681a);
                int b2 = bVar.b();
                long j = length - b2;
                int i2 = (int) j;
                int i3 = a2 == null ? -1 : a2.f31556c;
                if (length > bVar.b()) {
                    if (e.f31597c) {
                        Log.i("TAG_PROXY_ProxyTask", "cache hit, remainSize: " + j);
                    }
                    a(true, i2, i3, (int) length, b2);
                    a(a2, c2, bVar, aVar);
                    return;
                }
                a(false, i2, i3, (int) length, b2);
            } else {
                a(false, 0, 0, 0, bVar.b());
            }
            d(bVar, aVar);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:105:0x01b1 A[EDGE_INSN: B:105:0x01b1->B:72:0x01b1 ?: BREAK  , SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0108 A[Catch: all -> 0x01dd, TRY_LEAVE, TryCatch #6 {all -> 0x01dd, blocks: (B:32:0x00f3, B:39:0x0104, B:41:0x0108, B:47:0x0152, B:51:0x0164, B:50:0x0162, B:38:0x0100), top: B:98:0x00f3 }] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0160  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0162 A[Catch: all -> 0x01dd, TryCatch #6 {all -> 0x01dd, blocks: (B:32:0x00f3, B:39:0x0104, B:41:0x0108, B:47:0x0152, B:51:0x0164, B:50:0x0162, B:38:0x0100), top: B:98:0x00f3 }] */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0173 A[Catch: all -> 0x01d9, TryCatch #4 {all -> 0x01d9, blocks: (B:53:0x016d, B:55:0x0173, B:57:0x0178, B:70:0x01a6, B:71:0x01ad, B:72:0x01b1, B:74:0x01b5, B:75:0x01ba, B:60:0x017e), top: B:100:0x016d }] */
    /* JADX WARN: Removed duplicated region for block: B:74:0x01b5 A[Catch: all -> 0x01d9, TryCatch #4 {all -> 0x01d9, blocks: (B:53:0x016d, B:55:0x0173, B:57:0x0178, B:70:0x01a6, B:71:0x01ad, B:72:0x01b1, B:74:0x01b5, B:75:0x01ba, B:60:0x017e), top: B:100:0x016d }] */
    /* JADX WARN: Removed duplicated region for block: B:78:0x01c6  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x020c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void d(b bVar, l.a aVar) throws com.bytedance.sdk.openadsdk.o.c.d, IOException, com.bytedance.sdk.openadsdk.o.c.a, com.bytedance.sdk.openadsdk.o.c.b, VAdError {
        h hVar;
        byte[] bArr;
        InputStream d2;
        int i2;
        int read;
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeLL(65545, this, bVar, aVar) != null) {
            return;
        }
        i();
        long elapsedRealtime = SystemClock.elapsedRealtime();
        int b2 = bVar.b();
        com.bytedance.sdk.openadsdk.o.e.a a2 = a(aVar, b2, this.f31523i.f31680c.f31685e, "GET");
        if (a2 == null) {
            return;
        }
        h hVar2 = null;
        int i3 = 0;
        try {
            String a3 = com.bytedance.sdk.openadsdk.o.g.d.a(a2, false, true);
            if (a3 == null) {
                com.bytedance.sdk.openadsdk.o.b.a a4 = this.f31516b.a(this.f31522h, f());
                int a5 = com.bytedance.sdk.openadsdk.o.g.d.a(a2);
                if (a4 != null && a4.f31556c != a5) {
                    if (e.f31597c) {
                        Log.e("TAG_PROXY_ProxyTask", "Content-Length not match, old: " + a4.f31556c + StringUtil.ARRAY_ELEMENT_SEPARATOR + a5 + ", key: " + this.f31522h);
                    }
                    throw new com.bytedance.sdk.openadsdk.o.c.b("Content-Length not match, old length: " + a4.f31556c + ", new length: " + a5 + ", rawKey: " + this.f31521g + ", currentUrl: " + aVar + ", previousInfo: " + a4.f31558e);
                }
                if (!bVar.a()) {
                    String a6 = com.bytedance.sdk.openadsdk.o.g.d.a(a2, b2);
                    e();
                    byte[] bytes = a6.getBytes(com.bytedance.sdk.openadsdk.o.g.d.f31674a);
                    bVar.a(bytes, 0, bytes.length);
                }
                e();
                File d3 = this.f31515a.d(this.f31522h);
                if (this.q && d3 != null && d3.length() >= bVar.b()) {
                    com.bytedance.sdk.openadsdk.o.g.d.a(a2, this.f31516b, this.f31522h, this.f31523i.f31680c.f31681a);
                    try {
                        hVar = new h(d3, "rwd");
                    } catch (h.a e2) {
                        e = e2;
                    }
                    try {
                        try {
                            hVar.a(bVar.b());
                        } catch (h.a e3) {
                            e = e3;
                            e.printStackTrace();
                            hVar = null;
                            if (e.f31597c) {
                            }
                            com.bytedance.sdk.openadsdk.o.b.a a7 = this.f31516b.a(this.f31522h, f());
                            if (a7 != null) {
                            }
                            bArr = new byte[8192];
                            d2 = a2.d();
                            i2 = 0;
                            while (true) {
                                try {
                                    read = d2.read(bArr);
                                    if (read >= 0) {
                                    }
                                    e();
                                } catch (Throwable th) {
                                    th = th;
                                    hVar2 = hVar;
                                    i3 = i2;
                                    com.bytedance.sdk.openadsdk.o.g.d.a(a2.d());
                                    if (hVar2 != null) {
                                        hVar2.a();
                                    }
                                    this.f31517c.addAndGet(i3);
                                    this.f31518d.addAndGet(SystemClock.elapsedRealtime() - elapsedRealtime);
                                    throw th;
                                }
                            }
                            if (e.f31597c) {
                            }
                            c();
                            com.bytedance.sdk.openadsdk.o.g.d.a(a2.d());
                            if (hVar != null) {
                            }
                            this.f31517c.addAndGet(i2);
                            this.f31518d.addAndGet(SystemClock.elapsedRealtime() - elapsedRealtime);
                            return;
                        }
                        if (e.f31597c) {
                            Log.i("TAG_PROXY_ProxyTask", "can write to cache file in network task, cache file size: " + d3.length() + ", from: " + bVar.b());
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        hVar2 = hVar;
                        com.bytedance.sdk.openadsdk.o.g.d.a(a2.d());
                        if (hVar2 != null) {
                        }
                        this.f31517c.addAndGet(i3);
                        this.f31518d.addAndGet(SystemClock.elapsedRealtime() - elapsedRealtime);
                        throw th;
                    }
                } else {
                    if (e.f31597c) {
                        Log.w("TAG_PROXY_ProxyTask", "can't write to cache file in network task, cache file size: " + d3.length() + ", from: " + bVar.b());
                    }
                    hVar = null;
                }
                com.bytedance.sdk.openadsdk.o.b.a a72 = this.f31516b.a(this.f31522h, f());
                int i4 = a72 != null ? 0 : a72.f31556c;
                bArr = new byte[8192];
                d2 = a2.d();
                i2 = 0;
                while (true) {
                    read = d2.read(bArr);
                    if (read >= 0) {
                        break;
                    }
                    e();
                    if (read > 0) {
                        bVar.b(bArr, 0, read);
                        i2 += read;
                        if (hVar != null) {
                            hVar.a(bArr, 0, read);
                        }
                        a(i4, bVar.b());
                    }
                    e();
                }
                if (e.f31597c) {
                    Log.i("TAG_PROXY_ProxyTask", "read from net complete!");
                }
                c();
                com.bytedance.sdk.openadsdk.o.g.d.a(a2.d());
                if (hVar != null) {
                    hVar.a();
                }
                this.f31517c.addAndGet(i2);
                this.f31518d.addAndGet(SystemClock.elapsedRealtime() - elapsedRealtime);
                return;
            }
            throw new com.bytedance.sdk.openadsdk.o.c.c(a3 + ", rawKey: " + this.f31521g + ", url: " + aVar);
        } catch (Throwable th3) {
            th = th3;
        }
    }

    private b h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65546, this)) == null) {
            try {
                this.f31523i = i.a(this.m.getInputStream());
                OutputStream outputStream = this.m.getOutputStream();
                com.bytedance.sdk.openadsdk.o.a.a aVar = this.f31523i.f31680c.f31681a == 1 ? e.f31595a : e.f31596b;
                if (aVar == null) {
                    if (e.f31597c) {
                        Log.e("TAG_PROXY_ProxyTask", "cache is null");
                    }
                    return null;
                }
                this.f31515a = aVar;
                this.f31521g = this.f31523i.f31680c.f31682b;
                this.f31522h = this.f31523i.f31680c.f31683c;
                this.j = new l(this.f31523i.f31680c.f31687g);
                this.f31520f = this.f31523i.f31679b;
                if (e.f31597c) {
                    Log.i("TAG_PROXY_ProxyTask", "request from MediaPlayer:    " + this.f31523i.toString());
                }
                return new b(outputStream, this.f31523i.f31680c.f31684d);
            } catch (i.d e2) {
                com.bytedance.sdk.openadsdk.o.g.d.a(this.m);
                if (e.f31597c) {
                    Log.e("TAG_PROXY_ProxyTask", Log.getStackTraceString(e2));
                }
                a(this.f31515a == null ? null : Boolean.valueOf(g()), this.f31521g, e2);
                return null;
            } catch (IOException e3) {
                com.bytedance.sdk.openadsdk.o.g.d.a(this.m);
                if (e.f31597c) {
                    Log.e("TAG_PROXY_ProxyTask", Log.getStackTraceString(e3));
                }
                a(this.f31515a == null ? null : Boolean.valueOf(g()), this.f31521g, e3);
                return null;
            }
        }
        return (b) invokeV.objValue;
    }

    private void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65547, this) == null) {
            com.bytedance.sdk.openadsdk.o.b bVar = this.p;
            this.p = null;
            if (bVar != null) {
                bVar.a();
            }
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        b h2;
        com.bytedance.sdk.openadsdk.o.b.a a2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (h2 = h()) == null) {
            return;
        }
        c cVar = this.n;
        if (cVar != null) {
            cVar.a(this);
        }
        this.f31515a.a(this.f31522h);
        if (e.f31602h != 0 && ((a2 = this.f31516b.a(this.f31522h, this.f31523i.f31680c.f31681a)) == null || this.f31515a.c(this.f31522h).length() < a2.f31556c)) {
            this.o.a(g(), this.f31522h);
        }
        try {
            a(h2);
        } catch (VAdError e2) {
            e2.printStackTrace();
        } catch (com.bytedance.sdk.openadsdk.o.c.a e3) {
            if (e.f31597c) {
                Log.e("TAG_PROXY_ProxyTask", Log.getStackTraceString(e3));
            }
        } catch (Throwable th) {
            if (e.f31597c) {
                Log.e("TAG_PROXY_ProxyTask", Log.getStackTraceString(th));
            }
        }
        this.f31515a.b(this.f31522h);
        this.o.a(g(), null);
        a();
        com.bytedance.sdk.openadsdk.o.g.d.a(this.m);
        c cVar2 = this.n;
        if (cVar2 != null) {
            cVar2.b(this);
        }
    }

    /* loaded from: classes6.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public com.bytedance.sdk.openadsdk.o.a.a f31659a;

        /* renamed from: b  reason: collision with root package name */
        public com.bytedance.sdk.openadsdk.o.b.c f31660b;

        /* renamed from: c  reason: collision with root package name */
        public Socket f31661c;

        /* renamed from: d  reason: collision with root package name */
        public c f31662d;

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

        public a a(com.bytedance.sdk.openadsdk.o.b.c cVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, cVar)) == null) {
                if (cVar != null) {
                    this.f31660b = cVar;
                    return this;
                }
                throw new IllegalArgumentException("db == null");
            }
            return (a) invokeL.objValue;
        }

        public a a(Socket socket) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, socket)) == null) {
                if (socket != null) {
                    this.f31661c = socket;
                    return this;
                }
                throw new IllegalArgumentException("socket == null");
            }
            return (a) invokeL.objValue;
        }

        public a a(c cVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar)) == null) {
                this.f31662d = cVar;
                return this;
            }
            return (a) invokeL.objValue;
        }

        public g a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                if (this.f31660b != null && this.f31661c != null) {
                    return new g(this);
                }
                throw new IllegalArgumentException();
            }
            return (g) invokeV.objValue;
        }
    }

    private boolean a(b bVar) throws com.bytedance.sdk.openadsdk.o.c.a, VAdError {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, this, bVar)) == null) {
            while (this.j.a()) {
                e();
                l.a b2 = this.j.b();
                try {
                    a(bVar, b2);
                    return true;
                } catch (com.bytedance.sdk.component.adnet.err.a e2) {
                    if (e.f31597c) {
                        Log.e("TAG_PROXY_ProxyTask", Log.getStackTraceString(e2));
                    }
                } catch (com.bytedance.sdk.openadsdk.o.c.b e3) {
                    if (e.f31597c) {
                        Log.e("TAG_PROXY_ProxyTask", Log.getStackTraceString(e3));
                    }
                    return false;
                } catch (com.bytedance.sdk.openadsdk.o.c.c e4) {
                    b2.a();
                    a(Boolean.valueOf(g()), this.f31521g, e4);
                } catch (com.bytedance.sdk.openadsdk.o.c.d e5) {
                    if (e.f31597c) {
                        Log.e("TAG_PROXY_ProxyTask", Log.getStackTraceString(e5));
                    }
                    return true;
                } catch (h.a e6) {
                    if (e.f31597c) {
                        Log.e("TAG_PROXY_ProxyTask", Log.getStackTraceString(e6));
                    }
                    this.q = false;
                    a(Boolean.valueOf(g()), this.f31521g, e6);
                } catch (IOException e7) {
                    if (e7 instanceof SocketTimeoutException) {
                        b2.b();
                    }
                    if (b()) {
                        if (e.f31597c) {
                            if (ResponseException.CANCELED.equalsIgnoreCase(e7.getMessage())) {
                                Log.w("TAG_PROXY_ProxyTask", "okhttp call canceled");
                            } else {
                                Log.e("TAG_PROXY_ProxyTask", Log.getStackTraceString(e7));
                            }
                        }
                    } else {
                        a(Boolean.valueOf(g()), this.f31521g, e7);
                    }
                } catch (Exception e8) {
                    if (e.f31597c) {
                        Log.e("TAG_PROXY_ProxyTask", Log.getStackTraceString(e8));
                    }
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    private void a(b bVar, l.a aVar) throws com.bytedance.sdk.openadsdk.o.c.d, IOException, h.a, com.bytedance.sdk.openadsdk.o.c.a, com.bytedance.sdk.openadsdk.o.c.b, VAdError {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, this, bVar, aVar) == null) {
            if ("HEAD".equalsIgnoreCase(this.f31523i.f31678a.f31690a)) {
                b(bVar, aVar);
            } else {
                c(bVar, aVar);
            }
        }
    }

    private byte[] a(com.bytedance.sdk.openadsdk.o.b.a aVar, b bVar, l.a aVar2) throws IOException, VAdError {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(AdIconUtil.BAIDU_LOGO_ID, this, aVar, bVar, aVar2)) == null) {
            if (aVar != null) {
                if (e.f31597c) {
                    Log.i("TAG_PROXY_ProxyTask", "get header from db");
                }
                return com.bytedance.sdk.openadsdk.o.g.d.a(aVar, bVar.b()).getBytes(com.bytedance.sdk.openadsdk.o.g.d.f31674a);
            }
            com.bytedance.sdk.openadsdk.o.e.a a2 = a(aVar2, 0, -1, "HEAD");
            if (a2 == null) {
                return null;
            }
            try {
                String a3 = com.bytedance.sdk.openadsdk.o.g.d.a(a2, false, false);
                if (a3 == null) {
                    com.bytedance.sdk.openadsdk.o.b.a a4 = com.bytedance.sdk.openadsdk.o.g.d.a(a2, this.f31516b, this.f31522h, this.f31523i.f31680c.f31681a);
                    if (e.f31597c) {
                        Log.w("TAG_PROXY_ProxyTask", "get header from network");
                    }
                    return com.bytedance.sdk.openadsdk.o.g.d.a(a4, bVar.b()).getBytes(com.bytedance.sdk.openadsdk.o.g.d.f31674a);
                }
                throw new com.bytedance.sdk.openadsdk.o.c.c(a3 + ", rawKey: " + this.f31521g + ", url: " + aVar2);
            } finally {
                com.bytedance.sdk.openadsdk.o.g.d.a(a2.d());
            }
        }
        return (byte[]) invokeLLL.objValue;
    }

    private void a(com.bytedance.sdk.openadsdk.o.b.a aVar, File file, b bVar, l.a aVar2) throws IOException, com.bytedance.sdk.openadsdk.o.c.d, h.a, com.bytedance.sdk.openadsdk.o.c.a, com.bytedance.sdk.openadsdk.o.c.b, VAdError {
        com.bytedance.sdk.component.e.f fVar;
        com.bytedance.sdk.openadsdk.o.b bVar2;
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeLLLL(65538, this, aVar, file, bVar, aVar2) != null) {
            return;
        }
        if (!bVar.a()) {
            byte[] a2 = a(aVar, bVar, aVar2);
            e();
            if (a2 == null) {
                return;
            }
            bVar.a(a2, 0, a2.length);
        }
        h hVar = null;
        if (aVar == null && (aVar = this.f31516b.a(this.f31522h, this.f31523i.f31680c.f31681a)) == null) {
            if (e.f31597c) {
                Log.e("TAG_PROXY_ProxyTask", "failed to get video header info from db");
            }
            a((com.bytedance.sdk.openadsdk.o.b.a) null, bVar, aVar2);
            aVar = this.f31516b.a(this.f31522h, this.f31523i.f31680c.f31681a);
            if (aVar == null) {
                throw new com.bytedance.sdk.openadsdk.o.c.c("failed to get header, rawKey: " + this.f31521g + ", url: " + aVar2);
            }
        }
        if (file.length() >= aVar.f31556c || !((bVar2 = this.p) == null || bVar2.b() || bVar2.d())) {
            fVar = null;
        } else {
            com.bytedance.sdk.openadsdk.o.b a3 = new b.a().a(this.f31515a).a(this.f31516b).a(this.f31521g).b(this.f31522h).a(new l(aVar2.f31704a)).a(this.f31520f).a(this.f31523i).a(new b.InterfaceC0358b(this) { // from class: com.bytedance.sdk.openadsdk.o.g.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ g f31656a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f31656a = this;
                }

                @Override // com.bytedance.sdk.openadsdk.o.b.InterfaceC0358b
                public void a(com.bytedance.sdk.openadsdk.o.b bVar3) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, bVar3) == null) {
                        this.f31656a.f31517c.addAndGet(bVar3.f31517c.get());
                        this.f31656a.f31518d.addAndGet(bVar3.f31518d.get());
                        synchronized (bVar3.m) {
                            bVar3.m.notifyAll();
                        }
                        if (bVar3.d()) {
                            this.f31656a.o.a(this.f31656a.g(), null);
                        }
                    }
                }
            }).a();
            this.p = a3;
            fVar = new com.bytedance.sdk.component.e.f(a3, null, 10, 1);
            com.bytedance.sdk.component.e.e.a(new com.bytedance.sdk.component.e.g(this, "processCacheNetWorkConcurrent", fVar) { // from class: com.bytedance.sdk.openadsdk.o.g.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ com.bytedance.sdk.component.e.f f31657a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ g f31658b;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(r8);
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, r8, fVar};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            super((String) newInitContext.callArgs[0]);
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f31658b = this;
                    this.f31657a = fVar;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.f31657a.run();
                    }
                }
            });
            if (e.f31597c) {
                Log.e("TAG_PROXY_ProxyTask", "fire download in process cache task");
            }
        }
        byte[] bArr = new byte[8192];
        try {
            h hVar2 = new h(file, r.f7745a);
            try {
                hVar2.a(bVar.b());
                int min = this.f31523i.f31680c.f31685e > 0 ? Math.min(aVar.f31556c, this.f31523i.f31680c.f31685e) : aVar.f31556c;
                while (bVar.b() < min) {
                    e();
                    int a4 = hVar2.a(bArr);
                    if (a4 <= 0) {
                        com.bytedance.sdk.openadsdk.o.b bVar3 = this.p;
                        if (bVar3 != null) {
                            com.bytedance.sdk.openadsdk.o.c.b i2 = bVar3.i();
                            if (i2 == null) {
                                h.a h2 = bVar3.h();
                                if (h2 != null) {
                                    throw h2;
                                }
                            } else {
                                throw i2;
                            }
                        }
                        if (bVar3 != null && !bVar3.b() && !bVar3.d()) {
                            e();
                            synchronized (bVar3.m) {
                                try {
                                    bVar3.m.wait(1000L);
                                } catch (InterruptedException e2) {
                                    e2.printStackTrace();
                                }
                            }
                        }
                        if (e.f31597c) {
                            Log.e("TAG_PROXY_ProxyTask", "download task has finished!!!");
                        }
                        throw new com.bytedance.sdk.openadsdk.o.c.c("illegal state download task has finished, rawKey: " + this.f31521g + ", url: " + aVar2);
                    }
                    bVar.b(bArr, 0, a4);
                    e();
                }
                if (e.f31597c) {
                    Log.i("TAG_PROXY_ProxyTask", "read cache file complete: " + bVar.b() + StringUtil.ARRAY_ELEMENT_SEPARATOR + min);
                }
                c();
                hVar2.a();
                if (fVar != null) {
                    try {
                        fVar.get();
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                hVar = hVar2;
                if (hVar != null) {
                    hVar.a();
                }
                if (fVar != null) {
                    try {
                        fVar.get();
                    } catch (Throwable th3) {
                        th3.printStackTrace();
                    }
                }
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.o.a
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.a();
            i();
        }
    }
}
