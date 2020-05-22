package com.facebook.c;

import com.baidu.android.util.media.WebpUtils;
/* loaded from: classes13.dex */
public final class b {
    public static final c msL = new c("JPEG", "jpeg");
    public static final c msM = new c("PNG", "png");
    public static final c msN = new c("GIF", "gif");
    public static final c msO = new c("BMP", "bmp");
    public static final c msP = new c("WEBP_SIMPLE", WebpUtils.TYPE_IMG_WEBP);
    public static final c msQ = new c("WEBP_LOSSLESS", WebpUtils.TYPE_IMG_WEBP);
    public static final c msR = new c("WEBP_EXTENDED", WebpUtils.TYPE_IMG_WEBP);
    public static final c msS = new c("WEBP_EXTENDED_WITH_ALPHA", WebpUtils.TYPE_IMG_WEBP);
    public static final c msT = new c("WEBP_ANIMATED", WebpUtils.TYPE_IMG_WEBP);
    public static final c msU = new c("HEIF", "heif");

    public static boolean a(c cVar) {
        return b(cVar) || cVar == msT;
    }

    public static boolean b(c cVar) {
        return cVar == msP || cVar == msQ || cVar == msR || cVar == msS;
    }
}
