package com.yy.mediaframework.utils;

import com.yy.mediaframework.Constant;
import java.util.Locale;
/* loaded from: classes6.dex */
public class VideoSizeUtils {
    private static final String TAG = "VideoSizeUtils";

    public static Size CalcFitSize(int i, int i2, int i3, int i4, Constant.ScaleMode scaleMode) {
        YMFLog.info(null, "[Util    ]", String.format(Locale.getDefault(), "imageWidth:%d, imageHeight:%d, frameWidth:%d, frameHeight:%d", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)) + " scaleMode:" + scaleMode);
        Size size = new Size(i, i2);
        if (Constant.ScaleMode.AspectFit == scaleMode) {
            if (i4 * i < i3 * i2) {
                size.width = (int) ((((1.0d * i4) / i2) * i) + 0.5d);
                size.height = i4;
                size.x = (i3 - size.width) / 2;
                size.y = 0;
            } else {
                size.width = i3;
                size.height = (int) ((((1.0d * i3) / i) * i2) + 0.5d);
                size.x = 0;
                size.y = (i4 - size.height) / 2;
            }
        } else if (Constant.ScaleMode.AspectFill == scaleMode) {
            if (i4 * i < i3 * i2) {
                size.width = i3;
                size.height = (int) ((((1.0d * i3) / i) * i2) + 0.5d);
                size.x = 0;
                size.y = (i4 - size.height) / 2;
            } else {
                size.width = (int) ((((1.0d * i4) / i2) * i) + 0.5d);
                size.height = i4;
                size.x = (i3 - size.width) / 2;
                size.y = 0;
            }
        } else if (Constant.ScaleMode.ScacleToFill == scaleMode) {
            size.height = i4;
            size.width = i3;
            size.x = 0;
            size.y = 0;
        }
        return size;
    }

    public static Size CalcFitSize(int i, int i2, int i3, int i4) {
        Size size = new Size();
        if (i2 > 0 && i > 0 && i4 > 0 && i3 > 0) {
            if (i3 > i || i4 > i2) {
                if ((i * 1.0d) / i2 > (i3 * 1.0d) / i4) {
                    size.height = i2;
                    size.width = (i2 * i3) / i4;
                } else {
                    size.width = i;
                    size.height = (i * i4) / i3;
                }
                size.width &= -16;
                size.height &= -16;
            } else {
                size.width = i3;
                size.height = i4;
            }
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

        public String toString() {
            return "(" + this.x + "," + this.y + "," + this.width + "," + this.height + ")";
        }
    }
}
