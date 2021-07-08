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
    public final l f69764e;

    /* renamed from: f  reason: collision with root package name */
    public final long f69765f;

    /* renamed from: g  reason: collision with root package name */
    public final long f69766g;

    /* renamed from: h  reason: collision with root package name */
    public final boolean f69767h;

    /* renamed from: i  reason: collision with root package name */
    public final ArrayList<c> f69768i;
    public l.a j;

    /* loaded from: classes8.dex */
    public static final class a extends j {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: c  reason: collision with root package name */
        public final long f69769c;

        /* renamed from: d  reason: collision with root package name */
        public final long f69770d;

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
            d.f.b.a.i0.a.a(!m.f70645e);
            j2 = j2 == Long.MIN_VALUE ? m.f70649i : j2;
            long j3 = m.f70649i;
            if (j3 != -9223372036854775807L) {
                j2 = j2 > j3 ? j3 : j2;
                d.f.b.a.i0.a.a(j == 0 || m.f70644d);
                d.f.b.a.i0.a.a(j <= j2);
            }
            d.f.b.a.i0.a.a(wVar.f(0, new w.b()).k() == 0);
            this.f69769c = j;
            this.f69770d = j2;
        }

        @Override // d.f.b.a.w
        public w.b g(int i2, w.b bVar, boolean z) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i2), bVar, Boolean.valueOf(z)})) == null) {
                w.b g2 = this.f69811b.g(0, bVar, z);
                long j = this.f69770d;
                g2.f70635d = j != -9223372036854775807L ? j - this.f69769c : -9223372036854775807L;
                return g2;
            }
            return (w.b) invokeCommon.objValue;
        }

        @Override // d.f.b.a.w
        public w.c n(int i2, w.c cVar, boolean z, long j) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i2), cVar, Boolean.valueOf(z), Long.valueOf(j)})) == null) {
                w.c n = this.f69811b.n(0, cVar, z, j);
                long j2 = this.f69770d;
                n.f70649i = j2 != -9223372036854775807L ? j2 - this.f69769c : -9223372036854775807L;
                long j3 = n.f70648h;
                if (j3 != -9223372036854775807L) {
                    long max = Math.max(j3, this.f69769c);
                    n.f70648h = max;
                    long j4 = this.f69770d;
                    if (j4 != -9223372036854775807L) {
                        max = Math.min(max, j4);
                    }
                    n.f70648h = max;
                    n.f70648h = max - this.f69769c;
                }
                long b2 = d.f.b.a.b.b(this.f69769c);
                long j5 = n.f70642b;
                if (j5 != -9223372036854775807L) {
                    n.f70642b = j5 + b2;
                }
                long j6 = n.f70643c;
                if (j6 != -9223372036854775807L) {
                    n.f70643c = j6 + b2;
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
            this.f69764e.a(gVar, false, this);
        }
    }

    @Override // d.f.b.a.d0.l
    public void b() throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f69764e.b();
        }
    }

    @Override // d.f.b.a.d0.l.a
    public void c(l lVar, w wVar, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, lVar, wVar, obj) == null) {
            this.j.c(this, new a(wVar, this.f69765f, this.f69766g), obj);
            int size = this.f69768i.size();
            for (int i2 = 0; i2 < size; i2++) {
                this.f69768i.get(i2).f(this.f69765f, this.f69766g);
            }
        }
    }

    @Override // d.f.b.a.d0.l
    public k d(l.b bVar, d.f.b.a.h0.b bVar2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, bVar, bVar2)) == null) {
            c cVar = new c(this.f69764e.d(bVar, bVar2), this.f69767h);
            this.f69768i.add(cVar);
            cVar.f(this.f69765f, this.f69766g);
            return cVar;
        }
        return (k) invokeLL.objValue;
    }

    @Override // d.f.b.a.d0.l
    public void e(k kVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, kVar) == null) {
            d.f.b.a.i0.a.f(this.f69768i.remove(kVar));
            this.f69764e.e(((c) kVar).f69754e);
        }
    }

    @Override // d.f.b.a.d0.l
    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.f69764e.f();
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
        this.f69764e = lVar;
        this.f69765f = j;
        this.f69766g = j2;
        this.f69767h = z;
        this.f69768i = new ArrayList<>();
    }
}
