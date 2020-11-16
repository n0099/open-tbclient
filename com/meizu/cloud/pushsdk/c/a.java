package com.meizu.cloud.pushsdk.c;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.meizu.cloud.pushsdk.c.b.c;
import com.meizu.cloud.pushsdk.c.b.f;
import com.meizu.cloud.pushsdk.c.e.b;
import com.meizu.cloud.pushsdk.c.e.c;
import com.meizu.cloud.pushsdk.c.f.e;
import com.meizu.cloud.pushsdk.util.MzSystemUtils;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes15.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private static c f4378a;
    private static BroadcastReceiver b;
    private static AtomicBoolean c = new AtomicBoolean(false);

    private static b a(Context context) {
        return new b.a().a(context).a();
    }

    public static c a(Context context, com.meizu.cloud.pushsdk.b.c.a aVar, f fVar) {
        if (f4378a == null) {
            synchronized (a.class) {
                if (f4378a == null) {
                    f4378a = a(b(context, aVar, fVar), (b) null, context);
                }
                if (c.compareAndSet(false, true)) {
                    a(context, f4378a);
                }
            }
        }
        return f4378a;
    }

    public static c a(Context context, f fVar) {
        return a(context, (com.meizu.cloud.pushsdk.b.c.a) null, fVar);
    }

    public static c a(Context context, boolean z) {
        if (f4378a == null) {
            synchronized (a.class) {
                if (f4378a == null) {
                    f4378a = a(b(context, null, null), (b) null, context);
                }
            }
        }
        com.meizu.cloud.a.a.i("PushAndroidTracker", "can upload subject " + z);
        if (z) {
            f4378a.a(a(context));
        }
        return f4378a;
    }

    private static c a(com.meizu.cloud.pushsdk.c.b.c cVar, b bVar, Context context) {
        return new com.meizu.cloud.pushsdk.c.e.a.a(new c.a(cVar, "PushAndroidTracker", context.getPackageCodePath(), context, com.meizu.cloud.pushsdk.c.e.a.a.class).a(com.meizu.cloud.pushsdk.c.f.b.VERBOSE).a((Boolean) false).a(bVar).a(4));
    }

    private static String a() {
        if (MzSystemUtils.isInternational() || MzSystemUtils.isIndiaLocal()) {
            return "push-statics.in.meizu.com";
        }
        com.meizu.cloud.a.a.e("QuickTracker", "current statics domain is push-statics.meizu.com");
        return "push-statics.meizu.com";
    }

    private static void a(Context context, final c cVar) {
        IntentFilter intentFilter = new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE");
        BroadcastReceiver broadcastReceiver = new BroadcastReceiver() { // from class: com.meizu.cloud.pushsdk.c.a.1
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context2, Intent intent) {
                if (e.a(context2)) {
                    com.meizu.cloud.pushsdk.c.f.c.a("QuickTracker", "restart track event: %s", "online true");
                    c.this.a();
                }
            }
        };
        b = broadcastReceiver;
        context.registerReceiver(broadcastReceiver, intentFilter);
    }

    private static com.meizu.cloud.pushsdk.c.b.c b(Context context, com.meizu.cloud.pushsdk.b.c.a aVar, f fVar) {
        return new com.meizu.cloud.pushsdk.c.b.a.a(new c.a(a(), context, com.meizu.cloud.pushsdk.c.b.a.a.class).a(fVar).a(aVar).a(1).a(com.meizu.cloud.pushsdk.c.b.a.DefaultGroup).b(com.meizu.cloud.pushsdk.c.b.a.DefaultGroup.a()).c(2));
    }
}
