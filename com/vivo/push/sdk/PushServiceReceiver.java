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
/* loaded from: classes3.dex */
public class PushServiceReceiver extends BroadcastReceiver {

    /* renamed from: a  reason: collision with root package name */
    private static HandlerThread f13970a = null;

    /* renamed from: b  reason: collision with root package name */
    private static Handler f13971b = null;
    private static a c = new a();

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        if ("android.net.conn.CONNECTIVITY_CHANGE".equals(action) || "android.intent.action.ACTION_POWER_CONNECTED".equals(action) || "android.intent.action.ACTION_POWER_DISCONNECTED".equals(action)) {
            if (f13970a == null) {
                HandlerThread handlerThread = new HandlerThread("PushServiceReceiver");
                f13970a = handlerThread;
                handlerThread.start();
                f13971b = new Handler(f13970a.getLooper());
            }
            p.d("PushServiceReceiver", context.getPackageName() + ": start PushSerevice for by " + action + "  ; handler : " + f13971b);
            a.a(c, context, action);
            f13971b.removeCallbacks(c);
            f13971b.postDelayed(c, 2000L);
        }
    }

    /* loaded from: classes3.dex */
    static class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        private Context f13972a;

        /* renamed from: b  reason: collision with root package name */
        private String f13973b;

        a() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            boolean z;
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) this.f13972a.getApplicationContext().getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo != null) {
                z = activeNetworkInfo.isConnectedOrConnecting();
            } else {
                z = false;
            }
            if (!z) {
                p.d("PushServiceReceiver", this.f13972a.getPackageName() + ": 无网络  by " + this.f13973b);
                p.a(this.f13972a, "触发静态广播:无网络(" + this.f13973b + "," + this.f13972a.getPackageName() + ")");
                return;
            }
            p.d("PushServiceReceiver", this.f13972a.getPackageName() + ": 执行开始出发动作: " + this.f13973b);
            p.a(this.f13972a, "触发静态广播(" + this.f13973b + "," + this.f13972a.getPackageName() + ")");
            com.vivo.push.p.a().a(this.f13972a);
            if (!ClientConfigManagerImpl.getInstance(this.f13972a).isCancleBroadcastReceiver()) {
                PushClient.getInstance(this.f13972a).initialize();
            }
        }

        static /* synthetic */ void a(a aVar, Context context, String str) {
            aVar.f13972a = context.getApplicationContext();
            aVar.f13973b = str;
        }
    }
}
