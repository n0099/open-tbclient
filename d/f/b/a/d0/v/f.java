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
    public final n f69923a;

    /* renamed from: b  reason: collision with root package name */
    public final int[] f69924b;

    /* renamed from: c  reason: collision with root package name */
    public final d.f.b.a.f0.f f69925c;

    /* renamed from: d  reason: collision with root package name */
    public final int f69926d;

    /* renamed from: e  reason: collision with root package name */
    public final d.f.b.a.h0.e f69927e;

    /* renamed from: f  reason: collision with root package name */
    public final long f69928f;

    /* renamed from: g  reason: collision with root package name */
    public final int f69929g;

    /* renamed from: h  reason: collision with root package name */
    public final b[] f69930h;

    /* renamed from: i  reason: collision with root package name */
    public d.f.b.a.d0.v.g.b f69931i;
    public int j;
    public IOException k;
    public boolean l;
    public long m;

    /* loaded from: classes8.dex */
    public static final class a implements a.InterfaceC1978a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final e.a f69932a;

        /* renamed from: b  reason: collision with root package name */
        public final int f69933b;

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

        @Override // d.f.b.a.d0.v.a.InterfaceC1978a
        public d.f.b.a.d0.v.a a(n nVar, d.f.b.a.d0.v.g.b bVar, int i2, int[] iArr, d.f.b.a.f0.f fVar, int i3, long j, boolean z, boolean z2) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{nVar, bVar, Integer.valueOf(i2), iArr, fVar, Integer.valueOf(i3), Long.valueOf(j), Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) ? new f(nVar, bVar, i2, iArr, fVar, i3, this.f69932a.a(), j, this.f69933b, z, z2) : (d.f.b.a.d0.v.a) invokeCommon.objValue;
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
            this.f69932a = aVar;
            this.f69933b = i2;
        }
    }

    /* loaded from: classes8.dex */
    public static final class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final d.f.b.a.d0.u.d f69934a;

        /* renamed from: b  reason: collision with root package name */
        public g f69935b;

        /* renamed from: c  reason: collision with root package name */
        public d f69936c;

        /* renamed from: d  reason: collision with root package name */
        public long f69937d;

        /* renamed from: e  reason: collision with root package name */
        public int f69938e;

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
            this.f69937d = j;
            this.f69935b = gVar;
            String str = gVar.f69974a.containerMimeType;
            if (g(str)) {
                this.f69934a = null;
            } else {
                if ("application/x-rawcc".equals(str)) {
                    eVar = new d.f.b.a.a0.s.a(gVar.f69974a);
                } else if (h(str)) {
                    eVar = new d.f.b.a.a0.o.d(1);
                } else {
                    int i5 = z ? 4 : 0;
                    eVar = new d.f.b.a.a0.q.e(z2 ? i5 | 8 : i5);
                }
                this.f69934a = new d.f.b.a.d0.u.d(eVar, i2, gVar.f69974a);
            }
            this.f69936c = gVar.i();
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
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f69936c.d() + this.f69938e : invokeV.intValue;
        }

        public int b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f69936c.c(this.f69937d) : invokeV.intValue;
        }

        public long c(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) ? e(i2) + this.f69936c.a(i2 - this.f69938e, this.f69937d) : invokeI.longValue;
        }

        public int d(long j) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeJ = interceptable.invokeJ(1048579, this, j)) == null) ? this.f69936c.b(j, this.f69937d) + this.f69938e : invokeJ.intValue;
        }

        public long e(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i2)) == null) ? this.f69936c.f(i2 - this.f69938e) : invokeI.longValue;
        }

        public d.f.b.a.d0.v.g.f f(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i2)) == null) ? this.f69936c.e(i2 - this.f69938e) : (d.f.b.a.d0.v.g.f) invokeI.objValue;
        }

        public void i(long j, g gVar) throws BehindLiveWindowException {
            int c2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJL(1048582, this, j, gVar) == null) {
                d i2 = this.f69935b.i();
                d i3 = gVar.i();
                this.f69937d = j;
                this.f69935b = gVar;
                if (i2 == null) {
                    return;
                }
                this.f69936c = i3;
                if (i2.g() && (c2 = i2.c(this.f69937d)) != 0) {
                    int d2 = (i2.d() + c2) - 1;
                    long f2 = i2.f(d2) + i2.a(d2, this.f69937d);
                    int d3 = i3.d();
                    long f3 = i3.f(d3);
                    int i4 = (f2 > f3 ? 1 : (f2 == f3 ? 0 : -1));
                    if (i4 == 0) {
                        this.f69938e += (d2 + 1) - d3;
                    } else if (i4 >= 0) {
                        this.f69938e += i2.b(f3, this.f69937d) - d3;
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
        this.f69923a = nVar;
        this.f69931i = bVar;
        this.f69924b = iArr;
        this.f69925c = fVar;
        this.f69926d = i3;
        this.f69927e = eVar;
        this.j = i2;
        this.f69928f = j;
        this.f69929g = i4;
        long d2 = bVar.d(i2);
        this.m = -9223372036854775807L;
        ArrayList<g> h2 = h();
        this.f69930h = new b[fVar.length()];
        for (int i7 = 0; i7 < this.f69930h.length; i7++) {
            this.f69930h[i7] = new b(d2, i3, h2.get(fVar.b(i7)), z, z2);
        }
    }

    public static d.f.b.a.d0.u.c i(b bVar, d.f.b.a.h0.e eVar, Format format, int i2, Object obj, d.f.b.a.d0.v.g.f fVar, d.f.b.a.d0.v.g.f fVar2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{bVar, eVar, format, Integer.valueOf(i2), obj, fVar, fVar2})) == null) {
            String str = bVar.f69935b.f69975b;
            if (fVar == null || (fVar2 = fVar.a(fVar2, str)) != null) {
                fVar = fVar2;
            }
            return new k(eVar, new d.f.b.a.h0.g(fVar.b(str), fVar.f69970a, fVar.f69971b, bVar.f69935b.h()), format, i2, obj, bVar.f69934a);
        }
        return (d.f.b.a.d0.u.c) invokeCommon.objValue;
    }

    public static d.f.b.a.d0.u.c j(b bVar, d.f.b.a.h0.e eVar, int i2, Format format, int i3, Object obj, int i4, int i5) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, null, new Object[]{bVar, eVar, Integer.valueOf(i2), format, Integer.valueOf(i3), obj, Integer.valueOf(i4), Integer.valueOf(i5)})) == null) {
            g gVar = bVar.f69935b;
            long e2 = bVar.e(i4);
            d.f.b.a.d0.v.g.f f2 = bVar.f(i4);
            String str = gVar.f69975b;
            if (bVar.f69934a == null) {
                return new m(eVar, new d.f.b.a.h0.g(f2.b(str), f2.f69970a, f2.f69971b, gVar.h()), format, i3, obj, e2, bVar.c(i4), i4, i2, format);
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
            return new d.f.b.a.d0.u.i(eVar, new d.f.b.a.h0.g(f2.b(str), f2.f69970a, f2.f69971b, gVar.h()), format, i3, obj, e2, bVar.c((i4 + i7) - 1), i4, i7, -gVar.f69976c, bVar.f69934a);
        }
        return (d.f.b.a.d0.u.c) invokeCommon.objValue;
    }

    @Override // d.f.b.a.d0.u.g
    public void a() throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            IOException iOException = this.k;
            if (iOException == null) {
                this.f69923a.a();
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
            b bVar = this.f69930h[this.f69925c.k(((k) cVar).f69862c)];
            if (bVar.f69936c != null || (c2 = bVar.f69934a.c()) == null) {
                return;
            }
            bVar.f69936c = new e((d.f.b.a.a0.a) c2);
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
                if (!this.f69931i.f69946c && (cVar instanceof d.f.b.a.d0.u.l) && (exc instanceof HttpDataSource.InvalidResponseCodeException) && ((HttpDataSource.InvalidResponseCodeException) exc).responseCode == 404 && (b2 = (bVar = this.f69930h[this.f69925c.k(cVar.f69862c)]).b()) != -1 && b2 != 0 && ((d.f.b.a.d0.u.l) cVar).f() > (bVar.a() + b2) - 1) {
                    this.l = true;
                    return true;
                }
                d.f.b.a.f0.f fVar = this.f69925c;
                return h.a(fVar, fVar.k(cVar.f69862c), exc);
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
                this.f69931i = bVar;
                this.j = i2;
                long d2 = bVar.d(i2);
                ArrayList<g> h2 = h();
                for (int i3 = 0; i3 < this.f69930h.length; i3++) {
                    this.f69930h[i3].i(d2, h2.get(this.f69925c.b(i3)));
                }
            } catch (BehindLiveWindowException e2) {
                this.k = e2;
            }
        }
    }

    @Override // d.f.b.a.d0.u.g
    public void f(d.f.b.a.d0.u.l lVar, long j, long j2, d.f.b.a.d0.u.e eVar) {
        int i2;
        int f2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{lVar, Long.valueOf(j), Long.valueOf(j2), eVar}) == null) && this.k == null) {
            this.f69925c.i(j, j2 - j, k(j));
            b bVar = this.f69930h[this.f69925c.a()];
            d.f.b.a.d0.u.d dVar = bVar.f69934a;
            if (dVar != null) {
                g gVar = bVar.f69935b;
                d.f.b.a.d0.v.g.f k = dVar.b() == null ? gVar.k() : null;
                d.f.b.a.d0.v.g.f j3 = bVar.f69936c == null ? gVar.j() : null;
                if (k != null || j3 != null) {
                    eVar.f69878a = i(bVar, this.f69927e, this.f69925c.f(), this.f69925c.l(), this.f69925c.j(), k, j3);
                    return;
                }
            }
            int b2 = bVar.b();
            boolean z = false;
            if (b2 == 0) {
                d.f.b.a.d0.v.g.b bVar2 = this.f69931i;
                eVar.f69879b = (!bVar2.f69946c || this.j < bVar2.b() - 1) ? true : true;
                return;
            }
            int a2 = bVar.a();
            if (b2 == -1) {
                long g2 = (g() - d.f.b.a.b.a(this.f69931i.f69944a)) - d.f.b.a.b.a(this.f69931i.a(this.j).f69968b);
                long j4 = this.f69931i.f69948e;
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
                f2 = v.k(bVar.d(j2), a2, i3);
            } else {
                f2 = lVar.f();
                if (f2 < a2) {
                    this.k = new BehindLiveWindowException();
                    return;
                }
            }
            int i4 = f2;
            if (i4 <= i3 && (!this.l || i4 < i3)) {
                eVar.f69878a = j(bVar, this.f69927e, this.f69926d, this.f69925c.f(), this.f69925c.l(), this.f69925c.j(), i4, Math.min(this.f69929g, (i3 - i4) + 1));
                return;
            }
            d.f.b.a.d0.v.g.b bVar3 = this.f69931i;
            eVar.f69879b = (!bVar3.f69946c || this.j < bVar3.b() - 1) ? true : true;
        }
    }

    public final long g() {
        InterceptResult invokeV;
        long currentTimeMillis;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            if (this.f69928f != 0) {
                currentTimeMillis = SystemClock.elapsedRealtime() + this.f69928f;
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
            List<d.f.b.a.d0.v.g.a> list = this.f69931i.a(this.j).f69969c;
            ArrayList<g> arrayList = new ArrayList<>();
            for (int i2 : this.f69924b) {
                arrayList.addAll(list.get(i2).f69941c);
            }
            return arrayList;
        }
        return (ArrayList) invokeV.objValue;
    }

    public final long k(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048583, this, j)) == null) {
            if (this.f69931i.f69946c && this.m != -9223372036854775807L) {
                return this.m - j;
            }
            return -9223372036854775807L;
        }
        return invokeJ.longValue;
    }

    public final void l(b bVar, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(InputDeviceCompat.SOURCE_TOUCHPAD, this, bVar, i2) == null) {
            this.m = this.f69931i.f69946c ? bVar.c(i2) : -9223372036854775807L;
        }
    }
}
