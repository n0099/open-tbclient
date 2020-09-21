package com.facebook.c;

import com.baidu.android.util.media.WebpUtils;
/* loaded from: classes12.dex */
public final class b {
    public static final c nCm = new c("JPEG", "jpeg");
    public static final c nCn = new c("PNG", "png");
    public static final c nCo = new c("GIF", "gif");
    public static final c nCp = new c("BMP", "bmp");
    public static final c nCq = new c("WEBP_SIMPLE", WebpUtils.TYPE_IMG_WEBP);
    public static final c nCr = new c("WEBP_LOSSLESS", WebpUtils.TYPE_IMG_WEBP);
    public static final c nCs = new c("WEBP_EXTENDED", WebpUtils.TYPE_IMG_WEBP);
    public static final c nCt = new c("WEBP_EXTENDED_WITH_ALPHA", WebpUtils.TYPE_IMG_WEBP);
    public static final c nCu = new c("WEBP_ANIMATED", WebpUtils.TYPE_IMG_WEBP);
    public static final c nCv = new c("HEIF", "heif");

    public static boolean a(c cVar) {
        return b(cVar) || cVar == nCu;
    }

    public static boolean b(c cVar) {
        return cVar == nCq || cVar == nCr || cVar == nCs || cVar == nCt;
    }
}
