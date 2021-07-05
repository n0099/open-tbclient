package com.ksad.lottie.model.content;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.ksad.lottie.a.a.p;
/* loaded from: classes7.dex */
public class k implements b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final String f33945a;

    /* renamed from: b  reason: collision with root package name */
    public final int f33946b;

    /* renamed from: c  reason: collision with root package name */
    public final com.ksad.lottie.model.a.h f33947c;

    public k(String str, int i2, com.ksad.lottie.model.a.h hVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Integer.valueOf(i2), hVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f33945a = str;
        this.f33946b = i2;
        this.f33947c = hVar;
    }

    @Override // com.ksad.lottie.model.content.b
    public com.ksad.lottie.a.a.b a(com.ksad.lottie.f fVar, com.ksad.lottie.model.layer.a aVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, fVar, aVar)) == null) ? new p(fVar, aVar, this) : (com.ksad.lottie.a.a.b) invokeLL.objValue;
    }

    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f33945a : (String) invokeV.objValue;
    }

    public com.ksad.lottie.model.a.h b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f33947c : (com.ksad.lottie.model.a.h) invokeV.objValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return "ShapePath{name=" + this.f33945a + ", index=" + this.f33946b + '}';
        }
        return (String) invokeV.objValue;
    }
}
