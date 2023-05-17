package com.heytap.mcssdk.d;

import android.content.Context;
import android.content.Intent;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.heytap.mcssdk.PushService;
import com.heytap.msp.push.mode.BaseMode;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes9.dex */
public abstract class c implements d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public c() {
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

    public static List<BaseMode> a(Context context, Intent intent) {
        InterceptResult invokeLL;
        BaseMode a;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, context, intent)) == null) {
            if (intent == null) {
                return null;
            }
            int i = 4096;
            try {
                i = Integer.parseInt(com.heytap.mcssdk.utils.b.d(intent.getStringExtra("type")));
            } catch (Exception e) {
                com.heytap.mcssdk.utils.d.e("MessageParser--getMessageByIntent--Exception:" + e.getMessage());
            }
            com.heytap.mcssdk.utils.d.b("MessageParser--getMessageByIntent--type:" + i);
            ArrayList arrayList = new ArrayList();
            for (d dVar : PushService.getInstance().getParsers()) {
                if (dVar != null && (a = dVar.a(context, i, intent)) != null) {
                    arrayList.add(a);
                }
            }
            return arrayList;
        }
        return (List) invokeLL.objValue;
    }

    public abstract BaseMode a(Intent intent, int i);
}
