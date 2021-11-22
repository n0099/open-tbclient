package com.vivo.push.c;

import android.content.Context;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.vivo.push.model.UnvarnishedMessage;
import com.vivo.push.sdk.PushMessageCallback;
/* loaded from: classes2.dex */
public final class q implements Runnable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ UnvarnishedMessage f71195a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ p f71196b;

    public q(p pVar, UnvarnishedMessage unvarnishedMessage) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {pVar, unvarnishedMessage};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f71196b = pVar;
        this.f71195a = unvarnishedMessage;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context context;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            p pVar = this.f71196b;
            PushMessageCallback pushMessageCallback = ((ab) pVar).f71165b;
            context = pVar.f71347a;
            pushMessageCallback.onTransmissionMessage(context, this.f71195a);
        }
    }
}
