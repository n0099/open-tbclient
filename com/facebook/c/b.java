package com.facebook.c;
/* loaded from: classes2.dex */
public final class b {
    public static final c kfs = new c("JPEG", "jpeg");
    public static final c kft = new c("PNG", "png");
    public static final c kfu = new c("GIF", "gif");
    public static final c kfv = new c("BMP", "bmp");
    public static final c kfw = new c("WEBP_SIMPLE", "webp");
    public static final c kfx = new c("WEBP_LOSSLESS", "webp");
    public static final c kfy = new c("WEBP_EXTENDED", "webp");
    public static final c kfz = new c("WEBP_EXTENDED_WITH_ALPHA", "webp");
    public static final c kfA = new c("WEBP_ANIMATED", "webp");

    public static boolean a(c cVar) {
        return b(cVar) || cVar == kfA;
    }

    public static boolean b(c cVar) {
        return cVar == kfw || cVar == kfx || cVar == kfy || cVar == kfz;
    }
}
