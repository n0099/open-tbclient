package com.squareup.wire;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
/* loaded from: classes6.dex */
public final class UnknownFieldMap {
    public static /* synthetic */ int[] $SWITCH_TABLE$com$squareup$wire$WireType;
    public Map<Integer, List<FieldValue>> fieldMap;

    /* loaded from: classes6.dex */
    public static abstract class FieldValue {
        public final int tag;
        public final WireType wireType;

        public FieldValue(int i, WireType wireType) {
            this.tag = i;
            this.wireType = wireType;
        }

        public static Fixed32FieldValue fixed32(int i, Integer num) {
            return new Fixed32FieldValue(i, num);
        }

        public static Fixed64FieldValue fixed64(int i, Long l) {
            return new Fixed64FieldValue(i, l);
        }

        public static LengthDelimitedFieldValue lengthDelimited(int i, ByteString byteString) {
            return new LengthDelimitedFieldValue(i, byteString);
        }

        public static VarintFieldValue varint(int i, Long l) {
            return new VarintFieldValue(i, l);
        }

        public ByteString getAsBytes() {
            throw new IllegalStateException();
        }

        public Integer getAsInteger() {
            throw new IllegalStateException();
        }

        public Long getAsLong() {
            throw new IllegalStateException();
        }

        public abstract int getSerializedSize();

        public int getTag() {
            return this.tag;
        }

        public WireType getWireType() {
            return this.wireType;
        }

        public abstract void write(int i, WireOutput wireOutput) throws IOException;
    }

    /* loaded from: classes6.dex */
    public static final class Fixed32FieldValue extends FieldValue {
        public final Integer value;

        public Fixed32FieldValue(int i, Integer num) {
            super(i, WireType.FIXED32);
            this.value = num;
        }

        @Override // com.squareup.wire.UnknownFieldMap.FieldValue
        public Integer getAsInteger() {
            return this.value;
        }

        @Override // com.squareup.wire.UnknownFieldMap.FieldValue
        public int getSerializedSize() {
            return 4;
        }

        @Override // com.squareup.wire.UnknownFieldMap.FieldValue
        public void write(int i, WireOutput wireOutput) throws IOException {
            wireOutput.writeTag(i, WireType.FIXED32);
            wireOutput.writeFixed32(this.value.intValue());
        }
    }

    /* loaded from: classes6.dex */
    public static final class Fixed64FieldValue extends FieldValue {
        public final Long value;

        public Fixed64FieldValue(int i, Long l) {
            super(i, WireType.FIXED64);
            this.value = l;
        }

        @Override // com.squareup.wire.UnknownFieldMap.FieldValue
        public Long getAsLong() {
            return this.value;
        }

        @Override // com.squareup.wire.UnknownFieldMap.FieldValue
        public int getSerializedSize() {
            return 8;
        }

        @Override // com.squareup.wire.UnknownFieldMap.FieldValue
        public void write(int i, WireOutput wireOutput) throws IOException {
            wireOutput.writeTag(i, WireType.FIXED64);
            wireOutput.writeFixed64(this.value.longValue());
        }
    }

    /* loaded from: classes6.dex */
    public static final class LengthDelimitedFieldValue extends FieldValue {
        public final ByteString value;

        public LengthDelimitedFieldValue(int i, ByteString byteString) {
            super(i, WireType.LENGTH_DELIMITED);
            this.value = byteString;
        }

        @Override // com.squareup.wire.UnknownFieldMap.FieldValue
        public ByteString getAsBytes() {
            return this.value;
        }

        @Override // com.squareup.wire.UnknownFieldMap.FieldValue
        public int getSerializedSize() {
            return WireOutput.varint32Size(this.value.size()) + this.value.size();
        }

        @Override // com.squareup.wire.UnknownFieldMap.FieldValue
        public void write(int i, WireOutput wireOutput) throws IOException {
            wireOutput.writeTag(i, WireType.LENGTH_DELIMITED);
            wireOutput.writeVarint32(this.value.size());
            wireOutput.writeRawBytes(this.value.toByteArray());
        }
    }

    /* loaded from: classes6.dex */
    public enum UnknownFieldType {
        VARINT,
        FIXED32,
        FIXED64,
        LENGTH_DELIMITED;

        public static UnknownFieldType of(String str) {
            if ("varint".equals(str)) {
                return VARINT;
            }
            if ("fixed32".equals(str)) {
                return FIXED32;
            }
            if ("fixed64".equals(str)) {
                return FIXED64;
            }
            if ("length-delimited".equals(str)) {
                return LENGTH_DELIMITED;
            }
            throw new IllegalArgumentException("Unknown type " + str);
        }

        /* JADX DEBUG: Replace access to removed values field (ENUM$VALUES) with 'values()' method */
        /* renamed from: values  reason: to resolve conflict with enum method */
        public static UnknownFieldType[] valuesCustom() {
            UnknownFieldType[] valuesCustom = values();
            int length = valuesCustom.length;
            UnknownFieldType[] unknownFieldTypeArr = new UnknownFieldType[length];
            System.arraycopy(valuesCustom, 0, unknownFieldTypeArr, 0, length);
            return unknownFieldTypeArr;
        }
    }

    /* loaded from: classes6.dex */
    public static final class VarintFieldValue extends FieldValue {
        public final Long value;

        public VarintFieldValue(int i, Long l) {
            super(i, WireType.VARINT);
            this.value = l;
        }

        @Override // com.squareup.wire.UnknownFieldMap.FieldValue
        public Long getAsLong() {
            return this.value;
        }

        @Override // com.squareup.wire.UnknownFieldMap.FieldValue
        public int getSerializedSize() {
            return WireOutput.varint64Size(this.value.longValue());
        }

        @Override // com.squareup.wire.UnknownFieldMap.FieldValue
        public void write(int i, WireOutput wireOutput) throws IOException {
            wireOutput.writeTag(i, WireType.VARINT);
            wireOutput.writeVarint64(this.value.longValue());
        }
    }

    public static /* synthetic */ int[] $SWITCH_TABLE$com$squareup$wire$WireType() {
        int[] iArr = $SWITCH_TABLE$com$squareup$wire$WireType;
        if (iArr != null) {
            return iArr;
        }
        int[] iArr2 = new int[WireType.valuesCustom().length];
        try {
            iArr2[WireType.END_GROUP.ordinal()] = 5;
        } catch (NoSuchFieldError unused) {
        }
        try {
            iArr2[WireType.FIXED32.ordinal()] = 6;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            iArr2[WireType.FIXED64.ordinal()] = 2;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            iArr2[WireType.LENGTH_DELIMITED.ordinal()] = 3;
        } catch (NoSuchFieldError unused4) {
        }
        try {
            iArr2[WireType.START_GROUP.ordinal()] = 4;
        } catch (NoSuchFieldError unused5) {
        }
        try {
            iArr2[WireType.VARINT.ordinal()] = 1;
        } catch (NoSuchFieldError unused6) {
        }
        $SWITCH_TABLE$com$squareup$wire$WireType = iArr2;
        return iArr2;
    }

    public UnknownFieldMap() {
    }

    private <T> void addElement(Map<Integer, List<FieldValue>> map, int i, T t, WireType wireType) {
        FieldValue varint;
        List<FieldValue> list = map.get(Integer.valueOf(i));
        if (list == null) {
            list = new ArrayList<>();
            map.put(Integer.valueOf(i), list);
        }
        int i2 = $SWITCH_TABLE$com$squareup$wire$WireType()[wireType.ordinal()];
        if (i2 == 1) {
            varint = FieldValue.varint(i, (Long) t);
        } else if (i2 == 2) {
            varint = FieldValue.fixed64(i, (Long) t);
        } else if (i2 == 3) {
            varint = FieldValue.lengthDelimited(i, (ByteString) t);
        } else if (i2 == 6) {
            varint = FieldValue.fixed32(i, (Integer) t);
        } else {
            throw new IllegalArgumentException("Unsupported wireType = " + wireType);
        }
        if (list.size() > 0 && list.get(0).getWireType() != varint.getWireType()) {
            throw new IllegalStateException("Wire type differs from previous type for tag");
        }
        list.add(varint);
    }

    private Map<Integer, List<FieldValue>> ensureFieldMap() {
        if (this.fieldMap == null) {
            this.fieldMap = new TreeMap();
        }
        return this.fieldMap;
    }

    public void addFixed32(int i, Integer num) {
        addElement(ensureFieldMap(), i, num, WireType.FIXED32);
    }

    public void addFixed64(int i, Long l) {
        addElement(ensureFieldMap(), i, l, WireType.FIXED64);
    }

    public void addLengthDelimited(int i, ByteString byteString) {
        addElement(ensureFieldMap(), i, byteString, WireType.LENGTH_DELIMITED);
    }

    public void addVarint(int i, Long l) {
        addElement(ensureFieldMap(), i, l, WireType.VARINT);
    }

    public int getSerializedSize() {
        Map<Integer, List<FieldValue>> map = this.fieldMap;
        int i = 0;
        if (map != null) {
            for (Map.Entry<Integer, List<FieldValue>> entry : map.entrySet()) {
                i += WireOutput.varintTagSize(entry.getKey().intValue());
                for (FieldValue fieldValue : entry.getValue()) {
                    i += fieldValue.getSerializedSize();
                }
            }
        }
        return i;
    }

    public void write(WireOutput wireOutput) throws IOException {
        Map<Integer, List<FieldValue>> map = this.fieldMap;
        if (map != null) {
            for (Map.Entry<Integer, List<FieldValue>> entry : map.entrySet()) {
                int intValue = entry.getKey().intValue();
                for (FieldValue fieldValue : entry.getValue()) {
                    fieldValue.write(intValue, wireOutput);
                }
            }
        }
    }

    public UnknownFieldMap(UnknownFieldMap unknownFieldMap) {
        if (unknownFieldMap.fieldMap != null) {
            ensureFieldMap().putAll(unknownFieldMap.fieldMap);
        }
    }
}
