package com.repackage;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.kw0;
/* loaded from: classes6.dex */
public class iw0<T extends kw0> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Object[] a;
    public int b;
    public int c;
    public final int d;

    public iw0(int i) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.c = 0;
        i = i <= 0 ? 2 : i;
        this.d = i;
        this.a = new Object[i];
    }

    public T a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (this.b > 0) {
                if (this.c >= this.d) {
                    dx0.j("acquire(), active player is overSize : " + this.d);
                }
                int i = this.b;
                int i2 = i - 1;
                Object[] objArr = this.a;
                T t = (T) objArr[i2];
                objArr[i2] = null;
                this.b = i - 1;
                this.c++;
                t.onInit();
                return t;
            }
            return null;
        }
        return (T) invokeV.objValue;
    }

    @Nullable
    public T b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            if (this.b > 0) {
                if (this.c >= this.d) {
                    dx0.j("acquire(" + str + "), active player is overSize : " + this.d);
                }
                int i = -1;
                for (int i2 = 0; i2 < this.b; i2++) {
                    if (((kw0) this.a[i2]).verify(str)) {
                        i = i2;
                    }
                }
                if (i != -1) {
                    this.c++;
                    Object[] objArr = this.a;
                    T t = (T) objArr[i];
                    objArr[i] = null;
                    while (true) {
                        int i3 = this.b;
                        if (i < i3 - 1) {
                            Object[] objArr2 = this.a;
                            int i4 = i + 1;
                            objArr2[i] = objArr2[i4];
                            i = i4;
                        } else {
                            this.a[i3 - 1] = null;
                            this.b = i3 - 1;
                            t.onInit();
                            return t;
                        }
                    }
                }
            }
            return null;
        }
        return (T) invokeL.objValue;
    }

    public void c(T t) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, t) == null) || e(t)) {
            return;
        }
        d(t);
        t.onInit();
    }

    public final void d(T t) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, t) == null) || e(t)) {
            return;
        }
        int i = this.b;
        Object[] objArr = this.a;
        if (i < objArr.length) {
            objArr[i] = t;
            this.b = i + 1;
            return;
        }
        int i2 = 0;
        while (true) {
            Object[] objArr2 = this.a;
            if (i2 < objArr2.length - 1) {
                int i3 = i2 + 1;
                objArr2[i2] = objArr2[i3];
                i2 = i3;
            } else {
                objArr2[this.b - 1] = t;
                return;
            }
        }
    }

    public final boolean e(T t) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, t)) == null) {
            for (int i = 0; i < this.b; i++) {
                if (this.a[i] == t) {
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public void f(@NonNull T t) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, t) == null) || e(t)) {
            return;
        }
        d(t);
        this.c--;
        t.onRelease();
    }
}
