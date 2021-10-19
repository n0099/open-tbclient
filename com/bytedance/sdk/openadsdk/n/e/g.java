package com.bytedance.sdk.openadsdk.n.e;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.component.adnet.core.Header;
import com.bytedance.sdk.component.adnet.core.HttpResponse;
import com.bytedance.sdk.openadsdk.n.i;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes9.dex */
public class g extends a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c  reason: collision with root package name */
    public HttpResponse f68585c;

    public g(HttpResponse httpResponse, f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {httpResponse, fVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f68585c = httpResponse;
        this.f68576a = new ArrayList();
        for (int i4 = 0; i4 < this.f68585c.getHeaders().size(); i4++) {
            Header header = this.f68585c.getHeaders().get(i4);
            if (header != null) {
                this.f68576a.add(new i.b(header.getName(), header.getValue()));
            }
        }
        this.f68577b = fVar;
    }

    @Override // com.bytedance.sdk.openadsdk.n.e.a
    public int a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f68585c.getStatusCode() : invokeV.intValue;
    }

    @Override // com.bytedance.sdk.openadsdk.n.e.a
    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f68585c.getStatusCode() >= 200 && this.f68585c.getStatusCode() < 300 : invokeV.booleanValue;
    }

    @Override // com.bytedance.sdk.openadsdk.n.e.a
    public List<i.b> c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f68576a : (List) invokeV.objValue;
    }

    @Override // com.bytedance.sdk.openadsdk.n.e.a
    public InputStream d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f68585c.getContent() : (InputStream) invokeV.objValue;
    }

    @Override // com.bytedance.sdk.openadsdk.n.e.a
    public String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? "http/1.1" : (String) invokeV.objValue;
    }

    @Override // com.bytedance.sdk.openadsdk.n.e.a
    public String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? a(this.f68585c.getStatusCode()) : (String) invokeV.objValue;
    }

    @Override // com.bytedance.sdk.openadsdk.n.e.a
    public String a(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2)) == null) ? a(str) != null ? a(str).f68663b : str2 : (String) invokeLL.objValue;
    }
}
