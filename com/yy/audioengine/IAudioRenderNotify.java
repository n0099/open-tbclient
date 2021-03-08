package com.yy.audioengine;
/* loaded from: classes6.dex */
public interface IAudioRenderNotify {
    void onAudioVolumeData(int i);

    IAudioRenderInfo onRenderAudioData(int i, int i2, int i3);

    IAudioRenderFormatInfo onRenderAudioFormatChange(int i, int i2);
}
