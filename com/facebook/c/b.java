package com.facebook.c;

import com.baidu.android.util.media.WebpUtils;
/* loaded from: classes12.dex */
public final class b {
    public static final c nRF = new c("JPEG", "jpeg");
    public static final c nRG = new c("PNG", "png");
    public static final c nRH = new c("GIF", "gif");
    public static final c nRI = new c("BMP", "bmp");
    public static final c nRJ = new c("WEBP_SIMPLE", WebpUtils.TYPE_IMG_WEBP);
    public static final c nRK = new c("WEBP_LOSSLESS", WebpUtils.TYPE_IMG_WEBP);
    public static final c nRL = new c("WEBP_EXTENDED", WebpUtils.TYPE_IMG_WEBP);
    public static final c nRM = new c("WEBP_EXTENDED_WITH_ALPHA", WebpUtils.TYPE_IMG_WEBP);
    public static final c nRN = new c("WEBP_ANIMATED", WebpUtils.TYPE_IMG_WEBP);
    public static final c nRO = new c("HEIF", "heif");

    public static boolean a(c cVar) {
        return b(cVar) || cVar == nRN;
    }

    public static boolean b(c cVar) {
        return cVar == nRJ || cVar == nRK || cVar == nRL || cVar == nRM;
    }
}
