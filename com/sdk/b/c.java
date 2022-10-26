package com.sdk.b;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.LinkedHashMap;
import java.util.Map;
/* loaded from: classes8.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final LinkedHashMap a;
    public int b;
    public int c;
    public b d;

    public c(int i) {
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
        if (i <= 0) {
            throw new IllegalArgumentException("maxSize <= 0");
        }
        this.c = i;
        this.a = new LinkedHashMap(0, 0.75f, true);
        this.d = new b(0, 0.75f);
    }

    public final int a(Object obj, Object obj2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, obj, obj2)) == null) {
            int b = b(obj, obj2);
            if (b <= 0) {
                this.b = 0;
                for (Map.Entry entry : this.a.entrySet()) {
                    this.b = b(entry.getKey(), entry.getValue()) + this.b;
                }
            }
            return b;
        }
        return invokeLL.intValue;
    }

    public final Object a(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj)) == null) {
            if (obj != null) {
                synchronized (this) {
                    if (!this.d.containsKey(obj)) {
                        b(obj);
                        return null;
                    }
                    Object obj2 = this.a.get(obj);
                    if (obj2 != null) {
                        return obj2;
                    }
                    return null;
                }
            }
            throw new NullPointerException("key == null");
        }
        return invokeL.objValue;
    }

    public final Object a(Object obj, Object obj2, long j) {
        InterceptResult invokeCommon;
        Object put;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{obj, obj2, Long.valueOf(j)})) == null) {
            if (obj == null || obj2 == null) {
                throw new NullPointerException("key == null || value == null");
            }
            synchronized (this) {
                this.b += a(obj, obj2);
                put = this.a.put(obj, obj2);
                this.d.put(obj, Long.valueOf(j));
                if (put != null) {
                    this.b -= a(obj, put);
                }
            }
            a(this.c);
            return put;
        }
        return invokeCommon.objValue;
    }

    public final void a(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
            while (true) {
                synchronized (this) {
                    if (this.b <= i || this.a.isEmpty()) {
                        break;
                    }
                    Map.Entry entry = (Map.Entry) this.a.entrySet().iterator().next();
                    Object key = entry.getKey();
                    Object value = entry.getValue();
                    this.a.remove(key);
                    this.d.remove(key);
                    this.b -= a(key, value);
                }
            }
        }
    }

    public int b(Object obj, Object obj2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, obj, obj2)) == null) {
            throw null;
        }
        return invokeLL.intValue;
    }

    public final Object b(Object obj) {
        InterceptResult invokeL;
        Object remove;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, obj)) == null) {
            if (obj != null) {
                synchronized (this) {
                    remove = this.a.remove(obj);
                    this.d.remove(obj);
                    if (remove != null) {
                        this.b -= a(obj, remove);
                    }
                }
                return remove;
            }
            throw new NullPointerException("key == null");
        }
        return invokeL.objValue;
    }
}
