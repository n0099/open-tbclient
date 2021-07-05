package com.kuaishou.aegon.httpdns;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kuaishou.aegon.a.a;
import java.util.List;
/* loaded from: classes7.dex */
public final /* synthetic */ class b implements a.InterfaceC0400a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final String f34023a;

    public b(String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f34023a = str;
    }

    public static a.InterfaceC0400a a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) ? new b(str) : (a.InterfaceC0400a) invokeL.objValue;
    }

    @Override // com.kuaishou.aegon.a.a.InterfaceC0400a
    public Object get() {
        InterceptResult invokeV;
        List nativeResolve;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            nativeResolve = HttpDnsResolver.nativeResolve(this.f34023a);
            return nativeResolve;
        }
        return invokeV.objValue;
    }
}
