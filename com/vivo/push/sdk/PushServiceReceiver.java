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
    public static HandlerThread f36674a;

    /* renamed from: b  reason: collision with root package name */
    public static Handler f36675b;

    /* renamed from: c  reason: collision with root package name */
    public static a f36676c = new a();

    /* loaded from: classes7.dex */
    public static class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public Context f36677a;

        /* renamed from: b  reason: collision with root package name */
        public String f36678b;

        public static /* synthetic */ void a(a aVar, Context context, String str) {
            aVar.f36677a = context.getApplicationContext();
            aVar.f36678b = str;
        }

        @Override // java.lang.Runnable
        public final void run() {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) this.f36677a.getApplicationContext().getSystemService("connectivity")).getActiveNetworkInfo();
            if (!(activeNetworkInfo != null ? activeNetworkInfo.isConnectedOrConnecting() : false)) {
                p.d("PushServiceReceiver", this.f36677a.getPackageName() + ": 无网络  by " + this.f36678b);
                Context context = this.f36677a;
                p.a(context, "触发静态广播:无网络(" + this.f36678b + "," + this.f36677a.getPackageName() + SmallTailInfo.EMOTION_SUFFIX);
                return;
            }
            p.d("PushServiceReceiver", this.f36677a.getPackageName() + ": 执行开始出发动作: " + this.f36678b);
            Context context2 = this.f36677a;
            p.a(context2, "触发静态广播(" + this.f36678b + "," + this.f36677a.getPackageName() + SmallTailInfo.EMOTION_SUFFIX);
            com.vivo.push.p.a().a(this.f36677a);
            if (ClientConfigManagerImpl.getInstance(this.f36677a).isCancleBroadcastReceiver()) {
                return;
            }
            PushClient.getInstance(this.f36677a).initialize();
        }
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        if ("android.net.conn.CONNECTIVITY_CHANGE".equals(action) || "android.intent.action.ACTION_POWER_CONNECTED".equals(action) || "android.intent.action.ACTION_POWER_DISCONNECTED".equals(action)) {
            if (f36674a == null) {
                HandlerThread handlerThread = new HandlerThread("PushServiceReceiver");
                f36674a = handlerThread;
                handlerThread.start();
                f36675b = new Handler(f36674a.getLooper());
            }
            p.d("PushServiceReceiver", context.getPackageName() + ": start PushSerevice for by " + action + "  ; handler : " + f36675b);
            a.a(f36676c, context, action);
            f36675b.removeCallbacks(f36676c);
            f36675b.postDelayed(f36676c, 2000L);
        }
    }
}
