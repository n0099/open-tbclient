package com.win.opensdk;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes10.dex */
public class C0 implements x2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ E0 f76588a;

    public C0(E0 e0) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {e0};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f76588a = e0;
    }

    @Override // com.win.opensdk.x2
    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
        }
    }

    @Override // com.win.opensdk.x2
    public boolean a(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2)) == null) {
            E0 e0 = this.f76588a;
            if (Q1.a(e0.f76603c, e0.f76608h)) {
                this.f76588a.f76608h = System.currentTimeMillis();
                E0 e02 = this.f76588a;
                Q1.a(e02.f76601a, str, e02.f76603c, e02.f76607g, str2);
                Z0.a(this.f76588a.f76601a).a(new a1(this.f76588a.f76603c), str).a("desc", str2).a();
                PBNativeListener pBNativeListener = this.f76588a.f76606f;
                if (pBNativeListener != null) {
                    pBNativeListener.onClicked();
                }
                N.a(this.f76588a.f76603c, str2);
                return true;
            }
            return true;
        }
        return invokeLL.booleanValue;
    }
}
