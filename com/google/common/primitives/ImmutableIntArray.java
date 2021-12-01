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
/* loaded from: classes2.dex */
public final class ImmutableIntArray implements Serializable {
    public static /* synthetic */ Interceptable $ic;
    public static final ImmutableIntArray EMPTY;
    public transient /* synthetic */ FieldHolder $fh;
    public final int[] array;
    public final int end;
    public final transient int start;

    /* loaded from: classes2.dex */
    public static class AsList extends AbstractList<Integer> implements RandomAccess, Serializable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final ImmutableIntArray parent;

        public /* synthetic */ AsList(ImmutableIntArray immutableIntArray, a aVar) {
            this(immutableIntArray);
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
                        if (obj2 instanceof Integer) {
                            int i3 = i2 + 1;
                            if (this.parent.array[i2] == ((Integer) obj2).intValue()) {
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
                if (obj instanceof Integer) {
                    return this.parent.indexOf(((Integer) obj).intValue());
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
                if (obj instanceof Integer) {
                    return this.parent.lastIndexOf(((Integer) obj).intValue());
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
        public List<Integer> subList(int i2, int i3) {
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

        public AsList(ImmutableIntArray immutableIntArray) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {immutableIntArray};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.parent = immutableIntArray;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.AbstractList, java.util.List
        public Integer get(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) ? Integer.valueOf(this.parent.get(i2)) : (Integer) invokeI.objValue;
        }
    }

    /* loaded from: classes2.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes2.dex */
    public static final class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int[] a;

        /* renamed from: b  reason: collision with root package name */
        public int f56502b;

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
            this.f56502b = 0;
            this.a = new int[i2];
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

        public b a(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
                e(1);
                int[] iArr = this.a;
                int i3 = this.f56502b;
                iArr[i3] = i2;
                this.f56502b = i3 + 1;
                return this;
            }
            return (b) invokeI.objValue;
        }

        public b b(Iterable<Integer> iterable) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, iterable)) == null) {
                if (iterable instanceof Collection) {
                    c((Collection) iterable);
                    return this;
                }
                for (Integer num : iterable) {
                    a(num.intValue());
                }
                return this;
            }
            return (b) invokeL.objValue;
        }

        public b c(Collection<Integer> collection) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, collection)) == null) {
                e(collection.size());
                for (Integer num : collection) {
                    int[] iArr = this.a;
                    int i2 = this.f56502b;
                    this.f56502b = i2 + 1;
                    iArr[i2] = num.intValue();
                }
                return this;
            }
            return (b) invokeL.objValue;
        }

        public ImmutableIntArray d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f56502b == 0 ? ImmutableIntArray.EMPTY : new ImmutableIntArray(this.a, 0, this.f56502b, null) : (ImmutableIntArray) invokeV.objValue;
        }

        public final void e(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048580, this, i2) == null) {
                int i3 = this.f56502b + i2;
                int[] iArr = this.a;
                if (i3 > iArr.length) {
                    int[] iArr2 = new int[f(iArr.length, i3)];
                    System.arraycopy(this.a, 0, iArr2, 0, this.f56502b);
                    this.a = iArr2;
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(714986666, "Lcom/google/common/primitives/ImmutableIntArray;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(714986666, "Lcom/google/common/primitives/ImmutableIntArray;");
                return;
            }
        }
        EMPTY = new ImmutableIntArray(new int[0]);
    }

    public /* synthetic */ ImmutableIntArray(int[] iArr, int i2, int i3, a aVar) {
        this(iArr, i2, i3);
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

    public static ImmutableIntArray copyOf(int[] iArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65547, null, iArr)) == null) ? iArr.length == 0 ? EMPTY : new ImmutableIntArray(Arrays.copyOf(iArr, iArr.length)) : (ImmutableIntArray) invokeL.objValue;
    }

    private boolean isPartialView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65548, this)) == null) ? this.start > 0 || this.end < this.array.length : invokeV.booleanValue;
    }

    public static ImmutableIntArray of() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65549, null)) == null) ? EMPTY : (ImmutableIntArray) invokeV.objValue;
    }

    public List<Integer> asList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? new AsList(this, null) : (List) invokeV.objValue;
    }

    public boolean contains(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) ? indexOf(i2) >= 0 : invokeI.booleanValue;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, obj)) == null) {
            if (obj == this) {
                return true;
            }
            if (obj instanceof ImmutableIntArray) {
                ImmutableIntArray immutableIntArray = (ImmutableIntArray) obj;
                if (length() != immutableIntArray.length()) {
                    return false;
                }
                for (int i2 = 0; i2 < length(); i2++) {
                    if (get(i2) != immutableIntArray.get(i2)) {
                        return false;
                    }
                }
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public int get(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i2)) == null) {
            n.n(i2, length());
            return this.array[this.start + i2];
        }
        return invokeI.intValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            int i2 = 1;
            for (int i3 = this.start; i3 < this.end; i3++) {
                int i4 = this.array[i3];
                Ints.f(i4);
                i2 = (i2 * 31) + i4;
            }
            return i2;
        }
        return invokeV.intValue;
    }

    public int indexOf(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i2)) == null) {
            for (int i3 = this.start; i3 < this.end; i3++) {
                if (this.array[i3] == i2) {
                    return i3 - this.start;
                }
            }
            return -1;
        }
        return invokeI.intValue;
    }

    public boolean isEmpty() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.end == this.start : invokeV.booleanValue;
    }

    public int lastIndexOf(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeI = interceptable.invokeI(1048583, this, i2)) != null) {
            return invokeI.intValue;
        }
        int i3 = this.end;
        while (true) {
            i3--;
            int i4 = this.start;
            if (i3 < i4) {
                return -1;
            }
            if (this.array[i3] == i2) {
                return i3 - i4;
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

    public ImmutableIntArray subArray(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048586, this, i2, i3)) == null) {
            n.v(i2, i3, length());
            if (i2 == i3) {
                return EMPTY;
            }
            int[] iArr = this.array;
            int i4 = this.start;
            return new ImmutableIntArray(iArr, i2 + i4, i4 + i3);
        }
        return (ImmutableIntArray) invokeII.objValue;
    }

    public int[] toArray() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? Arrays.copyOfRange(this.array, this.start, this.end) : (int[]) invokeV.objValue;
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

    public ImmutableIntArray trimmed() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? isPartialView() ? new ImmutableIntArray(toArray()) : this : (ImmutableIntArray) invokeV.objValue;
    }

    public Object writeReplace() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? trimmed() : invokeV.objValue;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ImmutableIntArray(int[] iArr) {
        this(iArr, 0, iArr.length);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {iArr};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((int[]) objArr2[0], ((Integer) objArr2[1]).intValue(), ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public static ImmutableIntArray copyOf(Collection<Integer> collection) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65546, null, collection)) == null) ? collection.isEmpty() ? EMPTY : new ImmutableIntArray(Ints.k(collection)) : (ImmutableIntArray) invokeL.objValue;
    }

    public static ImmutableIntArray of(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65550, null, i2)) == null) ? new ImmutableIntArray(new int[]{i2}) : (ImmutableIntArray) invokeI.objValue;
    }

    public ImmutableIntArray(int[] iArr, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {iArr, Integer.valueOf(i2), Integer.valueOf(i3)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.array = iArr;
        this.start = i2;
        this.end = i3;
    }

    public static b builder() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) ? new b(10) : (b) invokeV.objValue;
    }

    public static ImmutableIntArray copyOf(Iterable<Integer> iterable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, iterable)) == null) {
            if (iterable instanceof Collection) {
                return copyOf((Collection<Integer>) iterable);
            }
            b builder = builder();
            builder.b(iterable);
            return builder.d();
        }
        return (ImmutableIntArray) invokeL.objValue;
    }

    public static ImmutableIntArray of(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeII = interceptable.invokeII(65551, null, i2, i3)) == null) ? new ImmutableIntArray(new int[]{i2, i3}) : (ImmutableIntArray) invokeII.objValue;
    }

    public static ImmutableIntArray of(int i2, int i3, int i4) {
        InterceptResult invokeIII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeIII = interceptable.invokeIII(65552, null, i2, i3, i4)) == null) ? new ImmutableIntArray(new int[]{i2, i3, i4}) : (ImmutableIntArray) invokeIII.objValue;
    }

    public static ImmutableIntArray of(int i2, int i3, int i4, int i5) {
        InterceptResult invokeIIII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeIIII = interceptable.invokeIIII(65553, null, i2, i3, i4, i5)) == null) ? new ImmutableIntArray(new int[]{i2, i3, i4, i5}) : (ImmutableIntArray) invokeIIII.objValue;
    }

    public static ImmutableIntArray of(int i2, int i3, int i4, int i5, int i6) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65554, null, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6)})) == null) ? new ImmutableIntArray(new int[]{i2, i3, i4, i5, i6}) : (ImmutableIntArray) invokeCommon.objValue;
    }

    public static ImmutableIntArray of(int i2, int i3, int i4, int i5, int i6, int i7) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65555, null, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7)})) == null) ? new ImmutableIntArray(new int[]{i2, i3, i4, i5, i6, i7}) : (ImmutableIntArray) invokeCommon.objValue;
    }

    public static ImmutableIntArray of(int i2, int... iArr) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(65556, null, i2, iArr)) == null) {
            n.e(iArr.length <= 2147483646, "the total number of elements must fit in an int");
            int[] iArr2 = new int[iArr.length + 1];
            iArr2[0] = i2;
            System.arraycopy(iArr, 0, iArr2, 1, iArr.length);
            return new ImmutableIntArray(iArr2);
        }
        return (ImmutableIntArray) invokeIL.objValue;
    }
}
