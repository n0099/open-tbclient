package com.squareup.wire;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.LinkedHashMap;
import java.util.Map;
/* loaded from: classes7.dex */
public final class ExtensionRegistry {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Map<Class<? extends ExtendableMessage>, Map<String, Extension<?, ?>>> extensionsByName;
    public final Map<Class<? extends ExtendableMessage>, Map<Integer, Extension<?, ?>>> extensionsByTag;

    public ExtensionRegistry() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.extensionsByTag = new LinkedHashMap();
        this.extensionsByName = new LinkedHashMap();
    }

    public <T extends ExtendableMessage<?>, E> void add(Extension<T, E> extension) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, extension) == null) {
            Class<T> extendedType = extension.getExtendedType();
            Map<Integer, Extension<?, ?>> map = this.extensionsByTag.get(extendedType);
            Map<String, Extension<?, ?>> map2 = this.extensionsByName.get(extendedType);
            if (map == null) {
                map = new LinkedHashMap<>();
                map2 = new LinkedHashMap<>();
                this.extensionsByTag.put(extendedType, map);
                this.extensionsByName.put(extendedType, map2);
            }
            map.put(Integer.valueOf(extension.getTag()), extension);
            map2.put(extension.getName(), extension);
        }
    }

    public <T extends ExtendableMessage<?>, E> Extension<T, E> getExtension(Class<T> cls, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cls, i)) == null) {
            Map<Integer, Extension<?, ?>> map = this.extensionsByTag.get(cls);
            if (map == null) {
                return null;
            }
            return (Extension<T, E>) map.get(Integer.valueOf(i));
        }
        return (Extension) invokeLI.objValue;
    }

    public <T extends ExtendableMessage<?>, E> Extension<T, E> getExtension(Class<T> cls, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, cls, str)) == null) {
            Map<String, Extension<?, ?>> map = this.extensionsByName.get(cls);
            if (map == null) {
                return null;
            }
            return (Extension<T, E>) map.get(str);
        }
        return (Extension) invokeLL.objValue;
    }
}
