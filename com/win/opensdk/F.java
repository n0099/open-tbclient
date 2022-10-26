package com.win.opensdk;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.win.opensdk.activitys.H5Activity;
/* loaded from: classes8.dex */
public class F implements E2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ H5Activity a;

    public F(H5Activity h5Activity) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {h5Activity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = h5Activity;
    }

    @Override // com.win.opensdk.E2
    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            this.a.g = str;
        }
    }

    @Override // com.win.opensdk.E2
    public boolean a(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2)) == null) {
            H5Activity h5Activity = this.a;
            if (V1.a(h5Activity.e, h5Activity.h)) {
                this.a.h = System.currentTimeMillis();
                H5Activity h5Activity2 = this.a;
                V1.a(h5Activity2.a, str, h5Activity2.e, h5Activity2.i, str2);
                e1.a(this.a.a).a(new f1(this.a.e), str).a("desc", str2).a();
                M1.a(this.a.e.getId() + this.a.f, "is_click", null);
                M.a(this.a.e, str2);
                return true;
            }
            return true;
        }
        return invokeLL.booleanValue;
    }
}
