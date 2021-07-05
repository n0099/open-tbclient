package com.ksad.lottie.model.a;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes7.dex */
public class c extends n<com.ksad.lottie.model.content.c, com.ksad.lottie.model.content.c> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(List<com.ksad.lottie.e.a<com.ksad.lottie.model.content.c>> list) {
        super((List) list);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {list};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((List) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // com.ksad.lottie.model.a.m
    public com.ksad.lottie.a.b.a<com.ksad.lottie.model.content.c, com.ksad.lottie.model.content.c> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? new com.ksad.lottie.a.b.d(this.f33859a) : (com.ksad.lottie.a.b.a) invokeV.objValue;
    }

    @Override // com.ksad.lottie.model.a.n
    public /* bridge */ /* synthetic */ String toString() {
        return super.toString();
    }
}
