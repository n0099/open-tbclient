package org.brotli.dec;

import java.io.IOException;
import java.io.InputStream;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public final class j {
    int distance;
    int j;
    byte[] output;
    int qpY;
    int qqA;
    byte[] qqB;
    int qqC;
    int qqD;
    int qqE;
    int qqF;
    int qqG;
    int qqH;
    int qqI;
    int qqN;
    int qqO;
    int qqP;
    int qqQ;
    int qqR;
    byte[] qqa;
    int qqd;
    boolean qqe;
    boolean qqf;
    boolean qqg;
    int qqr;
    int qqs;
    byte[] qqt;
    byte[] qqu;
    int qqv;
    int qqw;
    int qqx;
    int qqy;
    int qqz;
    int qpX = 0;
    final a qpZ = new a();
    final int[] qqb = new int[3240];
    final int[] qqc = new int[3240];
    final g qqh = new g();
    final g qqi = new g();
    final g qqj = new g();
    final int[] qqk = new int[3];
    final int[] qql = new int[3];
    final int[] qqm = new int[6];
    final int[] qqn = {16, 15, 11, 4};
    int pos = 0;
    int hkN = 0;
    int qqo = 0;
    boolean qqp = false;
    int qqq = 0;
    int qqJ = 0;
    long qqK = 0;
    byte[] qqL = new byte[0];
    int qqM = 0;

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
        if (jVar.qpX != 0) {
            throw new IllegalStateException("State MUST be uninitialized");
        }
        a.a(jVar.qpZ, inputStream);
        int i = i(jVar.qpZ);
        if (i == 9) {
            throw new BrotliRuntimeException("Invalid 'windowBits' code");
        }
        jVar.qqI = 1 << i;
        jVar.qqH = jVar.qqI - 16;
        jVar.qpX = 1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void j(j jVar) throws IOException {
        if (jVar.qpX == 0) {
            throw new IllegalStateException("State MUST be initialized");
        }
        if (jVar.qpX != 11) {
            jVar.qpX = 11;
            a.e(jVar.qpZ);
        }
    }
}
