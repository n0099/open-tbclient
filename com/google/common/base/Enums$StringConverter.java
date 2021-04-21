package com.google.common.base;

import d.h.c.a.n;
import java.io.Serializable;
import java.lang.Enum;
/* loaded from: classes6.dex */
public final class Enums$StringConverter<T extends Enum<T>> extends Converter<String, T> implements Serializable {
    public static final long serialVersionUID = 0;
    public final Class<T> enumClass;

    public Enums$StringConverter(Class<T> cls) {
        n.p(cls);
        this.enumClass = cls;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.google.common.base.Enums$StringConverter<T extends java.lang.Enum<T>> */
    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.base.Converter
    public /* bridge */ /* synthetic */ String doBackward(Object obj) {
        return doBackward((Enums$StringConverter<T>) ((Enum) obj));
    }

    @Override // com.google.common.base.Converter, d.h.c.a.g
    public boolean equals(Object obj) {
        if (obj instanceof Enums$StringConverter) {
            return this.enumClass.equals(((Enums$StringConverter) obj).enumClass);
        }
        return false;
    }

    public int hashCode() {
        return this.enumClass.hashCode();
    }

    public String toString() {
        return "Enums.stringConverter(" + this.enumClass.getName() + ".class)";
    }

    public String doBackward(T t) {
        return t.name();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.common.base.Converter
    public T doForward(String str) {
        return (T) Enum.valueOf(this.enumClass, str);
    }
}
