package com.vivo.push.c;

import android.content.Context;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.vivo.push.sdk.PushMessageCallback;
/* loaded from: classes7.dex */
public final class m implements Runnable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ com.vivo.push.b.o f42121a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ l f42122b;

    public m(l lVar, com.vivo.push.b.o oVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {lVar, oVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f42122b = lVar;
        this.f42121a = oVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context context;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            l lVar = this.f42122b;
            PushMessageCallback pushMessageCallback = ((ab) lVar).f42095b;
            context = lVar.f42277a;
            pushMessageCallback.onListTags(context, this.f42121a.h(), this.f42121a.d(), this.f42121a.g());
        }
    }
}
