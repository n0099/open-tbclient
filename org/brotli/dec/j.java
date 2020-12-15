package org.brotli.dec;

import java.io.IOException;
import java.io.InputStream;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes11.dex */
public final class j {
    int distance;
    int j;
    byte[] output;
    int pMN;
    byte[] pMP;
    int pMS;
    boolean pMT;
    boolean pMU;
    boolean pMV;
    int pNC;
    int pND;
    int pNE;
    int pNF;
    int pNG;
    int pNg;
    int pNh;
    byte[] pNi;
    byte[] pNj;
    int pNk;
    int pNl;
    int pNm;
    int pNn;
    int pNo;
    int pNp;
    byte[] pNq;
    int pNr;
    int pNs;
    int pNt;
    int pNu;
    int pNv;
    int pNw;
    int pNx;
    int pMM = 0;
    final a pMO = new a();
    final int[] pMQ = new int[3240];
    final int[] pMR = new int[3240];
    final g pMW = new g();
    final g pMX = new g();
    final g pMY = new g();
    final int[] pMZ = new int[3];
    final int[] pNa = new int[3];
    final int[] pNb = new int[6];
    final int[] pNc = {16, 15, 11, 4};
    int pos = 0;
    int gYY = 0;
    int pNd = 0;
    boolean pNe = false;
    int pNf = 0;
    int pNy = 0;
    long pNz = 0;
    byte[] pNA = new byte[0];
    int pNB = 0;

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
        if (jVar.pMM != 0) {
            throw new IllegalStateException("State MUST be uninitialized");
        }
        a.a(jVar.pMO, inputStream);
        int i = i(jVar.pMO);
        if (i == 9) {
            throw new BrotliRuntimeException("Invalid 'windowBits' code");
        }
        jVar.pNx = 1 << i;
        jVar.pNw = jVar.pNx - 16;
        jVar.pMM = 1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void j(j jVar) throws IOException {
        if (jVar.pMM == 0) {
            throw new IllegalStateException("State MUST be initialized");
        }
        if (jVar.pMM != 11) {
            jVar.pMM = 11;
            a.e(jVar.pMO);
        }
    }
}
