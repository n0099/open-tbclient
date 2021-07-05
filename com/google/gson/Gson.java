package com.google.gson;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bumptech.glide.load.engine.GlideException;
import com.google.gson.internal.ConstructorConstructor;
import com.google.gson.internal.Excluder;
import com.google.gson.internal.Primitives;
import com.google.gson.internal.Streams;
import com.google.gson.internal.bind.ArrayTypeAdapter;
import com.google.gson.internal.bind.CollectionTypeAdapterFactory;
import com.google.gson.internal.bind.DateTypeAdapter;
import com.google.gson.internal.bind.JsonAdapterAnnotationTypeAdapterFactory;
import com.google.gson.internal.bind.JsonTreeReader;
import com.google.gson.internal.bind.JsonTreeWriter;
import com.google.gson.internal.bind.MapTypeAdapterFactory;
import com.google.gson.internal.bind.ObjectTypeAdapter;
import com.google.gson.internal.bind.ReflectiveTypeAdapterFactory;
import com.google.gson.internal.bind.SqlDateTypeAdapter;
import com.google.gson.internal.bind.TimeTypeAdapter;
import com.google.gson.internal.bind.TypeAdapters;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import com.google.gson.stream.MalformedJsonException;
import java.io.EOFException;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicLongArray;
/* loaded from: classes7.dex */
public final class Gson {
    public static /* synthetic */ Interceptable $ic = null;
    public static final boolean DEFAULT_COMPLEX_MAP_KEYS = false;
    public static final boolean DEFAULT_ESCAPE_HTML = true;
    public static final boolean DEFAULT_JSON_NON_EXECUTABLE = false;
    public static final boolean DEFAULT_LENIENT = false;
    public static final boolean DEFAULT_PRETTY_PRINT = false;
    public static final boolean DEFAULT_SERIALIZE_NULLS = false;
    public static final boolean DEFAULT_SPECIALIZE_FLOAT_VALUES = false;
    public static final String JSON_NON_EXECUTABLE_PREFIX = ")]}'\n";
    public static final TypeToken<?> NULL_KEY_SURROGATE;
    public transient /* synthetic */ FieldHolder $fh;
    public final List<TypeAdapterFactory> builderFactories;
    public final List<TypeAdapterFactory> builderHierarchyFactories;
    public final ThreadLocal<Map<TypeToken<?>, FutureTypeAdapter<?>>> calls;
    public final boolean complexMapKeySerialization;
    public final ConstructorConstructor constructorConstructor;
    public final String datePattern;
    public final int dateStyle;
    public final Excluder excluder;
    public final List<TypeAdapterFactory> factories;
    public final FieldNamingStrategy fieldNamingStrategy;
    public final boolean generateNonExecutableJson;
    public final boolean htmlSafe;
    public final Map<Type, InstanceCreator<?>> instanceCreators;
    public final JsonAdapterAnnotationTypeAdapterFactory jsonAdapterFactory;
    public final boolean lenient;
    public final LongSerializationPolicy longSerializationPolicy;
    public final boolean prettyPrinting;
    public final boolean serializeNulls;
    public final boolean serializeSpecialFloatingPointValues;
    public final int timeStyle;
    public final Map<TypeToken<?>, TypeAdapter<?>> typeTokenCache;

    /* loaded from: classes7.dex */
    public static class FutureTypeAdapter<T> extends TypeAdapter<T> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public TypeAdapter<T> delegate;

        public FutureTypeAdapter() {
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

        @Override // com.google.gson.TypeAdapter
        public T read(JsonReader jsonReader) throws IOException {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, jsonReader)) == null) {
                TypeAdapter<T> typeAdapter = this.delegate;
                if (typeAdapter != null) {
                    return typeAdapter.read(jsonReader);
                }
                throw new IllegalStateException();
            }
            return (T) invokeL.objValue;
        }

        public void setDelegate(TypeAdapter<T> typeAdapter) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, typeAdapter) == null) {
                if (this.delegate == null) {
                    this.delegate = typeAdapter;
                    return;
                }
                throw new AssertionError();
            }
        }

        @Override // com.google.gson.TypeAdapter
        public void write(JsonWriter jsonWriter, T t) throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, jsonWriter, t) == null) {
                TypeAdapter<T> typeAdapter = this.delegate;
                if (typeAdapter != null) {
                    typeAdapter.write(jsonWriter, t);
                    return;
                }
                throw new IllegalStateException();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-69763544, "Lcom/google/gson/Gson;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-69763544, "Lcom/google/gson/Gson;");
                return;
            }
        }
        NULL_KEY_SURROGATE = TypeToken.get(Object.class);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public Gson() {
        this(Excluder.DEFAULT, FieldNamingPolicy.IDENTITY, Collections.emptyMap(), false, false, false, true, false, false, false, LongSerializationPolicy.DEFAULT, null, 2, 2, Collections.emptyList(), Collections.emptyList(), Collections.emptyList());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr = newInitContext.callArgs;
                this((Excluder) objArr[0], (FieldNamingStrategy) objArr[1], (Map) objArr[2], ((Boolean) objArr[3]).booleanValue(), ((Boolean) objArr[4]).booleanValue(), ((Boolean) objArr[5]).booleanValue(), ((Boolean) objArr[6]).booleanValue(), ((Boolean) objArr[7]).booleanValue(), ((Boolean) objArr[8]).booleanValue(), ((Boolean) objArr[9]).booleanValue(), (LongSerializationPolicy) objArr[10], (String) objArr[11], ((Integer) objArr[12]).intValue(), ((Integer) objArr[13]).intValue(), (List) objArr[14], (List) objArr[15], (List) objArr[16]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public static void assertFullConsumption(Object obj, JsonReader jsonReader) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65539, null, obj, jsonReader) == null) || obj == null) {
            return;
        }
        try {
            if (jsonReader.peek() == JsonToken.END_DOCUMENT) {
                return;
            }
            throw new JsonIOException("JSON document was not fully consumed.");
        } catch (MalformedJsonException e2) {
            throw new JsonSyntaxException(e2);
        } catch (IOException e3) {
            throw new JsonIOException(e3);
        }
    }

    public static TypeAdapter<AtomicLong> atomicLongAdapter(TypeAdapter<Number> typeAdapter) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65540, null, typeAdapter)) == null) ? new TypeAdapter<AtomicLong>(typeAdapter) { // from class: com.google.gson.Gson.4
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ TypeAdapter val$longAdapter;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {typeAdapter};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.val$longAdapter = typeAdapter;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.gson.TypeAdapter
            public AtomicLong read(JsonReader jsonReader) throws IOException {
                InterceptResult invokeL2;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jsonReader)) == null) ? new AtomicLong(((Number) this.val$longAdapter.read(jsonReader)).longValue()) : (AtomicLong) invokeL2.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.gson.TypeAdapter
            public void write(JsonWriter jsonWriter, AtomicLong atomicLong) throws IOException {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLL(1048579, this, jsonWriter, atomicLong) == null) {
                    this.val$longAdapter.write(jsonWriter, Long.valueOf(atomicLong.get()));
                }
            }
        }.nullSafe() : (TypeAdapter) invokeL.objValue;
    }

    public static TypeAdapter<AtomicLongArray> atomicLongArrayAdapter(TypeAdapter<Number> typeAdapter) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, typeAdapter)) == null) ? new TypeAdapter<AtomicLongArray>(typeAdapter) { // from class: com.google.gson.Gson.5
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ TypeAdapter val$longAdapter;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {typeAdapter};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.val$longAdapter = typeAdapter;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.gson.TypeAdapter
            public AtomicLongArray read(JsonReader jsonReader) throws IOException {
                InterceptResult invokeL2;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jsonReader)) == null) {
                    ArrayList arrayList = new ArrayList();
                    jsonReader.beginArray();
                    while (jsonReader.hasNext()) {
                        arrayList.add(Long.valueOf(((Number) this.val$longAdapter.read(jsonReader)).longValue()));
                    }
                    jsonReader.endArray();
                    int size = arrayList.size();
                    AtomicLongArray atomicLongArray = new AtomicLongArray(size);
                    for (int i2 = 0; i2 < size; i2++) {
                        atomicLongArray.set(i2, ((Long) arrayList.get(i2)).longValue());
                    }
                    return atomicLongArray;
                }
                return (AtomicLongArray) invokeL2.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.gson.TypeAdapter
            public void write(JsonWriter jsonWriter, AtomicLongArray atomicLongArray) throws IOException {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLL(1048579, this, jsonWriter, atomicLongArray) == null) {
                    jsonWriter.beginArray();
                    int length = atomicLongArray.length();
                    for (int i2 = 0; i2 < length; i2++) {
                        this.val$longAdapter.write(jsonWriter, Long.valueOf(atomicLongArray.get(i2)));
                    }
                    jsonWriter.endArray();
                }
            }
        }.nullSafe() : (TypeAdapter) invokeL.objValue;
    }

    public static void checkValidFloatingPoint(double d2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(AdIconUtil.BAIDU_LOGO_ID, null, new Object[]{Double.valueOf(d2)}) == null) {
            if (Double.isNaN(d2) || Double.isInfinite(d2)) {
                throw new IllegalArgumentException(d2 + " is not a valid double value as per JSON specification. To override this behavior, use GsonBuilder.serializeSpecialFloatingPointValues() method.");
            }
        }
    }

    private TypeAdapter<Number> doubleAdapter(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(65543, this, z)) == null) {
            if (z) {
                return TypeAdapters.DOUBLE;
            }
            return new TypeAdapter<Number>(this) { // from class: com.google.gson.Gson.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ Gson this$0;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                }

                /* JADX DEBUG: Method merged with bridge method */
                /* JADX DEBUG: Return type fixed from 'java.lang.Double' to match base method */
                @Override // com.google.gson.TypeAdapter
                /* renamed from: read */
                public Number read2(JsonReader jsonReader) throws IOException {
                    InterceptResult invokeL;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, jsonReader)) == null) {
                        if (jsonReader.peek() == JsonToken.NULL) {
                            jsonReader.nextNull();
                            return null;
                        }
                        return Double.valueOf(jsonReader.nextDouble());
                    }
                    return (Double) invokeL.objValue;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.google.gson.TypeAdapter
                public void write(JsonWriter jsonWriter, Number number) throws IOException {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLL(Constants.METHOD_SEND_USER_MSG, this, jsonWriter, number) == null) {
                        if (number == null) {
                            jsonWriter.nullValue();
                            return;
                        }
                        Gson.checkValidFloatingPoint(number.doubleValue());
                        jsonWriter.value(number);
                    }
                }
            };
        }
        return (TypeAdapter) invokeZ.objValue;
    }

    private TypeAdapter<Number> floatAdapter(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(65544, this, z)) == null) {
            if (z) {
                return TypeAdapters.FLOAT;
            }
            return new TypeAdapter<Number>(this) { // from class: com.google.gson.Gson.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ Gson this$0;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                }

                /* JADX DEBUG: Method merged with bridge method */
                /* JADX DEBUG: Return type fixed from 'java.lang.Float' to match base method */
                @Override // com.google.gson.TypeAdapter
                /* renamed from: read */
                public Number read2(JsonReader jsonReader) throws IOException {
                    InterceptResult invokeL;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, jsonReader)) == null) {
                        if (jsonReader.peek() == JsonToken.NULL) {
                            jsonReader.nextNull();
                            return null;
                        }
                        return Float.valueOf((float) jsonReader.nextDouble());
                    }
                    return (Float) invokeL.objValue;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.google.gson.TypeAdapter
                public void write(JsonWriter jsonWriter, Number number) throws IOException {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLL(Constants.METHOD_SEND_USER_MSG, this, jsonWriter, number) == null) {
                        if (number == null) {
                            jsonWriter.nullValue();
                            return;
                        }
                        Gson.checkValidFloatingPoint(number.floatValue());
                        jsonWriter.value(number);
                    }
                }
            };
        }
        return (TypeAdapter) invokeZ.objValue;
    }

    public static TypeAdapter<Number> longAdapter(LongSerializationPolicy longSerializationPolicy) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, longSerializationPolicy)) == null) {
            if (longSerializationPolicy == LongSerializationPolicy.DEFAULT) {
                return TypeAdapters.LONG;
            }
            return new TypeAdapter<Number>() { // from class: com.google.gson.Gson.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                        }
                    }
                }

                /* JADX DEBUG: Method merged with bridge method */
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // com.google.gson.TypeAdapter
                public Number read(JsonReader jsonReader) throws IOException {
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, jsonReader)) == null) {
                        if (jsonReader.peek() == JsonToken.NULL) {
                            jsonReader.nextNull();
                            return null;
                        }
                        return Long.valueOf(jsonReader.nextLong());
                    }
                    return (Number) invokeL2.objValue;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.google.gson.TypeAdapter
                public void write(JsonWriter jsonWriter, Number number) throws IOException {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLL(Constants.METHOD_SEND_USER_MSG, this, jsonWriter, number) == null) {
                        if (number == null) {
                            jsonWriter.nullValue();
                        } else {
                            jsonWriter.value(number.toString());
                        }
                    }
                }
            };
        }
        return (TypeAdapter) invokeL.objValue;
    }

    public Excluder excluder() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.excluder : (Excluder) invokeV.objValue;
    }

    public FieldNamingStrategy fieldNamingStrategy() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.fieldNamingStrategy : (FieldNamingStrategy) invokeV.objValue;
    }

    public <T> T fromJson(String str, Class<T> cls) throws JsonSyntaxException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, str, cls)) == null) ? (T) Primitives.wrap(cls).cast(fromJson(str, (Type) cls)) : (T) invokeLL.objValue;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v5, resolved type: java.util.Map<com.google.gson.reflect.TypeToken<?>, com.google.gson.TypeAdapter<?>> */
    /* JADX DEBUG: Type inference failed for r4v5. Raw type applied. Possible types: com.google.gson.TypeAdapter<T>, com.google.gson.TypeAdapter<?> */
    /* JADX WARN: Multi-variable type inference failed */
    public <T> TypeAdapter<T> getAdapter(TypeToken<T> typeToken) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, typeToken)) == null) {
            TypeAdapter<T> typeAdapter = (TypeAdapter<T>) this.typeTokenCache.get(typeToken == null ? NULL_KEY_SURROGATE : typeToken);
            if (typeAdapter != null) {
                return typeAdapter;
            }
            Map<TypeToken<?>, FutureTypeAdapter<?>> map = this.calls.get();
            boolean z = false;
            if (map == null) {
                map = new HashMap<>();
                this.calls.set(map);
                z = true;
            }
            FutureTypeAdapter<?> futureTypeAdapter = map.get(typeToken);
            if (futureTypeAdapter != null) {
                return futureTypeAdapter;
            }
            try {
                FutureTypeAdapter<?> futureTypeAdapter2 = new FutureTypeAdapter<>();
                map.put(typeToken, futureTypeAdapter2);
                for (TypeAdapterFactory typeAdapterFactory : this.factories) {
                    TypeAdapter typeAdapter2 = (TypeAdapter<T>) typeAdapterFactory.create(this, typeToken);
                    if (typeAdapter2 != null) {
                        futureTypeAdapter2.setDelegate(typeAdapter2);
                        this.typeTokenCache.put(typeToken, typeAdapter2);
                        return typeAdapter2;
                    }
                }
                throw new IllegalArgumentException("GSON (2.8.5) cannot handle " + typeToken);
            } finally {
                map.remove(typeToken);
                if (z) {
                    this.calls.remove();
                }
            }
        }
        return (TypeAdapter) invokeL.objValue;
    }

    public <T> TypeAdapter<T> getDelegateAdapter(TypeAdapterFactory typeAdapterFactory, TypeToken<T> typeToken) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048587, this, typeAdapterFactory, typeToken)) == null) {
            if (!this.factories.contains(typeAdapterFactory)) {
                typeAdapterFactory = this.jsonAdapterFactory;
            }
            boolean z = false;
            for (TypeAdapterFactory typeAdapterFactory2 : this.factories) {
                if (z) {
                    TypeAdapter<T> create = typeAdapterFactory2.create(this, typeToken);
                    if (create != null) {
                        return create;
                    }
                } else if (typeAdapterFactory2 == typeAdapterFactory) {
                    z = true;
                }
            }
            throw new IllegalArgumentException("GSON cannot serialize " + typeToken);
        }
        return (TypeAdapter) invokeLL.objValue;
    }

    public boolean htmlSafe() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.htmlSafe : invokeV.booleanValue;
    }

    public GsonBuilder newBuilder() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? new GsonBuilder(this) : (GsonBuilder) invokeV.objValue;
    }

    public JsonReader newJsonReader(Reader reader) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, reader)) == null) {
            JsonReader jsonReader = new JsonReader(reader);
            jsonReader.setLenient(this.lenient);
            return jsonReader;
        }
        return (JsonReader) invokeL.objValue;
    }

    public JsonWriter newJsonWriter(Writer writer) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, writer)) == null) {
            if (this.generateNonExecutableJson) {
                writer.write(JSON_NON_EXECUTABLE_PREFIX);
            }
            JsonWriter jsonWriter = new JsonWriter(writer);
            if (this.prettyPrinting) {
                jsonWriter.setIndent(GlideException.IndentedAppendable.INDENT);
            }
            jsonWriter.setSerializeNulls(this.serializeNulls);
            return jsonWriter;
        }
        return (JsonWriter) invokeL.objValue;
    }

    public boolean serializeNulls() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.serializeNulls : invokeV.booleanValue;
    }

    public String toJson(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048594, this, obj)) == null) {
            if (obj == null) {
                return toJson((JsonElement) JsonNull.INSTANCE);
            }
            return toJson(obj, obj.getClass());
        }
        return (String) invokeL.objValue;
    }

    public JsonElement toJsonTree(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048601, this, obj)) == null) {
            if (obj == null) {
                return JsonNull.INSTANCE;
            }
            return toJsonTree(obj, obj.getClass());
        }
        return (JsonElement) invokeL.objValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
            return "{serializeNulls:" + this.serializeNulls + ",factories:" + this.factories + ",instanceCreators:" + this.constructorConstructor + "}";
        }
        return (String) invokeV.objValue;
    }

    public <T> T fromJson(String str, Type type) throws JsonSyntaxException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, type)) == null) {
            if (str == null) {
                return null;
            }
            return (T) fromJson(new StringReader(str), type);
        }
        return (T) invokeLL.objValue;
    }

    public String toJson(Object obj, Type type) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048595, this, obj, type)) == null) {
            StringWriter stringWriter = new StringWriter();
            toJson(obj, type, stringWriter);
            return stringWriter.toString();
        }
        return (String) invokeLL.objValue;
    }

    public JsonElement toJsonTree(Object obj, Type type) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048602, this, obj, type)) == null) {
            JsonTreeWriter jsonTreeWriter = new JsonTreeWriter();
            toJson(obj, type, jsonTreeWriter);
            return jsonTreeWriter.get();
        }
        return (JsonElement) invokeLL.objValue;
    }

    public <T> T fromJson(Reader reader, Class<T> cls) throws JsonSyntaxException, JsonIOException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, reader, cls)) == null) {
            JsonReader newJsonReader = newJsonReader(reader);
            Object fromJson = fromJson(newJsonReader, cls);
            assertFullConsumption(fromJson, newJsonReader);
            return (T) Primitives.wrap(cls).cast(fromJson);
        }
        return (T) invokeLL.objValue;
    }

    public Gson(Excluder excluder, FieldNamingStrategy fieldNamingStrategy, Map<Type, InstanceCreator<?>> map, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, LongSerializationPolicy longSerializationPolicy, String str, int i2, int i3, List<TypeAdapterFactory> list, List<TypeAdapterFactory> list2, List<TypeAdapterFactory> list3) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {excluder, fieldNamingStrategy, map, Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3), Boolean.valueOf(z4), Boolean.valueOf(z5), Boolean.valueOf(z6), Boolean.valueOf(z7), longSerializationPolicy, str, Integer.valueOf(i2), Integer.valueOf(i3), list, list2, list3};
            interceptable.invokeUnInit(65538, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.calls = new ThreadLocal<>();
        this.typeTokenCache = new ConcurrentHashMap();
        this.excluder = excluder;
        this.fieldNamingStrategy = fieldNamingStrategy;
        this.instanceCreators = map;
        this.constructorConstructor = new ConstructorConstructor(map);
        this.serializeNulls = z;
        this.complexMapKeySerialization = z2;
        this.generateNonExecutableJson = z3;
        this.htmlSafe = z4;
        this.prettyPrinting = z5;
        this.lenient = z6;
        this.serializeSpecialFloatingPointValues = z7;
        this.longSerializationPolicy = longSerializationPolicy;
        this.datePattern = str;
        this.dateStyle = i2;
        this.timeStyle = i3;
        this.builderFactories = list;
        this.builderHierarchyFactories = list2;
        ArrayList arrayList = new ArrayList();
        arrayList.add(TypeAdapters.JSON_ELEMENT_FACTORY);
        arrayList.add(ObjectTypeAdapter.FACTORY);
        arrayList.add(excluder);
        arrayList.addAll(list3);
        arrayList.add(TypeAdapters.STRING_FACTORY);
        arrayList.add(TypeAdapters.INTEGER_FACTORY);
        arrayList.add(TypeAdapters.BOOLEAN_FACTORY);
        arrayList.add(TypeAdapters.BYTE_FACTORY);
        arrayList.add(TypeAdapters.SHORT_FACTORY);
        TypeAdapter<Number> longAdapter = longAdapter(longSerializationPolicy);
        arrayList.add(TypeAdapters.newFactory(Long.TYPE, Long.class, longAdapter));
        arrayList.add(TypeAdapters.newFactory(Double.TYPE, Double.class, doubleAdapter(z7)));
        arrayList.add(TypeAdapters.newFactory(Float.TYPE, Float.class, floatAdapter(z7)));
        arrayList.add(TypeAdapters.NUMBER_FACTORY);
        arrayList.add(TypeAdapters.ATOMIC_INTEGER_FACTORY);
        arrayList.add(TypeAdapters.ATOMIC_BOOLEAN_FACTORY);
        arrayList.add(TypeAdapters.newFactory(AtomicLong.class, atomicLongAdapter(longAdapter)));
        arrayList.add(TypeAdapters.newFactory(AtomicLongArray.class, atomicLongArrayAdapter(longAdapter)));
        arrayList.add(TypeAdapters.ATOMIC_INTEGER_ARRAY_FACTORY);
        arrayList.add(TypeAdapters.CHARACTER_FACTORY);
        arrayList.add(TypeAdapters.STRING_BUILDER_FACTORY);
        arrayList.add(TypeAdapters.STRING_BUFFER_FACTORY);
        arrayList.add(TypeAdapters.newFactory(BigDecimal.class, TypeAdapters.BIG_DECIMAL));
        arrayList.add(TypeAdapters.newFactory(BigInteger.class, TypeAdapters.BIG_INTEGER));
        arrayList.add(TypeAdapters.URL_FACTORY);
        arrayList.add(TypeAdapters.URI_FACTORY);
        arrayList.add(TypeAdapters.UUID_FACTORY);
        arrayList.add(TypeAdapters.CURRENCY_FACTORY);
        arrayList.add(TypeAdapters.LOCALE_FACTORY);
        arrayList.add(TypeAdapters.INET_ADDRESS_FACTORY);
        arrayList.add(TypeAdapters.BIT_SET_FACTORY);
        arrayList.add(DateTypeAdapter.FACTORY);
        arrayList.add(TypeAdapters.CALENDAR_FACTORY);
        arrayList.add(TimeTypeAdapter.FACTORY);
        arrayList.add(SqlDateTypeAdapter.FACTORY);
        arrayList.add(TypeAdapters.TIMESTAMP_FACTORY);
        arrayList.add(ArrayTypeAdapter.FACTORY);
        arrayList.add(TypeAdapters.CLASS_FACTORY);
        arrayList.add(new CollectionTypeAdapterFactory(this.constructorConstructor));
        arrayList.add(new MapTypeAdapterFactory(this.constructorConstructor, z2));
        JsonAdapterAnnotationTypeAdapterFactory jsonAdapterAnnotationTypeAdapterFactory = new JsonAdapterAnnotationTypeAdapterFactory(this.constructorConstructor);
        this.jsonAdapterFactory = jsonAdapterAnnotationTypeAdapterFactory;
        arrayList.add(jsonAdapterAnnotationTypeAdapterFactory);
        arrayList.add(TypeAdapters.ENUM_FACTORY);
        arrayList.add(new ReflectiveTypeAdapterFactory(this.constructorConstructor, fieldNamingStrategy, excluder, this.jsonAdapterFactory));
        this.factories = Collections.unmodifiableList(arrayList);
    }

    public void toJson(Object obj, Appendable appendable) throws JsonIOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048598, this, obj, appendable) == null) {
            if (obj != null) {
                toJson(obj, obj.getClass(), appendable);
            } else {
                toJson((JsonElement) JsonNull.INSTANCE, appendable);
            }
        }
    }

    public void toJson(Object obj, Type type, Appendable appendable) throws JsonIOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048600, this, obj, type, appendable) == null) {
            try {
                toJson(obj, type, newJsonWriter(Streams.writerForAppendable(appendable)));
            } catch (IOException e2) {
                throw new JsonIOException(e2);
            }
        }
    }

    public <T> T fromJson(Reader reader, Type type) throws JsonIOException, JsonSyntaxException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, reader, type)) == null) {
            JsonReader newJsonReader = newJsonReader(reader);
            T t = (T) fromJson(newJsonReader, type);
            assertFullConsumption(t, newJsonReader);
            return t;
        }
        return (T) invokeLL.objValue;
    }

    public void toJson(Object obj, Type type, JsonWriter jsonWriter) throws JsonIOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048599, this, obj, type, jsonWriter) == null) {
            TypeAdapter adapter = getAdapter(TypeToken.get(type));
            boolean isLenient = jsonWriter.isLenient();
            jsonWriter.setLenient(true);
            boolean isHtmlSafe = jsonWriter.isHtmlSafe();
            jsonWriter.setHtmlSafe(this.htmlSafe);
            boolean serializeNulls = jsonWriter.getSerializeNulls();
            jsonWriter.setSerializeNulls(this.serializeNulls);
            try {
                try {
                    try {
                        adapter.write(jsonWriter, obj);
                    } catch (IOException e2) {
                        throw new JsonIOException(e2);
                    }
                } catch (AssertionError e3) {
                    throw new AssertionError("AssertionError (GSON 2.8.5): " + e3.getMessage(), e3);
                }
            } finally {
                jsonWriter.setLenient(isLenient);
                jsonWriter.setHtmlSafe(isHtmlSafe);
                jsonWriter.setSerializeNulls(serializeNulls);
            }
        }
    }

    public <T> T fromJson(JsonReader jsonReader, Type type) throws JsonIOException, JsonSyntaxException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, jsonReader, type)) == null) {
            boolean isLenient = jsonReader.isLenient();
            boolean z = true;
            jsonReader.setLenient(true);
            try {
                try {
                    try {
                        try {
                            try {
                                jsonReader.peek();
                                z = false;
                                T read = getAdapter(TypeToken.get(type)).read(jsonReader);
                                jsonReader.setLenient(isLenient);
                                return read;
                            } catch (IllegalStateException e2) {
                                throw new JsonSyntaxException(e2);
                            }
                        } catch (AssertionError e3) {
                            throw new AssertionError("AssertionError (GSON 2.8.5): " + e3.getMessage(), e3);
                        }
                    } catch (EOFException e4) {
                        if (z) {
                            jsonReader.setLenient(isLenient);
                            return null;
                        }
                        throw new JsonSyntaxException(e4);
                    }
                } catch (IOException e5) {
                    throw new JsonSyntaxException(e5);
                }
            } catch (Throwable th) {
                jsonReader.setLenient(isLenient);
                throw th;
            }
        }
        return (T) invokeLL.objValue;
    }

    public <T> TypeAdapter<T> getAdapter(Class<T> cls) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, cls)) == null) ? getAdapter(TypeToken.get((Class) cls)) : (TypeAdapter) invokeL.objValue;
    }

    public <T> T fromJson(JsonElement jsonElement, Class<T> cls) throws JsonSyntaxException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, jsonElement, cls)) == null) ? (T) Primitives.wrap(cls).cast(fromJson(jsonElement, (Type) cls)) : (T) invokeLL.objValue;
    }

    public <T> T fromJson(JsonElement jsonElement, Type type) throws JsonSyntaxException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, jsonElement, type)) == null) {
            if (jsonElement == null) {
                return null;
            }
            return (T) fromJson(new JsonTreeReader(jsonElement), type);
        }
        return (T) invokeLL.objValue;
    }

    public String toJson(JsonElement jsonElement) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, jsonElement)) == null) {
            StringWriter stringWriter = new StringWriter();
            toJson(jsonElement, (Appendable) stringWriter);
            return stringWriter.toString();
        }
        return (String) invokeL.objValue;
    }

    public void toJson(JsonElement jsonElement, Appendable appendable) throws JsonIOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048597, this, jsonElement, appendable) == null) {
            try {
                toJson(jsonElement, newJsonWriter(Streams.writerForAppendable(appendable)));
            } catch (IOException e2) {
                throw new JsonIOException(e2);
            }
        }
    }

    public void toJson(JsonElement jsonElement, JsonWriter jsonWriter) throws JsonIOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048596, this, jsonElement, jsonWriter) == null) {
            boolean isLenient = jsonWriter.isLenient();
            jsonWriter.setLenient(true);
            boolean isHtmlSafe = jsonWriter.isHtmlSafe();
            jsonWriter.setHtmlSafe(this.htmlSafe);
            boolean serializeNulls = jsonWriter.getSerializeNulls();
            jsonWriter.setSerializeNulls(this.serializeNulls);
            try {
                try {
                    Streams.write(jsonElement, jsonWriter);
                } catch (IOException e2) {
                    throw new JsonIOException(e2);
                } catch (AssertionError e3) {
                    throw new AssertionError("AssertionError (GSON 2.8.5): " + e3.getMessage(), e3);
                }
            } finally {
                jsonWriter.setLenient(isLenient);
                jsonWriter.setHtmlSafe(isHtmlSafe);
                jsonWriter.setSerializeNulls(serializeNulls);
            }
        }
    }
}
