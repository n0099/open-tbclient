package com.squareup.wire;
/* loaded from: classes4.dex */
public enum WireType {
    VARINT(0),
    FIXED64(1),
    LENGTH_DELIMITED(2),
    START_GROUP(3),
    END_GROUP(4),
    FIXED32(5);
    
    public static final int FIXED_32_SIZE = 4;
    public static final int FIXED_64_SIZE = 8;
    public static final int TAG_TYPE_BITS = 3;
    private static final int TAG_TYPE_MASK = 7;
    private final int value;

    /* JADX DEBUG: Replace access to removed values field (ENUM$VALUES) with 'values()' method */
    /* renamed from: values  reason: to resolve conflict with enum method */
    public static WireType[] valuesCustom() {
        WireType[] valuesCustom = values();
        int length = valuesCustom.length;
        WireType[] wireTypeArr = new WireType[length];
        System.arraycopy(valuesCustom, 0, wireTypeArr, 0, length);
        return wireTypeArr;
    }

    public static WireType valueOf(int i) {
        switch (i & 7) {
            case 0:
                return VARINT;
            case 1:
                return FIXED64;
            case 2:
                return LENGTH_DELIMITED;
            case 3:
                return START_GROUP;
            case 4:
                return END_GROUP;
            case 5:
                return FIXED32;
            default:
                throw new IllegalArgumentException("No WireType for value " + i);
        }
    }

    WireType(int i) {
        this.value = i;
    }

    public int value() {
        return this.value;
    }
}
