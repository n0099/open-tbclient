package com.facebook.drawee.backends.pipeline.debug;

import android.util.SparseIntArray;
import com.facebook.drawee.debug.DebugControllerOverlayDrawable;
/* loaded from: classes8.dex */
public class DebugOverlayImageOriginColor {
    public static final SparseIntArray IMAGE_ORIGIN_COLOR_MAP;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray(7);
        IMAGE_ORIGIN_COLOR_MAP = sparseIntArray;
        sparseIntArray.append(1, -7829368);
        IMAGE_ORIGIN_COLOR_MAP.append(2, -65536);
        IMAGE_ORIGIN_COLOR_MAP.append(3, -256);
        IMAGE_ORIGIN_COLOR_MAP.append(4, -256);
        IMAGE_ORIGIN_COLOR_MAP.append(5, DebugControllerOverlayDrawable.TEXT_COLOR_IMAGE_OK);
        IMAGE_ORIGIN_COLOR_MAP.append(6, DebugControllerOverlayDrawable.TEXT_COLOR_IMAGE_OK);
        IMAGE_ORIGIN_COLOR_MAP.append(7, DebugControllerOverlayDrawable.TEXT_COLOR_IMAGE_OK);
    }

    public static int getImageOriginColor(int i) {
        return IMAGE_ORIGIN_COLOR_MAP.get(i, -1);
    }
}
