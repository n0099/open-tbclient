package org.brotli.dec;

import java.io.IOException;
import java.io.InputStream;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public final class j {
    int distance;
    int j;
    int mLU;
    int ngC;
    boolean ngD;
    boolean ngE;
    boolean ngF;
    int ngQ;
    int ngR;
    byte[] ngS;
    byte[] ngT;
    int ngU;
    int ngV;
    int ngW;
    int ngX;
    int ngY;
    int ngZ;
    int ngx;
    byte[] ngz;
    byte[] nha;
    int nhb;
    int nhc;
    int nhd;
    int nhe;
    int nhf;
    int nhg;
    int nhh;
    int nhm;
    int nhn;
    int nho;
    int nhp;
    byte[] output;
    int ngw = 0;
    final a ngy = new a();
    final int[] ngA = new int[3240];
    final int[] ngB = new int[3240];
    final g ngG = new g();
    final g ngH = new g();
    final g ngI = new g();
    final int[] ngJ = new int[3];
    final int[] ngK = new int[3];
    final int[] ngL = new int[6];
    final int[] ngM = {16, 15, 11, 4};
    int pos = 0;
    int fqj = 0;
    int ngN = 0;
    boolean ngO = false;
    int ngP = 0;
    int nhi = 0;
    long nhj = 0;
    byte[] nhk = new byte[0];
    int nhl = 0;

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
        if (jVar.ngw != 0) {
            throw new IllegalStateException("State MUST be uninitialized");
        }
        a.a(jVar.ngy, inputStream);
        int i = i(jVar.ngy);
        if (i == 9) {
            throw new BrotliRuntimeException("Invalid 'windowBits' code");
        }
        jVar.nhh = 1 << i;
        jVar.nhg = jVar.nhh - 16;
        jVar.ngw = 1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void j(j jVar) throws IOException {
        if (jVar.ngw == 0) {
            throw new IllegalStateException("State MUST be initialized");
        }
        if (jVar.ngw != 11) {
            jVar.ngw = 11;
            a.e(jVar.ngy);
        }
    }
}
