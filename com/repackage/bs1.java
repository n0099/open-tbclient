package com.repackage;

import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.api.pending.queue.operation.BasePendingOperation;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
/* loaded from: classes5.dex */
public class bs1 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean b;
    public transient /* synthetic */ FieldHolder $fh;
    public HashMap<String, ur1> a;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755816527, "Lcom/repackage/bs1;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755816527, "Lcom/repackage/bs1;");
                return;
            }
        }
        b = rg1.a;
    }

    public bs1() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = new LinkedHashMap();
    }

    public synchronized void a(BasePendingOperation basePendingOperation) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, basePendingOperation) == null) {
            synchronized (this) {
                if (basePendingOperation == null) {
                    return;
                }
                if (b) {
                    Log.d("PendingOperationHandler", "*************** 【Add pending module】:" + basePendingOperation.b() + " params: " + basePendingOperation.c());
                }
                c(basePendingOperation.getType()).b(basePendingOperation);
            }
        }
    }

    public synchronized void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            synchronized (this) {
                for (Map.Entry<String, ur1> entry : this.a.entrySet()) {
                    entry.getValue().c();
                }
                this.a.clear();
            }
        }
    }

    public final ur1 c(BasePendingOperation.OperationType operationType) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, operationType)) == null) {
            if (!this.a.containsKey(operationType.name())) {
                ur1 a = yr1.a(operationType);
                this.a.put(operationType.name(), a);
                return a;
            }
            return this.a.get(operationType.name());
        }
        return (ur1) invokeL.objValue;
    }

    public synchronized void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            synchronized (this) {
                for (Map.Entry<String, ur1> entry : this.a.entrySet()) {
                    entry.getValue().a();
                }
            }
        }
    }
}
