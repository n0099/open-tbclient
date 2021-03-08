package com.yy.videoplayer.render;

import android.graphics.Bitmap;
import com.yy.videoplayer.decoder.VideoConstant;
/* loaded from: classes6.dex */
public interface IRender {
    boolean checkUpdateMirrorMode(boolean z);

    void clip(int i, int i2, int i3, int i4, int i5, int i6, boolean z);

    void clip(int i, int i2, int i3, int i4, VideoConstant.ScaleMode scaleMode);

    void flipHorizontal();

    void flipVertical();

    int prepareInputBackgroundTexture(Bitmap bitmap, int i, int i2);

    boolean prepareInputImageData(YMFImageBuffer yMFImageBuffer);

    boolean prepareInputTexture(YMFTexture yMFTexture);

    boolean prepareOutputTexture(YMFTexture yMFTexture);

    void prepareWaterTexture(YMFTexture yMFTexture);

    void release();

    void render();

    void rotate(int i);
}
