package com.google.protobuf;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
/* loaded from: classes6.dex */
public class LazyField {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ByteString bytes;
    public final MessageLite defaultInstance;
    public final ExtensionRegistryLite extensionRegistry;
    public volatile boolean isDirty;
    public volatile MessageLite value;

    /* renamed from: com.google.protobuf.LazyField$1  reason: invalid class name */
    /* loaded from: classes6.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes6.dex */
    public static class LazyEntry<K> implements Map.Entry<K, Object> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public Map.Entry<K, LazyField> entry;

        public /* synthetic */ LazyEntry(Map.Entry entry, AnonymousClass1 anonymousClass1) {
            this(entry);
        }

        public LazyField getField() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.entry.getValue() : (LazyField) invokeV.objValue;
        }

        @Override // java.util.Map.Entry
        public K getKey() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.entry.getKey() : (K) invokeV.objValue;
        }

        @Override // java.util.Map.Entry
        public Object getValue() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                LazyField value = this.entry.getValue();
                if (value == null) {
                    return null;
                }
                return value.getValue();
            }
            return invokeV.objValue;
        }

        @Override // java.util.Map.Entry
        public Object setValue(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, obj)) == null) {
                if (obj instanceof MessageLite) {
                    return this.entry.getValue().setValue((MessageLite) obj);
                }
                throw new IllegalArgumentException("LazyField now only used for MessageSet, and the value of MessageSet must be an instance of MessageLite");
            }
            return invokeL.objValue;
        }

        public LazyEntry(Map.Entry<K, LazyField> entry) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {entry};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.entry = entry;
        }
    }

    /* loaded from: classes6.dex */
    public static class LazyIterator<K> implements Iterator<Map.Entry<K, Object>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public Iterator<Map.Entry<K, Object>> iterator;

        public LazyIterator(Iterator<Map.Entry<K, Object>> it) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {it};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.iterator = it;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.iterator.hasNext() : invokeV.booleanValue;
        }

        @Override // java.util.Iterator
        public void remove() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                this.iterator.remove();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Iterator
        public Map.Entry<K, Object> next() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                Map.Entry<K, Object> next = this.iterator.next();
                return next.getValue() instanceof LazyField ? new LazyEntry(next, null) : next;
            }
            return (Map.Entry) invokeV.objValue;
        }
    }

    public LazyField(MessageLite messageLite, ExtensionRegistryLite extensionRegistryLite, ByteString byteString) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {messageLite, extensionRegistryLite, byteString};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.isDirty = false;
        this.defaultInstance = messageLite;
        this.extensionRegistry = extensionRegistryLite;
        this.bytes = byteString;
    }

    private void ensureInitialized() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65537, this) == null) && this.value == null) {
            synchronized (this) {
                if (this.value != null) {
                    return;
                }
                try {
                    if (this.bytes != null) {
                        this.value = this.defaultInstance.getParserForType().parseFrom(this.bytes, this.extensionRegistry);
                    }
                } catch (IOException unused) {
                }
            }
        }
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, obj)) == null) {
            ensureInitialized();
            return this.value.equals(obj);
        }
        return invokeL.booleanValue;
    }

    public int getSerializedSize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (this.isDirty) {
                return this.value.getSerializedSize();
            }
            return this.bytes.size();
        }
        return invokeV.intValue;
    }

    public MessageLite getValue() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            ensureInitialized();
            return this.value;
        }
        return (MessageLite) invokeV.objValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            ensureInitialized();
            return this.value.hashCode();
        }
        return invokeV.intValue;
    }

    public MessageLite setValue(MessageLite messageLite) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, messageLite)) == null) {
            MessageLite messageLite2 = this.value;
            this.value = messageLite;
            this.bytes = null;
            this.isDirty = true;
            return messageLite2;
        }
        return (MessageLite) invokeL.objValue;
    }

    public ByteString toByteString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            if (!this.isDirty) {
                return this.bytes;
            }
            synchronized (this) {
                if (!this.isDirty) {
                    return this.bytes;
                }
                this.bytes = this.value.toByteString();
                this.isDirty = false;
                return this.bytes;
            }
        }
        return (ByteString) invokeV.objValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            ensureInitialized();
            return this.value.toString();
        }
        return (String) invokeV.objValue;
    }
}
