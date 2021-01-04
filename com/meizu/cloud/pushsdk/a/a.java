package com.meizu.cloud.pushsdk.a;

import android.content.Context;
import com.meizu.cloud.pushsdk.a.c;
import com.meizu.cloud.pushsdk.base.f;
import java.util.Map;
/* loaded from: classes6.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private static final String f11407a = a.class.getSimpleName();

    public static com.meizu.cloud.pushsdk.c.a.c a(Context context) {
        com.meizu.cloud.pushsdk.c.a.c cVar = new com.meizu.cloud.pushsdk.c.a.c();
        c c = c(context);
        Map<String, String> a2 = c.a();
        Map<String, String> b2 = c.b();
        Map<String, Object> c2 = c.c();
        Map<String, Object> d = c.d();
        if (a2.size() > 0) {
            cVar.a(b.f11416a, a2);
        }
        if (b2.size() > 0) {
            cVar.a(b.f, b2);
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

    private static c c(Context context) {
        return new c.a().a(context).a();
    }
}
