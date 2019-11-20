package com.facebook.c;
/* loaded from: classes2.dex */
public final class b {
    public static final c kfj = new c("JPEG", "jpeg");
    public static final c kfk = new c("PNG", "png");
    public static final c kfl = new c("GIF", "gif");
    public static final c kfm = new c("BMP", "bmp");
    public static final c kfn = new c("WEBP_SIMPLE", "webp");
    public static final c kfo = new c("WEBP_LOSSLESS", "webp");
    public static final c kfp = new c("WEBP_EXTENDED", "webp");
    public static final c kfq = new c("WEBP_EXTENDED_WITH_ALPHA", "webp");
    public static final c kfr = new c("WEBP_ANIMATED", "webp");

    public static boolean a(c cVar) {
        return b(cVar) || cVar == kfr;
    }

    public static boolean b(c cVar) {
        return cVar == kfn || cVar == kfo || cVar == kfp || cVar == kfq;
    }
}
