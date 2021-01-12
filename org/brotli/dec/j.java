package org.brotli.dec;

import java.io.IOException;
import java.io.InputStream;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public final class j {
    int distance;
    int j;
    byte[] output;
    int qlB;
    boolean qlC;
    boolean qlD;
    boolean qlE;
    int qlP;
    int qlQ;
    byte[] qlR;
    byte[] qlS;
    int qlT;
    int qlU;
    int qlV;
    int qlW;
    int qlX;
    int qlY;
    byte[] qlZ;
    int qlw;
    byte[] qly;
    int qma;
    int qmb;
    int qmc;
    int qmd;
    int qme;
    int qmf;
    int qmg;
    int qml;
    int qmm;
    int qmn;
    int qmo;
    int qmp;
    int qlv = 0;
    final a qlx = new a();
    final int[] qlz = new int[3240];
    final int[] qlA = new int[3240];
    final g qlF = new g();
    final g qlG = new g();
    final g qlH = new g();
    final int[] qlI = new int[3];
    final int[] qlJ = new int[3];
    final int[] qlK = new int[6];
    final int[] qlL = {16, 15, 11, 4};
    int pos = 0;
    int hgg = 0;
    int qlM = 0;
    boolean qlN = false;
    int qlO = 0;
    int qmh = 0;
    long qmi = 0;
    byte[] qmj = new byte[0];
    int qmk = 0;

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
        if (jVar.qlv != 0) {
            throw new IllegalStateException("State MUST be uninitialized");
        }
        a.a(jVar.qlx, inputStream);
        int i = i(jVar.qlx);
        if (i == 9) {
            throw new BrotliRuntimeException("Invalid 'windowBits' code");
        }
        jVar.qmg = 1 << i;
        jVar.qmf = jVar.qmg - 16;
        jVar.qlv = 1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void j(j jVar) throws IOException {
        if (jVar.qlv == 0) {
            throw new IllegalStateException("State MUST be initialized");
        }
        if (jVar.qlv != 11) {
            jVar.qlv = 11;
            a.e(jVar.qlx);
        }
    }
}
