package com.facebook.c;

import com.baidu.android.util.media.WebpUtils;
import com.baidu.searchbox.picture.component.BaseBrowseView;
/* loaded from: classes12.dex */
public final class b {
    public static final c lOC = new c("JPEG", "jpeg");
    public static final c lOD = new c("PNG", "png");
    public static final c lOE = new c("GIF", BaseBrowseView.IMG_TYPE_GIF);
    public static final c lOF = new c("BMP", "bmp");
    public static final c lOG = new c("WEBP_SIMPLE", WebpUtils.TYPE_IMG_WEBP);
    public static final c lOH = new c("WEBP_LOSSLESS", WebpUtils.TYPE_IMG_WEBP);
    public static final c lOI = new c("WEBP_EXTENDED", WebpUtils.TYPE_IMG_WEBP);
    public static final c lOJ = new c("WEBP_EXTENDED_WITH_ALPHA", WebpUtils.TYPE_IMG_WEBP);
    public static final c lOK = new c("WEBP_ANIMATED", WebpUtils.TYPE_IMG_WEBP);
    public static final c lOL = new c("HEIF", "heif");

    public static boolean a(c cVar) {
        return b(cVar) || cVar == lOK;
    }

    public static boolean b(c cVar) {
        return cVar == lOG || cVar == lOH || cVar == lOI || cVar == lOJ;
    }
}
