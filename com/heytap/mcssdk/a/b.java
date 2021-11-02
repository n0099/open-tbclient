package com.heytap.mcssdk.a;

import android.content.Context;
import android.content.Intent;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.heytap.mcssdk.mode.CommandMessage;
import com.heytap.mcssdk.mode.Message;
import com.heytap.mcssdk.utils.CryptoUtil;
import com.heytap.mcssdk.utils.LogUtil;
/* loaded from: classes2.dex */
public final class b extends c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public b() {
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
            if (4105 == i2) {
                return a(intent);
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
                CommandMessage commandMessage = new CommandMessage();
                commandMessage.setCommand(Integer.parseInt(CryptoUtil.desDecrypt(intent.getStringExtra("command"))));
                commandMessage.setResponseCode(Integer.parseInt(CryptoUtil.desDecrypt(intent.getStringExtra("code"))));
                commandMessage.setContent(CryptoUtil.desDecrypt(intent.getStringExtra("content")));
                commandMessage.setAppKey(CryptoUtil.desDecrypt(intent.getStringExtra("appKey")));
                commandMessage.setAppSecret(CryptoUtil.desDecrypt(intent.getStringExtra(CommandMessage.APP_SECRET)));
                commandMessage.setAppPackage(CryptoUtil.desDecrypt(intent.getStringExtra("appPackage")));
                LogUtil.d("OnHandleIntent-message:" + commandMessage.toString());
                return commandMessage;
            } catch (Exception e2) {
                LogUtil.d("OnHandleIntent--" + e2.getMessage());
                return null;
            }
        }
        return (Message) invokeL.objValue;
    }
}
