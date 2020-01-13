package kotlin.jvm.internal;

import kotlin.reflect.h;
import kotlin.reflect.l;
/* loaded from: classes5.dex */
public abstract class MutablePropertyReference1 extends MutablePropertyReference implements kotlin.reflect.h {
    public MutablePropertyReference1() {
    }

    public MutablePropertyReference1(Object obj) {
        super(obj);
    }

    @Override // kotlin.jvm.internal.CallableReference
    protected kotlin.reflect.b computeReflected() {
        return t.a(this);
    }

    @Override // kotlin.jvm.a.b
    public Object invoke(Object obj) {
        return get(obj);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // kotlin.reflect.l
    public l.a getGetter() {
        return ((kotlin.reflect.h) getReflected()).getGetter();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // kotlin.reflect.h
    public h.a getSetter() {
        return ((kotlin.reflect.h) getReflected()).getSetter();
    }

    @Override // kotlin.reflect.l
    public Object getDelegate(Object obj) {
        return ((kotlin.reflect.h) getReflected()).getDelegate(obj);
    }
}
