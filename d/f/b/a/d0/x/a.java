package d.f.b.a.d0.x;

import android.net.Uri;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.source.BehindLiveWindowException;
import d.f.b.a.a0.q.j;
import d.f.b.a.a0.q.k;
import d.f.b.a.d0.u.h;
import d.f.b.a.d0.u.i;
import d.f.b.a.d0.u.l;
import d.f.b.a.d0.x.b;
import d.f.b.a.d0.x.e.a;
import d.f.b.a.f0.f;
import d.f.b.a.h0.e;
import d.f.b.a.h0.g;
import d.f.b.a.h0.n;
import java.io.IOException;
/* loaded from: classes8.dex */
public class a implements b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final n f70536a;

    /* renamed from: b  reason: collision with root package name */
    public final int f70537b;

    /* renamed from: c  reason: collision with root package name */
    public final f f70538c;

    /* renamed from: d  reason: collision with root package name */
    public final d.f.b.a.d0.u.d[] f70539d;

    /* renamed from: e  reason: collision with root package name */
    public final e f70540e;

    /* renamed from: f  reason: collision with root package name */
    public d.f.b.a.d0.x.e.a f70541f;

    /* renamed from: g  reason: collision with root package name */
    public int f70542g;

    /* renamed from: h  reason: collision with root package name */
    public IOException f70543h;

    /* renamed from: d.f.b.a.d0.x.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static final class C1980a implements b.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final e.a f70544a;

        public C1980a(e.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f70544a = aVar;
        }

        @Override // d.f.b.a.d0.x.b.a
        public b a(n nVar, d.f.b.a.d0.x.e.a aVar, int i2, f fVar, k[] kVarArr) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{nVar, aVar, Integer.valueOf(i2), fVar, kVarArr})) == null) ? new a(nVar, aVar, i2, fVar, this.f70544a.a(), kVarArr) : (b) invokeCommon.objValue;
        }
    }

    public a(n nVar, d.f.b.a.d0.x.e.a aVar, int i2, f fVar, e eVar, k[] kVarArr) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r3;
            Object[] objArr = {nVar, aVar, Integer.valueOf(i2), fVar, eVar, kVarArr};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f70536a = nVar;
        this.f70541f = aVar;
        this.f70537b = i2;
        this.f70538c = fVar;
        this.f70540e = eVar;
        a.b bVar = aVar.f70558c[i2];
        this.f70539d = new d.f.b.a.d0.u.d[fVar.length()];
        int i5 = 0;
        while (i5 < this.f70539d.length) {
            int b2 = fVar.b(i5);
            Format format = bVar.f70565c[b2];
            int i6 = i5;
            this.f70539d[i6] = new d.f.b.a.d0.u.d(new d.f.b.a.a0.q.e(3, null, new j(b2, bVar.f70563a, bVar.f70564b, -9223372036854775807L, aVar.f70559d, format, 0, kVarArr, bVar.f70563a == 2 ? 4 : 0, null, null), null), bVar.f70563a, format);
            i5 = i6 + 1;
        }
    }

    public static l g(Format format, e eVar, Uri uri, String str, int i2, long j, long j2, int i3, Object obj, d.f.b.a.d0.u.d dVar) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{format, eVar, uri, str, Integer.valueOf(i2), Long.valueOf(j), Long.valueOf(j2), Integer.valueOf(i3), obj, dVar})) == null) ? new i(eVar, new g(uri, 0L, -1L, str), format, i3, obj, j, j2, i2, 1, j, dVar) : (l) invokeCommon.objValue;
    }

    @Override // d.f.b.a.d0.u.g
    public void a() throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            IOException iOException = this.f70543h;
            if (iOException == null) {
                this.f70536a.a();
                return;
            }
            throw iOException;
        }
    }

    @Override // d.f.b.a.d0.x.b
    public void b(d.f.b.a.d0.x.e.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
            a.b[] bVarArr = this.f70541f.f70558c;
            int i2 = this.f70537b;
            a.b bVar = bVarArr[i2];
            int i3 = bVar.f70566d;
            a.b bVar2 = aVar.f70558c[i2];
            if (i3 != 0 && bVar2.f70566d != 0) {
                int i4 = i3 - 1;
                long d2 = bVar.d(i4) + bVar.b(i4);
                long d3 = bVar2.d(0);
                if (d2 <= d3) {
                    this.f70542g += i3;
                } else {
                    this.f70542g += bVar.c(d3);
                }
            } else {
                this.f70542g += i3;
            }
            this.f70541f = aVar;
        }
    }

    @Override // d.f.b.a.d0.u.g
    public void c(d.f.b.a.d0.u.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, cVar) == null) {
        }
    }

    @Override // d.f.b.a.d0.u.g
    public boolean d(d.f.b.a.d0.u.c cVar, boolean z, Exception exc) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{cVar, Boolean.valueOf(z), exc})) == null) {
            if (z) {
                f fVar = this.f70538c;
                if (h.a(fVar, fVar.k(cVar.f70316c), exc)) {
                    return true;
                }
            }
            return false;
        }
        return invokeCommon.booleanValue;
    }

    @Override // d.f.b.a.d0.u.g
    public final void f(l lVar, long j, long j2, d.f.b.a.d0.u.e eVar) {
        int e2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{lVar, Long.valueOf(j), Long.valueOf(j2), eVar}) == null) && this.f70543h == null) {
            d.f.b.a.d0.x.e.a aVar = this.f70541f;
            a.b bVar = aVar.f70558c[this.f70537b];
            if (bVar.f70566d == 0) {
                eVar.f70333b = !aVar.f70556a;
                return;
            }
            if (lVar == null) {
                e2 = bVar.c(j2);
            } else {
                e2 = lVar.e() - this.f70542g;
                if (e2 < 0) {
                    this.f70543h = new BehindLiveWindowException();
                    return;
                }
            }
            int i2 = e2;
            if (i2 >= bVar.f70566d) {
                eVar.f70333b = !this.f70541f.f70556a;
                return;
            }
            this.f70538c.i(j, j2 - j, h(j));
            long d2 = bVar.d(i2);
            long b2 = d2 + bVar.b(i2);
            int i3 = i2 + this.f70542g;
            int a2 = this.f70538c.a();
            eVar.f70332a = g(this.f70538c.f(), this.f70540e, bVar.a(this.f70538c.b(a2), i2), null, i3, d2, b2, this.f70538c.l(), this.f70538c.j(), this.f70539d[a2]);
        }
    }

    public final long h(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048581, this, j)) == null) {
            d.f.b.a.d0.x.e.a aVar = this.f70541f;
            if (aVar.f70556a) {
                a.b bVar = aVar.f70558c[this.f70537b];
                int i2 = bVar.f70566d - 1;
                return (bVar.d(i2) + bVar.b(i2)) - j;
            }
            return -9223372036854775807L;
        }
        return invokeJ.longValue;
    }
}
