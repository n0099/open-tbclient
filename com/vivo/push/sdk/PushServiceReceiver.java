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
    public static HandlerThread f39511a;

    /* renamed from: b  reason: collision with root package name */
    public static Handler f39512b;

    /* renamed from: c  reason: collision with root package name */
    public static a f39513c = new a();

    /* loaded from: classes7.dex */
    public static class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public Context f39514a;

        /* renamed from: b  reason: collision with root package name */
        public String f39515b;

        public static /* synthetic */ void a(a aVar, Context context, String str) {
            aVar.f39514a = context.getApplicationContext();
            aVar.f39515b = str;
        }

        @Override // java.lang.Runnable
        public final void run() {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) this.f39514a.getApplicationContext().getSystemService("connectivity")).getActiveNetworkInfo();
            if (!(activeNetworkInfo != null ? activeNetworkInfo.isConnectedOrConnecting() : false)) {
                p.d("PushServiceReceiver", this.f39514a.getPackageName() + ": 无网络  by " + this.f39515b);
                Context context = this.f39514a;
                p.a(context, "触发静态广播:无网络(" + this.f39515b + "," + this.f39514a.getPackageName() + SmallTailInfo.EMOTION_SUFFIX);
                return;
            }
            p.d("PushServiceReceiver", this.f39514a.getPackageName() + ": 执行开始出发动作: " + this.f39515b);
            Context context2 = this.f39514a;
            p.a(context2, "触发静态广播(" + this.f39515b + "," + this.f39514a.getPackageName() + SmallTailInfo.EMOTION_SUFFIX);
            com.vivo.push.p.a().a(this.f39514a);
            if (ClientConfigManagerImpl.getInstance(this.f39514a).isCancleBroadcastReceiver()) {
                return;
            }
            PushClient.getInstance(this.f39514a).initialize();
        }
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        if ("android.net.conn.CONNECTIVITY_CHANGE".equals(action) || "android.intent.action.ACTION_POWER_CONNECTED".equals(action) || "android.intent.action.ACTION_POWER_DISCONNECTED".equals(action)) {
            if (f39511a == null) {
                HandlerThread handlerThread = new HandlerThread("PushServiceReceiver");
                f39511a = handlerThread;
                handlerThread.start();
                f39512b = new Handler(f39511a.getLooper());
            }
            p.d("PushServiceReceiver", context.getPackageName() + ": start PushSerevice for by " + action + "  ; handler : " + f39512b);
            a.a(f39513c, context, action);
            f39512b.removeCallbacks(f39513c);
            f39512b.postDelayed(f39513c, 2000L);
        }
    }
}
