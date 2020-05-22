package org.brotli.dec;

import java.io.IOException;
import java.io.InputStream;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public final class j {
    int distance;
    int j;
    int nBB;
    byte[] nBD;
    int nBG;
    boolean nBH;
    boolean nBI;
    boolean nBJ;
    int nBU;
    int nBV;
    byte[] nBW;
    byte[] nBX;
    int nBY;
    int nBZ;
    int nCa;
    int nCb;
    int nCc;
    int nCd;
    byte[] nCe;
    int nCf;
    int nCg;
    int nCh;
    int nCi;
    int nCj;
    int nCk;
    int nCl;
    int nCq;
    int nCr;
    int nCs;
    int nCt;
    int ngb;
    byte[] output;
    int nBA = 0;
    final a nBC = new a();
    final int[] nBE = new int[3240];
    final int[] nBF = new int[3240];
    final g nBK = new g();
    final g nBL = new g();
    final g nBM = new g();
    final int[] nBN = new int[3];
    final int[] nBO = new int[3];
    final int[] nBP = new int[6];
    final int[] nBQ = {16, 15, 11, 4};
    int pos = 0;
    int fEi = 0;
    int nBR = 0;
    boolean nBS = false;
    int nBT = 0;
    int nCm = 0;
    long nCn = 0;
    byte[] nCo = new byte[0];
    int nCp = 0;

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
        if (jVar.nBA != 0) {
            throw new IllegalStateException("State MUST be uninitialized");
        }
        a.a(jVar.nBC, inputStream);
        int i = i(jVar.nBC);
        if (i == 9) {
            throw new BrotliRuntimeException("Invalid 'windowBits' code");
        }
        jVar.nCl = 1 << i;
        jVar.nCk = jVar.nCl - 16;
        jVar.nBA = 1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void j(j jVar) throws IOException {
        if (jVar.nBA == 0) {
            throw new IllegalStateException("State MUST be initialized");
        }
        if (jVar.nBA != 11) {
            jVar.nBA = 11;
            a.e(jVar.nBC);
        }
    }
}
