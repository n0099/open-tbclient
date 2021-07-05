package d.f.b.a.a0.t;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.Format;
import d.f.b.a.a0.t.w;
import kotlin.jvm.internal.ByteCompanionObject;
/* loaded from: classes10.dex */
public final class f implements h {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final d.f.b.a.i0.l f72420a;

    /* renamed from: b  reason: collision with root package name */
    public final String f72421b;

    /* renamed from: c  reason: collision with root package name */
    public String f72422c;

    /* renamed from: d  reason: collision with root package name */
    public d.f.b.a.a0.m f72423d;

    /* renamed from: e  reason: collision with root package name */
    public int f72424e;

    /* renamed from: f  reason: collision with root package name */
    public int f72425f;

    /* renamed from: g  reason: collision with root package name */
    public int f72426g;

    /* renamed from: h  reason: collision with root package name */
    public long f72427h;

    /* renamed from: i  reason: collision with root package name */
    public Format f72428i;
    public int j;
    public long k;

    public f(String str) {
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
        d.f.b.a.i0.l lVar = new d.f.b.a.i0.l(new byte[15]);
        this.f72420a = lVar;
        byte[] bArr = lVar.f73386a;
        bArr[0] = ByteCompanionObject.MAX_VALUE;
        bArr[1] = -2;
        bArr[2] = ByteCompanionObject.MIN_VALUE;
        bArr[3] = 1;
        this.f72424e = 0;
        this.f72421b = str;
    }

    public final boolean a(d.f.b.a.i0.l lVar, byte[] bArr, int i2) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048576, this, lVar, bArr, i2)) == null) {
            int min = Math.min(lVar.a(), i2 - this.f72425f);
            lVar.g(bArr, this.f72425f, min);
            int i3 = this.f72425f + min;
            this.f72425f = i3;
            return i3 == i2;
        }
        return invokeLLI.booleanValue;
    }

    @Override // d.f.b.a.a0.t.h
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f72424e = 0;
            this.f72425f = 0;
            this.f72426g = 0;
        }
    }

    @Override // d.f.b.a.a0.t.h
    public void c(d.f.b.a.i0.l lVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, lVar) == null) {
            while (lVar.a() > 0) {
                int i2 = this.f72424e;
                if (i2 != 0) {
                    if (i2 != 1) {
                        if (i2 == 2) {
                            int min = Math.min(lVar.a(), this.j - this.f72425f);
                            this.f72423d.a(lVar, min);
                            int i3 = this.f72425f + min;
                            this.f72425f = i3;
                            int i4 = this.j;
                            if (i3 == i4) {
                                this.f72423d.c(this.k, 1, i4, 0, null);
                                this.k += this.f72427h;
                                this.f72424e = 0;
                            }
                        }
                    } else if (a(lVar, this.f72420a.f73386a, 15)) {
                        g();
                        this.f72420a.J(0);
                        this.f72423d.a(this.f72420a, 15);
                        this.f72424e = 2;
                    }
                } else if (h(lVar)) {
                    this.f72425f = 4;
                    this.f72424e = 1;
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
            this.k = j;
        }
    }

    @Override // d.f.b.a.a0.t.h
    public void f(d.f.b.a.a0.g gVar, w.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, gVar, dVar) == null) {
            dVar.a();
            this.f72422c = dVar.b();
            this.f72423d = gVar.a(dVar.c(), 1);
        }
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            byte[] bArr = this.f72420a.f73386a;
            if (this.f72428i == null) {
                Format d2 = d.f.b.a.x.f.d(bArr, this.f72422c, this.f72421b, null);
                this.f72428i = d2;
                this.f72423d.b(d2);
            }
            this.j = d.f.b.a.x.f.a(bArr);
            this.f72427h = (int) ((d.f.b.a.x.f.c(bArr) * 1000000) / this.f72428i.sampleRate);
        }
    }

    public final boolean h(d.f.b.a.i0.l lVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, lVar)) == null) {
            while (lVar.a() > 0) {
                int i2 = this.f72426g << 8;
                this.f72426g = i2;
                int x = i2 | lVar.x();
                this.f72426g = x;
                if (x == 2147385345) {
                    this.f72426g = 0;
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }
}
