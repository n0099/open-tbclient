package com.facebook.c;

import com.baidu.android.util.media.WebpUtils;
/* loaded from: classes13.dex */
public final class b {
    public static final c lYQ = new c("JPEG", "jpeg");
    public static final c lYR = new c("PNG", "png");
    public static final c lYS = new c("GIF", "gif");
    public static final c lYT = new c("BMP", "bmp");
    public static final c lYU = new c("WEBP_SIMPLE", WebpUtils.TYPE_IMG_WEBP);
    public static final c lYV = new c("WEBP_LOSSLESS", WebpUtils.TYPE_IMG_WEBP);
    public static final c lYW = new c("WEBP_EXTENDED", WebpUtils.TYPE_IMG_WEBP);
    public static final c lYX = new c("WEBP_EXTENDED_WITH_ALPHA", WebpUtils.TYPE_IMG_WEBP);
    public static final c lYY = new c("WEBP_ANIMATED", WebpUtils.TYPE_IMG_WEBP);
    public static final c lYZ = new c("HEIF", "heif");

    public static boolean a(c cVar) {
        return b(cVar) || cVar == lYY;
    }

    public static boolean b(c cVar) {
        return cVar == lYU || cVar == lYV || cVar == lYW || cVar == lYX;
    }
}
