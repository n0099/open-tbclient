package org.brotli.dec;

import java.io.IOException;
import java.io.InputStream;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public final class j {
    int distance;
    int j;
    byte[] oBB;
    int oBE;
    boolean oBF;
    boolean oBG;
    boolean oBH;
    int oBS;
    int oBT;
    byte[] oBU;
    byte[] oBV;
    int oBW;
    int oBX;
    int oBY;
    int oBZ;
    int oBz;
    int oCa;
    int oCb;
    byte[] oCc;
    int oCd;
    int oCe;
    int oCf;
    int oCg;
    int oCh;
    int oCi;
    int oCj;
    int oCo;
    int oCp;
    int oCq;
    int oCr;
    int oga;
    byte[] output;
    int oBy = 0;
    final a oBA = new a();
    final int[] oBC = new int[3240];
    final int[] oBD = new int[3240];
    final g oBI = new g();
    final g oBJ = new g();
    final g oBK = new g();
    final int[] oBL = new int[3];
    final int[] oBM = new int[3];
    final int[] oBN = new int[6];
    final int[] oBO = {16, 15, 11, 4};
    int pos = 0;
    int ggY = 0;
    int oBP = 0;
    boolean oBQ = false;
    int oBR = 0;
    int oCk = 0;
    long oCl = 0;
    byte[] oCm = new byte[0];
    int oCn = 0;

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
        if (jVar.oBy != 0) {
            throw new IllegalStateException("State MUST be uninitialized");
        }
        a.a(jVar.oBA, inputStream);
        int i = i(jVar.oBA);
        if (i == 9) {
            throw new BrotliRuntimeException("Invalid 'windowBits' code");
        }
        jVar.oCj = 1 << i;
        jVar.oCi = jVar.oCj - 16;
        jVar.oBy = 1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void j(j jVar) throws IOException {
        if (jVar.oBy == 0) {
            throw new IllegalStateException("State MUST be initialized");
        }
        if (jVar.oBy != 11) {
            jVar.oBy = 11;
            a.e(jVar.oBA);
        }
    }
}
