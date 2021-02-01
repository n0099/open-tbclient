package com.thunder.livesdk;

import com.thunder.livesdk.ThunderPublisher;
import com.thunder.livesdk.log.ThunderLog;
/* loaded from: classes4.dex */
public class ThunderDefaultMic extends ThunderAudioCapture {
    private int mSampleRate = 16000;
    private int mChannels = 2;
    private int mSampleBitDepth = 16;
    private IYYLiveDefaultMicDataCallback mMicDataCallback = null;

    /* loaded from: classes4.dex */
    public interface IYYLiveDefaultMicDataCallback {
        void onAudioDataCallback(byte[] bArr, boolean z);
    }

    public void setMicDataCallback(int i, int i2, IYYLiveDefaultMicDataCallback iYYLiveDefaultMicDataCallback) {
        ThunderLog.release(ThunderLog.kLogTagCall, "setMicDataCallback sampleRate=%d, channels=%d, callback=%s", Integer.valueOf(i), Integer.valueOf(i2), iYYLiveDefaultMicDataCallback.toString());
        this.mSampleRate = i;
        this.mChannels = i2;
        this.mMicDataCallback = iYYLiveDefaultMicDataCallback;
    }

    public IYYLiveDefaultMicDataCallback getMicDataCallback() {
        return this.mMicDataCallback;
    }

    @Override // com.thunder.livesdk.ThunderAudioCapture
    public void startCapture(ThunderPublisher.IAudioPublisher iAudioPublisher) {
    }

    @Override // com.thunder.livesdk.ThunderAudioCapture
    public void stopCapture() {
    }

    @Override // com.thunder.livesdk.ThunderAudioCapture
    public int getSampleRate() {
        return this.mSampleRate;
    }

    @Override // com.thunder.livesdk.ThunderAudioCapture
    public int getChannels() {
        return this.mChannels;
    }

    @Override // com.thunder.livesdk.ThunderAudioCapture
    public int getBitDepth() {
        return this.mSampleBitDepth;
    }
}
