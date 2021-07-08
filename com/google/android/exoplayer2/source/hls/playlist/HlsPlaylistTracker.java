package com.google.android.exoplayer2.source.hls.playlist;

import android.net.Uri;
import android.os.Handler;
import android.os.SystemClock;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.upstream.Loader;
import d.f.b.a.d0.b;
import d.f.b.a.d0.u.h;
import d.f.b.a.d0.w.e;
import d.f.b.a.d0.w.o.a;
import d.f.b.a.d0.w.o.b;
import d.f.b.a.h0.o;
import d.f.b.a.i0.u;
import java.io.IOException;
import java.util.ArrayList;
import java.util.IdentityHashMap;
import java.util.List;
/* loaded from: classes5.dex */
public final class HlsPlaylistTracker implements Loader.a<o<d.f.b.a.d0.w.o.c>> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public final Uri f32858e;

    /* renamed from: f  reason: collision with root package name */
    public final e f32859f;

    /* renamed from: g  reason: collision with root package name */
    public final o.a<d.f.b.a.d0.w.o.c> f32860g;

    /* renamed from: h  reason: collision with root package name */
    public final int f32861h;

    /* renamed from: i  reason: collision with root package name */
    public final IdentityHashMap<a.C1980a, b> f32862i;
    public final Handler j;
    public final d k;
    public final List<c> l;
    public final Loader m;
    public final b.a n;
    public d.f.b.a.d0.w.o.a o;
    public a.C1980a p;
    public d.f.b.a.d0.w.o.b q;
    public boolean r;

    /* loaded from: classes5.dex */
    public static final class PlaylistResetException extends IOException {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final String url;

        public /* synthetic */ PlaylistResetException(String str, a aVar) {
            this(str);
        }

        public PlaylistResetException(String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.url = str;
        }
    }

    /* loaded from: classes5.dex */
    public static final class PlaylistStuckException extends IOException {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final String url;

        public /* synthetic */ PlaylistStuckException(String str, a aVar) {
            this(str);
        }

        public PlaylistStuckException(String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.url = str;
        }
    }

    /* loaded from: classes5.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes5.dex */
    public final class b implements Loader.a<o<d.f.b.a.d0.w.o.c>>, Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final a.C1980a f32863e;

        /* renamed from: f  reason: collision with root package name */
        public final Loader f32864f;

        /* renamed from: g  reason: collision with root package name */
        public final o<d.f.b.a.d0.w.o.c> f32865g;

        /* renamed from: h  reason: collision with root package name */
        public d.f.b.a.d0.w.o.b f32866h;

        /* renamed from: i  reason: collision with root package name */
        public long f32867i;
        public long j;
        public long k;
        public long l;
        public boolean m;
        public IOException n;
        public final /* synthetic */ HlsPlaylistTracker o;

        public b(HlsPlaylistTracker hlsPlaylistTracker, a.C1980a c1980a) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hlsPlaylistTracker, c1980a};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.o = hlsPlaylistTracker;
            this.f32863e = c1980a;
            this.f32864f = new Loader("HlsPlaylistTracker:MediaPlaylist");
            this.f32865g = new o<>(hlsPlaylistTracker.f32859f.a(4), u.d(hlsPlaylistTracker.o.f70068a, c1980a.f70054a), 4, hlsPlaylistTracker.f32860g);
        }

        public final boolean d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                this.l = SystemClock.elapsedRealtime() + 60000;
                this.o.C(this.f32863e, 60000L);
                return this.o.p == this.f32863e && !this.o.y();
            }
            return invokeV.booleanValue;
        }

        public d.f.b.a.d0.w.o.b e() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f32866h : (d.f.b.a.d0.w.o.b) invokeV.objValue;
        }

        public boolean f() {
            InterceptResult invokeV;
            int i2;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                if (this.f32866h == null) {
                    return false;
                }
                long elapsedRealtime = SystemClock.elapsedRealtime();
                long max = Math.max(30000L, d.f.b.a.b.b(this.f32866h.q));
                d.f.b.a.d0.w.o.b bVar = this.f32866h;
                return bVar.l || (i2 = bVar.f70056c) == 2 || i2 == 1 || this.f32867i + max > elapsedRealtime;
            }
            return invokeV.booleanValue;
        }

        public void g() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                this.l = 0L;
                if (this.m || this.f32864f.g()) {
                    return;
                }
                long elapsedRealtime = SystemClock.elapsedRealtime();
                if (elapsedRealtime < this.k) {
                    this.m = true;
                    this.o.j.postDelayed(this, this.k - elapsedRealtime);
                    return;
                }
                h();
            }
        }

        public final void h() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
                this.f32864f.k(this.f32865g, this, this.o.f32861h);
            }
        }

        public void i() throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
                this.f32864f.a();
                IOException iOException = this.n;
                if (iOException != null) {
                    throw iOException;
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.android.exoplayer2.upstream.Loader.a
        /* renamed from: j */
        public void l(o<d.f.b.a.d0.w.o.c> oVar, long j, long j2, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{oVar, Long.valueOf(j), Long.valueOf(j2), Boolean.valueOf(z)}) == null) {
                this.o.n.g(oVar.f70437a, 4, j, j2, oVar.d());
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.android.exoplayer2.upstream.Loader.a
        /* renamed from: k */
        public void m(o<d.f.b.a.d0.w.o.c> oVar, long j, long j2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{oVar, Long.valueOf(j), Long.valueOf(j2)}) == null) {
                d.f.b.a.d0.w.o.c e2 = oVar.e();
                if (e2 instanceof d.f.b.a.d0.w.o.b) {
                    p((d.f.b.a.d0.w.o.b) e2);
                    this.o.n.i(oVar.f70437a, 4, j, j2, oVar.d());
                    return;
                }
                this.n = new ParserException("Loaded playlist has unexpected type.");
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.android.exoplayer2.upstream.Loader.a
        /* renamed from: o */
        public int n(o<d.f.b.a.d0.w.o.c> oVar, long j, long j2, IOException iOException) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048587, this, new Object[]{oVar, Long.valueOf(j), Long.valueOf(j2), iOException})) == null) {
                boolean z = iOException instanceof ParserException;
                this.o.n.k(oVar.f70437a, 4, j, j2, oVar.d(), iOException, z);
                if (z) {
                    return 3;
                }
                return h.c(iOException) ? d() : true ? 0 : 2;
            }
            return invokeCommon.intValue;
        }

        public final void p(d.f.b.a.d0.w.o.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048588, this, bVar) == null) {
                d.f.b.a.d0.w.o.b bVar2 = this.f32866h;
                long elapsedRealtime = SystemClock.elapsedRealtime();
                this.f32867i = elapsedRealtime;
                d.f.b.a.d0.w.o.b r = this.o.r(bVar2, bVar);
                this.f32866h = r;
                if (r != bVar2) {
                    this.n = null;
                    this.j = elapsedRealtime;
                    this.o.G(this.f32863e, r);
                } else if (!r.l) {
                    int size = bVar.f70061h + bVar.p.size();
                    d.f.b.a.d0.w.o.b bVar3 = this.f32866h;
                    if (size < bVar3.f70061h) {
                        this.n = new PlaylistResetException(this.f32863e.f70054a, null);
                    } else if (elapsedRealtime - this.j > d.f.b.a.b.b(bVar3.j) * 3.5d) {
                        this.n = new PlaylistStuckException(this.f32863e.f70054a, null);
                        d();
                    }
                }
                d.f.b.a.d0.w.o.b bVar4 = this.f32866h;
                long j = bVar4.j;
                if (bVar4 == bVar2) {
                    j /= 2;
                }
                this.k = elapsedRealtime + d.f.b.a.b.b(j);
                if (this.f32863e != this.o.p || this.f32866h.l) {
                    return;
                }
                g();
            }
        }

        public void q() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
                this.f32864f.i();
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
                this.m = false;
                h();
            }
        }
    }

    /* loaded from: classes5.dex */
    public interface c {
        void a(a.C1980a c1980a, long j);

        void f();
    }

    /* loaded from: classes5.dex */
    public interface d {
        void c(d.f.b.a.d0.w.o.b bVar);
    }

    public HlsPlaylistTracker(Uri uri, e eVar, b.a aVar, int i2, d dVar, o.a<d.f.b.a.d0.w.o.c> aVar2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {uri, eVar, aVar, Integer.valueOf(i2), dVar, aVar2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f32858e = uri;
        this.f32859f = eVar;
        this.n = aVar;
        this.f32861h = i2;
        this.k = dVar;
        this.f32860g = aVar2;
        this.l = new ArrayList();
        this.m = new Loader("HlsPlaylistTracker:MasterPlaylist");
        this.f32862i = new IdentityHashMap<>();
        this.j = new Handler();
    }

    public static b.a q(d.f.b.a.d0.w.o.b bVar, d.f.b.a.d0.w.o.b bVar2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65548, null, bVar, bVar2)) == null) {
            int i2 = bVar2.f70061h - bVar.f70061h;
            List<b.a> list = bVar.p;
            if (i2 < list.size()) {
                return list.get(i2);
            }
            return null;
        }
        return (b.a) invokeLL.objValue;
    }

    public void A(a.C1980a c1980a) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, c1980a) == null) {
            this.f32862i.get(c1980a).i();
        }
    }

    public void B() throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.m.a();
            a.C1980a c1980a = this.p;
            if (c1980a != null) {
                A(c1980a);
            }
        }
    }

    public final void C(a.C1980a c1980a, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(Constants.METHOD_SEND_USER_MSG, this, c1980a, j) == null) {
            int size = this.l.size();
            for (int i2 = 0; i2 < size; i2++) {
                this.l.get(i2).a(c1980a, j);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.android.exoplayer2.upstream.Loader.a
    /* renamed from: D */
    public void l(o<d.f.b.a.d0.w.o.c> oVar, long j, long j2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{oVar, Long.valueOf(j), Long.valueOf(j2), Boolean.valueOf(z)}) == null) {
            this.n.g(oVar.f70437a, 4, j, j2, oVar.d());
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.android.exoplayer2.upstream.Loader.a
    /* renamed from: E */
    public void m(o<d.f.b.a.d0.w.o.c> oVar, long j, long j2) {
        d.f.b.a.d0.w.o.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{oVar, Long.valueOf(j), Long.valueOf(j2)}) == null) {
            d.f.b.a.d0.w.o.c e2 = oVar.e();
            boolean z = e2 instanceof d.f.b.a.d0.w.o.b;
            if (z) {
                aVar = d.f.b.a.d0.w.o.a.a(e2.f70068a);
            } else {
                aVar = (d.f.b.a.d0.w.o.a) e2;
            }
            this.o = aVar;
            this.p = aVar.f70049c.get(0);
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(aVar.f70049c);
            arrayList.addAll(aVar.f70050d);
            arrayList.addAll(aVar.f70051e);
            p(arrayList);
            b bVar = this.f32862i.get(this.p);
            if (z) {
                bVar.p((d.f.b.a.d0.w.o.b) e2);
            } else {
                bVar.g();
            }
            this.n.i(oVar.f70437a, 4, j, j2, oVar.d());
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.android.exoplayer2.upstream.Loader.a
    /* renamed from: F */
    public int n(o<d.f.b.a.d0.w.o.c> oVar, long j, long j2, IOException iOException) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048581, this, new Object[]{oVar, Long.valueOf(j), Long.valueOf(j2), iOException})) == null) {
            boolean z = iOException instanceof ParserException;
            this.n.k(oVar.f70437a, 4, j, j2, oVar.d(), iOException, z);
            return z ? 3 : 0;
        }
        return invokeCommon.intValue;
    }

    public final void G(a.C1980a c1980a, d.f.b.a.d0.w.o.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, c1980a, bVar) == null) {
            if (c1980a == this.p) {
                if (this.q == null) {
                    this.r = !bVar.l;
                }
                this.q = bVar;
                this.k.c(bVar);
            }
            int size = this.l.size();
            for (int i2 = 0; i2 < size; i2++) {
                this.l.get(i2).f();
            }
        }
    }

    public void H(a.C1980a c1980a) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, c1980a) == null) {
            this.f32862i.get(c1980a).g();
        }
    }

    public void I() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.m.i();
            for (b bVar : this.f32862i.values()) {
                bVar.q();
            }
            this.j.removeCallbacksAndMessages(null);
            this.f32862i.clear();
        }
    }

    public void J(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, cVar) == null) {
            this.l.remove(cVar);
        }
    }

    public void K() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            this.m.k(new o(this.f32859f.a(4), this.f32858e, 4, this.f32860g), this, this.f32861h);
        }
    }

    public void o(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, cVar) == null) {
            this.l.add(cVar);
        }
    }

    public final void p(List<a.C1980a> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, list) == null) {
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                a.C1980a c1980a = list.get(i2);
                this.f32862i.put(c1980a, new b(this, c1980a));
            }
        }
    }

    public final d.f.b.a.d0.w.o.b r(d.f.b.a.d0.w.o.b bVar, d.f.b.a.d0.w.o.b bVar2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048592, this, bVar, bVar2)) == null) {
            if (bVar2.d(bVar)) {
                return bVar2.a(t(bVar, bVar2), s(bVar, bVar2));
            }
            return bVar2.l ? bVar.b() : bVar;
        }
        return (d.f.b.a.d0.w.o.b) invokeLL.objValue;
    }

    public final int s(d.f.b.a.d0.w.o.b bVar, d.f.b.a.d0.w.o.b bVar2) {
        InterceptResult invokeLL;
        b.a q;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048593, this, bVar, bVar2)) == null) {
            if (bVar2.f70059f) {
                return bVar2.f70060g;
            }
            d.f.b.a.d0.w.o.b bVar3 = this.q;
            int i2 = bVar3 != null ? bVar3.f70060g : 0;
            return (bVar == null || (q = q(bVar, bVar2)) == null) ? i2 : (bVar.f70060g + q.f70065g) - bVar2.p.get(0).f70065g;
        }
        return invokeLL.intValue;
    }

    public final long t(d.f.b.a.d0.w.o.b bVar, d.f.b.a.d0.w.o.b bVar2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048594, this, bVar, bVar2)) == null) {
            if (bVar2.m) {
                return bVar2.f70058e;
            }
            d.f.b.a.d0.w.o.b bVar3 = this.q;
            long j = bVar3 != null ? bVar3.f70058e : 0L;
            if (bVar == null) {
                return j;
            }
            int size = bVar.p.size();
            b.a q = q(bVar, bVar2);
            if (q != null) {
                return bVar.f70058e + q.f70066h;
            }
            return size == bVar2.f70061h - bVar.f70061h ? bVar.c() : j;
        }
        return invokeLL.longValue;
    }

    public d.f.b.a.d0.w.o.a u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.o : (d.f.b.a.d0.w.o.a) invokeV.objValue;
    }

    public d.f.b.a.d0.w.o.b v(a.C1980a c1980a) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048596, this, c1980a)) == null) {
            d.f.b.a.d0.w.o.b e2 = this.f32862i.get(c1980a).e();
            if (e2 != null) {
                z(c1980a);
            }
            return e2;
        }
        return (d.f.b.a.d0.w.o.b) invokeL.objValue;
    }

    public boolean w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? this.r : invokeV.booleanValue;
    }

    public boolean x(a.C1980a c1980a) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048598, this, c1980a)) == null) ? this.f32862i.get(c1980a).f() : invokeL.booleanValue;
    }

    public final boolean y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            List<a.C1980a> list = this.o.f70049c;
            int size = list.size();
            long elapsedRealtime = SystemClock.elapsedRealtime();
            for (int i2 = 0; i2 < size; i2++) {
                b bVar = this.f32862i.get(list.get(i2));
                if (elapsedRealtime > bVar.l) {
                    this.p = bVar.f32863e;
                    bVar.g();
                    return true;
                }
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void z(a.C1980a c1980a) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048600, this, c1980a) == null) && c1980a != this.p && this.o.f70049c.contains(c1980a)) {
            d.f.b.a.d0.w.o.b bVar = this.q;
            if (bVar == null || !bVar.l) {
                this.p = c1980a;
                this.f32862i.get(c1980a).g();
            }
        }
    }
}
