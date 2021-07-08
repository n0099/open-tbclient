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
/* loaded from: classes8.dex */
public final class b implements h {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final d.f.b.a.i0.k f69498a;

    /* renamed from: b  reason: collision with root package name */
    public final d.f.b.a.i0.l f69499b;

    /* renamed from: c  reason: collision with root package name */
    public final String f69500c;

    /* renamed from: d  reason: collision with root package name */
    public String f69501d;

    /* renamed from: e  reason: collision with root package name */
    public d.f.b.a.a0.m f69502e;

    /* renamed from: f  reason: collision with root package name */
    public int f69503f;

    /* renamed from: g  reason: collision with root package name */
    public int f69504g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f69505h;

    /* renamed from: i  reason: collision with root package name */
    public long f69506i;
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
            int min = Math.min(lVar.a(), i2 - this.f69504g);
            lVar.g(bArr, this.f69504g, min);
            int i3 = this.f69504g + min;
            this.f69504g = i3;
            return i3 == i2;
        }
        return invokeLLI.booleanValue;
    }

    @Override // d.f.b.a.a0.t.h
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f69503f = 0;
            this.f69504g = 0;
            this.f69505h = false;
        }
    }

    @Override // d.f.b.a.a0.t.h
    public void c(d.f.b.a.i0.l lVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, lVar) == null) {
            while (lVar.a() > 0) {
                int i2 = this.f69503f;
                if (i2 != 0) {
                    if (i2 != 1) {
                        if (i2 == 2) {
                            int min = Math.min(lVar.a(), this.k - this.f69504g);
                            this.f69502e.a(lVar, min);
                            int i3 = this.f69504g + min;
                            this.f69504g = i3;
                            int i4 = this.k;
                            if (i3 == i4) {
                                this.f69502e.c(this.l, 1, i4, 0, null);
                                this.l += this.f69506i;
                                this.f69503f = 0;
                            }
                        }
                    } else if (a(lVar, this.f69499b.f70489a, 8)) {
                        g();
                        this.f69499b.J(0);
                        this.f69502e.a(this.f69499b, 8);
                        this.f69503f = 2;
                    }
                } else if (h(lVar)) {
                    this.f69503f = 1;
                    byte[] bArr = this.f69499b.f70489a;
                    bArr[0] = 11;
                    bArr[1] = 119;
                    this.f69504g = 2;
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
            this.f69501d = dVar.b();
            this.f69502e = gVar.a(dVar.c(), 1);
        }
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.f69498a.l(0);
            a.b d2 = d.f.b.a.x.a.d(this.f69498a);
            Format format = this.j;
            if (format == null || d2.f70658c != format.channelCount || d2.f70657b != format.sampleRate || d2.f70656a != format.sampleMimeType) {
                Format createAudioSampleFormat = Format.createAudioSampleFormat(this.f69501d, d2.f70656a, null, -1, -1, d2.f70658c, d2.f70657b, null, null, 0, this.f69500c);
                this.j = createAudioSampleFormat;
                this.f69502e.b(createAudioSampleFormat);
            }
            this.k = d2.f70659d;
            this.f69506i = (d2.f70660e * 1000000) / this.j.sampleRate;
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
            if (!this.f69505h) {
                this.f69505h = lVar.x() == 11;
            } else {
                int x = lVar.x();
                if (x == 119) {
                    this.f69505h = false;
                    return true;
                }
                this.f69505h = x == 11;
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
        this.f69498a = kVar;
        this.f69499b = new d.f.b.a.i0.l(kVar.f70485a);
        this.f69503f = 0;
        this.f69500c = str;
    }
}
