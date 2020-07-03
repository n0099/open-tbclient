package com.facebook.c;

import com.baidu.android.util.media.WebpUtils;
/* loaded from: classes13.dex */
public final class b {
    public static final c mPU = new c("JPEG", "jpeg");
    public static final c mPV = new c("PNG", "png");
    public static final c mPW = new c("GIF", "gif");
    public static final c mPX = new c("BMP", "bmp");
    public static final c mPY = new c("WEBP_SIMPLE", WebpUtils.TYPE_IMG_WEBP);
    public static final c mPZ = new c("WEBP_LOSSLESS", WebpUtils.TYPE_IMG_WEBP);
    public static final c mQa = new c("WEBP_EXTENDED", WebpUtils.TYPE_IMG_WEBP);
    public static final c mQb = new c("WEBP_EXTENDED_WITH_ALPHA", WebpUtils.TYPE_IMG_WEBP);
    public static final c mQc = new c("WEBP_ANIMATED", WebpUtils.TYPE_IMG_WEBP);
    public static final c mQd = new c("HEIF", "heif");

    public static boolean a(c cVar) {
        return b(cVar) || cVar == mQc;
    }

    public static boolean b(c cVar) {
        return cVar == mPY || cVar == mPZ || cVar == mQa || cVar == mQb;
    }
}
