package kotlin.jvm.internal;

import kotlin.reflect.g;
import kotlin.reflect.k;
/* loaded from: classes20.dex */
public abstract class MutablePropertyReference0 extends MutablePropertyReference implements kotlin.reflect.g {
    public MutablePropertyReference0() {
    }

    public MutablePropertyReference0(Object obj) {
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
        return ((kotlin.reflect.g) getReflected()).getGetter();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // kotlin.reflect.g
    public g.a getSetter() {
        return ((kotlin.reflect.g) getReflected()).getSetter();
    }

    @Override // kotlin.reflect.k
    public Object getDelegate() {
        return ((kotlin.reflect.g) getReflected()).getDelegate();
    }
}
