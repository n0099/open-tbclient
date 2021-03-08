package com.yy.mediaframework.gpuimage.util;
/* loaded from: classes6.dex */
public class VideoSizeUtil {

    /* loaded from: classes6.dex */
    public enum ScaleMode {
        CLIP_TO_BOUNDS,
        ASPECTFIT,
        FULL_FILL
    }

    public static Size CalcFitSize(int i, int i2, int i3, int i4, ScaleMode scaleMode) {
        Size size = new Size(i, i2);
        if (ScaleMode.ASPECTFIT == scaleMode) {
            if (i4 * i < i3 * i2) {
                size.width = (int) ((((i4 * 1.0d) / i2) * i) + 0.5d);
                size.height = i4;
                size.x = (i3 - size.width) / 2;
                size.y = 0;
            } else {
                size.width = i3;
                size.height = (int) ((((i3 * 1.0d) / i) * i2) + 0.5d);
                size.x = 0;
                size.y = (i4 - size.height) / 2;
            }
        } else if (ScaleMode.CLIP_TO_BOUNDS == scaleMode) {
            if (i4 * i < i3 * i2) {
                size.width = i3;
                size.height = (int) ((((i3 * 1.0d) / i) * i2) + 0.5d);
                size.x = 0;
                size.y = (i4 - size.height) / 2;
            } else {
                size.width = (int) ((((i4 * 1.0d) / i2) * i) + 0.5d);
                size.height = i4;
                size.x = (i3 - size.width) / 2;
                size.y = 0;
            }
        } else if (ScaleMode.FULL_FILL == scaleMode) {
            size.height = i4;
            size.width = i3;
            size.x = 0;
            size.y = 0;
        }
        return size;
    }

    /* loaded from: classes6.dex */
    public static class Size {
        public int height;
        public int width;
        public int x;
        public int y;

        public Size(int i, int i2) {
            this.width = i;
            this.height = i2;
        }

        public Size() {
            this.width = 0;
            this.height = 0;
        }
    }
}
