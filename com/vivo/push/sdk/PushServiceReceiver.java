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
/* loaded from: classes4.dex */
public class PushServiceReceiver extends BroadcastReceiver {

    /* renamed from: a  reason: collision with root package name */
    private static HandlerThread f13971a = null;

    /* renamed from: b  reason: collision with root package name */
    private static Handler f13972b = null;
    private static a c = new a();

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        if ("android.net.conn.CONNECTIVITY_CHANGE".equals(action) || "android.intent.action.ACTION_POWER_CONNECTED".equals(action) || "android.intent.action.ACTION_POWER_DISCONNECTED".equals(action)) {
            if (f13971a == null) {
                HandlerThread handlerThread = new HandlerThread("PushServiceReceiver");
                f13971a = handlerThread;
                handlerThread.start();
                f13972b = new Handler(f13971a.getLooper());
            }
            p.d("PushServiceReceiver", context.getPackageName() + ": start PushSerevice for by " + action + "  ; handler : " + f13972b);
            a.a(c, context, action);
            f13972b.removeCallbacks(c);
            f13972b.postDelayed(c, 2000L);
        }
    }

    /* loaded from: classes4.dex */
    static class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        private Context f13973a;

        /* renamed from: b  reason: collision with root package name */
        private String f13974b;

        a() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            boolean z;
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) this.f13973a.getApplicationContext().getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo != null) {
                z = activeNetworkInfo.isConnectedOrConnecting();
            } else {
                z = false;
            }
            if (!z) {
                p.d("PushServiceReceiver", this.f13973a.getPackageName() + ": 无网络  by " + this.f13974b);
                p.a(this.f13973a, "触发静态广播:无网络(" + this.f13974b + "," + this.f13973a.getPackageName() + ")");
                return;
            }
            p.d("PushServiceReceiver", this.f13973a.getPackageName() + ": 执行开始出发动作: " + this.f13974b);
            p.a(this.f13973a, "触发静态广播(" + this.f13974b + "," + this.f13973a.getPackageName() + ")");
            com.vivo.push.p.a().a(this.f13973a);
            if (!ClientConfigManagerImpl.getInstance(this.f13973a).isCancleBroadcastReceiver()) {
                PushClient.getInstance(this.f13973a).initialize();
            }
        }

        static /* synthetic */ void a(a aVar, Context context, String str) {
            aVar.f13973a = context.getApplicationContext();
            aVar.f13974b = str;
        }
    }
}
