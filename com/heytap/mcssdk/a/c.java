package com.heytap.mcssdk.a;

import android.content.Context;
import android.content.Intent;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.heytap.mcssdk.PushManager;
import com.heytap.mcssdk.mode.Message;
import com.heytap.mcssdk.utils.CryptoUtil;
import com.heytap.mcssdk.utils.LogUtil;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public abstract class c implements d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public c() {
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

    public static List<Message> a(Context context, Intent intent) {
        InterceptResult invokeLL;
        Message a;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, context, intent)) == null) {
            if (intent == null) {
                return null;
            }
            int i2 = 4096;
            try {
                i2 = Integer.parseInt(CryptoUtil.desDecrypt(intent.getStringExtra("type")));
            } catch (Exception e2) {
                LogUtil.e("MessageParser--getMessageByIntent--Exception:" + e2.getMessage());
            }
            LogUtil.d("MessageParser--getMessageByIntent--type:" + i2);
            ArrayList arrayList = new ArrayList();
            for (d dVar : PushManager.getInstance().getParsers()) {
                if (dVar != null && (a = dVar.a(context, i2, intent)) != null) {
                    arrayList.add(a);
                }
            }
            return arrayList;
        }
        return (List) invokeLL.objValue;
    }

    public abstract Message a(Intent intent);
}
