package com.thunder.livesdk.video;

import com.yy.videoplayer.VideoDecodeEventNotify;
import com.yy.videoplayer.VideoRenderNotify;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public interface IThunderVideoPlay {
    void onDecodedFrameData(long j, int i, int i2, byte[] bArr, int i3, long j2);

    void onFirstFrameDecodeNotify(long j, long j2, long j3);

    void onFirstFrameRenderNotify(long j, int i, int i2, long j2);

    void onHardwareDecodeErrorNotify(long j, long j2, int i);

    void onVideoDecodeNotify(VideoDecodeEventNotify videoDecodeEventNotify);

    void onVideoRenderNotify(ArrayList<VideoRenderNotify> arrayList);

    void onViewStateNotify(long j, int i);
}
