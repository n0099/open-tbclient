package com.facebook.c;

import com.baidu.android.util.media.WebpUtils;
/* loaded from: classes8.dex */
public final class b {
    public static final c nrW = new c("JPEG", "jpeg");
    public static final c nrX = new c("PNG", "png");
    public static final c nrY = new c("GIF", "gif");
    public static final c nrZ = new c("BMP", "bmp");
    public static final c nsa = new c("WEBP_SIMPLE", WebpUtils.TYPE_IMG_WEBP);
    public static final c nsb = new c("WEBP_LOSSLESS", WebpUtils.TYPE_IMG_WEBP);
    public static final c nsc = new c("WEBP_EXTENDED", WebpUtils.TYPE_IMG_WEBP);
    public static final c nsd = new c("WEBP_EXTENDED_WITH_ALPHA", WebpUtils.TYPE_IMG_WEBP);
    public static final c nse = new c("WEBP_ANIMATED", WebpUtils.TYPE_IMG_WEBP);
    public static final c nsf = new c("HEIF", "heif");

    public static boolean a(c cVar) {
        return b(cVar) || cVar == nse;
    }

    public static boolean b(c cVar) {
        return cVar == nsa || cVar == nsb || cVar == nsc || cVar == nsd;
    }
}
