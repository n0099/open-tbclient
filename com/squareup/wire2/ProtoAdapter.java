package com.squareup.wire2;

import com.squareup.wire2.Message;
import com.squareup.wire2.WireField;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import okio.Buffer;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.ByteString;
import okio.Okio;
/* loaded from: classes7.dex */
public abstract class ProtoAdapter<E> {
    public static final ProtoAdapter<ByteString> BYTES;
    public static final ProtoAdapter<Double> DOUBLE;
    public static final ProtoAdapter<Integer> FIXED32;
    public static final ProtoAdapter<Long> FIXED64;
    public static final int FIXED_32_SIZE = 4;
    public static final int FIXED_64_SIZE = 8;
    public static final int FIXED_BOOL_SIZE = 1;
    public static final ProtoAdapter<Float> FLOAT;
    public static final ProtoAdapter<Long> INT64;
    public static final ProtoAdapter<Integer> SFIXED32;
    public static final ProtoAdapter<Long> SFIXED64;
    public static final ProtoAdapter<Long> SINT64;
    public static final ProtoAdapter<String> STRING;
    public static final ProtoAdapter<Long> UINT64;
    public final FieldEncoding fieldEncoding;
    public final Class<?> javaType;
    public ProtoAdapter<List<E>> packedAdapter;
    public ProtoAdapter<List<E>> repeatedAdapter;
    public static final ProtoAdapter<Boolean> BOOL = new g(FieldEncoding.VARINT, Boolean.class);
    public static final ProtoAdapter<Integer> INT32 = new h(FieldEncoding.VARINT, Integer.class);
    public static final ProtoAdapter<Integer> UINT32 = new i(FieldEncoding.VARINT, Integer.class);
    public static final ProtoAdapter<Integer> SINT32 = new j(FieldEncoding.VARINT, Integer.class);

    /* loaded from: classes7.dex */
    public static final class EnumConstantNotFoundException extends IllegalArgumentException {
        public final int value;

        public EnumConstantNotFoundException(int i2, Class<?> cls) {
            super("Unknown enum tag " + i2 + " for " + cls.getCanonicalName());
            this.value = i2;
        }
    }

    /* loaded from: classes7.dex */
    public static class a extends ProtoAdapter<Float> {
        public a(FieldEncoding fieldEncoding, Class cls) {
            super(fieldEncoding, cls);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire2.ProtoAdapter
        /* renamed from: a */
        public Float decode(d.n.a.c cVar) throws IOException {
            return Float.valueOf(Float.intBitsToFloat(cVar.i()));
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire2.ProtoAdapter
        /* renamed from: b */
        public void encode(d.n.a.d dVar, Float f2) throws IOException {
            dVar.l(Float.floatToIntBits(f2.floatValue()));
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire2.ProtoAdapter
        /* renamed from: c */
        public int encodedSize(Float f2) {
            return 4;
        }
    }

    /* loaded from: classes7.dex */
    public static class b extends ProtoAdapter<Double> {
        public b(FieldEncoding fieldEncoding, Class cls) {
            super(fieldEncoding, cls);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire2.ProtoAdapter
        /* renamed from: a */
        public Double decode(d.n.a.c cVar) throws IOException {
            return Double.valueOf(Double.longBitsToDouble(cVar.j()));
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire2.ProtoAdapter
        /* renamed from: b */
        public void encode(d.n.a.d dVar, Double d2) throws IOException {
            dVar.m(Double.doubleToLongBits(d2.doubleValue()));
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire2.ProtoAdapter
        /* renamed from: c */
        public int encodedSize(Double d2) {
            return 8;
        }
    }

    /* loaded from: classes7.dex */
    public static class c extends ProtoAdapter<String> {
        public c(FieldEncoding fieldEncoding, Class cls) {
            super(fieldEncoding, cls);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire2.ProtoAdapter
        /* renamed from: a */
        public String decode(d.n.a.c cVar) throws IOException {
            return cVar.k();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire2.ProtoAdapter
        /* renamed from: b */
        public void encode(d.n.a.d dVar, String str) throws IOException {
            dVar.o(str);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire2.ProtoAdapter
        /* renamed from: c */
        public int encodedSize(String str) {
            return d.n.a.d.h(str);
        }
    }

    /* loaded from: classes7.dex */
    public static class d extends ProtoAdapter<ByteString> {
        public d(FieldEncoding fieldEncoding, Class cls) {
            super(fieldEncoding, cls);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire2.ProtoAdapter
        /* renamed from: a */
        public ByteString decode(d.n.a.c cVar) throws IOException {
            return cVar.h();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire2.ProtoAdapter
        /* renamed from: b */
        public void encode(d.n.a.d dVar, ByteString byteString) throws IOException {
            dVar.k(byteString);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire2.ProtoAdapter
        /* renamed from: c */
        public int encodedSize(ByteString byteString) {
            return byteString.size();
        }
    }

    /* loaded from: classes7.dex */
    public class e extends ProtoAdapter<List<E>> {
        public e(FieldEncoding fieldEncoding, Class cls) {
            super(fieldEncoding, cls);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire2.ProtoAdapter
        /* renamed from: a */
        public List<E> decode(d.n.a.c cVar) throws IOException {
            return Collections.singletonList(ProtoAdapter.this.decode(cVar));
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire2.ProtoAdapter
        /* renamed from: b */
        public void encode(d.n.a.d dVar, List<E> list) throws IOException {
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                ProtoAdapter.this.encode(dVar, (d.n.a.d) list.get(i2));
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire2.ProtoAdapter
        /* renamed from: c */
        public void encodeWithTag(d.n.a.d dVar, int i2, List<E> list) throws IOException {
            if (list.isEmpty()) {
                return;
            }
            super.encodeWithTag(dVar, i2, list);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire2.ProtoAdapter
        /* renamed from: d */
        public int encodedSize(List<E> list) {
            int size = list.size();
            int i2 = 0;
            for (int i3 = 0; i3 < size; i3++) {
                i2 += ProtoAdapter.this.encodedSize(list.get(i3));
            }
            return i2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire2.ProtoAdapter
        /* renamed from: e */
        public int encodedSizeWithTag(int i2, List<E> list) {
            if (list.isEmpty()) {
                return 0;
            }
            return super.encodedSizeWithTag(i2, list);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire2.ProtoAdapter
        /* renamed from: f */
        public List<E> redact(List<E> list) {
            return Collections.emptyList();
        }
    }

    /* loaded from: classes7.dex */
    public class f extends ProtoAdapter<List<E>> {
        public f(FieldEncoding fieldEncoding, Class cls) {
            super(fieldEncoding, cls);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire2.ProtoAdapter
        /* renamed from: a */
        public List<E> decode(d.n.a.c cVar) throws IOException {
            return Collections.singletonList(ProtoAdapter.this.decode(cVar));
        }

        public void b(d.n.a.d dVar, List<E> list) {
            throw new UnsupportedOperationException("Repeated values can only be encoded with a tag.");
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire2.ProtoAdapter
        /* renamed from: c */
        public void encodeWithTag(d.n.a.d dVar, int i2, List<E> list) throws IOException {
            int size = list.size();
            for (int i3 = 0; i3 < size; i3++) {
                ProtoAdapter.this.encodeWithTag(dVar, i2, list.get(i3));
            }
        }

        public int d(List<E> list) {
            throw new UnsupportedOperationException("Repeated values can only be sized with a tag.");
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire2.ProtoAdapter
        /* renamed from: e */
        public int encodedSizeWithTag(int i2, List<E> list) {
            int size = list.size();
            int i3 = 0;
            for (int i4 = 0; i4 < size; i4++) {
                i3 += ProtoAdapter.this.encodedSizeWithTag(i2, list.get(i4));
            }
            return i3;
        }

        @Override // com.squareup.wire2.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(d.n.a.d dVar, Object obj) throws IOException {
            b(dVar, (List) obj);
            throw null;
        }

        @Override // com.squareup.wire2.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(Object obj) {
            d((List) obj);
            throw null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire2.ProtoAdapter
        /* renamed from: f */
        public List<E> redact(List<E> list) {
            return Collections.emptyList();
        }
    }

    /* loaded from: classes7.dex */
    public static class g extends ProtoAdapter<Boolean> {
        public g(FieldEncoding fieldEncoding, Class cls) {
            super(fieldEncoding, cls);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire2.ProtoAdapter
        /* renamed from: a */
        public Boolean decode(d.n.a.c cVar) throws IOException {
            int l = cVar.l();
            if (l == 0) {
                return Boolean.FALSE;
            }
            if (l == 1) {
                return Boolean.TRUE;
            }
            throw new IOException(String.format("Invalid boolean value 0x%02x", Integer.valueOf(l)));
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire2.ProtoAdapter
        /* renamed from: b */
        public void encode(d.n.a.d dVar, Boolean bool) throws IOException {
            dVar.q(bool.booleanValue() ? 1 : 0);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire2.ProtoAdapter
        /* renamed from: c */
        public int encodedSize(Boolean bool) {
            return 1;
        }
    }

    /* loaded from: classes7.dex */
    public static class h extends ProtoAdapter<Integer> {
        public h(FieldEncoding fieldEncoding, Class cls) {
            super(fieldEncoding, cls);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire2.ProtoAdapter
        /* renamed from: a */
        public Integer decode(d.n.a.c cVar) throws IOException {
            return Integer.valueOf(cVar.l());
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire2.ProtoAdapter
        /* renamed from: b */
        public void encode(d.n.a.d dVar, Integer num) throws IOException {
            dVar.n(num.intValue());
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire2.ProtoAdapter
        /* renamed from: c */
        public int encodedSize(Integer num) {
            return d.n.a.d.e(num.intValue());
        }
    }

    /* loaded from: classes7.dex */
    public static class i extends ProtoAdapter<Integer> {
        public i(FieldEncoding fieldEncoding, Class cls) {
            super(fieldEncoding, cls);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire2.ProtoAdapter
        /* renamed from: a */
        public Integer decode(d.n.a.c cVar) throws IOException {
            return Integer.valueOf(cVar.l());
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire2.ProtoAdapter
        /* renamed from: b */
        public void encode(d.n.a.d dVar, Integer num) throws IOException {
            dVar.q(num.intValue());
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire2.ProtoAdapter
        /* renamed from: c */
        public int encodedSize(Integer num) {
            return d.n.a.d.i(num.intValue());
        }
    }

    /* loaded from: classes7.dex */
    public static class j extends ProtoAdapter<Integer> {
        public j(FieldEncoding fieldEncoding, Class cls) {
            super(fieldEncoding, cls);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire2.ProtoAdapter
        /* renamed from: a */
        public Integer decode(d.n.a.c cVar) throws IOException {
            return Integer.valueOf(d.n.a.d.a(cVar.l()));
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire2.ProtoAdapter
        /* renamed from: b */
        public void encode(d.n.a.d dVar, Integer num) throws IOException {
            dVar.q(d.n.a.d.c(num.intValue()));
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire2.ProtoAdapter
        /* renamed from: c */
        public int encodedSize(Integer num) {
            return d.n.a.d.i(d.n.a.d.c(num.intValue()));
        }
    }

    /* loaded from: classes7.dex */
    public static class k extends ProtoAdapter<Integer> {
        public k(FieldEncoding fieldEncoding, Class cls) {
            super(fieldEncoding, cls);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire2.ProtoAdapter
        /* renamed from: a */
        public Integer decode(d.n.a.c cVar) throws IOException {
            return Integer.valueOf(cVar.i());
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire2.ProtoAdapter
        /* renamed from: b */
        public void encode(d.n.a.d dVar, Integer num) throws IOException {
            dVar.l(num.intValue());
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire2.ProtoAdapter
        /* renamed from: c */
        public int encodedSize(Integer num) {
            return 4;
        }
    }

    /* loaded from: classes7.dex */
    public static class l extends ProtoAdapter<Long> {
        public l(FieldEncoding fieldEncoding, Class cls) {
            super(fieldEncoding, cls);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire2.ProtoAdapter
        /* renamed from: a */
        public Long decode(d.n.a.c cVar) throws IOException {
            return Long.valueOf(cVar.m());
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire2.ProtoAdapter
        /* renamed from: b */
        public void encode(d.n.a.d dVar, Long l) throws IOException {
            dVar.r(l.longValue());
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire2.ProtoAdapter
        /* renamed from: c */
        public int encodedSize(Long l) {
            return d.n.a.d.j(l.longValue());
        }
    }

    /* loaded from: classes7.dex */
    public static class m extends ProtoAdapter<Long> {
        public m(FieldEncoding fieldEncoding, Class cls) {
            super(fieldEncoding, cls);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire2.ProtoAdapter
        /* renamed from: a */
        public Long decode(d.n.a.c cVar) throws IOException {
            return Long.valueOf(cVar.m());
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire2.ProtoAdapter
        /* renamed from: b */
        public void encode(d.n.a.d dVar, Long l) throws IOException {
            dVar.r(l.longValue());
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire2.ProtoAdapter
        /* renamed from: c */
        public int encodedSize(Long l) {
            return d.n.a.d.j(l.longValue());
        }
    }

    /* loaded from: classes7.dex */
    public static class n extends ProtoAdapter<Long> {
        public n(FieldEncoding fieldEncoding, Class cls) {
            super(fieldEncoding, cls);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire2.ProtoAdapter
        /* renamed from: a */
        public Long decode(d.n.a.c cVar) throws IOException {
            return Long.valueOf(d.n.a.d.b(cVar.m()));
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire2.ProtoAdapter
        /* renamed from: b */
        public void encode(d.n.a.d dVar, Long l) throws IOException {
            dVar.r(d.n.a.d.d(l.longValue()));
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire2.ProtoAdapter
        /* renamed from: c */
        public int encodedSize(Long l) {
            return d.n.a.d.j(d.n.a.d.d(l.longValue()));
        }
    }

    /* loaded from: classes7.dex */
    public static class o extends ProtoAdapter<Long> {
        public o(FieldEncoding fieldEncoding, Class cls) {
            super(fieldEncoding, cls);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire2.ProtoAdapter
        /* renamed from: a */
        public Long decode(d.n.a.c cVar) throws IOException {
            return Long.valueOf(cVar.j());
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire2.ProtoAdapter
        /* renamed from: b */
        public void encode(d.n.a.d dVar, Long l) throws IOException {
            dVar.m(l.longValue());
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire2.ProtoAdapter
        /* renamed from: c */
        public int encodedSize(Long l) {
            return 8;
        }
    }

    /* loaded from: classes7.dex */
    public static final class p<K, V> extends ProtoAdapter<Map.Entry<K, V>> {

        /* renamed from: a  reason: collision with root package name */
        public final ProtoAdapter<K> f39433a;

        /* renamed from: b  reason: collision with root package name */
        public final ProtoAdapter<V> f39434b;

        public p(ProtoAdapter<K> protoAdapter, ProtoAdapter<V> protoAdapter2) {
            super(FieldEncoding.LENGTH_DELIMITED, null);
            this.f39433a = protoAdapter;
            this.f39434b = protoAdapter2;
        }

        public Map.Entry<K, V> a(d.n.a.c cVar) {
            throw new UnsupportedOperationException();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire2.ProtoAdapter
        /* renamed from: b */
        public void encode(d.n.a.d dVar, Map.Entry<K, V> entry) throws IOException {
            this.f39433a.encodeWithTag(dVar, 1, entry.getKey());
            this.f39434b.encodeWithTag(dVar, 2, entry.getValue());
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire2.ProtoAdapter
        /* renamed from: c */
        public int encodedSize(Map.Entry<K, V> entry) {
            return this.f39433a.encodedSizeWithTag(1, entry.getKey()) + this.f39434b.encodedSizeWithTag(2, entry.getValue());
        }

        @Override // com.squareup.wire2.ProtoAdapter
        public /* bridge */ /* synthetic */ Object decode(d.n.a.c cVar) throws IOException {
            a(cVar);
            throw null;
        }
    }

    /* loaded from: classes7.dex */
    public static final class q<K, V> extends ProtoAdapter<Map<K, V>> {

        /* renamed from: a  reason: collision with root package name */
        public final p<K, V> f39435a;

        public q(ProtoAdapter<K> protoAdapter, ProtoAdapter<V> protoAdapter2) {
            super(FieldEncoding.LENGTH_DELIMITED, null);
            this.f39435a = new p<>(protoAdapter, protoAdapter2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire2.ProtoAdapter
        /* renamed from: a */
        public Map<K, V> decode(d.n.a.c cVar) throws IOException {
            long c2 = cVar.c();
            K k = null;
            V v = null;
            while (true) {
                int f2 = cVar.f();
                if (f2 == -1) {
                    break;
                } else if (f2 == 1) {
                    k = this.f39435a.f39433a.decode(cVar);
                } else if (f2 == 2) {
                    v = this.f39435a.f39434b.decode(cVar);
                }
            }
            cVar.d(c2);
            if (k != null) {
                if (v != null) {
                    return Collections.singletonMap(k, v);
                }
                throw new IllegalStateException("Map entry with null value");
            }
            throw new IllegalStateException("Map entry with null key");
        }

        public void b(d.n.a.d dVar, Map<K, V> map) {
            throw new UnsupportedOperationException("Repeated values can only be encoded with a tag.");
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire2.ProtoAdapter
        /* renamed from: c */
        public void encodeWithTag(d.n.a.d dVar, int i2, Map<K, V> map) throws IOException {
            for (Map.Entry<K, V> entry : map.entrySet()) {
                this.f39435a.encodeWithTag(dVar, i2, entry);
            }
        }

        public int d(Map<K, V> map) {
            throw new UnsupportedOperationException("Repeated values can only be sized with a tag.");
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire2.ProtoAdapter
        /* renamed from: e */
        public int encodedSizeWithTag(int i2, Map<K, V> map) {
            int i3 = 0;
            for (Map.Entry<K, V> entry : map.entrySet()) {
                i3 += this.f39435a.encodedSizeWithTag(i2, entry);
            }
            return i3;
        }

        @Override // com.squareup.wire2.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(d.n.a.d dVar, Object obj) throws IOException {
            b(dVar, (Map) obj);
            throw null;
        }

        @Override // com.squareup.wire2.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(Object obj) {
            d((Map) obj);
            throw null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire2.ProtoAdapter
        /* renamed from: f */
        public Map<K, V> redact(Map<K, V> map) {
            return Collections.emptyMap();
        }
    }

    static {
        k kVar = new k(FieldEncoding.FIXED32, Integer.class);
        FIXED32 = kVar;
        SFIXED32 = kVar;
        INT64 = new l(FieldEncoding.VARINT, Long.class);
        UINT64 = new m(FieldEncoding.VARINT, Long.class);
        SINT64 = new n(FieldEncoding.VARINT, Long.class);
        o oVar = new o(FieldEncoding.FIXED64, Long.class);
        FIXED64 = oVar;
        SFIXED64 = oVar;
        FLOAT = new a(FieldEncoding.FIXED32, Float.class);
        DOUBLE = new b(FieldEncoding.FIXED64, Double.class);
        STRING = new c(FieldEncoding.LENGTH_DELIMITED, String.class);
        BYTES = new d(FieldEncoding.LENGTH_DELIMITED, ByteString.class);
    }

    public ProtoAdapter(FieldEncoding fieldEncoding, Class<?> cls) {
        this.fieldEncoding = fieldEncoding;
        this.javaType = cls;
    }

    private ProtoAdapter<List<E>> createPacked() {
        FieldEncoding fieldEncoding = this.fieldEncoding;
        FieldEncoding fieldEncoding2 = FieldEncoding.LENGTH_DELIMITED;
        if (fieldEncoding != fieldEncoding2) {
            return new e(fieldEncoding2, List.class);
        }
        throw new IllegalArgumentException("Unable to pack a length-delimited type.");
    }

    private ProtoAdapter<List<E>> createRepeated() {
        return new f(this.fieldEncoding, List.class);
    }

    public static <M extends Message> ProtoAdapter<M> get(M m2) {
        return get(m2.getClass());
    }

    public static <E extends d.n.a.g> d.n.a.e<E> newEnumAdapter(Class<E> cls) {
        return new d.n.a.e<>(cls);
    }

    public static <K, V> ProtoAdapter<Map<K, V>> newMapAdapter(ProtoAdapter<K> protoAdapter, ProtoAdapter<V> protoAdapter2) {
        return new q(protoAdapter, protoAdapter2);
    }

    public static <M extends Message<M, B>, B extends Message.a<M, B>> ProtoAdapter<M> newMessageAdapter(Class<M> cls) {
        return d.n.a.f.a(cls);
    }

    public final ProtoAdapter<List<E>> asPacked() {
        ProtoAdapter<List<E>> protoAdapter = this.packedAdapter;
        if (protoAdapter != null) {
            return protoAdapter;
        }
        ProtoAdapter<List<E>> createPacked = createPacked();
        this.packedAdapter = createPacked;
        return createPacked;
    }

    public final ProtoAdapter<List<E>> asRepeated() {
        ProtoAdapter<List<E>> protoAdapter = this.repeatedAdapter;
        if (protoAdapter != null) {
            return protoAdapter;
        }
        ProtoAdapter<List<E>> createRepeated = createRepeated();
        this.repeatedAdapter = createRepeated;
        return createRepeated;
    }

    public abstract E decode(d.n.a.c cVar) throws IOException;

    public final E decode(byte[] bArr) throws IOException {
        d.n.a.b.a(bArr, "bytes == null");
        return decode(new Buffer().write(bArr));
    }

    public abstract void encode(d.n.a.d dVar, E e2) throws IOException;

    public final void encode(BufferedSink bufferedSink, E e2) throws IOException {
        d.n.a.b.a(e2, "value == null");
        d.n.a.b.a(bufferedSink, "sink == null");
        encode(new d.n.a.d(bufferedSink), (d.n.a.d) e2);
    }

    public void encodeWithTag(d.n.a.d dVar, int i2, E e2) throws IOException {
        dVar.p(i2, this.fieldEncoding);
        if (this.fieldEncoding == FieldEncoding.LENGTH_DELIMITED) {
            dVar.q(encodedSize(e2));
        }
        encode(dVar, (d.n.a.d) e2);
    }

    public abstract int encodedSize(E e2);

    public int encodedSizeWithTag(int i2, E e2) {
        int encodedSize = encodedSize(e2);
        if (this.fieldEncoding == FieldEncoding.LENGTH_DELIMITED) {
            encodedSize += d.n.a.d.i(encodedSize);
        }
        return encodedSize + d.n.a.d.g(i2);
    }

    public E redact(E e2) {
        return null;
    }

    public String toString(E e2) {
        return e2.toString();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: com.squareup.wire2.ProtoAdapter<E> */
    /* JADX WARN: Multi-variable type inference failed */
    public ProtoAdapter<?> withLabel(WireField.Label label) {
        if (label.isRepeated()) {
            if (label.isPacked()) {
                return asPacked();
            }
            return asRepeated();
        }
        return this;
    }

    public static <M> ProtoAdapter<M> get(Class<M> cls) {
        try {
            return (ProtoAdapter) cls.getField("ADAPTER").get(null);
        } catch (IllegalAccessException | NoSuchFieldException e2) {
            throw new IllegalArgumentException("failed to access " + cls.getName() + "#ADAPTER", e2);
        }
    }

    public final E decode(ByteString byteString) throws IOException {
        d.n.a.b.a(byteString, "bytes == null");
        return decode(new Buffer().write(byteString));
    }

    public static ProtoAdapter<?> get(String str) {
        try {
            int indexOf = str.indexOf(35);
            String substring = str.substring(0, indexOf);
            return (ProtoAdapter) Class.forName(substring).getField(str.substring(indexOf + 1)).get(null);
        } catch (ClassNotFoundException | IllegalAccessException | NoSuchFieldException e2) {
            throw new IllegalArgumentException("failed to access " + str, e2);
        }
    }

    public final byte[] encode(E e2) {
        d.n.a.b.a(e2, "value == null");
        Buffer buffer = new Buffer();
        try {
            encode((BufferedSink) buffer, (Buffer) e2);
            return buffer.readByteArray();
        } catch (IOException e3) {
            throw new AssertionError(e3);
        }
    }

    public final E decode(InputStream inputStream) throws IOException {
        d.n.a.b.a(inputStream, "stream == null");
        return decode(Okio.buffer(Okio.source(inputStream)));
    }

    public final E decode(BufferedSource bufferedSource) throws IOException {
        d.n.a.b.a(bufferedSource, "source == null");
        return decode(new d.n.a.c(bufferedSource));
    }

    public final void encode(OutputStream outputStream, E e2) throws IOException {
        d.n.a.b.a(e2, "value == null");
        d.n.a.b.a(outputStream, "stream == null");
        BufferedSink buffer = Okio.buffer(Okio.sink(outputStream));
        encode(buffer, (BufferedSink) e2);
        buffer.emit();
    }
}
