package com.facebook.c;
/* loaded from: classes2.dex */
public final class b {
    public static final c jXe = new c("JPEG", "jpeg");
    public static final c jXf = new c("PNG", "png");
    public static final c jXg = new c("GIF", "gif");
    public static final c jXh = new c("BMP", "bmp");
    public static final c jXi = new c("WEBP_SIMPLE", "webp");
    public static final c jXj = new c("WEBP_LOSSLESS", "webp");
    public static final c jXk = new c("WEBP_EXTENDED", "webp");
    public static final c jXl = new c("WEBP_EXTENDED_WITH_ALPHA", "webp");
    public static final c jXm = new c("WEBP_ANIMATED", "webp");

    public static boolean a(c cVar) {
        return b(cVar) || cVar == jXm;
    }

    public static boolean b(c cVar) {
        return cVar == jXi || cVar == jXj || cVar == jXk || cVar == jXl;
    }
}
