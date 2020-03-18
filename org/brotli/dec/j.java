package org.brotli.dec;

import java.io.IOException;
import java.io.InputStream;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public final class j {
    int distance;
    int j;
    int nMT;
    byte[] nMV;
    int nMY;
    boolean nMZ;
    int nNA;
    int nNB;
    int nNC;
    int nND;
    int nNI;
    int nNJ;
    int nNK;
    int nNL;
    boolean nNa;
    boolean nNb;
    int nNm;
    int nNn;
    byte[] nNo;
    byte[] nNp;
    int nNq;
    int nNr;
    int nNs;
    int nNt;
    int nNu;
    int nNv;
    byte[] nNw;
    int nNx;
    int nNy;
    int nNz;
    int npl;
    byte[] output;
    int nMS = 0;
    final a nMU = new a();
    final int[] nMW = new int[3240];
    final int[] nMX = new int[3240];
    final g nNc = new g();
    final g nNd = new g();
    final g nNe = new g();
    final int[] nNf = new int[3];
    final int[] nNg = new int[3];
    final int[] nNh = new int[6];
    final int[] nNi = {16, 15, 11, 4};
    int pos = 0;
    int eLQ = 0;
    int nNj = 0;
    boolean nNk = false;
    int nNl = 0;
    int nNE = 0;
    long nNF = 0;
    byte[] nNG = new byte[0];
    int nNH = 0;

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
        if (jVar.nMS != 0) {
            throw new IllegalStateException("State MUST be uninitialized");
        }
        a.a(jVar.nMU, inputStream);
        int i = i(jVar.nMU);
        if (i == 9) {
            throw new BrotliRuntimeException("Invalid 'windowBits' code");
        }
        jVar.nND = 1 << i;
        jVar.nNC = jVar.nND - 16;
        jVar.nMS = 1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void j(j jVar) throws IOException {
        if (jVar.nMS == 0) {
            throw new IllegalStateException("State MUST be initialized");
        }
        if (jVar.nMS != 11) {
            jVar.nMS = 11;
            a.e(jVar.nMU);
        }
    }
}
