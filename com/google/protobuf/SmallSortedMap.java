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
/* loaded from: classes7.dex */
public class SmallSortedMap extends AbstractMap {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List entryList;
    public boolean isImmutable;
    public volatile EntrySet lazyEntrySet;
    public final int maxArraySize;
    public Map overflowEntries;

    /* loaded from: classes7.dex */
    public class EmptySet {
        public static /* synthetic */ Interceptable $ic;
        public static final Iterable ITERABLE;
        public static final Iterator ITERATOR;
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
            ITERATOR = new Iterator() { // from class: com.google.protobuf.SmallSortedMap.EmptySet.1
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
            ITERABLE = new Iterable() { // from class: com.google.protobuf.SmallSortedMap.EmptySet.2
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
                public Iterator iterator() {
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

        public static Iterable iterable() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
                return ITERABLE;
            }
            return (Iterable) invokeV.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public class Entry implements Map.Entry, Comparable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final Comparable key;
        public final /* synthetic */ SmallSortedMap this$0;
        public Object value;

        public Entry(SmallSortedMap smallSortedMap, Comparable comparable, Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {smallSortedMap, comparable, obj};
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
            this.key = comparable;
            this.value = obj;
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public Entry(SmallSortedMap smallSortedMap, Map.Entry entry) {
            this(smallSortedMap, (Comparable) entry.getKey(), entry.getValue());
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

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.lang.Comparable
        public int compareTo(Entry entry) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, entry)) == null) {
                return getKey().compareTo(entry.getKey());
            }
            return invokeL.intValue;
        }

        @Override // java.util.Map.Entry
        public Object setValue(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, obj)) == null) {
                this.this$0.checkMutable();
                Object obj2 = this.value;
                this.value = obj;
                return obj2;
            }
            return invokeL.objValue;
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
        public Comparable getKey() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                return this.key;
            }
            return (Comparable) invokeV.objValue;
        }

        @Override // java.util.Map.Entry
        public Object getValue() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
                return this.value;
            }
            return invokeV.objValue;
        }

        @Override // java.util.Map.Entry
        public int hashCode() {
            InterceptResult invokeV;
            int hashCode;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                Comparable comparable = this.key;
                int i = 0;
                if (comparable == null) {
                    hashCode = 0;
                } else {
                    hashCode = comparable.hashCode();
                }
                Object obj = this.value;
                if (obj != null) {
                    i = obj.hashCode();
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

    /* loaded from: classes7.dex */
    public class EntryIterator implements Iterator {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public Iterator lazyOverflowIterator;
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

        private Iterator getOverflowIterator() {
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
        public Map.Entry next() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                this.nextCalledBeforeRemove = true;
                int i = this.pos + 1;
                this.pos = i;
                if (i < this.this$0.entryList.size()) {
                    return (Map.Entry) this.this$0.entryList.get(this.pos);
                }
                return (Map.Entry) getOverflowIterator().next();
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

    /* loaded from: classes7.dex */
    public class EntrySet extends AbstractSet {
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

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean add(Map.Entry entry) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, entry)) == null) {
                if (!contains(entry)) {
                    this.this$0.put((Comparable) entry.getKey(), entry.getValue());
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
        public Iterator iterator() {
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

    public static SmallSortedMap newFieldMap(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65546, null, i)) == null) {
            return new SmallSortedMap(i) { // from class: com.google.protobuf.SmallSortedMap.1
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
                                Map.Entry arrayEntryAt = getArrayEntryAt(i2);
                                if (((FieldSet.FieldDescriptorLite) arrayEntryAt.getKey()).isRepeated()) {
                                    arrayEntryAt.setValue(Collections.unmodifiableList((List) arrayEntryAt.getValue()));
                                }
                            }
                            for (Map.Entry entry : getOverflowEntries()) {
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
                    return super.put((Comparable) ((FieldSet.FieldDescriptorLite) obj), obj2);
                }
            };
        }
        return (SmallSortedMap) invokeI.objValue;
    }

    public static SmallSortedMap newInstanceForTest(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65547, null, i)) == null) {
            return new SmallSortedMap(i);
        }
        return (SmallSortedMap) invokeI.objValue;
    }

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

    @Override // java.util.AbstractMap, java.util.Map
    public Object get(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, obj)) == null) {
            Comparable comparable = (Comparable) obj;
            int binarySearchInArray = binarySearchInArray(comparable);
            if (binarySearchInArray >= 0) {
                return ((Entry) this.entryList.get(binarySearchInArray)).getValue();
            }
            return this.overflowEntries.get(comparable);
        }
        return invokeL.objValue;
    }

    public Map.Entry getArrayEntryAt(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i)) == null) {
            return (Map.Entry) this.entryList.get(i);
        }
        return (Map.Entry) invokeI.objValue;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Object remove(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, obj)) == null) {
            checkMutable();
            Comparable comparable = (Comparable) obj;
            int binarySearchInArray = binarySearchInArray(comparable);
            if (binarySearchInArray >= 0) {
                return removeArrayEntryAt(binarySearchInArray);
            }
            if (this.overflowEntries.isEmpty()) {
                return null;
            }
            return this.overflowEntries.remove(comparable);
        }
        return invokeL.objValue;
    }

    private int binarySearchInArray(Comparable comparable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, this, comparable)) == null) {
            int size = this.entryList.size() - 1;
            if (size >= 0) {
                int compareTo = comparable.compareTo(((Entry) this.entryList.get(size)).getKey());
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
                int compareTo2 = comparable.compareTo(((Entry) this.entryList.get(i2)).getKey());
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
    public Object removeArrayEntryAt(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65548, this, i)) == null) {
            checkMutable();
            Object value = ((Entry) this.entryList.remove(i)).getValue();
            if (!this.overflowEntries.isEmpty()) {
                Iterator it = getOverflowEntriesMutable().entrySet().iterator();
                this.entryList.add(new Entry(this, (Map.Entry) it.next()));
                it.remove();
            }
            return value;
        }
        return invokeI.objValue;
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

    private SortedMap getOverflowEntriesMutable() {
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
    public Set entrySet() {
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

    public Iterable getOverflowEntries() {
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
        Map unmodifiableMap;
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

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.util.AbstractMap, java.util.Map
    public Object put(Comparable comparable, Object obj) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048586, this, comparable, obj)) == null) {
            checkMutable();
            int binarySearchInArray = binarySearchInArray(comparable);
            if (binarySearchInArray >= 0) {
                return ((Entry) this.entryList.get(binarySearchInArray)).setValue(obj);
            }
            ensureEntryArrayMutable();
            int i = -(binarySearchInArray + 1);
            if (i >= this.maxArraySize) {
                return getOverflowEntriesMutable().put(comparable, obj);
            }
            int size = this.entryList.size();
            int i2 = this.maxArraySize;
            if (size == i2) {
                Entry entry = (Entry) this.entryList.remove(i2 - 1);
                getOverflowEntriesMutable().put(entry.getKey(), entry.getValue());
            }
            this.entryList.add(i, new Entry(this, comparable, obj));
            return null;
        }
        return invokeLL.objValue;
    }
}
