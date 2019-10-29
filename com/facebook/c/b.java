package com.facebook.c;
/* loaded from: classes2.dex */
public final class b {
    public static final c kga = new c("JPEG", "jpeg");
    public static final c kgb = new c("PNG", "png");
    public static final c kgc = new c("GIF", "gif");
    public static final c kgd = new c("BMP", "bmp");
    public static final c kge = new c("WEBP_SIMPLE", "webp");
    public static final c kgf = new c("WEBP_LOSSLESS", "webp");
    public static final c kgg = new c("WEBP_EXTENDED", "webp");
    public static final c kgh = new c("WEBP_EXTENDED_WITH_ALPHA", "webp");
    public static final c kgi = new c("WEBP_ANIMATED", "webp");

    public static boolean a(c cVar) {
        return b(cVar) || cVar == kgi;
    }

    public static boolean b(c cVar) {
        return cVar == kge || cVar == kgf || cVar == kgg || cVar == kgh;
    }
}
