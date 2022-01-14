package com.vivo.push.sdk;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
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
import com.vivo.push.e;
import com.vivo.push.util.ContextDelegate;
import com.vivo.push.util.p;
import com.vivo.push.util.r;
/* loaded from: classes4.dex */
public class PushServiceReceiver extends BroadcastReceiver {
    public static /* synthetic */ Interceptable $ic;
    public static HandlerThread a;

    /* renamed from: b  reason: collision with root package name */
    public static Handler f60727b;

    /* renamed from: c  reason: collision with root package name */
    public static a f60728c;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes4.dex */
    public static class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public Context a;

        /* renamed from: b  reason: collision with root package name */
        public String f60729b;

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
            aVar.a = ContextDelegate.getContext(context);
            aVar.f60729b = str;
        }

        @Override // java.lang.Runnable
        public final void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                NetworkInfo a = r.a(this.a);
                if (!(a != null ? a.isConnectedOrConnecting() : false)) {
                    p.d("PushServiceReceiver", this.a.getPackageName() + ": 无网络  by " + this.f60729b);
                    Context context = this.a;
                    p.a(context, "触发静态广播:无网络(" + this.f60729b + "," + this.a.getPackageName() + SmallTailInfo.EMOTION_SUFFIX);
                    return;
                }
                p.d("PushServiceReceiver", this.a.getPackageName() + ": 执行开始出发动作: " + this.f60729b);
                Context context2 = this.a;
                p.a(context2, "触发静态广播(" + this.f60729b + "," + this.a.getPackageName() + SmallTailInfo.EMOTION_SUFFIX);
                e.a().a(this.a);
                if (ClientConfigManagerImpl.getInstance(this.a).isCancleBroadcastReceiver()) {
                    return;
                }
                PushClient.getInstance(this.a).initialize();
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
        f60728c = new a();
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
            Context context2 = ContextDelegate.getContext(context);
            String action = intent.getAction();
            if ("android.net.conn.CONNECTIVITY_CHANGE".equals(action) || "android.intent.action.ACTION_POWER_CONNECTED".equals(action) || "android.intent.action.ACTION_POWER_DISCONNECTED".equals(action)) {
                if (a == null) {
                    HandlerThread handlerThread = new HandlerThread("PushServiceReceiver");
                    a = handlerThread;
                    handlerThread.start();
                    f60727b = new Handler(a.getLooper());
                }
                p.d("PushServiceReceiver", context2.getPackageName() + ": start PushSerevice for by " + action + "  ; handler : " + f60727b);
                a.a(f60728c, context2, action);
                f60727b.removeCallbacks(f60728c);
                f60727b.postDelayed(f60728c, 2000L);
            }
        }
    }
}
