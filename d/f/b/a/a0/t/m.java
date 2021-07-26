package d.f.b.a.a0.t;

import android.util.Pair;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.ParserException;
import d.f.b.a.a0.t.w;
import java.util.Collections;
/* loaded from: classes8.dex */
public final class m implements h {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final String f70057a;

    /* renamed from: b  reason: collision with root package name */
    public final d.f.b.a.i0.l f70058b;

    /* renamed from: c  reason: collision with root package name */
    public final d.f.b.a.i0.k f70059c;

    /* renamed from: d  reason: collision with root package name */
    public d.f.b.a.a0.m f70060d;

    /* renamed from: e  reason: collision with root package name */
    public Format f70061e;

    /* renamed from: f  reason: collision with root package name */
    public String f70062f;

    /* renamed from: g  reason: collision with root package name */
    public int f70063g;

    /* renamed from: h  reason: collision with root package name */
    public int f70064h;

    /* renamed from: i  reason: collision with root package name */
    public int f70065i;
    public int j;
    public long k;
    public boolean l;
    public int m;
    public int n;
    public int o;
    public int p;
    public boolean q;
    public long r;
    public int s;
    public long t;
    public int u;

    public m(@Nullable String str) {
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
        this.f70057a = str;
        d.f.b.a.i0.l lVar = new d.f.b.a.i0.l(1024);
        this.f70058b = lVar;
        this.f70059c = new d.f.b.a.i0.k(lVar.f70943a);
    }

    public static long a(d.f.b.a.i0.k kVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65537, null, kVar)) == null) ? kVar.g((kVar.g(2) + 1) * 8) : invokeL.longValue;
    }

    @Override // d.f.b.a.a0.t.h
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f70063g = 0;
            this.l = false;
        }
    }

    @Override // d.f.b.a.a0.t.h
    public void c(d.f.b.a.i0.l lVar) throws ParserException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, lVar) == null) {
            while (lVar.a() > 0) {
                int i2 = this.f70063g;
                if (i2 != 0) {
                    if (i2 == 1) {
                        int x = lVar.x();
                        if ((x & 224) == 224) {
                            this.j = x;
                            this.f70063g = 2;
                        } else if (x != 86) {
                            this.f70063g = 0;
                        }
                    } else if (i2 == 2) {
                        int x2 = ((this.j & (-225)) << 8) | lVar.x();
                        this.f70065i = x2;
                        if (x2 > this.f70058b.f70943a.length) {
                            m(x2);
                        }
                        this.f70064h = 0;
                        this.f70063g = 3;
                    } else if (i2 == 3) {
                        int min = Math.min(lVar.a(), this.f70065i - this.f70064h);
                        lVar.g(this.f70059c.f70939a, this.f70064h, min);
                        int i3 = this.f70064h + min;
                        this.f70064h = i3;
                        if (i3 == this.f70065i) {
                            this.f70059c.l(0);
                            g(this.f70059c);
                            this.f70063g = 0;
                        }
                    }
                } else if (lVar.x() == 86) {
                    this.f70063g = 1;
                }
            }
        }
    }

    @Override // d.f.b.a.a0.t.h
    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
        }
    }

    @Override // d.f.b.a.a0.t.h
    public void e(long j, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Long.valueOf(j), Boolean.valueOf(z)}) == null) {
            this.k = j;
        }
    }

    @Override // d.f.b.a.a0.t.h
    public void f(d.f.b.a.a0.g gVar, w.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, gVar, dVar) == null) {
            dVar.a();
            this.f70060d = gVar.a(dVar.c(), 1);
            this.f70062f = dVar.b();
        }
    }

    public final void g(d.f.b.a.i0.k kVar) throws ParserException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, kVar) == null) {
            if (!kVar.f()) {
                this.l = true;
                l(kVar);
            } else if (!this.l) {
                return;
            }
            if (this.n == 0) {
                if (this.o == 0) {
                    k(kVar, j(kVar));
                    if (this.q) {
                        kVar.n((int) this.r);
                        return;
                    }
                    return;
                }
                throw new ParserException();
            }
            throw new ParserException();
        }
    }

    public final int h(d.f.b.a.i0.k kVar) throws ParserException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, kVar)) == null) {
            int b2 = kVar.b();
            Pair<Integer, Integer> h2 = d.f.b.a.i0.c.h(kVar, true);
            this.s = ((Integer) h2.first).intValue();
            this.u = ((Integer) h2.second).intValue();
            return b2 - kVar.b();
        }
        return invokeL.intValue;
    }

    public final void i(d.f.b.a.i0.k kVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, kVar) == null) {
            int g2 = kVar.g(3);
            this.p = g2;
            if (g2 == 0) {
                kVar.n(8);
            } else if (g2 == 1) {
                kVar.n(9);
            } else if (g2 == 3 || g2 == 4 || g2 == 5) {
                kVar.n(6);
            } else if (g2 == 6 || g2 == 7) {
                kVar.n(1);
            }
        }
    }

    public final int j(d.f.b.a.i0.k kVar) throws ParserException {
        InterceptResult invokeL;
        int g2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, kVar)) == null) {
            if (this.p == 0) {
                int i2 = 0;
                do {
                    g2 = kVar.g(8);
                    i2 += g2;
                } while (g2 == 255);
                return i2;
            }
            throw new ParserException();
        }
        return invokeL.intValue;
    }

    public final void k(d.f.b.a.i0.k kVar, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048585, this, kVar, i2) == null) {
            int e2 = kVar.e();
            if ((e2 & 7) == 0) {
                this.f70058b.J(e2 >> 3);
            } else {
                kVar.h(this.f70058b.f70943a, 0, i2 * 8);
                this.f70058b.J(0);
            }
            this.f70060d.a(this.f70058b, i2);
            this.f70060d.c(this.k, 1, i2, 0, null);
            this.k += this.t;
        }
    }

    public final void l(d.f.b.a.i0.k kVar) throws ParserException {
        boolean f2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, kVar) == null) {
            int g2 = kVar.g(1);
            this.m = g2;
            int g3 = g2 == 1 ? kVar.g(1) : 0;
            this.n = g3;
            if (g3 == 0) {
                if (this.m == 1) {
                    a(kVar);
                }
                if (kVar.f()) {
                    this.o = kVar.g(6);
                    int g4 = kVar.g(4);
                    int g5 = kVar.g(3);
                    if (g4 == 0 && g5 == 0) {
                        if (this.m == 0) {
                            int e2 = kVar.e();
                            int h2 = h(kVar);
                            kVar.l(e2);
                            byte[] bArr = new byte[(h2 + 7) / 8];
                            kVar.h(bArr, 0, h2);
                            Format createAudioSampleFormat = Format.createAudioSampleFormat(this.f70062f, "audio/mp4a-latm", null, -1, -1, this.u, this.s, Collections.singletonList(bArr), null, 0, this.f70057a);
                            if (!createAudioSampleFormat.equals(this.f70061e)) {
                                this.f70061e = createAudioSampleFormat;
                                this.t = 1024000000 / createAudioSampleFormat.sampleRate;
                                this.f70060d.b(createAudioSampleFormat);
                            }
                        } else {
                            kVar.n(((int) a(kVar)) - h(kVar));
                        }
                        i(kVar);
                        boolean f3 = kVar.f();
                        this.q = f3;
                        this.r = 0L;
                        if (f3) {
                            if (this.m == 1) {
                                this.r = a(kVar);
                            } else {
                                do {
                                    f2 = kVar.f();
                                    this.r = (this.r << 8) + kVar.g(8);
                                } while (f2);
                            }
                        }
                        if (kVar.f()) {
                            kVar.n(8);
                            return;
                        }
                        return;
                    }
                    throw new ParserException();
                }
                throw new ParserException();
            }
            throw new ParserException();
        }
    }

    public final void m(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i2) == null) {
            this.f70058b.G(i2);
            this.f70059c.j(this.f70058b.f70943a);
        }
    }
}
