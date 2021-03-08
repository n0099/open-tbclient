package com.thunder.livesdk;

import com.thunder.livesdk.ThunderPublisher;
import com.thunder.livesdk.log.ThunderLog;
/* loaded from: classes6.dex */
public class ExternalAudioSource extends ThunderAudioCapture {
    private int mChannels;
    private ThunderPublisher.IAudioPublisher mPublisher = null;
    private int mSampleBitDepth;
    private int mSampleRate;

    public ExternalAudioSource(int i, int i2) {
        this.mSampleRate = 0;
        this.mChannels = 0;
        this.mSampleBitDepth = 0;
        this.mSampleRate = i;
        this.mChannels = i2;
        this.mSampleBitDepth = 16;
    }

    public void pushCustomAudioFrame(byte[] bArr, long j) {
        if (this.mPublisher != null) {
            this.mPublisher.pushAudioData(bArr, j);
        }
    }

    @Override // com.thunder.livesdk.ThunderAudioCapture
    public void startCapture(ThunderPublisher.IAudioPublisher iAudioPublisher) {
        this.mPublisher = iAudioPublisher;
    }

    @Override // com.thunder.livesdk.ThunderAudioCapture
    public void stopCapture() {
        if (ThunderLog.isInfoValid()) {
            ThunderLog.info(ThunderLog.kLogTagRtcEngine, "stop push external audio.");
        }
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
