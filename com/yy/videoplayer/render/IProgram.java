package com.yy.videoplayer.render;

import com.yy.videoplayer.decoder.VideoConstant;
/* loaded from: classes6.dex */
public interface IProgram {
    boolean checkUpdateMirrorMode(boolean z);

    void clip(int i, int i2, int i3, int i4, int i5, int i6, boolean z);

    void clip(int i, int i2, int i3, int i4, VideoConstant.ScaleMode scaleMode);

    void drawFrame();

    void enableWaterMarker(boolean z);

    void flipHorizontal();

    void flipVertical();

    int programType();

    void release();

    void rotation(int i);

    void useProgram();
}
