package com.thunder.livesdk.video;

import com.yy.mediaframework.IPublishListener;
import com.yy.mediaframework.ITextureListener;
import com.yy.videoplayer.VideoRenderNotify;
import java.util.ArrayList;
/* loaded from: classes6.dex */
public interface IThunderVideoEngine extends IPublishListener, ITextureListener {
    void onDecodedFrameData(long j, int i, int i2, byte[] bArr, int i3, long j2);

    void onFirstFrameRenderNotify(long j, long j2, long j3, long j4, int i);

    void onHardwareDecodeErrorNotify(long j, long j2, int i);

    void onVideoRenderNotify(ArrayList<VideoRenderNotify> arrayList);
}
