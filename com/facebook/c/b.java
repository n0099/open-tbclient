package com.facebook.c;

import com.baidu.android.util.media.WebpUtils;
import com.baidu.searchbox.picture.component.BaseBrowseView;
/* loaded from: classes13.dex */
public final class b {
    public static final c lPq = new c("JPEG", "jpeg");
    public static final c lPr = new c("PNG", "png");
    public static final c lPs = new c("GIF", BaseBrowseView.IMG_TYPE_GIF);
    public static final c lPt = new c("BMP", "bmp");
    public static final c lPu = new c("WEBP_SIMPLE", WebpUtils.TYPE_IMG_WEBP);
    public static final c lPv = new c("WEBP_LOSSLESS", WebpUtils.TYPE_IMG_WEBP);
    public static final c lPw = new c("WEBP_EXTENDED", WebpUtils.TYPE_IMG_WEBP);
    public static final c lPx = new c("WEBP_EXTENDED_WITH_ALPHA", WebpUtils.TYPE_IMG_WEBP);
    public static final c lPy = new c("WEBP_ANIMATED", WebpUtils.TYPE_IMG_WEBP);
    public static final c lPz = new c("HEIF", "heif");

    public static boolean a(c cVar) {
        return b(cVar) || cVar == lPy;
    }

    public static boolean b(c cVar) {
        return cVar == lPu || cVar == lPv || cVar == lPw || cVar == lPx;
    }
}
