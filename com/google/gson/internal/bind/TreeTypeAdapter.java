package com.google.gson.internal.bind;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.gson.Gson;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.internal.C$Gson$Preconditions;
import com.google.gson.internal.Streams;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.lang.reflect.Type;
/* loaded from: classes7.dex */
public final class TreeTypeAdapter<T> extends TypeAdapter<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final TreeTypeAdapter<T>.GsonContextImpl context;
    public TypeAdapter<T> delegate;
    public final JsonDeserializer<T> deserializer;
    public final Gson gson;
    public final JsonSerializer<T> serializer;
    public final TypeAdapterFactory skipPast;
    public final TypeToken<T> typeToken;

    /* renamed from: com.google.gson.internal.bind.TreeTypeAdapter$1  reason: invalid class name */
    /* loaded from: classes7.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes7.dex */
    public final class GsonContextImpl implements JsonSerializationContext, JsonDeserializationContext {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TreeTypeAdapter this$0;

        public GsonContextImpl(TreeTypeAdapter treeTypeAdapter) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {treeTypeAdapter};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = treeTypeAdapter;
        }

        @Override // com.google.gson.JsonSerializationContext
        public JsonElement serialize(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj)) == null) {
                return this.this$0.gson.toJsonTree(obj);
            }
            return (JsonElement) invokeL.objValue;
        }

        public /* synthetic */ GsonContextImpl(TreeTypeAdapter treeTypeAdapter, AnonymousClass1 anonymousClass1) {
            this(treeTypeAdapter);
        }

        @Override // com.google.gson.JsonDeserializationContext
        public <R> R deserialize(JsonElement jsonElement, Type type) throws JsonParseException {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, jsonElement, type)) == null) {
                return (R) this.this$0.gson.fromJson(jsonElement, type);
            }
            return (R) invokeLL.objValue;
        }

        @Override // com.google.gson.JsonSerializationContext
        public JsonElement serialize(Object obj, Type type) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, obj, type)) == null) {
                return this.this$0.gson.toJsonTree(obj, type);
            }
            return (JsonElement) invokeLL.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public static final class SingleTypeFactory implements TypeAdapterFactory {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final JsonDeserializer<?> deserializer;
        public final TypeToken<?> exactType;
        public final Class<?> hierarchyType;
        public final boolean matchRawType;
        public final JsonSerializer<?> serializer;

        public SingleTypeFactory(Object obj, TypeToken<?> typeToken, boolean z, Class<?> cls) {
            JsonSerializer<?> jsonSerializer;
            boolean z2;
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {obj, typeToken, Boolean.valueOf(z), cls};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            if (obj instanceof JsonSerializer) {
                jsonSerializer = (JsonSerializer) obj;
            } else {
                jsonSerializer = null;
            }
            this.serializer = jsonSerializer;
            JsonDeserializer<?> jsonDeserializer = obj instanceof JsonDeserializer ? (JsonDeserializer) obj : null;
            this.deserializer = jsonDeserializer;
            if (this.serializer == null && jsonDeserializer == null) {
                z2 = false;
            } else {
                z2 = true;
            }
            C$Gson$Preconditions.checkArgument(z2);
            this.exactType = typeToken;
            this.matchRawType = z;
            this.hierarchyType = cls;
        }

        @Override // com.google.gson.TypeAdapterFactory
        public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> typeToken) {
            InterceptResult invokeLL;
            boolean isAssignableFrom;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, gson, typeToken)) == null) {
                TypeToken<?> typeToken2 = this.exactType;
                if (typeToken2 != null) {
                    if (!typeToken2.equals(typeToken) && (!this.matchRawType || this.exactType.getType() != typeToken.getRawType())) {
                        isAssignableFrom = false;
                    } else {
                        isAssignableFrom = true;
                    }
                } else {
                    isAssignableFrom = this.hierarchyType.isAssignableFrom(typeToken.getRawType());
                }
                if (isAssignableFrom) {
                    return new TreeTypeAdapter(this.serializer, this.deserializer, gson, typeToken, this);
                }
                return null;
            }
            return (TypeAdapter) invokeLL.objValue;
        }
    }

    public TreeTypeAdapter(JsonSerializer<T> jsonSerializer, JsonDeserializer<T> jsonDeserializer, Gson gson, TypeToken<T> typeToken, TypeAdapterFactory typeAdapterFactory) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {jsonSerializer, jsonDeserializer, gson, typeToken, typeAdapterFactory};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.context = new GsonContextImpl(this, null);
        this.serializer = jsonSerializer;
        this.deserializer = jsonDeserializer;
        this.gson = gson;
        this.typeToken = typeToken;
        this.skipPast = typeAdapterFactory;
    }

    private TypeAdapter<T> delegate() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, this)) == null) {
            TypeAdapter<T> typeAdapter = this.delegate;
            if (typeAdapter == null) {
                TypeAdapter<T> delegateAdapter = this.gson.getDelegateAdapter(this.skipPast, this.typeToken);
                this.delegate = delegateAdapter;
                return delegateAdapter;
            }
            return typeAdapter;
        }
        return (TypeAdapter) invokeV.objValue;
    }

    public static TypeAdapterFactory newFactory(TypeToken<?> typeToken, Object obj) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, typeToken, obj)) == null) {
            return new SingleTypeFactory(obj, typeToken, false, null);
        }
        return (TypeAdapterFactory) invokeLL.objValue;
    }

    public static TypeAdapterFactory newFactoryWithMatchRawType(TypeToken<?> typeToken, Object obj) {
        InterceptResult invokeLL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, typeToken, obj)) == null) {
            if (typeToken.getType() == typeToken.getRawType()) {
                z = true;
            } else {
                z = false;
            }
            return new SingleTypeFactory(obj, typeToken, z, null);
        }
        return (TypeAdapterFactory) invokeLL.objValue;
    }

    public static TypeAdapterFactory newTypeHierarchyFactory(Class<?> cls, Object obj) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, cls, obj)) == null) {
            return new SingleTypeFactory(obj, null, false, cls);
        }
        return (TypeAdapterFactory) invokeLL.objValue;
    }

    @Override // com.google.gson.TypeAdapter
    public void write(JsonWriter jsonWriter, T t) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jsonWriter, t) == null) {
            JsonSerializer<T> jsonSerializer = this.serializer;
            if (jsonSerializer == null) {
                delegate().write(jsonWriter, t);
            } else if (t == null) {
                jsonWriter.nullValue();
            } else {
                Streams.write(jsonSerializer.serialize(t, this.typeToken.getType(), this.context), jsonWriter);
            }
        }
    }

    @Override // com.google.gson.TypeAdapter
    public T read(JsonReader jsonReader) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, jsonReader)) == null) {
            if (this.deserializer == null) {
                return delegate().read(jsonReader);
            }
            JsonElement parse = Streams.parse(jsonReader);
            if (parse.isJsonNull()) {
                return null;
            }
            return this.deserializer.deserialize(parse, this.typeToken.getType(), this.context);
        }
        return (T) invokeL.objValue;
    }
}
