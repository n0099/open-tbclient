package com.nineoldandroids.util;
/* loaded from: classes9.dex */
public abstract class IntProperty<T> extends Property<T, Integer> {
    public abstract void setValue(T t, int i);

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.nineoldandroids.util.Property
    public /* bridge */ /* synthetic */ void set(Object obj, Integer num) {
        set2((IntProperty<T>) obj, num);
    }

    public IntProperty(String str) {
        super(Integer.class, str);
    }

    /* renamed from: set  reason: avoid collision after fix types in other method */
    public final void set2(T t, Integer num) {
        set2((IntProperty<T>) t, Integer.valueOf(num.intValue()));
    }
}
