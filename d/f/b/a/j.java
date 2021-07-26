package d.f.b.a;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.os.SystemClock;
import android.util.Log;
import android.util.Pair;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.IllegalSeekPositionException;
import d.f.b.a.d0.k;
import d.f.b.a.d0.l;
import d.f.b.a.f0.h;
import d.f.b.a.g;
import d.f.b.a.n;
import d.f.b.a.w;
import java.io.IOException;
/* loaded from: classes8.dex */
public final class j implements Handler.Callback, k.a, h.a, l.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int A;
    public int B;
    public boolean C;
    public int D;
    public int E;
    public long F;
    public int G;
    public int H;
    public c I;
    public long J;
    public a K;
    public a L;
    public a M;

    /* renamed from: e  reason: collision with root package name */
    public final r[] f70978e;

    /* renamed from: f  reason: collision with root package name */
    public final s[] f70979f;

    /* renamed from: g  reason: collision with root package name */
    public final d.f.b.a.f0.h f70980g;

    /* renamed from: h  reason: collision with root package name */
    public final m f70981h;

    /* renamed from: i  reason: collision with root package name */
    public final d.f.b.a.i0.q f70982i;
    public final Handler j;
    public final HandlerThread k;
    public final Handler l;
    public final g m;
    public final w.c n;
    public final w.b o;
    public final n p;
    public o q;
    public p r;
    public r s;
    public d.f.b.a.i0.h t;
    public d.f.b.a.d0.l u;
    public r[] v;
    public boolean w;
    public boolean x;
    public boolean y;
    public boolean z;

    /* loaded from: classes8.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final d.f.b.a.d0.k f70983a;

        /* renamed from: b  reason: collision with root package name */
        public final Object f70984b;

        /* renamed from: c  reason: collision with root package name */
        public final int f70985c;

        /* renamed from: d  reason: collision with root package name */
        public final d.f.b.a.d0.o[] f70986d;

        /* renamed from: e  reason: collision with root package name */
        public final boolean[] f70987e;

        /* renamed from: f  reason: collision with root package name */
        public final long f70988f;

        /* renamed from: g  reason: collision with root package name */
        public n.b f70989g;

        /* renamed from: h  reason: collision with root package name */
        public boolean f70990h;

        /* renamed from: i  reason: collision with root package name */
        public boolean f70991i;
        public a j;
        public d.f.b.a.f0.i k;
        public final r[] l;
        public final s[] m;
        public final d.f.b.a.f0.h n;
        public final m o;
        public final d.f.b.a.d0.l p;
        public d.f.b.a.f0.i q;

        public a(r[] rVarArr, s[] sVarArr, long j, d.f.b.a.f0.h hVar, m mVar, d.f.b.a.d0.l lVar, Object obj, int i2, n.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rVarArr, sVarArr, Long.valueOf(j), hVar, mVar, lVar, obj, Integer.valueOf(i2), bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.l = rVarArr;
            this.m = sVarArr;
            this.f70988f = j;
            this.n = hVar;
            this.o = mVar;
            this.p = lVar;
            d.f.b.a.i0.a.e(obj);
            this.f70984b = obj;
            this.f70985c = i2;
            this.f70989g = bVar;
            this.f70986d = new d.f.b.a.d0.o[rVarArr.length];
            this.f70987e = new boolean[rVarArr.length];
            d.f.b.a.d0.k d2 = lVar.d(bVar.f71055a, mVar.e());
            if (bVar.f71057c != Long.MIN_VALUE) {
                d.f.b.a.d0.c cVar = new d.f.b.a.d0.c(d2, true);
                cVar.f(0L, bVar.f71057c);
                d2 = cVar;
            }
            this.f70983a = d2;
        }

        public final void a(d.f.b.a.d0.o[] oVarArr) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, oVarArr) != null) {
                return;
            }
            int i2 = 0;
            while (true) {
                s[] sVarArr = this.m;
                if (i2 >= sVarArr.length) {
                    return;
                }
                if (sVarArr[i2].e() == 5 && this.k.f70811b[i2]) {
                    oVarArr[i2] = new d.f.b.a.d0.g();
                }
                i2++;
            }
        }

        public void b(long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j) == null) {
                this.f70983a.b(k(j));
            }
        }

        public final void c(d.f.b.a.d0.o[] oVarArr) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, oVarArr) != null) {
                return;
            }
            int i2 = 0;
            while (true) {
                s[] sVarArr = this.m;
                if (i2 >= sVarArr.length) {
                    return;
                }
                if (sVarArr[i2].e() == 5) {
                    oVarArr[i2] = null;
                }
                i2++;
            }
        }

        public long d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f70985c == 0 ? this.f70988f : this.f70988f - this.f70989g.f71056b : invokeV.longValue;
        }

        public void e() throws ExoPlaybackException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
                this.f70990h = true;
                i();
                this.f70989g = this.f70989g.b(m(this.f70989g.f71056b, false));
            }
        }

        public boolean f(boolean z, long j) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048581, this, new Object[]{Boolean.valueOf(z), Long.valueOf(j)})) == null) {
                long c2 = !this.f70990h ? this.f70989g.f71056b : this.f70983a.c();
                if (c2 == Long.MIN_VALUE) {
                    n.b bVar = this.f70989g;
                    if (bVar.f71061g) {
                        return true;
                    }
                    c2 = bVar.f71059e;
                }
                return this.o.d(c2 - k(j), z);
            }
            return invokeCommon.booleanValue;
        }

        public boolean g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f70990h && (!this.f70991i || this.f70983a.c() == Long.MIN_VALUE) : invokeV.booleanValue;
        }

        public void h() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
                try {
                    if (this.f70989g.f71057c != Long.MIN_VALUE) {
                        this.p.e(((d.f.b.a.d0.c) this.f70983a).f70208e);
                    } else {
                        this.p.e(this.f70983a);
                    }
                } catch (RuntimeException e2) {
                    Log.e("ExoPlayerImplInternal", "Period release failed.", e2);
                }
            }
        }

        public boolean i() throws ExoPlaybackException {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
                d.f.b.a.f0.i c2 = this.n.c(this.m, this.f70983a.k());
                if (c2.a(this.q)) {
                    return false;
                }
                this.k = c2;
                return true;
            }
            return invokeV.booleanValue;
        }

        public boolean j(long j) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJ = interceptable.invokeJ(1048585, this, j)) == null) {
                long d2 = !this.f70990h ? 0L : this.f70983a.d();
                if (d2 == Long.MIN_VALUE) {
                    return false;
                }
                return this.o.c(d2 - k(j));
            }
            return invokeJ.booleanValue;
        }

        public long k(long j) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeJ = interceptable.invokeJ(1048586, this, j)) == null) ? j - d() : invokeJ.longValue;
        }

        public long l(long j) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeJ = interceptable.invokeJ(1048587, this, j)) == null) ? j + d() : invokeJ.longValue;
        }

        public long m(long j, boolean z) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048588, this, new Object[]{Long.valueOf(j), Boolean.valueOf(z)})) == null) ? n(j, z, new boolean[this.l.length]) : invokeCommon.longValue;
        }

        public long n(long j, boolean z, boolean[] zArr) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable != null && (invokeCommon = interceptable.invokeCommon(1048589, this, new Object[]{Long.valueOf(j), Boolean.valueOf(z), zArr})) != null) {
                return invokeCommon.longValue;
            }
            d.f.b.a.f0.g gVar = this.k.f70812c;
            int i2 = 0;
            while (true) {
                boolean z2 = true;
                if (i2 >= gVar.f70807a) {
                    break;
                }
                boolean[] zArr2 = this.f70987e;
                if (z || !this.k.b(this.q, i2)) {
                    z2 = false;
                }
                zArr2[i2] = z2;
                i2++;
            }
            c(this.f70986d);
            long e2 = this.f70983a.e(gVar.b(), this.f70987e, this.f70986d, zArr, j);
            a(this.f70986d);
            this.q = this.k;
            this.f70991i = false;
            int i3 = 0;
            while (true) {
                d.f.b.a.d0.o[] oVarArr = this.f70986d;
                if (i3 < oVarArr.length) {
                    if (oVarArr[i3] != null) {
                        d.f.b.a.i0.a.f(this.k.f70811b[i3]);
                        if (this.m[i3].e() != 5) {
                            this.f70991i = true;
                        }
                    } else {
                        d.f.b.a.i0.a.f(gVar.a(i3) == null);
                    }
                    i3++;
                } else {
                    this.o.a(this.l, this.k.f70810a, gVar);
                    return e2;
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public static final class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final d.f.b.a.d0.l f70992a;

        /* renamed from: b  reason: collision with root package name */
        public final w f70993b;

        /* renamed from: c  reason: collision with root package name */
        public final Object f70994c;

        public b(d.f.b.a.d0.l lVar, w wVar, Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lVar, wVar, obj};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f70992a = lVar;
            this.f70993b = wVar;
            this.f70994c = obj;
        }
    }

    /* loaded from: classes8.dex */
    public static final class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final w f70995a;

        /* renamed from: b  reason: collision with root package name */
        public final int f70996b;

        /* renamed from: c  reason: collision with root package name */
        public final long f70997c;

        public c(w wVar, int i2, long j) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wVar, Integer.valueOf(i2), Long.valueOf(j)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f70995a = wVar;
            this.f70996b = i2;
            this.f70997c = j;
        }
    }

    public j(r[] rVarArr, d.f.b.a.f0.h hVar, m mVar, boolean z, int i2, boolean z2, Handler handler, g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {rVarArr, hVar, mVar, Boolean.valueOf(z), Integer.valueOf(i2), Boolean.valueOf(z2), handler, gVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f70978e = rVarArr;
        this.f70980g = hVar;
        this.f70981h = mVar;
        this.x = z;
        this.B = i2;
        this.C = z2;
        this.l = handler;
        this.A = 1;
        this.m = gVar;
        this.q = new o(null, null, 0, -9223372036854775807L);
        this.f70979f = new s[rVarArr.length];
        for (int i5 = 0; i5 < rVarArr.length; i5++) {
            rVarArr[i5].setIndex(i5);
            this.f70979f[i5] = rVarArr[i5].p();
        }
        this.f70982i = new d.f.b.a.i0.q();
        this.v = new r[0];
        this.n = new w.c();
        this.o = new w.b();
        this.p = new n();
        hVar.a(this);
        this.r = p.f71069d;
        HandlerThread handlerThread = new HandlerThread("ExoPlayerImplInternal:Handler", -16);
        this.k = handlerThread;
        handlerThread.start();
        this.j = new Handler(this.k.getLooper(), this);
    }

    @NonNull
    public static Format[] h(d.f.b.a.f0.f fVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, fVar)) == null) {
            int length = fVar != null ? fVar.length() : 0;
            Format[] formatArr = new Format[length];
            for (int i2 = 0; i2 < length; i2++) {
                formatArr[i2] = fVar.h(i2);
            }
            return formatArr;
        }
        return (Format[]) invokeL.objValue;
    }

    public final void A(d.f.b.a.d0.l lVar, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048576, this, lVar, z) == null) {
            this.G++;
            G(true);
            this.f70981h.onPrepared();
            if (z) {
                this.q = new o(null, null, 0, -9223372036854775807L);
            } else {
                o oVar = this.q;
                this.q = new o(null, null, oVar.f71064c, oVar.f71067f, this.q.f71066e);
            }
            this.u = lVar;
            lVar.a(this.m, true, this);
            a0(2);
            this.j.sendEmptyMessage(2);
        }
    }

    public synchronized void B() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            synchronized (this) {
                if (this.w) {
                    return;
                }
                this.j.sendEmptyMessage(6);
                boolean z = false;
                while (!this.w) {
                    try {
                        wait();
                    } catch (InterruptedException unused) {
                        z = true;
                    }
                }
                if (z) {
                    Thread.currentThread().interrupt();
                }
            }
        }
    }

    public final void C() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            G(true);
            this.f70981h.b();
            a0(1);
            this.k.quit();
            synchronized (this) {
                this.w = true;
                notifyAll();
            }
        }
    }

    public final void D(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, aVar) == null) {
            while (aVar != null) {
                aVar.h();
                aVar = aVar.j;
            }
        }
    }

    public final boolean E(r rVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, rVar)) == null) {
            a aVar = this.L.j;
            return aVar != null && aVar.f70990h && rVar.f();
        }
        return invokeL.booleanValue;
    }

    public final void F() throws ExoPlaybackException {
        a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (aVar = this.M) == null) {
            return;
        }
        boolean z = true;
        for (aVar = this.M; aVar != null && aVar.f70990h; aVar = aVar.j) {
            if (aVar.i()) {
                if (z) {
                    boolean z2 = this.L != this.M;
                    D(this.M.j);
                    a aVar2 = this.M;
                    aVar2.j = null;
                    this.K = aVar2;
                    this.L = aVar2;
                    boolean[] zArr = new boolean[this.f70978e.length];
                    long n = aVar2.n(this.q.f71067f, z2, zArr);
                    if (this.A != 4 && n != this.q.f71067f) {
                        o oVar = this.q;
                        o e2 = oVar.e(oVar.f71064c, n, oVar.f71066e);
                        this.q = e2;
                        this.l.obtainMessage(4, 3, 0, e2).sendToTarget();
                        H(n);
                    }
                    boolean[] zArr2 = new boolean[this.f70978e.length];
                    int i2 = 0;
                    int i3 = 0;
                    while (true) {
                        r[] rVarArr = this.f70978e;
                        if (i2 >= rVarArr.length) {
                            break;
                        }
                        r rVar = rVarArr[i2];
                        zArr2[i2] = rVar.getState() != 0;
                        d.f.b.a.d0.o oVar2 = this.M.f70986d[i2];
                        if (oVar2 != null) {
                            i3++;
                        }
                        if (zArr2[i2]) {
                            if (oVar2 != rVar.getStream()) {
                                b(rVar);
                            } else if (zArr[i2]) {
                                rVar.l(this.J);
                            }
                        }
                        i2++;
                    }
                    this.l.obtainMessage(2, aVar.k).sendToTarget();
                    f(zArr2, i3);
                } else {
                    this.K = aVar;
                    for (a aVar3 = aVar.j; aVar3 != null; aVar3 = aVar3.j) {
                        aVar3.h();
                    }
                    a aVar4 = this.K;
                    aVar4.j = null;
                    if (aVar4.f70990h) {
                        this.K.m(Math.max(aVar4.f70989g.f71056b, aVar4.k(this.J)), false);
                    }
                }
                if (this.A != 4) {
                    s();
                    i0();
                    this.j.sendEmptyMessage(2);
                    return;
                }
                return;
            }
            if (aVar == this.L) {
                z = false;
            }
        }
    }

    public final void G(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            this.j.removeMessages(2);
            this.y = false;
            this.f70982i.e();
            this.J = 60000000L;
            for (r rVar : this.v) {
                try {
                    b(rVar);
                } catch (ExoPlaybackException | RuntimeException e2) {
                    Log.e("ExoPlayerImplInternal", "Stop failed.", e2);
                }
            }
            this.v = new r[0];
            a aVar = this.M;
            if (aVar == null) {
                aVar = this.K;
            }
            D(aVar);
            this.K = null;
            this.L = null;
            this.M = null;
            Q(false);
            if (z) {
                d.f.b.a.d0.l lVar = this.u;
                if (lVar != null) {
                    lVar.f();
                    this.u = null;
                }
                this.p.n(null);
                this.q = this.q.c(null, null);
            }
        }
    }

    public final void H(long j) throws ExoPlaybackException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048583, this, j) == null) {
            a aVar = this.M;
            long l = aVar == null ? j + 60000000 : aVar.l(j);
            this.J = l;
            this.f70982i.a(l);
            for (r rVar : this.v) {
                rVar.l(this.J);
            }
        }
    }

    public final Pair<Integer, Long> I(c cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, cVar)) == null) {
            w wVar = this.q.f71062a;
            w wVar2 = cVar.f70995a;
            if (wVar2.p()) {
                wVar2 = wVar;
            }
            try {
                Pair<Integer, Long> i2 = wVar2.i(this.n, this.o, cVar.f70996b, cVar.f70997c);
                if (wVar == wVar2) {
                    return i2;
                }
                int b2 = wVar.b(wVar2.g(((Integer) i2.first).intValue(), this.o, true).f71087b);
                if (b2 != -1) {
                    return Pair.create(Integer.valueOf(b2), i2.second);
                }
                int J = J(((Integer) i2.first).intValue(), wVar2, wVar);
                if (J != -1) {
                    return k(wVar, wVar.f(J, this.o).f71088c, -9223372036854775807L);
                }
                return null;
            } catch (IndexOutOfBoundsException unused) {
                throw new IllegalSeekPositionException(wVar, cVar.f70996b, cVar.f70997c);
            }
        }
        return (Pair) invokeL.objValue;
    }

    public final int J(int i2, w wVar, w wVar2) {
        InterceptResult invokeILL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048585, this, i2, wVar, wVar2)) == null) {
            int h2 = wVar.h();
            int i3 = i2;
            int i4 = -1;
            for (int i5 = 0; i5 < h2 && i4 == -1; i5++) {
                i3 = wVar.d(i3, this.o, this.n, this.B, this.C);
                if (i3 == -1) {
                    break;
                }
                i4 = wVar2.b(wVar.g(i3, this.o, true).f71087b);
            }
            return i4;
        }
        return invokeILL.intValue;
    }

    public final void K(long j, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048586, this, new Object[]{Long.valueOf(j), Long.valueOf(j2)}) == null) {
            this.j.removeMessages(2);
            long elapsedRealtime = (j + j2) - SystemClock.elapsedRealtime();
            if (elapsedRealtime <= 0) {
                this.j.sendEmptyMessage(2);
            } else {
                this.j.sendEmptyMessageDelayed(2, elapsedRealtime);
            }
        }
    }

    public void L(w wVar, int i2, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048587, this, new Object[]{wVar, Integer.valueOf(i2), Long.valueOf(j)}) == null) {
            this.j.obtainMessage(3, new c(wVar, i2, j)).sendToTarget();
        }
    }

    public final void M(c cVar) throws ExoPlaybackException {
        int i2;
        long j;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, cVar) == null) {
            w wVar = this.q.f71062a;
            if (wVar == null) {
                this.H++;
                this.I = cVar;
                return;
            }
            Pair<Integer, Long> I = I(cVar);
            if (I == null) {
                int i3 = wVar.p() ? 0 : wVar.l(wVar.a(this.C), this.n).f71100f;
                this.q = this.q.d(i3, -9223372036854775807L, -9223372036854775807L);
                a0(4);
                this.l.obtainMessage(3, 1, 0, this.q.d(i3, 0L, -9223372036854775807L)).sendToTarget();
                G(false);
                return;
            }
            int i4 = cVar.f70997c == -9223372036854775807L ? 1 : 0;
            int intValue = ((Integer) I.first).intValue();
            long longValue = ((Long) I.second).longValue();
            l.b k = this.p.k(intValue, longValue);
            if (k.b()) {
                j = 0;
                i2 = 1;
            } else {
                i2 = i4;
                j = longValue;
            }
            try {
                if (k.equals(this.q.f71064c) && j / 1000 == this.q.f71067f / 1000) {
                    return;
                }
                long N = N(k, j);
                int i5 = i2 | (j != N ? 1 : 0);
                o e2 = this.q.e(k, N, longValue);
                this.q = e2;
                this.l.obtainMessage(3, i5, 0, e2).sendToTarget();
            } finally {
                o e3 = this.q.e(k, j, longValue);
                this.q = e3;
                this.l.obtainMessage(3, i2, 0, e3).sendToTarget();
            }
        }
    }

    public final long N(l.b bVar, long j) throws ExoPlaybackException {
        InterceptResult invokeLJ;
        a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(1048589, this, bVar, j)) == null) {
            f0();
            this.y = false;
            a0(2);
            a aVar2 = this.M;
            if (aVar2 == null) {
                a aVar3 = this.K;
                if (aVar3 != null) {
                    aVar3.h();
                }
                aVar = null;
            } else {
                aVar = null;
                while (aVar2 != null) {
                    if (aVar == null && b0(bVar, j, aVar2)) {
                        aVar = aVar2;
                    } else {
                        aVar2.h();
                    }
                    aVar2 = aVar2.j;
                }
            }
            a aVar4 = this.M;
            if (aVar4 != aVar || aVar4 != this.L) {
                for (r rVar : this.v) {
                    b(rVar);
                }
                this.v = new r[0];
                this.M = null;
            }
            if (aVar != null) {
                aVar.j = null;
                this.K = aVar;
                this.L = aVar;
                V(aVar);
                a aVar5 = this.M;
                if (aVar5.f70991i) {
                    j = aVar5.f70983a.g(j);
                }
                H(j);
                s();
            } else {
                this.K = null;
                this.L = null;
                this.M = null;
                H(j);
            }
            this.j.sendEmptyMessage(2);
            return j;
        }
        return invokeLJ.longValue;
    }

    public void O(g.b... bVarArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, bVarArr) == null) {
            if (this.w) {
                Log.w("ExoPlayerImplInternal", "Ignoring messages sent after release.");
                return;
            }
            this.D++;
            this.j.obtainMessage(11, bVarArr).sendToTarget();
        }
    }

    /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
    public final void P(g.b[] bVarArr) throws ExoPlaybackException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, bVarArr) == null) {
            try {
                for (g.b bVar : bVarArr) {
                    bVar.f70815a.h(bVar.f70816b, bVar.f70817c);
                }
                if (this.A == 3 || this.A == 2) {
                    this.j.sendEmptyMessage(2);
                }
                synchronized (this) {
                    this.E++;
                    notifyAll();
                }
            } catch (Throwable th) {
                synchronized (this) {
                    this.E++;
                    notifyAll();
                    throw th;
                }
            }
        }
    }

    public final void Q(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048592, this, z) == null) || this.z == z) {
            return;
        }
        this.z = z;
        this.l.obtainMessage(1, z ? 1 : 0, 0).sendToTarget();
    }

    public void R(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048593, this, z) == null) {
            this.j.obtainMessage(1, z ? 1 : 0, 0).sendToTarget();
        }
    }

    public final void S(boolean z) throws ExoPlaybackException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048594, this, z) == null) {
            this.y = false;
            this.x = z;
            if (!z) {
                f0();
                i0();
                return;
            }
            int i2 = this.A;
            if (i2 == 3) {
                c0();
                this.j.sendEmptyMessage(2);
            } else if (i2 == 2) {
                this.j.sendEmptyMessage(2);
            }
        }
    }

    public void T(p pVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, pVar) == null) {
            this.j.obtainMessage(4, pVar).sendToTarget();
        }
    }

    public final void U(p pVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, pVar) == null) {
            d.f.b.a.i0.h hVar = this.t;
            if (hVar != null) {
                pVar = hVar.c(pVar);
            }
            this.f70982i.c(pVar);
            this.r = pVar;
            this.l.obtainMessage(6, pVar).sendToTarget();
        }
    }

    public final void V(a aVar) throws ExoPlaybackException {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048597, this, aVar) == null) || this.M == aVar) {
            return;
        }
        boolean[] zArr = new boolean[this.f70978e.length];
        int i2 = 0;
        int i3 = 0;
        while (true) {
            r[] rVarArr = this.f70978e;
            if (i2 < rVarArr.length) {
                r rVar = rVarArr[i2];
                zArr[i2] = rVar.getState() != 0;
                if (aVar.k.f70811b[i2]) {
                    i3++;
                }
                if (zArr[i2] && (!aVar.k.f70811b[i2] || (rVar.j() && rVar.getStream() == this.M.f70986d[i2]))) {
                    b(rVar);
                }
                i2++;
            } else {
                this.M = aVar;
                this.l.obtainMessage(2, aVar.k).sendToTarget();
                f(zArr, i3);
                return;
            }
        }
    }

    public void W(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048598, this, i2) == null) {
            this.j.obtainMessage(12, i2, 0).sendToTarget();
        }
    }

    public final void X(int i2) throws ExoPlaybackException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048599, this, i2) == null) {
            this.B = i2;
            this.p.l(i2);
            j0();
        }
    }

    public void Y(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048600, this, z) == null) {
            this.j.obtainMessage(13, z ? 1 : 0, 0).sendToTarget();
        }
    }

    public final void Z(boolean z) throws ExoPlaybackException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048601, this, z) == null) {
            this.C = z;
            this.p.m(z);
            j0();
        }
    }

    public synchronized void a(g.b... bVarArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, bVarArr) == null) {
            synchronized (this) {
                if (this.w) {
                    Log.w("ExoPlayerImplInternal", "Ignoring messages sent after release.");
                    return;
                }
                int i2 = this.D;
                this.D = i2 + 1;
                this.j.obtainMessage(11, bVarArr).sendToTarget();
                boolean z = false;
                while (this.E <= i2) {
                    try {
                        wait();
                    } catch (InterruptedException unused) {
                        z = true;
                    }
                }
                if (z) {
                    Thread.currentThread().interrupt();
                }
            }
        }
    }

    public final void a0(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048603, this, i2) == null) || this.A == i2) {
            return;
        }
        this.A = i2;
        this.l.obtainMessage(0, i2, 0).sendToTarget();
    }

    public final void b(r rVar) throws ExoPlaybackException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048604, this, rVar) == null) {
            if (rVar == this.s) {
                this.t = null;
                this.s = null;
            }
            g(rVar);
            rVar.i();
        }
    }

    public final boolean b0(l.b bVar, long j, a aVar) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048605, this, new Object[]{bVar, Long.valueOf(j), aVar})) == null) {
            if (bVar.equals(aVar.f70989g.f71055a) && aVar.f70990h) {
                this.q.f71062a.f(aVar.f70989g.f71055a.f70266a, this.o);
                int d2 = this.o.d(j);
                return d2 == -1 || this.o.f(d2) == aVar.f70989g.f71057c;
            }
            return false;
        }
        return invokeCommon.booleanValue;
    }

    @Override // d.f.b.a.d0.l.a
    public void c(d.f.b.a.d0.l lVar, w wVar, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048606, this, lVar, wVar, obj) == null) {
            this.j.obtainMessage(7, new b(lVar, wVar, obj)).sendToTarget();
        }
    }

    public final void c0() throws ExoPlaybackException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048607, this) == null) {
            this.y = false;
            this.f70982i.b();
            for (r rVar : this.v) {
                rVar.start();
            }
        }
    }

    public final void d() throws ExoPlaybackException, IOException {
        r[] rVarArr;
        boolean r;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048608, this) == null) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            h0();
            if (this.M == null) {
                t();
                K(elapsedRealtime, 10L);
                return;
            }
            d.f.b.a.i0.t.a("doSomeWork");
            i0();
            this.M.f70983a.r(this.q.f71067f);
            boolean z = true;
            boolean z2 = true;
            for (r rVar : this.v) {
                rVar.k(this.J, this.F);
                z2 = z2 && rVar.b();
                boolean z3 = rVar.isReady() || rVar.b() || E(rVar);
                if (!z3) {
                    rVar.o();
                }
                z = z && z3;
            }
            if (!z) {
                t();
            }
            d.f.b.a.i0.h hVar = this.t;
            if (hVar != null) {
                p d2 = hVar.d();
                if (!d2.equals(this.r)) {
                    this.r = d2;
                    this.f70982i.c(d2);
                    this.l.obtainMessage(6, d2).sendToTarget();
                }
            }
            long j = this.M.f70989g.f71059e;
            if (z2 && ((j == -9223372036854775807L || j <= this.q.f71067f) && this.M.f70989g.f71061g)) {
                a0(4);
                f0();
            } else {
                int i3 = this.A;
                if (i3 == 2) {
                    if (this.v.length > 0) {
                        r = z && this.K.f(this.y, this.J);
                    } else {
                        r = r(j);
                    }
                    if (r) {
                        a0(3);
                        if (this.x) {
                            c0();
                        }
                    }
                } else if (i3 == 3) {
                    if (this.v.length <= 0) {
                        z = r(j);
                    }
                    if (!z) {
                        this.y = this.x;
                        a0(2);
                        f0();
                    }
                }
            }
            if (this.A == 2) {
                for (r rVar2 : this.v) {
                    rVar2.o();
                }
            }
            if ((this.x && this.A == 3) || (i2 = this.A) == 2) {
                K(elapsedRealtime, 10L);
            } else if (this.v.length != 0 && i2 != 4) {
                K(elapsedRealtime, 1000L);
            } else {
                this.j.removeMessages(2);
            }
            d.f.b.a.i0.t.c();
        }
    }

    public void d0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048609, this) == null) {
            this.j.sendEmptyMessage(5);
        }
    }

    public final void e(int i2, boolean z, int i3) throws ExoPlaybackException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048610, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z), Integer.valueOf(i3)}) == null) {
            r rVar = this.f70978e[i2];
            this.v[i3] = rVar;
            if (rVar.getState() == 0) {
                d.f.b.a.f0.i iVar = this.M.k;
                t tVar = iVar.f70814e[i2];
                Format[] h2 = h(iVar.f70812c.a(i2));
                boolean z2 = this.x && this.A == 3;
                boolean z3 = !z && z2;
                a aVar = this.M;
                rVar.g(tVar, h2, aVar.f70986d[i2], this.J, z3, aVar.d());
                d.f.b.a.i0.h m = rVar.m();
                if (m != null) {
                    if (this.t == null) {
                        this.t = m;
                        this.s = rVar;
                        m.c(this.r);
                    } else {
                        throw ExoPlaybackException.createForUnexpected(new IllegalStateException("Multiple renderer media clocks enabled."));
                    }
                }
                if (z2) {
                    rVar.start();
                }
            }
        }
    }

    public final void e0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048611, this) == null) {
            G(true);
            this.f70981h.f();
            a0(1);
        }
    }

    public final void f(boolean[] zArr, int i2) throws ExoPlaybackException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048612, this, zArr, i2) == null) {
            this.v = new r[i2];
            int i3 = 0;
            for (int i4 = 0; i4 < this.f70978e.length; i4++) {
                if (this.M.k.f70811b[i4]) {
                    e(i4, zArr[i4], i3);
                    i3++;
                }
            }
        }
    }

    public final void f0() throws ExoPlaybackException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048613, this) == null) {
            this.f70982i.e();
            for (r rVar : this.v) {
                g(rVar);
            }
        }
    }

    public final void g(r rVar) throws ExoPlaybackException {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048614, this, rVar) == null) && rVar.getState() == 2) {
            rVar.stop();
        }
    }

    public final a g0(a aVar, int i2) {
        a aVar2;
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048615, this, aVar, i2)) == null) {
            while (true) {
                n.b g2 = this.p.g(aVar.f70989g, i2);
                aVar.f70989g = g2;
                if (g2.f71060f || (aVar2 = aVar.j) == null) {
                    break;
                }
                aVar = aVar2;
            }
            return aVar;
        }
        return (a) invokeLI.objValue;
    }

    public final void h0() throws ExoPlaybackException, IOException {
        a aVar;
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeV(1048616, this) != null) {
            return;
        }
        if (this.q.f71062a == null) {
            this.u.b();
            return;
        }
        u();
        a aVar2 = this.K;
        int i2 = 0;
        if (aVar2 != null && !aVar2.g()) {
            if (this.K != null && !this.z) {
                s();
            }
        } else {
            Q(false);
        }
        if (this.M == null) {
            return;
        }
        while (this.x && (aVar = this.M) != this.L && this.J >= aVar.j.f70988f) {
            aVar.h();
            V(this.M.j);
            o oVar = this.q;
            n.b bVar = this.M.f70989g;
            this.q = oVar.e(bVar.f71055a, bVar.f71056b, bVar.f71058d);
            i0();
            this.l.obtainMessage(4, 0, 0, this.q).sendToTarget();
        }
        a aVar3 = this.L;
        if (aVar3.f70989g.f71061g) {
            while (true) {
                r[] rVarArr = this.f70978e;
                if (i2 >= rVarArr.length) {
                    return;
                }
                r rVar = rVarArr[i2];
                d.f.b.a.d0.o oVar2 = this.L.f70986d[i2];
                if (oVar2 != null && rVar.getStream() == oVar2 && rVar.f()) {
                    rVar.n();
                }
                i2++;
            }
        } else {
            a aVar4 = aVar3.j;
            if (aVar4 == null || !aVar4.f70990h) {
                return;
            }
            int i3 = 0;
            while (true) {
                r[] rVarArr2 = this.f70978e;
                if (i3 < rVarArr2.length) {
                    r rVar2 = rVarArr2[i3];
                    d.f.b.a.d0.o oVar3 = this.L.f70986d[i3];
                    if (rVar2.getStream() != oVar3) {
                        return;
                    }
                    if (oVar3 != null && !rVar2.f()) {
                        return;
                    }
                    i3++;
                } else {
                    a aVar5 = this.L;
                    d.f.b.a.f0.i iVar = aVar5.k;
                    a aVar6 = aVar5.j;
                    this.L = aVar6;
                    d.f.b.a.f0.i iVar2 = aVar6.k;
                    boolean z = aVar6.f70983a.h() != -9223372036854775807L;
                    int i4 = 0;
                    while (true) {
                        r[] rVarArr3 = this.f70978e;
                        if (i4 >= rVarArr3.length) {
                            return;
                        }
                        r rVar3 = rVarArr3[i4];
                        if (iVar.f70811b[i4]) {
                            if (z) {
                                rVar3.n();
                            } else if (!rVar3.j()) {
                                d.f.b.a.f0.f a2 = iVar2.f70812c.a(i4);
                                boolean z2 = iVar2.f70811b[i4];
                                boolean z3 = this.f70979f[i4].e() == 5;
                                t tVar = iVar.f70814e[i4];
                                t tVar2 = iVar2.f70814e[i4];
                                if (z2 && tVar2.equals(tVar) && !z3) {
                                    Format[] h2 = h(a2);
                                    a aVar7 = this.L;
                                    rVar3.s(h2, aVar7.f70986d[i4], aVar7.d());
                                } else {
                                    rVar3.n();
                                }
                            }
                        }
                        i4++;
                    }
                }
            }
        }
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048617, this, message)) == null) {
            try {
                switch (message.what) {
                    case 0:
                        A((d.f.b.a.d0.l) message.obj, message.arg1 != 0);
                        return true;
                    case 1:
                        S(message.arg1 != 0);
                        return true;
                    case 2:
                        d();
                        return true;
                    case 3:
                        M((c) message.obj);
                        return true;
                    case 4:
                        U((p) message.obj);
                        return true;
                    case 5:
                        e0();
                        return true;
                    case 6:
                        C();
                        return true;
                    case 7:
                        q((b) message.obj);
                        return true;
                    case 8:
                        n((d.f.b.a.d0.k) message.obj);
                        return true;
                    case 9:
                        m((d.f.b.a.d0.k) message.obj);
                        return true;
                    case 10:
                        F();
                        return true;
                    case 11:
                        P((g.b[]) message.obj);
                        return true;
                    case 12:
                        X(message.arg1);
                        return true;
                    case 13:
                        Z(message.arg1 != 0);
                        return true;
                    default:
                        return false;
                }
            } catch (ExoPlaybackException e2) {
                Log.e("ExoPlayerImplInternal", "Renderer error.", e2);
                this.l.obtainMessage(7, e2).sendToTarget();
                e0();
                return true;
            } catch (IOException e3) {
                Log.e("ExoPlayerImplInternal", "Source error.", e3);
                this.l.obtainMessage(7, ExoPlaybackException.createForSource(e3)).sendToTarget();
                e0();
                return true;
            } catch (RuntimeException e4) {
                Log.e("ExoPlayerImplInternal", "Internal runtime error.", e4);
                this.l.obtainMessage(7, ExoPlaybackException.createForUnexpected(e4)).sendToTarget();
                e0();
                return true;
            }
        }
        return invokeL.booleanValue;
    }

    public final void i0() throws ExoPlaybackException {
        a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048618, this) == null) || (aVar = this.M) == null) {
            return;
        }
        long h2 = aVar.f70983a.h();
        if (h2 != -9223372036854775807L) {
            H(h2);
            o oVar = this.q;
            o e2 = oVar.e(oVar.f71064c, h2, oVar.f71066e);
            this.q = e2;
            this.l.obtainMessage(4, 3, 0, e2).sendToTarget();
        } else {
            r rVar = this.s;
            if (rVar != null && !rVar.b() && (this.s.isReady() || !E(this.s))) {
                long q = this.t.q();
                this.J = q;
                this.f70982i.a(q);
            } else {
                this.J = this.f70982i.q();
            }
            h2 = this.M.k(this.J);
        }
        this.q.f71067f = h2;
        this.F = SystemClock.elapsedRealtime() * 1000;
        long c2 = this.v.length == 0 ? Long.MIN_VALUE : this.M.f70983a.c();
        o oVar2 = this.q;
        if (c2 == Long.MIN_VALUE) {
            c2 = this.M.f70989g.f71059e;
        }
        oVar2.f71068g = c2;
    }

    public final void j0() throws ExoPlaybackException {
        a aVar;
        a aVar2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048620, this) == null) {
            a aVar3 = this.M;
            if (aVar3 == null) {
                aVar3 = this.K;
            }
            if (aVar3 == null) {
                return;
            }
            while (true) {
                int d2 = this.q.f71062a.d(aVar3.f70989g.f71055a.f70266a, this.o, this.n, this.B, this.C);
                while (true) {
                    a aVar4 = aVar3.j;
                    if (aVar4 == null || aVar3.f70989g.f71060f) {
                        break;
                    }
                    aVar3 = aVar4;
                }
                if (d2 == -1 || (aVar2 = aVar3.j) == null || aVar2.f70989g.f71055a.f70266a != d2) {
                    break;
                }
                aVar3 = aVar2;
            }
            int i2 = this.K.f70985c;
            a aVar5 = this.L;
            int i3 = aVar5 != null ? aVar5.f70985c : -1;
            a aVar6 = aVar3.j;
            if (aVar6 != null) {
                D(aVar6);
                aVar3.j = null;
            }
            aVar3.f70989g = this.p.f(aVar3.f70989g);
            boolean z = true;
            if (!(i2 <= aVar3.f70985c)) {
                this.K = aVar3;
            }
            if (((i3 == -1 || i3 > aVar3.f70985c) ? false : false) || (aVar = this.M) == null) {
                return;
            }
            l.b bVar = aVar.f70989g.f71055a;
            long N = N(bVar, this.q.f71067f);
            if (N != this.q.f71067f) {
                o oVar = this.q;
                o e2 = oVar.e(bVar, N, oVar.f71066e);
                this.q = e2;
                this.l.obtainMessage(4, 3, 0, e2).sendToTarget();
            }
        }
    }

    public final Pair<Integer, Long> k(w wVar, int i2, long j) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048621, this, new Object[]{wVar, Integer.valueOf(i2), Long.valueOf(j)})) == null) ? wVar.i(this.n, this.o, i2, j) : (Pair) invokeCommon.objValue;
    }

    @Override // d.f.b.a.d0.k.a
    public void l(d.f.b.a.d0.k kVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048622, this, kVar) == null) {
            this.j.obtainMessage(8, kVar).sendToTarget();
        }
    }

    public final void m(d.f.b.a.d0.k kVar) {
        a aVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048623, this, kVar) == null) && (aVar = this.K) != null && aVar.f70983a == kVar) {
            s();
        }
    }

    public final void n(d.f.b.a.d0.k kVar) throws ExoPlaybackException {
        a aVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048624, this, kVar) == null) && (aVar = this.K) != null && aVar.f70983a == kVar) {
            aVar.e();
            if (this.M == null) {
                a aVar2 = this.K;
                this.L = aVar2;
                H(aVar2.f70989g.f71056b);
                V(this.L);
            }
            s();
        }
    }

    public final void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048625, this) == null) {
            p(0, 0);
        }
    }

    public final void p(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048626, this, i2, i3) == null) {
            w wVar = this.q.f71062a;
            int i4 = wVar.p() ? 0 : wVar.l(wVar.a(this.C), this.n).f71100f;
            this.q = this.q.d(i4, -9223372036854775807L, -9223372036854775807L);
            a0(4);
            x(i2, i3, this.q.d(i4, 0L, -9223372036854775807L));
            G(false);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:85:0x01e0, code lost:
        r3 = r20.L;
     */
    /* JADX WARN: Code restructure failed: missing block: B:86:0x01e2, code lost:
        if (r3 == null) goto L99;
     */
    /* JADX WARN: Code restructure failed: missing block: B:88:0x01e8, code lost:
        if (r3.f70985c >= r2.f70985c) goto L99;
     */
    /* JADX WARN: Code restructure failed: missing block: B:89:0x01ea, code lost:
        r11 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:90:0x01eb, code lost:
        if (r11 != false) goto L103;
     */
    /* JADX WARN: Code restructure failed: missing block: B:91:0x01ed, code lost:
        r6 = N(r20.M.f70989g.f71055a, r20.q.f71067f);
        r4 = r20.q;
        r20.q = r4.e(r20.M.f70989g.f71055a, r6, r4.f71066e);
     */
    /* JADX WARN: Code restructure failed: missing block: B:92:0x020c, code lost:
        r20.K = r1;
        r1.j = null;
        D(r2);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void q(b bVar) throws ExoPlaybackException {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048627, this, bVar) == null) && bVar.f70992a == this.u) {
            w wVar = this.q.f71062a;
            w wVar2 = bVar.f70993b;
            Object obj = bVar.f70994c;
            this.p.n(wVar2);
            o c2 = this.q.c(wVar2, obj);
            this.q = c2;
            boolean z = false;
            if (wVar == null) {
                int i2 = this.G;
                this.G = 0;
                if (this.H > 0) {
                    Pair<Integer, Long> I = I(this.I);
                    int i3 = this.H;
                    this.H = 0;
                    this.I = null;
                    if (I == null) {
                        p(i2, i3);
                        return;
                    }
                    int intValue = ((Integer) I.first).intValue();
                    long longValue = ((Long) I.second).longValue();
                    l.b k = this.p.k(intValue, longValue);
                    this.q = this.q.e(k, k.b() ? 0L : longValue, longValue);
                    w(i2, i3);
                    return;
                } else if (c2.f71065d == -9223372036854775807L) {
                    if (wVar2.p()) {
                        p(i2, 0);
                        return;
                    }
                    Pair<Integer, Long> k2 = k(wVar2, wVar2.a(this.C), -9223372036854775807L);
                    int intValue2 = ((Integer) k2.first).intValue();
                    long longValue2 = ((Long) k2.second).longValue();
                    l.b k3 = this.p.k(intValue2, longValue2);
                    this.q = this.q.e(k3, k3.b() ? 0L : longValue2, longValue2);
                    w(i2, 0);
                    return;
                } else {
                    w(i2, 0);
                    return;
                }
            }
            int i4 = c2.f71064c.f70266a;
            a aVar = this.M;
            if (aVar == null) {
                aVar = this.K;
            }
            if (aVar == null && i4 >= wVar.h()) {
                v();
                return;
            }
            int b2 = wVar2.b(aVar == null ? wVar.g(i4, this.o, true).f71087b : aVar.f70984b);
            if (b2 == -1) {
                int J = J(i4, wVar, wVar2);
                if (J == -1) {
                    o();
                    return;
                }
                Pair<Integer, Long> k4 = k(wVar2, wVar2.f(J, this.o).f71088c, -9223372036854775807L);
                int intValue3 = ((Integer) k4.first).intValue();
                long longValue3 = ((Long) k4.second).longValue();
                wVar2.g(intValue3, this.o, true);
                if (aVar != null) {
                    Object obj2 = this.o.f71087b;
                    aVar.f70989g = aVar.f70989g.a(-1);
                    while (true) {
                        aVar = aVar.j;
                        if (aVar == null) {
                            break;
                        } else if (aVar.f70984b.equals(obj2)) {
                            aVar.f70989g = this.p.g(aVar.f70989g, intValue3);
                        } else {
                            aVar.f70989g = aVar.f70989g.a(-1);
                        }
                    }
                }
                l.b bVar2 = new l.b(intValue3);
                this.q = this.q.e(bVar2, N(bVar2, longValue3), -9223372036854775807L);
                v();
                return;
            }
            if (b2 != i4) {
                this.q = this.q.b(b2);
            }
            if (this.q.f71064c.b()) {
                l.b k5 = this.p.k(b2, this.q.f71066e);
                if (!k5.b() || k5.f70268c != this.q.f71064c.f70268c) {
                    this.q = this.q.e(k5, N(k5, this.q.f71066e), k5.b() ? this.q.f71066e : -9223372036854775807L);
                    v();
                    return;
                }
            }
            if (aVar == null) {
                v();
                return;
            }
            a g0 = g0(aVar, b2);
            int i5 = b2;
            while (true) {
                a aVar2 = g0.j;
                if (aVar2 == null) {
                    break;
                }
                i5 = wVar2.d(i5, this.o, this.n, this.B, this.C);
                if (i5 == -1 || !aVar2.f70984b.equals(wVar2.g(i5, this.o, true).f71087b)) {
                    break;
                }
                g0 = g0(aVar2, i5);
            }
            v();
        }
    }

    public final boolean r(long j) {
        InterceptResult invokeJ;
        a aVar;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJ = interceptable.invokeJ(1048628, this, j)) == null) ? j == -9223372036854775807L || this.q.f71067f < j || ((aVar = this.M.j) != null && (aVar.f70990h || aVar.f70989g.f71055a.b())) : invokeJ.booleanValue;
    }

    public final void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048629, this) == null) {
            boolean j = this.K.j(this.J);
            Q(j);
            if (j) {
                this.K.b(this.J);
            }
        }
    }

    public final void t() throws IOException {
        a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048630, this) == null) || (aVar = this.K) == null || aVar.f70990h) {
            return;
        }
        a aVar2 = this.L;
        if (aVar2 == null || aVar2.j == aVar) {
            for (r rVar : this.v) {
                if (!rVar.f()) {
                    return;
                }
            }
            this.K.f70983a.q();
        }
    }

    public final void u() throws IOException {
        n.b e2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048631, this) == null) {
            a aVar = this.K;
            if (aVar == null) {
                e2 = this.p.a(this.q);
            } else if (aVar.f70989g.f71061g || !aVar.g()) {
                return;
            } else {
                a aVar2 = this.K;
                if (aVar2.f70989g.f71059e == -9223372036854775807L) {
                    return;
                }
                a aVar3 = this.M;
                if (aVar3 != null && aVar2.f70985c - aVar3.f70985c == 100) {
                    return;
                }
                n nVar = this.p;
                a aVar4 = this.K;
                e2 = nVar.e(aVar4.f70989g, aVar4.d(), this.J);
            }
            if (e2 == null) {
                this.u.b();
                return;
            }
            a aVar5 = this.K;
            long d2 = aVar5 == null ? 60000000L : aVar5.d() + this.K.f70989g.f71059e;
            a aVar6 = this.K;
            a aVar7 = new a(this.f70978e, this.f70979f, d2, this.f70980g, this.f70981h, this.u, this.q.f71062a.g(e2.f71055a.f70266a, this.o, true).f71087b, aVar6 == null ? 0 : aVar6.f70985c + 1, e2);
            a aVar8 = this.K;
            if (aVar8 != null) {
                aVar8.j = aVar7;
            }
            this.K = aVar7;
            aVar7.f70983a.o(this, e2.f71056b);
            Q(true);
        }
    }

    public final void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048632, this) == null) {
            w(0, 0);
        }
    }

    public final void w(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048633, this, i2, i3) == null) {
            x(i2, i3, this.q);
        }
    }

    public final void x(int i2, int i3, o oVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048634, this, i2, i3, oVar) == null) {
            this.l.obtainMessage(5, i2, i3, oVar).sendToTarget();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.f.b.a.d0.p.a
    /* renamed from: y */
    public void j(d.f.b.a.d0.k kVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048635, this, kVar) == null) {
            this.j.obtainMessage(9, kVar).sendToTarget();
        }
    }

    public void z(d.f.b.a.d0.l lVar, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048636, this, lVar, z) == null) {
            this.j.obtainMessage(0, z ? 1 : 0, 0, lVar).sendToTarget();
        }
    }
}
