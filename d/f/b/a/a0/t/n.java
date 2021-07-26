package d.f.b.a.a0.t;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.Format;
import d.f.b.a.a0.t.w;
/* loaded from: classes8.dex */
public final class n implements h {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final d.f.b.a.i0.l f70066a;

    /* renamed from: b  reason: collision with root package name */
    public final d.f.b.a.a0.j f70067b;

    /* renamed from: c  reason: collision with root package name */
    public final String f70068c;

    /* renamed from: d  reason: collision with root package name */
    public String f70069d;

    /* renamed from: e  reason: collision with root package name */
    public d.f.b.a.a0.m f70070e;

    /* renamed from: f  reason: collision with root package name */
    public int f70071f;

    /* renamed from: g  reason: collision with root package name */
    public int f70072g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f70073h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f70074i;
    public long j;
    public int k;
    public long l;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public n() {
        this(null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                this((String) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public final void a(d.f.b.a.i0.l lVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, lVar) == null) {
            byte[] bArr = lVar.f70943a;
            int d2 = lVar.d();
            for (int c2 = lVar.c(); c2 < d2; c2++) {
                boolean z = (bArr[c2] & 255) == 255;
                boolean z2 = this.f70074i && (bArr[c2] & 224) == 224;
                this.f70074i = z;
                if (z2) {
                    lVar.J(c2 + 1);
                    this.f70074i = false;
                    this.f70066a.f70943a[1] = bArr[c2];
                    this.f70072g = 2;
                    this.f70071f = 1;
                    return;
                }
            }
            lVar.J(d2);
        }
    }

    @Override // d.f.b.a.a0.t.h
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f70071f = 0;
            this.f70072g = 0;
            this.f70074i = false;
        }
    }

    @Override // d.f.b.a.a0.t.h
    public void c(d.f.b.a.i0.l lVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, lVar) == null) {
            while (lVar.a() > 0) {
                int i2 = this.f70071f;
                if (i2 == 0) {
                    a(lVar);
                } else if (i2 == 1) {
                    h(lVar);
                } else if (i2 == 2) {
                    g(lVar);
                }
            }
        }
    }

    @Override // d.f.b.a.a0.t.h
    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
        }
    }

    @Override // d.f.b.a.a0.t.h
    public void e(long j, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{Long.valueOf(j), Boolean.valueOf(z)}) == null) {
            this.l = j;
        }
    }

    @Override // d.f.b.a.a0.t.h
    public void f(d.f.b.a.a0.g gVar, w.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, gVar, dVar) == null) {
            dVar.a();
            this.f70069d = dVar.b();
            this.f70070e = gVar.a(dVar.c(), 1);
        }
    }

    public final void g(d.f.b.a.i0.l lVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, lVar) == null) {
            int min = Math.min(lVar.a(), this.k - this.f70072g);
            this.f70070e.a(lVar, min);
            int i2 = this.f70072g + min;
            this.f70072g = i2;
            int i3 = this.k;
            if (i2 < i3) {
                return;
            }
            this.f70070e.c(this.l, 1, i3, 0, null);
            this.l += this.j;
            this.f70072g = 0;
            this.f70071f = 0;
        }
    }

    public final void h(d.f.b.a.i0.l lVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, lVar) == null) {
            int min = Math.min(lVar.a(), 4 - this.f70072g);
            lVar.g(this.f70066a.f70943a, this.f70072g, min);
            int i2 = this.f70072g + min;
            this.f70072g = i2;
            if (i2 < 4) {
                return;
            }
            this.f70066a.J(0);
            if (!d.f.b.a.a0.j.b(this.f70066a.i(), this.f70067b)) {
                this.f70072g = 0;
                this.f70071f = 1;
                return;
            }
            d.f.b.a.a0.j jVar = this.f70067b;
            this.k = jVar.f69676c;
            if (!this.f70073h) {
                int i3 = jVar.f69677d;
                this.j = (jVar.f69680g * 1000000) / i3;
                this.f70070e.b(Format.createAudioSampleFormat(this.f70069d, jVar.f69675b, null, -1, 4096, jVar.f69678e, i3, null, null, 0, this.f70068c));
                this.f70073h = true;
            }
            this.f70066a.J(0);
            this.f70070e.a(this.f70066a, 4);
            this.f70071f = 2;
        }
    }

    public n(String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f70071f = 0;
        d.f.b.a.i0.l lVar = new d.f.b.a.i0.l(4);
        this.f70066a = lVar;
        lVar.f70943a[0] = -1;
        this.f70067b = new d.f.b.a.a0.j();
        this.f70068c = str;
    }
}
