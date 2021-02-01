package tv.danmaku.ijk.media.player.misc;

import com.baidu.media.duplayer.Keep;
@Keep
/* loaded from: classes5.dex */
public interface IMediaDataSource {
    void close();

    long getSize();

    int readAt(long j, byte[] bArr, int i, int i2);
}
