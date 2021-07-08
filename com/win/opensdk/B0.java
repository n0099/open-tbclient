package com.win.opensdk;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class B0 implements r0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C0 f39325a;

    public B0(C0 c0) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {c0};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f39325a = c0;
    }

    @Override // com.win.opensdk.r0
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
        }
    }

    @Override // com.win.opensdk.r0
    public void a(int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str) == null) {
            D0 d0 = this.f39325a.f39330a;
            long currentTimeMillis = System.currentTimeMillis();
            D0 d02 = this.f39325a.f39330a;
            d0.f39345c = currentTimeMillis - d02.f39344b;
            x0.a(d02.f39343a).a(i2, this.f39325a.f39330a.f39345c).a();
        }
    }

    @Override // com.win.opensdk.r0
    public void a(Object obj) {
        long j;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, obj) == null) {
            D0 d0 = this.f39325a.f39330a;
            long currentTimeMillis = System.currentTimeMillis();
            j = this.f39325a.f39330a.f39344b;
            d0.f39345c = currentTimeMillis - j;
            this.f39325a.f39330a.a((R0) obj);
        }
    }
}
