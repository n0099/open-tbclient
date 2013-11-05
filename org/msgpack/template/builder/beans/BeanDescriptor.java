package org.msgpack.template.builder.beans;
/* loaded from: classes.dex */
public class BeanDescriptor extends b {
    private Class<?> h;
    private Class<?> i;

    public BeanDescriptor(Class<?> cls, Class<?> cls2) {
        if (cls == null) {
            throw new NullPointerException();
        }
        a(a(cls));
        this.h = cls;
        this.i = cls2;
    }

    public BeanDescriptor(Class<?> cls) {
        this(cls, null);
    }

    public Class<?> a() {
        return this.h;
    }

    private String a(Class<?> cls) {
        if (cls == null) {
            return null;
        }
        String name = cls.getName();
        int lastIndexOf = name.lastIndexOf(".");
        return lastIndexOf != -1 ? name.substring(lastIndexOf + 1) : name;
    }
}
