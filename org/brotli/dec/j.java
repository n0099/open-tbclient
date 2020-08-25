package org.brotli.dec;

import java.io.IOException;
import java.io.InputStream;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public final class j {
    int distance;
    int j;
    int oBA;
    int oBB;
    byte[] oBC;
    byte[] oBD;
    int oBE;
    int oBF;
    int oBG;
    int oBH;
    int oBI;
    int oBJ;
    byte[] oBK;
    int oBL;
    int oBM;
    int oBN;
    int oBO;
    int oBP;
    int oBQ;
    int oBR;
    int oBW;
    int oBX;
    int oBY;
    int oBZ;
    int oBh;
    byte[] oBj;
    int oBm;
    boolean oBn;
    boolean oBo;
    boolean oBp;
    int ofI;
    byte[] output;
    int oBg = 0;
    final a oBi = new a();
    final int[] oBk = new int[3240];
    final int[] oBl = new int[3240];
    final g oBq = new g();
    final g oBr = new g();
    final g oBs = new g();
    final int[] oBt = new int[3];
    final int[] oBu = new int[3];
    final int[] oBv = new int[6];
    final int[] oBw = {16, 15, 11, 4};
    int pos = 0;
    int ggU = 0;
    int oBx = 0;
    boolean oBy = false;
    int oBz = 0;
    int oBS = 0;
    long oBT = 0;
    byte[] oBU = new byte[0];
    int oBV = 0;

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
        if (jVar.oBg != 0) {
            throw new IllegalStateException("State MUST be uninitialized");
        }
        a.a(jVar.oBi, inputStream);
        int i = i(jVar.oBi);
        if (i == 9) {
            throw new BrotliRuntimeException("Invalid 'windowBits' code");
        }
        jVar.oBR = 1 << i;
        jVar.oBQ = jVar.oBR - 16;
        jVar.oBg = 1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void j(j jVar) throws IOException {
        if (jVar.oBg == 0) {
            throw new IllegalStateException("State MUST be initialized");
        }
        if (jVar.oBg != 11) {
            jVar.oBg = 11;
            a.e(jVar.oBi);
        }
    }
}
