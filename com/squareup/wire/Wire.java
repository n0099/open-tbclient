package com.squareup.wire;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.squareup.wire.Message;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes8.dex */
public final class Wire {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Map<Class<? extends Message.Builder>, BuilderAdapter<? extends Message.Builder>> builderAdapters;
    public final Map<Class<? extends ProtoEnum>, EnumAdapter<? extends ProtoEnum>> enumAdapters;
    public final Map<Class<? extends Message>, MessageAdapter<? extends Message>> messageAdapters;
    public final ExtensionRegistry registry;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public Wire(Class<?>... clsArr) {
        this(Arrays.asList(clsArr));
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {clsArr};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                this((List) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public static <T> T get(T t, T t2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, t, t2)) == null) ? t != null ? t : t2 : (T) invokeLL.objValue;
    }

    public synchronized <B extends Message.Builder> BuilderAdapter<B> builderAdapter(Class<B> cls) {
        InterceptResult invokeL;
        BuilderAdapter<B> builderAdapter;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, cls)) == null) {
            synchronized (this) {
                builderAdapter = (BuilderAdapter<B>) this.builderAdapters.get(cls);
                if (builderAdapter == null) {
                    builderAdapter = new BuilderAdapter<>(cls);
                    this.builderAdapters.put(cls, builderAdapter);
                }
            }
            return builderAdapter;
        }
        return (BuilderAdapter) invokeL.objValue;
    }

    public synchronized <E extends ProtoEnum> EnumAdapter<E> enumAdapter(Class<E> cls) {
        InterceptResult invokeL;
        EnumAdapter<E> enumAdapter;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cls)) == null) {
            synchronized (this) {
                enumAdapter = (EnumAdapter<E>) this.enumAdapters.get(cls);
                if (enumAdapter == null) {
                    enumAdapter = new EnumAdapter<>(cls);
                    this.enumAdapters.put(cls, enumAdapter);
                }
            }
            return enumAdapter;
        }
        return (EnumAdapter) invokeL.objValue;
    }

    public synchronized <M extends Message> MessageAdapter<M> messageAdapter(Class<M> cls) {
        InterceptResult invokeL;
        MessageAdapter<M> messageAdapter;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, cls)) == null) {
            synchronized (this) {
                messageAdapter = (MessageAdapter<M>) this.messageAdapters.get(cls);
                if (messageAdapter == null) {
                    messageAdapter = new MessageAdapter<>(this, cls);
                    this.messageAdapters.put(cls, messageAdapter);
                }
            }
            return messageAdapter;
        }
        return (MessageAdapter) invokeL.objValue;
    }

    public <M extends Message> M parseFrom(byte[] bArr, Class<M> cls) throws IOException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, bArr, cls)) == null) {
            Preconditions.checkNotNull(bArr, "bytes");
            Preconditions.checkNotNull(cls, "messageClass");
            return (M) parseFrom(WireInput.newInstance(bArr), cls);
        }
        return (M) invokeLL.objValue;
    }

    public Wire(List<Class<?>> list) {
        Field[] declaredFields;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {list};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.messageAdapters = new LinkedHashMap();
        this.builderAdapters = new LinkedHashMap();
        this.enumAdapters = new LinkedHashMap();
        this.registry = new ExtensionRegistry();
        for (Class<?> cls : list) {
            for (Field field : cls.getDeclaredFields()) {
                if (field.getType().equals(Extension.class)) {
                    try {
                        this.registry.add((Extension) field.get(null));
                    } catch (IllegalAccessException e) {
                        throw new AssertionError(e);
                    }
                }
            }
        }
    }

    public <M extends Message> M parseFrom(byte[] bArr, int i, int i2, Class<M> cls) throws IOException {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{bArr, Integer.valueOf(i), Integer.valueOf(i2), cls})) == null) {
            Preconditions.checkNotNull(bArr, "bytes");
            Preconditions.checkArgument(i >= 0, "offset < 0");
            Preconditions.checkArgument(i2 >= 0, "count < 0");
            Preconditions.checkArgument(i + i2 <= bArr.length, "offset + count > bytes");
            Preconditions.checkNotNull(cls, "messageClass");
            return (M) parseFrom(WireInput.newInstance(bArr, i, i2), cls);
        }
        return (M) invokeCommon.objValue;
    }

    public <M extends Message> M parseFrom(InputStream inputStream, Class<M> cls) throws IOException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, inputStream, cls)) == null) {
            Preconditions.checkNotNull(inputStream, "input");
            Preconditions.checkNotNull(cls, "messageClass");
            return (M) parseFrom(WireInput.newInstance(inputStream), cls);
        }
        return (M) invokeLL.objValue;
    }

    private <M extends Message> M parseFrom(WireInput wireInput, Class<M> cls) throws IOException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65539, this, wireInput, cls)) == null) ? messageAdapter(cls).read(wireInput) : (M) invokeLL.objValue;
    }
}
