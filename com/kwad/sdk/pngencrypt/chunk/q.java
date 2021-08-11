package com.kwad.sdk.pngencrypt.chunk;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.pngencrypt.PngjException;
import java.io.ByteArrayInputStream;
/* loaded from: classes10.dex */
public class q extends aa {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: h  reason: collision with root package name */
    public int f72792h;

    /* renamed from: i  reason: collision with root package name */
    public int f72793i;

    /* renamed from: j  reason: collision with root package name */
    public int f72794j;
    public int k;
    public int l;
    public int m;
    public int n;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public q(com.kwad.sdk.pngencrypt.k kVar) {
        super("IHDR", kVar);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {kVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((String) objArr2[0], (com.kwad.sdk.pngencrypt.k) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        if (kVar != null) {
            a(kVar);
        }
    }

    @Override // com.kwad.sdk.pngencrypt.chunk.PngChunk
    public void a(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, dVar) == null) {
            if (dVar.f72760a != 13) {
                throw new PngjException("Bad IDHR len " + dVar.f72760a);
            }
            ByteArrayInputStream b2 = dVar.b();
            this.f72792h = com.kwad.sdk.pngencrypt.n.b(b2);
            this.f72793i = com.kwad.sdk.pngencrypt.n.b(b2);
            this.f72794j = com.kwad.sdk.pngencrypt.n.a(b2);
            this.k = com.kwad.sdk.pngencrypt.n.a(b2);
            this.l = com.kwad.sdk.pngencrypt.n.a(b2);
            this.m = com.kwad.sdk.pngencrypt.n.a(b2);
            this.n = com.kwad.sdk.pngencrypt.n.a(b2);
        }
    }

    public void a(com.kwad.sdk.pngencrypt.k kVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, kVar) == null) {
            b(this.f72739e.f72832a);
            c(this.f72739e.f72833b);
            d(this.f72739e.f72834c);
            int i2 = this.f72739e.f72836e ? 4 : 0;
            if (this.f72739e.f72838g) {
                i2++;
            }
            if (!this.f72739e.f72837f) {
                i2 += 2;
            }
            e(i2);
            f(0);
            g(0);
            h(0);
        }
    }

    public void b(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
            this.f72792h = i2;
        }
    }

    public int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f72792h : invokeV.intValue;
    }

    public void c(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i2) == null) {
            this.f72793i = i2;
        }
    }

    public int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f72793i : invokeV.intValue;
    }

    public void d(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i2) == null) {
            this.f72794j = i2;
        }
    }

    public int e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f72794j : invokeV.intValue;
    }

    public void e(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) {
            this.k = i2;
        }
    }

    public int f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.k : invokeV.intValue;
    }

    public void f(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i2) == null) {
            this.l = i2;
        }
    }

    public int g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.n : invokeV.intValue;
    }

    public void g(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i2) == null) {
            this.m = i2;
        }
    }

    public void h(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048589, this, i2) == null) {
            this.n = i2;
        }
    }

    public boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? g() == 1 : invokeV.booleanValue;
    }

    public com.kwad.sdk.pngencrypt.k i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            j();
            return new com.kwad.sdk.pngencrypt.k(c(), d(), e(), (f() & 4) != 0, f() == 0 || f() == 4, (f() & 1) != 0);
        }
        return (com.kwad.sdk.pngencrypt.k) invokeV.objValue;
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            if (this.f72792h < 1 || this.f72793i < 1 || this.l != 0 || this.m != 0) {
                throw new PngjException("bad IHDR: col/row/compmethod/filmethod invalid");
            }
            int i2 = this.f72794j;
            if (i2 != 1 && i2 != 2 && i2 != 4 && i2 != 8 && i2 != 16) {
                throw new PngjException("bad IHDR: bitdepth invalid");
            }
            int i3 = this.n;
            if (i3 < 0 || i3 > 1) {
                throw new PngjException("bad IHDR: interlace invalid");
            }
            int i4 = this.k;
            if (i4 != 0) {
                if (i4 != 6 && i4 != 2) {
                    if (i4 == 3) {
                        if (this.f72794j == 16) {
                            throw new PngjException("bad IHDR: bitdepth invalid");
                        }
                        return;
                    } else if (i4 != 4) {
                        throw new PngjException("bad IHDR: invalid colormodel");
                    }
                }
                int i5 = this.f72794j;
                if (i5 != 8 && i5 != 16) {
                    throw new PngjException("bad IHDR: bitdepth invalid");
                }
            }
        }
    }
}
