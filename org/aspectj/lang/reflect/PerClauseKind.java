package org.aspectj.lang.reflect;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes5.dex */
public final class PerClauseKind {
    public static final /* synthetic */ PerClauseKind[] $VALUES;
    public static /* synthetic */ Interceptable $ic;
    public static final PerClauseKind PERCFLOW;
    public static final PerClauseKind PERCFLOWBELOW;
    public static final PerClauseKind PERTARGET;
    public static final PerClauseKind PERTHIS;
    public static final PerClauseKind PERTYPEWITHIN;
    public static final PerClauseKind SINGLETON;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-611258470, "Lorg/aspectj/lang/reflect/PerClauseKind;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-611258470, "Lorg/aspectj/lang/reflect/PerClauseKind;");
                return;
            }
        }
        SINGLETON = new PerClauseKind("SINGLETON", 0);
        PERTHIS = new PerClauseKind("PERTHIS", 1);
        PERTARGET = new PerClauseKind("PERTARGET", 2);
        PERCFLOW = new PerClauseKind("PERCFLOW", 3);
        PERCFLOWBELOW = new PerClauseKind("PERCFLOWBELOW", 4);
        PerClauseKind perClauseKind = new PerClauseKind("PERTYPEWITHIN", 5);
        PERTYPEWITHIN = perClauseKind;
        $VALUES = new PerClauseKind[]{SINGLETON, PERTHIS, PERTARGET, PERCFLOW, PERCFLOWBELOW, perClauseKind};
    }

    public PerClauseKind(String str, int i2) {
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

    public static PerClauseKind valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (PerClauseKind) Enum.valueOf(PerClauseKind.class, str) : (PerClauseKind) invokeL.objValue;
    }

    public static PerClauseKind[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (PerClauseKind[]) $VALUES.clone() : (PerClauseKind[]) invokeV.objValue;
    }
}
