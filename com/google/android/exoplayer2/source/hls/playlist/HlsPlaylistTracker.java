package com.google.android.exoplayer2.source.hls.playlist;

import android.net.Uri;
import android.os.Handler;
import android.os.SystemClock;
import androidx.core.view.InputDeviceCompat;
import c.i.b.a.d0.b;
import c.i.b.a.d0.u.h;
import c.i.b.a.d0.w.e;
import c.i.b.a.d0.w.o.a;
import c.i.b.a.d0.w.o.b;
import c.i.b.a.h0.o;
import c.i.b.a.i0.u;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.upstream.Loader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.IdentityHashMap;
import java.util.List;
/* loaded from: classes9.dex */
public final class HlsPlaylistTracker implements Loader.a<o<c.i.b.a.d0.w.o.c>> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public final Uri f69940e;

    /* renamed from: f  reason: collision with root package name */
    public final e f69941f;

    /* renamed from: g  reason: collision with root package name */
    public final o.a<c.i.b.a.d0.w.o.c> f69942g;

    /* renamed from: h  reason: collision with root package name */
    public final int f69943h;

    /* renamed from: i  reason: collision with root package name */
    public final IdentityHashMap<a.C1487a, b> f69944i;

    /* renamed from: j  reason: collision with root package name */
    public final Handler f69945j;
    public final d k;
    public final List<c> l;
    public final Loader m;
    public final b.a n;
    public c.i.b.a.d0.w.o.a o;
    public a.C1487a p;
    public c.i.b.a.d0.w.o.b q;
    public boolean r;

    /* loaded from: classes9.dex */
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

    /* loaded from: classes9.dex */
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

    /* loaded from: classes9.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes9.dex */
    public final class b implements Loader.a<o<c.i.b.a.d0.w.o.c>>, Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final a.C1487a f69946e;

        /* renamed from: f  reason: collision with root package name */
        public final Loader f69947f;

        /* renamed from: g  reason: collision with root package name */
        public final o<c.i.b.a.d0.w.o.c> f69948g;

        /* renamed from: h  reason: collision with root package name */
        public c.i.b.a.d0.w.o.b f69949h;

        /* renamed from: i  reason: collision with root package name */
        public long f69950i;

        /* renamed from: j  reason: collision with root package name */
        public long f69951j;
        public long k;
        public long l;
        public boolean m;
        public IOException n;
        public final /* synthetic */ HlsPlaylistTracker o;

        public b(HlsPlaylistTracker hlsPlaylistTracker, a.C1487a c1487a) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hlsPlaylistTracker, c1487a};
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
            this.f69946e = c1487a;
            this.f69947f = new Loader("HlsPlaylistTracker:MediaPlaylist");
            this.f69948g = new o<>(hlsPlaylistTracker.f69941f.a(4), u.d(hlsPlaylistTracker.o.f33256a, c1487a.f33240a), 4, hlsPlaylistTracker.f69942g);
        }

        public final boolean d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                this.l = SystemClock.elapsedRealtime() + 60000;
                this.o.C(this.f69946e, 60000L);
                return this.o.p == this.f69946e && !this.o.y();
            }
            return invokeV.booleanValue;
        }

        public c.i.b.a.d0.w.o.b e() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f69949h : (c.i.b.a.d0.w.o.b) invokeV.objValue;
        }

        public boolean f() {
            InterceptResult invokeV;
            int i2;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                if (this.f69949h == null) {
                    return false;
                }
                long elapsedRealtime = SystemClock.elapsedRealtime();
                long max = Math.max(30000L, c.i.b.a.b.b(this.f69949h.q));
                c.i.b.a.d0.w.o.b bVar = this.f69949h;
                return bVar.l || (i2 = bVar.f33242c) == 2 || i2 == 1 || this.f69950i + max > elapsedRealtime;
            }
            return invokeV.booleanValue;
        }

        public void g() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                this.l = 0L;
                if (this.m || this.f69947f.g()) {
                    return;
                }
                long elapsedRealtime = SystemClock.elapsedRealtime();
                if (elapsedRealtime < this.k) {
                    this.m = true;
                    this.o.f69945j.postDelayed(this, this.k - elapsedRealtime);
                    return;
                }
                h();
            }
        }

        public final void h() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
                this.f69947f.k(this.f69948g, this, this.o.f69943h);
            }
        }

        public void i() throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
                this.f69947f.a();
                IOException iOException = this.n;
                if (iOException != null) {
                    throw iOException;
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.android.exoplayer2.upstream.Loader.a
        /* renamed from: j */
        public void l(o<c.i.b.a.d0.w.o.c> oVar, long j2, long j3, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{oVar, Long.valueOf(j2), Long.valueOf(j3), Boolean.valueOf(z)}) == null) {
                this.o.n.g(oVar.f33649a, 4, j2, j3, oVar.c());
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.android.exoplayer2.upstream.Loader.a
        /* renamed from: k */
        public void m(o<c.i.b.a.d0.w.o.c> oVar, long j2, long j3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{oVar, Long.valueOf(j2), Long.valueOf(j3)}) == null) {
                c.i.b.a.d0.w.o.c d2 = oVar.d();
                if (d2 instanceof c.i.b.a.d0.w.o.b) {
                    p((c.i.b.a.d0.w.o.b) d2);
                    this.o.n.i(oVar.f33649a, 4, j2, j3, oVar.c());
                    return;
                }
                this.n = new ParserException("Loaded playlist has unexpected type.");
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.android.exoplayer2.upstream.Loader.a
        /* renamed from: o */
        public int n(o<c.i.b.a.d0.w.o.c> oVar, long j2, long j3, IOException iOException) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048587, this, new Object[]{oVar, Long.valueOf(j2), Long.valueOf(j3), iOException})) == null) {
                boolean z = iOException instanceof ParserException;
                this.o.n.k(oVar.f33649a, 4, j2, j3, oVar.c(), iOException, z);
                if (z) {
                    return 3;
                }
                return h.c(iOException) ? d() : true ? 0 : 2;
            }
            return invokeCommon.intValue;
        }

        public final void p(c.i.b.a.d0.w.o.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048588, this, bVar) == null) {
                c.i.b.a.d0.w.o.b bVar2 = this.f69949h;
                long elapsedRealtime = SystemClock.elapsedRealtime();
                this.f69950i = elapsedRealtime;
                c.i.b.a.d0.w.o.b r = this.o.r(bVar2, bVar);
                this.f69949h = r;
                if (r != bVar2) {
                    this.n = null;
                    this.f69951j = elapsedRealtime;
                    this.o.G(this.f69946e, r);
                } else if (!r.l) {
                    int size = bVar.f33247h + bVar.p.size();
                    c.i.b.a.d0.w.o.b bVar3 = this.f69949h;
                    if (size < bVar3.f33247h) {
                        this.n = new PlaylistResetException(this.f69946e.f33240a, null);
                    } else if (elapsedRealtime - this.f69951j > c.i.b.a.b.b(bVar3.f33249j) * 3.5d) {
                        this.n = new PlaylistStuckException(this.f69946e.f33240a, null);
                        d();
                    }
                }
                c.i.b.a.d0.w.o.b bVar4 = this.f69949h;
                long j2 = bVar4.f33249j;
                if (bVar4 == bVar2) {
                    j2 /= 2;
                }
                this.k = elapsedRealtime + c.i.b.a.b.b(j2);
                if (this.f69946e != this.o.p || this.f69949h.l) {
                    return;
                }
                g();
            }
        }

        public void q() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
                this.f69947f.i();
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

    /* loaded from: classes9.dex */
    public interface c {
        void a(a.C1487a c1487a, long j2);

        void f();
    }

    /* loaded from: classes9.dex */
    public interface d {
        void c(c.i.b.a.d0.w.o.b bVar);
    }

    public HlsPlaylistTracker(Uri uri, e eVar, b.a aVar, int i2, d dVar, o.a<c.i.b.a.d0.w.o.c> aVar2) {
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
        this.f69940e = uri;
        this.f69941f = eVar;
        this.n = aVar;
        this.f69943h = i2;
        this.k = dVar;
        this.f69942g = aVar2;
        this.l = new ArrayList();
        this.m = new Loader("HlsPlaylistTracker:MasterPlaylist");
        this.f69944i = new IdentityHashMap<>();
        this.f69945j = new Handler();
    }

    public static b.a q(c.i.b.a.d0.w.o.b bVar, c.i.b.a.d0.w.o.b bVar2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65548, null, bVar, bVar2)) == null) {
            int i2 = bVar2.f33247h - bVar.f33247h;
            List<b.a> list = bVar.p;
            if (i2 < list.size()) {
                return list.get(i2);
            }
            return null;
        }
        return (b.a) invokeLL.objValue;
    }

    public void A(a.C1487a c1487a) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, c1487a) == null) {
            this.f69944i.get(c1487a).i();
        }
    }

    public void B() throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.m.a();
            a.C1487a c1487a = this.p;
            if (c1487a != null) {
                A(c1487a);
            }
        }
    }

    public final void C(a.C1487a c1487a, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(Constants.METHOD_SEND_USER_MSG, this, c1487a, j2) == null) {
            int size = this.l.size();
            for (int i2 = 0; i2 < size; i2++) {
                this.l.get(i2).a(c1487a, j2);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.android.exoplayer2.upstream.Loader.a
    /* renamed from: D */
    public void l(o<c.i.b.a.d0.w.o.c> oVar, long j2, long j3, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{oVar, Long.valueOf(j2), Long.valueOf(j3), Boolean.valueOf(z)}) == null) {
            this.n.g(oVar.f33649a, 4, j2, j3, oVar.c());
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.android.exoplayer2.upstream.Loader.a
    /* renamed from: E */
    public void m(o<c.i.b.a.d0.w.o.c> oVar, long j2, long j3) {
        c.i.b.a.d0.w.o.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{oVar, Long.valueOf(j2), Long.valueOf(j3)}) == null) {
            c.i.b.a.d0.w.o.c d2 = oVar.d();
            boolean z = d2 instanceof c.i.b.a.d0.w.o.b;
            if (z) {
                aVar = c.i.b.a.d0.w.o.a.a(d2.f33256a);
            } else {
                aVar = (c.i.b.a.d0.w.o.a) d2;
            }
            this.o = aVar;
            this.p = aVar.f33235c.get(0);
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(aVar.f33235c);
            arrayList.addAll(aVar.f33236d);
            arrayList.addAll(aVar.f33237e);
            p(arrayList);
            b bVar = this.f69944i.get(this.p);
            if (z) {
                bVar.p((c.i.b.a.d0.w.o.b) d2);
            } else {
                bVar.g();
            }
            this.n.i(oVar.f33649a, 4, j2, j3, oVar.c());
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.android.exoplayer2.upstream.Loader.a
    /* renamed from: F */
    public int n(o<c.i.b.a.d0.w.o.c> oVar, long j2, long j3, IOException iOException) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048581, this, new Object[]{oVar, Long.valueOf(j2), Long.valueOf(j3), iOException})) == null) {
            boolean z = iOException instanceof ParserException;
            this.n.k(oVar.f33649a, 4, j2, j3, oVar.c(), iOException, z);
            return z ? 3 : 0;
        }
        return invokeCommon.intValue;
    }

    public final void G(a.C1487a c1487a, c.i.b.a.d0.w.o.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, c1487a, bVar) == null) {
            if (c1487a == this.p) {
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

    public void H(a.C1487a c1487a) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, c1487a) == null) {
            this.f69944i.get(c1487a).g();
        }
    }

    public void I() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.m.i();
            for (b bVar : this.f69944i.values()) {
                bVar.q();
            }
            this.f69945j.removeCallbacksAndMessages(null);
            this.f69944i.clear();
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
            this.m.k(new o(this.f69941f.a(4), this.f69940e, 4, this.f69942g), this, this.f69943h);
        }
    }

    public void o(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, cVar) == null) {
            this.l.add(cVar);
        }
    }

    public final void p(List<a.C1487a> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, list) == null) {
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                a.C1487a c1487a = list.get(i2);
                this.f69944i.put(c1487a, new b(this, c1487a));
            }
        }
    }

    public final c.i.b.a.d0.w.o.b r(c.i.b.a.d0.w.o.b bVar, c.i.b.a.d0.w.o.b bVar2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048592, this, bVar, bVar2)) == null) {
            if (bVar2.d(bVar)) {
                return bVar2.a(t(bVar, bVar2), s(bVar, bVar2));
            }
            return bVar2.l ? bVar.b() : bVar;
        }
        return (c.i.b.a.d0.w.o.b) invokeLL.objValue;
    }

    public final int s(c.i.b.a.d0.w.o.b bVar, c.i.b.a.d0.w.o.b bVar2) {
        InterceptResult invokeLL;
        b.a q;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048593, this, bVar, bVar2)) == null) {
            if (bVar2.f33245f) {
                return bVar2.f33246g;
            }
            c.i.b.a.d0.w.o.b bVar3 = this.q;
            int i2 = bVar3 != null ? bVar3.f33246g : 0;
            return (bVar == null || (q = q(bVar, bVar2)) == null) ? i2 : (bVar.f33246g + q.f33252g) - bVar2.p.get(0).f33252g;
        }
        return invokeLL.intValue;
    }

    public final long t(c.i.b.a.d0.w.o.b bVar, c.i.b.a.d0.w.o.b bVar2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048594, this, bVar, bVar2)) == null) {
            if (bVar2.m) {
                return bVar2.f33244e;
            }
            c.i.b.a.d0.w.o.b bVar3 = this.q;
            long j2 = bVar3 != null ? bVar3.f33244e : 0L;
            if (bVar == null) {
                return j2;
            }
            int size = bVar.p.size();
            b.a q = q(bVar, bVar2);
            if (q != null) {
                return bVar.f33244e + q.f33253h;
            }
            return size == bVar2.f33247h - bVar.f33247h ? bVar.c() : j2;
        }
        return invokeLL.longValue;
    }

    public c.i.b.a.d0.w.o.a u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.o : (c.i.b.a.d0.w.o.a) invokeV.objValue;
    }

    public c.i.b.a.d0.w.o.b v(a.C1487a c1487a) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048596, this, c1487a)) == null) {
            c.i.b.a.d0.w.o.b e2 = this.f69944i.get(c1487a).e();
            if (e2 != null) {
                z(c1487a);
            }
            return e2;
        }
        return (c.i.b.a.d0.w.o.b) invokeL.objValue;
    }

    public boolean w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? this.r : invokeV.booleanValue;
    }

    public boolean x(a.C1487a c1487a) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048598, this, c1487a)) == null) ? this.f69944i.get(c1487a).f() : invokeL.booleanValue;
    }

    public final boolean y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            List<a.C1487a> list = this.o.f33235c;
            int size = list.size();
            long elapsedRealtime = SystemClock.elapsedRealtime();
            for (int i2 = 0; i2 < size; i2++) {
                b bVar = this.f69944i.get(list.get(i2));
                if (elapsedRealtime > bVar.l) {
                    this.p = bVar.f69946e;
                    bVar.g();
                    return true;
                }
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void z(a.C1487a c1487a) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048600, this, c1487a) == null) && c1487a != this.p && this.o.f33235c.contains(c1487a)) {
            c.i.b.a.d0.w.o.b bVar = this.q;
            if (bVar == null || !bVar.l) {
                this.p = c1487a;
                this.f69944i.get(c1487a).g();
            }
        }
    }
}
