package org.brotli.dec;

import java.io.IOException;
import java.io.InputStream;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes8.dex */
public final class j {
    int distance;
    int j;
    byte[] output;
    int pHt;
    int qcK;
    byte[] qcM;
    int qcP;
    boolean qcQ;
    boolean qcR;
    boolean qcS;
    int qdA;
    int qdB;
    int qdC;
    int qdd;
    int qde;
    byte[] qdf;
    byte[] qdg;
    int qdh;
    int qdi;
    int qdj;
    int qdk;
    int qdl;
    int qdm;
    byte[] qdn;
    int qdo;
    int qdp;
    int qdq;
    int qdr;
    int qds;
    int qdt;
    int qdu;
    int qdz;
    int qcJ = 0;
    final a qcL = new a();
    final int[] qcN = new int[3240];
    final int[] qcO = new int[3240];
    final g qcT = new g();
    final g qcU = new g();
    final g qcV = new g();
    final int[] qcW = new int[3];
    final int[] qcX = new int[3];
    final int[] qcY = new int[6];
    final int[] qcZ = {16, 15, 11, 4};
    int pos = 0;
    int gPJ = 0;
    int qda = 0;
    boolean qdb = false;
    int qdc = 0;
    int qdv = 0;
    long qdw = 0;
    byte[] qdx = new byte[0];
    int qdy = 0;

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
        if (jVar.qcJ != 0) {
            throw new IllegalStateException("State MUST be uninitialized");
        }
        a.a(jVar.qcL, inputStream);
        int i = i(jVar.qcL);
        if (i == 9) {
            throw new BrotliRuntimeException("Invalid 'windowBits' code");
        }
        jVar.qdu = 1 << i;
        jVar.qdt = jVar.qdu - 16;
        jVar.qcJ = 1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void j(j jVar) throws IOException {
        if (jVar.qcJ == 0) {
            throw new IllegalStateException("State MUST be initialized");
        }
        if (jVar.qcJ != 11) {
            jVar.qcJ = 11;
            a.e(jVar.qcL);
        }
    }
}
