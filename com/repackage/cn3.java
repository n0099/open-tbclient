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
public class cn3 implements fm1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public cn3() {
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

    @Override // com.repackage.fm1
    public ed4 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? bn3.b().a() : (ed4) invokeV.objValue;
    }

    @Override // com.repackage.fm1
    public void b(l62 l62Var, j62 j62Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, l62Var, j62Var) == null) || j62Var == null) {
            return;
        }
        if (l62Var != null && !TextUtils.isEmpty(l62Var.a)) {
            String str = l62Var.a;
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
                    j62Var.onFail();
                    return;
                } else {
                    bn3.b().b(true, j62Var);
                    return;
                }
            } else if (l62Var.b) {
                bn3.b().b(false, j62Var);
                return;
            } else {
                bn3.b().b(true, j62Var);
                return;
            }
        }
        j62Var.onFail();
    }

    @Override // com.repackage.fm1
    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? d() || w92.d.w() || (w92.d.k(ZeusWebViewPreloadClass.ZEUS_FILE_DIR) && b72.U().s0()) : invokeV.booleanValue;
    }

    @Override // com.repackage.fm1
    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? !bn3.b().c() : invokeV.booleanValue;
    }
}
