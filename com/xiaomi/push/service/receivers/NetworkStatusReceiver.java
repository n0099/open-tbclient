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
import com.xiaomi.mipush.sdk.af;
import com.xiaomi.mipush.sdk.ao;
import com.xiaomi.mipush.sdk.au;
import com.xiaomi.mipush.sdk.b;
import com.xiaomi.push.bj;
import com.xiaomi.push.hb;
import com.xiaomi.push.o;
import com.xiaomi.push.service.ServiceClient;
/* loaded from: classes8.dex */
public class NetworkStatusReceiver extends BroadcastReceiver {
    public static /* synthetic */ Interceptable $ic;
    public static boolean a;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean b;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-776277076, "Lcom/xiaomi/push/service/receivers/NetworkStatusReceiver;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-776277076, "Lcom/xiaomi/push/service/receivers/NetworkStatusReceiver;");
        }
    }

    public NetworkStatusReceiver() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.b = false;
        this.b = true;
    }

    public NetworkStatusReceiver(Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {obj};
            interceptable.invokeUnInit(65538, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.b = false;
        a = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, this, context) == null) {
            if (!ao.a(context).m124a() && b.m131a(context).m140c() && !b.m131a(context).m143f()) {
                try {
                    Intent intent = new Intent();
                    intent.setComponent(new ComponentName(context, "com.xiaomi.push.service.XMPushService"));
                    intent.setAction("com.xiaomi.push.network_status_changed");
                    ServiceClient.getInstance(context).startServiceSafely(intent);
                } catch (Exception e) {
                    com.xiaomi.channel.commonutils.logger.b.a(e);
                }
            }
            hb.m392a(context);
            if (bj.b(context) && ao.a(context).m127b()) {
                ao.a(context).m128c();
            }
            if (bj.b(context)) {
                if ("syncing".equals(af.a(context).a(au.a))) {
                    MiPushClient.disablePush(context);
                }
                if ("syncing".equals(af.a(context).a(au.b))) {
                    MiPushClient.enablePush(context);
                }
                if ("syncing".equals(af.a(context).a(au.c))) {
                    MiPushClient.syncAssemblePushToken(context);
                }
                if ("syncing".equals(af.a(context).a(au.d))) {
                    MiPushClient.syncAssembleFCMPushToken(context);
                }
                if ("syncing".equals(af.a(context).a(au.e))) {
                    MiPushClient.syncAssembleCOSPushToken(context);
                }
                if ("syncing".equals(af.a(context).a(au.f))) {
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
        return (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) ? a : invokeV.booleanValue;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, context, intent) == null) || this.b) {
            return;
        }
        o.a().post(new a(this, context));
    }
}
