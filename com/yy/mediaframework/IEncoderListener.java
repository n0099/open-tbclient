package com.yy.mediaframework;

import com.yy.mediaframework.api.YMFEncoderStatisticInfo;
import com.yy.mediaframework.api.YMFVideoEncodeFrame;
/* loaded from: classes6.dex */
public interface IEncoderListener {
    void onEncodeEncParam(String str);

    void onEncodeFirstFrame();

    void onEncodeFrameData(YMFVideoEncodeFrame yMFVideoEncodeFrame);

    void onEncodeResolution(int i, int i2, int i3);

    void onEncodeStat(YMFEncoderStatisticInfo yMFEncoderStatisticInfo);

    void onEncoderSwitch();

    void onHardEncoderError();

    void onWaterMarkSizeChange(int i, int i2);
}
