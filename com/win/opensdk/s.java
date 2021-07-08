package com.win.opensdk;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.win.opensdk.activitys.H5Activity;
/* loaded from: classes6.dex */
public class s implements V1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ H5Activity f39650a;

    public s(H5Activity h5Activity) {
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
        this.f39650a = h5Activity;
    }

    @Override // com.win.opensdk.V1
    public boolean a(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2)) == null) {
            H5Activity h5Activity = this.f39650a;
            if (o1.a(h5Activity.f39537e, h5Activity.f39540h)) {
                this.f39650a.f39540h = System.currentTimeMillis();
                H5Activity h5Activity2 = this.f39650a;
                o1.a(h5Activity2.f39533a, str, h5Activity2.f39537e, h5Activity2.f39541i, str2);
                x0.a(this.f39650a.f39533a).a(new y0(this.f39650a.f39537e), str).a("desc", str2).a();
                f1.a(this.f39650a.f39537e.getId() + this.f39650a.f39538f, "is_click", null);
                z.a(this.f39650a.f39537e, str2);
                return true;
            }
            return true;
        }
        return invokeLL.booleanValue;
    }

    @Override // com.win.opensdk.V1
    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            this.f39650a.f39539g = str;
        }
    }
}
