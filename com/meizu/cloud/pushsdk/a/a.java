package com.meizu.cloud.pushsdk.a;

import android.content.Context;
import com.meizu.cloud.pushsdk.a.c;
import com.meizu.cloud.pushsdk.base.f;
import java.util.Map;
/* loaded from: classes8.dex */
public class a {
    public static final String a = "a";

    public static com.meizu.cloud.pushsdk.c.a.c a(Context context) {
        com.meizu.cloud.pushsdk.c.a.c cVar = new com.meizu.cloud.pushsdk.c.a.c();
        c c = c(context);
        Map a2 = c.a();
        Map b = c.b();
        Map c2 = c.c();
        Map d = c.d();
        if (a2.size() > 0) {
            cVar.a(b.a, a2);
        }
        if (b.size() > 0) {
            cVar.a(b.f, b);
        }
        if (c2.size() > 0) {
            cVar.a(b.o, c2);
        }
        if (d.size() > 0) {
            cVar.a(b.v, d);
        }
        return cVar;
    }

    public static void b(final Context context) {
        f.a().execute(new Runnable() { // from class: com.meizu.cloud.pushsdk.a.a.1
            @Override // java.lang.Runnable
            public void run() {
                com.meizu.cloud.pushsdk.a.a.b.a(context).a("POST", null, a.a(context).toString());
            }
        });
    }

    public static c c(Context context) {
        return new c.a().a(context).a();
    }
}
