package com.vivo.push.sdk;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Handler;
import android.os.HandlerThread;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.vivo.push.PushClient;
import com.vivo.push.cache.ClientConfigManagerImpl;
import com.vivo.push.util.p;
/* loaded from: classes7.dex */
public class PushServiceReceiver extends BroadcastReceiver {

    /* renamed from: a  reason: collision with root package name */
    public static HandlerThread f39512a;

    /* renamed from: b  reason: collision with root package name */
    public static Handler f39513b;

    /* renamed from: c  reason: collision with root package name */
    public static a f39514c = new a();

    /* loaded from: classes7.dex */
    public static class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public Context f39515a;

        /* renamed from: b  reason: collision with root package name */
        public String f39516b;

        public static /* synthetic */ void a(a aVar, Context context, String str) {
            aVar.f39515a = context.getApplicationContext();
            aVar.f39516b = str;
        }

        @Override // java.lang.Runnable
        public final void run() {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) this.f39515a.getApplicationContext().getSystemService("connectivity")).getActiveNetworkInfo();
            if (!(activeNetworkInfo != null ? activeNetworkInfo.isConnectedOrConnecting() : false)) {
                p.d("PushServiceReceiver", this.f39515a.getPackageName() + ": 无网络  by " + this.f39516b);
                Context context = this.f39515a;
                p.a(context, "触发静态广播:无网络(" + this.f39516b + "," + this.f39515a.getPackageName() + SmallTailInfo.EMOTION_SUFFIX);
                return;
            }
            p.d("PushServiceReceiver", this.f39515a.getPackageName() + ": 执行开始出发动作: " + this.f39516b);
            Context context2 = this.f39515a;
            p.a(context2, "触发静态广播(" + this.f39516b + "," + this.f39515a.getPackageName() + SmallTailInfo.EMOTION_SUFFIX);
            com.vivo.push.p.a().a(this.f39515a);
            if (ClientConfigManagerImpl.getInstance(this.f39515a).isCancleBroadcastReceiver()) {
                return;
            }
            PushClient.getInstance(this.f39515a).initialize();
        }
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        if ("android.net.conn.CONNECTIVITY_CHANGE".equals(action) || "android.intent.action.ACTION_POWER_CONNECTED".equals(action) || "android.intent.action.ACTION_POWER_DISCONNECTED".equals(action)) {
            if (f39512a == null) {
                HandlerThread handlerThread = new HandlerThread("PushServiceReceiver");
                f39512a = handlerThread;
                handlerThread.start();
                f39513b = new Handler(f39512a.getLooper());
            }
            p.d("PushServiceReceiver", context.getPackageName() + ": start PushSerevice for by " + action + "  ; handler : " + f39513b);
            a.a(f39514c, context, action);
            f39513b.removeCallbacks(f39514c);
            f39513b.postDelayed(f39514c, 2000L);
        }
    }
}
