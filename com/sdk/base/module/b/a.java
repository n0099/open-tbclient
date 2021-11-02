package com.sdk.base.module.b;

import android.content.Context;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.sdk.base.framework.a.a.c;
import com.sdk.base.framework.c.e;
import com.sdk.base.framework.c.f;
import com.sdk.base.framework.c.g;
import com.sdk.base.module.manager.SDKManager;
/* loaded from: classes2.dex */
public class a<T> extends com.sdk.base.framework.d.a<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(Context context, com.sdk.base.framework.b.a<T> aVar, e eVar) {
        super(context, aVar, eVar);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, aVar, eVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (com.sdk.base.framework.b.a) objArr2[1], (e) objArr2[2]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        if (!f.f68208d) {
            this.f68215b = g.f68211b.a();
            this.f68216c = g.f68210a.a();
            return;
        }
        String testHost = SDKManager.getTestHost();
        String statisticalTestHost = SDKManager.getStatisticalTestHost();
        this.f68216c = c.b(statisticalTestHost).booleanValue() ? statisticalTestHost : g.f68210a.a();
        if (c.b(testHost).booleanValue()) {
            this.f68215b = testHost;
        } else {
            this.f68215b = g.f68211b.a();
        }
    }
}
