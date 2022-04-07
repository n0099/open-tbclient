package com.squareup.wire;

import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.squareup.wire.ExtendableMessage;
import com.squareup.wire.Message;
import java.util.Collections;
import java.util.List;
/* loaded from: classes7.dex */
public abstract class ExtendableMessage<T extends ExtendableMessage<?>> extends Message {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public transient ExtensionMap<T> extensionMap;

    /* loaded from: classes7.dex */
    public static abstract class ExtendableBuilder<T extends ExtendableMessage<?>> extends Message.Builder<T> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public ExtensionMap<T> extensionMap;

        public ExtendableBuilder() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public <E> E getExtension(Extension<T, E> extension) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, extension)) == null) {
                ExtensionMap<T> extensionMap = this.extensionMap;
                if (extensionMap == null) {
                    return null;
                }
                return (E) extensionMap.get(extension);
            }
            return (E) invokeL.objValue;
        }

        public <E> ExtendableBuilder<T> setExtension(Extension<T, E> extension, E e) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, extension, e)) == null) {
                if (this.extensionMap == null) {
                    this.extensionMap = new ExtensionMap<>();
                }
                this.extensionMap.put(extension, e);
                return this;
            }
            return (ExtendableBuilder) invokeLL.objValue;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ExtendableBuilder(ExtendableMessage<T> extendableMessage) {
            super(extendableMessage);
            ExtensionMap<T> extensionMap;
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {extendableMessage};
                interceptable.invokeUnInit(65537, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((Message) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            if (extendableMessage == null || (extensionMap = extendableMessage.extensionMap) == null) {
                return;
            }
            this.extensionMap = new ExtensionMap<>(extensionMap);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ExtendableMessage(ExtendableBuilder<T> extendableBuilder) {
        super(extendableBuilder);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {extendableBuilder};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Message.Builder) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        ExtensionMap<T> extensionMap = extendableBuilder.extensionMap;
        if (extensionMap != null) {
            this.extensionMap = new ExtensionMap<>(extensionMap);
        }
    }

    public boolean extensionsEqual(ExtendableMessage<T> extendableMessage) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, extendableMessage)) == null) {
            ExtensionMap<T> extensionMap = this.extensionMap;
            if (extensionMap == null) {
                return extendableMessage.extensionMap == null;
            }
            return extensionMap.equals(extendableMessage.extensionMap);
        }
        return invokeL.booleanValue;
    }

    public int extensionsHashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            ExtensionMap<T> extensionMap = this.extensionMap;
            if (extensionMap == null) {
                return 0;
            }
            return extensionMap.hashCode();
        }
        return invokeV.intValue;
    }

    public String extensionsToString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            ExtensionMap<T> extensionMap = this.extensionMap;
            return extensionMap == null ? StringUtil.EMPTY_ARRAY : extensionMap.toString();
        }
        return (String) invokeV.objValue;
    }

    public <E> E getExtension(Extension<T, E> extension) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, extension)) == null) {
            ExtensionMap<T> extensionMap = this.extensionMap;
            if (extensionMap == null) {
                return null;
            }
            return (E) extensionMap.get(extension);
        }
        return (E) invokeL.objValue;
    }

    public List<Extension<T, ?>> getExtensions() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            ExtensionMap<T> extensionMap = this.extensionMap;
            return extensionMap == null ? Collections.emptyList() : extensionMap.getExtensions();
        }
        return (List) invokeV.objValue;
    }
}
