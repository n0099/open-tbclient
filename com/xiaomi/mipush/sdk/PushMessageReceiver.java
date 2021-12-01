package com.xiaomi.mipush.sdk;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kuaishou.weapon.un.w0;
import com.xiaomi.mipush.sdk.MessageHandleService;
import com.xiaomi.push.el;
/* loaded from: classes3.dex */
public abstract class PushMessageReceiver extends BroadcastReceiver {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public PushMessageReceiver() {
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

    public void onCommandResult(Context context, MiPushCommandMessage miPushCommandMessage) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, context, miPushCommandMessage) == null) {
        }
    }

    public void onNotificationMessageArrived(Context context, MiPushMessage miPushMessage) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(com.baidu.android.imsdk.internal.Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, miPushMessage) == null) {
        }
    }

    public void onNotificationMessageClicked(Context context, MiPushMessage miPushMessage) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(com.baidu.android.imsdk.internal.Constants.METHOD_SEND_USER_MSG, this, context, miPushMessage) == null) {
        }
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, context, intent) == null) {
            MessageHandleService.addJob(context.getApplicationContext(), new MessageHandleService.a(intent, this));
            try {
                int intExtra = intent.getIntExtra("eventMessageType", -1);
                if (intExtra == 2000) {
                    el.a(context.getApplicationContext()).a(context.getPackageName(), intent, 2003, (String) null);
                } else if (intExtra == 6000) {
                    el.a(context.getApplicationContext()).a(context.getPackageName(), intent, w0.i3, (String) null);
                }
            } catch (Exception e2) {
                com.xiaomi.channel.commonutils.logger.b.a(e2);
            }
        }
    }

    @Deprecated
    public void onReceiveMessage(Context context, MiPushMessage miPushMessage) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, context, miPushMessage) == null) {
        }
    }

    public void onReceivePassThroughMessage(Context context, MiPushMessage miPushMessage) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, context, miPushMessage) == null) {
        }
    }

    public void onReceiveRegisterResult(Context context, MiPushCommandMessage miPushCommandMessage) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, context, miPushCommandMessage) == null) {
        }
    }

    public void onRequirePermissions(Context context, String[] strArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, context, strArr) == null) {
        }
    }
}
