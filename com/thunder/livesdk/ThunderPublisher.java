package com.thunder.livesdk;

import com.thunder.livesdk.ThunderConstant;
import com.thunder.livesdk.video.ThunderVideoLogCallback;
import com.yy.mediaframework.utils.YMFLog;
/* loaded from: classes6.dex */
public class ThunderPublisher {
    private ThunderDefaultMic mDefaultMic = new ThunderDefaultMic();
    private ThunderDefaultCamera mDefaultCamera = new ThunderDefaultCamera();

    /* loaded from: classes6.dex */
    public interface IAudioPublisher {
        void pushAudioData(byte[] bArr, long j);
    }

    /* loaded from: classes6.dex */
    public interface IVideoPublisher {
        void pushVideoData(byte[] bArr, int i, int i2, int i3, int i4, long j);

        void pushVideoData(byte[] bArr, ThunderConstant.ThunderVideoEncodeType thunderVideoEncodeType, long j, long j2);

        void pushVideoFrame(ThunderExternalVideoFrame thunderExternalVideoFrame);

        void pushVideoTexture(int i, int i2, int i3, int i4, int i5, long j, float[] fArr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ThunderPublisher() {
        YMFLog.registerLogger(ThunderVideoLogCallback.sharedInstance());
    }

    public ThunderDefaultMic getDefaluteMic() {
        return this.mDefaultMic;
    }

    public ThunderDefaultCamera getDefaluteCamera() {
        return this.mDefaultCamera;
    }
}
