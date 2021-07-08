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
    public final d.f.b.a.i0.l f69612a;

    /* renamed from: b  reason: collision with root package name */
    public final d.f.b.a.a0.j f69613b;

    /* renamed from: c  reason: collision with root package name */
    public final String f69614c;

    /* renamed from: d  reason: collision with root package name */
    public String f69615d;

    /* renamed from: e  reason: collision with root package name */
    public d.f.b.a.a0.m f69616e;

    /* renamed from: f  reason: collision with root package name */
    public int f69617f;

    /* renamed from: g  reason: collision with root package name */
    public int f69618g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f69619h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f69620i;
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
            byte[] bArr = lVar.f70489a;
            int d2 = lVar.d();
            for (int c2 = lVar.c(); c2 < d2; c2++) {
                boolean z = (bArr[c2] & 255) == 255;
                boolean z2 = this.f69620i && (bArr[c2] & 224) == 224;
                this.f69620i = z;
                if (z2) {
                    lVar.J(c2 + 1);
                    this.f69620i = false;
                    this.f69612a.f70489a[1] = bArr[c2];
                    this.f69618g = 2;
                    this.f69617f = 1;
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
            this.f69617f = 0;
            this.f69618g = 0;
            this.f69620i = false;
        }
    }

    @Override // d.f.b.a.a0.t.h
    public void c(d.f.b.a.i0.l lVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, lVar) == null) {
            while (lVar.a() > 0) {
                int i2 = this.f69617f;
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
            this.f69615d = dVar.b();
            this.f69616e = gVar.a(dVar.c(), 1);
        }
    }

    public final void g(d.f.b.a.i0.l lVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, lVar) == null) {
            int min = Math.min(lVar.a(), this.k - this.f69618g);
            this.f69616e.a(lVar, min);
            int i2 = this.f69618g + min;
            this.f69618g = i2;
            int i3 = this.k;
            if (i2 < i3) {
                return;
            }
            this.f69616e.c(this.l, 1, i3, 0, null);
            this.l += this.j;
            this.f69618g = 0;
            this.f69617f = 0;
        }
    }

    public final void h(d.f.b.a.i0.l lVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, lVar) == null) {
            int min = Math.min(lVar.a(), 4 - this.f69618g);
            lVar.g(this.f69612a.f70489a, this.f69618g, min);
            int i2 = this.f69618g + min;
            this.f69618g = i2;
            if (i2 < 4) {
                return;
            }
            this.f69612a.J(0);
            if (!d.f.b.a.a0.j.b(this.f69612a.i(), this.f69613b)) {
                this.f69618g = 0;
                this.f69617f = 1;
                return;
            }
            d.f.b.a.a0.j jVar = this.f69613b;
            this.k = jVar.f69222c;
            if (!this.f69619h) {
                int i3 = jVar.f69223d;
                this.j = (jVar.f69226g * 1000000) / i3;
                this.f69616e.b(Format.createAudioSampleFormat(this.f69615d, jVar.f69221b, null, -1, 4096, jVar.f69224e, i3, null, null, 0, this.f69614c));
                this.f69619h = true;
            }
            this.f69612a.J(0);
            this.f69616e.a(this.f69612a, 4);
            this.f69617f = 2;
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
        this.f69617f = 0;
        d.f.b.a.i0.l lVar = new d.f.b.a.i0.l(4);
        this.f69612a = lVar;
        lVar.f70489a[0] = -1;
        this.f69613b = new d.f.b.a.a0.j();
        this.f69614c = str;
    }
}
