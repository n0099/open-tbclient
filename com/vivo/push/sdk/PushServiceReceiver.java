package com.vivo.push.sdk;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Handler;
import android.os.HandlerThread;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.vivo.push.PushClient;
import com.vivo.push.cache.ClientConfigManagerImpl;
import com.vivo.push.util.p;
/* loaded from: classes2.dex */
public class PushServiceReceiver extends BroadcastReceiver {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static HandlerThread f70349a;

    /* renamed from: b  reason: collision with root package name */
    public static Handler f70350b;

    /* renamed from: c  reason: collision with root package name */
    public static a f70351c;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes2.dex */
    public static class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public Context f70352a;

        /* renamed from: b  reason: collision with root package name */
        public String f70353b;

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public static /* synthetic */ void a(a aVar, Context context, String str) {
            aVar.f70352a = context.getApplicationContext();
            aVar.f70353b = str;
        }

        @Override // java.lang.Runnable
        public final void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                NetworkInfo activeNetworkInfo = ((ConnectivityManager) this.f70352a.getApplicationContext().getSystemService("connectivity")).getActiveNetworkInfo();
                if (!(activeNetworkInfo != null ? activeNetworkInfo.isConnectedOrConnecting() : false)) {
                    p.d("PushServiceReceiver", this.f70352a.getPackageName() + ": 无网络  by " + this.f70353b);
                    Context context = this.f70352a;
                    p.a(context, "触发静态广播:无网络(" + this.f70353b + "," + this.f70352a.getPackageName() + SmallTailInfo.EMOTION_SUFFIX);
                    return;
                }
                p.d("PushServiceReceiver", this.f70352a.getPackageName() + ": 执行开始出发动作: " + this.f70353b);
                Context context2 = this.f70352a;
                p.a(context2, "触发静态广播(" + this.f70353b + "," + this.f70352a.getPackageName() + SmallTailInfo.EMOTION_SUFFIX);
                com.vivo.push.p.a().a(this.f70352a);
                if (ClientConfigManagerImpl.getInstance(this.f70352a).isCancleBroadcastReceiver()) {
                    return;
                }
                PushClient.getInstance(this.f70352a).initialize();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-448844590, "Lcom/vivo/push/sdk/PushServiceReceiver;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-448844590, "Lcom/vivo/push/sdk/PushServiceReceiver;");
                return;
            }
        }
        f70351c = new a();
    }

    public PushServiceReceiver() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, context, intent) == null) {
            String action = intent.getAction();
            if ("android.net.conn.CONNECTIVITY_CHANGE".equals(action) || "android.intent.action.ACTION_POWER_CONNECTED".equals(action) || "android.intent.action.ACTION_POWER_DISCONNECTED".equals(action)) {
                if (f70349a == null) {
                    HandlerThread handlerThread = new HandlerThread("PushServiceReceiver");
                    f70349a = handlerThread;
                    handlerThread.start();
                    f70350b = new Handler(f70349a.getLooper());
                }
                p.d("PushServiceReceiver", context.getPackageName() + ": start PushSerevice for by " + action + "  ; handler : " + f70350b);
                a.a(f70351c, context, action);
                f70350b.removeCallbacks(f70351c);
                f70350b.postDelayed(f70351c, 2000L);
            }
        }
    }
}
