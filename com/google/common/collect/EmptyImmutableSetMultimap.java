package com.google.common.collect;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Comparator;
/* loaded from: classes10.dex */
public class EmptyImmutableSetMultimap extends ImmutableSetMultimap<Object, Object> {
    public static /* synthetic */ Interceptable $ic;
    public static final EmptyImmutableSetMultimap INSTANCE;
    public static final long serialVersionUID = 0;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1254667192, "Lcom/google/common/collect/EmptyImmutableSetMultimap;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1254667192, "Lcom/google/common/collect/EmptyImmutableSetMultimap;");
                return;
            }
        }
        INSTANCE = new EmptyImmutableSetMultimap();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EmptyImmutableSetMultimap() {
        super(ImmutableMap.of(), 0, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr = newInitContext.callArgs;
                super((ImmutableMap) objArr[0], ((Integer) objArr[1]).intValue(), (Comparator) objArr[2]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    private Object readResolve() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, this)) == null) ? INSTANCE : invokeV.objValue;
    }
}
