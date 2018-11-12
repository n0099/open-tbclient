package com.facebook.c;

import com.baidu.searchbox.ng.ai.apps.canvas.model.CanvasToTempFileModel;
/* loaded from: classes2.dex */
public final class b {
    public static final c idA = new c("JPEG", "jpeg");
    public static final c idB = new c("PNG", CanvasToTempFileModel.IMAGE_EXT_PNG);
    public static final c idC = new c("GIF", "gif");
    public static final c idD = new c("BMP", "bmp");
    public static final c idE = new c("WEBP_SIMPLE", "webp");
    public static final c idF = new c("WEBP_LOSSLESS", "webp");
    public static final c idG = new c("WEBP_EXTENDED", "webp");
    public static final c idH = new c("WEBP_EXTENDED_WITH_ALPHA", "webp");
    public static final c idI = new c("WEBP_ANIMATED", "webp");

    public static boolean a(c cVar) {
        return b(cVar) || cVar == idI;
    }

    public static boolean b(c cVar) {
        return cVar == idE || cVar == idF || cVar == idG || cVar == idH;
    }
}
