package com.huawei.hms.base.log;

import android.content.Context;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.huawei.hms.support.log.HMSExtLogger;
/* loaded from: classes9.dex */
public class d implements b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final HMSExtLogger a;
    public b b;

    public d(HMSExtLogger hMSExtLogger) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {hMSExtLogger};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = hMSExtLogger;
    }

    @Override // com.huawei.hms.base.log.b
    public void a(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar) == null) {
            this.b = bVar;
        }
    }

    @Override // com.huawei.hms.base.log.b
    public void a(Context context, String str) {
        b bVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048576, this, context, str) == null) && (bVar = this.b) != null) {
            bVar.a(context, str);
        }
    }

    @Override // com.huawei.hms.base.log.b
    public void a(String str, int i, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLILL(Constants.METHOD_SEND_USER_MSG, this, str, i, str2, str3) == null) {
            HMSExtLogger hMSExtLogger = this.a;
            if (hMSExtLogger != null) {
                if (i != 3) {
                    if (i != 4) {
                        if (i != 5) {
                            hMSExtLogger.e(str2, str3);
                        } else {
                            hMSExtLogger.w(str2, str3);
                        }
                    } else {
                        hMSExtLogger.i(str2, str3);
                    }
                } else {
                    hMSExtLogger.d(str2, str3);
                }
            }
            b bVar = this.b;
            if (bVar != null) {
                bVar.a(str, i, str2, str3);
            }
        }
    }
}
