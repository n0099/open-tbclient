package com.yy.audioengine;
/* loaded from: classes6.dex */
public interface IKaraokeNotify {
    void onKaraokeCurrentPlayVolume(long j, long j2, long j3);

    void onKaraokeCurrentRecordVolume(long j, long j2);

    void onKaraokeFirstPlayData();

    void onKaraokeInitError();

    void onKaraokePitch(byte b, long j, long j2, long j3);

    void onKaraokePlayEnd();

    void onKaraokeScore(byte b, long j);
}
