package com.facebook.c;
/* loaded from: classes5.dex */
public final class b {
    public static final c pIt = new c("JPEG", "jpeg");
    public static final c pIu = new c("PNG", "png");
    public static final c pIv = new c("GIF", "gif");
    public static final c pIw = new c("BMP", "bmp");
    public static final c pIx = new c("WEBP_SIMPLE", "webp");
    public static final c pIy = new c("WEBP_LOSSLESS", "webp");
    public static final c pIz = new c("WEBP_EXTENDED", "webp");
    public static final c pIA = new c("WEBP_EXTENDED_WITH_ALPHA", "webp");
    public static final c pIB = new c("WEBP_ANIMATED", "webp");
    public static final c pIC = new c("HEIF", "heif");

    public static boolean a(c cVar) {
        return b(cVar) || cVar == pIB;
    }

    public static boolean b(c cVar) {
        return cVar == pIx || cVar == pIy || cVar == pIz || cVar == pIA;
    }
}
