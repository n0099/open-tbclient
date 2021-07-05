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
import d.f.d.c.u0;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.AbstractSet;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
/* loaded from: classes7.dex */
public class CompactHashSet<E> extends AbstractSet<E> implements Serializable {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int DEFAULT_SIZE = 3;
    public static final long HASH_MASK = -4294967296L;
    public static final float LOAD_FACTOR = 1.0f;
    public static final long NEXT_MASK = 4294967295L;
    public static final int UNSET = -1;
    public transient /* synthetic */ FieldHolder $fh;
    public transient Object[] elements;
    public transient long[] entries;
    public transient int modCount;
    public transient int size;
    public transient int[] table;

    /* loaded from: classes7.dex */
    public class a implements Iterator<E> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public int f33051e;

        /* renamed from: f  reason: collision with root package name */
        public int f33052f;

        /* renamed from: g  reason: collision with root package name */
        public int f33053g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ CompactHashSet f33054h;

        public a(CompactHashSet compactHashSet) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {compactHashSet};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f33054h = compactHashSet;
            CompactHashSet compactHashSet2 = this.f33054h;
            this.f33051e = compactHashSet2.modCount;
            this.f33052f = compactHashSet2.firstEntryIndex();
            this.f33053g = -1;
        }

        public final void a() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.f33054h.modCount != this.f33051e) {
                throw new ConcurrentModificationException();
            }
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f33052f >= 0 : invokeV.booleanValue;
        }

        @Override // java.util.Iterator
        public E next() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                a();
                if (hasNext()) {
                    int i2 = this.f33052f;
                    this.f33053g = i2;
                    CompactHashSet compactHashSet = this.f33054h;
                    E e2 = (E) compactHashSet.elements[i2];
                    this.f33052f = compactHashSet.getSuccessor(i2);
                    return e2;
                }
                throw new NoSuchElementException();
            }
            return (E) invokeV.objValue;
        }

        @Override // java.util.Iterator
        public void remove() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                a();
                m.e(this.f33053g >= 0);
                this.f33051e++;
                CompactHashSet compactHashSet = this.f33054h;
                compactHashSet.remove(compactHashSet.elements[this.f33053g], CompactHashSet.getHash(compactHashSet.entries[this.f33053g]));
                this.f33052f = this.f33054h.adjustAfterRemove(this.f33052f, this.f33053g);
                this.f33053g = -1;
            }
        }
    }

    public CompactHashSet() {
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

    public static <E> CompactHashSet<E> create() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.AD_TEXT_ID, null)) == null) ? new CompactHashSet<>() : (CompactHashSet) invokeV.objValue;
    }

    public static <E> CompactHashSet<E> createWithExpectedSize(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65544, null, i2)) == null) ? new CompactHashSet<>(i2) : (CompactHashSet) invokeI.objValue;
    }

    public static int getHash(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJ = interceptable.invokeJ(65545, null, j)) == null) ? (int) (j >>> 32) : invokeJ.intValue;
    }

    public static int getNext(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJ = interceptable.invokeJ(65546, null, j)) == null) ? (int) j : invokeJ.intValue;
    }

    private int hashTableMask() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65547, this)) == null) ? this.table.length - 1 : invokeV.intValue;
    }

    public static long[] newEntries(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65548, null, i2)) == null) {
            long[] jArr = new long[i2];
            Arrays.fill(jArr, -1L);
            return jArr;
        }
        return (long[]) invokeI.objValue;
    }

    public static int[] newTable(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65549, null, i2)) == null) {
            int[] iArr = new int[i2];
            Arrays.fill(iArr, -1);
            return iArr;
        }
        return (int[]) invokeI.objValue;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: com.google.common.collect.CompactHashSet<E> */
    /* JADX WARN: Multi-variable type inference failed */
    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65550, this, objectInputStream) == null) {
            objectInputStream.defaultReadObject();
            int readInt = objectInputStream.readInt();
            if (readInt >= 0) {
                init(readInt);
                for (int i2 = 0; i2 < readInt; i2++) {
                    add(objectInputStream.readObject());
                }
                return;
            }
            throw new InvalidObjectException("Invalid size: " + readInt);
        }
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
                objectOutputStream.writeObject(this.elements[firstEntryIndex]);
                firstEntryIndex = getSuccessor(firstEntryIndex);
            }
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean add(E e2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, e2)) == null) {
            if (needsAllocArrays()) {
                allocArrays();
            }
            long[] jArr = this.entries;
            Object[] objArr = this.elements;
            int d2 = n0.d(e2);
            int hashTableMask = hashTableMask() & d2;
            int i2 = this.size;
            int[] iArr = this.table;
            int i3 = iArr[hashTableMask];
            if (i3 == -1) {
                iArr[hashTableMask] = i2;
            } else {
                while (true) {
                    long j = jArr[i3];
                    if (getHash(j) == d2 && k.a(e2, objArr[i3])) {
                        return false;
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
                insertEntry(i2, e2, d2);
                this.size = i4;
                int length = this.table.length;
                if (n0.b(i2, length, 1.0d)) {
                    resizeTable(length * 2);
                }
                this.modCount++;
                return true;
            }
            throw new IllegalStateException("Cannot contain more than Integer.MAX_VALUE elements!");
        }
        return invokeL.booleanValue;
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
            this.elements = new Object[i2];
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public void clear() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || needsAllocArrays()) {
            return;
        }
        this.modCount++;
        Arrays.fill(this.elements, 0, this.size, (Object) null);
        Arrays.fill(this.table, -1);
        Arrays.fill(this.entries, 0, this.size, -1L);
        this.size = 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, obj)) == null) {
            if (needsAllocArrays()) {
                return false;
            }
            int d2 = n0.d(obj);
            int i2 = this.table[hashTableMask() & d2];
            while (i2 != -1) {
                long j = this.entries[i2];
                if (getHash(j) == d2 && k.a(obj, this.elements[i2])) {
                    return true;
                }
                i2 = getNext(j);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public int firstEntryIndex() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? isEmpty() ? -1 : 0 : invokeV.intValue;
    }

    public int getSuccessor(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i2)) == null) {
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
        if (interceptable == null || interceptable.invokeI(1048583, this, i2) == null) {
            n.e(i2 >= 0, "Initial capacity must be non-negative");
            this.modCount = Math.max(1, i2);
        }
    }

    public void insertEntry(int i2, E e2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{Integer.valueOf(i2), e2, Integer.valueOf(i3)}) == null) {
            this.entries[i2] = (i3 << 32) | 4294967295L;
            this.elements[i2] = e2;
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean isEmpty() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.size == 0 : invokeV.booleanValue;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public Iterator<E> iterator() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? new a(this) : (Iterator) invokeV.objValue;
    }

    public void moveLastEntry(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeI(1048587, this, i2) != null) {
            return;
        }
        int size = size() - 1;
        if (i2 < size) {
            Object[] objArr = this.elements;
            objArr[i2] = objArr[size];
            objArr[size] = null;
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
            this.elements[i2] = null;
            this.entries[i2] = -1;
        }
    }

    public boolean needsAllocArrays() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.table == null : invokeV.booleanValue;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean remove(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, obj)) == null) {
            if (needsAllocArrays()) {
                return false;
            }
            return remove(obj, n0.d(obj));
        }
        return invokeL.booleanValue;
    }

    public void resizeEntries(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i2) == null) {
            this.elements = Arrays.copyOf(this.elements, i2);
            long[] jArr = this.entries;
            int length = jArr.length;
            long[] copyOf = Arrays.copyOf(jArr, i2);
            if (i2 > length) {
                Arrays.fill(copyOf, length, i2, -1L);
            }
            this.entries = copyOf;
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public int size() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.size : invokeV.intValue;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public Object[] toArray() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? needsAllocArrays() ? new Object[0] : Arrays.copyOf(this.elements, this.size) : (Object[]) invokeV.objValue;
    }

    public void trimToSize() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048594, this) == null) || needsAllocArrays()) {
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

    public static <E> CompactHashSet<E> create(Collection<? extends E> collection) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, collection)) == null) {
            CompactHashSet<E> createWithExpectedSize = createWithExpectedSize(collection.size());
            createWithExpectedSize.addAll(collection);
            return createWithExpectedSize;
        }
        return (CompactHashSet) invokeL.objValue;
    }

    public CompactHashSet(int i2) {
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

    /* JADX INFO: Access modifiers changed from: private */
    public boolean remove(Object obj, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeLI = interceptable.invokeLI(65551, this, obj, i2)) != null) {
            return invokeLI.booleanValue;
        }
        int hashTableMask = hashTableMask() & i2;
        int i3 = this.table[hashTableMask];
        if (i3 == -1) {
            return false;
        }
        int i4 = -1;
        while (true) {
            if (getHash(this.entries[i3]) == i2 && k.a(obj, this.elements[i3])) {
                if (i4 == -1) {
                    this.table[hashTableMask] = getNext(this.entries[i3]);
                } else {
                    long[] jArr = this.entries;
                    jArr[i4] = swapNext(jArr[i4], getNext(jArr[i3]));
                }
                moveLastEntry(i3);
                this.size--;
                this.modCount++;
                return true;
            }
            int next = getNext(this.entries[i3]);
            if (next == -1) {
                return false;
            }
            i4 = i3;
            i3 = next;
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public <T> T[] toArray(T[] tArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, tArr)) == null) {
            if (needsAllocArrays()) {
                if (tArr.length > 0) {
                    tArr[0] = null;
                }
                return tArr;
            }
            return (T[]) u0.j(this.elements, 0, this.size, tArr);
        }
        return (T[]) ((Object[]) invokeL.objValue);
    }

    public static <E> CompactHashSet<E> create(E... eArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, eArr)) == null) {
            CompactHashSet<E> createWithExpectedSize = createWithExpectedSize(eArr.length);
            Collections.addAll(createWithExpectedSize, eArr);
            return createWithExpectedSize;
        }
        return (CompactHashSet) invokeL.objValue;
    }
}
