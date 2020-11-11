package org.brotli.dec;

import java.io.IOException;
import java.io.InputStream;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public final class j {
    int distance;
    int j;
    byte[] output;
    int pFQ;
    int qbA;
    int qbB;
    byte[] qbC;
    byte[] qbD;
    int qbE;
    int qbF;
    int qbG;
    int qbH;
    int qbI;
    int qbJ;
    byte[] qbK;
    int qbL;
    int qbM;
    int qbN;
    int qbO;
    int qbP;
    int qbQ;
    int qbR;
    int qbW;
    int qbX;
    int qbY;
    int qbZ;
    int qbh;
    byte[] qbj;
    int qbm;
    boolean qbn;
    boolean qbo;
    boolean qbp;
    int qbg = 0;
    final a qbi = new a();
    final int[] qbk = new int[3240];
    final int[] qbl = new int[3240];
    final g qbq = new g();
    final g qbr = new g();
    final g qbs = new g();
    final int[] qbt = new int[3];
    final int[] qbu = new int[3];
    final int[] qbv = new int[6];
    final int[] qbw = {16, 15, 11, 4};
    int pos = 0;
    int gQc = 0;
    int qbx = 0;
    boolean qby = false;
    int qbz = 0;
    int qbS = 0;
    long qbT = 0;
    byte[] qbU = new byte[0];
    int qbV = 0;

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
        if (jVar.qbg != 0) {
            throw new IllegalStateException("State MUST be uninitialized");
        }
        a.a(jVar.qbi, inputStream);
        int i = i(jVar.qbi);
        if (i == 9) {
            throw new BrotliRuntimeException("Invalid 'windowBits' code");
        }
        jVar.qbR = 1 << i;
        jVar.qbQ = jVar.qbR - 16;
        jVar.qbg = 1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void j(j jVar) throws IOException {
        if (jVar.qbg == 0) {
            throw new IllegalStateException("State MUST be initialized");
        }
        if (jVar.qbg != 11) {
            jVar.qbg = 11;
            a.e(jVar.qbi);
        }
    }
}
