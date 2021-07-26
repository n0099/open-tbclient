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
/* loaded from: classes6.dex */
public class o implements Closeable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final k f36053a;

    /* renamed from: b  reason: collision with root package name */
    public final boolean f36054b;

    /* renamed from: c  reason: collision with root package name */
    public final c f36055c;

    /* renamed from: d  reason: collision with root package name */
    public final a f36056d;

    /* renamed from: e  reason: collision with root package name */
    public final ah f36057e;

    /* renamed from: f  reason: collision with root package name */
    public int f36058f;

    /* renamed from: g  reason: collision with root package name */
    public ErrorBehaviour f36059g;

    /* renamed from: h  reason: collision with root package name */
    public i<? extends Object> f36060h;

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
        this.f36058f = -1;
        this.f36059g = ErrorBehaviour.STRICT;
        a aVar = new a(inputStream);
        this.f36056d = aVar;
        aVar.a(z);
        c f2 = f();
        this.f36055c = f2;
        try {
            if (this.f36056d.b(f2, 36) != 36) {
                com.kwad.sdk.core.d.a.a(new PngjException("Could not read first 36 bytes (PNG signature+IHDR chunk)"));
            }
            this.f36053a = this.f36055c.j();
            this.f36054b = this.f36055c.k() != null;
            b(5024024L);
            a(901001001L);
            c(2024024L);
            this.f36055c.c("fdAT");
            this.f36055c.c("fcTL");
            this.f36057e = new ah(this.f36055c.f35953i);
            a(m.a());
            this.f36058f = -1;
        } catch (RuntimeException e2) {
            this.f36056d.close();
            this.f36055c.close();
            throw e2;
        }
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
            return;
        }
        while (true) {
            c cVar = this.f36055c;
            if (cVar.f35952h >= 4) {
                return;
            }
            if (this.f36056d.a(cVar) <= 0) {
                com.kwad.sdk.core.d.a.a(new PngjException("Premature ending reading first chunks"));
            }
        }
    }

    public void a(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j) == null) {
            this.f36055c.a(j);
        }
    }

    public void a(i<? extends Object> iVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, iVar) == null) {
            this.f36060h = iVar;
        }
    }

    public ah b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (this.f36055c.g()) {
                a();
            }
            return this.f36057e;
        }
        return (ah) invokeV.objValue;
    }

    public void b(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048580, this, j) == null) {
            this.f36055c.c(j);
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            e();
            this.f36055c.c("IDAT");
            this.f36055c.c("fdAT");
            if (this.f36055c.g()) {
                a();
            }
            d();
        }
    }

    public void c(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048582, this, j) == null) {
            this.f36055c.b(j);
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            try {
                if (this.f36055c != null) {
                    this.f36055c.close();
                }
            } catch (Exception e2) {
                com.kwad.sdk.core.d.a.e("PNG_ENCRYPT", "error closing chunk sequence:" + e2.getMessage());
            }
            a aVar = this.f36056d;
            if (aVar != null) {
                aVar.close();
            }
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            try {
                if (this.f36055c.g()) {
                    a();
                }
                if (this.f36055c.h() != null && !this.f36055c.h().d()) {
                    this.f36055c.h().g();
                }
                while (!this.f36055c.b() && this.f36056d.a(this.f36055c) > 0) {
                }
            } finally {
                close();
            }
        }
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.f36055c.a(false);
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
            return this.f36053a.toString() + " interlaced=" + this.f36054b;
        }
        return (String) invokeV.objValue;
    }
}
