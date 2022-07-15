package com.repackage;

import android.os.Handler;
import android.os.Looper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
/* loaded from: classes5.dex */
public class ba0 implements z90 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Handler a;

    /* loaded from: classes5.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ x90 a;
        public final /* synthetic */ Object b;

        public a(ba0 ba0Var, x90 x90Var, Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ba0Var, x90Var, obj};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = x90Var;
            this.b = obj;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.call(this.b);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ x90 a;
        public final /* synthetic */ Object b;

        public b(ba0 ba0Var, x90 x90Var, Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ba0Var, x90Var, obj};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = x90Var;
            this.b = obj;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.call(this.b);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ x90 a;
        public final /* synthetic */ Object b;

        public c(ba0 ba0Var, x90 x90Var, Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ba0Var, x90Var, obj};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = x90Var;
            this.b = obj;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.call(this.b);
            }
        }
    }

    public ba0() {
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
        this.a = new Handler(Looper.getMainLooper());
    }

    @Override // com.repackage.z90
    public void a(int i, Object obj, x90 x90Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048576, this, i, obj, x90Var) == null) {
            if (i == 2) {
                if (b()) {
                    x90Var.call(obj);
                } else {
                    this.a.post(new a(this, x90Var, obj));
                }
            } else if (i != 3) {
                if (i != 4) {
                    x90Var.call(obj);
                } else {
                    ha0.a(new c(this, x90Var, obj));
                }
            } else if (b()) {
                ha0.a(new b(this, x90Var, obj));
            } else {
                x90Var.call(obj);
            }
        }
    }

    public final boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? Looper.getMainLooper() == Looper.myLooper() : invokeV.booleanValue;
    }

    public synchronized void c(WeakHashMap<Object, List<y90>> weakHashMap, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, weakHashMap, obj) == null) {
            synchronized (this) {
                for (Map.Entry<Object, List<y90>> entry : weakHashMap.entrySet()) {
                    if (entry != null && entry.getValue() != null) {
                        for (y90 y90Var : entry.getValue()) {
                            if (y90Var.b(obj)) {
                                y90Var.call(obj);
                            }
                        }
                    }
                }
            }
        }
    }

    public synchronized void d(WeakHashMap<Object, List<y90>> weakHashMap, Object obj, Class<?> cls, int i, x90 x90Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{weakHashMap, obj, cls, Integer.valueOf(i), x90Var}) == null) {
            synchronized (this) {
                List<y90> list = weakHashMap.containsKey(obj) ? weakHashMap.get(obj) : null;
                if (list == null) {
                    list = new ArrayList<>();
                    weakHashMap.put(obj, list);
                }
                list.add(new y90(i, cls, x90Var, this));
            }
        }
    }

    public void e(WeakHashMap<Object, List<y90>> weakHashMap, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, weakHashMap, obj) == null) {
            List<y90> remove = weakHashMap.remove(obj);
            if (!na0.c(remove)) {
                for (y90 y90Var : remove) {
                    y90Var.a();
                }
            }
            remove.clear();
        }
    }
}
