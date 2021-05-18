package d.a.i0.n.o;

import androidx.annotation.Nullable;
import java.io.Closeable;
/* loaded from: classes3.dex */
public class c {
    public static void a(@Nullable Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Exception e2) {
                if (d.a.i0.n.c.f47808a) {
                    e2.printStackTrace();
                }
            }
        }
    }
}
