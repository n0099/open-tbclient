package com.google.android.exoplayer2.source.hls.playlist;

import android.net.Uri;
import android.os.Handler;
import android.os.SystemClock;
import androidx.core.view.InputDeviceCompat;
import b.h.b.a.d0.b;
import b.h.b.a.d0.u.h;
import b.h.b.a.d0.w.e;
import b.h.b.a.d0.w.o.a;
import b.h.b.a.d0.w.o.b;
import b.h.b.a.h0.o;
import b.h.b.a.i0.u;
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
public final class HlsPlaylistTracker implements Loader.a<o<b.h.b.a.d0.w.o.c>> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public final Uri f63892e;

    /* renamed from: f  reason: collision with root package name */
    public final e f63893f;

    /* renamed from: g  reason: collision with root package name */
    public final o.a<b.h.b.a.d0.w.o.c> f63894g;

    /* renamed from: h  reason: collision with root package name */
    public final int f63895h;

    /* renamed from: i  reason: collision with root package name */
    public final IdentityHashMap<a.C1524a, b> f63896i;
    public final Handler j;
    public final d k;
    public final List<c> l;
    public final Loader m;
    public final b.a n;
    public b.h.b.a.d0.w.o.a o;
    public a.C1524a p;
    public b.h.b.a.d0.w.o.b q;
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
    public final class b implements Loader.a<o<b.h.b.a.d0.w.o.c>>, Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final a.C1524a f63897e;

        /* renamed from: f  reason: collision with root package name */
        public final Loader f63898f;

        /* renamed from: g  reason: collision with root package name */
        public final o<b.h.b.a.d0.w.o.c> f63899g;

        /* renamed from: h  reason: collision with root package name */
        public b.h.b.a.d0.w.o.b f63900h;

        /* renamed from: i  reason: collision with root package name */
        public long f63901i;
        public long j;
        public long k;
        public long l;
        public boolean m;
        public IOException n;
        public final /* synthetic */ HlsPlaylistTracker o;

        public b(HlsPlaylistTracker hlsPlaylistTracker, a.C1524a c1524a) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hlsPlaylistTracker, c1524a};
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
            this.f63897e = c1524a;
            this.f63898f = new Loader("HlsPlaylistTracker:MediaPlaylist");
            this.f63899g = new o<>(hlsPlaylistTracker.f63893f.a(4), u.d(hlsPlaylistTracker.o.f33072a, c1524a.f33058a), 4, hlsPlaylistTracker.f63894g);
        }

        public final boolean d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                this.l = SystemClock.elapsedRealtime() + 60000;
                this.o.C(this.f63897e, 60000L);
                return this.o.p == this.f63897e && !this.o.y();
            }
            return invokeV.booleanValue;
        }

        public b.h.b.a.d0.w.o.b e() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f63900h : (b.h.b.a.d0.w.o.b) invokeV.objValue;
        }

        public boolean f() {
            InterceptResult invokeV;
            int i2;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                if (this.f63900h == null) {
                    return false;
                }
                long elapsedRealtime = SystemClock.elapsedRealtime();
                long max = Math.max(30000L, b.h.b.a.b.b(this.f63900h.q));
                b.h.b.a.d0.w.o.b bVar = this.f63900h;
                return bVar.l || (i2 = bVar.f33060c) == 2 || i2 == 1 || this.f63901i + max > elapsedRealtime;
            }
            return invokeV.booleanValue;
        }

        public void g() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                this.l = 0L;
                if (this.m || this.f63898f.g()) {
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
                this.f63898f.k(this.f63899g, this, this.o.f63895h);
            }
        }

        public void i() throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
                this.f63898f.a();
                IOException iOException = this.n;
                if (iOException != null) {
                    throw iOException;
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.android.exoplayer2.upstream.Loader.a
        /* renamed from: j */
        public void l(o<b.h.b.a.d0.w.o.c> oVar, long j, long j2, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{oVar, Long.valueOf(j), Long.valueOf(j2), Boolean.valueOf(z)}) == null) {
                this.o.n.g(oVar.f33441a, 4, j, j2, oVar.c());
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.android.exoplayer2.upstream.Loader.a
        /* renamed from: k */
        public void m(o<b.h.b.a.d0.w.o.c> oVar, long j, long j2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{oVar, Long.valueOf(j), Long.valueOf(j2)}) == null) {
                b.h.b.a.d0.w.o.c d2 = oVar.d();
                if (d2 instanceof b.h.b.a.d0.w.o.b) {
                    p((b.h.b.a.d0.w.o.b) d2);
                    this.o.n.i(oVar.f33441a, 4, j, j2, oVar.c());
                    return;
                }
                this.n = new ParserException("Loaded playlist has unexpected type.");
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.android.exoplayer2.upstream.Loader.a
        /* renamed from: o */
        public int n(o<b.h.b.a.d0.w.o.c> oVar, long j, long j2, IOException iOException) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048587, this, new Object[]{oVar, Long.valueOf(j), Long.valueOf(j2), iOException})) == null) {
                boolean z = iOException instanceof ParserException;
                this.o.n.k(oVar.f33441a, 4, j, j2, oVar.c(), iOException, z);
                if (z) {
                    return 3;
                }
                return h.c(iOException) ? d() : true ? 0 : 2;
            }
            return invokeCommon.intValue;
        }

        public final void p(b.h.b.a.d0.w.o.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048588, this, bVar) == null) {
                b.h.b.a.d0.w.o.b bVar2 = this.f63900h;
                long elapsedRealtime = SystemClock.elapsedRealtime();
                this.f63901i = elapsedRealtime;
                b.h.b.a.d0.w.o.b r = this.o.r(bVar2, bVar);
                this.f63900h = r;
                if (r != bVar2) {
                    this.n = null;
                    this.j = elapsedRealtime;
                    this.o.G(this.f63897e, r);
                } else if (!r.l) {
                    int size = bVar.f33065h + bVar.p.size();
                    b.h.b.a.d0.w.o.b bVar3 = this.f63900h;
                    if (size < bVar3.f33065h) {
                        this.n = new PlaylistResetException(this.f63897e.f33058a, null);
                    } else if (elapsedRealtime - this.j > b.h.b.a.b.b(bVar3.j) * 3.5d) {
                        this.n = new PlaylistStuckException(this.f63897e.f33058a, null);
                        d();
                    }
                }
                b.h.b.a.d0.w.o.b bVar4 = this.f63900h;
                long j = bVar4.j;
                if (bVar4 == bVar2) {
                    j /= 2;
                }
                this.k = elapsedRealtime + b.h.b.a.b.b(j);
                if (this.f63897e != this.o.p || this.f63900h.l) {
                    return;
                }
                g();
            }
        }

        public void q() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
                this.f63898f.i();
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
        void a(a.C1524a c1524a, long j);

        void f();
    }

    /* loaded from: classes11.dex */
    public interface d {
        void c(b.h.b.a.d0.w.o.b bVar);
    }

    public HlsPlaylistTracker(Uri uri, e eVar, b.a aVar, int i2, d dVar, o.a<b.h.b.a.d0.w.o.c> aVar2) {
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
        this.f63892e = uri;
        this.f63893f = eVar;
        this.n = aVar;
        this.f63895h = i2;
        this.k = dVar;
        this.f63894g = aVar2;
        this.l = new ArrayList();
        this.m = new Loader("HlsPlaylistTracker:MasterPlaylist");
        this.f63896i = new IdentityHashMap<>();
        this.j = new Handler();
    }

    public static b.a q(b.h.b.a.d0.w.o.b bVar, b.h.b.a.d0.w.o.b bVar2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65548, null, bVar, bVar2)) == null) {
            int i2 = bVar2.f33065h - bVar.f33065h;
            List<b.a> list = bVar.p;
            if (i2 < list.size()) {
                return list.get(i2);
            }
            return null;
        }
        return (b.a) invokeLL.objValue;
    }

    public void A(a.C1524a c1524a) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, c1524a) == null) {
            this.f63896i.get(c1524a).i();
        }
    }

    public void B() throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.m.a();
            a.C1524a c1524a = this.p;
            if (c1524a != null) {
                A(c1524a);
            }
        }
    }

    public final void C(a.C1524a c1524a, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(Constants.METHOD_SEND_USER_MSG, this, c1524a, j) == null) {
            int size = this.l.size();
            for (int i2 = 0; i2 < size; i2++) {
                this.l.get(i2).a(c1524a, j);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.android.exoplayer2.upstream.Loader.a
    /* renamed from: D */
    public void l(o<b.h.b.a.d0.w.o.c> oVar, long j, long j2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{oVar, Long.valueOf(j), Long.valueOf(j2), Boolean.valueOf(z)}) == null) {
            this.n.g(oVar.f33441a, 4, j, j2, oVar.c());
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.android.exoplayer2.upstream.Loader.a
    /* renamed from: E */
    public void m(o<b.h.b.a.d0.w.o.c> oVar, long j, long j2) {
        b.h.b.a.d0.w.o.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{oVar, Long.valueOf(j), Long.valueOf(j2)}) == null) {
            b.h.b.a.d0.w.o.c d2 = oVar.d();
            boolean z = d2 instanceof b.h.b.a.d0.w.o.b;
            if (z) {
                aVar = b.h.b.a.d0.w.o.a.a(d2.f33072a);
            } else {
                aVar = (b.h.b.a.d0.w.o.a) d2;
            }
            this.o = aVar;
            this.p = aVar.f33053c.get(0);
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(aVar.f33053c);
            arrayList.addAll(aVar.f33054d);
            arrayList.addAll(aVar.f33055e);
            p(arrayList);
            b bVar = this.f63896i.get(this.p);
            if (z) {
                bVar.p((b.h.b.a.d0.w.o.b) d2);
            } else {
                bVar.g();
            }
            this.n.i(oVar.f33441a, 4, j, j2, oVar.c());
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.android.exoplayer2.upstream.Loader.a
    /* renamed from: F */
    public int n(o<b.h.b.a.d0.w.o.c> oVar, long j, long j2, IOException iOException) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048581, this, new Object[]{oVar, Long.valueOf(j), Long.valueOf(j2), iOException})) == null) {
            boolean z = iOException instanceof ParserException;
            this.n.k(oVar.f33441a, 4, j, j2, oVar.c(), iOException, z);
            return z ? 3 : 0;
        }
        return invokeCommon.intValue;
    }

    public final void G(a.C1524a c1524a, b.h.b.a.d0.w.o.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, c1524a, bVar) == null) {
            if (c1524a == this.p) {
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

    public void H(a.C1524a c1524a) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, c1524a) == null) {
            this.f63896i.get(c1524a).g();
        }
    }

    public void I() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.m.i();
            for (b bVar : this.f63896i.values()) {
                bVar.q();
            }
            this.j.removeCallbacksAndMessages(null);
            this.f63896i.clear();
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
            this.m.k(new o(this.f63893f.a(4), this.f63892e, 4, this.f63894g), this, this.f63895h);
        }
    }

    public void o(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, cVar) == null) {
            this.l.add(cVar);
        }
    }

    public final void p(List<a.C1524a> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, list) == null) {
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                a.C1524a c1524a = list.get(i2);
                this.f63896i.put(c1524a, new b(this, c1524a));
            }
        }
    }

    public final b.h.b.a.d0.w.o.b r(b.h.b.a.d0.w.o.b bVar, b.h.b.a.d0.w.o.b bVar2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048592, this, bVar, bVar2)) == null) {
            if (bVar2.d(bVar)) {
                return bVar2.a(t(bVar, bVar2), s(bVar, bVar2));
            }
            return bVar2.l ? bVar.b() : bVar;
        }
        return (b.h.b.a.d0.w.o.b) invokeLL.objValue;
    }

    public final int s(b.h.b.a.d0.w.o.b bVar, b.h.b.a.d0.w.o.b bVar2) {
        InterceptResult invokeLL;
        b.a q;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048593, this, bVar, bVar2)) == null) {
            if (bVar2.f33063f) {
                return bVar2.f33064g;
            }
            b.h.b.a.d0.w.o.b bVar3 = this.q;
            int i2 = bVar3 != null ? bVar3.f33064g : 0;
            return (bVar == null || (q = q(bVar, bVar2)) == null) ? i2 : (bVar.f33064g + q.f33069g) - bVar2.p.get(0).f33069g;
        }
        return invokeLL.intValue;
    }

    public final long t(b.h.b.a.d0.w.o.b bVar, b.h.b.a.d0.w.o.b bVar2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048594, this, bVar, bVar2)) == null) {
            if (bVar2.m) {
                return bVar2.f33062e;
            }
            b.h.b.a.d0.w.o.b bVar3 = this.q;
            long j = bVar3 != null ? bVar3.f33062e : 0L;
            if (bVar == null) {
                return j;
            }
            int size = bVar.p.size();
            b.a q = q(bVar, bVar2);
            if (q != null) {
                return bVar.f33062e + q.f33070h;
            }
            return size == bVar2.f33065h - bVar.f33065h ? bVar.c() : j;
        }
        return invokeLL.longValue;
    }

    public b.h.b.a.d0.w.o.a u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.o : (b.h.b.a.d0.w.o.a) invokeV.objValue;
    }

    public b.h.b.a.d0.w.o.b v(a.C1524a c1524a) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048596, this, c1524a)) == null) {
            b.h.b.a.d0.w.o.b e2 = this.f63896i.get(c1524a).e();
            if (e2 != null) {
                z(c1524a);
            }
            return e2;
        }
        return (b.h.b.a.d0.w.o.b) invokeL.objValue;
    }

    public boolean w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? this.r : invokeV.booleanValue;
    }

    public boolean x(a.C1524a c1524a) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048598, this, c1524a)) == null) ? this.f63896i.get(c1524a).f() : invokeL.booleanValue;
    }

    public final boolean y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            List<a.C1524a> list = this.o.f33053c;
            int size = list.size();
            long elapsedRealtime = SystemClock.elapsedRealtime();
            for (int i2 = 0; i2 < size; i2++) {
                b bVar = this.f63896i.get(list.get(i2));
                if (elapsedRealtime > bVar.l) {
                    this.p = bVar.f63897e;
                    bVar.g();
                    return true;
                }
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void z(a.C1524a c1524a) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048600, this, c1524a) == null) && c1524a != this.p && this.o.f33053c.contains(c1524a)) {
            b.h.b.a.d0.w.o.b bVar = this.q;
            if (bVar == null || !bVar.l) {
                this.p = c1524a;
                this.f63896i.get(c1524a).g();
            }
        }
    }
}
