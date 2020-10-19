package org.brotli.dec;

import java.io.IOException;
import java.io.InputStream;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public final class j {
    int distance;
    int j;
    int oFa;
    byte[] output;
    boolean paA;
    boolean paB;
    boolean paC;
    int paN;
    int paO;
    byte[] paP;
    byte[] paQ;
    int paR;
    int paS;
    int paT;
    int paU;
    int paV;
    int paW;
    byte[] paX;
    int paY;
    int paZ;
    int pat;
    byte[] pav;
    int paz;
    int pba;
    int pbb;
    int pbc;
    int pbd;
    int pbe;
    int pbj;
    int pbk;
    int pbl;
    int pbm;
    int pas = 0;
    final a pau = new a();
    final int[] paw = new int[3240];
    final int[] pax = new int[3240];
    final g paD = new g();
    final g paE = new g();
    final g paF = new g();
    final int[] paG = new int[3];
    final int[] paH = new int[3];
    final int[] paI = new int[6];
    final int[] paJ = {16, 15, 11, 4};
    int pos = 0;
    int gyC = 0;
    int paK = 0;
    boolean paL = false;
    int paM = 0;
    int pbf = 0;
    long pbg = 0;
    byte[] pbh = new byte[0];
    int pbi = 0;

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
        if (jVar.pas != 0) {
            throw new IllegalStateException("State MUST be uninitialized");
        }
        a.a(jVar.pau, inputStream);
        int i = i(jVar.pau);
        if (i == 9) {
            throw new BrotliRuntimeException("Invalid 'windowBits' code");
        }
        jVar.pbe = 1 << i;
        jVar.pbd = jVar.pbe - 16;
        jVar.pas = 1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void j(j jVar) throws IOException {
        if (jVar.pas == 0) {
            throw new IllegalStateException("State MUST be initialized");
        }
        if (jVar.pas != 11) {
            jVar.pas = 11;
            a.e(jVar.pau);
        }
    }
}
