package com.google.gson.internal.bind;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.gson.FieldNamingStrategy;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.internal.C$Gson$Types;
import com.google.gson.internal.ConstructorConstructor;
import com.google.gson.internal.Excluder;
import com.google.gson.internal.ObjectConstructor;
import com.google.gson.internal.Primitives;
import com.google.gson.internal.reflect.ReflectionAccessor;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes7.dex */
public final class ReflectiveTypeAdapterFactory implements TypeAdapterFactory {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final ReflectionAccessor accessor;
    public final ConstructorConstructor constructorConstructor;
    public final Excluder excluder;
    public final FieldNamingStrategy fieldNamingPolicy;
    public final JsonAdapterAnnotationTypeAdapterFactory jsonAdapterFactory;

    /* loaded from: classes7.dex */
    public static final class Adapter<T> extends TypeAdapter<T> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final Map<String, BoundField> boundFields;
        public final ObjectConstructor<T> constructor;

        public Adapter(ObjectConstructor<T> objectConstructor, Map<String, BoundField> map) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {objectConstructor, map};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.constructor = objectConstructor;
            this.boundFields = map;
        }

        @Override // com.google.gson.TypeAdapter
        public T read(JsonReader jsonReader) throws IOException {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, jsonReader)) == null) {
                if (jsonReader.peek() == JsonToken.NULL) {
                    jsonReader.nextNull();
                    return null;
                }
                T t = (T) this.constructor.construct();
                try {
                    jsonReader.beginObject();
                    while (jsonReader.hasNext()) {
                        BoundField boundField = this.boundFields.get(jsonReader.nextName());
                        if (boundField != null && boundField.deserialized) {
                            boundField.read(jsonReader, t);
                        }
                        jsonReader.skipValue();
                    }
                    jsonReader.endObject();
                    return t;
                } catch (IllegalAccessException e) {
                    throw new AssertionError(e);
                } catch (IllegalStateException e2) {
                    throw new JsonSyntaxException(e2);
                }
            }
            return (T) invokeL.objValue;
        }

        @Override // com.google.gson.TypeAdapter
        public void write(JsonWriter jsonWriter, T t) throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jsonWriter, t) == null) {
                if (t == null) {
                    jsonWriter.nullValue();
                    return;
                }
                jsonWriter.beginObject();
                try {
                    for (BoundField boundField : this.boundFields.values()) {
                        if (boundField.writeField(t)) {
                            jsonWriter.name(boundField.name);
                            boundField.write(jsonWriter, t);
                        }
                    }
                    jsonWriter.endObject();
                } catch (IllegalAccessException e) {
                    throw new AssertionError(e);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public static abstract class BoundField {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final boolean deserialized;
        public final String name;
        public final boolean serialized;

        public abstract void read(JsonReader jsonReader, Object obj) throws IOException, IllegalAccessException;

        public abstract void write(JsonWriter jsonWriter, Object obj) throws IOException, IllegalAccessException;

        public abstract boolean writeField(Object obj) throws IOException, IllegalAccessException;

        public BoundField(String str, boolean z, boolean z2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Boolean.valueOf(z), Boolean.valueOf(z2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.name = str;
            this.serialized = z;
            this.deserialized = z2;
        }
    }

    public ReflectiveTypeAdapterFactory(ConstructorConstructor constructorConstructor, FieldNamingStrategy fieldNamingStrategy, Excluder excluder, JsonAdapterAnnotationTypeAdapterFactory jsonAdapterAnnotationTypeAdapterFactory) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {constructorConstructor, fieldNamingStrategy, excluder, jsonAdapterAnnotationTypeAdapterFactory};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.accessor = ReflectionAccessor.getInstance();
        this.constructorConstructor = constructorConstructor;
        this.fieldNamingPolicy = fieldNamingStrategy;
        this.excluder = excluder;
        this.jsonAdapterFactory = jsonAdapterAnnotationTypeAdapterFactory;
    }

    private BoundField createBoundField(Gson gson, Field field, String str, TypeToken<?> typeToken, boolean z, boolean z2) {
        InterceptResult invokeCommon;
        TypeAdapter<?> typeAdapter;
        boolean z3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, this, new Object[]{gson, field, str, typeToken, Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) {
            boolean isPrimitive = Primitives.isPrimitive(typeToken.getRawType());
            JsonAdapter jsonAdapter = (JsonAdapter) field.getAnnotation(JsonAdapter.class);
            if (jsonAdapter != null) {
                typeAdapter = this.jsonAdapterFactory.getTypeAdapter(this.constructorConstructor, gson, typeToken, jsonAdapter);
            } else {
                typeAdapter = null;
            }
            if (typeAdapter != null) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (typeAdapter == null) {
                typeAdapter = gson.getAdapter(typeToken);
            }
            return new BoundField(this, str, z, z2, field, z3, typeAdapter, gson, typeToken, isPrimitive) { // from class: com.google.gson.internal.bind.ReflectiveTypeAdapterFactory.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ ReflectiveTypeAdapterFactory this$0;
                public final /* synthetic */ Gson val$context;
                public final /* synthetic */ Field val$field;
                public final /* synthetic */ TypeToken val$fieldType;
                public final /* synthetic */ boolean val$isPrimitive;
                public final /* synthetic */ boolean val$jsonAdapterPresent;
                public final /* synthetic */ TypeAdapter val$typeAdapter;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(str, z, z2);
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r3;
                        Object[] objArr = {this, str, Boolean.valueOf(z), Boolean.valueOf(z2), field, Boolean.valueOf(z3), typeAdapter, gson, typeToken, Boolean.valueOf(isPrimitive)};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            Object[] objArr2 = newInitContext.callArgs;
                            super((String) objArr2[0], ((Boolean) objArr2[1]).booleanValue(), ((Boolean) objArr2[2]).booleanValue());
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.val$field = field;
                    this.val$jsonAdapterPresent = z3;
                    this.val$typeAdapter = typeAdapter;
                    this.val$context = gson;
                    this.val$fieldType = typeToken;
                    this.val$isPrimitive = isPrimitive;
                }

                @Override // com.google.gson.internal.bind.ReflectiveTypeAdapterFactory.BoundField
                public void read(JsonReader jsonReader, Object obj) throws IOException, IllegalAccessException {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLL(1048576, this, jsonReader, obj) == null) {
                        Object read = this.val$typeAdapter.read(jsonReader);
                        if (read != null || !this.val$isPrimitive) {
                            this.val$field.set(obj, read);
                        }
                    }
                }

                @Override // com.google.gson.internal.bind.ReflectiveTypeAdapterFactory.BoundField
                public void write(JsonWriter jsonWriter, Object obj) throws IOException, IllegalAccessException {
                    TypeAdapter typeAdapterRuntimeTypeWrapper;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jsonWriter, obj) == null) {
                        Object obj2 = this.val$field.get(obj);
                        if (this.val$jsonAdapterPresent) {
                            typeAdapterRuntimeTypeWrapper = this.val$typeAdapter;
                        } else {
                            typeAdapterRuntimeTypeWrapper = new TypeAdapterRuntimeTypeWrapper(this.val$context, this.val$typeAdapter, this.val$fieldType.getType());
                        }
                        typeAdapterRuntimeTypeWrapper.write(jsonWriter, obj2);
                    }
                }

                @Override // com.google.gson.internal.bind.ReflectiveTypeAdapterFactory.BoundField
                public boolean writeField(Object obj) throws IOException, IllegalAccessException {
                    InterceptResult invokeL;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL = interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, obj)) == null) {
                        if (!this.serialized || this.val$field.get(obj) == obj) {
                            return false;
                        }
                        return true;
                    }
                    return invokeL.booleanValue;
                }
            };
        }
        return (BoundField) invokeCommon.objValue;
    }

    public static boolean excludeField(Field field, boolean z, Excluder excluder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, null, new Object[]{field, Boolean.valueOf(z), excluder})) == null) {
            if (!excluder.excludeClass(field.getType(), z) && !excluder.excludeField(field, z)) {
                return true;
            }
            return false;
        }
        return invokeCommon.booleanValue;
    }

    private Map<String, BoundField> getBoundFields(Gson gson, TypeToken<?> typeToken, Class<?> cls) {
        InterceptResult invokeLLL;
        BoundField boundField;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65539, this, gson, typeToken, cls)) == null) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            if (cls.isInterface()) {
                return linkedHashMap;
            }
            Type type = typeToken.getType();
            TypeToken<?> typeToken2 = typeToken;
            Class<?> cls2 = cls;
            while (cls2 != Object.class) {
                Field[] declaredFields = cls2.getDeclaredFields();
                int length = declaredFields.length;
                boolean z2 = false;
                int i = 0;
                while (i < length) {
                    Field field = declaredFields[i];
                    boolean excludeField = excludeField(field, true);
                    boolean excludeField2 = excludeField(field, z2);
                    if (excludeField || excludeField2) {
                        this.accessor.makeAccessible(field);
                        Type resolve = C$Gson$Types.resolve(typeToken2.getType(), cls2, field.getGenericType());
                        List<String> fieldNames = getFieldNames(field);
                        int size = fieldNames.size();
                        BoundField boundField2 = null;
                        int i2 = 0;
                        while (i2 < size) {
                            String str = fieldNames.get(i2);
                            if (i2 != 0) {
                                z = false;
                            } else {
                                z = excludeField;
                            }
                            int i3 = i2;
                            BoundField boundField3 = boundField2;
                            int i4 = size;
                            List<String> list = fieldNames;
                            Field field2 = field;
                            BoundField boundField4 = (BoundField) linkedHashMap.put(str, createBoundField(gson, field, str, TypeToken.get(resolve), z, excludeField2));
                            if (boundField3 == null) {
                                boundField2 = boundField4;
                            } else {
                                boundField2 = boundField3;
                            }
                            i2 = i3 + 1;
                            excludeField = z;
                            fieldNames = list;
                            size = i4;
                            field = field2;
                        }
                        if (boundField2 != null) {
                            throw new IllegalArgumentException(type + " declares multiple JSON fields named " + boundField.name);
                        }
                    }
                    i++;
                    z2 = false;
                }
                typeToken2 = TypeToken.get(C$Gson$Types.resolve(typeToken2.getType(), cls2, cls2.getGenericSuperclass()));
                cls2 = typeToken2.getRawType();
            }
            return linkedHashMap;
        }
        return (Map) invokeLLL.objValue;
    }

    private List<String> getFieldNames(Field field) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, field)) == null) {
            SerializedName serializedName = (SerializedName) field.getAnnotation(SerializedName.class);
            if (serializedName == null) {
                return Collections.singletonList(this.fieldNamingPolicy.translateName(field));
            }
            String value = serializedName.value();
            String[] alternate = serializedName.alternate();
            if (alternate.length == 0) {
                return Collections.singletonList(value);
            }
            ArrayList arrayList = new ArrayList(alternate.length + 1);
            arrayList.add(value);
            for (String str : alternate) {
                arrayList.add(str);
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    @Override // com.google.gson.TypeAdapterFactory
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> typeToken) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, gson, typeToken)) == null) {
            Class<? super T> rawType = typeToken.getRawType();
            if (!Object.class.isAssignableFrom(rawType)) {
                return null;
            }
            return new Adapter(this.constructorConstructor.get(typeToken), getBoundFields(gson, typeToken, rawType));
        }
        return (TypeAdapter) invokeLL.objValue;
    }

    public boolean excludeField(Field field, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, field, z)) == null) {
            return excludeField(field, z, this.excluder);
        }
        return invokeLZ.booleanValue;
    }
}
