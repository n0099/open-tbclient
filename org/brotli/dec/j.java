package org.brotli.dec;

import java.io.IOException;
import java.io.InputStream;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public final class j {
    int distance;
    int j;
    byte[] output;
    int pRN;
    byte[] pRP;
    int pRS;
    boolean pRT;
    boolean pRU;
    boolean pRV;
    int pSC;
    int pSD;
    int pSE;
    int pSF;
    int pSg;
    int pSh;
    byte[] pSi;
    byte[] pSj;
    int pSk;
    int pSl;
    int pSm;
    int pSn;
    int pSo;
    int pSp;
    byte[] pSq;
    int pSr;
    int pSs;
    int pSt;
    int pSu;
    int pSv;
    int pSw;
    int pSx;
    int pwx;
    int pRM = 0;
    final a pRO = new a();
    final int[] pRQ = new int[3240];
    final int[] pRR = new int[3240];
    final g pRW = new g();
    final g pRX = new g();
    final g pRY = new g();
    final int[] pRZ = new int[3];
    final int[] pSa = new int[3];
    final int[] pSb = new int[6];
    final int[] pSc = {16, 15, 11, 4};
    int pos = 0;
    int gKq = 0;
    int pSd = 0;
    boolean pSe = false;
    int pSf = 0;
    int pSy = 0;
    long pSz = 0;
    byte[] pSA = new byte[0];
    int pSB = 0;

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
        if (jVar.pRM != 0) {
            throw new IllegalStateException("State MUST be uninitialized");
        }
        a.a(jVar.pRO, inputStream);
        int i = i(jVar.pRO);
        if (i == 9) {
            throw new BrotliRuntimeException("Invalid 'windowBits' code");
        }
        jVar.pSx = 1 << i;
        jVar.pSw = jVar.pSx - 16;
        jVar.pRM = 1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void j(j jVar) throws IOException {
        if (jVar.pRM == 0) {
            throw new IllegalStateException("State MUST be initialized");
        }
        if (jVar.pRM != 11) {
            jVar.pRM = 11;
            a.e(jVar.pRO);
        }
    }
}
