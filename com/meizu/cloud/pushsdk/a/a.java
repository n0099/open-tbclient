package com.meizu.cloud.pushsdk.a;

import android.content.Context;
import com.meizu.cloud.pushsdk.a.c;
import com.meizu.cloud.pushsdk.base.f;
import java.util.Map;
/* loaded from: classes7.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static final String f40026a = "a";

    public static com.meizu.cloud.pushsdk.c.a.c a(Context context) {
        com.meizu.cloud.pushsdk.c.a.c cVar = new com.meizu.cloud.pushsdk.c.a.c();
        c c2 = c(context);
        Map<String, String> a2 = c2.a();
        Map<String, String> b2 = c2.b();
        Map<String, Object> c3 = c2.c();
        Map<String, Object> d2 = c2.d();
        if (a2.size() > 0) {
            cVar.a(b.f40044a, a2);
        }
        if (b2.size() > 0) {
            cVar.a(b.f40049f, b2);
        }
        if (c3.size() > 0) {
            cVar.a(b.o, c3);
        }
        if (d2.size() > 0) {
            cVar.a(b.v, d2);
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
