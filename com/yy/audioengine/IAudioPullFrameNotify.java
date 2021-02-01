package com.yy.audioengine;
/* loaded from: classes4.dex */
public interface IAudioPullFrameNotify {
    IAudioPullFrameInfo onPullAudioFrame(long j, boolean z, boolean z2, boolean z3, boolean z4, double d, double d2, double d3);

    boolean onPullAudioVolume(int i, int i2);
}
