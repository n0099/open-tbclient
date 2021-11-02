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
import com.heytap.mcssdk.mode.AppMessage;
import com.heytap.mcssdk.mode.Message;
import com.heytap.mcssdk.utils.CryptoUtil;
import com.heytap.mcssdk.utils.LogUtil;
/* loaded from: classes2.dex */
public final class a extends c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

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

    @Override // com.heytap.mcssdk.a.d
    public final Message a(Context context, int i2, Intent intent) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048576, this, context, i2, intent)) == null) {
            if (4098 == i2) {
                Message a2 = a(intent);
                PushManager.statisticMessage(context, (AppMessage) a2, PushManager.EVENT_ID_PUSH_TRANSMIT);
                return a2;
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
                AppMessage appMessage = new AppMessage();
                appMessage.setMessageID(Integer.parseInt(CryptoUtil.desDecrypt(intent.getStringExtra("messageID"))));
                appMessage.setTaskID(CryptoUtil.desDecrypt(intent.getStringExtra("taskID")));
                appMessage.setAppPackage(CryptoUtil.desDecrypt(intent.getStringExtra("appPackage")));
                appMessage.setContent(CryptoUtil.desDecrypt(intent.getStringExtra("content")));
                appMessage.setBalanceTime(Integer.parseInt(CryptoUtil.desDecrypt(intent.getStringExtra(Message.BALANCE_TIME))));
                appMessage.setStartDate(Long.parseLong(CryptoUtil.desDecrypt(intent.getStringExtra(Message.START_DATE))));
                appMessage.setEndDate(Long.parseLong(CryptoUtil.desDecrypt(intent.getStringExtra(Message.END_DATE))));
                appMessage.setTimeRanges(CryptoUtil.desDecrypt(intent.getStringExtra(Message.TIME_RANGES)));
                appMessage.setTitle(CryptoUtil.desDecrypt(intent.getStringExtra("title")));
                appMessage.setRule(CryptoUtil.desDecrypt(intent.getStringExtra(Message.RULE)));
                appMessage.setForcedDelivery(Integer.parseInt(CryptoUtil.desDecrypt(intent.getStringExtra(Message.FORCED_DELIVERY))));
                appMessage.setDistinctBycontent(Integer.parseInt(CryptoUtil.desDecrypt(intent.getStringExtra(Message.DISTINCT_CONTENT))));
                LogUtil.d("OnHandleIntent-message:" + appMessage.toString());
                return appMessage;
            } catch (Exception e2) {
                LogUtil.d("OnHandleIntent--" + e2.getMessage());
                return null;
            }
        }
        return (Message) invokeL.objValue;
    }
}
