package org.brotli.dec;

import java.io.IOException;
import java.io.InputStream;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public final class j {
    int distance;
    int j;
    int nLM;
    int ohC;
    int ohD;
    byte[] ohE;
    byte[] ohF;
    int ohG;
    int ohH;
    int ohI;
    int ohJ;
    int ohK;
    int ohL;
    byte[] ohM;
    int ohN;
    int ohO;
    int ohP;
    int ohQ;
    int ohR;
    int ohS;
    int ohT;
    int ohY;
    int ohZ;
    int ohj;
    byte[] ohl;
    int oho;
    boolean ohp;
    boolean ohq;
    boolean ohr;
    int oia;
    int oib;
    byte[] output;
    int ohi = 0;
    final a ohk = new a();
    final int[] ohm = new int[3240];
    final int[] ohn = new int[3240];
    final g ohs = new g();
    final g oht = new g();
    final g ohu = new g();
    final int[] ohv = new int[3];
    final int[] ohw = new int[3];
    final int[] ohx = new int[6];
    final int[] ohy = {16, 15, 11, 4};
    int pos = 0;
    int fUV = 0;
    int ohz = 0;
    boolean ohA = false;
    int ohB = 0;
    int ohU = 0;
    long ohV = 0;
    byte[] ohW = new byte[0];
    int ohX = 0;

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
        if (jVar.ohi != 0) {
            throw new IllegalStateException("State MUST be uninitialized");
        }
        a.a(jVar.ohk, inputStream);
        int i = i(jVar.ohk);
        if (i == 9) {
            throw new BrotliRuntimeException("Invalid 'windowBits' code");
        }
        jVar.ohT = 1 << i;
        jVar.ohS = jVar.ohT - 16;
        jVar.ohi = 1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void j(j jVar) throws IOException {
        if (jVar.ohi == 0) {
            throw new IllegalStateException("State MUST be initialized");
        }
        if (jVar.ohi != 11) {
            jVar.ohi = 11;
            a.e(jVar.ohk);
        }
    }
}
