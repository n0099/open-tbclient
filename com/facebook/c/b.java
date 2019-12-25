package com.facebook.c;

import com.baidu.android.util.media.WebpUtils;
import com.baidu.searchbox.picture.component.BaseBrowseView;
/* loaded from: classes11.dex */
public final class b {
    public static final c lKR = new c("JPEG", "jpeg");
    public static final c lKS = new c("PNG", "png");
    public static final c lKT = new c("GIF", BaseBrowseView.IMG_TYPE_GIF);
    public static final c lKU = new c("BMP", "bmp");
    public static final c lKV = new c("WEBP_SIMPLE", WebpUtils.TYPE_IMG_WEBP);
    public static final c lKW = new c("WEBP_LOSSLESS", WebpUtils.TYPE_IMG_WEBP);
    public static final c lKX = new c("WEBP_EXTENDED", WebpUtils.TYPE_IMG_WEBP);
    public static final c lKY = new c("WEBP_EXTENDED_WITH_ALPHA", WebpUtils.TYPE_IMG_WEBP);
    public static final c lKZ = new c("WEBP_ANIMATED", WebpUtils.TYPE_IMG_WEBP);
    public static final c lLa = new c("HEIF", "heif");

    public static boolean a(c cVar) {
        return b(cVar) || cVar == lKZ;
    }

    public static boolean b(c cVar) {
        return cVar == lKV || cVar == lKW || cVar == lKX || cVar == lKY;
    }
}
