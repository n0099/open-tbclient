package com.heytap.mcssdk.utils;

import android.content.Context;
import android.content.Intent;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.heytap.mcssdk.PushManager;
import com.heytap.mcssdk.mode.CommandMessage;
/* loaded from: classes7.dex */
public class DataMessageUtil {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TYPE = "type";
    public transient /* synthetic */ FieldHolder $fh;

    public DataMessageUtil() {
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

    public void appArrive(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, context, str) == null) {
            try {
                Intent intent = new Intent();
                intent.setAction(PushManager.getReceiveSdkAction(context));
                intent.setPackage(PushManager.getMcsPackageName(context));
                intent.putExtra("appPackage", context.getPackageName());
                intent.putExtra("messageID", str);
                intent.putExtra("type", CommandMessage.COMMAND_SEND_INSTANT_ACK);
                context.startService(intent);
            } catch (Exception e) {
                LogUtil.e("statisticMessage--Exception" + e.getMessage());
            }
        }
    }
}
