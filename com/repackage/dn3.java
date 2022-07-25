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
/* loaded from: classes5.dex */
public class dn3 implements gm1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public dn3() {
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

    @Override // com.repackage.gm1
    public fd4 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? cn3.b().a() : (fd4) invokeV.objValue;
    }

    @Override // com.repackage.gm1
    public void b(m62 m62Var, k62 k62Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, m62Var, k62Var) == null) || k62Var == null) {
            return;
        }
        if (m62Var != null && !TextUtils.isEmpty(m62Var.a)) {
            String str = m62Var.a;
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
                    k62Var.onFail();
                    return;
                } else {
                    cn3.b().b(true, k62Var);
                    return;
                }
            } else if (m62Var.b) {
                cn3.b().b(false, k62Var);
                return;
            } else {
                cn3.b().b(true, k62Var);
                return;
            }
        }
        k62Var.onFail();
    }

    @Override // com.repackage.gm1
    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? d() || x92.d.w() || (x92.d.k(ZeusWebViewPreloadClass.ZEUS_FILE_DIR) && c72.U().s0()) : invokeV.booleanValue;
    }

    @Override // com.repackage.gm1
    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? !cn3.b().c() : invokeV.booleanValue;
    }
}
