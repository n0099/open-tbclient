package com.google.gson;

import com.google.gson.b.a;
import com.google.gson.internal.Excluder;
import com.google.gson.internal.b;
import com.google.gson.internal.bind.ArrayTypeAdapter;
import com.google.gson.internal.bind.CollectionTypeAdapterFactory;
import com.google.gson.internal.bind.DateTypeAdapter;
import com.google.gson.internal.bind.JsonAdapterAnnotationTypeAdapterFactory;
import com.google.gson.internal.bind.MapTypeAdapterFactory;
import com.google.gson.internal.bind.ObjectTypeAdapter;
import com.google.gson.internal.bind.ReflectiveTypeAdapterFactory;
import com.google.gson.internal.bind.SqlDateTypeAdapter;
import com.google.gson.internal.bind.TimeTypeAdapter;
import com.google.gson.internal.bind.TypeAdapters;
import com.google.gson.internal.g;
import com.google.gson.internal.h;
import com.google.gson.stream.JsonToken;
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
/* loaded from: classes5.dex */
public final class Gson {
    static final boolean DEFAULT_COMPLEX_MAP_KEYS = false;
    static final boolean DEFAULT_ESCAPE_HTML = true;
    static final boolean DEFAULT_JSON_NON_EXECUTABLE = false;
    static final boolean DEFAULT_LENIENT = false;
    static final boolean DEFAULT_PRETTY_PRINT = false;
    static final boolean DEFAULT_SERIALIZE_NULLS = false;
    static final boolean DEFAULT_SPECIALIZE_FLOAT_VALUES = false;
    private static final String JSON_NON_EXECUTABLE_PREFIX = ")]}'\n";
    private static final a<?> NULL_KEY_SURROGATE = a.C(Object.class);
    final List<TypeAdapterFactory> builderFactories;
    final List<TypeAdapterFactory> builderHierarchyFactories;
    private final ThreadLocal<Map<a<?>, FutureTypeAdapter<?>>> calls;
    final boolean complexMapKeySerialization;
    private final b constructorConstructor;
    final String datePattern;
    final int dateStyle;
    final Excluder excluder;
    final List<TypeAdapterFactory> factories;
    final FieldNamingStrategy fieldNamingStrategy;
    final boolean generateNonExecutableJson;
    final boolean htmlSafe;
    final Map<Type, InstanceCreator<?>> instanceCreators;
    private final JsonAdapterAnnotationTypeAdapterFactory jsonAdapterFactory;
    final boolean lenient;
    final LongSerializationPolicy longSerializationPolicy;
    final boolean prettyPrinting;
    final boolean serializeNulls;
    final boolean serializeSpecialFloatingPointValues;
    final int timeStyle;
    private final Map<a<?>, TypeAdapter<?>> typeTokenCache;

    public Gson() {
        this(Excluder.pSa, FieldNamingPolicy.IDENTITY, Collections.emptyMap(), false, false, false, true, false, false, false, LongSerializationPolicy.DEFAULT, null, 2, 2, Collections.emptyList(), Collections.emptyList(), Collections.emptyList());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Gson(Excluder excluder, FieldNamingStrategy fieldNamingStrategy, Map<Type, InstanceCreator<?>> map, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, LongSerializationPolicy longSerializationPolicy, String str, int i, int i2, List<TypeAdapterFactory> list, List<TypeAdapterFactory> list2, List<TypeAdapterFactory> list3) {
        this.calls = new ThreadLocal<>();
        this.typeTokenCache = new ConcurrentHashMap();
        this.excluder = excluder;
        this.fieldNamingStrategy = fieldNamingStrategy;
        this.instanceCreators = map;
        this.constructorConstructor = new b(map);
        this.serializeNulls = z;
        this.complexMapKeySerialization = z2;
        this.generateNonExecutableJson = z3;
        this.htmlSafe = z4;
        this.prettyPrinting = z5;
        this.lenient = z6;
        this.serializeSpecialFloatingPointValues = z7;
        this.longSerializationPolicy = longSerializationPolicy;
        this.datePattern = str;
        this.dateStyle = i;
        this.timeStyle = i2;
        this.builderFactories = list;
        this.builderHierarchyFactories = list2;
        ArrayList arrayList = new ArrayList();
        arrayList.add(TypeAdapters.pUC);
        arrayList.add(ObjectTypeAdapter.pSR);
        arrayList.add(excluder);
        arrayList.addAll(list3);
        arrayList.add(TypeAdapters.pUh);
        arrayList.add(TypeAdapters.pTQ);
        arrayList.add(TypeAdapters.pTK);
        arrayList.add(TypeAdapters.pTM);
        arrayList.add(TypeAdapters.pTO);
        TypeAdapter<Number> longAdapter = longAdapter(longSerializationPolicy);
        arrayList.add(TypeAdapters.a(Long.TYPE, Long.class, longAdapter));
        arrayList.add(TypeAdapters.a(Double.TYPE, Double.class, doubleAdapter(z7)));
        arrayList.add(TypeAdapters.a(Float.TYPE, Float.class, floatAdapter(z7)));
        arrayList.add(TypeAdapters.pUb);
        arrayList.add(TypeAdapters.pTS);
        arrayList.add(TypeAdapters.pTU);
        arrayList.add(TypeAdapters.a(AtomicLong.class, atomicLongAdapter(longAdapter)));
        arrayList.add(TypeAdapters.a(AtomicLongArray.class, atomicLongArrayAdapter(longAdapter)));
        arrayList.add(TypeAdapters.pTW);
        arrayList.add(TypeAdapters.pUd);
        arrayList.add(TypeAdapters.pUj);
        arrayList.add(TypeAdapters.pUl);
        arrayList.add(TypeAdapters.a(BigDecimal.class, TypeAdapters.pUf));
        arrayList.add(TypeAdapters.a(BigInteger.class, TypeAdapters.pUg));
        arrayList.add(TypeAdapters.pUn);
        arrayList.add(TypeAdapters.pUp);
        arrayList.add(TypeAdapters.pUt);
        arrayList.add(TypeAdapters.pUv);
        arrayList.add(TypeAdapters.pUA);
        arrayList.add(TypeAdapters.pUr);
        arrayList.add(TypeAdapters.pTH);
        arrayList.add(DateTypeAdapter.pSR);
        arrayList.add(TypeAdapters.pUy);
        arrayList.add(TimeTypeAdapter.pSR);
        arrayList.add(SqlDateTypeAdapter.pSR);
        arrayList.add(TypeAdapters.pUw);
        arrayList.add(ArrayTypeAdapter.pSR);
        arrayList.add(TypeAdapters.pTF);
        arrayList.add(new CollectionTypeAdapterFactory(this.constructorConstructor));
        arrayList.add(new MapTypeAdapterFactory(this.constructorConstructor, z2));
        this.jsonAdapterFactory = new JsonAdapterAnnotationTypeAdapterFactory(this.constructorConstructor);
        arrayList.add(this.jsonAdapterFactory);
        arrayList.add(TypeAdapters.pUD);
        arrayList.add(new ReflectiveTypeAdapterFactory(this.constructorConstructor, fieldNamingStrategy, excluder, this.jsonAdapterFactory));
        this.factories = Collections.unmodifiableList(arrayList);
    }

    public GsonBuilder newBuilder() {
        return new GsonBuilder(this);
    }

    public Excluder excluder() {
        return this.excluder;
    }

    public FieldNamingStrategy fieldNamingStrategy() {
        return this.fieldNamingStrategy;
    }

    public boolean serializeNulls() {
        return this.serializeNulls;
    }

    public boolean htmlSafe() {
        return this.htmlSafe;
    }

    private TypeAdapter<Number> doubleAdapter(boolean z) {
        return z ? TypeAdapters.pTZ : new TypeAdapter<Number>() { // from class: com.google.gson.Gson.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX DEBUG: Return type fixed from 'java.lang.Double' to match base method */
            @Override // com.google.gson.TypeAdapter
            /* renamed from: read */
            public Number read2(com.google.gson.stream.a aVar) throws IOException {
                if (aVar.eBp() == JsonToken.NULL) {
                    aVar.eBv();
                    return null;
                }
                return Double.valueOf(aVar.eBw());
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.gson.TypeAdapter
            public void write(com.google.gson.stream.b bVar, Number number) throws IOException {
                if (number == null) {
                    bVar.eBI();
                    return;
                }
                Gson.checkValidFloatingPoint(number.doubleValue());
                bVar.b(number);
            }
        };
    }

    private TypeAdapter<Number> floatAdapter(boolean z) {
        return z ? TypeAdapters.pTY : new TypeAdapter<Number>() { // from class: com.google.gson.Gson.2
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX DEBUG: Return type fixed from 'java.lang.Float' to match base method */
            @Override // com.google.gson.TypeAdapter
            /* renamed from: read */
            public Number read2(com.google.gson.stream.a aVar) throws IOException {
                if (aVar.eBp() == JsonToken.NULL) {
                    aVar.eBv();
                    return null;
                }
                return Float.valueOf((float) aVar.eBw());
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.gson.TypeAdapter
            public void write(com.google.gson.stream.b bVar, Number number) throws IOException {
                if (number == null) {
                    bVar.eBI();
                    return;
                }
                Gson.checkValidFloatingPoint(number.floatValue());
                bVar.b(number);
            }
        };
    }

    static void checkValidFloatingPoint(double d) {
        if (Double.isNaN(d) || Double.isInfinite(d)) {
            throw new IllegalArgumentException(d + " is not a valid double value as per JSON specification. To override this behavior, use GsonBuilder.serializeSpecialFloatingPointValues() method.");
        }
    }

    private static TypeAdapter<Number> longAdapter(LongSerializationPolicy longSerializationPolicy) {
        return longSerializationPolicy == LongSerializationPolicy.DEFAULT ? TypeAdapters.pTX : new TypeAdapter<Number>() { // from class: com.google.gson.Gson.3
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.google.gson.TypeAdapter
            public Number read(com.google.gson.stream.a aVar) throws IOException {
                if (aVar.eBp() == JsonToken.NULL) {
                    aVar.eBv();
                    return null;
                }
                return Long.valueOf(aVar.eBx());
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.gson.TypeAdapter
            public void write(com.google.gson.stream.b bVar, Number number) throws IOException {
                if (number == null) {
                    bVar.eBI();
                } else {
                    bVar.ZL(number.toString());
                }
            }
        };
    }

    private static TypeAdapter<AtomicLong> atomicLongAdapter(final TypeAdapter<Number> typeAdapter) {
        return new TypeAdapter<AtomicLong>() { // from class: com.google.gson.Gson.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.gson.TypeAdapter
            public void write(com.google.gson.stream.b bVar, AtomicLong atomicLong) throws IOException {
                TypeAdapter.this.write(bVar, Long.valueOf(atomicLong.get()));
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.gson.TypeAdapter
            public AtomicLong read(com.google.gson.stream.a aVar) throws IOException {
                return new AtomicLong(((Number) TypeAdapter.this.read(aVar)).longValue());
            }
        }.nullSafe();
    }

    private static TypeAdapter<AtomicLongArray> atomicLongArrayAdapter(final TypeAdapter<Number> typeAdapter) {
        return new TypeAdapter<AtomicLongArray>() { // from class: com.google.gson.Gson.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.gson.TypeAdapter
            public void write(com.google.gson.stream.b bVar, AtomicLongArray atomicLongArray) throws IOException {
                bVar.eBE();
                int length = atomicLongArray.length();
                for (int i = 0; i < length; i++) {
                    TypeAdapter.this.write(bVar, Long.valueOf(atomicLongArray.get(i)));
                }
                bVar.eBF();
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.gson.TypeAdapter
            public AtomicLongArray read(com.google.gson.stream.a aVar) throws IOException {
                ArrayList arrayList = new ArrayList();
                aVar.eBn();
                while (aVar.hasNext()) {
                    arrayList.add(Long.valueOf(((Number) TypeAdapter.this.read(aVar)).longValue()));
                }
                aVar.endArray();
                int size = arrayList.size();
                AtomicLongArray atomicLongArray = new AtomicLongArray(size);
                for (int i = 0; i < size; i++) {
                    atomicLongArray.set(i, ((Long) arrayList.get(i)).longValue());
                }
                return atomicLongArray;
            }
        }.nullSafe();
    }

    public <T> TypeAdapter<T> getAdapter(a<T> aVar) {
        Map<a<?>, FutureTypeAdapter<?>> map;
        TypeAdapter<T> typeAdapter = (TypeAdapter<T>) this.typeTokenCache.get(aVar == null ? NULL_KEY_SURROGATE : aVar);
        if (typeAdapter == null) {
            Map<a<?>, FutureTypeAdapter<?>> map2 = this.calls.get();
            boolean z = false;
            if (map2 == null) {
                map = new HashMap<>();
                this.calls.set(map);
                z = true;
            } else {
                map = map2;
            }
            typeAdapter = map.get(aVar);
            if (typeAdapter == null) {
                try {
                    FutureTypeAdapter<?> futureTypeAdapter = new FutureTypeAdapter<>();
                    map.put(aVar, futureTypeAdapter);
                    for (TypeAdapterFactory typeAdapterFactory : this.factories) {
                        typeAdapter = typeAdapterFactory.create(this, aVar);
                        if (typeAdapter != null) {
                            futureTypeAdapter.setDelegate(typeAdapter);
                            this.typeTokenCache.put(aVar, typeAdapter);
                            map.remove(aVar);
                            if (z) {
                                this.calls.remove();
                            }
                        }
                    }
                    throw new IllegalArgumentException("GSON (2.8.5) cannot handle " + aVar);
                } catch (Throwable th) {
                    map.remove(aVar);
                    if (z) {
                        this.calls.remove();
                    }
                    throw th;
                }
            }
        }
        return typeAdapter;
    }

    public <T> TypeAdapter<T> getDelegateAdapter(TypeAdapterFactory typeAdapterFactory, a<T> aVar) {
        if (!this.factories.contains(typeAdapterFactory)) {
            typeAdapterFactory = this.jsonAdapterFactory;
        }
        boolean z = false;
        for (TypeAdapterFactory typeAdapterFactory2 : this.factories) {
            if (!z) {
                if (typeAdapterFactory2 == typeAdapterFactory) {
                    z = true;
                }
            } else {
                TypeAdapter<T> create = typeAdapterFactory2.create(this, aVar);
                if (create != null) {
                    return create;
                }
            }
        }
        throw new IllegalArgumentException("GSON cannot serialize " + aVar);
    }

    public <T> TypeAdapter<T> getAdapter(Class<T> cls) {
        return getAdapter(a.C(cls));
    }

    public JsonElement toJsonTree(Object obj) {
        return obj == null ? JsonNull.INSTANCE : toJsonTree(obj, obj.getClass());
    }

    public JsonElement toJsonTree(Object obj, Type type) {
        com.google.gson.internal.bind.b bVar = new com.google.gson.internal.bind.b();
        toJson(obj, type, bVar);
        return bVar.eBC();
    }

    public String toJson(Object obj) {
        return obj == null ? toJson((JsonElement) JsonNull.INSTANCE) : toJson(obj, obj.getClass());
    }

    public String toJson(Object obj, Type type) {
        StringWriter stringWriter = new StringWriter();
        toJson(obj, type, stringWriter);
        return stringWriter.toString();
    }

    public void toJson(Object obj, Appendable appendable) throws JsonIOException {
        if (obj != null) {
            toJson(obj, obj.getClass(), appendable);
        } else {
            toJson((JsonElement) JsonNull.INSTANCE, appendable);
        }
    }

    public void toJson(Object obj, Type type, Appendable appendable) throws JsonIOException {
        try {
            toJson(obj, type, newJsonWriter(h.b(appendable)));
        } catch (IOException e) {
            throw new JsonIOException(e);
        }
    }

    public void toJson(Object obj, Type type, com.google.gson.stream.b bVar) throws JsonIOException {
        TypeAdapter adapter = getAdapter(a.r(type));
        boolean eBN = bVar.eBN();
        bVar.BA(true);
        boolean eBV = bVar.eBV();
        bVar.BC(this.htmlSafe);
        boolean eBW = bVar.eBW();
        bVar.BD(this.serializeNulls);
        try {
            try {
                try {
                    adapter.write(bVar, obj);
                } catch (IOException e) {
                    throw new JsonIOException(e);
                }
            } catch (AssertionError e2) {
                throw new AssertionError("AssertionError (GSON 2.8.5): " + e2.getMessage(), e2);
            }
        } finally {
            bVar.BA(eBN);
            bVar.BC(eBV);
            bVar.BD(eBW);
        }
    }

    public String toJson(JsonElement jsonElement) {
        StringWriter stringWriter = new StringWriter();
        toJson(jsonElement, (Appendable) stringWriter);
        return stringWriter.toString();
    }

    public void toJson(JsonElement jsonElement, Appendable appendable) throws JsonIOException {
        try {
            toJson(jsonElement, newJsonWriter(h.b(appendable)));
        } catch (IOException e) {
            throw new JsonIOException(e);
        }
    }

    public com.google.gson.stream.b newJsonWriter(Writer writer) throws IOException {
        if (this.generateNonExecutableJson) {
            writer.write(JSON_NON_EXECUTABLE_PREFIX);
        }
        com.google.gson.stream.b bVar = new com.google.gson.stream.b(writer);
        if (this.prettyPrinting) {
            bVar.ZO("  ");
        }
        bVar.BD(this.serializeNulls);
        return bVar;
    }

    public com.google.gson.stream.a newJsonReader(Reader reader) {
        com.google.gson.stream.a aVar = new com.google.gson.stream.a(reader);
        aVar.BA(this.lenient);
        return aVar;
    }

    public void toJson(JsonElement jsonElement, com.google.gson.stream.b bVar) throws JsonIOException {
        boolean eBN = bVar.eBN();
        bVar.BA(true);
        boolean eBV = bVar.eBV();
        bVar.BC(this.htmlSafe);
        boolean eBW = bVar.eBW();
        bVar.BD(this.serializeNulls);
        try {
            try {
                h.a(jsonElement, bVar);
            } catch (IOException e) {
                throw new JsonIOException(e);
            } catch (AssertionError e2) {
                throw new AssertionError("AssertionError (GSON 2.8.5): " + e2.getMessage(), e2);
            }
        } finally {
            bVar.BA(eBN);
            bVar.BC(eBV);
            bVar.BD(eBW);
        }
    }

    public <T> T fromJson(String str, Class<T> cls) throws JsonSyntaxException {
        return (T) g.z(cls).cast(fromJson(str, (Type) cls));
    }

    public <T> T fromJson(String str, Type type) throws JsonSyntaxException {
        if (str == null) {
            return null;
        }
        return (T) fromJson(new StringReader(str), type);
    }

    public <T> T fromJson(Reader reader, Class<T> cls) throws JsonSyntaxException, JsonIOException {
        com.google.gson.stream.a newJsonReader = newJsonReader(reader);
        Object fromJson = fromJson(newJsonReader, cls);
        assertFullConsumption(fromJson, newJsonReader);
        return (T) g.z(cls).cast(fromJson);
    }

    public <T> T fromJson(Reader reader, Type type) throws JsonIOException, JsonSyntaxException {
        com.google.gson.stream.a newJsonReader = newJsonReader(reader);
        T t = (T) fromJson(newJsonReader, type);
        assertFullConsumption(t, newJsonReader);
        return t;
    }

    private static void assertFullConsumption(Object obj, com.google.gson.stream.a aVar) {
        if (obj != null) {
            try {
                if (aVar.eBp() != JsonToken.END_DOCUMENT) {
                    throw new JsonIOException("JSON document was not fully consumed.");
                }
            } catch (MalformedJsonException e) {
                throw new JsonSyntaxException(e);
            } catch (IOException e2) {
                throw new JsonIOException(e2);
            }
        }
    }

    public <T> T fromJson(com.google.gson.stream.a aVar, Type type) throws JsonIOException, JsonSyntaxException {
        boolean z = true;
        boolean eBN = aVar.eBN();
        aVar.BA(true);
        try {
            try {
                try {
                    aVar.eBp();
                    z = false;
                    T read = getAdapter(a.r(type)).read(aVar);
                    aVar.BA(eBN);
                    return read;
                } catch (IOException e) {
                    throw new JsonSyntaxException(e);
                } catch (IllegalStateException e2) {
                    throw new JsonSyntaxException(e2);
                }
            } catch (EOFException e3) {
                if (!z) {
                    throw new JsonSyntaxException(e3);
                }
                aVar.BA(eBN);
                return null;
            } catch (AssertionError e4) {
                throw new AssertionError("AssertionError (GSON 2.8.5): " + e4.getMessage(), e4);
            }
        } catch (Throwable th) {
            aVar.BA(eBN);
            throw th;
        }
    }

    public <T> T fromJson(JsonElement jsonElement, Class<T> cls) throws JsonSyntaxException {
        return (T) g.z(cls).cast(fromJson(jsonElement, (Type) cls));
    }

    public <T> T fromJson(JsonElement jsonElement, Type type) throws JsonSyntaxException {
        if (jsonElement == null) {
            return null;
        }
        return (T) fromJson(new com.google.gson.internal.bind.a(jsonElement), type);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static class FutureTypeAdapter<T> extends TypeAdapter<T> {
        private TypeAdapter<T> delegate;

        FutureTypeAdapter() {
        }

        public void setDelegate(TypeAdapter<T> typeAdapter) {
            if (this.delegate != null) {
                throw new AssertionError();
            }
            this.delegate = typeAdapter;
        }

        @Override // com.google.gson.TypeAdapter
        public T read(com.google.gson.stream.a aVar) throws IOException {
            if (this.delegate == null) {
                throw new IllegalStateException();
            }
            return this.delegate.read(aVar);
        }

        @Override // com.google.gson.TypeAdapter
        public void write(com.google.gson.stream.b bVar, T t) throws IOException {
            if (this.delegate == null) {
                throw new IllegalStateException();
            }
            this.delegate.write(bVar, t);
        }
    }

    public String toString() {
        return "{serializeNulls:" + this.serializeNulls + ",factories:" + this.factories + ",instanceCreators:" + this.constructorConstructor + "}";
    }
}
