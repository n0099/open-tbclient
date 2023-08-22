package com.google.gson.internal;

import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.Since;
import com.google.gson.annotations.Until;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/* loaded from: classes9.dex */
public final class Excluder implements TypeAdapterFactory, Cloneable {
    public static final Excluder DEFAULT = new Excluder();
    public static final double IGNORE_VERSIONS = -1.0d;
    public boolean requireExpose;
    public double version = -1.0d;
    public int modifiers = 136;
    public boolean serializeInnerClasses = true;
    public List<ExclusionStrategy> serializationStrategies = Collections.emptyList();
    public List<ExclusionStrategy> deserializationStrategies = Collections.emptyList();

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: clone */
    public Excluder m167clone() {
        try {
            return (Excluder) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(e);
        }
    }

    public Excluder disableInnerClassSerialization() {
        Excluder m167clone = m167clone();
        m167clone.serializeInnerClasses = false;
        return m167clone;
    }

    public Excluder excludeFieldsWithoutExposeAnnotation() {
        Excluder m167clone = m167clone();
        m167clone.requireExpose = true;
        return m167clone;
    }

    private boolean excludeClassChecks(Class<?> cls) {
        if (this.version != -1.0d && !isValidVersion((Since) cls.getAnnotation(Since.class), (Until) cls.getAnnotation(Until.class))) {
            return true;
        }
        if ((!this.serializeInnerClasses && isInnerClass(cls)) || isAnonymousOrLocal(cls)) {
            return true;
        }
        return false;
    }

    private boolean excludeClassInStrategy(Class<?> cls, boolean z) {
        List<ExclusionStrategy> list;
        if (z) {
            list = this.serializationStrategies;
        } else {
            list = this.deserializationStrategies;
        }
        for (ExclusionStrategy exclusionStrategy : list) {
            if (exclusionStrategy.shouldSkipClass(cls)) {
                return true;
            }
        }
        return false;
    }

    private boolean isValidVersion(Since since, Until until) {
        if (isValidSince(since) && isValidUntil(until)) {
            return true;
        }
        return false;
    }

    @Override // com.google.gson.TypeAdapterFactory
    public <T> TypeAdapter<T> create(final Gson gson, final TypeToken<T> typeToken) {
        final boolean z;
        final boolean z2;
        Class<? super T> rawType = typeToken.getRawType();
        boolean excludeClassChecks = excludeClassChecks(rawType);
        if (!excludeClassChecks && !excludeClassInStrategy(rawType, true)) {
            z = false;
        } else {
            z = true;
        }
        if (!excludeClassChecks && !excludeClassInStrategy(rawType, false)) {
            z2 = false;
        } else {
            z2 = true;
        }
        if (!z && !z2) {
            return null;
        }
        return new TypeAdapter<T>() { // from class: com.google.gson.internal.Excluder.1
            public TypeAdapter<T> delegate;

            private TypeAdapter<T> delegate() {
                TypeAdapter<T> typeAdapter = this.delegate;
                if (typeAdapter == null) {
                    TypeAdapter<T> delegateAdapter = gson.getDelegateAdapter(Excluder.this, typeToken);
                    this.delegate = delegateAdapter;
                    return delegateAdapter;
                }
                return typeAdapter;
            }

            @Override // com.google.gson.TypeAdapter
            public T read(JsonReader jsonReader) throws IOException {
                if (z2) {
                    jsonReader.skipValue();
                    return null;
                }
                return delegate().read(jsonReader);
            }

            @Override // com.google.gson.TypeAdapter
            public void write(JsonWriter jsonWriter, T t) throws IOException {
                if (z) {
                    jsonWriter.nullValue();
                } else {
                    delegate().write(jsonWriter, t);
                }
            }
        };
    }

    public boolean excludeClass(Class<?> cls, boolean z) {
        if (!excludeClassChecks(cls) && !excludeClassInStrategy(cls, z)) {
            return false;
        }
        return true;
    }

    private boolean isAnonymousOrLocal(Class<?> cls) {
        if (!Enum.class.isAssignableFrom(cls) && (cls.isAnonymousClass() || cls.isLocalClass())) {
            return true;
        }
        return false;
    }

    private boolean isInnerClass(Class<?> cls) {
        if (cls.isMemberClass() && !isStatic(cls)) {
            return true;
        }
        return false;
    }

    private boolean isStatic(Class<?> cls) {
        if ((cls.getModifiers() & 8) != 0) {
            return true;
        }
        return false;
    }

    private boolean isValidSince(Since since) {
        if (since != null && since.value() > this.version) {
            return false;
        }
        return true;
    }

    private boolean isValidUntil(Until until) {
        if (until != null && until.value() <= this.version) {
            return false;
        }
        return true;
    }

    public Excluder withModifiers(int... iArr) {
        Excluder m167clone = m167clone();
        m167clone.modifiers = 0;
        for (int i : iArr) {
            m167clone.modifiers = i | m167clone.modifiers;
        }
        return m167clone;
    }

    public Excluder withVersion(double d) {
        Excluder m167clone = m167clone();
        m167clone.version = d;
        return m167clone;
    }

    public boolean excludeField(Field field, boolean z) {
        List<ExclusionStrategy> list;
        Expose expose;
        if ((this.modifiers & field.getModifiers()) != 0) {
            return true;
        }
        if ((this.version != -1.0d && !isValidVersion((Since) field.getAnnotation(Since.class), (Until) field.getAnnotation(Until.class))) || field.isSynthetic()) {
            return true;
        }
        if (this.requireExpose && ((expose = (Expose) field.getAnnotation(Expose.class)) == null || (!z ? !expose.deserialize() : !expose.serialize()))) {
            return true;
        }
        if ((!this.serializeInnerClasses && isInnerClass(field.getType())) || isAnonymousOrLocal(field.getType())) {
            return true;
        }
        if (z) {
            list = this.serializationStrategies;
        } else {
            list = this.deserializationStrategies;
        }
        if (!list.isEmpty()) {
            FieldAttributes fieldAttributes = new FieldAttributes(field);
            for (ExclusionStrategy exclusionStrategy : list) {
                if (exclusionStrategy.shouldSkipField(fieldAttributes)) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    public Excluder withExclusionStrategy(ExclusionStrategy exclusionStrategy, boolean z, boolean z2) {
        Excluder m167clone = m167clone();
        if (z) {
            ArrayList arrayList = new ArrayList(this.serializationStrategies);
            m167clone.serializationStrategies = arrayList;
            arrayList.add(exclusionStrategy);
        }
        if (z2) {
            ArrayList arrayList2 = new ArrayList(this.deserializationStrategies);
            m167clone.deserializationStrategies = arrayList2;
            arrayList2.add(exclusionStrategy);
        }
        return m167clone;
    }
}
