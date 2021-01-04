package com.facebook.c;
/* loaded from: classes6.dex */
public final class b {
    public static final c pyV = new c("JPEG", "jpeg");
    public static final c pyW = new c("PNG", "png");
    public static final c pyX = new c("GIF", "gif");
    public static final c pyY = new c("BMP", "bmp");
    public static final c pyZ = new c("WEBP_SIMPLE", "webp");
    public static final c pza = new c("WEBP_LOSSLESS", "webp");
    public static final c pzb = new c("WEBP_EXTENDED", "webp");
    public static final c pzc = new c("WEBP_EXTENDED_WITH_ALPHA", "webp");
    public static final c pzd = new c("WEBP_ANIMATED", "webp");
    public static final c pze = new c("HEIF", "heif");

    public static boolean a(c cVar) {
        return b(cVar) || cVar == pzd;
    }

    public static boolean b(c cVar) {
        return cVar == pyZ || cVar == pza || cVar == pzb || cVar == pzc;
    }
}
