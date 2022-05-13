package com.repackage;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.win.opensdk.PBNativeListener;
/* loaded from: classes5.dex */
public class dn9 implements rn9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ ln9 a;

    public dn9(ln9 ln9Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {ln9Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = ln9Var;
    }

    @Override // com.repackage.rn9
    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
        }
    }

    @Override // com.repackage.rn9
    public boolean a(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2)) == null) {
            ln9 ln9Var = this.a;
            if (vp9.d(ln9Var.c, ln9Var.h)) {
                this.a.h = System.currentTimeMillis();
                ln9 ln9Var2 = this.a;
                vp9.a(ln9Var2.a, str, ln9Var2.c, ln9Var2.g, str2);
                tq9 a = xq9.a(this.a.a);
                a.h(new br9(this.a.c), str);
                a.l("desc", str2);
                a.m();
                PBNativeListener pBNativeListener = this.a.f;
                if (pBNativeListener != null) {
                    pBNativeListener.onClicked();
                }
                ro9.p(this.a.c, str2);
                return true;
            }
            return true;
        }
        return invokeLL.booleanValue;
    }
}
