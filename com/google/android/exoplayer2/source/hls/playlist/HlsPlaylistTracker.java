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
/* loaded from: classes3.dex */
public final class HlsPlaylistTracker implements Loader.a<o<c.i.b.a.d0.w.o.c>> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public final Uri f54278e;

    /* renamed from: f  reason: collision with root package name */
    public final e f54279f;

    /* renamed from: g  reason: collision with root package name */
    public final o.a<c.i.b.a.d0.w.o.c> f54280g;

    /* renamed from: h  reason: collision with root package name */
    public final int f54281h;

    /* renamed from: i  reason: collision with root package name */
    public final IdentityHashMap<a.C1659a, b> f54282i;

    /* renamed from: j  reason: collision with root package name */
    public final Handler f54283j;
    public final d k;
    public final List<c> l;
    public final Loader m;
    public final b.a n;
    public c.i.b.a.d0.w.o.a o;
    public a.C1659a p;
    public c.i.b.a.d0.w.o.b q;
    public boolean r;

    /* loaded from: classes3.dex */
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

    /* loaded from: classes3.dex */
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

    /* loaded from: classes3.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes3.dex */
    public final class b implements Loader.a<o<c.i.b.a.d0.w.o.c>>, Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final a.C1659a f54284e;

        /* renamed from: f  reason: collision with root package name */
        public final Loader f54285f;

        /* renamed from: g  reason: collision with root package name */
        public final o<c.i.b.a.d0.w.o.c> f54286g;

        /* renamed from: h  reason: collision with root package name */
        public c.i.b.a.d0.w.o.b f54287h;

        /* renamed from: i  reason: collision with root package name */
        public long f54288i;

        /* renamed from: j  reason: collision with root package name */
        public long f54289j;
        public long k;
        public long l;
        public boolean m;
        public IOException n;
        public final /* synthetic */ HlsPlaylistTracker o;

        public b(HlsPlaylistTracker hlsPlaylistTracker, a.C1659a c1659a) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hlsPlaylistTracker, c1659a};
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
            this.f54284e = c1659a;
            this.f54285f = new Loader("HlsPlaylistTracker:MediaPlaylist");
            this.f54286g = new o<>(hlsPlaylistTracker.f54279f.a(4), u.d(hlsPlaylistTracker.o.a, c1659a.a), 4, hlsPlaylistTracker.f54280g);
        }

        public final boolean d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                this.l = SystemClock.elapsedRealtime() + 60000;
                this.o.C(this.f54284e, 60000L);
                return this.o.p == this.f54284e && !this.o.y();
            }
            return invokeV.booleanValue;
        }

        public c.i.b.a.d0.w.o.b e() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f54287h : (c.i.b.a.d0.w.o.b) invokeV.objValue;
        }

        public boolean f() {
            InterceptResult invokeV;
            int i2;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                if (this.f54287h == null) {
                    return false;
                }
                long elapsedRealtime = SystemClock.elapsedRealtime();
                long max = Math.max(30000L, c.i.b.a.b.b(this.f54287h.q));
                c.i.b.a.d0.w.o.b bVar = this.f54287h;
                return bVar.l || (i2 = bVar.f29325c) == 2 || i2 == 1 || this.f54288i + max > elapsedRealtime;
            }
            return invokeV.booleanValue;
        }

        public void g() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                this.l = 0L;
                if (this.m || this.f54285f.g()) {
                    return;
                }
                long elapsedRealtime = SystemClock.elapsedRealtime();
                if (elapsedRealtime < this.k) {
                    this.m = true;
                    this.o.f54283j.postDelayed(this, this.k - elapsedRealtime);
                    return;
                }
                h();
            }
        }

        public final void h() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
                this.f54285f.k(this.f54286g, this, this.o.f54281h);
            }
        }

        public void i() throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
                this.f54285f.a();
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
                this.o.n.g(oVar.a, 4, j2, j3, oVar.b());
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.android.exoplayer2.upstream.Loader.a
        /* renamed from: k */
        public void m(o<c.i.b.a.d0.w.o.c> oVar, long j2, long j3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{oVar, Long.valueOf(j2), Long.valueOf(j3)}) == null) {
                c.i.b.a.d0.w.o.c c2 = oVar.c();
                if (c2 instanceof c.i.b.a.d0.w.o.b) {
                    p((c.i.b.a.d0.w.o.b) c2);
                    this.o.n.i(oVar.a, 4, j2, j3, oVar.b());
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
                this.o.n.k(oVar.a, 4, j2, j3, oVar.b(), iOException, z);
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
                c.i.b.a.d0.w.o.b bVar2 = this.f54287h;
                long elapsedRealtime = SystemClock.elapsedRealtime();
                this.f54288i = elapsedRealtime;
                c.i.b.a.d0.w.o.b r = this.o.r(bVar2, bVar);
                this.f54287h = r;
                if (r != bVar2) {
                    this.n = null;
                    this.f54289j = elapsedRealtime;
                    this.o.G(this.f54284e, r);
                } else if (!r.l) {
                    int size = bVar.f29330h + bVar.p.size();
                    c.i.b.a.d0.w.o.b bVar3 = this.f54287h;
                    if (size < bVar3.f29330h) {
                        this.n = new PlaylistResetException(this.f54284e.a, null);
                    } else if (elapsedRealtime - this.f54289j > c.i.b.a.b.b(bVar3.f29332j) * 3.5d) {
                        this.n = new PlaylistStuckException(this.f54284e.a, null);
                        d();
                    }
                }
                c.i.b.a.d0.w.o.b bVar4 = this.f54287h;
                long j2 = bVar4.f29332j;
                if (bVar4 == bVar2) {
                    j2 /= 2;
                }
                this.k = elapsedRealtime + c.i.b.a.b.b(j2);
                if (this.f54284e != this.o.p || this.f54287h.l) {
                    return;
                }
                g();
            }
        }

        public void q() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
                this.f54285f.i();
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

    /* loaded from: classes3.dex */
    public interface c {
        void a(a.C1659a c1659a, long j2);

        void f();
    }

    /* loaded from: classes3.dex */
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
        this.f54278e = uri;
        this.f54279f = eVar;
        this.n = aVar;
        this.f54281h = i2;
        this.k = dVar;
        this.f54280g = aVar2;
        this.l = new ArrayList();
        this.m = new Loader("HlsPlaylistTracker:MasterPlaylist");
        this.f54282i = new IdentityHashMap<>();
        this.f54283j = new Handler();
    }

    public static b.a q(c.i.b.a.d0.w.o.b bVar, c.i.b.a.d0.w.o.b bVar2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65548, null, bVar, bVar2)) == null) {
            int i2 = bVar2.f29330h - bVar.f29330h;
            List<b.a> list = bVar.p;
            if (i2 < list.size()) {
                return list.get(i2);
            }
            return null;
        }
        return (b.a) invokeLL.objValue;
    }

    public void A(a.C1659a c1659a) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, c1659a) == null) {
            this.f54282i.get(c1659a).i();
        }
    }

    public void B() throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.m.a();
            a.C1659a c1659a = this.p;
            if (c1659a != null) {
                A(c1659a);
            }
        }
    }

    public final void C(a.C1659a c1659a, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(Constants.METHOD_SEND_USER_MSG, this, c1659a, j2) == null) {
            int size = this.l.size();
            for (int i2 = 0; i2 < size; i2++) {
                this.l.get(i2).a(c1659a, j2);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.android.exoplayer2.upstream.Loader.a
    /* renamed from: D */
    public void l(o<c.i.b.a.d0.w.o.c> oVar, long j2, long j3, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{oVar, Long.valueOf(j2), Long.valueOf(j3), Boolean.valueOf(z)}) == null) {
            this.n.g(oVar.a, 4, j2, j3, oVar.b());
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.android.exoplayer2.upstream.Loader.a
    /* renamed from: E */
    public void m(o<c.i.b.a.d0.w.o.c> oVar, long j2, long j3) {
        c.i.b.a.d0.w.o.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{oVar, Long.valueOf(j2), Long.valueOf(j3)}) == null) {
            c.i.b.a.d0.w.o.c c2 = oVar.c();
            boolean z = c2 instanceof c.i.b.a.d0.w.o.b;
            if (z) {
                aVar = c.i.b.a.d0.w.o.a.a(c2.a);
            } else {
                aVar = (c.i.b.a.d0.w.o.a) c2;
            }
            this.o = aVar;
            this.p = aVar.f29319c.get(0);
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(aVar.f29319c);
            arrayList.addAll(aVar.f29320d);
            arrayList.addAll(aVar.f29321e);
            p(arrayList);
            b bVar = this.f54282i.get(this.p);
            if (z) {
                bVar.p((c.i.b.a.d0.w.o.b) c2);
            } else {
                bVar.g();
            }
            this.n.i(oVar.a, 4, j2, j3, oVar.b());
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
            this.n.k(oVar.a, 4, j2, j3, oVar.b(), iOException, z);
            return z ? 3 : 0;
        }
        return invokeCommon.intValue;
    }

    public final void G(a.C1659a c1659a, c.i.b.a.d0.w.o.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, c1659a, bVar) == null) {
            if (c1659a == this.p) {
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

    public void H(a.C1659a c1659a) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, c1659a) == null) {
            this.f54282i.get(c1659a).g();
        }
    }

    public void I() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.m.i();
            for (b bVar : this.f54282i.values()) {
                bVar.q();
            }
            this.f54283j.removeCallbacksAndMessages(null);
            this.f54282i.clear();
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
            this.m.k(new o(this.f54279f.a(4), this.f54278e, 4, this.f54280g), this, this.f54281h);
        }
    }

    public void o(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, cVar) == null) {
            this.l.add(cVar);
        }
    }

    public final void p(List<a.C1659a> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, list) == null) {
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                a.C1659a c1659a = list.get(i2);
                this.f54282i.put(c1659a, new b(this, c1659a));
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
            if (bVar2.f29328f) {
                return bVar2.f29329g;
            }
            c.i.b.a.d0.w.o.b bVar3 = this.q;
            int i2 = bVar3 != null ? bVar3.f29329g : 0;
            return (bVar == null || (q = q(bVar, bVar2)) == null) ? i2 : (bVar.f29329g + q.f29335g) - bVar2.p.get(0).f29335g;
        }
        return invokeLL.intValue;
    }

    public final long t(c.i.b.a.d0.w.o.b bVar, c.i.b.a.d0.w.o.b bVar2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048594, this, bVar, bVar2)) == null) {
            if (bVar2.m) {
                return bVar2.f29327e;
            }
            c.i.b.a.d0.w.o.b bVar3 = this.q;
            long j2 = bVar3 != null ? bVar3.f29327e : 0L;
            if (bVar == null) {
                return j2;
            }
            int size = bVar.p.size();
            b.a q = q(bVar, bVar2);
            if (q != null) {
                return bVar.f29327e + q.f29336h;
            }
            return size == bVar2.f29330h - bVar.f29330h ? bVar.c() : j2;
        }
        return invokeLL.longValue;
    }

    public c.i.b.a.d0.w.o.a u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.o : (c.i.b.a.d0.w.o.a) invokeV.objValue;
    }

    public c.i.b.a.d0.w.o.b v(a.C1659a c1659a) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048596, this, c1659a)) == null) {
            c.i.b.a.d0.w.o.b e2 = this.f54282i.get(c1659a).e();
            if (e2 != null) {
                z(c1659a);
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

    public boolean x(a.C1659a c1659a) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048598, this, c1659a)) == null) ? this.f54282i.get(c1659a).f() : invokeL.booleanValue;
    }

    public final boolean y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            List<a.C1659a> list = this.o.f29319c;
            int size = list.size();
            long elapsedRealtime = SystemClock.elapsedRealtime();
            for (int i2 = 0; i2 < size; i2++) {
                b bVar = this.f54282i.get(list.get(i2));
                if (elapsedRealtime > bVar.l) {
                    this.p = bVar.f54284e;
                    bVar.g();
                    return true;
                }
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void z(a.C1659a c1659a) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048600, this, c1659a) == null) && c1659a != this.p && this.o.f29319c.contains(c1659a)) {
            c.i.b.a.d0.w.o.b bVar = this.q;
            if (bVar == null || !bVar.l) {
                this.p = c1659a;
                this.f54282i.get(c1659a).g();
            }
        }
    }
}
