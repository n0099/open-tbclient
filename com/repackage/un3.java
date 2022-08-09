package com.repackage;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pyramid.annotation.Service;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.ZeusWebViewPreloadClass;
@Service
/* loaded from: classes7.dex */
public class un3 implements xm1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public un3() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @Override // com.repackage.xm1
    public wd4 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? tn3.b().a() : (wd4) invokeV.objValue;
    }

    @Override // com.repackage.xm1
    public void b(d72 d72Var, b72 b72Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, d72Var, b72Var) == null) || b72Var == null) {
            return;
        }
        if (d72Var != null && !TextUtils.isEmpty(d72Var.a)) {
            String str = d72Var.a;
            char c = 65535;
            int hashCode = str.hashCode();
            if (hashCode != 1195918653) {
                if (hashCode == 1825003424 && str.equals("by_click")) {
                    c = 0;
                }
            } else if (str.equals("by_silent")) {
                c = 1;
            }
            if (c != 0) {
                if (c != 1) {
                    b72Var.onFail();
                    return;
                } else {
                    tn3.b().b(true, b72Var);
                    return;
                }
            } else if (d72Var.b) {
                tn3.b().b(false, b72Var);
                return;
            } else {
                tn3.b().b(true, b72Var);
                return;
            }
        }
        b72Var.onFail();
    }

    @Override // com.repackage.xm1
    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? d() || oa2.d.w() || (oa2.d.k(ZeusWebViewPreloadClass.ZEUS_FILE_DIR) && t72.U().s0()) : invokeV.booleanValue;
    }

    @Override // com.repackage.xm1
    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? !tn3.b().c() : invokeV.booleanValue;
    }
}
