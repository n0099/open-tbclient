package com.xiaomi.push.service.receivers;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.xiaomi.mipush.sdk.COSPushHelper;
import com.xiaomi.mipush.sdk.FTOSPushHelper;
import com.xiaomi.mipush.sdk.HWPushHelper;
import com.xiaomi.mipush.sdk.MiPushClient;
import com.xiaomi.mipush.sdk.ae;
import com.xiaomi.mipush.sdk.an;
import com.xiaomi.mipush.sdk.at;
import com.xiaomi.mipush.sdk.b;
import com.xiaomi.push.bg;
import com.xiaomi.push.gq;
import com.xiaomi.push.service.ServiceClient;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
/* loaded from: classes4.dex */
public class NetworkStatusReceiver extends BroadcastReceiver {
    public static /* synthetic */ Interceptable $ic = null;
    public static int a = 1;

    /* renamed from: a  reason: collision with other field name */
    public static BlockingQueue<Runnable> f975a = null;

    /* renamed from: a  reason: collision with other field name */
    public static ThreadPoolExecutor f976a = null;

    /* renamed from: a  reason: collision with other field name */
    public static boolean f977a = false;

    /* renamed from: b  reason: collision with root package name */
    public static int f63864b = 1;

    /* renamed from: c  reason: collision with root package name */
    public static int f63865c = 2;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with other field name */
    public boolean f978b;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-776277076, "Lcom/xiaomi/push/service/receivers/NetworkStatusReceiver;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-776277076, "Lcom/xiaomi/push/service/receivers/NetworkStatusReceiver;");
                return;
            }
        }
        f975a = new LinkedBlockingQueue();
        f976a = new ThreadPoolExecutor(a, f63864b, f63865c, TimeUnit.SECONDS, f975a);
        f977a = false;
    }

    public NetworkStatusReceiver() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f978b = false;
        this.f978b = true;
    }

    public NetworkStatusReceiver(Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {obj};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.f978b = false;
        f977a = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, this, context) == null) {
            if (!an.a(context).m156a() && b.m163a(context).m172c() && !b.m163a(context).m175f()) {
                try {
                    Intent intent = new Intent();
                    intent.setComponent(new ComponentName(context, "com.xiaomi.push.service.XMPushService"));
                    intent.setAction("com.xiaomi.push.network_status_changed");
                    ServiceClient.getInstance(context).startServiceSafely(intent);
                } catch (Exception e2) {
                    com.xiaomi.channel.commonutils.logger.b.a(e2);
                }
            }
            gq.m411a(context);
            if (bg.b(context) && an.a(context).m159b()) {
                an.a(context).m160c();
            }
            if (bg.b(context)) {
                if ("syncing".equals(ae.a(context).a(at.a))) {
                    MiPushClient.disablePush(context);
                }
                if ("syncing".equals(ae.a(context).a(at.f63267b))) {
                    MiPushClient.enablePush(context);
                }
                if ("syncing".equals(ae.a(context).a(at.f63268c))) {
                    MiPushClient.syncAssemblePushToken(context);
                }
                if ("syncing".equals(ae.a(context).a(at.f63269d))) {
                    MiPushClient.syncAssembleFCMPushToken(context);
                }
                if ("syncing".equals(ae.a(context).a(at.f63270e))) {
                    MiPushClient.syncAssembleCOSPushToken(context);
                }
                if ("syncing".equals(ae.a(context).a(at.f63271f))) {
                    MiPushClient.syncAssembleFTOSPushToken(context);
                }
                if (HWPushHelper.needConnect() && HWPushHelper.shouldTryConnect(context)) {
                    HWPushHelper.setConnectTime(context);
                    HWPushHelper.registerHuaWeiAssemblePush(context);
                }
                COSPushHelper.doInNetworkChange(context);
                FTOSPushHelper.doInNetworkChange(context);
            }
        }
    }

    public static boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) ? f977a : invokeV.booleanValue;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, context, intent) == null) || this.f978b) {
            return;
        }
        f976a.execute(new a(this, context));
    }
}
