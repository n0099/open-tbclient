package org.brotli.dec;

import java.io.IOException;
import java.io.InputStream;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes11.dex */
public final class j {
    int distance;
    int j;
    byte[] output;
    int pML;
    byte[] pMN;
    int pMQ;
    boolean pMR;
    boolean pMS;
    boolean pMT;
    int pNA;
    int pNB;
    int pNC;
    int pND;
    int pNE;
    int pNe;
    int pNf;
    byte[] pNg;
    byte[] pNh;
    int pNi;
    int pNj;
    int pNk;
    int pNl;
    int pNm;
    int pNn;
    byte[] pNo;
    int pNp;
    int pNq;
    int pNr;
    int pNs;
    int pNt;
    int pNu;
    int pNv;
    int pMK = 0;
    final a pMM = new a();
    final int[] pMO = new int[3240];
    final int[] pMP = new int[3240];
    final g pMU = new g();
    final g pMV = new g();
    final g pMW = new g();
    final int[] pMX = new int[3];
    final int[] pMY = new int[3];
    final int[] pMZ = new int[6];
    final int[] pNa = {16, 15, 11, 4};
    int pos = 0;
    int gYW = 0;
    int pNb = 0;
    boolean pNc = false;
    int pNd = 0;
    int pNw = 0;
    long pNx = 0;
    byte[] pNy = new byte[0];
    int pNz = 0;

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
        if (jVar.pMK != 0) {
            throw new IllegalStateException("State MUST be uninitialized");
        }
        a.a(jVar.pMM, inputStream);
        int i = i(jVar.pMM);
        if (i == 9) {
            throw new BrotliRuntimeException("Invalid 'windowBits' code");
        }
        jVar.pNv = 1 << i;
        jVar.pNu = jVar.pNv - 16;
        jVar.pMK = 1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void j(j jVar) throws IOException {
        if (jVar.pMK == 0) {
            throw new IllegalStateException("State MUST be initialized");
        }
        if (jVar.pMK != 11) {
            jVar.pMK = 11;
            a.e(jVar.pMM);
        }
    }
}
