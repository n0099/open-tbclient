package com.google.common.primitives;

import androidx.core.view.InputDeviceCompat;
import b.i.d.a.n;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.common.base.Converter;
import java.io.Serializable;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.RandomAccess;
/* loaded from: classes2.dex */
public final class Floats {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes2.dex */
    public static class FloatArrayAsList extends AbstractList<Float> implements RandomAccess, Serializable {
        public static /* synthetic */ Interceptable $ic;
        public static final long serialVersionUID = 0;
        public transient /* synthetic */ FieldHolder $fh;
        public final float[] array;
        public final int end;
        public final int start;

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public FloatArrayAsList(float[] fArr) {
            this(fArr, 0, fArr.length);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fArr};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    this((float[]) objArr2[0], ((Integer) objArr2[1]).intValue(), ((Integer) objArr2[2]).intValue());
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
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, obj)) == null) ? (obj instanceof Float) && Floats.d(this.array, ((Float) obj).floatValue(), this.start, this.end) != -1 : invokeL.booleanValue;
        }

        @Override // java.util.AbstractList, java.util.Collection, java.util.List
        public boolean equals(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj)) == null) {
                if (obj == this) {
                    return true;
                }
                if (obj instanceof FloatArrayAsList) {
                    FloatArrayAsList floatArrayAsList = (FloatArrayAsList) obj;
                    int size = size();
                    if (floatArrayAsList.size() != size) {
                        return false;
                    }
                    for (int i2 = 0; i2 < size; i2++) {
                        if (this.array[this.start + i2] != floatArrayAsList.array[floatArrayAsList.start + i2]) {
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
                    i2 = (i2 * 31) + Floats.c(this.array[i3]);
                }
                return i2;
            }
            return invokeV.intValue;
        }

        @Override // java.util.AbstractList, java.util.List
        public int indexOf(Object obj) {
            InterceptResult invokeL;
            int d2;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, obj)) == null) {
                if (!(obj instanceof Float) || (d2 = Floats.d(this.array, ((Float) obj).floatValue(), this.start, this.end)) < 0) {
                    return -1;
                }
                return d2 - this.start;
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
            int e2;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, obj)) == null) {
                if (!(obj instanceof Float) || (e2 = Floats.e(this.array, ((Float) obj).floatValue(), this.start, this.end)) < 0) {
                    return -1;
                }
                return e2 - this.start;
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
        public List<Float> subList(int i2, int i3) {
            InterceptResult invokeII;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeII = interceptable.invokeII(1048587, this, i2, i3)) == null) {
                n.v(i2, i3, size());
                if (i2 == i3) {
                    return Collections.emptyList();
                }
                float[] fArr = this.array;
                int i4 = this.start;
                return new FloatArrayAsList(fArr, i2 + i4, i4 + i3);
            }
            return (List) invokeII.objValue;
        }

        public float[] toFloatArray() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? Arrays.copyOfRange(this.array, this.start, this.end) : (float[]) invokeV.objValue;
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

        public FloatArrayAsList(float[] fArr, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fArr, Integer.valueOf(i2), Integer.valueOf(i3)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.array = fArr;
            this.start = i2;
            this.end = i3;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.AbstractList, java.util.List
        public Float get(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) {
                n.n(i2, size());
                return Float.valueOf(this.array[this.start + i2]);
            }
            return (Float) invokeI.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.AbstractList, java.util.List
        public Float set(int i2, Float f2) {
            InterceptResult invokeIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIL = interceptable.invokeIL(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2, f2)) == null) {
                n.n(i2, size());
                float[] fArr = this.array;
                int i3 = this.start;
                float f3 = fArr[i3 + i2];
                n.p(f2);
                fArr[i3 + i2] = f2.floatValue();
                return Float.valueOf(f3);
            }
            return (Float) invokeIL.objValue;
        }
    }

    /* loaded from: classes2.dex */
    public static final class FloatConverter extends Converter<String, Float> implements Serializable {
        public static /* synthetic */ Interceptable $ic = null;
        public static final FloatConverter INSTANCE;
        public static final long serialVersionUID = 1;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(260285861, "Lcom/google/common/primitives/Floats$FloatConverter;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(260285861, "Lcom/google/common/primitives/Floats$FloatConverter;");
                    return;
                }
            }
            INSTANCE = new FloatConverter();
        }

        public FloatConverter() {
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
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? "Floats.stringConverter()" : (String) invokeV.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.common.base.Converter
        public String doBackward(Float f2) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, f2)) == null) ? f2.toString() : (String) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.common.base.Converter
        public Float doForward(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) ? Float.valueOf(str) : (Float) invokeL.objValue;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes2.dex */
    public static final class LexicographicalComparator implements Comparator<float[]> {
        public static final /* synthetic */ LexicographicalComparator[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final LexicographicalComparator INSTANCE;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1250523098, "Lcom/google/common/primitives/Floats$LexicographicalComparator;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1250523098, "Lcom/google/common/primitives/Floats$LexicographicalComparator;");
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
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? "Floats.lexicographicalComparator()" : (String) invokeV.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Comparator
        public int compare(float[] fArr, float[] fArr2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, fArr, fArr2)) == null) {
                int min = Math.min(fArr.length, fArr2.length);
                for (int i2 = 0; i2 < min; i2++) {
                    int compare = Float.compare(fArr[i2], fArr2[i2]);
                    if (compare != 0) {
                        return compare;
                    }
                }
                return fArr.length - fArr2.length;
            }
            return invokeLL.intValue;
        }
    }

    public static int c(float f2) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeF = interceptable.invokeF(65538, null, f2)) == null) ? Float.valueOf(f2).hashCode() : invokeF.intValue;
    }

    public static int d(float[] fArr, float f2, int i2, int i3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65539, null, new Object[]{fArr, Float.valueOf(f2), Integer.valueOf(i2), Integer.valueOf(i3)})) == null) {
            while (i2 < i3) {
                if (fArr[i2] == f2) {
                    return i2;
                }
                i2++;
            }
            return -1;
        }
        return invokeCommon.intValue;
    }

    public static int e(float[] fArr, float f2, int i2, int i3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{fArr, Float.valueOf(f2), Integer.valueOf(i2), Integer.valueOf(i3)})) == null) {
            for (int i4 = i3 - 1; i4 >= i2; i4--) {
                if (fArr[i4] == f2) {
                    return i4;
                }
            }
            return -1;
        }
        return invokeCommon.intValue;
    }
}
