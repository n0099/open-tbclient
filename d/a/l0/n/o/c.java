package d.a.l0.n.o;

import androidx.annotation.Nullable;
import java.io.Closeable;
/* loaded from: classes3.dex */
public class c {
    public static void a(@Nullable Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Exception e2) {
                if (d.a.l0.n.c.f47984a) {
                    e2.printStackTrace();
                }
            }
        }
    }
}
