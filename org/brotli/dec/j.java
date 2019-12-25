package org.brotli.dec;

import java.io.IOException;
import java.io.InputStream;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public final class j {
    int distance;
    int j;
    int naZ;
    int nbA;
    int nbB;
    byte[] nbC;
    int nbD;
    int nbE;
    int nbF;
    int nbG;
    int nbH;
    int nbI;
    int nbJ;
    int nbO;
    int nbP;
    int nbQ;
    int nbR;
    int nbS;
    byte[] nbb;
    int nbe;
    boolean nbf;
    boolean nbg;
    boolean nbh;
    int nbs;
    int nbt;
    byte[] nbu;
    byte[] nbv;
    int nbw;
    int nbx;
    int nby;
    int nbz;
    byte[] output;
    int naY = 0;
    final a nba = new a();
    final int[] nbc = new int[3240];
    final int[] nbd = new int[3240];
    final g nbi = new g();
    final g nbj = new g();
    final g nbk = new g();
    final int[] nbl = new int[3];
    final int[] nbm = new int[3];
    final int[] nbn = new int[6];
    final int[] nbo = {16, 15, 11, 4};
    int pos = 0;
    int eGc = 0;
    int nbp = 0;
    boolean nbq = false;
    int nbr = 0;
    int nbK = 0;
    long nbL = 0;
    byte[] nbM = new byte[0];
    int nbN = 0;

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
        if (jVar.naY != 0) {
            throw new IllegalStateException("State MUST be uninitialized");
        }
        a.a(jVar.nba, inputStream);
        int i = i(jVar.nba);
        if (i == 9) {
            throw new BrotliRuntimeException("Invalid 'windowBits' code");
        }
        jVar.nbJ = 1 << i;
        jVar.nbI = jVar.nbJ - 16;
        jVar.naY = 1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void j(j jVar) throws IOException {
        if (jVar.naY == 0) {
            throw new IllegalStateException("State MUST be initialized");
        }
        if (jVar.naY != 11) {
            jVar.naY = 11;
            a.e(jVar.nba);
        }
    }
}
