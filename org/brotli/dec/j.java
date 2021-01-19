package org.brotli.dec;

import java.io.IOException;
import java.io.InputStream;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public final class j {
    int distance;
    int j;
    byte[] output;
    int qlC;
    boolean qlD;
    boolean qlE;
    boolean qlF;
    int qlQ;
    int qlR;
    byte[] qlS;
    byte[] qlT;
    int qlU;
    int qlV;
    int qlW;
    int qlX;
    int qlY;
    int qlZ;
    int qlx;
    byte[] qlz;
    byte[] qma;
    int qmb;
    int qmc;
    int qmd;
    int qme;
    int qmf;
    int qmg;
    int qmh;
    int qmm;
    int qmn;
    int qmo;
    int qmp;
    int qmq;
    int qlw = 0;
    final a qly = new a();
    final int[] qlA = new int[3240];
    final int[] qlB = new int[3240];
    final g qlG = new g();
    final g qlH = new g();
    final g qlI = new g();
    final int[] qlJ = new int[3];
    final int[] qlK = new int[3];
    final int[] qlL = new int[6];
    final int[] qlM = {16, 15, 11, 4};
    int pos = 0;
    int hgg = 0;
    int qlN = 0;
    boolean qlO = false;
    int qlP = 0;
    int qmi = 0;
    long qmj = 0;
    byte[] qmk = new byte[0];
    int qml = 0;

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
        if (jVar.qlw != 0) {
            throw new IllegalStateException("State MUST be uninitialized");
        }
        a.a(jVar.qly, inputStream);
        int i = i(jVar.qly);
        if (i == 9) {
            throw new BrotliRuntimeException("Invalid 'windowBits' code");
        }
        jVar.qmh = 1 << i;
        jVar.qmg = jVar.qmh - 16;
        jVar.qlw = 1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void j(j jVar) throws IOException {
        if (jVar.qlw == 0) {
            throw new IllegalStateException("State MUST be initialized");
        }
        if (jVar.qlw != 11) {
            jVar.qlw = 11;
            a.e(jVar.qly);
        }
    }
}
