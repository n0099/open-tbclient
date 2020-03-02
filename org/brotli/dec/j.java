package org.brotli.dec;

import java.io.IOException;
import java.io.InputStream;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public final class j {
    int distance;
    int j;
    int nKV;
    byte[] nKX;
    int nLA;
    int nLB;
    int nLC;
    int nLD;
    int nLE;
    int nLF;
    int nLK;
    int nLL;
    int nLM;
    int nLN;
    int nLa;
    boolean nLb;
    boolean nLc;
    boolean nLd;
    int nLo;
    int nLp;
    byte[] nLq;
    byte[] nLr;
    int nLs;
    int nLt;
    int nLu;
    int nLv;
    int nLw;
    int nLx;
    byte[] nLy;
    int nLz;
    int nnl;
    byte[] output;
    int nKU = 0;
    final a nKW = new a();
    final int[] nKY = new int[3240];
    final int[] nKZ = new int[3240];
    final g nLe = new g();
    final g nLf = new g();
    final g nLg = new g();
    final int[] nLh = new int[3];
    final int[] nLi = new int[3];
    final int[] nLj = new int[6];
    final int[] nLk = {16, 15, 11, 4};
    int pos = 0;
    int eLh = 0;
    int nLl = 0;
    boolean nLm = false;
    int nLn = 0;
    int nLG = 0;
    long nLH = 0;
    byte[] nLI = new byte[0];
    int nLJ = 0;

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
        if (jVar.nKU != 0) {
            throw new IllegalStateException("State MUST be uninitialized");
        }
        a.a(jVar.nKW, inputStream);
        int i = i(jVar.nKW);
        if (i == 9) {
            throw new BrotliRuntimeException("Invalid 'windowBits' code");
        }
        jVar.nLF = 1 << i;
        jVar.nLE = jVar.nLF - 16;
        jVar.nKU = 1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void j(j jVar) throws IOException {
        if (jVar.nKU == 0) {
            throw new IllegalStateException("State MUST be initialized");
        }
        if (jVar.nKU != 11) {
            jVar.nKU = 11;
            a.e(jVar.nKW);
        }
    }
}
