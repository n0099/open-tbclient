package com.google.gson.internal.bind;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.internal.C$Gson$Types;
import com.google.gson.internal.ConstructorConstructor;
import com.google.gson.internal.ObjectConstructor;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Collection;
/* loaded from: classes2.dex */
public final class CollectionTypeAdapterFactory implements TypeAdapterFactory {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final ConstructorConstructor constructorConstructor;

    /* loaded from: classes2.dex */
    public static final class Adapter<E> extends TypeAdapter<Collection<E>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final ObjectConstructor<? extends Collection<E>> constructor;
        public final TypeAdapter<E> elementTypeAdapter;

        public Adapter(Gson gson, Type type, TypeAdapter<E> typeAdapter, ObjectConstructor<? extends Collection<E>> objectConstructor) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gson, type, typeAdapter, objectConstructor};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.elementTypeAdapter = new TypeAdapterRuntimeTypeWrapper(gson, typeAdapter, type);
            this.constructor = objectConstructor;
        }

        @Override // com.google.gson.TypeAdapter
        public /* bridge */ /* synthetic */ void write(JsonWriter jsonWriter, Object obj) throws IOException {
            write(jsonWriter, (Collection) ((Collection) obj));
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.TypeAdapter
        public Collection<E> read(JsonReader jsonReader) throws IOException {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jsonReader)) == null) {
                if (jsonReader.peek() == JsonToken.NULL) {
                    jsonReader.nextNull();
                    return null;
                }
                Collection<E> construct = this.constructor.construct();
                jsonReader.beginArray();
                while (jsonReader.hasNext()) {
                    construct.add(this.elementTypeAdapter.read(jsonReader));
                }
                jsonReader.endArray();
                return construct;
            }
            return (Collection) invokeL.objValue;
        }

        public void write(JsonWriter jsonWriter, Collection<E> collection) throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048579, this, jsonWriter, collection) == null) {
                if (collection == null) {
                    jsonWriter.nullValue();
                    return;
                }
                jsonWriter.beginArray();
                for (E e2 : collection) {
                    this.elementTypeAdapter.write(jsonWriter, e2);
                }
                jsonWriter.endArray();
            }
        }
    }

    public CollectionTypeAdapterFactory(ConstructorConstructor constructorConstructor) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {constructorConstructor};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.constructorConstructor = constructorConstructor;
    }

    @Override // com.google.gson.TypeAdapterFactory
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> typeToken) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, gson, typeToken)) == null) {
            Type type = typeToken.getType();
            Class<? super T> rawType = typeToken.getRawType();
            if (Collection.class.isAssignableFrom(rawType)) {
                Type collectionElementType = C$Gson$Types.getCollectionElementType(type, rawType);
                return new Adapter(gson, collectionElementType, gson.getAdapter(TypeToken.get(collectionElementType)), this.constructorConstructor.get(typeToken));
            }
            return null;
        }
        return (TypeAdapter) invokeLL.objValue;
    }
}
