package org.brotli.dec;

import java.io.IOException;
import java.io.InputStream;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public final class j {
    int distance;
    int j;
    int nJZ;
    int nKA;
    int nKB;
    byte[] nKC;
    int nKD;
    int nKE;
    int nKF;
    int nKG;
    int nKH;
    int nKI;
    int nKJ;
    int nKO;
    int nKP;
    int nKQ;
    int nKR;
    byte[] nKb;
    int nKe;
    boolean nKf;
    boolean nKg;
    boolean nKh;
    int nKs;
    int nKt;
    byte[] nKu;
    byte[] nKv;
    int nKw;
    int nKx;
    int nKy;
    int nKz;
    int nmD;
    byte[] output;
    int nJY = 0;
    final a nKa = new a();
    final int[] nKc = new int[3240];
    final int[] nKd = new int[3240];
    final g nKi = new g();
    final g nKj = new g();
    final g nKk = new g();
    final int[] nKl = new int[3];
    final int[] nKm = new int[3];
    final int[] nKn = new int[6];
    final int[] nKo = {16, 15, 11, 4};
    int pos = 0;
    int eHm = 0;
    int nKp = 0;
    boolean nKq = false;
    int nKr = 0;
    int nKK = 0;
    long nKL = 0;
    byte[] nKM = new byte[0];
    int nKN = 0;

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
        if (jVar.nJY != 0) {
            throw new IllegalStateException("State MUST be uninitialized");
        }
        a.a(jVar.nKa, inputStream);
        int i = i(jVar.nKa);
        if (i == 9) {
            throw new BrotliRuntimeException("Invalid 'windowBits' code");
        }
        jVar.nKJ = 1 << i;
        jVar.nKI = jVar.nKJ - 16;
        jVar.nJY = 1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void j(j jVar) throws IOException {
        if (jVar.nJY == 0) {
            throw new IllegalStateException("State MUST be initialized");
        }
        if (jVar.nJY != 11) {
            jVar.nJY = 11;
            a.e(jVar.nKa);
        }
    }
}
