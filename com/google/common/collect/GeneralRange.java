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
import java.io.Serializable;
import java.util.Comparator;
/* loaded from: classes6.dex */
public final class GeneralRange<T> implements Serializable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Comparator<? super T> comparator;
    public final boolean hasLowerBound;
    public final boolean hasUpperBound;
    public final BoundType lowerBoundType;
    public final T lowerEndpoint;
    public transient GeneralRange<T> reverse;
    public final BoundType upperBoundType;
    public final T upperEndpoint;

    public GeneralRange(Comparator<? super T> comparator, boolean z, T t, BoundType boundType, boolean z2, T t2, BoundType boundType2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {comparator, Boolean.valueOf(z), t, boundType, Boolean.valueOf(z2), t2, boundType2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        n.p(comparator);
        this.comparator = comparator;
        this.hasLowerBound = z;
        this.hasUpperBound = z2;
        this.lowerEndpoint = t;
        n.p(boundType);
        this.lowerBoundType = boundType;
        this.upperEndpoint = t2;
        n.p(boundType2);
        this.upperBoundType = boundType2;
        if (z) {
            comparator.compare(t, t);
        }
        if (z2) {
            comparator.compare(t2, t2);
        }
        if (z && z2) {
            int compare = comparator.compare(t, t2);
            n.l(compare <= 0, "lowerEndpoint (%s) > upperEndpoint (%s)", t, t2);
            if (compare == 0) {
                n.d((boundType != BoundType.OPEN) | (boundType2 != BoundType.OPEN));
            }
        }
    }

    public static <T> GeneralRange<T> all(Comparator<? super T> comparator) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, comparator)) == null) {
            BoundType boundType = BoundType.OPEN;
            return new GeneralRange<>(comparator, false, null, boundType, false, null, boundType);
        }
        return (GeneralRange) invokeL.objValue;
    }

    public static <T> GeneralRange<T> downTo(Comparator<? super T> comparator, T t, BoundType boundType) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(65538, null, comparator, t, boundType)) == null) ? new GeneralRange<>(comparator, true, t, boundType, false, null, BoundType.OPEN) : (GeneralRange) invokeLLL.objValue;
    }

    public static <T extends Comparable> GeneralRange<T> from(Range<T> range) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, range)) == null) {
            return new GeneralRange<>(Ordering.natural(), range.hasLowerBound(), range.hasLowerBound() ? range.lowerEndpoint() : null, range.hasLowerBound() ? range.lowerBoundType() : BoundType.OPEN, range.hasUpperBound(), range.hasUpperBound() ? range.upperEndpoint() : null, range.hasUpperBound() ? range.upperBoundType() : BoundType.OPEN);
        }
        return (GeneralRange) invokeL.objValue;
    }

    public static <T> GeneralRange<T> range(Comparator<? super T> comparator, T t, BoundType boundType, T t2, BoundType boundType2) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, comparator, t, boundType, t2, boundType2)) == null) ? new GeneralRange<>(comparator, true, t, boundType, true, t2, boundType2) : (GeneralRange) invokeLLLLL.objValue;
    }

    public static <T> GeneralRange<T> upTo(Comparator<? super T> comparator, T t, BoundType boundType) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(AdIconUtil.AD_TEXT_ID, null, comparator, t, boundType)) == null) ? new GeneralRange<>(comparator, false, null, BoundType.OPEN, true, t, boundType) : (GeneralRange) invokeLLL.objValue;
    }

    public Comparator<? super T> comparator() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.comparator : (Comparator) invokeV.objValue;
    }

    public boolean contains(T t) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, t)) == null) ? (tooLow(t) || tooHigh(t)) ? false : true : invokeL.booleanValue;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, obj)) == null) {
            if (obj instanceof GeneralRange) {
                GeneralRange generalRange = (GeneralRange) obj;
                return this.comparator.equals(generalRange.comparator) && this.hasLowerBound == generalRange.hasLowerBound && this.hasUpperBound == generalRange.hasUpperBound && getLowerBoundType().equals(generalRange.getLowerBoundType()) && getUpperBoundType().equals(generalRange.getUpperBoundType()) && k.a(getLowerEndpoint(), generalRange.getLowerEndpoint()) && k.a(getUpperEndpoint(), generalRange.getUpperEndpoint());
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public BoundType getLowerBoundType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.lowerBoundType : (BoundType) invokeV.objValue;
    }

    public T getLowerEndpoint() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.lowerEndpoint : (T) invokeV.objValue;
    }

    public BoundType getUpperBoundType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.upperBoundType : (BoundType) invokeV.objValue;
    }

    public T getUpperEndpoint() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.upperEndpoint : (T) invokeV.objValue;
    }

    public boolean hasLowerBound() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.hasLowerBound : invokeV.booleanValue;
    }

    public boolean hasUpperBound() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.hasUpperBound : invokeV.booleanValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? k.b(this.comparator, getLowerEndpoint(), getLowerBoundType(), getUpperEndpoint(), getUpperBoundType()) : invokeV.intValue;
    }

    public GeneralRange<T> intersect(GeneralRange<T> generalRange) {
        InterceptResult invokeL;
        int compare;
        int compare2;
        T t;
        BoundType boundType;
        BoundType boundType2;
        int compare3;
        BoundType boundType3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, generalRange)) == null) {
            n.p(generalRange);
            n.d(this.comparator.equals(generalRange.comparator));
            boolean z = this.hasLowerBound;
            T lowerEndpoint = getLowerEndpoint();
            BoundType lowerBoundType = getLowerBoundType();
            if (!hasLowerBound()) {
                z = generalRange.hasLowerBound;
                lowerEndpoint = generalRange.getLowerEndpoint();
                lowerBoundType = generalRange.getLowerBoundType();
            } else if (generalRange.hasLowerBound() && ((compare = this.comparator.compare(getLowerEndpoint(), generalRange.getLowerEndpoint())) < 0 || (compare == 0 && generalRange.getLowerBoundType() == BoundType.OPEN))) {
                lowerEndpoint = generalRange.getLowerEndpoint();
                lowerBoundType = generalRange.getLowerBoundType();
            }
            boolean z2 = z;
            boolean z3 = this.hasUpperBound;
            T upperEndpoint = getUpperEndpoint();
            BoundType upperBoundType = getUpperBoundType();
            if (!hasUpperBound()) {
                z3 = generalRange.hasUpperBound;
                upperEndpoint = generalRange.getUpperEndpoint();
                upperBoundType = generalRange.getUpperBoundType();
            } else if (generalRange.hasUpperBound() && ((compare2 = this.comparator.compare(getUpperEndpoint(), generalRange.getUpperEndpoint())) > 0 || (compare2 == 0 && generalRange.getUpperBoundType() == BoundType.OPEN))) {
                upperEndpoint = generalRange.getUpperEndpoint();
                upperBoundType = generalRange.getUpperBoundType();
            }
            boolean z4 = z3;
            T t2 = upperEndpoint;
            if (z2 && z4 && ((compare3 = this.comparator.compare(lowerEndpoint, t2)) > 0 || (compare3 == 0 && lowerBoundType == (boundType3 = BoundType.OPEN) && upperBoundType == boundType3))) {
                boundType = BoundType.OPEN;
                boundType2 = BoundType.CLOSED;
                t = t2;
            } else {
                t = lowerEndpoint;
                boundType = lowerBoundType;
                boundType2 = upperBoundType;
            }
            return new GeneralRange<>(this.comparator, z2, t, boundType, z4, t2, boundType2);
        }
        return (GeneralRange) invokeL.objValue;
    }

    public boolean isEmpty() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? (hasUpperBound() && tooLow(getUpperEndpoint())) || (hasLowerBound() && tooHigh(getLowerEndpoint())) : invokeV.booleanValue;
    }

    public GeneralRange<T> reverse() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            GeneralRange<T> generalRange = this.reverse;
            if (generalRange == null) {
                GeneralRange<T> generalRange2 = new GeneralRange<>(Ordering.from(this.comparator).reverse(), this.hasUpperBound, getUpperEndpoint(), getUpperBoundType(), this.hasLowerBound, getLowerEndpoint(), getLowerBoundType());
                generalRange2.reverse = this;
                this.reverse = generalRange2;
                return generalRange2;
            }
            return generalRange;
        }
        return (GeneralRange) invokeV.objValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            StringBuilder sb = new StringBuilder();
            sb.append(this.comparator);
            sb.append(":");
            sb.append(this.lowerBoundType == BoundType.CLOSED ? '[' : '(');
            sb.append(this.hasLowerBound ? this.lowerEndpoint : "-∞");
            sb.append(',');
            sb.append(this.hasUpperBound ? this.upperEndpoint : "∞");
            sb.append(this.upperBoundType == BoundType.CLOSED ? ']' : ')');
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }

    public boolean tooHigh(T t) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, t)) == null) {
            if (hasUpperBound()) {
                int compare = this.comparator.compare(t, getUpperEndpoint());
                return ((compare == 0) & (getUpperBoundType() == BoundType.OPEN)) | (compare > 0);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public boolean tooLow(T t) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, t)) == null) {
            if (hasLowerBound()) {
                int compare = this.comparator.compare(t, getLowerEndpoint());
                return ((compare == 0) & (getLowerBoundType() == BoundType.OPEN)) | (compare < 0);
            }
            return false;
        }
        return invokeL.booleanValue;
    }
}
