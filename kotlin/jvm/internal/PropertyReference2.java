package kotlin.jvm.internal;

import kotlin.reflect.m;
/* loaded from: classes5.dex */
public abstract class PropertyReference2 extends PropertyReference implements kotlin.reflect.m {
    @Override // kotlin.jvm.internal.CallableReference
    protected kotlin.reflect.b computeReflected() {
        return s.a(this);
    }

    @Override // kotlin.jvm.a.c
    public Object invoke(Object obj, Object obj2) {
        return get(obj, obj2);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // kotlin.reflect.m
    public m.a getGetter() {
        return ((kotlin.reflect.m) getReflected()).getGetter();
    }

    @Override // kotlin.reflect.m
    public Object getDelegate(Object obj, Object obj2) {
        return ((kotlin.reflect.m) getReflected()).getDelegate(obj, obj2);
    }
}
