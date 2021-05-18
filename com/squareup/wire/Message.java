package com.squareup.wire;

import com.squareup.wire.UnknownFieldMap;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes7.dex */
public abstract class Message {
    public static final Wire WIRE = new Wire(new Class[0]);
    public transient int cachedSerializedSize;
    public transient int hashCode = 0;
    public transient boolean haveCachedSerializedSize;
    public transient UnknownFieldMap unknownFields;

    /* loaded from: classes7.dex */
    public static abstract class Builder<T extends Message> {
        public UnknownFieldMap unknownFieldMap;

        public Builder() {
        }

        public static <T> List<T> checkForNulls(List<T> list) {
            if (list != null && !list.isEmpty()) {
                for (T t : list) {
                    if (t == null) {
                        throw null;
                    }
                }
            }
            return list;
        }

        private UnknownFieldMap ensureUnknownFieldMap() {
            if (this.unknownFieldMap == null) {
                this.unknownFieldMap = new UnknownFieldMap();
            }
            return this.unknownFieldMap;
        }

        public void addFixed32(int i2, int i3) {
            ensureUnknownFieldMap().addFixed32(i2, Integer.valueOf(i3));
        }

        public void addFixed64(int i2, long j) {
            ensureUnknownFieldMap().addFixed64(i2, Long.valueOf(j));
        }

        public void addLengthDelimited(int i2, ByteString byteString) {
            ensureUnknownFieldMap().addLengthDelimited(i2, byteString);
        }

        public void addVarint(int i2, long j) {
            ensureUnknownFieldMap().addVarint(i2, Long.valueOf(j));
        }

        public abstract T build(boolean z);

        public void checkRequiredFields() {
            Message.WIRE.builderAdapter(getClass()).checkRequiredFields(this);
        }

        public Builder(Message message) {
            if (message == null || message.unknownFields == null) {
                return;
            }
            this.unknownFieldMap = new UnknownFieldMap(message.unknownFields);
        }
    }

    /* loaded from: classes7.dex */
    public enum Datatype {
        INT32(1),
        INT64(2),
        UINT32(3),
        UINT64(4),
        SINT32(5),
        SINT64(6),
        BOOL(7),
        ENUM(8),
        STRING(9),
        BYTES(10),
        MESSAGE(11),
        FIXED32(12),
        SFIXED32(13),
        FIXED64(14),
        SFIXED64(15),
        FLOAT(16),
        DOUBLE(17);
        
        public static /* synthetic */ int[] $SWITCH_TABLE$com$squareup$wire$Message$Datatype;
        public static final Comparator<Datatype> ORDER_BY_NAME = new Comparator<Datatype>() { // from class: com.squareup.wire.Message.Datatype.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // java.util.Comparator
            public int compare(Datatype datatype, Datatype datatype2) {
                return datatype.name().compareTo(datatype2.name());
            }
        };
        public static final Map<String, Datatype> TYPES_BY_NAME;
        public final int value;

        public static /* synthetic */ int[] $SWITCH_TABLE$com$squareup$wire$Message$Datatype() {
            int[] iArr = $SWITCH_TABLE$com$squareup$wire$Message$Datatype;
            if (iArr != null) {
                return iArr;
            }
            int[] iArr2 = new int[valuesCustom().length];
            try {
                iArr2[BOOL.ordinal()] = 7;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr2[BYTES.ordinal()] = 10;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr2[DOUBLE.ordinal()] = 17;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr2[ENUM.ordinal()] = 8;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr2[FIXED32.ordinal()] = 12;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr2[FIXED64.ordinal()] = 14;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr2[FLOAT.ordinal()] = 16;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr2[INT32.ordinal()] = 1;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr2[INT64.ordinal()] = 2;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                iArr2[MESSAGE.ordinal()] = 11;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                iArr2[SFIXED32.ordinal()] = 13;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                iArr2[SFIXED64.ordinal()] = 15;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                iArr2[SINT32.ordinal()] = 5;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                iArr2[SINT64.ordinal()] = 6;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                iArr2[STRING.ordinal()] = 9;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                iArr2[UINT32.ordinal()] = 3;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                iArr2[UINT64.ordinal()] = 4;
            } catch (NoSuchFieldError unused17) {
            }
            $SWITCH_TABLE$com$squareup$wire$Message$Datatype = iArr2;
            return iArr2;
        }

        static {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            TYPES_BY_NAME = linkedHashMap;
            linkedHashMap.put("int32", INT32);
            TYPES_BY_NAME.put("int64", INT64);
            TYPES_BY_NAME.put("uint32", UINT32);
            TYPES_BY_NAME.put("uint64", UINT64);
            TYPES_BY_NAME.put("sint32", SINT32);
            TYPES_BY_NAME.put("sint64", SINT64);
            TYPES_BY_NAME.put("bool", BOOL);
            TYPES_BY_NAME.put("enum", ENUM);
            TYPES_BY_NAME.put("string", STRING);
            TYPES_BY_NAME.put("bytes", BYTES);
            TYPES_BY_NAME.put("message", MESSAGE);
            TYPES_BY_NAME.put("fixed32", FIXED32);
            TYPES_BY_NAME.put("sfixed32", SFIXED32);
            TYPES_BY_NAME.put("fixed64", FIXED64);
            TYPES_BY_NAME.put("sfixed64", SFIXED64);
            TYPES_BY_NAME.put("float", FLOAT);
            TYPES_BY_NAME.put("double", DOUBLE);
        }

        Datatype(int i2) {
            this.value = i2;
        }

        public static Datatype of(String str) {
            return TYPES_BY_NAME.get(str);
        }

        /* JADX DEBUG: Replace access to removed values field (ENUM$VALUES) with 'values()' method */
        /* renamed from: values  reason: to resolve conflict with enum method */
        public static Datatype[] valuesCustom() {
            Datatype[] valuesCustom = values();
            int length = valuesCustom.length;
            Datatype[] datatypeArr = new Datatype[length];
            System.arraycopy(valuesCustom, 0, datatypeArr, 0, length);
            return datatypeArr;
        }

        public int value() {
            return this.value;
        }

        public WireType wireType() {
            switch ($SWITCH_TABLE$com$squareup$wire$Message$Datatype()[ordinal()]) {
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                case 6:
                case 7:
                case 8:
                    return WireType.VARINT;
                case 9:
                case 10:
                case 11:
                    return WireType.LENGTH_DELIMITED;
                case 12:
                case 13:
                case 16:
                    return WireType.FIXED32;
                case 14:
                case 15:
                case 17:
                    return WireType.FIXED64;
                default:
                    throw new AssertionError("No wiretype for datatype " + this);
            }
        }
    }

    /* loaded from: classes7.dex */
    public enum Label {
        REQUIRED(32),
        OPTIONAL(64),
        REPEATED(128),
        PACKED(256);
        
        public static final Comparator<Label> ORDER_BY_NAME = new Comparator<Label>() { // from class: com.squareup.wire.Message.Label.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // java.util.Comparator
            public int compare(Label label, Label label2) {
                return label.name().compareTo(label2.name());
            }
        };
        public final int value;

        Label(int i2) {
            this.value = i2;
        }

        /* JADX DEBUG: Replace access to removed values field (ENUM$VALUES) with 'values()' method */
        /* renamed from: values  reason: to resolve conflict with enum method */
        public static Label[] valuesCustom() {
            Label[] valuesCustom = values();
            int length = valuesCustom.length;
            Label[] labelArr = new Label[length];
            System.arraycopy(valuesCustom, 0, labelArr, 0, length);
            return labelArr;
        }

        public boolean isPacked() {
            return this == PACKED;
        }

        public boolean isRepeated() {
            return this == REPEATED || this == PACKED;
        }

        public int value() {
            return this.value;
        }
    }

    public Message(Builder builder) {
        UnknownFieldMap unknownFieldMap = builder.unknownFieldMap;
        if (unknownFieldMap != null) {
            this.unknownFields = new UnknownFieldMap(unknownFieldMap);
        }
    }

    public static <T> List<T> asList(T... tArr) {
        return Arrays.asList(tArr);
    }

    public static <T> List<T> copyOf(List<T> list) {
        if (list == null) {
            return null;
        }
        return new ArrayList(list);
    }

    public static <E extends Enum & ProtoEnum> E enumFromInt(Class<E> cls, int i2) {
        return (E) ((Enum) WIRE.enumAdapter(cls).fromInt(i2));
    }

    public static <T> List<T> immutableCopyOf(List<T> list) {
        if (list == null) {
            return Collections.emptyList();
        }
        return Collections.unmodifiableList(new ArrayList(list));
    }

    public static <E extends Enum & ProtoEnum> int intFromEnum(E e2) {
        return WIRE.enumAdapter(e2.getClass()).toInt(e2);
    }

    private void write(WireOutput wireOutput) {
        try {
            WIRE.messageAdapter(getClass()).write(this, wireOutput);
        } catch (IOException e2) {
            throw new RuntimeException(e2);
        }
    }

    public boolean equals(Object obj, Object obj2) {
        if (obj != obj2) {
            return obj != null && obj.equals(obj2);
        }
        return true;
    }

    public int getSerializedSize() {
        if (!this.haveCachedSerializedSize) {
            this.cachedSerializedSize = WIRE.messageAdapter(getClass()).getSerializedSize(this);
            this.haveCachedSerializedSize = true;
        }
        return this.cachedSerializedSize;
    }

    public int getUnknownFieldsSerializedSize() {
        UnknownFieldMap unknownFieldMap = this.unknownFields;
        if (unknownFieldMap == null) {
            return 0;
        }
        return unknownFieldMap.getSerializedSize();
    }

    public byte[] toByteArray() {
        return WIRE.messageAdapter(getClass()).toByteArray(this);
    }

    public String toString() {
        return WIRE.messageAdapter(getClass()).toString(this);
    }

    public Collection<List<UnknownFieldMap.FieldValue>> unknownFields() {
        UnknownFieldMap unknownFieldMap = this.unknownFields;
        return unknownFieldMap == null ? Collections.emptySet() : unknownFieldMap.fieldMap.values();
    }

    public void writeTo(byte[] bArr) {
        writeTo(bArr, 0, bArr.length);
    }

    public void writeUnknownFieldMap(WireOutput wireOutput) throws IOException {
        UnknownFieldMap unknownFieldMap = this.unknownFields;
        if (unknownFieldMap != null) {
            unknownFieldMap.write(wireOutput);
        }
    }

    public boolean equals(List<?> list, List<?> list2) {
        if (list != null && list.isEmpty()) {
            list = null;
        }
        if (list2 != null && list2.isEmpty()) {
            list2 = null;
        }
        if (list != list2) {
            return list != null && list.equals(list2);
        }
        return true;
    }

    public void writeTo(byte[] bArr, int i2, int i3) {
        write(WireOutput.newInstance(bArr, i2, i3));
    }
}
