package com.kwai.video.player.misc;
/* loaded from: classes4.dex */
public interface IMediaDataSource {
    void close();

    long getSize();

    int readAt(long j, byte[] bArr, int i, int i2);
}
