package com.facebook.c;
/* loaded from: classes5.dex */
public final class b {
    public static final c pvG = new c("JPEG", "jpeg");
    public static final c pvH = new c("PNG", "png");
    public static final c pvI = new c("GIF", "gif");
    public static final c pvJ = new c("BMP", "bmp");
    public static final c pvK = new c("WEBP_SIMPLE", "webp");
    public static final c pvL = new c("WEBP_LOSSLESS", "webp");
    public static final c pvM = new c("WEBP_EXTENDED", "webp");
    public static final c pvN = new c("WEBP_EXTENDED_WITH_ALPHA", "webp");
    public static final c pvO = new c("WEBP_ANIMATED", "webp");
    public static final c pvP = new c("HEIF", "heif");

    public static boolean a(c cVar) {
        return b(cVar) || cVar == pvO;
    }

    public static boolean b(c cVar) {
        return cVar == pvK || cVar == pvL || cVar == pvM || cVar == pvN;
    }
}
