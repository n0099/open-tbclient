package com.google.gson.internal.bind;

import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSyntaxException;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.internal.C$Gson$Types;
import com.google.gson.internal.ConstructorConstructor;
import com.google.gson.internal.JsonReaderInternalAccess;
import com.google.gson.internal.ObjectConstructor;
import com.google.gson.internal.Streams;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Map;
/* loaded from: classes7.dex */
public final class MapTypeAdapterFactory implements TypeAdapterFactory {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final boolean complexMapKeySerialization;
    public final ConstructorConstructor constructorConstructor;

    /* loaded from: classes7.dex */
    public final class Adapter<K, V> extends TypeAdapter<Map<K, V>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final ObjectConstructor<? extends Map<K, V>> constructor;
        public final TypeAdapter<K> keyTypeAdapter;
        public final /* synthetic */ MapTypeAdapterFactory this$0;
        public final TypeAdapter<V> valueTypeAdapter;

        public Adapter(MapTypeAdapterFactory mapTypeAdapterFactory, Gson gson, Type type, TypeAdapter<K> typeAdapter, Type type2, TypeAdapter<V> typeAdapter2, ObjectConstructor<? extends Map<K, V>> objectConstructor) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mapTypeAdapterFactory, gson, type, typeAdapter, type2, typeAdapter2, objectConstructor};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = mapTypeAdapterFactory;
            this.keyTypeAdapter = new TypeAdapterRuntimeTypeWrapper(gson, typeAdapter, type);
            this.valueTypeAdapter = new TypeAdapterRuntimeTypeWrapper(gson, typeAdapter2, type2);
            this.constructor = objectConstructor;
        }

        private String keyToString(JsonElement jsonElement) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65537, this, jsonElement)) == null) {
                if (jsonElement.isJsonPrimitive()) {
                    JsonPrimitive asJsonPrimitive = jsonElement.getAsJsonPrimitive();
                    if (asJsonPrimitive.isNumber()) {
                        return String.valueOf(asJsonPrimitive.getAsNumber());
                    }
                    if (asJsonPrimitive.isBoolean()) {
                        return Boolean.toString(asJsonPrimitive.getAsBoolean());
                    }
                    if (asJsonPrimitive.isString()) {
                        return asJsonPrimitive.getAsString();
                    }
                    throw new AssertionError();
                } else if (jsonElement.isJsonNull()) {
                    return StringUtil.NULL_STRING;
                } else {
                    throw new AssertionError();
                }
            }
            return (String) invokeL.objValue;
        }

        @Override // com.google.gson.TypeAdapter
        public /* bridge */ /* synthetic */ void write(JsonWriter jsonWriter, Object obj) throws IOException {
            write(jsonWriter, (Map) ((Map) obj));
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.TypeAdapter
        public Map<K, V> read(JsonReader jsonReader) throws IOException {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jsonReader)) == null) {
                JsonToken peek = jsonReader.peek();
                if (peek == JsonToken.NULL) {
                    jsonReader.nextNull();
                    return null;
                }
                Map<K, V> construct = this.constructor.construct();
                if (peek == JsonToken.BEGIN_ARRAY) {
                    jsonReader.beginArray();
                    while (jsonReader.hasNext()) {
                        jsonReader.beginArray();
                        K read = this.keyTypeAdapter.read(jsonReader);
                        if (construct.put(read, this.valueTypeAdapter.read(jsonReader)) == null) {
                            jsonReader.endArray();
                        } else {
                            throw new JsonSyntaxException("duplicate key: " + read);
                        }
                    }
                    jsonReader.endArray();
                } else {
                    jsonReader.beginObject();
                    while (jsonReader.hasNext()) {
                        JsonReaderInternalAccess.INSTANCE.promoteNameToValue(jsonReader);
                        K read2 = this.keyTypeAdapter.read(jsonReader);
                        if (construct.put(read2, this.valueTypeAdapter.read(jsonReader)) != null) {
                            throw new JsonSyntaxException("duplicate key: " + read2);
                        }
                    }
                    jsonReader.endObject();
                }
                return construct;
            }
            return (Map) invokeL.objValue;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r3v5, resolved type: com.google.gson.TypeAdapter<V> */
        /* JADX DEBUG: Multi-variable search result rejected for r3v8, resolved type: com.google.gson.TypeAdapter<V> */
        /* JADX WARN: Multi-variable type inference failed */
        public void write(JsonWriter jsonWriter, Map<K, V> map) throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048579, this, jsonWriter, map) == null) {
                if (map == null) {
                    jsonWriter.nullValue();
                } else if (!this.this$0.complexMapKeySerialization) {
                    jsonWriter.beginObject();
                    for (Map.Entry<K, V> entry : map.entrySet()) {
                        jsonWriter.name(String.valueOf(entry.getKey()));
                        this.valueTypeAdapter.write(jsonWriter, entry.getValue());
                    }
                    jsonWriter.endObject();
                } else {
                    ArrayList arrayList = new ArrayList(map.size());
                    ArrayList arrayList2 = new ArrayList(map.size());
                    int i = 0;
                    boolean z = false;
                    for (Map.Entry<K, V> entry2 : map.entrySet()) {
                        JsonElement jsonTree = this.keyTypeAdapter.toJsonTree(entry2.getKey());
                        arrayList.add(jsonTree);
                        arrayList2.add(entry2.getValue());
                        z |= jsonTree.isJsonArray() || jsonTree.isJsonObject();
                    }
                    if (z) {
                        jsonWriter.beginArray();
                        int size = arrayList.size();
                        while (i < size) {
                            jsonWriter.beginArray();
                            Streams.write((JsonElement) arrayList.get(i), jsonWriter);
                            this.valueTypeAdapter.write(jsonWriter, arrayList2.get(i));
                            jsonWriter.endArray();
                            i++;
                        }
                        jsonWriter.endArray();
                        return;
                    }
                    jsonWriter.beginObject();
                    int size2 = arrayList.size();
                    while (i < size2) {
                        jsonWriter.name(keyToString((JsonElement) arrayList.get(i)));
                        this.valueTypeAdapter.write(jsonWriter, arrayList2.get(i));
                        i++;
                    }
                    jsonWriter.endObject();
                }
            }
        }
    }

    public MapTypeAdapterFactory(ConstructorConstructor constructorConstructor, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {constructorConstructor, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.constructorConstructor = constructorConstructor;
        this.complexMapKeySerialization = z;
    }

    private TypeAdapter<?> getKeyAdapter(Gson gson, Type type) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, this, gson, type)) == null) {
            if (type != Boolean.TYPE && type != Boolean.class) {
                return gson.getAdapter(TypeToken.get(type));
            }
            return TypeAdapters.BOOLEAN_AS_STRING;
        }
        return (TypeAdapter) invokeLL.objValue;
    }

    @Override // com.google.gson.TypeAdapterFactory
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> typeToken) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, gson, typeToken)) == null) {
            Type type = typeToken.getType();
            if (Map.class.isAssignableFrom(typeToken.getRawType())) {
                Type[] mapKeyAndValueTypes = C$Gson$Types.getMapKeyAndValueTypes(type, C$Gson$Types.getRawType(type));
                return new Adapter(this, gson, mapKeyAndValueTypes[0], getKeyAdapter(gson, mapKeyAndValueTypes[0]), mapKeyAndValueTypes[1], gson.getAdapter(TypeToken.get(mapKeyAndValueTypes[1])), this.constructorConstructor.get(typeToken));
            }
            return null;
        }
        return (TypeAdapter) invokeLL.objValue;
    }
}
