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
    public final n f70082a;

    /* renamed from: b  reason: collision with root package name */
    public final int f70083b;

    /* renamed from: c  reason: collision with root package name */
    public final f f70084c;

    /* renamed from: d  reason: collision with root package name */
    public final d.f.b.a.d0.u.d[] f70085d;

    /* renamed from: e  reason: collision with root package name */
    public final e f70086e;

    /* renamed from: f  reason: collision with root package name */
    public d.f.b.a.d0.x.e.a f70087f;

    /* renamed from: g  reason: collision with root package name */
    public int f70088g;

    /* renamed from: h  reason: collision with root package name */
    public IOException f70089h;

    /* renamed from: d.f.b.a.d0.x.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static final class C1981a implements b.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final e.a f70090a;

        public C1981a(e.a aVar) {
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
            this.f70090a = aVar;
        }

        @Override // d.f.b.a.d0.x.b.a
        public b a(n nVar, d.f.b.a.d0.x.e.a aVar, int i2, f fVar, k[] kVarArr) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{nVar, aVar, Integer.valueOf(i2), fVar, kVarArr})) == null) ? new a(nVar, aVar, i2, fVar, this.f70090a.a(), kVarArr) : (b) invokeCommon.objValue;
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
        this.f70082a = nVar;
        this.f70087f = aVar;
        this.f70083b = i2;
        this.f70084c = fVar;
        this.f70086e = eVar;
        a.b bVar = aVar.f70104c[i2];
        this.f70085d = new d.f.b.a.d0.u.d[fVar.length()];
        int i5 = 0;
        while (i5 < this.f70085d.length) {
            int b2 = fVar.b(i5);
            Format format = bVar.f70111c[b2];
            int i6 = i5;
            this.f70085d[i6] = new d.f.b.a.d0.u.d(new d.f.b.a.a0.q.e(3, null, new j(b2, bVar.f70109a, bVar.f70110b, -9223372036854775807L, aVar.f70105d, format, 0, kVarArr, bVar.f70109a == 2 ? 4 : 0, null, null), null), bVar.f70109a, format);
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
            IOException iOException = this.f70089h;
            if (iOException == null) {
                this.f70082a.a();
                return;
            }
            throw iOException;
        }
    }

    @Override // d.f.b.a.d0.x.b
    public void b(d.f.b.a.d0.x.e.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
            a.b[] bVarArr = this.f70087f.f70104c;
            int i2 = this.f70083b;
            a.b bVar = bVarArr[i2];
            int i3 = bVar.f70112d;
            a.b bVar2 = aVar.f70104c[i2];
            if (i3 != 0 && bVar2.f70112d != 0) {
                int i4 = i3 - 1;
                long d2 = bVar.d(i4) + bVar.b(i4);
                long d3 = bVar2.d(0);
                if (d2 <= d3) {
                    this.f70088g += i3;
                } else {
                    this.f70088g += bVar.c(d3);
                }
            } else {
                this.f70088g += i3;
            }
            this.f70087f = aVar;
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
                f fVar = this.f70084c;
                if (h.a(fVar, fVar.k(cVar.f69862c), exc)) {
                    return true;
                }
            }
            return false;
        }
        return invokeCommon.booleanValue;
    }

    @Override // d.f.b.a.d0.u.g
    public final void f(l lVar, long j, long j2, d.f.b.a.d0.u.e eVar) {
        int f2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{lVar, Long.valueOf(j), Long.valueOf(j2), eVar}) == null) && this.f70089h == null) {
            d.f.b.a.d0.x.e.a aVar = this.f70087f;
            a.b bVar = aVar.f70104c[this.f70083b];
            if (bVar.f70112d == 0) {
                eVar.f69879b = !aVar.f70102a;
                return;
            }
            if (lVar == null) {
                f2 = bVar.c(j2);
            } else {
                f2 = lVar.f() - this.f70088g;
                if (f2 < 0) {
                    this.f70089h = new BehindLiveWindowException();
                    return;
                }
            }
            int i2 = f2;
            if (i2 >= bVar.f70112d) {
                eVar.f69879b = !this.f70087f.f70102a;
                return;
            }
            this.f70084c.i(j, j2 - j, h(j));
            long d2 = bVar.d(i2);
            long b2 = d2 + bVar.b(i2);
            int i3 = i2 + this.f70088g;
            int a2 = this.f70084c.a();
            eVar.f69878a = g(this.f70084c.f(), this.f70086e, bVar.a(this.f70084c.b(a2), i2), null, i3, d2, b2, this.f70084c.l(), this.f70084c.j(), this.f70085d[a2]);
        }
    }

    public final long h(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048581, this, j)) == null) {
            d.f.b.a.d0.x.e.a aVar = this.f70087f;
            if (aVar.f70102a) {
                a.b bVar = aVar.f70104c[this.f70083b];
                int i2 = bVar.f70112d - 1;
                return (bVar.d(i2) + bVar.b(i2)) - j;
            }
            return -9223372036854775807L;
        }
        return invokeJ.longValue;
    }
}
