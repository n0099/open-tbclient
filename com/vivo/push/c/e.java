package com.vivo.push.c;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.vivo.push.sdk.PushMessageCallback;
/* loaded from: classes6.dex */
public final class e implements Runnable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f39122a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ com.vivo.push.b.k f39123b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ d f39124c;

    public e(d dVar, String str, com.vivo.push.b.k kVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {dVar, str, kVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f39124c = dVar;
        this.f39122a = str;
        this.f39123b = kVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context context;
        Context context2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            if (!TextUtils.isEmpty(this.f39122a)) {
                d dVar = this.f39124c;
                PushMessageCallback pushMessageCallback = ((ab) dVar).f39109b;
                context2 = dVar.f39291a;
                pushMessageCallback.onReceiveRegId(context2, this.f39122a);
            }
            d dVar2 = this.f39124c;
            PushMessageCallback pushMessageCallback2 = ((ab) dVar2).f39109b;
            context = dVar2.f39291a;
            pushMessageCallback2.onBind(context, this.f39123b.h(), this.f39123b.d());
        }
    }
}
