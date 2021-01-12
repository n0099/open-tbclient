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
    private static HandlerThread f13671a = null;

    /* renamed from: b  reason: collision with root package name */
    private static Handler f13672b = null;
    private static a c = new a();

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        if ("android.net.conn.CONNECTIVITY_CHANGE".equals(action) || "android.intent.action.ACTION_POWER_CONNECTED".equals(action) || "android.intent.action.ACTION_POWER_DISCONNECTED".equals(action)) {
            if (f13671a == null) {
                HandlerThread handlerThread = new HandlerThread("PushServiceReceiver");
                f13671a = handlerThread;
                handlerThread.start();
                f13672b = new Handler(f13671a.getLooper());
            }
            p.d("PushServiceReceiver", context.getPackageName() + ": start PushSerevice for by " + action + "  ; handler : " + f13672b);
            a.a(c, context, action);
            f13672b.removeCallbacks(c);
            f13672b.postDelayed(c, 2000L);
        }
    }

    /* loaded from: classes3.dex */
    static class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        private Context f13673a;

        /* renamed from: b  reason: collision with root package name */
        private String f13674b;

        a() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            boolean z;
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) this.f13673a.getApplicationContext().getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo != null) {
                z = activeNetworkInfo.isConnectedOrConnecting();
            } else {
                z = false;
            }
            if (!z) {
                p.d("PushServiceReceiver", this.f13673a.getPackageName() + ": 无网络  by " + this.f13674b);
                p.a(this.f13673a, "触发静态广播:无网络(" + this.f13674b + "," + this.f13673a.getPackageName() + ")");
                return;
            }
            p.d("PushServiceReceiver", this.f13673a.getPackageName() + ": 执行开始出发动作: " + this.f13674b);
            p.a(this.f13673a, "触发静态广播(" + this.f13674b + "," + this.f13673a.getPackageName() + ")");
            com.vivo.push.p.a().a(this.f13673a);
            if (!ClientConfigManagerImpl.getInstance(this.f13673a).isCancleBroadcastReceiver()) {
                PushClient.getInstance(this.f13673a).initialize();
            }
        }

        static /* synthetic */ void a(a aVar, Context context, String str) {
            aVar.f13673a = context.getApplicationContext();
            aVar.f13674b = str;
        }
    }
}
