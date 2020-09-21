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
/* loaded from: classes17.dex */
public abstract class Message {
    private static final Wire WIRE = new Wire(new Class[0]);
    private transient int cachedSerializedSize;
    protected transient int hashCode = 0;
    private transient boolean haveCachedSerializedSize;
    private transient UnknownFieldMap unknownFields;

    /* loaded from: classes17.dex */
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
        
        private static /* synthetic */ int[] $SWITCH_TABLE$com$squareup$wire$Message$Datatype;
        private final int value;
        public static final Comparator<Datatype> ORDER_BY_NAME = new Comparator<Datatype>() { // from class: com.squareup.wire.Message.Datatype.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // java.util.Comparator
            public int compare(Datatype datatype, Datatype datatype2) {
                return datatype.name().compareTo(datatype2.name());
            }
        };
        private static final Map<String, Datatype> TYPES_BY_NAME = new LinkedHashMap();

        /* JADX DEBUG: Replace access to removed values field (ENUM$VALUES) with 'values()' method */
        /* renamed from: values  reason: to resolve conflict with enum method */
        public static Datatype[] valuesCustom() {
            Datatype[] valuesCustom = values();
            int length = valuesCustom.length;
            Datatype[] datatypeArr = new Datatype[length];
            System.arraycopy(valuesCustom, 0, datatypeArr, 0, length);
            return datatypeArr;
        }

        static /* synthetic */ int[] $SWITCH_TABLE$com$squareup$wire$Message$Datatype() {
            int[] iArr = $SWITCH_TABLE$com$squareup$wire$Message$Datatype;
            if (iArr == null) {
                iArr = new int[valuesCustom().length];
                try {
                    iArr[BOOL.ordinal()] = 7;
                } catch (NoSuchFieldError e) {
                }
                try {
                    iArr[BYTES.ordinal()] = 10;
                } catch (NoSuchFieldError e2) {
                }
                try {
                    iArr[DOUBLE.ordinal()] = 17;
                } catch (NoSuchFieldError e3) {
                }
                try {
                    iArr[ENUM.ordinal()] = 8;
                } catch (NoSuchFieldError e4) {
                }
                try {
                    iArr[FIXED32.ordinal()] = 12;
                } catch (NoSuchFieldError e5) {
                }
                try {
                    iArr[FIXED64.ordinal()] = 14;
                } catch (NoSuchFieldError e6) {
                }
                try {
                    iArr[FLOAT.ordinal()] = 16;
                } catch (NoSuchFieldError e7) {
                }
                try {
                    iArr[INT32.ordinal()] = 1;
                } catch (NoSuchFieldError e8) {
                }
                try {
                    iArr[INT64.ordinal()] = 2;
                } catch (NoSuchFieldError e9) {
                }
                try {
                    iArr[MESSAGE.ordinal()] = 11;
                } catch (NoSuchFieldError e10) {
                }
                try {
                    iArr[SFIXED32.ordinal()] = 13;
                } catch (NoSuchFieldError e11) {
                }
                try {
                    iArr[SFIXED64.ordinal()] = 15;
                } catch (NoSuchFieldError e12) {
                }
                try {
                    iArr[SINT32.ordinal()] = 5;
                } catch (NoSuchFieldError e13) {
                }
                try {
                    iArr[SINT64.ordinal()] = 6;
                } catch (NoSuchFieldError e14) {
                }
                try {
                    iArr[STRING.ordinal()] = 9;
                } catch (NoSuchFieldError e15) {
                }
                try {
                    iArr[UINT32.ordinal()] = 3;
                } catch (NoSuchFieldError e16) {
                }
                try {
                    iArr[UINT64.ordinal()] = 4;
                } catch (NoSuchFieldError e17) {
                }
                $SWITCH_TABLE$com$squareup$wire$Message$Datatype = iArr;
            }
            return iArr;
        }

        static {
            TYPES_BY_NAME.put("int32", INT32);
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

        Datatype(int i) {
            this.value = i;
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

        public static Datatype of(String str) {
            return TYPES_BY_NAME.get(str);
        }
    }

    /* loaded from: classes17.dex */
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
        private final int value;

        /* JADX DEBUG: Replace access to removed values field (ENUM$VALUES) with 'values()' method */
        /* renamed from: values  reason: to resolve conflict with enum method */
        public static Label[] valuesCustom() {
            Label[] valuesCustom = values();
            int length = valuesCustom.length;
            Label[] labelArr = new Label[length];
            System.arraycopy(valuesCustom, 0, labelArr, 0, length);
            return labelArr;
        }

        Label(int i) {
            this.value = i;
        }

        public int value() {
            return this.value;
        }

        public boolean isRepeated() {
            return this == REPEATED || this == PACKED;
        }

        public boolean isPacked() {
            return this == PACKED;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Message(Builder builder) {
        if (builder.unknownFieldMap != null) {
            this.unknownFields = new UnknownFieldMap(builder.unknownFieldMap);
        }
    }

    protected Collection<List<UnknownFieldMap.FieldValue>> unknownFields() {
        return this.unknownFields == null ? Collections.emptySet() : this.unknownFields.fieldMap.values();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static <T> List<T> copyOf(List<T> list) {
        if (list == null) {
            return null;
        }
        return new ArrayList(list);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static <T> List<T> immutableCopyOf(List<T> list) {
        return list == null ? Collections.emptyList() : Collections.unmodifiableList(new ArrayList(list));
    }

    public static <E extends Enum & ProtoEnum> int intFromEnum(E e) {
        return WIRE.enumAdapter(e.getClass()).toInt(e);
    }

    public static <E extends Enum & ProtoEnum> E enumFromInt(Class<E> cls, int i) {
        return (E) ((Enum) WIRE.enumAdapter(cls).fromInt(i));
    }

    public byte[] toByteArray() {
        return WIRE.messageAdapter(getClass()).toByteArray(this);
    }

    public void writeTo(byte[] bArr) {
        writeTo(bArr, 0, bArr.length);
    }

    public void writeTo(byte[] bArr, int i, int i2) {
        write(WireOutput.newInstance(bArr, i, i2));
    }

    private void write(WireOutput wireOutput) {
        try {
            WIRE.messageAdapter(getClass()).write(this, wireOutput);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void writeUnknownFieldMap(WireOutput wireOutput) throws IOException {
        if (this.unknownFields != null) {
            this.unknownFields.write(wireOutput);
        }
    }

    public int getSerializedSize() {
        if (!this.haveCachedSerializedSize) {
            this.cachedSerializedSize = WIRE.messageAdapter(getClass()).getSerializedSize(this);
            this.haveCachedSerializedSize = true;
        }
        return this.cachedSerializedSize;
    }

    public int getUnknownFieldsSerializedSize() {
        if (this.unknownFields == null) {
            return 0;
        }
        return this.unknownFields.getSerializedSize();
    }

    protected boolean equals(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    protected boolean equals(List<?> list, List<?> list2) {
        if (list != null && list.isEmpty()) {
            list = null;
        }
        if (list2 != null && list2.isEmpty()) {
            list2 = null;
        }
        return list == list2 || (list != null && list.equals(list2));
    }

    protected static <T> List<T> asList(T... tArr) {
        return Arrays.asList(tArr);
    }

    public String toString() {
        return WIRE.messageAdapter(getClass()).toString(this);
    }

    /* loaded from: classes17.dex */
    public static abstract class Builder<T extends Message> {
        UnknownFieldMap unknownFieldMap;

        public abstract T build(boolean z);

        public Builder() {
        }

        public Builder(Message message) {
            if (message != null && message.unknownFields != null) {
                this.unknownFieldMap = new UnknownFieldMap(message.unknownFields);
            }
        }

        public void addVarint(int i, long j) {
            ensureUnknownFieldMap().addVarint(i, Long.valueOf(j));
        }

        public void addFixed32(int i, int i2) {
            ensureUnknownFieldMap().addFixed32(i, Integer.valueOf(i2));
        }

        public void addFixed64(int i, long j) {
            ensureUnknownFieldMap().addFixed64(i, Long.valueOf(j));
        }

        public void addLengthDelimited(int i, ByteString byteString) {
            ensureUnknownFieldMap().addLengthDelimited(i, byteString);
        }

        private UnknownFieldMap ensureUnknownFieldMap() {
            if (this.unknownFieldMap == null) {
                this.unknownFieldMap = new UnknownFieldMap();
            }
            return this.unknownFieldMap;
        }

        public void checkRequiredFields() {
            Message.WIRE.builderAdapter(getClass()).checkRequiredFields(this);
        }

        protected static <T> List<T> checkForNulls(List<T> list) {
            if (list != null && !list.isEmpty()) {
                for (T t : list) {
                    if (t == null) {
                        throw new NullPointerException();
                    }
                }
            }
            return list;
        }
    }
}
