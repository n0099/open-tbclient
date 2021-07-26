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
    public static final int f69903i;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f69904a;

    /* renamed from: b  reason: collision with root package name */
    public int f69905b;

    /* renamed from: c  reason: collision with root package name */
    public long f69906c;

    /* renamed from: d  reason: collision with root package name */
    public int f69907d;

    /* renamed from: e  reason: collision with root package name */
    public int f69908e;

    /* renamed from: f  reason: collision with root package name */
    public int f69909f;

    /* renamed from: g  reason: collision with root package name */
    public final int[] f69910g;

    /* renamed from: h  reason: collision with root package name */
    public final l f69911h;

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
        f69903i = v.q("OggS");
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
        this.f69910g = new int[255];
        this.f69911h = new l(255);
    }

    public boolean a(d.f.b.a.a0.f fVar, boolean z) throws IOException, InterruptedException {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048576, this, fVar, z)) == null) {
            this.f69911h.F();
            b();
            if ((fVar.getLength() == -1 || fVar.getLength() - fVar.f() >= 27) && fVar.d(this.f69911h.f70943a, 0, 27, true)) {
                if (this.f69911h.z() != f69903i) {
                    if (z) {
                        return false;
                    }
                    throw new ParserException("expected OggS capture pattern at begin of page");
                } else {
                    int x = this.f69911h.x();
                    this.f69904a = x;
                    if (x != 0) {
                        if (z) {
                            return false;
                        }
                        throw new ParserException("unsupported bit stream revision");
                    }
                    this.f69905b = this.f69911h.x();
                    this.f69906c = this.f69911h.m();
                    this.f69911h.n();
                    this.f69911h.n();
                    this.f69911h.n();
                    int x2 = this.f69911h.x();
                    this.f69907d = x2;
                    this.f69908e = x2 + 27;
                    this.f69911h.F();
                    fVar.c(this.f69911h.f70943a, 0, this.f69907d);
                    for (int i2 = 0; i2 < this.f69907d; i2++) {
                        this.f69910g[i2] = this.f69911h.x();
                        this.f69909f += this.f69910g[i2];
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
            this.f69904a = 0;
            this.f69905b = 0;
            this.f69906c = 0L;
            this.f69907d = 0;
            this.f69908e = 0;
            this.f69909f = 0;
        }
    }
}
