package com.facebook.c;
/* loaded from: classes2.dex */
public final class b {
    public static final c jEK = new c("JPEG", "jpeg");
    public static final c jEL = new c("PNG", "png");
    public static final c jEM = new c("GIF", "gif");
    public static final c jEN = new c("BMP", "bmp");
    public static final c jEO = new c("WEBP_SIMPLE", "webp");
    public static final c jEP = new c("WEBP_LOSSLESS", "webp");
    public static final c jEQ = new c("WEBP_EXTENDED", "webp");
    public static final c jER = new c("WEBP_EXTENDED_WITH_ALPHA", "webp");
    public static final c jES = new c("WEBP_ANIMATED", "webp");

    public static boolean a(c cVar) {
        return b(cVar) || cVar == jES;
    }

    public static boolean b(c cVar) {
        return cVar == jEO || cVar == jEP || cVar == jEQ || cVar == jER;
    }
}
