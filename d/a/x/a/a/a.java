package d.a.x.a.a;

import com.baidu.mario.audio.AudioParams;
import java.nio.ByteBuffer;
/* loaded from: classes8.dex */
public interface a {
    void a(boolean z, AudioParams audioParams);

    void onAudioFrameAvailable(ByteBuffer byteBuffer, int i2, long j);

    void onAudioStop(boolean z);
}
