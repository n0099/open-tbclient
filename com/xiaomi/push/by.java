package com.xiaomi.push;

import android.content.Context;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.xiaomi.push.al;
/* loaded from: classes8.dex */
public class by extends al.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ bx a;

    public by(bx bxVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bxVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = bxVar;
    }

    @Override // com.xiaomi.push.al.a
    /* renamed from: a */
    public String mo217a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "10052" : (String) invokeV.objValue;
    }

    @Override // java.lang.Runnable
    public void run() {
        cn cnVar;
        cn cnVar2;
        Context context;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            com.xiaomi.channel.commonutils.logger.b.c("exec== mUploadJob");
            cnVar = this.a.f176a;
            if (cnVar != null) {
                cnVar2 = this.a.f176a;
                context = this.a.f173a;
                cnVar2.a(context);
                this.a.b("upload_time");
            }
        }
    }
}
