package com.facebook.c;
/* loaded from: classes2.dex */
public final class b {
    public static final c jXh = new c("JPEG", "jpeg");
    public static final c jXi = new c("PNG", "png");
    public static final c jXj = new c("GIF", "gif");
    public static final c jXk = new c("BMP", "bmp");
    public static final c jXl = new c("WEBP_SIMPLE", "webp");
    public static final c jXm = new c("WEBP_LOSSLESS", "webp");
    public static final c jXn = new c("WEBP_EXTENDED", "webp");
    public static final c jXo = new c("WEBP_EXTENDED_WITH_ALPHA", "webp");
    public static final c jXp = new c("WEBP_ANIMATED", "webp");

    public static boolean a(c cVar) {
        return b(cVar) || cVar == jXp;
    }

    public static boolean b(c cVar) {
        return cVar == jXl || cVar == jXm || cVar == jXn || cVar == jXo;
    }
}
