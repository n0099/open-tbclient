package kotlin.jvm.internal;

import kotlin.reflect.l;
/* loaded from: classes14.dex */
public abstract class PropertyReference1 extends PropertyReference implements kotlin.reflect.l {
    public PropertyReference1() {
    }

    public PropertyReference1(Object obj) {
        super(obj);
    }

    @Override // kotlin.jvm.internal.CallableReference
    protected kotlin.reflect.b computeReflected() {
        return s.a(this);
    }

    @Override // kotlin.jvm.a.b
    public Object invoke(Object obj) {
        return get(obj);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // kotlin.reflect.l
    public l.a getGetter() {
        return ((kotlin.reflect.l) getReflected()).getGetter();
    }

    @Override // kotlin.reflect.l
    public Object getDelegate(Object obj) {
        return ((kotlin.reflect.l) getReflected()).getDelegate(obj);
    }
}
