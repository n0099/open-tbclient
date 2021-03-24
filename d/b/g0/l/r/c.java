package d.b.g0.l.r;

import androidx.annotation.Nullable;
import java.io.Closeable;
/* loaded from: classes3.dex */
public class c {
    public static void a(@Nullable Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Exception e2) {
                if (d.b.g0.l.f.f48888a) {
                    e2.printStackTrace();
                }
            }
        }
    }
}
