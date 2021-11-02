package com.google.common.primitives;

import androidx.core.view.InputDeviceCompat;
import b.i.d.a.n;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.material.badge.BadgeDrawable;
import com.google.common.base.Converter;
import java.io.Serializable;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.RandomAccess;
import java.util.regex.Pattern;
/* loaded from: classes2.dex */
public final class Doubles {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes2.dex */
    public static class DoubleArrayAsList extends AbstractList<Double> implements RandomAccess, Serializable {
        public static /* synthetic */ Interceptable $ic;
        public static final long serialVersionUID = 0;
        public transient /* synthetic */ FieldHolder $fh;
        public final double[] array;
        public final int end;
        public final int start;

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public DoubleArrayAsList(double[] dArr) {
            this(dArr, 0, dArr.length);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dArr};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    this((double[]) objArr2[0], ((Integer) objArr2[1]).intValue(), ((Integer) objArr2[2]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean contains(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, obj)) == null) ? (obj instanceof Double) && Doubles.e(this.array, ((Double) obj).doubleValue(), this.start, this.end) != -1 : invokeL.booleanValue;
        }

        @Override // java.util.AbstractList, java.util.Collection, java.util.List
        public boolean equals(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj)) == null) {
                if (obj == this) {
                    return true;
                }
                if (obj instanceof DoubleArrayAsList) {
                    DoubleArrayAsList doubleArrayAsList = (DoubleArrayAsList) obj;
                    int size = size();
                    if (doubleArrayAsList.size() != size) {
                        return false;
                    }
                    for (int i2 = 0; i2 < size; i2++) {
                        if (this.array[this.start + i2] != doubleArrayAsList.array[doubleArrayAsList.start + i2]) {
                            return false;
                        }
                    }
                    return true;
                }
                return super.equals(obj);
            }
            return invokeL.booleanValue;
        }

        @Override // java.util.AbstractList, java.util.Collection, java.util.List
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

        @Override // java.util.AbstractList, java.util.List
        public int indexOf(Object obj) {
            InterceptResult invokeL;
            int e2;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, obj)) == null) {
                if (!(obj instanceof Double) || (e2 = Doubles.e(this.array, ((Double) obj).doubleValue(), this.start, this.end)) < 0) {
                    return -1;
                }
                return e2 - this.start;
            }
            return invokeL.intValue;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean isEmpty() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                return false;
            }
            return invokeV.booleanValue;
        }

        @Override // java.util.AbstractList, java.util.List
        public int lastIndexOf(Object obj) {
            InterceptResult invokeL;
            int g2;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, obj)) == null) {
                if (!(obj instanceof Double) || (g2 = Doubles.g(this.array, ((Double) obj).doubleValue(), this.start, this.end)) < 0) {
                    return -1;
                }
                return g2 - this.start;
            }
            return invokeL.intValue;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.end - this.start : invokeV.intValue;
        }

        @Override // java.util.AbstractList, java.util.List
        public List<Double> subList(int i2, int i3) {
            InterceptResult invokeII;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeII = interceptable.invokeII(1048587, this, i2, i3)) == null) {
                n.v(i2, i3, size());
                if (i2 == i3) {
                    return Collections.emptyList();
                }
                double[] dArr = this.array;
                int i4 = this.start;
                return new DoubleArrayAsList(dArr, i2 + i4, i4 + i3);
            }
            return (List) invokeII.objValue;
        }

        public double[] toDoubleArray() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? Arrays.copyOfRange(this.array, this.start, this.end) : (double[]) invokeV.objValue;
        }

        @Override // java.util.AbstractCollection
        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable != null && (invokeV = interceptable.invokeV(1048589, this)) != null) {
                return (String) invokeV.objValue;
            }
            StringBuilder sb = new StringBuilder(size() * 12);
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

        public DoubleArrayAsList(double[] dArr, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dArr, Integer.valueOf(i2), Integer.valueOf(i3)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.array = dArr;
            this.start = i2;
            this.end = i3;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.AbstractList, java.util.List
        public Double get(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) {
                n.n(i2, size());
                return Double.valueOf(this.array[this.start + i2]);
            }
            return (Double) invokeI.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.AbstractList, java.util.List
        public Double set(int i2, Double d2) {
            InterceptResult invokeIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIL = interceptable.invokeIL(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2, d2)) == null) {
                n.n(i2, size());
                double[] dArr = this.array;
                int i3 = this.start;
                double d3 = dArr[i3 + i2];
                n.p(d2);
                dArr[i3 + i2] = d2.doubleValue();
                return Double.valueOf(d3);
            }
            return (Double) invokeIL.objValue;
        }
    }

    /* loaded from: classes2.dex */
    public static final class DoubleConverter extends Converter<String, Double> implements Serializable {
        public static /* synthetic */ Interceptable $ic = null;
        public static final DoubleConverter INSTANCE;
        public static final long serialVersionUID = 1;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(618184969, "Lcom/google/common/primitives/Doubles$DoubleConverter;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(618184969, "Lcom/google/common/primitives/Doubles$DoubleConverter;");
                    return;
                }
            }
            INSTANCE = new DoubleConverter();
        }

        public DoubleConverter() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        private Object readResolve() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65538, this)) == null) ? INSTANCE : invokeV.objValue;
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? "Doubles.stringConverter()" : (String) invokeV.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.common.base.Converter
        public String doBackward(Double d2) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, d2)) == null) ? d2.toString() : (String) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.common.base.Converter
        public Double doForward(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) ? Double.valueOf(str) : (Double) invokeL.objValue;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes2.dex */
    public static final class LexicographicalComparator implements Comparator<double[]> {
        public static final /* synthetic */ LexicographicalComparator[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final LexicographicalComparator INSTANCE;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-342482011, "Lcom/google/common/primitives/Doubles$LexicographicalComparator;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-342482011, "Lcom/google/common/primitives/Doubles$LexicographicalComparator;");
                    return;
                }
            }
            LexicographicalComparator lexicographicalComparator = new LexicographicalComparator("INSTANCE", 0);
            INSTANCE = lexicographicalComparator;
            $VALUES = new LexicographicalComparator[]{lexicographicalComparator};
        }

        public LexicographicalComparator(String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public static LexicographicalComparator valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (LexicographicalComparator) Enum.valueOf(LexicographicalComparator.class, str) : (LexicographicalComparator) invokeL.objValue;
        }

        public static LexicographicalComparator[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (LexicographicalComparator[]) $VALUES.clone() : (LexicographicalComparator[]) invokeV.objValue;
        }

        @Override // java.lang.Enum
        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? "Doubles.lexicographicalComparator()" : (String) invokeV.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Comparator
        public int compare(double[] dArr, double[] dArr2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, dArr, dArr2)) == null) {
                int min = Math.min(dArr.length, dArr2.length);
                for (int i2 = 0; i2 < min; i2++) {
                    int compare = Double.compare(dArr[i2], dArr2[i2]);
                    if (compare != 0) {
                        return compare;
                    }
                }
                return dArr.length - dArr2.length;
            }
            return invokeLL.intValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1415980468, "Lcom/google/common/primitives/Doubles;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1415980468, "Lcom/google/common/primitives/Doubles;");
                return;
            }
        }
        c();
    }

    public static Pattern c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            return Pattern.compile(("[+-]?(?:NaN|Infinity|" + ("(?:\\d+#(?:\\.\\d*#)?|\\.\\d+#)(?:[eE][+-]?\\d+#)?[fFdD]?") + "|" + ("0[xX](?:[0-9a-fA-F]+#(?:\\.[0-9a-fA-F]*#)?|\\.[0-9a-fA-F]+#)[pP][+-]?\\d+#[fFdD]?") + SmallTailInfo.EMOTION_SUFFIX).replace("#", BadgeDrawable.DEFAULT_EXCEED_MAX_BADGE_NUMBER_SUFFIX));
        }
        return (Pattern) invokeV.objValue;
    }

    public static int d(double d2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{Double.valueOf(d2)})) == null) ? Double.valueOf(d2).hashCode() : invokeCommon.intValue;
    }

    public static int e(double[] dArr, double d2, int i2, int i3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(AdIconUtil.AD_TEXT_ID, null, new Object[]{dArr, Double.valueOf(d2), Integer.valueOf(i2), Integer.valueOf(i3)})) == null) {
            while (i2 < i3) {
                if (dArr[i2] == d2) {
                    return i2;
                }
                i2++;
            }
            return -1;
        }
        return invokeCommon.intValue;
    }

    public static boolean f(double d2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(AdIconUtil.BAIDU_LOGO_ID, null, new Object[]{Double.valueOf(d2)})) == null) ? Double.NEGATIVE_INFINITY < d2 && d2 < Double.POSITIVE_INFINITY : invokeCommon.booleanValue;
    }

    public static int g(double[] dArr, double d2, int i2, int i3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65543, null, new Object[]{dArr, Double.valueOf(d2), Integer.valueOf(i2), Integer.valueOf(i3)})) == null) {
            for (int i4 = i3 - 1; i4 >= i2; i4--) {
                if (dArr[i4] == d2) {
                    return i4;
                }
            }
            return -1;
        }
        return invokeCommon.intValue;
    }

    public static double[] h(Collection<? extends Number> collection) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, collection)) == null) {
            if (collection instanceof DoubleArrayAsList) {
                return ((DoubleArrayAsList) collection).toDoubleArray();
            }
            Object[] array = collection.toArray();
            int length = array.length;
            double[] dArr = new double[length];
            for (int i2 = 0; i2 < length; i2++) {
                Object obj = array[i2];
                n.p(obj);
                dArr[i2] = ((Number) obj).doubleValue();
            }
            return dArr;
        }
        return (double[]) invokeL.objValue;
    }
}
