package com.ss.android.socialbase.appdownloader.a;

import android.content.Context;
import android.content.Intent;
import com.baidu.mapsdkplatform.comapi.map.ag;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class l extends a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l(Context context, com.ss.android.socialbase.downloader.g.a aVar, String str) {
        super(context, aVar, str);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, aVar, str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (com.ss.android.socialbase.downloader.g.a) objArr2[1], (String) objArr2[2]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // com.ss.android.socialbase.appdownloader.a.e
    public Intent b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            String c2 = this.f62047b.c("s");
            String a = com.ss.android.socialbase.appdownloader.f.c.a(this.f62047b.c(ag.f36904h), c2);
            String a2 = com.ss.android.socialbase.appdownloader.f.c.a(this.f62047b.c("ah"), c2);
            String a3 = com.ss.android.socialbase.appdownloader.f.c.a(this.f62047b.c("ai"), c2);
            String a4 = com.ss.android.socialbase.appdownloader.f.c.a(this.f62047b.c("aj"), c2);
            Intent intent = new Intent();
            intent.putExtra(a, this.f62048c);
            intent.putExtra(a2, "*/*");
            intent.putExtra(a3, true);
            intent.setAction(a4);
            intent.addFlags(268435456);
            intent.addFlags(32768);
            return intent;
        }
        return (Intent) invokeV.objValue;
    }
}
