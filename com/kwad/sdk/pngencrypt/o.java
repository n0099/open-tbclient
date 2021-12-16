package com.kwad.sdk.pngencrypt;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.pngencrypt.chunk.ah;
import java.io.Closeable;
import java.io.InputStream;
/* loaded from: classes3.dex */
public class o implements Closeable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final k a;

    /* renamed from: b  reason: collision with root package name */
    public final boolean f59388b;

    /* renamed from: c  reason: collision with root package name */
    public final c f59389c;

    /* renamed from: d  reason: collision with root package name */
    public final a f59390d;

    /* renamed from: e  reason: collision with root package name */
    public final ah f59391e;

    /* renamed from: f  reason: collision with root package name */
    public int f59392f;

    /* renamed from: g  reason: collision with root package name */
    public ErrorBehaviour f59393g;

    /* renamed from: h  reason: collision with root package name */
    public i<? extends Object> f59394h;

    public o(InputStream inputStream, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {inputStream, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f59392f = -1;
        this.f59393g = ErrorBehaviour.STRICT;
        a aVar = new a(inputStream);
        this.f59390d = aVar;
        aVar.a(z);
        c f2 = f();
        this.f59389c = f2;
        try {
            if (this.f59390d.b(f2, 36) != 36) {
                com.kwad.sdk.core.d.a.a(new PngjException("Could not read first 36 bytes (PNG signature+IHDR chunk)"));
            }
            this.a = this.f59389c.j();
            this.f59388b = this.f59389c.k() != null;
            b(5024024L);
            a(901001001L);
            c(2024024L);
            this.f59389c.c("fdAT");
            this.f59389c.c("fcTL");
            this.f59391e = new ah(this.f59389c.f59275i);
            a(m.a());
            this.f59392f = -1;
        } catch (RuntimeException e2) {
            this.f59390d.close();
            this.f59389c.close();
            throw e2;
        }
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
            return;
        }
        while (true) {
            c cVar = this.f59389c;
            if (cVar.f59274h >= 4) {
                return;
            }
            if (this.f59390d.a(cVar) <= 0) {
                com.kwad.sdk.core.d.a.a(new PngjException("Premature ending reading first chunks"));
            }
        }
    }

    public void a(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j2) == null) {
            this.f59389c.a(j2);
        }
    }

    public void a(i<? extends Object> iVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, iVar) == null) {
            this.f59394h = iVar;
        }
    }

    public ah b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (this.f59389c.g()) {
                a();
            }
            return this.f59391e;
        }
        return (ah) invokeV.objValue;
    }

    public void b(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048580, this, j2) == null) {
            this.f59389c.c(j2);
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            e();
            this.f59389c.c("IDAT");
            this.f59389c.c("fdAT");
            if (this.f59389c.g()) {
                a();
            }
            d();
        }
    }

    public void c(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048582, this, j2) == null) {
            this.f59389c.b(j2);
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            try {
                if (this.f59389c != null) {
                    this.f59389c.close();
                }
            } catch (Exception e2) {
                com.kwad.sdk.core.d.a.e("PNG_ENCRYPT", "error closing chunk sequence:" + e2.getMessage());
            }
            a aVar = this.f59390d;
            if (aVar != null) {
                aVar.close();
            }
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            try {
                if (this.f59389c.g()) {
                    a();
                }
                if (this.f59389c.h() != null && !this.f59389c.h().d()) {
                    this.f59389c.h().g();
                }
                while (!this.f59389c.b() && this.f59390d.a(this.f59389c) > 0) {
                }
            } finally {
                close();
            }
        }
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.f59389c.a(false);
        }
    }

    public c f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? new c(false) : (c) invokeV.objValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.a.toString() + " interlaced=" + this.f59388b;
        }
        return (String) invokeV.objValue;
    }
}
