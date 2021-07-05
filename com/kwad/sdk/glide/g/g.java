package com.kwad.sdk.glide.g;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
/* loaded from: classes7.dex */
public class g<T, Y> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final Map<T, Y> f37765a;

    /* renamed from: b  reason: collision with root package name */
    public final long f37766b;

    /* renamed from: c  reason: collision with root package name */
    public long f37767c;

    /* renamed from: d  reason: collision with root package name */
    public long f37768d;

    public g(long j) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Long.valueOf(j)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f37765a = new LinkedHashMap(100, 0.75f, true);
        this.f37766b = j;
        this.f37767c = j;
    }

    private void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65537, this) == null) {
            a(this.f37767c);
        }
    }

    public int a(@Nullable Y y) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, y)) == null) {
            return 1;
        }
        return invokeL.intValue;
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            a(0L);
        }
    }

    public synchronized void a(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(Constants.METHOD_SEND_USER_MSG, this, j) == null) {
            synchronized (this) {
                while (this.f37768d > j) {
                    Iterator<Map.Entry<T, Y>> it = this.f37765a.entrySet().iterator();
                    Map.Entry<T, Y> next = it.next();
                    Y value = next.getValue();
                    this.f37768d -= a((g<T, Y>) value);
                    T key = next.getKey();
                    it.remove();
                    a(key, value);
                }
            }
        }
    }

    public void a(@NonNull T t, @Nullable Y y) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, t, y) == null) {
        }
    }

    public synchronized long b() {
        InterceptResult invokeV;
        long j;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            synchronized (this) {
                j = this.f37767c;
            }
            return j;
        }
        return invokeV.longValue;
    }

    @Nullable
    public synchronized Y b(@NonNull T t) {
        InterceptResult invokeL;
        Y y;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, t)) == null) {
            synchronized (this) {
                y = this.f37765a.get(t);
            }
            return y;
        }
        return (Y) invokeL.objValue;
    }

    @Nullable
    public synchronized Y b(@NonNull T t, @Nullable Y y) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, t, y)) == null) {
            synchronized (this) {
                long a2 = a((g<T, Y>) y);
                if (a2 >= this.f37767c) {
                    a(t, y);
                    return null;
                }
                if (y != null) {
                    this.f37768d += a2;
                }
                Y put = this.f37765a.put(t, y);
                if (put != null) {
                    this.f37768d -= a((g<T, Y>) put);
                    if (!put.equals(y)) {
                        a(t, put);
                    }
                }
                c();
                return put;
            }
        }
        return (Y) invokeLL.objValue;
    }

    @Nullable
    public synchronized Y c(@NonNull T t) {
        InterceptResult invokeL;
        Y remove;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, t)) == null) {
            synchronized (this) {
                remove = this.f37765a.remove(t);
                if (remove != null) {
                    this.f37768d -= a((g<T, Y>) remove);
                }
            }
            return remove;
        }
        return (Y) invokeL.objValue;
    }
}
