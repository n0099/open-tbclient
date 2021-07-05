package d.f.b.a.d0.w;

import android.os.Handler;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.upstream.Loader;
import d.f.b.a.d0.b;
import d.f.b.a.d0.n;
import d.f.b.a.d0.o;
import d.f.b.a.d0.p;
import d.f.b.a.d0.s;
import d.f.b.a.d0.t;
import d.f.b.a.d0.w.d;
import d.f.b.a.d0.w.o.a;
import d.f.b.a.i0.v;
import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;
/* loaded from: classes10.dex */
public final class l implements Loader.a<d.f.b.a.d0.u.c>, Loader.d, p, d.f.b.a.a0.g, n.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean[] A;
    public boolean[] B;
    public long C;
    public long D;
    public long E;
    public boolean F;
    public boolean G;
    public boolean H;

    /* renamed from: e  reason: collision with root package name */
    public final int f72931e;

    /* renamed from: f  reason: collision with root package name */
    public final b f72932f;

    /* renamed from: g  reason: collision with root package name */
    public final d f72933g;

    /* renamed from: h  reason: collision with root package name */
    public final d.f.b.a.h0.b f72934h;

    /* renamed from: i  reason: collision with root package name */
    public final Format f72935i;
    public final int j;
    public final Loader k;
    public final b.a l;
    public final d.b m;
    public final LinkedList<h> n;
    public final Runnable o;
    public final Handler p;
    public d.f.b.a.d0.n[] q;
    public int[] r;
    public boolean s;
    public boolean t;
    public int u;
    public Format v;
    public boolean w;
    public t x;
    public int y;
    public boolean z;

    /* loaded from: classes10.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ l f72936e;

        public a(l lVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f72936e = lVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f72936e.F();
            }
        }
    }

    /* loaded from: classes10.dex */
    public interface b extends p.a<l> {
        void i(a.C2011a c2011a);

        void onPrepared();
    }

    public l(int i2, b bVar, d dVar, d.f.b.a.h0.b bVar2, long j, Format format, int i3, b.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2), bVar, dVar, bVar2, Long.valueOf(j), format, Integer.valueOf(i3), aVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f72931e = i2;
        this.f72932f = bVar;
        this.f72933g = dVar;
        this.f72934h = bVar2;
        this.f72935i = format;
        this.j = i3;
        this.l = aVar;
        this.k = new Loader("Loader:HlsSampleStreamWrapper");
        this.m = new d.b();
        this.r = new int[0];
        this.q = new d.f.b.a.d0.n[0];
        this.n = new LinkedList<>();
        this.o = new a(this);
        this.p = new Handler();
        this.D = j;
        this.E = j;
    }

    public static String A(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) ? z(str, 2) : (String) invokeL.objValue;
    }

    public static Format v(Format format, Format format2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, format, format2)) == null) {
            if (format == null) {
                return format2;
            }
            String str = null;
            int d2 = d.f.b.a.i0.i.d(format2.sampleMimeType);
            if (d2 == 1) {
                str = y(format.codecs);
            } else if (d2 == 2) {
                str = A(format.codecs);
            }
            return format2.copyWithContainerInfo(format.id, str, format.bitrate, format.width, format.height, format.selectionFlags, format.language);
        }
        return (Format) invokeLL.objValue;
    }

    public static String y(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65540, null, str)) == null) ? z(str, 1) : (String) invokeL.objValue;
    }

    public static String z(String str, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(AdIconUtil.AD_TEXT_ID, null, str, i2)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            String[] split = str.split("(\\s*,\\s*)|(\\s*$)");
            StringBuilder sb = new StringBuilder();
            for (String str2 : split) {
                if (i2 == d.f.b.a.i0.i.e(str2)) {
                    if (sb.length() > 0) {
                        sb.append(",");
                    }
                    sb.append(str2);
                }
            }
            if (sb.length() > 0) {
                return sb.toString();
            }
            return null;
        }
        return (String) invokeLI.objValue;
    }

    public void B(int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)}) == null) {
            for (d.f.b.a.d0.n nVar : this.q) {
                nVar.F(i2);
            }
            if (z) {
                for (d.f.b.a.d0.n nVar2 : this.q) {
                    nVar2.G();
                }
            }
        }
    }

    public final boolean C(d.f.b.a.d0.u.c cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar)) == null) ? cVar instanceof h : invokeL.booleanValue;
    }

    public final boolean D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.E != -9223372036854775807L : invokeV.booleanValue;
    }

    public boolean E(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i2)) == null) ? this.H || (!D() && this.q[i2].s()) : invokeI.booleanValue;
    }

    public final void F() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || this.w || this.t || !this.s) {
            return;
        }
        for (d.f.b.a.d0.n nVar : this.q) {
            if (nVar.q() == null) {
                return;
            }
        }
        t();
        this.t = true;
        this.f72932f.onPrepared();
    }

    public void G() throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.k.a();
            this.f72933g.e();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.android.exoplayer2.upstream.Loader.a
    /* renamed from: H */
    public void l(d.f.b.a.d0.u.c cVar, long j, long j2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{cVar, Long.valueOf(j), Long.valueOf(j2), Boolean.valueOf(z)}) == null) {
            this.l.f(cVar.f72757a, cVar.f72758b, this.f72931e, cVar.f72759c, cVar.f72760d, cVar.f72761e, cVar.f72762f, cVar.f72763g, j, j2, cVar.d());
            if (z) {
                return;
            }
            O();
            if (this.u > 0) {
                this.f72932f.j(this);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.android.exoplayer2.upstream.Loader.a
    /* renamed from: I */
    public void m(d.f.b.a.d0.u.c cVar, long j, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{cVar, Long.valueOf(j), Long.valueOf(j2)}) == null) {
            this.f72933g.g(cVar);
            this.l.h(cVar.f72757a, cVar.f72758b, this.f72931e, cVar.f72759c, cVar.f72760d, cVar.f72761e, cVar.f72762f, cVar.f72763g, j, j2, cVar.d());
            if (!this.t) {
                b(this.D);
            } else {
                this.f72932f.j(this);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.android.exoplayer2.upstream.Loader.a
    /* renamed from: J */
    public int n(d.f.b.a.d0.u.c cVar, long j, long j2, IOException iOException) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{cVar, Long.valueOf(j), Long.valueOf(j2), iOException})) == null) {
            long d2 = cVar.d();
            boolean C = C(cVar);
            boolean z = true;
            if (!this.f72933g.h(cVar, !C || d2 == 0, iOException)) {
                z = false;
            } else if (C) {
                d.f.b.a.i0.a.f(this.n.removeLast() == cVar);
                if (this.n.isEmpty()) {
                    this.E = this.D;
                }
            }
            this.l.j(cVar.f72757a, cVar.f72758b, this.f72931e, cVar.f72759c, cVar.f72760d, cVar.f72761e, cVar.f72762f, cVar.f72763g, j, j2, cVar.d(), iOException, z);
            if (z) {
                if (!this.t) {
                    b(this.D);
                    return 2;
                }
                this.f72932f.j(this);
                return 2;
            }
            return 0;
        }
        return invokeCommon.intValue;
    }

    public void K(a.C2011a c2011a, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(1048585, this, c2011a, j) == null) {
            this.f72933g.i(c2011a, j);
        }
    }

    public void L(Format format) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, format) == null) {
            a(0, -1).b(format);
            this.s = true;
            F();
        }
    }

    public int M(int i2, d.f.b.a.l lVar, d.f.b.a.y.e eVar, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048587, this, new Object[]{Integer.valueOf(i2), lVar, eVar, Boolean.valueOf(z)})) == null) {
            if (D()) {
                return -3;
            }
            int w = this.q[i2].w(lVar, eVar, z, this.H, this.D);
            if (w == -4) {
                w();
            }
            return w;
        }
        return invokeCommon.intValue;
    }

    public void N() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            boolean j = this.k.j(this);
            if (this.t && !j) {
                for (d.f.b.a.d0.n nVar : this.q) {
                    nVar.k();
                }
            }
            this.p.removeCallbacksAndMessages(null);
            this.w = true;
        }
    }

    public final void O() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            for (d.f.b.a.d0.n nVar : this.q) {
                nVar.B(this.F);
            }
            this.F = false;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0028, code lost:
        return false;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean P(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeJ = interceptable.invokeJ(1048590, this, j)) != null) {
            return invokeJ.booleanValue;
        }
        int length = this.q.length;
        int i2 = 0;
        while (true) {
            if (i2 >= length) {
                return true;
            }
            d.f.b.a.d0.n nVar = this.q[i2];
            nVar.C();
            if ((nVar.f(j, true, false) != -1) || (!this.B[i2] && this.z)) {
                nVar.l();
                i2++;
            }
        }
    }

    public boolean Q(long j, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048591, this, new Object[]{Long.valueOf(j), Boolean.valueOf(z)})) == null) {
            this.D = j;
            if (z || D() || !P(j)) {
                this.E = j;
                this.H = false;
                this.n.clear();
                if (this.k.g()) {
                    this.k.f();
                    return true;
                }
                O();
                return true;
            }
            return false;
        }
        return invokeCommon.booleanValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:70:0x010e  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0117  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean R(d.f.b.a.f0.f[] fVarArr, boolean[] zArr, o[] oVarArr, boolean[] zArr2, long j, boolean z) {
        InterceptResult invokeCommon;
        boolean z2;
        boolean z3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048592, this, new Object[]{fVarArr, zArr, oVarArr, zArr2, Long.valueOf(j), Boolean.valueOf(z)})) == null) {
            d.f.b.a.i0.a.f(this.t);
            int i2 = this.u;
            int i3 = 0;
            for (int i4 = 0; i4 < fVarArr.length; i4++) {
                if (oVarArr[i4] != null && (fVarArr[i4] == null || !zArr[i4])) {
                    U(((k) oVarArr[i4]).f72929e, false);
                    oVarArr[i4] = null;
                }
            }
            boolean z4 = z || (!this.G ? j == this.D : i2 != 0);
            d.f.b.a.f0.f d2 = this.f72933g.d();
            boolean z5 = z4;
            d.f.b.a.f0.f fVar = d2;
            for (int i5 = 0; i5 < fVarArr.length; i5++) {
                if (oVarArr[i5] == null && fVarArr[i5] != null) {
                    d.f.b.a.f0.f fVar2 = fVarArr[i5];
                    int b2 = this.x.b(fVar2.d());
                    U(b2, true);
                    if (b2 == this.y) {
                        this.f72933g.l(fVar2);
                        fVar = fVar2;
                    }
                    oVarArr[i5] = new k(this, b2);
                    zArr2[i5] = true;
                    if (!z5) {
                        d.f.b.a.d0.n nVar = this.q[b2];
                        nVar.C();
                        z5 = nVar.f(j, true, true) == -1 && nVar.p() != 0;
                    }
                }
            }
            if (this.u == 0) {
                this.f72933g.j();
                this.v = null;
                this.n.clear();
                if (this.k.g()) {
                    d.f.b.a.d0.n[] nVarArr = this.q;
                    int length = nVarArr.length;
                    while (i3 < length) {
                        nVarArr[i3].k();
                        i3++;
                    }
                    this.k.f();
                } else {
                    O();
                }
            } else {
                if (!this.n.isEmpty() && !v.a(fVar, d2)) {
                    if (!this.G) {
                        fVar.i(j, j < 0 ? -j : 0L, -9223372036854775807L);
                        if (fVar.e() == this.f72933g.c().b(this.n.getLast().f72759c)) {
                            z3 = false;
                            if (z3) {
                                this.F = true;
                                z2 = true;
                                z5 = true;
                                if (z5) {
                                    Q(j, z2);
                                    while (i3 < oVarArr.length) {
                                        if (oVarArr[i3] != null) {
                                            zArr2[i3] = true;
                                        }
                                        i3++;
                                    }
                                }
                            }
                        }
                    }
                    z3 = true;
                    if (z3) {
                    }
                }
                z2 = z;
                if (z5) {
                }
            }
            this.G = true;
            return z5;
        }
        return invokeCommon.booleanValue;
    }

    public void S(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048593, this, z) == null) {
            this.f72933g.n(z);
        }
    }

    public void T(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048594, this, j) == null) {
            this.C = j;
            for (d.f.b.a.d0.n nVar : this.q) {
                nVar.D(j);
            }
        }
    }

    public final void U(int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048595, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)}) == null) {
            d.f.b.a.i0.a.f(this.A[i2] != z);
            this.A[i2] = z;
            this.u += z ? 1 : -1;
        }
    }

    public int V(int i2, long j) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048596, this, new Object[]{Integer.valueOf(i2), Long.valueOf(j)})) == null) {
            int i3 = 0;
            if (D()) {
                return 0;
            }
            d.f.b.a.d0.n nVar = this.q[i2];
            if (this.H && j > nVar.o()) {
                i3 = nVar.g();
            } else {
                int f2 = nVar.f(j, true, true);
                if (f2 != -1) {
                    i3 = f2;
                }
            }
            if (i3 > 0) {
                w();
            }
            return i3;
        }
        return invokeCommon.intValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.f.b.a.a0.g
    /* renamed from: W */
    public d.f.b.a.d0.n a(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048597, this, i2, i3)) == null) {
            int length = this.q.length;
            for (int i4 = 0; i4 < length; i4++) {
                if (this.r[i4] == i2) {
                    return this.q[i4];
                }
            }
            d.f.b.a.d0.n nVar = new d.f.b.a.d0.n(this.f72934h);
            nVar.D(this.C);
            nVar.E(this);
            int i5 = length + 1;
            int[] copyOf = Arrays.copyOf(this.r, i5);
            this.r = copyOf;
            copyOf[length] = i2;
            d.f.b.a.d0.n[] nVarArr = (d.f.b.a.d0.n[]) Arrays.copyOf(this.q, i5);
            this.q = nVarArr;
            nVarArr[length] = nVar;
            return nVar;
        }
        return (d.f.b.a.d0.n) invokeII.objValue;
    }

    @Override // d.f.b.a.d0.p
    public boolean b(long j) {
        InterceptResult invokeJ;
        h last;
        long j2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048599, this, j)) == null) {
            if (this.H || this.k.g()) {
                return false;
            }
            if (D()) {
                last = null;
                j2 = this.E;
            } else {
                last = this.n.getLast();
                j2 = last.f72763g;
            }
            this.f72933g.b(last, j, j2, this.m);
            d.b bVar = this.m;
            boolean z = bVar.f72915b;
            d.f.b.a.d0.u.c cVar = bVar.f72914a;
            a.C2011a c2011a = bVar.f72916c;
            bVar.a();
            if (z) {
                this.E = -9223372036854775807L;
                this.H = true;
                return true;
            } else if (cVar == null) {
                if (c2011a != null) {
                    this.f72932f.i(c2011a);
                }
                return false;
            } else {
                if (C(cVar)) {
                    this.E = -9223372036854775807L;
                    h hVar = (h) cVar;
                    hVar.i(this);
                    this.n.add(hVar);
                }
                this.l.l(cVar.f72757a, cVar.f72758b, this.f72931e, cVar.f72759c, cVar.f72760d, cVar.f72761e, cVar.f72762f, cVar.f72763g, this.k.k(cVar, this, this.j));
                return true;
            }
        }
        return invokeJ.booleanValue;
    }

    @Override // d.f.b.a.d0.p
    public long c() {
        InterceptResult invokeV;
        LinkedList<h> linkedList;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            if (this.H) {
                return Long.MIN_VALUE;
            }
            if (D()) {
                return this.E;
            }
            long j = this.D;
            h last = this.n.getLast();
            if (!last.g()) {
                last = this.n.size() > 1 ? this.n.get(linkedList.size() - 2) : null;
            }
            if (last != null) {
                j = Math.max(j, last.f72763g);
            }
            for (d.f.b.a.d0.n nVar : this.q) {
                j = Math.max(j, nVar.o());
            }
            return j;
        }
        return invokeV.longValue;
    }

    @Override // d.f.b.a.d0.p
    public long d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            if (D()) {
                return this.E;
            }
            if (this.H) {
                return Long.MIN_VALUE;
            }
            return this.n.getLast().f72763g;
        }
        return invokeV.longValue;
    }

    @Override // d.f.b.a.d0.n.b
    public void f(Format format) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, format) == null) {
            this.p.post(this.o);
        }
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.d
    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048603, this) == null) {
            O();
        }
    }

    @Override // d.f.b.a.a0.g
    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048604, this) == null) {
            this.s = true;
            this.p.post(this.o);
        }
    }

    public t k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) ? this.x : (t) invokeV.objValue;
    }

    @Override // d.f.b.a.a0.g
    public void p(d.f.b.a.a0.l lVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048609, this, lVar) == null) {
        }
    }

    public void q() throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048610, this) == null) {
            G();
        }
    }

    public void r(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048611, this, j) == null) {
            int length = this.q.length;
            for (int i2 = 0; i2 < length; i2++) {
                this.q[i2].j(j, false, this.A[i2]);
            }
        }
    }

    public final void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048612, this) == null) {
            int length = this.q.length;
            int i2 = 0;
            char c2 = 0;
            int i3 = -1;
            while (true) {
                char c3 = 3;
                if (i2 >= length) {
                    break;
                }
                String str = this.q[i2].q().sampleMimeType;
                if (!d.f.b.a.i0.i.i(str)) {
                    if (d.f.b.a.i0.i.g(str)) {
                        c3 = 2;
                    } else {
                        c3 = d.f.b.a.i0.i.h(str) ? (char) 1 : (char) 0;
                    }
                }
                if (c3 > c2) {
                    i3 = i2;
                    c2 = c3;
                } else if (c3 == c2 && i3 != -1) {
                    i3 = -1;
                }
                i2++;
            }
            s c4 = this.f72933g.c();
            int i4 = c4.f72748a;
            this.y = -1;
            this.A = new boolean[length];
            this.B = new boolean[length];
            s[] sVarArr = new s[length];
            for (int i5 = 0; i5 < length; i5++) {
                Format q = this.q[i5].q();
                String str2 = q.sampleMimeType;
                boolean z = d.f.b.a.i0.i.i(str2) || d.f.b.a.i0.i.g(str2);
                this.B[i5] = z;
                this.z = z | this.z;
                if (i5 == i3) {
                    Format[] formatArr = new Format[i4];
                    for (int i6 = 0; i6 < i4; i6++) {
                        formatArr[i6] = v(c4.a(i6), q);
                    }
                    sVarArr[i5] = new s(formatArr);
                    this.y = i5;
                } else {
                    sVarArr[i5] = new s(v((c2 == 3 && d.f.b.a.i0.i.g(q.sampleMimeType)) ? this.f72935i : null, q));
                }
            }
            this.x = new t(sVarArr);
        }
    }

    public void u() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048613, this) == null) || this.t) {
            return;
        }
        b(this.D);
    }

    public final void w() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048614, this) == null) || this.n.isEmpty()) {
            return;
        }
        while (this.n.size() > 1 && x(this.n.getFirst())) {
            this.n.removeFirst();
        }
        h first = this.n.getFirst();
        Format format = first.f72759c;
        if (!format.equals(this.v)) {
            this.l.e(this.f72931e, format, first.f72760d, first.f72761e, first.f72762f);
        }
        this.v = format;
    }

    public final boolean x(h hVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(1048615, this, hVar)) != null) {
            return invokeL.booleanValue;
        }
        int i2 = hVar.j;
        int i3 = 0;
        while (true) {
            d.f.b.a.d0.n[] nVarArr = this.q;
            if (i3 >= nVarArr.length) {
                return true;
            }
            if (this.A[i3] && nVarArr[i3].t() == i2) {
                return false;
            }
            i3++;
        }
    }
}
