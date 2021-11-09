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
/* loaded from: classes2.dex */
public class o implements Closeable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final k f65991a;

    /* renamed from: b  reason: collision with root package name */
    public final boolean f65992b;

    /* renamed from: c  reason: collision with root package name */
    public final c f65993c;

    /* renamed from: d  reason: collision with root package name */
    public final a f65994d;

    /* renamed from: e  reason: collision with root package name */
    public final ah f65995e;

    /* renamed from: f  reason: collision with root package name */
    public int f65996f;

    /* renamed from: g  reason: collision with root package name */
    public ErrorBehaviour f65997g;

    /* renamed from: h  reason: collision with root package name */
    public i<? extends Object> f65998h;

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
        this.f65996f = -1;
        this.f65997g = ErrorBehaviour.STRICT;
        a aVar = new a(inputStream);
        this.f65994d = aVar;
        aVar.a(z);
        c f2 = f();
        this.f65993c = f2;
        try {
            if (this.f65994d.b(f2, 36) != 36) {
                com.kwad.sdk.core.d.a.a(new PngjException("Could not read first 36 bytes (PNG signature+IHDR chunk)"));
            }
            this.f65991a = this.f65993c.j();
            this.f65992b = this.f65993c.k() != null;
            b(5024024L);
            a(901001001L);
            c(2024024L);
            this.f65993c.c("fdAT");
            this.f65993c.c("fcTL");
            this.f65995e = new ah(this.f65993c.f65891i);
            a(m.a());
            this.f65996f = -1;
        } catch (RuntimeException e2) {
            this.f65994d.close();
            this.f65993c.close();
            throw e2;
        }
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
            return;
        }
        while (true) {
            c cVar = this.f65993c;
            if (cVar.f65890h >= 4) {
                return;
            }
            if (this.f65994d.a(cVar) <= 0) {
                com.kwad.sdk.core.d.a.a(new PngjException("Premature ending reading first chunks"));
            }
        }
    }

    public void a(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j) == null) {
            this.f65993c.a(j);
        }
    }

    public void a(i<? extends Object> iVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, iVar) == null) {
            this.f65998h = iVar;
        }
    }

    public ah b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (this.f65993c.g()) {
                a();
            }
            return this.f65995e;
        }
        return (ah) invokeV.objValue;
    }

    public void b(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048580, this, j) == null) {
            this.f65993c.c(j);
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            e();
            this.f65993c.c("IDAT");
            this.f65993c.c("fdAT");
            if (this.f65993c.g()) {
                a();
            }
            d();
        }
    }

    public void c(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048582, this, j) == null) {
            this.f65993c.b(j);
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            try {
                if (this.f65993c != null) {
                    this.f65993c.close();
                }
            } catch (Exception e2) {
                com.kwad.sdk.core.d.a.e("PNG_ENCRYPT", "error closing chunk sequence:" + e2.getMessage());
            }
            a aVar = this.f65994d;
            if (aVar != null) {
                aVar.close();
            }
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            try {
                if (this.f65993c.g()) {
                    a();
                }
                if (this.f65993c.h() != null && !this.f65993c.h().d()) {
                    this.f65993c.h().g();
                }
                while (!this.f65993c.b() && this.f65994d.a(this.f65993c) > 0) {
                }
            } finally {
                close();
            }
        }
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.f65993c.a(false);
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
            return this.f65991a.toString() + " interlaced=" + this.f65992b;
        }
        return (String) invokeV.objValue;
    }
}
