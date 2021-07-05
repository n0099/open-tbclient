package d.f.b.a.a0.t;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.Format;
import d.f.b.a.a0.t.w;
/* loaded from: classes10.dex */
public final class n implements h {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final d.f.b.a.i0.l f72509a;

    /* renamed from: b  reason: collision with root package name */
    public final d.f.b.a.a0.j f72510b;

    /* renamed from: c  reason: collision with root package name */
    public final String f72511c;

    /* renamed from: d  reason: collision with root package name */
    public String f72512d;

    /* renamed from: e  reason: collision with root package name */
    public d.f.b.a.a0.m f72513e;

    /* renamed from: f  reason: collision with root package name */
    public int f72514f;

    /* renamed from: g  reason: collision with root package name */
    public int f72515g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f72516h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f72517i;
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
            byte[] bArr = lVar.f73386a;
            int d2 = lVar.d();
            for (int c2 = lVar.c(); c2 < d2; c2++) {
                boolean z = (bArr[c2] & 255) == 255;
                boolean z2 = this.f72517i && (bArr[c2] & 224) == 224;
                this.f72517i = z;
                if (z2) {
                    lVar.J(c2 + 1);
                    this.f72517i = false;
                    this.f72509a.f73386a[1] = bArr[c2];
                    this.f72515g = 2;
                    this.f72514f = 1;
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
            this.f72514f = 0;
            this.f72515g = 0;
            this.f72517i = false;
        }
    }

    @Override // d.f.b.a.a0.t.h
    public void c(d.f.b.a.i0.l lVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, lVar) == null) {
            while (lVar.a() > 0) {
                int i2 = this.f72514f;
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
            this.f72512d = dVar.b();
            this.f72513e = gVar.a(dVar.c(), 1);
        }
    }

    public final void g(d.f.b.a.i0.l lVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, lVar) == null) {
            int min = Math.min(lVar.a(), this.k - this.f72515g);
            this.f72513e.a(lVar, min);
            int i2 = this.f72515g + min;
            this.f72515g = i2;
            int i3 = this.k;
            if (i2 < i3) {
                return;
            }
            this.f72513e.c(this.l, 1, i3, 0, null);
            this.l += this.j;
            this.f72515g = 0;
            this.f72514f = 0;
        }
    }

    public final void h(d.f.b.a.i0.l lVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, lVar) == null) {
            int min = Math.min(lVar.a(), 4 - this.f72515g);
            lVar.g(this.f72509a.f73386a, this.f72515g, min);
            int i2 = this.f72515g + min;
            this.f72515g = i2;
            if (i2 < 4) {
                return;
            }
            this.f72509a.J(0);
            if (!d.f.b.a.a0.j.b(this.f72509a.i(), this.f72510b)) {
                this.f72515g = 0;
                this.f72514f = 1;
                return;
            }
            d.f.b.a.a0.j jVar = this.f72510b;
            this.k = jVar.f72119c;
            if (!this.f72516h) {
                int i3 = jVar.f72120d;
                this.j = (jVar.f72123g * 1000000) / i3;
                this.f72513e.b(Format.createAudioSampleFormat(this.f72512d, jVar.f72118b, null, -1, 4096, jVar.f72121e, i3, null, null, 0, this.f72511c));
                this.f72516h = true;
            }
            this.f72509a.J(0);
            this.f72513e.a(this.f72509a, 4);
            this.f72514f = 2;
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
        this.f72514f = 0;
        d.f.b.a.i0.l lVar = new d.f.b.a.i0.l(4);
        this.f72509a = lVar;
        lVar.f73386a[0] = -1;
        this.f72510b = new d.f.b.a.a0.j();
        this.f72511c = str;
    }
}
