package tv.danmaku.ijk.media.player.misc;

import com.baidu.media.duplayer.Keep;
@Keep
/* loaded from: classes2.dex */
public interface IMediaDataSource {
    void close();

    long getSize();

    int readAt(long j2, byte[] bArr, int i2, int i3);
}
