package org.brotli.dec;

import java.io.IOException;
import java.io.InputStream;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public final class j {
    int distance;
    int j;
    int mLX;
    int ngA;
    byte[] ngC;
    int ngF;
    boolean ngG;
    boolean ngH;
    boolean ngI;
    int ngT;
    int ngU;
    byte[] ngV;
    byte[] ngW;
    int ngX;
    int ngY;
    int ngZ;
    int nha;
    int nhb;
    int nhc;
    byte[] nhd;
    int nhe;
    int nhf;
    int nhg;
    int nhh;
    int nhi;
    int nhj;
    int nhk;
    int nhp;
    int nhq;
    int nhr;
    int nhs;
    byte[] output;
    int ngz = 0;
    final a ngB = new a();
    final int[] ngD = new int[3240];
    final int[] ngE = new int[3240];
    final g ngJ = new g();
    final g ngK = new g();
    final g ngL = new g();
    final int[] ngM = new int[3];
    final int[] ngN = new int[3];
    final int[] ngO = new int[6];
    final int[] ngP = {16, 15, 11, 4};
    int pos = 0;
    int fqo = 0;
    int ngQ = 0;
    boolean ngR = false;
    int ngS = 0;
    int nhl = 0;
    long nhm = 0;
    byte[] nhn = new byte[0];
    int nho = 0;

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
        if (jVar.ngz != 0) {
            throw new IllegalStateException("State MUST be uninitialized");
        }
        a.a(jVar.ngB, inputStream);
        int i = i(jVar.ngB);
        if (i == 9) {
            throw new BrotliRuntimeException("Invalid 'windowBits' code");
        }
        jVar.nhk = 1 << i;
        jVar.nhj = jVar.nhk - 16;
        jVar.ngz = 1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void j(j jVar) throws IOException {
        if (jVar.ngz == 0) {
            throw new IllegalStateException("State MUST be initialized");
        }
        if (jVar.ngz != 11) {
            jVar.ngz = 11;
            a.e(jVar.ngB);
        }
    }
}
