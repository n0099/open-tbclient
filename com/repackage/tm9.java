package com.repackage;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.win.opensdk.PBError;
import com.win.opensdk.core.Info;
/* loaded from: classes7.dex */
public class tm9 implements tp9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ jn9 a;

    public tm9(jn9 jn9Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {jn9Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = jn9Var;
    }

    @Override // com.repackage.tp9
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
        }
    }

    @Override // com.repackage.tp9
    public void a(Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj) == null) {
            Info info = (Info) obj;
            try {
                this.a.c = info;
                if (this.a.f != null) {
                    if (info == null || info.getType() != 61) {
                        this.a.f.onFail(PBError.PID_TYPE_ERROR);
                    } else if (this.a.e()) {
                        this.a.f.onLoaded();
                    }
                }
            } catch (Exception unused) {
            }
        }
    }

    @Override // com.repackage.tp9
    public void onFail(PBError pBError) {
        xn9 xn9Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, pBError) == null) || (xn9Var = this.a.f) == null) {
            return;
        }
        xn9Var.onFail(pBError);
    }
}
