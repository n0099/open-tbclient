package com.bytedance.sdk.openadsdk.n;

import android.os.SystemClock;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
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
import com.bytedance.sdk.openadsdk.n.b;
import com.bytedance.sdk.openadsdk.n.h;
import com.bytedance.sdk.openadsdk.n.i;
import com.bytedance.sdk.openadsdk.n.l;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.SocketTimeoutException;
/* loaded from: classes9.dex */
public class g extends com.bytedance.sdk.openadsdk.n.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Socket m;
    public final c n;
    public final d o;
    public volatile com.bytedance.sdk.openadsdk.n.b p;
    public volatile boolean q;

    /* loaded from: classes9.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final OutputStream f67912a;

        /* renamed from: b  reason: collision with root package name */
        public int f67913b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f67914c;

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
            this.f67912a = outputStream;
            this.f67913b = i2;
        }

        public boolean a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f67914c : invokeV.booleanValue;
        }

        public void b(byte[] bArr, int i2, int i3) throws com.bytedance.sdk.openadsdk.n.c.d {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(1048579, this, bArr, i2, i3) == null) {
                try {
                    this.f67912a.write(bArr, i2, i3);
                    this.f67913b += i3;
                } catch (IOException e2) {
                    throw new com.bytedance.sdk.openadsdk.n.c.d(e2);
                }
            }
        }

        public void a(byte[] bArr, int i2, int i3) throws com.bytedance.sdk.openadsdk.n.c.d {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLII(1048576, this, bArr, i2, i3) == null) || this.f67914c) {
                return;
            }
            try {
                this.f67912a.write(bArr, i2, i3);
                this.f67914c = true;
            } catch (IOException e2) {
                throw new com.bytedance.sdk.openadsdk.n.c.d(e2);
            }
        }

        public int b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f67913b : invokeV.intValue;
        }
    }

    /* loaded from: classes9.dex */
    public interface c {
        void a(g gVar);

        void b(g gVar);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(a aVar) {
        super(aVar.f67907a, aVar.f67908b);
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
                super((com.bytedance.sdk.openadsdk.n.a.a) objArr2[0], (com.bytedance.sdk.openadsdk.n.b.c) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.q = true;
        this.m = aVar.f67909c;
        this.n = aVar.f67910d;
        this.o = d.c();
    }

    private void a(boolean z, int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)}) == null) {
        }
    }

    private void b(b bVar, l.a aVar) throws IOException, com.bytedance.sdk.openadsdk.n.c.d, VAdError {
        byte[] a2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65543, this, bVar, aVar) == null) || (a2 = a(this.f67757b.a(this.f67763h, this.f67764i.f67928c.f67929a), bVar, aVar)) == null) {
            return;
        }
        bVar.a(a2, 0, a2.length);
    }

    private void c(b bVar, l.a aVar) throws h.a, com.bytedance.sdk.openadsdk.n.c.d, IOException, com.bytedance.sdk.openadsdk.n.c.a, com.bytedance.sdk.openadsdk.n.c.b, VAdError {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65544, this, bVar, aVar) == null) {
            if (this.q) {
                File c2 = this.f67756a.c(this.f67763h);
                long length = c2.length();
                com.bytedance.sdk.openadsdk.n.b.a a2 = this.f67757b.a(this.f67763h, this.f67764i.f67928c.f67929a);
                int b2 = bVar.b();
                long j2 = length - b2;
                int i2 = (int) j2;
                int i3 = a2 == null ? -1 : a2.f67790c;
                if (length > bVar.b()) {
                    if (e.f67842c) {
                        String str = "cache hit, remainSize: " + j2;
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

    /* JADX WARN: Removed duplicated region for block: B:102:0x019f A[EDGE_INSN: B:102:0x019f->B:71:0x019f ?: BREAK  , SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0102 A[Catch: all -> 0x01c4, TRY_LEAVE, TryCatch #3 {all -> 0x01c4, blocks: (B:31:0x00ed, B:38:0x00fe, B:40:0x0102, B:46:0x0144, B:50:0x0156, B:49:0x0154, B:37:0x00fa), top: B:93:0x00c8 }] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0152  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0154 A[Catch: all -> 0x01c4, TryCatch #3 {all -> 0x01c4, blocks: (B:31:0x00ed, B:38:0x00fe, B:40:0x0102, B:46:0x0144, B:50:0x0156, B:49:0x0154, B:37:0x00fa), top: B:93:0x00c8 }] */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0165 A[Catch: all -> 0x01c0, TryCatch #7 {all -> 0x01c0, blocks: (B:52:0x015f, B:54:0x0165, B:56:0x016a, B:69:0x0194, B:70:0x019b, B:71:0x019f, B:59:0x0170), top: B:100:0x015f }] */
    /* JADX WARN: Removed duplicated region for block: B:74:0x01ad  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void d(b bVar, l.a aVar) throws com.bytedance.sdk.openadsdk.n.c.d, IOException, com.bytedance.sdk.openadsdk.n.c.a, com.bytedance.sdk.openadsdk.n.c.b, VAdError {
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
        com.bytedance.sdk.openadsdk.n.e.a a2 = a(aVar, b2, this.f67764i.f67928c.f67933e, "GET");
        if (a2 == null) {
            return;
        }
        h hVar2 = null;
        int i3 = 0;
        try {
            String a3 = com.bytedance.sdk.openadsdk.n.g.d.a(a2, false, true);
            if (a3 == null) {
                com.bytedance.sdk.openadsdk.n.b.a a4 = this.f67757b.a(this.f67763h, f());
                int a5 = com.bytedance.sdk.openadsdk.n.g.d.a(a2);
                if (a4 != null && a4.f67790c != a5) {
                    if (e.f67842c) {
                        String str = "Content-Length not match, old: " + a4.f67790c + StringUtil.ARRAY_ELEMENT_SEPARATOR + a5 + ", key: " + this.f67763h;
                    }
                    throw new com.bytedance.sdk.openadsdk.n.c.b("Content-Length not match, old length: " + a4.f67790c + ", new length: " + a5 + ", rawKey: " + this.f67762g + ", currentUrl: " + aVar + ", previousInfo: " + a4.f67792e);
                }
                if (!bVar.a()) {
                    String a6 = com.bytedance.sdk.openadsdk.n.g.d.a(a2, b2);
                    e();
                    byte[] bytes = a6.getBytes(com.bytedance.sdk.openadsdk.n.g.d.f67922a);
                    bVar.a(bytes, 0, bytes.length);
                }
                e();
                File d3 = this.f67756a.d(this.f67763h);
                try {
                    if (this.q && d3 != null && d3.length() >= bVar.b()) {
                        com.bytedance.sdk.openadsdk.n.g.d.a(a2, this.f67757b, this.f67763h, this.f67764i.f67928c.f67929a);
                        try {
                            hVar = new h(d3, "rwd");
                            try {
                                hVar.a(bVar.b());
                            } catch (h.a e2) {
                                e = e2;
                                e.printStackTrace();
                                hVar = null;
                                if (e.f67842c) {
                                }
                                com.bytedance.sdk.openadsdk.n.b.a a7 = this.f67757b.a(this.f67763h, f());
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
                                        com.bytedance.sdk.openadsdk.n.g.d.a(a2.d());
                                        if (hVar2 != null) {
                                            hVar2.a();
                                        }
                                        this.f67758c.addAndGet(i3);
                                        this.f67759d.addAndGet(SystemClock.elapsedRealtime() - elapsedRealtime);
                                        throw th;
                                    }
                                }
                                boolean z = e.f67842c;
                                c();
                                com.bytedance.sdk.openadsdk.n.g.d.a(a2.d());
                                if (hVar != null) {
                                }
                                this.f67758c.addAndGet(i2);
                                this.f67759d.addAndGet(SystemClock.elapsedRealtime() - elapsedRealtime);
                            }
                        } catch (h.a e3) {
                            e = e3;
                        }
                        if (e.f67842c) {
                            String str2 = "can write to cache file in network task, cache file size: " + d3.length() + ", from: " + bVar.b();
                        }
                    } else {
                        if (e.f67842c) {
                            String str3 = "can't write to cache file in network task, cache file size: " + d3.length() + ", from: " + bVar.b();
                        }
                        hVar = null;
                    }
                    com.bytedance.sdk.openadsdk.n.b.a a72 = this.f67757b.a(this.f67763h, f());
                    int i4 = a72 != null ? 0 : a72.f67790c;
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
                    boolean z2 = e.f67842c;
                    c();
                    com.bytedance.sdk.openadsdk.n.g.d.a(a2.d());
                    if (hVar != null) {
                        hVar.a();
                    }
                    this.f67758c.addAndGet(i2);
                    this.f67759d.addAndGet(SystemClock.elapsedRealtime() - elapsedRealtime);
                } catch (Throwable th2) {
                    th = th2;
                    hVar2 = hVar;
                }
            } else {
                throw new com.bytedance.sdk.openadsdk.n.c.c(a3 + ", rawKey: " + this.f67762g + ", url: " + aVar);
            }
        } catch (Throwable th3) {
            th = th3;
        }
    }

    private b h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65546, this)) == null) {
            try {
                this.f67764i = i.a(this.m.getInputStream());
                OutputStream outputStream = this.m.getOutputStream();
                com.bytedance.sdk.openadsdk.n.a.a aVar = this.f67764i.f67928c.f67929a == 1 ? e.f67840a : e.f67841b;
                if (aVar == null) {
                    boolean z = e.f67842c;
                    return null;
                }
                this.f67756a = aVar;
                this.f67762g = this.f67764i.f67928c.f67930b;
                this.f67763h = this.f67764i.f67928c.f67931c;
                this.f67765j = new l(this.f67764i.f67928c.f67935g);
                this.f67761f = this.f67764i.f67927b;
                if (e.f67842c) {
                    String str = "request from MediaPlayer:    " + this.f67764i.toString();
                }
                return new b(outputStream, this.f67764i.f67928c.f67932d);
            } catch (i.d e2) {
                com.bytedance.sdk.openadsdk.n.g.d.a(this.m);
                if (e.f67842c) {
                    Log.getStackTraceString(e2);
                }
                a(this.f67756a == null ? null : Boolean.valueOf(g()), this.f67762g, e2);
                return null;
            } catch (IOException e3) {
                com.bytedance.sdk.openadsdk.n.g.d.a(this.m);
                if (e.f67842c) {
                    Log.getStackTraceString(e3);
                }
                a(this.f67756a == null ? null : Boolean.valueOf(g()), this.f67762g, e3);
                return null;
            }
        }
        return (b) invokeV.objValue;
    }

    private void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65547, this) == null) {
            com.bytedance.sdk.openadsdk.n.b bVar = this.p;
            this.p = null;
            if (bVar != null) {
                bVar.a();
            }
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        b h2;
        com.bytedance.sdk.openadsdk.n.b.a a2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (h2 = h()) == null) {
            return;
        }
        c cVar = this.n;
        if (cVar != null) {
            cVar.a(this);
        }
        this.f67756a.a(this.f67763h);
        if (e.f67847h != 0 && ((a2 = this.f67757b.a(this.f67763h, this.f67764i.f67928c.f67929a)) == null || this.f67756a.c(this.f67763h).length() < a2.f67790c)) {
            this.o.a(g(), this.f67763h);
        }
        try {
            a(h2);
        } catch (VAdError e2) {
            e2.printStackTrace();
        } catch (com.bytedance.sdk.openadsdk.n.c.a e3) {
            if (e.f67842c) {
                Log.getStackTraceString(e3);
            }
        } catch (Throwable th) {
            if (e.f67842c) {
                Log.getStackTraceString(th);
            }
        }
        this.f67756a.b(this.f67763h);
        this.o.a(g(), null);
        a();
        com.bytedance.sdk.openadsdk.n.g.d.a(this.m);
        c cVar2 = this.n;
        if (cVar2 != null) {
            cVar2.b(this);
        }
    }

    /* loaded from: classes9.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public com.bytedance.sdk.openadsdk.n.a.a f67907a;

        /* renamed from: b  reason: collision with root package name */
        public com.bytedance.sdk.openadsdk.n.b.c f67908b;

        /* renamed from: c  reason: collision with root package name */
        public Socket f67909c;

        /* renamed from: d  reason: collision with root package name */
        public c f67910d;

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

        public a a(com.bytedance.sdk.openadsdk.n.b.c cVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, cVar)) == null) {
                if (cVar != null) {
                    this.f67908b = cVar;
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
                    this.f67909c = socket;
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
                this.f67910d = cVar;
                return this;
            }
            return (a) invokeL.objValue;
        }

        public g a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                if (this.f67908b != null && this.f67909c != null) {
                    return new g(this);
                }
                throw new IllegalArgumentException();
            }
            return (g) invokeV.objValue;
        }
    }

    private boolean a(b bVar) throws com.bytedance.sdk.openadsdk.n.c.a, VAdError {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, this, bVar)) == null) {
            while (this.f67765j.a()) {
                e();
                l.a b2 = this.f67765j.b();
                try {
                    a(bVar, b2);
                    return true;
                } catch (com.bytedance.sdk.component.adnet.err.a e2) {
                    if (e.f67842c) {
                        Log.getStackTraceString(e2);
                    }
                } catch (com.bytedance.sdk.openadsdk.n.c.b e3) {
                    if (e.f67842c) {
                        Log.getStackTraceString(e3);
                    }
                    return false;
                } catch (com.bytedance.sdk.openadsdk.n.c.c e4) {
                    b2.a();
                    a(Boolean.valueOf(g()), this.f67762g, e4);
                } catch (com.bytedance.sdk.openadsdk.n.c.d e5) {
                    if (e.f67842c) {
                        Log.getStackTraceString(e5);
                    }
                    return true;
                } catch (h.a e6) {
                    if (e.f67842c) {
                        Log.getStackTraceString(e6);
                    }
                    this.q = false;
                    a(Boolean.valueOf(g()), this.f67762g, e6);
                } catch (IOException e7) {
                    if (e7 instanceof SocketTimeoutException) {
                        b2.b();
                    }
                    if (b()) {
                        if (e.f67842c && !ResponseException.CANCELED.equalsIgnoreCase(e7.getMessage())) {
                            Log.getStackTraceString(e7);
                        }
                    } else {
                        a(Boolean.valueOf(g()), this.f67762g, e7);
                    }
                } catch (Exception e8) {
                    if (e.f67842c) {
                        Log.getStackTraceString(e8);
                    }
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    private void a(b bVar, l.a aVar) throws com.bytedance.sdk.openadsdk.n.c.d, IOException, h.a, com.bytedance.sdk.openadsdk.n.c.a, com.bytedance.sdk.openadsdk.n.c.b, VAdError {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, this, bVar, aVar) == null) {
            if ("HEAD".equalsIgnoreCase(this.f67764i.f67926a.f67938a)) {
                b(bVar, aVar);
            } else {
                c(bVar, aVar);
            }
        }
    }

    private byte[] a(com.bytedance.sdk.openadsdk.n.b.a aVar, b bVar, l.a aVar2) throws IOException, VAdError {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(AdIconUtil.BAIDU_LOGO_ID, this, aVar, bVar, aVar2)) == null) {
            if (aVar != null) {
                boolean z = e.f67842c;
                return com.bytedance.sdk.openadsdk.n.g.d.a(aVar, bVar.b()).getBytes(com.bytedance.sdk.openadsdk.n.g.d.f67922a);
            }
            com.bytedance.sdk.openadsdk.n.e.a a2 = a(aVar2, 0, -1, "HEAD");
            if (a2 == null) {
                return null;
            }
            try {
                String a3 = com.bytedance.sdk.openadsdk.n.g.d.a(a2, false, false);
                if (a3 == null) {
                    com.bytedance.sdk.openadsdk.n.b.a a4 = com.bytedance.sdk.openadsdk.n.g.d.a(a2, this.f67757b, this.f67763h, this.f67764i.f67928c.f67929a);
                    boolean z2 = e.f67842c;
                    return com.bytedance.sdk.openadsdk.n.g.d.a(a4, bVar.b()).getBytes(com.bytedance.sdk.openadsdk.n.g.d.f67922a);
                }
                throw new com.bytedance.sdk.openadsdk.n.c.c(a3 + ", rawKey: " + this.f67762g + ", url: " + aVar2);
            } finally {
                com.bytedance.sdk.openadsdk.n.g.d.a(a2.d());
            }
        }
        return (byte[]) invokeLLL.objValue;
    }

    private void a(com.bytedance.sdk.openadsdk.n.b.a aVar, File file, b bVar, l.a aVar2) throws IOException, com.bytedance.sdk.openadsdk.n.c.d, h.a, com.bytedance.sdk.openadsdk.n.c.a, com.bytedance.sdk.openadsdk.n.c.b, VAdError {
        com.bytedance.sdk.component.d.f fVar;
        com.bytedance.sdk.openadsdk.n.b bVar2;
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
        if (aVar == null && (aVar = this.f67757b.a(this.f67763h, this.f67764i.f67928c.f67929a)) == null) {
            boolean z = e.f67842c;
            a((com.bytedance.sdk.openadsdk.n.b.a) null, bVar, aVar2);
            aVar = this.f67757b.a(this.f67763h, this.f67764i.f67928c.f67929a);
            if (aVar == null) {
                throw new com.bytedance.sdk.openadsdk.n.c.c("failed to get header, rawKey: " + this.f67762g + ", url: " + aVar2);
            }
        }
        if (file.length() >= aVar.f67790c || !((bVar2 = this.p) == null || bVar2.b() || bVar2.d())) {
            fVar = null;
        } else {
            com.bytedance.sdk.openadsdk.n.b a3 = new b.a().a(this.f67756a).a(this.f67757b).a(this.f67762g).b(this.f67763h).a(new l(aVar2.f67952a)).a(this.f67761f).a(this.f67764i).a(new b.InterfaceC1920b(this) { // from class: com.bytedance.sdk.openadsdk.n.g.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ g f67904a;

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
                    this.f67904a = this;
                }

                @Override // com.bytedance.sdk.openadsdk.n.b.InterfaceC1920b
                public void a(com.bytedance.sdk.openadsdk.n.b bVar3) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, bVar3) == null) {
                        this.f67904a.f67758c.addAndGet(bVar3.f67758c.get());
                        this.f67904a.f67759d.addAndGet(bVar3.f67759d.get());
                        synchronized (bVar3.m) {
                            bVar3.m.notifyAll();
                        }
                        if (bVar3.d()) {
                            this.f67904a.o.a(this.f67904a.g(), null);
                        }
                    }
                }
            }).a();
            this.p = a3;
            fVar = new com.bytedance.sdk.component.d.f(a3, null, 10, 1);
            com.bytedance.sdk.component.d.e.a(new com.bytedance.sdk.component.d.g(this, "processCacheNetWorkConcurrent", fVar) { // from class: com.bytedance.sdk.openadsdk.n.g.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ com.bytedance.sdk.component.d.f f67905a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ g f67906b;

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
                    this.f67906b = this;
                    this.f67905a = fVar;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.f67905a.run();
                    }
                }
            });
            boolean z2 = e.f67842c;
        }
        byte[] bArr = new byte[8192];
        try {
            h hVar2 = new h(file, r.f42062a);
            try {
                hVar2.a(bVar.b());
                int min = this.f67764i.f67928c.f67933e > 0 ? Math.min(aVar.f67790c, this.f67764i.f67928c.f67933e) : aVar.f67790c;
                while (bVar.b() < min) {
                    e();
                    int a4 = hVar2.a(bArr);
                    if (a4 <= 0) {
                        com.bytedance.sdk.openadsdk.n.b bVar3 = this.p;
                        if (bVar3 != null) {
                            com.bytedance.sdk.openadsdk.n.c.b i2 = bVar3.i();
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
                        boolean z3 = e.f67842c;
                        throw new com.bytedance.sdk.openadsdk.n.c.c("illegal state download task has finished, rawKey: " + this.f67762g + ", url: " + aVar2);
                    }
                    bVar.b(bArr, 0, a4);
                    e();
                }
                if (e.f67842c) {
                    String str = "read cache file complete: " + bVar.b() + StringUtil.ARRAY_ELEMENT_SEPARATOR + min;
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

    @Override // com.bytedance.sdk.openadsdk.n.a
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.a();
            i();
        }
    }
}
