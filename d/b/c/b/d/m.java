package d.b.c.b.d;

import android.content.Context;
import java.io.File;
/* loaded from: classes5.dex */
public class m {
    public static n a(Context context) {
        return b(context, null);
    }

    public static n b(Context context, d.b.c.b.f.a aVar) {
        if (aVar == null) {
            aVar = new l();
        }
        return c(context, new c(aVar));
    }

    public static n c(Context context, d.b.c.b.f.c cVar) {
        n nVar = new n(new h(new File(d.b.c.b.a.h(context), "reqQueue")), cVar);
        nVar.b();
        return nVar;
    }
}
