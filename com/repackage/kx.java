package com.repackage;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Stack;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Unit;
/* loaded from: classes6.dex */
public final class kx<T> implements jx<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Stack<T> a;
    public final ReentrantLock b;

    public kx() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = new Stack<>();
        this.b = new ReentrantLock(true);
    }

    @Override // com.repackage.jx
    public void a(T t) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, t) == null) {
            ReentrantLock reentrantLock = this.b;
            reentrantLock.lock();
            try {
                this.a.push(t);
            } finally {
                reentrantLock.unlock();
            }
        }
    }

    @Override // com.repackage.jx
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            ReentrantLock reentrantLock = this.b;
            reentrantLock.lock();
            try {
                this.a.clear();
                Unit unit = Unit.INSTANCE;
            } finally {
                reentrantLock.unlock();
            }
        }
    }

    @Override // com.repackage.jx
    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            ReentrantLock reentrantLock = this.b;
            reentrantLock.lock();
            try {
                return this.a.isEmpty();
            } finally {
                reentrantLock.unlock();
            }
        }
        return invokeV.booleanValue;
    }

    @Override // com.repackage.jx
    public T a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            ReentrantLock reentrantLock = this.b;
            reentrantLock.lock();
            try {
                if (!c()) {
                    return this.a.pop();
                }
                return null;
            } finally {
                reentrantLock.unlock();
            }
        }
        return (T) invokeV.objValue;
    }
}
