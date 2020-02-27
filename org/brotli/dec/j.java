package org.brotli.dec;

import java.io.IOException;
import java.io.InputStream;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public final class j {
    int distance;
    int j;
    int nKT;
    byte[] nKV;
    int nKY;
    boolean nKZ;
    int nLA;
    int nLB;
    int nLC;
    int nLD;
    int nLI;
    int nLJ;
    int nLK;
    int nLL;
    boolean nLa;
    boolean nLb;
    int nLm;
    int nLn;
    byte[] nLo;
    byte[] nLp;
    int nLq;
    int nLr;
    int nLs;
    int nLt;
    int nLu;
    int nLv;
    byte[] nLw;
    int nLx;
    int nLy;
    int nLz;
    int nnj;
    byte[] output;
    int nKS = 0;
    final a nKU = new a();
    final int[] nKW = new int[3240];
    final int[] nKX = new int[3240];
    final g nLc = new g();
    final g nLd = new g();
    final g nLe = new g();
    final int[] nLf = new int[3];
    final int[] nLg = new int[3];
    final int[] nLh = new int[6];
    final int[] nLi = {16, 15, 11, 4};
    int pos = 0;
    int eLg = 0;
    int nLj = 0;
    boolean nLk = false;
    int nLl = 0;
    int nLE = 0;
    long nLF = 0;
    byte[] nLG = new byte[0];
    int nLH = 0;

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
        if (jVar.nKS != 0) {
            throw new IllegalStateException("State MUST be uninitialized");
        }
        a.a(jVar.nKU, inputStream);
        int i = i(jVar.nKU);
        if (i == 9) {
            throw new BrotliRuntimeException("Invalid 'windowBits' code");
        }
        jVar.nLD = 1 << i;
        jVar.nLC = jVar.nLD - 16;
        jVar.nKS = 1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void j(j jVar) throws IOException {
        if (jVar.nKS == 0) {
            throw new IllegalStateException("State MUST be initialized");
        }
        if (jVar.nKS != 11) {
            jVar.nKS = 11;
            a.e(jVar.nKU);
        }
    }
}
