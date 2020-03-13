package com.facebook.c;

import com.baidu.android.util.media.WebpUtils;
import com.baidu.searchbox.picture.component.BaseBrowseView;
/* loaded from: classes13.dex */
public final class b {
    public static final c lPB = new c("JPEG", "jpeg");
    public static final c lPC = new c("PNG", "png");
    public static final c lPD = new c("GIF", BaseBrowseView.IMG_TYPE_GIF);
    public static final c lPE = new c("BMP", "bmp");
    public static final c lPF = new c("WEBP_SIMPLE", WebpUtils.TYPE_IMG_WEBP);
    public static final c lPG = new c("WEBP_LOSSLESS", WebpUtils.TYPE_IMG_WEBP);
    public static final c lPH = new c("WEBP_EXTENDED", WebpUtils.TYPE_IMG_WEBP);
    public static final c lPI = new c("WEBP_EXTENDED_WITH_ALPHA", WebpUtils.TYPE_IMG_WEBP);
    public static final c lPJ = new c("WEBP_ANIMATED", WebpUtils.TYPE_IMG_WEBP);
    public static final c lPK = new c("HEIF", "heif");

    public static boolean a(c cVar) {
        return b(cVar) || cVar == lPJ;
    }

    public static boolean b(c cVar) {
        return cVar == lPF || cVar == lPG || cVar == lPH || cVar == lPI;
    }
}
