package com.sdk.mobile.b;

import android.os.Handler;
import android.os.Looper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.sdk.base.framework.a.f;
/* loaded from: classes6.dex */
public final class e implements Runnable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Handler f38467a;

    /* renamed from: b  reason: collision with root package name */
    public long f38468b;

    /* renamed from: c  reason: collision with root package name */
    public /* synthetic */ a f38469c;

    public e(a aVar, long j) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {aVar, Long.valueOf(j)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f38469c = aVar;
        this.f38467a = new Handler(Looper.getMainLooper());
        this.f38468b = j;
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f38467a.postDelayed(this, this.f38468b);
        }
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f38467a.removeCallbacks(this);
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        f fVar;
        String str;
        Boolean bool;
        f fVar2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            fVar = this.f38469c.f38447f;
            if (fVar != null) {
                str = a.f38442a;
                bool = a.f38443b;
                com.sdk.base.framework.a.a.c.c(str, "超时，已取消请求", bool);
                fVar2 = this.f38469c.f38447f;
                fVar2.a();
            }
            this.f38469c.a(1, "超时", 101005, null, com.sdk.base.framework.f.f.a.b().a());
        }
    }
}
