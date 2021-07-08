package d.f.b.a.d0.w;

import android.net.Uri;
import android.os.Handler;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker;
import d.f.b.a.d0.b;
import d.f.b.a.d0.l;
import d.f.b.a.d0.r;
import d.f.b.a.d0.w.o.b;
import d.f.b.a.h0.e;
import d.f.b.a.h0.o;
import java.io.IOException;
import java.util.List;
/* loaded from: classes8.dex */
public final class j implements d.f.b.a.d0.l, HlsPlaylistTracker.d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public final f f70027e;

    /* renamed from: f  reason: collision with root package name */
    public final Uri f70028f;

    /* renamed from: g  reason: collision with root package name */
    public final e f70029g;

    /* renamed from: h  reason: collision with root package name */
    public final int f70030h;

    /* renamed from: i  reason: collision with root package name */
    public final b.a f70031i;
    public final o.a<d.f.b.a.d0.w.o.c> j;
    public HlsPlaylistTracker k;
    public l.a l;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(310362129, "Ld/f/b/a/d0/w/j;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(310362129, "Ld/f/b/a/d0/w/j;");
                return;
            }
        }
        d.f.b.a.k.a("goog.exo.hls");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public j(Uri uri, e.a aVar, Handler handler, d.f.b.a.d0.b bVar) {
        this(uri, aVar, 3, handler, bVar);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {uri, aVar, handler, bVar};
            interceptable.invokeUnInit(65539, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Uri) objArr2[0], (e.a) objArr2[1], ((Integer) objArr2[2]).intValue(), (Handler) objArr2[3], (d.f.b.a.d0.b) objArr2[4]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
    }

    @Override // d.f.b.a.d0.l
    public void a(d.f.b.a.g gVar, boolean z, l.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{gVar, Boolean.valueOf(z), aVar}) == null) {
            d.f.b.a.i0.a.f(this.k == null);
            HlsPlaylistTracker hlsPlaylistTracker = new HlsPlaylistTracker(this.f70028f, this.f70029g, this.f70031i, this.f70030h, this, this.j);
            this.k = hlsPlaylistTracker;
            this.l = aVar;
            hlsPlaylistTracker.K();
        }
    }

    @Override // d.f.b.a.d0.l
    public void b() throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.k.B();
        }
    }

    @Override // com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker.d
    public void c(d.f.b.a.d0.w.o.b bVar) {
        r rVar;
        long j;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bVar) == null) {
            long j2 = bVar.m ? 0L : -9223372036854775807L;
            long b2 = bVar.m ? d.f.b.a.b.b(bVar.f70058e) : -9223372036854775807L;
            long j3 = bVar.f70057d;
            if (this.k.w()) {
                long j4 = bVar.l ? bVar.f70058e + bVar.q : -9223372036854775807L;
                List<b.a> list = bVar.p;
                if (j3 == -9223372036854775807L) {
                    j = list.isEmpty() ? 0L : list.get(Math.max(0, list.size() - 3)).f70066h;
                } else {
                    j = j3;
                }
                rVar = new r(j2, b2, j4, bVar.q, bVar.f70058e, j, true, !bVar.l);
            } else {
                long j5 = j3 == -9223372036854775807L ? 0L : j3;
                long j6 = bVar.f70058e;
                long j7 = bVar.q;
                rVar = new r(j2, b2, j6 + j7, j7, j6, j5, true, false);
            }
            this.l.c(this, rVar, new g(this.k.u(), bVar));
        }
    }

    @Override // d.f.b.a.d0.l
    public d.f.b.a.d0.k d(l.b bVar, d.f.b.a.h0.b bVar2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, bVar, bVar2)) == null) {
            d.f.b.a.i0.a.a(bVar.f69812a == 0);
            return new i(this.f70027e, this.k, this.f70029g, this.f70030h, this.f70031i, bVar2);
        }
        return (d.f.b.a.d0.k) invokeLL.objValue;
    }

    @Override // d.f.b.a.d0.l
    public void e(d.f.b.a.d0.k kVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, kVar) == null) {
            ((i) kVar).t();
        }
    }

    @Override // d.f.b.a.d0.l
    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            HlsPlaylistTracker hlsPlaylistTracker = this.k;
            if (hlsPlaylistTracker != null) {
                hlsPlaylistTracker.I();
                this.k = null;
            }
            this.l = null;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public j(Uri uri, e.a aVar, int i2, Handler handler, d.f.b.a.d0.b bVar) {
        this(uri, new b(aVar), f.f70021a, i2, handler, bVar, new d.f.b.a.d0.w.o.d());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {uri, aVar, Integer.valueOf(i2), handler, bVar};
            interceptable.invokeUnInit(65538, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Uri) objArr2[0], (e) objArr2[1], (f) objArr2[2], ((Integer) objArr2[3]).intValue(), (Handler) objArr2[4], (d.f.b.a.d0.b) objArr2[5], (o.a) objArr2[6]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
    }

    public j(Uri uri, e eVar, f fVar, int i2, Handler handler, d.f.b.a.d0.b bVar, o.a<d.f.b.a.d0.w.o.c> aVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {uri, eVar, fVar, Integer.valueOf(i2), handler, bVar, aVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f70028f = uri;
        this.f70029g = eVar;
        this.f70027e = fVar;
        this.f70030h = i2;
        this.j = aVar;
        this.f70031i = new b.a(handler, bVar);
    }
}
