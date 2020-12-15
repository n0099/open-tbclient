package com.facebook.c;

import com.baidu.android.util.media.WebpUtils;
/* loaded from: classes7.dex */
public final class b {
    public static final c piU = new c("JPEG", "jpeg");
    public static final c piV = new c("PNG", "png");
    public static final c piW = new c("GIF", "gif");
    public static final c piX = new c("BMP", "bmp");
    public static final c piY = new c("WEBP_SIMPLE", WebpUtils.TYPE_IMG_WEBP);
    public static final c piZ = new c("WEBP_LOSSLESS", WebpUtils.TYPE_IMG_WEBP);
    public static final c pja = new c("WEBP_EXTENDED", WebpUtils.TYPE_IMG_WEBP);
    public static final c pjb = new c("WEBP_EXTENDED_WITH_ALPHA", WebpUtils.TYPE_IMG_WEBP);
    public static final c pjc = new c("WEBP_ANIMATED", WebpUtils.TYPE_IMG_WEBP);
    public static final c pjd = new c("HEIF", "heif");

    public static boolean a(c cVar) {
        return b(cVar) || cVar == pjc;
    }

    public static boolean b(c cVar) {
        return cVar == piY || cVar == piZ || cVar == pja || cVar == pjb;
    }
}
