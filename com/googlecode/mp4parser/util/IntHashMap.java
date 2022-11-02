package com.googlecode.mp4parser.util;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class IntHashMap {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public transient int count;
    public float loadFactor;
    public transient Entry[] table;
    public int threshold;

    /* loaded from: classes7.dex */
    public static class Entry {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int hash;
        public int key;
        public Entry next;
        public Object value;

        public Entry(int i, int i2, Object obj, Entry entry) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i), Integer.valueOf(i2), obj, entry};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.hash = i;
            this.key = i2;
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr = newInitContext.callArgs;
                this(((Integer) objArr[0]).intValue(), ((Float) objArr[1]).floatValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public void rehash() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            Entry[] entryArr = this.table;
            int length = entryArr.length;
            int i = (length * 2) + 1;
            Entry[] entryArr2 = new Entry[i];
            this.threshold = (int) (i * this.loadFactor);
            this.table = entryArr2;
            while (true) {
                int i2 = length - 1;
                if (length <= 0) {
                    return;
                }
                Entry entry = entryArr[i2];
                while (entry != null) {
                    Entry entry2 = entry.next;
                    int i3 = (entry.hash & Integer.MAX_VALUE) % i;
                    entry.next = entryArr2[i3];
                    entryArr2[i3] = entry;
                    entry = entry2;
                }
                length = i2;
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public IntHashMap(int i) {
        this(i, 0.75f);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this(((Integer) objArr2[0]).intValue(), ((Float) objArr2[1]).floatValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public IntHashMap(int i, float f) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i), Float.valueOf(f)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        if (i >= 0) {
            if (f > 0.0f) {
                i = i == 0 ? 1 : i;
                this.loadFactor = f;
                this.table = new Entry[i];
                this.threshold = (int) (i * f);
                return;
            }
            throw new IllegalArgumentException("Illegal Load: " + f);
        }
        throw new IllegalArgumentException("Illegal Capacity: " + i);
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

    public boolean isEmpty() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            if (this.count == 0) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public int size() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.count;
        }
        return invokeV.intValue;
    }

    public boolean contains(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj)) == null) {
            if (obj != null) {
                Entry[] entryArr = this.table;
                int length = entryArr.length;
                while (true) {
                    int i = length - 1;
                    if (length <= 0) {
                        return false;
                    }
                    for (Entry entry = entryArr[i]; entry != null; entry = entry.next) {
                        if (entry.value.equals(obj)) {
                            return true;
                        }
                    }
                    length = i;
                }
            } else {
                throw null;
            }
        } else {
            return invokeL.booleanValue;
        }
    }

    public boolean containsKey(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i)) == null) {
            Entry[] entryArr = this.table;
            for (Entry entry = entryArr[(Integer.MAX_VALUE & i) % entryArr.length]; entry != null; entry = entry.next) {
                if (entry.hash == i) {
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
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, obj)) == null) {
            return contains(obj);
        }
        return invokeL.booleanValue;
    }

    public Object get(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i)) == null) {
            Entry[] entryArr = this.table;
            for (Entry entry = entryArr[(Integer.MAX_VALUE & i) % entryArr.length]; entry != null; entry = entry.next) {
                if (entry.hash == i) {
                    return entry.value;
                }
            }
            return null;
        }
        return invokeI.objValue;
    }

    public Object put(int i, Object obj) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048582, this, i, obj)) == null) {
            Entry[] entryArr = this.table;
            int i2 = Integer.MAX_VALUE & i;
            int length = i2 % entryArr.length;
            for (Entry entry = entryArr[length]; entry != null; entry = entry.next) {
                if (entry.hash == i) {
                    Object obj2 = entry.value;
                    entry.value = obj;
                    return obj2;
                }
            }
            if (this.count >= this.threshold) {
                rehash();
                entryArr = this.table;
                length = i2 % entryArr.length;
            }
            entryArr[length] = new Entry(i, i, obj, entryArr[length]);
            this.count++;
            return null;
        }
        return invokeIL.objValue;
    }

    public Object remove(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i)) == null) {
            Entry[] entryArr = this.table;
            int length = (Integer.MAX_VALUE & i) % entryArr.length;
            Entry entry = null;
            for (Entry entry2 = entryArr[length]; entry2 != null; entry2 = entry2.next) {
                if (entry2.hash == i) {
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
}
