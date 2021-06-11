package com.kwai.video.player.misc;
/* loaded from: classes7.dex */
public interface IMediaDataSource {
    void close();

    long getSize();

    int readAt(long j, byte[] bArr, int i2, int i3);
}
