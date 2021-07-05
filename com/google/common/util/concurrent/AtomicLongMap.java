package com.google.common.util.concurrent;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.common.collect.Maps;
import d.f.d.a.g;
import d.f.d.a.n;
import java.io.Serializable;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
/* loaded from: classes7.dex */
public final class AtomicLongMap<K> implements Serializable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public transient Map<K, Long> asMap;
    public final ConcurrentHashMap<K, AtomicLong> map;

    public AtomicLongMap(ConcurrentHashMap<K, AtomicLong> concurrentHashMap) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {concurrentHashMap};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        n.p(concurrentHashMap);
        this.map = concurrentHashMap;
    }

    public static <K> AtomicLongMap<K> create() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) ? new AtomicLongMap<>(new ConcurrentHashMap()) : (AtomicLongMap) invokeV.objValue;
    }

    private Map<K, Long> createAsMap() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, this)) == null) ? Collections.unmodifiableMap(Maps.G(this.map, new g<AtomicLong, Long>(this) { // from class: com.google.common.util.concurrent.AtomicLongMap.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ AtomicLongMap this$0;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.this$0 = this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // d.f.d.a.g
            public Long apply(AtomicLong atomicLong) {
                InterceptResult invokeL;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, atomicLong)) == null) ? Long.valueOf(atomicLong.get()) : (Long) invokeL.objValue;
            }
        })) : (Map) invokeV.objValue;
    }

    public long addAndGet(K k, long j) {
        AtomicLong atomicLong;
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(1048576, this, k, j)) == null) {
            do {
                atomicLong = this.map.get(k);
                if (atomicLong == null && (atomicLong = this.map.putIfAbsent(k, new AtomicLong(j))) == null) {
                    return j;
                }
                while (true) {
                    long j2 = atomicLong.get();
                    if (j2 == 0) {
                        break;
                    }
                    long j3 = j2 + j;
                    if (atomicLong.compareAndSet(j2, j3)) {
                        return j3;
                    }
                }
            } while (!this.map.replace(k, atomicLong, new AtomicLong(j)));
            return j;
        }
        return invokeLJ.longValue;
    }

    public Map<K, Long> asMap() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            Map<K, Long> map = this.asMap;
            if (map == null) {
                Map<K, Long> createAsMap = createAsMap();
                this.asMap = createAsMap;
                return createAsMap;
            }
            return map;
        }
        return (Map) invokeV.objValue;
    }

    public void clear() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.map.clear();
        }
    }

    public boolean containsKey(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, obj)) == null) ? this.map.containsKey(obj) : invokeL.booleanValue;
    }

    public long decrementAndGet(K k) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, k)) == null) ? addAndGet(k, -1L) : invokeL.longValue;
    }

    public long get(K k) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, k)) == null) {
            AtomicLong atomicLong = this.map.get(k);
            if (atomicLong == null) {
                return 0L;
            }
            return atomicLong.get();
        }
        return invokeL.longValue;
    }

    public long getAndAdd(K k, long j) {
        AtomicLong atomicLong;
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(1048582, this, k, j)) == null) {
            do {
                atomicLong = this.map.get(k);
                if (atomicLong == null && (atomicLong = this.map.putIfAbsent(k, new AtomicLong(j))) == null) {
                    return 0L;
                }
                while (true) {
                    long j2 = atomicLong.get();
                    if (j2 == 0) {
                        break;
                    } else if (atomicLong.compareAndSet(j2, j2 + j)) {
                        return j2;
                    }
                }
            } while (!this.map.replace(k, atomicLong, new AtomicLong(j)));
            return 0L;
        }
        return invokeLJ.longValue;
    }

    public long getAndDecrement(K k) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, k)) == null) ? getAndAdd(k, -1L) : invokeL.longValue;
    }

    public long getAndIncrement(K k) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, k)) == null) ? getAndAdd(k, 1L) : invokeL.longValue;
    }

    public long incrementAndGet(K k) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, k)) == null) ? addAndGet(k, 1L) : invokeL.longValue;
    }

    public boolean isEmpty() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.map.isEmpty() : invokeV.booleanValue;
    }

    public long put(K k, long j) {
        AtomicLong atomicLong;
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(1048587, this, k, j)) == null) {
            do {
                atomicLong = this.map.get(k);
                if (atomicLong == null && (atomicLong = this.map.putIfAbsent(k, new AtomicLong(j))) == null) {
                    return 0L;
                }
                while (true) {
                    long j2 = atomicLong.get();
                    if (j2 == 0) {
                        break;
                    } else if (atomicLong.compareAndSet(j2, j)) {
                        return j2;
                    }
                }
            } while (!this.map.replace(k, atomicLong, new AtomicLong(j)));
            return 0L;
        }
        return invokeLJ.longValue;
    }

    public void putAll(Map<? extends K, ? extends Long> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, map) == null) {
            for (Map.Entry<? extends K, ? extends Long> entry : map.entrySet()) {
                put(entry.getKey(), entry.getValue().longValue());
            }
        }
    }

    public long putIfAbsent(K k, long j) {
        AtomicLong atomicLong;
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(1048589, this, k, j)) == null) {
            do {
                atomicLong = this.map.get(k);
                if (atomicLong == null && (atomicLong = this.map.putIfAbsent(k, new AtomicLong(j))) == null) {
                    return 0L;
                }
                long j2 = atomicLong.get();
                if (j2 != 0) {
                    return j2;
                }
            } while (!this.map.replace(k, atomicLong, new AtomicLong(j)));
            return 0L;
        }
        return invokeLJ.longValue;
    }

    public long remove(K k) {
        InterceptResult invokeL;
        long j;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, k)) == null) {
            AtomicLong atomicLong = this.map.get(k);
            if (atomicLong == null) {
                return 0L;
            }
            do {
                j = atomicLong.get();
                if (j == 0) {
                    break;
                }
            } while (!atomicLong.compareAndSet(j, 0L));
            this.map.remove(k, atomicLong);
            return j;
        }
        return invokeL.longValue;
    }

    public void removeAllZeros() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            Iterator<Map.Entry<K, AtomicLong>> it = this.map.entrySet().iterator();
            while (it.hasNext()) {
                AtomicLong value = it.next().getValue();
                if (value != null && value.get() == 0) {
                    it.remove();
                }
            }
        }
    }

    public boolean removeIfZero(K k) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, k)) == null) ? remove(k, 0L) : invokeL.booleanValue;
    }

    public boolean replace(K k, long j, long j2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048594, this, new Object[]{k, Long.valueOf(j), Long.valueOf(j2)})) == null) {
            if (j == 0) {
                return putIfAbsent(k, j2) == 0;
            }
            AtomicLong atomicLong = this.map.get(k);
            if (atomicLong == null) {
                return false;
            }
            return atomicLong.compareAndSet(j, j2);
        }
        return invokeCommon.booleanValue;
    }

    public int size() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.map.size() : invokeV.intValue;
    }

    public long sum() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            long j = 0;
            for (AtomicLong atomicLong : this.map.values()) {
                j += atomicLong.get();
            }
            return j;
        }
        return invokeV.longValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? this.map.toString() : (String) invokeV.objValue;
    }

    public static <K> AtomicLongMap<K> create(Map<? extends K, ? extends Long> map) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, map)) == null) {
            AtomicLongMap<K> create = create();
            create.putAll(map);
            return create;
        }
        return (AtomicLongMap) invokeL.objValue;
    }

    public boolean remove(K k, long j) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(1048591, this, k, j)) == null) {
            AtomicLong atomicLong = this.map.get(k);
            if (atomicLong == null) {
                return false;
            }
            long j2 = atomicLong.get();
            if (j2 != j) {
                return false;
            }
            if (j2 == 0 || atomicLong.compareAndSet(j2, 0L)) {
                this.map.remove(k, atomicLong);
                return true;
            }
            return false;
        }
        return invokeLJ.booleanValue;
    }
}
