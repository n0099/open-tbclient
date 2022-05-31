package com.repackage;

import android.os.Handler;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Collection;
/* loaded from: classes7.dex */
public final class zd3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public static class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ae3 a;
        public final /* synthetic */ Object b;

        public a(ae3 ae3Var, Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ae3Var, obj};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ae3Var;
            this.b = obj;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.onCallback(this.b);
            }
        }
    }

    public static <T> void a(Handler handler, ae3<T> ae3Var, Collection<T> collection) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65536, null, handler, ae3Var, collection) == null) || ae3Var == null || collection == null || collection.isEmpty()) {
            return;
        }
        for (T t : collection) {
            e(handler, ae3Var, t);
        }
    }

    public static <T> void b(Handler handler, ae3<T> ae3Var, T... tArr) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65537, null, handler, ae3Var, tArr) == null) || ae3Var == null || tArr == null || tArr.length < 1) {
            return;
        }
        for (T t : tArr) {
            e(handler, ae3Var, t);
        }
    }

    public static <T> void c(ae3<T> ae3Var, Collection<T> collection) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, ae3Var, collection) == null) {
            a(null, ae3Var, collection);
        }
    }

    public static <T> void d(ae3<T> ae3Var, T... tArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, ae3Var, tArr) == null) {
            b(null, ae3Var, tArr);
        }
    }

    public static <T> void e(Handler handler, ae3<T> ae3Var, T t) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, handler, ae3Var, t) == null) {
            if (handler == null) {
                ae3Var.onCallback(t);
            } else {
                handler.post(new a(ae3Var, t));
            }
        }
    }
}
