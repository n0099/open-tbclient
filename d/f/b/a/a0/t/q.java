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
    public final d.f.b.a.i0.s f69635a;

    /* renamed from: b  reason: collision with root package name */
    public final SparseArray<a> f69636b;

    /* renamed from: c  reason: collision with root package name */
    public final d.f.b.a.i0.l f69637c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f69638d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f69639e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f69640f;

    /* renamed from: g  reason: collision with root package name */
    public d.f.b.a.a0.g f69641g;

    /* loaded from: classes8.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final h f69642a;

        /* renamed from: b  reason: collision with root package name */
        public final d.f.b.a.i0.s f69643b;

        /* renamed from: c  reason: collision with root package name */
        public final d.f.b.a.i0.k f69644c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f69645d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f69646e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f69647f;

        /* renamed from: g  reason: collision with root package name */
        public int f69648g;

        /* renamed from: h  reason: collision with root package name */
        public long f69649h;

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
            this.f69642a = hVar;
            this.f69643b = sVar;
            this.f69644c = new d.f.b.a.i0.k(new byte[64]);
        }

        public void a(d.f.b.a.i0.l lVar) throws ParserException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, lVar) == null) {
                lVar.g(this.f69644c.f70485a, 0, 3);
                this.f69644c.l(0);
                b();
                lVar.g(this.f69644c.f70485a, 0, this.f69648g);
                this.f69644c.l(0);
                c();
                this.f69642a.e(this.f69649h, true);
                this.f69642a.c(lVar);
                this.f69642a.d();
            }
        }

        public final void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.f69644c.n(8);
                this.f69645d = this.f69644c.f();
                this.f69646e = this.f69644c.f();
                this.f69644c.n(6);
                this.f69648g = this.f69644c.g(8);
            }
        }

        public final void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                this.f69649h = 0L;
                if (this.f69645d) {
                    this.f69644c.n(4);
                    this.f69644c.n(1);
                    this.f69644c.n(1);
                    long g2 = (this.f69644c.g(3) << 30) | (this.f69644c.g(15) << 15) | this.f69644c.g(15);
                    this.f69644c.n(1);
                    if (!this.f69647f && this.f69646e) {
                        this.f69644c.n(4);
                        this.f69644c.n(1);
                        this.f69644c.n(1);
                        this.f69644c.n(1);
                        this.f69643b.b((this.f69644c.g(3) << 30) | (this.f69644c.g(15) << 15) | this.f69644c.g(15));
                        this.f69647f = true;
                    }
                    this.f69649h = this.f69643b.b(g2);
                }
            }
        }

        public void d() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                this.f69647f = false;
                this.f69642a.b();
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
            this.f69635a.g();
            for (int i2 = 0; i2 < this.f69636b.size(); i2++) {
                this.f69636b.valueAt(i2).d();
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
            if (fVar.d(this.f69637c.f70489a, 0, 4, true)) {
                this.f69637c.J(0);
                int i2 = this.f69637c.i();
                if (i2 == 441) {
                    return -1;
                }
                if (i2 == 442) {
                    fVar.c(this.f69637c.f70489a, 0, 10);
                    this.f69637c.J(9);
                    fVar.h((this.f69637c.x() & 7) + 14);
                    return 0;
                } else if (i2 == 443) {
                    fVar.c(this.f69637c.f70489a, 0, 2);
                    this.f69637c.J(0);
                    fVar.h(this.f69637c.D() + 6);
                    return 0;
                } else if (((i2 & (-256)) >> 8) != 1) {
                    fVar.h(1);
                    return 0;
                } else {
                    int i3 = i2 & 255;
                    a aVar = this.f69636b.get(i3);
                    if (!this.f69638d) {
                        if (aVar == null) {
                            h hVar = null;
                            if (!this.f69639e && i3 == 189) {
                                hVar = new b();
                                this.f69639e = true;
                            } else if (!this.f69639e && (i3 & 224) == 192) {
                                hVar = new n();
                                this.f69639e = true;
                            } else if (!this.f69640f && (i3 & 240) == 224) {
                                hVar = new i();
                                this.f69640f = true;
                            }
                            if (hVar != null) {
                                hVar.f(this.f69641g, new w.d(i3, 256));
                                aVar = new a(hVar, this.f69635a);
                                this.f69636b.put(i3, aVar);
                            }
                        }
                        if ((this.f69639e && this.f69640f) || fVar.getPosition() > 1048576) {
                            this.f69638d = true;
                            this.f69641g.j();
                        }
                    }
                    fVar.c(this.f69637c.f70489a, 0, 2);
                    this.f69637c.J(0);
                    int D = this.f69637c.D() + 6;
                    if (aVar == null) {
                        fVar.h(D);
                    } else {
                        this.f69637c.G(D);
                        fVar.readFully(this.f69637c.f70489a, 0, D);
                        this.f69637c.J(6);
                        aVar.a(this.f69637c);
                        d.f.b.a.i0.l lVar = this.f69637c;
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
            this.f69641g = gVar;
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
        this.f69635a = sVar;
        this.f69637c = new d.f.b.a.i0.l(4096);
        this.f69636b = new SparseArray<>();
    }
}
