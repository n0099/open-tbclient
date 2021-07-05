package com.ksad.lottie.model.content;

import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.ksad.lottie.a.a.o;
import com.ksad.lottie.model.a.l;
/* loaded from: classes7.dex */
public class g implements b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final String f33931a;

    /* renamed from: b  reason: collision with root package name */
    public final com.ksad.lottie.model.a.b f33932b;

    /* renamed from: c  reason: collision with root package name */
    public final com.ksad.lottie.model.a.b f33933c;

    /* renamed from: d  reason: collision with root package name */
    public final l f33934d;

    public g(String str, com.ksad.lottie.model.a.b bVar, com.ksad.lottie.model.a.b bVar2, l lVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, bVar, bVar2, lVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f33931a = str;
        this.f33932b = bVar;
        this.f33933c = bVar2;
        this.f33934d = lVar;
    }

    @Override // com.ksad.lottie.model.content.b
    @Nullable
    public com.ksad.lottie.a.a.b a(com.ksad.lottie.f fVar, com.ksad.lottie.model.layer.a aVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, fVar, aVar)) == null) ? new o(fVar, aVar, this) : (com.ksad.lottie.a.a.b) invokeLL.objValue;
    }

    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f33931a : (String) invokeV.objValue;
    }

    public com.ksad.lottie.model.a.b b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f33932b : (com.ksad.lottie.model.a.b) invokeV.objValue;
    }

    public com.ksad.lottie.model.a.b c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f33933c : (com.ksad.lottie.model.a.b) invokeV.objValue;
    }

    public l d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f33934d : (l) invokeV.objValue;
    }
}
