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
/* loaded from: classes2.dex */
public class a {
    public static c a;

    /* renamed from: b  reason: collision with root package name */
    public static BroadcastReceiver f60388b;

    /* renamed from: c  reason: collision with root package name */
    public static AtomicBoolean f60389c = new AtomicBoolean(false);

    public static b a(Context context) {
        return new b.a().a(context).a();
    }

    public static c a(Context context, com.meizu.cloud.pushsdk.b.c.a aVar, f fVar) {
        if (a == null) {
            synchronized (a.class) {
                if (a == null) {
                    a = a(b(context, aVar, fVar), (b) null, context);
                }
                if (f60389c.compareAndSet(false, true)) {
                    a(context, a);
                }
            }
        }
        return a;
    }

    public static c a(Context context, f fVar) {
        return a(context, (com.meizu.cloud.pushsdk.b.c.a) null, fVar);
    }

    public static c a(Context context, boolean z) {
        if (a == null) {
            synchronized (a.class) {
                if (a == null) {
                    a = a(b(context, null, null), (b) null, context);
                }
            }
        }
        c.k.a.a.a.d("PushAndroidTracker", "can upload subject " + z);
        if (z) {
            a.a(a(context));
        }
        return a;
    }

    public static c a(com.meizu.cloud.pushsdk.c.b.c cVar, b bVar, Context context) {
        return new com.meizu.cloud.pushsdk.c.e.a.a(new c.a(cVar, "PushAndroidTracker", context.getPackageCodePath(), context, com.meizu.cloud.pushsdk.c.e.a.a.class).a(com.meizu.cloud.pushsdk.c.f.b.VERBOSE).a(Boolean.FALSE).a(bVar).a(4));
    }

    public static String a() {
        if (MzSystemUtils.isInternational() || MzSystemUtils.isIndiaLocal()) {
            return "push-statics.in.meizu.com";
        }
        c.k.a.a.a.b("QuickTracker", "current statics domain is push-statics.meizu.com");
        return "push-statics.meizu.com";
    }

    public static void a(Context context, final c cVar) {
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
        f60388b = broadcastReceiver;
        context.registerReceiver(broadcastReceiver, intentFilter);
    }

    public static com.meizu.cloud.pushsdk.c.b.c b(Context context, com.meizu.cloud.pushsdk.b.c.a aVar, f fVar) {
        return new com.meizu.cloud.pushsdk.c.b.a.a(new c.a(a(), context, com.meizu.cloud.pushsdk.c.b.a.a.class).a(fVar).a(aVar).a(1).a(com.meizu.cloud.pushsdk.c.b.a.DefaultGroup).b(com.meizu.cloud.pushsdk.c.b.a.DefaultGroup.a()).c(2));
    }
}
