package org.brotli.dec;

import java.io.IOException;
import java.io.InputStream;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public final class j {
    int distance;
    int j;
    byte[] nKA;
    int nKB;
    int nKC;
    int nKD;
    int nKE;
    int nKF;
    int nKG;
    byte[] nKH;
    int nKI;
    int nKJ;
    int nKK;
    int nKL;
    int nKM;
    int nKN;
    int nKO;
    int nKT;
    int nKU;
    int nKV;
    int nKW;
    int nKe;
    byte[] nKg;
    int nKj;
    boolean nKk;
    boolean nKl;
    boolean nKm;
    int nKx;
    int nKy;
    byte[] nKz;
    int nmI;
    byte[] output;
    int nKd = 0;
    final a nKf = new a();
    final int[] nKh = new int[3240];
    final int[] nKi = new int[3240];
    final g nKn = new g();
    final g nKo = new g();
    final g nKp = new g();
    final int[] nKq = new int[3];
    final int[] nKr = new int[3];
    final int[] nKs = new int[6];
    final int[] nKt = {16, 15, 11, 4};
    int pos = 0;
    int eHm = 0;
    int nKu = 0;
    boolean nKv = false;
    int nKw = 0;
    int nKP = 0;
    long nKQ = 0;
    byte[] nKR = new byte[0];
    int nKS = 0;

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
        if (jVar.nKd != 0) {
            throw new IllegalStateException("State MUST be uninitialized");
        }
        a.a(jVar.nKf, inputStream);
        int i = i(jVar.nKf);
        if (i == 9) {
            throw new BrotliRuntimeException("Invalid 'windowBits' code");
        }
        jVar.nKO = 1 << i;
        jVar.nKN = jVar.nKO - 16;
        jVar.nKd = 1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void j(j jVar) throws IOException {
        if (jVar.nKd == 0) {
            throw new IllegalStateException("State MUST be initialized");
        }
        if (jVar.nKd != 11) {
            jVar.nKd = 11;
            a.e(jVar.nKf);
        }
    }
}
