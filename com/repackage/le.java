package com.repackage;

import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.te;
/* loaded from: classes6.dex */
public abstract class le<T> implements se<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final boolean a;
    public final me b;

    public le(me meVar, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {meVar, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = meVar;
        this.a = z;
    }

    @Override // com.repackage.se
    public T a(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, str, str2)) == null) {
            oe<T> k = k(str, str2);
            if (k == null) {
                return null;
            }
            return k.b;
        }
        return (T) invokeLL.objValue;
    }

    @Override // com.repackage.se
    public me c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.b : (me) invokeV.objValue;
    }

    @Override // com.repackage.se
    public void d(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, str2) == null) {
            l(h(str, str2));
        }
    }

    @Override // com.repackage.se
    public te.b<T> e(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, str, str2)) == null) {
            oe<T> k = k(str, str2);
            if (k == null) {
                return null;
            }
            te.b<T> bVar = new te.b<>();
            bVar.a = str2;
            bVar.b = k.b;
            long j = k.f;
            bVar.c = k.d;
            return bVar;
        }
        return (te.b) invokeLL.objValue;
    }

    @Override // com.repackage.se
    public void f(String str, String str2, T t, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{str, str2, t, Long.valueOf(j)}) == null) {
            oe<T> oeVar = new oe<>();
            oeVar.a = h(str, str2);
            oeVar.c = str;
            oeVar.f = j;
            oeVar.b = t;
            oeVar.e = System.currentTimeMillis();
            oeVar.d = System.currentTimeMillis();
            j(oeVar);
        }
    }

    public String h(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, str, str2)) == null) {
            if (this.a) {
                return str + "@" + str2;
            }
            return str2;
        }
        return (String) invokeLL.objValue;
    }

    public abstract oe<T> i(String str);

    public abstract void j(oe<T> oeVar);

    public oe<T> k(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, str2)) == null) {
            String h = h(str, str2);
            oe<T> i = i(h);
            if (i == null) {
                BdLog.isDebugMode();
                return null;
            } else if (i.f < System.currentTimeMillis()) {
                m(h);
                BdLog.isDebugMode();
                return null;
            } else {
                if (this.b.a()) {
                    i.e = System.currentTimeMillis();
                    j(i);
                }
                BdLog.isDebugMode();
                return i;
            }
        }
        return (oe) invokeLL.objValue;
    }

    public abstract void l(String str);

    public abstract void m(String str);
}
