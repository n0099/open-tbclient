package com.facebook.c;

import com.baidu.android.util.media.WebpUtils;
import com.baidu.searchbox.picture.component.BaseBrowseView;
/* loaded from: classes13.dex */
public final class b {
    public static final c lRh = new c("JPEG", "jpeg");
    public static final c lRi = new c("PNG", "png");
    public static final c lRj = new c("GIF", BaseBrowseView.IMG_TYPE_GIF);
    public static final c lRk = new c("BMP", "bmp");
    public static final c lRl = new c("WEBP_SIMPLE", WebpUtils.TYPE_IMG_WEBP);
    public static final c lRm = new c("WEBP_LOSSLESS", WebpUtils.TYPE_IMG_WEBP);
    public static final c lRn = new c("WEBP_EXTENDED", WebpUtils.TYPE_IMG_WEBP);
    public static final c lRo = new c("WEBP_EXTENDED_WITH_ALPHA", WebpUtils.TYPE_IMG_WEBP);
    public static final c lRp = new c("WEBP_ANIMATED", WebpUtils.TYPE_IMG_WEBP);
    public static final c lRq = new c("HEIF", "heif");

    public static boolean a(c cVar) {
        return b(cVar) || cVar == lRp;
    }

    public static boolean b(c cVar) {
        return cVar == lRl || cVar == lRm || cVar == lRn || cVar == lRo;
    }
}
