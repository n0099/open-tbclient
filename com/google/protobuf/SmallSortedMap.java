package com.google.protobuf;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.protobuf.FieldSet;
import java.lang.Comparable;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;
/* loaded from: classes8.dex */
public class SmallSortedMap<K extends Comparable<K>, V> extends AbstractMap<K, V> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<SmallSortedMap<K, V>.Entry> entryList;
    public boolean isImmutable;
    public volatile SmallSortedMap<K, V>.EntrySet lazyEntrySet;
    public final int maxArraySize;
    public Map<K, V> overflowEntries;

    /* loaded from: classes8.dex */
    public static class EmptySet {
        public static /* synthetic */ Interceptable $ic;
        public static final Iterable<Object> ITERABLE;
        public static final Iterator<Object> ITERATOR;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(2122384450, "Lcom/google/protobuf/SmallSortedMap$EmptySet;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(2122384450, "Lcom/google/protobuf/SmallSortedMap$EmptySet;");
                    return;
                }
            }
            ITERATOR = new Iterator<Object>() { // from class: com.google.protobuf.SmallSortedMap.EmptySet.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // java.util.Iterator
                public boolean hasNext() {
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                        return false;
                    }
                    return invokeV.booleanValue;
                }

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                        }
                    }
                }

                @Override // java.util.Iterator
                public Object next() {
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                        throw new NoSuchElementException();
                    }
                    return invokeV.objValue;
                }

                @Override // java.util.Iterator
                public void remove() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                        throw new UnsupportedOperationException();
                    }
                }
            };
            ITERABLE = new Iterable<Object>() { // from class: com.google.protobuf.SmallSortedMap.EmptySet.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                        }
                    }
                }

                @Override // java.lang.Iterable
                public Iterator<Object> iterator() {
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                        return EmptySet.ITERATOR;
                    }
                    return (Iterator) invokeV.objValue;
                }
            };
        }

        public EmptySet() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65537, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public static <T> Iterable<T> iterable() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
                return (Iterable<T>) ITERABLE;
            }
            return (Iterable) invokeV.objValue;
        }
    }

    /* loaded from: classes8.dex */
    public class Entry implements Map.Entry<K, V>, Comparable<SmallSortedMap<K, V>.Entry> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final K key;
        public final /* synthetic */ SmallSortedMap this$0;
        public V value;

        public Entry(SmallSortedMap smallSortedMap, K k, V v) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {smallSortedMap, k, v};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = smallSortedMap;
            this.key = k;
            this.value = v;
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public Entry(SmallSortedMap smallSortedMap, Map.Entry<K, V> entry) {
            this(smallSortedMap, entry.getKey(), entry.getValue());
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {smallSortedMap, entry};
                interceptable.invokeUnInit(65537, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    this((SmallSortedMap) objArr2[0], (Comparable) objArr2[1], objArr2[2]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
        }

        private boolean equals(Object obj, Object obj2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, this, obj, obj2)) == null) {
                if (obj == null) {
                    if (obj2 == null) {
                        return true;
                    }
                    return false;
                }
                return obj.equals(obj2);
            }
            return invokeLL.booleanValue;
        }

        public int compareTo(SmallSortedMap<K, V>.Entry entry) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, entry)) == null) {
                return getKey().compareTo(entry.getKey());
            }
            return invokeL.intValue;
        }

        @Override // java.util.Map.Entry
        public V setValue(V v) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, v)) == null) {
                this.this$0.checkMutable();
                V v2 = this.value;
                this.value = v;
                return v2;
            }
            return (V) invokeL.objValue;
        }

        @Override // java.lang.Comparable
        public /* bridge */ /* synthetic */ int compareTo(Object obj) {
            return compareTo((Entry) ((Entry) obj));
        }

        @Override // java.util.Map.Entry
        public boolean equals(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, obj)) == null) {
                if (obj == this) {
                    return true;
                }
                if (!(obj instanceof Map.Entry)) {
                    return false;
                }
                Map.Entry entry = (Map.Entry) obj;
                if (equals(this.key, entry.getKey()) && equals(this.value, entry.getValue())) {
                    return true;
                }
                return false;
            }
            return invokeL.booleanValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Map.Entry
        public K getKey() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                return this.key;
            }
            return (K) invokeV.objValue;
        }

        @Override // java.util.Map.Entry
        public V getValue() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
                return this.value;
            }
            return (V) invokeV.objValue;
        }

        @Override // java.util.Map.Entry
        public int hashCode() {
            InterceptResult invokeV;
            int hashCode;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                K k = this.key;
                int i = 0;
                if (k == null) {
                    hashCode = 0;
                } else {
                    hashCode = k.hashCode();
                }
                V v = this.value;
                if (v != null) {
                    i = v.hashCode();
                }
                return hashCode ^ i;
            }
            return invokeV.intValue;
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
                return this.key + "=" + this.value;
            }
            return (String) invokeV.objValue;
        }
    }

    /* loaded from: classes8.dex */
    public class EntryIterator implements Iterator<Map.Entry<K, V>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public Iterator<Map.Entry<K, V>> lazyOverflowIterator;
        public boolean nextCalledBeforeRemove;
        public int pos;
        public final /* synthetic */ SmallSortedMap this$0;

        public EntryIterator(SmallSortedMap smallSortedMap) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {smallSortedMap};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = smallSortedMap;
            this.pos = -1;
        }

        private Iterator<Map.Entry<K, V>> getOverflowIterator() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65538, this)) == null) {
                if (this.lazyOverflowIterator == null) {
                    this.lazyOverflowIterator = this.this$0.overflowEntries.entrySet().iterator();
                }
                return this.lazyOverflowIterator;
            }
            return (Iterator) invokeV.objValue;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                if (this.pos + 1 < this.this$0.entryList.size() || getOverflowIterator().hasNext()) {
                    return true;
                }
                return false;
            }
            return invokeV.booleanValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Iterator
        public Map.Entry<K, V> next() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                this.nextCalledBeforeRemove = true;
                int i = this.pos + 1;
                this.pos = i;
                if (i < this.this$0.entryList.size()) {
                    return (Map.Entry) this.this$0.entryList.get(this.pos);
                }
                return getOverflowIterator().next();
            }
            return (Map.Entry) invokeV.objValue;
        }

        @Override // java.util.Iterator
        public void remove() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                if (this.nextCalledBeforeRemove) {
                    this.nextCalledBeforeRemove = false;
                    this.this$0.checkMutable();
                    if (this.pos < this.this$0.entryList.size()) {
                        SmallSortedMap smallSortedMap = this.this$0;
                        int i = this.pos;
                        this.pos = i - 1;
                        smallSortedMap.removeArrayEntryAt(i);
                        return;
                    }
                    getOverflowIterator().remove();
                    return;
                }
                throw new IllegalStateException("remove() was called before next()");
            }
        }
    }

    /* loaded from: classes8.dex */
    public class EntrySet extends AbstractSet<Map.Entry<K, V>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SmallSortedMap this$0;

        public EntrySet(SmallSortedMap smallSortedMap) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {smallSortedMap};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = smallSortedMap;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public /* bridge */ /* synthetic */ boolean add(Object obj) {
            return add((Map.Entry) ((Map.Entry) obj));
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, obj)) == null) {
                Map.Entry entry = (Map.Entry) obj;
                Object obj2 = this.this$0.get(entry.getKey());
                Object value = entry.getValue();
                if (obj2 != value && (obj2 == null || !obj2.equals(value))) {
                    return false;
                }
                return true;
            }
            return invokeL.booleanValue;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, obj)) == null) {
                Map.Entry entry = (Map.Entry) obj;
                if (contains(entry)) {
                    this.this$0.remove(entry.getKey());
                    return true;
                }
                return false;
            }
            return invokeL.booleanValue;
        }

        public boolean add(Map.Entry<K, V> entry) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, entry)) == null) {
                if (!contains(entry)) {
                    this.this$0.put((SmallSortedMap) entry.getKey(), (K) entry.getValue());
                    return true;
                }
                return false;
            }
            return invokeL.booleanValue;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                this.this$0.clear();
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<Map.Entry<K, V>> iterator() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                return new EntryIterator();
            }
            return (Iterator) invokeV.objValue;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                return this.this$0.size();
            }
            return invokeV.intValue;
        }
    }

    public SmallSortedMap(int i) {
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
        this.maxArraySize = i;
        this.entryList = Collections.emptyList();
        this.overflowEntries = Collections.emptyMap();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.google.protobuf.SmallSortedMap<K extends java.lang.Comparable<K>, V> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractMap, java.util.Map
    public /* bridge */ /* synthetic */ Object put(Object obj, Object obj2) {
        return put((SmallSortedMap<K, V>) ((Comparable) obj), (Comparable) obj2);
    }

    public static <FieldDescriptorType extends FieldSet.FieldDescriptorLite<FieldDescriptorType>> SmallSortedMap<FieldDescriptorType, Object> newFieldMap(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65546, null, i)) == null) {
            return (SmallSortedMap<FieldDescriptorType, Object>) new SmallSortedMap<FieldDescriptorType, Object>(i) { // from class: com.google.protobuf.SmallSortedMap.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(i);
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {Integer.valueOf(i)};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            Object[] objArr2 = newInitContext.callArgs;
                            super(((Integer) objArr2[0]).intValue());
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                }

                @Override // com.google.protobuf.SmallSortedMap
                public void makeImmutable() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        if (!isImmutable()) {
                            for (int i2 = 0; i2 < getNumArrayEntries(); i2++) {
                                Map.Entry<FieldDescriptorType, Object> arrayEntryAt = getArrayEntryAt(i2);
                                if (((FieldSet.FieldDescriptorLite) arrayEntryAt.getKey()).isRepeated()) {
                                    arrayEntryAt.setValue(Collections.unmodifiableList((List) arrayEntryAt.getValue()));
                                }
                            }
                            for (Map.Entry<FieldDescriptorType, Object> entry : getOverflowEntries()) {
                                if (((FieldSet.FieldDescriptorLite) entry.getKey()).isRepeated()) {
                                    entry.setValue(Collections.unmodifiableList((List) entry.getValue()));
                                }
                            }
                        }
                        super.makeImmutable();
                    }
                }

                @Override // com.google.protobuf.SmallSortedMap, java.util.AbstractMap, java.util.Map
                public /* bridge */ /* synthetic */ Object put(Object obj, Object obj2) {
                    return super.put((AnonymousClass1<FieldDescriptorType>) ((FieldSet.FieldDescriptorLite) obj), (FieldSet.FieldDescriptorLite) obj2);
                }
            };
        }
        return (SmallSortedMap) invokeI.objValue;
    }

    public static <K extends Comparable<K>, V> SmallSortedMap<K, V> newInstanceForTest(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65547, null, i)) == null) {
            return new SmallSortedMap<>(i);
        }
        return (SmallSortedMap) invokeI.objValue;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: com.google.protobuf.SmallSortedMap<K extends java.lang.Comparable<K>, V> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj)) == null) {
            Comparable comparable = (Comparable) obj;
            if (binarySearchInArray(comparable) < 0 && !this.overflowEntries.containsKey(comparable)) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: com.google.protobuf.SmallSortedMap<K extends java.lang.Comparable<K>, V> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractMap, java.util.Map
    public V get(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, obj)) == null) {
            Comparable comparable = (Comparable) obj;
            int binarySearchInArray = binarySearchInArray(comparable);
            if (binarySearchInArray >= 0) {
                return this.entryList.get(binarySearchInArray).getValue();
            }
            return this.overflowEntries.get(comparable);
        }
        return (V) invokeL.objValue;
    }

    public Map.Entry<K, V> getArrayEntryAt(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i)) == null) {
            return this.entryList.get(i);
        }
        return (Map.Entry) invokeI.objValue;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: com.google.protobuf.SmallSortedMap<K extends java.lang.Comparable<K>, V> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractMap, java.util.Map
    public V remove(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, obj)) == null) {
            checkMutable();
            Comparable comparable = (Comparable) obj;
            int binarySearchInArray = binarySearchInArray(comparable);
            if (binarySearchInArray >= 0) {
                return (V) removeArrayEntryAt(binarySearchInArray);
            }
            if (this.overflowEntries.isEmpty()) {
                return null;
            }
            return this.overflowEntries.remove(comparable);
        }
        return (V) invokeL.objValue;
    }

    private int binarySearchInArray(K k) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, this, k)) == null) {
            int size = this.entryList.size() - 1;
            if (size >= 0) {
                int compareTo = k.compareTo(this.entryList.get(size).getKey());
                if (compareTo > 0) {
                    return -(size + 2);
                }
                if (compareTo == 0) {
                    return size;
                }
            }
            int i = 0;
            while (i <= size) {
                int i2 = (i + size) / 2;
                int compareTo2 = k.compareTo(this.entryList.get(i2).getKey());
                if (compareTo2 < 0) {
                    size = i2 - 1;
                } else if (compareTo2 > 0) {
                    i = i2 + 1;
                } else {
                    return i2;
                }
            }
            return -(i + 1);
        }
        return invokeL.intValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public V removeArrayEntryAt(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65548, this, i)) == null) {
            checkMutable();
            V value = this.entryList.remove(i).getValue();
            if (!this.overflowEntries.isEmpty()) {
                Iterator<Map.Entry<K, V>> it = getOverflowEntriesMutable().entrySet().iterator();
                this.entryList.add(new Entry(this, it.next()));
                it.remove();
            }
            return value;
        }
        return (V) invokeI.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkMutable() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(65543, this) != null) || !this.isImmutable) {
            return;
        }
        throw new UnsupportedOperationException();
    }

    private void ensureEntryArrayMutable() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65544, this) == null) {
            checkMutable();
            if (this.entryList.isEmpty() && !(this.entryList instanceof ArrayList)) {
                this.entryList = new ArrayList(this.maxArraySize);
            }
        }
    }

    private SortedMap<K, V> getOverflowEntriesMutable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, this)) == null) {
            checkMutable();
            if (this.overflowEntries.isEmpty() && !(this.overflowEntries instanceof TreeMap)) {
                this.overflowEntries = new TreeMap();
            }
            return (SortedMap) this.overflowEntries;
        }
        return (SortedMap) invokeV.objValue;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            checkMutable();
            if (!this.entryList.isEmpty()) {
                this.entryList.clear();
            }
            if (!this.overflowEntries.isEmpty()) {
                this.overflowEntries.clear();
            }
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (this.lazyEntrySet == null) {
                this.lazyEntrySet = new EntrySet();
            }
            return this.lazyEntrySet;
        }
        return (Set) invokeV.objValue;
    }

    public int getNumArrayEntries() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.entryList.size();
        }
        return invokeV.intValue;
    }

    public int getNumOverflowEntries() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.overflowEntries.size();
        }
        return invokeV.intValue;
    }

    public Iterable<Map.Entry<K, V>> getOverflowEntries() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            if (this.overflowEntries.isEmpty()) {
                return EmptySet.iterable();
            }
            return this.overflowEntries.entrySet();
        }
        return (Iterable) invokeV.objValue;
    }

    public boolean isImmutable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.isImmutable;
        }
        return invokeV.booleanValue;
    }

    public void makeImmutable() {
        Map<K, V> unmodifiableMap;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048585, this) == null) && !this.isImmutable) {
            if (this.overflowEntries.isEmpty()) {
                unmodifiableMap = Collections.emptyMap();
            } else {
                unmodifiableMap = Collections.unmodifiableMap(this.overflowEntries);
            }
            this.overflowEntries = unmodifiableMap;
            this.isImmutable = true;
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int size() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return this.entryList.size() + this.overflowEntries.size();
        }
        return invokeV.intValue;
    }

    public V put(K k, V v) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048586, this, k, v)) == null) {
            checkMutable();
            int binarySearchInArray = binarySearchInArray(k);
            if (binarySearchInArray >= 0) {
                return this.entryList.get(binarySearchInArray).setValue(v);
            }
            ensureEntryArrayMutable();
            int i = -(binarySearchInArray + 1);
            if (i >= this.maxArraySize) {
                return getOverflowEntriesMutable().put(k, v);
            }
            int size = this.entryList.size();
            int i2 = this.maxArraySize;
            if (size == i2) {
                SmallSortedMap<K, V>.Entry remove = this.entryList.remove(i2 - 1);
                getOverflowEntriesMutable().put((K) remove.getKey(), remove.getValue());
            }
            this.entryList.add(i, new Entry(this, k, v));
            return null;
        }
        return (V) invokeLL.objValue;
    }
}
