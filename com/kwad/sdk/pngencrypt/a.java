package com.kwad.sdk.pngencrypt;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
/* loaded from: classes2.dex */
public class a implements Closeable {
    public static /* synthetic */ Interceptable $ic;
    public static final /* synthetic */ boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public InputStream f58671b;

    /* renamed from: c  reason: collision with root package name */
    public byte[] f58672c;

    /* renamed from: d  reason: collision with root package name */
    public int f58673d;

    /* renamed from: e  reason: collision with root package name */
    public int f58674e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f58675f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f58676g;

    /* renamed from: h  reason: collision with root package name */
    public long f58677h;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-743219246, "Lcom/kwad/sdk/pngencrypt/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-743219246, "Lcom/kwad/sdk/pngencrypt/a;");
                return;
            }
        }
        a = !a.class.desiredAssertionStatus();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public a(InputStream inputStream) {
        this(inputStream, 16384);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {inputStream};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((InputStream) objArr2[0], ((Integer) objArr2[1]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public a(InputStream inputStream, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {inputStream, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.f58675f = false;
        this.f58676g = true;
        this.f58677h = 0L;
        this.f58671b = inputStream;
        this.f58672c = new byte[i2 < 1 ? 16384 : i2];
    }

    public int a(f fVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, fVar)) == null) ? a(fVar, Integer.MAX_VALUE) : invokeL.intValue;
    }

    public int a(f fVar, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, fVar, i2)) == null) {
            a();
            if (i2 <= 0 || i2 >= this.f58673d) {
                i2 = this.f58673d;
            }
            if (i2 <= 0) {
                if (!this.f58675f) {
                    com.kwad.sdk.core.d.a.a(new PngjException("This should not happen"));
                }
                return fVar.b() ? -1 : 0;
            }
            int a2 = fVar.a(this.f58672c, this.f58674e, i2);
            if (a2 > 0) {
                this.f58674e += a2;
                int i3 = this.f58673d - a2;
                this.f58673d = i3;
                if (!a && i3 < 0) {
                    throw new AssertionError();
                }
            }
            if (a2 > 0) {
                return a2;
            }
            if (!fVar.b()) {
                com.kwad.sdk.core.d.a.a(new PngjException("This should not happen!"));
            }
            return -1;
        }
        return invokeLI.intValue;
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || this.f58673d > 0 || this.f58675f) {
            return;
        }
        try {
            this.f58674e = 0;
            int read = this.f58671b.read(this.f58672c);
            this.f58673d = read;
            if (read == 0) {
                com.kwad.sdk.core.d.a.a(new PngjException("This should not happen: stream.read(buf) returned 0"));
            } else if (read < 0) {
                close();
            } else {
                this.f58677h += read;
            }
        } catch (IOException e2) {
            com.kwad.sdk.core.d.a.a(new PngjException(e2));
        }
    }

    public void a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            this.f58676g = z;
        }
    }

    public int b(f fVar, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048580, this, fVar, i2)) == null) {
            int i3 = i2;
            while (i3 > 0) {
                int a2 = a(fVar, i3);
                if (a2 <= 0) {
                    return a2;
                }
                i3 -= a2;
            }
            if (a || i3 == 0) {
                return i2;
            }
            throw new AssertionError();
        }
        return invokeLI.intValue;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.f58675f = true;
            this.f58672c = null;
            this.f58673d = 0;
            this.f58674e = 0;
            InputStream inputStream = this.f58671b;
            if (inputStream != null && this.f58676g) {
                try {
                    inputStream.close();
                } catch (Exception unused) {
                }
            }
            this.f58671b = null;
        }
    }
}
