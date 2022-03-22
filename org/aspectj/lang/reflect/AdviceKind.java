package org.aspectj.lang.reflect;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes8.dex */
public final class AdviceKind {
    public static final /* synthetic */ AdviceKind[] $VALUES;
    public static /* synthetic */ Interceptable $ic;
    public static final AdviceKind AFTER;
    public static final AdviceKind AFTER_RETURNING;
    public static final AdviceKind AFTER_THROWING;
    public static final AdviceKind AROUND;
    public static final AdviceKind BEFORE;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1442506608, "Lorg/aspectj/lang/reflect/AdviceKind;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1442506608, "Lorg/aspectj/lang/reflect/AdviceKind;");
                return;
            }
        }
        BEFORE = new AdviceKind("BEFORE", 0);
        AFTER = new AdviceKind("AFTER", 1);
        AFTER_RETURNING = new AdviceKind("AFTER_RETURNING", 2);
        AFTER_THROWING = new AdviceKind("AFTER_THROWING", 3);
        AdviceKind adviceKind = new AdviceKind("AROUND", 4);
        AROUND = adviceKind;
        $VALUES = new AdviceKind[]{BEFORE, AFTER, AFTER_RETURNING, AFTER_THROWING, adviceKind};
    }

    public AdviceKind(String str, int i) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Integer.valueOf(i)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                String str2 = (String) objArr2[0];
                ((Integer) objArr2[1]).intValue();
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static AdviceKind valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (AdviceKind) Enum.valueOf(AdviceKind.class, str) : (AdviceKind) invokeL.objValue;
    }

    public static AdviceKind[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (AdviceKind[]) $VALUES.clone() : (AdviceKind[]) invokeV.objValue;
    }
}
