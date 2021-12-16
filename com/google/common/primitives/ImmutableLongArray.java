package com.google.common.primitives;

import androidx.core.view.InputDeviceCompat;
import c.i.d.a.n;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Serializable;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.RandomAccess;
/* loaded from: classes3.dex */
public final class ImmutableLongArray implements Serializable {
    public static /* synthetic */ Interceptable $ic;
    public static final ImmutableLongArray EMPTY;
    public transient /* synthetic */ FieldHolder $fh;
    public final long[] array;
    public final int end;
    public final transient int start;

    /* loaded from: classes3.dex */
    public static class AsList extends AbstractList<Long> implements RandomAccess, Serializable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final ImmutableLongArray parent;

        public /* synthetic */ AsList(ImmutableLongArray immutableLongArray, a aVar) {
            this(immutableLongArray);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean contains(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, obj)) == null) ? indexOf(obj) >= 0 : invokeL.booleanValue;
        }

        @Override // java.util.AbstractList, java.util.Collection, java.util.List
        public boolean equals(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj)) == null) {
                if (obj instanceof AsList) {
                    return this.parent.equals(((AsList) obj).parent);
                }
                if (obj instanceof List) {
                    List list = (List) obj;
                    if (size() != list.size()) {
                        return false;
                    }
                    int i2 = this.parent.start;
                    for (Object obj2 : list) {
                        if (obj2 instanceof Long) {
                            int i3 = i2 + 1;
                            if (this.parent.array[i2] == ((Long) obj2).longValue()) {
                                i2 = i3;
                            }
                        }
                        return false;
                    }
                    return true;
                }
                return false;
            }
            return invokeL.booleanValue;
        }

        @Override // java.util.AbstractList, java.util.Collection, java.util.List
        public int hashCode() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.parent.hashCode() : invokeV.intValue;
        }

        @Override // java.util.AbstractList, java.util.List
        public int indexOf(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, obj)) == null) {
                if (obj instanceof Long) {
                    return this.parent.indexOf(((Long) obj).longValue());
                }
                return -1;
            }
            return invokeL.intValue;
        }

        @Override // java.util.AbstractList, java.util.List
        public int lastIndexOf(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, obj)) == null) {
                if (obj instanceof Long) {
                    return this.parent.lastIndexOf(((Long) obj).longValue());
                }
                return -1;
            }
            return invokeL.intValue;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.parent.length() : invokeV.intValue;
        }

        @Override // java.util.AbstractList, java.util.List
        public List<Long> subList(int i2, int i3) {
            InterceptResult invokeII;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeII = interceptable.invokeII(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2, i3)) == null) ? this.parent.subArray(i2, i3).asList() : (List) invokeII.objValue;
        }

        @Override // java.util.AbstractCollection
        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.parent.toString() : (String) invokeV.objValue;
        }

        public AsList(ImmutableLongArray immutableLongArray) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {immutableLongArray};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.parent = immutableLongArray;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.AbstractList, java.util.List
        public Long get(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) ? Long.valueOf(this.parent.get(i2)) : (Long) invokeI.objValue;
        }
    }

    /* loaded from: classes3.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes3.dex */
    public static final class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public long[] a;

        /* renamed from: b  reason: collision with root package name */
        public int f57084b;

        public b(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f57084b = 0;
            this.a = new long[i2];
        }

        public static int f(int i2, int i3) {
            InterceptResult invokeII;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeII = interceptable.invokeII(65537, null, i2, i3)) == null) {
                if (i3 >= 0) {
                    int i4 = i2 + (i2 >> 1) + 1;
                    if (i4 < i3) {
                        i4 = Integer.highestOneBit(i3 - 1) << 1;
                    }
                    if (i4 < 0) {
                        return Integer.MAX_VALUE;
                    }
                    return i4;
                }
                throw new AssertionError("cannot store more than MAX_VALUE elements");
            }
            return invokeII.intValue;
        }

        public b a(long j2) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJ = interceptable.invokeJ(1048576, this, j2)) == null) {
                e(1);
                long[] jArr = this.a;
                int i2 = this.f57084b;
                jArr[i2] = j2;
                this.f57084b = i2 + 1;
                return this;
            }
            return (b) invokeJ.objValue;
        }

        public b b(Iterable<Long> iterable) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, iterable)) == null) {
                if (iterable instanceof Collection) {
                    c((Collection) iterable);
                    return this;
                }
                for (Long l : iterable) {
                    a(l.longValue());
                }
                return this;
            }
            return (b) invokeL.objValue;
        }

        public b c(Collection<Long> collection) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, collection)) == null) {
                e(collection.size());
                for (Long l : collection) {
                    long[] jArr = this.a;
                    int i2 = this.f57084b;
                    this.f57084b = i2 + 1;
                    jArr[i2] = l.longValue();
                }
                return this;
            }
            return (b) invokeL.objValue;
        }

        public ImmutableLongArray d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f57084b == 0 ? ImmutableLongArray.EMPTY : new ImmutableLongArray(this.a, 0, this.f57084b, null) : (ImmutableLongArray) invokeV.objValue;
        }

        public final void e(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048580, this, i2) == null) {
                int i3 = this.f57084b + i2;
                long[] jArr = this.a;
                if (i3 > jArr.length) {
                    long[] jArr2 = new long[f(jArr.length, i3)];
                    System.arraycopy(this.a, 0, jArr2, 0, this.f57084b);
                    this.a = jArr2;
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1316146459, "Lcom/google/common/primitives/ImmutableLongArray;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1316146459, "Lcom/google/common/primitives/ImmutableLongArray;");
                return;
            }
        }
        EMPTY = new ImmutableLongArray(new long[0]);
    }

    public /* synthetic */ ImmutableLongArray(long[] jArr, int i2, int i3, a aVar) {
        this(jArr, i2, i3);
    }

    public static b builder(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65544, null, i2)) == null) {
            n.f(i2 >= 0, "Invalid initialCapacity: %s", i2);
            return new b(i2);
        }
        return (b) invokeI.objValue;
    }

    public static ImmutableLongArray copyOf(long[] jArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65547, null, jArr)) == null) ? jArr.length == 0 ? EMPTY : new ImmutableLongArray(Arrays.copyOf(jArr, jArr.length)) : (ImmutableLongArray) invokeL.objValue;
    }

    private boolean isPartialView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65548, this)) == null) ? this.start > 0 || this.end < this.array.length : invokeV.booleanValue;
    }

    public static ImmutableLongArray of() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65549, null)) == null) ? EMPTY : (ImmutableLongArray) invokeV.objValue;
    }

    public List<Long> asList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? new AsList(this, null) : (List) invokeV.objValue;
    }

    public boolean contains(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJ = interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j2)) == null) ? indexOf(j2) >= 0 : invokeJ.booleanValue;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, obj)) == null) {
            if (obj == this) {
                return true;
            }
            if (obj instanceof ImmutableLongArray) {
                ImmutableLongArray immutableLongArray = (ImmutableLongArray) obj;
                if (length() != immutableLongArray.length()) {
                    return false;
                }
                for (int i2 = 0; i2 < length(); i2++) {
                    if (get(i2) != immutableLongArray.get(i2)) {
                        return false;
                    }
                }
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public long get(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i2)) == null) {
            n.n(i2, length());
            return this.array[this.start + i2];
        }
        return invokeI.longValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            int i2 = 1;
            for (int i3 = this.start; i3 < this.end; i3++) {
                i2 = (i2 * 31) + Longs.e(this.array[i3]);
            }
            return i2;
        }
        return invokeV.intValue;
    }

    public int indexOf(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048581, this, j2)) == null) {
            for (int i2 = this.start; i2 < this.end; i2++) {
                if (this.array[i2] == j2) {
                    return i2 - this.start;
                }
            }
            return -1;
        }
        return invokeJ.intValue;
    }

    public boolean isEmpty() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.end == this.start : invokeV.booleanValue;
    }

    public int lastIndexOf(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeJ = interceptable.invokeJ(1048583, this, j2)) != null) {
            return invokeJ.intValue;
        }
        int i2 = this.end;
        while (true) {
            i2--;
            int i3 = this.start;
            if (i2 < i3) {
                return -1;
            }
            if (this.array[i2] == j2) {
                return i2 - i3;
            }
        }
    }

    public int length() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.end - this.start : invokeV.intValue;
    }

    public Object readResolve() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? isEmpty() ? EMPTY : this : invokeV.objValue;
    }

    public ImmutableLongArray subArray(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048586, this, i2, i3)) == null) {
            n.v(i2, i3, length());
            if (i2 == i3) {
                return EMPTY;
            }
            long[] jArr = this.array;
            int i4 = this.start;
            return new ImmutableLongArray(jArr, i2 + i4, i4 + i3);
        }
        return (ImmutableLongArray) invokeII.objValue;
    }

    public long[] toArray() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? Arrays.copyOfRange(this.array, this.start, this.end) : (long[]) invokeV.objValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeV = interceptable.invokeV(1048588, this)) != null) {
            return (String) invokeV.objValue;
        }
        if (isEmpty()) {
            return "[]";
        }
        StringBuilder sb = new StringBuilder(length() * 5);
        sb.append('[');
        sb.append(this.array[this.start]);
        int i2 = this.start;
        while (true) {
            i2++;
            if (i2 < this.end) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append(this.array[i2]);
            } else {
                sb.append(']');
                return sb.toString();
            }
        }
    }

    public ImmutableLongArray trimmed() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? isPartialView() ? new ImmutableLongArray(toArray()) : this : (ImmutableLongArray) invokeV.objValue;
    }

    public Object writeReplace() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? trimmed() : invokeV.objValue;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ImmutableLongArray(long[] jArr) {
        this(jArr, 0, jArr.length);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {jArr};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((long[]) objArr2[0], ((Integer) objArr2[1]).intValue(), ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public static ImmutableLongArray of(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJ = interceptable.invokeJ(65550, null, j2)) == null) ? new ImmutableLongArray(new long[]{j2}) : (ImmutableLongArray) invokeJ.objValue;
    }

    public ImmutableLongArray(long[] jArr, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {jArr, Integer.valueOf(i2), Integer.valueOf(i3)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.array = jArr;
        this.start = i2;
        this.end = i3;
    }

    public static b builder() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) ? new b(10) : (b) invokeV.objValue;
    }

    public static ImmutableLongArray copyOf(Collection<Long> collection) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65546, null, collection)) == null) ? collection.isEmpty() ? EMPTY : new ImmutableLongArray(Longs.h(collection)) : (ImmutableLongArray) invokeL.objValue;
    }

    public static ImmutableLongArray of(long j2, long j3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65551, null, new Object[]{Long.valueOf(j2), Long.valueOf(j3)})) == null) ? new ImmutableLongArray(new long[]{j2, j3}) : (ImmutableLongArray) invokeCommon.objValue;
    }

    public static ImmutableLongArray copyOf(Iterable<Long> iterable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, iterable)) == null) {
            if (iterable instanceof Collection) {
                return copyOf((Collection<Long>) iterable);
            }
            b builder = builder();
            builder.b(iterable);
            return builder.d();
        }
        return (ImmutableLongArray) invokeL.objValue;
    }

    public static ImmutableLongArray of(long j2, long j3, long j4) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65552, null, new Object[]{Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(j4)})) == null) ? new ImmutableLongArray(new long[]{j2, j3, j4}) : (ImmutableLongArray) invokeCommon.objValue;
    }

    public static ImmutableLongArray of(long j2, long j3, long j4, long j5) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65553, null, new Object[]{Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(j4), Long.valueOf(j5)})) == null) ? new ImmutableLongArray(new long[]{j2, j3, j4, j5}) : (ImmutableLongArray) invokeCommon.objValue;
    }

    public static ImmutableLongArray of(long j2, long j3, long j4, long j5, long j6) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65554, null, new Object[]{Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(j4), Long.valueOf(j5), Long.valueOf(j6)})) == null) ? new ImmutableLongArray(new long[]{j2, j3, j4, j5, j6}) : (ImmutableLongArray) invokeCommon.objValue;
    }

    public static ImmutableLongArray of(long j2, long j3, long j4, long j5, long j6, long j7) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65555, null, new Object[]{Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(j4), Long.valueOf(j5), Long.valueOf(j6), Long.valueOf(j7)})) == null) ? new ImmutableLongArray(new long[]{j2, j3, j4, j5, j6, j7}) : (ImmutableLongArray) invokeCommon.objValue;
    }

    public static ImmutableLongArray of(long j2, long... jArr) {
        InterceptResult invokeJL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJL = interceptable.invokeJL(65556, null, j2, jArr)) == null) {
            n.e(jArr.length <= 2147483646, "the total number of elements must fit in an int");
            long[] jArr2 = new long[jArr.length + 1];
            jArr2[0] = j2;
            System.arraycopy(jArr, 0, jArr2, 1, jArr.length);
            return new ImmutableLongArray(jArr2);
        }
        return (ImmutableLongArray) invokeJL.objValue;
    }
}
