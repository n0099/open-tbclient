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
    public static HandlerThread f40353a;

    /* renamed from: b  reason: collision with root package name */
    public static Handler f40354b;

    /* renamed from: c  reason: collision with root package name */
    public static a f40355c = new a();

    /* loaded from: classes7.dex */
    public static class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public Context f40356a;

        /* renamed from: b  reason: collision with root package name */
        public String f40357b;

        public static /* synthetic */ void a(a aVar, Context context, String str) {
            aVar.f40356a = context.getApplicationContext();
            aVar.f40357b = str;
        }

        @Override // java.lang.Runnable
        public final void run() {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) this.f40356a.getApplicationContext().getSystemService("connectivity")).getActiveNetworkInfo();
            if (!(activeNetworkInfo != null ? activeNetworkInfo.isConnectedOrConnecting() : false)) {
                p.d("PushServiceReceiver", this.f40356a.getPackageName() + ": 无网络  by " + this.f40357b);
                Context context = this.f40356a;
                p.a(context, "触发静态广播:无网络(" + this.f40357b + "," + this.f40356a.getPackageName() + SmallTailInfo.EMOTION_SUFFIX);
                return;
            }
            p.d("PushServiceReceiver", this.f40356a.getPackageName() + ": 执行开始出发动作: " + this.f40357b);
            Context context2 = this.f40356a;
            p.a(context2, "触发静态广播(" + this.f40357b + "," + this.f40356a.getPackageName() + SmallTailInfo.EMOTION_SUFFIX);
            com.vivo.push.p.a().a(this.f40356a);
            if (ClientConfigManagerImpl.getInstance(this.f40356a).isCancleBroadcastReceiver()) {
                return;
            }
            PushClient.getInstance(this.f40356a).initialize();
        }
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        if ("android.net.conn.CONNECTIVITY_CHANGE".equals(action) || "android.intent.action.ACTION_POWER_CONNECTED".equals(action) || "android.intent.action.ACTION_POWER_DISCONNECTED".equals(action)) {
            if (f40353a == null) {
                HandlerThread handlerThread = new HandlerThread("PushServiceReceiver");
                f40353a = handlerThread;
                handlerThread.start();
                f40354b = new Handler(f40353a.getLooper());
            }
            p.d("PushServiceReceiver", context.getPackageName() + ": start PushSerevice for by " + action + "  ; handler : " + f40354b);
            a.a(f40355c, context, action);
            f40354b.removeCallbacks(f40355c);
            f40354b.postDelayed(f40355c, 2000L);
        }
    }
}
