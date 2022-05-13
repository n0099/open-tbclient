package com.repackage;

import android.os.Handler;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Collection;
/* loaded from: classes6.dex */
public final class mf3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public static class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ nf3 a;
        public final /* synthetic */ Object b;

        public a(nf3 nf3Var, Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nf3Var, obj};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = nf3Var;
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

    public static <T> void a(Handler handler, nf3<T> nf3Var, Collection<T> collection) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65536, null, handler, nf3Var, collection) == null) || nf3Var == null || collection == null || collection.isEmpty()) {
            return;
        }
        for (T t : collection) {
            e(handler, nf3Var, t);
        }
    }

    public static <T> void b(Handler handler, nf3<T> nf3Var, T... tArr) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65537, null, handler, nf3Var, tArr) == null) || nf3Var == null || tArr == null || tArr.length < 1) {
            return;
        }
        for (T t : tArr) {
            e(handler, nf3Var, t);
        }
    }

    public static <T> void c(nf3<T> nf3Var, Collection<T> collection) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, nf3Var, collection) == null) {
            a(null, nf3Var, collection);
        }
    }

    public static <T> void d(nf3<T> nf3Var, T... tArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, nf3Var, tArr) == null) {
            b(null, nf3Var, tArr);
        }
    }

    public static <T> void e(Handler handler, nf3<T> nf3Var, T t) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, handler, nf3Var, t) == null) {
            if (handler == null) {
                nf3Var.onCallback(t);
            } else {
                handler.post(new a(nf3Var, t));
            }
        }
    }
}
