package org.msgpack.type;
/* loaded from: classes.dex */
public enum ValueType {
    NIL,
    BOOLEAN,
    INTEGER,
    FLOAT,
    ARRAY,
    MAP,
    RAW;

    /* JADX DEBUG: Replace access to removed values field (a) with 'values()' method */
    /* renamed from: values  reason: to resolve conflict with enum method */
    public static ValueType[] valuesCustom() {
        ValueType[] valuesCustom = values();
        int length = valuesCustom.length;
        ValueType[] valueTypeArr = new ValueType[length];
        System.arraycopy(valuesCustom, 0, valueTypeArr, 0, length);
        return valueTypeArr;
    }
}
