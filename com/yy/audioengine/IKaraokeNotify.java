package com.yy.audioengine;
/* loaded from: classes4.dex */
public interface IKaraokeNotify {
    void onKaraokeCurrentPlayVolume(long j, long j2, long j3);

    void onKaraokeCurrentRecordVolume(long j, long j2);

    void onKaraokeFirstPlayData();

    void onKaraokeInitError();

    void onKaraokePitch(byte b2, long j, long j2, long j3);

    void onKaraokePlayEnd();

    void onKaraokeScore(byte b2, long j);
}
