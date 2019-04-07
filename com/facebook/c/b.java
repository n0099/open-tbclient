package com.facebook.c;
/* loaded from: classes2.dex */
public final class b {
    public static final c jEp = new c("JPEG", "jpeg");
    public static final c jEq = new c("PNG", "png");
    public static final c jEr = new c("GIF", "gif");
    public static final c jEs = new c("BMP", "bmp");
    public static final c jEt = new c("WEBP_SIMPLE", "webp");
    public static final c jEu = new c("WEBP_LOSSLESS", "webp");
    public static final c jEv = new c("WEBP_EXTENDED", "webp");
    public static final c jEw = new c("WEBP_EXTENDED_WITH_ALPHA", "webp");
    public static final c jEx = new c("WEBP_ANIMATED", "webp");

    public static boolean a(c cVar) {
        return b(cVar) || cVar == jEx;
    }

    public static boolean b(c cVar) {
        return cVar == jEt || cVar == jEu || cVar == jEv || cVar == jEw;
    }
}
