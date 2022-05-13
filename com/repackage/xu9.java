package com.repackage;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
import java.io.InputStream;
import org.brotli.dec.BrotliRuntimeException;
/* loaded from: classes7.dex */
public final class xu9 {
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
    public int a;
    public int b;
    public final ou9 c;
    public byte[] d;
    public final int[] e;
    public final int[] f;
    public int g;
    public boolean h;
    public boolean i;
    public boolean j;
    public final uu9 k;
    public final uu9 l;
    public final uu9 m;
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

    public xu9() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = 0;
        this.c = new ou9();
        this.e = new int[3240];
        this.f = new int[3240];
        this.k = new uu9();
        this.l = new uu9();
        this.m = new uu9();
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

    public static void a(xu9 xu9Var) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, xu9Var) == null) {
            int i = xu9Var.a;
            if (i == 0) {
                throw new IllegalStateException("State MUST be initialized");
            }
            if (i == 11) {
                return;
            }
            xu9Var.a = 11;
            ou9.b(xu9Var.c);
        }
    }

    public static int b(ou9 ou9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, ou9Var)) == null) {
            if (ou9.i(ou9Var, 1) == 0) {
                return 16;
            }
            int i = ou9.i(ou9Var, 3);
            if (i != 0) {
                return i + 17;
            }
            int i2 = ou9.i(ou9Var, 3);
            if (i2 != 0) {
                return i2 + 8;
            }
            return 17;
        }
        return invokeL.intValue;
    }

    public static void c(xu9 xu9Var, InputStream inputStream) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, xu9Var, inputStream) == null) {
            if (xu9Var.a == 0) {
                ou9.e(xu9Var.c, inputStream);
                int b = b(xu9Var.c);
                if (b != 9) {
                    int i = 1 << b;
                    xu9Var.P = i;
                    xu9Var.O = i - 16;
                    xu9Var.a = 1;
                    return;
                }
                throw new BrotliRuntimeException("Invalid 'windowBits' code");
            }
            throw new IllegalStateException("State MUST be uninitialized");
        }
    }
}
