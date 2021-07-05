package com.google.common.graph;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes7.dex */
public final class Traverser$Order {
    public static final /* synthetic */ Traverser$Order[] $VALUES;
    public static /* synthetic */ Interceptable $ic;
    public static final Traverser$Order POSTORDER;
    public static final Traverser$Order PREORDER;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1254766810, "Lcom/google/common/graph/Traverser$Order;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1254766810, "Lcom/google/common/graph/Traverser$Order;");
                return;
            }
        }
        PREORDER = new Traverser$Order("PREORDER", 0);
        Traverser$Order traverser$Order = new Traverser$Order("POSTORDER", 1);
        POSTORDER = traverser$Order;
        $VALUES = new Traverser$Order[]{PREORDER, traverser$Order};
    }

    public Traverser$Order(String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                String str2 = (String) objArr2[0];
                ((Integer) objArr2[1]).intValue();
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static Traverser$Order valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (Traverser$Order) Enum.valueOf(Traverser$Order.class, str) : (Traverser$Order) invokeL.objValue;
    }

    public static Traverser$Order[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (Traverser$Order[]) $VALUES.clone() : (Traverser$Order[]) invokeV.objValue;
    }
}
