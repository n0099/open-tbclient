package com.facebook.c;
/* loaded from: classes2.dex */
public final class b {
    public static final c jFd = new c("JPEG", "jpeg");
    public static final c jFe = new c("PNG", "png");
    public static final c jFf = new c("GIF", "gif");
    public static final c jFg = new c("BMP", "bmp");
    public static final c jFh = new c("WEBP_SIMPLE", "webp");
    public static final c jFi = new c("WEBP_LOSSLESS", "webp");
    public static final c jFj = new c("WEBP_EXTENDED", "webp");
    public static final c jFk = new c("WEBP_EXTENDED_WITH_ALPHA", "webp");
    public static final c jFl = new c("WEBP_ANIMATED", "webp");

    public static boolean a(c cVar) {
        return b(cVar) || cVar == jFl;
    }

    public static boolean b(c cVar) {
        return cVar == jFh || cVar == jFi || cVar == jFj || cVar == jFk;
    }
}
