package d.f.b.a.a0.r;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.Format;
import d.f.b.a.a0.l;
import d.f.b.a.a0.m;
import java.io.IOException;
/* loaded from: classes8.dex */
public abstract class h {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final d f69912a;

    /* renamed from: b  reason: collision with root package name */
    public m f69913b;

    /* renamed from: c  reason: collision with root package name */
    public d.f.b.a.a0.g f69914c;

    /* renamed from: d  reason: collision with root package name */
    public f f69915d;

    /* renamed from: e  reason: collision with root package name */
    public long f69916e;

    /* renamed from: f  reason: collision with root package name */
    public long f69917f;

    /* renamed from: g  reason: collision with root package name */
    public long f69918g;

    /* renamed from: h  reason: collision with root package name */
    public int f69919h;

    /* renamed from: i  reason: collision with root package name */
    public int f69920i;
    public b j;
    public long k;
    public boolean l;
    public boolean m;

    /* loaded from: classes8.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes8.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public Format f69921a;

        /* renamed from: b  reason: collision with root package name */
        public f f69922b;

        public b() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public static final class c implements f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public c() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // d.f.b.a.a0.r.f
        public long a(d.f.b.a.a0.f fVar) throws IOException, InterruptedException {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, fVar)) == null) {
                return -1L;
            }
            return invokeL.longValue;
        }

        @Override // d.f.b.a.a0.r.f
        public l d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? new l.a(-9223372036854775807L) : (l) invokeV.objValue;
        }

        @Override // d.f.b.a.a0.r.f
        public long e(long j) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJ = interceptable.invokeJ(Constants.METHOD_SEND_USER_MSG, this, j)) == null) {
                return 0L;
            }
            return invokeJ.longValue;
        }

        public /* synthetic */ c(a aVar) {
            this();
        }
    }

    public h() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f69912a = new d();
    }

    public long a(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJ = interceptable.invokeJ(1048576, this, j)) == null) ? (j * 1000000) / this.f69920i : invokeJ.longValue;
    }

    public long b(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJ = interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j)) == null) ? (this.f69920i * j) / 1000000 : invokeJ.longValue;
    }

    public void c(d.f.b.a.a0.g gVar, m mVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, gVar, mVar) == null) {
            this.f69914c = gVar;
            this.f69913b = mVar;
            j(true);
        }
    }

    public void d(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048579, this, j) == null) {
            this.f69918g = j;
        }
    }

    public abstract long e(d.f.b.a.i0.l lVar);

    public final int f(d.f.b.a.a0.f fVar, d.f.b.a.a0.k kVar) throws IOException, InterruptedException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, fVar, kVar)) == null) {
            int i2 = this.f69919h;
            if (i2 != 0) {
                if (i2 != 1) {
                    if (i2 == 2) {
                        return i(fVar, kVar);
                    }
                    throw new IllegalStateException();
                }
                fVar.h((int) this.f69917f);
                this.f69919h = 2;
                return 0;
            }
            return g(fVar);
        }
        return invokeLL.intValue;
    }

    public final int g(d.f.b.a.a0.f fVar) throws IOException, InterruptedException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, fVar)) == null) {
            boolean z = true;
            while (z) {
                if (!this.f69912a.d(fVar)) {
                    this.f69919h = 3;
                    return -1;
                }
                this.k = fVar.getPosition() - this.f69917f;
                z = h(this.f69912a.c(), this.f69917f, this.j);
                if (z) {
                    this.f69917f = fVar.getPosition();
                }
            }
            Format format = this.j.f69921a;
            this.f69920i = format.sampleRate;
            if (!this.m) {
                this.f69913b.b(format);
                this.m = true;
            }
            f fVar2 = this.j.f69922b;
            if (fVar2 != null) {
                this.f69915d = fVar2;
            } else if (fVar.getLength() == -1) {
                this.f69915d = new c(null);
            } else {
                e b2 = this.f69912a.b();
                this.f69915d = new d.f.b.a.a0.r.a(this.f69917f, fVar.getLength(), this, b2.f69908e + b2.f69909f, b2.f69906c);
            }
            this.j = null;
            this.f69919h = 2;
            this.f69912a.f();
            return 0;
        }
        return invokeL.intValue;
    }

    public abstract boolean h(d.f.b.a.i0.l lVar, long j, b bVar) throws IOException, InterruptedException;

    public final int i(d.f.b.a.a0.f fVar, d.f.b.a.a0.k kVar) throws IOException, InterruptedException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, fVar, kVar)) == null) {
            long a2 = this.f69915d.a(fVar);
            if (a2 >= 0) {
                kVar.f69681a = a2;
                return 1;
            }
            if (a2 < -1) {
                d(-(a2 + 2));
            }
            if (!this.l) {
                this.f69914c.p(this.f69915d.d());
                this.l = true;
            }
            if (this.k <= 0 && !this.f69912a.d(fVar)) {
                this.f69919h = 3;
                return -1;
            }
            this.k = 0L;
            d.f.b.a.i0.l c2 = this.f69912a.c();
            long e2 = e(c2);
            if (e2 >= 0) {
                long j = this.f69918g;
                if (j + e2 >= this.f69916e) {
                    long a3 = a(j);
                    this.f69913b.a(c2, c2.d());
                    this.f69913b.c(a3, 1, c2.d(), 0, null);
                    this.f69916e = -1L;
                }
            }
            this.f69918g += e2;
            return 0;
        }
        return invokeLL.intValue;
    }

    public void j(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            if (z) {
                this.j = new b();
                this.f69917f = 0L;
                this.f69919h = 0;
            } else {
                this.f69919h = 1;
            }
            this.f69916e = -1L;
            this.f69918g = 0L;
        }
    }

    public final void k(long j, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048586, this, new Object[]{Long.valueOf(j), Long.valueOf(j2)}) == null) {
            this.f69912a.e();
            if (j == 0) {
                j(!this.l);
            } else if (this.f69919h != 0) {
                this.f69916e = this.f69915d.e(j2);
                this.f69919h = 2;
            }
        }
    }
}
