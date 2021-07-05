package com.ksad.lottie.a.b;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes7.dex */
public class k extends f<com.ksad.lottie.e.d> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k(List<com.ksad.lottie.e.a<com.ksad.lottie.e.d>> list) {
        super(list);
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

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.ksad.lottie.a.b.a
    /* renamed from: b */
    public com.ksad.lottie.e.d a(com.ksad.lottie.e.a<com.ksad.lottie.e.d> aVar, float f2) {
        InterceptResult invokeLF;
        com.ksad.lottie.e.d dVar;
        com.ksad.lottie.e.d dVar2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLF = interceptable.invokeLF(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar, f2)) == null) {
            com.ksad.lottie.e.d dVar3 = aVar.f33774a;
            if (dVar3 == null || (dVar = aVar.f33775b) == null) {
                throw new IllegalStateException("Missing values for keyframe.");
            }
            com.ksad.lottie.e.d dVar4 = dVar3;
            com.ksad.lottie.e.d dVar5 = dVar;
            com.ksad.lottie.e.c<A> cVar = this.f33678b;
            return (cVar == 0 || (dVar2 = (com.ksad.lottie.e.d) cVar.a(aVar.f33777d, aVar.f33778e.floatValue(), dVar4, dVar5, f2, c(), f())) == null) ? new com.ksad.lottie.e.d(com.ksad.lottie.d.e.a(dVar4.a(), dVar5.a(), f2), com.ksad.lottie.d.e.a(dVar4.b(), dVar5.b(), f2)) : dVar2;
        }
        return (com.ksad.lottie.e.d) invokeLF.objValue;
    }
}
