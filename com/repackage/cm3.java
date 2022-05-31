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
public class cm3 implements fl1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public cm3() {
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

    @Override // com.repackage.fl1
    public ec4 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? bm3.b().a() : (ec4) invokeV.objValue;
    }

    @Override // com.repackage.fl1
    public void b(l52 l52Var, j52 j52Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, l52Var, j52Var) == null) || j52Var == null) {
            return;
        }
        if (l52Var != null && !TextUtils.isEmpty(l52Var.a)) {
            String str = l52Var.a;
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
                    j52Var.onFail();
                    return;
                } else {
                    bm3.b().b(true, j52Var);
                    return;
                }
            } else if (l52Var.b) {
                bm3.b().b(false, j52Var);
                return;
            } else {
                bm3.b().b(true, j52Var);
                return;
            }
        }
        j52Var.onFail();
    }

    @Override // com.repackage.fl1
    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? d() || w82.d.w() || (w82.d.k(ZeusWebViewPreloadClass.ZEUS_FILE_DIR) && b62.U().s0()) : invokeV.booleanValue;
    }

    @Override // com.repackage.fl1
    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? !bm3.b().c() : invokeV.booleanValue;
    }
}
