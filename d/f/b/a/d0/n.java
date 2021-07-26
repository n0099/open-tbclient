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
    public final d.f.b.a.h0.b f70281a;

    /* renamed from: b  reason: collision with root package name */
    public final int f70282b;

    /* renamed from: c  reason: collision with root package name */
    public final m f70283c;

    /* renamed from: d  reason: collision with root package name */
    public final m.a f70284d;

    /* renamed from: e  reason: collision with root package name */
    public final d.f.b.a.i0.l f70285e;

    /* renamed from: f  reason: collision with root package name */
    public a f70286f;

    /* renamed from: g  reason: collision with root package name */
    public a f70287g;

    /* renamed from: h  reason: collision with root package name */
    public a f70288h;

    /* renamed from: i  reason: collision with root package name */
    public Format f70289i;
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
        public final long f70290a;

        /* renamed from: b  reason: collision with root package name */
        public final long f70291b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f70292c;
        @Nullable

        /* renamed from: d  reason: collision with root package name */
        public d.f.b.a.h0.a f70293d;
        @Nullable

        /* renamed from: e  reason: collision with root package name */
        public a f70294e;

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
            this.f70290a = j;
            this.f70291b = j + i2;
        }

        public a a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                this.f70293d = null;
                a aVar = this.f70294e;
                this.f70294e = null;
                return aVar;
            }
            return (a) invokeV.objValue;
        }

        public void b(d.f.b.a.h0.a aVar, a aVar2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar, aVar2) == null) {
                this.f70293d = aVar;
                this.f70294e = aVar2;
                this.f70292c = true;
            }
        }

        public int c(long j) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeJ = interceptable.invokeJ(Constants.METHOD_SEND_USER_MSG, this, j)) == null) ? ((int) (j - this.f70290a)) + this.f70293d.f70828b : invokeJ.intValue;
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
        this.f70281a = bVar;
        this.f70282b = bVar.e();
        this.f70283c = new m();
        this.f70284d = new m.a();
        this.f70285e = new d.f.b.a.i0.l(32);
        a aVar = new a(0L, this.f70282b);
        this.f70286f = aVar;
        this.f70287g = aVar;
        this.f70288h = aVar;
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
            this.f70283c.v(z);
            h(this.f70286f);
            a aVar = new a(0L, this.f70282b);
            this.f70286f = aVar;
            this.f70287g = aVar;
            this.f70288h = aVar;
            this.m = 0L;
            this.f70281a.b();
        }
    }

    public void C() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f70283c.w();
            this.f70287g = this.f70286f;
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
            this.f70283c.x(i2);
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
                a aVar = this.f70288h;
                lVar.g(aVar.f70293d.f70827a, aVar.c(this.m), v);
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
            boolean l = this.f70283c.l(n);
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
                if ((i2 & 1) == 0 || !this.f70283c.c(j)) {
                    return;
                }
                this.n = false;
            }
            this.f70283c.d(j + this.l, i2, (this.m - i3) - i4, i3, aVar);
        }
    }

    @Override // d.f.b.a.a0.m
    public int d(d.f.b.a.a0.f fVar, int i2, boolean z) throws IOException, InterruptedException {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048586, this, new Object[]{fVar, Integer.valueOf(i2), Boolean.valueOf(z)})) == null) {
            int v = v(i2);
            a aVar = this.f70288h;
            int read = fVar.read(aVar.f70293d.f70827a, aVar.c(this.m), v);
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
            a aVar = this.f70287g;
            if (j < aVar.f70291b) {
                return;
            }
            this.f70287g = aVar.f70294e;
        }
    }

    public int f(long j, boolean z, boolean z2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048588, this, new Object[]{Long.valueOf(j), Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) ? this.f70283c.a(j, z, z2) : invokeCommon.intValue;
    }

    public int g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.f70283c.b() : invokeV.intValue;
    }

    public final void h(a aVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048590, this, aVar) == null) && aVar.f70292c) {
            a aVar2 = this.f70288h;
            int i2 = (aVar2.f70292c ? 1 : 0) + (((int) (aVar2.f70290a - aVar.f70290a)) / this.f70282b);
            d.f.b.a.h0.a[] aVarArr = new d.f.b.a.h0.a[i2];
            for (int i3 = 0; i3 < i2; i3++) {
                aVarArr[i3] = aVar.f70293d;
                aVar = aVar.a();
            }
            this.f70281a.d(aVarArr);
        }
    }

    public final void i(long j) {
        a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeJ(1048591, this, j) == null) || j == -1) {
            return;
        }
        while (true) {
            aVar = this.f70286f;
            if (j < aVar.f70291b) {
                break;
            }
            this.f70281a.a(aVar.f70293d);
            this.f70286f = this.f70286f.a();
        }
        if (this.f70287g.f70290a < aVar.f70290a) {
            this.f70287g = aVar;
        }
    }

    public void j(long j, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048592, this, new Object[]{Long.valueOf(j), Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            i(this.f70283c.g(j, z, z2));
        }
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            i(this.f70283c.h());
        }
    }

    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            i(this.f70283c.i());
        }
    }

    public void m(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048595, this, i2) == null) {
            long j = this.f70283c.j(i2);
            this.m = j;
            if (j != 0) {
                a aVar = this.f70286f;
                if (j != aVar.f70290a) {
                    while (this.m > aVar.f70291b) {
                        aVar = aVar.f70294e;
                    }
                    a aVar2 = aVar.f70294e;
                    h(aVar2);
                    a aVar3 = new a(aVar.f70291b, this.f70282b);
                    aVar.f70294e = aVar3;
                    if (this.m != aVar.f70291b) {
                        aVar3 = aVar;
                    }
                    this.f70288h = aVar3;
                    if (this.f70287g == aVar2) {
                        this.f70287g = aVar.f70294e;
                        return;
                    }
                    return;
                }
            }
            h(this.f70286f);
            a aVar4 = new a(this.m, this.f70282b);
            this.f70286f = aVar4;
            this.f70287g = aVar4;
            this.f70288h = aVar4;
        }
    }

    public long o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.f70283c.m() : invokeV.longValue;
    }

    public int p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? this.f70283c.o() : invokeV.intValue;
    }

    public Format q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? this.f70283c.q() : (Format) invokeV.objValue;
    }

    public int r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? this.f70283c.r() : invokeV.intValue;
    }

    public boolean s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? this.f70283c.s() : invokeV.booleanValue;
    }

    public int t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? this.f70283c.t() : invokeV.intValue;
    }

    public final void u(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048602, this, i2) == null) {
            long j = this.m + i2;
            this.m = j;
            a aVar = this.f70288h;
            if (j == aVar.f70291b) {
                this.f70288h = aVar.f70294e;
            }
        }
    }

    public final int v(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048603, this, i2)) == null) {
            a aVar = this.f70288h;
            if (!aVar.f70292c) {
                aVar.b(this.f70281a.c(), new a(this.f70288h.f70291b, this.f70282b));
            }
            return Math.min(i2, (int) (this.f70288h.f70291b - this.m));
        }
        return invokeI.intValue;
    }

    public int w(d.f.b.a.l lVar, d.f.b.a.y.e eVar, boolean z, boolean z2, long j) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048604, this, new Object[]{lVar, eVar, Boolean.valueOf(z), Boolean.valueOf(z2), Long.valueOf(j)})) == null) {
            int u = this.f70283c.u(lVar, eVar, z, z2, this.f70289i, this.f70284d);
            if (u == -5) {
                this.f70289i = lVar.f71049a;
                return -5;
            } else if (u != -4) {
                if (u == -3) {
                    return -3;
                }
                throw new IllegalStateException();
            } else {
                if (!eVar.j()) {
                    if (eVar.f71210h < j) {
                        eVar.e(Integer.MIN_VALUE);
                    }
                    if (eVar.p()) {
                        z(eVar, this.f70284d);
                    }
                    eVar.n(this.f70284d.f70278a);
                    m.a aVar = this.f70284d;
                    x(aVar.f70279b, eVar.f71209g, aVar.f70278a);
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
                int min = Math.min(i2, (int) (this.f70287g.f70291b - j));
                a aVar = this.f70287g;
                byteBuffer.put(aVar.f70293d.f70827a, aVar.c(j), min);
                i2 -= min;
                j += min;
                a aVar2 = this.f70287g;
                if (j == aVar2.f70291b) {
                    this.f70287g = aVar2.f70294e;
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
                int min = Math.min(i3, (int) (this.f70287g.f70291b - j));
                a aVar = this.f70287g;
                System.arraycopy(aVar.f70293d.f70827a, aVar.c(j), bArr, i2 - i3, min);
                i3 -= min;
                j += min;
                a aVar2 = this.f70287g;
                if (j == aVar2.f70291b) {
                    this.f70287g = aVar2.f70294e;
                }
            }
        }
    }

    public final void z(d.f.b.a.y.e eVar, m.a aVar) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048607, this, eVar, aVar) == null) {
            long j = aVar.f70279b;
            this.f70285e.G(1);
            y(j, this.f70285e.f70943a, 1);
            long j2 = j + 1;
            byte b2 = this.f70285e.f70943a[0];
            boolean z = (b2 & ByteCompanionObject.MIN_VALUE) != 0;
            int i3 = b2 & ByteCompanionObject.MAX_VALUE;
            d.f.b.a.y.b bVar = eVar.f71208f;
            if (bVar.f71188a == null) {
                bVar.f71188a = new byte[16];
            }
            y(j2, eVar.f71208f.f71188a, i3);
            long j3 = j2 + i3;
            if (z) {
                this.f70285e.G(2);
                y(j3, this.f70285e.f70943a, 2);
                j3 += 2;
                i2 = this.f70285e.D();
            } else {
                i2 = 1;
            }
            int[] iArr = eVar.f71208f.f71191d;
            if (iArr == null || iArr.length < i2) {
                iArr = new int[i2];
            }
            int[] iArr2 = iArr;
            int[] iArr3 = eVar.f71208f.f71192e;
            if (iArr3 == null || iArr3.length < i2) {
                iArr3 = new int[i2];
            }
            int[] iArr4 = iArr3;
            if (z) {
                int i4 = i2 * 6;
                this.f70285e.G(i4);
                y(j3, this.f70285e.f70943a, i4);
                j3 += i4;
                this.f70285e.J(0);
                for (int i5 = 0; i5 < i2; i5++) {
                    iArr2[i5] = this.f70285e.D();
                    iArr4[i5] = this.f70285e.B();
                }
            } else {
                iArr2[0] = 0;
                iArr4[0] = aVar.f70278a - ((int) (j3 - aVar.f70279b));
            }
            m.a aVar2 = aVar.f70280c;
            d.f.b.a.y.b bVar2 = eVar.f71208f;
            bVar2.c(i2, iArr2, iArr4, aVar2.f69684b, bVar2.f71188a, aVar2.f69683a, aVar2.f69685c, aVar2.f69686d);
            long j4 = aVar.f70279b;
            int i6 = (int) (j3 - j4);
            aVar.f70279b = j4 + i6;
            aVar.f70278a -= i6;
        }
    }
}
