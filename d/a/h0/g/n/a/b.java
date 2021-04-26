package d.a.h0.g.n.a;

import d.a.h0.p.d;
import java.io.File;
/* loaded from: classes3.dex */
public class b {
    public static void a() {
        File b2 = b();
        if (b2.exists()) {
            d.f(b2);
        }
    }

    public static File b() {
        return d.a.h0.g.q.a.e("aigames_debug_game_core");
    }

    public static File c() {
        File b2 = b();
        if (!b2.exists()) {
            b2.mkdirs();
        }
        return new File(b2, "debugGameCore.zip");
    }
}
