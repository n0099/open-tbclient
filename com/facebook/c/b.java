package com.facebook.c;

import com.baidu.android.util.media.WebpUtils;
/* loaded from: classes8.dex */
public final class b {
    public static final c nso = new c("JPEG", "jpeg");
    public static final c nsp = new c("PNG", "png");
    public static final c nsq = new c("GIF", "gif");
    public static final c nsr = new c("BMP", "bmp");
    public static final c nss = new c("WEBP_SIMPLE", WebpUtils.TYPE_IMG_WEBP);
    public static final c nst = new c("WEBP_LOSSLESS", WebpUtils.TYPE_IMG_WEBP);
    public static final c nsu = new c("WEBP_EXTENDED", WebpUtils.TYPE_IMG_WEBP);
    public static final c nsv = new c("WEBP_EXTENDED_WITH_ALPHA", WebpUtils.TYPE_IMG_WEBP);
    public static final c nsw = new c("WEBP_ANIMATED", WebpUtils.TYPE_IMG_WEBP);
    public static final c nsx = new c("HEIF", "heif");

    public static boolean a(c cVar) {
        return b(cVar) || cVar == nsw;
    }

    public static boolean b(c cVar) {
        return cVar == nss || cVar == nst || cVar == nsu || cVar == nsv;
    }
}
