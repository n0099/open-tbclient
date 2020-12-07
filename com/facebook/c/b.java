package com.facebook.c;

import com.baidu.android.util.media.WebpUtils;
/* loaded from: classes7.dex */
public final class b {
    public static final c piS = new c("JPEG", "jpeg");
    public static final c piT = new c("PNG", "png");
    public static final c piU = new c("GIF", "gif");
    public static final c piV = new c("BMP", "bmp");
    public static final c piW = new c("WEBP_SIMPLE", WebpUtils.TYPE_IMG_WEBP);
    public static final c piX = new c("WEBP_LOSSLESS", WebpUtils.TYPE_IMG_WEBP);
    public static final c piY = new c("WEBP_EXTENDED", WebpUtils.TYPE_IMG_WEBP);
    public static final c piZ = new c("WEBP_EXTENDED_WITH_ALPHA", WebpUtils.TYPE_IMG_WEBP);
    public static final c pja = new c("WEBP_ANIMATED", WebpUtils.TYPE_IMG_WEBP);
    public static final c pjb = new c("HEIF", "heif");

    public static boolean a(c cVar) {
        return b(cVar) || cVar == pja;
    }

    public static boolean b(c cVar) {
        return cVar == piW || cVar == piX || cVar == piY || cVar == piZ;
    }
}
