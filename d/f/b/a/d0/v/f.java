package d.f.b.a.d0.v;

import android.os.SystemClock;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.source.BehindLiveWindowException;
import com.google.android.exoplayer2.upstream.HttpDataSource;
import d.f.b.a.a0.l;
import d.f.b.a.d0.u.h;
import d.f.b.a.d0.u.k;
import d.f.b.a.d0.u.m;
import d.f.b.a.d0.v.a;
import d.f.b.a.d0.v.g.g;
import d.f.b.a.h0.e;
import d.f.b.a.h0.n;
import d.f.b.a.i0.i;
import d.f.b.a.i0.v;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class f implements d.f.b.a.d0.v.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final n f70377a;

    /* renamed from: b  reason: collision with root package name */
    public final int[] f70378b;

    /* renamed from: c  reason: collision with root package name */
    public final d.f.b.a.f0.f f70379c;

    /* renamed from: d  reason: collision with root package name */
    public final int f70380d;

    /* renamed from: e  reason: collision with root package name */
    public final d.f.b.a.h0.e f70381e;

    /* renamed from: f  reason: collision with root package name */
    public final long f70382f;

    /* renamed from: g  reason: collision with root package name */
    public final int f70383g;

    /* renamed from: h  reason: collision with root package name */
    public final b[] f70384h;

    /* renamed from: i  reason: collision with root package name */
    public d.f.b.a.d0.v.g.b f70385i;
    public int j;
    public IOException k;
    public boolean l;
    public long m;

    /* loaded from: classes8.dex */
    public static final class a implements a.InterfaceC1977a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final e.a f70386a;

        /* renamed from: b  reason: collision with root package name */
        public final int f70387b;

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public a(e.a aVar) {
            this(aVar, 1);
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
                    this((e.a) objArr2[0], ((Integer) objArr2[1]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        @Override // d.f.b.a.d0.v.a.InterfaceC1977a
        public d.f.b.a.d0.v.a a(n nVar, d.f.b.a.d0.v.g.b bVar, int i2, int[] iArr, d.f.b.a.f0.f fVar, int i3, long j, boolean z, boolean z2) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{nVar, bVar, Integer.valueOf(i2), iArr, fVar, Integer.valueOf(i3), Long.valueOf(j), Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) ? new f(nVar, bVar, i2, iArr, fVar, i3, this.f70386a.a(), j, this.f70387b, z, z2) : (d.f.b.a.d0.v.a) invokeCommon.objValue;
        }

        public a(e.a aVar, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.f70386a = aVar;
            this.f70387b = i2;
        }
    }

    /* loaded from: classes8.dex */
    public static final class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final d.f.b.a.d0.u.d f70388a;

        /* renamed from: b  reason: collision with root package name */
        public g f70389b;

        /* renamed from: c  reason: collision with root package name */
        public d f70390c;

        /* renamed from: d  reason: collision with root package name */
        public long f70391d;

        /* renamed from: e  reason: collision with root package name */
        public int f70392e;

        public b(long j, int i2, g gVar, boolean z, boolean z2) {
            d.f.b.a.a0.e eVar;
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Long.valueOf(j), Integer.valueOf(i2), gVar, Boolean.valueOf(z), Boolean.valueOf(z2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f70391d = j;
            this.f70389b = gVar;
            String str = gVar.f70428a.containerMimeType;
            if (g(str)) {
                this.f70388a = null;
            } else {
                if ("application/x-rawcc".equals(str)) {
                    eVar = new d.f.b.a.a0.s.a(gVar.f70428a);
                } else if (h(str)) {
                    eVar = new d.f.b.a.a0.o.d(1);
                } else {
                    int i5 = z ? 4 : 0;
                    eVar = new d.f.b.a.a0.q.e(z2 ? i5 | 8 : i5);
                }
                this.f70388a = new d.f.b.a.d0.u.d(eVar, i2, gVar.f70428a);
            }
            this.f70390c = gVar.i();
        }

        public static boolean g(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) ? i.h(str) || "application/ttml+xml".equals(str) : invokeL.booleanValue;
        }

        public static boolean h(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? str.startsWith("video/webm") || str.startsWith("audio/webm") || str.startsWith("application/webm") : invokeL.booleanValue;
        }

        public int a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f70390c.d() + this.f70392e : invokeV.intValue;
        }

        public int b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f70390c.c(this.f70391d) : invokeV.intValue;
        }

        public long c(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) ? e(i2) + this.f70390c.a(i2 - this.f70392e, this.f70391d) : invokeI.longValue;
        }

        public int d(long j) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeJ = interceptable.invokeJ(1048579, this, j)) == null) ? this.f70390c.b(j, this.f70391d) + this.f70392e : invokeJ.intValue;
        }

        public long e(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i2)) == null) ? this.f70390c.f(i2 - this.f70392e) : invokeI.longValue;
        }

        public d.f.b.a.d0.v.g.f f(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i2)) == null) ? this.f70390c.e(i2 - this.f70392e) : (d.f.b.a.d0.v.g.f) invokeI.objValue;
        }

        public void i(long j, g gVar) throws BehindLiveWindowException {
            int c2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJL(1048582, this, j, gVar) == null) {
                d i2 = this.f70389b.i();
                d i3 = gVar.i();
                this.f70391d = j;
                this.f70389b = gVar;
                if (i2 == null) {
                    return;
                }
                this.f70390c = i3;
                if (i2.g() && (c2 = i2.c(this.f70391d)) != 0) {
                    int d2 = (i2.d() + c2) - 1;
                    long f2 = i2.f(d2) + i2.a(d2, this.f70391d);
                    int d3 = i3.d();
                    long f3 = i3.f(d3);
                    int i4 = (f2 > f3 ? 1 : (f2 == f3 ? 0 : -1));
                    if (i4 == 0) {
                        this.f70392e += (d2 + 1) - d3;
                    } else if (i4 >= 0) {
                        this.f70392e += i2.b(f3, this.f70391d) - d3;
                    } else {
                        throw new BehindLiveWindowException();
                    }
                }
            }
        }
    }

    public f(n nVar, d.f.b.a.d0.v.g.b bVar, int i2, int[] iArr, d.f.b.a.f0.f fVar, int i3, d.f.b.a.h0.e eVar, long j, int i4, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r3;
            Object[] objArr = {nVar, bVar, Integer.valueOf(i2), iArr, fVar, Integer.valueOf(i3), eVar, Long.valueOf(j), Integer.valueOf(i4), Boolean.valueOf(z), Boolean.valueOf(z2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i5 = newInitContext.flag;
            if ((i5 & 1) != 0) {
                int i6 = i5 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f70377a = nVar;
        this.f70385i = bVar;
        this.f70378b = iArr;
        this.f70379c = fVar;
        this.f70380d = i3;
        this.f70381e = eVar;
        this.j = i2;
        this.f70382f = j;
        this.f70383g = i4;
        long d2 = bVar.d(i2);
        this.m = -9223372036854775807L;
        ArrayList<g> h2 = h();
        this.f70384h = new b[fVar.length()];
        for (int i7 = 0; i7 < this.f70384h.length; i7++) {
            this.f70384h[i7] = new b(d2, i3, h2.get(fVar.b(i7)), z, z2);
        }
    }

    public static d.f.b.a.d0.u.c i(b bVar, d.f.b.a.h0.e eVar, Format format, int i2, Object obj, d.f.b.a.d0.v.g.f fVar, d.f.b.a.d0.v.g.f fVar2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{bVar, eVar, format, Integer.valueOf(i2), obj, fVar, fVar2})) == null) {
            String str = bVar.f70389b.f70429b;
            if (fVar == null || (fVar2 = fVar.a(fVar2, str)) != null) {
                fVar = fVar2;
            }
            return new k(eVar, new d.f.b.a.h0.g(fVar.b(str), fVar.f70424a, fVar.f70425b, bVar.f70389b.h()), format, i2, obj, bVar.f70388a);
        }
        return (d.f.b.a.d0.u.c) invokeCommon.objValue;
    }

    public static d.f.b.a.d0.u.c j(b bVar, d.f.b.a.h0.e eVar, int i2, Format format, int i3, Object obj, int i4, int i5) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, null, new Object[]{bVar, eVar, Integer.valueOf(i2), format, Integer.valueOf(i3), obj, Integer.valueOf(i4), Integer.valueOf(i5)})) == null) {
            g gVar = bVar.f70389b;
            long e2 = bVar.e(i4);
            d.f.b.a.d0.v.g.f f2 = bVar.f(i4);
            String str = gVar.f70429b;
            if (bVar.f70388a == null) {
                return new m(eVar, new d.f.b.a.h0.g(f2.b(str), f2.f70424a, f2.f70425b, gVar.h()), format, i3, obj, e2, bVar.c(i4), i4, i2, format);
            }
            int i6 = 1;
            int i7 = 1;
            while (i6 < i5) {
                d.f.b.a.d0.v.g.f a2 = f2.a(bVar.f(i4 + i6), str);
                if (a2 == null) {
                    break;
                }
                i7++;
                i6++;
                f2 = a2;
            }
            return new d.f.b.a.d0.u.i(eVar, new d.f.b.a.h0.g(f2.b(str), f2.f70424a, f2.f70425b, gVar.h()), format, i3, obj, e2, bVar.c((i4 + i7) - 1), i4, i7, -gVar.f70430c, bVar.f70388a);
        }
        return (d.f.b.a.d0.u.c) invokeCommon.objValue;
    }

    @Override // d.f.b.a.d0.u.g
    public void a() throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            IOException iOException = this.k;
            if (iOException == null) {
                this.f70377a.a();
                return;
            }
            throw iOException;
        }
    }

    @Override // d.f.b.a.d0.u.g
    public void c(d.f.b.a.d0.u.c cVar) {
        l c2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar) == null) && (cVar instanceof k)) {
            b bVar = this.f70384h[this.f70379c.k(((k) cVar).f70316c)];
            if (bVar.f70390c != null || (c2 = bVar.f70388a.c()) == null) {
                return;
            }
            bVar.f70390c = new e((d.f.b.a.a0.a) c2);
        }
    }

    @Override // d.f.b.a.d0.u.g
    public boolean d(d.f.b.a.d0.u.c cVar, boolean z, Exception exc) {
        InterceptResult invokeCommon;
        b bVar;
        int b2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{cVar, Boolean.valueOf(z), exc})) == null) {
            if (z) {
                if (!this.f70385i.f70400c && (cVar instanceof d.f.b.a.d0.u.l) && (exc instanceof HttpDataSource.InvalidResponseCodeException) && ((HttpDataSource.InvalidResponseCodeException) exc).responseCode == 404 && (b2 = (bVar = this.f70384h[this.f70379c.k(cVar.f70316c)]).b()) != -1 && b2 != 0 && ((d.f.b.a.d0.u.l) cVar).e() > (bVar.a() + b2) - 1) {
                    this.l = true;
                    return true;
                }
                d.f.b.a.f0.f fVar = this.f70379c;
                return h.a(fVar, fVar.k(cVar.f70316c), exc);
            }
            return false;
        }
        return invokeCommon.booleanValue;
    }

    @Override // d.f.b.a.d0.v.a
    public void e(d.f.b.a.d0.v.g.b bVar, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048579, this, bVar, i2) == null) {
            try {
                this.f70385i = bVar;
                this.j = i2;
                long d2 = bVar.d(i2);
                ArrayList<g> h2 = h();
                for (int i3 = 0; i3 < this.f70384h.length; i3++) {
                    this.f70384h[i3].i(d2, h2.get(this.f70379c.b(i3)));
                }
            } catch (BehindLiveWindowException e2) {
                this.k = e2;
            }
        }
    }

    @Override // d.f.b.a.d0.u.g
    public void f(d.f.b.a.d0.u.l lVar, long j, long j2, d.f.b.a.d0.u.e eVar) {
        int i2;
        int e2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{lVar, Long.valueOf(j), Long.valueOf(j2), eVar}) == null) && this.k == null) {
            this.f70379c.i(j, j2 - j, k(j));
            b bVar = this.f70384h[this.f70379c.a()];
            d.f.b.a.d0.u.d dVar = bVar.f70388a;
            if (dVar != null) {
                g gVar = bVar.f70389b;
                d.f.b.a.d0.v.g.f k = dVar.b() == null ? gVar.k() : null;
                d.f.b.a.d0.v.g.f j3 = bVar.f70390c == null ? gVar.j() : null;
                if (k != null || j3 != null) {
                    eVar.f70332a = i(bVar, this.f70381e, this.f70379c.f(), this.f70379c.l(), this.f70379c.j(), k, j3);
                    return;
                }
            }
            int b2 = bVar.b();
            boolean z = false;
            if (b2 == 0) {
                d.f.b.a.d0.v.g.b bVar2 = this.f70385i;
                eVar.f70333b = (!bVar2.f70400c || this.j < bVar2.b() - 1) ? true : true;
                return;
            }
            int a2 = bVar.a();
            if (b2 == -1) {
                long g2 = (g() - d.f.b.a.b.a(this.f70385i.f70398a)) - d.f.b.a.b.a(this.f70385i.a(this.j).f70422b);
                long j4 = this.f70385i.f70402e;
                if (j4 != -9223372036854775807L) {
                    a2 = Math.max(a2, bVar.d(g2 - d.f.b.a.b.a(j4)));
                }
                i2 = bVar.d(g2);
            } else {
                i2 = b2 + a2;
            }
            int i3 = i2 - 1;
            l(bVar, i3);
            if (lVar == null) {
                e2 = v.k(bVar.d(j2), a2, i3);
            } else {
                e2 = lVar.e();
                if (e2 < a2) {
                    this.k = new BehindLiveWindowException();
                    return;
                }
            }
            int i4 = e2;
            if (i4 <= i3 && (!this.l || i4 < i3)) {
                eVar.f70332a = j(bVar, this.f70381e, this.f70380d, this.f70379c.f(), this.f70379c.l(), this.f70379c.j(), i4, Math.min(this.f70383g, (i3 - i4) + 1));
                return;
            }
            d.f.b.a.d0.v.g.b bVar3 = this.f70385i;
            eVar.f70333b = (!bVar3.f70400c || this.j < bVar3.b() - 1) ? true : true;
        }
    }

    public final long g() {
        InterceptResult invokeV;
        long currentTimeMillis;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            if (this.f70382f != 0) {
                currentTimeMillis = SystemClock.elapsedRealtime() + this.f70382f;
            } else {
                currentTimeMillis = System.currentTimeMillis();
            }
            return currentTimeMillis * 1000;
        }
        return invokeV.longValue;
    }

    public final ArrayList<g> h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            List<d.f.b.a.d0.v.g.a> list = this.f70385i.a(this.j).f70423c;
            ArrayList<g> arrayList = new ArrayList<>();
            for (int i2 : this.f70378b) {
                arrayList.addAll(list.get(i2).f70395c);
            }
            return arrayList;
        }
        return (ArrayList) invokeV.objValue;
    }

    public final long k(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048583, this, j)) == null) {
            if (this.f70385i.f70400c && this.m != -9223372036854775807L) {
                return this.m - j;
            }
            return -9223372036854775807L;
        }
        return invokeJ.longValue;
    }

    public final void l(b bVar, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(InputDeviceCompat.SOURCE_TOUCHPAD, this, bVar, i2) == null) {
            this.m = this.f70385i.f70400c ? bVar.c(i2) : -9223372036854775807L;
        }
    }
}
