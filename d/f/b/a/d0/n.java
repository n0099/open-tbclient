package d.f.b.a.d0;

import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.Format;
import d.f.b.a.a0.m;
import d.f.b.a.d0.m;
import java.io.EOFException;
import java.io.IOException;
import java.nio.ByteBuffer;
import kotlin.jvm.internal.ByteCompanionObject;
/* loaded from: classes8.dex */
public final class n implements d.f.b.a.a0.m {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final d.f.b.a.h0.b f69827a;

    /* renamed from: b  reason: collision with root package name */
    public final int f69828b;

    /* renamed from: c  reason: collision with root package name */
    public final m f69829c;

    /* renamed from: d  reason: collision with root package name */
    public final m.a f69830d;

    /* renamed from: e  reason: collision with root package name */
    public final d.f.b.a.i0.l f69831e;

    /* renamed from: f  reason: collision with root package name */
    public a f69832f;

    /* renamed from: g  reason: collision with root package name */
    public a f69833g;

    /* renamed from: h  reason: collision with root package name */
    public a f69834h;

    /* renamed from: i  reason: collision with root package name */
    public Format f69835i;
    public boolean j;
    public Format k;
    public long l;
    public long m;
    public boolean n;
    public b o;

    /* loaded from: classes8.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final long f69836a;

        /* renamed from: b  reason: collision with root package name */
        public final long f69837b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f69838c;
        @Nullable

        /* renamed from: d  reason: collision with root package name */
        public d.f.b.a.h0.a f69839d;
        @Nullable

        /* renamed from: e  reason: collision with root package name */
        public a f69840e;

        public a(long j, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Long.valueOf(j), Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f69836a = j;
            this.f69837b = j + i2;
        }

        public a a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                this.f69839d = null;
                a aVar = this.f69840e;
                this.f69840e = null;
                return aVar;
            }
            return (a) invokeV.objValue;
        }

        public void b(d.f.b.a.h0.a aVar, a aVar2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar, aVar2) == null) {
                this.f69839d = aVar;
                this.f69840e = aVar2;
                this.f69838c = true;
            }
        }

        public int c(long j) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeJ = interceptable.invokeJ(Constants.METHOD_SEND_USER_MSG, this, j)) == null) ? ((int) (j - this.f69836a)) + this.f69839d.f70374b : invokeJ.intValue;
        }
    }

    /* loaded from: classes8.dex */
    public interface b {
        void f(Format format);
    }

    public n(d.f.b.a.h0.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f69827a = bVar;
        this.f69828b = bVar.e();
        this.f69829c = new m();
        this.f69830d = new m.a();
        this.f69831e = new d.f.b.a.i0.l(32);
        a aVar = new a(0L, this.f69828b);
        this.f69832f = aVar;
        this.f69833g = aVar;
        this.f69834h = aVar;
    }

    public static Format n(Format format, long j) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(65537, null, format, j)) == null) {
            if (format == null) {
                return null;
            }
            if (j != 0) {
                long j2 = format.subsampleOffsetUs;
                return j2 != Long.MAX_VALUE ? format.copyWithSubsampleOffsetUs(j2 + j) : format;
            }
            return format;
        }
        return (Format) invokeLJ.objValue;
    }

    public void A() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            B(false);
        }
    }

    public void B(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            this.f69829c.v(z);
            h(this.f69832f);
            a aVar = new a(0L, this.f69828b);
            this.f69832f = aVar;
            this.f69833g = aVar;
            this.f69834h = aVar;
            this.m = 0L;
            this.f69827a.b();
        }
    }

    public void C() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f69829c.w();
            this.f69833g = this.f69832f;
        }
    }

    public void D(long j) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeJ(1048579, this, j) == null) || this.l == j) {
            return;
        }
        this.l = j;
        this.j = true;
    }

    public void E(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bVar) == null) {
            this.o = bVar;
        }
    }

    public void F(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i2) == null) {
            this.f69829c.x(i2);
        }
    }

    public void G() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.n = true;
        }
    }

    @Override // d.f.b.a.a0.m
    public void a(d.f.b.a.i0.l lVar, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048583, this, lVar, i2) == null) {
            while (i2 > 0) {
                int v = v(i2);
                a aVar = this.f69834h;
                lVar.g(aVar.f69839d.f70373a, aVar.c(this.m), v);
                i2 -= v;
                u(v);
            }
        }
    }

    @Override // d.f.b.a.a0.m
    public void b(Format format) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, format) == null) {
            Format n = n(format, this.l);
            boolean l = this.f69829c.l(n);
            this.k = format;
            this.j = false;
            b bVar = this.o;
            if (bVar == null || !l) {
                return;
            }
            bVar.f(n);
        }
    }

    @Override // d.f.b.a.a0.m
    public void c(long j, int i2, int i3, int i4, m.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048585, this, new Object[]{Long.valueOf(j), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), aVar}) == null) {
            if (this.j) {
                b(this.k);
            }
            if (this.n) {
                if ((i2 & 1) == 0 || !this.f69829c.c(j)) {
                    return;
                }
                this.n = false;
            }
            this.f69829c.d(j + this.l, i2, (this.m - i3) - i4, i3, aVar);
        }
    }

    @Override // d.f.b.a.a0.m
    public int d(d.f.b.a.a0.f fVar, int i2, boolean z) throws IOException, InterruptedException {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048586, this, new Object[]{fVar, Integer.valueOf(i2), Boolean.valueOf(z)})) == null) {
            int v = v(i2);
            a aVar = this.f69834h;
            int read = fVar.read(aVar.f69839d.f70373a, aVar.c(this.m), v);
            if (read != -1) {
                u(read);
                return read;
            } else if (z) {
                return -1;
            } else {
                throw new EOFException();
            }
        }
        return invokeCommon.intValue;
    }

    public final void e(long j) {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeJ(1048587, this, j) != null) {
            return;
        }
        while (true) {
            a aVar = this.f69833g;
            if (j < aVar.f69837b) {
                return;
            }
            this.f69833g = aVar.f69840e;
        }
    }

    public int f(long j, boolean z, boolean z2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048588, this, new Object[]{Long.valueOf(j), Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) ? this.f69829c.a(j, z, z2) : invokeCommon.intValue;
    }

    public int g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.f69829c.b() : invokeV.intValue;
    }

    public final void h(a aVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048590, this, aVar) == null) && aVar.f69838c) {
            a aVar2 = this.f69834h;
            int i2 = (aVar2.f69838c ? 1 : 0) + (((int) (aVar2.f69836a - aVar.f69836a)) / this.f69828b);
            d.f.b.a.h0.a[] aVarArr = new d.f.b.a.h0.a[i2];
            for (int i3 = 0; i3 < i2; i3++) {
                aVarArr[i3] = aVar.f69839d;
                aVar = aVar.a();
            }
            this.f69827a.d(aVarArr);
        }
    }

    public final void i(long j) {
        a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeJ(1048591, this, j) == null) || j == -1) {
            return;
        }
        while (true) {
            aVar = this.f69832f;
            if (j < aVar.f69837b) {
                break;
            }
            this.f69827a.a(aVar.f69839d);
            this.f69832f = this.f69832f.a();
        }
        if (this.f69833g.f69836a < aVar.f69836a) {
            this.f69833g = aVar;
        }
    }

    public void j(long j, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048592, this, new Object[]{Long.valueOf(j), Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            i(this.f69829c.g(j, z, z2));
        }
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            i(this.f69829c.h());
        }
    }

    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            i(this.f69829c.i());
        }
    }

    public void m(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048595, this, i2) == null) {
            long j = this.f69829c.j(i2);
            this.m = j;
            if (j != 0) {
                a aVar = this.f69832f;
                if (j != aVar.f69836a) {
                    while (this.m > aVar.f69837b) {
                        aVar = aVar.f69840e;
                    }
                    a aVar2 = aVar.f69840e;
                    h(aVar2);
                    a aVar3 = new a(aVar.f69837b, this.f69828b);
                    aVar.f69840e = aVar3;
                    if (this.m != aVar.f69837b) {
                        aVar3 = aVar;
                    }
                    this.f69834h = aVar3;
                    if (this.f69833g == aVar2) {
                        this.f69833g = aVar.f69840e;
                        return;
                    }
                    return;
                }
            }
            h(this.f69832f);
            a aVar4 = new a(this.m, this.f69828b);
            this.f69832f = aVar4;
            this.f69833g = aVar4;
            this.f69834h = aVar4;
        }
    }

    public long o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.f69829c.m() : invokeV.longValue;
    }

    public int p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? this.f69829c.o() : invokeV.intValue;
    }

    public Format q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? this.f69829c.q() : (Format) invokeV.objValue;
    }

    public int r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? this.f69829c.r() : invokeV.intValue;
    }

    public boolean s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? this.f69829c.s() : invokeV.booleanValue;
    }

    public int t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? this.f69829c.t() : invokeV.intValue;
    }

    public final void u(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048602, this, i2) == null) {
            long j = this.m + i2;
            this.m = j;
            a aVar = this.f69834h;
            if (j == aVar.f69837b) {
                this.f69834h = aVar.f69840e;
            }
        }
    }

    public final int v(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048603, this, i2)) == null) {
            a aVar = this.f69834h;
            if (!aVar.f69838c) {
                aVar.b(this.f69827a.c(), new a(this.f69834h.f69837b, this.f69828b));
            }
            return Math.min(i2, (int) (this.f69834h.f69837b - this.m));
        }
        return invokeI.intValue;
    }

    public int w(d.f.b.a.l lVar, d.f.b.a.y.e eVar, boolean z, boolean z2, long j) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048604, this, new Object[]{lVar, eVar, Boolean.valueOf(z), Boolean.valueOf(z2), Long.valueOf(j)})) == null) {
            int u = this.f69829c.u(lVar, eVar, z, z2, this.f69835i, this.f69830d);
            if (u == -5) {
                this.f69835i = lVar.f70595a;
                return -5;
            } else if (u != -4) {
                if (u == -3) {
                    return -3;
                }
                throw new IllegalStateException();
            } else {
                if (!eVar.j()) {
                    if (eVar.f70756h < j) {
                        eVar.e(Integer.MIN_VALUE);
                    }
                    if (eVar.p()) {
                        z(eVar, this.f69830d);
                    }
                    eVar.n(this.f69830d.f69824a);
                    m.a aVar = this.f69830d;
                    x(aVar.f69825b, eVar.f70755g, aVar.f69824a);
                }
                return -4;
            }
        }
        return invokeCommon.intValue;
    }

    public final void x(long j, ByteBuffer byteBuffer, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048605, this, new Object[]{Long.valueOf(j), byteBuffer, Integer.valueOf(i2)}) == null) {
            e(j);
            while (i2 > 0) {
                int min = Math.min(i2, (int) (this.f69833g.f69837b - j));
                a aVar = this.f69833g;
                byteBuffer.put(aVar.f69839d.f70373a, aVar.c(j), min);
                i2 -= min;
                j += min;
                a aVar2 = this.f69833g;
                if (j == aVar2.f69837b) {
                    this.f69833g = aVar2.f69840e;
                }
            }
        }
    }

    public final void y(long j, byte[] bArr, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048606, this, new Object[]{Long.valueOf(j), bArr, Integer.valueOf(i2)}) == null) {
            e(j);
            int i3 = i2;
            while (i3 > 0) {
                int min = Math.min(i3, (int) (this.f69833g.f69837b - j));
                a aVar = this.f69833g;
                System.arraycopy(aVar.f69839d.f70373a, aVar.c(j), bArr, i2 - i3, min);
                i3 -= min;
                j += min;
                a aVar2 = this.f69833g;
                if (j == aVar2.f69837b) {
                    this.f69833g = aVar2.f69840e;
                }
            }
        }
    }

    public final void z(d.f.b.a.y.e eVar, m.a aVar) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048607, this, eVar, aVar) == null) {
            long j = aVar.f69825b;
            this.f69831e.G(1);
            y(j, this.f69831e.f70489a, 1);
            long j2 = j + 1;
            byte b2 = this.f69831e.f70489a[0];
            boolean z = (b2 & ByteCompanionObject.MIN_VALUE) != 0;
            int i3 = b2 & ByteCompanionObject.MAX_VALUE;
            d.f.b.a.y.b bVar = eVar.f70754f;
            if (bVar.f70734a == null) {
                bVar.f70734a = new byte[16];
            }
            y(j2, eVar.f70754f.f70734a, i3);
            long j3 = j2 + i3;
            if (z) {
                this.f69831e.G(2);
                y(j3, this.f69831e.f70489a, 2);
                j3 += 2;
                i2 = this.f69831e.D();
            } else {
                i2 = 1;
            }
            int[] iArr = eVar.f70754f.f70737d;
            if (iArr == null || iArr.length < i2) {
                iArr = new int[i2];
            }
            int[] iArr2 = iArr;
            int[] iArr3 = eVar.f70754f.f70738e;
            if (iArr3 == null || iArr3.length < i2) {
                iArr3 = new int[i2];
            }
            int[] iArr4 = iArr3;
            if (z) {
                int i4 = i2 * 6;
                this.f69831e.G(i4);
                y(j3, this.f69831e.f70489a, i4);
                j3 += i4;
                this.f69831e.J(0);
                for (int i5 = 0; i5 < i2; i5++) {
                    iArr2[i5] = this.f69831e.D();
                    iArr4[i5] = this.f69831e.B();
                }
            } else {
                iArr2[0] = 0;
                iArr4[0] = aVar.f69824a - ((int) (j3 - aVar.f69825b));
            }
            m.a aVar2 = aVar.f69826c;
            d.f.b.a.y.b bVar2 = eVar.f70754f;
            bVar2.c(i2, iArr2, iArr4, aVar2.f69230b, bVar2.f70734a, aVar2.f69229a, aVar2.f69231c, aVar2.f69232d);
            long j4 = aVar.f69825b;
            int i6 = (int) (j3 - j4);
            aVar.f69825b = j4 + i6;
            aVar.f69824a -= i6;
        }
    }
}
