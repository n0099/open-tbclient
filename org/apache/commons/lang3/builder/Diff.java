package org.apache.commons.lang3.builder;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.reflect.Type;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.reflect.TypeUtils;
import org.apache.commons.lang3.tuple.Pair;
/* loaded from: classes3.dex */
public abstract class Diff<T> extends Pair<T, T> {
    public static /* synthetic */ Interceptable $ic = null;
    public static final long serialVersionUID = 1;
    public transient /* synthetic */ FieldHolder $fh;
    public final String fieldName;
    public final Type type;

    public Diff(String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.type = (Type) ObjectUtils.defaultIfNull(TypeUtils.getTypeArguments(getClass(), Diff.class).get(Diff.class.getTypeParameters()[0]), Object.class);
        this.fieldName = str;
    }

    public final String getFieldName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.fieldName : (String) invokeV.objValue;
    }

    public final Type getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.type : (Type) invokeV.objValue;
    }

    @Override // java.util.Map.Entry
    public final T setValue(T t) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, t)) == null) {
            throw new UnsupportedOperationException("Cannot alter Diff object.");
        }
        return (T) invokeL.objValue;
    }

    @Override // org.apache.commons.lang3.tuple.Pair
    public final String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? String.format("[%s: %s, %s]", this.fieldName, getLeft(), getRight()) : (String) invokeV.objValue;
    }
}
