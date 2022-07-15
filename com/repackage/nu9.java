package com.repackage;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import rx.internal.util.atomic.LinkedQueueNode;
/* loaded from: classes6.dex */
public abstract class nu9<E> extends pu9<E> {
    public static /* synthetic */ Interceptable $ic;
    public static final long b;
    public transient /* synthetic */ FieldHolder $fh;
    public LinkedQueueNode<E> consumerNode;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755456865, "Lcom/repackage/nu9;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755456865, "Lcom/repackage/nu9;");
                return;
            }
        }
        b = rv9.a(nu9.class, "consumerNode");
    }

    public nu9() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public final LinkedQueueNode<E> d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? (LinkedQueueNode) rv9.a.f(this, b) : (LinkedQueueNode) invokeV.objValue;
    }

    public final void e(LinkedQueueNode<E> linkedQueueNode) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, linkedQueueNode) == null) {
            this.consumerNode = linkedQueueNode;
        }
    }
}
