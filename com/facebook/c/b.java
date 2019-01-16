package com.facebook.c;

import com.baidu.searchbox.ng.ai.apps.canvas.model.CanvasToTempFileModel;
/* loaded from: classes2.dex */
public final class b {
    public static final c ipd = new c("JPEG", "jpeg");
    public static final c ipe = new c("PNG", CanvasToTempFileModel.IMAGE_EXT_PNG);
    public static final c ipf = new c("GIF", "gif");
    public static final c ipg = new c("BMP", "bmp");
    public static final c iph = new c("WEBP_SIMPLE", "webp");
    public static final c ipi = new c("WEBP_LOSSLESS", "webp");
    public static final c ipj = new c("WEBP_EXTENDED", "webp");
    public static final c ipk = new c("WEBP_EXTENDED_WITH_ALPHA", "webp");
    public static final c ipl = new c("WEBP_ANIMATED", "webp");

    public static boolean a(c cVar) {
        return b(cVar) || cVar == ipl;
    }

    public static boolean b(c cVar) {
        return cVar == iph || cVar == ipi || cVar == ipj || cVar == ipk;
    }
}
