package com.meizu.cloud.pushsdk.b;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.meizu.cloud.pushsdk.b.b.c;
import com.meizu.cloud.pushsdk.b.b.f;
import com.meizu.cloud.pushsdk.b.e.b;
import com.meizu.cloud.pushsdk.b.e.c;
import com.meizu.cloud.pushsdk.b.f.e;
import com.meizu.cloud.pushsdk.common.b.h;
/* loaded from: classes2.dex */
public class a {
    private static c a;

    public static synchronized c a(Context context, f fVar) {
        c cVar;
        synchronized (a.class) {
            b a2 = a(context);
            if (a == null) {
                a = a(b(context, fVar), a2, context);
                a(context, a);
            }
            a.a(a2);
            cVar = a;
        }
        return cVar;
    }

    private static c a(com.meizu.cloud.pushsdk.b.b.c cVar, b bVar, Context context) {
        return new com.meizu.cloud.pushsdk.b.e.a.a(new c.a(cVar, "PushAndroidTracker", context.getPackageCodePath(), context, com.meizu.cloud.pushsdk.b.e.a.a.class).a(com.meizu.cloud.pushsdk.b.f.b.VERBOSE).a((Boolean) false).a(bVar).a(2));
    }

    private static com.meizu.cloud.pushsdk.b.b.c b(Context context, f fVar) {
        return new com.meizu.cloud.pushsdk.b.b.a.a(new c.a(a(), context, com.meizu.cloud.pushsdk.b.b.a.a.class).a(com.meizu.cloud.pushsdk.platform.a.a()).a(com.meizu.cloud.pushsdk.platform.a.b()).a(fVar).a(1).b(2));
    }

    private static b a(Context context) {
        return new b.a().a(context).a();
    }

    private static void a(Context context, final com.meizu.cloud.pushsdk.b.e.c cVar) {
        context.registerReceiver(new BroadcastReceiver() { // from class: com.meizu.cloud.pushsdk.b.a.1
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context2, Intent intent) {
                if (e.a(context2)) {
                    com.meizu.cloud.pushsdk.b.f.c.a("QuickTracker", "restart track event: %s", "online true");
                    com.meizu.cloud.pushsdk.b.e.c.this.a();
                }
            }
        }, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
    }

    private static String a() {
        if (h.b() || h.c()) {
            return "push.statics.in.meizu.com";
        }
        com.meizu.cloud.a.a.e("QuickTracker", "current statics domain is push.statics.meizu.com");
        return "push.statics.meizu.com";
    }
}
