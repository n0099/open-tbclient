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
/* loaded from: classes7.dex */
public class u90 implements s90 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Handler a;

    /* loaded from: classes7.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ q90 a;
        public final /* synthetic */ Object b;

        public a(u90 u90Var, q90 q90Var, Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {u90Var, q90Var, obj};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = q90Var;
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

    /* loaded from: classes7.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ q90 a;
        public final /* synthetic */ Object b;

        public b(u90 u90Var, q90 q90Var, Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {u90Var, q90Var, obj};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = q90Var;
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

    /* loaded from: classes7.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ q90 a;
        public final /* synthetic */ Object b;

        public c(u90 u90Var, q90 q90Var, Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {u90Var, q90Var, obj};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = q90Var;
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

    public u90() {
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

    @Override // com.repackage.s90
    public void a(int i, Object obj, q90 q90Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048576, this, i, obj, q90Var) == null) {
            if (i == 2) {
                if (b()) {
                    q90Var.call(obj);
                } else {
                    this.a.post(new a(this, q90Var, obj));
                }
            } else if (i != 3) {
                if (i != 4) {
                    q90Var.call(obj);
                } else {
                    aa0.a(new c(this, q90Var, obj));
                }
            } else if (b()) {
                aa0.a(new b(this, q90Var, obj));
            } else {
                q90Var.call(obj);
            }
        }
    }

    public final boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? Looper.getMainLooper() == Looper.myLooper() : invokeV.booleanValue;
    }

    public synchronized void c(WeakHashMap<Object, List<r90>> weakHashMap, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, weakHashMap, obj) == null) {
            synchronized (this) {
                for (Map.Entry<Object, List<r90>> entry : weakHashMap.entrySet()) {
                    if (entry != null && entry.getValue() != null) {
                        for (r90 r90Var : entry.getValue()) {
                            if (r90Var.b(obj)) {
                                r90Var.call(obj);
                            }
                        }
                    }
                }
            }
        }
    }

    public synchronized void d(WeakHashMap<Object, List<r90>> weakHashMap, Object obj, Class<?> cls, int i, q90 q90Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{weakHashMap, obj, cls, Integer.valueOf(i), q90Var}) == null) {
            synchronized (this) {
                List<r90> list = weakHashMap.containsKey(obj) ? weakHashMap.get(obj) : null;
                if (list == null) {
                    list = new ArrayList<>();
                    weakHashMap.put(obj, list);
                }
                list.add(new r90(i, cls, q90Var, this));
            }
        }
    }

    public void e(WeakHashMap<Object, List<r90>> weakHashMap, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, weakHashMap, obj) == null) {
            List<r90> remove = weakHashMap.remove(obj);
            if (!ea0.c(remove)) {
                for (r90 r90Var : remove) {
                    r90Var.a();
                }
            }
            remove.clear();
        }
    }
}
