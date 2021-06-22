package d.a.d0.a.c;

import java.io.Closeable;
import java.io.IOException;
/* loaded from: classes2.dex */
public class k {
    public static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e2) {
                g gVar = g.f43388a;
                gVar.e("SafeUtil", "error closing " + closeable.getClass().getName(), e2);
            }
        }
    }
}
