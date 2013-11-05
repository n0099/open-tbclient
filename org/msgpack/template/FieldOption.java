package org.msgpack.template;
/* loaded from: classes.dex */
public enum FieldOption {
    IGNORE,
    OPTIONAL,
    NOTNULLABLE,
    DEFAULT;

    /* JADX DEBUG: Replace access to removed values field (a) with 'values()' method */
    /* renamed from: values  reason: to resolve conflict with enum method */
    public static FieldOption[] valuesCustom() {
        FieldOption[] valuesCustom = values();
        int length = valuesCustom.length;
        FieldOption[] fieldOptionArr = new FieldOption[length];
        System.arraycopy(valuesCustom, 0, fieldOptionArr, 0, length);
        return fieldOptionArr;
    }
}
