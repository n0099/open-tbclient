package org.apache.commons.lang3.builder;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes4.dex */
public class DiffResult implements Iterable<Diff<?>> {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String DIFFERS_STRING = "differs from";
    public static final String OBJECTS_SAME_STRING = "";
    public transient /* synthetic */ FieldHolder $fh;
    public final List<Diff<?>> diffs;
    public final Object lhs;
    public final Object rhs;
    public final ToStringStyle style;

    public DiffResult(Object obj, Object obj2, List<Diff<?>> list, ToStringStyle toStringStyle) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {obj, obj2, list, toStringStyle};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        if (obj == null) {
            throw new IllegalArgumentException("Left hand object cannot be null");
        }
        if (obj2 == null) {
            throw new IllegalArgumentException("Right hand object cannot be null");
        }
        if (list != null) {
            this.diffs = list;
            this.lhs = obj;
            this.rhs = obj2;
            if (toStringStyle == null) {
                this.style = ToStringStyle.DEFAULT_STYLE;
                return;
            } else {
                this.style = toStringStyle;
                return;
            }
        }
        throw new IllegalArgumentException("List of differences cannot be null");
    }

    public List<Diff<?>> getDiffs() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? Collections.unmodifiableList(this.diffs) : (List) invokeV.objValue;
    }

    public int getNumberOfDiffs() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.diffs.size() : invokeV.intValue;
    }

    public ToStringStyle getToStringStyle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.style : (ToStringStyle) invokeV.objValue;
    }

    @Override // java.lang.Iterable
    public Iterator<Diff<?>> iterator() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.diffs.iterator() : (Iterator) invokeV.objValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? toString(this.style) : (String) invokeV.objValue;
    }

    public String toString(ToStringStyle toStringStyle) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, toStringStyle)) == null) {
            if (this.diffs.size() == 0) {
                return "";
            }
            ToStringBuilder toStringBuilder = new ToStringBuilder(this.lhs, toStringStyle);
            ToStringBuilder toStringBuilder2 = new ToStringBuilder(this.rhs, toStringStyle);
            for (Diff<?> diff : this.diffs) {
                toStringBuilder.append(diff.getFieldName(), diff.getLeft());
                toStringBuilder2.append(diff.getFieldName(), diff.getRight());
            }
            return String.format("%s %s %s", toStringBuilder.build(), DIFFERS_STRING, toStringBuilder2.build());
        }
        return (String) invokeL.objValue;
    }
}
