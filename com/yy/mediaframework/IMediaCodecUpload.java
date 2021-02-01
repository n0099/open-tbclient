package com.yy.mediaframework;

import com.yy.mediaframework.ExternalInterface;
import com.yy.mediaframework.background.Background;
import com.yy.mediaframework.base.VideoEncoderConfig;
import com.yy.mediaframework.inteligence.dynamictexture.IDynamicTexture;
import com.yy.mediaframework.model.DecodeVideoConfig;
import com.yy.mediaframework.model.DecodeVideoSample;
import com.yy.mediaframework.model.ExternalDecodeInfo;
import com.yy.mediaframework.model.ExternalYYMediaSample;
import com.yy.mediaframework.screenshot.ScreenShotCallback;
import com.yy.mediaframework.watermark.WaterMark;
/* loaded from: classes4.dex */
public interface IMediaCodecUpload {
    void onExternalVideoEnd();

    void onPeripheralsVideoConfigReceived(DecodeVideoConfig decodeVideoConfig);

    void onPeripheralsVideoDataReceived(DecodeVideoSample decodeVideoSample);

    void onPeripheralsVideoEnd();

    void pushEncodeExternalData(ExternalYYMediaSample externalYYMediaSample);

    void pushExternalVideoDecodeInfo(ExternalDecodeInfo externalDecodeInfo);

    void setBackground(Background background);

    void setDynamicTexture(IDynamicTexture iDynamicTexture);

    void setEncoderConfig(VideoEncoderConfig videoEncoderConfig);

    void setEncoderListener(IEncoderListener iEncoderListener);

    void setExternalDecodeInterface(ExternalInterface.IExternalDecode iExternalDecode);

    void setExternalVideoInterface(ExternalInterface.IExternalCameraData iExternalCameraData);

    void setGLManagerRunnable(Runnable runnable);

    void setNetworkBitrateSuggest(int i);

    void setVideoRenderPosition(VideoRenderPosition videoRenderPosition);

    void setWaterMark(WaterMark waterMark);

    void startEncoder();

    void stopEncoder();

    void takeScreenShot(ScreenShotCallback screenShotCallback);
}
