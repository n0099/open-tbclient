package com.vivo.push.sdk;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Handler;
import android.os.HandlerThread;
import com.vivo.push.PushClient;
import com.vivo.push.cache.ClientConfigManagerImpl;
import com.vivo.push.util.p;
/* loaded from: classes14.dex */
public class PushServiceReceiver extends BroadcastReceiver {

    /* renamed from: a  reason: collision with root package name */
    private static HandlerThread f8068a = null;
    private static Handler b = null;
    private static a c = new a();

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        if ("android.net.conn.CONNECTIVITY_CHANGE".equals(action) || "android.intent.action.ACTION_POWER_CONNECTED".equals(action) || "android.intent.action.ACTION_POWER_DISCONNECTED".equals(action)) {
            if (f8068a == null) {
                HandlerThread handlerThread = new HandlerThread("PushServiceReceiver");
                f8068a = handlerThread;
                handlerThread.start();
                b = new Handler(f8068a.getLooper());
            }
            p.d("PushServiceReceiver", context.getPackageName() + ": start PushSerevice for by " + action + "  ; handler : " + b);
            a.a(c, context, action);
            b.removeCallbacks(c);
            b.postDelayed(c, 2000L);
        }
    }

    /* loaded from: classes14.dex */
    static class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        private Context f8069a;
        private String b;

        a() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            boolean z;
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) this.f8069a.getApplicationContext().getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo != null) {
                z = activeNetworkInfo.isConnectedOrConnecting();
            } else {
                z = false;
            }
            if (!z) {
                p.d("PushServiceReceiver", this.f8069a.getPackageName() + ": 无网络  by " + this.b);
                p.a(this.f8069a, "触发静态广播:无网络(" + this.b + "," + this.f8069a.getPackageName() + ")");
                return;
            }
            p.d("PushServiceReceiver", this.f8069a.getPackageName() + ": 执行开始出发动作: " + this.b);
            p.a(this.f8069a, "触发静态广播(" + this.b + "," + this.f8069a.getPackageName() + ")");
            com.vivo.push.p.a().a(this.f8069a);
            if (!ClientConfigManagerImpl.getInstance(this.f8069a).isCancleBroadcastReceiver()) {
                PushClient.getInstance(this.f8069a).initialize();
            }
        }

        static /* synthetic */ void a(a aVar, Context context, String str) {
            aVar.f8069a = context.getApplicationContext();
            aVar.b = str;
        }
    }
}
