package org.brotli.dec;

import java.io.IOException;
import java.io.InputStream;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public final class j {
    int distance;
    int j;
    byte[] output;
    int qoJ;
    int qoK;
    byte[] qoL;
    byte[] qoM;
    int qoN;
    int qoO;
    int qoP;
    int qoQ;
    int qoR;
    int qoS;
    byte[] qoT;
    int qoU;
    int qoV;
    int qoW;
    int qoX;
    int qoY;
    int qoZ;
    int qoq;
    byte[] qos;
    int qov;
    boolean qow;
    boolean qox;
    boolean qoy;
    int qpa;
    int qpf;
    int qpg;
    int qph;
    int qpi;
    int qpj;
    int qop = 0;
    final a qor = new a();
    final int[] qot = new int[3240];
    final int[] qou = new int[3240];
    final g qoz = new g();
    final g qoA = new g();
    final g qoB = new g();
    final int[] qoC = new int[3];
    final int[] qoD = new int[3];
    final int[] qoE = new int[6];
    final int[] qoF = {16, 15, 11, 4};
    int pos = 0;
    int hkN = 0;
    int qoG = 0;
    boolean qoH = false;
    int qoI = 0;
    int qpb = 0;
    long qpc = 0;
    byte[] qpd = new byte[0];
    int qpe = 0;

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
        if (jVar.qop != 0) {
            throw new IllegalStateException("State MUST be uninitialized");
        }
        a.a(jVar.qor, inputStream);
        int i = i(jVar.qor);
        if (i == 9) {
            throw new BrotliRuntimeException("Invalid 'windowBits' code");
        }
        jVar.qpa = 1 << i;
        jVar.qoZ = jVar.qpa - 16;
        jVar.qop = 1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void j(j jVar) throws IOException {
        if (jVar.qop == 0) {
            throw new IllegalStateException("State MUST be initialized");
        }
        if (jVar.qop != 11) {
            jVar.qop = 11;
            a.e(jVar.qor);
        }
    }
}
