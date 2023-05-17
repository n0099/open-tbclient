package com.huawei.hms.support.api.entity.push;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
public class PushNaming {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String GETTOKEN_ASYNC_RSP = "push.onNewToken";
    public static final String PUSH_CONSENT = "push.consent";
    public static final String PUSH_PROFILE = "push.profile";
    public static final String RECEIVE_MSG_RSP = "push.receiveMessage";
    public static final String SET_NOTIFY_FLAG = "push.setNotifyFlag";
    public static final String SUBSCRIBE = "push.subscribe";
    public static final String UPSEND_MSG = "push.sendMessage";
    public static final String UPSEND_MSG_ASYNC_RSP = "push.sendMessageRet";
    public static final String UPSEND_RECEIPT = "push.deliveryMessage";
    public transient /* synthetic */ FieldHolder $fh;

    public PushNaming() {
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
}
