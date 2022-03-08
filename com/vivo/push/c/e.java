package com.vivo.push.c;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.vivo.push.sdk.PushMessageCallback;
/* loaded from: classes8.dex */
public final class e implements Runnable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ String a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ com.vivo.push.b.i f59227b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ d f59228c;

    public e(d dVar, String str, com.vivo.push.b.i iVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {dVar, str, iVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f59228c = dVar;
        this.a = str;
        this.f59227b = iVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context context;
        Context context2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            if (!TextUtils.isEmpty(this.a)) {
                d dVar = this.f59228c;
                PushMessageCallback pushMessageCallback = ((z) dVar).f59246b;
                context2 = dVar.a;
                pushMessageCallback.onReceiveRegId(context2, this.a);
            }
            d dVar2 = this.f59228c;
            PushMessageCallback pushMessageCallback2 = ((z) dVar2).f59246b;
            context = dVar2.a;
            pushMessageCallback2.onBind(context, this.f59227b.h(), this.f59227b.d());
        }
    }
}
