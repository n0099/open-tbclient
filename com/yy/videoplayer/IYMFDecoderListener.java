package com.yy.videoplayer;

import com.yy.videoplayer.render.YMFImageBuffer;
/* loaded from: classes6.dex */
public interface IYMFDecoderListener {
    void onDecodeStreamEnd(long j, YMFImageBuffer yMFImageBuffer);

    void onDecodeStreamStart(long j, YMFImageBuffer yMFImageBuffer);

    void onDecodedFrameAvailable(long j, YMFImageBuffer yMFImageBuffer);
}
