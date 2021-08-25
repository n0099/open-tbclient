package com.win.opensdk;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.win.opensdk.core.Info;
/* loaded from: classes10.dex */
public class u1 implements n1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ A1 f77002a;

    public u1(A1 a1) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {a1};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f77002a = a1;
    }

    @Override // com.win.opensdk.n1
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
        }
    }

    @Override // com.win.opensdk.n1
    public void a(Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj) == null) {
            Info info = (Info) obj;
            try {
                this.f77002a.f76576c = info;
                if (this.f77002a.f76579f != null) {
                    if (info == null || info.getType() != 51) {
                        this.f77002a.f76579f.onFail(PBError.PID_TYPE_ERROR);
                    } else if (this.f77002a.b()) {
                        this.f77002a.f76579f.onLoaded();
                    }
                }
            } catch (Exception unused) {
            }
        }
    }

    @Override // com.win.opensdk.n1
    public void onFail(PBError pBError) {
        F f2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, pBError) == null) || (f2 = this.f77002a.f76579f) == null) {
            return;
        }
        f2.onFail(pBError);
    }
}
