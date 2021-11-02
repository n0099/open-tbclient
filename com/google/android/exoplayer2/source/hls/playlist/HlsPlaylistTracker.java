package com.google.android.exoplayer2.source.hls.playlist;

import android.net.Uri;
import android.os.Handler;
import android.os.SystemClock;
import androidx.core.view.InputDeviceCompat;
import b.i.b.a.d0.b;
import b.i.b.a.d0.u.h;
import b.i.b.a.d0.w.e;
import b.i.b.a.d0.w.o.a;
import b.i.b.a.d0.w.o.b;
import b.i.b.a.h0.o;
import b.i.b.a.i0.u;
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
/* loaded from: classes11.dex */
public final class HlsPlaylistTracker implements Loader.a<o<b.i.b.a.d0.w.o.c>> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public final Uri f62993e;

    /* renamed from: f  reason: collision with root package name */
    public final e f62994f;

    /* renamed from: g  reason: collision with root package name */
    public final o.a<b.i.b.a.d0.w.o.c> f62995g;

    /* renamed from: h  reason: collision with root package name */
    public final int f62996h;

    /* renamed from: i  reason: collision with root package name */
    public final IdentityHashMap<a.C1482a, b> f62997i;
    public final Handler j;
    public final d k;
    public final List<c> l;
    public final Loader m;
    public final b.a n;
    public b.i.b.a.d0.w.o.a o;
    public a.C1482a p;
    public b.i.b.a.d0.w.o.b q;
    public boolean r;

    /* loaded from: classes11.dex */
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

    /* loaded from: classes11.dex */
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

    /* loaded from: classes11.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes11.dex */
    public final class b implements Loader.a<o<b.i.b.a.d0.w.o.c>>, Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final a.C1482a f62998e;

        /* renamed from: f  reason: collision with root package name */
        public final Loader f62999f;

        /* renamed from: g  reason: collision with root package name */
        public final o<b.i.b.a.d0.w.o.c> f63000g;

        /* renamed from: h  reason: collision with root package name */
        public b.i.b.a.d0.w.o.b f63001h;

        /* renamed from: i  reason: collision with root package name */
        public long f63002i;
        public long j;
        public long k;
        public long l;
        public boolean m;
        public IOException n;
        public final /* synthetic */ HlsPlaylistTracker o;

        public b(HlsPlaylistTracker hlsPlaylistTracker, a.C1482a c1482a) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hlsPlaylistTracker, c1482a};
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
            this.f62998e = c1482a;
            this.f62999f = new Loader("HlsPlaylistTracker:MediaPlaylist");
            this.f63000g = new o<>(hlsPlaylistTracker.f62994f.a(4), u.d(hlsPlaylistTracker.o.f32214a, c1482a.f32200a), 4, hlsPlaylistTracker.f62995g);
        }

        public final boolean d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                this.l = SystemClock.elapsedRealtime() + 60000;
                this.o.C(this.f62998e, 60000L);
                return this.o.p == this.f62998e && !this.o.y();
            }
            return invokeV.booleanValue;
        }

        public b.i.b.a.d0.w.o.b e() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f63001h : (b.i.b.a.d0.w.o.b) invokeV.objValue;
        }

        public boolean f() {
            InterceptResult invokeV;
            int i2;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                if (this.f63001h == null) {
                    return false;
                }
                long elapsedRealtime = SystemClock.elapsedRealtime();
                long max = Math.max(30000L, b.i.b.a.b.b(this.f63001h.q));
                b.i.b.a.d0.w.o.b bVar = this.f63001h;
                return bVar.l || (i2 = bVar.f32202c) == 2 || i2 == 1 || this.f63002i + max > elapsedRealtime;
            }
            return invokeV.booleanValue;
        }

        public void g() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                this.l = 0L;
                if (this.m || this.f62999f.g()) {
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
                this.f62999f.k(this.f63000g, this, this.o.f62996h);
            }
        }

        public void i() throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
                this.f62999f.a();
                IOException iOException = this.n;
                if (iOException != null) {
                    throw iOException;
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.android.exoplayer2.upstream.Loader.a
        /* renamed from: j */
        public void l(o<b.i.b.a.d0.w.o.c> oVar, long j, long j2, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{oVar, Long.valueOf(j), Long.valueOf(j2), Boolean.valueOf(z)}) == null) {
                this.o.n.g(oVar.f32583a, 4, j, j2, oVar.c());
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.android.exoplayer2.upstream.Loader.a
        /* renamed from: k */
        public void m(o<b.i.b.a.d0.w.o.c> oVar, long j, long j2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{oVar, Long.valueOf(j), Long.valueOf(j2)}) == null) {
                b.i.b.a.d0.w.o.c d2 = oVar.d();
                if (d2 instanceof b.i.b.a.d0.w.o.b) {
                    p((b.i.b.a.d0.w.o.b) d2);
                    this.o.n.i(oVar.f32583a, 4, j, j2, oVar.c());
                    return;
                }
                this.n = new ParserException("Loaded playlist has unexpected type.");
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.android.exoplayer2.upstream.Loader.a
        /* renamed from: o */
        public int n(o<b.i.b.a.d0.w.o.c> oVar, long j, long j2, IOException iOException) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048587, this, new Object[]{oVar, Long.valueOf(j), Long.valueOf(j2), iOException})) == null) {
                boolean z = iOException instanceof ParserException;
                this.o.n.k(oVar.f32583a, 4, j, j2, oVar.c(), iOException, z);
                if (z) {
                    return 3;
                }
                return h.c(iOException) ? d() : true ? 0 : 2;
            }
            return invokeCommon.intValue;
        }

        public final void p(b.i.b.a.d0.w.o.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048588, this, bVar) == null) {
                b.i.b.a.d0.w.o.b bVar2 = this.f63001h;
                long elapsedRealtime = SystemClock.elapsedRealtime();
                this.f63002i = elapsedRealtime;
                b.i.b.a.d0.w.o.b r = this.o.r(bVar2, bVar);
                this.f63001h = r;
                if (r != bVar2) {
                    this.n = null;
                    this.j = elapsedRealtime;
                    this.o.G(this.f62998e, r);
                } else if (!r.l) {
                    int size = bVar.f32207h + bVar.p.size();
                    b.i.b.a.d0.w.o.b bVar3 = this.f63001h;
                    if (size < bVar3.f32207h) {
                        this.n = new PlaylistResetException(this.f62998e.f32200a, null);
                    } else if (elapsedRealtime - this.j > b.i.b.a.b.b(bVar3.j) * 3.5d) {
                        this.n = new PlaylistStuckException(this.f62998e.f32200a, null);
                        d();
                    }
                }
                b.i.b.a.d0.w.o.b bVar4 = this.f63001h;
                long j = bVar4.j;
                if (bVar4 == bVar2) {
                    j /= 2;
                }
                this.k = elapsedRealtime + b.i.b.a.b.b(j);
                if (this.f62998e != this.o.p || this.f63001h.l) {
                    return;
                }
                g();
            }
        }

        public void q() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
                this.f62999f.i();
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

    /* loaded from: classes11.dex */
    public interface c {
        void a(a.C1482a c1482a, long j);

        void f();
    }

    /* loaded from: classes11.dex */
    public interface d {
        void c(b.i.b.a.d0.w.o.b bVar);
    }

    public HlsPlaylistTracker(Uri uri, e eVar, b.a aVar, int i2, d dVar, o.a<b.i.b.a.d0.w.o.c> aVar2) {
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
        this.f62993e = uri;
        this.f62994f = eVar;
        this.n = aVar;
        this.f62996h = i2;
        this.k = dVar;
        this.f62995g = aVar2;
        this.l = new ArrayList();
        this.m = new Loader("HlsPlaylistTracker:MasterPlaylist");
        this.f62997i = new IdentityHashMap<>();
        this.j = new Handler();
    }

    public static b.a q(b.i.b.a.d0.w.o.b bVar, b.i.b.a.d0.w.o.b bVar2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65548, null, bVar, bVar2)) == null) {
            int i2 = bVar2.f32207h - bVar.f32207h;
            List<b.a> list = bVar.p;
            if (i2 < list.size()) {
                return list.get(i2);
            }
            return null;
        }
        return (b.a) invokeLL.objValue;
    }

    public void A(a.C1482a c1482a) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, c1482a) == null) {
            this.f62997i.get(c1482a).i();
        }
    }

    public void B() throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.m.a();
            a.C1482a c1482a = this.p;
            if (c1482a != null) {
                A(c1482a);
            }
        }
    }

    public final void C(a.C1482a c1482a, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(Constants.METHOD_SEND_USER_MSG, this, c1482a, j) == null) {
            int size = this.l.size();
            for (int i2 = 0; i2 < size; i2++) {
                this.l.get(i2).a(c1482a, j);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.android.exoplayer2.upstream.Loader.a
    /* renamed from: D */
    public void l(o<b.i.b.a.d0.w.o.c> oVar, long j, long j2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{oVar, Long.valueOf(j), Long.valueOf(j2), Boolean.valueOf(z)}) == null) {
            this.n.g(oVar.f32583a, 4, j, j2, oVar.c());
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.android.exoplayer2.upstream.Loader.a
    /* renamed from: E */
    public void m(o<b.i.b.a.d0.w.o.c> oVar, long j, long j2) {
        b.i.b.a.d0.w.o.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{oVar, Long.valueOf(j), Long.valueOf(j2)}) == null) {
            b.i.b.a.d0.w.o.c d2 = oVar.d();
            boolean z = d2 instanceof b.i.b.a.d0.w.o.b;
            if (z) {
                aVar = b.i.b.a.d0.w.o.a.a(d2.f32214a);
            } else {
                aVar = (b.i.b.a.d0.w.o.a) d2;
            }
            this.o = aVar;
            this.p = aVar.f32195c.get(0);
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(aVar.f32195c);
            arrayList.addAll(aVar.f32196d);
            arrayList.addAll(aVar.f32197e);
            p(arrayList);
            b bVar = this.f62997i.get(this.p);
            if (z) {
                bVar.p((b.i.b.a.d0.w.o.b) d2);
            } else {
                bVar.g();
            }
            this.n.i(oVar.f32583a, 4, j, j2, oVar.c());
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.android.exoplayer2.upstream.Loader.a
    /* renamed from: F */
    public int n(o<b.i.b.a.d0.w.o.c> oVar, long j, long j2, IOException iOException) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048581, this, new Object[]{oVar, Long.valueOf(j), Long.valueOf(j2), iOException})) == null) {
            boolean z = iOException instanceof ParserException;
            this.n.k(oVar.f32583a, 4, j, j2, oVar.c(), iOException, z);
            return z ? 3 : 0;
        }
        return invokeCommon.intValue;
    }

    public final void G(a.C1482a c1482a, b.i.b.a.d0.w.o.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, c1482a, bVar) == null) {
            if (c1482a == this.p) {
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

    public void H(a.C1482a c1482a) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, c1482a) == null) {
            this.f62997i.get(c1482a).g();
        }
    }

    public void I() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.m.i();
            for (b bVar : this.f62997i.values()) {
                bVar.q();
            }
            this.j.removeCallbacksAndMessages(null);
            this.f62997i.clear();
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
            this.m.k(new o(this.f62994f.a(4), this.f62993e, 4, this.f62995g), this, this.f62996h);
        }
    }

    public void o(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, cVar) == null) {
            this.l.add(cVar);
        }
    }

    public final void p(List<a.C1482a> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, list) == null) {
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                a.C1482a c1482a = list.get(i2);
                this.f62997i.put(c1482a, new b(this, c1482a));
            }
        }
    }

    public final b.i.b.a.d0.w.o.b r(b.i.b.a.d0.w.o.b bVar, b.i.b.a.d0.w.o.b bVar2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048592, this, bVar, bVar2)) == null) {
            if (bVar2.d(bVar)) {
                return bVar2.a(t(bVar, bVar2), s(bVar, bVar2));
            }
            return bVar2.l ? bVar.b() : bVar;
        }
        return (b.i.b.a.d0.w.o.b) invokeLL.objValue;
    }

    public final int s(b.i.b.a.d0.w.o.b bVar, b.i.b.a.d0.w.o.b bVar2) {
        InterceptResult invokeLL;
        b.a q;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048593, this, bVar, bVar2)) == null) {
            if (bVar2.f32205f) {
                return bVar2.f32206g;
            }
            b.i.b.a.d0.w.o.b bVar3 = this.q;
            int i2 = bVar3 != null ? bVar3.f32206g : 0;
            return (bVar == null || (q = q(bVar, bVar2)) == null) ? i2 : (bVar.f32206g + q.f32211g) - bVar2.p.get(0).f32211g;
        }
        return invokeLL.intValue;
    }

    public final long t(b.i.b.a.d0.w.o.b bVar, b.i.b.a.d0.w.o.b bVar2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048594, this, bVar, bVar2)) == null) {
            if (bVar2.m) {
                return bVar2.f32204e;
            }
            b.i.b.a.d0.w.o.b bVar3 = this.q;
            long j = bVar3 != null ? bVar3.f32204e : 0L;
            if (bVar == null) {
                return j;
            }
            int size = bVar.p.size();
            b.a q = q(bVar, bVar2);
            if (q != null) {
                return bVar.f32204e + q.f32212h;
            }
            return size == bVar2.f32207h - bVar.f32207h ? bVar.c() : j;
        }
        return invokeLL.longValue;
    }

    public b.i.b.a.d0.w.o.a u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.o : (b.i.b.a.d0.w.o.a) invokeV.objValue;
    }

    public b.i.b.a.d0.w.o.b v(a.C1482a c1482a) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048596, this, c1482a)) == null) {
            b.i.b.a.d0.w.o.b e2 = this.f62997i.get(c1482a).e();
            if (e2 != null) {
                z(c1482a);
            }
            return e2;
        }
        return (b.i.b.a.d0.w.o.b) invokeL.objValue;
    }

    public boolean w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? this.r : invokeV.booleanValue;
    }

    public boolean x(a.C1482a c1482a) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048598, this, c1482a)) == null) ? this.f62997i.get(c1482a).f() : invokeL.booleanValue;
    }

    public final boolean y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            List<a.C1482a> list = this.o.f32195c;
            int size = list.size();
            long elapsedRealtime = SystemClock.elapsedRealtime();
            for (int i2 = 0; i2 < size; i2++) {
                b bVar = this.f62997i.get(list.get(i2));
                if (elapsedRealtime > bVar.l) {
                    this.p = bVar.f62998e;
                    bVar.g();
                    return true;
                }
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void z(a.C1482a c1482a) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048600, this, c1482a) == null) && c1482a != this.p && this.o.f32195c.contains(c1482a)) {
            b.i.b.a.d0.w.o.b bVar = this.q;
            if (bVar == null || !bVar.l) {
                this.p = c1482a;
                this.f62997i.get(c1482a).g();
            }
        }
    }
}
