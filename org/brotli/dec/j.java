package org.brotli.dec;

import java.io.IOException;
import java.io.InputStream;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public final class j {
    int distance;
    int j;
    int nDe;
    byte[] nYB;
    int nYE;
    boolean nYF;
    boolean nYG;
    boolean nYH;
    int nYS;
    int nYT;
    byte[] nYU;
    byte[] nYV;
    int nYW;
    int nYX;
    int nYY;
    int nYZ;
    int nYz;
    int nZa;
    int nZb;
    byte[] nZc;
    int nZd;
    int nZe;
    int nZf;
    int nZg;
    int nZh;
    int nZi;
    int nZj;
    int nZo;
    int nZp;
    int nZq;
    int nZr;
    byte[] output;
    int nYy = 0;
    final a nYA = new a();
    final int[] nYC = new int[3240];
    final int[] nYD = new int[3240];
    final g nYI = new g();
    final g nYJ = new g();
    final g nYK = new g();
    final int[] nYL = new int[3];
    final int[] nYM = new int[3];
    final int[] nYN = new int[6];
    final int[] nYO = {16, 15, 11, 4};
    int pos = 0;
    int fPC = 0;
    int nYP = 0;
    boolean nYQ = false;
    int nYR = 0;
    int nZk = 0;
    long nZl = 0;
    byte[] nZm = new byte[0];
    int nZn = 0;

    private static int i(a aVar) {
        if (a.a(aVar, 1) == 0) {
            return 16;
        }
        int a = a.a(aVar, 3);
        if (a != 0) {
            return a + 17;
        }
        int a2 = a.a(aVar, 3);
        if (a2 != 0) {
            return a2 + 8;
        }
        return 17;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(j jVar, InputStream inputStream) {
        if (jVar.nYy != 0) {
            throw new IllegalStateException("State MUST be uninitialized");
        }
        a.a(jVar.nYA, inputStream);
        int i = i(jVar.nYA);
        if (i == 9) {
            throw new BrotliRuntimeException("Invalid 'windowBits' code");
        }
        jVar.nZj = 1 << i;
        jVar.nZi = jVar.nZj - 16;
        jVar.nYy = 1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void j(j jVar) throws IOException {
        if (jVar.nYy == 0) {
            throw new IllegalStateException("State MUST be initialized");
        }
        if (jVar.nYy != 11) {
            jVar.nYy = 11;
            a.e(jVar.nYA);
        }
    }
}
