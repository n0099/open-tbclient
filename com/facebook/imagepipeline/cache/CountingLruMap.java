package com.facebook.imagepipeline.cache;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.common.internal.Predicate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.annotation.Nullable;
/* loaded from: classes7.dex */
public class CountingLruMap {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final LinkedHashMap mMap;
    public int mSizeInBytes;
    public final ValueDescriptor mValueDescriptor;

    public CountingLruMap(ValueDescriptor valueDescriptor) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {valueDescriptor};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mMap = new LinkedHashMap();
        this.mSizeInBytes = 0;
        this.mValueDescriptor = valueDescriptor;
    }

    private int getValueSizeInBytes(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, this, obj)) == null) {
            if (obj == null) {
                return 0;
            }
            return this.mValueDescriptor.getSizeInBytes(obj);
        }
        return invokeL.intValue;
    }

    public synchronized boolean contains(Object obj) {
        InterceptResult invokeL;
        boolean containsKey;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj)) == null) {
            synchronized (this) {
                containsKey = this.mMap.containsKey(obj);
            }
            return containsKey;
        }
        return invokeL.booleanValue;
    }

    @Nullable
    public synchronized Object get(Object obj) {
        InterceptResult invokeL;
        Object obj2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, obj)) == null) {
            synchronized (this) {
                obj2 = this.mMap.get(obj);
            }
            return obj2;
        }
        return invokeL.objValue;
    }

    @Nullable
    public synchronized Object remove(Object obj) {
        InterceptResult invokeL;
        Object remove;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, obj)) == null) {
            synchronized (this) {
                remove = this.mMap.remove(obj);
                this.mSizeInBytes -= getValueSizeInBytes(remove);
            }
            return remove;
        }
        return invokeL.objValue;
    }

    public synchronized ArrayList clear() {
        InterceptResult invokeV;
        ArrayList arrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            synchronized (this) {
                arrayList = new ArrayList(this.mMap.values());
                this.mMap.clear();
                this.mSizeInBytes = 0;
            }
            return arrayList;
        }
        return (ArrayList) invokeV.objValue;
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
    public synchronized Object getFirstKey() {
        InterceptResult invokeV;
        Object next;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            synchronized (this) {
                if (this.mMap.isEmpty()) {
                    next = null;
                } else {
                    next = this.mMap.keySet().iterator().next();
                }
            }
            return next;
        }
        return invokeV.objValue;
    }

    public synchronized ArrayList getKeys() {
        InterceptResult invokeV;
        ArrayList arrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            synchronized (this) {
                arrayList = new ArrayList(this.mMap.keySet());
            }
            return arrayList;
        }
        return (ArrayList) invokeV.objValue;
    }

    public synchronized int getSizeInBytes() {
        InterceptResult invokeV;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            synchronized (this) {
                i = this.mSizeInBytes;
            }
            return i;
        }
        return invokeV.intValue;
    }

    public synchronized ArrayList getValues() {
        InterceptResult invokeV;
        ArrayList arrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            synchronized (this) {
                arrayList = new ArrayList(this.mMap.values());
            }
            return arrayList;
        }
        return (ArrayList) invokeV.objValue;
    }

    public synchronized ArrayList getMatchingEntries(@Nullable Predicate predicate) {
        InterceptResult invokeL;
        ArrayList arrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, predicate)) == null) {
            synchronized (this) {
                arrayList = new ArrayList(this.mMap.entrySet().size());
                for (Map.Entry entry : this.mMap.entrySet()) {
                    if (predicate == null || predicate.apply(entry.getKey())) {
                        arrayList.add(entry);
                    }
                }
            }
            return arrayList;
        }
        return (ArrayList) invokeL.objValue;
    }

    public synchronized ArrayList removeAll(@Nullable Predicate predicate) {
        InterceptResult invokeL;
        ArrayList arrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, predicate)) == null) {
            synchronized (this) {
                arrayList = new ArrayList();
                Iterator it = this.mMap.entrySet().iterator();
                while (it.hasNext()) {
                    Map.Entry entry = (Map.Entry) it.next();
                    if (predicate == null || predicate.apply(entry.getKey())) {
                        arrayList.add(entry.getValue());
                        this.mSizeInBytes -= getValueSizeInBytes(entry.getValue());
                        it.remove();
                    }
                }
            }
            return arrayList;
        }
        return (ArrayList) invokeL.objValue;
    }

    @Nullable
    public synchronized Object put(Object obj, Object obj2) {
        InterceptResult invokeLL;
        Object remove;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048585, this, obj, obj2)) == null) {
            synchronized (this) {
                remove = this.mMap.remove(obj);
                this.mSizeInBytes -= getValueSizeInBytes(remove);
                this.mMap.put(obj, obj2);
                this.mSizeInBytes += getValueSizeInBytes(obj2);
            }
            return remove;
        }
        return invokeLL.objValue;
    }
}
