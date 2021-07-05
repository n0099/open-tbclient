package d.f.b.a.d0;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.Format;
import d.f.b.a.d0.k;
import java.io.IOException;
/* loaded from: classes10.dex */
public final class c implements k, k.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public final k f72651e;

    /* renamed from: f  reason: collision with root package name */
    public k.a f72652f;

    /* renamed from: g  reason: collision with root package name */
    public long f72653g;

    /* renamed from: h  reason: collision with root package name */
    public long f72654h;

    /* renamed from: i  reason: collision with root package name */
    public a[] f72655i;
    public boolean j;

    /* loaded from: classes10.dex */
    public static final class a implements o {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final k f72656e;

        /* renamed from: f  reason: collision with root package name */
        public final o f72657f;

        /* renamed from: g  reason: collision with root package name */
        public final long f72658g;

        /* renamed from: h  reason: collision with root package name */
        public final long f72659h;

        /* renamed from: i  reason: collision with root package name */
        public boolean f72660i;
        public boolean j;

        public a(k kVar, o oVar, long j, long j2, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kVar, oVar, Long.valueOf(j), Long.valueOf(j2), Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f72656e = kVar;
            this.f72657f = oVar;
            this.f72658g = j;
            this.f72659h = j2;
            this.f72660i = z;
        }

        @Override // d.f.b.a.d0.o
        public void a() throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f72657f.a();
            }
        }

        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.f72660i = false;
            }
        }

        public void d() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                this.j = false;
            }
        }

        @Override // d.f.b.a.d0.o
        public int f(d.f.b.a.l lVar, d.f.b.a.y.e eVar, boolean z) {
            InterceptResult invokeLLZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(1048579, this, lVar, eVar, z)) == null) {
                if (this.f72660i) {
                    return -3;
                }
                if (this.j) {
                    eVar.l(4);
                    return -4;
                }
                int f2 = this.f72657f.f(lVar, eVar, z);
                if (f2 == -5) {
                    Format format = lVar.f73492a;
                    lVar.f73492a = format.copyWithGaplessInfo(this.f72658g != 0 ? 0 : format.encoderDelay, this.f72659h == Long.MIN_VALUE ? format.encoderPadding : 0);
                    return -5;
                }
                long j = this.f72659h;
                if (j != Long.MIN_VALUE && ((f2 == -4 && eVar.f73653h >= j) || (f2 == -3 && this.f72656e.c() == Long.MIN_VALUE))) {
                    eVar.f();
                    eVar.l(4);
                    this.j = true;
                    return -4;
                }
                if (f2 == -4 && !eVar.j()) {
                    eVar.f73653h -= this.f72658g;
                }
                return f2;
            }
            return invokeLLZ.intValue;
        }

        @Override // d.f.b.a.d0.o
        public boolean isReady() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f72657f.isReady() : invokeV.booleanValue;
        }

        @Override // d.f.b.a.d0.o
        public int j(long j) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeJ = interceptable.invokeJ(1048581, this, j)) == null) ? this.f72657f.j(this.f72658g + j) : invokeJ.intValue;
        }
    }

    public c(k kVar, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {kVar, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f72651e = kVar;
        this.f72653g = -9223372036854775807L;
        this.f72654h = -9223372036854775807L;
        this.f72655i = new a[0];
        this.j = z;
    }

    public static boolean m(d.f.b.a.f0.f[] fVarArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, fVarArr)) == null) {
            for (d.f.b.a.f0.f fVar : fVarArr) {
                if (fVar != null && !d.f.b.a.i0.i.g(fVar.f().sampleMimeType)) {
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.f.b.a.d0.p.a
    /* renamed from: a */
    public void j(k kVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, kVar) == null) {
            this.f72652f.j(this);
        }
    }

    @Override // d.f.b.a.d0.k, d.f.b.a.d0.p
    public boolean b(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJ = interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j)) == null) ? this.f72651e.b(j + this.f72653g) : invokeJ.booleanValue;
    }

    @Override // d.f.b.a.d0.k, d.f.b.a.d0.p
    public long c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            long c2 = this.f72651e.c();
            if (c2 != Long.MIN_VALUE) {
                long j = this.f72654h;
                if (j == Long.MIN_VALUE || c2 < j) {
                    return Math.max(0L, c2 - this.f72653g);
                }
            }
            return Long.MIN_VALUE;
        }
        return invokeV.longValue;
    }

    @Override // d.f.b.a.d0.k, d.f.b.a.d0.p
    public long d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            long d2 = this.f72651e.d();
            if (d2 != Long.MIN_VALUE) {
                long j = this.f72654h;
                if (j == Long.MIN_VALUE || d2 < j) {
                    return d2 - this.f72653g;
                }
            }
            return Long.MIN_VALUE;
        }
        return invokeV.longValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x006c, code lost:
        if (r12 > r3) goto L30;
     */
    @Override // d.f.b.a.d0.k
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public long e(d.f.b.a.f0.f[] fVarArr, boolean[] zArr, o[] oVarArr, boolean[] zArr2, long j) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{fVarArr, zArr, oVarArr, zArr2, Long.valueOf(j)})) == null) {
            this.f72655i = new a[oVarArr.length];
            o[] oVarArr2 = new o[oVarArr.length];
            int i2 = 0;
            while (true) {
                o oVar = null;
                if (i2 >= oVarArr.length) {
                    break;
                }
                a[] aVarArr = this.f72655i;
                aVarArr[i2] = (a) oVarArr[i2];
                if (aVarArr[i2] != null) {
                    oVar = aVarArr[i2].f72657f;
                }
                oVarArr2[i2] = oVar;
                i2++;
            }
            long e2 = this.f72651e.e(fVarArr, zArr, oVarArr2, zArr2, j + this.f72653g);
            boolean z = true;
            if (this.j) {
                this.j = this.f72653g != 0 && m(fVarArr);
            }
            long j2 = this.f72653g;
            if (e2 != j + j2) {
                if (e2 >= j2) {
                    long j3 = this.f72654h;
                    if (j3 != Long.MIN_VALUE) {
                    }
                }
                z = false;
            }
            d.f.b.a.i0.a.f(z);
            for (int i3 = 0; i3 < oVarArr.length; i3++) {
                if (oVarArr2[i3] == null) {
                    this.f72655i[i3] = null;
                } else if (oVarArr[i3] == null || this.f72655i[i3].f72657f != oVarArr2[i3]) {
                    this.f72655i[i3] = new a(this, oVarArr2[i3], this.f72653g, this.f72654h, this.j);
                }
                oVarArr[i3] = this.f72655i[i3];
            }
            return e2 - this.f72653g;
        }
        return invokeCommon.longValue;
    }

    public void f(long j, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{Long.valueOf(j), Long.valueOf(j2)}) == null) {
            this.f72653g = j;
            this.f72654h = j2;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0033, code lost:
        if (r0 > r7) goto L20;
     */
    @Override // d.f.b.a.d0.k
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public long g(long j) {
        InterceptResult invokeJ;
        a[] aVarArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048582, this, j)) == null) {
            boolean z = false;
            for (a aVar : this.f72655i) {
                if (aVar != null) {
                    aVar.d();
                }
            }
            long g2 = this.f72651e.g(this.f72653g + j);
            long j2 = this.f72653g;
            if (g2 != j + j2) {
                if (g2 >= j2) {
                    long j3 = this.f72654h;
                    if (j3 != Long.MIN_VALUE) {
                    }
                }
                d.f.b.a.i0.a.f(z);
                return g2 - this.f72653g;
            }
            z = true;
            d.f.b.a.i0.a.f(z);
            return g2 - this.f72653g;
        }
        return invokeJ.longValue;
    }

    @Override // d.f.b.a.d0.k
    public long h() {
        InterceptResult invokeV;
        a[] aVarArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            boolean z = false;
            if (this.j) {
                for (a aVar : this.f72655i) {
                    if (aVar != null) {
                        aVar.c();
                    }
                }
                this.j = false;
                long h2 = h();
                if (h2 != -9223372036854775807L) {
                    return h2;
                }
                return 0L;
            }
            long h3 = this.f72651e.h();
            if (h3 == -9223372036854775807L) {
                return -9223372036854775807L;
            }
            d.f.b.a.i0.a.f(h3 >= this.f72653g);
            long j = this.f72654h;
            d.f.b.a.i0.a.f((j == Long.MIN_VALUE || h3 <= j) ? true : true);
            return h3 - this.f72653g;
        }
        return invokeV.longValue;
    }

    @Override // d.f.b.a.d0.k
    public t k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f72651e.k() : (t) invokeV.objValue;
    }

    @Override // d.f.b.a.d0.k.a
    public void l(k kVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, kVar) == null) {
            d.f.b.a.i0.a.f((this.f72653g == -9223372036854775807L || this.f72654h == -9223372036854775807L) ? false : true);
            this.f72652f.l(this);
        }
    }

    @Override // d.f.b.a.d0.k
    public void o(k.a aVar, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(1048587, this, aVar, j) == null) {
            this.f72652f = aVar;
            this.f72651e.o(this, this.f72653g + j);
        }
    }

    @Override // d.f.b.a.d0.k
    public void q() throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            this.f72651e.q();
        }
    }

    @Override // d.f.b.a.d0.k
    public void r(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048589, this, j) == null) {
            this.f72651e.r(j + this.f72653g);
        }
    }
}
