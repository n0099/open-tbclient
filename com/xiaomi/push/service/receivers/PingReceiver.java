package com.xiaomi.push.service.receivers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.eu;
import com.xiaomi.push.service.ServiceClient;
import com.xiaomi.push.service.XMPushService;
import com.xiaomi.push.service.bk;
/* loaded from: classes8.dex */
public class PingReceiver extends BroadcastReceiver {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public PingReceiver() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, context, intent) == null) {
            b.c(intent.getPackage() + " is the package name");
            if (XMPushService.m594e()) {
                return;
            }
            if (!bk.p.equals(intent.getAction())) {
                b.m99a("cancel the old ping timer");
                eu.a();
            } else if (TextUtils.equals(context.getPackageName(), intent.getPackage())) {
                b.c("Ping XMChannelService on timer");
                try {
                    Intent intent2 = new Intent(context, XMPushService.class);
                    intent2.putExtra("time_stamp", System.currentTimeMillis());
                    intent2.setAction("com.xiaomi.push.timer");
                    ServiceClient.getInstance(context).startServiceSafely(intent2);
                } catch (Exception e) {
                    b.a(e);
                }
            }
        }
    }
}
