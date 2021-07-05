package d.f.b.a.a0.t;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.Format;
import d.f.b.a.a0.t.w;
import d.f.b.a.x.a;
/* loaded from: classes10.dex */
public final class b implements h {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final d.f.b.a.i0.k f72395a;

    /* renamed from: b  reason: collision with root package name */
    public final d.f.b.a.i0.l f72396b;

    /* renamed from: c  reason: collision with root package name */
    public final String f72397c;

    /* renamed from: d  reason: collision with root package name */
    public String f72398d;

    /* renamed from: e  reason: collision with root package name */
    public d.f.b.a.a0.m f72399e;

    /* renamed from: f  reason: collision with root package name */
    public int f72400f;

    /* renamed from: g  reason: collision with root package name */
    public int f72401g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f72402h;

    /* renamed from: i  reason: collision with root package name */
    public long f72403i;
    public Format j;
    public int k;
    public long l;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public b() {
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

    public final boolean a(d.f.b.a.i0.l lVar, byte[] bArr, int i2) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048576, this, lVar, bArr, i2)) == null) {
            int min = Math.min(lVar.a(), i2 - this.f72401g);
            lVar.g(bArr, this.f72401g, min);
            int i3 = this.f72401g + min;
            this.f72401g = i3;
            return i3 == i2;
        }
        return invokeLLI.booleanValue;
    }

    @Override // d.f.b.a.a0.t.h
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f72400f = 0;
            this.f72401g = 0;
            this.f72402h = false;
        }
    }

    @Override // d.f.b.a.a0.t.h
    public void c(d.f.b.a.i0.l lVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, lVar) == null) {
            while (lVar.a() > 0) {
                int i2 = this.f72400f;
                if (i2 != 0) {
                    if (i2 != 1) {
                        if (i2 == 2) {
                            int min = Math.min(lVar.a(), this.k - this.f72401g);
                            this.f72399e.a(lVar, min);
                            int i3 = this.f72401g + min;
                            this.f72401g = i3;
                            int i4 = this.k;
                            if (i3 == i4) {
                                this.f72399e.c(this.l, 1, i4, 0, null);
                                this.l += this.f72403i;
                                this.f72400f = 0;
                            }
                        }
                    } else if (a(lVar, this.f72396b.f73386a, 8)) {
                        g();
                        this.f72396b.J(0);
                        this.f72399e.a(this.f72396b, 8);
                        this.f72400f = 2;
                    }
                } else if (h(lVar)) {
                    this.f72400f = 1;
                    byte[] bArr = this.f72396b.f73386a;
                    bArr[0] = 11;
                    bArr[1] = 119;
                    this.f72401g = 2;
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
            this.f72398d = dVar.b();
            this.f72399e = gVar.a(dVar.c(), 1);
        }
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.f72395a.l(0);
            a.b d2 = d.f.b.a.x.a.d(this.f72395a);
            Format format = this.j;
            if (format == null || d2.f73555c != format.channelCount || d2.f73554b != format.sampleRate || d2.f73553a != format.sampleMimeType) {
                Format createAudioSampleFormat = Format.createAudioSampleFormat(this.f72398d, d2.f73553a, null, -1, -1, d2.f73555c, d2.f73554b, null, null, 0, this.f72397c);
                this.j = createAudioSampleFormat;
                this.f72399e.b(createAudioSampleFormat);
            }
            this.k = d2.f73556d;
            this.f72403i = (d2.f73557e * 1000000) / this.j.sampleRate;
        }
    }

    public final boolean h(d.f.b.a.i0.l lVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(1048583, this, lVar)) != null) {
            return invokeL.booleanValue;
        }
        while (true) {
            if (lVar.a() <= 0) {
                return false;
            }
            if (!this.f72402h) {
                this.f72402h = lVar.x() == 11;
            } else {
                int x = lVar.x();
                if (x == 119) {
                    this.f72402h = false;
                    return true;
                }
                this.f72402h = x == 11;
            }
        }
    }

    public b(String str) {
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
        d.f.b.a.i0.k kVar = new d.f.b.a.i0.k(new byte[8]);
        this.f72395a = kVar;
        this.f72396b = new d.f.b.a.i0.l(kVar.f73382a);
        this.f72400f = 0;
        this.f72397c = str;
    }
}
