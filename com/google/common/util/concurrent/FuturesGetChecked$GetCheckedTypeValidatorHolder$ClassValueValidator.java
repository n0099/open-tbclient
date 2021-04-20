package com.google.common.util.concurrent;
/* loaded from: classes6.dex */
public enum FuturesGetChecked$GetCheckedTypeValidatorHolder$ClassValueValidator {
    INSTANCE;
    
    public static final ClassValue<Boolean> isValidClass = new ClassValue<Boolean>() { // from class: com.google.common.util.concurrent.FuturesGetChecked$GetCheckedTypeValidatorHolder$ClassValueValidator.a
    };

    public void validateClass(Class<? extends Exception> cls) {
        isValidClass.get(cls);
    }
}
