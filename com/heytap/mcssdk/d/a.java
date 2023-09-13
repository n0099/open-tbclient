package com.heytap.mcssdk.d;

import android.content.Context;
import android.content.Intent;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.heytap.msp.push.mode.BaseMode;
/* loaded from: classes10.dex */
public class a extends c {
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

    @Override // com.heytap.mcssdk.d.d
    public BaseMode a(Context context, int i, Intent intent) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048576, this, context, i, intent)) == null) {
            if (4105 == i) {
                return a(intent, i);
            }
            return null;
        }
        return (BaseMode) invokeLIL.objValue;
    }

    @Override // com.heytap.mcssdk.d.c
    public BaseMode a(Intent intent, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, intent, i)) == null) {
            try {
                com.heytap.mcssdk.c.b bVar = new com.heytap.mcssdk.c.b();
                bVar.a(Integer.parseInt(com.heytap.mcssdk.utils.b.d(intent.getStringExtra("command"))));
                bVar.b(Integer.parseInt(com.heytap.mcssdk.utils.b.d(intent.getStringExtra("code"))));
                bVar.e(com.heytap.mcssdk.utils.b.d(intent.getStringExtra("content")));
                bVar.a(com.heytap.mcssdk.utils.b.d(intent.getStringExtra("appKey")));
                bVar.b(com.heytap.mcssdk.utils.b.d(intent.getStringExtra(com.heytap.mcssdk.constant.b.A)));
                bVar.f(com.heytap.mcssdk.utils.b.d(intent.getStringExtra("appPackage")));
                com.heytap.mcssdk.utils.d.b("OnHandleIntent-message:" + bVar.toString());
                return bVar;
            } catch (Exception e) {
                com.heytap.mcssdk.utils.d.b("OnHandleIntent--" + e.getMessage());
                return null;
            }
        }
        return (BaseMode) invokeLI.objValue;
    }
}
