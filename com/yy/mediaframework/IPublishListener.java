package com.yy.mediaframework;

import com.yy.mediaframework.Constant;
import com.yy.mediaframework.api.YMFVideoEncodeFrame;
/* loaded from: classes6.dex */
public interface IPublishListener {
    void onEncodeFrameData(YMFVideoEncodeFrame yMFVideoEncodeFrame);

    void onUpdateVideoSizeChanged(long j, int i, int i2);

    void onVideoAnchorStatus(Constant.AnchorStatus anchorStatus);

    void onVideoFrameProcessTime(float f, float f2);
}
