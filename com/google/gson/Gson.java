package com.google.gson;

import com.bumptech.glide.load.engine.GlideException;
import com.google.gson.internal.Excluder;
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
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.MalformedJsonException;
import d.h.d.b.b;
import d.h.d.b.g;
import d.h.d.b.h;
import d.h.d.c.a;
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
/* loaded from: classes6.dex */
public final class Gson {
    public static final boolean DEFAULT_COMPLEX_MAP_KEYS = false;
    public static final boolean DEFAULT_ESCAPE_HTML = true;
    public static final boolean DEFAULT_JSON_NON_EXECUTABLE = false;
    public static final boolean DEFAULT_LENIENT = false;
    public static final boolean DEFAULT_PRETTY_PRINT = false;
    public static final boolean DEFAULT_SERIALIZE_NULLS = false;
    public static final boolean DEFAULT_SPECIALIZE_FLOAT_VALUES = false;
    public static final String JSON_NON_EXECUTABLE_PREFIX = ")]}'\n";
    public static final a<?> NULL_KEY_SURROGATE = a.a(Object.class);
    public final List<TypeAdapterFactory> builderFactories;
    public final List<TypeAdapterFactory> builderHierarchyFactories;
    public final ThreadLocal<Map<a<?>, FutureTypeAdapter<?>>> calls;
    public final boolean complexMapKeySerialization;
    public final b constructorConstructor;
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
    public final Map<a<?>, TypeAdapter<?>> typeTokenCache;

    /* loaded from: classes6.dex */
    public static class FutureTypeAdapter<T> extends TypeAdapter<T> {
        public TypeAdapter<T> delegate;

        @Override // com.google.gson.TypeAdapter
        public T read(d.h.d.d.a aVar) throws IOException {
            TypeAdapter<T> typeAdapter = this.delegate;
            if (typeAdapter != null) {
                return typeAdapter.read(aVar);
            }
            throw new IllegalStateException();
        }

        public void setDelegate(TypeAdapter<T> typeAdapter) {
            if (this.delegate == null) {
                this.delegate = typeAdapter;
                return;
            }
            throw new AssertionError();
        }

        @Override // com.google.gson.TypeAdapter
        public void write(d.h.d.d.b bVar, T t) throws IOException {
            TypeAdapter<T> typeAdapter = this.delegate;
            if (typeAdapter != null) {
                typeAdapter.write(bVar, t);
                return;
            }
            throw new IllegalStateException();
        }
    }

    public Gson() {
        this(Excluder.k, FieldNamingPolicy.IDENTITY, Collections.emptyMap(), false, false, false, true, false, false, false, LongSerializationPolicy.DEFAULT, null, 2, 2, Collections.emptyList(), Collections.emptyList(), Collections.emptyList());
    }

    public static void assertFullConsumption(Object obj, d.h.d.d.a aVar) {
        if (obj != null) {
            try {
                if (aVar.M() == JsonToken.END_DOCUMENT) {
                    return;
                }
                throw new JsonIOException("JSON document was not fully consumed.");
            } catch (MalformedJsonException e2) {
                throw new JsonSyntaxException(e2);
            } catch (IOException e3) {
                throw new JsonIOException(e3);
            }
        }
    }

    public static TypeAdapter<AtomicLong> atomicLongAdapter(final TypeAdapter<Number> typeAdapter) {
        return new TypeAdapter<AtomicLong>() { // from class: com.google.gson.Gson.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.gson.TypeAdapter
            public AtomicLong read(d.h.d.d.a aVar) throws IOException {
                return new AtomicLong(((Number) TypeAdapter.this.read(aVar)).longValue());
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.gson.TypeAdapter
            public void write(d.h.d.d.b bVar, AtomicLong atomicLong) throws IOException {
                TypeAdapter.this.write(bVar, Long.valueOf(atomicLong.get()));
            }
        }.nullSafe();
    }

    public static TypeAdapter<AtomicLongArray> atomicLongArrayAdapter(final TypeAdapter<Number> typeAdapter) {
        return new TypeAdapter<AtomicLongArray>() { // from class: com.google.gson.Gson.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.gson.TypeAdapter
            public AtomicLongArray read(d.h.d.d.a aVar) throws IOException {
                ArrayList arrayList = new ArrayList();
                aVar.n();
                while (aVar.y()) {
                    arrayList.add(Long.valueOf(((Number) TypeAdapter.this.read(aVar)).longValue()));
                }
                aVar.t();
                int size = arrayList.size();
                AtomicLongArray atomicLongArray = new AtomicLongArray(size);
                for (int i = 0; i < size; i++) {
                    atomicLongArray.set(i, ((Long) arrayList.get(i)).longValue());
                }
                return atomicLongArray;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.gson.TypeAdapter
            public void write(d.h.d.d.b bVar, AtomicLongArray atomicLongArray) throws IOException {
                bVar.q();
                int length = atomicLongArray.length();
                for (int i = 0; i < length; i++) {
                    TypeAdapter.this.write(bVar, Long.valueOf(atomicLongArray.get(i)));
                }
                bVar.t();
            }
        }.nullSafe();
    }

    public static void checkValidFloatingPoint(double d2) {
        if (Double.isNaN(d2) || Double.isInfinite(d2)) {
            throw new IllegalArgumentException(d2 + " is not a valid double value as per JSON specification. To override this behavior, use GsonBuilder.serializeSpecialFloatingPointValues() method.");
        }
    }

    private TypeAdapter<Number> doubleAdapter(boolean z) {
        if (z) {
            return TypeAdapters.v;
        }
        return new TypeAdapter<Number>() { // from class: com.google.gson.Gson.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX DEBUG: Return type fixed from 'java.lang.Double' to match base method */
            @Override // com.google.gson.TypeAdapter
            /* renamed from: read */
            public Number read2(d.h.d.d.a aVar) throws IOException {
                if (aVar.M() == JsonToken.NULL) {
                    aVar.I();
                    return null;
                }
                return Double.valueOf(aVar.D());
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.gson.TypeAdapter
            public void write(d.h.d.d.b bVar, Number number) throws IOException {
                if (number == null) {
                    bVar.B();
                    return;
                }
                Gson.checkValidFloatingPoint(number.doubleValue());
                bVar.N(number);
            }
        };
    }

    private TypeAdapter<Number> floatAdapter(boolean z) {
        if (z) {
            return TypeAdapters.u;
        }
        return new TypeAdapter<Number>() { // from class: com.google.gson.Gson.2
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX DEBUG: Return type fixed from 'java.lang.Float' to match base method */
            @Override // com.google.gson.TypeAdapter
            /* renamed from: read */
            public Number read2(d.h.d.d.a aVar) throws IOException {
                if (aVar.M() == JsonToken.NULL) {
                    aVar.I();
                    return null;
                }
                return Float.valueOf((float) aVar.D());
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.gson.TypeAdapter
            public void write(d.h.d.d.b bVar, Number number) throws IOException {
                if (number == null) {
                    bVar.B();
                    return;
                }
                Gson.checkValidFloatingPoint(number.floatValue());
                bVar.N(number);
            }
        };
    }

    public static TypeAdapter<Number> longAdapter(LongSerializationPolicy longSerializationPolicy) {
        if (longSerializationPolicy == LongSerializationPolicy.DEFAULT) {
            return TypeAdapters.t;
        }
        return new TypeAdapter<Number>() { // from class: com.google.gson.Gson.3
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.google.gson.TypeAdapter
            public Number read(d.h.d.d.a aVar) throws IOException {
                if (aVar.M() == JsonToken.NULL) {
                    aVar.I();
                    return null;
                }
                return Long.valueOf(aVar.F());
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.gson.TypeAdapter
            public void write(d.h.d.d.b bVar, Number number) throws IOException {
                if (number == null) {
                    bVar.B();
                } else {
                    bVar.O(number.toString());
                }
            }
        };
    }

    public Excluder excluder() {
        return this.excluder;
    }

    public FieldNamingStrategy fieldNamingStrategy() {
        return this.fieldNamingStrategy;
    }

    public <T> T fromJson(String str, Class<T> cls) throws JsonSyntaxException {
        return (T) g.c(cls).cast(fromJson(str, (Type) cls));
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v5, resolved type: java.util.Map<d.h.d.c.a<?>, com.google.gson.TypeAdapter<?>> */
    /* JADX DEBUG: Type inference failed for r4v4. Raw type applied. Possible types: com.google.gson.TypeAdapter<T>, com.google.gson.TypeAdapter<?> */
    /* JADX WARN: Multi-variable type inference failed */
    public <T> TypeAdapter<T> getAdapter(a<T> aVar) {
        TypeAdapter<T> typeAdapter = (TypeAdapter<T>) this.typeTokenCache.get(aVar == null ? NULL_KEY_SURROGATE : aVar);
        if (typeAdapter != null) {
            return typeAdapter;
        }
        Map<a<?>, FutureTypeAdapter<?>> map = this.calls.get();
        boolean z = false;
        if (map == null) {
            map = new HashMap<>();
            this.calls.set(map);
            z = true;
        }
        FutureTypeAdapter<?> futureTypeAdapter = map.get(aVar);
        if (futureTypeAdapter != null) {
            return futureTypeAdapter;
        }
        try {
            FutureTypeAdapter<?> futureTypeAdapter2 = new FutureTypeAdapter<>();
            map.put(aVar, futureTypeAdapter2);
            for (TypeAdapterFactory typeAdapterFactory : this.factories) {
                TypeAdapter typeAdapter2 = (TypeAdapter<T>) typeAdapterFactory.create(this, aVar);
                if (typeAdapter2 != null) {
                    futureTypeAdapter2.setDelegate(typeAdapter2);
                    this.typeTokenCache.put(aVar, typeAdapter2);
                    return typeAdapter2;
                }
            }
            throw new IllegalArgumentException("GSON (2.8.5) cannot handle " + aVar);
        } finally {
            map.remove(aVar);
            if (z) {
                this.calls.remove();
            }
        }
    }

    public <T> TypeAdapter<T> getDelegateAdapter(TypeAdapterFactory typeAdapterFactory, a<T> aVar) {
        if (!this.factories.contains(typeAdapterFactory)) {
            typeAdapterFactory = this.jsonAdapterFactory;
        }
        boolean z = false;
        for (TypeAdapterFactory typeAdapterFactory2 : this.factories) {
            if (z) {
                TypeAdapter<T> create = typeAdapterFactory2.create(this, aVar);
                if (create != null) {
                    return create;
                }
            } else if (typeAdapterFactory2 == typeAdapterFactory) {
                z = true;
            }
        }
        throw new IllegalArgumentException("GSON cannot serialize " + aVar);
    }

    public boolean htmlSafe() {
        return this.htmlSafe;
    }

    public GsonBuilder newBuilder() {
        return new GsonBuilder(this);
    }

    public d.h.d.d.a newJsonReader(Reader reader) {
        d.h.d.d.a aVar = new d.h.d.d.a(reader);
        aVar.R(this.lenient);
        return aVar;
    }

    public d.h.d.d.b newJsonWriter(Writer writer) throws IOException {
        if (this.generateNonExecutableJson) {
            writer.write(JSON_NON_EXECUTABLE_PREFIX);
        }
        d.h.d.d.b bVar = new d.h.d.d.b(writer);
        if (this.prettyPrinting) {
            bVar.H(GlideException.IndentedAppendable.INDENT);
        }
        bVar.J(this.serializeNulls);
        return bVar;
    }

    public boolean serializeNulls() {
        return this.serializeNulls;
    }

    public String toJson(Object obj) {
        if (obj == null) {
            return toJson((JsonElement) JsonNull.INSTANCE);
        }
        return toJson(obj, obj.getClass());
    }

    public JsonElement toJsonTree(Object obj) {
        if (obj == null) {
            return JsonNull.INSTANCE;
        }
        return toJsonTree(obj, obj.getClass());
    }

    public String toString() {
        return "{serializeNulls:" + this.serializeNulls + ",factories:" + this.factories + ",instanceCreators:" + this.constructorConstructor + "}";
    }

    public <T> T fromJson(String str, Type type) throws JsonSyntaxException {
        if (str == null) {
            return null;
        }
        return (T) fromJson(new StringReader(str), type);
    }

    public String toJson(Object obj, Type type) {
        StringWriter stringWriter = new StringWriter();
        toJson(obj, type, stringWriter);
        return stringWriter.toString();
    }

    public JsonElement toJsonTree(Object obj, Type type) {
        d.h.d.b.j.b bVar = new d.h.d.b.j.b();
        toJson(obj, type, bVar);
        return bVar.R();
    }

    public <T> T fromJson(Reader reader, Class<T> cls) throws JsonSyntaxException, JsonIOException {
        d.h.d.d.a newJsonReader = newJsonReader(reader);
        Object fromJson = fromJson(newJsonReader, cls);
        assertFullConsumption(fromJson, newJsonReader);
        return (T) g.c(cls).cast(fromJson);
    }

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
        arrayList.add(TypeAdapters.Y);
        arrayList.add(ObjectTypeAdapter.f31341b);
        arrayList.add(excluder);
        arrayList.addAll(list3);
        arrayList.add(TypeAdapters.D);
        arrayList.add(TypeAdapters.m);
        arrayList.add(TypeAdapters.f31383g);
        arrayList.add(TypeAdapters.i);
        arrayList.add(TypeAdapters.k);
        TypeAdapter<Number> longAdapter = longAdapter(longSerializationPolicy);
        arrayList.add(TypeAdapters.c(Long.TYPE, Long.class, longAdapter));
        arrayList.add(TypeAdapters.c(Double.TYPE, Double.class, doubleAdapter(z7)));
        arrayList.add(TypeAdapters.c(Float.TYPE, Float.class, floatAdapter(z7)));
        arrayList.add(TypeAdapters.x);
        arrayList.add(TypeAdapters.o);
        arrayList.add(TypeAdapters.q);
        arrayList.add(TypeAdapters.b(AtomicLong.class, atomicLongAdapter(longAdapter)));
        arrayList.add(TypeAdapters.b(AtomicLongArray.class, atomicLongArrayAdapter(longAdapter)));
        arrayList.add(TypeAdapters.s);
        arrayList.add(TypeAdapters.z);
        arrayList.add(TypeAdapters.F);
        arrayList.add(TypeAdapters.H);
        arrayList.add(TypeAdapters.b(BigDecimal.class, TypeAdapters.B));
        arrayList.add(TypeAdapters.b(BigInteger.class, TypeAdapters.C));
        arrayList.add(TypeAdapters.J);
        arrayList.add(TypeAdapters.L);
        arrayList.add(TypeAdapters.P);
        arrayList.add(TypeAdapters.R);
        arrayList.add(TypeAdapters.W);
        arrayList.add(TypeAdapters.N);
        arrayList.add(TypeAdapters.f31380d);
        arrayList.add(DateTypeAdapter.f31332b);
        arrayList.add(TypeAdapters.U);
        arrayList.add(TimeTypeAdapter.f31360b);
        arrayList.add(SqlDateTypeAdapter.f31358b);
        arrayList.add(TypeAdapters.S);
        arrayList.add(ArrayTypeAdapter.f31326c);
        arrayList.add(TypeAdapters.f31378b);
        arrayList.add(new CollectionTypeAdapterFactory(this.constructorConstructor));
        arrayList.add(new MapTypeAdapterFactory(this.constructorConstructor, z2));
        JsonAdapterAnnotationTypeAdapterFactory jsonAdapterAnnotationTypeAdapterFactory = new JsonAdapterAnnotationTypeAdapterFactory(this.constructorConstructor);
        this.jsonAdapterFactory = jsonAdapterAnnotationTypeAdapterFactory;
        arrayList.add(jsonAdapterAnnotationTypeAdapterFactory);
        arrayList.add(TypeAdapters.Z);
        arrayList.add(new ReflectiveTypeAdapterFactory(this.constructorConstructor, fieldNamingStrategy, excluder, this.jsonAdapterFactory));
        this.factories = Collections.unmodifiableList(arrayList);
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
            toJson(obj, type, newJsonWriter(h.c(appendable)));
        } catch (IOException e2) {
            throw new JsonIOException(e2);
        }
    }

    public <T> T fromJson(Reader reader, Type type) throws JsonIOException, JsonSyntaxException {
        d.h.d.d.a newJsonReader = newJsonReader(reader);
        T t = (T) fromJson(newJsonReader, type);
        assertFullConsumption(t, newJsonReader);
        return t;
    }

    public void toJson(Object obj, Type type, d.h.d.d.b bVar) throws JsonIOException {
        TypeAdapter adapter = getAdapter(a.b(type));
        boolean y = bVar.y();
        bVar.I(true);
        boolean x = bVar.x();
        bVar.G(this.htmlSafe);
        boolean w = bVar.w();
        bVar.J(this.serializeNulls);
        try {
            try {
                adapter.write(bVar, obj);
            } catch (IOException e2) {
                throw new JsonIOException(e2);
            } catch (AssertionError e3) {
                throw new AssertionError("AssertionError (GSON 2.8.5): " + e3.getMessage(), e3);
            }
        } finally {
            bVar.I(y);
            bVar.G(x);
            bVar.J(w);
        }
    }

    public <T> T fromJson(d.h.d.d.a aVar, Type type) throws JsonIOException, JsonSyntaxException {
        boolean z = aVar.z();
        boolean z2 = true;
        aVar.R(true);
        try {
            try {
                try {
                    aVar.M();
                    z2 = false;
                    T read = getAdapter(a.b(type)).read(aVar);
                    aVar.R(z);
                    return read;
                } catch (IOException e2) {
                    throw new JsonSyntaxException(e2);
                } catch (IllegalStateException e3) {
                    throw new JsonSyntaxException(e3);
                }
            } catch (EOFException e4) {
                if (z2) {
                    aVar.R(z);
                    return null;
                }
                throw new JsonSyntaxException(e4);
            } catch (AssertionError e5) {
                throw new AssertionError("AssertionError (GSON 2.8.5): " + e5.getMessage(), e5);
            }
        } catch (Throwable th) {
            aVar.R(z);
            throw th;
        }
    }

    public <T> TypeAdapter<T> getAdapter(Class<T> cls) {
        return getAdapter(a.a(cls));
    }

    public <T> T fromJson(JsonElement jsonElement, Class<T> cls) throws JsonSyntaxException {
        return (T) g.c(cls).cast(fromJson(jsonElement, (Type) cls));
    }

    public <T> T fromJson(JsonElement jsonElement, Type type) throws JsonSyntaxException {
        if (jsonElement == null) {
            return null;
        }
        return (T) fromJson(new d.h.d.b.j.a(jsonElement), type);
    }

    public String toJson(JsonElement jsonElement) {
        StringWriter stringWriter = new StringWriter();
        toJson(jsonElement, (Appendable) stringWriter);
        return stringWriter.toString();
    }

    public void toJson(JsonElement jsonElement, Appendable appendable) throws JsonIOException {
        try {
            toJson(jsonElement, newJsonWriter(h.c(appendable)));
        } catch (IOException e2) {
            throw new JsonIOException(e2);
        }
    }

    public void toJson(JsonElement jsonElement, d.h.d.d.b bVar) throws JsonIOException {
        boolean y = bVar.y();
        bVar.I(true);
        boolean x = bVar.x();
        bVar.G(this.htmlSafe);
        boolean w = bVar.w();
        bVar.J(this.serializeNulls);
        try {
            try {
                h.b(jsonElement, bVar);
            } catch (IOException e2) {
                throw new JsonIOException(e2);
            } catch (AssertionError e3) {
                throw new AssertionError("AssertionError (GSON 2.8.5): " + e3.getMessage(), e3);
            }
        } finally {
            bVar.I(y);
            bVar.G(x);
            bVar.J(w);
        }
    }
}
