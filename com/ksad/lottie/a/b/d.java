package com.ksad.lottie.a.b;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes7.dex */
public class d extends f<com.ksad.lottie.model.content.c> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c  reason: collision with root package name */
    public final com.ksad.lottie.model.content.c f33683c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(List<com.ksad.lottie.e.a<com.ksad.lottie.model.content.c>> list) {
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
        com.ksad.lottie.model.content.c cVar = list.get(0).f33774a;
        int c2 = cVar != null ? cVar.c() : 0;
        this.f33683c = new com.ksad.lottie.model.content.c(new float[c2], new int[c2]);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.ksad.lottie.a.b.a
    /* renamed from: b */
    public com.ksad.lottie.model.content.c a(com.ksad.lottie.e.a<com.ksad.lottie.model.content.c> aVar, float f2) {
        InterceptResult invokeLF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLF = interceptable.invokeLF(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar, f2)) == null) {
            this.f33683c.a(aVar.f33774a, aVar.f33775b, f2);
            return this.f33683c;
        }
        return (com.ksad.lottie.model.content.c) invokeLF.objValue;
    }
}
