package d.f.b.a.a0.t;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.f.b.a.a0.l;
import d.f.b.a.a0.t.w;
import java.io.IOException;
/* loaded from: classes8.dex */
public final class a implements d.f.b.a.a0.e {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: e  reason: collision with root package name */
    public static final int f69947e;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final long f69948a;

    /* renamed from: b  reason: collision with root package name */
    public final b f69949b;

    /* renamed from: c  reason: collision with root package name */
    public final d.f.b.a.i0.l f69950c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f69951d;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1942728730, "Ld/f/b/a/a0/t/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1942728730, "Ld/f/b/a/a0/t/a;");
                return;
            }
        }
        f69947e = d.f.b.a.i0.v.q("ID3");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public a() {
        this(0L);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                this(((Long) newInitContext.callArgs[0]).longValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    @Override // d.f.b.a.a0.e
    public void a(long j, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Long.valueOf(j), Long.valueOf(j2)}) == null) {
            this.f69951d = false;
            this.f69949b.b();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0036, code lost:
        r8.e();
        r4 = r4 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x003f, code lost:
        if ((r4 - r3) < 8192) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0041, code lost:
        return false;
     */
    @Override // d.f.b.a.a0.e
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean d(d.f.b.a.a0.f fVar) throws IOException, InterruptedException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, fVar)) != null) {
            return invokeL.booleanValue;
        }
        d.f.b.a.i0.l lVar = new d.f.b.a.i0.l(10);
        int i2 = 0;
        while (true) {
            fVar.c(lVar.f70943a, 0, 10);
            lVar.J(0);
            if (lVar.A() != f69947e) {
                break;
            }
            lVar.K(3);
            int w = lVar.w();
            i2 += w + 10;
            fVar.g(w);
        }
        fVar.e();
        fVar.g(i2);
        int i3 = i2;
        while (true) {
            int i4 = 0;
            while (true) {
                fVar.c(lVar.f70943a, 0, 5);
                lVar.J(0);
                if (lVar.D() != 2935) {
                    break;
                }
                i4++;
                if (i4 >= 4) {
                    return true;
                }
                int e2 = d.f.b.a.x.a.e(lVar.f70943a);
                if (e2 == -1) {
                    return false;
                }
                fVar.g(e2 - 5);
            }
            fVar.g(i3);
        }
    }

    @Override // d.f.b.a.a0.e
    public int e(d.f.b.a.a0.f fVar, d.f.b.a.a0.k kVar) throws IOException, InterruptedException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, fVar, kVar)) == null) {
            int read = fVar.read(this.f69950c.f70943a, 0, 2786);
            if (read == -1) {
                return -1;
            }
            this.f69950c.J(0);
            this.f69950c.I(read);
            if (!this.f69951d) {
                this.f69949b.e(this.f69948a, true);
                this.f69951d = true;
            }
            this.f69949b.c(this.f69950c);
            return 0;
        }
        return invokeLL.intValue;
    }

    @Override // d.f.b.a.a0.e
    public void f(d.f.b.a.a0.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, gVar) == null) {
            this.f69949b.f(gVar, new w.d(0, 1));
            gVar.j();
            gVar.p(new l.a(-9223372036854775807L));
        }
    }

    @Override // d.f.b.a.a0.e
    public void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
        }
    }

    public a(long j) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Long.valueOf(j)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.f69948a = j;
        this.f69949b = new b();
        this.f69950c = new d.f.b.a.i0.l(2786);
    }
}
