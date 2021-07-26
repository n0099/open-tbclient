package d.f.b.a.d0;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.f.b.a.d0.l;
import d.f.b.a.w;
import java.io.IOException;
import java.util.ArrayList;
/* loaded from: classes8.dex */
public final class d implements l, l.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public final l f70218e;

    /* renamed from: f  reason: collision with root package name */
    public final long f70219f;

    /* renamed from: g  reason: collision with root package name */
    public final long f70220g;

    /* renamed from: h  reason: collision with root package name */
    public final boolean f70221h;

    /* renamed from: i  reason: collision with root package name */
    public final ArrayList<c> f70222i;
    public l.a j;

    /* loaded from: classes8.dex */
    public static final class a extends j {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: c  reason: collision with root package name */
        public final long f70223c;

        /* renamed from: d  reason: collision with root package name */
        public final long f70224d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(w wVar, long j, long j2) {
            super(wVar);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wVar, Long.valueOf(j), Long.valueOf(j2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((w) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            d.f.b.a.i0.a.a(wVar.o() == 1);
            d.f.b.a.i0.a.a(wVar.h() == 1);
            w.c m = wVar.m(0, new w.c(), false);
            d.f.b.a.i0.a.a(!m.f71099e);
            j2 = j2 == Long.MIN_VALUE ? m.f71103i : j2;
            long j3 = m.f71103i;
            if (j3 != -9223372036854775807L) {
                j2 = j2 > j3 ? j3 : j2;
                d.f.b.a.i0.a.a(j == 0 || m.f71098d);
                d.f.b.a.i0.a.a(j <= j2);
            }
            d.f.b.a.i0.a.a(wVar.f(0, new w.b()).k() == 0);
            this.f70223c = j;
            this.f70224d = j2;
        }

        @Override // d.f.b.a.w
        public w.b g(int i2, w.b bVar, boolean z) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i2), bVar, Boolean.valueOf(z)})) == null) {
                w.b g2 = this.f70265b.g(0, bVar, z);
                long j = this.f70224d;
                g2.f71089d = j != -9223372036854775807L ? j - this.f70223c : -9223372036854775807L;
                return g2;
            }
            return (w.b) invokeCommon.objValue;
        }

        @Override // d.f.b.a.w
        public w.c n(int i2, w.c cVar, boolean z, long j) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i2), cVar, Boolean.valueOf(z), Long.valueOf(j)})) == null) {
                w.c n = this.f70265b.n(0, cVar, z, j);
                long j2 = this.f70224d;
                n.f71103i = j2 != -9223372036854775807L ? j2 - this.f70223c : -9223372036854775807L;
                long j3 = n.f71102h;
                if (j3 != -9223372036854775807L) {
                    long max = Math.max(j3, this.f70223c);
                    n.f71102h = max;
                    long j4 = this.f70224d;
                    if (j4 != -9223372036854775807L) {
                        max = Math.min(max, j4);
                    }
                    n.f71102h = max;
                    n.f71102h = max - this.f70223c;
                }
                long b2 = d.f.b.a.b.b(this.f70223c);
                long j5 = n.f71096b;
                if (j5 != -9223372036854775807L) {
                    n.f71096b = j5 + b2;
                }
                long j6 = n.f71097c;
                if (j6 != -9223372036854775807L) {
                    n.f71097c = j6 + b2;
                }
                return n;
            }
            return (w.c) invokeCommon.objValue;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public d(l lVar, long j, long j2) {
        this(lVar, j, j2, true);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r9;
            Object[] objArr = {lVar, Long.valueOf(j), Long.valueOf(j2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((l) objArr2[0], ((Long) objArr2[1]).longValue(), ((Long) objArr2[2]).longValue(), ((Boolean) objArr2[3]).booleanValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // d.f.b.a.d0.l
    public void a(d.f.b.a.g gVar, boolean z, l.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{gVar, Boolean.valueOf(z), aVar}) == null) {
            this.j = aVar;
            this.f70218e.a(gVar, false, this);
        }
    }

    @Override // d.f.b.a.d0.l
    public void b() throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f70218e.b();
        }
    }

    @Override // d.f.b.a.d0.l.a
    public void c(l lVar, w wVar, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, lVar, wVar, obj) == null) {
            this.j.c(this, new a(wVar, this.f70219f, this.f70220g), obj);
            int size = this.f70222i.size();
            for (int i2 = 0; i2 < size; i2++) {
                this.f70222i.get(i2).f(this.f70219f, this.f70220g);
            }
        }
    }

    @Override // d.f.b.a.d0.l
    public k d(l.b bVar, d.f.b.a.h0.b bVar2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, bVar, bVar2)) == null) {
            c cVar = new c(this.f70218e.d(bVar, bVar2), this.f70221h);
            this.f70222i.add(cVar);
            cVar.f(this.f70219f, this.f70220g);
            return cVar;
        }
        return (k) invokeLL.objValue;
    }

    @Override // d.f.b.a.d0.l
    public void e(k kVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, kVar) == null) {
            d.f.b.a.i0.a.f(this.f70222i.remove(kVar));
            this.f70218e.e(((c) kVar).f70208e);
        }
    }

    @Override // d.f.b.a.d0.l
    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.f70218e.f();
        }
    }

    public d(l lVar, long j, long j2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {lVar, Long.valueOf(j), Long.valueOf(j2), Boolean.valueOf(z)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        d.f.b.a.i0.a.a(j >= 0);
        d.f.b.a.i0.a.e(lVar);
        this.f70218e = lVar;
        this.f70219f = j;
        this.f70220g = j2;
        this.f70221h = z;
        this.f70222i = new ArrayList<>();
    }
}
