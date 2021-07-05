package d.f.b.a.a0.s;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.ParserException;
import d.f.b.a.a0.e;
import d.f.b.a.a0.f;
import d.f.b.a.a0.g;
import d.f.b.a.a0.k;
import d.f.b.a.a0.l;
import d.f.b.a.a0.m;
import d.f.b.a.i0.l;
import d.f.b.a.i0.v;
import java.io.IOException;
/* loaded from: classes10.dex */
public final class a implements e {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: i  reason: collision with root package name */
    public static final int f72381i;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final Format f72382a;

    /* renamed from: b  reason: collision with root package name */
    public final l f72383b;

    /* renamed from: c  reason: collision with root package name */
    public m f72384c;

    /* renamed from: d  reason: collision with root package name */
    public int f72385d;

    /* renamed from: e  reason: collision with root package name */
    public int f72386e;

    /* renamed from: f  reason: collision with root package name */
    public long f72387f;

    /* renamed from: g  reason: collision with root package name */
    public int f72388g;

    /* renamed from: h  reason: collision with root package name */
    public int f72389h;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1942698939, "Ld/f/b/a/a0/s/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1942698939, "Ld/f/b/a/a0/s/a;");
                return;
            }
        }
        f72381i = v.q("RCC\u0001");
    }

    public a(Format format) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {format};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f72382a = format;
        this.f72383b = new l(9);
        this.f72385d = 0;
    }

    @Override // d.f.b.a.a0.e
    public void a(long j, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Long.valueOf(j), Long.valueOf(j2)}) == null) {
            this.f72385d = 0;
        }
    }

    public final boolean b(f fVar) throws IOException, InterruptedException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, fVar)) == null) {
            this.f72383b.F();
            if (fVar.a(this.f72383b.f73386a, 0, 8, true)) {
                if (this.f72383b.i() == f72381i) {
                    this.f72386e = this.f72383b.x();
                    return true;
                }
                throw new IOException("Input not RawCC");
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public final void c(f fVar) throws IOException, InterruptedException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, fVar) == null) {
            while (this.f72388g > 0) {
                this.f72383b.F();
                fVar.readFully(this.f72383b.f73386a, 0, 3);
                this.f72384c.a(this.f72383b, 3);
                this.f72389h += 3;
                this.f72388g--;
            }
            int i2 = this.f72389h;
            if (i2 > 0) {
                this.f72384c.c(this.f72387f, 1, i2, 0, null);
            }
        }
    }

    @Override // d.f.b.a.a0.e
    public boolean d(f fVar) throws IOException, InterruptedException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, fVar)) == null) {
            this.f72383b.F();
            fVar.c(this.f72383b.f73386a, 0, 8);
            return this.f72383b.i() == f72381i;
        }
        return invokeL.booleanValue;
    }

    @Override // d.f.b.a.a0.e
    public int e(f fVar, k kVar) throws IOException, InterruptedException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeLL = interceptable.invokeLL(1048580, this, fVar, kVar)) != null) {
            return invokeLL.intValue;
        }
        while (true) {
            int i2 = this.f72385d;
            if (i2 != 0) {
                if (i2 != 1) {
                    if (i2 == 2) {
                        c(fVar);
                        this.f72385d = 1;
                        return 0;
                    }
                    throw new IllegalStateException();
                } else if (g(fVar)) {
                    this.f72385d = 2;
                } else {
                    this.f72385d = 0;
                    return -1;
                }
            } else if (!b(fVar)) {
                return -1;
            } else {
                this.f72385d = 1;
            }
        }
    }

    @Override // d.f.b.a.a0.e
    public void f(g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, gVar) == null) {
            gVar.p(new l.a(-9223372036854775807L));
            this.f72384c = gVar.a(0, 3);
            gVar.j();
            this.f72384c.b(this.f72382a);
        }
    }

    public final boolean g(f fVar) throws IOException, InterruptedException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, fVar)) == null) {
            this.f72383b.F();
            int i2 = this.f72386e;
            if (i2 == 0) {
                if (!fVar.a(this.f72383b.f73386a, 0, 5, true)) {
                    return false;
                }
                this.f72387f = (this.f72383b.z() * 1000) / 45;
            } else if (i2 == 1) {
                if (!fVar.a(this.f72383b.f73386a, 0, 9, true)) {
                    return false;
                }
                this.f72387f = this.f72383b.q();
            } else {
                throw new ParserException("Unsupported version number: " + this.f72386e);
            }
            this.f72388g = this.f72383b.x();
            this.f72389h = 0;
            return true;
        }
        return invokeL.booleanValue;
    }

    @Override // d.f.b.a.a0.e
    public void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
        }
    }
}
