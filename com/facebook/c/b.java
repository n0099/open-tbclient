package com.facebook.c;

import com.baidu.searchbox.ng.ai.apps.canvas.model.CanvasToTempFileModel;
/* loaded from: classes2.dex */
public final class b {
    public static final c ikK = new c("JPEG", "jpeg");
    public static final c ikL = new c("PNG", CanvasToTempFileModel.IMAGE_EXT_PNG);
    public static final c ikM = new c("GIF", "gif");
    public static final c ikN = new c("BMP", "bmp");
    public static final c ikO = new c("WEBP_SIMPLE", "webp");
    public static final c ikP = new c("WEBP_LOSSLESS", "webp");
    public static final c ikQ = new c("WEBP_EXTENDED", "webp");
    public static final c ikR = new c("WEBP_EXTENDED_WITH_ALPHA", "webp");
    public static final c ikS = new c("WEBP_ANIMATED", "webp");

    public static boolean a(c cVar) {
        return b(cVar) || cVar == ikS;
    }

    public static boolean b(c cVar) {
        return cVar == ikO || cVar == ikP || cVar == ikQ || cVar == ikR;
    }
}
