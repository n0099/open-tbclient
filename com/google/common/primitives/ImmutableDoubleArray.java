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
public final class ImmutableDoubleArray implements Serializable {
    public static /* synthetic */ Interceptable $ic;
    public static final ImmutableDoubleArray EMPTY;
    public transient /* synthetic */ FieldHolder $fh;
    public final double[] array;
    public final int end;
    public final transient int start;

    /* loaded from: classes3.dex */
    public static class AsList extends AbstractList<Double> implements RandomAccess, Serializable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final ImmutableDoubleArray parent;

        public /* synthetic */ AsList(ImmutableDoubleArray immutableDoubleArray, a aVar) {
            this(immutableDoubleArray);
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
                        if (obj2 instanceof Double) {
                            int i3 = i2 + 1;
                            if (ImmutableDoubleArray.areEqual(this.parent.array[i2], ((Double) obj2).doubleValue())) {
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
                if (obj instanceof Double) {
                    return this.parent.indexOf(((Double) obj).doubleValue());
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
                if (obj instanceof Double) {
                    return this.parent.lastIndexOf(((Double) obj).doubleValue());
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
        public List<Double> subList(int i2, int i3) {
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

        public AsList(ImmutableDoubleArray immutableDoubleArray) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {immutableDoubleArray};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.parent = immutableDoubleArray;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.AbstractList, java.util.List
        public Double get(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) ? Double.valueOf(this.parent.get(i2)) : (Double) invokeI.objValue;
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
        public double[] a;

        /* renamed from: b  reason: collision with root package name */
        public int f57082b;

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
            this.f57082b = 0;
            this.a = new double[i2];
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

        public b a(double d2) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Double.valueOf(d2)})) == null) {
                e(1);
                double[] dArr = this.a;
                int i2 = this.f57082b;
                dArr[i2] = d2;
                this.f57082b = i2 + 1;
                return this;
            }
            return (b) invokeCommon.objValue;
        }

        public b b(Iterable<Double> iterable) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, iterable)) == null) {
                if (iterable instanceof Collection) {
                    c((Collection) iterable);
                    return this;
                }
                for (Double d2 : iterable) {
                    a(d2.doubleValue());
                }
                return this;
            }
            return (b) invokeL.objValue;
        }

        public b c(Collection<Double> collection) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, collection)) == null) {
                e(collection.size());
                for (Double d2 : collection) {
                    double[] dArr = this.a;
                    int i2 = this.f57082b;
                    this.f57082b = i2 + 1;
                    dArr[i2] = d2.doubleValue();
                }
                return this;
            }
            return (b) invokeL.objValue;
        }

        public ImmutableDoubleArray d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f57082b == 0 ? ImmutableDoubleArray.EMPTY : new ImmutableDoubleArray(this.a, 0, this.f57082b, null) : (ImmutableDoubleArray) invokeV.objValue;
        }

        public final void e(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048580, this, i2) == null) {
                int i3 = this.f57082b + i2;
                double[] dArr = this.a;
                if (i3 > dArr.length) {
                    double[] dArr2 = new double[f(dArr.length, i3)];
                    System.arraycopy(this.a, 0, dArr2, 0, this.f57082b);
                    this.a = dArr2;
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(2124144314, "Lcom/google/common/primitives/ImmutableDoubleArray;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(2124144314, "Lcom/google/common/primitives/ImmutableDoubleArray;");
                return;
            }
        }
        EMPTY = new ImmutableDoubleArray(new double[0]);
    }

    public /* synthetic */ ImmutableDoubleArray(double[] dArr, int i2, int i3, a aVar) {
        this(dArr, i2, i3);
    }

    public static boolean areEqual(double d2, double d3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65544, null, new Object[]{Double.valueOf(d2), Double.valueOf(d3)})) == null) ? Double.doubleToLongBits(d2) == Double.doubleToLongBits(d3) : invokeCommon.booleanValue;
    }

    public static b builder(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65546, null, i2)) == null) {
            n.f(i2 >= 0, "Invalid initialCapacity: %s", i2);
            return new b(i2);
        }
        return (b) invokeI.objValue;
    }

    public static ImmutableDoubleArray copyOf(double[] dArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65549, null, dArr)) == null) ? dArr.length == 0 ? EMPTY : new ImmutableDoubleArray(Arrays.copyOf(dArr, dArr.length)) : (ImmutableDoubleArray) invokeL.objValue;
    }

    private boolean isPartialView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65550, this)) == null) ? this.start > 0 || this.end < this.array.length : invokeV.booleanValue;
    }

    public static ImmutableDoubleArray of() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65551, null)) == null) ? EMPTY : (ImmutableDoubleArray) invokeV.objValue;
    }

    public List<Double> asList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? new AsList(this, null) : (List) invokeV.objValue;
    }

    public boolean contains(double d2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Double.valueOf(d2)})) == null) ? indexOf(d2) >= 0 : invokeCommon.booleanValue;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, obj)) == null) {
            if (obj == this) {
                return true;
            }
            if (obj instanceof ImmutableDoubleArray) {
                ImmutableDoubleArray immutableDoubleArray = (ImmutableDoubleArray) obj;
                if (length() != immutableDoubleArray.length()) {
                    return false;
                }
                for (int i2 = 0; i2 < length(); i2++) {
                    if (!areEqual(get(i2), immutableDoubleArray.get(i2))) {
                        return false;
                    }
                }
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public double get(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i2)) == null) {
            n.n(i2, length());
            return this.array[this.start + i2];
        }
        return invokeI.doubleValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            int i2 = 1;
            for (int i3 = this.start; i3 < this.end; i3++) {
                i2 = (i2 * 31) + Doubles.d(this.array[i3]);
            }
            return i2;
        }
        return invokeV.intValue;
    }

    public int indexOf(double d2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048581, this, new Object[]{Double.valueOf(d2)})) == null) {
            for (int i2 = this.start; i2 < this.end; i2++) {
                if (areEqual(this.array[i2], d2)) {
                    return i2 - this.start;
                }
            }
            return -1;
        }
        return invokeCommon.intValue;
    }

    public boolean isEmpty() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.end == this.start : invokeV.booleanValue;
    }

    public int lastIndexOf(double d2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeCommon = interceptable.invokeCommon(1048583, this, new Object[]{Double.valueOf(d2)})) != null) {
            return invokeCommon.intValue;
        }
        int i2 = this.end;
        while (true) {
            i2--;
            if (i2 < this.start) {
                return -1;
            }
            if (areEqual(this.array[i2], d2)) {
                return i2 - this.start;
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

    public ImmutableDoubleArray subArray(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048586, this, i2, i3)) == null) {
            n.v(i2, i3, length());
            if (i2 == i3) {
                return EMPTY;
            }
            double[] dArr = this.array;
            int i4 = this.start;
            return new ImmutableDoubleArray(dArr, i2 + i4, i4 + i3);
        }
        return (ImmutableDoubleArray) invokeII.objValue;
    }

    public double[] toArray() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? Arrays.copyOfRange(this.array, this.start, this.end) : (double[]) invokeV.objValue;
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

    public ImmutableDoubleArray trimmed() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? isPartialView() ? new ImmutableDoubleArray(toArray()) : this : (ImmutableDoubleArray) invokeV.objValue;
    }

    public Object writeReplace() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? trimmed() : invokeV.objValue;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ImmutableDoubleArray(double[] dArr) {
        this(dArr, 0, dArr.length);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {dArr};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((double[]) objArr2[0], ((Integer) objArr2[1]).intValue(), ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public static ImmutableDoubleArray of(double d2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65552, null, new Object[]{Double.valueOf(d2)})) == null) ? new ImmutableDoubleArray(new double[]{d2}) : (ImmutableDoubleArray) invokeCommon.objValue;
    }

    public ImmutableDoubleArray(double[] dArr, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {dArr, Integer.valueOf(i2), Integer.valueOf(i3)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.array = dArr;
        this.start = i2;
        this.end = i3;
    }

    public static b builder() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) ? new b(10) : (b) invokeV.objValue;
    }

    public static ImmutableDoubleArray copyOf(Collection<Double> collection) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65548, null, collection)) == null) ? collection.isEmpty() ? EMPTY : new ImmutableDoubleArray(Doubles.h(collection)) : (ImmutableDoubleArray) invokeL.objValue;
    }

    public static ImmutableDoubleArray of(double d2, double d3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65553, null, new Object[]{Double.valueOf(d2), Double.valueOf(d3)})) == null) ? new ImmutableDoubleArray(new double[]{d2, d3}) : (ImmutableDoubleArray) invokeCommon.objValue;
    }

    public static ImmutableDoubleArray copyOf(Iterable<Double> iterable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, iterable)) == null) {
            if (iterable instanceof Collection) {
                return copyOf((Collection<Double>) iterable);
            }
            b builder = builder();
            builder.b(iterable);
            return builder.d();
        }
        return (ImmutableDoubleArray) invokeL.objValue;
    }

    public static ImmutableDoubleArray of(double d2, double d3, double d4) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65554, null, new Object[]{Double.valueOf(d2), Double.valueOf(d3), Double.valueOf(d4)})) == null) ? new ImmutableDoubleArray(new double[]{d2, d3, d4}) : (ImmutableDoubleArray) invokeCommon.objValue;
    }

    public static ImmutableDoubleArray of(double d2, double d3, double d4, double d5) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65555, null, new Object[]{Double.valueOf(d2), Double.valueOf(d3), Double.valueOf(d4), Double.valueOf(d5)})) == null) ? new ImmutableDoubleArray(new double[]{d2, d3, d4, d5}) : (ImmutableDoubleArray) invokeCommon.objValue;
    }

    public static ImmutableDoubleArray of(double d2, double d3, double d4, double d5, double d6) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65556, null, new Object[]{Double.valueOf(d2), Double.valueOf(d3), Double.valueOf(d4), Double.valueOf(d5), Double.valueOf(d6)})) == null) ? new ImmutableDoubleArray(new double[]{d2, d3, d4, d5, d6}) : (ImmutableDoubleArray) invokeCommon.objValue;
    }

    public static ImmutableDoubleArray of(double d2, double d3, double d4, double d5, double d6, double d7) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65557, null, new Object[]{Double.valueOf(d2), Double.valueOf(d3), Double.valueOf(d4), Double.valueOf(d5), Double.valueOf(d6), Double.valueOf(d7)})) == null) ? new ImmutableDoubleArray(new double[]{d2, d3, d4, d5, d6, d7}) : (ImmutableDoubleArray) invokeCommon.objValue;
    }

    public static ImmutableDoubleArray of(double d2, double... dArr) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65558, null, new Object[]{Double.valueOf(d2), dArr})) == null) {
            n.e(dArr.length <= 2147483646, "the total number of elements must fit in an int");
            double[] dArr2 = new double[dArr.length + 1];
            dArr2[0] = d2;
            System.arraycopy(dArr, 0, dArr2, 1, dArr.length);
            return new ImmutableDoubleArray(dArr2);
        }
        return (ImmutableDoubleArray) invokeCommon.objValue;
    }
}
