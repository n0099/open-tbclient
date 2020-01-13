package kotlin.jvm.internal;

import kotlin.reflect.k;
/* loaded from: classes5.dex */
public abstract class PropertyReference0 extends PropertyReference implements kotlin.reflect.k {
    public PropertyReference0() {
    }

    public PropertyReference0(Object obj) {
        super(obj);
    }

    @Override // kotlin.jvm.internal.CallableReference
    protected kotlin.reflect.b computeReflected() {
        return t.a(this);
    }

    @Override // kotlin.jvm.a.a
    public Object invoke() {
        return get();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // kotlin.reflect.k
    public k.a getGetter() {
        return ((kotlin.reflect.k) getReflected()).getGetter();
    }

    @Override // kotlin.reflect.k
    public Object getDelegate() {
        return ((kotlin.reflect.k) getReflected()).getDelegate();
    }
}
