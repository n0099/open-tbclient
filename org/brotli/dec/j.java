package org.brotli.dec;

import java.io.IOException;
import java.io.InputStream;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public final class j {
    int distance;
    int j;
    int nLO;
    int ohE;
    int ohF;
    byte[] ohG;
    byte[] ohH;
    int ohI;
    int ohJ;
    int ohK;
    int ohL;
    int ohM;
    int ohN;
    byte[] ohO;
    int ohP;
    int ohQ;
    int ohR;
    int ohS;
    int ohT;
    int ohU;
    int ohV;
    int ohl;
    byte[] ohn;
    int ohq;
    boolean ohr;
    boolean ohs;
    boolean oht;
    int oia;
    int oib;
    int oic;
    int oid;
    byte[] output;
    int ohk = 0;
    final a ohm = new a();
    final int[] oho = new int[3240];
    final int[] ohp = new int[3240];
    final g ohu = new g();
    final g ohv = new g();
    final g ohw = new g();
    final int[] ohx = new int[3];
    final int[] ohy = new int[3];
    final int[] ohz = new int[6];
    final int[] ohA = {16, 15, 11, 4};
    int pos = 0;
    int fUV = 0;
    int ohB = 0;
    boolean ohC = false;
    int ohD = 0;
    int ohW = 0;
    long ohX = 0;
    byte[] ohY = new byte[0];
    int ohZ = 0;

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
        if (jVar.ohk != 0) {
            throw new IllegalStateException("State MUST be uninitialized");
        }
        a.a(jVar.ohm, inputStream);
        int i = i(jVar.ohm);
        if (i == 9) {
            throw new BrotliRuntimeException("Invalid 'windowBits' code");
        }
        jVar.ohV = 1 << i;
        jVar.ohU = jVar.ohV - 16;
        jVar.ohk = 1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void j(j jVar) throws IOException {
        if (jVar.ohk == 0) {
            throw new IllegalStateException("State MUST be initialized");
        }
        if (jVar.ohk != 11) {
            jVar.ohk = 11;
            a.e(jVar.ohm);
        }
    }
}
