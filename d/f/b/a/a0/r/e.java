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
/* loaded from: classes10.dex */
public final class e {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: i  reason: collision with root package name */
    public static final int f72346i;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f72347a;

    /* renamed from: b  reason: collision with root package name */
    public int f72348b;

    /* renamed from: c  reason: collision with root package name */
    public long f72349c;

    /* renamed from: d  reason: collision with root package name */
    public int f72350d;

    /* renamed from: e  reason: collision with root package name */
    public int f72351e;

    /* renamed from: f  reason: collision with root package name */
    public int f72352f;

    /* renamed from: g  reason: collision with root package name */
    public final int[] f72353g;

    /* renamed from: h  reason: collision with root package name */
    public final l f72354h;

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
        f72346i = v.q("OggS");
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
        this.f72353g = new int[255];
        this.f72354h = new l(255);
    }

    public boolean a(d.f.b.a.a0.f fVar, boolean z) throws IOException, InterruptedException {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048576, this, fVar, z)) == null) {
            this.f72354h.F();
            b();
            if ((fVar.getLength() == -1 || fVar.getLength() - fVar.f() >= 27) && fVar.d(this.f72354h.f73386a, 0, 27, true)) {
                if (this.f72354h.z() != f72346i) {
                    if (z) {
                        return false;
                    }
                    throw new ParserException("expected OggS capture pattern at begin of page");
                } else {
                    int x = this.f72354h.x();
                    this.f72347a = x;
                    if (x != 0) {
                        if (z) {
                            return false;
                        }
                        throw new ParserException("unsupported bit stream revision");
                    }
                    this.f72348b = this.f72354h.x();
                    this.f72349c = this.f72354h.m();
                    this.f72354h.n();
                    this.f72354h.n();
                    this.f72354h.n();
                    int x2 = this.f72354h.x();
                    this.f72350d = x2;
                    this.f72351e = x2 + 27;
                    this.f72354h.F();
                    fVar.c(this.f72354h.f73386a, 0, this.f72350d);
                    for (int i2 = 0; i2 < this.f72350d; i2++) {
                        this.f72353g[i2] = this.f72354h.x();
                        this.f72352f += this.f72353g[i2];
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
            this.f72347a = 0;
            this.f72348b = 0;
            this.f72349c = 0L;
            this.f72350d = 0;
            this.f72351e = 0;
            this.f72352f = 0;
        }
    }
}
