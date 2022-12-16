package com.heytap.mcssdk.a;

import android.content.Context;
import android.content.Intent;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.heytap.mcssdk.PushManager;
import com.heytap.mcssdk.mode.Message;
import com.heytap.mcssdk.mode.SptDataMessage;
import com.heytap.mcssdk.utils.CryptoUtil;
import com.heytap.mcssdk.utils.LogUtil;
/* loaded from: classes8.dex */
public final class e extends c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public e() {
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

    @Override // com.heytap.mcssdk.a.d
    public final Message a(Context context, int i, Intent intent) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048576, this, context, i, intent)) == null) {
            if (4103 == i) {
                Message a = a(intent);
                PushManager.statisticMessage(context, (SptDataMessage) a, PushManager.EVENT_ID_PUSH_TRANSMIT);
                return a;
            }
            return null;
        }
        return (Message) invokeLIL.objValue;
    }

    @Override // com.heytap.mcssdk.a.c
    public final Message a(Intent intent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, intent)) == null) {
            try {
                SptDataMessage sptDataMessage = new SptDataMessage();
                sptDataMessage.setMessageID(Integer.parseInt(CryptoUtil.desDecrypt(intent.getStringExtra("messageID"))));
                sptDataMessage.setTaskID(CryptoUtil.desDecrypt(intent.getStringExtra("taskID")));
                sptDataMessage.setAppPackage(CryptoUtil.desDecrypt(intent.getStringExtra("appPackage")));
                sptDataMessage.setContent(CryptoUtil.desDecrypt(intent.getStringExtra("content")));
                sptDataMessage.setDescription(CryptoUtil.desDecrypt(intent.getStringExtra("description")));
                sptDataMessage.setAppID(CryptoUtil.desDecrypt(intent.getStringExtra(Message.APP_ID)));
                sptDataMessage.setGlobalID(CryptoUtil.desDecrypt(intent.getStringExtra("globalID")));
                return sptDataMessage;
            } catch (Exception e) {
                LogUtil.d("OnHandleIntent--" + e.getMessage());
                return null;
            }
        }
        return (Message) invokeL.objValue;
    }
}
