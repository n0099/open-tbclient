package com.google.common.util.concurrent;

import d.h.c.i.a.h;
import java.lang.ref.WeakReference;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
/* loaded from: classes6.dex */
public enum FuturesGetChecked$GetCheckedTypeValidatorHolder$WeakSetValidator {
    INSTANCE;
    
    public static final Set<WeakReference<Class<? extends Exception>>> validClasses = new CopyOnWriteArraySet();

    public void validateClass(Class<? extends Exception> cls) {
        for (WeakReference<Class<? extends Exception>> weakReference : validClasses) {
            if (cls.equals(weakReference.get())) {
                return;
            }
        }
        h.a(cls);
        if (validClasses.size() > 1000) {
            validClasses.clear();
        }
        validClasses.add(new WeakReference<>(cls));
    }
}
