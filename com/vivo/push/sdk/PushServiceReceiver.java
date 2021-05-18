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
    public static HandlerThread f36745a;

    /* renamed from: b  reason: collision with root package name */
    public static Handler f36746b;

    /* renamed from: c  reason: collision with root package name */
    public static a f36747c = new a();

    /* loaded from: classes7.dex */
    public static class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public Context f36748a;

        /* renamed from: b  reason: collision with root package name */
        public String f36749b;

        public static /* synthetic */ void a(a aVar, Context context, String str) {
            aVar.f36748a = context.getApplicationContext();
            aVar.f36749b = str;
        }

        @Override // java.lang.Runnable
        public final void run() {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) this.f36748a.getApplicationContext().getSystemService("connectivity")).getActiveNetworkInfo();
            if (!(activeNetworkInfo != null ? activeNetworkInfo.isConnectedOrConnecting() : false)) {
                p.d("PushServiceReceiver", this.f36748a.getPackageName() + ": 无网络  by " + this.f36749b);
                Context context = this.f36748a;
                p.a(context, "触发静态广播:无网络(" + this.f36749b + "," + this.f36748a.getPackageName() + SmallTailInfo.EMOTION_SUFFIX);
                return;
            }
            p.d("PushServiceReceiver", this.f36748a.getPackageName() + ": 执行开始出发动作: " + this.f36749b);
            Context context2 = this.f36748a;
            p.a(context2, "触发静态广播(" + this.f36749b + "," + this.f36748a.getPackageName() + SmallTailInfo.EMOTION_SUFFIX);
            com.vivo.push.p.a().a(this.f36748a);
            if (ClientConfigManagerImpl.getInstance(this.f36748a).isCancleBroadcastReceiver()) {
                return;
            }
            PushClient.getInstance(this.f36748a).initialize();
        }
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        if ("android.net.conn.CONNECTIVITY_CHANGE".equals(action) || "android.intent.action.ACTION_POWER_CONNECTED".equals(action) || "android.intent.action.ACTION_POWER_DISCONNECTED".equals(action)) {
            if (f36745a == null) {
                HandlerThread handlerThread = new HandlerThread("PushServiceReceiver");
                f36745a = handlerThread;
                handlerThread.start();
                f36746b = new Handler(f36745a.getLooper());
            }
            p.d("PushServiceReceiver", context.getPackageName() + ": start PushSerevice for by " + action + "  ; handler : " + f36746b);
            a.a(f36747c, context, action);
            f36746b.removeCallbacks(f36747c);
            f36746b.postDelayed(f36747c, 2000L);
        }
    }
}
