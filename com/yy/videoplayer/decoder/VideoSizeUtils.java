package com.yy.videoplayer.decoder;

import com.yy.videoplayer.Constant;
import com.yy.videoplayer.decoder.VideoConstant;
import com.yy.videoplayer.utils.YMFLog;
/* loaded from: classes6.dex */
public class VideoSizeUtils {
    public static Size CalcFitSize(int i, int i2, int i3, int i4, VideoConstant.ScaleMode scaleMode) {
        YMFLog.info(null, Constant.MEDIACODE_PLAYVIEW, "CalcFitSize video frame size:" + i + "*" + i2 + ", view:" + i3 + "*" + i4 + " mode:" + scaleMode);
        Size size = new Size(i, i2);
        if (VideoConstant.ScaleMode.AspectFit == scaleMode) {
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
        } else if (VideoConstant.ScaleMode.ClipToBounds == scaleMode) {
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
        } else if (VideoConstant.ScaleMode.Original == scaleMode) {
            if (i <= i3 && i2 <= i4) {
                size.width = i;
                size.height = i2;
                size.x = (i3 - size.width) / 2;
                size.y = (i4 - size.height) / 2;
            } else if (i4 * i < i3 * i2) {
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
        } else if (VideoConstant.ScaleMode.FillParent == scaleMode) {
            size.height = i4;
            size.width = i3;
            size.x = 0;
            size.y = 0;
        }
        YMFLog.info(null, Constant.MEDIACODE_PLAYVIEW, "CalcFitSize after (" + size.x + "," + size.y + ", " + size.width + "," + size.height + " )");
        return size;
    }

    public static Size calcVideoSize(int i, int i2, int i3, int i4) {
        Size size = new Size(0, 0);
        size.x = i;
        size.y = i2;
        size.width = i3;
        size.height = i4;
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
