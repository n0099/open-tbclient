package d.f.b.a.a0.t;

import android.util.SparseArray;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.ParserException;
import d.f.b.a.a0.l;
import d.f.b.a.a0.t.w;
import java.io.IOException;
/* loaded from: classes8.dex */
public final class q implements d.f.b.a.a0.e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final d.f.b.a.i0.s f70089a;

    /* renamed from: b  reason: collision with root package name */
    public final SparseArray<a> f70090b;

    /* renamed from: c  reason: collision with root package name */
    public final d.f.b.a.i0.l f70091c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f70092d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f70093e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f70094f;

    /* renamed from: g  reason: collision with root package name */
    public d.f.b.a.a0.g f70095g;

    /* loaded from: classes8.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final h f70096a;

        /* renamed from: b  reason: collision with root package name */
        public final d.f.b.a.i0.s f70097b;

        /* renamed from: c  reason: collision with root package name */
        public final d.f.b.a.i0.k f70098c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f70099d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f70100e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f70101f;

        /* renamed from: g  reason: collision with root package name */
        public int f70102g;

        /* renamed from: h  reason: collision with root package name */
        public long f70103h;

        public a(h hVar, d.f.b.a.i0.s sVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hVar, sVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f70096a = hVar;
            this.f70097b = sVar;
            this.f70098c = new d.f.b.a.i0.k(new byte[64]);
        }

        public void a(d.f.b.a.i0.l lVar) throws ParserException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, lVar) == null) {
                lVar.g(this.f70098c.f70939a, 0, 3);
                this.f70098c.l(0);
                b();
                lVar.g(this.f70098c.f70939a, 0, this.f70102g);
                this.f70098c.l(0);
                c();
                this.f70096a.e(this.f70103h, true);
                this.f70096a.c(lVar);
                this.f70096a.d();
            }
        }

        public final void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.f70098c.n(8);
                this.f70099d = this.f70098c.f();
                this.f70100e = this.f70098c.f();
                this.f70098c.n(6);
                this.f70102g = this.f70098c.g(8);
            }
        }

        public final void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                this.f70103h = 0L;
                if (this.f70099d) {
                    this.f70098c.n(4);
                    this.f70098c.n(1);
                    this.f70098c.n(1);
                    long g2 = (this.f70098c.g(3) << 30) | (this.f70098c.g(15) << 15) | this.f70098c.g(15);
                    this.f70098c.n(1);
                    if (!this.f70101f && this.f70100e) {
                        this.f70098c.n(4);
                        this.f70098c.n(1);
                        this.f70098c.n(1);
                        this.f70098c.n(1);
                        this.f70097b.b((this.f70098c.g(3) << 30) | (this.f70098c.g(15) << 15) | this.f70098c.g(15));
                        this.f70101f = true;
                    }
                    this.f70103h = this.f70097b.b(g2);
                }
            }
        }

        public void d() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                this.f70101f = false;
                this.f70096a.b();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1942729226, "Ld/f/b/a/a0/t/q;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1942729226, "Ld/f/b/a/a0/t/q;");
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public q() {
        this(new d.f.b.a.i0.s(0L));
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                this((d.f.b.a.i0.s) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    @Override // d.f.b.a.a0.e
    public void a(long j, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Long.valueOf(j), Long.valueOf(j2)}) == null) {
            this.f70089a.g();
            for (int i2 = 0; i2 < this.f70090b.size(); i2++) {
                this.f70090b.valueAt(i2).d();
            }
        }
    }

    @Override // d.f.b.a.a0.e
    public boolean d(d.f.b.a.a0.f fVar) throws IOException, InterruptedException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, fVar)) == null) {
            byte[] bArr = new byte[14];
            fVar.c(bArr, 0, 14);
            if (442 == (((bArr[0] & 255) << 24) | ((bArr[1] & 255) << 16) | ((bArr[2] & 255) << 8) | (bArr[3] & 255)) && (bArr[4] & 196) == 68 && (bArr[6] & 4) == 4 && (bArr[8] & 4) == 4 && (bArr[9] & 1) == 1 && (bArr[12] & 3) == 3) {
                fVar.g(bArr[13] & 7);
                fVar.c(bArr, 0, 3);
                return 1 == ((((bArr[0] & 255) << 16) | ((bArr[1] & 255) << 8)) | (bArr[2] & 255));
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // d.f.b.a.a0.e
    public int e(d.f.b.a.a0.f fVar, d.f.b.a.a0.k kVar) throws IOException, InterruptedException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, fVar, kVar)) == null) {
            if (fVar.d(this.f70091c.f70943a, 0, 4, true)) {
                this.f70091c.J(0);
                int i2 = this.f70091c.i();
                if (i2 == 441) {
                    return -1;
                }
                if (i2 == 442) {
                    fVar.c(this.f70091c.f70943a, 0, 10);
                    this.f70091c.J(9);
                    fVar.h((this.f70091c.x() & 7) + 14);
                    return 0;
                } else if (i2 == 443) {
                    fVar.c(this.f70091c.f70943a, 0, 2);
                    this.f70091c.J(0);
                    fVar.h(this.f70091c.D() + 6);
                    return 0;
                } else if (((i2 & (-256)) >> 8) != 1) {
                    fVar.h(1);
                    return 0;
                } else {
                    int i3 = i2 & 255;
                    a aVar = this.f70090b.get(i3);
                    if (!this.f70092d) {
                        if (aVar == null) {
                            h hVar = null;
                            if (!this.f70093e && i3 == 189) {
                                hVar = new b();
                                this.f70093e = true;
                            } else if (!this.f70093e && (i3 & 224) == 192) {
                                hVar = new n();
                                this.f70093e = true;
                            } else if (!this.f70094f && (i3 & 240) == 224) {
                                hVar = new i();
                                this.f70094f = true;
                            }
                            if (hVar != null) {
                                hVar.f(this.f70095g, new w.d(i3, 256));
                                aVar = new a(hVar, this.f70089a);
                                this.f70090b.put(i3, aVar);
                            }
                        }
                        if ((this.f70093e && this.f70094f) || fVar.getPosition() > 1048576) {
                            this.f70092d = true;
                            this.f70095g.j();
                        }
                    }
                    fVar.c(this.f70091c.f70943a, 0, 2);
                    this.f70091c.J(0);
                    int D = this.f70091c.D() + 6;
                    if (aVar == null) {
                        fVar.h(D);
                    } else {
                        this.f70091c.G(D);
                        fVar.readFully(this.f70091c.f70943a, 0, D);
                        this.f70091c.J(6);
                        aVar.a(this.f70091c);
                        d.f.b.a.i0.l lVar = this.f70091c;
                        lVar.I(lVar.b());
                    }
                    return 0;
                }
            }
            return -1;
        }
        return invokeLL.intValue;
    }

    @Override // d.f.b.a.a0.e
    public void f(d.f.b.a.a0.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, gVar) == null) {
            this.f70095g = gVar;
            gVar.p(new l.a(-9223372036854775807L));
        }
    }

    @Override // d.f.b.a.a0.e
    public void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
        }
    }

    public q(d.f.b.a.i0.s sVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {sVar};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.f70089a = sVar;
        this.f70091c = new d.f.b.a.i0.l(4096);
        this.f70090b = new SparseArray<>();
    }
}
