package com.facebook.c;

import com.baidu.android.util.media.WebpUtils;
/* loaded from: classes12.dex */
public final class b {
    public static final c oIX = new c("JPEG", "jpeg");
    public static final c oIY = new c("PNG", "png");
    public static final c oIZ = new c("GIF", "gif");
    public static final c oJa = new c("BMP", "bmp");
    public static final c oJb = new c("WEBP_SIMPLE", WebpUtils.TYPE_IMG_WEBP);
    public static final c oJc = new c("WEBP_LOSSLESS", WebpUtils.TYPE_IMG_WEBP);
    public static final c oJd = new c("WEBP_EXTENDED", WebpUtils.TYPE_IMG_WEBP);
    public static final c oJe = new c("WEBP_EXTENDED_WITH_ALPHA", WebpUtils.TYPE_IMG_WEBP);
    public static final c oJf = new c("WEBP_ANIMATED", WebpUtils.TYPE_IMG_WEBP);
    public static final c oJg = new c("HEIF", "heif");

    public static boolean a(c cVar) {
        return b(cVar) || cVar == oJf;
    }

    public static boolean b(c cVar) {
        return cVar == oJb || cVar == oJc || cVar == oJd || cVar == oJe;
    }
}
