package com.google.j2objc.annotations;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes10.dex */
public final class LoopTranslation$LoopStyle {
    public static final /* synthetic */ LoopTranslation$LoopStyle[] $VALUES;
    public static /* synthetic */ Interceptable $ic;
    public static final LoopTranslation$LoopStyle FAST_ENUMERATION;
    public static final LoopTranslation$LoopStyle JAVA_ITERATOR;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(26331119, "Lcom/google/j2objc/annotations/LoopTranslation$LoopStyle;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(26331119, "Lcom/google/j2objc/annotations/LoopTranslation$LoopStyle;");
                return;
            }
        }
        JAVA_ITERATOR = new LoopTranslation$LoopStyle("JAVA_ITERATOR", 0);
        LoopTranslation$LoopStyle loopTranslation$LoopStyle = new LoopTranslation$LoopStyle("FAST_ENUMERATION", 1);
        FAST_ENUMERATION = loopTranslation$LoopStyle;
        $VALUES = new LoopTranslation$LoopStyle[]{JAVA_ITERATOR, loopTranslation$LoopStyle};
    }

    public LoopTranslation$LoopStyle(String str, int i2) {
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

    public static LoopTranslation$LoopStyle valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (LoopTranslation$LoopStyle) Enum.valueOf(LoopTranslation$LoopStyle.class, str) : (LoopTranslation$LoopStyle) invokeL.objValue;
    }

    public static LoopTranslation$LoopStyle[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (LoopTranslation$LoopStyle[]) $VALUES.clone() : (LoopTranslation$LoopStyle[]) invokeV.objValue;
    }
}
