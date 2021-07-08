package d.f.b.a.a0.r;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.ParserException;
import d.f.b.a.a0.m;
import d.f.b.a.i0.l;
import java.io.IOException;
/* loaded from: classes8.dex */
public class c implements d.f.b.a.a0.e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public d.f.b.a.a0.g f69441a;

    /* renamed from: b  reason: collision with root package name */
    public h f69442b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f69443c;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1942669210, "Ld/f/b/a/a0/r/c;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1942669210, "Ld/f/b/a/a0/r/c;");
        }
    }

    public c() {
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

    public static l b(l lVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, lVar)) == null) {
            lVar.J(0);
            return lVar;
        }
        return (l) invokeL.objValue;
    }

    @Override // d.f.b.a.a0.e
    public void a(long j, long j2) {
        h hVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Long.valueOf(j), Long.valueOf(j2)}) == null) || (hVar = this.f69442b) == null) {
            return;
        }
        hVar.k(j, j2);
    }

    public final boolean c(d.f.b.a.a0.f fVar) throws IOException, InterruptedException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, fVar)) == null) {
            e eVar = new e();
            if (eVar.a(fVar, true) && (eVar.f69451b & 2) == 2) {
                int min = Math.min(eVar.f69455f, 8);
                l lVar = new l(min);
                fVar.c(lVar.f70489a, 0, min);
                b(lVar);
                if (b.o(lVar)) {
                    this.f69442b = new b();
                } else {
                    b(lVar);
                    if (j.p(lVar)) {
                        this.f69442b = new j();
                    } else {
                        b(lVar);
                        if (g.n(lVar)) {
                            this.f69442b = new g();
                        }
                    }
                }
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // d.f.b.a.a0.e
    public boolean d(d.f.b.a.a0.f fVar) throws IOException, InterruptedException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, fVar)) == null) {
            try {
                return c(fVar);
            } catch (ParserException unused) {
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    @Override // d.f.b.a.a0.e
    public int e(d.f.b.a.a0.f fVar, d.f.b.a.a0.k kVar) throws IOException, InterruptedException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, fVar, kVar)) == null) {
            if (this.f69442b == null) {
                if (c(fVar)) {
                    fVar.e();
                } else {
                    throw new ParserException("Failed to determine bitstream type");
                }
            }
            if (!this.f69443c) {
                m a2 = this.f69441a.a(0, 1);
                this.f69441a.j();
                this.f69442b.c(this.f69441a, a2);
                this.f69443c = true;
            }
            return this.f69442b.f(fVar, kVar);
        }
        return invokeLL.intValue;
    }

    @Override // d.f.b.a.a0.e
    public void f(d.f.b.a.a0.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, gVar) == null) {
            this.f69441a = gVar;
        }
    }

    @Override // d.f.b.a.a0.e
    public void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
        }
    }
}
