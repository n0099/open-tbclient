package com.squareup.wire;
/* loaded from: classes7.dex */
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
    public static final int TAG_TYPE_MASK = 7;
    public final int value;

    WireType(int i2) {
        this.value = i2;
    }

    /* JADX DEBUG: Replace access to removed values field (ENUM$VALUES) with 'values()' method */
    /* renamed from: values  reason: to resolve conflict with enum method */
    public static WireType[] valuesCustom() {
        WireType[] valuesCustom = values();
        int length = valuesCustom.length;
        WireType[] wireTypeArr = new WireType[length];
        System.arraycopy(valuesCustom, 0, wireTypeArr, 0, length);
        return wireTypeArr;
    }

    public int value() {
        return this.value;
    }

    public static WireType valueOf(int i2) {
        int i3 = i2 & 7;
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 != 3) {
                        if (i3 != 4) {
                            if (i3 == 5) {
                                return FIXED32;
                            }
                            throw new IllegalArgumentException("No WireType for value " + i2);
                        }
                        return END_GROUP;
                    }
                    return START_GROUP;
                }
                return LENGTH_DELIMITED;
            }
            return FIXED64;
        }
        return VARINT;
    }
}
