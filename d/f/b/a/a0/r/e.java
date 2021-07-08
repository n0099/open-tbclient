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
import d.f.b.a.i0.l;
import d.f.b.a.i0.v;
import java.io.EOFException;
import java.io.IOException;
/* loaded from: classes8.dex */
public final class e {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: i  reason: collision with root package name */
    public static final int f69449i;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f69450a;

    /* renamed from: b  reason: collision with root package name */
    public int f69451b;

    /* renamed from: c  reason: collision with root package name */
    public long f69452c;

    /* renamed from: d  reason: collision with root package name */
    public int f69453d;

    /* renamed from: e  reason: collision with root package name */
    public int f69454e;

    /* renamed from: f  reason: collision with root package name */
    public int f69455f;

    /* renamed from: g  reason: collision with root package name */
    public final int[] f69456g;

    /* renamed from: h  reason: collision with root package name */
    public final l f69457h;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1942669272, "Ld/f/b/a/a0/r/e;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1942669272, "Ld/f/b/a/a0/r/e;");
                return;
            }
        }
        f69449i = v.q("OggS");
    }

    public e() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f69456g = new int[255];
        this.f69457h = new l(255);
    }

    public boolean a(d.f.b.a.a0.f fVar, boolean z) throws IOException, InterruptedException {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048576, this, fVar, z)) == null) {
            this.f69457h.F();
            b();
            if ((fVar.getLength() == -1 || fVar.getLength() - fVar.f() >= 27) && fVar.d(this.f69457h.f70489a, 0, 27, true)) {
                if (this.f69457h.z() != f69449i) {
                    if (z) {
                        return false;
                    }
                    throw new ParserException("expected OggS capture pattern at begin of page");
                } else {
                    int x = this.f69457h.x();
                    this.f69450a = x;
                    if (x != 0) {
                        if (z) {
                            return false;
                        }
                        throw new ParserException("unsupported bit stream revision");
                    }
                    this.f69451b = this.f69457h.x();
                    this.f69452c = this.f69457h.m();
                    this.f69457h.n();
                    this.f69457h.n();
                    this.f69457h.n();
                    int x2 = this.f69457h.x();
                    this.f69453d = x2;
                    this.f69454e = x2 + 27;
                    this.f69457h.F();
                    fVar.c(this.f69457h.f70489a, 0, this.f69453d);
                    for (int i2 = 0; i2 < this.f69453d; i2++) {
                        this.f69456g[i2] = this.f69457h.x();
                        this.f69455f += this.f69456g[i2];
                    }
                    return true;
                }
            }
            if (z) {
                return false;
            }
            throw new EOFException();
        }
        return invokeLZ.booleanValue;
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f69450a = 0;
            this.f69451b = 0;
            this.f69452c = 0L;
            this.f69453d = 0;
            this.f69454e = 0;
            this.f69455f = 0;
        }
    }
}
