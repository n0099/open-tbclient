package org.apache.commons.lang3;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.others.IStringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Serializable;
import java.util.Comparator;
/* loaded from: classes2.dex */
public final class Range<T> implements Serializable {
    public static /* synthetic */ Interceptable $ic = null;
    public static final long serialVersionUID = 1;
    public transient /* synthetic */ FieldHolder $fh;
    public final Comparator<T> comparator;
    public transient int hashCode;
    public final T maximum;
    public final T minimum;
    public transient String toString;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes2.dex */
    public static final class ComparableComparator implements Comparator {
        public static final /* synthetic */ ComparableComparator[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final ComparableComparator INSTANCE;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(296943529, "Lorg/apache/commons/lang3/Range$ComparableComparator;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(296943529, "Lorg/apache/commons/lang3/Range$ComparableComparator;");
                    return;
                }
            }
            ComparableComparator comparableComparator = new ComparableComparator("INSTANCE", 0);
            INSTANCE = comparableComparator;
            $VALUES = new ComparableComparator[]{comparableComparator};
        }

        public ComparableComparator(String str, int i2) {
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

        public static ComparableComparator valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (ComparableComparator) Enum.valueOf(ComparableComparator.class, str) : (ComparableComparator) invokeL.objValue;
        }

        public static ComparableComparator[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (ComparableComparator[]) $VALUES.clone() : (ComparableComparator[]) invokeV.objValue;
        }

        @Override // java.util.Comparator
        public int compare(Object obj, Object obj2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, obj, obj2)) == null) ? ((Comparable) obj).compareTo(obj2) : invokeLL.intValue;
        }
    }

    public Range(T t, T t2, Comparator<T> comparator) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {t, t2, comparator};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        if (t != null && t2 != null) {
            if (comparator == null) {
                this.comparator = ComparableComparator.INSTANCE;
            } else {
                this.comparator = comparator;
            }
            if (this.comparator.compare(t, t2) < 1) {
                this.minimum = t;
                this.maximum = t2;
                return;
            }
            this.minimum = t2;
            this.maximum = t;
            return;
        }
        throw new IllegalArgumentException("Elements in a range must not be null: element1=" + t + ", element2=" + t2);
    }

    /* JADX WARN: Incorrect types in method signature: <T::Ljava/lang/Comparable<TT;>;>(TT;TT;)Lorg/apache/commons/lang3/Range<TT;>; */
    public static Range between(Comparable comparable, Comparable comparable2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, comparable, comparable2)) == null) ? between(comparable, comparable2, null) : (Range) invokeLL.objValue;
    }

    /* JADX WARN: Incorrect types in method signature: <T::Ljava/lang/Comparable<TT;>;>(TT;)Lorg/apache/commons/lang3/Range<TT;>; */
    public static Range is(Comparable comparable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, comparable)) == null) ? between(comparable, comparable, null) : (Range) invokeL.objValue;
    }

    public boolean contains(T t) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, t)) == null) ? t != null && this.comparator.compare(t, this.minimum) > -1 && this.comparator.compare(t, this.maximum) < 1 : invokeL.booleanValue;
    }

    public boolean containsRange(Range<T> range) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, range)) == null) ? range != null && contains(range.minimum) && contains(range.maximum) : invokeL.booleanValue;
    }

    public int elementCompareTo(T t) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, t)) == null) {
            if (t != null) {
                if (isAfter(t)) {
                    return -1;
                }
                return isBefore(t) ? 1 : 0;
            }
            throw new NullPointerException("Element is null");
        }
        return invokeL.intValue;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, obj)) == null) {
            if (obj == this) {
                return true;
            }
            if (obj == null || obj.getClass() != Range.class) {
                return false;
            }
            Range range = (Range) obj;
            return this.minimum.equals(range.minimum) && this.maximum.equals(range.maximum);
        }
        return invokeL.booleanValue;
    }

    public Comparator<T> getComparator() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.comparator : (Comparator) invokeV.objValue;
    }

    public T getMaximum() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.maximum : (T) invokeV.objValue;
    }

    public T getMinimum() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.minimum : (T) invokeV.objValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            int i2 = this.hashCode;
            if (i2 == 0) {
                int hashCode = ((((629 + Range.class.hashCode()) * 37) + this.minimum.hashCode()) * 37) + this.maximum.hashCode();
                this.hashCode = hashCode;
                return hashCode;
            }
            return i2;
        }
        return invokeV.intValue;
    }

    public Range<T> intersectionWith(Range<T> range) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, range)) == null) {
            if (isOverlappedBy(range)) {
                if (equals(range)) {
                    return this;
                }
                return between(getComparator().compare(this.minimum, range.minimum) < 0 ? range.minimum : this.minimum, getComparator().compare(this.maximum, range.maximum) < 0 ? this.maximum : range.maximum, getComparator());
            }
            throw new IllegalArgumentException(String.format("Cannot calculate intersection with non-overlapping range %s", range));
        }
        return (Range) invokeL.objValue;
    }

    public boolean isAfter(T t) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, t)) == null) ? t != null && this.comparator.compare(t, this.minimum) < 0 : invokeL.booleanValue;
    }

    public boolean isAfterRange(Range<T> range) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, range)) == null) {
            if (range == null) {
                return false;
            }
            return isAfter(range.maximum);
        }
        return invokeL.booleanValue;
    }

    public boolean isBefore(T t) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, t)) == null) ? t != null && this.comparator.compare(t, this.maximum) > 0 : invokeL.booleanValue;
    }

    public boolean isBeforeRange(Range<T> range) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, range)) == null) {
            if (range == null) {
                return false;
            }
            return isBefore(range.minimum);
        }
        return invokeL.booleanValue;
    }

    public boolean isEndedBy(T t) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, t)) == null) ? t != null && this.comparator.compare(t, this.maximum) == 0 : invokeL.booleanValue;
    }

    public boolean isNaturalOrdering() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.comparator == ComparableComparator.INSTANCE : invokeV.booleanValue;
    }

    public boolean isOverlappedBy(Range<T> range) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, range)) == null) {
            if (range == null) {
                return false;
            }
            return range.contains(this.minimum) || range.contains(this.maximum) || contains(range.minimum);
        }
        return invokeL.booleanValue;
    }

    public boolean isStartedBy(T t) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, t)) == null) ? t != null && this.comparator.compare(t, this.minimum) == 0 : invokeL.booleanValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            if (this.toString == null) {
                this.toString = PreferencesUtil.LEFT_MOUNT + this.minimum + IStringUtil.TOP_PATH + this.maximum + PreferencesUtil.RIGHT_MOUNT;
            }
            return this.toString;
        }
        return (String) invokeV.objValue;
    }

    public static <T> Range<T> between(T t, T t2, Comparator<T> comparator) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(65538, null, t, t2, comparator)) == null) ? new Range<>(t, t2, comparator) : (Range) invokeLLL.objValue;
    }

    public static <T> Range<T> is(T t, Comparator<T> comparator) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, t, comparator)) == null) ? between(t, t, comparator) : (Range) invokeLL.objValue;
    }

    public String toString(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048594, this, str)) == null) ? String.format(str, this.minimum, this.maximum, this.comparator) : (String) invokeL.objValue;
    }
}
