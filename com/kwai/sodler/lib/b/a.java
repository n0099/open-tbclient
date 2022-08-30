package com.kwai.sodler.lib.b;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public final class a extends b<com.kwai.sodler.lib.kwai.a> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(com.kwai.sodler.lib.c.b bVar) {
        super(bVar);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((com.kwai.sodler.lib.c.b) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public static com.kwai.sodler.lib.kwai.a fd(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) ? new com.kwai.sodler.lib.kwai.a(str) : (com.kwai.sodler.lib.kwai.a) invokeL.objValue;
    }

    @Override // com.kwai.sodler.lib.b.b, com.kwai.sodler.lib.a.f
    public final /* synthetic */ com.kwai.sodler.lib.a.a fb(String str) {
        return fd(str);
    }

    /* JADX DEBUG: Return type fixed from 'com.kwai.sodler.lib.g' to match base method */
    @Override // com.kwai.sodler.lib.b.b
    public final /* synthetic */ com.kwai.sodler.lib.kwai.a fe(String str) {
        return fd(str);
    }
}
