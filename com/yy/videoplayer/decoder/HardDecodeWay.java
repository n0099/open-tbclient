package com.yy.videoplayer.decoder;

import android.graphics.Bitmap;
import com.yy.videoplayer.IVideoInfoCallback;
import com.yy.videoplayer.decoder.VideoConstant;
import com.yy.videoplayer.decoder.VideoDecoderCenterExt;
/* loaded from: classes6.dex */
public interface HardDecodeWay extends VideoSurfaceListener {
    Bitmap GetScreenShot();

    boolean IsDecoderNeedReconfig();

    void OnStreamEnd();

    void OnVideoConfig(byte[] bArr, int i, int i2, String str);

    long OnVideoDataArrived(byte[] bArr, long j, VideoConstant.ExtraData extraData);

    void Quit();

    void SetPlayNotify(PlayNotify playNotify);

    void SetVideoIds(long j, long j2);

    void Start();

    VideoDecoderCenterExt.HardDecoderStaffVersion getHardDecodeType();

    long getUserGroupId();

    void onCreateRenderAhead(int i, int i2, String str);

    void setVideoInfoCallback(IVideoInfoCallback iVideoInfoCallback);

    void setVrStream(boolean z);
}
