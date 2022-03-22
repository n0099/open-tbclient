package com.vivo.push.c;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.vivo.push.sdk.PushMessageCallback;
/* loaded from: classes7.dex */
public final class e implements Runnable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ String a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ com.vivo.push.b.i f43862b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ d f43863c;

    public e(d dVar, String str, com.vivo.push.b.i iVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {dVar, str, iVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f43863c = dVar;
        this.a = str;
        this.f43862b = iVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context context;
        Context context2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            if (!TextUtils.isEmpty(this.a)) {
                d dVar = this.f43863c;
                PushMessageCallback pushMessageCallback = ((z) dVar).f43881b;
                context2 = dVar.a;
                pushMessageCallback.onReceiveRegId(context2, this.a);
            }
            d dVar2 = this.f43863c;
            PushMessageCallback pushMessageCallback2 = ((z) dVar2).f43881b;
            context = dVar2.a;
            pushMessageCallback2.onBind(context, this.f43862b.h(), this.f43862b.d());
        }
    }
}
