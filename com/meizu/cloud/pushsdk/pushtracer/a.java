package com.meizu.cloud.pushsdk.pushtracer;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.meizu.cloud.pushsdk.common.util.g;
import com.meizu.cloud.pushsdk.pushtracer.d.b;
import com.meizu.cloud.pushsdk.pushtracer.d.c;
import com.meizu.cloud.pushsdk.pushtracer.emitter.BufferOption;
import com.meizu.cloud.pushsdk.pushtracer.emitter.b;
import com.meizu.cloud.pushsdk.pushtracer.emitter.d;
import com.meizu.cloud.pushsdk.pushtracer.utils.LogLevel;
/* loaded from: classes3.dex */
public class a {
    private static c a;

    public static c a(Context context, d dVar) {
        b a2 = a(context);
        if (a == null) {
            synchronized (a.class) {
                if (a == null) {
                    a = a(b(context, dVar), a2, context);
                    a(context, a);
                    a.a(a2);
                }
            }
        }
        return a;
    }

    private static c a(com.meizu.cloud.pushsdk.pushtracer.emitter.b bVar, b bVar2, Context context) {
        return new com.meizu.cloud.pushsdk.pushtracer.d.a.a(new c.a(bVar, "PushAndroidTracker", context.getPackageCodePath(), context, com.meizu.cloud.pushsdk.pushtracer.d.a.a.class).a(LogLevel.VERBOSE).a((Boolean) false).a(bVar2).a(2));
    }

    private static com.meizu.cloud.pushsdk.pushtracer.emitter.b b(Context context, d dVar) {
        return new com.meizu.cloud.pushsdk.pushtracer.emitter.a.a(new b.a(a(), context, com.meizu.cloud.pushsdk.pushtracer.emitter.a.a.class).a(dVar).a(1).a(BufferOption.Single).b(1).c(2));
    }

    private static com.meizu.cloud.pushsdk.pushtracer.d.b a(Context context) {
        return new b.a().a(context).a();
    }

    private static void a(Context context, final c cVar) {
        context.registerReceiver(new BroadcastReceiver() { // from class: com.meizu.cloud.pushsdk.pushtracer.a.1
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context2, Intent intent) {
                if (com.meizu.cloud.pushsdk.pushtracer.utils.d.a(context2)) {
                    com.meizu.cloud.pushsdk.pushtracer.utils.b.a("QuickTracker", "restart track event: %s", "online true");
                    c.this.a();
                }
            }
        }, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
    }

    private static String a() {
        if (g.b() || g.c()) {
            return "push-statics.in.meizu.com";
        }
        com.meizu.cloud.a.a.e("QuickTracker", "current statics domain is push-statics.meizu.com");
        return "push-statics.meizu.com";
    }
}
