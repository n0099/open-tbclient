package com.yy.mediaframework;

import android.graphics.Bitmap;
import com.yy.mediaframework.base.VideoEncoderConfig;
import com.yy.mediaframework.base.YMFLowStreamEncoderConfig;
import com.yy.mediaframework.inteligence.common.ResolutionModifyConfig;
import com.yy.mediaframework.inteligence.dynamictexture.IDynamicTexture;
import com.yy.mediaframework.screenshot.ScreenShotCallback;
import java.util.List;
/* loaded from: classes4.dex */
public interface ILiveSession {
    void adjustEncoderBitrate(int i);

    boolean isHardwareEncoderAvailable();

    void requestIFrame();

    void setDynamicTexture(IDynamicTexture iDynamicTexture);

    void setEncoderConfig(VideoEncoderConfig videoEncoderConfig);

    void setEncoderListener(IEncoderListener iEncoderListener);

    void setHardwareEncoderAvailable(boolean z);

    void setLowDelayMode(boolean z);

    void setLowStreamEncoderConfigs(List<YMFLowStreamEncoderConfig> list, boolean z);

    void setNetworkBitrateSuggest(int i);

    void setResolutionModifyConfigs(List<ResolutionModifyConfig> list, int i);

    void setWaterMark(Bitmap bitmap, int i, int i2);

    void startEncoder();

    void stopAndRelease();

    void stopEncoder();

    void takeScreenShot(ScreenShotCallback screenShotCallback);
}
