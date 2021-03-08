package org.brotli.dec;

import java.io.IOException;
import java.io.InputStream;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public final class j {
    int distance;
    int j;
    byte[] output;
    int qwC;
    byte[] qwE;
    int qwH;
    boolean qwI;
    boolean qwJ;
    boolean qwK;
    int qwV;
    int qwW;
    byte[] qwX;
    byte[] qwY;
    int qwZ;
    int qxa;
    int qxb;
    int qxc;
    int qxd;
    int qxe;
    byte[] qxf;
    int qxg;
    int qxh;
    int qxi;
    int qxj;
    int qxk;
    int qxl;
    int qxm;
    int qxr;
    int qxs;
    int qxt;
    int qxu;
    int qxv;
    int qwB = 0;
    final a qwD = new a();
    final int[] qwF = new int[3240];
    final int[] qwG = new int[3240];
    final g qwL = new g();
    final g qwM = new g();
    final g qwN = new g();
    final int[] qwO = new int[3];
    final int[] qwP = new int[3];
    final int[] qwQ = new int[6];
    final int[] qwR = {16, 15, 11, 4};
    int pos = 0;
    int hmt = 0;
    int qwS = 0;
    boolean qwT = false;
    int qwU = 0;
    int qxn = 0;
    long qxo = 0;
    byte[] qxp = new byte[0];
    int qxq = 0;

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
        if (jVar.qwB != 0) {
            throw new IllegalStateException("State MUST be uninitialized");
        }
        a.a(jVar.qwD, inputStream);
        int i = i(jVar.qwD);
        if (i == 9) {
            throw new BrotliRuntimeException("Invalid 'windowBits' code");
        }
        jVar.qxm = 1 << i;
        jVar.qxl = jVar.qxm - 16;
        jVar.qwB = 1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void j(j jVar) throws IOException {
        if (jVar.qwB == 0) {
            throw new IllegalStateException("State MUST be initialized");
        }
        if (jVar.qwB != 11) {
            jVar.qwB = 11;
            a.e(jVar.qwD);
        }
    }
}
