package com.facebook.c;
/* loaded from: classes2.dex */
public final class b {
    public static final c jEV = new c("JPEG", "jpeg");
    public static final c jEW = new c("PNG", "png");
    public static final c jEX = new c("GIF", "gif");
    public static final c jEY = new c("BMP", "bmp");
    public static final c jEZ = new c("WEBP_SIMPLE", "webp");
    public static final c jFa = new c("WEBP_LOSSLESS", "webp");
    public static final c jFb = new c("WEBP_EXTENDED", "webp");
    public static final c jFc = new c("WEBP_EXTENDED_WITH_ALPHA", "webp");
    public static final c jFd = new c("WEBP_ANIMATED", "webp");

    public static boolean a(c cVar) {
        return b(cVar) || cVar == jFd;
    }

    public static boolean b(c cVar) {
        return cVar == jEZ || cVar == jFa || cVar == jFb || cVar == jFc;
    }
}
