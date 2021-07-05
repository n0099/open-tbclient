package com.ksad.lottie.a.b;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes7.dex */
public class e extends f<Integer> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(List<com.ksad.lottie.e.a<Integer>> list) {
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
    public Integer a(com.ksad.lottie.e.a<Integer> aVar, float f2) {
        InterceptResult invokeLF;
        Integer num;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLF = interceptable.invokeLF(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar, f2)) == null) {
            if (aVar.f33774a == null || aVar.f33775b == null) {
                throw new IllegalStateException("Missing values for keyframe.");
            }
            com.ksad.lottie.e.c<A> cVar = this.f33678b;
            return (cVar == 0 || (num = (Integer) cVar.a(aVar.f33777d, aVar.f33778e.floatValue(), aVar.f33774a, aVar.f33775b, f2, c(), f())) == null) ? Integer.valueOf(com.ksad.lottie.d.e.a(aVar.f33774a.intValue(), aVar.f33775b.intValue(), f2)) : num;
        }
        return (Integer) invokeLF.objValue;
    }
}
