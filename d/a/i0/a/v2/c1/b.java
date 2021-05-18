package d.a.i0.a.v2.c1;

import androidx.annotation.Nullable;
import d.a.i0.t.d;
import java.nio.channels.Channel;
/* loaded from: classes3.dex */
public final class b {
    public static void a(@Nullable Channel channel) {
        if (channel == null || !channel.isOpen()) {
            return;
        }
        d.d(channel);
    }
}
