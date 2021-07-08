package com.googlecode.mp4parser.util;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class IntHashMap {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public transient int count;
    public float loadFactor;
    public transient Entry[] table;
    public int threshold;

    /* loaded from: classes6.dex */
    public static class Entry {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int hash;
        public int key;
        public Entry next;
        public Object value;

        public Entry(int i2, int i3, Object obj, Entry entry) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i2), Integer.valueOf(i3), obj, entry};
                interceptable.invokeUnInit(65536, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.hash = i2;
            this.key = i3;
            this.value = obj;
            this.next = entry;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public IntHashMap() {
        this(20, 0.75f);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr = newInitContext.callArgs;
                this(((Integer) objArr[0]).intValue(), ((Float) objArr[1]).floatValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public synchronized void clear() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            synchronized (this) {
                Entry[] entryArr = this.table;
                int length = entryArr.length;
                while (true) {
                    length--;
                    if (length < 0) {
                        this.count = 0;
                    } else {
                        entryArr[length] = null;
                    }
                }
            }
        }
    }

    public boolean contains(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj)) != null) {
            return invokeL.booleanValue;
        }
        if (obj != null) {
            Entry[] entryArr = this.table;
            int length = entryArr.length;
            while (true) {
                int i2 = length - 1;
                if (length <= 0) {
                    return false;
                }
                for (Entry entry = entryArr[i2]; entry != null; entry = entry.next) {
                    if (entry.value.equals(obj)) {
                        return true;
                    }
                }
                length = i2;
            }
        } else {
            throw null;
        }
    }

    public boolean containsKey(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) {
            Entry[] entryArr = this.table;
            for (Entry entry = entryArr[(Integer.MAX_VALUE & i2) % entryArr.length]; entry != null; entry = entry.next) {
                if (entry.hash == i2) {
                    return true;
                }
            }
            return false;
        }
        return invokeI.booleanValue;
    }

    public boolean containsValue(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, obj)) == null) ? contains(obj) : invokeL.booleanValue;
    }

    public Object get(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i2)) == null) {
            Entry[] entryArr = this.table;
            for (Entry entry = entryArr[(Integer.MAX_VALUE & i2) % entryArr.length]; entry != null; entry = entry.next) {
                if (entry.hash == i2) {
                    return entry.value;
                }
            }
            return null;
        }
        return invokeI.objValue;
    }

    public boolean isEmpty() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.count == 0 : invokeV.booleanValue;
    }

    public Object put(int i2, Object obj) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048582, this, i2, obj)) == null) {
            Entry[] entryArr = this.table;
            int i3 = Integer.MAX_VALUE & i2;
            int length = i3 % entryArr.length;
            for (Entry entry = entryArr[length]; entry != null; entry = entry.next) {
                if (entry.hash == i2) {
                    Object obj2 = entry.value;
                    entry.value = obj;
                    return obj2;
                }
            }
            if (this.count >= this.threshold) {
                rehash();
                entryArr = this.table;
                length = i3 % entryArr.length;
            }
            entryArr[length] = new Entry(i2, i2, obj, entryArr[length]);
            this.count++;
            return null;
        }
        return invokeIL.objValue;
    }

    public void rehash() {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeV(1048583, this) != null) {
            return;
        }
        Entry[] entryArr = this.table;
        int length = entryArr.length;
        int i2 = (length * 2) + 1;
        Entry[] entryArr2 = new Entry[i2];
        this.threshold = (int) (i2 * this.loadFactor);
        this.table = entryArr2;
        while (true) {
            int i3 = length - 1;
            if (length <= 0) {
                return;
            }
            Entry entry = entryArr[i3];
            while (entry != null) {
                Entry entry2 = entry.next;
                int i4 = (entry.hash & Integer.MAX_VALUE) % i2;
                entry.next = entryArr2[i4];
                entryArr2[i4] = entry;
                entry = entry2;
            }
            length = i3;
        }
    }

    public Object remove(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2)) == null) {
            Entry[] entryArr = this.table;
            int length = (Integer.MAX_VALUE & i2) % entryArr.length;
            Entry entry = null;
            for (Entry entry2 = entryArr[length]; entry2 != null; entry2 = entry2.next) {
                if (entry2.hash == i2) {
                    if (entry != null) {
                        entry.next = entry2.next;
                    } else {
                        entryArr[length] = entry2.next;
                    }
                    this.count--;
                    Object obj = entry2.value;
                    entry2.value = null;
                    return obj;
                }
                entry = entry2;
            }
            return null;
        }
        return invokeI.objValue;
    }

    public int size() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.count : invokeV.intValue;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public IntHashMap(int i2) {
        this(i2, 0.75f);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this(((Integer) objArr2[0]).intValue(), ((Float) objArr2[1]).floatValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public IntHashMap(int i2, float f2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2), Float.valueOf(f2)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        if (i2 < 0) {
            throw new IllegalArgumentException("Illegal Capacity: " + i2);
        } else if (f2 > 0.0f) {
            i2 = i2 == 0 ? 1 : i2;
            this.loadFactor = f2;
            this.table = new Entry[i2];
            this.threshold = (int) (i2 * f2);
        } else {
            throw new IllegalArgumentException("Illegal Load: " + f2);
        }
    }
}
