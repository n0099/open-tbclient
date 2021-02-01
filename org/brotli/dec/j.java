package org.brotli.dec;

import java.io.IOException;
import java.io.InputStream;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public final class j {
    int distance;
    int j;
    byte[] output;
    int qvA;
    byte[] qvC;
    int qvF;
    boolean qvG;
    boolean qvH;
    boolean qvI;
    int qvT;
    int qvU;
    byte[] qvV;
    byte[] qvW;
    int qvX;
    int qvY;
    int qvZ;
    int qwa;
    int qwb;
    int qwc;
    byte[] qwd;
    int qwe;
    int qwf;
    int qwg;
    int qwh;
    int qwi;
    int qwj;
    int qwk;
    int qwp;
    int qwq;
    int qwr;
    int qws;
    int qwt;
    int qvz = 0;
    final a qvB = new a();
    final int[] qvD = new int[3240];
    final int[] qvE = new int[3240];
    final g qvJ = new g();
    final g qvK = new g();
    final g qvL = new g();
    final int[] qvM = new int[3];
    final int[] qvN = new int[3];
    final int[] qvO = new int[6];
    final int[] qvP = {16, 15, 11, 4};
    int pos = 0;
    int hkw = 0;
    int qvQ = 0;
    boolean qvR = false;
    int qvS = 0;
    int qwl = 0;
    long qwm = 0;
    byte[] qwn = new byte[0];
    int qwo = 0;

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
        if (jVar.qvz != 0) {
            throw new IllegalStateException("State MUST be uninitialized");
        }
        a.a(jVar.qvB, inputStream);
        int i = i(jVar.qvB);
        if (i == 9) {
            throw new BrotliRuntimeException("Invalid 'windowBits' code");
        }
        jVar.qwk = 1 << i;
        jVar.qwj = jVar.qwk - 16;
        jVar.qvz = 1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void j(j jVar) throws IOException {
        if (jVar.qvz == 0) {
            throw new IllegalStateException("State MUST be initialized");
        }
        if (jVar.qvz != 11) {
            jVar.qvz = 11;
            a.e(jVar.qvB);
        }
    }
}
