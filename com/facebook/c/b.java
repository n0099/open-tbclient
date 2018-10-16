package com.facebook.c;

import com.baidu.searchbox.ng.ai.apps.canvas.model.CanvasToTempFileModel;
/* loaded from: classes2.dex */
public final class b {
    public static final c ibM = new c("JPEG", "jpeg");
    public static final c ibN = new c("PNG", CanvasToTempFileModel.IMAGE_EXT_PNG);
    public static final c ibO = new c("GIF", "gif");
    public static final c ibP = new c("BMP", "bmp");
    public static final c ibQ = new c("WEBP_SIMPLE", "webp");
    public static final c ibR = new c("WEBP_LOSSLESS", "webp");
    public static final c ibS = new c("WEBP_EXTENDED", "webp");
    public static final c ibT = new c("WEBP_EXTENDED_WITH_ALPHA", "webp");
    public static final c ibU = new c("WEBP_ANIMATED", "webp");

    public static boolean a(c cVar) {
        return b(cVar) || cVar == ibU;
    }

    public static boolean b(c cVar) {
        return cVar == ibQ || cVar == ibR || cVar == ibS || cVar == ibT;
    }
}
