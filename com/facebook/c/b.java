package com.facebook.c;
/* loaded from: classes5.dex */
public final class b {
    public static final c pGo = new c("JPEG", "jpeg");
    public static final c pGp = new c("PNG", "png");
    public static final c pGq = new c("GIF", "gif");
    public static final c pGr = new c("BMP", "bmp");
    public static final c pGs = new c("WEBP_SIMPLE", "webp");
    public static final c pGt = new c("WEBP_LOSSLESS", "webp");
    public static final c pGu = new c("WEBP_EXTENDED", "webp");
    public static final c pGv = new c("WEBP_EXTENDED_WITH_ALPHA", "webp");
    public static final c pGw = new c("WEBP_ANIMATED", "webp");
    public static final c pGx = new c("HEIF", "heif");

    public static boolean a(c cVar) {
        return b(cVar) || cVar == pGw;
    }

    public static boolean b(c cVar) {
        return cVar == pGs || cVar == pGt || cVar == pGu || cVar == pGv;
    }
}
