package g.b.a;

import java.io.IOException;
import java.io.InputStream;
import org.brotli.dec.BrotliRuntimeException;
/* loaded from: classes8.dex */
public final class j {
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
    public int U;
    public int V;
    public int W;
    public int X;
    public int Y;
    public byte[] Z;

    /* renamed from: b  reason: collision with root package name */
    public int f71708b;

    /* renamed from: d  reason: collision with root package name */
    public byte[] f71710d;

    /* renamed from: g  reason: collision with root package name */
    public int f71713g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f71714h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f71715i;
    public boolean j;
    public int w;
    public int x;
    public int y;
    public byte[] z;

    /* renamed from: a  reason: collision with root package name */
    public int f71707a = 0;

    /* renamed from: c  reason: collision with root package name */
    public final a f71709c = new a();

    /* renamed from: e  reason: collision with root package name */
    public final int[] f71711e = new int[3240];

    /* renamed from: f  reason: collision with root package name */
    public final int[] f71712f = new int[3240];
    public final g k = new g();
    public final g l = new g();
    public final g m = new g();
    public final int[] n = new int[3];
    public final int[] o = new int[3];
    public final int[] p = new int[6];
    public final int[] q = {16, 15, 11, 4};
    public int r = 0;
    public int s = 0;
    public int t = 0;
    public boolean u = false;
    public int v = 0;
    public int Q = 0;
    public long R = 0;
    public byte[] S = new byte[0];
    public int T = 0;

    public static void a(j jVar) throws IOException {
        int i2 = jVar.f71707a;
        if (i2 == 0) {
            throw new IllegalStateException("State MUST be initialized");
        }
        if (i2 == 11) {
            return;
        }
        jVar.f71707a = 11;
        a.b(jVar.f71709c);
    }

    public static int b(a aVar) {
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

    public static void c(j jVar, InputStream inputStream) {
        if (jVar.f71707a == 0) {
            a.e(jVar.f71709c, inputStream);
            int b2 = b(jVar.f71709c);
            if (b2 != 9) {
                int i2 = 1 << b2;
                jVar.P = i2;
                jVar.O = i2 - 16;
                jVar.f71707a = 1;
                return;
            }
            throw new BrotliRuntimeException("Invalid 'windowBits' code");
        }
        throw new IllegalStateException("State MUST be uninitialized");
    }
}
