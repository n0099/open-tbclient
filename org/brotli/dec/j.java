package org.brotli.dec;

import java.io.IOException;
import java.io.InputStream;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes15.dex */
public final class j {
    int distance;
    int j;
    byte[] oLA;
    int oLB;
    int oLC;
    int oLD;
    int oLE;
    int oLF;
    int oLG;
    byte[] oLH;
    int oLI;
    int oLJ;
    int oLK;
    int oLL;
    int oLM;
    int oLN;
    int oLO;
    int oLT;
    int oLU;
    int oLV;
    int oLW;
    int oLe;
    byte[] oLg;
    int oLj;
    boolean oLk;
    boolean oLl;
    boolean oLm;
    int oLx;
    int oLy;
    byte[] oLz;
    int opJ;
    byte[] output;
    int oLd = 0;
    final a oLf = new a();
    final int[] oLh = new int[3240];
    final int[] oLi = new int[3240];
    final g oLn = new g();
    final g oLo = new g();
    final g oLp = new g();
    final int[] oLq = new int[3];
    final int[] oLr = new int[3];
    final int[] oLs = new int[6];
    final int[] oLt = {16, 15, 11, 4};
    int pos = 0;
    int gkj = 0;
    int oLu = 0;
    boolean oLv = false;
    int oLw = 0;
    int oLP = 0;
    long oLQ = 0;
    byte[] oLR = new byte[0];
    int oLS = 0;

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
        if (jVar.oLd != 0) {
            throw new IllegalStateException("State MUST be uninitialized");
        }
        a.a(jVar.oLf, inputStream);
        int i = i(jVar.oLf);
        if (i == 9) {
            throw new BrotliRuntimeException("Invalid 'windowBits' code");
        }
        jVar.oLO = 1 << i;
        jVar.oLN = jVar.oLO - 16;
        jVar.oLd = 1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void j(j jVar) throws IOException {
        if (jVar.oLd == 0) {
            throw new IllegalStateException("State MUST be initialized");
        }
        if (jVar.oLd != 11) {
            jVar.oLd = 11;
            a.e(jVar.oLf);
        }
    }
}
