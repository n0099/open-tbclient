package org.brotli.dec;

import java.io.IOException;
import java.io.InputStream;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public final class j {
    int distance;
    int j;
    int nDb;
    int nYB;
    boolean nYC;
    boolean nYD;
    boolean nYE;
    int nYP;
    int nYQ;
    byte[] nYR;
    byte[] nYS;
    int nYT;
    int nYU;
    int nYV;
    int nYW;
    int nYX;
    int nYY;
    byte[] nYZ;
    int nYw;
    byte[] nYy;
    int nZa;
    int nZb;
    int nZc;
    int nZd;
    int nZe;
    int nZf;
    int nZg;
    int nZl;
    int nZm;
    int nZn;
    int nZo;
    byte[] output;
    int nYv = 0;
    final a nYx = new a();
    final int[] nYz = new int[3240];
    final int[] nYA = new int[3240];
    final g nYF = new g();
    final g nYG = new g();
    final g nYH = new g();
    final int[] nYI = new int[3];
    final int[] nYJ = new int[3];
    final int[] nYK = new int[6];
    final int[] nYL = {16, 15, 11, 4};
    int pos = 0;
    int fPC = 0;
    int nYM = 0;
    boolean nYN = false;
    int nYO = 0;
    int nZh = 0;
    long nZi = 0;
    byte[] nZj = new byte[0];
    int nZk = 0;

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
        if (jVar.nYv != 0) {
            throw new IllegalStateException("State MUST be uninitialized");
        }
        a.a(jVar.nYx, inputStream);
        int i = i(jVar.nYx);
        if (i == 9) {
            throw new BrotliRuntimeException("Invalid 'windowBits' code");
        }
        jVar.nZg = 1 << i;
        jVar.nZf = jVar.nZg - 16;
        jVar.nYv = 1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void j(j jVar) throws IOException {
        if (jVar.nYv == 0) {
            throw new IllegalStateException("State MUST be initialized");
        }
        if (jVar.nYv != 11) {
            jVar.nYv = 11;
            a.e(jVar.nYx);
        }
    }
}
