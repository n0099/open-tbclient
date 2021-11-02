package org.apache.commons.lang3.tuple;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Serializable;
import java.util.Map;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.builder.CompareToBuilder;
/* loaded from: classes3.dex */
public abstract class Pair<L, R> implements Map.Entry<L, R>, Comparable<Pair<L, R>>, Serializable {
    public static /* synthetic */ Interceptable $ic = null;
    public static final long serialVersionUID = 4954918890077093841L;
    public transient /* synthetic */ FieldHolder $fh;

    public Pair() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static <L, R> Pair<L, R> of(L l, R r) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, l, r)) == null) ? new ImmutablePair(l, r) : (Pair) invokeLL.objValue;
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(Object obj) {
        return compareTo((Pair) ((Pair) obj));
    }

    @Override // java.util.Map.Entry
    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, obj)) == null) {
            if (obj == this) {
                return true;
            }
            if (obj instanceof Map.Entry) {
                Map.Entry entry = (Map.Entry) obj;
                return ObjectUtils.equals(getKey(), entry.getKey()) && ObjectUtils.equals(getValue(), entry.getValue());
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // java.util.Map.Entry
    public final L getKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? getLeft() : (L) invokeV.objValue;
    }

    public abstract L getLeft();

    public abstract R getRight();

    @Override // java.util.Map.Entry
    public R getValue() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? getRight() : (R) invokeV.objValue;
    }

    @Override // java.util.Map.Entry
    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return (getKey() == null ? 0 : getKey().hashCode()) ^ (getValue() != null ? getValue().hashCode() : 0);
        }
        return invokeV.intValue;
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [('(' char), (wrap: L : 0x000e: INVOKE  (r1v3 L A[REMOVE]) = (r4v0 'this' org.apache.commons.lang3.tuple.Pair<L, R> A[IMMUTABLE_TYPE, THIS]) type: VIRTUAL call: org.apache.commons.lang3.tuple.Pair.getLeft():java.lang.Object), (',' char), (wrap: R : 0x001a: INVOKE  (r1v5 R A[REMOVE]) = (r4v0 'this' org.apache.commons.lang3.tuple.Pair<L, R> A[IMMUTABLE_TYPE, THIS]) type: VIRTUAL call: org.apache.commons.lang3.tuple.Pair.getRight():java.lang.Object), (')' char)] */
    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            StringBuilder sb = new StringBuilder();
            sb.append('(');
            sb.append(getLeft());
            sb.append(',');
            sb.append(getRight());
            sb.append(')');
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }

    public int compareTo(Pair<L, R> pair) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pair)) == null) ? new CompareToBuilder().append(getLeft(), pair.getLeft()).append(getRight(), pair.getRight()).toComparison() : invokeL.intValue;
    }

    public String toString(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, str)) == null) ? String.format(str, getLeft(), getRight()) : (String) invokeL.objValue;
    }
}
