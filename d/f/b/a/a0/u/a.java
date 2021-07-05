package d.f.b.a.a0.u;

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
import java.io.IOException;
/* loaded from: classes10.dex */
public final class a implements e, l {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public g f72585a;

    /* renamed from: b  reason: collision with root package name */
    public m f72586b;

    /* renamed from: c  reason: collision with root package name */
    public b f72587c;

    /* renamed from: d  reason: collision with root package name */
    public int f72588d;

    /* renamed from: e  reason: collision with root package name */
    public int f72589e;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1942758521, "Ld/f/b/a/a0/u/a;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1942758521, "Ld/f/b/a/a0/u/a;");
        }
    }

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    @Override // d.f.b.a.a0.e
    public void a(long j, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Long.valueOf(j), Long.valueOf(j2)}) == null) {
            this.f72589e = 0;
        }
    }

    @Override // d.f.b.a.a0.l
    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // d.f.b.a.a0.l
    public long c(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJ = interceptable.invokeJ(Constants.METHOD_SEND_USER_MSG, this, j)) == null) ? this.f72587c.f(j) : invokeJ.longValue;
    }

    @Override // d.f.b.a.a0.e
    public boolean d(f fVar) throws IOException, InterruptedException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, fVar)) == null) ? c.a(fVar) != null : invokeL.booleanValue;
    }

    @Override // d.f.b.a.a0.e
    public int e(f fVar, k kVar) throws IOException, InterruptedException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, fVar, kVar)) == null) {
            if (this.f72587c == null) {
                b a2 = c.a(fVar);
                this.f72587c = a2;
                if (a2 != null) {
                    this.f72586b.b(Format.createAudioSampleFormat(null, "audio/raw", null, a2.a(), 32768, this.f72587c.e(), this.f72587c.g(), this.f72587c.d(), null, null, 0, null));
                    this.f72588d = this.f72587c.b();
                } else {
                    throw new ParserException("Unsupported or unrecognized wav header.");
                }
            }
            if (!this.f72587c.i()) {
                c.b(fVar, this.f72587c);
                this.f72585a.p(this);
            }
            int d2 = this.f72586b.d(fVar, 32768 - this.f72589e, true);
            if (d2 != -1) {
                this.f72589e += d2;
            }
            int i2 = this.f72589e / this.f72588d;
            if (i2 > 0) {
                long h2 = this.f72587c.h(fVar.getPosition() - this.f72589e);
                int i3 = i2 * this.f72588d;
                int i4 = this.f72589e - i3;
                this.f72589e = i4;
                this.f72586b.c(h2, 1, i3, i4, null);
            }
            return d2 == -1 ? -1 : 0;
        }
        return invokeLL.intValue;
    }

    @Override // d.f.b.a.a0.e
    public void f(g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, gVar) == null) {
            this.f72585a = gVar;
            this.f72586b = gVar.a(0, 1);
            this.f72587c = null;
            gVar.j();
        }
    }

    @Override // d.f.b.a.a0.l
    public long h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f72587c.c() : invokeV.longValue;
    }

    @Override // d.f.b.a.a0.e
    public void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
        }
    }
}
