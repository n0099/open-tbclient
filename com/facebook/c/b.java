package com.facebook.c;

import com.baidu.android.util.media.WebpUtils;
/* loaded from: classes13.dex */
public final class b {
    public static final c mtV = new c("JPEG", "jpeg");
    public static final c mtW = new c("PNG", "png");
    public static final c mtX = new c("GIF", "gif");
    public static final c mtY = new c("BMP", "bmp");
    public static final c mtZ = new c("WEBP_SIMPLE", WebpUtils.TYPE_IMG_WEBP);
    public static final c mua = new c("WEBP_LOSSLESS", WebpUtils.TYPE_IMG_WEBP);
    public static final c mub = new c("WEBP_EXTENDED", WebpUtils.TYPE_IMG_WEBP);
    public static final c muc = new c("WEBP_EXTENDED_WITH_ALPHA", WebpUtils.TYPE_IMG_WEBP);
    public static final c mud = new c("WEBP_ANIMATED", WebpUtils.TYPE_IMG_WEBP);
    public static final c mue = new c("HEIF", "heif");

    public static boolean a(c cVar) {
        return b(cVar) || cVar == mud;
    }

    public static boolean b(c cVar) {
        return cVar == mtZ || cVar == mua || cVar == mub || cVar == muc;
    }
}
