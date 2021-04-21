package d.b.h0.l.r;

import androidx.annotation.Nullable;
import java.io.Closeable;
/* loaded from: classes3.dex */
public class c {
    public static void a(@Nullable Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Exception e2) {
                if (d.b.h0.l.f.f49610a) {
                    e2.printStackTrace();
                }
            }
        }
    }
}
