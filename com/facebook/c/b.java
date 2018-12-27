package com.facebook.c;

import com.baidu.searchbox.ng.ai.apps.canvas.model.CanvasToTempFileModel;
/* loaded from: classes2.dex */
public final class b {
    public static final c inW = new c("JPEG", "jpeg");
    public static final c inX = new c("PNG", CanvasToTempFileModel.IMAGE_EXT_PNG);
    public static final c inY = new c("GIF", "gif");
    public static final c inZ = new c("BMP", "bmp");
    public static final c ioa = new c("WEBP_SIMPLE", "webp");
    public static final c iob = new c("WEBP_LOSSLESS", "webp");
    public static final c ioc = new c("WEBP_EXTENDED", "webp");
    public static final c iod = new c("WEBP_EXTENDED_WITH_ALPHA", "webp");
    public static final c ioe = new c("WEBP_ANIMATED", "webp");

    public static boolean a(c cVar) {
        return b(cVar) || cVar == ioe;
    }

    public static boolean b(c cVar) {
        return cVar == ioa || cVar == iob || cVar == ioc || cVar == iod;
    }
}
