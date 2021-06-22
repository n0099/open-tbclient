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
    public static HandlerThread f40456a;

    /* renamed from: b  reason: collision with root package name */
    public static Handler f40457b;

    /* renamed from: c  reason: collision with root package name */
    public static a f40458c = new a();

    /* loaded from: classes7.dex */
    public static class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public Context f40459a;

        /* renamed from: b  reason: collision with root package name */
        public String f40460b;

        public static /* synthetic */ void a(a aVar, Context context, String str) {
            aVar.f40459a = context.getApplicationContext();
            aVar.f40460b = str;
        }

        @Override // java.lang.Runnable
        public final void run() {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) this.f40459a.getApplicationContext().getSystemService("connectivity")).getActiveNetworkInfo();
            if (!(activeNetworkInfo != null ? activeNetworkInfo.isConnectedOrConnecting() : false)) {
                p.d("PushServiceReceiver", this.f40459a.getPackageName() + ": 无网络  by " + this.f40460b);
                Context context = this.f40459a;
                p.a(context, "触发静态广播:无网络(" + this.f40460b + "," + this.f40459a.getPackageName() + SmallTailInfo.EMOTION_SUFFIX);
                return;
            }
            p.d("PushServiceReceiver", this.f40459a.getPackageName() + ": 执行开始出发动作: " + this.f40460b);
            Context context2 = this.f40459a;
            p.a(context2, "触发静态广播(" + this.f40460b + "," + this.f40459a.getPackageName() + SmallTailInfo.EMOTION_SUFFIX);
            com.vivo.push.p.a().a(this.f40459a);
            if (ClientConfigManagerImpl.getInstance(this.f40459a).isCancleBroadcastReceiver()) {
                return;
            }
            PushClient.getInstance(this.f40459a).initialize();
        }
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        if ("android.net.conn.CONNECTIVITY_CHANGE".equals(action) || "android.intent.action.ACTION_POWER_CONNECTED".equals(action) || "android.intent.action.ACTION_POWER_DISCONNECTED".equals(action)) {
            if (f40456a == null) {
                HandlerThread handlerThread = new HandlerThread("PushServiceReceiver");
                f40456a = handlerThread;
                handlerThread.start();
                f40457b = new Handler(f40456a.getLooper());
            }
            p.d("PushServiceReceiver", context.getPackageName() + ": start PushSerevice for by " + action + "  ; handler : " + f40457b);
            a.a(f40458c, context, action);
            f40457b.removeCallbacks(f40458c);
            f40457b.postDelayed(f40458c, 2000L);
        }
    }
}
