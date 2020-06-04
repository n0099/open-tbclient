package org.brotli.dec;

import java.io.IOException;
import java.io.InputStream;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public final class j {
    int distance;
    int j;
    int nCL;
    byte[] nCN;
    int nCQ;
    boolean nCR;
    boolean nCS;
    boolean nCT;
    int nDA;
    int nDB;
    int nDC;
    int nDD;
    int nDe;
    int nDf;
    byte[] nDg;
    byte[] nDh;
    int nDi;
    int nDj;
    int nDk;
    int nDl;
    int nDm;
    int nDn;
    byte[] nDo;
    int nDp;
    int nDq;
    int nDr;
    int nDs;
    int nDt;
    int nDu;
    int nDv;
    int nhl;
    byte[] output;
    int nCK = 0;
    final a nCM = new a();
    final int[] nCO = new int[3240];
    final int[] nCP = new int[3240];
    final g nCU = new g();
    final g nCV = new g();
    final g nCW = new g();
    final int[] nCX = new int[3];
    final int[] nCY = new int[3];
    final int[] nCZ = new int[6];
    final int[] nDa = {16, 15, 11, 4};
    int pos = 0;
    int fEt = 0;
    int nDb = 0;
    boolean nDc = false;
    int nDd = 0;
    int nDw = 0;
    long nDx = 0;
    byte[] nDy = new byte[0];
    int nDz = 0;

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
        if (jVar.nCK != 0) {
            throw new IllegalStateException("State MUST be uninitialized");
        }
        a.a(jVar.nCM, inputStream);
        int i = i(jVar.nCM);
        if (i == 9) {
            throw new BrotliRuntimeException("Invalid 'windowBits' code");
        }
        jVar.nDv = 1 << i;
        jVar.nDu = jVar.nDv - 16;
        jVar.nCK = 1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void j(j jVar) throws IOException {
        if (jVar.nCK == 0) {
            throw new IllegalStateException("State MUST be initialized");
        }
        if (jVar.nCK != 11) {
            jVar.nCK = 11;
            a.e(jVar.nCM);
        }
    }
}
