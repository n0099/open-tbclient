package com.facebook.c;

import com.baidu.android.util.media.WebpUtils;
/* loaded from: classes12.dex */
public final class b {
    public static final c oSq = new c("JPEG", "jpeg");
    public static final c oSr = new c("PNG", "png");
    public static final c oSs = new c("GIF", "gif");
    public static final c oSt = new c("BMP", "bmp");
    public static final c oSu = new c("WEBP_SIMPLE", WebpUtils.TYPE_IMG_WEBP);
    public static final c oSv = new c("WEBP_LOSSLESS", WebpUtils.TYPE_IMG_WEBP);
    public static final c oSw = new c("WEBP_EXTENDED", WebpUtils.TYPE_IMG_WEBP);
    public static final c oSx = new c("WEBP_EXTENDED_WITH_ALPHA", WebpUtils.TYPE_IMG_WEBP);
    public static final c oSy = new c("WEBP_ANIMATED", WebpUtils.TYPE_IMG_WEBP);
    public static final c oSz = new c("HEIF", "heif");

    public static boolean a(c cVar) {
        return b(cVar) || cVar == oSy;
    }

    public static boolean b(c cVar) {
        return cVar == oSu || cVar == oSv || cVar == oSw || cVar == oSx;
    }
}
