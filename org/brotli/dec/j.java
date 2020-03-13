package org.brotli.dec;

import java.io.IOException;
import java.io.InputStream;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public final class j {
    int distance;
    int j;
    int nLA;
    byte[] nLB;
    byte[] nLC;
    int nLD;
    int nLE;
    int nLF;
    int nLG;
    int nLH;
    int nLI;
    byte[] nLJ;
    int nLK;
    int nLL;
    int nLM;
    int nLN;
    int nLO;
    int nLP;
    int nLQ;
    int nLV;
    int nLW;
    int nLX;
    int nLY;
    int nLg;
    byte[] nLi;
    int nLl;
    boolean nLm;
    boolean nLn;
    boolean nLo;
    int nLz;
    int nnw;
    byte[] output;
    int nLf = 0;
    final a nLh = new a();
    final int[] nLj = new int[3240];
    final int[] nLk = new int[3240];
    final g nLp = new g();
    final g nLq = new g();
    final g nLr = new g();
    final int[] nLs = new int[3];
    final int[] nLt = new int[3];
    final int[] nLu = new int[6];
    final int[] nLv = {16, 15, 11, 4};
    int pos = 0;
    int eLu = 0;
    int nLw = 0;
    boolean nLx = false;
    int nLy = 0;
    int nLR = 0;
    long nLS = 0;
    byte[] nLT = new byte[0];
    int nLU = 0;

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
        if (jVar.nLf != 0) {
            throw new IllegalStateException("State MUST be uninitialized");
        }
        a.a(jVar.nLh, inputStream);
        int i = i(jVar.nLh);
        if (i == 9) {
            throw new BrotliRuntimeException("Invalid 'windowBits' code");
        }
        jVar.nLQ = 1 << i;
        jVar.nLP = jVar.nLQ - 16;
        jVar.nLf = 1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void j(j jVar) throws IOException {
        if (jVar.nLf == 0) {
            throw new IllegalStateException("State MUST be initialized");
        }
        if (jVar.nLf != 11) {
            jVar.nLf = 11;
            a.e(jVar.nLh);
        }
    }
}
