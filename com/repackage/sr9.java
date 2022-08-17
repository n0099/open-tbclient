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
public final class sr9 {
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
    public final jr9 c;
    public byte[] d;
    public final int[] e;
    public final int[] f;
    public int g;
    public boolean h;
    public boolean i;
    public boolean j;
    public final pr9 k;
    public final pr9 l;
    public final pr9 m;
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

    public sr9() {
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
        this.c = new jr9();
        this.e = new int[3240];
        this.f = new int[3240];
        this.k = new pr9();
        this.l = new pr9();
        this.m = new pr9();
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

    public static void a(sr9 sr9Var) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, sr9Var) == null) {
            int i = sr9Var.a;
            if (i == 0) {
                throw new IllegalStateException("State MUST be initialized");
            }
            if (i == 11) {
                return;
            }
            sr9Var.a = 11;
            jr9.b(sr9Var.c);
        }
    }

    public static int b(jr9 jr9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, jr9Var)) == null) {
            if (jr9.i(jr9Var, 1) == 0) {
                return 16;
            }
            int i = jr9.i(jr9Var, 3);
            if (i != 0) {
                return i + 17;
            }
            int i2 = jr9.i(jr9Var, 3);
            if (i2 != 0) {
                return i2 + 8;
            }
            return 17;
        }
        return invokeL.intValue;
    }

    public static void c(sr9 sr9Var, InputStream inputStream) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, sr9Var, inputStream) == null) {
            if (sr9Var.a == 0) {
                jr9.e(sr9Var.c, inputStream);
                int b = b(sr9Var.c);
                if (b != 9) {
                    int i = 1 << b;
                    sr9Var.P = i;
                    sr9Var.O = i - 16;
                    sr9Var.a = 1;
                    return;
                }
                throw new BrotliRuntimeException("Invalid 'windowBits' code");
            }
            throw new IllegalStateException("State MUST be uninitialized");
        }
    }
}
