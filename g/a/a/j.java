package g.a.a;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
import java.io.InputStream;
import org.brotli.dec.BrotliRuntimeException;
/* loaded from: classes9.dex */
public final class j {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public byte[] A;
    public int B;
    public int C;
    public int D;
    public int E;
    public int F;
    public int G;
    public byte[] H;
    public int I;
    public int J;
    public int K;
    public int L;
    public int M;
    public int N;
    public int O;
    public int P;
    public int Q;
    public long R;
    public byte[] S;
    public int T;
    public int U;
    public int V;
    public int W;
    public int X;
    public int Y;
    public byte[] Z;

    /* renamed from: a  reason: collision with root package name */
    public int f72787a;

    /* renamed from: b  reason: collision with root package name */
    public int f72788b;

    /* renamed from: c  reason: collision with root package name */
    public final a f72789c;

    /* renamed from: d  reason: collision with root package name */
    public byte[] f72790d;

    /* renamed from: e  reason: collision with root package name */
    public final int[] f72791e;

    /* renamed from: f  reason: collision with root package name */
    public final int[] f72792f;

    /* renamed from: g  reason: collision with root package name */
    public int f72793g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f72794h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f72795i;
    public boolean j;
    public final g k;
    public final g l;
    public final g m;
    public final int[] n;
    public final int[] o;
    public final int[] p;
    public final int[] q;
    public int r;
    public int s;
    public int t;
    public boolean u;
    public int v;
    public int w;
    public int x;
    public int y;
    public byte[] z;

    public j() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f72787a = 0;
        this.f72789c = new a();
        this.f72791e = new int[3240];
        this.f72792f = new int[3240];
        this.k = new g();
        this.l = new g();
        this.m = new g();
        this.n = new int[3];
        this.o = new int[3];
        this.p = new int[6];
        this.q = new int[]{16, 15, 11, 4};
        this.r = 0;
        this.s = 0;
        this.t = 0;
        this.u = false;
        this.v = 0;
        this.Q = 0;
        this.R = 0L;
        this.S = new byte[0];
        this.T = 0;
    }

    public static void a(j jVar) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, jVar) == null) {
            int i2 = jVar.f72787a;
            if (i2 == 0) {
                throw new IllegalStateException("State MUST be initialized");
            }
            if (i2 == 11) {
                return;
            }
            jVar.f72787a = 11;
            a.b(jVar.f72789c);
        }
    }

    public static int b(a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, aVar)) == null) {
            if (a.i(aVar, 1) == 0) {
                return 16;
            }
            int i2 = a.i(aVar, 3);
            if (i2 != 0) {
                return i2 + 17;
            }
            int i3 = a.i(aVar, 3);
            if (i3 != 0) {
                return i3 + 8;
            }
            return 17;
        }
        return invokeL.intValue;
    }

    public static void c(j jVar, InputStream inputStream) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, jVar, inputStream) == null) {
            if (jVar.f72787a == 0) {
                a.e(jVar.f72789c, inputStream);
                int b2 = b(jVar.f72789c);
                if (b2 != 9) {
                    int i2 = 1 << b2;
                    jVar.P = i2;
                    jVar.O = i2 - 16;
                    jVar.f72787a = 1;
                    return;
                }
                throw new BrotliRuntimeException("Invalid 'windowBits' code");
            }
            throw new IllegalStateException("State MUST be uninitialized");
        }
    }
}
