package org.brotli.dec;

import java.io.IOException;
import java.io.InputStream;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public final class j {
    int distance;
    int j;
    byte[] output;
    int qwA;
    int qwB;
    int qwC;
    byte[] qwD;
    int qwE;
    int qwF;
    int qwG;
    int qwH;
    int qwI;
    int qwJ;
    int qwK;
    int qwP;
    int qwQ;
    int qwR;
    int qwS;
    int qwT;
    int qwa;
    byte[] qwc;
    int qwf;
    boolean qwg;
    boolean qwh;
    boolean qwi;
    int qwt;
    int qwu;
    byte[] qwv;
    byte[] qww;
    int qwx;
    int qwy;
    int qwz;
    int qvZ = 0;
    final a qwb = new a();
    final int[] qwd = new int[3240];
    final int[] qwe = new int[3240];
    final g qwj = new g();
    final g qwk = new g();
    final g qwl = new g();
    final int[] qwm = new int[3];
    final int[] qwn = new int[3];
    final int[] qwo = new int[6];
    final int[] qwp = {16, 15, 11, 4};
    int pos = 0;
    int hkK = 0;
    int qwq = 0;
    boolean qwr = false;
    int qws = 0;
    int qwL = 0;
    long qwM = 0;
    byte[] qwN = new byte[0];
    int qwO = 0;

    private static int i(a aVar) {
        if (a.a(aVar, 1) == 0) {
            return 16;
        }
        int a2 = a.a(aVar, 3);
        if (a2 != 0) {
            return a2 + 17;
        }
        int a3 = a.a(aVar, 3);
        if (a3 != 0) {
            return a3 + 8;
        }
        return 17;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(j jVar, InputStream inputStream) {
        if (jVar.qvZ != 0) {
            throw new IllegalStateException("State MUST be uninitialized");
        }
        a.a(jVar.qwb, inputStream);
        int i = i(jVar.qwb);
        if (i == 9) {
            throw new BrotliRuntimeException("Invalid 'windowBits' code");
        }
        jVar.qwK = 1 << i;
        jVar.qwJ = jVar.qwK - 16;
        jVar.qvZ = 1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void j(j jVar) throws IOException {
        if (jVar.qvZ == 0) {
            throw new IllegalStateException("State MUST be initialized");
        }
        if (jVar.qvZ != 11) {
            jVar.qvZ = 11;
            a.e(jVar.qwb);
        }
    }
}
