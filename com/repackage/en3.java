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
/* loaded from: classes6.dex */
public class en3 implements hm1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public en3() {
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

    @Override // com.repackage.hm1
    public gd4 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? dn3.b().a() : (gd4) invokeV.objValue;
    }

    @Override // com.repackage.hm1
    public void b(n62 n62Var, l62 l62Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, n62Var, l62Var) == null) || l62Var == null) {
            return;
        }
        if (n62Var != null && !TextUtils.isEmpty(n62Var.a)) {
            String str = n62Var.a;
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
                    l62Var.onFail();
                    return;
                } else {
                    dn3.b().b(true, l62Var);
                    return;
                }
            } else if (n62Var.b) {
                dn3.b().b(false, l62Var);
                return;
            } else {
                dn3.b().b(true, l62Var);
                return;
            }
        }
        l62Var.onFail();
    }

    @Override // com.repackage.hm1
    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? d() || y92.d.w() || (y92.d.k(ZeusWebViewPreloadClass.ZEUS_FILE_DIR) && d72.U().s0()) : invokeV.booleanValue;
    }

    @Override // com.repackage.hm1
    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? !dn3.b().c() : invokeV.booleanValue;
    }
}
