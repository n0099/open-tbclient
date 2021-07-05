package d.f.b.a.d0.u;

import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
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
import d.f.b.a.d0.u.g;
import java.io.IOException;
import java.util.Collections;
import java.util.LinkedList;
/* loaded from: classes10.dex */
public class f<T extends g> implements o, p, Loader.a<c>, Loader.d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public final int f72777e;

    /* renamed from: f  reason: collision with root package name */
    public final int[] f72778f;

    /* renamed from: g  reason: collision with root package name */
    public final boolean[] f72779g;

    /* renamed from: h  reason: collision with root package name */
    public final T f72780h;

    /* renamed from: i  reason: collision with root package name */
    public final p.a<f<T>> f72781i;
    public final b.a j;
    public final int k;
    public final Loader l;
    public final e m;
    public final LinkedList<d.f.b.a.d0.u.a> n;
    public final n o;
    public final n[] p;
    public final b q;
    public Format r;
    public long s;
    public long t;
    public boolean u;

    /* loaded from: classes10.dex */
    public final class a implements o {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final f<T> f72782e;

        /* renamed from: f  reason: collision with root package name */
        public final n f72783f;

        /* renamed from: g  reason: collision with root package name */
        public final int f72784g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ f f72785h;

        public a(f fVar, f<T> fVar2, n nVar, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar, fVar2, nVar, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f72785h = fVar;
            this.f72782e = fVar2;
            this.f72783f = nVar;
            this.f72784g = i2;
        }

        @Override // d.f.b.a.d0.o
        public void a() throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            }
        }

        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                d.f.b.a.i0.a.f(this.f72785h.f72779g[this.f72784g]);
                this.f72785h.f72779g[this.f72784g] = false;
            }
        }

        @Override // d.f.b.a.d0.o
        public int f(d.f.b.a.l lVar, d.f.b.a.y.e eVar, boolean z) {
            InterceptResult invokeLLZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(Constants.METHOD_SEND_USER_MSG, this, lVar, eVar, z)) == null) {
                if (this.f72785h.x()) {
                    return -3;
                }
                n nVar = this.f72783f;
                f fVar = this.f72785h;
                return nVar.w(lVar, eVar, z, fVar.u, fVar.t);
            }
            return invokeLLZ.intValue;
        }

        @Override // d.f.b.a.d0.o
        public boolean isReady() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                f fVar = this.f72785h;
                return fVar.u || (!fVar.x() && this.f72783f.s());
            }
            return invokeV.booleanValue;
        }

        @Override // d.f.b.a.d0.o
        public int j(long j) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJ = interceptable.invokeJ(1048580, this, j)) == null) {
                if (this.f72785h.u && j > this.f72783f.o()) {
                    return this.f72783f.g();
                }
                int f2 = this.f72783f.f(j, true, true);
                if (f2 == -1) {
                    return 0;
                }
                return f2;
            }
            return invokeJ.intValue;
        }
    }

    public f(int i2, int[] iArr, T t, p.a<f<T>> aVar, d.f.b.a.h0.b bVar, long j, int i3, b.a aVar2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2), iArr, t, aVar, bVar, Long.valueOf(j), Integer.valueOf(i3), aVar2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f72777e = i2;
        this.f72778f = iArr;
        this.f72780h = t;
        this.f72781i = aVar;
        this.j = aVar2;
        this.k = i3;
        this.l = new Loader("Loader:ChunkSampleStream");
        this.m = new e();
        LinkedList<d.f.b.a.d0.u.a> linkedList = new LinkedList<>();
        this.n = linkedList;
        Collections.unmodifiableList(linkedList);
        int i6 = 0;
        int length = iArr == null ? 0 : iArr.length;
        this.p = new n[length];
        this.f72779g = new boolean[length];
        int i7 = length + 1;
        int[] iArr2 = new int[i7];
        n[] nVarArr = new n[i7];
        n nVar = new n(bVar);
        this.o = nVar;
        iArr2[0] = i2;
        nVarArr[0] = nVar;
        while (i6 < length) {
            n nVar2 = new n(bVar);
            this.p[i6] = nVar2;
            int i8 = i6 + 1;
            nVarArr[i8] = nVar2;
            iArr2[i8] = iArr[i6];
            i6 = i8;
        }
        this.q = new b(iArr2, nVarArr);
        this.s = j;
        this.t = j;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0096  */
    /* JADX WARN: Removed duplicated region for block: B:39:? A[RETURN, SYNTHETIC] */
    @Override // com.google.android.exoplayer2.upstream.Loader.a
    /* renamed from: A */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int n(c cVar, long j, long j2, IOException iOException) {
        InterceptResult invokeCommon;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{cVar, Long.valueOf(j), Long.valueOf(j2), iOException})) != null) {
            return invokeCommon.intValue;
        }
        long d2 = cVar.d();
        boolean w = w(cVar);
        boolean z2 = (d2 != 0 && w && v()) ? false : true;
        if (this.f72780h.d(cVar, z2, iOException)) {
            if (!z2) {
                Log.w("ChunkSampleStream", "Ignoring attempt to cancel non-cancelable load.");
            } else {
                if (w) {
                    d.f.b.a.d0.u.a removeLast = this.n.removeLast();
                    d.f.b.a.i0.a.f(removeLast == cVar);
                    this.o.m(removeLast.h(0));
                    int i2 = 0;
                    while (true) {
                        n[] nVarArr = this.p;
                        if (i2 >= nVarArr.length) {
                            break;
                        }
                        n nVar = nVarArr[i2];
                        i2++;
                        nVar.m(removeLast.h(i2));
                    }
                    if (this.n.isEmpty()) {
                        this.s = this.t;
                    }
                }
                z = true;
                this.j.j(cVar.f72757a, cVar.f72758b, this.f72777e, cVar.f72759c, cVar.f72760d, cVar.f72761e, cVar.f72762f, cVar.f72763g, j, j2, d2, iOException, z);
                if (z) {
                    return 0;
                }
                this.f72781i.j(this);
                return 2;
            }
        }
        z = false;
        this.j.j(cVar.f72757a, cVar.f72758b, this.f72777e, cVar.f72759c, cVar.f72760d, cVar.f72761e, cVar.f72762f, cVar.f72763g, j, j2, d2, iOException, z);
        if (z) {
        }
    }

    public void B() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.l.j(this)) {
            return;
        }
        this.o.k();
        for (n nVar : this.p) {
            nVar.k();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0027  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0046  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void C(long j) {
        boolean z;
        n[] nVarArr;
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeJ(Constants.METHOD_SEND_USER_MSG, this, j) != null) {
            return;
        }
        this.t = j;
        if (!x()) {
            if (this.o.f(j, true, j < d()) != -1) {
                z = true;
                if (!z) {
                    s(this.o.p());
                    this.o.l();
                    for (n nVar : this.p) {
                        nVar.C();
                        nVar.j(j, true, false);
                    }
                    return;
                }
                this.s = j;
                this.u = false;
                this.n.clear();
                if (this.l.g()) {
                    this.l.f();
                    return;
                }
                this.o.A();
                for (n nVar2 : this.p) {
                    nVar2.A();
                }
                return;
            }
        }
        z = false;
        if (!z) {
        }
    }

    public f<T>.a D(long j, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Long.valueOf(j), Integer.valueOf(i2)})) == null) {
            for (int i3 = 0; i3 < this.p.length; i3++) {
                if (this.f72778f[i3] == i2) {
                    d.f.b.a.i0.a.f(!this.f72779g[i3]);
                    this.f72779g[i3] = true;
                    this.p[i3].C();
                    this.p[i3].f(j, true, true);
                    return new a(this, this, this.p[i3], i3);
                }
            }
            throw new IllegalStateException();
        }
        return (a) invokeCommon.objValue;
    }

    @Override // d.f.b.a.d0.o
    public void a() throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.l.a();
            if (this.l.g()) {
                return;
            }
            this.f72780h.a();
        }
    }

    @Override // d.f.b.a.d0.p
    public boolean b(long j) {
        InterceptResult invokeJ;
        d.f.b.a.d0.u.a last;
        long j2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048581, this, j)) == null) {
            if (this.u || this.l.g()) {
                return false;
            }
            if (x()) {
                last = null;
                j2 = this.s;
            } else {
                last = this.n.getLast();
                j2 = last.f72763g;
            }
            this.f72780h.f(last, j, j2, this.m);
            e eVar = this.m;
            boolean z = eVar.f72776b;
            c cVar = eVar.f72775a;
            eVar.a();
            if (z) {
                this.s = -9223372036854775807L;
                this.u = true;
                return true;
            } else if (cVar == null) {
                return false;
            } else {
                if (w(cVar)) {
                    this.s = -9223372036854775807L;
                    d.f.b.a.d0.u.a aVar = (d.f.b.a.d0.u.a) cVar;
                    aVar.j(this.q);
                    this.n.add(aVar);
                }
                this.j.l(cVar.f72757a, cVar.f72758b, this.f72777e, cVar.f72759c, cVar.f72760d, cVar.f72761e, cVar.f72762f, cVar.f72763g, this.l.k(cVar, this, this.k));
                return true;
            }
        }
        return invokeJ.booleanValue;
    }

    @Override // d.f.b.a.d0.p
    public long c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            if (this.u) {
                return Long.MIN_VALUE;
            }
            if (x()) {
                return this.s;
            }
            long j = this.t;
            d.f.b.a.d0.u.a last = this.n.getLast();
            if (!last.g()) {
                if (this.n.size() > 1) {
                    LinkedList<d.f.b.a.d0.u.a> linkedList = this.n;
                    last = linkedList.get(linkedList.size() - 2);
                } else {
                    last = null;
                }
            }
            if (last != null) {
                j = Math.max(j, last.f72763g);
            }
            return Math.max(j, this.o.o());
        }
        return invokeV.longValue;
    }

    @Override // d.f.b.a.d0.p
    public long d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            if (x()) {
                return this.s;
            }
            if (this.u) {
                return Long.MIN_VALUE;
            }
            return this.n.getLast().f72763g;
        }
        return invokeV.longValue;
    }

    @Override // d.f.b.a.d0.o
    public int f(d.f.b.a.l lVar, d.f.b.a.y.e eVar, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, lVar, eVar, z)) == null) {
            if (x()) {
                return -3;
            }
            s(this.o.p());
            int w = this.o.w(lVar, eVar, z, this.u, this.t);
            if (w == -4) {
                this.o.l();
            }
            return w;
        }
        return invokeLLZ.intValue;
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.d
    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.o.A();
            for (n nVar : this.p) {
                nVar.A();
            }
        }
    }

    @Override // d.f.b.a.d0.o
    public boolean isReady() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.u || (!x() && this.o.s()) : invokeV.booleanValue;
    }

    @Override // d.f.b.a.d0.o
    public int j(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048587, this, j)) == null) {
            int i2 = 0;
            if (x()) {
                return 0;
            }
            if (this.u && j > this.o.o()) {
                i2 = this.o.g();
            } else {
                int f2 = this.o.f(j, true, true);
                if (f2 != -1) {
                    i2 = f2;
                }
            }
            if (i2 > 0) {
                this.o.l();
            }
            return i2;
        }
        return invokeJ.intValue;
    }

    public final void s(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048591, this, i2) == null) || this.n.isEmpty()) {
            return;
        }
        while (this.n.size() > 1 && this.n.get(1).h(0) <= i2) {
            this.n.removeFirst();
        }
        d.f.b.a.d0.u.a first = this.n.getFirst();
        Format format = first.f72759c;
        if (!format.equals(this.r)) {
            this.j.e(this.f72777e, format, first.f72760d, first.f72761e, first.f72762f);
        }
        this.r = format;
    }

    public void t(long j) {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeJ(1048592, this, j) != null) {
            return;
        }
        int i2 = 0;
        while (true) {
            n[] nVarArr = this.p;
            if (i2 >= nVarArr.length) {
                return;
            }
            nVarArr[i2].j(j, true, this.f72779g[i2]);
            i2++;
        }
    }

    public T u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.f72780h : (T) invokeV.objValue;
    }

    public final boolean v() {
        InterceptResult invokeV;
        int p;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            d.f.b.a.d0.u.a last = this.n.getLast();
            if (this.o.p() > last.h(0)) {
                return true;
            }
            int i2 = 0;
            do {
                n[] nVarArr = this.p;
                if (i2 >= nVarArr.length) {
                    return false;
                }
                p = nVarArr[i2].p();
                i2++;
            } while (p <= last.h(i2));
            return true;
        }
        return invokeV.booleanValue;
    }

    public final boolean w(c cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048595, this, cVar)) == null) ? cVar instanceof d.f.b.a.d0.u.a : invokeL.booleanValue;
    }

    public boolean x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.s != -9223372036854775807L : invokeV.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.android.exoplayer2.upstream.Loader.a
    /* renamed from: y */
    public void l(c cVar, long j, long j2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048597, this, new Object[]{cVar, Long.valueOf(j), Long.valueOf(j2), Boolean.valueOf(z)}) == null) {
            this.j.f(cVar.f72757a, cVar.f72758b, this.f72777e, cVar.f72759c, cVar.f72760d, cVar.f72761e, cVar.f72762f, cVar.f72763g, j, j2, cVar.d());
            if (z) {
                return;
            }
            this.o.A();
            for (n nVar : this.p) {
                nVar.A();
            }
            this.f72781i.j(this);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.android.exoplayer2.upstream.Loader.a
    /* renamed from: z */
    public void m(c cVar, long j, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048598, this, new Object[]{cVar, Long.valueOf(j), Long.valueOf(j2)}) == null) {
            this.f72780h.c(cVar);
            this.j.h(cVar.f72757a, cVar.f72758b, this.f72777e, cVar.f72759c, cVar.f72760d, cVar.f72761e, cVar.f72762f, cVar.f72763g, j, j2, cVar.d());
            this.f72781i.j(this);
        }
    }
}
