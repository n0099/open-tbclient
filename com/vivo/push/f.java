package com.vivo.push;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.vivo.push.util.aa;
/* loaded from: classes7.dex */
public final class f implements Runnable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ String a;
    public final /* synthetic */ e b;

    public f(e eVar, String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {eVar, str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = eVar;
        this.a = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context context;
        Context context2;
        Context context3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            context = this.b.h;
            if (context == null || TextUtils.isEmpty(this.a)) {
                return;
            }
            context2 = this.b.h;
            context3 = this.b.h;
            if (aa.a(context2, context3.getPackageName(), this.a)) {
                this.b.i();
            }
        }
    }
}
