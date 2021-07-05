package tv.danmaku.ijk.media.player.misc;

import com.baidu.media.duplayer.Keep;
@Keep
/* loaded from: classes2.dex */
public interface IAndroidIO {
    int close();

    int open(String str);

    int read(byte[] bArr, int i2);

    long seek(long j, int i2);
}
