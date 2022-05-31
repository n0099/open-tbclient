package com.repackage;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Comparator;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes5.dex */
public final class az5 implements Comparator<l0> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public az5() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.util.Comparator
    /* renamed from: a */
    public int compare(l0 entity1, l0 entity2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, entity1, entity2)) == null) {
            Intrinsics.checkNotNullParameter(entity1, "entity1");
            Intrinsics.checkNotNullParameter(entity2, "entity2");
            dz5 b = b06.b(entity2);
            ry5 a = b == null ? null : b.a();
            if (a == null) {
                return 0;
            }
            dz5 b2 = b06.b(entity1);
            ry5 a2 = b2 != null ? b2.a() : null;
            if (a2 == null) {
                return 0;
            }
            return a2.compareTo(a);
        }
        return invokeLL.intValue;
    }
}
