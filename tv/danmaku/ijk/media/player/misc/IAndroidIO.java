package tv.danmaku.ijk.media.player.misc;

import com.baidu.media.duplayer.Keep;
@Keep
/* loaded from: classes15.dex */
public interface IAndroidIO {
    int close();

    int open(String str);

    int read(byte[] bArr, int i);

    long seek(long j, int i);
}
