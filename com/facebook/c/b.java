package com.facebook.c;
/* loaded from: classes2.dex */
public final class b {
    public static final c khP = new c("JPEG", "jpeg");
    public static final c khQ = new c("PNG", "png");
    public static final c khR = new c("GIF", "gif");
    public static final c khS = new c("BMP", "bmp");
    public static final c khT = new c("WEBP_SIMPLE", "webp");
    public static final c khU = new c("WEBP_LOSSLESS", "webp");
    public static final c khV = new c("WEBP_EXTENDED", "webp");
    public static final c khW = new c("WEBP_EXTENDED_WITH_ALPHA", "webp");
    public static final c khX = new c("WEBP_ANIMATED", "webp");

    public static boolean a(c cVar) {
        return b(cVar) || cVar == khX;
    }

    public static boolean b(c cVar) {
        return cVar == khT || cVar == khU || cVar == khV || cVar == khW;
    }
}
