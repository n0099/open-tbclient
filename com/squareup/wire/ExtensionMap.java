package com.squareup.wire;

import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.squareup.wire.ExtendableMessage;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
/* loaded from: classes7.dex */
public final class ExtensionMap<T extends ExtendableMessage<?>> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Map<Extension<T, ?>, Object> map;

    public ExtensionMap() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.map = new TreeMap();
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, obj)) == null) ? (obj instanceof ExtensionMap) && this.map.equals(((ExtensionMap) obj).map) : invokeL.booleanValue;
    }

    public <E> E get(Extension<T, E> extension) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, extension)) == null) ? (E) this.map.get(extension) : (E) invokeL.objValue;
    }

    public List<Extension<T, ?>> getExtensions() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? Collections.unmodifiableList(new ArrayList(this.map.keySet())) : (List) invokeV.objValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.map.hashCode() : invokeV.intValue;
    }

    public <E> void put(Extension<T, E> extension, E e2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, extension, e2) == null) {
            this.map.put(extension, e2);
        }
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            StringBuilder sb = new StringBuilder();
            sb.append(StringUtil.ARRAY_START);
            String str = "";
            for (Map.Entry<Extension<T, ?>, Object> entry : this.map.entrySet()) {
                sb.append(str);
                sb.append(entry.getKey().getTag());
                sb.append("=");
                sb.append(entry.getValue());
                str = StringUtil.ARRAY_ELEMENT_SEPARATOR;
            }
            sb.append("}");
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }

    public ExtensionMap(ExtensionMap<T> extensionMap) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {extensionMap};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        TreeMap treeMap = new TreeMap();
        this.map = treeMap;
        treeMap.putAll(extensionMap.map);
    }
}
