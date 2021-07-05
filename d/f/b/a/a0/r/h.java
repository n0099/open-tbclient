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
/* loaded from: classes10.dex */
public abstract class h {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final d f72355a;

    /* renamed from: b  reason: collision with root package name */
    public m f72356b;

    /* renamed from: c  reason: collision with root package name */
    public d.f.b.a.a0.g f72357c;

    /* renamed from: d  reason: collision with root package name */
    public f f72358d;

    /* renamed from: e  reason: collision with root package name */
    public long f72359e;

    /* renamed from: f  reason: collision with root package name */
    public long f72360f;

    /* renamed from: g  reason: collision with root package name */
    public long f72361g;

    /* renamed from: h  reason: collision with root package name */
    public int f72362h;

    /* renamed from: i  reason: collision with root package name */
    public int f72363i;
    public b j;
    public long k;
    public boolean l;
    public boolean m;

    /* loaded from: classes10.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes10.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public Format f72364a;

        /* renamed from: b  reason: collision with root package name */
        public f f72365b;

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

    /* loaded from: classes10.dex */
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
        this.f72355a = new d();
    }

    public long a(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJ = interceptable.invokeJ(1048576, this, j)) == null) ? (j * 1000000) / this.f72363i : invokeJ.longValue;
    }

    public long b(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJ = interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j)) == null) ? (this.f72363i * j) / 1000000 : invokeJ.longValue;
    }

    public void c(d.f.b.a.a0.g gVar, m mVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, gVar, mVar) == null) {
            this.f72357c = gVar;
            this.f72356b = mVar;
            j(true);
        }
    }

    public void d(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048579, this, j) == null) {
            this.f72361g = j;
        }
    }

    public abstract long e(d.f.b.a.i0.l lVar);

    public final int f(d.f.b.a.a0.f fVar, d.f.b.a.a0.k kVar) throws IOException, InterruptedException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, fVar, kVar)) == null) {
            int i2 = this.f72362h;
            if (i2 != 0) {
                if (i2 != 1) {
                    if (i2 == 2) {
                        return i(fVar, kVar);
                    }
                    throw new IllegalStateException();
                }
                fVar.h((int) this.f72360f);
                this.f72362h = 2;
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
                if (!this.f72355a.d(fVar)) {
                    this.f72362h = 3;
                    return -1;
                }
                this.k = fVar.getPosition() - this.f72360f;
                z = h(this.f72355a.c(), this.f72360f, this.j);
                if (z) {
                    this.f72360f = fVar.getPosition();
                }
            }
            Format format = this.j.f72364a;
            this.f72363i = format.sampleRate;
            if (!this.m) {
                this.f72356b.b(format);
                this.m = true;
            }
            f fVar2 = this.j.f72365b;
            if (fVar2 != null) {
                this.f72358d = fVar2;
            } else if (fVar.getLength() == -1) {
                this.f72358d = new c(null);
            } else {
                e b2 = this.f72355a.b();
                this.f72358d = new d.f.b.a.a0.r.a(this.f72360f, fVar.getLength(), this, b2.f72351e + b2.f72352f, b2.f72349c);
            }
            this.j = null;
            this.f72362h = 2;
            this.f72355a.f();
            return 0;
        }
        return invokeL.intValue;
    }

    public abstract boolean h(d.f.b.a.i0.l lVar, long j, b bVar) throws IOException, InterruptedException;

    public final int i(d.f.b.a.a0.f fVar, d.f.b.a.a0.k kVar) throws IOException, InterruptedException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, fVar, kVar)) == null) {
            long a2 = this.f72358d.a(fVar);
            if (a2 >= 0) {
                kVar.f72124a = a2;
                return 1;
            }
            if (a2 < -1) {
                d(-(a2 + 2));
            }
            if (!this.l) {
                this.f72357c.p(this.f72358d.d());
                this.l = true;
            }
            if (this.k <= 0 && !this.f72355a.d(fVar)) {
                this.f72362h = 3;
                return -1;
            }
            this.k = 0L;
            d.f.b.a.i0.l c2 = this.f72355a.c();
            long e2 = e(c2);
            if (e2 >= 0) {
                long j = this.f72361g;
                if (j + e2 >= this.f72359e) {
                    long a3 = a(j);
                    this.f72356b.a(c2, c2.d());
                    this.f72356b.c(a3, 1, c2.d(), 0, null);
                    this.f72359e = -1L;
                }
            }
            this.f72361g += e2;
            return 0;
        }
        return invokeLL.intValue;
    }

    public void j(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            if (z) {
                this.j = new b();
                this.f72360f = 0L;
                this.f72362h = 0;
            } else {
                this.f72362h = 1;
            }
            this.f72359e = -1L;
            this.f72361g = 0L;
        }
    }

    public final void k(long j, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048586, this, new Object[]{Long.valueOf(j), Long.valueOf(j2)}) == null) {
            this.f72355a.e();
            if (j == 0) {
                j(!this.l);
            } else if (this.f72362h != 0) {
                this.f72359e = this.f72358d.e(j2);
                this.f72362h = 2;
            }
        }
    }
}
