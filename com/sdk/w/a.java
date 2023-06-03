package com.sdk.w;

import android.content.Context;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.sdk.base.module.manager.SDKManager;
import com.sdk.f.c;
import com.sdk.f.f;
import com.sdk.g.b;
/* loaded from: classes10.dex */
public class a<T> extends b<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x001e, code lost:
        if (com.sdk.o.a.b(r9).booleanValue() != false) goto L7;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public a(Context context, com.sdk.e.a<T> aVar, c cVar) {
        super(context, aVar, cVar);
        String a;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, aVar, cVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (com.sdk.e.a) objArr2[1], (c) objArr2[2]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        if (f.c) {
            a = SDKManager.testHost;
            com.sdk.o.a.b(SDKManager.statisticalTestHost).booleanValue();
        }
        a = f.a.a.a();
        this.i = a;
    }
}
