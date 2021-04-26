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
/* loaded from: classes6.dex */
public class PushServiceReceiver extends BroadcastReceiver {

    /* renamed from: a  reason: collision with root package name */
    public static HandlerThread f37500a;

    /* renamed from: b  reason: collision with root package name */
    public static Handler f37501b;

    /* renamed from: c  reason: collision with root package name */
    public static a f37502c = new a();

    /* loaded from: classes6.dex */
    public static class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public Context f37503a;

        /* renamed from: b  reason: collision with root package name */
        public String f37504b;

        public static /* synthetic */ void a(a aVar, Context context, String str) {
            aVar.f37503a = context.getApplicationContext();
            aVar.f37504b = str;
        }

        @Override // java.lang.Runnable
        public final void run() {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) this.f37503a.getApplicationContext().getSystemService("connectivity")).getActiveNetworkInfo();
            if (!(activeNetworkInfo != null ? activeNetworkInfo.isConnectedOrConnecting() : false)) {
                p.d("PushServiceReceiver", this.f37503a.getPackageName() + ": 无网络  by " + this.f37504b);
                Context context = this.f37503a;
                p.a(context, "触发静态广播:无网络(" + this.f37504b + "," + this.f37503a.getPackageName() + SmallTailInfo.EMOTION_SUFFIX);
                return;
            }
            p.d("PushServiceReceiver", this.f37503a.getPackageName() + ": 执行开始出发动作: " + this.f37504b);
            Context context2 = this.f37503a;
            p.a(context2, "触发静态广播(" + this.f37504b + "," + this.f37503a.getPackageName() + SmallTailInfo.EMOTION_SUFFIX);
            com.vivo.push.p.a().a(this.f37503a);
            if (ClientConfigManagerImpl.getInstance(this.f37503a).isCancleBroadcastReceiver()) {
                return;
            }
            PushClient.getInstance(this.f37503a).initialize();
        }
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        if ("android.net.conn.CONNECTIVITY_CHANGE".equals(action) || "android.intent.action.ACTION_POWER_CONNECTED".equals(action) || "android.intent.action.ACTION_POWER_DISCONNECTED".equals(action)) {
            if (f37500a == null) {
                HandlerThread handlerThread = new HandlerThread("PushServiceReceiver");
                f37500a = handlerThread;
                handlerThread.start();
                f37501b = new Handler(f37500a.getLooper());
            }
            p.d("PushServiceReceiver", context.getPackageName() + ": start PushSerevice for by " + action + "  ; handler : " + f37501b);
            a.a(f37502c, context, action);
            f37501b.removeCallbacks(f37502c);
            f37501b.postDelayed(f37502c, 2000L);
        }
    }
}
