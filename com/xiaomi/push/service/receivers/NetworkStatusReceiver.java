package com.xiaomi.push.service.receivers;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import com.baidu.mobads.container.util.AdIconUtil;
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
/* loaded from: classes10.dex */
public class NetworkStatusReceiver extends BroadcastReceiver {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: a  reason: collision with root package name */
    public static int f78231a = 1;

    /* renamed from: a  reason: collision with other field name */
    public static BlockingQueue<Runnable> f974a = null;

    /* renamed from: a  reason: collision with other field name */
    public static ThreadPoolExecutor f975a = null;

    /* renamed from: a  reason: collision with other field name */
    public static boolean f976a = false;

    /* renamed from: b  reason: collision with root package name */
    public static int f78232b = 1;

    /* renamed from: c  reason: collision with root package name */
    public static int f78233c = 2;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with other field name */
    public boolean f977b;

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
        f974a = new LinkedBlockingQueue();
        f975a = new ThreadPoolExecutor(f78231a, f78232b, f78233c, TimeUnit.SECONDS, f974a);
        f976a = false;
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
        this.f977b = false;
        this.f977b = true;
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
        this.f977b = false;
        f976a = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, this, context) == null) {
            if (!an.a(context).m107a() && b.m114a(context).m123c() && !b.m114a(context).m126f()) {
                try {
                    Intent intent = new Intent();
                    intent.setComponent(new ComponentName(context, "com.xiaomi.push.service.XMPushService"));
                    intent.setAction("com.xiaomi.push.network_status_changed");
                    ServiceClient.getInstance(context).startServiceSafely(intent);
                } catch (Exception e2) {
                    com.xiaomi.channel.commonutils.logger.b.a(e2);
                }
            }
            gq.m362a(context);
            if (bg.b(context) && an.a(context).m110b()) {
                an.a(context).m111c();
            }
            if (bg.b(context)) {
                if ("syncing".equals(ae.a(context).a(at.f77289a))) {
                    MiPushClient.disablePush(context);
                }
                if ("syncing".equals(ae.a(context).a(at.f77290b))) {
                    MiPushClient.enablePush(context);
                }
                if ("syncing".equals(ae.a(context).a(at.f77291c))) {
                    MiPushClient.syncAssemblePushToken(context);
                }
                if ("syncing".equals(ae.a(context).a(at.f77292d))) {
                    MiPushClient.syncAssembleFCMPushToken(context);
                }
                if ("syncing".equals(ae.a(context).a(at.f77293e))) {
                    MiPushClient.syncAssembleCOSPushToken(context);
                }
                if ("syncing".equals(ae.a(context).a(at.f77294f))) {
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
        return (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.AD_TEXT_ID, null)) == null) ? f976a : invokeV.booleanValue;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, context, intent) == null) || this.f977b) {
            return;
        }
        f975a.execute(new a(this, context));
    }
}
