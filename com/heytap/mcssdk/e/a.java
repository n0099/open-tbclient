package com.heytap.mcssdk.e;

import android.content.Context;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.heytap.mcssdk.PushService;
import com.heytap.mcssdk.constant.MessageConstant;
import com.heytap.mcssdk.utils.Utils;
import com.heytap.mcssdk.utils.d;
import com.heytap.mcssdk.utils.f;
import com.heytap.msp.push.callback.ICallBackResultService;
import com.heytap.msp.push.callback.IDataMessageCallBackService;
import com.heytap.msp.push.callback.IGetAppNotificationCallBackService;
import com.heytap.msp.push.callback.ISetAppNotificationCallBackService;
import com.heytap.msp.push.mode.BaseMode;
/* loaded from: classes9.dex */
public class a implements c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public a() {
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

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.heytap.mcssdk.c.b bVar, PushService pushService) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, this, bVar, pushService) == null) {
            if (bVar == null) {
                str = "message is null , please check param of parseCommandMessage(2)";
            } else if (pushService == null) {
                str = "pushService is null , please check param of parseCommandMessage(2)";
            } else if (pushService.getPushCallback() != null) {
                int e = bVar.e();
                if (e == 12287) {
                    ICallBackResultService pushCallback = pushService.getPushCallback();
                    if (pushCallback != null) {
                        pushCallback.onError(bVar.g(), bVar.f());
                        return;
                    }
                    return;
                } else if (e == 12298) {
                    pushService.getPushCallback().onSetPushTime(bVar.g(), bVar.f());
                    return;
                } else if (e == 12306) {
                    pushService.getPushCallback().onGetPushStatus(bVar.g(), Utils.parseInt(bVar.f()));
                    return;
                } else if (e == 12309) {
                    pushService.getPushCallback().onGetNotificationStatus(bVar.g(), Utils.parseInt(bVar.f()));
                    return;
                } else if (e == 12289) {
                    if (bVar.g() == 0) {
                        pushService.setRegisterID(bVar.f());
                    }
                    pushService.getPushCallback().onRegister(bVar.g(), bVar.f());
                    return;
                } else if (e == 12290) {
                    pushService.getPushCallback().onUnRegister(bVar.g());
                    return;
                } else {
                    switch (e) {
                        case MessageConstant.CommandId.COMMAND_APP_NOTIFICATION_OPEN /* 12316 */:
                        case MessageConstant.CommandId.COMMAND_APP_NOTIFICATION_CLOSE /* 12317 */:
                            ISetAppNotificationCallBackService pushSetAppNotificationCallBack = pushService.getPushSetAppNotificationCallBack();
                            if (pushSetAppNotificationCallBack != null) {
                                pushSetAppNotificationCallBack.onSetAppNotificationSwitch(bVar.g());
                                return;
                            }
                            return;
                        case MessageConstant.CommandId.COMMAND_APP_NOTIFICATION_GET /* 12318 */:
                            int i = 0;
                            try {
                                i = Integer.parseInt(bVar.f());
                            } catch (Exception unused) {
                            }
                            IGetAppNotificationCallBackService pushGetAppNotificationCallBack = pushService.getPushGetAppNotificationCallBack();
                            if (pushGetAppNotificationCallBack != null) {
                                pushGetAppNotificationCallBack.onGetAppNotificationSwitch(bVar.g(), i);
                                return;
                            }
                            return;
                        default:
                            return;
                    }
                }
            } else {
                str = "pushService.getPushCallback() is null , please check param of parseCommandMessage(2)";
            }
            d.e(str);
        }
    }

    @Override // com.heytap.mcssdk.e.c
    public void a(Context context, BaseMode baseMode, IDataMessageCallBackService iDataMessageCallBackService) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(1048576, this, context, baseMode, iDataMessageCallBackService) == null) && baseMode != null && baseMode.getType() == 4105) {
            com.heytap.mcssdk.c.b bVar = (com.heytap.mcssdk.c.b) baseMode;
            d.b("mcssdk-CallBackResultProcessor:" + bVar.toString());
            f.b(new Runnable(this, bVar) { // from class: com.heytap.mcssdk.e.a.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ com.heytap.mcssdk.c.b a;
                public final /* synthetic */ a b;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, bVar};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.b = this;
                    this.a = bVar;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.b.a(this.a, PushService.getInstance());
                    }
                }
            });
        }
    }
}
