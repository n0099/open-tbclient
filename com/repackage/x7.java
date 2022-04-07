package com.repackage;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public abstract class x7<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final int a;
    public int b;
    public final y6<T> c;

    /* loaded from: classes7.dex */
    public interface a {
        void reset();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public x7() {
        this(16, Integer.MAX_VALUE);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr = newInitContext.callArgs;
                this(((Integer) objArr[0]).intValue(), ((Integer) objArr[1]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public void a(T t) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, t) == null) {
        }
    }

    public void b(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
            for (int i2 = 0; i2 < i; i2++) {
                y6<T> y6Var = this.c;
                if (y6Var.b < this.a) {
                    y6Var.a(d());
                }
            }
            this.b = Math.max(this.b, this.c.b);
        }
    }

    public void c(T t) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, t) == null) {
            if (t != null) {
                y6<T> y6Var = this.c;
                if (y6Var.b < this.a) {
                    y6Var.a(t);
                    this.b = Math.max(this.b, this.c.b);
                    f(t);
                    return;
                }
                a(t);
                return;
            }
            throw new IllegalArgumentException("object cannot be null.");
        }
    }

    public abstract T d();

    public T e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            y6<T> y6Var = this.c;
            return y6Var.b == 0 ? d() : y6Var.pop();
        }
        return (T) invokeV.objValue;
    }

    public void f(T t) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048581, this, t) == null) && (t instanceof a)) {
            ((a) t).reset();
        }
    }

    public x7(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i), Integer.valueOf(i2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.c = new y6<>(false, i);
        this.a = i2;
    }
}
