package com.kwai.sodler.lib.b;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwai.sodler.lib.h;
/* loaded from: classes5.dex */
public final class c extends b<h> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(com.kwai.sodler.lib.c.b bVar) {
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

    public static h i(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) ? new h(str) : (h) invokeL.objValue;
    }

    @Override // com.kwai.sodler.lib.b.b, com.kwai.sodler.lib.a.f
    public final /* synthetic */ com.kwai.sodler.lib.a.a g(String str) {
        return i(str);
    }

    /* JADX DEBUG: Return type fixed from 'com.kwai.sodler.lib.g' to match base method */
    @Override // com.kwai.sodler.lib.b.b
    public final /* synthetic */ h h(String str) {
        return i(str);
    }
}
