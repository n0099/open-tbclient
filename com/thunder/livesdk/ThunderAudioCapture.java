package com.thunder.livesdk;

import com.thunder.livesdk.ThunderPublisher;
/* loaded from: classes4.dex */
public abstract class ThunderAudioCapture {
    public abstract int getBitDepth();

    public abstract int getChannels();

    public abstract int getSampleRate();

    public abstract void startCapture(ThunderPublisher.IAudioPublisher iAudioPublisher);

    public abstract void stopCapture();
}
