package com.squareup.wire2;

import com.squareup.wire2.Message;
import com.squareup.wire2.Message.a;
import com.squareup.wire2.ProtoAdapter;
import com.squareup.wire2.WireField;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes17.dex */
final class f<M extends Message<M, B>, B extends Message.a<M, B>> extends ProtoAdapter<M> {
    private final Class<B> builderType;
    private final Class<M> messageType;
    private final Map<Integer, a<M, B>> pAu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <M extends Message<M, B>, B extends Message.a<M, B>> f<M, B> K(Class<M> cls) {
        Field[] declaredFields;
        Class builderType = getBuilderType(cls);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Field field : cls.getDeclaredFields()) {
            WireField wireField = (WireField) field.getAnnotation(WireField.class);
            if (wireField != null) {
                linkedHashMap.put(Integer.valueOf(wireField.tag()), new a(wireField, field, builderType));
            }
        }
        return new f<>(cls, builderType, Collections.unmodifiableMap(linkedHashMap));
    }

    f(Class<M> cls, Class<B> cls2, Map<Integer, a<M, B>> map) {
        super(FieldEncoding.LENGTH_DELIMITED, cls);
        this.messageType = cls;
        this.builderType = cls2;
        this.pAu = map;
    }

    B newBuilder() {
        try {
            return this.builderType.newInstance();
        } catch (IllegalAccessException | InstantiationException e) {
            throw new AssertionError(e);
        }
    }

    private static <M extends Message<M, B>, B extends Message.a<M, B>> Class<B> getBuilderType(Class<M> cls) {
        try {
            return (Class<B>) Class.forName(cls.getName() + "$Builder");
        } catch (ClassNotFoundException e) {
            throw new IllegalArgumentException("No builder class found for message type " + cls.getName());
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.squareup.wire2.ProtoAdapter
    /* renamed from: b */
    public int encodedSize(M m) {
        int i = m.cachedSerializedSize;
        if (i == 0) {
            int i2 = 0;
            for (a<M, B> aVar : this.pAu.values()) {
                Object a2 = aVar.a((a<M, B>) m);
                if (a2 != null) {
                    i2 = aVar.adapter().encodedSizeWithTag(aVar.tag, a2) + i2;
                }
            }
            int size = m.unknownFields().size() + i2;
            m.cachedSerializedSize = size;
            return size;
        }
        return i;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.squareup.wire2.ProtoAdapter
    /* renamed from: a */
    public void encode(d dVar, M m) throws IOException {
        for (a<M, B> aVar : this.pAu.values()) {
            Object a2 = aVar.a((a<M, B>) m);
            if (a2 != null) {
                aVar.adapter().encodeWithTag(dVar, aVar.tag, a2);
            }
        }
        dVar.b(m.unknownFields());
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.squareup.wire2.ProtoAdapter
    /* renamed from: c */
    public M redact(M m) {
        Message.a<M, B> newBuilder = m.newBuilder();
        for (a<M, B> aVar : this.pAu.values()) {
            if (aVar.pAi && aVar.pAf == WireField.Label.REQUIRED) {
                throw new UnsupportedOperationException(String.format("Field '%s' in %s is required and cannot be redacted.", aVar.name, this.javaType.getName()));
            }
            boolean isAssignableFrom = Message.class.isAssignableFrom(aVar.eAF().javaType);
            if (aVar.pAi || (isAssignableFrom && !aVar.pAf.isRepeated())) {
                Object a2 = aVar.a((a<M, B>) newBuilder);
                if (a2 != null) {
                    aVar.b(newBuilder, aVar.adapter().redact(a2));
                }
            } else if (isAssignableFrom && aVar.pAf.isRepeated()) {
                com.squareup.wire2.internal.a.a((List) aVar.a((a<M, B>) newBuilder), aVar.eAF());
            }
        }
        newBuilder.clearUnknownFields();
        return newBuilder.build();
    }

    public boolean equals(Object obj) {
        return (obj instanceof f) && ((f) obj).messageType == this.messageType;
    }

    public int hashCode() {
        return this.messageType.hashCode();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.squareup.wire2.ProtoAdapter
    /* renamed from: d */
    public String toString(M m) {
        StringBuilder sb = new StringBuilder();
        for (a<M, B> aVar : this.pAu.values()) {
            Object a2 = aVar.a((a<M, B>) m);
            if (a2 != null) {
                sb.append(", ").append(aVar.name).append('=').append(aVar.pAi ? "██" : a2);
            }
        }
        sb.replace(0, 2, this.messageType.getSimpleName() + '{');
        return sb.append('}').toString();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.squareup.wire2.ProtoAdapter
    /* renamed from: l */
    public M decode(c cVar) throws IOException {
        ProtoAdapter<?> eAF;
        B newBuilder = newBuilder();
        long eAH = cVar.eAH();
        while (true) {
            int eAI = cVar.eAI();
            if (eAI != -1) {
                a<M, B> aVar = this.pAu.get(Integer.valueOf(eAI));
                if (aVar != null) {
                    try {
                        if (aVar.eAE()) {
                            eAF = aVar.adapter();
                        } else {
                            eAF = aVar.eAF();
                        }
                        aVar.a(newBuilder, eAF.decode(cVar));
                    } catch (ProtoAdapter.EnumConstantNotFoundException e) {
                        newBuilder.addUnknownField(eAI, FieldEncoding.VARINT, Long.valueOf(e.value));
                    }
                } else {
                    FieldEncoding eAJ = cVar.eAJ();
                    newBuilder.addUnknownField(eAI, eAJ, eAJ.rawProtoAdapter().decode(cVar));
                }
            } else {
                cVar.iE(eAH);
                return (M) newBuilder.build();
            }
        }
    }
}
