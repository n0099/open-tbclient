package com.google.common.graph;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes2.dex */
public final class ElementOrder$Type {
    public static final /* synthetic */ ElementOrder$Type[] $VALUES;
    public static /* synthetic */ Interceptable $ic;
    public static final ElementOrder$Type INSERTION;
    public static final ElementOrder$Type SORTED;
    public static final ElementOrder$Type UNORDERED;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-931477864, "Lcom/google/common/graph/ElementOrder$Type;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-931477864, "Lcom/google/common/graph/ElementOrder$Type;");
                return;
            }
        }
        UNORDERED = new ElementOrder$Type("UNORDERED", 0);
        INSERTION = new ElementOrder$Type("INSERTION", 1);
        ElementOrder$Type elementOrder$Type = new ElementOrder$Type("SORTED", 2);
        SORTED = elementOrder$Type;
        $VALUES = new ElementOrder$Type[]{UNORDERED, INSERTION, elementOrder$Type};
    }

    public ElementOrder$Type(String str, int i2) {
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

    public static ElementOrder$Type valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (ElementOrder$Type) Enum.valueOf(ElementOrder$Type.class, str) : (ElementOrder$Type) invokeL.objValue;
    }

    public static ElementOrder$Type[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (ElementOrder$Type[]) $VALUES.clone() : (ElementOrder$Type[]) invokeV.objValue;
    }
}
