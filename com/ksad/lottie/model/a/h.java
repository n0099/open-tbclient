package com.ksad.lottie.model.a;

import android.graphics.Path;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes7.dex */
public class h extends n<com.ksad.lottie.model.content.h, Path> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(List<com.ksad.lottie.e.a<com.ksad.lottie.model.content.h>> list) {
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
    public com.ksad.lottie.a.b.a<com.ksad.lottie.model.content.h, Path> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? new com.ksad.lottie.a.b.l(this.f33859a) : (com.ksad.lottie.a.b.a) invokeV.objValue;
    }

    @Override // com.ksad.lottie.model.a.n
    public /* bridge */ /* synthetic */ String toString() {
        return super.toString();
    }
}
