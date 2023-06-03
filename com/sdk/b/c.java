package com.sdk.b;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.LinkedHashMap;
import java.util.Map;
/* loaded from: classes10.dex */
public class c<K, V> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final LinkedHashMap<K, V> a;
    public int b;
    public int c;
    public b<K, Long> d;

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
        this.a = new LinkedHashMap<>(0, 0.75f, true);
        this.d = new b<>(0, 0.75f);
    }

    public final int a(K k, V v) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, k, v)) == null) {
            int b = b(k, v);
            if (b <= 0) {
                this.b = 0;
                for (Map.Entry<K, V> entry : this.a.entrySet()) {
                    this.b = b(entry.getKey(), entry.getValue()) + this.b;
                }
            }
            return b;
        }
        return invokeLL.intValue;
    }

    public final V a(K k) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, k)) == null) {
            if (k != null) {
                synchronized (this) {
                    if (!this.d.containsKey(k)) {
                        b(k);
                        return null;
                    }
                    V v = this.a.get(k);
                    if (v != null) {
                        return v;
                    }
                    return null;
                }
            }
            throw new NullPointerException("key == null");
        }
        return (V) invokeL.objValue;
    }

    public final V a(K k, V v, long j) {
        InterceptResult invokeCommon;
        V put;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{k, v, Long.valueOf(j)})) == null) {
            if (k == null || v == null) {
                throw new NullPointerException("key == null || value == null");
            }
            synchronized (this) {
                this.b += a(k, v);
                put = this.a.put(k, v);
                this.d.put(k, Long.valueOf(j));
                if (put != null) {
                    this.b -= a(k, put);
                }
            }
            a(this.c);
            return put;
        }
        return (V) invokeCommon.objValue;
    }

    public final void a(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
            while (true) {
                synchronized (this) {
                    if (this.b <= i || this.a.isEmpty()) {
                        break;
                    }
                    Map.Entry<K, V> next = this.a.entrySet().iterator().next();
                    K key = next.getKey();
                    V value = next.getValue();
                    this.a.remove(key);
                    this.d.remove((Object) key);
                    this.b -= a(key, value);
                }
            }
        }
    }

    public int b(K k, V v) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, k, v)) == null) {
            throw null;
        }
        return invokeLL.intValue;
    }

    public final V b(K k) {
        InterceptResult invokeL;
        V remove;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, k)) == null) {
            if (k != null) {
                synchronized (this) {
                    remove = this.a.remove(k);
                    this.d.remove((Object) k);
                    if (remove != null) {
                        this.b -= a(k, remove);
                    }
                }
                return remove;
            }
            throw new NullPointerException("key == null");
        }
        return (V) invokeL.objValue;
    }
}
