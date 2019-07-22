package com.facebook.c;
/* loaded from: classes2.dex */
public final class b {
    public static final c kel = new c("JPEG", "jpeg");
    public static final c kem = new c("PNG", "png");
    public static final c ken = new c("GIF", "gif");
    public static final c keo = new c("BMP", "bmp");
    public static final c kep = new c("WEBP_SIMPLE", "webp");
    public static final c keq = new c("WEBP_LOSSLESS", "webp");
    public static final c ker = new c("WEBP_EXTENDED", "webp");
    public static final c kes = new c("WEBP_EXTENDED_WITH_ALPHA", "webp");
    public static final c ket = new c("WEBP_ANIMATED", "webp");

    public static boolean a(c cVar) {
        return b(cVar) || cVar == ket;
    }

    public static boolean b(c cVar) {
        return cVar == kep || cVar == keq || cVar == ker || cVar == kes;
    }
}
