package com.win.opensdk;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.win.opensdk.activitys.H5Activity;
/* loaded from: classes10.dex */
public class G implements x2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ H5Activity f76795a;

    public G(H5Activity h5Activity) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {h5Activity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f76795a = h5Activity;
    }

    @Override // com.win.opensdk.x2
    public boolean a(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2)) == null) {
            H5Activity h5Activity = this.f76795a;
            if (Q1.a(h5Activity.f76954e, h5Activity.f76957h)) {
                this.f76795a.f76957h = System.currentTimeMillis();
                H5Activity h5Activity2 = this.f76795a;
                Q1.a(h5Activity2.f76950a, str, h5Activity2.f76954e, h5Activity2.f76958i, str2);
                Z0.a(this.f76795a.f76950a).a(new a1(this.f76795a.f76954e), str).a("desc", str2).a();
                H1.a(this.f76795a.f76954e.getId() + this.f76795a.f76955f, "is_click", null);
                N.a(this.f76795a.f76954e, str2);
                return true;
            }
            return true;
        }
        return invokeLL.booleanValue;
    }

    @Override // com.win.opensdk.x2
    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            this.f76795a.f76956g = str;
        }
    }
}
