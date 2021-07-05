package com.kwad.sdk.core.f.a;

import android.content.Context;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class i {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Context f36104a;

    public i(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f36104a = context;
    }

    public String a() {
        InterceptResult invokeV;
        String str;
        Exception e2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            try {
                Class<?> cls = Class.forName("com.android.id.impl.IdProviderImpl");
                str = (String) cls.getMethod("getOAID", Context.class).invoke(cls.newInstance(), this.f36104a);
            } catch (Exception e3) {
                str = "";
                e2 = e3;
            }
            try {
                com.kwad.sdk.core.d.a.b("XiaomiDeviceIDHelper", "getOAID oaid:" + str);
            } catch (Exception e4) {
                e2 = e4;
                com.kwad.sdk.core.d.a.b("XiaomiDeviceIDHelper", "getOAID fail");
                com.kwad.sdk.core.d.a.b(e2);
                return str;
            }
            return str;
        }
        return (String) invokeV.objValue;
    }
}
