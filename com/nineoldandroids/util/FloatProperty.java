package com.nineoldandroids.util;
/* loaded from: classes5.dex */
public abstract class FloatProperty<T> extends Property<T, Float> {
    public abstract void setValue(T t, float f);

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.nineoldandroids.util.Property
    public /* bridge */ /* synthetic */ void set(Object obj, Float f) {
        set2((FloatProperty<T>) obj, f);
    }

    public FloatProperty(String str) {
        super(Float.class, str);
    }

    /* renamed from: set  reason: avoid collision after fix types in other method */
    public final void set2(T t, Float f) {
        setValue(t, f.floatValue());
    }
}
