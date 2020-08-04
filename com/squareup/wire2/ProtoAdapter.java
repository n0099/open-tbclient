package com.squareup.wire2;

import com.squareup.wire2.Message;
import com.squareup.wire2.WireField;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import okio.Buffer;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.ByteString;
import okio.Okio;
/* loaded from: classes5.dex */
public abstract class ProtoAdapter<E> {
    private static final int FIXED_32_SIZE = 4;
    private static final int FIXED_64_SIZE = 8;
    private static final int FIXED_BOOL_SIZE = 1;
    private final FieldEncoding fieldEncoding;
    final Class<?> javaType;
    ProtoAdapter<List<E>> packedAdapter;
    ProtoAdapter<List<E>> repeatedAdapter;
    public static final ProtoAdapter<Boolean> BOOL = new ProtoAdapter<Boolean>(FieldEncoding.VARINT, Boolean.class) { // from class: com.squareup.wire2.ProtoAdapter.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire2.ProtoAdapter
        /* renamed from: s */
        public int encodedSize(Boolean bool) {
            return 1;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire2.ProtoAdapter
        /* renamed from: a */
        public void encode(d dVar, Boolean bool) throws IOException {
            dVar.writeVarint32(bool.booleanValue() ? 1 : 0);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire2.ProtoAdapter
        /* renamed from: a */
        public Boolean decode(c cVar) throws IOException {
            int readVarint32 = cVar.readVarint32();
            if (readVarint32 == 0) {
                return Boolean.FALSE;
            }
            if (readVarint32 == 1) {
                return Boolean.TRUE;
            }
            throw new IOException(String.format("Invalid boolean value 0x%02x", Integer.valueOf(readVarint32)));
        }
    };
    public static final ProtoAdapter<Integer> INT32 = new ProtoAdapter<Integer>(FieldEncoding.VARINT, Integer.class) { // from class: com.squareup.wire2.ProtoAdapter.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire2.ProtoAdapter
        /* renamed from: s */
        public int encodedSize(Integer num) {
            return d.int32Size(num.intValue());
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire2.ProtoAdapter
        /* renamed from: a */
        public void encode(d dVar, Integer num) throws IOException {
            dVar.writeSignedVarint32(num.intValue());
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire2.ProtoAdapter
        /* renamed from: g */
        public Integer decode(c cVar) throws IOException {
            return Integer.valueOf(cVar.readVarint32());
        }
    };
    public static final ProtoAdapter<Integer> UINT32 = new ProtoAdapter<Integer>(FieldEncoding.VARINT, Integer.class) { // from class: com.squareup.wire2.ProtoAdapter.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire2.ProtoAdapter
        /* renamed from: s */
        public int encodedSize(Integer num) {
            return d.varint32Size(num.intValue());
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire2.ProtoAdapter
        /* renamed from: a */
        public void encode(d dVar, Integer num) throws IOException {
            dVar.writeVarint32(num.intValue());
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire2.ProtoAdapter
        /* renamed from: g */
        public Integer decode(c cVar) throws IOException {
            return Integer.valueOf(cVar.readVarint32());
        }
    };
    public static final ProtoAdapter<Integer> SINT32 = new ProtoAdapter<Integer>(FieldEncoding.VARINT, Integer.class) { // from class: com.squareup.wire2.ProtoAdapter.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire2.ProtoAdapter
        /* renamed from: s */
        public int encodedSize(Integer num) {
            return d.varint32Size(d.encodeZigZag32(num.intValue()));
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire2.ProtoAdapter
        /* renamed from: a */
        public void encode(d dVar, Integer num) throws IOException {
            dVar.writeVarint32(d.encodeZigZag32(num.intValue()));
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire2.ProtoAdapter
        /* renamed from: g */
        public Integer decode(c cVar) throws IOException {
            return Integer.valueOf(d.decodeZigZag32(cVar.readVarint32()));
        }
    };
    public static final ProtoAdapter<Integer> FIXED32 = new ProtoAdapter<Integer>(FieldEncoding.FIXED32, Integer.class) { // from class: com.squareup.wire2.ProtoAdapter.11
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire2.ProtoAdapter
        /* renamed from: s */
        public int encodedSize(Integer num) {
            return 4;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire2.ProtoAdapter
        /* renamed from: a */
        public void encode(d dVar, Integer num) throws IOException {
            dVar.writeFixed32(num.intValue());
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire2.ProtoAdapter
        /* renamed from: g */
        public Integer decode(c cVar) throws IOException {
            return Integer.valueOf(cVar.readFixed32());
        }
    };
    public static final ProtoAdapter<Integer> SFIXED32 = FIXED32;
    public static final ProtoAdapter<Long> INT64 = new ProtoAdapter<Long>(FieldEncoding.VARINT, Long.class) { // from class: com.squareup.wire2.ProtoAdapter.12
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire2.ProtoAdapter
        /* renamed from: g */
        public int encodedSize(Long l) {
            return d.varint64Size(l.longValue());
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire2.ProtoAdapter
        /* renamed from: a */
        public void encode(d dVar, Long l) throws IOException {
            dVar.writeVarint64(l.longValue());
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire2.ProtoAdapter
        /* renamed from: h */
        public Long decode(c cVar) throws IOException {
            return Long.valueOf(cVar.readVarint64());
        }
    };
    public static final ProtoAdapter<Long> UINT64 = new ProtoAdapter<Long>(FieldEncoding.VARINT, Long.class) { // from class: com.squareup.wire2.ProtoAdapter.13
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire2.ProtoAdapter
        /* renamed from: g */
        public int encodedSize(Long l) {
            return d.varint64Size(l.longValue());
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire2.ProtoAdapter
        /* renamed from: a */
        public void encode(d dVar, Long l) throws IOException {
            dVar.writeVarint64(l.longValue());
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire2.ProtoAdapter
        /* renamed from: h */
        public Long decode(c cVar) throws IOException {
            return Long.valueOf(cVar.readVarint64());
        }
    };
    public static final ProtoAdapter<Long> SINT64 = new ProtoAdapter<Long>(FieldEncoding.VARINT, Long.class) { // from class: com.squareup.wire2.ProtoAdapter.14
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire2.ProtoAdapter
        /* renamed from: g */
        public int encodedSize(Long l) {
            return d.varint64Size(d.encodeZigZag64(l.longValue()));
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire2.ProtoAdapter
        /* renamed from: a */
        public void encode(d dVar, Long l) throws IOException {
            dVar.writeVarint64(d.encodeZigZag64(l.longValue()));
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire2.ProtoAdapter
        /* renamed from: h */
        public Long decode(c cVar) throws IOException {
            return Long.valueOf(d.decodeZigZag64(cVar.readVarint64()));
        }
    };
    public static final ProtoAdapter<Long> FIXED64 = new ProtoAdapter<Long>(FieldEncoding.FIXED64, Long.class) { // from class: com.squareup.wire2.ProtoAdapter.15
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire2.ProtoAdapter
        /* renamed from: g */
        public int encodedSize(Long l) {
            return 8;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire2.ProtoAdapter
        /* renamed from: a */
        public void encode(d dVar, Long l) throws IOException {
            dVar.writeFixed64(l.longValue());
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire2.ProtoAdapter
        /* renamed from: h */
        public Long decode(c cVar) throws IOException {
            return Long.valueOf(cVar.readFixed64());
        }
    };
    public static final ProtoAdapter<Long> SFIXED64 = FIXED64;
    public static final ProtoAdapter<Float> FLOAT = new ProtoAdapter<Float>(FieldEncoding.FIXED32, Float.class) { // from class: com.squareup.wire2.ProtoAdapter.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire2.ProtoAdapter
        /* renamed from: e */
        public int encodedSize(Float f) {
            return 4;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire2.ProtoAdapter
        /* renamed from: a */
        public void encode(d dVar, Float f) throws IOException {
            dVar.writeFixed32(Float.floatToIntBits(f.floatValue()));
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire2.ProtoAdapter
        /* renamed from: b */
        public Float decode(c cVar) throws IOException {
            return Float.valueOf(Float.intBitsToFloat(cVar.readFixed32()));
        }
    };
    public static final ProtoAdapter<Double> DOUBLE = new ProtoAdapter<Double>(FieldEncoding.FIXED64, Double.class) { // from class: com.squareup.wire2.ProtoAdapter.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire2.ProtoAdapter
        /* renamed from: a */
        public int encodedSize(Double d) {
            return 8;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire2.ProtoAdapter
        /* renamed from: a */
        public void encode(d dVar, Double d) throws IOException {
            dVar.writeFixed64(Double.doubleToLongBits(d.doubleValue()));
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire2.ProtoAdapter
        /* renamed from: c */
        public Double decode(c cVar) throws IOException {
            return Double.valueOf(Double.longBitsToDouble(cVar.readFixed64()));
        }
    };
    public static final ProtoAdapter<String> STRING = new ProtoAdapter<String>(FieldEncoding.LENGTH_DELIMITED, String.class) { // from class: com.squareup.wire2.ProtoAdapter.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire2.ProtoAdapter
        /* renamed from: Sz */
        public int encodedSize(String str) {
            return d.utf8Length(str);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire2.ProtoAdapter
        /* renamed from: a */
        public void encode(d dVar, String str) throws IOException {
            dVar.writeString(str);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire2.ProtoAdapter
        /* renamed from: d */
        public String decode(c cVar) throws IOException {
            return cVar.readString();
        }
    };
    public static final ProtoAdapter<ByteString> BYTES = new ProtoAdapter<ByteString>(FieldEncoding.LENGTH_DELIMITED, ByteString.class) { // from class: com.squareup.wire2.ProtoAdapter.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire2.ProtoAdapter
        /* renamed from: a */
        public int encodedSize(ByteString byteString) {
            return byteString.size();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire2.ProtoAdapter
        /* renamed from: a */
        public void encode(d dVar, ByteString byteString) throws IOException {
            dVar.b(byteString);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire2.ProtoAdapter
        /* renamed from: e */
        public ByteString decode(c cVar) throws IOException {
            return cVar.dQF();
        }
    };

    public abstract E decode(c cVar) throws IOException;

    public abstract void encode(d dVar, E e) throws IOException;

    public abstract int encodedSize(E e);

    public ProtoAdapter(FieldEncoding fieldEncoding, Class<?> cls) {
        this.fieldEncoding = fieldEncoding;
        this.javaType = cls;
    }

    public static <M extends Message<M, B>, B extends Message.a<M, B>> ProtoAdapter<M> newMessageAdapter(Class<M> cls) {
        return f.K(cls);
    }

    public static <E extends g> e<E> newEnumAdapter(Class<E> cls) {
        return new e<>(cls);
    }

    public static <K, V> ProtoAdapter<Map<K, V>> newMapAdapter(ProtoAdapter<K> protoAdapter, ProtoAdapter<V> protoAdapter2) {
        return new b(protoAdapter, protoAdapter2);
    }

    public static <M extends Message> ProtoAdapter<M> get(M m) {
        return get(m.getClass());
    }

    public static <M> ProtoAdapter<M> get(Class<M> cls) {
        try {
            return (ProtoAdapter) cls.getField("ADAPTER").get(null);
        } catch (IllegalAccessException | NoSuchFieldException e) {
            throw new IllegalArgumentException("failed to access " + cls.getName() + "#ADAPTER", e);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ProtoAdapter<?> get(String str) {
        try {
            int indexOf = str.indexOf(35);
            String substring = str.substring(0, indexOf);
            return (ProtoAdapter) Class.forName(substring).getField(str.substring(indexOf + 1)).get(null);
        } catch (ClassNotFoundException | IllegalAccessException | NoSuchFieldException e) {
            throw new IllegalArgumentException("failed to access " + str, e);
        }
    }

    public E redact(E e) {
        return null;
    }

    public int encodedSizeWithTag(int i, E e) {
        int encodedSize = encodedSize(e);
        if (this.fieldEncoding == FieldEncoding.LENGTH_DELIMITED) {
            encodedSize += d.varint32Size(encodedSize);
        }
        return encodedSize + d.Lg(i);
    }

    public void encodeWithTag(d dVar, int i, E e) throws IOException {
        dVar.b(i, this.fieldEncoding);
        if (this.fieldEncoding == FieldEncoding.LENGTH_DELIMITED) {
            dVar.writeVarint32(encodedSize(e));
        }
        encode(dVar, (d) e);
    }

    public final void encode(BufferedSink bufferedSink, E e) throws IOException {
        com.squareup.wire2.b.checkNotNull(e, "value == null");
        com.squareup.wire2.b.checkNotNull(bufferedSink, "sink == null");
        encode(new d(bufferedSink), (d) e);
    }

    public final byte[] encode(E e) {
        com.squareup.wire2.b.checkNotNull(e, "value == null");
        Buffer buffer = new Buffer();
        try {
            encode((BufferedSink) buffer, (Buffer) e);
            return buffer.readByteArray();
        } catch (IOException e2) {
            throw new AssertionError(e2);
        }
    }

    public final void encode(OutputStream outputStream, E e) throws IOException {
        com.squareup.wire2.b.checkNotNull(e, "value == null");
        com.squareup.wire2.b.checkNotNull(outputStream, "stream == null");
        BufferedSink buffer = Okio.buffer(Okio.sink(outputStream));
        encode(buffer, (BufferedSink) e);
        buffer.emit();
    }

    public final E decode(byte[] bArr) throws IOException {
        com.squareup.wire2.b.checkNotNull(bArr, "bytes == null");
        return decode(new Buffer().write(bArr));
    }

    public final E decode(ByteString byteString) throws IOException {
        com.squareup.wire2.b.checkNotNull(byteString, "bytes == null");
        return decode(new Buffer().write(byteString));
    }

    public final E decode(InputStream inputStream) throws IOException {
        com.squareup.wire2.b.checkNotNull(inputStream, "stream == null");
        return decode(Okio.buffer(Okio.source(inputStream)));
    }

    public final E decode(BufferedSource bufferedSource) throws IOException {
        com.squareup.wire2.b.checkNotNull(bufferedSource, "source == null");
        return decode(new c(bufferedSource));
    }

    public String toString(E e) {
        return e.toString();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: com.squareup.wire2.ProtoAdapter<E> */
    /* JADX INFO: Access modifiers changed from: package-private */
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

    private ProtoAdapter<List<E>> createPacked() {
        if (this.fieldEncoding == FieldEncoding.LENGTH_DELIMITED) {
            throw new IllegalArgumentException("Unable to pack a length-delimited type.");
        }
        return new ProtoAdapter<List<E>>(FieldEncoding.LENGTH_DELIMITED, List.class) { // from class: com.squareup.wire2.ProtoAdapter.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.squareup.wire2.ProtoAdapter
            /* renamed from: a */
            public void encodeWithTag(d dVar, int i, List<E> list) throws IOException {
                if (!list.isEmpty()) {
                    super.encodeWithTag(dVar, i, list);
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.squareup.wire2.ProtoAdapter
            /* renamed from: fG */
            public int encodedSize(List<E> list) {
                int size = list.size();
                int i = 0;
                for (int i2 = 0; i2 < size; i2++) {
                    i += ProtoAdapter.this.encodedSize(list.get(i2));
                }
                return i;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.squareup.wire2.ProtoAdapter
            /* renamed from: q */
            public int encodedSizeWithTag(int i, List<E> list) {
                if (list.isEmpty()) {
                    return 0;
                }
                return super.encodedSizeWithTag(i, list);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.squareup.wire2.ProtoAdapter
            /* renamed from: a */
            public void encode(d dVar, List<E> list) throws IOException {
                int size = list.size();
                for (int i = 0; i < size; i++) {
                    ProtoAdapter.this.encode(dVar, (d) list.get(i));
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.squareup.wire2.ProtoAdapter
            /* renamed from: f */
            public List<E> decode(c cVar) throws IOException {
                return Collections.singletonList(ProtoAdapter.this.decode(cVar));
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.squareup.wire2.ProtoAdapter
            /* renamed from: fH */
            public List<E> redact(List<E> list) {
                return Collections.emptyList();
            }
        };
    }

    private ProtoAdapter<List<E>> createRepeated() {
        return new ProtoAdapter<List<E>>(this.fieldEncoding, List.class) { // from class: com.squareup.wire2.ProtoAdapter.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.squareup.wire2.ProtoAdapter
            /* renamed from: fG */
            public int encodedSize(List<E> list) {
                throw new UnsupportedOperationException("Repeated values can only be sized with a tag.");
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.squareup.wire2.ProtoAdapter
            /* renamed from: q */
            public int encodedSizeWithTag(int i, List<E> list) {
                int size = list.size();
                int i2 = 0;
                for (int i3 = 0; i3 < size; i3++) {
                    i2 += ProtoAdapter.this.encodedSizeWithTag(i, list.get(i3));
                }
                return i2;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.squareup.wire2.ProtoAdapter
            /* renamed from: a */
            public void encode(d dVar, List<E> list) {
                throw new UnsupportedOperationException("Repeated values can only be encoded with a tag.");
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.squareup.wire2.ProtoAdapter
            /* renamed from: a */
            public void encodeWithTag(d dVar, int i, List<E> list) throws IOException {
                int size = list.size();
                for (int i2 = 0; i2 < size; i2++) {
                    ProtoAdapter.this.encodeWithTag(dVar, i, list.get(i2));
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.squareup.wire2.ProtoAdapter
            /* renamed from: f */
            public List<E> decode(c cVar) throws IOException {
                return Collections.singletonList(ProtoAdapter.this.decode(cVar));
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.squareup.wire2.ProtoAdapter
            /* renamed from: fH */
            public List<E> redact(List<E> list) {
                return Collections.emptyList();
            }
        };
    }

    /* loaded from: classes5.dex */
    public static final class EnumConstantNotFoundException extends IllegalArgumentException {
        public final int value;

        /* JADX INFO: Access modifiers changed from: package-private */
        public EnumConstantNotFoundException(int i, Class<?> cls) {
            super("Unknown enum tag " + i + " for " + cls.getCanonicalName());
            this.value = i;
        }
    }

    /* loaded from: classes5.dex */
    private static final class b<K, V> extends ProtoAdapter<Map<K, V>> {
        private final a<K, V> nNH;

        b(ProtoAdapter<K> protoAdapter, ProtoAdapter<V> protoAdapter2) {
            super(FieldEncoding.LENGTH_DELIMITED, null);
            this.nNH = new a<>(protoAdapter, protoAdapter2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire2.ProtoAdapter
        /* renamed from: B */
        public int encodedSize(Map<K, V> map) {
            throw new UnsupportedOperationException("Repeated values can only be sized with a tag.");
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire2.ProtoAdapter
        /* renamed from: f */
        public int encodedSizeWithTag(int i, Map<K, V> map) {
            int i2 = 0;
            Iterator<Map.Entry<K, V>> it = map.entrySet().iterator();
            while (true) {
                int i3 = i2;
                if (it.hasNext()) {
                    i2 = this.nNH.encodedSizeWithTag(i, it.next()) + i3;
                } else {
                    return i3;
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire2.ProtoAdapter
        /* renamed from: a */
        public void encode(d dVar, Map<K, V> map) {
            throw new UnsupportedOperationException("Repeated values can only be encoded with a tag.");
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire2.ProtoAdapter
        /* renamed from: a */
        public void encodeWithTag(d dVar, int i, Map<K, V> map) throws IOException {
            for (Map.Entry<K, V> entry : map.entrySet()) {
                this.nNH.encodeWithTag(dVar, i, entry);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire2.ProtoAdapter
        /* renamed from: j */
        public Map<K, V> decode(c cVar) throws IOException {
            V v = null;
            long dQC = cVar.dQC();
            K k = null;
            while (true) {
                int dQD = cVar.dQD();
                if (dQD != -1) {
                    switch (dQD) {
                        case 1:
                            k = this.nNH.nND.decode(cVar);
                            break;
                        case 2:
                            v = this.nNH.nNG.decode(cVar);
                            break;
                    }
                } else {
                    cVar.gu(dQC);
                    if (k == null) {
                        throw new IllegalStateException("Map entry with null key");
                    }
                    if (v == null) {
                        throw new IllegalStateException("Map entry with null value");
                    }
                    return Collections.singletonMap(k, v);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire2.ProtoAdapter
        /* renamed from: C */
        public Map<K, V> redact(Map<K, V> map) {
            return Collections.emptyMap();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static final class a<K, V> extends ProtoAdapter<Map.Entry<K, V>> {
        final ProtoAdapter<K> nND;
        final ProtoAdapter<V> nNG;

        a(ProtoAdapter<K> protoAdapter, ProtoAdapter<V> protoAdapter2) {
            super(FieldEncoding.LENGTH_DELIMITED, null);
            this.nND = protoAdapter;
            this.nNG = protoAdapter2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire2.ProtoAdapter
        /* renamed from: a */
        public int encodedSize(Map.Entry<K, V> entry) {
            return this.nND.encodedSizeWithTag(1, entry.getKey()) + this.nNG.encodedSizeWithTag(2, entry.getValue());
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire2.ProtoAdapter
        /* renamed from: a */
        public void encode(d dVar, Map.Entry<K, V> entry) throws IOException {
            this.nND.encodeWithTag(dVar, 1, entry.getKey());
            this.nNG.encodeWithTag(dVar, 2, entry.getValue());
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire2.ProtoAdapter
        /* renamed from: i */
        public Map.Entry<K, V> decode(c cVar) {
            throw new UnsupportedOperationException();
        }
    }
}
