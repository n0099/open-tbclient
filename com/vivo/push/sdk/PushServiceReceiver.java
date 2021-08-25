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
/* loaded from: classes10.dex */
public class PushServiceReceiver extends BroadcastReceiver {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static HandlerThread f76468a;

    /* renamed from: b  reason: collision with root package name */
    public static Handler f76469b;

    /* renamed from: c  reason: collision with root package name */
    public static a f76470c;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes10.dex */
    public static class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public Context f76471a;

        /* renamed from: b  reason: collision with root package name */
        public String f76472b;

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
            aVar.f76471a = context.getApplicationContext();
            aVar.f76472b = str;
        }

        @Override // java.lang.Runnable
        public final void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                NetworkInfo activeNetworkInfo = ((ConnectivityManager) this.f76471a.getApplicationContext().getSystemService("connectivity")).getActiveNetworkInfo();
                if (!(activeNetworkInfo != null ? activeNetworkInfo.isConnectedOrConnecting() : false)) {
                    p.d("PushServiceReceiver", this.f76471a.getPackageName() + ": 无网络  by " + this.f76472b);
                    Context context = this.f76471a;
                    p.a(context, "触发静态广播:无网络(" + this.f76472b + "," + this.f76471a.getPackageName() + SmallTailInfo.EMOTION_SUFFIX);
                    return;
                }
                p.d("PushServiceReceiver", this.f76471a.getPackageName() + ": 执行开始出发动作: " + this.f76472b);
                Context context2 = this.f76471a;
                p.a(context2, "触发静态广播(" + this.f76472b + "," + this.f76471a.getPackageName() + SmallTailInfo.EMOTION_SUFFIX);
                com.vivo.push.p.a().a(this.f76471a);
                if (ClientConfigManagerImpl.getInstance(this.f76471a).isCancleBroadcastReceiver()) {
                    return;
                }
                PushClient.getInstance(this.f76471a).initialize();
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
        f76470c = new a();
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
                if (f76468a == null) {
                    HandlerThread handlerThread = new HandlerThread("PushServiceReceiver");
                    f76468a = handlerThread;
                    handlerThread.start();
                    f76469b = new Handler(f76468a.getLooper());
                }
                p.d("PushServiceReceiver", context.getPackageName() + ": start PushSerevice for by " + action + "  ; handler : " + f76469b);
                a.a(f76470c, context, action);
                f76469b.removeCallbacks(f76470c);
                f76469b.postDelayed(f76470c, 2000L);
            }
        }
    }
}
