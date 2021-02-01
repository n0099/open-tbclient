package com.facebook.c;
/* loaded from: classes5.dex */
public final class b {
    public static final c pFO = new c("JPEG", "jpeg");
    public static final c pFP = new c("PNG", "png");
    public static final c pFQ = new c("GIF", "gif");
    public static final c pFR = new c("BMP", "bmp");
    public static final c pFS = new c("WEBP_SIMPLE", "webp");
    public static final c pFT = new c("WEBP_LOSSLESS", "webp");
    public static final c pFU = new c("WEBP_EXTENDED", "webp");
    public static final c pFV = new c("WEBP_EXTENDED_WITH_ALPHA", "webp");
    public static final c pFW = new c("WEBP_ANIMATED", "webp");
    public static final c pFX = new c("HEIF", "heif");

    public static boolean a(c cVar) {
        return b(cVar) || cVar == pFW;
    }

    public static boolean b(c cVar) {
        return cVar == pFS || cVar == pFT || cVar == pFU || cVar == pFV;
    }
}
