package com.google.common.collect;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.f.d.a.n;
import d.f.d.c.m;
import d.f.d.c.n0;
import d.f.d.c.o1;
import java.util.AbstractMap;
import java.util.Arrays;
import java.util.Map;
import kotlin.UShort;
/* loaded from: classes7.dex */
public final class RegularImmutableMap<K, V> extends ImmutableMap<K, V> {
    public static /* synthetic */ Interceptable $ic = null;
    public static final byte ABSENT = -1;
    public static final int BYTE_MASK = 255;
    public static final int BYTE_MAX_SIZE = 128;
    public static final ImmutableMap<Object, Object> EMPTY;
    public static final int SHORT_MASK = 65535;
    public static final int SHORT_MAX_SIZE = 32768;
    public static final long serialVersionUID = 0;
    public transient /* synthetic */ FieldHolder $fh;
    public final transient Object[] alternatingKeysAndValues;
    public final transient Object hashTable;
    public final transient int size;

    /* loaded from: classes7.dex */
    public static class EntrySet<K, V> extends ImmutableSet<Map.Entry<K, V>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final transient Object[] alternatingKeysAndValues;
        public final transient int keyOffset;
        public final transient ImmutableMap<K, V> map;
        public final transient int size;

        public EntrySet(ImmutableMap<K, V> immutableMap, Object[] objArr, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr2 = {immutableMap, objArr, Integer.valueOf(i2), Integer.valueOf(i3)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.map = immutableMap;
            this.alternatingKeysAndValues = objArr;
            this.keyOffset = i2;
            this.size = i3;
        }

        @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, obj)) == null) {
                if (obj instanceof Map.Entry) {
                    Map.Entry entry = (Map.Entry) obj;
                    Object key = entry.getKey();
                    Object value = entry.getValue();
                    return value != null && value.equals(this.map.get(key));
                }
                return false;
            }
            return invokeL.booleanValue;
        }

        @Override // com.google.common.collect.ImmutableCollection
        public int copyIntoArray(Object[] objArr, int i2) {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, objArr, i2)) == null) ? asList().copyIntoArray(objArr, i2) : invokeLI.intValue;
        }

        @Override // com.google.common.collect.ImmutableSet
        public ImmutableList<Map.Entry<K, V>> createAsList() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? new ImmutableList<Map.Entry<K, V>>(this) { // from class: com.google.common.collect.RegularImmutableMap.EntrySet.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ EntrySet this$0;

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

                @Override // com.google.common.collect.ImmutableCollection
                public boolean isPartialView() {
                    InterceptResult invokeV2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV2 = interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                        return true;
                    }
                    return invokeV2.booleanValue;
                }

                @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
                public int size() {
                    InterceptResult invokeV2;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeV2 = interceptable2.invokeV(1048579, this)) == null) ? this.this$0.size : invokeV2.intValue;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // java.util.List
                public Map.Entry<K, V> get(int i2) {
                    InterceptResult invokeI;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeI = interceptable2.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) {
                        n.n(i2, this.this$0.size);
                        int i3 = i2 * 2;
                        return new AbstractMap.SimpleImmutableEntry(this.this$0.alternatingKeysAndValues[this.this$0.keyOffset + i3], this.this$0.alternatingKeysAndValues[i3 + (this.this$0.keyOffset ^ 1)]);
                    }
                    return (Map.Entry) invokeI.objValue;
                }
            } : (ImmutableList) invokeV.objValue;
        }

        @Override // com.google.common.collect.ImmutableCollection
        public boolean isPartialView() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                return true;
            }
            return invokeV.booleanValue;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.size : invokeV.intValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set, java.util.NavigableSet
        public o1<Map.Entry<K, V>> iterator() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? asList().iterator() : (o1) invokeV.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public static final class KeySet<K> extends ImmutableSet<K> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final transient ImmutableList<K> list;
        public final transient ImmutableMap<K, ?> map;

        public KeySet(ImmutableMap<K, ?> immutableMap, ImmutableList<K> immutableList) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {immutableMap, immutableList};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.map = immutableMap;
            this.list = immutableList;
        }

        @Override // com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection
        public ImmutableList<K> asList() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.list : (ImmutableList) invokeV.objValue;
        }

        @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj)) == null) ? this.map.get(obj) != null : invokeL.booleanValue;
        }

        @Override // com.google.common.collect.ImmutableCollection
        public int copyIntoArray(Object[] objArr, int i2) {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, objArr, i2)) == null) ? asList().copyIntoArray(objArr, i2) : invokeLI.intValue;
        }

        @Override // com.google.common.collect.ImmutableCollection
        public boolean isPartialView() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                return true;
            }
            return invokeV.booleanValue;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.map.size() : invokeV.intValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set, java.util.NavigableSet
        public o1<K> iterator() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? asList().iterator() : (o1) invokeV.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public static final class KeysOrValuesAsList extends ImmutableList<Object> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final transient Object[] alternatingKeysAndValues;
        public final transient int offset;
        public final transient int size;

        public KeysOrValuesAsList(Object[] objArr, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr2 = {objArr, Integer.valueOf(i2), Integer.valueOf(i3)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.alternatingKeysAndValues = objArr;
            this.offset = i2;
            this.size = i3;
        }

        @Override // java.util.List
        public Object get(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
                n.n(i2, this.size);
                return this.alternatingKeysAndValues[(i2 * 2) + this.offset];
            }
            return invokeI.objValue;
        }

        @Override // com.google.common.collect.ImmutableCollection
        public boolean isPartialView() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return true;
            }
            return invokeV.booleanValue;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.size : invokeV.intValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(547349010, "Lcom/google/common/collect/RegularImmutableMap;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(547349010, "Lcom/google/common/collect/RegularImmutableMap;");
                return;
            }
        }
        EMPTY = new RegularImmutableMap(null, new Object[0], 0);
    }

    public RegularImmutableMap(Object obj, Object[] objArr, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr2 = {obj, objArr, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.hashTable = obj;
        this.alternatingKeysAndValues = objArr;
        this.size = i2;
    }

    public static <K, V> RegularImmutableMap<K, V> create(int i2, Object[] objArr) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(65538, null, i2, objArr)) == null) {
            if (i2 == 0) {
                return (RegularImmutableMap) EMPTY;
            }
            if (i2 == 1) {
                m.a(objArr[0], objArr[1]);
                return new RegularImmutableMap<>(null, objArr, 1);
            }
            n.t(i2, objArr.length >> 1);
            return new RegularImmutableMap<>(createHashTable(objArr, i2, ImmutableSet.chooseTableSize(i2), 0), objArr, i2);
        }
        return (RegularImmutableMap) invokeIL.objValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x003d, code lost:
        r11[r5] = (byte) r1;
        r2 = r2 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x007d, code lost:
        r11[r5] = (short) r1;
        r2 = r2 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x00b4, code lost:
        r11[r6] = r1;
        r2 = r2 + 1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Object createHashTable(Object[] objArr, int i2, int i3, int i4) {
        InterceptResult invokeLIII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIII = interceptable.invokeLIII(65539, null, objArr, i2, i3, i4)) == null) {
            if (i2 == 1) {
                m.a(objArr[i4], objArr[i4 ^ 1]);
                return null;
            }
            int i5 = i3 - 1;
            int i6 = 0;
            if (i3 <= 128) {
                byte[] bArr = new byte[i3];
                Arrays.fill(bArr, (byte) -1);
                while (i6 < i2) {
                    int i7 = (i6 * 2) + i4;
                    Object obj = objArr[i7];
                    Object obj2 = objArr[i7 ^ 1];
                    m.a(obj, obj2);
                    int c2 = n0.c(obj.hashCode());
                    while (true) {
                        int i8 = c2 & i5;
                        int i9 = bArr[i8] & 255;
                        if (i9 == 255) {
                            break;
                        } else if (objArr[i9].equals(obj)) {
                            throw duplicateKeyException(obj, obj2, objArr, i9);
                        } else {
                            c2 = i8 + 1;
                        }
                    }
                }
                return bArr;
            } else if (i3 <= 32768) {
                short[] sArr = new short[i3];
                Arrays.fill(sArr, (short) -1);
                while (i6 < i2) {
                    int i10 = (i6 * 2) + i4;
                    Object obj3 = objArr[i10];
                    Object obj4 = objArr[i10 ^ 1];
                    m.a(obj3, obj4);
                    int c3 = n0.c(obj3.hashCode());
                    while (true) {
                        int i11 = c3 & i5;
                        int i12 = sArr[i11] & UShort.MAX_VALUE;
                        if (i12 == 65535) {
                            break;
                        } else if (objArr[i12].equals(obj3)) {
                            throw duplicateKeyException(obj3, obj4, objArr, i12);
                        } else {
                            c3 = i11 + 1;
                        }
                    }
                }
                return sArr;
            } else {
                int[] iArr = new int[i3];
                Arrays.fill(iArr, -1);
                while (i6 < i2) {
                    int i13 = (i6 * 2) + i4;
                    Object obj5 = objArr[i13];
                    Object obj6 = objArr[i13 ^ 1];
                    m.a(obj5, obj6);
                    int c4 = n0.c(obj5.hashCode());
                    while (true) {
                        int i14 = c4 & i5;
                        int i15 = iArr[i14];
                        if (i15 == -1) {
                            break;
                        } else if (objArr[i15].equals(obj5)) {
                            throw duplicateKeyException(obj5, obj6, objArr, i15);
                        } else {
                            c4 = i14 + 1;
                        }
                    }
                }
                return iArr;
            }
        }
        return invokeLIII.objValue;
    }

    public static IllegalArgumentException duplicateKeyException(Object obj, Object obj2, Object[] objArr, int i2) {
        InterceptResult invokeLLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLI = interceptable.invokeLLLI(65540, null, obj, obj2, objArr, i2)) == null) {
            return new IllegalArgumentException("Multiple entries with same key: " + obj + "=" + obj2 + " and " + objArr[i2] + "=" + objArr[i2 ^ 1]);
        }
        return (IllegalArgumentException) invokeLLLI.objValue;
    }

    @Override // com.google.common.collect.ImmutableMap
    public ImmutableSet<Map.Entry<K, V>> createEntrySet() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? new EntrySet(this, this.alternatingKeysAndValues, 0, this.size) : (ImmutableSet) invokeV.objValue;
    }

    @Override // com.google.common.collect.ImmutableMap
    public ImmutableSet<K> createKeySet() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? new KeySet(this, new KeysOrValuesAsList(this.alternatingKeysAndValues, 0, this.size)) : (ImmutableSet) invokeV.objValue;
    }

    @Override // com.google.common.collect.ImmutableMap
    public ImmutableCollection<V> createValues() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? new KeysOrValuesAsList(this.alternatingKeysAndValues, 1, this.size) : (ImmutableCollection) invokeV.objValue;
    }

    @Override // com.google.common.collect.ImmutableMap, java.util.Map
    public V get(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, obj)) == null) ? (V) get(this.hashTable, this.alternatingKeysAndValues, this.size, 0, obj) : (V) invokeL.objValue;
    }

    @Override // com.google.common.collect.ImmutableMap
    public boolean isPartialView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // java.util.Map
    public int size() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.size : invokeV.intValue;
    }

    public static Object get(Object obj, Object[] objArr, int i2, int i3, Object obj2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeCommon = interceptable.invokeCommon(AdIconUtil.AD_TEXT_ID, null, new Object[]{obj, objArr, Integer.valueOf(i2), Integer.valueOf(i3), obj2})) != null) {
            return invokeCommon.objValue;
        }
        if (obj2 == null) {
            return null;
        }
        if (i2 == 1) {
            if (objArr[i3].equals(obj2)) {
                return objArr[i3 ^ 1];
            }
            return null;
        } else if (obj == null) {
            return null;
        } else {
            if (obj instanceof byte[]) {
                byte[] bArr = (byte[]) obj;
                int length = bArr.length - 1;
                int c2 = n0.c(obj2.hashCode());
                while (true) {
                    int i4 = c2 & length;
                    int i5 = bArr[i4] & 255;
                    if (i5 == 255) {
                        return null;
                    }
                    if (objArr[i5].equals(obj2)) {
                        return objArr[i5 ^ 1];
                    }
                    c2 = i4 + 1;
                }
            } else if (obj instanceof short[]) {
                short[] sArr = (short[]) obj;
                int length2 = sArr.length - 1;
                int c3 = n0.c(obj2.hashCode());
                while (true) {
                    int i6 = c3 & length2;
                    int i7 = sArr[i6] & UShort.MAX_VALUE;
                    if (i7 == 65535) {
                        return null;
                    }
                    if (objArr[i7].equals(obj2)) {
                        return objArr[i7 ^ 1];
                    }
                    c3 = i6 + 1;
                }
            } else {
                int[] iArr = (int[]) obj;
                int length3 = iArr.length - 1;
                int c4 = n0.c(obj2.hashCode());
                while (true) {
                    int i8 = c4 & length3;
                    int i9 = iArr[i8];
                    if (i9 == -1) {
                        return null;
                    }
                    if (objArr[i9].equals(obj2)) {
                        return objArr[i9 ^ 1];
                    }
                    c4 = i8 + 1;
                }
            }
        }
    }
}
