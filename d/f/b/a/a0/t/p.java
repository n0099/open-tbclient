package d.f.b.a.a0.t;

import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.ParserException;
import d.f.b.a.a0.t.w;
/* loaded from: classes10.dex */
public final class p implements w {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final h f72523a;

    /* renamed from: b  reason: collision with root package name */
    public final d.f.b.a.i0.k f72524b;

    /* renamed from: c  reason: collision with root package name */
    public int f72525c;

    /* renamed from: d  reason: collision with root package name */
    public int f72526d;

    /* renamed from: e  reason: collision with root package name */
    public d.f.b.a.i0.s f72527e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f72528f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f72529g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f72530h;

    /* renamed from: i  reason: collision with root package name */
    public int f72531i;
    public int j;
    public boolean k;
    public long l;

    public p(h hVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {hVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f72523a = hVar;
        this.f72524b = new d.f.b.a.i0.k(new byte[10]);
        this.f72525c = 0;
    }

    @Override // d.f.b.a.a0.t.w
    public void a(d.f.b.a.i0.s sVar, d.f.b.a.a0.g gVar, w.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, sVar, gVar, dVar) == null) {
            this.f72527e = sVar;
            this.f72523a.f(gVar, dVar);
        }
    }

    @Override // d.f.b.a.a0.t.w
    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f72525c = 0;
            this.f72526d = 0;
            this.f72530h = false;
            this.f72523a.b();
        }
    }

    @Override // d.f.b.a.a0.t.w
    public final void c(d.f.b.a.i0.l lVar, boolean z) throws ParserException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(Constants.METHOD_SEND_USER_MSG, this, lVar, z) == null) {
            if (z) {
                int i2 = this.f72525c;
                if (i2 == 2) {
                    Log.w("PesReader", "Unexpected start indicator reading extended header");
                } else if (i2 == 3) {
                    if (this.j != -1) {
                        Log.w("PesReader", "Unexpected start indicator: expected " + this.j + " more bytes");
                    }
                    this.f72523a.d();
                }
                g(1);
            }
            while (lVar.a() > 0) {
                int i3 = this.f72525c;
                if (i3 != 0) {
                    if (i3 != 1) {
                        if (i3 == 2) {
                            if (d(lVar, this.f72524b.f73382a, Math.min(10, this.f72531i)) && d(lVar, null, this.f72531i)) {
                                f();
                                this.f72523a.e(this.l, this.k);
                                g(3);
                            }
                        } else if (i3 == 3) {
                            int a2 = lVar.a();
                            int i4 = this.j;
                            int i5 = i4 != -1 ? a2 - i4 : 0;
                            if (i5 > 0) {
                                a2 -= i5;
                                lVar.I(lVar.c() + a2);
                            }
                            this.f72523a.c(lVar);
                            int i6 = this.j;
                            if (i6 != -1) {
                                int i7 = i6 - a2;
                                this.j = i7;
                                if (i7 == 0) {
                                    this.f72523a.d();
                                    g(1);
                                }
                            }
                        }
                    } else if (d(lVar, this.f72524b.f73382a, 9)) {
                        g(e() ? 2 : 0);
                    }
                } else {
                    lVar.K(lVar.a());
                }
            }
        }
    }

    public final boolean d(d.f.b.a.i0.l lVar, byte[] bArr, int i2) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048579, this, lVar, bArr, i2)) == null) {
            int min = Math.min(lVar.a(), i2 - this.f72526d);
            if (min <= 0) {
                return true;
            }
            if (bArr == null) {
                lVar.K(min);
            } else {
                lVar.g(bArr, this.f72526d, min);
            }
            int i3 = this.f72526d + min;
            this.f72526d = i3;
            return i3 == i2;
        }
        return invokeLLI.booleanValue;
    }

    public final boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            this.f72524b.l(0);
            int g2 = this.f72524b.g(24);
            if (g2 != 1) {
                Log.w("PesReader", "Unexpected start code prefix: " + g2);
                this.j = -1;
                return false;
            }
            this.f72524b.n(8);
            int g3 = this.f72524b.g(16);
            this.f72524b.n(5);
            this.k = this.f72524b.f();
            this.f72524b.n(2);
            this.f72528f = this.f72524b.f();
            this.f72529g = this.f72524b.f();
            this.f72524b.n(6);
            int g4 = this.f72524b.g(8);
            this.f72531i = g4;
            if (g3 == 0) {
                this.j = -1;
            } else {
                this.j = ((g3 + 6) - 9) - g4;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.f72524b.l(0);
            this.l = -9223372036854775807L;
            if (this.f72528f) {
                this.f72524b.n(4);
                this.f72524b.n(1);
                this.f72524b.n(1);
                long g2 = (this.f72524b.g(3) << 30) | (this.f72524b.g(15) << 15) | this.f72524b.g(15);
                this.f72524b.n(1);
                if (!this.f72530h && this.f72529g) {
                    this.f72524b.n(4);
                    this.f72524b.n(1);
                    this.f72524b.n(1);
                    this.f72524b.n(1);
                    this.f72527e.b((this.f72524b.g(3) << 30) | (this.f72524b.g(15) << 15) | this.f72524b.g(15));
                    this.f72530h = true;
                }
                this.l = this.f72527e.b(g2);
            }
        }
    }

    public final void g(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i2) == null) {
            this.f72525c = i2;
            this.f72526d = 0;
        }
    }
}
