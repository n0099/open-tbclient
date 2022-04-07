package com.repackage;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.g5;
import com.repackage.j5;
/* loaded from: classes6.dex */
public abstract class k5<D extends j5, T extends g5<D>> extends c5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public T a;
    public D b;

    public k5() {
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

    public abstract boolean g(g5<?> g5Var);

    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: com.repackage.g5<?> */
    /* JADX WARN: Multi-variable type inference failed */
    public boolean h(g5<?> g5Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, g5Var)) == null) {
            if (g(g5Var)) {
                this.a = g5Var;
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // com.repackage.c5
    public void update() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.a.a(this.b);
        }
    }
}
