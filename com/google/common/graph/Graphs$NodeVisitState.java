package com.google.common.graph;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes6.dex */
public final class Graphs$NodeVisitState {
    public static final /* synthetic */ Graphs$NodeVisitState[] $VALUES;
    public static /* synthetic */ Interceptable $ic;
    public static final Graphs$NodeVisitState COMPLETE;
    public static final Graphs$NodeVisitState PENDING;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(776795421, "Lcom/google/common/graph/Graphs$NodeVisitState;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(776795421, "Lcom/google/common/graph/Graphs$NodeVisitState;");
                return;
            }
        }
        PENDING = new Graphs$NodeVisitState("PENDING", 0);
        Graphs$NodeVisitState graphs$NodeVisitState = new Graphs$NodeVisitState("COMPLETE", 1);
        COMPLETE = graphs$NodeVisitState;
        $VALUES = new Graphs$NodeVisitState[]{PENDING, graphs$NodeVisitState};
    }

    public Graphs$NodeVisitState(String str, int i2) {
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

    public static Graphs$NodeVisitState valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (Graphs$NodeVisitState) Enum.valueOf(Graphs$NodeVisitState.class, str) : (Graphs$NodeVisitState) invokeL.objValue;
    }

    public static Graphs$NodeVisitState[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (Graphs$NodeVisitState[]) $VALUES.clone() : (Graphs$NodeVisitState[]) invokeV.objValue;
    }
}
