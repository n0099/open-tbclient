package com.squareup.wire;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes17.dex */
public final class UnknownFieldMap {
    private static /* synthetic */ int[] $SWITCH_TABLE$com$squareup$wire$WireType;
    Map<Integer, List<FieldValue>> fieldMap;

    static /* synthetic */ int[] $SWITCH_TABLE$com$squareup$wire$WireType() {
        int[] iArr = $SWITCH_TABLE$com$squareup$wire$WireType;
        if (iArr == null) {
            iArr = new int[WireType.valuesCustom().length];
            try {
                iArr[WireType.END_GROUP.ordinal()] = 5;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[WireType.FIXED32.ordinal()] = 6;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[WireType.FIXED64.ordinal()] = 2;
            } catch (NoSuchFieldError e3) {
            }
            try {
                iArr[WireType.LENGTH_DELIMITED.ordinal()] = 3;
            } catch (NoSuchFieldError e4) {
            }
            try {
                iArr[WireType.START_GROUP.ordinal()] = 4;
            } catch (NoSuchFieldError e5) {
            }
            try {
                iArr[WireType.VARINT.ordinal()] = 1;
            } catch (NoSuchFieldError e6) {
            }
            $SWITCH_TABLE$com$squareup$wire$WireType = iArr;
        }
        return iArr;
    }

    /* loaded from: classes17.dex */
    enum UnknownFieldType {
        VARINT,
        FIXED32,
        FIXED64,
        LENGTH_DELIMITED;

        /* JADX DEBUG: Replace access to removed values field (ENUM$VALUES) with 'values()' method */
        /* renamed from: values  reason: to resolve conflict with enum method */
        public static UnknownFieldType[] valuesCustom() {
            UnknownFieldType[] valuesCustom = values();
            int length = valuesCustom.length;
            UnknownFieldType[] unknownFieldTypeArr = new UnknownFieldType[length];
            System.arraycopy(valuesCustom, 0, unknownFieldTypeArr, 0, length);
            return unknownFieldTypeArr;
        }

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
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes17.dex */
    public static abstract class FieldValue {
        private final int tag;
        private final WireType wireType;

        public abstract int getSerializedSize();

        public abstract void write(int i, WireOutput wireOutput) throws IOException;

        public FieldValue(int i, WireType wireType) {
            this.tag = i;
            this.wireType = wireType;
        }

        public static VarintFieldValue varint(int i, Long l) {
            return new VarintFieldValue(i, l);
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

        public int getTag() {
            return this.tag;
        }

        public WireType getWireType() {
            return this.wireType;
        }

        public Integer getAsInteger() {
            throw new IllegalStateException();
        }

        public Long getAsLong() {
            throw new IllegalStateException();
        }

        public ByteString getAsBytes() {
            throw new IllegalStateException();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes17.dex */
    public static final class VarintFieldValue extends FieldValue {
        private final Long value;

        public VarintFieldValue(int i, Long l) {
            super(i, WireType.VARINT);
            this.value = l;
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

        @Override // com.squareup.wire.UnknownFieldMap.FieldValue
        public Long getAsLong() {
            return this.value;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes17.dex */
    public static final class Fixed32FieldValue extends FieldValue {
        private final Integer value;

        public Fixed32FieldValue(int i, Integer num) {
            super(i, WireType.FIXED32);
            this.value = num;
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

        @Override // com.squareup.wire.UnknownFieldMap.FieldValue
        public Integer getAsInteger() {
            return this.value;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes17.dex */
    public static final class Fixed64FieldValue extends FieldValue {
        private final Long value;

        public Fixed64FieldValue(int i, Long l) {
            super(i, WireType.FIXED64);
            this.value = l;
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

        @Override // com.squareup.wire.UnknownFieldMap.FieldValue
        public Long getAsLong() {
            return this.value;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes17.dex */
    public static final class LengthDelimitedFieldValue extends FieldValue {
        private final ByteString value;

        public LengthDelimitedFieldValue(int i, ByteString byteString) {
            super(i, WireType.LENGTH_DELIMITED);
            this.value = byteString;
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

        @Override // com.squareup.wire.UnknownFieldMap.FieldValue
        public ByteString getAsBytes() {
            return this.value;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public UnknownFieldMap() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public UnknownFieldMap(UnknownFieldMap unknownFieldMap) {
        if (unknownFieldMap.fieldMap != null) {
            ensureFieldMap().putAll(unknownFieldMap.fieldMap);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void addVarint(int i, Long l) {
        addElement(ensureFieldMap(), i, l, WireType.VARINT);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void addFixed32(int i, Integer num) {
        addElement(ensureFieldMap(), i, num, WireType.FIXED32);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void addFixed64(int i, Long l) {
        addElement(ensureFieldMap(), i, l, WireType.FIXED64);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void addLengthDelimited(int i, ByteString byteString) {
        addElement(ensureFieldMap(), i, byteString, WireType.LENGTH_DELIMITED);
    }

    private Map<Integer, List<FieldValue>> ensureFieldMap() {
        if (this.fieldMap == null) {
            this.fieldMap = new TreeMap();
        }
        return this.fieldMap;
    }

    private <T> void addElement(Map<Integer, List<FieldValue>> map, int i, T t, WireType wireType) {
        ArrayList arrayList;
        VarintFieldValue lengthDelimited;
        List<FieldValue> list = map.get(Integer.valueOf(i));
        if (list == null) {
            ArrayList arrayList2 = new ArrayList();
            map.put(Integer.valueOf(i), arrayList2);
            arrayList = arrayList2;
        } else {
            arrayList = list;
        }
        switch ($SWITCH_TABLE$com$squareup$wire$WireType()[wireType.ordinal()]) {
            case 1:
                lengthDelimited = FieldValue.varint(i, (Long) t);
                break;
            case 2:
                lengthDelimited = FieldValue.fixed64(i, (Long) t);
                break;
            case 3:
                lengthDelimited = FieldValue.lengthDelimited(i, (ByteString) t);
                break;
            case 4:
            case 5:
            default:
                throw new IllegalArgumentException("Unsupported wireType = " + wireType);
            case 6:
                lengthDelimited = FieldValue.fixed32(i, (Integer) t);
                break;
        }
        if (arrayList.size() > 0 && arrayList.get(0).getWireType() != lengthDelimited.getWireType()) {
            throw new IllegalStateException("Wire type differs from previous type for tag");
        }
        arrayList.add(lengthDelimited);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getSerializedSize() {
        if (this.fieldMap == null) {
            return 0;
        }
        int i = 0;
        for (Map.Entry<Integer, List<FieldValue>> entry : this.fieldMap.entrySet()) {
            int varintTagSize = WireOutput.varintTagSize(entry.getKey().intValue()) + i;
            for (FieldValue fieldValue : entry.getValue()) {
                varintTagSize += fieldValue.getSerializedSize();
            }
            i = varintTagSize;
        }
        return i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void write(WireOutput wireOutput) throws IOException {
        if (this.fieldMap != null) {
            for (Map.Entry<Integer, List<FieldValue>> entry : this.fieldMap.entrySet()) {
                int intValue = entry.getKey().intValue();
                for (FieldValue fieldValue : entry.getValue()) {
                    fieldValue.write(intValue, wireOutput);
                }
            }
        }
    }
}
