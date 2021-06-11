package d.n.a;

import com.baidu.android.common.others.lang.StringUtil;
import com.squareup.wire2.FieldEncoding;
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
/* loaded from: classes7.dex */
public final class f<M extends Message<M, B>, B extends Message.a<M, B>> extends ProtoAdapter<M> {

    /* renamed from: a  reason: collision with root package name */
    public final Class<M> f70312a;

    /* renamed from: b  reason: collision with root package name */
    public final Class<B> f70313b;

    /* renamed from: c  reason: collision with root package name */
    public final Map<Integer, a<M, B>> f70314c;

    public f(Class<M> cls, Class<B> cls2, Map<Integer, a<M, B>> map) {
        super(FieldEncoding.LENGTH_DELIMITED, cls);
        this.f70312a = cls;
        this.f70313b = cls2;
        this.f70314c = map;
    }

    public static <M extends Message<M, B>, B extends Message.a<M, B>> f<M, B> a(Class<M> cls) {
        Field[] declaredFields;
        Class e2 = e(cls);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Field field : cls.getDeclaredFields()) {
            WireField wireField = (WireField) field.getAnnotation(WireField.class);
            if (wireField != null) {
                linkedHashMap.put(Integer.valueOf(wireField.tag()), new a(wireField, field, e2));
            }
        }
        return new f<>(cls, e2, Collections.unmodifiableMap(linkedHashMap));
    }

    public static <M extends Message<M, B>, B extends Message.a<M, B>> Class<B> e(Class<M> cls) {
        try {
            return (Class<B>) Class.forName(cls.getName() + "$Builder");
        } catch (ClassNotFoundException unused) {
            throw new IllegalArgumentException("No builder class found for message type " + cls.getName());
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.squareup.wire2.ProtoAdapter
    /* renamed from: b */
    public M decode(c cVar) throws IOException {
        ProtoAdapter<?> i2;
        B f2 = f();
        long c2 = cVar.c();
        while (true) {
            int f3 = cVar.f();
            if (f3 != -1) {
                a<M, B> aVar = this.f70314c.get(Integer.valueOf(f3));
                if (aVar != null) {
                    try {
                        if (aVar.f()) {
                            i2 = aVar.a();
                        } else {
                            i2 = aVar.i();
                        }
                        aVar.j(f2, i2.decode(cVar));
                    } catch (ProtoAdapter.EnumConstantNotFoundException e2) {
                        f2.addUnknownField(f3, FieldEncoding.VARINT, Long.valueOf(e2.value));
                    }
                } else {
                    FieldEncoding g2 = cVar.g();
                    f2.addUnknownField(f3, g2, g2.rawProtoAdapter().decode(cVar));
                }
            } else {
                cVar.d(c2);
                return (M) f2.build();
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.squareup.wire2.ProtoAdapter
    /* renamed from: c */
    public void encode(d dVar, M m) throws IOException {
        for (a<M, B> aVar : this.f70314c.values()) {
            Object b2 = aVar.b(m);
            if (b2 != null) {
                aVar.a().encodeWithTag(dVar, aVar.f70294c, b2);
            }
        }
        dVar.k(m.unknownFields());
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.squareup.wire2.ProtoAdapter
    /* renamed from: d */
    public int encodedSize(M m) {
        int i2 = m.cachedSerializedSize;
        if (i2 != 0) {
            return i2;
        }
        int i3 = 0;
        for (a<M, B> aVar : this.f70314c.values()) {
            Object b2 = aVar.b(m);
            if (b2 != null) {
                i3 += aVar.a().encodedSizeWithTag(aVar.f70294c, b2);
            }
        }
        int size = i3 + m.unknownFields().size();
        m.cachedSerializedSize = size;
        return size;
    }

    public boolean equals(Object obj) {
        return (obj instanceof f) && ((f) obj).f70312a == this.f70312a;
    }

    public B f() {
        try {
            return this.f70313b.newInstance();
        } catch (IllegalAccessException | InstantiationException e2) {
            throw new AssertionError(e2);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.squareup.wire2.ProtoAdapter
    /* renamed from: g */
    public M redact(M m) {
        Message.a<M, B> newBuilder = m.newBuilder();
        for (a<M, B> aVar : this.f70314c.values()) {
            if (aVar.f70297f && aVar.f70292a == WireField.Label.REQUIRED) {
                throw new UnsupportedOperationException(String.format("Field '%s' in %s is required and cannot be redacted.", aVar.f70293b, this.javaType.getName()));
            }
            boolean isAssignableFrom = Message.class.isAssignableFrom(aVar.i().javaType);
            if (!aVar.f70297f && (!isAssignableFrom || aVar.f70292a.isRepeated())) {
                if (isAssignableFrom && aVar.f70292a.isRepeated()) {
                    d.n.a.h.a.k((List) aVar.e(newBuilder), aVar.i());
                }
            } else {
                Object e2 = aVar.e(newBuilder);
                if (e2 != null) {
                    aVar.h(newBuilder, aVar.a().redact(e2));
                }
            }
        }
        newBuilder.clearUnknownFields();
        return newBuilder.build();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.squareup.wire2.ProtoAdapter
    /* renamed from: h */
    public String toString(M m) {
        StringBuilder sb = new StringBuilder();
        for (a<M, B> aVar : this.f70314c.values()) {
            Object b2 = aVar.b(m);
            if (b2 != null) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append(aVar.f70293b);
                sb.append(com.alipay.sdk.encrypt.a.f1886h);
                if (aVar.f70297f) {
                    b2 = "██";
                }
                sb.append(b2);
            }
        }
        sb.replace(0, 2, this.f70312a.getSimpleName() + '{');
        sb.append('}');
        return sb.toString();
    }

    public int hashCode() {
        return this.f70312a.hashCode();
    }
}
