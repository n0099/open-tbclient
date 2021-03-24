package d.b.g0.a.i2.s0;

import androidx.annotation.Nullable;
import d.b.g0.p.d;
import java.nio.channels.Channel;
/* loaded from: classes3.dex */
public final class b {
    public static void a(@Nullable Channel channel) {
        if (channel == null || !channel.isOpen()) {
            return;
        }
        d.a(channel);
    }
}
