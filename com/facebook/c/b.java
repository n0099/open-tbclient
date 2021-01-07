package com.facebook.c;
/* loaded from: classes5.dex */
public final class b {
    public static final c pAg = new c("JPEG", "jpeg");
    public static final c pAh = new c("PNG", "png");
    public static final c pAi = new c("GIF", "gif");
    public static final c pAj = new c("BMP", "bmp");
    public static final c pAk = new c("WEBP_SIMPLE", "webp");
    public static final c pAl = new c("WEBP_LOSSLESS", "webp");
    public static final c pAm = new c("WEBP_EXTENDED", "webp");
    public static final c pAn = new c("WEBP_EXTENDED_WITH_ALPHA", "webp");
    public static final c pAo = new c("WEBP_ANIMATED", "webp");
    public static final c pAp = new c("HEIF", "heif");

    public static boolean a(c cVar) {
        return b(cVar) || cVar == pAo;
    }

    public static boolean b(c cVar) {
        return cVar == pAk || cVar == pAl || cVar == pAm || cVar == pAn;
    }
}
