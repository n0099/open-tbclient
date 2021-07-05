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
/* loaded from: classes10.dex */
public final class q implements d.f.b.a.a0.e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final d.f.b.a.i0.s f72532a;

    /* renamed from: b  reason: collision with root package name */
    public final SparseArray<a> f72533b;

    /* renamed from: c  reason: collision with root package name */
    public final d.f.b.a.i0.l f72534c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f72535d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f72536e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f72537f;

    /* renamed from: g  reason: collision with root package name */
    public d.f.b.a.a0.g f72538g;

    /* loaded from: classes10.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final h f72539a;

        /* renamed from: b  reason: collision with root package name */
        public final d.f.b.a.i0.s f72540b;

        /* renamed from: c  reason: collision with root package name */
        public final d.f.b.a.i0.k f72541c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f72542d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f72543e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f72544f;

        /* renamed from: g  reason: collision with root package name */
        public int f72545g;

        /* renamed from: h  reason: collision with root package name */
        public long f72546h;

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
            this.f72539a = hVar;
            this.f72540b = sVar;
            this.f72541c = new d.f.b.a.i0.k(new byte[64]);
        }

        public void a(d.f.b.a.i0.l lVar) throws ParserException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, lVar) == null) {
                lVar.g(this.f72541c.f73382a, 0, 3);
                this.f72541c.l(0);
                b();
                lVar.g(this.f72541c.f73382a, 0, this.f72545g);
                this.f72541c.l(0);
                c();
                this.f72539a.e(this.f72546h, true);
                this.f72539a.c(lVar);
                this.f72539a.d();
            }
        }

        public final void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.f72541c.n(8);
                this.f72542d = this.f72541c.f();
                this.f72543e = this.f72541c.f();
                this.f72541c.n(6);
                this.f72545g = this.f72541c.g(8);
            }
        }

        public final void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                this.f72546h = 0L;
                if (this.f72542d) {
                    this.f72541c.n(4);
                    this.f72541c.n(1);
                    this.f72541c.n(1);
                    long g2 = (this.f72541c.g(3) << 30) | (this.f72541c.g(15) << 15) | this.f72541c.g(15);
                    this.f72541c.n(1);
                    if (!this.f72544f && this.f72543e) {
                        this.f72541c.n(4);
                        this.f72541c.n(1);
                        this.f72541c.n(1);
                        this.f72541c.n(1);
                        this.f72540b.b((this.f72541c.g(3) << 30) | (this.f72541c.g(15) << 15) | this.f72541c.g(15));
                        this.f72544f = true;
                    }
                    this.f72546h = this.f72540b.b(g2);
                }
            }
        }

        public void d() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                this.f72544f = false;
                this.f72539a.b();
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
            this.f72532a.g();
            for (int i2 = 0; i2 < this.f72533b.size(); i2++) {
                this.f72533b.valueAt(i2).d();
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
            if (fVar.d(this.f72534c.f73386a, 0, 4, true)) {
                this.f72534c.J(0);
                int i2 = this.f72534c.i();
                if (i2 == 441) {
                    return -1;
                }
                if (i2 == 442) {
                    fVar.c(this.f72534c.f73386a, 0, 10);
                    this.f72534c.J(9);
                    fVar.h((this.f72534c.x() & 7) + 14);
                    return 0;
                } else if (i2 == 443) {
                    fVar.c(this.f72534c.f73386a, 0, 2);
                    this.f72534c.J(0);
                    fVar.h(this.f72534c.D() + 6);
                    return 0;
                } else if (((i2 & (-256)) >> 8) != 1) {
                    fVar.h(1);
                    return 0;
                } else {
                    int i3 = i2 & 255;
                    a aVar = this.f72533b.get(i3);
                    if (!this.f72535d) {
                        if (aVar == null) {
                            h hVar = null;
                            if (!this.f72536e && i3 == 189) {
                                hVar = new b();
                                this.f72536e = true;
                            } else if (!this.f72536e && (i3 & 224) == 192) {
                                hVar = new n();
                                this.f72536e = true;
                            } else if (!this.f72537f && (i3 & 240) == 224) {
                                hVar = new i();
                                this.f72537f = true;
                            }
                            if (hVar != null) {
                                hVar.f(this.f72538g, new w.d(i3, 256));
                                aVar = new a(hVar, this.f72532a);
                                this.f72533b.put(i3, aVar);
                            }
                        }
                        if ((this.f72536e && this.f72537f) || fVar.getPosition() > 1048576) {
                            this.f72535d = true;
                            this.f72538g.j();
                        }
                    }
                    fVar.c(this.f72534c.f73386a, 0, 2);
                    this.f72534c.J(0);
                    int D = this.f72534c.D() + 6;
                    if (aVar == null) {
                        fVar.h(D);
                    } else {
                        this.f72534c.G(D);
                        fVar.readFully(this.f72534c.f73386a, 0, D);
                        this.f72534c.J(6);
                        aVar.a(this.f72534c);
                        d.f.b.a.i0.l lVar = this.f72534c;
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
            this.f72538g = gVar;
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
        this.f72532a = sVar;
        this.f72534c = new d.f.b.a.i0.l(4096);
        this.f72533b = new SparseArray<>();
    }
}
