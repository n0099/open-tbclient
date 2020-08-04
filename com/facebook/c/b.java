package com.facebook.c;

import com.baidu.android.util.media.WebpUtils;
/* loaded from: classes3.dex */
public final class b {
    public static final c mYh = new c("JPEG", "jpeg");
    public static final c mYi = new c("PNG", "png");
    public static final c mYj = new c("GIF", "gif");
    public static final c mYk = new c("BMP", "bmp");
    public static final c mYl = new c("WEBP_SIMPLE", WebpUtils.TYPE_IMG_WEBP);
    public static final c mYm = new c("WEBP_LOSSLESS", WebpUtils.TYPE_IMG_WEBP);
    public static final c mYn = new c("WEBP_EXTENDED", WebpUtils.TYPE_IMG_WEBP);
    public static final c mYo = new c("WEBP_EXTENDED_WITH_ALPHA", WebpUtils.TYPE_IMG_WEBP);
    public static final c mYp = new c("WEBP_ANIMATED", WebpUtils.TYPE_IMG_WEBP);
    public static final c mYq = new c("HEIF", "heif");

    public static boolean a(c cVar) {
        return b(cVar) || cVar == mYp;
    }

    public static boolean b(c cVar) {
        return cVar == mYl || cVar == mYm || cVar == mYn || cVar == mYo;
    }
}
