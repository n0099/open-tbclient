package com.google.common.collect;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.f.d.a.k;
import d.f.d.a.n;
import d.f.d.c.m;
import d.f.d.c.n0;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.AbstractCollection;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Arrays;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
/* loaded from: classes7.dex */
public class CompactHashMap<K, V> extends AbstractMap<K, V> implements Serializable {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int DEFAULT_SIZE = 3;
    public static final long HASH_MASK = -4294967296L;
    public static final float LOAD_FACTOR = 1.0f;
    public static final long NEXT_MASK = 4294967295L;
    public static final int UNSET = -1;
    public transient /* synthetic */ FieldHolder $fh;
    public transient long[] entries;
    public transient Set<Map.Entry<K, V>> entrySetView;
    public transient Set<K> keySetView;
    public transient Object[] keys;
    public transient int modCount;
    public transient int size;
    public transient int[] table;
    public transient Object[] values;
    public transient Collection<V> valuesView;

    /* loaded from: classes7.dex */
    public class a extends CompactHashMap<K, V>.e<K> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ CompactHashMap f33038i;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(CompactHashMap compactHashMap) {
            super(compactHashMap, null);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {compactHashMap};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((CompactHashMap) objArr2[0], (a) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f33038i = compactHashMap;
        }

        @Override // com.google.common.collect.CompactHashMap.e
        public K b(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) ? (K) this.f33038i.keys[i2] : (K) invokeI.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public class b extends CompactHashMap<K, V>.e<Map.Entry<K, V>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ CompactHashMap f33039i;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(CompactHashMap compactHashMap) {
            super(compactHashMap, null);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {compactHashMap};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((CompactHashMap) objArr2[0], (a) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f33039i = compactHashMap;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.common.collect.CompactHashMap.e
        /* renamed from: c */
        public Map.Entry<K, V> b(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) ? new g(this.f33039i, i2) : (Map.Entry) invokeI.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public class c extends CompactHashMap<K, V>.e<V> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ CompactHashMap f33040i;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(CompactHashMap compactHashMap) {
            super(compactHashMap, null);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {compactHashMap};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((CompactHashMap) objArr2[0], (a) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f33040i = compactHashMap;
        }

        @Override // com.google.common.collect.CompactHashMap.e
        public V b(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) ? (V) this.f33040i.values[i2] : (V) invokeI.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public class d extends AbstractSet<Map.Entry<K, V>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CompactHashMap f33041e;

        public d(CompactHashMap compactHashMap) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {compactHashMap};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f33041e = compactHashMap;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f33041e.clear();
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj)) == null) {
                if (obj instanceof Map.Entry) {
                    Map.Entry entry = (Map.Entry) obj;
                    int indexOf = this.f33041e.indexOf(entry.getKey());
                    return indexOf != -1 && k.a(this.f33041e.values[indexOf], entry.getValue());
                }
                return false;
            }
            return invokeL.booleanValue;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<Map.Entry<K, V>> iterator() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f33041e.entrySetIterator() : (Iterator) invokeV.objValue;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, obj)) == null) {
                if (obj instanceof Map.Entry) {
                    Map.Entry entry = (Map.Entry) obj;
                    int indexOf = this.f33041e.indexOf(entry.getKey());
                    if (indexOf == -1 || !k.a(this.f33041e.values[indexOf], entry.getValue())) {
                        return false;
                    }
                    this.f33041e.removeEntry(indexOf);
                    return true;
                }
                return false;
            }
            return invokeL.booleanValue;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f33041e.size : invokeV.intValue;
        }
    }

    /* loaded from: classes7.dex */
    public class f extends AbstractSet<K> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CompactHashMap f33046e;

        public f(CompactHashMap compactHashMap) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {compactHashMap};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f33046e = compactHashMap;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f33046e.clear();
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj)) == null) ? this.f33046e.containsKey(obj) : invokeL.booleanValue;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<K> iterator() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f33046e.keySetIterator() : (Iterator) invokeV.objValue;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, obj)) == null) {
                int indexOf = this.f33046e.indexOf(obj);
                if (indexOf == -1) {
                    return false;
                }
                this.f33046e.removeEntry(indexOf);
                return true;
            }
            return invokeL.booleanValue;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f33046e.size : invokeV.intValue;
        }
    }

    /* loaded from: classes7.dex */
    public final class g extends d.f.d.c.b<K, V> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final K f33047e;

        /* renamed from: f  reason: collision with root package name */
        public int f33048f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ CompactHashMap f33049g;

        public g(CompactHashMap compactHashMap, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {compactHashMap, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f33049g = compactHashMap;
            this.f33047e = (K) compactHashMap.keys[i2];
            this.f33048f = i2;
        }

        public final void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                int i2 = this.f33048f;
                if (i2 == -1 || i2 >= this.f33049g.size() || !k.a(this.f33047e, this.f33049g.keys[this.f33048f])) {
                    this.f33048f = this.f33049g.indexOf(this.f33047e);
                }
            }
        }

        @Override // d.f.d.c.b, java.util.Map.Entry
        public K getKey() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f33047e : (K) invokeV.objValue;
        }

        @Override // d.f.d.c.b, java.util.Map.Entry
        public V getValue() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                a();
                int i2 = this.f33048f;
                if (i2 == -1) {
                    return null;
                }
                return (V) this.f33049g.values[i2];
            }
            return (V) invokeV.objValue;
        }

        @Override // d.f.d.c.b, java.util.Map.Entry
        public V setValue(V v) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, v)) == null) {
                a();
                int i2 = this.f33048f;
                if (i2 == -1) {
                    this.f33049g.put(this.f33047e, v);
                    return null;
                }
                Object[] objArr = this.f33049g.values;
                V v2 = (V) objArr[i2];
                objArr[i2] = v;
                return v2;
            }
            return (V) invokeL.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public class h extends AbstractCollection<V> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CompactHashMap f33050e;

        public h(CompactHashMap compactHashMap) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {compactHashMap};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f33050e = compactHashMap;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public void clear() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f33050e.clear();
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator<V> iterator() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f33050e.valuesIterator() : (Iterator) invokeV.objValue;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f33050e.size : invokeV.intValue;
        }
    }

    public CompactHashMap() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        init(3);
    }

    public static <K, V> CompactHashMap<K, V> create() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.AD_TEXT_ID, null)) == null) ? new CompactHashMap<>() : (CompactHashMap) invokeV.objValue;
    }

    public static <K, V> CompactHashMap<K, V> createWithExpectedSize(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(AdIconUtil.BAIDU_LOGO_ID, null, i2)) == null) ? new CompactHashMap<>(i2) : (CompactHashMap) invokeI.objValue;
    }

    public static int getHash(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJ = interceptable.invokeJ(65543, null, j)) == null) ? (int) (j >>> 32) : invokeJ.intValue;
    }

    public static int getNext(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJ = interceptable.invokeJ(65544, null, j)) == null) ? (int) j : invokeJ.intValue;
    }

    private int hashTableMask() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65545, this)) == null) ? this.table.length - 1 : invokeV.intValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int indexOf(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, this, obj)) == null) {
            if (needsAllocArrays()) {
                return -1;
            }
            int d2 = n0.d(obj);
            int i2 = this.table[hashTableMask() & d2];
            while (i2 != -1) {
                long j = this.entries[i2];
                if (getHash(j) == d2 && k.a(obj, this.keys[i2])) {
                    return i2;
                }
                i2 = getNext(j);
            }
            return -1;
        }
        return invokeL.intValue;
    }

    public static long[] newEntries(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65547, null, i2)) == null) {
            long[] jArr = new long[i2];
            Arrays.fill(jArr, -1L);
            return jArr;
        }
        return (long[]) invokeI.objValue;
    }

    public static int[] newTable(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65548, null, i2)) == null) {
            int[] iArr = new int[i2];
            Arrays.fill(iArr, -1);
            return iArr;
        }
        return (int[]) invokeI.objValue;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: com.google.common.collect.CompactHashMap<K, V> */
    /* JADX WARN: Multi-variable type inference failed */
    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65549, this, objectInputStream) == null) {
            objectInputStream.defaultReadObject();
            int readInt = objectInputStream.readInt();
            if (readInt >= 0) {
                init(readInt);
                for (int i2 = 0; i2 < readInt; i2++) {
                    put(objectInputStream.readObject(), objectInputStream.readObject());
                }
                return;
            }
            throw new InvalidObjectException("Invalid size: " + readInt);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public V removeEntry(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65551, this, i2)) == null) ? remove(this.keys[i2], getHash(this.entries[i2])) : (V) invokeI.objValue;
    }

    private void resizeMeMaybe(int i2) {
        int length;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(65552, this, i2) == null) || i2 <= (length = this.entries.length)) {
            return;
        }
        int max = Math.max(1, length >>> 1) + length;
        if (max < 0) {
            max = Integer.MAX_VALUE;
        }
        if (max != length) {
            resizeEntries(max);
        }
    }

    private void resizeTable(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65553, this, i2) == null) {
            int[] newTable = newTable(i2);
            long[] jArr = this.entries;
            int length = newTable.length - 1;
            for (int i3 = 0; i3 < this.size; i3++) {
                int hash = getHash(jArr[i3]);
                int i4 = hash & length;
                int i5 = newTable[i4];
                newTable[i4] = i3;
                jArr[i3] = (hash << 32) | (i5 & 4294967295L);
            }
            this.table = newTable;
        }
    }

    public static long swapNext(long j, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65554, null, new Object[]{Long.valueOf(j), Integer.valueOf(i2)})) == null) ? (j & (-4294967296L)) | (i2 & 4294967295L) : invokeCommon.longValue;
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65555, this, objectOutputStream) == null) {
            objectOutputStream.defaultWriteObject();
            objectOutputStream.writeInt(this.size);
            int firstEntryIndex = firstEntryIndex();
            while (firstEntryIndex >= 0) {
                objectOutputStream.writeObject(this.keys[firstEntryIndex]);
                objectOutputStream.writeObject(this.values[firstEntryIndex]);
                firstEntryIndex = getSuccessor(firstEntryIndex);
            }
        }
    }

    public void accessEntry(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
        }
    }

    public int adjustAfterRemove(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeII = interceptable.invokeII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, i3)) == null) ? i2 - 1 : invokeII.intValue;
    }

    public void allocArrays() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            n.x(needsAllocArrays(), "Arrays already allocated");
            int i2 = this.modCount;
            this.table = newTable(n0.a(i2, 1.0d));
            this.entries = newEntries(i2);
            this.keys = new Object[i2];
            this.values = new Object[i2];
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || needsAllocArrays()) {
            return;
        }
        this.modCount++;
        Arrays.fill(this.keys, 0, this.size, (Object) null);
        Arrays.fill(this.values, 0, this.size, (Object) null);
        Arrays.fill(this.table, -1);
        Arrays.fill(this.entries, 0, this.size, -1L);
        this.size = 0;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, obj)) == null) ? indexOf(obj) != -1 : invokeL.booleanValue;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsValue(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, obj)) == null) {
            for (int i2 = 0; i2 < this.size; i2++) {
                if (k.a(obj, this.values[i2])) {
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public Set<Map.Entry<K, V>> createEntrySet() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? new d(this) : (Set) invokeV.objValue;
    }

    public Set<K> createKeySet() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? new f(this) : (Set) invokeV.objValue;
    }

    public Collection<V> createValues() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? new h(this) : (Collection) invokeV.objValue;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            Set<Map.Entry<K, V>> set = this.entrySetView;
            if (set == null) {
                Set<Map.Entry<K, V>> createEntrySet = createEntrySet();
                this.entrySetView = createEntrySet;
                return createEntrySet;
            }
            return set;
        }
        return (Set) invokeV.objValue;
    }

    public Iterator<Map.Entry<K, V>> entrySetIterator() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? new b(this) : (Iterator) invokeV.objValue;
    }

    public int firstEntryIndex() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? isEmpty() ? -1 : 0 : invokeV.intValue;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V get(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, obj)) == null) {
            int indexOf = indexOf(obj);
            accessEntry(indexOf);
            if (indexOf == -1) {
                return null;
            }
            return (V) this.values[indexOf];
        }
        return (V) invokeL.objValue;
    }

    public int getSuccessor(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048589, this, i2)) == null) {
            int i3 = i2 + 1;
            if (i3 < this.size) {
                return i3;
            }
            return -1;
        }
        return invokeI.intValue;
    }

    public void init(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i2) == null) {
            n.e(i2 >= 0, "Expected size must be non-negative");
            this.modCount = Math.max(1, i2);
        }
    }

    public void insertEntry(int i2, K k, V v, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048591, this, new Object[]{Integer.valueOf(i2), k, v, Integer.valueOf(i3)}) == null) {
            this.entries[i2] = (i3 << 32) | 4294967295L;
            this.keys[i2] = k;
            this.values[i2] = v;
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean isEmpty() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.size == 0 : invokeV.booleanValue;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<K> keySet() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            Set<K> set = this.keySetView;
            if (set == null) {
                Set<K> createKeySet = createKeySet();
                this.keySetView = createKeySet;
                return createKeySet;
            }
            return set;
        }
        return (Set) invokeV.objValue;
    }

    public Iterator<K> keySetIterator() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? new a(this) : (Iterator) invokeV.objValue;
    }

    public void moveLastEntry(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeI(1048595, this, i2) != null) {
            return;
        }
        int size = size() - 1;
        if (i2 < size) {
            Object[] objArr = this.keys;
            objArr[i2] = objArr[size];
            Object[] objArr2 = this.values;
            objArr2[i2] = objArr2[size];
            objArr[size] = null;
            objArr2[size] = null;
            long[] jArr = this.entries;
            long j = jArr[size];
            jArr[i2] = j;
            jArr[size] = -1;
            int hash = getHash(j) & hashTableMask();
            int[] iArr = this.table;
            int i3 = iArr[hash];
            if (i3 == size) {
                iArr[hash] = i2;
                return;
            }
            while (true) {
                long j2 = this.entries[i3];
                int next = getNext(j2);
                if (next == size) {
                    this.entries[i3] = swapNext(j2, i2);
                    return;
                }
                i3 = next;
            }
        } else {
            this.keys[i2] = null;
            this.values[i2] = null;
            this.entries[i2] = -1;
        }
    }

    public boolean needsAllocArrays() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.table == null : invokeV.booleanValue;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V put(K k, V v) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048597, this, k, v)) == null) {
            if (needsAllocArrays()) {
                allocArrays();
            }
            long[] jArr = this.entries;
            Object[] objArr = this.keys;
            Object[] objArr2 = this.values;
            int d2 = n0.d(k);
            int hashTableMask = hashTableMask() & d2;
            int i2 = this.size;
            int[] iArr = this.table;
            int i3 = iArr[hashTableMask];
            if (i3 == -1) {
                iArr[hashTableMask] = i2;
            } else {
                while (true) {
                    long j = jArr[i3];
                    if (getHash(j) == d2 && k.a(k, objArr[i3])) {
                        V v2 = (V) objArr2[i3];
                        objArr2[i3] = v;
                        accessEntry(i3);
                        return v2;
                    }
                    int next = getNext(j);
                    if (next == -1) {
                        jArr[i3] = swapNext(j, i2);
                        break;
                    }
                    i3 = next;
                }
            }
            if (i2 != Integer.MAX_VALUE) {
                int i4 = i2 + 1;
                resizeMeMaybe(i4);
                insertEntry(i2, k, v, d2);
                this.size = i4;
                int length = this.table.length;
                if (n0.b(i2, length, 1.0d)) {
                    resizeTable(length * 2);
                }
                this.modCount++;
                return null;
            }
            throw new IllegalStateException("Cannot contain more than Integer.MAX_VALUE elements!");
        }
        return (V) invokeLL.objValue;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V remove(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048598, this, obj)) == null) {
            if (needsAllocArrays()) {
                return null;
            }
            return remove(obj, n0.d(obj));
        }
        return (V) invokeL.objValue;
    }

    public void resizeEntries(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048599, this, i2) == null) {
            this.keys = Arrays.copyOf(this.keys, i2);
            this.values = Arrays.copyOf(this.values, i2);
            long[] jArr = this.entries;
            int length = jArr.length;
            long[] copyOf = Arrays.copyOf(jArr, i2);
            if (i2 > length) {
                Arrays.fill(copyOf, length, i2, -1L);
            }
            this.entries = copyOf;
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int size() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? this.size : invokeV.intValue;
    }

    public void trimToSize() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048601, this) == null) || needsAllocArrays()) {
            return;
        }
        int i2 = this.size;
        if (i2 < this.entries.length) {
            resizeEntries(i2);
        }
        int a2 = n0.a(i2, 1.0d);
        if (a2 < this.table.length) {
            resizeTable(a2);
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Collection<V> values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
            Collection<V> collection = this.valuesView;
            if (collection == null) {
                Collection<V> createValues = createValues();
                this.valuesView = createValues;
                return createValues;
            }
            return collection;
        }
        return (Collection) invokeV.objValue;
    }

    public Iterator<V> valuesIterator() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) ? new c(this) : (Iterator) invokeV.objValue;
    }

    public CompactHashMap(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        init(i2);
    }

    private V remove(Object obj, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeLI = interceptable.invokeLI(65550, this, obj, i2)) != null) {
            return (V) invokeLI.objValue;
        }
        int hashTableMask = hashTableMask() & i2;
        int i3 = this.table[hashTableMask];
        if (i3 == -1) {
            return null;
        }
        int i4 = -1;
        while (true) {
            if (getHash(this.entries[i3]) == i2 && k.a(obj, this.keys[i3])) {
                V v = (V) this.values[i3];
                if (i4 == -1) {
                    this.table[hashTableMask] = getNext(this.entries[i3]);
                } else {
                    long[] jArr = this.entries;
                    jArr[i4] = swapNext(jArr[i4], getNext(jArr[i3]));
                }
                moveLastEntry(i3);
                this.size--;
                this.modCount++;
                return v;
            }
            int next = getNext(this.entries[i3]);
            if (next == -1) {
                return null;
            }
            i4 = i3;
            i3 = next;
        }
    }

    /* loaded from: classes7.dex */
    public abstract class e<T> implements Iterator<T> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public int f33042e;

        /* renamed from: f  reason: collision with root package name */
        public int f33043f;

        /* renamed from: g  reason: collision with root package name */
        public int f33044g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ CompactHashMap f33045h;

        public e(CompactHashMap compactHashMap) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {compactHashMap};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f33045h = compactHashMap;
            CompactHashMap compactHashMap2 = this.f33045h;
            this.f33042e = compactHashMap2.modCount;
            this.f33043f = compactHashMap2.firstEntryIndex();
            this.f33044g = -1;
        }

        public final void a() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.f33045h.modCount != this.f33042e) {
                throw new ConcurrentModificationException();
            }
        }

        public abstract T b(int i2);

        @Override // java.util.Iterator
        public boolean hasNext() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f33043f >= 0 : invokeV.booleanValue;
        }

        @Override // java.util.Iterator
        public T next() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                a();
                if (hasNext()) {
                    int i2 = this.f33043f;
                    this.f33044g = i2;
                    T b2 = b(i2);
                    this.f33043f = this.f33045h.getSuccessor(this.f33043f);
                    return b2;
                }
                throw new NoSuchElementException();
            }
            return (T) invokeV.objValue;
        }

        @Override // java.util.Iterator
        public void remove() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
                a();
                m.e(this.f33044g >= 0);
                this.f33042e++;
                this.f33045h.removeEntry(this.f33044g);
                this.f33043f = this.f33045h.adjustAfterRemove(this.f33043f, this.f33044g);
                this.f33044g = -1;
            }
        }

        public /* synthetic */ e(CompactHashMap compactHashMap, a aVar) {
            this(compactHashMap);
        }
    }
}
