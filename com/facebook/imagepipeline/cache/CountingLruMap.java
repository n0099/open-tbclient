package com.facebook.imagepipeline.cache;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.common.internal.Predicate;
import com.facebook.common.internal.VisibleForTesting;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
import javax.annotation.concurrent.ThreadSafe;
@ThreadSafe
/* loaded from: classes5.dex */
public class CountingLruMap<K, V> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @GuardedBy("this")
    public final LinkedHashMap<K, V> mMap;
    @GuardedBy("this")
    public int mSizeInBytes;
    public final ValueDescriptor<V> mValueDescriptor;

    public CountingLruMap(ValueDescriptor<V> valueDescriptor) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {valueDescriptor};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mMap = new LinkedHashMap<>();
        this.mSizeInBytes = 0;
        this.mValueDescriptor = valueDescriptor;
    }

    private int getValueSizeInBytes(V v) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, this, v)) == null) {
            if (v == null) {
                return 0;
            }
            return this.mValueDescriptor.getSizeInBytes(v);
        }
        return invokeL.intValue;
    }

    public synchronized ArrayList<V> clear() {
        InterceptResult invokeV;
        ArrayList<V> arrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            synchronized (this) {
                arrayList = new ArrayList<>((Collection<? extends V>) this.mMap.values());
                this.mMap.clear();
                this.mSizeInBytes = 0;
            }
            return arrayList;
        }
        return (ArrayList) invokeV.objValue;
    }

    public synchronized boolean contains(K k) {
        InterceptResult invokeL;
        boolean containsKey;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, k)) == null) {
            synchronized (this) {
                containsKey = this.mMap.containsKey(k);
            }
            return containsKey;
        }
        return invokeL.booleanValue;
    }

    @Nullable
    public synchronized V get(K k) {
        InterceptResult invokeL;
        V v;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, k)) == null) {
            synchronized (this) {
                v = this.mMap.get(k);
            }
            return v;
        }
        return (V) invokeL.objValue;
    }

    public synchronized int getCount() {
        InterceptResult invokeV;
        int size;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            synchronized (this) {
                size = this.mMap.size();
            }
            return size;
        }
        return invokeV.intValue;
    }

    @Nullable
    public synchronized K getFirstKey() {
        InterceptResult invokeV;
        K next;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            synchronized (this) {
                next = this.mMap.isEmpty() ? null : this.mMap.keySet().iterator().next();
            }
            return next;
        }
        return (K) invokeV.objValue;
    }

    @VisibleForTesting
    public synchronized ArrayList<K> getKeys() {
        InterceptResult invokeV;
        ArrayList<K> arrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            synchronized (this) {
                arrayList = new ArrayList<>(this.mMap.keySet());
            }
            return arrayList;
        }
        return (ArrayList) invokeV.objValue;
    }

    public synchronized ArrayList<Map.Entry<K, V>> getMatchingEntries(@Nullable Predicate<K> predicate) {
        InterceptResult invokeL;
        ArrayList<Map.Entry<K, V>> arrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, predicate)) == null) {
            synchronized (this) {
                arrayList = new ArrayList<>(this.mMap.entrySet().size());
                for (Map.Entry<K, V> entry : this.mMap.entrySet()) {
                    if (predicate == null || predicate.apply(entry.getKey())) {
                        arrayList.add(entry);
                    }
                }
            }
            return arrayList;
        }
        return (ArrayList) invokeL.objValue;
    }

    public synchronized int getSizeInBytes() {
        InterceptResult invokeV;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            synchronized (this) {
                i2 = this.mSizeInBytes;
            }
            return i2;
        }
        return invokeV.intValue;
    }

    @VisibleForTesting
    public synchronized ArrayList<V> getValues() {
        InterceptResult invokeV;
        ArrayList<V> arrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            synchronized (this) {
                arrayList = new ArrayList<>((Collection<? extends V>) this.mMap.values());
            }
            return arrayList;
        }
        return (ArrayList) invokeV.objValue;
    }

    @Nullable
    public synchronized V put(K k, V v) {
        InterceptResult invokeLL;
        V remove;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048585, this, k, v)) == null) {
            synchronized (this) {
                remove = this.mMap.remove(k);
                this.mSizeInBytes -= getValueSizeInBytes(remove);
                this.mMap.put(k, v);
                this.mSizeInBytes += getValueSizeInBytes(v);
            }
            return remove;
        }
        return (V) invokeLL.objValue;
    }

    @Nullable
    public synchronized V remove(K k) {
        InterceptResult invokeL;
        V remove;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, k)) == null) {
            synchronized (this) {
                remove = this.mMap.remove(k);
                this.mSizeInBytes -= getValueSizeInBytes(remove);
            }
            return remove;
        }
        return (V) invokeL.objValue;
    }

    public synchronized ArrayList<V> removeAll(@Nullable Predicate<K> predicate) {
        InterceptResult invokeL;
        ArrayList<V> arrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, predicate)) == null) {
            synchronized (this) {
                arrayList = new ArrayList<>();
                Iterator<Map.Entry<K, V>> it = this.mMap.entrySet().iterator();
                while (it.hasNext()) {
                    Map.Entry<K, V> next = it.next();
                    if (predicate == null || predicate.apply(next.getKey())) {
                        arrayList.add(next.getValue());
                        this.mSizeInBytes -= getValueSizeInBytes(next.getValue());
                        it.remove();
                    }
                }
            }
            return arrayList;
        }
        return (ArrayList) invokeL.objValue;
    }
}
