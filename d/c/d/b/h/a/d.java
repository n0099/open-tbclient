package d.c.d.b.h.a;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
/* loaded from: classes5.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public int f66782a;

    /* loaded from: classes5.dex */
    public class b extends BroadcastReceiver {
        public b() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if ("android.intent.action.BATTERY_CHANGED".equals(intent.getAction())) {
                d.this.f66782a = (int) ((intent.getIntExtra("level", 0) * 100.0f) / intent.getIntExtra("scale", 100));
            }
        }
    }

    public d(Context context) {
        try {
            c(context);
        } catch (Throwable unused) {
        }
    }

    public int a() {
        return this.f66782a;
    }

    public final void c(Context context) {
        context.registerReceiver(new b(), new IntentFilter("android.intent.action.BATTERY_CHANGED"));
    }
}
